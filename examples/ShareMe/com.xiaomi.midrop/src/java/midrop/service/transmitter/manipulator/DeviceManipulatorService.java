/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 *  midrop.service.transmitter.manipulator.a
 */
package midrop.service.transmitter.manipulator;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import midrop.service.transmitter.manipulator.a;

public class DeviceManipulatorService
extends Service {
    public IBinder onBind(Intent intent) {
        return a.b();
    }

    public void onCreate() {
        super.onCreate();
        a.b().a((Context)this);
    }

    public void onDestroy() {
        a.b().c();
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}

