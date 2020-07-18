/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package midrop.c.e;

import b.a.q;
import midrop.c.c.e;
import midrop.c.c.f;
import midrop.c.e.a;
import midrop.c.e.b;

public final class c {
    public static a a(String string2, String string3, byte by, b.b.a a2, int n2, q q2) {
        a a3 = new a();
        if (string2 != null) {
            a3.b(string2);
        }
        a3.a(string3);
        a3.a(by);
        if (a2 != null) {
            boolean bl = a2.a;
            a3.a.b(b.e, bl);
            boolean bl2 = a2.b;
            a3.a.b(b.g, bl2);
            boolean bl3 = a2.c;
            a3.a.b(b.f, bl3);
            a3.a(a2.d);
            a3.b(a2.e);
            a3.c(a2.f);
            a3.d(a2.g);
        }
        if (n2 >= 0) {
            a3.b(n2);
        } else {
            a3.b(-1);
        }
        if (q2 != null) {
            boolean bl = q2.b;
            a3.a.b(b.q, bl);
            boolean bl4 = q2.c;
            a3.a.b(b.r, bl4);
            boolean bl5 = q2.d;
            a3.a.b(b.s, bl5);
        }
        return a3;
    }
}

