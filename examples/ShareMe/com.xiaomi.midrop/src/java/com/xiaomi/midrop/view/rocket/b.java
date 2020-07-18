/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  java.lang.Math
 *  java.lang.Object
 */
package com.xiaomi.midrop.view.rocket;

import android.content.Context;
import android.graphics.Bitmap;

public final class b {
    int a;
    int b;
    int c;
    int d;
    a[] e;
    Context f;
    private final int g = 6;

    public b(Context context) {
        this.f = context;
    }

    public final com.xiaomi.midrop.view.rocket.a[] a() {
        int n2 = (this.d - this.b) / 4;
        int n3 = this.b - n2 * 2;
        int n4 = (int)Math.round((double)(10.0 * Math.random())) % 6;
        com.xiaomi.midrop.view.rocket.a[] arra = new com.xiaomi.midrop.view.rocket.a[6];
        int n5 = n4;
        int n6 = 0;
        while (n6 < 6) {
            arra[n6] = new com.xiaomi.midrop.view.rocket.a();
            arra[n6].a = this.e[n5].a;
            arra[n6].b = this.e[n5].b;
            com.xiaomi.midrop.view.rocket.a a2 = arra[n6];
            int n7 = n3 + n2 * n6;
            int n8 = n6 + 1;
            a2.c = n7 + (n3 + n2 * n8 - n7) / 2;
            arra[n6].d = n3;
            arra[n6].e = n3 + n2;
            if (++n5 >= 6) {
                n5 = 0;
            }
            n6 = n8;
        }
        return arra;
    }

    private static final class a {
        Bitmap a;
        int b;

        private a() {
        }

        /* synthetic */ a(byte by) {
        }
    }

}

