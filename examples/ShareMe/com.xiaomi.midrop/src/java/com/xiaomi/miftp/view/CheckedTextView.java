/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.NinePatchDrawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.CheckedTextView
 */
package com.xiaomi.miftp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.miftp.c.h;

public class CheckedTextView
extends android.widget.CheckedTextView {
    private static final int[] a = new int[]{16842912};
    private Drawable b;

    public CheckedTextView(Context context) {
        super(context, null);
    }

    public CheckedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16843720);
    }

    public CheckedTextView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    private int getCheckWidth() {
        Drawable drawable2 = this.getCheckMarkDrawable();
        if (drawable2 == null) {
            return 0;
        }
        return drawable2.getCurrent().getIntrinsicWidth();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            int[] arrn = this.getDrawableState();
            this.b.setState(arrn);
            this.invalidate();
        }
    }

    public Drawable getCheckMarkDrawable() {
        return this.b;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.b != null) {
            this.b.jumpToCurrentState();
        }
    }

    protected int[] onCreateDrawableState(int n2) {
        int[] arrn = super.onCreateDrawableState(n2 + 1);
        if (this.isChecked()) {
            CheckedTextView.mergeDrawableStates((int[])arrn, (int[])a);
        }
        return arrn;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected void onDraw(Canvas canvas) {
        int n2;
        Drawable drawable2 = this.getCheckMarkDrawable();
        if (drawable2 != null) {
            int n3 = drawable2.getCurrent().getIntrinsicWidth();
            int n4 = h.a((View)this) ? this.getWidth() - this.getPaddingRight() - n3 : this.getPaddingLeft();
            int n5 = n4 + this.getScrollX();
            int n6 = this.getPaddingTop();
            int n7 = drawable2.getIntrinsicHeight();
            if (drawable2.getCurrent() instanceof NinePatchDrawable) {
                n7 = this.getHeight() - n6 - this.getPaddingBottom();
            } else {
                int n8 = 112 & this.getGravity();
                if (n8 != 16) {
                    if (n8 == 80) {
                        n6 = this.getHeight() - n7;
                    }
                } else {
                    n6 = (this.getHeight() - n7) / 2;
                }
            }
            drawable2.setBounds(n5, n6, n3 + n5, n7 + n6);
            drawable2.draw(canvas);
        }
        if ((n2 = CheckedTextView.super.getCheckWidth()) == 0) {
            super.onDraw(canvas);
            return;
        }
        int n9 = n2 + 0;
        if (h.a((View)this)) {
            n9 = -n9;
        }
        canvas.translate((float)n9, 0.0f);
        super.onDraw(canvas);
        canvas.translate((float)(-n9), 0.0f);
    }

    protected void onMeasure(int n2, int n3) {
        int n4;
        super.onMeasure(n2, n3);
        int n5 = CheckedTextView.super.getCheckWidth();
        if (n5 == 0) {
            return;
        }
        int n6 = View.MeasureSpec.getMode((int)n2);
        if (n6 == 1073741824) {
            return;
        }
        int n7 = n5 + this.getMeasuredWidth();
        if (n6 != Integer.MIN_VALUE || n7 <= (n4 = View.MeasureSpec.getSize((int)n2))) {
            n4 = n7;
        }
        this.setMeasuredDimension(n4, this.getMeasuredHeight());
    }

    public void setCheckMarkDrawable(Drawable drawable2) {
        if (this.b != null) {
            this.b.setCallback(null);
            this.unscheduleDrawable(this.b);
        }
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback)this);
            boolean bl = this.getVisibility() == 0;
            drawable2.setVisible(bl, false);
            drawable2.setState(a);
            this.setMinHeight(drawable2.getIntrinsicHeight());
            drawable2.setState(this.getDrawableState());
        }
        this.b = drawable2;
    }

    protected boolean verifyDrawable(Drawable drawable2) {
        return super.verifyDrawable(drawable2) || drawable2 == this.b;
        {
        }
    }
}

