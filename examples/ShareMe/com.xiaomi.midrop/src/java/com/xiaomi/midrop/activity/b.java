/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.xiaomi.midrop.WebActivity
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.midrop.WebActivity;
import com.xiaomi.midrop.c;

public final class b {
    private static final Object a = new Object();

    public static void a(Activity activity, String string2, boolean bl) {
        if (!TextUtils.isEmpty((CharSequence)string2) && activity != null && !activity.isFinishing()) {
            if (activity.isDestroyed()) {
                return;
            }
            if (bl) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse((String)string2));
                if (intent.resolveActivity(activity.getPackageManager()) != null) {
                    activity.startActivity(intent);
                    return;
                }
                intent.setPackage(null);
                if (intent.resolveActivity(activity.getPackageManager()) != null) {
                    activity.startActivity(intent);
                }
                return;
            }
            WebActivity.a((Context)activity, (String)"", (String)string2, (int)c.a.c);
        }
    }
}

