/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.util.AbstractSet
 *  java.util.Iterator
 *  java.util.Set
 *  java.util.concurrent.ConcurrentMap
 */
package io.netty.d.b;

import io.netty.d.b.n;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

public final class d<E>
extends AbstractSet<E>
implements Serializable {
    private static final long serialVersionUID = -6761513279741915432L;
    private final ConcurrentMap<E, Boolean> a = n.j();

    public final boolean add(E e2) {
        return this.a.putIfAbsent(e2, (Object)Boolean.TRUE) == null;
    }

    public final void clear() {
        this.a.clear();
    }

    public final boolean contains(Object object) {
        return this.a.containsKey(object);
    }

    public final Iterator<E> iterator() {
        return this.a.keySet().iterator();
    }

    public final boolean remove(Object object) {
        return this.a.remove(object) != null;
    }

    public final int size() {
        return this.a.size();
    }
}

