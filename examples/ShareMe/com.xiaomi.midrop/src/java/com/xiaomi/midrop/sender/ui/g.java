/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$w
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Object
 *  java.util.List
 */
package com.xiaomi.midrop.sender.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.sender.card.j;
import java.util.List;

public final class g
extends RecyclerView.a {
    private List<com.xiaomi.midrop.b.g> c;
    private Context d;
    private LayoutInflater e;

    public g(Context context, List<com.xiaomi.midrop.b.g> list) {
        this.d = context;
        this.c = list;
        this.e = LayoutInflater.from((Context)context);
    }

    public final int a() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    public final RecyclerView.w a(ViewGroup viewGroup, int n2) {
        return (g)this.new a(j.a(4, this.d, this.e), viewGroup);
    }

    public final void a(RecyclerView.w w2, int n2) {
        a a2 = (a)w2;
        com.xiaomi.midrop.b.g g2 = (com.xiaomi.midrop.b.g)this.c.get(n2);
        boolean bl = com.xiaomi.midrop.sender.c.g.e().a(g2);
        a2.o.a(g2, bl, true);
    }

    private final class a
    extends RecyclerView.w {
        private d o;

        public a(d d2, ViewGroup viewGroup) {
            super(d2.a(viewGroup));
            this.o = d2;
        }
    }

}

