/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$h
 *  android.support.v7.widget.RecyclerView$i
 *  android.support.v7.widget.RecyclerView$t
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.Interpolator
 *  java.lang.Math
 */
package com.xiaomi.midrop.view.sendchooser;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

public final class b
extends RecyclerView.h {
    private static final float c = Resources.getSystem().getDisplayMetrics().density;
    private int a = -16737025;
    private int b = 855638016;
    private final int d = (int)(28.0f * c);
    private final float e = 5.3f * c;
    private final float f = 8.0f * c;
    private final Interpolator g = new AccelerateDecelerateInterpolator();
    private final Paint h = new Paint();
    private boolean i;

    public b(boolean bl) {
        this.i = bl;
        this.h.setStyle(Paint.Style.FILL);
        this.h.setAntiAlias(true);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.t t2) {
        int n2;
        float f2;
        float f3;
        float f4;
        block8 : {
            block7 : {
                float f5;
                float f6;
                int n3;
                block6 : {
                    super.a(canvas, recyclerView, t2);
                    int n4 = recyclerView.getAdapter().a();
                    float f7 = this.e * (float)n4;
                    int n5 = n4 - 1;
                    float f8 = f7 + (float)Math.max((int)0, (int)n5) * this.f;
                    f2 = ((float)recyclerView.getWidth() - f8) / 2.0f;
                    f4 = (float)recyclerView.getHeight() - (float)this.d / 2.0f;
                    this.h.setColor(this.b);
                    float f9 = this.e + this.f;
                    float f10 = f2;
                    for (int i2 = 0; i2 < n4; f10 += f9, ++i2) {
                        canvas.drawCircle(f10, f4, this.e / 2.0f, this.h);
                    }
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();
                    n3 = linearLayoutManager.k();
                    if (n3 == (n2 = -1)) {
                        return;
                    }
                    View view = linearLayoutManager.c(n3);
                    int n6 = view.getLeft();
                    int n7 = view.getWidth();
                    f5 = this.g.getInterpolation((float)(n6 * -1) / (float)n7);
                    if (this.i) {
                        f2 = (f8 + (float)recyclerView.getWidth()) / 2.0f - this.e;
                    }
                    this.h.setColor(this.a);
                    f6 = this.e + this.f;
                    if (f5 != 0.0f) break block6;
                    f3 = f6 * (float)n3;
                    if (!this.i) break block7;
                    break block8;
                }
                float f11 = f6 * (float)n3;
                int n8 = this.i ? -1 : 1;
                f2 += f11 * (float)n8;
                f3 = f5 * this.e + f5 * this.f;
                if (this.i) break block8;
            }
            n2 = 1;
        }
        canvas.drawCircle(f2 + f3 * (float)n2, f4, this.e / 2.0f, this.h);
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t t2) {
        super.a(rect, view, recyclerView, t2);
        rect.bottom = this.d;
    }
}

