/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.widget.AppCompatImageView
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 */
package com.xiaomi.midrop.view;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class AutoPressedStyleImageView
extends AppCompatImageView {
    public AutoPressedStyleImageView(Context context) {
        super(context);
    }

    public AutoPressedStyleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoPressedStyleImageView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        return super.onTouchEvent(motionEvent);
    }
}

