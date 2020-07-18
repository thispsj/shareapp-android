/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.widget.Toast
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.xiaomi.market.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.xiaomi.market.sdk.R;
import com.xiaomi.market.sdk.b;

final class h {
    public static void a(int n2) {
        switch (n2) {
            default: {
                return;
            }
            case -1: {
                h.b(R.string.xiaomi_update_sdk_external_storage_unavailable);
                return;
            }
            case -2: 
        }
        h.b(R.string.xiaomi_update_sdk_connect_download_manager_fail);
    }

    private static void b(final int n2) {
        new Handler(Looper.getMainLooper()).post(new Runnable(){

            public final void run() {
                Toast.makeText((Context)b.a(), (int)n2, (int)0).show();
            }
        });
    }

}

