/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.os.Binder
 *  android.os.IBinder
 *  java.lang.String
 *  midrop.service.transmitter.fileserver.a
 *  midrop.service.transmitter.fileserver.b
 */
package midrop.service.transmitter.fileserver;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import midrop.service.transmitter.fileserver.a;
import midrop.service.transmitter.fileserver.b;

public class FileServerService
extends Service {
    private static final String a = "FileServerService";
    private b b;

    public IBinder onBind(Intent intent) {
        int n2 = Binder.getCallingUid();
        return new a(this.getPackageManager().getNameForUid(n2), this.b);
    }

    public void onCreate() {
        super.onCreate();
        this.b = new b((Context)this);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}

