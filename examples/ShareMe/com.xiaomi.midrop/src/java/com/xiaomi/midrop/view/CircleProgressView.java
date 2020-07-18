/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.RectF
 *  android.graphics.Xfermode
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.widget.FrameLayout
 *  java.lang.Math
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.midrop.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

public class CircleProgressView
extends FrameLayout {
    private static String a = "CircleProgressView";
    private static int b = 100;
    private Paint c;
    private int d;
    private Drawable e;
    private Bitmap f;
    private Canvas g;
    private int h;
    private RectF i;
    private Context j;
    private int k;

    public CircleProgressView(Context context) {
        super(context, null);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.k = b;
        this.j = context;
        this.setBackgroundResource(2131230904);
        this.setProgressResource(2131230905);
        this.c = new Paint();
        this.c.setStyle(Paint.Style.FILL);
        this.c.setAntiAlias(true);
        this.c.setColor(0);
        this.c.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public int getMaxProgress() {
        return this.k;
    }

    public int getProgress() {
        return this.h;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.e != null) {
            this.f.eraseColor(0);
            this.e.draw(this.g);
            this.g.drawArc(this.i, (float)(270 - this.d), (float)this.d, true, this.c);
            canvas.drawBitmap(this.f, (float)((this.getWidth() - this.f.getWidth()) / 2), (float)((this.getHeight() - this.f.getHeight()) / 2), null);
        }
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        this.setMeasuredDimension(Math.max((int)this.getMeasuredWidth(), (int)this.getSuggestedMinimumWidth()), Math.max((int)this.getMeasuredHeight(), (int)this.getSuggestedMinimumHeight()));
    }

    public void setMaxProgress(int n2) {
        if (n2 > 0 && this.k != n2) {
            this.k = n2;
            this.setProgress(this.h);
        }
    }

    public void setProgress(int n2) {
        this.h = Math.min((int)n2, (int)this.k);
        this.h = Math.max((int)0, (int)this.h);
        int n3 = 360 * (this.k - this.h) / this.k;
        if (n3 != this.d) {
            String string2 = a;
            StringBuilder stringBuilder = new StringBuilder("progress:");
            stringBuilder.append(this.h);
            Log.i((String)string2, (String)stringBuilder.toString());
            this.d = n3;
            this.invalidate();
        }
    }

    public void setProgressResource(int n2) {
        this.e = this.j.getResources().getDrawable(n2);
        int n3 = this.e.getIntrinsicWidth();
        int n4 = this.e.getIntrinsicHeight();
        this.e.setBounds(0, 0, n3, n4);
        this.f = Bitmap.createBitmap((int)n3, (int)n4, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        this.g = new Canvas(this.f);
        this.i = new RectF(0.0f, 0.0f, (float)n3, (float)n4);
        this.requestLayout();
    }
}

