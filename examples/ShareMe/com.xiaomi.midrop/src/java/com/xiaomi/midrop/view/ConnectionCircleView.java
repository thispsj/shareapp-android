/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.support.v4.content.a
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.animation.LinearInterpolator
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 */
package com.xiaomi.midrop.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class ConnectionCircleView
extends View {
    private Paint A;
    private ValueAnimator B;
    private float C;
    private float D;
    private float E;
    public RectF a;
    ValueAnimator b;
    public ValueAnimator c;
    public int d = 0;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private Paint o;
    private Paint p;
    private RectF q;
    private int r;
    private ValueAnimator s;
    private RectF t;
    private RectF u;
    private RectF v;
    private RectF w;
    private RectF x;
    private Paint y;
    private Paint z;

    public ConnectionCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = this.getResources().getDimensionPixelSize(2131165355);
        this.n = this.getResources().getDimensionPixelSize(2131165353);
        this.e = this.getResources().getDimensionPixelSize(2131165616) / 2;
        this.f = this.getResources().getDimensionPixelSize(2131165615) / 2;
        this.o = new Paint();
        this.o.setAntiAlias(true);
        this.o.setStrokeWidth((float)this.m);
        this.o.setStyle(Paint.Style.STROKE);
        this.p = new Paint();
        this.p.setAntiAlias(true);
        this.p.setStrokeWidth((float)this.m);
        this.p.setStyle(Paint.Style.STROKE);
        this.p.setColor(a.c((Context)this.getContext(), (int)2131099928));
        this.y = new Paint();
        this.y.setAntiAlias(true);
        this.y.setStrokeWidth((float)this.m);
        this.y.setStyle(Paint.Style.STROKE);
        this.y.setColor(a.c((Context)this.getContext(), (int)2131099783));
        this.z = new Paint(this.y);
        this.z.setColor(1728053247 & this.z.getColor());
        this.A = new Paint(this.p);
        this.A.setColor(a.c((Context)this.getContext(), (int)2131099784));
        this.q = new RectF();
        this.a = new RectF();
        this.t = new RectF();
        this.u = new RectF();
        this.v = new RectF();
        this.w = new RectF();
        this.x = new RectF();
    }

    private int a(Canvas canvas, int n2, int n3, int n4, float f2) {
        int n5 = n4 - n3;
        float f3 = n5;
        int n6 = n2 + (int)(f2 * f3);
        if (n6 >= n4) {
            n6 = n3 - n5 * 2 / 10;
        }
        if (n6 <= n3) {
            return n6;
        }
        float f4 = (float)(n4 - n6) / f3;
        this.y.setAlpha((int)(f4 * 255.0f));
        canvas.drawCircle((float)this.j, (float)this.k, (float)n6, this.y);
        return n6;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Canvas canvas, RectF rectF, RectF rectF2, Paint paint, int n2, int n3, int n4, int n5, int n6) {
        int n7;
        int n8;
        int n9 = n2 + (n3 - n2) / 2;
        int n10 = n9 - n2;
        canvas.save();
        if (n6 <= n9) {
            int n11 = n6 - n2;
            n7 = n4 * n11 / n10;
            n8 = n5 * n11;
        } else {
            int n12 = n3 - n6;
            n7 = n4 * n12 / n10;
            n8 = n5 * n12;
        }
        int n13 = n8 / n10;
        float f2 = rectF2.left;
        float f3 = n7;
        rectF.left = f2 - f3;
        rectF.right = f3 + rectF2.right;
        float f4 = rectF2.top;
        float f5 = n13;
        rectF.top = f4 - f5;
        rectF.bottom = f5 + rectF2.bottom;
        canvas.rotate((float)n6, (float)this.j, (float)this.k);
        canvas.drawOval(rectF, paint);
        canvas.restore();
    }

    private void setWaveAnimateValue(float f2) {
        this.E = Math.abs((float)(this.D - f2));
        this.D = f2;
        this.invalidate();
    }

    public final void a() {
        this.d = 0;
        if (this.s != null) {
            this.s.cancel();
            this.s = null;
        }
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
        if (this.B != null) {
            this.B.cancel();
            this.B = null;
        }
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
        this.invalidate();
    }

    public final void a(int n2, final int n3, long l2) {
        this.a();
        this.d = 1;
        this.s = new ValueAnimator();
        this.s.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int n2 = (Integer)valueAnimator.getAnimatedValue();
                ConnectionCircleView.this.setSweepAngle(n2);
            }
        });
        this.s.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public final void onAnimationEnd(Animator animator) {
                if (n3 == 360) {
                    ConnectionCircleView connectionCircleView = ConnectionCircleView.this;
                    connectionCircleView.a();
                    connectionCircleView.d = 2;
                    connectionCircleView.b = new ValueAnimator();
                    connectionCircleView.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float f2 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
                            ConnectionCircleView.this.setRotateDegree(f2);
                        }
                    });
                    connectionCircleView.b.setFloatValues(new float[]{0.0f, 1.0f});
                    connectionCircleView.b.setDuration(4000L);
                    connectionCircleView.b.setInterpolator((TimeInterpolator)new LinearInterpolator());
                    connectionCircleView.b.setRepeatCount(-1);
                    connectionCircleView.b.setRepeatMode(1);
                    connectionCircleView.b.start();
                }
            }
        });
        this.s.setIntValues(new int[]{n2, n3});
        this.s.setDuration(l2);
        this.s.setInterpolator((TimeInterpolator)new LinearInterpolator());
        this.s.start();
    }

    public int getSweepAngle() {
        return this.r;
    }

    protected void onDraw(Canvas canvas) {
        if (this.d == 2) {
            int n2 = 0 + (int)(180.0f * this.C);
            ConnectionCircleView.super.a(canvas, this.a, this.v, this.y, 0, 180, 8 * this.n / 10, 4 * this.n / 10, n2);
            int n3 = 60 + (int)(240.0f * this.C);
            ConnectionCircleView.super.a(canvas, this.t, this.w, this.z, 60, 300, 9 * this.n / 10, 9 * this.n / 10, n3);
            int n4 = 0 + (int)(180.0f * this.C);
            ConnectionCircleView.super.a(canvas, this.u, this.x, this.A, 0, 180, 4 * this.n / 10, 8 * this.n / 10, n4);
            return;
        }
        if (this.d == 3) {
            int n5 = 0 + (int)(180.0f * this.C);
            ConnectionCircleView.super.a(canvas, this.a, this.v, this.y, 0, 180, this.n, this.n, n5);
            return;
        }
        if (this.d == 4) {
            int n6 = this.f;
            int n7 = this.e;
            this.g = ConnectionCircleView.super.a(canvas, this.g, n6, n7, this.E);
            this.h = ConnectionCircleView.super.a(canvas, this.h, n6, n7, this.E);
            this.i = ConnectionCircleView.super.a(canvas, this.i, n6, n7, this.E);
            return;
        }
        canvas.drawCircle((float)this.j, (float)this.k, (float)this.l, this.p);
        canvas.drawArc(this.q, 270.0f, (float)this.r, false, this.o);
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        int n6;
        this.j = n6 = n2 / 2;
        this.k = n3 / 2;
        int n7 = this.m + this.n;
        this.l = n6 - n7;
        RectF rectF = this.q;
        float f2 = n7;
        float f3 = n2 - n7;
        float f4 = n3 - n7;
        rectF.set(f2, f2, f3, f4);
        this.a.set(f2, f2, f3, f4);
        this.v.set(this.a);
        this.t.set(this.a);
        this.w.set(this.t);
        this.u.set(this.a);
        this.x.set(this.u);
    }

    public void setCircleColor(int n2) {
        this.o.setColor(n2);
        this.y.setColor(n2);
        this.z.setColor(n2 & 1728053247);
    }

    public void setPadding(int n2) {
        this.n = n2;
    }

    public void setRotateDegree(float f2) {
        this.C = f2;
        this.invalidate();
    }

    public void setSweepAngle(int n2) {
        this.r = n2;
        this.invalidate();
    }

}

