/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.send.contacts;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.send.card.e;
import com.xiaomi.midrop.send.card.f;
import com.xiaomi.midrop.send.contacts.c;
import com.xiaomi.midrop.sender.c.g;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.view.stickadapter.a;
import java.util.List;

public final class c
extends com.xiaomi.midrop.view.stickadapter.a
implements g.a {
    i c;

    private final void h() {
        new Handler().post(new Runnable(this){
            final /* synthetic */ c a;
            {
                this.a = c2;
            }

            public final void run() {
                this.a.b();
            }
        });
    }

    @Override
    public final int a(int n2, int n3) {
        i i2 = this.c;
        int n4 = 2;
        if (i2 != null) {
            if (((g)i2.d().get((int)n3)).F) {
                return n4;
            }
            n4 = 1;
        }
        return n4;
    }

    @Override
    public final a.c a(ViewGroup viewGroup) {
        a.e.b.d.b((Object)viewGroup, "parent");
        Context context = viewGroup.getContext();
        a.e.b.d.a((Object)context, "parent.context");
        return new a(new e(context), viewGroup);
    }

    @Override
    public final void a(a.c c2, int n2, int n3) {
        a.e.b.d.b((Object)c2, "viewHolder");
        super.a(c2, n2, n3);
        e e2 = ((a)c2).n;
        i i2 = this.c;
        if (i2 != null) {
            e2.a(i2, true, true);
        }
        e2.a(new d.a((c)this, n2){
            final /* synthetic */ c a;
            final /* synthetic */ int b;
            {
                this.a = c2;
                this.b = n2;
            }

            public final void a(g g2) {
                this.a.a(this.b, true ^ this.a.g(this.b));
            }
        });
    }

    @Override
    public final void a(a.d d2, int n2, int n3, int n4) {
        a.e.b.d.b((Object)d2, "viewHolder");
        super.a(d2, n2, n3, n4);
        i i2 = this.c;
        if (i2 != null) {
            g g2 = (g)i2.d().get(n3);
            com.xiaomi.midrop.sender.card.d d3 = ((b)d2).n;
            com.xiaomi.midrop.sender.card.d d4 = !(d3 instanceof f) ? null : d3;
            f f2 = (f)d4;
            if (f2 != null) {
                boolean bl = n2 != 0 || n3 != 0;
                View view = f2.b;
                if (view == null) {
                    a.e.b.d.a("topDivider");
                }
                int n5 = bl ? 0 : 4;
                view.setVisibility(n5);
            }
            d3.a(g2, com.xiaomi.midrop.sender.c.g.e().a(g2), true);
        }
    }

    @Override
    public final void a(String string2, List<g> list) {
        c.super.h();
    }

    @Override
    public final void a(List<g> list) {
        c.super.h();
    }

    @Override
    public final void b(List<g> list) {
        c.super.h();
    }

    @Override
    public final int c() {
        return this.c != null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final a.d c(ViewGroup viewGroup, int n2) {
        b b2;
        a.e.b.d.b((Object)viewGroup, "parent");
        switch (n2) {
            default: {
                Context context = viewGroup.getContext();
                a.e.b.d.a((Object)context, "parent.context");
                b2 = new b(new com.xiaomi.midrop.send.card.d(context), viewGroup);
                do {
                    return b2;
                    break;
                } while (true);
            }
            case 2: {
                Context context = viewGroup.getContext();
                a.e.b.d.a((Object)context, "parent.context");
                b2 = new b(new com.xiaomi.midrop.send.card.d(context), viewGroup);
                return b2;
            }
            case 1: 
        }
        Context context = viewGroup.getContext();
        a.e.b.d.a((Object)context, "parent.context");
        b2 = new b(new f(context), viewGroup);
        return b2;
    }

    @Override
    public final int d(int n2) {
        List<g> list;
        i i2 = this.c;
        if (i2 != null && (list = i2.d()) != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public final boolean e(int n2) {
        return true;
    }

    @Override
    public final void h_() {
        this.h();
    }

    private static final class a
    extends a.c {
        final e n;

        public a(e e2, ViewGroup viewGroup) {
            a.e.b.d.b(e2, "card");
            a.e.b.d.b((Object)viewGroup, "viewGroup");
            super(e2.a(viewGroup));
            this.n = e2;
        }
    }

    private static final class b
    extends a.d {
        final com.xiaomi.midrop.sender.card.d n;

        public b(com.xiaomi.midrop.sender.card.d d2, ViewGroup viewGroup) {
            a.e.b.d.b(d2, "card");
            a.e.b.d.b((Object)viewGroup, "viewGroup");
            super(d2.a(viewGroup));
            this.n = d2;
        }
    }

}

