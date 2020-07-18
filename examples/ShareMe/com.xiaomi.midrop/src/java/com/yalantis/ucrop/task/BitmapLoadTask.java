/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Matrix
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.ParcelFileDescriptor
 *  android.support.v4.content.a
 *  android.text.TextUtils
 *  android.util.Log
 *  c.e
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileDescriptor
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.Void
 *  okhttp3.aa
 *  okhttp3.aa$a
 *  okhttp3.ac
 *  okhttp3.ad
 *  okhttp3.n
 *  okhttp3.x
 *  okhttp3.z
 */
package com.yalantis.ucrop.task;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.support.v4.content.a;
import android.text.TextUtils;
import android.util.Log;
import c.e;
import c.l;
import c.s;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.n;
import okhttp3.x;
import okhttp3.z;

public class BitmapLoadTask
extends AsyncTask<Void, Void, BitmapWorkerResult> {
    private static final String TAG = "BitmapWorkerTask";
    private final BitmapLoadCallback mBitmapLoadCallback;
    private final Context mContext;
    private Uri mInputUri;
    private Uri mOutputUri;
    private final int mRequiredHeight;
    private final int mRequiredWidth;

    public BitmapLoadTask(Context context, Uri uri, Uri uri2, int n2, int n3, BitmapLoadCallback bitmapLoadCallback) {
        this.mContext = context;
        this.mInputUri = uri;
        this.mOutputUri = uri2;
        this.mRequiredWidth = n2;
        this.mRequiredHeight = n3;
        this.mBitmapLoadCallback = bitmapLoadCallback;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void copyFile(Uri var1, Uri var2_2) throws NullPointerException, IOException {
        block8 : {
            Log.d((String)"BitmapWorkerTask", (String)"copyFile");
            if (var2_2 == null) {
                throw new NullPointerException("Output Uri is null - cannot copy image");
            }
            var4_3 = null;
            var6_4 = this.mContext.getContentResolver().openInputStream(var1);
            var7_5 = new FileOutputStream(new File(var2_2.getPath()));
            if (var6_4 != null) ** GOTO lbl12
            try {
                throw new NullPointerException("InputStream for given input Uri is null");
lbl12: // 1 sources:
                var8_6 = new byte[1024];
                while ((var9_7 = var6_4.read(var8_6)) > 0) {
                    var7_5.write(var8_6, 0, var9_7);
                }
            }
            catch (Throwable var5_11) {
                var4_3 = var7_5;
            }
            BitmapLoadUtils.close((Closeable)var7_5);
            BitmapLoadUtils.close((Closeable)var6_4);
            this.mInputUri = this.mOutputUri;
            return;
            catch (Throwable var5_8) {
                var4_3 = null;
            }
            break block8;
            catch (Throwable var5_9) {
                var6_4 = null;
            }
        }
        BitmapLoadUtils.close(var4_3);
        BitmapLoadUtils.close((Closeable)var6_4);
        this.mInputUri = this.mOutputUri;
        throw var5_10;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void downloadFile(Uri uri, Uri uri2) throws NullPointerException, IOException {
        Throwable throwable;
        x x2;
        e e2;
        ac ac2;
        s s2;
        block14 : {
            e e3;
            block13 : {
                ac ac3;
                e e4;
                block12 : {
                    Log.d((String)TAG, (String)"downloadFile");
                    if (uri2 == null) {
                        throw new NullPointerException("Output Uri is null - cannot download image");
                    }
                    x2 = new x();
                    e2 = null;
                    ac3 = z.a((x)x2, (aa)new aa.a().a(uri.toString()).a(), (boolean)false).a();
                    try {
                        e4 = ac3.g.c();
                    }
                    catch (Throwable throwable2) {
                        ac2 = ac3;
                        e2 = null;
                        s2 = null;
                        break block14;
                    }
                    OutputStream outputStream = this.mContext.getContentResolver().openOutputStream(uri2);
                    if (outputStream == null) break block12;
                    s s3 = l.a(outputStream);
                    try {
                        e4.a(s3);
                    }
                    catch (Throwable throwable3) {
                        e3 = e4;
                        ac2 = ac3;
                        s2 = s3;
                        throwable = throwable3;
                        break block13;
                    }
                    BitmapLoadUtils.close((Closeable)e4);
                    BitmapLoadUtils.close(s3);
                    if (ac3 != null) {
                        BitmapLoadUtils.close((Closeable)ac3.g);
                    }
                    x2.c.a();
                    this.mInputUri = this.mOutputUri;
                    return;
                }
                try {
                    throw new NullPointerException("OutputStream for given output Uri is null");
                }
                catch (Throwable throwable4) {
                    e3 = e4;
                    ac2 = ac3;
                    s2 = null;
                }
            }
            e2 = e3;
            break block14;
            catch (Throwable throwable5) {
                throwable = throwable5;
                s2 = null;
                ac2 = null;
            }
        }
        BitmapLoadUtils.close(e2);
        BitmapLoadUtils.close(s2);
        if (ac2 != null) {
            BitmapLoadUtils.close((Closeable)ac2.g);
        }
        x2.c.a();
        this.mInputUri = this.mOutputUri;
        throw throwable;
    }

    private String getFilePath() {
        if (a.a((Context)this.mContext, (String)"android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return FileUtils.getPath(this.mContext, this.mInputUri);
        }
        return null;
    }

    private void processInputUri() throws NullPointerException, IOException {
        String string2 = this.mInputUri.getScheme();
        StringBuilder stringBuilder = new StringBuilder("Uri scheme: ");
        stringBuilder.append(string2);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (!"http".equals((Object)string2) && !"https".equals((Object)string2)) {
            if ("content".equals((Object)string2)) {
                String string3 = this.getFilePath();
                if (!TextUtils.isEmpty((CharSequence)string3) && new File(string3).exists()) {
                    this.mInputUri = Uri.fromFile((File)new File(string3));
                    return;
                }
                try {
                    this.copyFile(this.mInputUri, this.mOutputUri);
                    return;
                }
                catch (IOException | NullPointerException throwable) {
                    Log.e((String)TAG, (String)"Copying failed", (Throwable)throwable);
                    throw throwable;
                }
            }
            if (!"file".equals((Object)string2)) {
                StringBuilder stringBuilder2 = new StringBuilder("Invalid Uri scheme ");
                stringBuilder2.append(string2);
                Log.e((String)TAG, (String)stringBuilder2.toString());
                StringBuilder stringBuilder3 = new StringBuilder("Invalid Uri scheme");
                stringBuilder3.append(string2);
                throw new IllegalArgumentException(stringBuilder3.toString());
            }
            return;
        }
        try {
            this.downloadFile(this.mInputUri, this.mOutputUri);
            return;
        }
        catch (IOException | NullPointerException throwable) {
            Log.e((String)TAG, (String)"Downloading failed", (Throwable)throwable);
            throw throwable;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected /* varargs */ BitmapWorkerResult doInBackground(Void ... arrvoid) {
        Bitmap bitmap;
        ParcelFileDescriptor parcelFileDescriptor;
        BitmapFactory.Options options;
        boolean bl;
        block14 : {
            block13 : {
                if (this.mInputUri == null) {
                    return new BitmapWorkerResult((Exception)((Object)new NullPointerException("Input Uri cannot be null")));
                }
                BitmapLoadTask.super.processInputUri();
                try {
                    parcelFileDescriptor = this.mContext.getContentResolver().openFileDescriptor(this.mInputUri, "r");
                    if (parcelFileDescriptor == null) break block13;
                }
                catch (FileNotFoundException fileNotFoundException) {
                    return new BitmapWorkerResult((Exception)((Object)fileNotFoundException));
                }
                FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
                options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                bitmap = null;
                BitmapFactory.decodeFileDescriptor((FileDescriptor)fileDescriptor, null, (BitmapFactory.Options)options);
                if (options.outWidth != -1) {
                    // empty if block
                }
                options.inSampleSize = BitmapLoadUtils.calculateInSampleSize(options, this.mRequiredWidth, this.mRequiredHeight);
                bl = false;
                options.inJustDecodeBounds = false;
                break block14;
            }
            StringBuilder stringBuilder = new StringBuilder("ParcelFileDescriptor was null for given Uri: [");
            stringBuilder.append((Object)this.mInputUri);
            stringBuilder.append("]");
            return new BitmapWorkerResult((Exception)((Object)new NullPointerException(stringBuilder.toString())));
            catch (IOException | NullPointerException throwable) {
                return new BitmapWorkerResult((Exception)throwable);
            }
        }
        while (!bl) {
            try {
                Bitmap bitmap2;
                bitmap = bitmap2 = BitmapFactory.decodeFile((String)this.mInputUri.getPath(), (BitmapFactory.Options)options);
                bl = true;
            }
            catch (OutOfMemoryError outOfMemoryError) {
                Log.e((String)TAG, (String)"doInBackground: BitmapFactory.decodeFileDescriptor: ", (Throwable)outOfMemoryError);
                options.inSampleSize = 2 * options.inSampleSize;
            }
        }
        if (bitmap == null) {
            StringBuilder stringBuilder = new StringBuilder("Bitmap could not be decoded from the Uri: [");
            stringBuilder.append((Object)this.mInputUri);
            stringBuilder.append("]");
            return new BitmapWorkerResult((Exception)((Object)new IllegalArgumentException(stringBuilder.toString())));
        }
        if (Build.VERSION.SDK_INT >= 16) {
            BitmapLoadUtils.close((Closeable)parcelFileDescriptor);
        }
        int n2 = BitmapLoadUtils.getExifOrientation(this.mContext, this.mInputUri);
        int n3 = BitmapLoadUtils.exifToDegrees(n2);
        int n4 = BitmapLoadUtils.exifToTranslation(n2);
        ExifInfo exifInfo = new ExifInfo(n2, n3, n4);
        Matrix matrix = new Matrix();
        if (n3 != 0) {
            matrix.preRotate((float)n3);
        }
        if (n4 != 1) {
            matrix.postScale((float)n4, 1.0f);
        }
        if (matrix.isIdentity()) return new BitmapWorkerResult(bitmap, exifInfo);
        return new BitmapWorkerResult(BitmapLoadUtils.transformBitmap(bitmap, matrix), exifInfo);
    }

    protected void onPostExecute(BitmapWorkerResult bitmapWorkerResult) {
        if (bitmapWorkerResult.mBitmapWorkerException == null) {
            BitmapLoadCallback bitmapLoadCallback = this.mBitmapLoadCallback;
            Bitmap bitmap = bitmapWorkerResult.mBitmapResult;
            ExifInfo exifInfo = bitmapWorkerResult.mExifInfo;
            String string2 = this.mInputUri.getPath();
            String string3 = this.mOutputUri == null ? null : this.mOutputUri.getPath();
            bitmapLoadCallback.onBitmapLoaded(bitmap, exifInfo, string2, string3);
            return;
        }
        this.mBitmapLoadCallback.onFailure(bitmapWorkerResult.mBitmapWorkerException);
    }

    public static class BitmapWorkerResult {
        Bitmap mBitmapResult;
        Exception mBitmapWorkerException;
        ExifInfo mExifInfo;

        public BitmapWorkerResult(Bitmap bitmap, ExifInfo exifInfo) {
            this.mBitmapResult = bitmap;
            this.mExifInfo = exifInfo;
        }

        public BitmapWorkerResult(Exception exception) {
            this.mBitmapWorkerException = exception;
        }
    }

}

