/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.xiaomi.midrop.sender.card.AudioItemCard
 *  java.lang.CharSequence
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.midrop.sender.card;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.result.a;
import com.xiaomi.midrop.sender.card.AudioItemCard;
import com.xiaomi.midrop.sender.card.c;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.h;
import com.xiaomi.midrop.util.j;

public final class c
extends d {
    View a;
    private ImageView b;
    private TextView n;
    private TextView o;

    public c(Context context) {
        super(context);
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        this.e = this.a().inflate(2131427393, viewGroup, false);
        this.b = (ImageView)this.e.findViewById(2131296522);
        this.n = (TextView)this.e.findViewById(2131296810);
        this.o = (TextView)this.e.findViewById(2131296412);
        this.f = this.e.findViewById(2131296734);
        this.a = this.e.findViewById(2131296602);
        return this.e;
    }

    @Override
    public final void a(g g2, boolean bl, boolean bl2) {
        this.d = bl;
        this.f.setSelected(this.d);
        h.b(this.g, this.b, g2.i);
        this.n.setText((CharSequence)g2.k);
        String string2 = TextUtils.isEmpty((CharSequence)g2.y) ? b.a().b(2131690008) : g2.y;
        String string3 = j.b(g2.l);
        TextView textView = this.o;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" | ");
        stringBuilder.append(string3);
        textView.setText((CharSequence)stringBuilder.toString());
        int n2 = 8;
        if (bl2) {
            this.f.setVisibility(0);
            this.e.setOnClickListener(new View.OnClickListener((c)this, g2){
                final /* synthetic */ g a;
                final /* synthetic */ c b;
                {
                    this.b = c2;
                    this.a = g2;
                }

                public void onClick(View view) {
                    this.b.d = true ^ this.b.d;
                    this.b.f.setSelected(this.b.d);
                    if (this.b.d) {
                        com.xiaomi.midrop.sender.c.g.e().b(this.a);
                        return;
                    }
                    com.xiaomi.midrop.sender.c.g.e().c(this.a);
                }
            });
            this.b.setOnClickListener(new View.OnClickListener((c)this, g2){
                final /* synthetic */ g a;
                final /* synthetic */ c b;
                {
                    this.b = c2;
                    this.a = g2;
                }

                public void onClick(View view) {
                    j.b(this.b.g, this.a.i);
                    com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.Q).a();
                    this.b.a.setVisibility(8);
                    a.a().a(3, this.a.i);
                }
            });
        } else {
            this.f.setVisibility(n2);
            this.e.setOnClickListener(new View.OnClickListener((c)this, g2){
                final /* synthetic */ g a;
                final /* synthetic */ c b;
                {
                    this.b = c2;
                    this.a = g2;
                }

                public void onClick(View view) {
                    j.b(this.b.g, this.a.i);
                    com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.aX).a();
                }
            });
            this.e.setOnLongClickListener(new View.OnLongClickListener((c)this, g2){
                final /* synthetic */ g a;
                final /* synthetic */ c b;
                {
                    this.b = c2;
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
        boolean bl3 = a.a().a(this.g, 3, g2.i);
        View view = this.a;
        if (bl3) {
            n2 = 0;
        }
        view.setVisibility(n2);
    }
}

