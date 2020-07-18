/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.ResultReceiver
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  midrop.a.c.a.a.a
 */
package midrop.b.c;

import android.os.ResultReceiver;

public interface a {
    public int a();

    public void a(ResultReceiver var1);

    public int b(b.g.b.a var1);

    public int b(b.g.b.b var1);

    public int d();

    public int e();

    public String f();

    public midrop.a.c.a.a.a g();

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a A;
        public static final /* enum */ a B;
        public static final /* enum */ a C;
        private static final /* synthetic */ a[] E;
        public static final /* enum */ a a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        public static final /* enum */ a d;
        public static final /* enum */ a e;
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        public static final /* enum */ a j;
        public static final /* enum */ a k;
        public static final /* enum */ a l;
        public static final /* enum */ a m;
        public static final /* enum */ a n;
        public static final /* enum */ a o;
        public static final /* enum */ a p;
        public static final /* enum */ a q;
        public static final /* enum */ a r;
        public static final /* enum */ a s;
        public static final /* enum */ a t;
        public static final /* enum */ a u;
        public static final /* enum */ a v;
        public static final /* enum */ a w;
        public static final /* enum */ a x;
        public static final /* enum */ a y;
        public static final /* enum */ a z;
        public Object D;

        static {
            a = new a();
            b = new a();
            c = new a();
            d = new a();
            e = new a();
            f = new a();
            g = new a();
            h = new a();
            i = new a();
            j = new a();
            k = new a();
            l = new a();
            m = new a();
            n = new a();
            o = new a();
            p = new a();
            q = new a();
            r = new a();
            s = new a();
            t = new a();
            u = new a();
            v = new a();
            w = new a();
            x = new a();
            y = new a();
            z = new a();
            A = new a();
            B = new a();
            C = new a();
            a[] arra = new a[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C};
            E = arra;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])E.clone();
        }
    }

    public static interface b {
        public void a(a var1, a var2);
    }

}

