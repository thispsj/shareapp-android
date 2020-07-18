/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.os.ResultReceiver
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.atomic.AtomicBoolean
 *  midrop.a.c.a
 *  midrop.a.c.a.a.a
 *  midrop.a.c.a.a.a$a
 *  midrop.a.c.k$a
 *  midrop.b.b.a.b
 *  midrop.service.transmitter.a
 */
package com.xiaomi.midrop.sender.service;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.qrcode.a;
import com.xiaomi.midrop.receiver.service.ReceiverService;
import com.xiaomi.midrop.sender.service.a;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import midrop.a.c.a;
import midrop.a.c.a.a.a;
import midrop.a.c.k;
import midrop.a.c.m;
import midrop.b.b.a.b;
import midrop.c.a.e;
import midrop.c.d.c;
import midrop.service.a.b;
import midrop.service.c.d;
import midrop.service.transmitter.a;

public final class a
extends k.a {
    public static int b = 1010;
    public static int c = 1020;
    ResultReceiver a;
    a.a d;
    private Context e;
    private midrop.service.transmitter.a f;
    private midrop.service.a.b g;
    private m h;
    private AtomicBoolean i = new AtomicBoolean(false);
    private List<Uri> j = new ArrayList();
    private a.b k;
    private b.e l;
    private b.f m;

    public a(Context context) {
        this.d = new a.a((a)this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public final void a(boolean bl) {
                a.a(this.a, bl, "wifi", "is_wifi_enabled");
            }

            public final void b(boolean bl) {
                a.a(this.a, bl, "bt", "is_bt_enabled");
            }
        };
        this.k = new a.b((a)this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public final void a(midrop.a.c.a.a.a a2) {
                String string2 = midrop.service.a.c.a(midrop.service.a.c$c.b).toString();
                a.a(this.a, string2, a2);
            }

            public final void b(midrop.a.c.a.a.a a2) {
                new StringBuilder("onDeviceLost:").append(a2.b());
                String string2 = midrop.service.a.c.a(midrop.service.a.c$c.c).toString();
                a.a(this.a, string2, a2);
            }
        };
        this.l = new b.e((a)this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public final void a(midrop.a.c.a.a.a a2) {
                a.a.b b2 = a2.b.a();
                if (com.xiaomi.midrop.sender.service.a$5.a[b2.ordinal()] == 1) {
                    a.a(this.a).set(true);
                }
                String string2 = midrop.service.a.c.a(midrop.service.a.c$a.d).toString();
                a.a(this.a, string2, a2);
            }

            public final void b(midrop.a.c.a.a.a a2) {
                a.a.f f2 = a2.b.f();
                switch (com.xiaomi.midrop.sender.service.a$5.b[f2.ordinal()]) {
                    default: {
                        break;
                    }
                    case 4: 
                    case 5: {
                        a.b(this.a);
                        break;
                    }
                    case 3: {
                        a.b(this.a);
                        a.c(this.a).p();
                        break;
                    }
                    case 1: 
                    case 2: {
                        a.a(this.a).set(true);
                        a2.b.a(a.a.b.e);
                    }
                }
                String string2 = midrop.service.a.c.a(midrop.service.a.c$a.e).toString();
                a.a(this.a, string2, a2);
            }

            public final void c(midrop.a.c.a.a.a a2) {
                a.a.c c2 = a2.b.g();
                if (com.xiaomi.midrop.sender.service.a$5.c[c2.ordinal()] == 1 && !a2.e()) {
                    android.widget.Toast.makeText((Context)a.d(this.a), (int)2131689776, (int)1).show();
                    a.b(this.a);
                }
                String string2 = midrop.service.a.c.a(midrop.service.a.c$a.f).toString();
                a.a(this.a, string2, a2);
            }

            public final void d(midrop.a.c.a.a.a a2) {
                String string2 = midrop.service.a.c.a(midrop.service.a.c$a.g).toString();
                a.a(this.a, string2, a2);
            }

            public final void e(midrop.a.c.a.a.a a2) {
                String string2 = midrop.service.a.c.a(midrop.service.a.c$a.c).toString();
                a.a(this.a, string2, a2);
                a.b(this.a);
            }
        };
        this.m = new b.f((a)this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public final void a() {
                a.c(this.a).i();
            }

            public final void b() {
                a.c(this.a).j();
            }

            public final void c() {
                this.a.a();
            }

            public final void d() {
                a.c(this.a).k();
            }

            public final void e() {
                this.a.l();
            }

            public final void f() {
                a.c(this.a).p();
            }
        };
        this.f = midrop.service.transmitter.a.a((Context)context);
        this.f.g = this.k;
        this.g = new midrop.service.a.b(context);
        this.g.b = this.m;
        this.g.d = this.l;
        this.e = context;
    }

    static /* synthetic */ AtomicBoolean a(a a2) {
        return a2.i;
    }

    static /* synthetic */ void a(a a2, String string2, midrop.a.c.a.a.a a3) {
        if (a2.h != null) {
            try {
                a2.h.a(string2, a3);
                return;
            }
            catch (RemoteException remoteException) {
                StringBuilder stringBuilder = new StringBuilder("sendMessage e: ");
                stringBuilder.append((Object)remoteException);
                d.b("MiDrop:SenderManagerServiceImpl", stringBuilder.toString(), new Object[0]);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static /* synthetic */ void a(a var0_1, boolean var1, String var2_3, String var3_2) {
        block7 : {
            block6 : {
                var4_4 = new Bundle();
                var4_4.putBoolean(var3_2, var1);
                var4_4.putString("call_back_from", "sender");
                var5_5 = var2_3.hashCode();
                if (var5_5 == 3154) break block6;
                if (var5_5 != 3649301 || !var2_3.equals((Object)"wifi")) ** GOTO lbl-1000
                var6_6 = 0;
                break block7;
            }
            if (var2_3.equals((Object)"bt")) {
                var6_6 = 1;
            } else lbl-1000: // 2 sources:
            {
                var6_6 = -1;
            }
        }
        switch (var6_6) {
            default: {
                return;
            }
            case 1: {
                new StringBuilder("sendCallBack bt, mResultReceiver=").append((Object)var0_1.a);
                if (var0_1.a == null) return;
                var0_1.a.send(a.c, var4_4);
                return;
            }
            case 0: 
        }
        new StringBuilder("sendCallBack wifi, mResultReceiver=").append((Object)var0_1.a);
        if (var0_1.a == null) return;
        var0_1.a.send(a.b, var4_4);
    }

    static /* synthetic */ void b(a a2) {
        a2.m();
    }

    static /* synthetic */ midrop.service.transmitter.a c(a a2) {
        return a2.f;
    }

    private void c(List<Uri> list) {
        ArrayList arrayList = new ArrayList(list);
        new AsyncTask<Void, Void, Void>((List<Uri>)arrayList){
            private List<Uri> a;
            {
                this.a = list;
            }

            protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                if (this.a != null) {
                    for (Uri uri : this.a) {
                        if (uri == null || uri.isOpaque() || Boolean.parseBoolean((String)uri.getQueryParameter("silent_transfer"))) continue;
                        String string2 = uri.getPath();
                        String string3 = j.d(string2);
                        a.d(string3);
                        if (!com.xiaomi.midrop.util.g.d(string3)) continue;
                        a.e(j.a(MiDropApplication.a(), string2));
                    }
                }
                return null;
            }
        }.execute((Object[])new Void[0]);
        this.g.a((List<Uri>)arrayList);
    }

    static /* synthetic */ Context d(a a2) {
        return a2.e;
    }

    static /* synthetic */ void d(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            af.a(af.a.cK).a(af.b.Q, string2).a();
        }
    }

    static /* synthetic */ void e(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            af.a(af.a.cL).a(af.b.R, string2).a();
        }
    }

    private void m() {
        this.f.t();
        new StringBuilder("finishService  mListener = ").append((Object)this.h);
        if (this.h == null) {
            Intent intent = new Intent(k.class.getName());
            intent.setPackage(this.e.getPackageName());
            this.e.stopService(intent);
        }
    }

    public final int a(String string2, boolean bl) {
        if (this.h == null) {
            return 7;
        }
        this.i.set(false);
        return this.f.a(string2, bl);
    }

    public final int a(List<String> list, String string2) throws RemoteException {
        Object[] arrobject = new Object[]{list.size(), string2};
        String.format((String)"sendDeleteFilesMsg -> [fileCount=%s], [rootDirName=%s]", (Object[])arrobject);
        return this.f.a("delete_files", list, string2);
    }

    public final int a(midrop.a.b.a a2) throws RemoteException {
        return this.g.a(a2);
    }

    public final int a(midrop.c.d.e e2) throws RemoteException {
        if (e2.a() == midrop.c.d.g.m) {
            if (midrop.a.c.a.a.b.a().b() != null) {
                this.f.a(e2.b());
            }
            return 0;
        }
        if (e2.a() == midrop.c.d.g.o) {
            this.f.p();
            return 0;
        }
        return this.g.a(e2);
    }

    public final List<g> a(int n2, int n3) {
        return this.g.a(n2, n3);
    }

    public final void a() {
        if (this.g.e()) {
            this.f.m();
        }
        this.f.s();
    }

    public final void a(String string2) {
        this.f.d(string2);
    }

    public final void a(List<Uri> list) {
        a.super.c(list);
    }

    public final void a(m m2) {
        this.h = m2;
        if (this.g != null) {
            this.g.c = m2;
        }
        if (this.f != null) {
            midrop.service.transmitter.a a2 = this.f;
            boolean bl = m2 == null;
            a2.h = bl;
        }
    }

    public final void a(e e2) {
        this.f.a(e2);
    }

    public final int b(String string2) throws RemoteException {
        String.format((String)"sendDeleteItemMsg -> [fileId=%s]", (Object[])new Object[]{string2});
        return this.f.a("single_delete", string2);
    }

    public final int b(midrop.a.b.a a2) throws RemoteException {
        return this.g.b(a2);
    }

    public final midrop.a.c.a.a.a b() throws RemoteException {
        return midrop.a.c.a.a.b.a().b();
    }

    public final void b(List<Uri> list) throws RemoteException {
        if (list != null && !list.isEmpty()) {
            this.j.addAll(list);
            return;
        }
        a.super.c(this.j);
        this.j.clear();
    }

    public final midrop.a.c.a.a.a c(String string2) throws RemoteException {
        com.xiaomi.midrop.qrcode.a a2 = com.xiaomi.midrop.qrcode.a.a(string2);
        if (a2 != null && a2.b()) {
            midrop.c.e.a a3 = new midrop.c.e.a();
            a3.b(a2.a);
            a3.a(a2.b);
            String string3 = a2.d != null ? a2.d.a : "";
            a3.d(string3);
            String string4 = a2.d != null ? a2.d.b : "";
            a3.e(string4);
            a3.a(a2.a());
            a3.a((byte)0);
            new StringBuilder("receive type ").append((Object)a2.a());
            e e2 = midrop.c.b.a.a(MiDropApplication.a(), a3);
            e2.d(a3.f());
            e2.e(a3.g());
            e2.f(a3.h());
            String string5 = a2.d != null ? a2.d.c : "";
            e2.c(string5);
            int n2 = a2.d != null ? a2.d.d : 0;
            e2.a(n2);
            e2.a(a3.i());
            e2.b(true);
            e2.c(true);
            e2.k();
            String string6 = a2.e != null ? a2.e.a : "";
            e2.g(string6);
            boolean bl = a2.e != null && a2.e.b;
            e2.a(bl);
            boolean bl2 = a2.e != null && a2.e.c;
            e2.d(bl2);
            boolean bl3 = a2.e != null;
            e2.f(bl3);
            boolean bl4 = b.g();
            boolean bl5 = false;
            if (bl4) {
                boolean bl6 = e2.c();
                bl5 = false;
                if (bl6) {
                    bl5 = true;
                }
            }
            e2.e(bl5);
            e2.h(a2.c);
            e2.i(a2.f);
            midrop.service.transmitter.manipulator.a.a.a().a(e2);
            midrop.a.c.a.a.b b2 = midrop.a.c.a.a.b.a();
            midrop.a.c.a.a.a a4 = b2.a(e2.a());
            if (a4 == null) {
                a4 = midrop.a.c.a.a.a.a((e)e2);
            } else {
                a4.a.k();
                if (TextUtils.isEmpty((CharSequence)a4.a.d())) {
                    a4.a.c(e2.d());
                }
            }
            if (a4 != null) {
                b2.a(a4);
                new StringBuilder("Add file receiver successfully, device id ").append(a4.b());
                return a4;
            }
        } else {
            d.b("MiDrop:SenderManagerServiceImpl", "parse receiver info failed", new Object[0]);
        }
        return null;
    }

    public final void c() {
        if (this.i.get() && !midrop.service.transmitter.a.r()) {
            this.f.p();
        }
        Context context = this.e;
        if (Build.VERSION.SDK_INT > 23 && ReceiverService.c(context) != null) {
            ReceiverService.a(context);
        }
    }

    public final void d() {
        if (this.f.i) {
            this.i.set(true);
            this.f.q();
        }
    }

    public final List<midrop.a.c.a.a.a> e() {
        return midrop.a.c.a.a.b.a().d();
    }

    public final midrop.c.d.a f() throws RemoteException {
        return this.g.a();
    }

    public final void g() {
        for (midrop.a.c.a.a.a a2 : this.e()) {
            a2.b.a(a.a.c.a);
            a2.b.a(a.a.b.a);
            a2.b.a(a.a.f.a);
        }
    }

    public final boolean h() {
        return this.g.d();
    }

    public final boolean i() throws RemoteException {
        return this.g.e();
    }

    public final boolean j() throws RemoteException {
        return this.g.f();
    }

    public final void k() {
        this.f.a(this.d);
        this.g.a((midrop.service.a.a)this.f);
    }

    public final void l() {
        this.f.h = true;
        this.f.g();
        this.g.b();
        this.m();
        midrop.a.c.a.a.b.a().a.clear();
    }

}

