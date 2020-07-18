/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Arrays
 *  java.util.List
 */
package a.a;

import a.a.c;
import java.util.Arrays;
import java.util.List;

public class d
extends c {
    public static final <T> List<T> a(T[] arrT) {
        a.e.b.d.b(arrT, "receiver$0");
        List list = Arrays.asList((Object[])arrT);
        a.e.b.d.a((Object)list, "ArraysUtilJVM.asList(this)");
        return list;
    }
}

