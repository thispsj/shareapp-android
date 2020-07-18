/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.util.AttributeSet
 *  android.view.View
 *  java.lang.Float
 *  java.lang.Object
 */
package com.xiaomi.midrop.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class WaveView
extends View {
    private float a;
    private boolean b;
    private Paint c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private ValueAnimator k;
    private ValueAnimator.AnimatorUpdateListener l;

    public WaveView(Context context) {
        super(context, null);
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public WaveView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.f = 255;
        this.g = 1200;
        this.h = 500;
        this.i = 3;
        this.j = 2200;
        this.l = new ValueAnimator.AnimatorUpdateListener(){

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WaveView.this.a = ((Float)valueAnimator.getAnimatedValue()).floatValue();
                if (WaveView.this.b) {
                    WaveView.this.a = 1.0f - WaveView.this.a;
                }
                WaveView.this.invalidate();
            }
        };
        this.d = this.getResources().getDimensionPixelSize(2131165730) / 2;
        this.e = this.getResources().getDimensionPixelSize(2131165731) / 2;
        this.c = new Paint(1);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(4.0f);
        this.k = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f});
        this.k.setDuration(2200L);
        this.k.setRepeatCount(-1);
    }

    public final void a() {
        if (this.k == null) {
            return;
        }
        if (this.k.isRunning()) {
            this.k.removeAllUpdateListeners();
            this.k.end();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = (float)this.getWidth() / 2.0f;
        float f3 = (float)this.getHeight() / 2.0f;
        for (int i2 = 0; i2 < 3; ++i2) {
            float f4 = 0.0f;
            if (i2 < 3) {
                float f5 = 2200.0f * this.a - (float)(i2 * 500);
                float f6 = f5 < 0.0f ? 0.0f : f5 / 1200.0f;
                f4 = f6 > 1.0f ? 0.0f : f6;
            }
            float f7 = f4 * (float)(this.d - this.e) + (float)this.e;
            float f8 = f4 <= 0.5f ? f4 * 2.0f : 2.0f * (1.0f - f4);
            int n2 = (int)(f8 * 255.0f);
            this.c.setAlpha(n2);
            canvas.drawCircle(f2, f3, f7, this.c);
        }
    }

    protected void onVisibilityChanged(View view, int n2) {
        super.onVisibilityChanged(view, n2);
    }

    public void setReverse(boolean bl) {
        this.b = bl;
    }

    public void setWaveColor(int n2) {
        this.c.setColor(n2);
    }

}

