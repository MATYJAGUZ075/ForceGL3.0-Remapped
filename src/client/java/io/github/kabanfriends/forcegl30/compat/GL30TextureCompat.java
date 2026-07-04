package io.github.kabanfriends.forcegl30.compat;

import io.github.kabanfriends.forcegl30.ForceGL30;
import org.lwjgl.opengl.ARBTextureBufferObject;
import org.lwjgl.opengl.GL31;

public final class GL30TextureCompat {

    private enum Backend {
        GL31,
        ARB,
        NONE
    }

    private static Backend backend;

    // Cache del último estado enviado al driver
    private static int lastTarget = -1;
    private static int lastInternalFormat = -1;
    private static int lastBuffer = -1;

    private GL30TextureCompat() {
    }

    private static Backend getBackend() {

        if (backend != null)
            return backend;

        if (CompatibilityManager.HAS_TEX_BUFFER)
            backend = Backend.GL31;
        else if (CompatibilityManager.HAS_ARB_TEX_BUFFER)
            backend = Backend.ARB;
        else
            backend = Backend.NONE;

        ForceGL30.LOGGER.info("Texture Buffer backend: {}", backend);

        return backend;
    }

    public static boolean texBuffer(
            int target,
            int internalFormat,
            int buffer
    ) {

        // Evita llamadas idénticas al driver
        if (target == lastTarget &&
                internalFormat == lastInternalFormat &&
                buffer == lastBuffer) {
            return true;
        }

        switch (getBackend()) {

            case GL31 -> GL31.glTexBuffer(
                    target,
                    internalFormat,
                    buffer
            );

            case ARB -> ARBTextureBufferObject.glTexBufferARB(
                    target,
                    internalFormat,
                    buffer
            );

            default -> {
                return false;
            }
        }

        lastTarget = target;
        lastInternalFormat = internalFormat;
        lastBuffer = buffer;

        return true;
    }

    public static void invalidateCache() {
        lastTarget = -1;
        lastInternalFormat = -1;
        lastBuffer = -1;
    }

}
