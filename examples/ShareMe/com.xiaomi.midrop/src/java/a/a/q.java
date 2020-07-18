/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.util.ListIterator
 *  java.util.NoSuchElementException
 */
package a.a;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class q
implements ListIterator {
    public static final q a = new q();

    private q() {
    }

    public final /* synthetic */ void add(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean hasNext() {
        return false;
    }

    public final boolean hasPrevious() {
        return false;
    }

    public final /* synthetic */ Object next() {
        throw (Throwable)new NoSuchElementException();
    }

    public final int nextIndex() {
        return 0;
    }

    public final /* synthetic */ Object previous() {
        throw (Throwable)new NoSuchElementException();
    }

    public final int previousIndex() {
        return -1;
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* synthetic */ void set(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

