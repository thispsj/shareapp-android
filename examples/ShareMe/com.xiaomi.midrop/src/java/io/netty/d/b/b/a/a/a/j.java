/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package io.netty.d.b.b.a.a.a;

public final class j {
    public static int a(a a2) {
        long l2 = a2.a();
        do {
            long l3 = a2.b();
            long l4 = a2.a();
            if (l2 == l4) {
                long l5 = l3 - l4;
                if (l5 > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                return (int)l5;
            }
            l2 = l4;
        } while (true);
    }

    public static boolean b(a a2) {
        return a2.a() == a2.b();
    }

    public static interface a {
        public long a();

        public long b();
    }

}

