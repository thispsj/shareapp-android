/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.support.v7.widget.CardView
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$j
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  com.xiaomi.midrop.sender.card.ImageItemByTimeCard
 *  com.xiaomi.midrop.sender.card.ImageItemByTimeCard$ChildView
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.xiaomi.midrop.sender.card;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.sender.card.ImageItemByTimeCard;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.h;
import java.util.ArrayList;
import java.util.List;

public final class g
extends d {
    int a;
    int b;
    int n;
    int o;
    private CardView p;
    private int q;
    private List<a> r = new ArrayList();

    public g(Context context) {
        super(context);
        this.a = context.getResources().getDimensionPixelOffset(2131165509);
        this.b = context.getResources().getDimensionPixelOffset(2131165508);
        this.q = context.getResources().getDimensionPixelOffset(2131165507);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final View a(ViewGroup viewGroup) {
        int n2;
        float f2;
        float f3;
        this.e = this.a().inflate(2131427453, viewGroup, false);
        this.p = (CardView)this.e.findViewById(2131296348);
        RecyclerView.j j2 = (RecyclerView.j)this.p.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 21) {
            n2 = this.q;
            f2 = this.p.getCardElevation();
            f3 = this.p.getRadius();
        } else {
            n2 = this.q;
            f2 = this.p.getCardElevation() + this.p.getRadius() + (float)this.p.getPaddingBottom() + (float)this.p.getPaddingTop() + (float)this.p.getContentPaddingBottom();
            f3 = this.p.getContentPaddingBottom();
        }
        j2.setMargins(n2, (int)(-(f2 + f3)), this.q, 0);
        this.o = (ac.b((Context)this.g).x - 4 * this.b - 2 * this.a - 2 * this.q) / 3;
        this.n = (int)this.p.getRadius();
        this.r.add(new Object((g)this, this.e.findViewById(2131296495), 0, 0){
            View a;
            View b;
            int c;
            boolean d;
            final /* synthetic */ g e;
            private ImageView f;
            {
                this.e = g2;
                this.b = view;
                this.a = view.findViewById(2131296734);
                this.f = (ImageView)view.findViewById(2131296494);
                this.c = n2;
            }

            final void a(com.xiaomi.midrop.b.g g2, boolean bl, boolean bl2, List<com.xiaomi.midrop.b.g> list) {
                this.d = bl;
                h.a(this.e.g, this.f, g2.h);
                if (bl2) {
                    this.a.setOnClickListener(new View.OnClickListener(this, g2){
                        final /* synthetic */ com.xiaomi.midrop.b.g a;
                        final /* synthetic */ a b;
                        {
                            this.b = a2;
                            this.a = g2;
                        }

                        public void onClick(View view) {
                            this.b.d = true ^ this.b.d;
                            this.b.a.setSelected(this.b.d);
                            if (this.b.d) {
                                com.xiaomi.midrop.sender.c.g.e().b(this.a);
                                return;
                            }
                            com.xiaomi.midrop.sender.c.g.e().c(this.a);
                        }
                    });
                } else {
                    this.a.setVisibility(8);
                }
                this.f.setOnClickListener(new View.OnClickListener(this, list, g2, bl2){
                    final /* synthetic */ List a;
                    final /* synthetic */ com.xiaomi.midrop.b.g b;
                    final /* synthetic */ boolean c;
                    final /* synthetic */ a d;
                    {
                        this.d = a2;
                        this.a = list;
                        this.b = g2;
                        this.c = bl;
                    }

                    /*
                     * Enabled aggressive block sorting
                     */
                    public void onClick(View view) {
                        com.xiaomi.midrop.util.ak.a().a((List<com.xiaomi.midrop.b.g>)this.a);
                        Context context = this.d.e.g;
                        com.xiaomi.midrop.b.g g2 = this.b;
                        String string2 = this.c ? "gallery.check" : "gallery.view";
                        com.xiaomi.midrop.GalleryActivity.a((Context)context, (com.xiaomi.midrop.b.g)g2, (String)string2);
                        com.xiaomi.midrop.util.af$a a2 = this.c ? com.xiaomi.midrop.util.af$a.O : com.xiaomi.midrop.util.af$a.aV;
                        com.xiaomi.midrop.util.af.a(a2).a();
                    }
                });
                this.a.setSelected(this.d);
            }
        });
        this.r.add(new /* invalid duplicate definition of identical inner class */);
        this.r.add(new /* invalid duplicate definition of identical inner class */);
        return this.e;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public final void a(com.xiaomi.midrop.b.g var1, boolean var2_3, boolean var3_2) {
        var4_4 = (i)var1;
        var5_5 = 0;
        while (var5_5 < this.r.size()) {
            block5 : {
                var6_9 = this.r.get(var5_5);
                var7_14 = var6_9.b;
                var8_6 = (LinearLayout.LayoutParams)var6_9.b.getLayoutParams();
                var8_6.width = var6_9.e.o;
                var8_6.height = var6_9.e.o;
                var9_10 = var4_4.e != false ? var6_9.e.a : var6_9.e.b;
                var10_12 = var9_10 + var6_9.e.n;
                if (var6_9.c != 0) break block5;
                var11_7 = var6_9.e.a;
                ** GOTO lbl21
            }
            if (var6_9.c == 2) {
                var11_7 = var6_9.e.b;
                var12_11 = var6_9.e.b + var6_9.e.n;
                var13_8 = var6_9.e.a;
            } else {
                var11_7 = var6_9.e.b;
lbl21: // 2 sources:
                var12_11 = var6_9.e.b + var6_9.e.n;
                var13_8 = var6_9.e.b;
            }
            var8_6.setMargins(var11_7, var12_11, var13_8, var10_12);
            var6_9.b.setLayoutParams((ViewGroup.LayoutParams)var8_6);
            if (var5_5 < var4_4.b.size()) {
                var14_13 = com.xiaomi.midrop.sender.c.g.e().a((com.xiaomi.midrop.b.g)var4_4.b.get(var5_5));
                var6_9.a((com.xiaomi.midrop.b.g)var4_4.b.get(var5_5), var14_13, var3_2, var4_4.a);
                var7_14.setVisibility(0);
            } else {
                var7_14.setVisibility(8);
            }
            ++var5_5;
        }
    }

}

