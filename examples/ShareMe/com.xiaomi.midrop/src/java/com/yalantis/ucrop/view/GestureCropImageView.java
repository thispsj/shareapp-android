/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.util.AttributeSet
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  android.view.ScaleGestureDetector$SimpleOnScaleGestureListener
 *  java.lang.Math
 */
package com.yalantis.ucrop.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.yalantis.ucrop.util.RotationGestureDetector;
import com.yalantis.ucrop.view.CropImageView;
import com.yalantis.ucrop.view.GestureCropImageView;

public class GestureCropImageView
extends CropImageView {
    private static final int DOUBLE_TAP_ZOOM_DURATION = 200;
    private int mDoubleTapScaleSteps;
    private GestureDetector mGestureDetector;
    private boolean mIsRotateEnabled;
    private boolean mIsScaleEnabled;
    private float mMidPntX;
    private float mMidPntY;
    private RotationGestureDetector mRotateDetector;
    private ScaleGestureDetector mScaleDetector;

    public GestureCropImageView(Context context) {
        super(context);
        this.mIsRotateEnabled = true;
        this.mIsScaleEnabled = true;
        this.mDoubleTapScaleSteps = 5;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.mIsRotateEnabled = true;
        this.mIsScaleEnabled = true;
        this.mDoubleTapScaleSteps = 5;
    }

    private void setupGestureListeners() {
        this.mGestureDetector = new GestureDetector(this.getContext(), (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this, null){
            final /* synthetic */ GestureCropImageView this$0;
            {
                this.this$0 = gestureCropImageView;
            }

            public boolean onDoubleTap(MotionEvent motionEvent) {
                this.this$0.zoomImageToPosition(this.this$0.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200L);
                return super.onDoubleTap(motionEvent);
            }

            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                this.this$0.postTranslate(-f2, -f3);
                return true;
            }
        }, null, true);
        this.mScaleDetector = new ScaleGestureDetector(this.getContext(), (ScaleGestureDetector.OnScaleGestureListener)new ScaleGestureDetector.SimpleOnScaleGestureListener(this, null){
            final /* synthetic */ GestureCropImageView this$0;
            {
                this.this$0 = gestureCropImageView;
            }

            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                this.this$0.postScale(scaleGestureDetector.getScaleFactor(), this.this$0.mMidPntX, this.this$0.mMidPntY);
                return true;
            }
        });
        this.mRotateDetector = new RotationGestureDetector(new RotateListener(this, null));
    }

    public int getDoubleTapScaleSteps() {
        return this.mDoubleTapScaleSteps;
    }

    protected float getDoubleTapTargetScale() {
        return this.getCurrentScale() * (float)Math.pow((double)(this.getMaxScale() / this.getMinScale()), (double)(1.0f / (float)this.mDoubleTapScaleSteps));
    }

    @Override
    protected void init() {
        super.init();
        this.setupGestureListeners();
    }

    public boolean isRotateEnabled() {
        return this.mIsRotateEnabled;
    }

    public boolean isScaleEnabled() {
        return this.mIsScaleEnabled;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((255 & motionEvent.getAction()) == 0) {
            this.cancelAllAnimations();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.mMidPntX = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.mMidPntY = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        if (this.mIsScaleEnabled) {
            this.mScaleDetector.onTouchEvent(motionEvent);
        }
        if (this.mIsRotateEnabled) {
            this.mRotateDetector.onTouchEvent(motionEvent);
        }
        if ((255 & motionEvent.getAction()) == 1) {
            this.setImageToWrapCropBounds();
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int n2) {
        this.mDoubleTapScaleSteps = n2;
    }

    public void setRotateEnabled(boolean bl) {
        this.mIsRotateEnabled = bl;
    }

    public void setScaleEnabled(boolean bl) {
        this.mIsScaleEnabled = bl;
    }

    private class RotateListener
    extends RotationGestureDetector.SimpleOnRotationGestureListener {
        final /* synthetic */ GestureCropImageView this$0;

        private RotateListener(GestureCropImageView gestureCropImageView) {
            this.this$0 = gestureCropImageView;
        }

        /* synthetic */ RotateListener(GestureCropImageView gestureCropImageView, 1 var2_2) {
            super(gestureCropImageView);
        }

        @Override
        public boolean onRotation(RotationGestureDetector rotationGestureDetector) {
            this.this$0.postRotate(rotationGestureDetector.getAngle(), this.this$0.mMidPntX, this.this$0.mMidPntY);
            return true;
        }
    }

}

