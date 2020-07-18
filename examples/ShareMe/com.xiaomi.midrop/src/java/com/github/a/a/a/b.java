/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.UnsupportedEncodingException
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.BitSet
 */
package com.github.a.a.a;

import com.github.a.a.a.a;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;

public final class b {
    private static final BitSet a = new BitSet(256);
    private final String b;

    static {
        for (int i2 = 33; i2 <= 60; ++i2) {
            a.set(i2);
        }
        for (int i3 = 62; i3 <= 126; ++i3) {
            a.set(i3);
        }
        a.set(9);
        a.set(32);
    }

    public b(String string2) {
        this.b = string2;
    }

    private static int a(byte by) throws a {
        int n2 = Character.digit((char)((char)by), (int)16);
        if (n2 == -1) {
            StringBuilder stringBuilder = new StringBuilder("Invalid URL encoding: not a valid digit (radix 16): ");
            stringBuilder.append((int)by);
            throw new a(stringBuilder.toString());
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final String a(String string2) throws a {
        byte[] arrby;
        try {
            arrby = string2.getBytes("US-ASCII");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new a(unsupportedEncodingException);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            byte by = arrby[i2];
            if (by == 61) {
                int n3 = i2 + 1;
                try {
                    int n2 = b.a(arrby[n3]);
                    i2 = n3 + 1;
                    byteArrayOutputStream.write((int)((char)(b.a(arrby[i2]) + (n2 << 4))));
                    continue;
                }
                catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    throw new a("Invalid quoted-printable encoding", arrayIndexOutOfBoundsException);
                }
            }
            byteArrayOutputStream.write((int)by);
        }
        try {
            return new String(byteArrayOutputStream.toByteArray(), this.b);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new a(unsupportedEncodingException);
        }
    }
}

