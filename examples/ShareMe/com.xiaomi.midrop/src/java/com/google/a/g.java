/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.google.a;

import com.google.a.i;
import com.google.a.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
extends i
implements Iterable<i> {
    private final List<i> a = new ArrayList();

    @Override
    public final Number a() {
        if (this.a.size() == 1) {
            return ((i)this.a.get(0)).a();
        }
        throw new IllegalStateException();
    }

    public final void a(i i2) {
        if (i2 == null) {
            i2 = k.a;
        }
        this.a.add((Object)i2);
    }

    @Override
    public final String b() {
        if (this.a.size() == 1) {
            return ((i)this.a.get(0)).b();
        }
        throw new IllegalStateException();
    }

    @Override
    public final double c() {
        if (this.a.size() == 1) {
            return ((i)this.a.get(0)).c();
        }
        throw new IllegalStateException();
    }

    @Override
    public final long d() {
        if (this.a.size() == 1) {
            return ((i)this.a.get(0)).d();
        }
        throw new IllegalStateException();
    }

    @Override
    public final int e() {
        if (this.a.size() == 1) {
            return ((i)this.a.get(0)).e();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object object) {
        return object == this || object instanceof g && ((g)object).a.equals(this.a);
        {
        }
    }

    @Override
    public final boolean f() {
        if (this.a.size() == 1) {
            return ((i)this.a.get(0)).f();
        }
        throw new IllegalStateException();
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final Iterator<i> iterator() {
        return this.a.iterator();
    }
}

