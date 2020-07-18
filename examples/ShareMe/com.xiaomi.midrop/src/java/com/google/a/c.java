/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.c$1
 *  com.google.a.c$2
 *  com.google.a.c$3
 *  com.google.a.c$4
 *  com.google.a.c$5
 *  com.google.a.c$6
 *  java.lang.Character
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.google.a;

import com.google.a.c;
import com.google.a.d;

public abstract class c
extends Enum<c>
implements d {
    public static final /* enum */ c a = new 1("IDENTITY");
    public static final /* enum */ c b = new 2("UPPER_CAMEL_CASE");
    public static final /* enum */ c c = new 3("UPPER_CAMEL_CASE_WITH_SPACES");
    public static final /* enum */ c d = new 4("LOWER_CASE_WITH_UNDERSCORES");
    public static final /* enum */ c e = new 5("LOWER_CASE_WITH_DASHES");
    public static final /* enum */ c f = new 6("LOWER_CASE_WITH_DOTS");
    private static final /* synthetic */ c[] g;

    static {
        c[] arrc = new c[]{a, b, c, d, e, f};
        g = arrc;
    }

    private c() {
    }

    /* synthetic */ c(String string2, int n2, byte by) {
    }

    static String a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        char c2 = string2.charAt(0);
        int n3 = string2.length();
        while (n2 < n3 - 1 && !Character.isLetter((char)c2)) {
            stringBuilder.append(c2);
            c2 = string2.charAt(++n2);
        }
        if (!Character.isUpperCase((char)c2)) {
            String string3;
            char c3 = Character.toUpperCase((char)c2);
            int n4 = n2 + 1;
            if (n4 < string2.length()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(c3);
                stringBuilder2.append(string2.substring(n4));
                string3 = stringBuilder2.toString();
            } else {
                string3 = String.valueOf((char)c3);
            }
            stringBuilder.append(string3);
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    static String a(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = string2.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string2.charAt(i2);
            if (Character.isUpperCase((char)c2) && stringBuilder.length() != 0) {
                stringBuilder.append(string3);
            }
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    public static c valueOf(String string2) {
        return (c)Enum.valueOf(c.class, (String)string2);
    }

    public static c[] values() {
        return (c[])g.clone();
    }
}

