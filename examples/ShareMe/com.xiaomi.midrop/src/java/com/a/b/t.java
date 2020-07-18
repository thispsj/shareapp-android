/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.a.b.t$1
 *  com.a.b.t$10
 *  com.a.b.t$2
 *  com.a.b.t$3
 *  com.a.b.t$4
 *  com.a.b.t$5
 *  com.a.b.t$6
 *  com.a.b.t$7
 *  com.a.b.t$8
 *  com.a.b.t$9
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 */
package com.a.b;

import com.a.b.h;
import com.a.b.i;
import com.a.b.l;
import com.a.b.t;
import java.io.IOException;

final class t {
    public static final h.a a = new 1();
    static final h<Boolean> b = new 3();
    static final h<Byte> c = new 4();
    static final h<Character> d = new 5();
    static final h<Double> e = new 6();
    static final h<Float> f = new 7();
    static final h<Integer> g = new 8();
    static final h<Long> h = new 9();
    static final h<Short> i = new 10();
    static final h<String> j = new 2();

    static int a(l l2, String string2, int n2, int n3) throws IOException {
        int n4 = l2.m();
        if (n4 >= n2 && n4 <= n3) {
            return n4;
        }
        Object[] arrobject = new Object[]{string2, n4, l2.p()};
        throw new i(String.format((String)"Expected %s but was %s at path %s", (Object[])arrobject));
    }
}

