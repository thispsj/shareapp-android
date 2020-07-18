/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 */
package com.google.a.b;

public final class a {
    public static <T> T a(T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        return t2;
    }

    public static void a(boolean bl) {
        if (!bl) {
            throw new IllegalArgumentException();
        }
    }
}

