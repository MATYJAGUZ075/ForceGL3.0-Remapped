package io.github.kabanfriends.forcegl30.mixin;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.opengl.VertexArrayCache;
import com.mojang.blaze3d.vertex.VertexFormat;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "com.mojang.blaze3d.opengl.VertexArrayCache$Separate")
public class VertexArrayCacheSeparateMixin {

    @Inject(
            method = "bindVertexArray",
            at = @At("HEAD"),
            remap = false
    )
    private void forcegl30$entered(
            VertexFormat[] vertexBindings,
            GpuBufferSlice[] vertexBuffers,
            @Nullable VertexArrayCache.VertexArray lastBoundVertexArray,
            CallbackInfoReturnable<VertexArrayCache.VertexArray> cir
    ) {
        System.out.println("========== VertexArrayCache.Separate ==========");
        System.out.println("bindVertexArray()");
        System.out.println("vertexBindings = " + vertexBindings.length);
        System.out.println("vertexBuffers  = " + vertexBuffers.length);
    }
}