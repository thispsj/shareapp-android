/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.wifi.WifiManager
 *  android.net.wifi.WifiManager$LocalOnlyHotspotCallback
 *  android.net.wifi.WifiManager$LocalOnlyHotspotReservation
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.SystemClock
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.Thread
 */
package b.e.a.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import b.e.a.a;
import b.e.a.a.a;
import b.e.a.a.a.a.d;

public final class a
implements b.e.a.a {
    a.a a;
    volatile WifiManager.LocalOnlyHotspotReservation b;
    private b.e.a.a.a.a c;
    private WifiManager d;

    public a(Context context) {
        this.d = (WifiManager)context.getApplicationContext().getSystemService("wifi");
        this.c = new b.e.a.a.a.a(context, this.d);
    }

    @Override
    public final int a() {
        if (Build.VERSION.SDK_INT >= 26 && this.b != null) {
            String string2;
            block5 : {
                int n2;
                this.b.close();
                this.b = null;
                long l2 = SystemClock.elapsedRealtime();
                while ((n2 = d.a(this.d)) != 11 && n2 != 14) {
                    if (SystemClock.elapsedRealtime() - l2 > 10000L) {
                        string2 = "stopWifiAp not ok by HotspotReservation,timeout 10s";
                        break block5;
                    }
                    try {
                        Thread.sleep((long)500L);
                    }
                    catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
                string2 = "stopWifiAp OK by HotspotReservation";
            }
            midrop.service.c.d.a(string2, new Object[0]);
            return 0;
        }
        return this.c.a(10000);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public final int a(a.a a2) {
        this.a = a2;
        int n2 = this.c.a(10000);
        if (n2 != 0) {
            midrop.service.c.d.b("WifiApImpl", "stopWifiAp failed", new Object[0]);
            if (this.a == null) return 0;
            this.a.a(n2);
            return 0;
        }
        try {
            this.d.startLocalOnlyHotspot(new WifiManager.LocalOnlyHotspotCallback((a)this){
                final /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public final void onFailed(int n2) {
                    java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder("Start local hotspot failed, reason=");
                    stringBuilder.append(n2);
                    midrop.service.c.d.b("WifiApImpl", stringBuilder.toString(), new Object[0]);
                    if (this.a.a != null) {
                        this.a.a.a(n2 + 9015);
                    }
                }

                public final void onStarted(WifiManager.LocalOnlyHotspotReservation localOnlyHotspotReservation) {
                    super.onStarted(localOnlyHotspotReservation);
                    this.a.b = localOnlyHotspotReservation;
                    if (this.a.a != null) {
                        android.net.wifi.WifiConfiguration wifiConfiguration = localOnlyHotspotReservation.getWifiConfiguration();
                        this.a.a.a(wifiConfiguration.SSID, wifiConfiguration.BSSID, wifiConfiguration.preSharedKey);
                    }
                }

                public final void onStopped() {
                    super.onStopped();
                }
            }, null);
            return 0;
        }
        catch (IllegalStateException illegalStateException) {
            int n3;
            a.a a3;
            block4 : {
                midrop.service.c.d.a("WifiApImpl", "startLocalOnlyHotspot", illegalStateException, new Object[0]);
                if (this.a == null) return 0;
                a3 = this.a;
                n3 = 9026;
                break block4;
                catch (SecurityException securityException) {
                    midrop.service.c.d.a("WifiApImpl", "startLocalOnlyHotspot", securityException, new Object[0]);
                    if (this.a == null) return 0;
                    a3 = this.a;
                    n3 = 9014;
                }
            }
            a3.a(n3);
            return 0;
        }
    }

    @Override
    public final int a(b.e.a.b.a a2) {
        return this.c.a(a2.a(), a2.h, false, 10000);
    }

    @Override
    public final int a(String string2, String string3, boolean bl) {
        return this.c.a(string2, string3, bl, 10000);
    }

    @Override
    public final boolean b() {
        return Build.VERSION.SDK_INT >= 26;
    }
}

