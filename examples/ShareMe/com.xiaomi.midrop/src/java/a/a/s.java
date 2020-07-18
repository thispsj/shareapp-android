/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 */
package a.a;

import java.util.Iterator;

public abstract class s
implements Iterator<Integer> {
    public abstract int a();

    public /* synthetic */ Object next() {
        return this.a();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

