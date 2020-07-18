/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 */
package org.jetbrains.anko;

import a.e.b.d;
import java.lang.ref.WeakReference;

public final class a<T> {
    private final WeakReference<T> a;

    public a(WeakReference<T> weakReference) {
        d.b(weakReference, "weakRef");
        this.a = weakReference;
    }
}

