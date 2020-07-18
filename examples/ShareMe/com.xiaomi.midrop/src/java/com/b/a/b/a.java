/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.security.MessageDigest
 *  java.util.Locale
 */
package com.b.a.b;

import java.security.MessageDigest;
import java.util.Locale;

public final class a {
    public static String a(String string2) {
        char[] arrc = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        MessageDigest messageDigest = MessageDigest.getInstance((String)"MD5");
        messageDigest.update(string2.getBytes());
        byte[] arrby = messageDigest.digest();
        char[] arrc2 = new char[32];
        int n2 = 0;
        for (int i2 = 0; i2 < 16; ++i2) {
            byte by = arrby[i2];
            int n3 = n2 + 1;
            arrc2[n2] = arrc[15 & by >>> 4];
            n2 = n3 + 1;
            arrc2[n3] = arrc[by & 15];
        }
        try {
            String string3 = new String(arrc2).toUpperCase(Locale.ENGLISH);
            return string3;
        }
        catch (Exception exception) {
            return null;
        }
    }
}

