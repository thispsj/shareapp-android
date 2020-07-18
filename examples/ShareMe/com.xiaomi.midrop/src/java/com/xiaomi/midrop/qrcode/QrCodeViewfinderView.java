/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  com.google.zxing.s
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.qrcode;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.google.zxing.s;
import com.journeyapps.barcodescanner.ViewfinderView;
import com.xiaomi.midrop.qrcode.QrCodeViewfinderView;
import java.util.List;

public class QrCodeViewfinderView
extends ViewfinderView {
    protected static final String o = "QrCodeViewfinderView";
    private int p;
    private ValueAnimator q;

    public QrCodeViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static /* synthetic */ void a(QrCodeViewfinderView qrCodeViewfinderView, float f2) {
        qrCodeViewfinderView.setAnimatorValue(f2);
    }

    private void setAnimatorValue(float f2) {
        if (this.m == null) {
            return;
        }
        this.p = (int)((float)this.m.top + f2 * (float)(this.m.bottom - this.m.top));
        this.invalidate();
    }

    public final void b() {
        this.c();
        this.q = new ValueAnimator();
        this.q.setFloatValues(new float[]{0.0f, 1.0f});
        this.q.setDuration(2000L);
        this.q.setRepeatCount(-1);
        this.q.setRepeatMode(2);
        this.q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this){
            final /* synthetic */ QrCodeViewfinderView a;
            {
                this.a = qrCodeViewfinderView;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f2 = ((java.lang.Float)valueAnimator.getAnimatedValue()).floatValue();
                QrCodeViewfinderView.a(this.a, f2);
            }
        });
        this.q.start();
    }

    public final void c() {
        if (this.q != null) {
            this.q.end();
            this.q = null;
        }
    }

    @Override
    public void onDraw(Canvas canvas) {
        this.a();
        if (this.m != null) {
            if (this.n == null) {
                return;
            }
            Rect rect = this.m;
            Rect rect2 = this.n;
            int n2 = canvas.getWidth();
            int n3 = canvas.getHeight();
            Paint paint = this.c;
            int n4 = this.d != null ? this.f : this.e;
            paint.setColor(n4);
            float f2 = n2;
            canvas.drawRect(0.0f, 0.0f, f2, (float)rect.top, this.c);
            canvas.drawRect(0.0f, (float)rect.top, (float)rect.left, (float)(1 + rect.bottom), this.c);
            canvas.drawRect((float)(1 + rect.right), (float)rect.top, f2, (float)(1 + rect.bottom), this.c);
            canvas.drawRect(0.0f, (float)(1 + rect.bottom), f2, (float)n3, this.c);
            if (this.d != null) {
                this.c.setAlpha(160);
                canvas.drawBitmap(this.d, null, rect, this.c);
                return;
            }
            this.c.setColor(this.g);
            canvas.drawRect((float)(1 + rect.left), (float)this.p, (float)(-1 + rect.right), (float)(3 + this.p), this.c);
            float f3 = (float)rect.width() / (float)rect2.width();
            float f4 = (float)rect.height() / (float)rect2.height();
            int n5 = rect.left;
            int n6 = rect.top;
            if (!this.k.isEmpty()) {
                this.c.setAlpha(80);
                this.c.setColor(this.h);
                for (s s2 : this.k) {
                    canvas.drawCircle((float)(n5 + (int)(f3 * s2.a)), (float)(n6 + (int)(f4 * s2.b)), 3.0f, this.c);
                }
                this.k.clear();
            }
            if (!this.j.isEmpty()) {
                this.c.setAlpha(160);
                this.c.setColor(this.h);
                for (s s3 : this.j) {
                    canvas.drawCircle((float)(n5 + (int)(f3 * s3.a)), (float)(n6 + (int)(f4 * s3.b)), 6.0f, this.c);
                }
                List list = this.j;
                this.j = this.k;
                this.k = list;
                this.j.clear();
            }
        }
    }
}

