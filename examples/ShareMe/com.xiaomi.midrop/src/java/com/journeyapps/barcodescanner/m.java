/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Display
 *  android.view.OrientationEventListener
 *  android.view.WindowManager
 *  java.lang.Object
 */
package com.journeyapps.barcodescanner;

import android.content.Context;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.journeyapps.barcodescanner.l;

public final class m {
    int a;
    WindowManager b;
    OrientationEventListener c;
    l d;

    public final void a() {
        if (this.c != null) {
            this.c.disable();
        }
        this.c = null;
        this.b = null;
        this.d = null;
    }

}

