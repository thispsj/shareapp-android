/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningServiceInfo
 *  android.app.Service
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Message
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.os.ResultReceiver
 *  com.xiaomi.midrop.receiver.service.a
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 *  midrop.b.c.a
 *  midrop.service.b.a
 *  midrop.service.c.d
 */
package com.xiaomi.midrop.receiver.service;

import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.xiaomi.midrop.receiver.service.a;
import java.util.List;
import midrop.service.c.d;

public class ReceiverService
extends Service {
    private final int a = 1;
    private final int b = 5000;
    private a c;
    private Handler d = new Handler(){

        public final void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            ReceiverService.this.stopSelf();
        }
    };

    public static void a(Context context) {
        try {
            Intent intent = new Intent(context, ReceiverService.class);
            intent.putExtra("extra_command", "stop");
            context.startService(intent);
            return;
        }
        catch (Exception exception) {
            new StringBuilder("Starting service issue on stopReceiverService =").append((Object)exception);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context context, ResultReceiver resultReceiver) {
        try {
            Intent intent = new Intent(context, ReceiverService.class);
            if (resultReceiver != null) {
                intent.putExtra("result_receiver", (Parcelable)resultReceiver);
            }
            intent.putExtra("extra_command", "start");
            context.startService(intent);
            return;
        }
        catch (Exception exception) {
            new StringBuilder("Starting service issue on startReceiverService =").append((Object)exception);
            return;
        }
    }

    public static int b(Context context) {
        int n2 = 0;
        if (context != null) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager)context.getSystemService("activity")).getRunningServices(500)) {
                if (!runningServiceInfo.service.getPackageName().equals((Object)context.getPackageName()) || !runningServiceInfo.service.getClassName().equals((Object)ReceiverService.class.getName())) continue;
                n2 = runningServiceInfo.pid;
            }
        }
        return n2;
    }

    public static ActivityManager.RunningServiceInfo c(Context context) {
        List list = ((ActivityManager)context.getSystemService("activity")).getRunningServices(500);
        if (list != null && list.size() > 0) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : list) {
                if (!runningServiceInfo.service.getPackageName().equals((Object)context.getPackageName()) || !runningServiceInfo.service.getClassName().equals((Object)ReceiverService.class.getName())) continue;
                return runningServiceInfo;
            }
        }
        return null;
    }

    public IBinder onBind(Intent intent) {
        return this.c;
    }

    public void onCreate() {
        super.onCreate();
        this.c = new a((Context)this);
    }

    public void onDestroy() {
        try {
            this.c.b();
        }
        catch (RemoteException remoteException) {
            d.a((String)"ReceiverService", (String)"RemoteException", (Throwable)remoteException, (Object[])new Object[0]);
        }
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    public int onStartCommand(Intent intent, int n2, int n3) {
        new StringBuilder("onStartCommand, intent=").append((Object)intent);
        if (intent == null) {
            return 2;
        }
        if ("stop".equals((Object)intent.getStringExtra("extra_command"))) {
            this.d.removeMessages(1);
            this.d.sendEmptyMessageDelayed(1, 5000L);
            try {
                this.c.b();
                return 2;
            }
            catch (RemoteException remoteException) {
                d.a((String)"ReceiverService", (String)"RemoteException", (Throwable)remoteException, (Object[])new Object[0]);
                return 2;
            }
        }
        try {
            ResultReceiver resultReceiver = (ResultReceiver)intent.getParcelableExtra("result_receiver");
            this.d.removeMessages(1);
            this.c.a();
            a a2 = this.c;
            if (a2.a != null) {
                midrop.service.b.a a3 = a2.a;
                a3.l = resultReceiver;
                if (a3.h != null) {
                    a3.h.a(resultReceiver);
                }
                if (a3.i != null) {
                    a3.i.a(resultReceiver);
                    return 2;
                }
            }
        }
        catch (RemoteException remoteException) {
            d.a((String)"ReceiverService", (String)"RemoteException", (Throwable)remoteException, (Object[])new Object[0]);
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

}

