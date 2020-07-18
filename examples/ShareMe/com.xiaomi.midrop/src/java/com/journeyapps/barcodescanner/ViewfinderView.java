/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.View
 *  com.google.zxing.client.android.R
 *  com.google.zxing.client.android.R$color
 *  com.google.zxing.client.android.R$styleable
 *  com.google.zxing.s
 *  com.journeyapps.barcodescanner.ViewfinderView$1
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.client.android.R;
import com.google.zxing.s;
import com.journeyapps.barcodescanner.CameraPreview;
import com.journeyapps.barcodescanner.ViewfinderView;
import java.util.ArrayList;
import java.util.List;

public class ViewfinderView
extends View {
    protected static final String a = "ViewfinderView";
    protected static final int[] b = new int[]{0, 64, 128, 192, 255, 192, 128, 64};
    protected final Paint c = new Paint(1);
    protected Bitmap d;
    protected final int e;
    protected final int f;
    protected final int g;
    protected final int h;
    protected int i;
    protected List<s> j;
    protected List<s> k;
    protected CameraPreview l;
    protected Rect m;
    protected Rect n;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = this.getResources();
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_finder);
        this.e = typedArray.getColor(R.styleable.zxing_finder_zxing_viewfinder_mask, resources.getColor(R.color.zxing_viewfinder_mask));
        this.f = typedArray.getColor(R.styleable.zxing_finder_zxing_result_view, resources.getColor(R.color.zxing_result_view));
        this.g = typedArray.getColor(R.styleable.zxing_finder_zxing_viewfinder_laser, resources.getColor(R.color.zxing_viewfinder_laser));
        this.h = typedArray.getColor(R.styleable.zxing_finder_zxing_possible_result_points, resources.getColor(R.color.zxing_possible_result_points));
        typedArray.recycle();
        this.i = 0;
        this.j = new ArrayList(20);
        this.k = new ArrayList(20);
    }

    protected final void a() {
        if (this.l == null) {
            return;
        }
        Rect rect = this.l.getFramingRect();
        Rect rect2 = this.l.getPreviewFramingRect();
        if (rect != null && rect2 != null) {
            this.m = rect;
            this.n = rect2;
        }
    }

    public final void a(s s2) {
        if (this.j.size() < 20) {
            this.j.add((Object)s2);
        }
    }

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
            this.c.setAlpha(b[this.i]);
            this.i = (1 + this.i) % b.length;
            int n5 = rect.height() / 2 + rect.top;
            canvas.drawRect((float)(2 + rect.left), (float)(n5 - 1), (float)(-1 + rect.right), (float)(n5 + 2), this.c);
            float f3 = (float)rect.width() / (float)rect2.width();
            float f4 = (float)rect.height() / (float)rect2.height();
            int n6 = rect.left;
            int n7 = rect.top;
            if (!this.k.isEmpty()) {
                this.c.setAlpha(80);
                this.c.setColor(this.h);
                for (s s2 : this.k) {
                    canvas.drawCircle((float)(n6 + (int)(f3 * s2.a)), (float)(n7 + (int)(f4 * s2.b)), 3.0f, this.c);
                }
                this.k.clear();
            }
            if (!this.j.isEmpty()) {
                this.c.setAlpha(160);
                this.c.setColor(this.h);
                for (s s3 : this.j) {
                    canvas.drawCircle((float)(n6 + (int)(f3 * s3.a)), (float)(n7 + (int)(f4 * s3.b)), 6.0f, this.c);
                }
                List<s> list = this.j;
                this.j = this.k;
                this.k = list;
                this.j.clear();
            }
            this.postInvalidateDelayed(80L, -6 + rect.left, -6 + rect.top, 6 + rect.right, 6 + rect.bottom);
        }
    }

    public void setCameraPreview(CameraPreview cameraPreview) {
        this.l = cameraPreview;
        cameraPreview.a((CameraPreview.a)new 1((ViewfinderView)this));
    }
}

