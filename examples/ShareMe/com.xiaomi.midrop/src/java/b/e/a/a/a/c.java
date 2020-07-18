/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.net.Network
 *  android.net.NetworkInfo
 *  android.net.NetworkRequest
 *  android.net.NetworkRequest$Builder
 *  android.net.wifi.WifiConfiguration
 *  android.net.wifi.WifiConfiguration$KeyMgmt
 *  android.net.wifi.WifiInfo
 *  android.net.wifi.WifiManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Float
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.NoSuchFieldException
 *  java.lang.NoSuchMethodError
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.util.BitSet
 *  java.util.List
 *  java.util.Locale
 *  java.util.Timer
 *  java.util.TimerTask
 */
package b.e.a.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import b.e.a.a.a.a.a;
import b.e.a.a.a.a.d;
import b.e.a.a.a.c;
import b.e.c.d;
import java.lang.reflect.Field;
import java.util.BitSet;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import midrop.service.c.e;

public final class c
extends b.e.a.a.a.a {
    Context d;
    WifiManager e;
    int f = -1;
    a g;
    final b h;
    private ConnectivityManager i;
    private WifiConfiguration j;
    private WifiConfiguration k;

    public c(Context context, WifiManager wifiManager) {
        this.h = new Object((c)this, 0){
            int a;
            boolean b;
            final /* synthetic */ c c;
            {
                this.c = c2;
                this.a = -1;
                this.b = false;
            }
        };
        this.d = context;
        this.e = wifiManager;
        this.i = (ConnectivityManager)this.d.getSystemService("connectivity");
    }

    private WifiConfiguration a(String string2, String string3, int n2) {
        WifiConfiguration wifiConfiguration2;
        block11 : {
            List list = this.e.getConfiguredNetworks();
            if (list != null) {
                for (WifiConfiguration wifiConfiguration2 : list) {
                    if (wifiConfiguration2.SSID == null || !wifiConfiguration2.SSID.equals((Object)string2)) continue;
                    break;
                }
            } else {
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
                        break block11;
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
                        break block11;
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

    private void b() {
        ConnectivityManager connectivityManager = (ConnectivityManager)this.d.getSystemService("connectivity");
        if (connectivityManager == null) {
            throw new IllegalStateException("Bad luck, ConnectivityService not started.");
        }
        if (this.g == null) {
            NetworkRequest networkRequest = new NetworkRequest.Builder().addTransportType(1).removeCapability(12).build();
            this.g = new ConnectivityManager.NetworkCallback(this, 0){
                final /* synthetic */ c a;
                private Network b;
                {
                    this.a = c2;
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public final void onAvailable(Network network) {
                    WifiInfo wifiInfo = this.a.e.getConnectionInfo();
                    String.format((Locale)Locale.US, (String)"Callback onAvailable", (Object[])new Object[0]);
                    Locale locale = Locale.US;
                    Object[] arrobject = new Object[]{wifiInfo.getNetworkId(), this.a.f};
                    String.format((Locale)locale, (String)"onAvailable Network id = %s, mWifiNetId = %s", (Object[])arrobject);
                    if (this.a.f != wifiInfo.getNetworkId()) {
                        b b2;
                        b b3 = b2 = this.a.h;
                        synchronized (b3) {
                            this.a.h.notify();
                            return;
                        }
                    }
                    if (ConnectivityManager.getProcessDefaultNetwork() == null && this.b == null) {
                        b b4;
                        ConnectivityManager.setProcessDefaultNetwork((Network)network);
                        this.b = network;
                        b b5 = b4 = this.a.h;
                        synchronized (b5) {
                            this.a.h.b = true;
                            this.a.h.notify();
                            return;
                        }
                    }
                }

                public final void onLost(Network network) {
                    if (network.equals((Object)this.b) && network.equals((Object)ConnectivityManager.getProcessDefaultNetwork())) {
                        String.format((Locale)Locale.US, (String)"Callback onLost", (Object[])new Object[0]);
                        ConnectivityManager.setProcessDefaultNetwork(null);
                        this.b = null;
                        c c2 = this.a;
                        ConnectivityManager connectivityManager = (ConnectivityManager)c2.d.getSystemService("connectivity");
                        if (connectivityManager == null) {
                            throw new IllegalStateException("Bad luck, ConnectivityService not started.");
                        }
                        if (c2.g != null) {
                            try {
                                connectivityManager.unregisterNetworkCallback((ConnectivityManager.NetworkCallback)c2.g);
                            }
                            catch (SecurityException securityException) {
                                midrop.service.c.d.a("WifiHackerApi21", "Failed to unregister network callback", securityException, new Object[0]);
                            }
                            c2.g = null;
                        }
                    }
                }
            };
            try {
                connectivityManager.registerNetworkCallback(networkRequest, (ConnectivityManager.NetworkCallback)this.g);
                return;
            }
            catch (SecurityException securityException) {
                midrop.service.c.d.a("WifiHackerApi21", "Failed to register network callback", securityException, new Object[0]);
            }
        }
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
        b b2;
        new StringBuilder("disconnect ").append(this.f);
        e.a("sys_midrop_aphost", "stop");
        if (!this.e.isWifiEnabled()) {
            return 9004;
        }
        b b3 = b2 = this.h;
        // MONITORENTER : b3
        this.h.notify();
        // MONITOREXIT : b3
        if (this.f == -1) return 0;
        this.e.removeNetwork(this.f);
        this.e.saveConfiguration();
        this.f = -1;
        this.e.disconnect();
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final int a(int n2) {
        void var24_2 = this;
        synchronized (var24_2) {
            long l2;
            int n3;
            block21 : {
                block20 : {
                    block19 : {
                        block18 : {
                            b.e.c.d d2;
                            Object object;
                            block17 : {
                                l2 = System.currentTimeMillis();
                                e.a("sys_midrop_aphost", "stop");
                                int n4 = d.a(this.e);
                                if (n4 == 11 || n4 == 14) break block18;
                                midrop.service.c.d.a("Stop ap", new Object[0]);
                                object = new /* invalid duplicate definition of identical inner class */;
                                d2 = new b.e.c.d(this.d, new d.a(object){
                                    final /* synthetic */ b a;
                                    {
                                        this.a = b2;
                                    }

                                    /*
                                     * Enabled aggressive block sorting
                                     * Enabled unnecessary exception pruning
                                     * Enabled aggressive exception aggregation
                                     */
                                    @Override
                                    public final void a(int n2) {
                                        Locale locale = Locale.US;
                                        Object[] arrobject = new Object[]{b.e.c.c.a(n2)};
                                        String.format((Locale)locale, (String)"onApStateChanged: %s", (Object[])arrobject);
                                        StringBuilder stringBuilder = new StringBuilder("onApStateChanged status = ");
                                        stringBuilder.append(b.e.c.c.a(n2));
                                        midrop.service.c.d.a(stringBuilder.toString(), new Object[0]);
                                        if (n2 == 11) {
                                            b b2;
                                            b b3 = b2 = this.a;
                                            synchronized (b3) {
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
                                if (d.a(this.e) == 10) {
                                    Object object2 = object;
                                    synchronized (object2) {
                                        long l3 = n2;
                                        try {
                                            try {
                                                object.wait(l3);
                                            }
                                            catch (InterruptedException interruptedException) {
                                                interruptedException.printStackTrace();
                                            }
                                            break block17;
                                        }
                                        catch (Throwable throwable2) {}
                                        throw throwable2;
                                    }
                                }
                                boolean bl = Build.VERSION.SDK_INT <= 24 ? d.a(this.e, this.j, false) : b.e.a.a.a.a.b.a(this.i);
                                if (bl) {
                                    Object object3 = object;
                                    synchronized (object3) {
                                        long l4 = n2;
                                        try {
                                            try {
                                                object.wait(l4);
                                            }
                                            catch (InterruptedException interruptedException) {
                                                interruptedException.printStackTrace();
                                            }
                                            break block17;
                                        }
                                        catch (Throwable throwable3) {}
                                        throw throwable3;
                                    }
                                }
                            }
                            d2.a();
                            if (object.a != 11 && object.a != 14) break block19;
                            break block20;
                        }
                        midrop.service.c.d.a("Ap already stopped", new Object[0]);
                        break block20;
                    }
                    n3 = 9004;
                    break block21;
                }
                n3 = 0;
            }
            if (this.k != null) {
                d.a(this.e, this.k);
                this.k = null;
            }
            long l5 = System.currentTimeMillis();
            Locale locale = Locale.getDefault();
            Object[] arrobject = new Object[]{Float.valueOf((float)((float)(l5 - l2) / 1000.0f))};
            String.format((Locale)locale, (String)"Stop WiFi Ap cost %.2f seconds", (Object[])arrobject);
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
        block19 : {
            WifiConfiguration wifiConfiguration;
            b b2;
            e.a("sys_midrop_aphost", "running");
            if (!this.e.isWifiEnabled()) {
                int n4;
                if (Build.VERSION.SDK_INT <= 23) {
                    d.a(this.e, null, false);
                }
                if ((n4 = this.a(true, 10000)) != 0) return n4;
            }
            StringBuilder stringBuilder = new StringBuilder("\"");
            stringBuilder.append(string2);
            stringBuilder.append("\"");
            String string5 = stringBuilder.toString();
            NetworkInfo networkInfo = ((ConnectivityManager)this.d.getSystemService("connectivity")).getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                if (TextUtils.equals((CharSequence)networkInfo.getExtraInfo(), (CharSequence)string5)) {
                    b b3;
                    int n5 = this.e.getConnectionInfo().getNetworkId();
                    int n6 = 0;
                    if (n5 != -1) return n6;
                    this.b();
                    b b4 = b3 = this.h;
                    // MONITORENTER : b4
                    this.h.wait((long)n3);
                    return 0;
                    catch (InterruptedException interruptedException) {
                        midrop.service.c.d.a("WifiHackerApi21", "mConnectWifiLock wait error", interruptedException, new Object[0]);
                    }
                    // MONITOREXIT : b4
                    return 0;
                }
                this.e.disconnect();
            }
            if ((wifiConfiguration = this.a(string5, string4, n2)) == null) {
                midrop.service.c.d.b("WifiHackerApi21", "createWifiConfiguration failed", new Object[0]);
                return 9007;
            }
            if (wifiConfiguration.networkId == -1) {
                this.f = this.e.addNetwork(wifiConfiguration);
            } else {
                this.f = wifiConfiguration.networkId;
                this.e.updateNetwork(wifiConfiguration);
            }
            if (this.f == -1) {
                midrop.service.c.d.b("WifiHackerApi21", "addNetwork failed: -1", new Object[0]);
                return 9008;
            }
            this.b();
            this.e.enableNetwork(this.f, true);
            d.a(this.e, this.f, new a.a(){

                @Override
                public final void a() {
                    String.format((Locale)Locale.US, (String)"connect success!", (Object[])new Object[0]);
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                @Override
                public final void b() {
                    b b2;
                    String.format((Locale)Locale.US, (String)"connect failed!", (Object[])new Object[0]);
                    b b3 = b2 = c.this.h;
                    synchronized (b3) {
                        c.this.h.notify();
                        return;
                    }
                }
            });
            b b5 = b2 = this.h;
            // MONITORENTER : b5
            this.h.wait((long)n3);
            break block19;
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        // MONITOREXIT : b5
        new StringBuilder("lock connected status:").append(this.h.b);
        if (!this.h.b) return 9006;
        return 0;
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
    public final int a(String string2, String string3, boolean bl, int n2) {
        int n3;
        block28 : {
            boolean bl2;
            int n4;
            block26 : {
                int n5;
                block25 : {
                    int n6;
                    void var25_5 = this;
                    // MONITORENTER : var25_5
                    n3 = 1;
                    if (string2 == null) break block28;
                    if (string3 == null) {
                        return n3;
                    }
                    if (string2.length() > 32) {
                        return n3;
                    }
                    if (n2 < 0) {
                        return n3;
                    }
                    e.a("sys_midrop_aphost_internal", "running");
                    int n7 = this.a(10000);
                    e.a("sys_midrop_aphost_internal", "stop");
                    if (n7 != 0) {
                        midrop.service.c.d.b("WifiHackerApi21", "stopWifiAp failed", new Object[0]);
                        return n7;
                    }
                    if (Build.VERSION.SDK_INT <= 23 && (n6 = this.a(false, 10000)) != 0) {
                        midrop.service.c.d.b("WifiHackerApi21", "setWifiEnabled(false) failed", new Object[0]);
                        return n6;
                    }
                    String[] arrstring = WifiConfiguration.KeyMgmt.strings;
                    for (n5 = 0; n5 < arrstring.length; ++n5) {
                        boolean bl3 = TextUtils.equals((CharSequence)arrstring[n5], (CharSequence)"WPA2_PSK");
                        if (!bl3) {
                            continue;
                        }
                        break block25;
                    }
                    n5 = 0;
                }
                try {
                    n4 = (Integer)WifiConfiguration.KeyMgmt.class.getField("WPA2_PSK").get(null);
                    break block26;
                }
                catch (IllegalAccessException illegalAccessException) {
                    void var10_14;
                    String string4;
                    Object[] arrobject;
                    String string5;
                    block29 : {
                        string5 = "WifiHackerApi21";
                        string4 = "IllegalAccessException";
                        arrobject = new Object[]{};
                        break block29;
                        catch (NoSuchFieldException noSuchFieldException) {
                            string5 = "WifiHackerApi21";
                            string4 = "NoSuchFieldException";
                            arrobject = new Object[]{};
                        }
                    }
                    midrop.service.c.d.a(string5, string4, (Throwable)var10_14, arrobject);
                }
                n4 = n5;
            }
            this.k = d.b(this.e);
            this.j = new WifiConfiguration();
            this.j.SSID = string2;
            this.j.preSharedKey = string3;
            this.j.allowedAuthAlgorithms.set(0);
            this.j.allowedProtocols.set(n3);
            this.j.allowedProtocols.set(0);
            this.j.allowedKeyManagement.set(n4);
            this.j.allowedPairwiseCiphers.set(2);
            this.j.allowedPairwiseCiphers.set(n3);
            this.j.allowedGroupCiphers.set(3);
            this.j.allowedGroupCiphers.set(2);
            if (bl) {
                d.b(this.j, this.b);
                d.a(this.j, 0);
            } else {
                d.b(this.j, this.a);
                d.a(this.j, this.c);
            }
            e.a("sys_midrop_aphost", "running");
            Object object = new /* invalid duplicate definition of identical inner class */;
            b.e.c.d d2 = new b.e.c.d(this.d, new d.a(object){
                final /* synthetic */ b a;
                {
                    this.a = b2;
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                @Override
                public final void a(int n2) {
                    Locale locale = Locale.US;
                    Object[] arrobject = new Object[]{b.e.c.c.a(n2)};
                    String.format((Locale)locale, (String)"onWifiApStateChanged: %s", (Object[])arrobject);
                    if (n2 == 12) {
                        this.a.a = n2;
                        return;
                    }
                    if (n2 == 13) {
                        b b2;
                        this.a.a = n2;
                        b b3 = b2 = this.a;
                        synchronized (b3) {
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
                                    b b2;
                                    b b3 = b2 = this.a.a;
                                    synchronized (b3) {
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
            d2.a("android.net.wifi.WIFI_AP_STATE_CHANGED");
            if (Build.VERSION.SDK_INT <= 24) {
                bl2 = d.a(this.e, this.j, (boolean)n3);
            } else {
                d.a(this.e, this.j);
                bl2 = b.e.a.a.a.a.b.b(this.i);
            }
            if (bl2) {
                block27 : {
                    Object object2 = object;
                    // MONITORENTER : object2
                    long l2 = n2;
                    object.wait(l2);
                    break block27;
                    catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
                // MONITOREXIT : object2
            }
            d2.a();
            if (object.a == 13) {
                return 0;
            }
            midrop.service.c.d.b("WifiHackerApi21", "startWifiAp: FAILED", new Object[0]);
            n3 = object.a == 12 ? 9011 : (object.a == 11 ? 9013 : (object.a == -1 ? 9012 : 9003));
            e.a("sys_midrop_aphost", "stop");
        }
        // MONITOREXIT : var25_5
        return n3;
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
            if (n3 == this.e.getWifiState()) {
                return 0;
            }
            object = new /* invalid duplicate definition of identical inner class */;
            d2 = new b.e.c.d(this.d, new d.a(object){
                final /* synthetic */ b b;
                {
                    this.b = b2;
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
                    Object[] arrobject = new Object[]{b.e.c.c.a(n2)};
                    String.format((Locale)locale, (String)"onWifiStateChanged: %s", (Object[])arrobject);
                    if (n2 == n3) {
                        b b2;
                        b b3 = b2 = this.b;
                        synchronized (b3) {
                            this.b.a = n2;
                            this.b.notify();
                            return;
                        }
                    }
                }
            });
            d2.a("android.net.wifi.WIFI_STATE_CHANGED");
            if (n4 == d.a(this.e)) {
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
            if (this.e.setWifiEnabled(bl)) {
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

