/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.send.card;

import a.e.b.d;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;

public final class f
extends com.xiaomi.midrop.sender.card.d {
    public TextView a;
    public View b;

    public f(Context context) {
        d.b((Object)context, "context");
        super(context);
    }

    @Override
    public final View a(ViewGroup viewGroup) {
        View view = this.e = this.a().inflate(2131427466, null);
        d.a((Object)view, "mRootView");
        View view2 = view.findViewById(2131296810);
        d.a((Object)view2, "findViewById(id)");
        this.a = (TextView)view2;
        View view3 = this.e;
        d.a((Object)view3, "mRootView");
        View view4 = view3.findViewById(2131296819);
        d.a((Object)view4, "findViewById(id)");
        this.b = view4;
        View view5 = this.e;
        d.a((Object)view5, "mRootView");
        return view5;
    }

    @Override
    public final void a(g g2, boolean bl, boolean bl2) {
        if (g2 != null) {
            TextView textView = this.a;
            if (textView == null) {
                d.a("titleTv");
            }
            textView.setText((CharSequence)g2.k);
        }
    }
}

