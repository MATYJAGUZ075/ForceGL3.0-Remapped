//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package io.github.kabanfriends.forcegl30.mixin;

import io.github.kabanfriends.forcegl30.compat.GL30DrawCompat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(
        targets = {"com.mojang.blaze3d.opengl.GlCommandEncoder"}
)
public class GlCommandEncoderMixin {
    public GlCommandEncoderMixin() {
    }

    @Redirect(
            method = {"drawFromBuffers"},
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/opengl/GL33C;glDrawArraysInstanced(IIII)V",
                    remap = false
            )
    )
    private void forcegl30$drawArraysInstanced(int mode, int first, int count, int instanceCount) {
        GL30DrawCompat.drawArraysInstanced(mode, first, count, instanceCount);
    }

    @Redirect(
            method = {"drawFromBuffers"},
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/opengl/GL33C;glDrawElementsInstancedBaseVertex(IIIJII)V",
                    remap = false
            )
    )
    private void forcegl30$drawElementsInstancedBaseVertex(int mode, int count, int type, long indices, int instanceCount, int baseVertex) {
        GL30DrawCompat.drawElementsInstancedBaseVertex(mode, count, type, indices, instanceCount, baseVertex);
    }

    @Redirect(
            method = {"drawFromBuffers"},
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/opengl/ARBBaseInstance;glDrawArraysInstancedBaseInstance(IIIII)V",
                    remap = false
            )
    )
    private void forcegl30$drawArraysInstancedBaseInstance(int mode, int first, int count, int instanceCount, int firstInstance) {
        GL30DrawCompat.drawArraysInstancedBaseInstance(mode, first, count, instanceCount, firstInstance);
    }

    @Redirect(
            method = {"drawFromBuffers"},
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/opengl/ARBBaseInstance;glDrawElementsInstancedBaseVertexBaseInstance(IIIJIII)V",
                    remap = false
            )
    )
    private void forcegl30$drawElementsInstancedBaseVertexBaseInstance(int mode, int count, int type, long indices, int instanceCount, int baseVertex, int firstInstance) {
        GL30DrawCompat.drawElementsInstancedBaseVertexBaseInstance(mode, count, type, indices, instanceCount, baseVertex, firstInstance);
    }
}
