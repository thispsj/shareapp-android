/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.xiaomi.midrop.send.card.FilePickApkItemCard
 *  com.xiaomi.midrop.send.card.FilePickApkItemCard$ChildView
 *  com.xiaomi.midrop.sender.c.g
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.xiaomi.midrop.send.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.send.card.FilePickApkItemCard;
import com.xiaomi.midrop.sender.c.g;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.util.h;
import com.xiaomi.midrop.util.j;
import java.util.ArrayList;
import java.util.List;

public final class a
extends d {
    private List<a> a = new ArrayList();

    public a(Context context) {
        super(context);
    }

    static /* synthetic */ Context a(a a2) {
        return a2.g;
    }

    static /* synthetic */ Context b(a a2) {
        return a2.g;
    }

    static /* synthetic */ Context c(a a2) {
        return a2.g;
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        this.e = this.a().inflate(2131427463, viewGroup, false);
        this.a.add(new Object((a)this, this.e.findViewById(2131296542), 0){
            ImageView a;
            View b;
            View c;
            boolean d;
            TextView e;
            TextView f;
            final /* synthetic */ a g;
            {
                this.g = a2;
                this.c = view;
                this.b = view.findViewById(2131296734);
                this.a = (ImageView)view.findViewById(2131296505);
                this.e = (TextView)view.findViewById(2131296810);
                this.f = (TextView)view.findViewById(2131296758);
            }
        });
        this.a.add(new /* invalid duplicate definition of identical inner class */);
        this.a.add(new /* invalid duplicate definition of identical inner class */);
        this.a.add(new /* invalid duplicate definition of identical inner class */);
        this.a.add(new /* invalid duplicate definition of identical inner class */);
        return this.e;
    }

    @Override
    public final void a(com.xiaomi.midrop.b.g g2, boolean bl, boolean bl2) {
        i i2 = (i)g2;
        for (int i3 = 0; i3 < this.a.size(); ++i3) {
            a a2 = this.a.get(i3);
            View view = a2.c;
            if (i3 < i2.b.size()) {
                boolean bl3 = g.e().a((com.xiaomi.midrop.b.g)i2.b.get(i3));
                com.xiaomi.midrop.b.g g3 = (com.xiaomi.midrop.b.g)i2.b.get(i3);
                a2.d = bl3;
                h.b(a2.g.g, a2.a, g3.i, -1);
                a2.e.setText((CharSequence)g3.k);
                a2.f.setText((CharSequence)j.b(g3.l));
                a2.c.setOnClickListener(new View.OnClickListener(a2, g3){
                    final /* synthetic */ com.xiaomi.midrop.b.g a;
                    final /* synthetic */ a b;
                    {
                        this.b = a2;
                        this.a = g2;
                    }

                    public void onClick(View view) {
                        this.b.d = true ^ this.b.d;
                        this.b.b.setSelected(this.b.d);
                        this.b.c.setSelected(this.b.d);
                        new android.os.Handler().post(new java.lang.Runnable(this){
                            final /* synthetic */ FilePickApkItemCard.ChildView.1 a;
                            {
                                this.a = var1;
                            }

                            public final void run() {
                                if (this.a.b.d) {
                                    this.a.b.g.a((View)this.a.b.a);
                                    g.e().b(this.a.a);
                                    if (a.a(this.a.b.g) instanceof com.xiaomi.midrop.send.FilePickNewActivity) {
                                        ((com.xiaomi.midrop.send.FilePickNewActivity)a.b(this.a.b.g)).d();
                                    }
                                    if (this.a.a.D != null && this.a.a.D.length > 0) {
                                        android.widget.Toast.makeText((Context)a.c(this.a.b.g), (int)2131689524, (int)0).show();
                                        return;
                                    }
                                } else {
                                    g.e().c(this.a.a);
                                }
                            }
                        });
                    }
                });
                a2.b.setSelected(a2.d);
                a2.c.setSelected(a2.d);
                view.setVisibility(0);
                continue;
            }
            view.setVisibility(4);
        }
    }

}

