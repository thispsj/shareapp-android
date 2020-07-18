/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.net.NetworkInfo$State
 *  android.net.wifi.WifiConfiguration
 *  android.net.wifi.WifiConfiguration$KeyMgmt
 *  android.net.wifi.WifiInfo
 *  android.net.wifi.WifiManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.NoSuchMethodError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.BitSet
 *  java.util.List
 *  java.util.Locale
 *  java.util.Timer
 *  java.util.TimerTask
 */
package b.e.a.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import b.e.a.a.a.a.d;
import b.e.a.a.a.b;
import b.e.c.c;
import b.e.c.d;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import midrop.service.c.e;

public final class b
extends b.e.a.a.a.a {
    WifiManager d;
    WifiConfiguration e;
    String f;
    final a g;
    private Context h;
    private WifiConfiguration i;
    private int j;
    private b.e.c.d k;

    b(Context context, WifiManager wifiManager) {
        this.g = new Object((b)this, 0){
            int a;
            boolean b;
            final /* synthetic */ b c;
            {
                this.c = b2;
                this.a = -1;
                this.b = false;
            }
        };
        this.h = context;
        this.d = wifiManager;
    }

    private WifiConfiguration a(String string2, String string3, int n2) {
        WifiConfiguration wifiConfiguration2;
        block12 : {
            block11 : {
                List list = this.d.getConfiguredNetworks();
                if (list != null) {
                    for (WifiConfiguration wifiConfiguration2 : list) {
                        if (wifiConfiguration2.SSID == null) continue;
                        Locale locale = Locale.US;
                        Object[] arrobject = new Object[]{wifiConfiguration2.SSID, wifiConfiguration2.networkId};
                        String.format((Locale)locale, (String)"[%s] networkId = %s", (Object[])arrobject);
                        if (!wifiConfiguration2.SSID.equals((Object)string2)) continue;
                        if (wifiConfiguration2.preSharedKey != null && wifiConfiguration2.preSharedKey.equals((Object)string3)) {
                            Locale locale2 = Locale.US;
                            Object[] arrobject2 = new Object[]{wifiConfiguration2.networkId};
                            String.format((Locale)locale2, (String)"configure exist, networkId: %d", (Object[])arrobject2);
                            break block11;
                        }
                        d.a(this.d, wifiConfiguration2.networkId);
                        Locale locale3 = Locale.US;
                        Object[] arrobject3 = new Object[]{string2, wifiConfiguration2.networkId, wifiConfiguration2.preSharedKey};
                        midrop.service.c.d.b("WifiHackerApi19", String.format((Locale)locale3, (String)"Pwd not equals => [SSID = %s], [network = %d], [password = %s]", (Object[])arrobject3), new Object[0]);
                        break;
                    }
                }
                wifiConfiguration2 = null;
            }
            if (wifiConfiguration2 == null) {
                wifiConfiguration2 = new WifiConfiguration();
                wifiConfiguration2.allowedAuthAlgorithms.clear();
                wifiConfiguration2.allowedGroupCiphers.clear();
                wifiConfiguration2.allowedKeyManagement.clear();
                wifiConfiguration2.allowedPairwiseCiphers.clear();
                wifiConfiguration2.allowedProtocols.clear();
                wifiConfiguration2.SSID = string2;
                wifiConfiguration2.networkId = -1;
                switch (5.a[n2 - 1]) {
                    default: {
                        break block12;
                    }
                    case 3: {
                        StringBuilder stringBuilder = new StringBuilder("\"");
                        stringBuilder.append(string3);
                        stringBuilder.append("\"");
                        wifiConfiguration2.preSharedKey = stringBuilder.toString();
                        wifiConfiguration2.hiddenSSID = true;
                        wifiConfiguration2.allowedAuthAlgorithms.set(0);
                        wifiConfiguration2.allowedGroupCiphers.set(2);
                        wifiConfiguration2.allowedKeyManagement.set(1);
                        wifiConfiguration2.allowedPairwiseCiphers.set(1);
                        wifiConfiguration2.allowedGroupCiphers.set(3);
                        wifiConfiguration2.allowedPairwiseCiphers.set(2);
                        wifiConfiguration2.status = 2;
                        break block12;
                    }
                    case 2: {
                        wifiConfiguration2.hiddenSSID = true;
                        String[] arrstring = wifiConfiguration2.wepKeys;
                        StringBuilder stringBuilder = new StringBuilder("\"");
                        stringBuilder.append(string3);
                        stringBuilder.append("\"");
                        arrstring[0] = stringBuilder.toString();
                        wifiConfiguration2.allowedAuthAlgorithms.set(1);
                        wifiConfiguration2.allowedGroupCiphers.set(3);
                        wifiConfiguration2.allowedGroupCiphers.set(2);
                        wifiConfiguration2.allowedGroupCiphers.set(0);
                        wifiConfiguration2.allowedGroupCiphers.set(1);
                        break;
                    }
                    case 1: {
                        wifiConfiguration2.wepKeys[0] = "\"\"";
                    }
                }
                wifiConfiguration2.allowedKeyManagement.set(0);
                wifiConfiguration2.wepTxKeyIndex = 0;
            }
        }
        try {
            WifiConfiguration wifiConfiguration3 = b.d.c.a(wifiConfiguration2);
            return wifiConfiguration3;
        }
        catch (NoSuchMethodError noSuchMethodError) {
            noSuchMethodError.printStackTrace();
            return wifiConfiguration2;
        }
    }

    public static String a(String string2) {
        int n2;
        int n3 = string2.length();
        if (n3 > 1 && string2.charAt(0) == '\"' && string2.charAt(n2 = n3 - 1) == '\"') {
            string2 = string2.substring(1, n2);
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public final int a() {
        a a2;
        if (this.k != null) {
            this.k.a();
        }
        e.a("sys_midrop_aphost", "stop");
        if (!this.d.isWifiEnabled()) {
            return 9004;
        }
        a a3 = a2 = this.g;
        // MONITORENTER : a3
        this.g.notify();
        // MONITOREXIT : a3
        if (this.e == null) return 0;
        this.d.removeNetwork(this.j);
        this.d.disconnect();
        this.e = null;
        this.j = 0;
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final int a(int n2) {
        void var17_2 = this;
        synchronized (var17_2) {
            e.a("sys_midrop_aphost", "stop");
            int n4 = d.a(this.d);
            int n3 = 0;
            if (n4 != 11) {
                if (n4 == 14) {
                    n3 = 0;
                } else {
                    Object object;
                    b.e.c.d d2;
                    block21 : {
                        object = new /* invalid duplicate definition of identical inner class */;
                        d2 = new b.e.c.d(this.h, new d.a(object){
                            final /* synthetic */ a a;
                            {
                                this.a = a2;
                            }

                            /*
                             * Enabled aggressive block sorting
                             * Enabled unnecessary exception pruning
                             * Enabled aggressive exception aggregation
                             */
                            @Override
                            public final void a(int n2) {
                                Locale locale = Locale.US;
                                Object[] arrobject = new Object[]{c.a(n2)};
                                String.format((Locale)locale, (String)"onApStateChanged: %s", (Object[])arrobject);
                                if (n2 == 11) {
                                    a a2;
                                    a a3 = a2 = this.a;
                                    synchronized (a3) {
                                        this.a.a = n2;
                                        this.a.notify();
                                        return;
                                    }
                                }
                            }

                            @Override
                            public final void a(NetworkInfo networkInfo, WifiInfo wifiInfo) {
                            }

                            @Override
                            public final void b(int n2) {
                            }
                        });
                        d2.a("android.net.wifi.WIFI_AP_STATE_CHANGED");
                        if (d.a(this.d) == 10) {
                            Object object2 = object;
                            synchronized (object2) {
                                long l2 = n2;
                                try {
                                    try {
                                        object.wait(l2);
                                    }
                                    catch (InterruptedException interruptedException) {
                                        interruptedException.printStackTrace();
                                    }
                                    break block21;
                                }
                                catch (Throwable throwable2) {}
                                throw throwable2;
                            }
                        }
                        if (d.a(this.d, this.e, false)) {
                            Object object3 = object;
                            synchronized (object3) {
                                long l3 = n2;
                                try {
                                    try {
                                        object.wait(l3);
                                    }
                                    catch (InterruptedException interruptedException) {
                                        interruptedException.printStackTrace();
                                    }
                                    break block21;
                                }
                                catch (Throwable throwable3) {}
                                throw throwable3;
                            }
                        }
                    }
                    d2.a();
                    int n5 = object.a;
                    n3 = 0;
                    if (n5 != 11) {
                        n3 = object.a == 14 ? 0 : 9004;
                    }
                }
            }
            if (this.i != null) {
                d.a(this.d, this.i);
                this.i = null;
            }
            return n3;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public final int a(String string2, String string3, String string4, int n2, int n3) {
        b.e.c.d d2;
        block13 : {
            a a2;
            e.a("sys_midrop_aphost", "running");
            if (!this.d.isWifiEnabled()) {
                d.a(this.d, null, false);
                int n4 = this.a(true, 10000);
                if (n4 != 0) return n4;
            }
            StringBuilder stringBuilder = new StringBuilder("\"");
            stringBuilder.append(string2);
            stringBuilder.append("\"");
            String string5 = stringBuilder.toString();
            NetworkInfo networkInfo = ((ConnectivityManager)this.h.getSystemService("connectivity")).getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                if (TextUtils.equals((CharSequence)networkInfo.getExtraInfo(), (CharSequence)string5)) {
                    this.j = this.d.getConnectionInfo().getNetworkId();
                    new StringBuilder("Wifi AlreadyConnected mWifiNetId = ").append(this.j);
                    return 0;
                }
                this.d.disconnect();
            }
            this.e = this.a(string5, string4, n2);
            if (this.e == null) {
                midrop.service.c.d.b("WifiHackerApi19", "createWifiConfiguration failed", new Object[0]);
                return 9007;
            }
            int n5 = this.e.networkId == -1 ? this.d.addNetwork(this.e) : this.e.networkId;
            this.j = n5;
            if (this.j == -1) {
                midrop.service.c.d.b("WifiHackerApi19", "addNetwork failed: -1", new Object[0]);
                this.e = null;
                return 9008;
            }
            d2 = new b.e.c.d(this.h, new d.a(){

                @Override
                public final void a(int n2) {
                    WifiInfo wifiInfo = b.this.d.getConnectionInfo();
                    Locale locale = Locale.US;
                    Object[] arrobject = new Object[]{wifiInfo.getSSID(), c.a(n2)};
                    String.format((Locale)locale, (String)"onWifiApStateChanged: %s %s", (Object[])arrobject);
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                @Override
                public final void a(NetworkInfo networkInfo, WifiInfo wifiInfo) {
                    Locale locale = Locale.US;
                    Object[] arrobject = new Object[]{networkInfo.getExtraInfo(), networkInfo.getState()};
                    String.format((Locale)locale, (String)"onNetworkStateChanged: %s %s", (Object[])arrobject);
                    if (networkInfo.isConnected() && b.this.e != null) {
                        String string2 = networkInfo.getExtraInfo();
                        String string3 = b.this.e.SSID;
                        String.format((Locale)Locale.US, (String)"connected: %s", (Object[])new Object[]{string2});
                        if (b.a(string2).equals((Object)b.a(string3))) {
                            a a2;
                            b b2 = b.this;
                            int n2 = wifiInfo.getIpAddress();
                            StringBuffer stringBuffer = new StringBuffer();
                            int n3 = 255 & n2 >> 0;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(n3);
                            stringBuilder.append(".");
                            stringBuffer.append(stringBuilder.toString());
                            int n4 = 255 & n2 >> 8;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(n4);
                            stringBuilder2.append(".");
                            stringBuffer.append(stringBuilder2.toString());
                            int n5 = 255 & n2 >> 16;
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(n5);
                            stringBuilder3.append(".");
                            stringBuffer.append(stringBuilder3.toString());
                            stringBuffer.append(255 & n2 >> 24);
                            b2.f = stringBuffer.toString();
                            a a3 = a2 = b.this.g;
                            synchronized (a3) {
                                b.this.g.b = true;
                                b.this.g.notify();
                                return;
                            }
                        }
                    }
                }

                @Override
                public final void b(int n2) {
                    WifiInfo wifiInfo = b.this.d.getConnectionInfo();
                    Locale locale = Locale.US;
                    Object[] arrobject = new Object[]{wifiInfo.getSSID(), c.a(n2)};
                    String.format((Locale)locale, (String)"onWifiStateChanged: %s %s", (Object[])arrobject);
                }
            });
            ArrayList arrayList = new ArrayList();
            String string6 = Build.VERSION.SDK_INT >= 21 ? "android.net.conn.CONNECTIVITY_CHANGE" : "android.net.wifi.STATE_CHANGE";
            arrayList.add((Object)string6);
            d2.a((List<String>)arrayList);
            if (this.d.enableNetwork(this.j, true)) {
                Locale locale = Locale.US;
                Object[] arrobject = new Object[]{this.j};
                String.format((Locale)locale, (String)"connect network id = %s succeed!", (Object[])arrobject);
            } else {
                Locale locale = Locale.US;
                Object[] arrobject = new Object[]{this.j};
                String.format((Locale)locale, (String)"connect network id = %s failed!", (Object[])arrobject);
                this.e = null;
            }
            a a3 = a2 = this.g;
            // MONITORENTER : a3
            this.g.wait((long)n3);
            break block13;
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        // MONITOREXIT : a3
        d2.a();
        new StringBuilder("lock connected status:").append(this.g.b);
        if (!this.g.b) return 9006;
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final int a(String string2, String string3, boolean bl, int n2) {
        void var22_5 = this;
        synchronized (var22_5) {
            StringBuilder stringBuilder = new StringBuilder();
            Locale locale = Locale.US;
            Object[] arrobject = new Object[2];
            arrobject[0] = string2;
            Integer n5 = n2;
            int n3 = 1;
            arrobject[n3] = n5;
            stringBuilder.append(String.format((Locale)locale, (String)"startWifiAp(%s): %d", (Object[])arrobject));
            stringBuilder.append(" v19");
            if (string2 == null) return n3;
            if (string3 != null && string2.length() <= 32 && n2 >= 0) {
                Object object;
                block14 : {
                    int n4;
                    block13 : {
                        e.a("sys_midrop_aphost_internal", "running");
                        int n6 = this.a(10000);
                        e.a("sys_midrop_aphost_internal", "stop");
                        if (n6 != 0) return n6;
                        int n7 = this.a(false, 10000);
                        if (n7 != 0) return n7;
                        String[] arrstring = WifiConfiguration.KeyMgmt.strings;
                        for (n4 = 0; n4 < arrstring.length; ++n4) {
                            if (!TextUtils.equals((CharSequence)arrstring[n4], (CharSequence)"WPA2_PSK")) {
                                continue;
                            }
                            break block13;
                        }
                        n4 = 0;
                    }
                    this.i = d.b(this.d);
                    this.e = new WifiConfiguration();
                    this.e.SSID = string2;
                    this.e.preSharedKey = string3;
                    this.e.allowedAuthAlgorithms.set(0);
                    this.e.allowedProtocols.set(n3);
                    this.e.allowedProtocols.set(0);
                    this.e.allowedKeyManagement.set(n4);
                    this.e.allowedPairwiseCiphers.set(2);
                    this.e.allowedPairwiseCiphers.set(n3);
                    this.e.allowedGroupCiphers.set(3);
                    this.e.allowedGroupCiphers.set(2);
                    d.a(this.e, this.c);
                    e.a("sys_midrop_aphost", "running");
                    object = new /* invalid duplicate definition of identical inner class */;
                    this.k = new b.e.c.d(this.h, new d.a(object){
                        final /* synthetic */ a a;
                        {
                            this.a = a2;
                        }

                        /*
                         * Enabled aggressive block sorting
                         * Enabled unnecessary exception pruning
                         * Enabled aggressive exception aggregation
                         */
                        @Override
                        public final void a(int n2) {
                            Locale locale = Locale.US;
                            Object[] arrobject = new Object[]{c.a(n2)};
                            String.format((Locale)locale, (String)"onWifiApStateChanged: %s", (Object[])arrobject);
                            if (n2 == 12) {
                                this.a.a = n2;
                                return;
                            }
                            if (n2 == 13) {
                                a a2;
                                this.a.a = n2;
                                a a3 = a2 = this.a;
                                synchronized (a3) {
                                    this.a.notify();
                                    return;
                                }
                            }
                            if (n2 == 11) {
                                this.a.a = n2;
                                new Timer().schedule(new TimerTask(this){
                                    final /* synthetic */ 1 a;
                                    {
                                        this.a = var1;
                                    }

                                    /*
                                     * Enabled aggressive block sorting
                                     * Enabled unnecessary exception pruning
                                     * Enabled aggressive exception aggregation
                                     */
                                    public final void run() {
                                        if (this.a.a.a == 11) {
                                            a a2;
                                            a a3 = a2 = this.a.a;
                                            synchronized (a3) {
                                                this.a.a.notify();
                                                return;
                                            }
                                        }
                                    }
                                }, 10000L);
                            }
                        }

                        @Override
                        public final void a(NetworkInfo networkInfo, WifiInfo wifiInfo) {
                        }

                        @Override
                        public final void b(int n2) {
                        }
                    });
                    this.k.a("android.net.wifi.WIFI_AP_STATE_CHANGED");
                    if (d.a(this.d, this.e, (boolean)n3)) {
                        Object object2 = object;
                        synchronized (object2) {
                            long l2 = n2;
                            try {
                                try {
                                    object.wait(l2);
                                }
                                catch (InterruptedException interruptedException) {
                                    interruptedException.printStackTrace();
                                }
                                break block14;
                            }
                            catch (Throwable throwable2) {}
                            throw throwable2;
                        }
                    }
                }
                this.k.a();
                if (object.a == 13) {
                    return 0;
                }
                e.a("sys_midrop_aphost", "stop");
                return 9003;
            }
            return n3;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final int a(boolean bl, int n2) {
        Object object;
        b.e.c.d d2;
        int n3;
        block15 : {
            if (n2 < 0) {
                return 1;
            }
            int n4 = bl ? 2 : 0;
            n3 = bl ? 3 : 1;
            if (n3 == this.d.getWifiState()) {
                return 0;
            }
            object = new /* invalid duplicate definition of identical inner class */;
            d2 = new b.e.c.d(this.h, new d.a(object){
                final /* synthetic */ a b;
                {
                    this.b = a2;
                }

                @Override
                public final void a(int n2) {
                }

                @Override
                public final void a(NetworkInfo networkInfo, WifiInfo wifiInfo) {
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                @Override
                public final void b(int n2) {
                    Locale locale = Locale.US;
                    Object[] arrobject = new Object[]{c.a(n2)};
                    String.format((Locale)locale, (String)"onWifiStateChanged: %s", (Object[])arrobject);
                    if (n2 == n3) {
                        a a2;
                        a a3 = a2 = this.b;
                        synchronized (a3) {
                            this.b.a = n2;
                            this.b.notify();
                            return;
                        }
                    }
                }
            });
            d2.a("android.net.wifi.WIFI_STATE_CHANGED");
            if (n4 == d.a(this.d)) {
                Object object2 = object;
                synchronized (object2) {
                    long l2 = n2;
                    try {
                        try {
                            object.wait(l2);
                        }
                        catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        return 9000;
                    }
                    catch (Throwable throwable2) {}
                    throw throwable2;
                }
            }
            if (this.d.setWifiEnabled(bl)) {
                Locale locale = Locale.US;
                Object[] arrobject = new Object[]{Boolean.toString((boolean)bl)};
                String.format((Locale)locale, (String)"setWifiEnabled(%s), waiting...", (Object[])arrobject);
                Object object3 = object;
                synchronized (object3) {
                    long l3 = n2;
                    try {
                        try {
                            object.wait(l3);
                        }
                        catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        break block15;
                    }
                    catch (Throwable throwable3) {}
                    throw throwable3;
                }
            }
        }
        d2.a();
        if (object.a == n3) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{Boolean.toString((boolean)bl)};
            String.format((Locale)locale, (String)"setWifiEnabled(%s): OK", (Object[])arrobject);
            return 0;
        }
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{Boolean.toString((boolean)bl)};
        String.format((Locale)locale, (String)"setWifiEnabled(%s): FAILED", (Object[])arrobject);
        return 9005;
    }

}

