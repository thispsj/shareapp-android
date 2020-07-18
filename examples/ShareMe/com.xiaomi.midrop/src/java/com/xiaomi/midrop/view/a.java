/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$h
 *  android.support.v7.widget.RecyclerView$t
 *  android.view.View
 *  java.lang.Object
 */
package com.xiaomi.midrop.view;

import a.e.b.d;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public final class a
extends RecyclerView.h {
    private final int a = 300;

    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t t2) {
        d.b((Object)rect, "outRect");
        d.b((Object)view, "view");
        d.b((Object)recyclerView, "parent");
        super.a(rect, view, recyclerView, t2);
        if (t2 == null) {
            d.a();
        }
        int n2 = t2.a();
        int n3 = RecyclerView.d((View)view);
        if (n2 > 0 && n3 == n2 - 1) {
            rect.set(0, 0, 0, this.a);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}

