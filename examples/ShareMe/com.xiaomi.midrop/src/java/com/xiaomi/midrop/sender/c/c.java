/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  java.lang.Object
 */
package com.xiaomi.midrop.sender.c;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public final class c {
    public static int a(Context context, float f2) {
        return (int)(0.5f + f2 * context.getResources().getDisplayMetrics().density);
    }
}

