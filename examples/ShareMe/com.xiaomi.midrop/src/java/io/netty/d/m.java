/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.m$a
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.ref.Reference
 *  java.lang.ref.ReferenceQueue
 *  java.lang.reflect.Method
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.concurrent.ConcurrentMap
 *  java.util.concurrent.atomic.AtomicReference
 */
package io.netty.d;

import io.netty.d.b.e;
import io.netty.d.b.n;
import io.netty.d.b.t;
import io.netty.d.b.u;
import io.netty.d.m;
import io.netty.d.o;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;

/*
 * Exception performing whole class analysis.
 */
public class m<T> {
    private static final c a;
    private static final int b;
    private static c c;
    private static final io.netty.d.b.a.d d;
    private static final AtomicReference<String[]> j;
    private final ConcurrentMap<a<?>, b> e;
    private final ReferenceQueue<Object> f;
    private final ConcurrentMap<String, Boolean> g;
    private final String h;
    private final int i;

    static {
        a = c.b;
        d = io.netty.d.b.a.e.a(m.class);
        String string2 = u.b("io.netty.noResourceLeakDetection");
        boolean bl = false;
        if (string2 != null) {
            bl = u.a("io.netty.noResourceLeakDetection", false);
            d.b("-Dio.netty.noResourceLeakDetection: {}", (Object)bl);
            d.c("-Dio.netty.noResourceLeakDetection is deprecated. Use '-D{}={}' instead.", (Object)"io.netty.leakDetection.level", (Object)a.name().toLowerCase());
        }
        c c2 = bl ? c.a : a;
        c c3 = c.a(u.a("io.netty.leakDetection.level", u.a("io.netty.leakDetectionLevel", c2.name())));
        b = u.a("io.netty.leakDetection.targetRecords", 4);
        c = c3;
        if (d.b()) {
            d.b("-D{}: {}", (Object)"io.netty.leakDetection.level", (Object)c3.name().toLowerCase());
            d.b("-D{}: {}", (Object)"io.netty.leakDetection.targetRecords", (Object)b);
        }
        j = new AtomicReference((Object)e.e);
    }

    @Deprecated
    public m(Class<?> class_) {
        super(class_, (byte)0);
    }

    public m(Class<?> class_, byte by) {
        super(t.a(class_));
    }

    @Deprecated
    private m(String string2) {
        this.e = n.j();
        this.f = new ReferenceQueue();
        this.g = n.j();
        if (string2 == null) {
            throw new NullPointerException("resourceType");
        }
        this.h = string2;
        this.i = 128;
    }

    public static c a() {
        return c;
    }

    public static /* varargs */ void a(Class class_, String ... arrstring) {
        String[] arrstring2;
        Object[] arrobject;
        HashSet hashSet = new HashSet((Collection)Arrays.asList((Object[])arrstring));
        Method[] arrmethod = class_.getDeclaredMethods();
        int n2 = arrmethod.length;
        for (int i2 = 0; !(i2 >= n2 || hashSet.remove((Object)arrmethod[i2].getName()) && hashSet.isEmpty()); ++i2) {
        }
        if (!hashSet.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("Can't find '");
            stringBuilder.append((Object)hashSet);
            stringBuilder.append("' in ");
            stringBuilder.append(class_.getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        do {
            arrobject = (String[])j.get();
            arrstring2 = (String[])Arrays.copyOf((Object[])arrobject, (int)(2 + arrobject.length));
            for (int i3 = 0; i3 <= 0; ++i3) {
                int n3 = arrobject.length;
                int n4 = i3 * 2;
                arrstring2[n3 + n4] = class_.getName();
                arrstring2[1 + (n4 + arrobject.length)] = arrstring[i3];
            }
        } while (!j.compareAndSet((Object)arrobject, (Object)arrstring2));
    }

    static /* synthetic */ int c() {
        return b;
    }

    private void e() {
        a a2;
        if (!d.e()) {
            a a3;
            while ((a3 = this.f.poll()) != null) {
                a3.b();
            }
            return;
        }
        while ((a2 = this.f.poll()) != null) {
            String string2;
            if (!a2.b() || this.g.putIfAbsent((Object)(string2 = a2.toString()), (Object)Boolean.TRUE) != null) continue;
            if (string2.isEmpty()) {
                String string3 = this.h;
                io.netty.d.b.a.d d2 = d;
                Object[] arrobject = new Object[]{string3, "io.netty.leakDetection.level", c.c.name().toLowerCase(), t.a(this)};
                d2.c("LEAK: {}.release() was not called before it's garbage-collected. Enable advanced leak reporting to find out where the leak occurred. To enable advanced leak reporting, specify the JVM option '-D{}={}' or call {}.setLevel() See http://netty.io/wiki/reference-counted-objects.html for more information.", arrobject);
                continue;
            }
            String string4 = this.h;
            d.d("LEAK: {}.release() was not called before it's garbage-collected. See http://netty.io/wiki/reference-counted-objects.html for more information.{}", string4, string2);
        }
    }

    public final o<T> a(T t2) {
        c c2 = c;
        if (c2 == c.a) {
            return null;
        }
        if (c2.ordinal() < c.d.ordinal()) {
            if (n.o().nextInt(this.i) == 0) {
                m.super.e();
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            return null;
        }
        m.super.e();
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    private static final class b {
        static final b a;
        private static final int b;

        static {
            b b2;
            a = b2 = new b();
            b = System.identityHashCode((Object)b2);
        }

        private b() {
        }

        public final boolean equals(Object object) {
            return object == this;
        }

        public final int hashCode() {
            return b;
        }
    }

    public static final class c
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

        static c a(String string2) {
            String string3 = string2.trim();
            for (c c2 : c.values()) {
                if (!string3.equalsIgnoreCase(c2.name())) {
                    if (!string3.equals((Object)String.valueOf((int)c2.ordinal()))) continue;
                    return c2;
                }
                return c2;
            }
            return a;
        }

        public static c valueOf(String string2) {
            return (c)Enum.valueOf(c.class, (String)string2);
        }

        public static c[] values() {
            return (c[])e.clone();
        }
    }

    private static final class d
    extends Throwable {
        private static final d a = new d();
        private static final long serialVersionUID = 6065153674892850720L;
        private final String b;
        private final d c;
        private final int d;

        private d() {
            this.b = null;
            this.c = null;
            this.d = -1;
        }

        d(d d2) {
            this.b = null;
            this.c = d2;
            this.d = 1 + d2.d;
        }

        static /* synthetic */ int a(d d2) {
            return d2.d;
        }

        static /* synthetic */ d a() {
            return a;
        }

        static /* synthetic */ d b(d d2) {
            return d2.c;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(2048);
            if (this.b != null) {
                stringBuilder.append("\tHint: ");
                stringBuilder.append(this.b);
                stringBuilder.append(t.a);
            }
            StackTraceElement[] arrstackTraceElement = this.getStackTrace();
            block0 : for (int i2 = 3; i2 < arrstackTraceElement.length; ++i2) {
                StackTraceElement stackTraceElement = arrstackTraceElement[i2];
                String[] arrstring = (String[])j.get();
                for (int i3 = 0; i3 < arrstring.length; i3 += 2) {
                    if (arrstring[i3].equals((Object)stackTraceElement.getClassName()) && arrstring[i3 + 1].equals((Object)stackTraceElement.getMethodName())) continue block0;
                }
                stringBuilder.append('\t');
                stringBuilder.append(stackTraceElement.toString());
                stringBuilder.append(t.a);
            }
            return stringBuilder.toString();
        }
    }

}

