/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.lang.Void
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.ListIterator
 *  java.util.RandomAccess
 */
package a.a;

import a.a.q;
import a.e.b.a;
import a.e.b.d;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class r
implements Serializable,
List,
RandomAccess {
    public static final r a = new r();
    private static final long serialVersionUID = -7390468764508069838L;

    private r() {
    }

    private final Object readResolve() {
        return a;
    }

    public final /* synthetic */ void add(int n2, Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* synthetic */ boolean add(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(int n2, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean contains(Object object) {
        if (!(object instanceof Void)) {
            return false;
        }
        d.b((Object)((Void)object), "element");
        return false;
    }

    public final boolean containsAll(Collection collection) {
        d.b((Object)collection, "elements");
        return collection.isEmpty();
    }

    public final boolean equals(Object object) {
        return object instanceof List && ((List)object).isEmpty();
    }

    public final /* synthetic */ Object get(int n2) {
        StringBuilder stringBuilder = new StringBuilder("Empty list doesn't contain element at index ");
        stringBuilder.append(n2);
        stringBuilder.append('.');
        throw (Throwable)new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final int hashCode() {
        return 1;
    }

    public final int indexOf(Object object) {
        if (!(object instanceof Void)) {
            return -1;
        }
        d.b((Object)((Void)object), "element");
        return -1;
    }

    public final boolean isEmpty() {
        return true;
    }

    public final Iterator iterator() {
        return (Iterator)q.a;
    }

    public final int lastIndexOf(Object object) {
        if (!(object instanceof Void)) {
            return -1;
        }
        d.b((Object)((Void)object), "element");
        return -1;
    }

    public final ListIterator listIterator() {
        return q.a;
    }

    public final ListIterator listIterator(int n2) {
        if (n2 != 0) {
            StringBuilder stringBuilder = new StringBuilder("Index: ");
            stringBuilder.append(n2);
            throw (Throwable)new IndexOutOfBoundsException(stringBuilder.toString());
        }
        return q.a;
    }

    public final /* synthetic */ Object remove(int n2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean remove(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* synthetic */ Object set(int n2, Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final List subList(int n2, int n3) {
        if (n2 == 0 && n3 == 0) {
            return (List)this;
        }
        StringBuilder stringBuilder = new StringBuilder("fromIndex: ");
        stringBuilder.append(n2);
        stringBuilder.append(", toIndex: ");
        stringBuilder.append(n3);
        throw (Throwable)new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final Object[] toArray() {
        return a.a(this);
    }

    public final <T> T[] toArray(T[] arrT) {
        return a.a(this, arrT);
    }

    public final String toString() {
        return "[]";
    }
}

