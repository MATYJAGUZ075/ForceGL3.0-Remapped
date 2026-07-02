package io.github.kabanfriends.forcegl30.mixin;

import org.lwjgl.opengl.ARBInstancedArrays;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "com.mojang.blaze3d.opengl.VertexArrayCache$Emulated")
public class VertexArrayCacheEmulatedMixin {

    @Redirect(
            method = "setupCombinedAttributes",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/opengl/GL33C;glVertexAttribDivisor(II)V",
                    remap = false
            ),
            remap = false
    )
    private static void forcegl30$vertexAttribDivisor(
            int index,
            int divisor
    ) {

        ARBInstancedArrays.glVertexAttribDivisorARB(index, divisor);

    }
}