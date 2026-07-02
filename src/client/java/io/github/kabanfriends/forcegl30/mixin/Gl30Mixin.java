package io.github.kabanfriends.forcegl30.mixin;

import com.mojang.blaze3d.opengl.GlBackend;
import io.github.kabanfriends.forcegl30.ForceGL30;
import io.github.kabanfriends.forcegl30.override.HintOverride;
import io.github.kabanfriends.forcegl30.override.OverrideType;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GlBackend.class)
public class Gl30Mixin {

    @Redirect(
            method = "setWindowHints",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/glfw/GLFW;glfwWindowHint(II)V",
                    remap = false
            )
    )
    private void forcegl30$windowHintOverride(int hint, int value) {

        System.out.println("FORCEGL30 MIXIN FUNCIONANDO");

        HintOverride override = ForceGL30.GLFW_OVERRIDE_VALUES.get(hint);

        if (override != null) {

            int original = value;

            String hintName = ForceGL30.GLFW_HINT_NAMES.getOrDefault(
                    hint,
                    "Unknown"
            );

            OverrideType type = override.getOverrideType();
            value = override.getValue();

            ForceGL30.LOGGER.info(
                    "Overriding {}: {} -> {}",
                    hintName,
                    original,
                    type == OverrideType.DO_NOT_SET ? "None" : value
            );

            if (type == OverrideType.DO_NOT_SET) {
                return;
            }
        }

        GLFW.glfwWindowHint(hint, value);
    }
}
