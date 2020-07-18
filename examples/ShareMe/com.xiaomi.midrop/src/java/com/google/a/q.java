/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.q$1
 *  com.google.a.q$2
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.google.a;

import com.google.a.q;

public abstract class q
extends Enum<q> {
    public static final /* enum */ q a = new 1("DEFAULT");
    public static final /* enum */ q b = new 2("STRING");
    private static final /* synthetic */ q[] c;

    static {
        q[] arrq = new q[]{a, b};
        c = arrq;
    }

    private q() {
    }

    /* synthetic */ q(String string2, int n2, byte by) {
    }

    public static q valueOf(String string2) {
        return (q)Enum.valueOf(q.class, (String)string2);
    }

    public static q[] values() {
        return (q[])c.clone();
    }
}

