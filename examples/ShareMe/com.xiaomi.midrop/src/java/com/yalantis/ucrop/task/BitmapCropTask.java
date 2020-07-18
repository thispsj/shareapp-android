/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.support.a.a
 *  android.util.Log
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 */
package com.yalantis.ucrop.task;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.a.a;
import android.util.Log;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.ImageHeaderParser;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

public class BitmapCropTask
extends AsyncTask<Void, Void, Throwable> {
    private static final String TAG = "BitmapCropTask";
    private int cropOffsetX;
    private int cropOffsetY;
    private final Bitmap.CompressFormat mCompressFormat;
    private final int mCompressQuality;
    private final WeakReference<Context> mContext;
    private final BitmapCropCallback mCropCallback;
    private final RectF mCropRect;
    private int mCroppedImageHeight;
    private int mCroppedImageWidth;
    private float mCurrentAngle;
    private final RectF mCurrentImageRect;
    private float mCurrentScale;
    private final ExifInfo mExifInfo;
    private final String mImageInputPath;
    private final String mImageOutputPath;
    private final int mMaxResultImageSizeX;
    private final int mMaxResultImageSizeY;
    private Bitmap mViewBitmap;

    public BitmapCropTask(Context context, Bitmap bitmap, ImageState imageState, CropParameters cropParameters, BitmapCropCallback bitmapCropCallback) {
        this.mContext = new WeakReference((Object)context);
        this.mViewBitmap = bitmap;
        this.mCropRect = imageState.getCropRect();
        this.mCurrentImageRect = imageState.getCurrentImageRect();
        this.mCurrentScale = imageState.getCurrentScale();
        this.mCurrentAngle = imageState.getCurrentAngle();
        this.mMaxResultImageSizeX = cropParameters.getMaxResultImageSizeX();
        this.mMaxResultImageSizeY = cropParameters.getMaxResultImageSizeY();
        this.mCompressFormat = cropParameters.getCompressFormat();
        this.mCompressQuality = cropParameters.getCompressQuality();
        this.mImageInputPath = cropParameters.getImageInputPath();
        this.mImageOutputPath = cropParameters.getImageOutputPath();
        this.mExifInfo = cropParameters.getExifInfo();
        this.mCropCallback = bitmapCropCallback;
    }

    private boolean crop() throws IOException {
        if (this.mMaxResultImageSizeX > 0 && this.mMaxResultImageSizeY > 0) {
            float f2 = this.mCropRect.width() / this.mCurrentScale;
            float f3 = this.mCropRect.height() / this.mCurrentScale;
            if (f2 > (float)this.mMaxResultImageSizeX || f3 > (float)this.mMaxResultImageSizeY) {
                float f4 = Math.min((float)((float)this.mMaxResultImageSizeX / f2), (float)((float)this.mMaxResultImageSizeY / f3));
                Bitmap bitmap = Bitmap.createScaledBitmap((Bitmap)this.mViewBitmap, (int)Math.round((float)(f4 * (float)this.mViewBitmap.getWidth())), (int)Math.round((float)(f4 * (float)this.mViewBitmap.getHeight())), (boolean)false);
                if (this.mViewBitmap != bitmap) {
                    this.mViewBitmap.recycle();
                }
                this.mViewBitmap = bitmap;
                this.mCurrentScale /= f4;
            }
        }
        if (this.mCurrentAngle != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.mCurrentAngle, (float)(this.mViewBitmap.getWidth() / 2), (float)(this.mViewBitmap.getHeight() / 2));
            Bitmap bitmap = Bitmap.createBitmap((Bitmap)this.mViewBitmap, (int)0, (int)0, (int)this.mViewBitmap.getWidth(), (int)this.mViewBitmap.getHeight(), (Matrix)matrix, (boolean)true);
            if (this.mViewBitmap != bitmap) {
                this.mViewBitmap.recycle();
            }
            this.mViewBitmap = bitmap;
        }
        this.cropOffsetX = Math.round((float)((this.mCropRect.left - this.mCurrentImageRect.left) / this.mCurrentScale));
        this.cropOffsetY = Math.round((float)((this.mCropRect.top - this.mCurrentImageRect.top) / this.mCurrentScale));
        this.mCroppedImageWidth = Math.round((float)(this.mCropRect.width() / this.mCurrentScale));
        this.mCroppedImageHeight = Math.round((float)(this.mCropRect.height() / this.mCurrentScale));
        boolean bl = this.shouldCrop(this.mCroppedImageWidth, this.mCroppedImageHeight);
        StringBuilder stringBuilder = new StringBuilder("Should crop: ");
        stringBuilder.append(bl);
        Log.i((String)TAG, (String)stringBuilder.toString());
        if (bl) {
            a a2 = new a(this.mImageInputPath);
            this.saveImage(Bitmap.createBitmap((Bitmap)this.mViewBitmap, (int)this.cropOffsetX, (int)this.cropOffsetY, (int)this.mCroppedImageWidth, (int)this.mCroppedImageHeight));
            if (this.mCompressFormat.equals((Object)Bitmap.CompressFormat.JPEG)) {
                ImageHeaderParser.copyExif(a2, this.mCroppedImageWidth, this.mCroppedImageHeight, this.mImageOutputPath);
            }
            return true;
        }
        FileUtils.copyFile(this.mImageInputPath, this.mImageOutputPath);
        return false;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void saveImage(Bitmap bitmap) throws FileNotFoundException {
        OutputStream outputStream;
        void var4_7;
        block5 : {
            Context context = (Context)this.mContext.get();
            if (context == null) {
                return;
            }
            outputStream = null;
            OutputStream outputStream2 = context.getContentResolver().openOutputStream(Uri.fromFile((File)new File(this.mImageOutputPath)));
            try {
                bitmap.compress(this.mCompressFormat, this.mCompressQuality, outputStream2);
                bitmap.recycle();
            }
            catch (Throwable throwable) {
                outputStream = outputStream2;
            }
            BitmapLoadUtils.close((Closeable)outputStream2);
            return;
            break block5;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        BitmapLoadUtils.close(outputStream);
        throw var4_7;
    }

    private boolean shouldCrop(int n2, int n3) {
        float f2;
        float f3;
        int n4 = 1 + Math.round((float)((float)Math.max((int)n2, (int)n3) / 1000.0f));
        if (!(this.mMaxResultImageSizeX > 0 && this.mMaxResultImageSizeY > 0 || (f2 = Math.abs((float)(this.mCropRect.left - this.mCurrentImageRect.left))) > (f3 = (float)n4) || Math.abs((float)(this.mCropRect.top - this.mCurrentImageRect.top)) > f3 || Math.abs((float)(this.mCropRect.bottom - this.mCurrentImageRect.bottom)) > f3)) {
            return Math.abs((float)(this.mCropRect.right - this.mCurrentImageRect.right)) > f3;
        }
        return true;
    }

    protected /* varargs */ Throwable doInBackground(Void ... arrvoid) {
        if (this.mViewBitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (this.mViewBitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.mCurrentImageRect.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            BitmapCropTask.super.crop();
            this.mViewBitmap = null;
            return null;
        }
        catch (Throwable throwable) {
            return throwable;
        }
    }

    protected void onPostExecute(Throwable throwable) {
        if (this.mCropCallback != null) {
            if (throwable == null) {
                Uri uri = Uri.fromFile((File)new File(this.mImageOutputPath));
                this.mCropCallback.onBitmapCropped(uri, this.cropOffsetX, this.cropOffsetY, this.mCroppedImageWidth, this.mCroppedImageHeight);
                return;
            }
            this.mCropCallback.onCropFailure(throwable);
        }
    }
}

