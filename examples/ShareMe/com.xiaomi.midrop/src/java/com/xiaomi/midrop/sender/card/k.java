/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.xiaomi.midrop.sender.card.SelectedItemCard
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 */
package com.xiaomi.midrop.sender.card;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.sender.card.SelectedItemCard;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.util.g;
import com.xiaomi.midrop.util.h;
import com.xiaomi.midrop.util.j;
import java.util.HashSet;

public final class k
extends d {
    private ImageView a;
    private TextView b;
    private TextView n;
    private View o;
    private View p;

    public k(Context context) {
        super(context);
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        this.e = this.a().inflate(2131427560, viewGroup, false);
        this.a = (ImageView)this.e.findViewById(2131296522);
        this.b = (TextView)this.e.findViewById(2131296453);
        this.n = (TextView)this.e.findViewById(2131296454);
        this.o = this.e.findViewById(2131296512);
        this.p = this.e.findViewById(2131296524);
        return this.e;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public final void a(com.xiaomi.midrop.b.g var1, boolean var2_3, boolean var3_2) {
        block9 : {
            this.b.setText((CharSequence)var1.k);
            if (var1.l != -1L) {
                var4_4 = this.n;
                var5_5 = j.b(var1.l);
            } else {
                var4_4 = this.n;
                var5_5 = "";
            }
            var4_4.setText((CharSequence)var5_5);
            this.a.setBackground(null);
            var6_6 = j.d(var1.i);
            if (!g.h.contains((Object)var6_6)) break block9;
            var7_7 = this.g;
            var8_8 = this.a;
            var9_9 = var1.i;
            ** GOTO lbl21
        }
        if (g.l.contains((Object)var6_6)) {
            var7_7 = this.g;
            var8_8 = this.a;
            var9_9 = var1.h;
lbl21: // 2 sources:
            h.a(var7_7, var8_8, var9_9);
            this.a.setBackground(this.g.getResources().getDrawable(2131231159));
        } else if (g.j.contains((Object)var6_6)) {
            h.b(this.g, this.a, var1.i, 2131231142);
        } else if (com.xiaomi.midrop.b.g.a(var1)) {
            this.a.setImageResource(2131230988);
        } else {
            h.b(this.g, this.a, var1.i);
        }
        this.o.setOnClickListener(new View.OnClickListener((k)this, var1){
            final /* synthetic */ com.xiaomi.midrop.b.g a;
            final /* synthetic */ k b;
            {
                this.b = k2;
                this.a = g2;
            }

            public void onClick(View view) {
                com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.J).a();
                com.xiaomi.midrop.sender.c.g.e().c(this.a);
                if (this.b.h != null) {
                    this.b.h.a(this.a);
                }
            }
        });
        if (var1.D != null && var1.D.length > 0) {
            this.p.setVisibility(0);
            this.p.setOnClickListener(new View.OnClickListener((k)this, var1){
                final /* synthetic */ com.xiaomi.midrop.b.g a;
                final /* synthetic */ k b;
                {
                    this.b = k2;
                    this.a = g2;
                }

                public void onClick(View view) {
                    if (this.a.D != null && this.a.D.length > 0) {
                        android.widget.Toast.makeText((Context)this.b.g, (int)2131689524, (int)0).show();
                    }
                }
            });
            return;
        }
        this.p.setVisibility(8);
    }
}

