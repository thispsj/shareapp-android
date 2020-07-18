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
 *  com.xiaomi.midrop.send.card.FilePickContactGroupCard
 *  com.xiaomi.midrop.send.card.FilePickContactGroupCard$configure
 *  com.xiaomi.midrop.sender.c.g
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.List
 */
package com.xiaomi.midrop.send.card;

import a.e.b.d;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.send.card.FilePickContactGroupCard;
import com.xiaomi.midrop.sender.c.g;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.util.Locale.b;
import java.util.Collection;
import java.util.List;

public final class e
extends com.xiaomi.midrop.sender.card.d {
    public TextView a;
    public TextView b;

    public e(Context context) {
        d.b((Object)context, "context");
        super(context);
    }

    public static final /* synthetic */ void a(e e2, boolean bl) {
        e2.d = bl;
    }

    public static final /* synthetic */ boolean a(e e2) {
        return e2.d;
    }

    public static final /* synthetic */ View b(e e2) {
        return e2.f;
    }

    public static final /* synthetic */ Context c(e e2) {
        return e2.g;
    }

    public static final /* synthetic */ d.a d(e e2) {
        return e2.h;
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        View view = this.e = this.a().inflate(2131427474, viewGroup, false);
        d.a((Object)view, "mRootView");
        View view2 = view.findViewById(2131296810);
        d.a((Object)view2, "findViewById(id)");
        this.a = (TextView)view2;
        View view3 = this.e;
        d.a((Object)view3, "mRootView");
        View view4 = view3.findViewById(2131296734);
        d.a((Object)view4, "findViewById(id)");
        this.f = view4;
        View view5 = this.e;
        d.a((Object)view5, "mRootView");
        View view6 = view5.findViewById(2131296399);
        d.a((Object)view6, "findViewById(id)");
        this.b = (TextView)view6;
        View view7 = this.e;
        d.a((Object)view7, "mRootView");
        return view7;
    }

    @Override
    public final void a(com.xiaomi.midrop.b.g g2, boolean bl, boolean bl2) {
        d.b(g2, "data");
        i i2 = (i)g2;
        TextView textView = this.a;
        if (textView == null) {
            d.a("titleTv");
        }
        textView.setText((CharSequence)b.a().b(2131689665));
        TextView textView2 = this.b;
        if (textView2 == null) {
            d.a("countTv");
        }
        Context context = this.g;
        Object[] arrobject = new Object[]{i2.a().size()};
        textView2.setText((CharSequence)context.getString(2131689551, arrobject));
        this.d = g.e().a((Collection)i2.a());
        View view = this.f;
        d.a((Object)view, "mTagView");
        int n2 = bl2 ? 0 : 8;
        view.setVisibility(n2);
        View view2 = this.f;
        d.a((Object)view2, "mTagView");
        view2.setSelected(this.d);
        this.f.setOnClickListener(new View.OnClickListener((e)this, i2){
            final /* synthetic */ e a;
            final /* synthetic */ i b;
            {
                this.a = e2;
                this.b = i2;
            }

            public final void onClick(View view) {
                e.a(this.a, true ^ e.a(this.a));
                View view2 = e.b(this.a);
                d.a((Object)view2, "mTagView");
                view2.setSelected(e.a(this.a));
                new android.os.Handler().post(new java.lang.Runnable(this){
                    final /* synthetic */ FilePickContactGroupCard.configure.1 a;
                    {
                        this.a = var1;
                    }

                    public final void run() {
                        if (e.a(this.a.a)) {
                            com.xiaomi.midrop.send.FilePickNewActivity filePickNewActivity;
                            this.a.a.a(e.b(this.a.a));
                            g.e().b((Collection)this.a.b.a());
                            Context context = e.c(this.a.a);
                            if (!(context instanceof com.xiaomi.midrop.send.FilePickNewActivity)) {
                                context = null;
                            }
                            if ((filePickNewActivity = (com.xiaomi.midrop.send.FilePickNewActivity)context) != null) {
                                filePickNewActivity.d();
                            }
                            return;
                        }
                        g.e().c((Collection)this.a.b.a());
                    }
                });
            }
        });
        this.e.setOnClickListener(new View.OnClickListener((e)this, i2){
            final /* synthetic */ e a;
            final /* synthetic */ i b;
            {
                this.a = e2;
                this.b = i2;
            }

            public final void onClick(View view) {
                if (e.d(this.a) != null) {
                    e.d(this.a).a(this.b);
                }
            }
        });
    }
}

