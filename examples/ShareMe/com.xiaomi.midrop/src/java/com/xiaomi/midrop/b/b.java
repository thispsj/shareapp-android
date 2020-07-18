/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.midrop.b;

import android.text.TextUtils;
import com.xiaomi.midrop.b.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
extends g {
    public boolean a;
    public List<g> b;
    public String c;
    public int d;
    public int e;
    public int f;

    public b() {
        this.b = new ArrayList();
        this.e = 0;
        this.f = 0;
    }

    public b(int n2) {
        this.b = new ArrayList();
        this.e = 0;
        this.f = 0;
        this.g = n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final long a() {
        if (this.b.size() <= 0) {
            return this.l;
        }
        long l2 = 0L;
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            g g2 = (g)iterator.next();
            if (g2.m == 5) continue;
            long l3 = g2 instanceof b ? ((b)g2).a() : g2.l;
            l2 += l3;
        }
        return l2;
    }

    @Override
    public final void a(int n2) {
        if (n2 == 3) {
            boolean bl;
            block6 : {
                for (g g2 : this.b) {
                    if (g2.m == 3 || g2.m == 4 || g2.m == 5) continue;
                    bl = false;
                    break block6;
                }
                bl = true;
            }
            if (bl) {
                this.m = 3;
                return;
            }
        }
        if (n2 != 4 && n2 != 5) {
            if (n2 == 1 && this.m != 2) {
                this.m = 1;
                return;
            }
            this.m = 2;
            return;
        }
        this.m = n2;
        for (g g3 : this.b) {
            if (g3.c()) continue;
            g3.m = n2;
        }
    }

    public final long b() {
        if (this.b.size() > 0) {
            long l2 = 0L;
            for (g g2 : this.b) {
                if (g2.m == 5) continue;
                l2 += g2.o;
            }
            return l2;
        }
        return this.o;
    }

    @Override
    public final boolean c() {
        if (true ^ TextUtils.isEmpty((CharSequence)this.c)) {
            if (this.e == this.d()) {
                return true;
            }
            Iterator iterator = this.b.iterator();
            while (iterator.hasNext()) {
                if (((g)iterator.next()).c()) continue;
                return false;
            }
            return true;
        }
        return super.c();
    }

    public final int d() {
        return Math.max((int)0, (int)(this.b.size() - this.f));
    }
}

