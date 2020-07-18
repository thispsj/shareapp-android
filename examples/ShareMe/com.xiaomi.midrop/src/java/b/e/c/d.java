/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.net.wifi.WifiInfo
 *  android.net.wifi.WifiManager
 *  android.os.Parcelable
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.List
 */
package b.e.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.List;

public class d
extends BroadcastReceiver {
    private static final String a = "b.e.c.d";
    private Context b;
    private boolean c;
    private a d;

    public d(Context context, a a2) {
        this.b = context;
        this.d = a2;
        this.c = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void a() {
        d d2 = this;
        // MONITORENTER : d2
        d2 = this;
        // MONITORENTER : d2
        if (this.c) {
            this.c = false;
            try {
                this.b.unregisterReceiver((BroadcastReceiver)this);
                return;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        // MONITOREXIT : d2
        // MONITOREXIT : d2
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void a(String string2) {
        void var6_2 = this;
        // MONITORENTER : var6_2
        var6_2 = this;
        // MONITORENTER : var6_2
        if (!this.c) {
            this.c = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(string2);
            this.b.registerReceiver((BroadcastReceiver)this, intentFilter);
        }
        // MONITOREXIT : var6_2
        // MONITOREXIT : var6_2
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void a(List<String> list) {
        void var7_2 = this;
        // MONITORENTER : var7_2
        var7_2 = this;
        // MONITORENTER : var7_2
        if (!this.c) {
            this.c = true;
            IntentFilter intentFilter = new IntentFilter();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                intentFilter.addAction((String)iterator.next());
            }
            this.b.registerReceiver((BroadcastReceiver)this, intentFilter);
        }
        // MONITOREXIT : var7_2
        // MONITOREXIT : var7_2
    }

    public void onReceive(Context context, Intent intent) {
        String string2 = intent.getAction();
        if (string2.equals((Object)"android.net.wifi.WIFI_AP_STATE_CHANGED")) {
            this.d.a(intent.getIntExtra("wifi_state", 0));
            return;
        }
        if (string2.equals((Object)"android.net.wifi.WIFI_STATE_CHANGED")) {
            int n2 = intent.getIntExtra("wifi_state", 0);
            this.d.b(n2);
            return;
        }
        if (!string2.equals((Object)"android.net.wifi.SCAN_RESULTS")) {
            if ("android.net.wifi.STATE_CHANGE".equals((Object)string2)) {
                NetworkInfo networkInfo = (NetworkInfo)intent.getParcelableExtra("networkInfo");
                WifiInfo wifiInfo = (WifiInfo)intent.getParcelableExtra("wifiInfo");
                this.d.a(networkInfo, wifiInfo);
                return;
            }
            if (string2.equals((Object)"android.net.conn.CONNECTIVITY_CHANGE")) {
                NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (networkInfo == null) {
                    return;
                }
                if (networkInfo.getType() != 1) {
                    return;
                }
                WifiInfo wifiInfo = ((WifiManager)context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                this.d.a(networkInfo, wifiInfo);
            }
        }
    }

    public static interface a {
        public void a(int var1);

        public void a(NetworkInfo var1, WifiInfo var2);

        public void b(int var1);
    }

}

