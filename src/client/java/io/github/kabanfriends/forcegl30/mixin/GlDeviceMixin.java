package io.github.kabanfriends.forcegl30.mixin;

import com.mojang.blaze3d.shaders.GpuDebugOptions;
import com.mojang.blaze3d.shaders.ShaderSource;
import org.lwjgl.opengl.GL;
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

        System.out.println("========== FORCEGL30 ==========");
        System.out.println("GL_ARB_vertex_attrib_binding = " + caps.GL_ARB_vertex_attrib_binding);
        System.out.println("GL_ARB_direct_state_access   = " + caps.GL_ARB_direct_state_access);
        System.out.println("GL_ARB_buffer_storage        = " + caps.GL_ARB_buffer_storage);
        System.out.println("GL_ARB_base_instance         = " + caps.GL_ARB_base_instance);
        System.out.println("GL_ARB_draw_indirect         = " + caps.GL_ARB_draw_indirect);
        System.out.println("GL_ARB_instanced_arrays      = " + caps.GL_ARB_instanced_arrays);
        System.out.println("GL_ARB_draw_elements_base_vertex = " + caps.GL_ARB_draw_elements_base_vertex);
        System.out.println("GL_ARB_draw_instanced       = " + caps.GL_ARB_draw_instanced);
        System.out.println("GL_ARB_multi_draw_indirect   = " + caps.GL_ARB_multi_draw_indirect);
        System.out.println("GL_ARB_shader_draw_parameters= " + caps.GL_ARB_shader_draw_parameters);
        System.out.println("GL_ARB_clip_control          = " + caps.GL_ARB_clip_control);
        System.out.println("================================");
    }
}