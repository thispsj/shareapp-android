/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.FrameLayout
 */
package com.xiaomi.midrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.xiaomi.midrop.R;

public class RatioByHeightFrameLayout
extends FrameLayout {
    private float a = 1.0f;
    private int b = 0;

    public RatioByHeightFrameLayout(Context context) {
        super(context);
    }

    public RatioByHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!this.isInEditMode()) {
            RatioByHeightFrameLayout.super.a(context, attributeSet);
        }
    }

    public RatioByHeightFrameLayout(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        if (!this.isInEditMode()) {
            RatioByHeightFrameLayout.super.a(context, attributeSet);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.RatioByHeightFrameLayout);
            this.b = typedArray.getDimensionPixelSize(0, 0);
            typedArray.recycle();
        }
    }

    protected void onMeasure(int n2, int n3) {
        int n4 = View.MeasureSpec.getSize((int)n3) - this.getPaddingTop() - this.getPaddingBottom();
        if (this.b > 0 && n4 > this.b) {
            n4 = this.b;
            n3 = View.MeasureSpec.makeMeasureSpec((int)n4, (int)1073741824);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int)((int)((float)n4 * this.a)), (int)1073741824), n3);
    }

    public void setRatio(float f2) {
        if (f2 > 0.0f) {
            this.a = f2;
            this.requestLayout();
        }
    }
}

