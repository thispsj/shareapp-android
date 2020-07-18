/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.support.v4.content.a
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  java.lang.Object
 */
package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.R;

public class HorizontalProgressWheelView
extends View {
    private final Rect mCanvasClipBounds;
    private float mLastTouchedPosition;
    private int mMiddleLineColor;
    private int mProgressLineHeight;
    private int mProgressLineMargin;
    private Paint mProgressLinePaint;
    private int mProgressLineWidth;
    private boolean mScrollStarted;
    private ScrollingListener mScrollingListener;
    private float mTotalScrollDistance;

    public HorizontalProgressWheelView(Context context) {
        super(context, null);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.mCanvasClipBounds = new Rect();
        HorizontalProgressWheelView.super.init();
    }

    @TargetApi(value=21)
    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int n2, int n3) {
        super(context, attributeSet, n2, n3);
        this.mCanvasClipBounds = new Rect();
    }

    private void init() {
        this.mMiddleLineColor = a.c((Context)this.getContext(), (int)R.color.ucrop_color_progress_wheel_line);
        this.mProgressLineWidth = this.getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.mProgressLineHeight = this.getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.mProgressLineMargin = this.getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        this.mProgressLinePaint = new Paint(1);
        this.mProgressLinePaint.setStyle(Paint.Style.STROKE);
        this.mProgressLinePaint.setStrokeWidth((float)this.mProgressLineWidth);
    }

    private void onScrollEvent(MotionEvent motionEvent, float f2) {
        this.mTotalScrollDistance -= f2;
        this.postInvalidate();
        this.mLastTouchedPosition = motionEvent.getX();
        if (this.mScrollingListener != null) {
            this.mScrollingListener.onScroll(-f2, this.mTotalScrollDistance);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    protected void onDraw(Canvas var1) {
        super.onDraw(var1);
        var1.getClipBounds(this.mCanvasClipBounds);
        var3_2 = this.mCanvasClipBounds.width() / (this.mProgressLineWidth + this.mProgressLineMargin);
        var4_3 = this.mTotalScrollDistance % (float)(this.mProgressLineMargin + this.mProgressLineWidth);
        this.mProgressLinePaint.setColor(this.getResources().getColor(R.color.ucrop_color_progress_wheel_line));
        var5_4 = 0;
        do {
            block4 : {
                if (var5_4 >= var3_2) {
                    this.mProgressLinePaint.setColor(this.mMiddleLineColor);
                    var1.drawLine((float)this.mCanvasClipBounds.centerX(), (float)this.mCanvasClipBounds.centerY() - (float)this.mProgressLineHeight / 2.0f, (float)this.mCanvasClipBounds.centerX(), (float)this.mCanvasClipBounds.centerY() + (float)this.mProgressLineHeight / 2.0f, this.mProgressLinePaint);
                    return;
                }
                var6_8 = var3_2 / 4;
                if (var5_4 >= var6_8) break block4;
                var8_5 = this.mProgressLinePaint;
                var9_6 = var5_4;
                ** GOTO lbl21
            }
            if (var5_4 > var3_2 * 3 / 4) {
                var8_5 = this.mProgressLinePaint;
                var9_6 = var3_2 - var5_4;
lbl21: // 2 sources:
                var8_5.setAlpha((int)(255.0f * (var9_6 / (float)var6_8)));
            } else {
                this.mProgressLinePaint.setAlpha(255);
            }
            var7_7 = -var4_3;
            var1.drawLine(var7_7 + (float)this.mCanvasClipBounds.left + (float)(var5_4 * (this.mProgressLineWidth + this.mProgressLineMargin)), (float)this.mCanvasClipBounds.centerY() - (float)this.mProgressLineHeight / 4.0f, var7_7 + (float)this.mCanvasClipBounds.left + (float)(var5_4 * (this.mProgressLineWidth + this.mProgressLineMargin)), (float)this.mCanvasClipBounds.centerY() + (float)this.mProgressLineHeight / 4.0f, this.mProgressLinePaint);
            ++var5_4;
        } while (true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            default: {
                return true;
            }
            case 2: {
                float f2 = motionEvent.getX() - this.mLastTouchedPosition;
                if (f2 == 0.0f) break;
                if (!this.mScrollStarted) {
                    this.mScrollStarted = true;
                    if (this.mScrollingListener != null) {
                        this.mScrollingListener.onScrollStart();
                    }
                }
                HorizontalProgressWheelView.super.onScrollEvent(motionEvent, f2);
                return true;
            }
            case 1: {
                if (this.mScrollingListener == null) break;
                this.mScrollStarted = false;
                this.mScrollingListener.onScrollEnd();
                return true;
            }
            case 0: {
                this.mLastTouchedPosition = motionEvent.getX();
            }
        }
        return true;
    }

    public void setMiddleLineColor(int n2) {
        this.mMiddleLineColor = n2;
        this.invalidate();
    }

    public void setScrollingListener(ScrollingListener scrollingListener) {
        this.mScrollingListener = scrollingListener;
    }

    public static interface ScrollingListener {
        public void onScroll(float var1, float var2);

        public void onScrollEnd();

        public void onScrollStart();
    }

}

