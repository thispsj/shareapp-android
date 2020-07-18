/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$b
 *  com.xiaomi.midrop.received.ReceivedActivity
 *  java.util.List
 */
package com.xiaomi.midrop.sender.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.received.ReceivedActivity;
import com.xiaomi.midrop.sender.card.d;
import java.util.List;

public abstract class h
extends RecyclerView.a {
    protected Context d;
    protected List<g> e;
    protected int f;
    protected boolean g;
    protected d.a h;

    public h(Context context, List<g> list, boolean bl) {
        this.d = context;
        this.e = list;
        this.f = 1;
        this.g = bl;
    }

    public final void a(d.a a2) {
        this.h = a2;
    }

    public final void a(boolean bl) {
        this.g = bl;
        this.a.b();
    }

    public final void c() {
        if (this.d instanceof ReceivedActivity) {
            ((ReceivedActivity)this.d).c();
        }
    }
}

