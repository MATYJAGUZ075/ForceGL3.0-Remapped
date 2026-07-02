//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package io.github.kabanfriends.forcegl30.mixin;

import com.mojang.blaze3d.opengl.GlBackend;
import io.github.kabanfriends.forcegl30.ForceGL30;
import io.github.kabanfriends.forcegl30.override.HintOverride;
import io.github.kabanfriends.forcegl30.override.OverrideType;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({GlBackend.class})
public class GL30Mixin {
    public GL30Mixin() {
    }

    @Redirect(
        method = {"setWindowHints"},
        at = @At(
    value = "INVOKE",
    target = "Lorg/lwjgl/glfw/GLFW;glfwWindowHint(II)V",
    remap = false
)
    )
    private void windowHintOverride(int hint, int value) {
        System.out.println("FORCEGL30 MIXIN FUNCIONANDO");
        if (ForceGL30.GLFW_OVERRIDE_VALUES.containsKey(hint)) {
            int original = value;
            String hintName = "Unknown";
            if (ForceGL30.GLFW_HINT_NAMES.containsKey(hint)) {
                hintName = (String)ForceGL30.GLFW_HINT_NAMES.get(hint);
            }

            HintOverride override = (HintOverride)ForceGL30.GLFW_OVERRIDE_VALUES.get(hint);
            OverrideType type = override.getOverrideType();
            value = override.getValue();
            ForceGL30.LOGGER.info("Overriding {}: {} -> {}", new Object[]{hintName, original, type == OverrideType.DO_NOT_SET ? "None" : value});
            if (type == OverrideType.DO_NOT_SET) {
                return;
            }
        }

        GLFW.glfwWindowHint(hint, value);
    }
}
