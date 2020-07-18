/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.text.TextUtils
 *  android.view.Display
 *  android.view.WindowManager
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package com.xiaomi.midrop.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import java.util.Locale;

public final class ac {
    public static int a(Context context) {
        return ac.b((Context)context).x;
    }

    public static Point b(Context context) {
        Point point = new Point();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getSize(point);
        return point;
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        return TextUtils.getLayoutDirectionFromLocale((Locale)context.getResources().getConfiguration().locale) == 1;
    }
}

