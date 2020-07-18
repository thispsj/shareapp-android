/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.b.b.a
 *  com.google.a.b.b.c
 *  java.lang.Object
 *  java.lang.reflect.AccessibleObject
 */
package com.google.a.b.b;

import com.google.a.b.b.a;
import com.google.a.b.b.c;
import com.google.a.b.e;
import java.lang.reflect.AccessibleObject;

public abstract class b {
    private static final b a;

    static {
        Object object = e.a() < 9 ? new a() : new c();
        a = object;
    }

    public static b a() {
        return a;
    }

    public abstract void a(AccessibleObject var1);
}

