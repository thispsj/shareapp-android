/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.support.v4.content.a
 *  android.support.v7.widget.AppCompatTextView
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.a;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.Locale;

public class AspectRatioTextView
extends AppCompatTextView {
    private float mAspectRatio;
    private String mAspectRatioTitle;
    private float mAspectRatioX;
    private float mAspectRatioY;
    private final Rect mCanvasClipBounds;
    private Paint mDotPaint;
    private int mDotSize;

    public AspectRatioTextView(Context context) {
        super(context, null);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.mCanvasClipBounds = new Rect();
        AspectRatioTextView.super.init(context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_AspectRatioTextView));
    }

    @TargetApi(value=21)
    public AspectRatioTextView(Context context, AttributeSet attributeSet, int n2, int n3) {
        super(context, attributeSet, n2);
        this.mCanvasClipBounds = new Rect();
        AspectRatioTextView.super.init(context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_AspectRatioTextView));
    }

    private void applyActiveColor(int n2) {
        if (this.mDotPaint != null) {
            this.mDotPaint.setColor(n2);
        }
        int[][] arrarrn = new int[][]{{16842913}, {0}};
        int[] arrn = new int[]{n2, a.c((Context)this.getContext(), (int)R.color.ucrop_color_widget)};
        this.setTextColor(new ColorStateList((int[][])arrarrn, arrn));
    }

    private void init(TypedArray typedArray) {
        this.setGravity(1);
        this.mAspectRatioTitle = typedArray.getString(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
        this.mAspectRatioX = typedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0f);
        this.mAspectRatioY = typedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0f);
        this.mAspectRatio = this.mAspectRatioX != 0.0f && this.mAspectRatioY != 0.0f ? this.mAspectRatioX / this.mAspectRatioY : 0.0f;
        this.mDotSize = this.getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_size_dot_scale_text_view);
        this.mDotPaint = new Paint(1);
        this.mDotPaint.setStyle(Paint.Style.FILL);
        AspectRatioTextView.super.setTitle();
        AspectRatioTextView.super.applyActiveColor(this.getResources().getColor(R.color.ucrop_color_widget_active));
        typedArray.recycle();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void setTitle() {
        String string2;
        if (!TextUtils.isEmpty((CharSequence)this.mAspectRatioTitle)) {
            string2 = this.mAspectRatioTitle;
        } else {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{(int)this.mAspectRatioX, (int)this.mAspectRatioY};
            string2 = String.format((Locale)locale, (String)"%d:%d", (Object[])arrobject);
        }
        this.setText((CharSequence)string2);
    }

    private void toggleAspectRatio() {
        if (this.mAspectRatio != 0.0f) {
            float f2 = this.mAspectRatioX;
            this.mAspectRatioX = this.mAspectRatioY;
            this.mAspectRatioY = f2;
            this.mAspectRatio = this.mAspectRatioX / this.mAspectRatioY;
        }
    }

    public float getAspectRatio(boolean bl) {
        if (bl) {
            AspectRatioTextView.super.toggleAspectRatio();
            AspectRatioTextView.super.setTitle();
        }
        return this.mAspectRatio;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.isSelected()) {
            canvas.getClipBounds(this.mCanvasClipBounds);
            canvas.drawCircle((float)(this.mCanvasClipBounds.right - this.mCanvasClipBounds.left) / 2.0f, (float)(this.mCanvasClipBounds.bottom - this.mDotSize), (float)(this.mDotSize / 2), this.mDotPaint);
        }
    }

    public void setActiveColor(int n2) {
        AspectRatioTextView.super.applyActiveColor(n2);
        this.invalidate();
    }

    public void setAspectRatio(AspectRatio aspectRatio) {
        this.mAspectRatioTitle = aspectRatio.getAspectRatioTitle();
        this.mAspectRatioX = aspectRatio.getAspectRatioX();
        this.mAspectRatioY = aspectRatio.getAspectRatioY();
        this.mAspectRatio = this.mAspectRatioX != 0.0f && this.mAspectRatioY != 0.0f ? this.mAspectRatioX / this.mAspectRatioY : 0.0f;
        AspectRatioTextView.super.setTitle();
    }
}

