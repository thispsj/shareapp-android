/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.support.v4.content.a
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$h
 *  android.support.v7.widget.RecyclerView$j
 *  android.support.v7.widget.RecyclerView$t
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package com.xiaomi.midrop.about;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.midrop.sender.c.c;
import com.xiaomi.midrop.util.ac;

public final class b
extends RecyclerView.h {
    private Drawable a;
    private Context b;

    public b(Context context) {
        this.b = context;
        this.a = a.a((Context)context, (int)2131230809);
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t t2) {
        super.a(rect, view, recyclerView, t2);
        rect.bottom = 1;
    }

    public final void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.t t2) {
        super.b(canvas, recyclerView, t2);
        int n2 = recyclerView.getPaddingLeft();
        int n3 = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int n4 = recyclerView.getChildCount();
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5;
            int n6;
            int n7;
            int n8;
            block3 : {
                block4 : {
                    block1 : {
                        block2 : {
                            View view = recyclerView.getChildAt(i2);
                            RecyclerView.j j2 = (RecyclerView.j)view.getLayoutParams();
                            n5 = view.getBottom() + j2.bottomMargin;
                            n8 = n5 + this.a.getIntrinsicHeight();
                            if (i2 == 0 || i2 == n4 - 1) break block1;
                            if (!ac.c(this.b)) break block2;
                            n6 = c.a(this.b, 24.0f);
                            n7 = 0;
                            break block3;
                        }
                        n7 = c.a(this.b, 24.0f);
                        break block4;
                    }
                    n7 = 0;
                }
                n6 = 0;
            }
            this.a.setBounds(n7 + n2, n5, n3 - n6, n8);
            this.a.draw(canvas);
        }
    }
}

