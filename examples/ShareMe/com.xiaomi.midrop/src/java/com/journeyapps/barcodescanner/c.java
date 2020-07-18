/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.YuvImage
 *  com.google.zxing.a
 *  com.google.zxing.q
 *  com.google.zxing.r
 *  java.io.ByteArrayOutputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.journeyapps.barcodescanner;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.google.zxing.a;
import com.google.zxing.q;
import com.google.zxing.r;
import com.journeyapps.barcodescanner.o;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;

public final class c {
    protected q a;
    protected o b;
    private final int c = 2;

    public c(q q2, o o2) {
        this.a = q2;
        this.b = o2;
    }

    public final Bitmap a() {
        o o2 = this.b;
        Rect rect = o2.f;
        if (o2.a()) {
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
        }
        YuvImage yuvImage = new YuvImage(o2.a, o2.d, o2.b, o2.c, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(rect, 90, (OutputStream)byteArrayOutputStream);
        byte[] arrby = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        Bitmap bitmap = BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length, (BitmapFactory.Options)options);
        if (o2.e != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate((float)o2.e);
            bitmap = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)bitmap.getWidth(), (int)bitmap.getHeight(), (Matrix)matrix, (boolean)false);
        }
        return bitmap;
    }

    public final String b() {
        return this.a.a;
    }

    public final byte[] c() {
        return this.a.b;
    }

    public final a d() {
        return this.a.d;
    }

    public final Map<r, Object> e() {
        return this.a.e;
    }

    public final String toString() {
        return this.a.a;
    }
}

