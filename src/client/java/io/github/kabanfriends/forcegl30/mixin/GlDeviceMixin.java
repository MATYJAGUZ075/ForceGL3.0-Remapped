package io.github.kabanfriends.forcegl30.mixin;

import com.mojang.blaze3d.shaders.GpuDebugOptions;
import com.mojang.blaze3d.shaders.ShaderSource;
import io.github.kabanfriends.forcegl30.ForceGL30;
import io.github.kabanfriends.forcegl30.compat.CompatibilityManager;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLCapabilities;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "com.mojang.blaze3d.opengl.GlDevice")
public class GlDeviceMixin {

    @Inject(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/opengl/GL;createCapabilities()Lorg/lwjgl/opengl/GLCapabilities;",
                    shift = At.Shift.AFTER
            ),
            remap = false
    )
    private void forcegl30$printCapabilities(
            long windowHandle,
            ShaderSource defaultShaderSource,
            GpuDebugOptions debugOptions,
            CallbackInfo ci
    ) {

        GLCapabilities caps = GL.getCapabilities();

        CompatibilityManager.init(caps);

        ForceGL30.LOGGER.info("========== ForceGL30 ==========");
        ForceGL30.LOGGER.info("GL_VERSION  = {}", GL11.glGetString(GL11.GL_VERSION));
        ForceGL30.LOGGER.info("GL_VENDOR   = {}", GL11.glGetString(GL11.GL_VENDOR));
        ForceGL30.LOGGER.info("GL_RENDERER = {}", GL11.glGetString(GL11.GL_RENDERER));

        ForceGL30.LOGGER.info("--------------------------------");

        ForceGL30.LOGGER.info("OpenGL30 = {}", caps.OpenGL30);
        ForceGL30.LOGGER.info("OpenGL31 = {}", caps.OpenGL31);
        ForceGL30.LOGGER.info("OpenGL32 = {}", caps.OpenGL32);
        ForceGL30.LOGGER.info("OpenGL33 = {}", caps.OpenGL33);

        ForceGL30.LOGGER.info("--------------------------------");

        ForceGL30.LOGGER.info("GL_ARB_texture_buffer_object      = {}", caps.GL_ARB_texture_buffer_object);
        ForceGL30.LOGGER.info("GL_ARB_uniform_buffer_object      = {}", caps.GL_ARB_uniform_buffer_object);
        ForceGL30.LOGGER.info("GL_ARB_vertex_attrib_binding      = {}", caps.GL_ARB_vertex_attrib_binding);
        ForceGL30.LOGGER.info("GL_ARB_direct_state_access        = {}", caps.GL_ARB_direct_state_access);
        ForceGL30.LOGGER.info("GL_ARB_buffer_storage             = {}", caps.GL_ARB_buffer_storage);
        ForceGL30.LOGGER.info("GL_ARB_base_instance              = {}", caps.GL_ARB_base_instance);
        ForceGL30.LOGGER.info("GL_ARB_draw_indirect              = {}", caps.GL_ARB_draw_indirect);
        ForceGL30.LOGGER.info("GL_ARB_instanced_arrays           = {}", caps.GL_ARB_instanced_arrays);
        ForceGL30.LOGGER.info("GL_ARB_draw_elements_base_vertex  = {}", caps.GL_ARB_draw_elements_base_vertex);
        ForceGL30.LOGGER.info("GL_ARB_draw_instanced             = {}", caps.GL_ARB_draw_instanced);
        ForceGL30.LOGGER.info("GL_ARB_multi_draw_indirect        = {}", caps.GL_ARB_multi_draw_indirect);
        ForceGL30.LOGGER.info("GL_ARB_shader_draw_parameters     = {}", caps.GL_ARB_shader_draw_parameters);
        ForceGL30.LOGGER.info("GL_ARB_clip_control               = {}", caps.GL_ARB_clip_control);

        ForceGL30.LOGGER.info("================================");
    }
}
