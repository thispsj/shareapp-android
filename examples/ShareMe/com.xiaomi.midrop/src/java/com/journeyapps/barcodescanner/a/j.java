/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  java.lang.String
 */
package com.journeyapps.barcodescanner.a;

import android.graphics.Rect;
import com.journeyapps.barcodescanner.a.l;
import com.journeyapps.barcodescanner.n;

public class j
extends l {
    private static final String b = "j";

    private static float a(float f2) {
        if (f2 < 1.0f) {
            return 1.0f / f2;
        }
        return f2;
    }

    @Override
    protected final float a(n n2, n n3) {
        if (n2.a > 0 && n2.b > 0) {
            float f2 = j.a(1.0f * (float)n2.a / (float)n3.a);
            float f3 = j.a(1.0f * (float)n2.b / (float)n3.b);
            float f4 = 1.0f / f2 / f3;
            float f5 = j.a(1.0f * (float)n2.a / (float)n2.b / (1.0f * (float)n3.a / (float)n3.b));
            return f4 * (1.0f / f5 / f5 / f5);
        }
        return 0.0f;
    }

    @Override
    public final Rect b(n n2, n n3) {
        return new Rect(0, 0, n3.a, n3.b);
    }
}

