//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package io.github.kabanfriends.forcegl30.mixin;

import io.github.kabanfriends.forcegl30.compat.GL30UniformCompat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(
        targets = {"com.mojang.blaze3d.opengl.GlCommandEncoder"}
)
public class GlCommandEncoderUniformMixin {
    public GlCommandEncoderUniformMixin() {
    }

    @Redirect(
            method = {"trySetup"},
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/opengl/GL33C;glBindBufferRange(IIIJJ)V",
                    remap = false
            ),
            remap = false
    )
    private void forcegl30$bindBufferRange(int target, int index, int buffer, long offset, long size) {
        GL30UniformCompat.bindUniformBuffer(index, buffer, offset, size);
    }
}
