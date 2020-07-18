/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.support.v4.view.ViewPager
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 */
package com.xiaomi.midrop.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.xiaomi.midrop.R;
import com.xiaomi.midrop.view.b;
import midrop.service.c.d;

public class ViewPager
extends android.support.v4.view.ViewPager {
    public ViewPager(Context context) {
        super(context, null);
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super((Context)new b(context), attributeSet);
        int n2 = context.getResources().getColor(2131099786);
        if (attributeSet != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.EdgeEffectView, 0, 0);
            n2 = typedArray.getColor(0, n2);
            typedArray.recycle();
        }
        this.setEdgeEffectColor(n2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            boolean bl = super.onInterceptTouchEvent(motionEvent);
            return bl;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            d.a("ViewPager", "onInterceptTouchEvent", illegalArgumentException, new Object[0]);
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            boolean bl = super.onTouchEvent(motionEvent);
            return bl;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            d.a("ViewPager", "onTouchEvent", illegalArgumentException, new Object[0]);
            return false;
        }
    }

    public void setEdgeEffectColor(int n2) {
        b b2 = (b)this.getContext();
        b2.a = n2;
        if (b2.b != null) {
            b2.b.setColorFilter(n2, PorterDuff.Mode.MULTIPLY);
        }
        if (b2.c != null) {
            b2.c.setColorFilter(n2, PorterDuff.Mode.MULTIPLY);
        }
    }
}

