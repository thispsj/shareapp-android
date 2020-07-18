/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.xiaomi.midrop.sender.card.ApkItemCard
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 */
package com.xiaomi.midrop.sender.card;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.sender.card.ApkItemCard;
import com.xiaomi.midrop.sender.card.a;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.util.h;
import com.xiaomi.midrop.util.j;

public final class a
extends d {
    ImageView a;
    View b;
    private final String n = "base";
    private TextView o;
    private TextView p;
    private TextView q;
    private View r;
    private TextView s;

    public a(Context context) {
        super(context);
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        this.e = this.a().inflate(2131427543, viewGroup, false);
        this.a = (ImageView)this.e.findViewById(2131296522);
        this.o = (TextView)this.e.findViewById(2131296810);
        this.p = (TextView)this.e.findViewById(2131296412);
        this.q = (TextView)this.e.findViewById(2131296905);
        this.s = (TextView)this.e.findViewById(2131296530);
        this.f = this.e.findViewById(2131296734);
        this.r = this.e.findViewById(2131296431);
        this.b = this.e.findViewById(2131296602);
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
        this.a.setImageResource(2131231142);
        h.b(this.g, this.a, g2.i, 2131231142);
        this.o.setTag((Object)g2.i);
        if (g2.k.contains((CharSequence)"base")) {
            new AsyncTask<g, Void, String>(this.o){
                private TextView b;
                private g c;
                private Context d;
                {
                    this.b = textView;
                    this.d = textView.getContext().getApplicationContext();
                }

                protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                    this.c = ((g[])arrobject)[0];
                    return j.a(this.d, this.c.i);
                }

                protected final /* synthetic */ void onPostExecute(Object object) {
                    String string2 = (String)object;
                    if (this.b.getTag() != null && this.b.getTag().equals((Object)this.c.i)) {
                        if (TextUtils.isEmpty((CharSequence)string2)) {
                            this.b.setText((CharSequence)this.c.k);
                            return;
                        }
                        this.b.setText((CharSequence)string2);
                    }
                }
            }.execute((Object[])new g[]{g2});
        } else {
            this.o.setText((CharSequence)g2.k);
        }
        this.s.setTag((Object)g2);
        this.r.setVisibility(0);
        if (!TextUtils.isEmpty((CharSequence)g2.y)) {
            this.r.setVisibility(0);
            textView = this.q;
            String string3 = this.g.getResources().getString(2131689518);
            Object[] arrobject = new Object[]{g2.y};
            string2 = String.format((String)string3, (Object[])arrobject);
        } else {
            this.r.setVisibility(8);
            textView = this.q;
            string2 = "";
        }
        textView.setText((CharSequence)string2);
        this.p.setText((CharSequence)j.b(g2.l));
        com.xiaomi.midrop.util.a.a(this.g, this.s, g2.E);
        this.s.setOnClickListener(new View.OnClickListener((a)this, g2){
            final /* synthetic */ g a;
            final /* synthetic */ a b;
            {
                this.b = a2;
                this.a = g2;
            }

            public void onClick(View view) {
                if (this.a.E == 0 && !TextUtils.isEmpty((CharSequence)this.a.C)) {
                    android.content.Intent intent = this.b.g.getPackageManager().getLaunchIntentForPackage(this.a.C);
                    if (intent != null) {
                        this.b.g.startActivity(intent);
                    }
                } else {
                    j.b(this.b.g, this.a.i);
                }
                this.b.b.setVisibility(8);
                com.xiaomi.midrop.result.a.a().a(1, this.a.i);
            }
        });
        if (bl2) {
            this.f.setVisibility(0);
            this.e.setOnClickListener(new View.OnClickListener((a)this, g2){
                final /* synthetic */ g a;
                final /* synthetic */ a b;
                {
                    this.b = a2;
                    this.a = g2;
                }

                public void onClick(View view) {
                    this.b.d = true ^ this.b.d;
                    this.b.f.setSelected(this.b.d);
                    if (this.b.d) {
                        this.b.a((View)this.b.a);
                        com.xiaomi.midrop.sender.c.g.e().b(this.a);
                        return;
                    }
                    com.xiaomi.midrop.sender.c.g.e().c(this.a);
                }
            });
            this.e.setOnLongClickListener(null);
            this.s.setVisibility(8);
        } else {
            this.f.setVisibility(8);
            this.e.setOnClickListener(new View.OnClickListener((a)this, g2){
                final /* synthetic */ g a;
                final /* synthetic */ a b;
                {
                    this.b = a2;
                    this.a = g2;
                }

                public void onClick(View view) {
                    j.b(this.b.g, this.a.i);
                    com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.aY).a();
                    this.b.b.setVisibility(8);
                    com.xiaomi.midrop.result.a.a().a(1, this.a.i);
                }
            });
            this.e.setOnLongClickListener(new View.OnLongClickListener((a)this, g2){
                final /* synthetic */ g a;
                final /* synthetic */ a b;
                {
                    this.b = a2;
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
            this.s.setVisibility(0);
        }
        boolean bl3 = com.xiaomi.midrop.result.a.a().a(this.g, 1, g2.i);
        View view = this.b;
        int n2 = bl3 ? 0 : 8;
        view.setVisibility(n2);
    }

}

