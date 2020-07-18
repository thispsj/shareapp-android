/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.StateListDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.TextView
 *  java.lang.Math
 */
package com.xiaomi.midrop.view.tablayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.midrop.R;

public class MsgView
extends TextView {
    private Context a;
    private GradientDrawable b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;

    public MsgView(Context context) {
        super(context, null);
    }

    public MsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public MsgView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.b = new GradientDrawable();
        this.a = context;
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MsgView);
        this.c = typedArray.getColor(0, 0);
        this.d = typedArray.getDimensionPixelSize(1, 0);
        this.e = typedArray.getDimensionPixelSize(5, 0);
        this.f = typedArray.getColor(4, 0);
        this.g = typedArray.getBoolean(2, false);
        this.h = typedArray.getBoolean(3, false);
        typedArray.recycle();
    }

    private int a(float f2) {
        return (int)(0.5f + f2 * this.a.getResources().getDisplayMetrics().density);
    }

    private void a() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = this.b;
        int n2 = this.c;
        int n3 = this.f;
        gradientDrawable.setColor(n2);
        gradientDrawable.setCornerRadius((float)this.d);
        gradientDrawable.setStroke(this.e, n3);
        stateListDrawable.addState(new int[]{-16842919}, (Drawable)this.b);
        if (Build.VERSION.SDK_INT >= 16) {
            this.setBackground((Drawable)stateListDrawable);
            return;
        }
        this.setBackgroundDrawable((Drawable)stateListDrawable);
    }

    public int getBackgroundColor() {
        return this.c;
    }

    public int getCornerRadius() {
        return this.d;
    }

    public int getStrokeColor() {
        return this.f;
    }

    public int getStrokeWidth() {
        return this.e;
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        super.onLayout(bl, n2, n3, n4, n5);
        if (this.g) {
            this.setCornerRadius(this.getHeight() / 2);
            return;
        }
        this.a();
    }

    protected void onMeasure(int n2, int n3) {
        if (this.h && this.getWidth() > 0 && this.getHeight() > 0) {
            int n4 = View.MeasureSpec.makeMeasureSpec((int)Math.max((int)this.getWidth(), (int)this.getHeight()), (int)1073741824);
            super.onMeasure(n4, n4);
            return;
        }
        super.onMeasure(n2, n3);
    }

    public void setBackgroundColor(int n2) {
        this.c = n2;
        MsgView.super.a();
    }

    public void setCornerRadius(int n2) {
        this.d = MsgView.super.a(n2);
        MsgView.super.a();
    }

    public void setIsRadiusHalfHeight(boolean bl) {
        this.g = bl;
        MsgView.super.a();
    }

    public void setIsWidthHeightEqual(boolean bl) {
        this.h = bl;
        MsgView.super.a();
    }

    public void setStrokeColor(int n2) {
        this.f = n2;
        MsgView.super.a();
    }

    public void setStrokeWidth(int n2) {
        this.e = MsgView.super.a(n2);
        MsgView.super.a();
    }
}

