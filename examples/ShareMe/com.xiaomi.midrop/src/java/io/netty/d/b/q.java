/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.b.q$1
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.RandomAccess
 */
package io.netty.d.b;

import io.netty.d.b.q;
import io.netty.d.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public final class q
extends ArrayList<Object> {
    private static final j<q> a = new 1();
    private static final long serialVersionUID = -8605125654176467947L;
    private boolean b;
    private final j.b c;

    private q(j.b b2) {
        super(b2, (byte)0);
    }

    private q(j.b b2, byte by) {
        super(8);
        this.c = b2;
    }

    /* synthetic */ q(j.b b2, char c2) {
        super(b2);
    }

    public static q a(int n2) {
        q q2 = a.get();
        q2.ensureCapacity(n2);
        return q2;
    }

    private static void a(Collection<?> collection) {
        if (collection instanceof RandomAccess && collection instanceof List) {
            List list = (List)collection;
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                if (list.get(i2) != null) continue;
                throw new IllegalArgumentException("c contains null values");
            }
            return;
        }
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() != null) continue;
            throw new IllegalArgumentException("c contains null values");
        }
    }

    public final boolean a() {
        this.clear();
        this.b = false;
        return a.recycle(this, this.c);
    }

    public final void add(int n2, Object object) {
        if (object == null) {
            throw new NullPointerException("element");
        }
        super.add(n2, object);
        this.b = true;
    }

    public final boolean add(Object object) {
        if (object == null) {
            throw new NullPointerException("element");
        }
        if (super.add(object)) {
            this.b = true;
            return true;
        }
        return false;
    }

    public final boolean addAll(int n2, Collection<?> collection) {
        q.a(collection);
        if (super.addAll(n2, collection)) {
            this.b = true;
            return true;
        }
        return false;
    }

    public final boolean addAll(Collection<?> collection) {
        q.a(collection);
        if (super.addAll(collection)) {
            this.b = true;
            return true;
        }
        return false;
    }

    public final Object set(int n2, Object object) {
        if (object == null) {
            throw new NullPointerException("element");
        }
        Object object2 = super.set(n2, object);
        this.b = true;
        return object2;
    }
}

