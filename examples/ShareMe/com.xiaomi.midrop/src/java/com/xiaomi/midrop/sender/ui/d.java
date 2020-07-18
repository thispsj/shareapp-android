/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$w
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  java.lang.Object
 *  java.util.List
 */
package com.xiaomi.midrop.sender.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xiaomi.midrop.sender.c.g;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.sender.card.e;
import com.xiaomi.midrop.sender.card.j;
import com.xiaomi.midrop.sender.ui.d;
import com.xiaomi.midrop.sender.ui.h;
import java.util.List;

public final class d
extends h {
    public boolean c;
    private LayoutInflater i;

    public d(Context context, List<com.xiaomi.midrop.b.g> list, boolean bl) {
        super(context, list, bl, (byte)0);
    }

    private d(Context context, List<com.xiaomi.midrop.b.g> list, boolean bl, byte by) {
        super(context, list, bl);
        this.c = true;
        this.c = true;
        this.i = LayoutInflater.from((Context)context);
    }

    public final int a() {
        if (this.e == null) {
            return 0;
        }
        return this.e.size();
    }

    public final RecyclerView.w a(ViewGroup viewGroup, int n2) {
        return new RecyclerView.w(j.a(this.f, this.d, this.i), viewGroup){
            private com.xiaomi.midrop.sender.card.d o;
            {
                this.o = d3;
            }
        };
    }

    public final void a(RecyclerView.w w2, int n2) {
        a a2 = w2;
        com.xiaomi.midrop.b.g g2 = (com.xiaomi.midrop.b.g)this.e.get(n2);
        boolean bl = g.e().a(g2);
        a2.o.a(new d.a((d)this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public final void a(com.xiaomi.midrop.b.g g2) {
                if (this.a.h != null) {
                    this.a.h.a(g2);
                }
            }
        });
        a2.o.a(new d.b((d)this){
            final /* synthetic */ d a;
            {
                this.a = d2;
            }

            public final void a() {
                this.a.c();
                com.xiaomi.midrop.view.action.MoreAction.a("long_click");
            }
        });
        a2.o.a((Object)this.e);
        if (a2.o instanceof e) {
            ((e)a.a(a2)).s = this.c;
        }
        a2.o.a(g2, bl, this.g);
    }

    public final void a(List<com.xiaomi.midrop.b.g> list) {
        this.e = list;
    }

}

