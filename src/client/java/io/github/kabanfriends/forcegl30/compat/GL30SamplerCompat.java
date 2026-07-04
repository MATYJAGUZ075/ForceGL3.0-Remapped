package io.github.kabanfriends.forcegl30.compat;

import org.lwjgl.opengl.ARBSamplerObjects;

public final class GL30SamplerCompat {

    private static final int[] LAST_SAMPLER = new int[32];

    static {
        for (int i = 0; i < LAST_SAMPLER.length; i++) {
            LAST_SAMPLER[i] = -1;
        }
    }

    private GL30SamplerCompat() {
    }

    public static void bindSampler(int unit, int sampler) {

        if (unit >= 0 &&
                unit < LAST_SAMPLER.length &&
                LAST_SAMPLER[unit] == sampler) {
            return;
        }

        ARBSamplerObjects.glBindSampler(unit, sampler);

        if (unit >= 0 && unit < LAST_SAMPLER.length) {
            LAST_SAMPLER[unit] = sampler;
        }
    }

    public static void invalidateCache() {

        for (int i = 0; i < LAST_SAMPLER.length; i++) {
            LAST_SAMPLER[i] = -1;
        }

    }

}
