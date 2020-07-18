/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.b.g
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.IdentityHashMap
 *  java.util.Map
 *  java.util.Set
 */
package io.netty.d.a;

import io.netty.d.a.o;
import io.netty.d.b.f;
import io.netty.d.b.g;
import io.netty.d.b.k;
import io.netty.d.b.n;
import io.netty.d.b.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

public class m<V> {
    private static final int variablesToRemoveIndex = g.e();
    private final int cleanerFlagIndex = g.e();
    private final int index = g.e();

    private static void addToVariablesToRemove(g g2, m<?> m2) {
        Set set;
        Object object = g2.a(variablesToRemoveIndex);
        if (object != g.a && object != null) {
            set = (Set)object;
        } else {
            set = Collections.newSetFromMap((Map)new IdentityHashMap());
            g2.a(variablesToRemoveIndex, (Object)set);
        }
        set.add(m2);
    }

    public static void destroy() {
        g.d();
    }

    private V initialize(g g2) {
        V v2;
        try {
            v2 = this.initialValue();
        }
        catch (Exception exception) {
            n.a(exception);
            v2 = null;
        }
        g2.a(this.index, v2);
        m.addToVariablesToRemove(g2, this);
        return v2;
    }

    private void registerCleaner(final g g2) {
        Thread thread = Thread.currentThread();
        if (!o.a(thread)) {
            if (g2.a(this.cleanerFlagIndex) != g.a) {
                return;
            }
            g2.a(this.cleanerFlagIndex, (Object)Boolean.TRUE);
            k.a((Object)thread, new Runnable(){

                public final void run() {
                    m.this.remove(g2);
                }
            });
        }
    }

    public static void removeAll() {
        block6 : {
            m[] arrm;
            int n2;
            g g2 = g.a();
            if (g2 == null) {
                return;
            }
            Object object = g2.a(variablesToRemoveIndex);
            if (object == null) break block6;
            try {
                if (object == g.a) break block6;
                Set set = (Set)object;
                arrm = (m[])set.toArray((Object[])new m[set.size()]);
                n2 = arrm.length;
            }
            catch (Throwable throwable) {
                g.c();
                throw throwable;
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                arrm[i2].remove(g2);
            }
        }
        g.c();
        return;
    }

    private static void removeFromVariablesToRemove(g g2, m<?> m2) {
        Object object = g2.a(variablesToRemoveIndex);
        if (object != g.a) {
            if (object == null) {
                return;
            }
            ((Set)object).remove(m2);
        }
    }

    private boolean setKnownNotUnset(g g2, V v2) {
        if (g2.a(this.index, v2)) {
            m.addToVariablesToRemove(g2, this);
            return true;
        }
        return false;
    }

    public static int size() {
        g g2 = g.a();
        int n2 = 0;
        if (g2 == null) {
            return 0;
        }
        int n3 = g2.e != 0 ? 1 : 0;
        if (g2.f != 0) {
            ++n3;
        }
        if (g2.g != null) {
            ++n3;
        }
        if (g2.h != null) {
            ++n3;
        }
        if (g2.i != null) {
            ++n3;
        }
        if (g2.j != null) {
            ++n3;
        }
        if (g2.k != null) {
            ++n3;
        }
        if (g2.l != null) {
            ++n3;
        }
        if (g2.m != null) {
            ++n3;
        }
        if (g2.n != null) {
            ++n3;
        }
        if (g2.o != null) {
            ++n3;
        }
        Object[] arrobject = g2.d;
        int n4 = arrobject.length;
        while (n2 < n4) {
            if (arrobject[n2] != g.a) {
                ++n3;
            }
            ++n2;
        }
        return n3 - 1;
    }

    public final V get() {
        g g2 = g.b();
        Object object = g2.a(this.index);
        if (object != g.a) {
            return (V)object;
        }
        V v2 = this.initialize(g2);
        this.registerCleaner(g2);
        return v2;
    }

    public final V get(g g2) {
        Object object = g2.a(this.index);
        if (object != g.a) {
            return (V)object;
        }
        return m.super.initialize(g2);
    }

    public V initialValue() throws Exception {
        return null;
    }

    public final boolean isSet() {
        return this.isSet(g.a());
    }

    public final boolean isSet(g g2) {
        boolean bl;
        Object[] arrobject;
        int n2;
        return g2 != null && (bl = (n2 = this.index) < (arrobject = g2.d).length && arrobject[n2] != g.a);
    }

    public void onRemoval(V v2) throws Exception {
    }

    public final void remove() {
        this.remove(g.a());
    }

    public final void remove(g g2) {
        Object object;
        if (g2 == null) {
            return;
        }
        int n2 = this.index;
        Object[] arrobject = g2.d;
        if (n2 < arrobject.length) {
            object = arrobject[n2];
            arrobject[n2] = g.a;
        } else {
            object = g.a;
        }
        m.removeFromVariablesToRemove(g2, this);
        if (object != g.a) {
            try {
                this.onRemoval(object);
                return;
            }
            catch (Exception exception) {
                n.a(exception);
            }
        }
    }

    public final void set(g g2, V v2) {
        if (v2 != g.a) {
            m.super.setKnownNotUnset(g2, v2);
            return;
        }
        this.remove(g2);
    }

    public final void set(V v2) {
        if (v2 != g.a) {
            g g2 = g.b();
            if (m.super.setKnownNotUnset(g2, v2)) {
                m.super.registerCleaner(g2);
            }
            return;
        }
        this.remove();
    }

}

