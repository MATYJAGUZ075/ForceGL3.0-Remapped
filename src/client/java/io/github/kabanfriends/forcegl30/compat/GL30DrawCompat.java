package io.github.kabanfriends.forcegl30.compat;

import org.lwjgl.opengl.ARBBaseInstance;
import org.lwjgl.opengl.ARBDrawElementsBaseVertex;
import org.lwjgl.opengl.ARBDrawInstanced;

public final class GL30DrawCompat {

    private GL30DrawCompat() {
    }

    public static void drawArraysInstanced(
            int mode,
            int first,
            int count,
            int instanceCount
    ) {

        if (count <= 0 || instanceCount <= 0)
            return;

        ARBDrawInstanced.glDrawArraysInstancedARB(
                mode,
                first,
                count,
                instanceCount
        );
    }

    public static void drawElementsInstancedBaseVertex(
            int mode,
            int count,
            int type,
            long indices,
            int instanceCount,
            int baseVertex
    ) {

        if (count <= 0 || instanceCount <= 0)
            return;

        while (instanceCount-- > 0) {
            ARBDrawElementsBaseVertex.glDrawElementsBaseVertex(
                    mode,
                    count,
                    type,
                    indices,
                    baseVertex
            );
        }
    }

    public static void drawArraysInstancedBaseInstance(
            int mode,
            int first,
            int count,
            int instanceCount,
            int firstInstance
    ) {

        if (count <= 0 || instanceCount <= 0)
            return;

        // OpenGL 3.0 no soporta firstInstance.
        ARBDrawInstanced.glDrawArraysInstancedARB(
                mode,
                first,
                count,
                instanceCount
        );
    }

    public static void drawElementsInstancedBaseVertexBaseInstance(
            int mode,
            int count,
            int type,
            long indices,
            int instanceCount,
            int baseVertex,
            int firstInstance
    ) {

        if (count <= 0 || instanceCount <= 0)
            return;

        // OpenGL 3.0 no soporta firstInstance.
        while (instanceCount-- > 0) {
            ARBDrawElementsBaseVertex.glDrawElementsBaseVertex(
                    mode,
                    count,
                    type,
                    indices,
                    baseVertex
            );
        }
    }

}
