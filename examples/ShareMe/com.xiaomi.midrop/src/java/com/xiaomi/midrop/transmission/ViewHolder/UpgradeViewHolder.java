/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$w
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  java.lang.String
 */
package com.xiaomi.midrop.transmission.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.midrop.transmission.a.e;
import com.xiaomi.midrop.transmission.upgrade.a;
import com.xiaomi.midrop.util.af;

public class UpgradeViewHolder
extends RecyclerView.w
implements View.OnClickListener {
    public TextView n;
    public e o;

    public UpgradeViewHolder(View view) {
        super(view);
        this.n = (TextView)view.findViewById(2131296849);
        this.n.setOnClickListener((View.OnClickListener)this);
    }

    public void onClick(View view) {
        if (this.o != null) {
            if (!this.o.b()) {
                return;
            }
            if (view.getId() != 2131296849) {
                return;
            }
            if (this.o.a != a.b.a && this.o.a != a.b.c) {
                if (this.o.a == a.b.b) {
                    this.o.b.b();
                    af.a(af.a.cS).a(af.b.X, "SelectPage").a();
                }
                return;
            }
            this.o.b.a();
            af.a(af.a.cS).a(af.b.X, "WaitPage").a();
        }
    }
}

