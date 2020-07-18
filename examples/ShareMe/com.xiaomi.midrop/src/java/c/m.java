/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.AbstractList
 *  java.util.RandomAccess
 */
package c;

import c.f;
import java.util.AbstractList;
import java.util.RandomAccess;

public final class m
extends AbstractList<f>
implements RandomAccess {
    final f[] a;

    private m(f[] arrf) {
        this.a = arrf;
    }

    public static /* varargs */ m a(f ... arrf) {
        return new m((f[])arrf.clone());
    }

    public final int size() {
        return this.a.length;
    }
}

