/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.FrameLayout
 */
package com.xiaomi.midrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class RatioByWidthFrameLayout
extends FrameLayout {
    private float a = 1.0f;

    public RatioByWidthFrameLayout(Context context) {
        super(context);
    }

    public RatioByWidthFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RatioByWidthFrameLayout(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, View.MeasureSpec.makeMeasureSpec((int)((int)((float)(View.MeasureSpec.getSize((int)n2) - this.getPaddingStart() - this.getPaddingEnd()) * this.a)), (int)1073741824));
    }

    public void setRadio(float f2) {
        if (f2 > 0.0f) {
            this.a = f2;
            this.requestLayout();
        }
    }
}

