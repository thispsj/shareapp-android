/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.net.wifi.WifiManager
 *  android.os.Build
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.os.ResultReceiver
 *  android.provider.Settings
 *  android.provider.Settings$Global
 *  android.provider.Settings$System
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  java.lang.Byte
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 *  java.util.Random
 *  midrop.b.b.a.b
 *  midrop.b.c.a.b
 */
package midrop.b.c.a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import b.a.o;
import b.e.c.b;
import b.g.b.a;
import b.g.e;
import b.g.f;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.profile.a;
import com.xiaomi.midrop.qrcode.a;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.util.y;
import java.util.Locale;
import java.util.Random;
import midrop.b.c.a;
import midrop.b.c.a.a;
import midrop.b.c.a.b;
import midrop.c.d.c;
import midrop.c.d.d;
import midrop.c.f.c;

public final class a
extends b
implements b.a {
    private static final String[] y = new String[]{"BD", "BO", "BZ", "GY", "ID", "IR", "MO", "NG", "PK", "QA", "TW", "TZ"};
    private boolean l;
    private boolean m;
    private b.e.c.b n;
    private b.e.a.a o;
    private int p = 6;
    private int q = b.e.c.a.b;
    private WifiManager r;
    private TelephonyManager s;
    private boolean t;
    private ResultReceiver u;
    private String v;
    private String w;
    private midrop.b.b.a.b x;

    public a(Context context, c c2, a.b b2) {
        super(context, c2, b2);
        this.o = new b.e.a.a.a(context);
        this.r = (WifiManager)context.getApplicationContext().getSystemService("wifi");
        this.s = (TelephonyManager)context.getSystemService("phone");
        this.n = new b.e.c.b(context, (b.a)this);
    }

    private void a(String string2, String string3, String string4) {
        com.xiaomi.midrop.qrcode.a a2 = new com.xiaomi.midrop.qrcode.a();
        a2.a = com.xiaomi.midrop.util.e.a();
        a2.b = String.valueOf((int)midrop.service.c.c.a());
        a2.d = new a.a();
        a2.d.a = string2;
        a2.d.b = string3;
        a2.d.c = string4;
        a2.d.d = 8181;
        a2.c = true;
        a2.f = true;
        Intent intent = new Intent("com.xiaomi.midrop.action.AP_STARTED");
        intent.setPackage("com.xiaomi.midrop");
        intent.putExtra("extra_info", (Parcelable)a2);
        if (this.u != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_ap_enabled", true);
            bundle.putString("call_back_from", "receiver");
            bundle.putParcelable("extra_info", (Parcelable)a2);
            this.u.send(1030, bundle);
        }
        this.a.sendBroadcast(intent);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final int a() {
        block19 : {
            block20 : {
                block18 : {
                    new StringBuilder("doStart, mHostStarted =").append(this.t);
                    if (this.t) {
                        midrop.service.c.d.b("MiDrop:ApHostImpl", "host(ap) already started", new Object[0]);
                        return 0;
                    }
                    this.v = "";
                    this.w = "";
                    if (!o.d()) {
                        if (this.l) {
                            midrop.service.c.d.b("MiDrop:ApHostImpl", "Wifi ap 26 already started", new Object[0]);
                        } else {
                            var24_1 = new midrop.b.b.a.b(MiDropApplication.a());
                            var25_2 = var24_1.a(false, false);
                            if (var25_2 != 0) {
                                var26_3 = Locale.getDefault();
                                var27_4 = new Object[]{var25_2};
                                midrop.service.c.d.b("MiDrop:ApHostImpl", String.format((Locale)var26_3, (String)"Wifi ap start failed: %d", (Object[])var27_4), new Object[0]);
                                this.onEvent(a.a.s);
                            } else {
                                this.x = var24_1;
                                this.n.a();
                                this.l = true;
                                this.onEvent(a.a.p);
                                this.a(var24_1.b(), var24_1.c(), var24_1.d());
                            }
                        }
                        var16_5 = "Ap host start Ap 26";
                    } else {
                        if (this.l) {
                            midrop.service.c.d.b("MiDrop:ApHostImpl", "Wifi Ap already started!", new Object[0]);
                        } else {
                            var2_6 = this.a;
                            try {
                                Settings.System.putInt((ContentResolver)var2_6.getContentResolver(), (String)"key_midrop_enabled", (int)2);
                                Settings.Global.putInt((ContentResolver)var2_6.getContentResolver(), (String)"key_midrop_enabled", (int)2);
                            }
                            catch (Exception var3_7) {
                                var3_7.printStackTrace();
                            }
                            var4_8 = new b.b.a();
                            var4_8.a = true;
                            var4_8.b = true;
                            var4_8.d = true;
                            var4_8.e = true;
                            var4_8.f = true;
                            var4_8.g = true;
                            var5_9 = b.e.a.a.a.a.d.c(this.r);
                            var6_10 = b.e.a.a.a.a.c.a(this.s);
                            var7_11 = var5_9 != false && var6_10 != false;
                            var4_8.c = var7_11;
                            var8_12 = new StringBuilder("support 5g band:");
                            var8_12.append(var5_9);
                            var8_12.append(var6_10);
                            var11_13 = this.b.a();
                            if (TextUtils.isEmpty((CharSequence)var11_13) || var11_13.equals((Object)"0")) {
                                var12_14 = String.valueOf((int)midrop.service.c.c.a());
                                if ((TextUtils.isEmpty((CharSequence)var12_14) || var12_14.equals((Object)"0")) && Build.MODEL.startsWith("Redmi Note 3")) {
                                    var12_14 = String.valueOf((int)new Random().nextInt());
                                }
                                this.b.b(var12_14);
                            }
                            var14_15 = new b.e.a.b.a((String)this.b.a.b(d.a), (Integer)this.b.a.b(d.d), c.a.a((Byte)this.b.a.b(d.e)), var4_8, this.b.a(), this.p, (Byte)this.b.a.b(d.c));
                            var15_16 = this.o.a(var14_15);
                            this.n.a();
                            if (var15_16 != 0) {
                                var20_17 = Locale.getDefault();
                                var21_18 = new Object[]{var15_16};
                                midrop.service.c.d.b("MiDrop:ApHostImpl", String.format((Locale)var20_17, (String)"wifiAp doStart failed: %d", (Object[])var21_18), new Object[0]);
                                this.onEvent(a.a.s);
                                this.v = var14_15.a();
                                this.w = var14_15.h;
                                if (!am.c()) {
                                    af.a(af.a.Z).a(af.b.O, var15_16).a();
                                }
                            } else {
                                this.l = true;
                                this.onEvent(a.a.p);
                                this.a(var14_15.a(), var14_15.h, "192.168.43.1");
                                midrop.service.c.b.a(this.a, true);
                            }
                        }
                        var16_5 = "Ap host start Ap custom";
                    }
                    midrop.service.c.d.a(var16_5, new Object[0]);
                    if (!this.m) break block18;
                    midrop.service.c.d.b("MiDrop:ApHostImpl", "xmpp server already started", new Object[0]);
                    break block19;
                }
                this.c = e.a((f)this, 8181);
                if (this.c.a()) break block20;
                midrop.service.c.d.a("Ap host start XMPP failed", new Object[0]);
                midrop.service.c.d.b("MiDrop:ApHostImpl", "xmppServer start failed", new Object[0]);
                this.onEvent(a.a.e);
                var17_19 = af.a(af.a.aa);
                var18_20 = af.b.O;
                var19_21 = 6004;
                ** GOTO lbl96
            }
            if (this.c.c() == 0) {
                midrop.service.c.d.a("Ap host start XMPP failed,port = 0", new Object[0]);
                midrop.service.c.d.b("MiDrop:ApHostImpl", "xmppServer getListenPort failed", new Object[0]);
                this.onEvent(a.a.e);
                var17_19 = af.a(af.a.aa);
                var18_20 = af.b.O;
                var19_21 = 6005;
lbl96: // 2 sources:
                var17_19.a(var18_20, var19_21).a();
            } else {
                this.m = true;
                midrop.service.c.d.a("Ap host start XMPP succeed", new Object[0]);
            }
        }
        this.t = true;
        this.k = false;
        this.h();
        return 0;
    }

    @Override
    public final void a(int n2) {
        new StringBuilder("wifi ap state changed ").append(b.e.c.c.a(n2));
        switch (n2) {
            default: {
                return;
            }
            case 13: {
                this.l = true;
                if (TextUtils.isEmpty((CharSequence)this.v) || TextUtils.isEmpty((CharSequence)this.w)) break;
                a.super.a(this.v, this.w, "192.168.43.1");
            }
            case 12: {
                return;
            }
            case 11: {
                new StringBuilder("onApStateChanged, WIFI_AP_STATE_DISABLED, mApStarted=").append(this.l);
                if (!this.l) break;
                this.onEvent(a.a.q);
                return;
            }
            case 10: 
        }
    }

    protected final void a(Intent intent) {
        if (intent.getBooleanExtra("extra_accept", false)) {
            midrop.b.a.b b2 = new midrop.b.a.b();
            b2.a = 1;
            b2.d = this.i;
            b2.c = com.xiaomi.midrop.util.e.a();
            b2.b = 12826;
            b2.e = y.C();
            b2.f = String.valueOf((int)midrop.service.c.c.a());
            this.b(new b.g.b.b("0", b2.toString()));
            return;
        }
        this.x_();
    }

    public final void a(ResultReceiver resultReceiver) {
        this.u = resultReceiver;
    }

    public final void a(b.g.d d2, String string2, int n2) {
        super.a(d2, string2, n2);
        this.onEvent(a.a.A);
    }

    public final void a(b.g.d d2, String string2, int n2, b.g.b.a a2) {
        new StringBuilder("onReceived IqAction: ").append(a2.d);
        if (a2.a == a.a.b && a2.c.equals((Object)"http://www.xiaomi.com/midrop")) {
            String string3 = a2.d;
            if ("support_wifi_5g".equals((Object)string3)) {
                if (this.q != b.e.c.a.d) {
                    this.q = b.e.c.a.b;
                }
            } else if ("swiched_wifi_5g".equals((Object)string3)) {
                this.q = b.e.c.a.d;
                this.onEvent(a.a.t);
            }
        }
        super.a(d2, string2, n2, a2);
    }

    public final void a(String string2, int n2, b.g.b.b b2) {
        if (this.d == null) {
            midrop.service.c.d.b("MiDrop:ApHostImpl", "listener is null", new Object[0]);
            return;
        }
        midrop.c.f.c c2 = new midrop.c.f.c();
        c.c c3 = c2.a(b2.a);
        if (c3 != c.c.a) {
            switch (1.a[c3.ordinal()]) {
                default: {
                    return;
                }
                case 2: {
                    a.a a2 = a.a.x;
                    a2.D = c2;
                    this.onEvent(a2);
                    return;
                }
                case 1: 
            }
            a.a a3 = a.a.w;
            a3.D = c2;
            this.onEvent(a3);
            return;
        }
        midrop.b.a.b b3 = midrop.b.a.b.a(b2.a);
        if (b3 != null && midrop.b.a.a.a(b3.d)) {
            this.f = string2;
            this.g = n2;
            this.i = b3.d;
            if (b3.a != 0) {
                midrop.service.c.d.b("MiDrop:ApHostImpl", "invalid status", new Object[0]);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("Ap host received connection id from ");
            stringBuilder.append(b3.c);
            midrop.service.c.d.a(stringBuilder.toString(), new Object[0]);
            String string3 = b3.f;
            if (!TextUtils.isEmpty((CharSequence)string3)) {
                int n3 = b3.e;
                a.a.a(string3, n3);
            }
            midrop.a.a.b.a(b3.d, b3.c, string3, false);
        }
    }

    final void a_(b.g.b.a a2) {
        this.b(a2);
    }

    public final void c() {
    }

    public final int d() {
        if (!this.t) {
            midrop.service.c.d.b("MiDrop:ApHostImpl", "host(ap) already stopped", new Object[0]);
            return 0;
        }
        midrop.service.c.d.a("Ap host will stop", new Object[0]);
        if (this.c != null && this.m) {
            this.c.b();
            this.c = null;
            this.m = false;
        }
        if (!this.l) {
            midrop.service.c.d.b("MiDrop:ApHostImpl", "already stopped", new Object[0]);
        } else {
            int n2;
            Context context = this.a;
            try {
                Settings.System.putInt((ContentResolver)context.getContentResolver(), (String)"key_midrop_enabled", (int)3);
                Settings.Global.putInt((ContentResolver)context.getContentResolver(), (String)"key_midrop_enabled", (int)3);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            this.l = false;
            this.onEvent(a.a.r);
            this.p = 6;
            this.f = null;
            this.g = 0;
            this.i = "";
            try {
                this.n.b();
            }
            catch (IllegalArgumentException illegalArgumentException) {}
            if (this.x != null) {
                n2 = this.x.a();
                this.x = null;
            } else {
                n2 = this.o.a();
            }
            if (n2 == 0) {
                midrop.service.c.b.a(this.a, false);
            }
        }
        this.t = false;
        this.i();
        return 0;
    }

    public final int e() {
        return this.h;
    }

    public final String f() {
        return this.i;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final void onEvent(a.a a2) {
        void var4_2 = this;
        synchronized (var4_2) {
            if (this.d != null) {
                this.d.a((midrop.b.c.a)this, a2);
            }
            new StringBuilder("event\uff1a").append(a2.name());
            return;
        }
    }

    protected final void x_() {
        this.b(new b.g.b.b("0", midrop.c.f.c.a(c.b.d).toString()));
    }
}

