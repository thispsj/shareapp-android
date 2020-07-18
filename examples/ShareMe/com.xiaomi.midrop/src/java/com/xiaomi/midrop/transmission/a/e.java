/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.xiaomi.midrop.transmission.a;

import com.xiaomi.midrop.transmission.upgrade.a;

public final class e
extends com.xiaomi.midrop.transmission.a.a {
    public a.b a;
    public a b;
    private int c = 0;

    public e(a.b b2, a a2) {
        this.a = b2;
        this.b = a2;
    }

    @Override
    public final int a() {
        return 1;
    }

    @Override
    public final int a(int n2) {
        return 6;
    }

    public final boolean b() {
        if (this.b == null) {
            return false;
        }
        return this.b.c();
    }

}

