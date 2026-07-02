//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package io.github.kabanfriends.forcegl30;

import com.google.common.collect.ImmutableMap;
import io.github.kabanfriends.forcegl30.override.HintOverride;
import io.github.kabanfriends.forcegl30.override.OverrideType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForceGL30 {
    public static final Logger LOGGER = LoggerFactory.getLogger("ForceGL30");
    public static final ImmutableMap<Integer, HintOverride> GLFW_OVERRIDE_VALUES;
    public static final ImmutableMap<Integer, String> GLFW_HINT_NAMES;
    private static final int[] GLFW_HINT_CODES = new int[]{131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080, 131081, 131082, 131083, 131084, 135169, 135170, 135171, 135172, 135173, 135174, 135175, 135176, 135177, 135178, 135179, 135180, 135181, 135182, 135183, 135184, 139265, 139266, 139267, 139268, 139269, 139270, 139271, 139272, 139273, 139274, 139275, 139276, 143361, 143362, 143363, 147457, 147458};

    public ForceGL30() {
    }

    static {
        ImmutableMap.Builder<Integer, HintOverride> overrideBuilder = ImmutableMap.builder();
        overrideBuilder.put(139266, new HintOverride(OverrideType.SET_VALUE, 3));
        overrideBuilder.put(139267, new HintOverride(OverrideType.SET_VALUE, 0));
        overrideBuilder.put(139272, new HintOverride(OverrideType.SET_VALUE, 0));
        overrideBuilder.put(139270, new HintOverride(OverrideType.SET_VALUE, 1));
        GLFW_OVERRIDE_VALUES = overrideBuilder.build();
        ImmutableMap.Builder<Integer, String> nameBuilder = ImmutableMap.builder();
        List<Integer> codes = Arrays.stream(GLFW_HINT_CODES).boxed().toList();

        for(Field field : GLFW.class.getDeclaredFields()) {
            if (!field.getName().equals("GLFW_OPENGL_DEBUG_CONTEXT") && field.getType() == Integer.TYPE && Modifier.isPublic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
                try {
                    int code = (Integer)field.get((Object)null);
                    if (codes.contains(code)) {
                        nameBuilder.put(code, field.getName());
                    }
                } catch (IllegalAccessException var8) {
                    LOGGER.error("Failed to get field value for GLFW.{}", field.getName());
                }
            }
        }

        GLFW_HINT_NAMES = nameBuilder.build();
    }
}
