package io.github.kabanfriends.forcegl30.mixin;

import org.lwjgl.opengl.GL11C;
import org.lwjgl.opengl.GL33C;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = GL33C.class, remap = false)
public abstract class GL33CDebugMixin {

    @Overwrite
    public static void glVertexAttribDivisor(int index, int divisor) {

        System.out.println("[GL33] glVertexAttribDivisor");

        GL11C.glGetError();
    }
}