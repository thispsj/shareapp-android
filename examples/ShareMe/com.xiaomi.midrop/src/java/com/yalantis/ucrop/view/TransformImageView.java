/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.support.v7.widget.AppCompatImageView
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FastBitmapDrawable;
import com.yalantis.ucrop.util.RectUtils;
import com.yalantis.ucrop.view.TransformImageView;

public class TransformImageView
extends AppCompatImageView {
    private static final int MATRIX_VALUES_COUNT = 9;
    private static final int RECT_CENTER_POINT_COORDS = 2;
    private static final int RECT_CORNER_POINTS_COORDS = 8;
    private static final String TAG = "TransformImageView";
    protected boolean mBitmapDecoded;
    protected boolean mBitmapLaidOut;
    protected final float[] mCurrentImageCenter;
    protected final float[] mCurrentImageCorners;
    protected Matrix mCurrentImageMatrix;
    private ExifInfo mExifInfo;
    private String mImageInputPath;
    private String mImageOutputPath;
    private float[] mInitialImageCenter;
    private float[] mInitialImageCorners;
    private final float[] mMatrixValues;
    private int mMaxBitmapSize;
    protected int mThisHeight;
    protected int mThisWidth;
    protected TransformImageListener mTransformImageListener;

    public TransformImageView(Context context) {
        super(context, null);
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.mCurrentImageCorners = new float[8];
        this.mCurrentImageCenter = new float[2];
        this.mMatrixValues = new float[9];
        this.mCurrentImageMatrix = new Matrix();
        this.mBitmapDecoded = false;
        this.mBitmapLaidOut = false;
        this.mMaxBitmapSize = 0;
        this.init();
    }

    static /* synthetic */ String access$002(TransformImageView transformImageView, String string2) {
        transformImageView.mImageInputPath = string2;
        return string2;
    }

    static /* synthetic */ String access$102(TransformImageView transformImageView, String string2) {
        transformImageView.mImageOutputPath = string2;
        return string2;
    }

    static /* synthetic */ ExifInfo access$202(TransformImageView transformImageView, ExifInfo exifInfo) {
        transformImageView.mExifInfo = exifInfo;
        return exifInfo;
    }

    private void updateCurrentImagePoints() {
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCorners, this.mInitialImageCorners);
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCenter, this.mInitialImageCenter);
    }

    public float getCurrentAngle() {
        return this.getMatrixAngle(this.mCurrentImageMatrix);
    }

    public float getCurrentScale() {
        return this.getMatrixScale(this.mCurrentImageMatrix);
    }

    public ExifInfo getExifInfo() {
        return this.mExifInfo;
    }

    public String getImageInputPath() {
        return this.mImageInputPath;
    }

    public String getImageOutputPath() {
        return this.mImageOutputPath;
    }

    public float getMatrixAngle(Matrix matrix) {
        return (float)(-(57.29577951308232 * Math.atan2((double)this.getMatrixValue(matrix, 1), (double)this.getMatrixValue(matrix, 0))));
    }

    public float getMatrixScale(Matrix matrix) {
        return (float)Math.sqrt((double)(Math.pow((double)this.getMatrixValue(matrix, 0), (double)2.0) + Math.pow((double)this.getMatrixValue(matrix, 3), (double)2.0)));
    }

    protected float getMatrixValue(Matrix matrix, int n2) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[n2];
    }

    public int getMaxBitmapSize() {
        if (this.mMaxBitmapSize <= 0) {
            this.mMaxBitmapSize = BitmapLoadUtils.calculateMaxBitmapSize(this.getContext());
        }
        return this.mMaxBitmapSize;
    }

    public Bitmap getViewBitmap() {
        if (this.getDrawable() != null && this.getDrawable() instanceof FastBitmapDrawable) {
            return ((FastBitmapDrawable)this.getDrawable()).getBitmap();
        }
        return null;
    }

    protected void init() {
        this.setScaleType(ImageView.ScaleType.MATRIX);
    }

    protected void onImageLaidOut() {
        Drawable drawable2 = this.getDrawable();
        if (drawable2 == null) {
            return;
        }
        float f2 = drawable2.getIntrinsicWidth();
        float f3 = drawable2.getIntrinsicHeight();
        Object[] arrobject = new Object[]{(int)f2, (int)f3};
        Log.d((String)TAG, (String)String.format((String)"Image size: [%d:%d]", (Object[])arrobject));
        RectF rectF = new RectF(0.0f, 0.0f, f2, f3);
        this.mInitialImageCorners = RectUtils.getCornersFromRect(rectF);
        this.mInitialImageCenter = RectUtils.getCenterFromRect(rectF);
        this.mBitmapLaidOut = true;
        if (this.mTransformImageListener != null) {
            this.mTransformImageListener.onLoadComplete();
        }
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        super.onLayout(bl, n2, n3, n4, n5);
        if (bl || this.mBitmapDecoded && !this.mBitmapLaidOut) {
            int n6 = this.getPaddingLeft();
            int n7 = this.getPaddingTop();
            int n8 = this.getWidth() - this.getPaddingRight();
            int n9 = this.getHeight() - this.getPaddingBottom();
            this.mThisWidth = n8 - n6;
            this.mThisHeight = n9 - n7;
            this.onImageLaidOut();
        }
    }

    public void postRotate(float f2, float f3, float f4) {
        if (f2 != 0.0f) {
            this.mCurrentImageMatrix.postRotate(f2, f3, f4);
            this.setImageMatrix(this.mCurrentImageMatrix);
            if (this.mTransformImageListener != null) {
                this.mTransformImageListener.onRotate(this.getMatrixAngle(this.mCurrentImageMatrix));
            }
        }
    }

    public void postScale(float f2, float f3, float f4) {
        if (f2 != 0.0f) {
            this.mCurrentImageMatrix.postScale(f2, f2, f3, f4);
            this.setImageMatrix(this.mCurrentImageMatrix);
            if (this.mTransformImageListener != null) {
                this.mTransformImageListener.onScale(this.getMatrixScale(this.mCurrentImageMatrix));
            }
        }
    }

    public void postTranslate(float f2, float f3) {
        if (f2 != 0.0f || f3 != 0.0f) {
            this.mCurrentImageMatrix.postTranslate(f2, f3);
            this.setImageMatrix(this.mCurrentImageMatrix);
        }
    }

    protected void printMatrix(String string2, Matrix matrix) {
        float f2 = this.getMatrixValue(matrix, 2);
        float f3 = this.getMatrixValue(matrix, 5);
        float f4 = this.getMatrixScale(matrix);
        float f5 = this.getMatrixAngle(matrix);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(": matrix: { x: ");
        stringBuilder.append(f2);
        stringBuilder.append(", y: ");
        stringBuilder.append(f3);
        stringBuilder.append(", scale: ");
        stringBuilder.append(f4);
        stringBuilder.append(", angle: ");
        stringBuilder.append(f5);
        stringBuilder.append(" }");
        Log.d((String)TAG, (String)stringBuilder.toString());
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.setImageDrawable((Drawable)new FastBitmapDrawable(bitmap));
    }

    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.mCurrentImageMatrix.set(matrix);
        TransformImageView.super.updateCurrentImagePoints();
    }

    public void setImageUri(Uri uri, Uri uri2) throws Exception {
        int n2 = this.getMaxBitmapSize();
        BitmapLoadUtils.decodeBitmapInBackground(this.getContext(), uri, uri2, n2, n2, new BitmapLoadCallback((TransformImageView)this){
            final /* synthetic */ TransformImageView this$0;
            {
                this.this$0 = transformImageView;
            }

            public void onBitmapLoaded(Bitmap bitmap, ExifInfo exifInfo, String string2, String string3) {
                TransformImageView.access$002(this.this$0, string2);
                TransformImageView.access$102(this.this$0, string3);
                TransformImageView.access$202(this.this$0, exifInfo);
                this.this$0.mBitmapDecoded = true;
                this.this$0.setImageBitmap(bitmap);
            }

            public void onFailure(Exception exception) {
                Log.e((String)"TransformImageView", (String)"onFailure: setImageUri", (java.lang.Throwable)exception);
                if (this.this$0.mTransformImageListener != null) {
                    this.this$0.mTransformImageListener.onLoadFailure(exception);
                }
            }
        });
    }

    public void setMaxBitmapSize(int n2) {
        this.mMaxBitmapSize = n2;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
            return;
        }
        Log.w((String)TAG, (String)"Invalid ScaleType. Only ScaleType.MATRIX can be used");
    }

    public void setTransformImageListener(TransformImageListener transformImageListener) {
        this.mTransformImageListener = transformImageListener;
    }

}

