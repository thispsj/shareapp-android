/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.firebase.analytics.FirebaseAnalytics
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.util;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;

public class k {
    private static final String b = k.class.getCanonicalName();
    private static k c;
    FirebaseAnalytics a;

    private k(Context context) {
        this.a = FirebaseAnalytics.getInstance((Context)context);
    }

    public static k a() {
        return c;
    }

    public static void a(Context context) {
        if (c == null) {
            c = new k(context);
        }
    }
}

