/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.journeyapps.barcodescanner;

import android.graphics.Rect;

public final class o {
    byte[] a;
    int b;
    int c;
    int d;
    int e;
    Rect f;

    public o(byte[] arrby, int n2, int n3, int n4, int n5) {
        this.a = arrby;
        this.b = n2;
        this.c = n3;
        this.e = n5;
        this.d = n4;
        if (n2 * n3 > arrby.length) {
            StringBuilder stringBuilder = new StringBuilder("Image data does not match the resolution. ");
            stringBuilder.append(n2);
            stringBuilder.append("x");
            stringBuilder.append(n3);
            stringBuilder.append(" > ");
            stringBuilder.append(arrby.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public final boolean a() {
        return this.e % 180 != 0;
    }
}

