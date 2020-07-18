/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Message
 *  android.os.RemoteException
 *  android.util.Pair
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  midrop.a.b.b$a
 *  midrop.a.c.a.a.a
 *  midrop.service.b.a
 */
package com.xiaomi.midrop.receiver.service;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.receiver.service.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import midrop.a.b.b;
import midrop.a.c.m;
import midrop.c.d.c;
import midrop.c.d.e;
import midrop.service.a.b;
import midrop.service.b.a;
import midrop.service.c.d;

public final class a
extends b.a {
    midrop.service.b.a a;
    private Context b;
    private m c;
    private b d;
    private List<Uri> e = new ArrayList();
    private Handler f;
    private b.e g;
    private a.d h;
    private a.b i;
    private b.f j;

    public a(Context context) {
        this.f = new Handler((a)this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public final void handleMessage(Message message) {
                int n2 = message.what;
                if (n2 != 10) {
                    if (n2 != 14) {
                        return;
                    }
                    Pair pair = (Pair)message.obj;
                    a.a(this.a).a("delete_files", (List)pair.first, (String)pair.second);
                    return;
                }
                String string2 = String.valueOf((Object)message.obj);
                if (!android.text.TextUtils.isEmpty((java.lang.CharSequence)string2)) {
                    a.a(this.a).a("single_delete", string2);
                    return;
                }
                d.b("ReceiverServiceImpl", "MSG_SEND_DELETE_ITEM fileId is null", new Object[0]);
            }
        };
        this.g = new b.e((a)this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public final void a(midrop.a.c.a.a.a a2) {
                String string2 = midrop.service.a.c.a(midrop.service.a.c$a.d).toString();
                a.a(this.a, string2, a2);
            }

            public final void b(midrop.a.c.a.a.a a2) {
                String string2 = midrop.service.a.c.a(midrop.service.a.c$a.e).toString();
                a.a(this.a, string2, a2);
            }

            public final void c(midrop.a.c.a.a.a a2) {
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
            }
        };
        this.h = new a.d((a)this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public final void a() {
                String string2 = midrop.service.a.c.b(midrop.service.a.c$b.b).toString();
                a.a(this.a, string2, null);
            }

            public final void b() {
                if (com.xiaomi.midrop.util.am.c()) {
                    a.b(this.a);
                    return;
                }
                String string2 = midrop.service.a.c.b(midrop.service.a.c$b.d).toString();
                a.a(this.a, string2, null);
            }

            public final void c() {
                String string2 = midrop.service.a.c.b(midrop.service.a.c$b.c).toString();
                a.a(this.a, string2, null);
            }

            public final void d() {
                String string2 = midrop.service.a.c.b(midrop.service.a.c$b.e).toString();
                a.a(this.a, string2, null);
            }
        };
        this.i = new a.b((a)this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public final void a() {
                String string2 = midrop.service.a.c.b(midrop.service.a.c$b.f).toString();
                a.a(this.a, string2, null);
            }

            public final void b() {
                String string2 = midrop.service.a.c.b(midrop.service.a.c$b.g).toString();
                a.a(this.a, string2, null);
            }

            public final void c() {
                String string2 = midrop.service.a.c.b(midrop.service.a.c$b.h).toString();
                a.a(this.a, string2, null);
            }
        };
        this.j = new b.f((a)this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public final void a() {
                a.a(this.a).l();
            }

            public final void b() {
                a.a(this.a).j();
                a.c(this.a).c();
                a.a(this.a).r();
            }

            public final void c() {
                a.a(this.a).m();
            }

            public final void d() {
                a.a(this.a).k();
            }

            public final void e() {
                a.a(this.a).r();
            }

            public final void f() {
                a.a(this.a).q();
            }
        };
        this.b = context;
        this.a = midrop.service.b.a.a((Context)context, (c.a)c.a.b, (String)com.xiaomi.midrop.util.e.a());
        this.a.j = this.h;
        this.a.k = this.i;
        this.d = new b(context);
        this.d.b = this.j;
        this.d.d = this.g;
    }

    static /* synthetic */ midrop.service.b.a a(a a2) {
        return a2.a;
    }

    static /* synthetic */ void a(a a2, String string2, midrop.a.c.a.a.a a3) {
        if (a2.c != null) {
            try {
                a2.c.a(string2, a3);
                return;
            }
            catch (RemoteException remoteException) {
                StringBuilder stringBuilder = new StringBuilder("sendMessage e: ");
                stringBuilder.append((Object)remoteException);
                d.b("ReceiverServiceImpl", stringBuilder.toString(), new Object[0]);
            }
        }
    }

    static /* synthetic */ void b(a a2) {
        Intent intent = new Intent("com.xiaomi.midrop.action.ENABLE_AP_BY_SETTING");
        a2.b.sendBroadcast(intent);
    }

    static /* synthetic */ b c(a a2) {
        return a2.d;
    }

    private void c(List<Uri> list) {
        ArrayList arrayList = new ArrayList(list);
        this.d.a((List<Uri>)arrayList);
    }

    public final int a() throws RemoteException {
        this.a.p();
        this.d.a((midrop.service.a.a)this.a);
        return 0;
    }

    public final int a(String string2) throws RemoteException {
        Message message = this.f.obtainMessage();
        message.what = 10;
        message.obj = string2;
        this.f.sendMessage(message);
        return 0;
    }

    public final int a(List<String> list, String string2) throws RemoteException {
        StringBuilder stringBuilder = new StringBuilder("sendDeleteItemMsg, fileId count ");
        stringBuilder.append(list.size());
        stringBuilder.append(" rootDirName=");
        stringBuilder.append(string2);
        Message message = this.f.obtainMessage();
        message.what = 14;
        message.obj = new Pair(list, (Object)string2);
        this.f.sendMessage(message);
        return 0;
    }

    public final int a(midrop.a.b.a a2) {
        return this.d.a(a2);
    }

    public final int a(e e2) throws RemoteException {
        if (e2.a() == midrop.c.d.g.l) {
            this.b();
            this.a();
            return 0;
        }
        if (e2.a() == midrop.c.d.g.m) {
            this.a.a(e2.b());
            return 0;
        }
        return this.d.a(e2);
    }

    public final List<g> a(int n2, int n3) {
        return this.d.a(n2, n3);
    }

    public final void a(List<Uri> list) {
        a.super.c(list);
    }

    public final void a(m m2) {
        this.c = m2;
        this.d.c = m2;
    }

    public final int b() throws RemoteException {
        if (this.a != null) {
            this.a.r();
        }
        if (this.d != null) {
            this.d.b();
        }
        return 0;
    }

    public final int b(midrop.a.b.a a2) {
        return this.d.b(a2);
    }

    public final void b(List<Uri> list) throws RemoteException {
        if (list != null && !list.isEmpty()) {
            this.e.addAll(list);
            return;
        }
        a.super.c(this.e);
        this.e.clear();
    }

    public final midrop.c.d.a c() throws RemoteException {
        return this.d.a();
    }

    public final midrop.a.c.a.a.a d() throws RemoteException {
        return this.a.h();
    }

    public final boolean e() throws RemoteException {
        return this.d.d();
    }

    public final boolean f() throws RemoteException {
        return this.d.e();
    }

    public final boolean g() throws RemoteException {
        return this.d.f();
    }
}

