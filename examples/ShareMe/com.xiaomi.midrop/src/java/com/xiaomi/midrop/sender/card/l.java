/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.xiaomi.midrop.sender.card.VideoItemCard
 *  java.lang.CharSequence
 *  java.lang.String
 */
package com.xiaomi.midrop.sender.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.result.a;
import com.xiaomi.midrop.sender.card.VideoItemCard;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.sender.card.l;
import com.xiaomi.midrop.util.h;
import com.xiaomi.midrop.util.j;

public final class l
extends d {
    ImageView a;
    View b;
    private TextView n;
    private TextView o;
    private TextView p;
    private View q;

    public l(Context context) {
        super(context);
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        this.e = this.a().inflate(2131427589, viewGroup, false);
        this.a = (ImageView)this.e.findViewById(2131296400);
        this.n = (TextView)this.e.findViewById(2131296907);
        this.o = (TextView)this.e.findViewById(2131296810);
        this.f = this.e.findViewById(2131296734);
        this.q = this.e.findViewById(2131296550);
        this.p = (TextView)this.e.findViewById(2131296807);
        this.b = this.e.findViewById(2131296602);
        return this.e;
    }

    @Override
    public final void a(g g2, boolean bl, boolean bl2) {
        this.d = bl;
        h.a(this.g, this.a, g2.i);
        this.f.setSelected(this.d);
        this.o.setText((CharSequence)g2.k);
        if (g2.v == 0L) {
            this.p.setVisibility(8);
        } else {
            this.p.setVisibility(0);
            this.p.setText((CharSequence)j.a(g2.v));
        }
        this.n.setText((CharSequence)j.b(g2.l));
        if (bl2) {
            this.f.setVisibility(0);
            this.q.setOnClickListener(new View.OnClickListener((l)this, g2){
                final /* synthetic */ g a;
                final /* synthetic */ l b;
                {
                    this.b = l2;
                    this.a = g2;
                }

                public void onClick(View view) {
                    this.b.d = true ^ this.b.d;
                    this.b.f.setSelected(this.b.d);
                    if (this.b.d) {
                        this.b.a((View)this.b.a);
                        com.xiaomi.midrop.sender.c.g.e().b(this.a);
                        return;
                    }
                    com.xiaomi.midrop.sender.c.g.e().c(this.a);
                }
            });
            this.q.setOnLongClickListener(null);
            this.a.setOnClickListener(new View.OnClickListener((l)this, g2){
                final /* synthetic */ g a;
                final /* synthetic */ l b;
                {
                    this.b = l2;
                    this.a = g2;
                }

                public void onClick(View view) {
                    j.b(this.b.g, this.a.i);
                    com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.P).a();
                }
            });
        } else {
            this.f.setVisibility(8);
            this.q.setOnClickListener(new View.OnClickListener((l)this, g2){
                final /* synthetic */ g a;
                final /* synthetic */ l b;
                {
                    this.b = l2;
                    this.a = g2;
                }

                public void onClick(View view) {
                    j.b(this.b.g, this.a.i);
                    com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.aW).a();
                    this.b.b.setVisibility(8);
                    a.a().a(4, this.a.i);
                }
            });
            this.q.setOnLongClickListener(new View.OnLongClickListener((l)this, g2){
                final /* synthetic */ g a;
                final /* synthetic */ l b;
                {
                    this.b = l2;
                    this.a = g2;
                }

                public final boolean onLongClick(View view) {
                    if (this.b.i != null) {
                        com.xiaomi.midrop.sender.c.g.e().b(this.a);
                        this.b.i.a();
                    }
                    return true;
                }
            });
        }
        boolean bl3 = a.a().a(this.g, 4, g2.i);
        View view = this.b;
        int n2 = bl3 ? 0 : 8;
        view.setVisibility(n2);
    }
}

