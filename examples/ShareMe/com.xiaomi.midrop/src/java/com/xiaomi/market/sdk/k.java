/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ResolveInfo
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.market.sdk;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.xiaomi.market.sdk.b;
import com.xiaomi.market.sdk.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class k {
    public static String a(Intent intent) {
        Iterator iterator = k.b(intent).iterator();
        while (iterator.hasNext()) {
            ActivityInfo activityInfo = ((ResolveInfo)iterator.next()).activityInfo;
            if (!activityInfo.enabled || !activityInfo.exported) continue;
            return activityInfo.packageName;
        }
        return null;
    }

    private static List<ResolveInfo> b(Intent intent) {
        List list;
        try {
            list = b.b().queryIntentActivities(intent, 0);
        }
        catch (Exception exception) {
            j.a("PkgUtils", exception.getMessage(), exception);
            list = null;
        }
        if (list != null) {
            return list;
        }
        return new ArrayList();
    }
}

