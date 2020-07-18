/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.text.DateFormat
 *  java.util.ArrayList
 *  java.util.Date
 *  java.util.List
 */
package com.xiaomi.midrop.b.a;

import com.xiaomi.midrop.b.a.k;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class j
extends k<List<i>> {
    private List<i> b = new ArrayList();
    private List<g> c = new ArrayList();
    private List<g> d = new ArrayList();
    private long e = -1L;
    private DateFormat f = com.xiaomi.midrop.util.j.b();
    private int g = 4;

    private void e() {
        int n2 = this.b.size() - 1;
        if (n2 > 0) {
            ((i)this.b.get((int)n2)).e = true;
        }
    }

    @Override
    protected final void a(g g2) {
        boolean bl = true ^ com.xiaomi.midrop.util.j.a(g2.w, this.e);
        if (bl) {
            this.d = new ArrayList();
            j.super.e();
            this.b.add((Object)i.a(0, this.f.format(new Date(1000L * g2.w)), this.d));
            this.e = g2.w;
        }
        if (bl || this.c.size() == this.g) {
            this.c = new ArrayList();
            i i2 = i.a(1, this.f.format(new Date(1000L * g2.w)), this.c);
            i2.a = this.d;
            i2.i = g2.i;
            this.b.add((Object)i2);
        }
        this.c.add((Object)g2);
        this.d.add((Object)g2);
    }

    @Override
    protected final void c() {
        if (this.b != null) {
            this.b.clear();
        }
        if (this.d != null) {
            this.d.clear();
        }
    }

    @Override
    protected final /* synthetic */ Object d() {
        this.e();
        return this.b;
    }
}

