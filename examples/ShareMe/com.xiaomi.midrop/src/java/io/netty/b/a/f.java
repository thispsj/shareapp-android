/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.System
 *  java.lang.UnsupportedOperationException
 *  java.nio.channels.SelectionKey
 *  java.util.AbstractSet
 *  java.util.Arrays
 *  java.util.Iterator
 */
package io.netty.b.a;

import java.nio.channels.SelectionKey;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;

final class f
extends AbstractSet<SelectionKey> {
    SelectionKey[] a = new SelectionKey[1024];
    int b;

    f() {
    }

    final void a(int n2) {
        Arrays.fill((Object[])this.a, (int)n2, (int)this.b, null);
        this.b = 0;
    }

    public final /* synthetic */ boolean add(Object object) {
        SelectionKey selectionKey = (SelectionKey)object;
        if (selectionKey == null) {
            return false;
        }
        SelectionKey[] arrselectionKey = this.a;
        int n2 = this.b;
        this.b = n2 + 1;
        arrselectionKey[n2] = selectionKey;
        if (this.b == this.a.length) {
            SelectionKey[] arrselectionKey2 = new SelectionKey[this.a.length << 1];
            System.arraycopy((Object)this.a, (int)0, (Object)arrselectionKey2, (int)0, (int)this.b);
            this.a = arrselectionKey2;
        }
        return true;
    }

    public final boolean contains(Object object) {
        return false;
    }

    public final Iterator<SelectionKey> iterator() {
        throw new UnsupportedOperationException();
    }

    public final boolean remove(Object object) {
        return false;
    }

    public final int size() {
        return this.b;
    }
}

