/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 */
package com.xiaomi.globalmiuiapp.common.f;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class e {
    private static final char[] a = "0123456789abcdef".toCharArray();

    public static String a(String string2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance((String)"MD5");
        messageDigest.reset();
        messageDigest.update(string2.getBytes("utf-8"));
        byte[] arrby = messageDigest.digest();
        char[] arrc = new char[2 * arrby.length];
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            int n2 = 255 & arrby[i2];
            int n3 = i2 * 2;
            arrc[n3] = a[n2 >>> 4];
            arrc[n3 + 1] = a[n2 & 15];
        }
        return new String(arrc);
    }
}

