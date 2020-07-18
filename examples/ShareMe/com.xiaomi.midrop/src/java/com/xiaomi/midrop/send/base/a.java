/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.List
 */
package com.xiaomi.midrop.send.base;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.send.base.a;
import com.xiaomi.midrop.send.card.c;
import com.xiaomi.midrop.send.card.i;
import com.xiaomi.midrop.send.card.k;
import com.xiaomi.midrop.sender.c.g;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.sender.card.j;
import com.xiaomi.midrop.view.stickadapter.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class a
extends com.xiaomi.midrop.view.stickadapter.a
implements g.a {
    protected int e;
    HashSet<g> f;
    HashSet<g> g;
    protected List<com.xiaomi.midrop.b.i> h;
    protected LayoutInflater i;

    public a() {
        this.f = new HashSet();
        this.g = new HashSet();
        this.h = new ArrayList();
        this.i = LayoutInflater.from((Context)MiDropApplication.a());
    }

    public a(int n2) {
        this.e = n2;
    }

    private void h() {
        new Handler().post(new Runnable(this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public final void run() {
                this.a.a.b();
            }
        });
    }

    @Override
    public a.c a(ViewGroup viewGroup) {
        d d2;
        block3 : {
            Context context;
            block0 : {
                block1 : {
                    block2 : {
                        context = viewGroup.getContext();
                        int n2 = this.e;
                        d2 = new k(context);
                        if (n2 == 6) break block0;
                        if (n2 == 8) break block1;
                        if (n2 == 10) break block2;
                        if (n2 == 12) break block1;
                        break block3;
                    }
                    d2 = new k(context);
                    break block3;
                }
                d2 = new c(context);
                break block3;
            }
            d2 = new com.xiaomi.midrop.send.card.j(context);
        }
        d2.m = this.i;
        return (a)this.new a(d2, viewGroup);
    }

    @Override
    public void a(a.c c2, int n2, int n3) {
        super.a(c2, n2, n3);
        a a2 = (a)c2;
        com.xiaomi.midrop.b.i i2 = (com.xiaomi.midrop.b.i)this.h.get(n2);
        a2.n.a(i2, true, this.g_());
        a2.n.a(new d.a((a)this, n2){
            final /* synthetic */ int a;
            final /* synthetic */ a b;
            {
                this.b = a2;
                this.a = n2;
            }

            public final void a(g g2) {
                this.b.a(this.a, true ^ this.b.g(this.a));
            }
        });
    }

    @Override
    public void a(a.d d2, int n2, int n3, int n4) {
        super.a(d2, n2, n3, n4);
        b b2 = (b)d2;
        g g2 = (g)((com.xiaomi.midrop.b.i)this.h.get((int)n2)).b.get(n3);
        b2.n.a(this.f.contains((Object)g2));
        b2.n.b(this.g.contains((Object)g2));
        b2.n.a(g2, com.xiaomi.midrop.sender.c.g.e().a(g2), this.g_());
    }

    @Override
    public final void a(String string2, List<g> list) {
        a.super.h();
    }

    @Override
    public final void a(List<g> list) {
        a.super.h();
    }

    @Override
    public final void b(List<g> list) {
        a.super.h();
    }

    @Override
    public int c() {
        return this.h.size();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public a.d c(ViewGroup var1, int var2_2) {
        var3_3 = var1.getContext();
        var4_4 = this.e;
        if (var4_4 == 10) ** GOTO lbl-1000
        if (var4_4 == 13) ** GOTO lbl12
        switch (var4_4) {
            default: {
                var5_5 = j.a(var4_4, var3_3, this.i);
                break;
            }
            case 7: 
            case 8: {
                var5_6 = new com.xiaomi.midrop.send.card.b(var3_3);
                break;
            }
lbl12: // 1 sources:
            var5_7 = new com.xiaomi.midrop.send.card.a(var3_3);
            break;
            case 6: lbl-1000: // 2 sources:
            {
                var5_8 = new i(var3_3);
            }
        }
        if (var5_9 != null) {
            var5_9.m = this.i;
        }
        return (a)this.new b((d)var5_9, var1);
    }

    public final void c(List<com.xiaomi.midrop.b.i> list) {
        if (list != null) {
            this.h.clear();
            this.h.addAll(list);
        }
    }

    @Override
    public int d(int n2) {
        return ((com.xiaomi.midrop.b.i)this.h.get((int)n2)).b.size();
    }

    @Override
    protected final boolean d() {
        return 8 == this.e || 6 == this.e || 12 == this.e;
        {
        }
    }

    @Override
    public boolean e(int n2) {
        return ((com.xiaomi.midrop.b.i)this.h.get((int)n2)).d == 0;
    }

    public boolean g_() {
        return true;
    }

    @Override
    public final void h_() {
        this.h();
    }

    protected final class a
    extends a.c {
        public d n;

        public a(d d2, ViewGroup viewGroup) {
            super(d2.a(viewGroup));
            this.n = d2;
        }
    }

    protected final class b
    extends a.d {
        public d n;

        public b(d d2, ViewGroup viewGroup) {
            super(d2.a(viewGroup));
            this.n = d2;
        }
    }

}

