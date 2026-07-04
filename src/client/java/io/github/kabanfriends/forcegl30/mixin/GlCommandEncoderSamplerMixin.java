package io.github.kabanfriends.forcegl30.mixin;

import io.github.kabanfriends.forcegl30.compat.GL30SamplerCompat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(
        targets = "com.mojang.blaze3d.opengl.GlCommandEncoder"
)
public class GlCommandEncoderSamplerMixin {

    @Redirect(
            method = "trySetup",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/opengl/GL33C;glBindSampler(II)V",
                    remap = false
            ),
            remap = false
    )
    private void forcegl30$bindSampler(int unit, int sampler) {

        GL30SamplerCompat.bindSampler(
                unit,
                sampler
        );

    }

}
