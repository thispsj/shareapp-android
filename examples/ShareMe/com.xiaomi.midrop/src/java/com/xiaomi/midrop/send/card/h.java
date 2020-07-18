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
 *  com.xiaomi.midrop.send.card.FilePickHistorySubGroupCard
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
import com.xiaomi.midrop.send.card.FilePickHistorySubGroupCard;
import com.xiaomi.midrop.sender.c.g;
import com.xiaomi.midrop.sender.card.d;
import java.util.Collection;
import java.util.List;

public final class h
extends d {
    private TextView a;
    private TextView b;

    public h(Context context) {
        super(context);
    }

    static /* synthetic */ boolean a(h h2) {
        return h2.d;
    }

    static /* synthetic */ boolean a(h h2, boolean bl) {
        h2.d = bl;
        return bl;
    }

    static /* synthetic */ boolean b(h h2) {
        return h2.d;
    }

    static /* synthetic */ View c(h h2) {
        return h2.f;
    }

    static /* synthetic */ boolean d(h h2) {
        return h2.d;
    }

    static /* synthetic */ View e(h h2) {
        return h2.f;
    }

    static /* synthetic */ Context f(h h2) {
        return h2.g;
    }

    static /* synthetic */ Context g(h h2) {
        return h2.g;
    }

    static /* synthetic */ d.a h(h h2) {
        return h2.h;
    }

    static /* synthetic */ d.a i(h h2) {
        return h2.h;
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        this.e = this.a().inflate(2131427471, viewGroup, false);
        this.f = this.e.findViewById(2131296734);
        this.a = (TextView)this.e.findViewById(2131296810);
        this.b = (TextView)this.e.findViewById(2131296399);
        return this.e;
    }

    @Override
    public final void a(com.xiaomi.midrop.b.g g2, boolean bl, boolean bl2) {
        i i2 = (i)g2;
        this.a.setText((CharSequence)i2.c);
        List<com.xiaomi.midrop.b.g> list = i2.a;
        TextView textView = this.b;
        Context context = this.g;
        Object[] arrobject = new Object[2];
        g.e();
        arrobject[0] = g.a(list);
        arrobject[1] = list.size();
        textView.setText((CharSequence)context.getString(2131689672, arrobject));
        if (i2.a != null) {
            this.d = g.e().a(i2.a);
        }
        View view = this.f;
        int n2 = bl2 ? 0 : 8;
        view.setVisibility(n2);
        this.f.setOnClickListener(new View.OnClickListener((h)this, i2){
            final /* synthetic */ i a;
            final /* synthetic */ h b;
            {
                this.b = h2;
                this.a = i2;
            }

            public void onClick(View view) {
                h.a(this.b, true ^ h.a(this.b));
                h.c(this.b).setSelected(h.b(this.b));
                new android.os.Handler().post(new java.lang.Runnable(this){
                    final /* synthetic */ FilePickHistorySubGroupCard.1 a;
                    {
                        this.a = var1;
                    }

                    public final void run() {
                        if (h.d(this.a.b)) {
                            this.a.b.a(h.e(this.a.b));
                            g.e().b(this.a.a.a);
                            if (h.f(this.a.b) instanceof com.xiaomi.midrop.send.FilePickNewActivity) {
                                ((com.xiaomi.midrop.send.FilePickNewActivity)h.g(this.a.b)).d();
                                return;
                            }
                        } else {
                            g.e().c(this.a.a.a);
                        }
                    }
                });
            }
        });
        this.e.setOnClickListener(new View.OnClickListener((h)this, i2){
            final /* synthetic */ i a;
            final /* synthetic */ h b;
            {
                this.b = h2;
                this.a = i2;
            }

            public void onClick(View view) {
                if (h.h(this.b) != null) {
                    h.i(this.b).a(this.a);
                }
            }
        });
        this.f.setSelected(this.d);
    }
}

