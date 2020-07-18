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
 *  com.xiaomi.midrop.sender.card.ImageItemCard
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.sender.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.result.a;
import com.xiaomi.midrop.sender.card.ImageItemCard;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.sender.card.h;
import com.xiaomi.midrop.util.ak;
import java.util.List;

public final class h
extends d {
    ImageView a;
    View b;
    View n;

    public h(Context context) {
        super(context);
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        this.e = this.a().inflate(2131427454, viewGroup, false);
        this.f = this.e.findViewById(2131296734);
        this.a = (ImageView)this.e.findViewById(2131296494);
        this.b = this.e.findViewById(2131296400);
        this.n = this.e.findViewById(2131296602);
        return this.e;
    }

    @Override
    public final void a(g g2, boolean bl, boolean bl2) {
        this.d = bl;
        com.xiaomi.midrop.util.h.a(this.g, this.a, g2.h);
        int n2 = 8;
        if (bl2) {
            this.f.setVisibility(0);
            this.f.setOnClickListener(new View.OnClickListener((h)this, g2){
                final /* synthetic */ g a;
                final /* synthetic */ h b;
                {
                    this.b = h2;
                    this.a = g2;
                }

                public void onClick(View view) {
                    this.b.d = true ^ this.b.d;
                    this.b.f.setSelected(this.b.d);
                    View view2 = this.b.b;
                    int n2 = this.b.d ? 0 : 8;
                    view2.setVisibility(n2);
                    if (this.b.d) {
                        this.b.a((View)this.b.a);
                        com.xiaomi.midrop.sender.c.g.e().b(this.a);
                        return;
                    }
                    com.xiaomi.midrop.sender.c.g.e().c(this.a);
                }
            });
        } else {
            this.f.setVisibility(n2);
            this.a.setOnLongClickListener(new View.OnLongClickListener((h)this, g2){
                final /* synthetic */ g a;
                final /* synthetic */ h b;
                {
                    this.b = h2;
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
        this.a.setOnClickListener(new View.OnClickListener((h)this, g2, bl2){
            final /* synthetic */ g a;
            final /* synthetic */ boolean b;
            final /* synthetic */ h c;
            {
                this.c = h2;
                this.a = g2;
                this.b = bl;
            }

            public void onClick(View view) {
                this.c.f.setSelected(this.c.d);
                Context context = this.c.g;
                g g2 = this.a;
                String string2 = this.b ? "gallery.check" : "gallery.view";
                com.xiaomi.midrop.GalleryActivity.a((Context)context, (g)g2, (String)string2);
                com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.aV).a();
                this.c.n.setVisibility(8);
                a.a().a(2, this.a.i);
            }
        });
        List list = (List)this.d();
        ak.a().a((List<g>)list);
        View view = this.b;
        int n3 = this.d ? 0 : 8;
        view.setVisibility(n3);
        this.f.setSelected(this.d);
        boolean bl3 = a.a().a(this.g, 2, g2.i);
        View view2 = this.n;
        if (bl3) {
            n2 = 0;
        }
        view2.setVisibility(n2);
    }
}

