/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.net.wifi.ScanResult
 *  android.net.wifi.WifiManager
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  android.os.SystemClock
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  midrop.service.c.d
 */
package b.e.a.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import midrop.service.c.d;

public final class a {
    WifiManager a;
    b.e.a.a.a.a b;
    public final Map<String, a> c = new HashMap();
    Handler d;
    b e;
    private Context f;
    private HandlerThread g;
    private c h = c.a;
    private BroadcastReceiver i;

    public a(Context context, b b2) {
        this.i = new BroadcastReceiver(){

            public final void onReceive(Context context, Intent intent) {
                if ("android.net.wifi.SCAN_RESULTS".equals((Object)intent.getAction())) {
                    if (!a.this.c()) {
                        return;
                    }
                    a.this.d.sendEmptyMessage(1);
                    a.a(a.this);
                }
            }
        };
        this.a = (WifiManager)context.getApplicationContext().getSystemService("wifi");
        this.e = b2;
        this.f = context;
        this.b = new b.e.a.a.a.a(context, this.a);
    }

    static /* synthetic */ void a(a a2) {
        if (a2.d != null && !a2.d.hasMessages(2)) {
            a2.d.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public final void a() {
        a a2 = this;
        synchronized (a2) {
            new StringBuilder("start:").append((Object)this.h);
            d.a((String)"ap scanner start", (Object[])new Object[0]);
            if (this.h != c.a) {
                if (this.d != null) {
                    this.d.sendEmptyMessage(3);
                    return;
                }
            } else {
                this.h = c.d;
                if (this.d == null) {
                    this.g = new HandlerThread("WifiScanWorker");
                    this.g.start();
                    this.d = new Handler(this.g.getLooper()){

                        /*
                         * Enabled aggressive block sorting
                         * Enabled unnecessary exception pruning
                         * Enabled aggressive exception aggregation
                         */
                        public final void handleMessage(Message message) {
                            if (!a.this.c()) {
                                return;
                            }
                            switch (message.what) {
                                default: {
                                    return;
                                }
                                case 3: {
                                    if (a.this.a.isWifiEnabled()) break;
                                    int n2 = a.this.b.a(true, 10000);
                                    StringBuilder stringBuilder = new StringBuilder("ap scanner start: wifi enable ret = ");
                                    stringBuilder.append(n2);
                                    d.a((String)stringBuilder.toString(), (Object[])new Object[0]);
                                    return;
                                }
                                case 2: {
                                    if (a.this.a.isWifiEnabled()) {
                                        b.d.c.a(a.this.a);
                                        return;
                                    }
                                    d.b((String)"WifiScanWorker", (String)"Wifi not enabled", (Object[])new Object[0]);
                                    a.a(a.this);
                                    return;
                                }
                                case 1: {
                                    Map<String, a> map;
                                    a a2 = a.this;
                                    Map<String, b.e.a.b.a> map2 = a2.d();
                                    long l2 = SystemClock.elapsedRealtime();
                                    Map<String, a> map3 = map = a2.c;
                                    synchronized (map3) {
                                        ArrayList arrayList = new ArrayList();
                                        for (b.e.a.b.a a3 : map2.values()) {
                                            a a4 = (a)a2.c.get((Object)a3.a());
                                            if (a4 == null) {
                                                arrayList.add((Object)a3);
                                                continue;
                                            }
                                            a4.b = l2;
                                        }
                                        for (b.e.a.b.a a5 : arrayList) {
                                            a2.e.a(a5);
                                            a2.c.put((Object)a5.a(), (Object)new a(a5, l2));
                                        }
                                        ArrayList arrayList2 = new ArrayList();
                                        for (a a6 : a2.c.values()) {
                                            if (l2 - a6.b <= 40000L) continue;
                                            arrayList2.add((Object)a6.a);
                                        }
                                        for (b.e.a.b.a a7 : arrayList2) {
                                            a2.e.b(a7);
                                            a2.c.remove((Object)a7.a());
                                        }
                                        StringBuilder stringBuilder = new StringBuilder();
                                        Iterator iterator = a2.c.values().iterator();
                                        do {
                                            if (!iterator.hasNext()) {
                                                StringBuilder stringBuilder2 = new StringBuilder("found ap, result = ");
                                                stringBuilder2.append(stringBuilder.toString());
                                                d.a((String)stringBuilder2.toString(), (Object[])new Object[0]);
                                                return;
                                            }
                                            stringBuilder.append(((a)iterator.next()).a.a);
                                            stringBuilder.append(", ");
                                        } while (true);
                                    }
                                }
                            }
                        }
                    };
                }
                this.h = c.c;
                this.d.sendEmptyMessage(3);
                this.d.sendEmptyMessage(2);
                IntentFilter intentFilter = new IntentFilter("android.net.wifi.SCAN_RESULTS");
                this.f.registerReceiver(this.i, intentFilter);
            }
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void b() {
        a a2 = this;
        synchronized (a2) {
            new StringBuilder("stop:").append((Object)this.h);
            d.a((String)"ap scanner stop", (Object[])new Object[0]);
            switch (3.a[this.h.ordinal()]) {
                case 4: {
                    this.h = c.a;
                    return;
                }
                case 3: {
                    if (this.g == null) return;
                    this.d.removeMessages(1);
                    this.d.removeMessages(2);
                    try {
                        this.f.unregisterReceiver(this.i);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        d.a((String)"WifiScanWorker", (String)"mScanResultReceiver is not register", (Throwable)illegalArgumentException, (Object[])new Object[0]);
                    }
                    this.h = c.a;
                    this.g.quitSafely();
                    this.g = null;
                    this.d = null;
                    return;
                }
                case 2: {
                    return;
                }
                case 1: {
                    return;
                }
            }
            return;
        }
    }

    public final boolean c() {
        a a2 = this;
        synchronized (a2) {
            int n2 = 3.a[this.h.ordinal()];
            boolean bl = true;
            switch (n2) {
                default: {
                    bl = false;
                }
                case 3: 
                case 4: 
            }
            return bl;
        }
    }

    final Map<String, b.e.a.b.a> d() {
        List list;
        HashMap hashMap = new HashMap();
        try {
            list = this.a.getScanResults();
        }
        catch (SecurityException securityException) {
            d.a((String)"WifiScanWorker", (String)"getScanResults", (Throwable)securityException, (Object[])new Object[0]);
            list = null;
        }
        if (list == null) {
            return hashMap;
        }
        for (ScanResult scanResult : list) {
            b.e.a.b.a a2 = new b.e.a.b.a();
            if (!a2.a(scanResult.SSID, scanResult.BSSID)) continue;
            hashMap.put((Object)a2.a(), (Object)a2);
        }
        return hashMap;
    }

    private static final class a {
        b.e.a.b.a a;
        long b;

        a() {
        }

        a(b.e.a.b.a a2, long l2) {
            this.a = a2;
            this.b = l2;
        }
    }

    public static interface b {
        public void a(b.e.a.b.a var1);

        public void b(b.e.a.b.a var1);
    }

    private static final class c
    extends Enum<c> {
        public static final /* enum */ c a = new c();
        public static final /* enum */ c b = new c();
        public static final /* enum */ c c = new c();
        public static final /* enum */ c d = new c();
        private static final /* synthetic */ c[] e;

        static {
            c[] arrc = new c[]{a, b, c, d};
            e = arrc;
        }

        public static c valueOf(String string2) {
            return (c)Enum.valueOf(c.class, (String)string2);
        }

        public static c[] values() {
            return (c[])e.clone();
        }
    }

}

