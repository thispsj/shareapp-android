/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$w
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.xiaomi.midrop.transmission.upgrade.UpgradeListAdapter
 *  com.xiaomi.midrop.transmission.upgrade.UpgradeListAdapter$ItemViewHolder
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.transmission.upgrade;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.transmission.upgrade.UpgradeListAdapter;
import com.xiaomi.midrop.util.h;
import com.xiaomi.midrop.util.x;
import java.util.List;

public final class b
extends RecyclerView.a {
    Context c;
    private List<com.xiaomi.midrop.transmission.upgrade.a.a> d;

    public b(Context context, List<com.xiaomi.midrop.transmission.upgrade.a.a> list) {
        this.c = context;
        this.d = list;
    }

    public final int a() {
        if (this.d == null) {
            return 0;
        }
        return this.d.size();
    }

    public final RecyclerView.w a(ViewGroup viewGroup, int n2) {
        return (b)this.new a(LayoutInflater.from((Context)this.c).inflate(2131427586, viewGroup, false));
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void a(RecyclerView.w w2, int n2) {
        a a2 = (a)w2;
        com.xiaomi.midrop.transmission.upgrade.a.a a3 = (com.xiaomi.midrop.transmission.upgrade.a.a)this.d.get(n2);
        boolean bl = com.xiaomi.midrop.transmission.upgrade.util.a.e().a(a3);
        boolean bl2 = true ^ a3.i;
        a2.o.setText((CharSequence)x.b(a3.c));
        a2.n.setBackground(null);
        h.b(a2.b.this.c, a2.n, a3.h, 2131231142);
        a2.a.setEnabled(bl2);
        a2.q.setEnabled(bl2);
        if (!bl2) {
            a2.p.setText((CharSequence)a2.b.this.c.getString(2131690015));
        } else {
            View view;
            int n3;
            Resources resources;
            a2.p.setText((CharSequence)a3.f);
            a2.q.setSelected(bl);
            if (bl) {
                view = a2.a;
                resources = a2.b.this.c.getResources();
                n3 = 2131100065;
            } else {
                view = a2.a;
                resources = a2.b.this.c.getResources();
                n3 = 2131099932;
            }
            view.setBackgroundColor(resources.getColor(n3));
        }
        a2.r = bl;
        a2.a.setOnClickListener(new View.OnClickListener(a2, a3){
            final /* synthetic */ com.xiaomi.midrop.transmission.upgrade.a.a a;
            final /* synthetic */ a b;
            {
                this.b = a2;
                this.a = a3;
            }

            public void onClick(View view) {
                a.a(this.b, true ^ a.a(this.b));
                a.b(this.b).setSelected(a.a(this.b));
                if (a.a(this.b)) {
                    this.b.a.setBackgroundColor(this.b.b.this.c.getResources().getColor(2131100065));
                    com.xiaomi.midrop.transmission.upgrade.util.a.e().b(this.a);
                    return;
                }
                this.b.a.setBackgroundColor(this.b.b.this.c.getResources().getColor(2131099932));
                com.xiaomi.midrop.transmission.upgrade.util.a.e().c(this.a);
            }
        });
    }

    private final class a
    extends RecyclerView.w {
        ImageView n;
        TextView o;
        TextView p;
        ImageView q;
        boolean r;

        public a(View view) {
            super(view);
            this.n = (ImageView)view.findViewById(2131296522);
            this.o = (TextView)view.findViewById(2131296855);
            this.p = (TextView)view.findViewById(2131296876);
            this.q = (ImageView)view.findViewById(2131296734);
        }

        static /* synthetic */ boolean a(a a2) {
            return a2.r;
        }

        static /* synthetic */ boolean a(a a2, boolean bl) {
            a2.r = bl;
            return bl;
        }

        static /* synthetic */ ImageView b(a a2) {
            return a2.q;
        }
    }

}

