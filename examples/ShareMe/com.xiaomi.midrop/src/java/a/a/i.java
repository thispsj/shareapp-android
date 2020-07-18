/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.util.Collection
 */
package a.a;

import a.a.h;
import a.e.b.d;
import java.util.Collection;

public class i
extends h {
    public static final <T> int a(Iterable<? extends T> iterable) {
        d.b(iterable, "receiver$0");
        if (iterable instanceof Collection) {
            return ((Collection)iterable).size();
        }
        return 10;
    }
}

