/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.yalantis.ucrop.callback;

import android.graphics.Bitmap;
import com.yalantis.ucrop.model.ExifInfo;

public interface BitmapLoadCallback {
    public void onBitmapLoaded(Bitmap var1, ExifInfo var2, String var3, String var4);

    public void onFailure(Exception var1);
}

