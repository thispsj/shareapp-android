/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.midrop.view.rocket;

public final class c {
    public float a;
    public float b;
    public int c;
    public int d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;

    public final float a() {
        return this.b + this.j;
    }

    public final float b() {
        float f2 = this.a() + (float)this.d;
        if (f2 > this.g) {
            f2 = this.g;
        }
        return f2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("x ");
        stringBuilder.append(this.a);
        stringBuilder.append(" y ");
        stringBuilder.append(this.b);
        stringBuilder.append(" strokeWidth ");
        stringBuilder.append(this.c);
        stringBuilder.append(" height ");
        stringBuilder.append(this.d);
        stringBuilder.append(" alpha ");
        stringBuilder.append(this.e);
        stringBuilder.append(" minY ");
        stringBuilder.append(this.f);
        stringBuilder.append(" maxY ");
        stringBuilder.append(this.g);
        return stringBuilder.toString();
    }
}

