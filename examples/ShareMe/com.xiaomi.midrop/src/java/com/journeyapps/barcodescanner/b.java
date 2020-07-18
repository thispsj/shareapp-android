/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  com.google.zxing.a
 *  com.google.zxing.b.b
 *  com.google.zxing.l
 *  com.google.zxing.v
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.journeyapps.barcodescanner;

import android.graphics.Bitmap;
import com.google.zxing.a;
import com.google.zxing.l;
import com.google.zxing.v;

public final class b {
    public static Bitmap a(String string2, a a2, int n2, int n3) throws v {
        com.google.zxing.b.b b2 = b.b(string2, a2, n2, n3);
        int n4 = b2.a;
        int n5 = b2.b;
        int[] arrn = new int[n4 * n5];
        for (int i2 = 0; i2 < n5; ++i2) {
            int n6 = i2 * n4;
            for (int i3 = 0; i3 < n4; ++i3) {
                int n7 = n6 + i3;
                int n8 = b2.a(i3, i2) ? -16777216 : -1;
                arrn[n7] = n8;
            }
        }
        Bitmap bitmap = Bitmap.createBitmap((int)n4, (int)n5, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        bitmap.setPixels(arrn, 0, n4, 0, 0, n4, n5);
        return bitmap;
    }

    private static com.google.zxing.b.b b(String string2, a a2, int n2, int n3) throws v {
        try {
            com.google.zxing.b.b b2 = new l().a(string2, a2, n2, n3);
            return b2;
        }
        catch (Exception exception) {
            throw new v((Throwable)exception);
        }
        catch (v v2) {
            throw v2;
        }
    }
}

