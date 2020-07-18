/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.market.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.market.sdk.g;
import com.xiaomi.market.sdk.j;
import com.xiaomi.market.sdk.s;

public class DownloadCompleteReceiver
extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.DOWNLOAD_COMPLETE".equals((Object)intent.getAction())) {
            long l2 = intent.getLongExtra("extra_download_id", -1L);
            StringBuilder stringBuilder = new StringBuilder("on sdk download complete : id = ");
            stringBuilder.append(l2);
            j.a("MarketSDKDownloadReceiver", stringBuilder.toString());
            if (l2 == -1L) {
                return;
            }
            g g2 = g.a(context);
            if (l2 >= 0L) {
                if (g2.d != l2) {
                    return;
                }
                g.a a2 = g.a.a(g2.d);
                if (a2 != null && a2.b != 16) {
                    if (TextUtils.isEmpty((CharSequence)a2.f)) {
                        return;
                    }
                    g2.f.a(a2.f, true ^ TextUtils.isEmpty((CharSequence)g2.b.j));
                    return;
                }
            }
        }
    }
}

