/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.e.a.a
 *  a.e.a.b
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.util.concurrent.Future
 *  org.jetbrains.anko.b$a
 *  org.jetbrains.anko.b$b
 */
package org.jetbrains.anko;

import a.l;
import java.lang.ref.WeakReference;
import java.util.concurrent.Future;
import org.jetbrains.anko.b;
import org.jetbrains.anko.d;

public final class b {
    private static final a.e.a.b<Throwable, l> a = (a.e.a.b)a.a;

    public static /* synthetic */ Future a(Object object, a.e.a.b b2) {
        a.e.a.b<Throwable, l> b3 = a;
        a.e.b.d.b((Object)b2, "task");
        org.jetbrains.anko.a a2 = new org.jetbrains.anko.a(new WeakReference(object));
        return d.a((a.e.a.a)new b(b2, a2, b3));
    }
}

