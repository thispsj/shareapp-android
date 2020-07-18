/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 */
package com.xiaomi.midrop.view.rocket;

import com.xiaomi.midrop.view.rocket.c;

public final class d {
    float a;
    float b;
    float c;
    float d;

    private float a(float f2) {
        float f3 = (float)(10.0 * Math.random());
        return (float)(Math.sin((double)Math.toRadians((double)f2)) * (double)(this.c - f3) + (double)this.b);
    }

    public final void a(c c2) {
        float f2 = (float)((double)c2.h + Math.random() * (double)(c2.i - c2.h));
        float f3 = f2 + 180.0f;
        float f4 = 180.0f - f2;
        c2.c = (int)Math.ceil((double)(2.0 * Math.random()));
        double d2 = Math.random();
        if (d2 < 0.30000001192092896) {
            d2 = 0.30000001192092896;
        }
        c2.d = (int)Math.round((double)(d2 * (double)this.d));
        c2.e = 0.3f * (float)Math.random();
        c2.f = d.super.a(f3);
        c2.g = d.super.a(f4);
        float f5 = (float)(10.0 * Math.random());
        c2.a = (float)(Math.cos((double)Math.toRadians((double)f3)) * (double)(this.c - f5) + (double)this.a);
        c2.b = d.super.a(f3) - (float)c2.d;
        c2.j = 0.0f;
    }
}

