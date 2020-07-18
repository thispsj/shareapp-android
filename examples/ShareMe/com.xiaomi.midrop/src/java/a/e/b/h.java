/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.e.b.c
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 */
package a.e.b;

import a.e.b.c;
import java.lang.reflect.Type;

public final class h {
    public static String a(c c2) {
        String string2 = c2.getClass().getGenericInterfaces()[0].toString();
        if (string2.startsWith("kotlin.jvm.functions.")) {
            string2 = string2.substring(21);
        }
        return string2;
    }
}

