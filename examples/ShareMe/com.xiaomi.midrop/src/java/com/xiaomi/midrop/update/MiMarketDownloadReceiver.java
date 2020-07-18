/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MiMarketDownloadReceiver
extends BroadcastReceiver {
    private static String a = "MiDrop:MiMarketDownloadReceiver";

    public void onReceive(Context context, Intent intent) {
        int n2 = intent.getIntExtra("errorCode", -100);
        double d2 = intent.getDoubleExtra("progress", -0.10000000149011612);
        String string2 = intent.getStringExtra("packageName");
        int n3 = intent.getIntExtra("reason", -100);
        int n4 = intent.getIntExtra("status", -100);
        Object[] arrobject = new Object[]{n2, d2, string2, n3, n4};
        String.format((String)"errorCode = %d\nprogress = %f\npackageName = %s\ndownloadFailReason = %d\ndownloadingState = %d", (Object[])arrobject);
    }
}

