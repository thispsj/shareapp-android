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
 *  com.xiaomi.midrop.send.card.FilePickAudioExpendGroupCard
 *  com.xiaomi.midrop.sender.c.g
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
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
import com.xiaomi.midrop.send.card.FilePickAudioExpendGroupCard;
import com.xiaomi.midrop.sender.c.g;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.util.h;
import java.util.Collection;
import java.util.List;

public final class c
extends d {
    ImageView a;
    ImageView b;
    private TextView n;
    private TextView o;

    public c(Context context) {
        super(context);
    }

    static /* synthetic */ boolean a(c c2) {
        return c2.d;
    }

    static /* synthetic */ boolean a(c c2, boolean bl) {
        c2.d = bl;
        return bl;
    }

    static /* synthetic */ boolean b(c c2) {
        return c2.d;
    }

    static /* synthetic */ View c(c c2) {
        return c2.f;
    }

    static /* synthetic */ boolean d(c c2) {
        return c2.d;
    }

    static /* synthetic */ Context e(c c2) {
        return c2.g;
    }

    static /* synthetic */ Context f(c c2) {
        return c2.g;
    }

    static /* synthetic */ d.a g(c c2) {
        return c2.h;
    }

    static /* synthetic */ d.a h(c c2) {
        return c2.h;
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        this.e = this.a().inflate(2131427467, viewGroup, false);
        this.a = (ImageView)this.e.findViewById(2131296522);
        this.n = (TextView)this.e.findViewById(2131296810);
        this.o = (TextView)this.e.findViewById(2131296399);
        this.f = this.e.findViewById(2131296734);
        this.b = (ImageView)this.e.findViewById(2131296320);
        return this.e;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public final void a(com.xiaomi.midrop.b.g var1, boolean var2_3, boolean var3_2) {
        block2 : {
            var4_4 = (i)var1;
            this.d = g.e().a(var4_4.b);
            if (!"param_type_singers".equals((Object)var4_4.G)) break block2;
            var12_5 = this.g;
            var13_6 = this.a;
            var14_7 = var1.u;
            var15_8 = 2131231068;
            ** GOTO lbl15
        }
        if ("param_type_album".equals((Object)var4_4.G)) {
            var12_5 = this.g;
            var13_6 = this.a;
            var14_7 = var1.u;
            var15_8 = 2131231067;
lbl15: // 2 sources:
            h.a(var12_5, var13_6, var14_7, var15_8);
        } else {
            this.a.setImageResource(2131230988);
        }
        this.n.setText((CharSequence)var4_4.c);
        var5_9 = this.o;
        var6_10 = this.g;
        var7_11 = new Object[1];
        var8_12 = var4_4.b != null ? var4_4.b.size() : 0;
        var7_11[0] = var8_12;
        var5_9.setText((CharSequence)var6_10.getString(2131689551, var7_11));
        this.f.setOnClickListener(new View.OnClickListener((c)this, var4_4, var1){
            final /* synthetic */ i a;
            final /* synthetic */ com.xiaomi.midrop.b.g b;
            final /* synthetic */ c c;
            {
                this.c = c2;
                this.a = i2;
                this.b = g2;
            }

            public void onClick(View view) {
                c.a(this.c, true ^ c.a(this.c));
                c.c(this.c).setSelected(c.b(this.c));
                new android.os.Handler().post(new java.lang.Runnable(this){
                    final /* synthetic */ FilePickAudioExpendGroupCard.1 a;
                    {
                        this.a = var1;
                    }

                    public final void run() {
                        if (c.d(this.a.c)) {
                            this.a.c.a((View)this.a.c.a);
                            g.e().b(this.a.a.b);
                            if (c.e(this.a.c) instanceof com.xiaomi.midrop.send.FilePickNewActivity) {
                                ((com.xiaomi.midrop.send.FilePickNewActivity)c.f(this.a.c)).d();
                                return;
                            }
                        } else {
                            g.e().c(((i)this.a.b).b);
                        }
                    }
                });
            }
        });
        this.e.setOnClickListener(new View.OnClickListener((c)this, var4_4){
            final /* synthetic */ i a;
            final /* synthetic */ c b;
            {
                this.b = c2;
                this.a = i2;
            }

            public void onClick(View view) {
                if (c.g(this.b) != null) {
                    c.h(this.b).a(this.a);
                    boolean bl = this.a.f;
                    this.a.f = bl ^ true;
                    ImageView imageView = this.b.b;
                    int n2 = !bl ? 2131231008 : 2131231007;
                    imageView.setImageResource(n2);
                }
            }
        });
        this.f.setSelected(this.d);
        var9_13 = var4_4.f;
        var10_14 = this.b;
        var11_15 = var9_13 != false ? 2131231008 : 2131231007;
        var10_14.setImageResource(var11_15);
    }
}

