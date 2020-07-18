/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.xiaomi.midrop.sender.card.AudioItemByGroupCard
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.sender.card;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.sender.card.AudioItemByGroupCard;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.util.h;
import java.util.List;

public final class b
extends d {
    private ImageView a;
    private TextView b;
    private TextView n;

    public b(Context context) {
        super(context);
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        this.a = (ImageView)this.e.findViewById(2131296522);
        this.b = (TextView)this.e.findViewById(2131296810);
        this.f = this.e.findViewById(2131296734);
        this.n = (TextView)this.e.findViewById(2131296399);
        return this.e;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final void a(g g2, boolean bl, boolean bl2) {
        String string2;
        TextView textView;
        this.d = bl;
        this.f.setSelected(this.d);
        if (g2 instanceof i) {
            textView = this.b;
            string2 = ((i)g2).c;
        } else {
            textView = this.b;
            string2 = g2.k;
        }
        textView.setText((CharSequence)string2);
        if (TextUtils.isEmpty((CharSequence)g2.u)) {
            h.a(this.g, this.a, 2131230988);
        } else {
            h.a(this.g, this.a, g2.u);
        }
        TextView textView2 = this.n;
        Context context = this.g;
        Object[] arrobject = new Object[]{((i)g2).b.size()};
        textView2.setText((CharSequence)context.getString(2131689551, arrobject));
        this.f.setOnClickListener(new View.OnClickListener((b)this, g2){
            final /* synthetic */ g a;
            final /* synthetic */ b b;
            {
                this.b = b2;
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
    }
}

