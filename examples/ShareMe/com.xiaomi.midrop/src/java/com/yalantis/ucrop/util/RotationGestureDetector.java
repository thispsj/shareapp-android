/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  java.lang.Math
 *  java.lang.Object
 */
package com.yalantis.ucrop.util;

import android.view.MotionEvent;

public class RotationGestureDetector {
    private static final int INVALID_POINTER_INDEX = -1;
    private float fX;
    private float fY;
    private float mAngle;
    private boolean mIsFirstTouch;
    private OnRotationGestureListener mListener;
    private int mPointerIndex1;
    private int mPointerIndex2;
    private float sX;
    private float sY;

    public RotationGestureDetector(OnRotationGestureListener onRotationGestureListener) {
        this.mListener = onRotationGestureListener;
        this.mPointerIndex1 = -1;
        this.mPointerIndex2 = -1;
    }

    private float calculateAngleBetweenLines(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return RotationGestureDetector.super.calculateAngleDelta((float)Math.toDegrees((double)((float)Math.atan2((double)(f3 - f5), (double)(f2 - f4)))), (float)Math.toDegrees((double)((float)Math.atan2((double)(f7 - f9), (double)(f6 - f8)))));
    }

    /*
     * Enabled aggressive block sorting
     */
    private float calculateAngleDelta(float f2, float f3) {
        float f4;
        this.mAngle = f3 % 360.0f - f2 % 360.0f;
        if (this.mAngle < -180.0f) {
            f4 = 360.0f + this.mAngle;
        } else {
            if (!(this.mAngle > 180.0f)) return this.mAngle;
            f4 = this.mAngle - 360.0f;
        }
        this.mAngle = f4;
        return this.mAngle;
    }

    public float getAngle() {
        return this.mAngle;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        block11 : {
            switch (motionEvent.getActionMasked()) {
                default: {
                    return true;
                }
                case 6: {
                    this.mPointerIndex2 = -1;
                    return true;
                }
                case 5: {
                    this.fX = motionEvent.getX();
                    this.fY = motionEvent.getY();
                    this.mPointerIndex2 = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                    break;
                }
                case 2: {
                    if (this.mPointerIndex1 != -1 && this.mPointerIndex2 != -1 && motionEvent.getPointerCount() > this.mPointerIndex2) {
                        float f2 = motionEvent.getX(this.mPointerIndex1);
                        float f3 = motionEvent.getY(this.mPointerIndex1);
                        float f4 = motionEvent.getX(this.mPointerIndex2);
                        float f5 = motionEvent.getY(this.mPointerIndex2);
                        if (this.mIsFirstTouch) {
                            this.mAngle = 0.0f;
                            this.mIsFirstTouch = false;
                        } else {
                            RotationGestureDetector.super.calculateAngleBetweenLines(this.fX, this.fY, this.sX, this.sY, f4, f5, f2, f3);
                        }
                        if (this.mListener != null) {
                            this.mListener.onRotation((RotationGestureDetector)this);
                        }
                        this.fX = f4;
                        this.fY = f5;
                        this.sX = f2;
                        this.sY = f3;
                        return true;
                    }
                    break block11;
                }
                case 1: {
                    this.mPointerIndex1 = -1;
                    return true;
                }
                case 0: {
                    this.sX = motionEvent.getX();
                    this.sY = motionEvent.getY();
                    this.mPointerIndex1 = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
                }
            }
            this.mAngle = 0.0f;
            this.mIsFirstTouch = true;
        }
        return true;
    }

    public static interface OnRotationGestureListener {
        public boolean onRotation(RotationGestureDetector var1);
    }

}

