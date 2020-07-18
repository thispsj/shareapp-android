/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.annotation.Annotation
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package com.google.a.b;

import com.google.a.a;
import com.google.a.d.c;
import com.google.a.e;
import com.google.a.r;
import com.google.a.s;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
implements s,
Cloneable {
    public static final d a = new d();
    public double b = -1.0;
    public int c = 136;
    public boolean d = true;
    public boolean e;
    public List<a> f = Collections.emptyList();
    public List<a> g = Collections.emptyList();

    private d a() {
        try {
            d d2 = (d)super.clone();
            return d2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError((Object)cloneNotSupportedException);
        }
    }

    public static boolean b(Class<?> class_) {
        return !Enum.class.isAssignableFrom(class_) && (class_.isAnonymousClass() || class_.isLocalClass());
    }

    public static boolean c(Class<?> class_) {
        boolean bl;
        return class_.isMemberClass() && !(bl = (8 & class_.getModifiers()) != 0);
    }

    @Override
    public final <T> r<T> a(final e e2, final com.google.a.c.a<T> a2) {
        boolean bl = this.a(a2.a);
        final boolean bl2 = bl || this.a(true);
        final boolean bl3 = bl || this.a(false);
        if (!bl2 && !bl3) {
            return null;
        }
        r r2 = new r<T>(){
            private r<T> f;

            private r<T> b() {
                r<T> r2 = this.f;
                if (r2 != null) {
                    return r2;
                }
                r r3 = e2.a(d.this, a2);
                this.f = r3;
                return r3;
            }

            @Override
            public final T a(com.google.a.d.a a22) throws IOException {
                if (bl3) {
                    a22.o();
                    return null;
                }
                return 1.super.b().a(a22);
            }

            @Override
            public final void a(c c2, T t2) throws IOException {
                if (bl2) {
                    c2.e();
                    return;
                }
                1.super.b().a(c2, t2);
            }
        };
        return r2;
    }

    public final boolean a(com.google.a.a.d d2, com.google.a.a.e e2) {
        boolean bl;
        boolean bl2 = d2 == null || !(d2.a() > this.b);
        return bl2 && (bl = e2 == null || !(e2.a() <= this.b));
    }

    public final boolean a(Class<?> class_) {
        if (this.b != -1.0 && !this.a((com.google.a.a.d)class_.getAnnotation(com.google.a.a.d.class), (com.google.a.a.e)class_.getAnnotation(com.google.a.a.e.class))) {
            return true;
        }
        if (!this.d && d.c(class_)) {
            return true;
        }
        return d.b(class_);
    }

    public final boolean a(boolean bl) {
        List<a> list = bl ? this.f : this.g;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (!((a)iterator.next()).b()) continue;
            return true;
        }
        return false;
    }

    protected final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.a();
    }

}

