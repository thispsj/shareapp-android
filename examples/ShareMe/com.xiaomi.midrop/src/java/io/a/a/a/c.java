/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  io.a.a.a.a$b
 *  io.a.a.a.a.b.p
 *  io.a.a.a.a.c.d
 *  io.a.a.a.a.c.k
 *  io.a.a.a.a.c.l
 *  io.a.a.a.a.c.m
 *  io.a.a.a.b
 *  io.a.a.a.c$1
 *  io.a.a.a.c$2
 *  io.a.a.a.h
 *  io.a.a.a.m
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.Callable
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package io.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import io.a.a.a.a;
import io.a.a.a.a.b.p;
import io.a.a.a.a.c.d;
import io.a.a.a.a.c.k;
import io.a.a.a.a.c.l;
import io.a.a.a.b;
import io.a.a.a.c;
import io.a.a.a.e;
import io.a.a.a.f;
import io.a.a.a.h;
import io.a.a.a.i;
import io.a.a.a.j;
import io.a.a.a.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class c {
    static volatile c a;
    static final io.a.a.a.l b;
    public final ExecutorService c;
    public io.a.a.a.a d;
    public WeakReference<Activity> e;
    final io.a.a.a.l f;
    final boolean g;
    private final Context h;
    private final Map<Class<? extends i>, i> i;
    private final Handler j;
    private final f<c> k;
    private final f<?> l;
    private final p m;
    private AtomicBoolean n;

    static {
        b = new b(0);
    }

    private c(Context context, Map<Class<? extends i>, i> map, k k2, Handler handler, io.a.a.a.l l2, boolean bl, f f2, p p2, Activity activity) {
        this.h = context;
        this.i = map;
        this.c = k2;
        this.j = handler;
        this.f = l2;
        this.g = bl;
        this.k = f2;
        this.n = new AtomicBoolean(false);
        this.l = new 2((c)this, map.size());
        this.m = p2;
        this.a(activity);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static /* varargs */ c a(Context context, i ... arri) {
        if (a != null) return a;
        Class<c> class_ = c.class;
        // MONITORENTER : io.a.a.a.c.class
        if (a == null) {
            c c2;
            HashMap hashMap;
            a a2 = new a(context);
            if (a2.b != null) {
                throw new IllegalStateException("Kits already set.");
            }
            a2.b = arri;
            if (a2.c == null) {
                a2.c = k.a();
            }
            if (a2.d == null) {
                a2.d = new Handler(Looper.getMainLooper());
            }
            if (a2.e == null) {
                b b2 = a2.f ? new b() : new b(0);
                a2.e = b2;
            }
            if (a2.h == null) {
                a2.h = a2.a.getPackageName();
            }
            if (a2.i == null) {
                a2.i = f.d;
            }
            if (a2.b == null) {
                hashMap = new HashMap();
            } else {
                List list = Arrays.asList((Object[])a2.b);
                HashMap hashMap2 = new HashMap(list.size());
                c.a((Map<Class<? extends i>, i>)hashMap2, (Collection<? extends i>)list);
                hashMap = hashMap2;
            }
            Context context2 = a2.a.getApplicationContext();
            p p2 = new p(context2, a2.h, a2.g, hashMap.values());
            k k2 = a2.c;
            Handler handler = a2.d;
            io.a.a.a.l l2 = a2.e;
            boolean bl = a2.f;
            f<c> f2 = a2.i;
            Context context3 = a2.a;
            Activity activity = context3 instanceof Activity ? (Activity)context3 : null;
            a = c2 = new c(context2, (Map<Class<? extends i>, i>)hashMap, k2, handler, l2, bl, f2, p2, activity);
            c2.d = new io.a.a.a.a(c2.h);
            c2.d.a(new 1(c2));
            c2.a(c2.h);
        }
        // MONITOREXIT : class_
        return a;
    }

    public static <T extends i> T a(Class<T> class_) {
        if (a == null) {
            throw new IllegalStateException("Must Initialize Fabric before using singleton()");
        }
        return (T)((i)c.a.i.get(class_));
    }

    public static io.a.a.a.l a() {
        if (a == null) {
            return b;
        }
        return c.a.f;
    }

    static /* synthetic */ AtomicBoolean a(c c2) {
        return c2.n;
    }

    private void a(Context context) {
        e e2 = new e(context.getPackageCodePath());
        Future future = this.c.submit((Callable)e2);
        Collection collection = this.i.values();
        m m2 = new m(future, collection);
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort((List)arrayList);
        m2.a(context, (c)this, f.d, this.m);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((i)iterator.next()).a(context, (c)this, this.l, this.m);
        }
        m2.i();
        StringBuilder stringBuilder = c.a().a(3) ? new StringBuilder("Initializing io.fabric.sdk.android:fabric [Version: 1.4.2.22], with the following kits:\n") : null;
        for (i i2 : arrayList) {
            i2.g.a((l)m2.g);
            c.a(this.i, i2);
            i2.i();
            if (stringBuilder == null) continue;
            stringBuilder.append(i2.b());
            stringBuilder.append(" [Version: ");
            stringBuilder.append(i2.a());
            stringBuilder.append("]\n");
        }
        if (stringBuilder != null) {
            c.a().a("Fabric", stringBuilder.toString());
        }
    }

    private static void a(Map<Class<? extends i>, i> map, i i2) {
        d d2 = i2.k;
        if (d2 != null) {
            for (Class class_ : d2.a()) {
                if (class_.isInterface()) {
                    for (i i3 : map.values()) {
                        if (!class_.isAssignableFrom(i3.getClass())) continue;
                        i2.g.a(i3.g);
                    }
                    continue;
                }
                if ((i)map.get((Object)class_) == null) {
                    throw new io.a.a.a.a.c.m("Referenced Kit was null, does the kit exist?");
                }
                i2.g.a(((i)map.get((Object)class_)).g);
            }
        }
    }

    private static void a(Map<Class<? extends i>, i> map, Collection<? extends i> collection) {
        for (i i2 : collection) {
            map.put((Object)i2.getClass(), (Object)i2);
            if (!(i2 instanceof j)) continue;
            c.a(map, ((j)((Object)i2)).c());
        }
    }

    static /* synthetic */ f b(c c2) {
        return c2.k;
    }

    public static boolean b() {
        if (a == null) {
            return false;
        }
        return c.a.g;
    }

    public final c a(Activity activity) {
        this.e = new WeakReference((Object)activity);
        return this;
    }

    public static final class a {
        final Context a;
        i[] b;
        k c;
        Handler d;
        io.a.a.a.l e;
        boolean f;
        String g;
        String h;
        f<c> i;

        public a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.a = context;
        }
    }

}

