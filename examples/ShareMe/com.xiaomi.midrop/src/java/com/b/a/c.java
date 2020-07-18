/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.text.TextUtils
 *  android.util.Log
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.HashMap
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.concurrent.ExecutorService
 */
package com.b.a;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.b.a.a;
import com.b.a.b;
import com.b.a.c;
import com.b.a.d;
import com.b.a.e;
import com.b.a.f;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public final class c
implements e.a {
    private static c g;
    public a a;
    public HashMap<f, d> b = new HashMap();
    public HashMap<f, b> c = new HashMap();
    LinkedList<Object> d = new LinkedList();
    public Handler e = new Handler();
    public ExecutorService f;

    private c() {
    }

    public static c a() {
        Class<c> class_ = c.class;
        synchronized (c.class) {
            if (g == null) {
                g = new c();
            }
            c c2 = g;
            // ** MonitorExit[var2] (shouldn't be in output)
            return c2;
        }
    }

    public final void a(f f2) {
        Log.v((String)"DownloadManager", (String)"try to removeDownloadTaskListener");
        if (f2 != null) {
            if (!this.c.containsKey((Object)f2)) {
                return;
            }
            Log.v((String)"DownloadManager", (String)"removeDownloadTaskListener");
            this.c.remove((Object)f2);
        }
    }

    public final void a(f f2, long l2, long l3) {
        f2.i = 2;
        b b2 = (b)this.c.get((Object)f2);
        Handler handler = this.e;
        Runnable runnable = new Runnable((c)this, b2, f2, l2, l3){
            final /* synthetic */ b a;
            final /* synthetic */ f b;
            final /* synthetic */ long c;
            final /* synthetic */ long d;
            final /* synthetic */ c e;
            {
                this.e = c2;
                this.a = b2;
                this.b = f2;
                this.c = l2;
                this.d = l3;
            }

            public final void run() {
                if (this.a != null) {
                    this.a.a(this.b, this.c, this.d);
                }
            }
        };
        handler.post(runnable);
    }

    public final void b() {
        c c2 = this;
        synchronized (c2) {
            if (this.f != null) {
                this.f.shutdownNow();
            }
            if (e.a().a(this)) {
                e.a().c(this);
            }
            com.b.a.a.a.a().close();
            return;
        }
    }

    public final void b(f f2) {
        f2.i = 2;
        f2.j = System.currentTimeMillis();
        b b2 = (b)this.c.get((Object)f2);
        e.a().a(f2);
        this.e.post(new Runnable((c)this, b2, f2){
            final /* synthetic */ b a;
            final /* synthetic */ f b;
            final /* synthetic */ c c;
            {
                this.c = c2;
                this.a = b2;
                this.b = f2;
            }

            public final void run() {
                if (this.a != null) {
                    this.a.a(this.b);
                }
            }
        });
    }

    public final void c(f f2) {
        f2.i = 32;
        f2.j = System.currentTimeMillis();
        b b2 = (b)this.c.get((Object)f2);
        this.e(f2);
        e.a().a(f2);
        this.e.post(new Runnable((c)this, b2, f2){
            final /* synthetic */ b a;
            final /* synthetic */ f b;
            final /* synthetic */ c c;
            {
                this.c = c2;
                this.a = b2;
                this.b = f2;
            }

            public final void run() {
                if (this.a != null) {
                    this.a.d(this.b);
                }
            }
        });
    }

    public final void d(f f2) {
        f2.i = 16;
        f2.j = System.currentTimeMillis();
        b b2 = (b)this.c.get((Object)f2);
        this.e(f2);
        e.a().a(f2);
        this.e.post(new Runnable((c)this, b2, f2){
            final /* synthetic */ b a;
            final /* synthetic */ f b;
            final /* synthetic */ c c;
            {
                this.c = c2;
                this.a = b2;
                this.b = f2;
            }

            public final void run() {
                if (this.a != null) {
                    this.a.b(this.b);
                }
            }
        });
    }

    final void e(f f2) {
        this.b.remove((Object)f2);
        this.c.remove((Object)f2);
    }

    @Override
    public final void f(f f2) {
        this.e.post(new Runnable((c)this, f2){
            final /* synthetic */ f a;
            final /* synthetic */ c b;
            {
                this.b = c2;
                this.a = f2;
            }

            public final void run() {
                java.util.Iterator iterator = this.b.d.iterator();
                while (iterator.hasNext()) {
                    iterator.next();
                }
            }
        });
    }

    public final String g(f f2) {
        String string2 = this.a.a;
        if (!TextUtils.isEmpty((CharSequence)f2.k)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("/");
            String string3 = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string3);
            stringBuilder2.append(f2.k);
            string2 = stringBuilder2.toString();
        }
        return string2;
    }
}

