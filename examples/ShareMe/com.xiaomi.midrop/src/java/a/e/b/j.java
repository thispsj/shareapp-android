/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.e.a.a
 *  a.e.a.b
 *  a.e.a.c
 *  a.e.a.d
 *  a.e.a.e
 *  a.e.a.f
 *  a.e.a.g
 *  a.e.a.h
 *  a.e.a.i
 *  a.e.a.j
 *  a.e.a.k
 *  a.e.a.l
 *  a.e.a.m
 *  a.e.a.n
 *  a.e.a.o
 *  a.e.a.p
 *  a.e.a.q
 *  a.e.a.r
 *  a.e.a.s
 *  a.e.a.t
 *  a.e.a.u
 *  a.e.a.v
 *  a.e.a.w
 *  a.e.b.c
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package a.e.b;

import a.c;
import a.e.a.a;
import a.e.a.b;
import a.e.a.e;
import a.e.a.f;
import a.e.a.g;
import a.e.a.h;
import a.e.a.i;
import a.e.a.k;
import a.e.a.l;
import a.e.a.m;
import a.e.a.n;
import a.e.a.o;
import a.e.a.p;
import a.e.a.q;
import a.e.a.r;
import a.e.a.s;
import a.e.a.t;
import a.e.a.u;
import a.e.a.v;
import a.e.a.w;
import a.e.b.d;

public class j {
    public static Object a(Object object) {
        if (object != null) {
            int n2;
            boolean bl = object instanceof c;
            boolean bl2 = true;
            if (!bl || (n2 = object instanceof a.e.b.c ? ((a.e.b.c)object).c() : (object instanceof a ? 0 : (object instanceof b ? 1 : (object instanceof m ? 2 : (object instanceof q ? 3 : (object instanceof r ? 4 : (object instanceof s ? 5 : (object instanceof t ? 6 : (object instanceof u ? 7 : (object instanceof v ? 8 : (object instanceof w ? 9 : (object instanceof a.e.a.c ? 10 : (object instanceof a.e.a.d ? 11 : (object instanceof e ? 12 : (object instanceof f ? 13 : (object instanceof g ? 14 : (object instanceof h ? 15 : (object instanceof i ? 16 : (object instanceof a.e.a.j ? 17 : (object instanceof k ? 18 : (object instanceof l ? 19 : (object instanceof n ? 20 : (object instanceof o ? 21 : (object instanceof p ? 22 : -1)))))))))))))))))))))))) != 2) {
                bl2 = false;
            }
            if (!bl2) {
                String string2 = object == null ? "null" : object.getClass().getName();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(" cannot be cast to ");
                stringBuilder.append("kotlin.jvm.functions.Function2");
                throw d.a(new ClassCastException(stringBuilder.toString()), j.class.getName());
            }
        }
        return object;
    }
}

