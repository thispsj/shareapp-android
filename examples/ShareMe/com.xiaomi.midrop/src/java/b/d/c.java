/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.wifi.WifiConfiguration
 *  android.net.wifi.WifiManager
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package b.d;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;

public class c {
    public static final long[] a = new long[]{600L, 800L, 1000L, 1200L, 1200L};
    private static final String b = "b.d.c";

    public static WifiConfiguration a(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration == null) {
            wifiConfiguration = null;
        }
        return wifiConfiguration;
    }

    public static void a(WifiManager wifiManager) {
        try {
            wifiManager.startScan();
        }
        catch (NullPointerException nullPointerException) {}
    }
}

