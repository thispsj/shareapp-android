/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  com.xiaomi.midrop.send.card.FilePickImageCard
 *  com.xiaomi.midrop.send.card.FilePickImageCard$ChildView
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.xiaomi.midrop.send.card;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.send.card.FilePickImageCard;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.util.h;
import java.util.ArrayList;
import java.util.List;

public final class i
extends d {
    private List<a> a = new ArrayList();
    private LinearLayout b;
    private int n;

    public i(Context context) {
        super(context);
    }

    static /* synthetic */ Context a(i i2) {
        return i2.g;
    }

    static /* synthetic */ Context b(i i2) {
        return i2.g;
    }

    static /* synthetic */ Context c(i i2) {
        return i2.g;
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        this.e = this.a().inflate(2131427472, viewGroup, false);
        this.b = (LinearLayout)this.e.findViewById(2131296565);
        this.a.add(new Object((i)this, this.e.findViewById(2131296495), 0){
            ImageView a;
            View b;
            View c;
            View d;
            boolean e;
            final /* synthetic */ i f;
            {
                this.f = i2;
                this.c = view;
                this.b = view.findViewById(2131296734);
                this.a = (ImageView)view.findViewById(2131296494);
                this.d = view.findViewById(2131296400);
            }

        });
        this.a.add(new /* invalid duplicate definition of identical inner class */);
        this.a.add(new /* invalid duplicate definition of identical inner class */);
        this.a.add(new /* invalid duplicate definition of identical inner class */);
        this.n = (int)this.g.getResources().getDimension(2131165452);
        return this.e;
    }

    @Override
    public final void a(g g2, boolean bl, boolean bl2) {
        com.xiaomi.midrop.b.i i2 = (com.xiaomi.midrop.b.i)g2;
        LinearLayout linearLayout = this.b;
        int n2 = this.b() ? this.n : 0;
        linearLayout.setPadding(0, n2, 0, this.b.getPaddingBottom());
        LinearLayout linearLayout2 = this.b;
        int n3 = this.b.getPaddingTop();
        int n4 = this.c() ? this.n : 0;
        linearLayout2.setPadding(0, n3, 0, n4);
        for (int i3 = 0; i3 < this.a.size(); ++i3) {
            a a2 = this.a.get(i3);
            View view = a2.c;
            if (i3 < i2.b.size()) {
                boolean bl3 = com.xiaomi.midrop.sender.c.g.e().a((g)i2.b.get(i3));
                final g g3 = (g)i2.b.get(i3);
                List<g> list = i2.a;
                a2.e = bl3;
                h.a(a2.f.g, a2.a, g3.h);
                a2.a.setOnClickListener(new View.OnClickListener(a2, list, g3, bl2){
                    final /* synthetic */ List a;
                    final /* synthetic */ g b;
                    final /* synthetic */ boolean c;
                    final /* synthetic */ a d;
                    {
                        this.d = a2;
                        this.a = list;
                        this.b = g2;
                        this.c = bl;
                    }

                    public void onClick(View view) {
                        com.xiaomi.midrop.util.ak.a().a((List<g>)this.a);
                        Context context = i.a(this.d.f);
                        g g2 = this.b;
                        String string = this.c ? "gallery.check" : "gallery.view";
                        com.xiaomi.midrop.GalleryActivity.a((Context)context, (g)g2, (String)string);
                    }
                });
                int n5 = 8;
                if (bl2) {
                    a2.b.setVisibility(0);
                    a2.b.setOnClickListener(new View.OnClickListener(a2, g3){
                        final /* synthetic */ g a;
                        final /* synthetic */ a b;
                        {
                            this.b = a2;
                            this.a = g2;
                        }

                        public void onClick(View view) {
                            this.b.e = true ^ this.b.e;
                            this.b.b.setSelected(this.b.e);
                            View view2 = this.b.d;
                            int n2 = this.b.e ? 0 : 8;
                            view2.setVisibility(n2);
                            new android.os.Handler().post(new java.lang.Runnable(this){
                                final /* synthetic */ FilePickImageCard.ChildView.2 a;
                                {
                                    this.a = var1;
                                }

                                public final void run() {
                                    if (this.a.b.e) {
                                        com.xiaomi.midrop.sender.c.g.e().b(this.a.a);
                                        this.a.b.f.a((View)this.a.b.a);
                                        if (i.b(this.a.b.f) instanceof com.xiaomi.midrop.send.FilePickNewActivity) {
                                            ((com.xiaomi.midrop.send.FilePickNewActivity)i.c(this.a.b.f)).d();
                                            return;
                                        }
                                    } else {
                                        com.xiaomi.midrop.sender.c.g.e().c(this.a.a);
                                    }
                                }
                            });
                        }
                    });
                    a2.a.setOnLongClickListener(null);
                } else {
                    a2.b.setVisibility(n5);
                    a2.b.setOnClickListener(null);
                    a2.a.setOnLongClickListener(new View.OnLongClickListener(){

                        public final boolean onLongClick(View view) {
                            if (a.this.f.i != null) {
                                com.xiaomi.midrop.sender.c.g.e().b(g3);
                                a.this.f.i.a();
                                return true;
                            }
                            return false;
                        }
                    });
                }
                a2.b.setSelected(a2.e);
                View view2 = a2.d;
                if (a2.e) {
                    n5 = 0;
                }
                view2.setVisibility(n5);
                view.setVisibility(0);
                continue;
            }
            view.setVisibility(4);
        }
    }

}

