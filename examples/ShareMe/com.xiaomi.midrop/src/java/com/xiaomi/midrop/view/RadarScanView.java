/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.SweepGradient
 *  android.support.v4.content.a
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.animation.LinearInterpolator
 *  java.lang.Integer
 *  java.lang.Object
 */
package com.xiaomi.midrop.view;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class RadarScanView
extends View {
    private float a;
    private float b;
    private float c;
    private float d;
    private Paint e = new Paint();
    private Paint f;
    private RectF g;
    private SweepGradient h;
    private int i;
    private int j;
    private float k;
    private float l;
    private int m;
    private int n;
    private ValueAnimator o;
    private int p;
    private int q;
    private int r;
    private ValueAnimator.AnimatorUpdateListener s = null;

    public RadarScanView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e.setColor(android.support.v4.content.a.c((Context)this.getContext(), (int)2131099929));
        this.e.setAntiAlias(true);
        this.e.setStrokeWidth(1.0f);
        this.e.setStyle(Paint.Style.STROKE);
        this.f = new Paint();
        this.f.setAntiAlias(true);
        this.f.setStyle(Paint.Style.FILL);
        this.g = new RectF();
        this.i = android.support.v4.content.a.c((Context)this.getContext(), (int)2131099931);
        this.j = android.support.v4.content.a.c((Context)this.getContext(), (int)2131099930);
        this.n = 180;
        this.m = 0;
        this.k = (float)this.m / 360.0f;
        this.l = (float)(this.m + this.n) / 360.0f;
        this.p = this.getResources().getDimensionPixelSize(2131165619);
    }

    static /* synthetic */ void a(RadarScanView radarScanView, int n2) {
        radarScanView.r = n2;
        radarScanView.invalidate();
    }

    private void c() {
        int[] arrn = new int[]{this.i, this.j};
        float[] arrf = new float[]{this.k, this.l};
        this.h = new SweepGradient(this.a, this.b, arrn, arrf);
        this.f.setShader((Shader)this.h);
    }

    public final void a() {
        if (this.o != null && this.o.isRunning()) {
            this.o.cancel();
        }
        this.o = new ValueAnimator();
        if (this.s == null) {
            this.s = new a(this, 0);
        }
        this.o.addUpdateListener(this.s);
        this.o.setIntValues(new int[]{0, 360});
        this.o.setDuration(2000L);
        this.o.setInterpolator((TimeInterpolator)new LinearInterpolator());
        this.o.setRepeatCount(-1);
        this.o.setRepeatMode(1);
        this.o.start();
    }

    public final void b() {
        if (this.o != null) {
            this.o.cancel();
            this.o.removeAllUpdateListeners();
            this.o = null;
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.o != null) {
            this.o.removeAllUpdateListeners();
            this.o.cancel();
            this.o = null;
        }
        this.s = null;
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawCircle(this.a, this.b, this.c, this.e);
        canvas.drawCircle(this.a, this.b, (float)this.p, this.e);
        canvas.drawCircle(this.a, this.b, (float)this.q, this.e);
        canvas.rotate((float)this.r, this.a, this.b);
        canvas.drawArc(this.g, (float)this.m, (float)this.n, true, this.f);
        canvas.restore();
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        float f2;
        this.d = 5.0f;
        this.a = f2 = (float)(n2 / 2);
        this.b = n3 / 2;
        this.c = f2 - this.d;
        this.g.left = this.a - this.c;
        this.g.right = this.a + this.c;
        this.g.top = this.b - this.c;
        this.g.bottom = this.b + this.c;
        RadarScanView.super.c();
        this.q = this.p + (int)(this.c - (float)this.p) / 2;
    }

    public void setGradientEndColor(int n2) {
        this.i = 16777215 & n2;
        this.j = n2 & 1308622847;
        RadarScanView.super.c();
    }

    private final class a
    implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ RadarScanView a;

        private a(RadarScanView radarScanView) {
            this.a = radarScanView;
        }

        /* synthetic */ a(RadarScanView radarScanView, byte by) {
            super(radarScanView);
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int n2 = (Integer)valueAnimator.getAnimatedValue();
            RadarScanView.a(this.a, n2);
        }
    }

}

