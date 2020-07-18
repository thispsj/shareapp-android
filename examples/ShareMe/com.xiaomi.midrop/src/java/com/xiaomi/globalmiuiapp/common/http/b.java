/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.xiaomi.globalmiuiapp.common.http.a
 *  com.xiaomi.globalmiuiapp.common.http.b$1
 *  com.xiaomi.globalmiuiapp.common.http.b$a
 *  d.a.a.a
 *  d.c
 *  d.c$a
 *  d.e
 *  d.e$a
 *  d.j
 *  d.m
 *  d.m$1
 *  d.m$a
 *  d.o
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.Proxy
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.concurrent.Executor
 *  java.util.concurrent.TimeUnit
 *  okhttp3.c
 *  okhttp3.e
 *  okhttp3.e$a
 *  okhttp3.internal.a.f
 *  okhttp3.internal.c
 *  okhttp3.t
 *  okhttp3.x
 *  okhttp3.x$a
 */
package com.xiaomi.globalmiuiapp.common.http;

import android.content.Context;
import android.text.TextUtils;
import com.a.b.s;
import com.xiaomi.globalmiuiapp.common.http.NullPrimitiveAdapter;
import com.xiaomi.globalmiuiapp.common.http.b;
import d.c;
import d.e;
import d.j;
import d.m;
import d.o;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import okhttp3.c;
import okhttp3.e;
import okhttp3.internal.a.f;
import okhttp3.t;
import okhttp3.x;

/*
 * Exception performing whole class analysis.
 */
public class b {
    private static volatile m a;
    private static final x b;

    static {
        x.a a2 = new x.a();
        a2.x = okhttp3.internal.c.a((String)"timeout", (long)20L, (TimeUnit)TimeUnit.SECONDS);
        a2.y = okhttp3.internal.c.a((String)"timeout", (long)15L, (TimeUnit)TimeUnit.SECONDS);
        a2.j = new c(com.xiaomi.globalmiuiapp.common.d.a.a("http"));
        a2.k = null;
        1 var1_1 = new 1();
        a2.e.add((Object)var1_1);
        StringBuilder stringBuilder = new StringBuilder("XMOKHttpHelper_");
        String string2 = TextUtils.isEmpty((CharSequence)com.xiaomi.globalmiuiapp.common.a.a.a.f) ? com.xiaomi.globalmiuiapp.common.a.a.a.b.getPackageName() : com.xiaomi.globalmiuiapp.common.a.a.a.f;
        stringBuilder.append(string2);
        com.xiaomi.globalmiuiapp.common.http.a a3 = new com.xiaomi.globalmiuiapp.common.http.a(stringBuilder.toString());
        a2.f.add((Object)a3);
        b = new x(a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static <T> T a(Class<T> class_) {
        if (a == null) {
            Class<b> class_2 = b.class;
            // MONITORENTER : com.xiaomi.globalmiuiapp.common.http.b.class
            if (a == null) {
                Executor executor;
                m m2;
                m.a a2 = new m.a();
                String string2 = com.xiaomi.globalmiuiapp.common.a.a.a.d;
                o.a((Object)string2, (String)"baseUrl == null");
                t t2 = t.e((String)string2);
                if (t2 == null) {
                    StringBuilder stringBuilder = new StringBuilder("Illegal URL: ");
                    stringBuilder.append(string2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                o.a((Object)t2, (String)"baseUrl == null");
                List list = t2.d;
                if (!"".equals(list.get(list.size() - 1))) {
                    StringBuilder stringBuilder = new StringBuilder("baseUrl must end in /: ");
                    stringBuilder.append((Object)t2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                a2.c = t2;
                a2.b = (e.a)o.a((Object)((e.a)o.a((Object)b, (String)"client == null")), (String)"factory == null");
                m.a a3 = a2.a((e.a)new /* Unavailable Anonymous Inner Class!! */).a((e.a)new d.a.a.a(new s(new s.a().a(new NullPrimitiveAdapter()))));
                if (a3.c == null) {
                    throw new IllegalStateException("Base URL required.");
                }
                e.a a4 = a3.b;
                if (a4 == null) {
                    a4 = new x();
                }
                if ((executor = a3.f) == null) {
                    executor = a3.a.b();
                }
                Executor executor2 = executor;
                ArrayList arrayList = new ArrayList((Collection)a3.e);
                arrayList.add((Object)a3.a.a(executor2));
                ArrayList arrayList2 = new ArrayList((Collection)a3.d);
                a = m2 = new m(a4, a3.c, (List)arrayList2, (List)arrayList, executor2, a3.g);
            }
            // MONITOREXIT : class_2
        }
        m m3 = a;
        o.a(class_);
        if (!m3.f) return (T)Proxy.newProxyInstance((ClassLoader)class_.getClassLoader(), (Class[])new Class[]{class_}, (InvocationHandler)new m.1(m3, class_));
        m3.a(class_);
        return (T)Proxy.newProxyInstance((ClassLoader)class_.getClassLoader(), (Class[])new Class[]{class_}, (InvocationHandler)new m.1(m3, class_));
    }
}

