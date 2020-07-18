/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.LinearLayout
 */
package com.xiaomi.midrop.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.xiaomi.midrop.util.ac;

public class MaxHeightLayout
extends LinearLayout {
    private int a;

    public MaxHeightLayout(Context context) {
        super(context);
        MaxHeightLayout.super.a();
    }

    public MaxHeightLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        MaxHeightLayout.super.a();
    }

    public MaxHeightLayout(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        MaxHeightLayout.super.a();
    }

    private void a() {
        this.a = (int)(0.7 * (double)ac.b((Context)this.getContext()).y);
    }

    protected void onMeasure(int n2, int n3) {
        int n4 = View.MeasureSpec.getMode((int)n3);
        int n5 = View.MeasureSpec.getSize((int)n3);
        if (n4 == Integer.MIN_VALUE && this.a > 0 && n5 >= this.a) {
            n3 = View.MeasureSpec.makeMeasureSpec((int)this.a, (int)Integer.MIN_VALUE);
        }
        super.onMeasure(n2, n3);
    }

    public void setMaxHeight(int n2) {
        this.a = n2;
        this.requestLayout();
    }
}

