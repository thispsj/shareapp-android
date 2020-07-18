/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Point
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.util.Log
 *  android.view.Display
 *  android.view.WindowManager
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.Void
 */
package com.yalantis.ucrop.util;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.task.BitmapLoadTask;
import com.yalantis.ucrop.util.EglUtils;
import com.yalantis.ucrop.util.ImageHeaderParser;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class BitmapLoadUtils {
    private static final String TAG = "BitmapLoadUtils";

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int calculateInSampleSize(BitmapFactory.Options options, int n2, int n3) {
        int n4 = options.outHeight;
        int n5 = options.outWidth;
        int n6 = 1;
        if (n4 <= n3 && n5 <= n2) return n6;
        while (n4 / n6 > n3 || n5 / n6 > n2) {
            n6 *= 2;
        }
        return n6;
    }

    public static int calculateMaxBitmapSize(Context context) {
        int n2;
        WindowManager windowManager = (WindowManager)context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int n3 = point.x;
        int n4 = point.y;
        int n5 = (int)Math.sqrt((double)(Math.pow((double)n3, (double)2.0) + Math.pow((double)n4, (double)2.0)));
        Canvas canvas = new Canvas();
        int n6 = Math.min((int)canvas.getMaximumBitmapWidth(), (int)canvas.getMaximumBitmapHeight());
        if (n6 > 0) {
            n5 = Math.min((int)n5, (int)n6);
        }
        if ((n2 = EglUtils.getMaxTextureSize()) > 0) {
            n5 = Math.min((int)n5, (int)n2);
        }
        StringBuilder stringBuilder = new StringBuilder("maxBitmapSize: ");
        stringBuilder.append(n5);
        Log.d((String)TAG, (String)stringBuilder.toString());
        return n5;
    }

    /*
     * Exception decompiling
     */
    public static void close(Closeable var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public static void decodeBitmapInBackground(Context context, Uri uri, Uri uri2, int n2, int n3, BitmapLoadCallback bitmapLoadCallback) {
        BitmapLoadTask bitmapLoadTask = new BitmapLoadTask(context, uri, uri2, n2, n3, bitmapLoadCallback);
        bitmapLoadTask.execute((Object[])new Void[0]);
    }

    public static int exifToDegrees(int n2) {
        switch (n2) {
            default: {
                return 0;
            }
            case 7: 
            case 8: {
                return 270;
            }
            case 5: 
            case 6: {
                return 90;
            }
            case 3: 
            case 4: 
        }
        return 180;
    }

    public static int exifToTranslation(int n2) {
        if (n2 != 2 && n2 != 7) {
            switch (n2) {
                default: {
                    return 1;
                }
                case 4: 
                case 5: 
            }
        }
        return -1;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static int getExifOrientation(Context context, Uri uri) {
        void var2_6;
        int n2;
        block5 : {
            InputStream inputStream = context.getContentResolver().openInputStream(uri);
            if (inputStream == null) {
                return 0;
            }
            n2 = new ImageHeaderParser(inputStream).getOrientation();
            try {
                BitmapLoadUtils.close((Closeable)inputStream);
                return n2;
            }
            catch (IOException iOException) {}
            break block5;
            catch (IOException iOException) {
                n2 = 0;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("getExifOrientation: ");
        stringBuilder.append(uri.toString());
        Log.e((String)TAG, (String)stringBuilder.toString(), (Throwable)var2_6);
        return n2;
    }

    public static Bitmap transformBitmap(Bitmap bitmap, Matrix matrix) {
        try {
            Bitmap bitmap2 = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)bitmap.getWidth(), (int)bitmap.getHeight(), (Matrix)matrix, (boolean)true);
            boolean bl = bitmap.sameAs(bitmap2);
            if (!bl) {
                return bitmap2;
            }
        }
        catch (OutOfMemoryError outOfMemoryError) {
            Log.e((String)TAG, (String)"transformBitmap: ", (Throwable)outOfMemoryError);
        }
        return bitmap;
    }
}

