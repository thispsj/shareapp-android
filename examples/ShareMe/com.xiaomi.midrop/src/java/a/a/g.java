/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.List
 */
package a.a;

import a.e.b.d;
import java.util.Collections;
import java.util.List;

public class g {
    public static final <T> List<T> a(T t2) {
        List list = Collections.singletonList(t2);
        d.a((Object)list, "java.util.Collections.singletonList(element)");
        return list;
    }
}

