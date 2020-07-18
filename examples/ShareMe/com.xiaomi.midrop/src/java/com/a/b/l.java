/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  c.d
 *  c.e
 *  com.a.b.n
 *  com.a.b.o
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 */
package com.a.b;

import c.c;
import c.d;
import c.e;
import c.f;
import c.m;
import com.a.b.i;
import com.a.b.j;
import com.a.b.n;
import com.a.b.o;
import com.a.b.q;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;

public abstract class l
implements Closeable {
    int a = 0;
    final int[] b = new int[32];
    final String[] c = new String[32];
    final int[] d = new int[32];
    boolean e;
    boolean f;

    l() {
    }

    public static l a(e e2) {
        return new n(e2);
    }

    public abstract int a(a var1) throws IOException;

    final j a(String string2) throws j {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" at path ");
        stringBuilder.append(this.p());
        throw new j(stringBuilder.toString());
    }

    public abstract void a() throws IOException;

    final void a(int n2) {
        if (this.a == this.b.length) {
            StringBuilder stringBuilder = new StringBuilder("Nesting too deep at ");
            stringBuilder.append(this.p());
            throw new i(stringBuilder.toString());
        }
        int[] arrn = this.b;
        int n3 = this.a;
        this.a = n3 + 1;
        arrn[n3] = n2;
    }

    public abstract int b(a var1) throws IOException;

    public abstract void b() throws IOException;

    public abstract void c() throws IOException;

    public abstract void d() throws IOException;

    public abstract boolean e() throws IOException;

    public abstract b f() throws IOException;

    public abstract String g() throws IOException;

    public abstract String h() throws IOException;

    public abstract boolean i() throws IOException;

    public abstract <T> T j() throws IOException;

    public abstract double k() throws IOException;

    public abstract long l() throws IOException;

    public abstract int m() throws IOException;

    public abstract void n() throws IOException;

    public final Object o() throws IOException {
        switch (1.a[this.f().ordinal()]) {
            default: {
                StringBuilder stringBuilder = new StringBuilder("Expected a value but was ");
                stringBuilder.append((Object)((Object)this.f()));
                stringBuilder.append(" at path ");
                stringBuilder.append(this.p());
                throw new IllegalStateException(stringBuilder.toString());
            }
            case 6: {
                return this.j();
            }
            case 5: {
                return this.i();
            }
            case 4: {
                return this.k();
            }
            case 3: {
                return this.h();
            }
            case 2: {
                q<K, V> q2 = new q<K, V>();
                this.c();
                while (this.e()) {
                    Object object;
                    String string2 = this.g();
                    Object object2 = q2.put((Object)string2, object = this.o());
                    if (object2 == null) continue;
                    StringBuilder stringBuilder = new StringBuilder("Map key '");
                    stringBuilder.append(string2);
                    stringBuilder.append("' has multiple values at path ");
                    stringBuilder.append(this.p());
                    stringBuilder.append(": ");
                    stringBuilder.append(object2);
                    stringBuilder.append(" and ");
                    stringBuilder.append(object);
                    throw new i(stringBuilder.toString());
                }
                this.d();
                return q2;
            }
            case 1: 
        }
        ArrayList arrayList = new ArrayList();
        this.a();
        while (this.e()) {
            arrayList.add(this.o());
        }
        this.b();
        return arrayList;
    }

    public final String p() {
        return com.a.b.m.a(this.a, this.b, this.c, this.d);
    }

    abstract void q() throws IOException;

    public static final class a {
        final String[] a;
        final m b;

        private a(String[] arrstring, m m2) {
            this.a = arrstring;
            this.b = m2;
        }

        public static /* varargs */ a a(String ... arrstring) {
            f[] arrf = new f[arrstring.length];
            c c2 = new c();
            int n2 = 0;
            do {
                if (n2 >= arrstring.length) break;
                o.a((d)c2, (String)arrstring[n2]);
                c2.e();
                arrf[n2] = c2.l();
                ++n2;
            } while (true);
            try {
                a a2 = new a((String[])arrstring.clone(), m.a(arrf));
                return a2;
            }
            catch (IOException iOException) {
                throw new AssertionError((Object)iOException);
            }
        }
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b a = new b();
        public static final /* enum */ b b = new b();
        public static final /* enum */ b c = new b();
        public static final /* enum */ b d = new b();
        public static final /* enum */ b e = new b();
        public static final /* enum */ b f = new b();
        public static final /* enum */ b g = new b();
        public static final /* enum */ b h = new b();
        public static final /* enum */ b i = new b();
        public static final /* enum */ b j = new b();
        private static final /* synthetic */ b[] k;

        static {
            b[] arrb = new b[]{a, b, c, d, e, f, g, h, i, j};
            k = arrb;
        }

        public static b valueOf(String string2) {
            return (b)Enum.valueOf(b.class, (String)string2);
        }

        public static b[] values() {
            return (b[])k.clone();
        }
    }

}

