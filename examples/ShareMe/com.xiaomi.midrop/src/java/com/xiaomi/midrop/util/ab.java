/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.PowerManager
 *  java.lang.Object
 */
package com.xiaomi.midrop.util;

import android.os.Build;
import android.os.PowerManager;

public final class ab {
    public static boolean a(PowerManager powerManager) {
        if (Build.VERSION.SDK_INT <= 19) {
            return powerManager.isScreenOn();
        }
        return powerManager.isInteractive();
    }
}

