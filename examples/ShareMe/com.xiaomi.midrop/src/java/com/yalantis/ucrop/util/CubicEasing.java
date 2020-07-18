/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.yalantis.ucrop.util;

public final class CubicEasing {
    public static float easeIn(float f2, float f3, float f4, float f5) {
        float f6 = f2 / f5;
        return f3 + f6 * (f6 * (f4 * f6));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static float easeInOut(float f2, float f3, float f4, float f5) {
        float f6;
        float f7 = f2 / (f5 / 2.0f);
        if (f7 < 1.0f) {
            f6 = f7 * (f7 * (f7 * (f4 / 2.0f)));
            do {
                return f6 + f3;
                break;
            } while (true);
        }
        float f8 = f4 / 2.0f;
        float f9 = f7 - 2.0f;
        f6 = f8 * (2.0f + f9 * (f9 * f9));
        return f6 + f3;
    }

    public static float easeOut(float f2, float f3, float f4, float f5) {
        float f6 = f2 / f5 - 1.0f;
        return f3 + f4 * (1.0f + f6 * (f6 * f6));
    }
}

