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
 *  com.xiaomi.midrop.send.card.FilePickContactCard
 *  com.xiaomi.midrop.send.card.FilePickContactCard$configure
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.send.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.send.card.FilePickContactCard;
import com.xiaomi.midrop.send.card.d;
import com.xiaomi.midrop.send.contacts.b;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.util.h;

public final class d
extends com.xiaomi.midrop.sender.card.d {
    ImageView a;
    private TextView b;
    private TextView n;

    public d(Context context) {
        a.e.b.d.b((Object)context, "context");
        super(context);
    }

    public static final /* synthetic */ void a(d d2, boolean bl) {
        d2.d = bl;
    }

    public static final /* synthetic */ boolean a(d d2) {
        return d2.d;
    }

    public static final /* synthetic */ View b(d d2) {
        return d2.f;
    }

    public static final /* synthetic */ Context c(d d2) {
        return d2.g;
    }

    public static final /* synthetic */ d.b d(d d2) {
        return d2.i;
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        View view = this.e = this.a().inflate(2131427465, null);
        a.e.b.d.a((Object)view, "mRootView");
        View view2 = view.findViewById(2131296522);
        a.e.b.d.a((Object)view2, "findViewById(id)");
        this.a = (ImageView)view2;
        View view3 = this.e;
        a.e.b.d.a((Object)view3, "mRootView");
        View view4 = view3.findViewById(2131296810);
        a.e.b.d.a((Object)view4, "findViewById(id)");
        this.b = (TextView)view4;
        View view5 = this.e;
        a.e.b.d.a((Object)view5, "mRootView");
        View view6 = view5.findViewById(2131296412);
        a.e.b.d.a((Object)view6, "findViewById(id)");
        this.n = (TextView)view6;
        View view7 = this.e;
        a.e.b.d.a((Object)view7, "mRootView");
        View view8 = view7.findViewById(2131296734);
        a.e.b.d.a((Object)view8, "findViewById(id)");
        this.f = view8;
        View view9 = this.e;
        a.e.b.d.a((Object)view9, "mRootView");
        return view9;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final void a(g g2, boolean bl, boolean bl2) {
        String string2;
        String string3;
        if (g2 == null) {
            return;
        }
        this.d = bl;
        View view = this.f;
        a.e.b.d.a((Object)view, "mTagView");
        int n2 = bl2 ? 0 : 8;
        view.setVisibility(n2);
        View view2 = this.f;
        a.e.b.d.a((Object)view2, "mTagView");
        view2.setSelected(bl);
        b b2 = b.a.a(g2);
        TextView textView = this.b;
        if (textView == null) {
            a.e.b.d.a("titleTv");
        }
        if ((string2 = b2.a) == null) {
            string2 = "";
        }
        CharSequence charSequence = string2;
        textView.setText(charSequence);
        TextView textView2 = this.n;
        if (textView2 == null) {
            a.e.b.d.a("descTv");
        }
        if ((string3 = b2.b) == null) {
            string3 = "";
        }
        CharSequence charSequence2 = string3;
        textView2.setText(charSequence2);
        if (b2.c != null) {
            Context context = this.g;
            ImageView imageView = this.a;
            if (imageView == null) {
                a.e.b.d.a("imgThumb");
            }
            h.a(context, imageView, b2.c);
        } else {
            Context context = this.g;
            ImageView imageView = this.a;
            if (imageView == null) {
                a.e.b.d.a("imgThumb");
            }
            h.a(context, imageView, 2131231021);
        }
        if (bl2) {
            View view3 = this.f;
            a.e.b.d.a((Object)view3, "mTagView");
            view3.setVisibility(0);
            this.e.setOnClickListener(new View.OnClickListener((d)this, g2){
                final /* synthetic */ d a;
                final /* synthetic */ g b;
                {
                    this.a = d2;
                    this.b = g2;
                }

                public final void onClick(View view) {
                    d.a(this.a, true ^ d.a(this.a));
                    View view2 = d.b(this.a);
                    a.e.b.d.a((Object)view2, "mTagView");
                    view2.setSelected(d.a(this.a));
                    new android.os.Handler().postDelayed(new java.lang.Runnable(this){
                        final /* synthetic */ FilePickContactCard.configure.1 a;
                        {
                            this.a = var1;
                        }

                        public final void run() {
                            if (d.a(this.a.a)) {
                                com.xiaomi.midrop.send.FilePickNewActivity filePickNewActivity;
                                d d2 = this.a.a;
                                ImageView imageView = this.a.a.a;
                                if (imageView == null) {
                                    a.e.b.d.a("imgThumb");
                                }
                                d2.a((View)imageView);
                                com.xiaomi.midrop.sender.c.g.e().b(this.a.b);
                                Context context = d.c(this.a.a);
                                if (!(context instanceof com.xiaomi.midrop.send.FilePickNewActivity)) {
                                    context = null;
                                }
                                if ((filePickNewActivity = (com.xiaomi.midrop.send.FilePickNewActivity)context) != null) {
                                    filePickNewActivity.d();
                                }
                                return;
                            }
                            com.xiaomi.midrop.sender.c.g.e().c(this.a.b);
                        }
                    }, 100L);
                }
            });
            this.e.setOnLongClickListener(null);
            return;
        }
        View view4 = this.f;
        a.e.b.d.a((Object)view4, "mTagView");
        view4.setVisibility(8);
        this.e.setOnClickListener(null);
        this.e.setOnLongClickListener(new View.OnLongClickListener((d)this, g2){
            final /* synthetic */ d a;
            final /* synthetic */ g b;
            {
                this.a = d2;
                this.b = g2;
            }

            public final boolean onLongClick(View view) {
                if (d.d(this.a) != null) {
                    com.xiaomi.midrop.sender.c.g.e().b(this.b);
                    d.d(this.a).a();
                    return true;
                }
                return false;
            }
        });
    }
}

