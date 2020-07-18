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
 *  com.xiaomi.midrop.sender.card.ImageItemByGroupCard
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.sender.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.sender.card.ImageItemByGroupCard;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.util.h;
import com.xiaomi.midrop.util.j;
import java.util.List;

public final class f
extends d {
    private ImageView a;
    private TextView b;
    private TextView n;

    public f(Context context) {
        super(context);
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        this.e = this.a().inflate(2131427456, viewGroup, false);
        this.f = this.e.findViewById(2131296734);
        this.a = (ImageView)this.e.findViewById(2131296522);
        this.b = (TextView)this.e.findViewById(2131296810);
        this.n = (TextView)this.e.findViewById(2131296399);
        return this.e;
    }

    @Override
    public final void a(g g2, boolean bl, boolean bl2) {
        this.d = bl;
        h.a(this.g, this.a, g2.h);
        this.b.setText((CharSequence)j.b(g2.i));
        TextView textView = this.n;
        Context context = this.g;
        Object[] arrobject = new Object[]{((i)g2).b.size()};
        textView.setText((CharSequence)context.getString(2131689551, arrobject));
        this.f.setOnClickListener(new View.OnClickListener((f)this, g2){
            final /* synthetic */ g a;
            final /* synthetic */ f b;
            {
                this.b = f2;
                this.a = g2;
            }

            public void onClick(View view) {
                this.b.d = true ^ this.b.d;
                this.b.f.setSelected(this.b.d);
                if (this.b.d) {
                    com.xiaomi.midrop.sender.c.g.e().b(((i)this.a).b);
                    return;
                }
                com.xiaomi.midrop.sender.c.g.e().c(((i)this.a).b);
            }
        });
        this.f.setSelected(this.d);
    }
}

