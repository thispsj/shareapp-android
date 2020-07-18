/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.xiaomi.midrop.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircleProgressBar
extends View {
    private boolean a;
    private boolean b;
    private int c;
    private int d;
    private double e;
    private double f;
    private double g;
    private double h;
    private int i;
    private int j;
    private int k;
    private RectF l;
    private a m;
    private a n;
    private Paint o;
    private Runnable p;

    public CircleProgressBar(Context context) {
        super(context, null);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = new Runnable(){

            public final void run() {
                CircleProgressBar.this.invalidate();
                CircleProgressBar.this.f = CircleProgressBar.this.f + CircleProgressBar.this.g;
                if (CircleProgressBar.this.f > CircleProgressBar.this.e) {
                    CircleProgressBar.this.f = CircleProgressBar.this.e;
                }
                CircleProgressBar.this.b();
            }
        };
        this.a = true;
        this.b = true;
        this.d = 100;
        this.o = new Paint();
        this.o.setAntiAlias(true);
        Context context2 = this.getContext();
        this.i = context2.getResources().getDimensionPixelOffset(2131165330);
        this.m = new a();
        this.m.d = context2.getResources().getColor(2131100039);
        this.n = new a();
        this.n.d = context2.getResources().getColor(2131099901);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a() {
        double d2;
        if (this.d > 0 && this.c > 0) {
            double d3 = this.c;
            if (this.c > this.d) {
                d3 = this.d;
            }
            this.e = 2.0 * (3.14 * (d3 / (double)this.d));
            this.g = (this.e - this.f) / 20.0;
            d2 = 360.0 * (d3 / (double)this.d);
        } else {
            this.e = d2 = 0.0;
        }
        this.h = d2;
    }

    private void b() {
        if (!(this.f >= this.e)) {
            if (!this.b) {
                return;
            }
            this.postDelayed(this.p, 48L);
        }
    }

    public int getMax() {
        return this.d;
    }

    protected void onDraw(Canvas canvas) {
        if (this.a) {
            this.o.setStyle(Paint.Style.STROKE);
            this.o.setStrokeWidth((float)this.i);
            a a2 = this.m;
            Paint paint = this.o;
            paint.setColor(a2.d);
            canvas.drawCircle((float)a2.a, (float)a2.b, (float)a2.c, paint);
        }
        if (this.b) {
            int n2 = this.n.a;
            int n3 = this.n.c;
            if (this.l == null) {
                this.l = new RectF();
            }
            RectF rectF = this.l;
            float f2 = n2 - n3;
            float f3 = n2 + n3;
            rectF.set(f2, f2, f3, f3);
            this.o.setStrokeWidth((float)this.i);
            this.o.setStyle(Paint.Style.STROKE);
            this.o.setColor(this.getContext().getResources().getColor(2131100072));
            a a3 = this.n;
            RectF rectF2 = this.l;
            float f4 = (float)this.h;
            Paint paint = this.o;
            paint.setColor(a3.d);
            canvas.drawArc(rectF2, 270.0f, f4, false, paint);
        }
    }

    protected void onMeasure(int n2, int n3) {
        int n4 = View.MeasureSpec.getMode((int)n2);
        int n5 = View.MeasureSpec.getMode((int)n3);
        int n6 = View.MeasureSpec.getSize((int)n2);
        int n7 = View.MeasureSpec.getSize((int)n3);
        int n8 = n4 != Integer.MIN_VALUE && n5 != Integer.MIN_VALUE ? Math.min((int)(n6 / 2), (int)(n7 / 2)) : this.getContext().getResources().getDimensionPixelOffset(2131165328);
        this.k = n8;
        this.j = 2 * this.k;
        int n9 = this.j / 2;
        int n10 = this.i;
        int n11 = this.j / 2 - n10;
        this.m.a = n9;
        this.m.b = n9;
        this.m.c = n11;
        this.n.a = n9;
        this.n.b = n9;
        this.n.c = n11;
        this.setMeasuredDimension(this.j, this.j);
    }

    public void setMax(int n2) {
        if (this.d == n2) {
            return;
        }
        this.d = n2;
        CircleProgressBar.super.a();
        this.invalidate();
    }

    public void setProgress(int n2) {
        if (this.c == n2) {
            return;
        }
        this.c = n2;
        CircleProgressBar.super.a();
        CircleProgressBar.super.b();
    }

    public void setProgressColor(int n2) {
        int n3 = this.getResources().getColor(n2);
        if (n3 == this.n.d) {
            return;
        }
        this.n.d = n3;
        this.invalidate();
    }

    public void setProgressWithoutAnimation(int n2) {
        if (this.c == n2) {
            return;
        }
        this.c = n2;
        CircleProgressBar.super.a();
        this.f = this.e;
        this.invalidate();
    }

    public void setRingOuterColor(int n2) {
        int n3 = this.getResources().getColor(n2);
        if (n3 == this.m.d) {
            return;
        }
        this.m.d = n3;
        this.invalidate();
    }

    public void setRingWidth(int n2) {
        this.i = n2;
    }

    static final class a {
        int a;
        int b;
        int c;
        int d;
    }

}

