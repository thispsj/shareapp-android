/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.netty.d.b;

import io.netty.d.b.e;
import io.netty.d.b.l;
import io.netty.d.b.u;

public final class t {
    public static final String a;
    static final /* synthetic */ boolean b = true;
    private static final String[] c;
    private static final String[] d;

    static {
        int n2;
        a = u.a("line.separator", "\n");
        c = new String[256];
        d = new String[256];
        for (n2 = 0; n2 < 10; ++n2) {
            String[] arrstring = c;
            StringBuilder stringBuilder = new StringBuilder("0");
            stringBuilder.append(n2);
            arrstring[n2] = stringBuilder.toString();
            t.d[n2] = String.valueOf((int)n2);
        }
        while (n2 < 16) {
            char c2 = (char)(n2 + 97 - 10);
            String[] arrstring = c;
            StringBuilder stringBuilder = new StringBuilder("0");
            stringBuilder.append(c2);
            arrstring[n2] = stringBuilder.toString();
            t.d[n2] = String.valueOf((char)c2);
            ++n2;
        }
        while (n2 < c.length) {
            String string2;
            t.c[n2] = string2 = Integer.toHexString((int)n2);
            t.d[n2] = string2;
            ++n2;
        }
    }

    private t() {
    }

    public static byte a(CharSequence charSequence, int n2) {
        int n3 = t.b(charSequence.charAt(n2));
        int n4 = t.b(charSequence.charAt(n2 + 1));
        if (n3 != -1 && n4 != -1) {
            return (byte)(n4 + (n3 << 4));
        }
        Object[] arrobject = new Object[]{charSequence.subSequence(n2, n2 + 2), n2, charSequence};
        throw new IllegalArgumentException(String.format((String)"invalid hex byte '%s' at index %d of '%s'", (Object[])arrobject));
    }

    public static String a(int n2) {
        return c[n2 & 255];
    }

    public static String a(Class<?> class_) {
        String string2 = l.a(class_, "clazz").getName();
        int n2 = string2.lastIndexOf(46);
        if (n2 >= 0) {
            string2 = string2.substring(n2 + 1);
        }
        return string2;
    }

    public static String a(Object object) {
        if (object == null) {
            return "null_object";
        }
        return t.a(object.getClass());
    }

    public static boolean a(char c2) {
        return c2 >= '\ud800' && c2 <= '\udfff';
    }

    public static byte[] a(CharSequence charSequence, int n2, int n3) {
        if (n3 >= 0 && (n3 & 1) == 0) {
            if (n3 == 0) {
                return e.a;
            }
            byte[] arrby = new byte[n3 >>> 1];
            for (int i2 = 0; i2 < n3; i2 += 2) {
                arrby[i2 >>> 1] = t.a(charSequence, n2 + i2);
            }
            return arrby;
        }
        StringBuilder stringBuilder = new StringBuilder("length: ");
        stringBuilder.append(n3);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int b(char n2) {
        if (n2 >= 48 && n2 <= 57) {
            return n2 - 48;
        }
        int n3 = 65;
        if (n2 >= n3 && n2 <= 70) {
            return 10 + (n2 - n3);
        }
        n3 = 97;
        if (n2 < n3) return -1;
        if (n2 > 102) return -1;
        return 10 + (n2 - n3);
    }
}

