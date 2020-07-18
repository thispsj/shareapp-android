/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.midrop.transmission.a;

import com.xiaomi.midrop.b.b;
import com.xiaomi.midrop.b.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
extends com.xiaomi.midrop.transmission.a.a {
    public List<b> a = new ArrayList();
    public int b = 0;
    public int c = 0;
    public long d = 0L;
    public int e = 0;

    public d(List<b> list, int n2) {
        this.a = list;
        this.e = n2;
        this.b();
    }

    @Override
    public final int a() {
        return this.b;
    }

    @Override
    public final int a(int n2) {
        if (this.a != null) {
            if (n2 >= this.b) {
                return 5;
            }
            int n3 = 0;
            for (b b2 : this.a) {
                n3 = b2.g == 1 ? ++n3 : (n3 += b2.b.size());
                if (n2 >= n3) continue;
                if (b2.g == 1) {
                    return 4;
                }
                return 3;
            }
        }
        return 5;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void b() {
        this.b = 0;
        this.c = 0;
        this.d = 0L;
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            b b2 = (b)iterator.next();
            int n2 = b2.g == 1 ? 1 + this.b : this.b + b2.b.size();
            this.b = n2;
            b2.e = 0;
            b2.f = 0;
            for (g g2 : b2.b) {
                if (g2.m == 3) {
                    b2.e = 1 + b2.e;
                    continue;
                }
                if (g2.m != 5) continue;
                b2.f = 1 + b2.f;
            }
            this.c += b2.d();
            this.d += b2.a();
        }
        return;
    }

    public final boolean c() {
        return this.a.size() > 1;
    }

}

