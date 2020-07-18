/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.xiaomi.midrop.view.ViewPager;
import midrop.service.c.d;

public class ScrollUnableViewPager
extends ViewPager {
    private static String d = "ScrollUnableViewPager";

    public ScrollUnableViewPager(Context context) {
        super(context);
    }

    public ScrollUnableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean canScrollHorizontally(int n2) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            boolean bl = super.onTouchEvent(motionEvent);
            return bl;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            d.a(d, "Viewpager onTouchEvent", illegalArgumentException, new Object[0]);
            return false;
        }
    }
}

