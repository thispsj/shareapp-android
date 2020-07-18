/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.widget.CardView
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  com.xiaomi.midrop.sender.card.ImageItemTitleCard
 *  java.lang.CharSequence
 *  java.lang.String
 */
package com.xiaomi.midrop.sender.card;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.sender.card.ImageItemTitleCard;
import com.xiaomi.midrop.sender.card.d;

public final class i
extends d {
    private CardView a;
    private TextView b;

    public i(Context context) {
        super(context);
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        this.e = this.a().inflate(2131427455, viewGroup, false);
        this.a = (CardView)this.e.findViewById(2131296348);
        this.b = (TextView)this.a.findViewById(2131296810);
        this.f = this.a.findViewById(2131296734);
        return this.e;
    }

    @Override
    public final void a(g g2, boolean bl, boolean bl2) {
        this.d = bl;
        com.xiaomi.midrop.b.i i2 = (com.xiaomi.midrop.b.i)g2;
        this.b.setText((CharSequence)i2.c);
        if (bl2) {
            this.f.setOnClickListener(new View.OnClickListener((i)this, i2){
                final /* synthetic */ com.xiaomi.midrop.b.i a;
                final /* synthetic */ i b;
                {
                    this.b = i2;
                    this.a = i3;
                }

                public void onClick(View view) {
                    this.b.d = true ^ this.b.d;
                    this.b.f.setSelected(this.b.d);
                    if (this.b.d) {
                        com.xiaomi.midrop.sender.c.g.e().b(this.a.b);
                        return;
                    }
                    com.xiaomi.midrop.sender.c.g.e().c(this.a.b);
                }
            });
        } else {
            this.f.setVisibility(8);
        }
        this.f.setSelected(this.d);
    }
}

