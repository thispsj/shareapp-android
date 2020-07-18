/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.google.a.b.a;

import com.google.a.b.a.h;
import com.google.a.d.a;
import com.google.a.d.b;
import com.google.a.d.c;
import com.google.a.e;
import com.google.a.r;
import com.google.a.s;
import java.io.IOException;
import java.util.ArrayList;

public final class h
extends r<Object> {
    public static final s a = new s(){

        @Override
        public final <T> r<T> a(e e2, com.google.a.c.a<T> a2) {
            if (a2.a == Object.class) {
                return new h(e2);
            }
            return null;
        }
    };
    private final e b;

    h(e e2) {
        this.b = e2;
    }

    @Override
    public final Object a(a a2) throws IOException {
        b b2 = a2.f();
        switch (2.a[b2.ordinal()]) {
            default: {
                throw new IllegalStateException();
            }
            case 6: {
                a2.k();
                return null;
            }
            case 5: {
                return a2.j();
            }
            case 4: {
                return a2.l();
            }
            case 3: {
                return a2.i();
            }
            case 2: {
                com.google.a.b.h h2 = new com.google.a.b.h();
                a2.c();
                while (a2.e()) {
                    h2.put((Object)a2.h(), this.a(a2));
                }
                a2.d();
                return h2;
            }
            case 1: 
        }
        ArrayList arrayList = new ArrayList();
        a2.a();
        while (a2.e()) {
            arrayList.add(this.a(a2));
        }
        a2.b();
        return arrayList;
    }

    @Override
    public final void a(c c2, Object object) throws IOException {
        if (object == null) {
            c2.e();
            return;
        }
        r<Object> r2 = this.b.a(object.getClass());
        if (r2 instanceof h) {
            c2.c();
            c2.d();
            return;
        }
        r2.a(c2, object);
    }

}

