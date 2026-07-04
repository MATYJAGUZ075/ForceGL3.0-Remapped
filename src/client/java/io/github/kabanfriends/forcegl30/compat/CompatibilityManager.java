package io.github.kabanfriends.forcegl30.compat;

import org.lwjgl.opengl.GLCapabilities;

public final class CompatibilityManager {

    private CompatibilityManager() {
    }

    /*
     * Capacidades detectadas al iniciar Minecraft.
     * Se leen muchísimas veces durante el render,
     * por eso usamos boolean en lugar de EnumMap.
     */

    public static boolean HAS_VERTEX_ATTRIB_BINDING;
    public static boolean HAS_DIRECT_STATE_ACCESS;
    public static boolean HAS_BUFFER_STORAGE;
    public static boolean HAS_BASE_INSTANCE;
    public static boolean HAS_DRAW_INDIRECT;
    public static boolean HAS_MULTI_DRAW_INDIRECT;
    public static boolean HAS_SHADER_DRAW_PARAMETERS;
    public static boolean HAS_CLIP_CONTROL;

    public static boolean HAS_TEX_BUFFER;
    public static boolean HAS_ARB_TEX_BUFFER;
    public static boolean HAS_TEX_BUFFER_RANGE;

    public static boolean HAS_UNIFORM_BUFFER;
    public static boolean HAS_ARB_UNIFORM_BUFFER;

    public static void init(GLCapabilities caps) {

        HAS_VERTEX_ATTRIB_BINDING =
                caps.GL_ARB_vertex_attrib_binding;

        HAS_DIRECT_STATE_ACCESS =
                caps.GL_ARB_direct_state_access;

        HAS_BUFFER_STORAGE =
                caps.GL_ARB_buffer_storage;

        HAS_BASE_INSTANCE =
                caps.GL_ARB_base_instance;

        HAS_DRAW_INDIRECT =
                caps.GL_ARB_draw_indirect;

        HAS_MULTI_DRAW_INDIRECT =
                caps.GL_ARB_multi_draw_indirect;

        HAS_SHADER_DRAW_PARAMETERS =
                caps.GL_ARB_shader_draw_parameters;

        HAS_CLIP_CONTROL =
                caps.GL_ARB_clip_control;

        // Texture Buffer

        HAS_TEX_BUFFER =
                caps.OpenGL31 ||
                        caps.GL_ARB_texture_buffer_object;

        HAS_ARB_TEX_BUFFER =
                caps.GL_ARB_texture_buffer_object;

        HAS_TEX_BUFFER_RANGE =
                caps.OpenGL43;

        // Uniform Buffer

        HAS_UNIFORM_BUFFER =
                caps.OpenGL31 ||
                        caps.GL_ARB_uniform_buffer_object;

        HAS_ARB_UNIFORM_BUFFER =
                caps.GL_ARB_uniform_buffer_object;
    }

    public static boolean supports(GLFeature feature) {

        return switch (feature) {

            case VERTEX_ATTRIB_BINDING ->
                    HAS_VERTEX_ATTRIB_BINDING;

            case DIRECT_STATE_ACCESS ->
                    HAS_DIRECT_STATE_ACCESS;

            case BUFFER_STORAGE ->
                    HAS_BUFFER_STORAGE;

            case BASE_INSTANCE ->
                    HAS_BASE_INSTANCE;

            case DRAW_INDIRECT ->
                    HAS_DRAW_INDIRECT;

            case MULTI_DRAW_INDIRECT ->
                    HAS_MULTI_DRAW_INDIRECT;

            case SHADER_DRAW_PARAMETERS ->
                    HAS_SHADER_DRAW_PARAMETERS;

            case CLIP_CONTROL ->
                    HAS_CLIP_CONTROL;

            case TEX_BUFFER ->
                    HAS_TEX_BUFFER;

            case ARB_TEX_BUFFER ->
                    HAS_ARB_TEX_BUFFER;

            case TEX_BUFFER_RANGE ->
                    HAS_TEX_BUFFER_RANGE;

            case UNIFORM_BUFFER ->
                    HAS_UNIFORM_BUFFER;

            case ARB_UNIFORM_BUFFER ->
                    HAS_ARB_UNIFORM_BUFFER;
        };
    }

}
