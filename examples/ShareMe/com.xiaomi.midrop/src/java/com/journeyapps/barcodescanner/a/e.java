/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.SurfaceHolder
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.journeyapps.barcodescanner.a;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;

public final class e {
    SurfaceHolder a;
    SurfaceTexture b;

    public e(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null) {
            throw new IllegalArgumentException("surfaceTexture may not be null");
        }
        this.b = surfaceTexture;
    }

    public e(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalArgumentException("surfaceHolder may not be null");
        }
        this.a = surfaceHolder;
    }
}

