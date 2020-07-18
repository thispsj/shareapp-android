/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.LinearLayout
 *  java.lang.Math
 */
package com.xiaomi.miftp.view.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.xiaomi.miftp.R;

public class DialogParentPanel
extends LinearLayout {
    private TypedValue a;
    private TypedValue b;
    private TypedValue c;
    private TypedValue d;
    private TypedValue e;
    private TypedValue f;
    private TypedValue g;
    private TypedValue h;

    public DialogParentPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.Window);
        if (typedArray.hasValue(R.styleable.Window_windowFixedWidthMinor_midrop)) {
            this.a = new TypedValue();
            typedArray.getValue(R.styleable.Window_windowFixedWidthMinor_midrop, this.a);
        }
        if (typedArray.hasValue(R.styleable.Window_windowFixedHeightMajor_midrop)) {
            this.b = new TypedValue();
            typedArray.getValue(R.styleable.Window_windowFixedHeightMajor_midrop, this.b);
        }
        if (typedArray.hasValue(R.styleable.Window_windowFixedWidthMajor_midrop)) {
            this.c = new TypedValue();
            typedArray.getValue(R.styleable.Window_windowFixedWidthMajor_midrop, this.c);
        }
        if (typedArray.hasValue(R.styleable.Window_windowFixedHeightMinor_midrop)) {
            this.d = new TypedValue();
            typedArray.getValue(R.styleable.Window_windowFixedHeightMinor_midrop, this.d);
        }
        if (typedArray.hasValue(R.styleable.Window_windowMaxWidthMinor)) {
            this.e = new TypedValue();
            typedArray.getValue(R.styleable.Window_windowMaxWidthMinor, this.e);
        }
        if (typedArray.hasValue(R.styleable.Window_windowMaxWidthMajor)) {
            this.f = new TypedValue();
            typedArray.getValue(R.styleable.Window_windowMaxWidthMajor, this.f);
        }
        if (typedArray.hasValue(R.styleable.Window_windowMaxHeightMajor)) {
            this.h = new TypedValue();
            typedArray.getValue(R.styleable.Window_windowMaxHeightMajor, this.h);
        }
        if (typedArray.hasValue(R.styleable.Window_windowMaxHeightMinor)) {
            this.g = new TypedValue();
            typedArray.getValue(R.styleable.Window_windowMaxHeightMinor, this.g);
        }
        typedArray.recycle();
    }

    private int a(int n2, boolean bl, TypedValue typedValue, TypedValue typedValue2, TypedValue typedValue3, TypedValue typedValue4) {
        if (View.MeasureSpec.getMode((int)n2) == Integer.MIN_VALUE) {
            DisplayMetrics displayMetrics = this.getContext().getResources().getDisplayMetrics();
            boolean bl2 = displayMetrics.widthPixels < displayMetrics.heightPixels;
            if (!bl2) {
                typedValue = typedValue2;
            }
            int n3 = DialogParentPanel.a(displayMetrics, typedValue, bl);
            if (n3 > 0) {
                return View.MeasureSpec.makeMeasureSpec((int)n3, (int)1073741824);
            }
            if (!bl2) {
                typedValue3 = typedValue4;
            }
            int n4 = DialogParentPanel.a(displayMetrics, typedValue3, bl);
            if (n4 > 0) {
                n2 = View.MeasureSpec.makeMeasureSpec((int)Math.min((int)n4, (int)View.MeasureSpec.getSize((int)n2)), (int)Integer.MIN_VALUE);
            }
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int a(DisplayMetrics displayMetrics, TypedValue typedValue, boolean bl) {
        float f2;
        if (typedValue == null) return 0;
        if (typedValue.type == 5) {
            f2 = typedValue.getDimension(displayMetrics);
            return (int)f2;
        }
        if (typedValue.type != 6) return 0;
        int n2 = bl ? displayMetrics.widthPixels : displayMetrics.heightPixels;
        float f3 = n2;
        f2 = typedValue.getFraction(f3, f3);
        return (int)f2;
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(DialogParentPanel.super.a(n2, true, this.a, this.c, this.e, this.f), DialogParentPanel.super.a(n3, false, this.d, this.b, this.g, this.h));
    }
}

