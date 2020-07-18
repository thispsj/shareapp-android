/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  com.xiaomi.midrop.send.card.FilePickImageTimeGroupCard
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
import android.widget.TextView;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.send.card.FilePickImageTimeGroupCard;
import com.xiaomi.midrop.sender.c.g;
import com.xiaomi.midrop.sender.card.d;
import java.util.Collection;
import java.util.List;

public final class k
extends d {
    private TextView a;
    private TextView b;

    public k(Context context) {
        super(context);
    }

    static /* synthetic */ boolean a(k k2) {
        return k2.d;
    }

    static /* synthetic */ boolean a(k k2, boolean bl) {
        k2.d = bl;
        return bl;
    }

    static /* synthetic */ boolean b(k k2) {
        return k2.d;
    }

    static /* synthetic */ View c(k k2) {
        return k2.f;
    }

    static /* synthetic */ boolean d(k k2) {
        return k2.d;
    }

    static /* synthetic */ View e(k k2) {
        return k2.f;
    }

    static /* synthetic */ Context f(k k2) {
        return k2.g;
    }

    static /* synthetic */ Context g(k k2) {
        return k2.g;
    }

    static /* synthetic */ d.a h(k k2) {
        return k2.h;
    }

    static /* synthetic */ d.a i(k k2) {
        return k2.h;
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        this.e = this.a().inflate(2131427474, viewGroup, false);
        this.f = this.e.findViewById(2131296734);
        this.a = (TextView)this.e.findViewById(2131296810);
        this.b = (TextView)this.e.findViewById(2131296399);
        return this.e;
    }

    @Override
    public final void a(com.xiaomi.midrop.b.g g2, boolean bl, boolean bl2) {
        i i2 = (i)g2;
        this.a.setText((CharSequence)i2.c);
        TextView textView = this.b;
        Context context = this.g;
        Object[] arrobject = new Object[1];
        int n2 = i2.a != null ? i2.a.size() : 0;
        arrobject[0] = n2;
        textView.setText((CharSequence)context.getString(2131689551, arrobject));
        if (i2.a != null) {
            this.d = g.e().a(i2.a);
        }
        View view = this.f;
        int n3 = bl2 ? 0 : 8;
        view.setVisibility(n3);
        this.f.setOnClickListener(new View.OnClickListener((k)this, i2){
            final /* synthetic */ i a;
            final /* synthetic */ k b;
            {
                this.b = k2;
                this.a = i2;
            }

            public void onClick(View view) {
                k.a(this.b, true ^ k.a(this.b));
                k.c(this.b).setSelected(k.b(this.b));
                new android.os.Handler().post(new java.lang.Runnable(this){
                    final /* synthetic */ FilePickImageTimeGroupCard.1 a;
                    {
                        this.a = var1;
                    }

                    public final void run() {
                        if (k.d(this.a.b)) {
                            this.a.b.a(k.e(this.a.b));
                            g.e().b(this.a.a.a);
                            if (k.f(this.a.b) instanceof com.xiaomi.midrop.send.FilePickNewActivity) {
                                ((com.xiaomi.midrop.send.FilePickNewActivity)k.g(this.a.b)).d();
                                return;
                            }
                        } else {
                            g.e().c(this.a.a.a);
                        }
                    }
                });
            }
        });
        this.e.setOnClickListener(new View.OnClickListener((k)this, i2){
            final /* synthetic */ i a;
            final /* synthetic */ k b;
            {
                this.b = k2;
                this.a = i2;
            }

            public void onClick(View view) {
                if (k.h(this.b) != null) {
                    k.i(this.b).a(this.a);
                }
            }
        });
        this.f.setSelected(this.d);
    }
}

