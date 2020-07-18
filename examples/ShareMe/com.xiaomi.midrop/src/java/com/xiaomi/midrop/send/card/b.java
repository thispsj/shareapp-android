/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.xiaomi.midrop.send.card.FilePickAudioCard
 *  java.lang.CharSequence
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.midrop.send.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.send.card.FilePickAudioCard;
import com.xiaomi.midrop.send.card.b;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.util.aj;
import com.xiaomi.midrop.util.h;
import com.xiaomi.midrop.util.j;

public final class b
extends d {
    ImageView a;
    private TextView b;
    private TextView n;

    public b(Context context) {
        super(context);
    }

    static /* synthetic */ boolean a(b b2) {
        return b2.d;
    }

    static /* synthetic */ boolean a(b b2, boolean bl) {
        b2.d = bl;
        return bl;
    }

    static /* synthetic */ boolean b(b b2) {
        return b2.d;
    }

    static /* synthetic */ View c(b b2) {
        return b2.f;
    }

    static /* synthetic */ boolean d(b b2) {
        return b2.d;
    }

    static /* synthetic */ Context e(b b2) {
        return b2.g;
    }

    static /* synthetic */ Context f(b b2) {
        return b2.g;
    }

    static /* synthetic */ Context g(b b2) {
        return b2.g;
    }

    static /* synthetic */ d.b h(b b2) {
        return b2.i;
    }

    static /* synthetic */ d.b i(b b2) {
        return b2.i;
    }

    static /* synthetic */ Context j(b b2) {
        return b2.g;
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        this.e = this.a().inflate(2131427464, null);
        this.a = (ImageView)this.e.findViewById(2131296522);
        this.b = (TextView)this.e.findViewById(2131296810);
        this.n = (TextView)this.e.findViewById(2131296412);
        this.f = this.e.findViewById(2131296734);
        return this.e;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final void a(g g2, boolean bl, boolean bl2) {
        View.OnLongClickListener onLongClickListener;
        View view;
        this.d = bl;
        this.f.setSelected(this.d);
        h.b(this.g, this.a, g2.i);
        this.b.setText((CharSequence)g2.k);
        String string2 = aj.a(g2.y) ? com.xiaomi.midrop.util.Locale.b.a().b(2131690008) : g2.y.trim();
        String string3 = j.b(g2.l);
        TextView textView = this.n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("   ");
        stringBuilder.append(string3);
        textView.setText((CharSequence)stringBuilder.toString());
        if (bl2) {
            this.f.setVisibility(0);
            this.e.setOnClickListener(new View.OnClickListener((b)this, g2){
                final /* synthetic */ g a;
                final /* synthetic */ b b;
                {
                    this.b = b2;
                    this.a = g2;
                }

                public void onClick(View view) {
                    b.a(this.b, true ^ b.a(this.b));
                    b.c(this.b).setSelected(b.b(this.b));
                    new android.os.Handler().postDelayed(new java.lang.Runnable(this){
                        final /* synthetic */ FilePickAudioCard.1 a;
                        {
                            this.a = var1;
                        }

                        public final void run() {
                            if (b.d(this.a.b)) {
                                this.a.b.a((View)this.a.b.a);
                                com.xiaomi.midrop.sender.c.g.e().b(this.a.a);
                                if (b.e(this.a.b) instanceof com.xiaomi.midrop.send.FilePickNewActivity) {
                                    ((com.xiaomi.midrop.send.FilePickNewActivity)b.f(this.a.b)).d();
                                    return;
                                }
                            } else {
                                com.xiaomi.midrop.sender.c.g.e().c(this.a.a);
                            }
                        }
                    }, 100L);
                }
            });
            view = this.e;
            onLongClickListener = null;
        } else {
            this.f.setVisibility(8);
            this.e.setOnClickListener(new View.OnClickListener((b)this, g2){
                final /* synthetic */ g a;
                final /* synthetic */ b b;
                {
                    this.b = b2;
                    this.a = g2;
                }

                public void onClick(View view) {
                    j.b(b.g(this.b), this.a.i);
                    com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.Q).a();
                }
            });
            view = this.e;
            onLongClickListener = new View.OnLongClickListener((b)this, g2){
                final /* synthetic */ g a;
                final /* synthetic */ b b;
                {
                    this.b = b2;
                    this.a = g2;
                }

                public final boolean onLongClick(View view) {
                    if (b.h(this.b) != null) {
                        this.b.a((View)this.b.a);
                        com.xiaomi.midrop.sender.c.g.e().b(this.a);
                        b.i(this.b).a();
                        return true;
                    }
                    return false;
                }
            };
        }
        view.setOnLongClickListener(onLongClickListener);
        this.a.setOnClickListener(new View.OnClickListener((b)this, g2){
            final /* synthetic */ g a;
            final /* synthetic */ b b;
            {
                this.b = b2;
                this.a = g2;
            }

            public void onClick(View view) {
                j.b(b.j(this.b), this.a.i);
                com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.Q).a();
            }
        });
    }
}

