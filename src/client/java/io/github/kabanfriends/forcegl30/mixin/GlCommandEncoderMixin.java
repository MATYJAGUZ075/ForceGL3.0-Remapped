package io.github.kabanfriends.forcegl30.mixin;

import org.lwjgl.opengl.ARBBaseInstance;
import org.lwjgl.opengl.ARBDrawElementsBaseVertex;
import org.lwjgl.opengl.ARBDrawInstanced;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "com.mojang.blaze3d.opengl.GlCommandEncoder")
public class GlCommandEncoderMixin {

    @Redirect(
            method = "drawFromBuffers",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/opengl/GL33C;glDrawArraysInstanced(IIII)V",
                    remap = false
            )
    )
    private void forcegl30$drawArraysInstanced(
            int mode,
            int first,
            int count,
            int instanceCount
    ) {

        if (count <= 0 || instanceCount <= 0)
            return;

        ARBDrawInstanced.glDrawArraysInstancedARB(
                mode,
                first,
                count,
                instanceCount
        );
    }

    @Redirect(
            method = "drawFromBuffers",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/opengl/GL33C;glDrawElementsInstancedBaseVertex(IIIJII)V",
                    remap = false
            )
    )
    private void forcegl30$drawElementsInstancedBaseVertex(
            int mode,
            int count,
            int type,
            long indices,
            int instanceCount,
            int baseVertex
    ) {

        if (count <= 0 || instanceCount <= 0)
            return;

        while (instanceCount-- > 0) {
            ARBDrawElementsBaseVertex.glDrawElementsBaseVertex(
                    mode,
                    count,
                    type,
                    indices,
                    baseVertex
            );
        }
    }

    @Redirect(
            method = "drawFromBuffers",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/opengl/ARBBaseInstance;glDrawArraysInstancedBaseInstance(IIIII)V",
                    remap = false
            )
    )
    private void forcegl30$drawArraysInstancedBaseInstance(
            int mode,
            int first,
            int count,
            int instanceCount,
            int firstInstance
    ) {

        if (count <= 0 || instanceCount <= 0)
            return;

        // firstInstance no existe en OpenGL 3.0, se ignora.
        ARBDrawInstanced.glDrawArraysInstancedARB(
                mode,
                first,
                count,
                instanceCount
        );
    }

    @Redirect(
            method = "drawFromBuffers",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/opengl/ARBBaseInstance;glDrawElementsInstancedBaseVertexBaseInstance(IIIJIII)V",
                    remap = false
            )
    )
    private void forcegl30$drawElementsInstancedBaseVertexBaseInstance(
            int mode,
            int count,
            int type,
            long indices,
            int instanceCount,
            int baseVertex,
            int firstInstance
    ) {

        if (count <= 0 || instanceCount <= 0)
            return;

        while (instanceCount-- > 0) {
            ARBDrawElementsBaseVertex.glDrawElementsBaseVertex(
                    mode,
                    count,
                    type,
                    indices,
                    baseVertex
            );
        }
    }
}