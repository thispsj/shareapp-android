/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.util.Log
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.journeyapps.barcodescanner.a;

import android.graphics.Rect;
import android.util.Log;
import com.journeyapps.barcodescanner.a.l;
import com.journeyapps.barcodescanner.n;

public class g
extends l {
    private static final String b = "g";

    @Override
    protected final float a(n n2, n n3) {
        if (n2.a > 0 && n2.b > 0) {
            n n4 = n2.b(n3);
            float f2 = 1.0f * (float)n4.a / (float)n2.a;
            if (f2 > 1.0f) {
                f2 = (float)Math.pow((double)(1.0f / f2), (double)1.1);
            }
            float f3 = 1.0f * (float)n4.a / (float)n3.a + 1.0f * (float)n4.b / (float)n3.b;
            return f2 * (1.0f / f3 / f3);
        }
        return 0.0f;
    }

    @Override
    public final Rect b(n n2, n n3) {
        n n4 = n2.b(n3);
        String string2 = b;
        StringBuilder stringBuilder = new StringBuilder("Preview: ");
        stringBuilder.append((Object)n2);
        stringBuilder.append("; Scaled: ");
        stringBuilder.append((Object)n4);
        stringBuilder.append("; Want: ");
        stringBuilder.append((Object)n3);
        Log.i((String)string2, (String)stringBuilder.toString());
        int n5 = (n4.a - n3.a) / 2;
        int n6 = (n4.b - n3.b) / 2;
        return new Rect(-n5, -n6, n4.a - n5, n4.b - n6);
    }
}

