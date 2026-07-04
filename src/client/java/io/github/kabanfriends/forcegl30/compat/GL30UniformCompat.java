package io.github.kabanfriends.forcegl30.compat;

import io.github.kabanfriends.forcegl30.ForceGL30;
import org.lwjgl.opengl.ARBUniformBufferObject;
import org.lwjgl.opengl.GL31;

public final class GL30UniformCompat {

    private enum Backend {
        GL31,
        ARB,
        NONE
    }

    private static Backend backend;

    // Cache
    private static int lastBinding = -1;
    private static int lastBuffer = -1;
    private static long lastOffset = Long.MIN_VALUE;
    private static long lastSize = Long.MIN_VALUE;

    private GL30UniformCompat() {
    }

    private static Backend getBackend() {

        if (backend != null)
            return backend;

        if (CompatibilityManager.HAS_UNIFORM_BUFFER)
            backend = Backend.GL31;
        else if (CompatibilityManager.HAS_ARB_UNIFORM_BUFFER)
            backend = Backend.ARB;
        else
            backend = Backend.NONE;

        ForceGL30.LOGGER.info("Uniform Buffer backend: {}", backend);

        return backend;
    }

    public static boolean bindUniformBuffer(
            int binding,
            int buffer,
            long offset,
            long size
    ) {

        if (binding == lastBinding &&
                buffer == lastBuffer &&
                offset == lastOffset &&
                size == lastSize) {
            return true;
        }

        switch (getBackend()) {

            case GL31 -> GL31.glBindBufferRange(
                    GL31.GL_UNIFORM_BUFFER,
                    binding,
                    buffer,
                    offset,
                    size
            );

            case ARB -> ARBUniformBufferObject.glBindBufferRange(
                    GL31.GL_UNIFORM_BUFFER,
                    binding,
                    buffer,
                    offset,
                    size
            );

            default -> {
                return false;
            }
        }

        lastBinding = binding;
        lastBuffer = buffer;
        lastOffset = offset;
        lastSize = size;

        return true;
    }

    public static void invalidateCache() {
        lastBinding = -1;
        lastBuffer = -1;
        lastOffset = Long.MIN_VALUE;
        lastSize = Long.MIN_VALUE;
    }

}
