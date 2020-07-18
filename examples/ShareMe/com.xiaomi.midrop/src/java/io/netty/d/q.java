/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Comparable
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.ConcurrentMap
 *  java.util.concurrent.atomic.AtomicInteger
 */
package io.netty.d;

import io.netty.d.b.l;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public class q
implements Comparable<q> {
    private static final AtomicInteger a = new AtomicInteger();
    final int D;
    final String E;

    protected q(String string2) {
        this.E = l.a(string2, "name");
        this.D = a.incrementAndGet();
    }

    public /* varargs */ q(ConcurrentMap<String, Boolean> concurrentMap,  /* corrupt varargs signature?! */ String string2) {
        l.a(concurrentMap, "map");
        if (concurrentMap.putIfAbsent((Object)string2, (Object)Boolean.TRUE) != null) {
            throw new IllegalArgumentException(String.format((String)"'%s' is already in use", (Object[])new Object[]{string2}));
        }
        this.E = l.a(string2, "name");
        this.D = a.incrementAndGet();
    }

    public /* synthetic */ int compareTo(Object object) {
        q q2 = (q)object;
        if (this == q2) {
            return 0;
        }
        int n2 = this.E.compareTo(q2.E);
        if (n2 != 0) {
            return n2;
        }
        return Integer.valueOf((int)this.D).compareTo(Integer.valueOf((int)q2.D));
    }

    public final boolean equals(Object object) {
        return super.equals(object);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return this.E;
    }
}

