package io.github.kabanfriends.forcegl30.mixin;

import io.github.kabanfriends.forcegl30.ForceGL30;
import io.github.kabanfriends.forcegl30.compat.GL30TextureCompat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(
        targets = "com.mojang.blaze3d.opengl.GlCommandEncoder"
)
public class GlCommandEncoderTextureMixin {

    @Redirect(
            method = "trySetup",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/opengl/GL33C;glTexBuffer(III)V",
                    remap = false
            ),
            remap = false
    )
    private void forcegl30$texBuffer(int target, int internalFormat, int buffer) {

        boolean success = GL30TextureCompat.texBuffer(
                target,
                internalFormat,
                buffer
        );

        if (!success) {
            ForceGL30.LOGGER.warn(
                    "[ForceGL30] Texture Buffer no soportado por esta GPU."
            );
        }
    }

}
