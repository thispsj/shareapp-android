/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package com.google.a.b;

public final class e {
    private static final int a;

    static {
        String string2 = System.getProperty((String)"java.version");
        int n2 = e.a(string2);
        if (n2 == -1) {
            n2 = e.b(string2);
        }
        if (n2 == -1) {
            n2 = 6;
        }
        a = n2;
    }

    public static int a() {
        return a;
    }

    private static int a(String string2) {
        int n2;
        block3 : {
            String[] arrstring;
            try {
                arrstring = string2.split("[._]");
                n2 = Integer.parseInt((String)arrstring[0]);
                if (n2 != 1) break block3;
            }
            catch (NumberFormatException numberFormatException) {
                return -1;
            }
            if (arrstring.length <= 1) break block3;
            int n3 = Integer.parseInt((String)arrstring[1]);
            return n3;
        }
        return n2;
    }

    private static int b(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        do {
            char c2;
            if (n2 >= string2.length() || !Character.isDigit((char)(c2 = string2.charAt(n2)))) break;
            stringBuilder.append(c2);
            ++n2;
        } while (true);
        try {
            int n3 = Integer.parseInt((String)stringBuilder.toString());
            return n3;
        }
        catch (NumberFormatException numberFormatException) {
            return -1;
        }
    }

    public static boolean b() {
        return a >= 9;
    }
}

