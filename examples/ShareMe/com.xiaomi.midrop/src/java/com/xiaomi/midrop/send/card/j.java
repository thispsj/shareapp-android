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
 *  com.xiaomi.midrop.send.card.FilePickImageExpendGroupCard
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.List
 */
package com.xiaomi.midrop.send.card;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.send.card.FilePickImageExpendGroupCard;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.util.h;
import java.util.Collection;
import java.util.List;

public final class j
extends d {
    ImageView a;
    ImageView b;
    private TextView n;
    private TextView o;

    public j(Context context) {
        super(context);
    }

    static /* synthetic */ boolean a(j j2) {
        return j2.d;
    }

    static /* synthetic */ boolean a(j j2, boolean bl) {
        j2.d = bl;
        return bl;
    }

    static /* synthetic */ boolean b(j j2) {
        return j2.d;
    }

    static /* synthetic */ View c(j j2) {
        return j2.f;
    }

    static /* synthetic */ boolean d(j j2) {
        return j2.d;
    }

    static /* synthetic */ Context e(j j2) {
        return j2.g;
    }

    static /* synthetic */ Context f(j j2) {
        return j2.g;
    }

    static /* synthetic */ d.a g(j j2) {
        return j2.h;
    }

    static /* synthetic */ d.a h(j j2) {
        return j2.h;
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

    @Override
    public final void a(g g2, boolean bl, boolean bl2) {
        i i2 = (i)g2;
        this.d = com.xiaomi.midrop.sender.c.g.e().a(i2.a);
        h.a(this.g, this.a, g2.h);
        this.a.setBackground(this.g.getResources().getDrawable(2131231159));
        this.a.setPadding(1, 1, 1, 1);
        this.n.setText((CharSequence)com.xiaomi.midrop.util.j.b(g2.i));
        TextView textView = this.o;
        Context context = this.g;
        Object[] arrobject = new Object[]{Integer.parseInt((String)i2.c)};
        textView.setText((CharSequence)context.getString(2131689551, arrobject));
        this.f.setOnClickListener(new View.OnClickListener((j)this, i2){
            final /* synthetic */ i a;
            final /* synthetic */ j b;
            {
                this.b = j2;
                this.a = i2;
            }

            public void onClick(View view) {
                j.a(this.b, true ^ j.a(this.b));
                j.c(this.b).setSelected(j.b(this.b));
                new android.os.Handler().post(new java.lang.Runnable(this){
                    final /* synthetic */ FilePickImageExpendGroupCard.1 a;
                    {
                        this.a = var1;
                    }

                    public final void run() {
                        if (j.d(this.a.b)) {
                            this.a.b.a((View)this.a.b.a);
                            com.xiaomi.midrop.sender.c.g.e().b(this.a.a.a);
                            if (j.e(this.a.b) instanceof com.xiaomi.midrop.send.FilePickNewActivity) {
                                ((com.xiaomi.midrop.send.FilePickNewActivity)j.f(this.a.b)).d();
                                return;
                            }
                        } else {
                            com.xiaomi.midrop.sender.c.g.e().c(this.a.a.a);
                        }
                    }
                });
            }
        });
        this.e.setOnClickListener(new View.OnClickListener((j)this, i2){
            final /* synthetic */ i a;
            final /* synthetic */ j b;
            {
                this.b = j2;
                this.a = i2;
            }

            public void onClick(View view) {
                if (j.g(this.b) != null) {
                    j.h(this.b).a(this.a);
                    boolean bl = this.a.f;
                    this.a.f = bl ^ true;
                    ImageView imageView = this.b.b;
                    int n2 = !bl ? 2131231008 : 2131231007;
                    imageView.setImageResource(n2);
                }
            }
        });
        this.f.setSelected(this.d);
        boolean bl3 = i2.f;
        ImageView imageView = this.b;
        int n2 = bl3 ? 2131231008 : 2131231007;
        imageView.setImageResource(n2);
    }
}

