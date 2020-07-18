/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 *  android.os.Parcelable
 *  android.os.ResultReceiver
 *  com.xiaomi.midrop.sender.service.a
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.sender.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.xiaomi.midrop.sender.service.a;

public class SenderManagerService
extends Service {
    private a a;
    private boolean b;
    private boolean c;

    public IBinder onBind(Intent intent) {
        this.c = true;
        return this.a;
    }

    public void onCreate() {
        super.onCreate();
        this.a = new a(this.getApplicationContext());
        this.a.k();
    }

    public void onDestroy() {
        super.onDestroy();
        this.a.l();
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
        this.c = true;
    }

    public int onStartCommand(Intent intent, int n2, int n3) {
        if (intent == null) {
            return 2;
        }
        ResultReceiver resultReceiver = (ResultReceiver)intent.getParcelableExtra("result_receiver");
        a a2 = this.a;
        if (resultReceiver != null) {
            a2.a = resultReceiver;
        }
        if ("com.xiaomi.midrop.action.START_DISCOVERY".equals((Object)intent.getAction())) {
            this.b = true;
            this.a.c();
            return 2;
        }
        if ("com.xiaomi.midrop.action.STOP_DISCOVERY".equals((Object)intent.getAction())) {
            this.b = false;
            if (!this.c) {
                this.a.d();
            }
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        this.c = false;
        if (!(this.a.h() || this.c || this.b)) {
            this.stopSelf();
        }
        return true;
    }
}

