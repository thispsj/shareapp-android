/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.b.a.c$a
 *  a.b.a.c$b
 *  a.b.b.a.a
 *  a.b.b.a.c
 *  a.b.d
 *  a.b.d$a
 *  a.b.e$b
 *  a.b.f
 *  a.e.a.m
 *  java.lang.Object
 *  java.lang.String
 */
package a.b.a;

import a.b.a.c;
import a.b.d;
import a.b.e;
import a.b.f;
import a.e.a.m;
import a.j;
import a.l;

public class c {
    public static final <T> a.b.c<T> a(a.b.c<? super T> c2) {
        a.e.b.d.b(c2, "receiver$0");
        a.b.c c3 = !(c2 instanceof a.b.b.a.c) ? null : c2;
        a.b.b.a.c c4 = (a.b.b.a.c)c3;
        if (c4 != null) {
            a.b.c c5 = c4.i;
            if (c5 == null) {
                d d2 = (d)c4.a().get((e.c)d.a);
                c5 = d2 != null ? d2.a((a.b.c)c4) : (a.b.c)c4;
                c4.i = c5;
            }
            if (c5 == null) {
                return c2;
            }
            c2 = c5;
        }
        return c2;
    }

    public static final <R, T> a.b.c<l> a(m<? super R, ? super a.b.c<? super T>, ? extends Object> m2, R r2, a.b.c<? super T> c2) {
        a.e.b.d.b(m2, "receiver$0");
        a.e.b.d.b(c2, "completion");
        a.e.b.d.b(c2, "completion");
        if (m2 instanceof a.b.b.a.a) {
            return ((a.b.b.a.a)m2).a(r2, c2);
        }
        e e2 = c2.a();
        if (e2 == f.a) {
            if (c2 == null) {
                throw new j("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }
            return (a.b.c)new a(c2, c2, m2, r2);
        }
        if (c2 == null) {
            throw new j("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        b b2 = new b(c2, e2, c2, e2, m2, r2);
        return (a.b.c)b2;
    }
}

