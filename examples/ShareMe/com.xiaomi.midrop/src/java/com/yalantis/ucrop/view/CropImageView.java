/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.os.AsyncTask
 *  android.util.AttributeSet
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.Arrays
 */
package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.task.BitmapCropTask;
import com.yalantis.ucrop.util.CubicEasing;
import com.yalantis.ucrop.util.RectUtils;
import com.yalantis.ucrop.view.TransformImageView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class CropImageView
extends TransformImageView {
    public static final float DEFAULT_ASPECT_RATIO = 0.0f;
    public static final int DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = 500;
    public static final int DEFAULT_MAX_BITMAP_SIZE = 0;
    public static final float DEFAULT_MAX_SCALE_MULTIPLIER = 10.0f;
    public static final float SOURCE_IMAGE_ASPECT_RATIO;
    private CropBoundsChangeListener mCropBoundsChangeListener;
    private final RectF mCropRect;
    private long mImageToWrapCropBoundsAnimDuration;
    private int mMaxResultImageSizeX;
    private int mMaxResultImageSizeY;
    private float mMaxScale;
    private float mMaxScaleMultiplier;
    private float mMinScale;
    private float mTargetAspectRatio;
    private final Matrix mTempMatrix;
    private Runnable mWrapCropBoundsRunnable;
    private Runnable mZoomImageToPositionRunnable;

    public CropImageView(Context context) {
        super(context, null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.mCropRect = new RectF();
        this.mTempMatrix = new Matrix();
        this.mMaxScaleMultiplier = 10.0f;
        this.mZoomImageToPositionRunnable = null;
        this.mMaxResultImageSizeX = 0;
        this.mMaxResultImageSizeY = 0;
        this.mImageToWrapCropBoundsAnimDuration = 500L;
    }

    private float[] calculateImageIndents() {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-this.getCurrentAngle());
        float[] arrf = Arrays.copyOf((float[])this.mCurrentImageCorners, (int)this.mCurrentImageCorners.length);
        float[] arrf2 = RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(arrf);
        this.mTempMatrix.mapPoints(arrf2);
        RectF rectF = RectUtils.trapToRect(arrf);
        RectF rectF2 = RectUtils.trapToRect(arrf2);
        float f2 = rectF.left - rectF2.left;
        float f3 = rectF.top - rectF2.top;
        float f4 = rectF.right - rectF2.right;
        float f5 = rectF.bottom - rectF2.bottom;
        float[] arrf3 = new float[4];
        if (!(f2 > 0.0f)) {
            f2 = 0.0f;
        }
        arrf3[0] = f2;
        if (!(f3 > 0.0f)) {
            f3 = 0.0f;
        }
        arrf3[1] = f3;
        if (!(f4 < 0.0f)) {
            f4 = 0.0f;
        }
        arrf3[2] = f4;
        if (!(f5 < 0.0f)) {
            f5 = 0.0f;
        }
        arrf3[3] = f5;
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(this.getCurrentAngle());
        this.mTempMatrix.mapPoints(arrf3);
        return arrf3;
    }

    private void calculateImageScaleBounds() {
        Drawable drawable2 = this.getDrawable();
        if (drawable2 == null) {
            return;
        }
        this.calculateImageScaleBounds(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
    }

    private void calculateImageScaleBounds(float f2, float f3) {
        this.mMinScale = Math.min((float)Math.min((float)(this.mCropRect.width() / f2), (float)(this.mCropRect.width() / f3)), (float)Math.min((float)(this.mCropRect.height() / f3), (float)(this.mCropRect.height() / f2)));
        this.mMaxScale = this.mMinScale * this.mMaxScaleMultiplier;
    }

    private void setupInitialImagePosition(float f2, float f3) {
        float f4 = this.mCropRect.width();
        float f5 = this.mCropRect.height();
        float f6 = Math.max((float)(this.mCropRect.width() / f2), (float)(this.mCropRect.height() / f3));
        float f7 = (f4 - f2 * f6) / 2.0f + this.mCropRect.left;
        float f8 = (f5 - f3 * f6) / 2.0f + this.mCropRect.top;
        this.mCurrentImageMatrix.reset();
        this.mCurrentImageMatrix.postScale(f6, f6);
        this.mCurrentImageMatrix.postTranslate(f7, f8);
        this.setImageMatrix(this.mCurrentImageMatrix);
    }

    public void cancelAllAnimations() {
        this.removeCallbacks(this.mWrapCropBoundsRunnable);
        this.removeCallbacks(this.mZoomImageToPositionRunnable);
    }

    public void cropAndSaveImage(Bitmap.CompressFormat compressFormat, int n2, BitmapCropCallback bitmapCropCallback) {
        this.cancelAllAnimations();
        this.setImageToWrapCropBounds(false);
        ImageState imageState = new ImageState(this.mCropRect, RectUtils.trapToRect(this.mCurrentImageCorners), this.getCurrentScale(), this.getCurrentAngle());
        CropParameters cropParameters = new CropParameters(this.mMaxResultImageSizeX, this.mMaxResultImageSizeY, compressFormat, n2, this.getImageInputPath(), this.getImageOutputPath(), this.getExifInfo());
        BitmapCropTask bitmapCropTask = new BitmapCropTask(this.getContext(), this.getViewBitmap(), imageState, cropParameters, bitmapCropCallback);
        bitmapCropTask.execute((Object[])new Void[0]);
    }

    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.mCropBoundsChangeListener;
    }

    public float getMaxScale() {
        return this.mMaxScale;
    }

    public float getMinScale() {
        return this.mMinScale;
    }

    public float getTargetAspectRatio() {
        return this.mTargetAspectRatio;
    }

    protected boolean isImageWrapCropBounds() {
        return this.isImageWrapCropBounds(this.mCurrentImageCorners);
    }

    protected boolean isImageWrapCropBounds(float[] arrf) {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-this.getCurrentAngle());
        float[] arrf2 = Arrays.copyOf((float[])arrf, (int)arrf.length);
        this.mTempMatrix.mapPoints(arrf2);
        float[] arrf3 = RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(arrf3);
        return RectUtils.trapToRect(arrf2).contains(RectUtils.trapToRect(arrf3));
    }

    @Override
    protected void onImageLaidOut() {
        int n2;
        super.onImageLaidOut();
        Drawable drawable2 = this.getDrawable();
        if (drawable2 == null) {
            return;
        }
        float f2 = drawable2.getIntrinsicWidth();
        float f3 = drawable2.getIntrinsicHeight();
        if (this.mTargetAspectRatio == 0.0f) {
            this.mTargetAspectRatio = f2 / f3;
        }
        if ((n2 = (int)((float)this.mThisWidth / this.mTargetAspectRatio)) > this.mThisHeight) {
            int n3 = (int)((float)this.mThisHeight * this.mTargetAspectRatio);
            int n4 = (this.mThisWidth - n3) / 2;
            this.mCropRect.set((float)n4, 0.0f, (float)(n3 + n4), (float)this.mThisHeight);
        } else {
            int n5 = (this.mThisHeight - n2) / 2;
            this.mCropRect.set(0.0f, (float)n5, (float)this.mThisWidth, (float)(n2 + n5));
        }
        this.calculateImageScaleBounds(f2, f3);
        this.setupInitialImagePosition(f2, f3);
        if (this.mCropBoundsChangeListener != null) {
            this.mCropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
        }
        if (this.mTransformImageListener != null) {
            this.mTransformImageListener.onScale(this.getCurrentScale());
            this.mTransformImageListener.onRotate(this.getCurrentAngle());
        }
    }

    public void postRotate(float f2) {
        this.postRotate(f2, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    @Override
    public void postScale(float f2, float f3, float f4) {
        if (f2 > 1.0f && f2 * this.getCurrentScale() <= this.getMaxScale()) {
            super.postScale(f2, f3, f4);
            return;
        }
        if (f2 < 1.0f && f2 * this.getCurrentScale() >= this.getMinScale()) {
            super.postScale(f2, f3, f4);
        }
    }

    protected void processStyledAttributes(TypedArray typedArray) {
        float f2 = Math.abs((float)typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float f3 = Math.abs((float)typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        if (f2 != 0.0f && f3 != 0.0f) {
            this.mTargetAspectRatio = f2 / f3;
            return;
        }
        this.mTargetAspectRatio = 0.0f;
    }

    public void setCropBoundsChangeListener(CropBoundsChangeListener cropBoundsChangeListener) {
        this.mCropBoundsChangeListener = cropBoundsChangeListener;
    }

    public void setCropRect(RectF rectF) {
        this.mTargetAspectRatio = rectF.width() / rectF.height();
        this.mCropRect.set(rectF.left - (float)this.getPaddingLeft(), rectF.top - (float)this.getPaddingTop(), rectF.right - (float)this.getPaddingRight(), rectF.bottom - (float)this.getPaddingBottom());
        CropImageView.super.calculateImageScaleBounds();
        this.setImageToWrapCropBounds();
    }

    public void setImageToWrapCropBounds() {
        this.setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBounds(boolean bl) {
        if (this.mBitmapLaidOut && !this.isImageWrapCropBounds()) {
            float f2;
            float f3;
            float f4;
            float f5 = this.mCurrentImageCenter[0];
            float f6 = this.mCurrentImageCenter[1];
            float f7 = this.getCurrentScale();
            float f8 = this.mCropRect.centerX() - f5;
            float f9 = this.mCropRect.centerY() - f6;
            this.mTempMatrix.reset();
            this.mTempMatrix.setTranslate(f8, f9);
            float[] arrf = Arrays.copyOf((float[])this.mCurrentImageCorners, (int)this.mCurrentImageCorners.length);
            this.mTempMatrix.mapPoints(arrf);
            boolean bl2 = this.isImageWrapCropBounds(arrf);
            if (bl2) {
                float[] arrf2 = CropImageView.super.calculateImageIndents();
                float f10 = -(arrf2[0] + arrf2[2]);
                f2 = -(arrf2[1] + arrf2[3]);
                f4 = f10;
                f3 = 0.0f;
            } else {
                RectF rectF = new RectF(this.mCropRect);
                this.mTempMatrix.reset();
                this.mTempMatrix.setRotate(this.getCurrentAngle());
                this.mTempMatrix.mapRect(rectF);
                float[] arrf3 = RectUtils.getRectSidesFromCorners(this.mCurrentImageCorners);
                float f11 = f7 * Math.max((float)(rectF.width() / arrf3[0]), (float)(rectF.height() / arrf3[1])) - f7;
                f4 = f8;
                f3 = f11;
                f2 = f9;
            }
            if (bl) {
                Runnable runnable;
                this.mWrapCropBoundsRunnable = runnable = new Runnable((CropImageView)this, this.mImageToWrapCropBoundsAnimDuration, f5, f6, f4, f2, f7, f3, bl2){
                    private final float mCenterDiffX;
                    private final float mCenterDiffY;
                    private final WeakReference<CropImageView> mCropImageView;
                    private final float mDeltaScale;
                    private final long mDurationMs;
                    private final float mOldScale;
                    private final float mOldX;
                    private final float mOldY;
                    private final long mStartTime;
                    private final boolean mWillBeImageInBoundsAfterTranslate;
                    {
                        this.mCropImageView = new WeakReference((Object)cropImageView);
                        this.mDurationMs = l2;
                        this.mStartTime = System.currentTimeMillis();
                        this.mOldX = f2;
                        this.mOldY = f3;
                        this.mCenterDiffX = f4;
                        this.mCenterDiffY = f5;
                        this.mOldScale = f6;
                        this.mDeltaScale = f7;
                        this.mWillBeImageInBoundsAfterTranslate = bl;
                    }

                    public void run() {
                        CropImageView cropImageView = (CropImageView)((Object)this.mCropImageView.get());
                        if (cropImageView == null) {
                            return;
                        }
                        long l2 = System.currentTimeMillis();
                        float f2 = Math.min((long)this.mDurationMs, (long)(l2 - this.mStartTime));
                        float f3 = CubicEasing.easeOut(f2, 0.0f, this.mCenterDiffX, this.mDurationMs);
                        float f4 = CubicEasing.easeOut(f2, 0.0f, this.mCenterDiffY, this.mDurationMs);
                        float f5 = CubicEasing.easeInOut(f2, 0.0f, this.mDeltaScale, this.mDurationMs);
                        if (f2 < (float)this.mDurationMs) {
                            cropImageView.postTranslate(f3 - (cropImageView.mCurrentImageCenter[0] - this.mOldX), f4 - (cropImageView.mCurrentImageCenter[1] - this.mOldY));
                            if (!this.mWillBeImageInBoundsAfterTranslate) {
                                cropImageView.zoomInImage(f5 + this.mOldScale, cropImageView.mCropRect.centerX(), cropImageView.mCropRect.centerY());
                            }
                            if (!cropImageView.isImageWrapCropBounds()) {
                                cropImageView.post((Runnable)this);
                            }
                        }
                    }
                };
                this.post(runnable);
                return;
            }
            this.postTranslate(f4, f2);
            if (!bl2) {
                this.zoomInImage(f7 + f3, this.mCropRect.centerX(), this.mCropRect.centerY());
            }
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(long l2) {
        if (l2 > 0L) {
            this.mImageToWrapCropBoundsAnimDuration = l2;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxResultImageSizeX(int n2) {
        this.mMaxResultImageSizeX = n2;
    }

    public void setMaxResultImageSizeY(int n2) {
        this.mMaxResultImageSizeY = n2;
    }

    public void setMaxScaleMultiplier(float f2) {
        this.mMaxScaleMultiplier = f2;
    }

    public void setTargetAspectRatio(float f2) {
        Drawable drawable2 = this.getDrawable();
        if (drawable2 == null) {
            this.mTargetAspectRatio = f2;
            return;
        }
        if (f2 == 0.0f) {
            f2 = (float)drawable2.getIntrinsicWidth() / (float)drawable2.getIntrinsicHeight();
        }
        this.mTargetAspectRatio = f2;
        if (this.mCropBoundsChangeListener != null) {
            this.mCropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
        }
    }

    protected void zoomImageToPosition(float f2, float f3, float f4, long l2) {
        Runnable runnable;
        if (f2 > this.getMaxScale()) {
            f2 = this.getMaxScale();
        }
        float f5 = this.getCurrentScale();
        float f6 = f2 - f5;
        this.mZoomImageToPositionRunnable = runnable = new Runnable((CropImageView)this, l2, f5, f6, f3, f4){
            private final WeakReference<CropImageView> mCropImageView;
            private final float mDeltaScale;
            private final float mDestX;
            private final float mDestY;
            private final long mDurationMs;
            private final float mOldScale;
            private final long mStartTime;
            {
                this.mCropImageView = new WeakReference((Object)cropImageView);
                this.mStartTime = System.currentTimeMillis();
                this.mDurationMs = l2;
                this.mOldScale = f2;
                this.mDeltaScale = f3;
                this.mDestX = f4;
                this.mDestY = f5;
            }

            public void run() {
                CropImageView cropImageView = (CropImageView)((Object)this.mCropImageView.get());
                if (cropImageView == null) {
                    return;
                }
                long l2 = System.currentTimeMillis();
                float f2 = Math.min((long)this.mDurationMs, (long)(l2 - this.mStartTime));
                float f3 = CubicEasing.easeInOut(f2, 0.0f, this.mDeltaScale, this.mDurationMs);
                if (f2 < (float)this.mDurationMs) {
                    cropImageView.zoomInImage(f3 + this.mOldScale, this.mDestX, this.mDestY);
                    cropImageView.post((Runnable)this);
                    return;
                }
                cropImageView.setImageToWrapCropBounds();
            }
        };
        this.post(runnable);
    }

    public void zoomInImage(float f2) {
        this.zoomInImage(f2, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomInImage(float f2, float f3, float f4) {
        if (f2 <= this.getMaxScale()) {
            this.postScale(f2 / this.getCurrentScale(), f3, f4);
        }
    }

    public void zoomOutImage(float f2) {
        this.zoomOutImage(f2, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomOutImage(float f2, float f3, float f4) {
        if (f2 >= this.getMinScale()) {
            this.postScale(f2 / this.getCurrentScale(), f3, f4);
        }
    }

}

