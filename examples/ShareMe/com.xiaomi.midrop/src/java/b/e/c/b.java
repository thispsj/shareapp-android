/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  java.lang.Object
 *  java.lang.String
 */
package b.e.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public final class b
extends BroadcastReceiver {
    private Context a;
    private boolean b;
    private a c;

    public b(Context context, a a2) {
        this.a = context;
        this.c = a2;
        this.b = false;
    }

    public final void a() {
        if (!this.b) {
            this.b = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_AP_STATE_CHANGED");
            this.a.registerReceiver((BroadcastReceiver)this, intentFilter);
        }
    }

    public final void b() {
        if (this.b) {
            this.b = false;
            this.a.unregisterReceiver((BroadcastReceiver)this);
        }
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals((Object)"android.net.wifi.WIFI_AP_STATE_CHANGED")) {
            this.c.a(intent.getIntExtra("wifi_state", 0));
        }
    }

    public static interface a {
        public void a(int var1);
    }

}

