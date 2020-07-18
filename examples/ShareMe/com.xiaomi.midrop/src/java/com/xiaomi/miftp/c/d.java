/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  java.lang.Object
 *  org.a.ae
 */
package com.xiaomi.miftp.c;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import org.a.ae;

public final class d {
    private static int a = -1;
    private static int b = -1;
    private static float c = -1.0f;

    public static int a() {
        if (c <= 0.0f) {
            c = ae.e().getResources().getDisplayMetrics().density;
        }
        return (int)(0.5f + 25.0f * c);
    }
}

