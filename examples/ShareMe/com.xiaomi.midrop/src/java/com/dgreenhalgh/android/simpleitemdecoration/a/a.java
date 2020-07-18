/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$h
 *  android.support.v7.widget.RecyclerView$j
 *  android.support.v7.widget.RecyclerView$t
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package com.dgreenhalgh.android.simpleitemdecoration.a;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public final class a
extends RecyclerView.h {
    private Drawable a;
    private Drawable b;
    private int c;

    public a(Drawable drawable2, Drawable drawable3) {
        this.a = drawable2;
        this.b = drawable3;
        this.c = 3;
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t t2) {
        super.a(rect, view, recyclerView, t2);
        boolean bl = RecyclerView.d((View)view) % this.c == 0;
        if (!bl) {
            rect.left = this.a.getIntrinsicWidth();
        }
        int n2 = RecyclerView.d((View)view);
        int n3 = this.c;
        boolean bl2 = false;
        if (n2 < n3) {
            bl2 = true;
        }
        if (!bl2) {
            rect.top = this.b.getIntrinsicHeight();
        }
    }

    public final void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.t t2) {
        int n2 = recyclerView.getPaddingTop();
        int n3 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        for (int i2 = 0; i2 < this.c; ++i2) {
            View view = recyclerView.getChildAt(i2);
            RecyclerView.j j2 = (RecyclerView.j)view.getLayoutParams();
            int n4 = view.getRight() + j2.rightMargin;
            int n5 = n4 + this.a.getIntrinsicWidth();
            this.a.setBounds(n4, n2, n5, n3);
            this.a.draw(canvas);
        }
        int n6 = recyclerView.getPaddingLeft();
        int n7 = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int n8 = recyclerView.getChildCount();
        int n9 = n8 % this.c;
        int n10 = n8 / this.c;
        int n11 = 0;
        if (n9 == 0) {
            --n10;
        }
        while (n11 < n10) {
            View view = recyclerView.getChildAt(n11 * this.c);
            RecyclerView.j j3 = (RecyclerView.j)view.getLayoutParams();
            int n12 = view.getBottom() + j3.bottomMargin;
            int n13 = n12 + this.b.getIntrinsicHeight();
            this.b.setBounds(n6, n12, n7, n13);
            this.b.draw(canvas);
            ++n11;
        }
    }
}

