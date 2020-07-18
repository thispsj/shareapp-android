/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.charset.Charset
 */
package c;

import java.nio.charset.Charset;

public final class v {
    public static final Charset a = Charset.forName((String)"UTF-8");

    public static int a(int n2) {
        return (-16777216 & n2) >>> 24 | (16711680 & n2) >>> 8 | (65280 & n2) << 8 | (n2 & 255) << 24;
    }

    public static short a(short s2) {
        int n2 = s2 & 65535;
        return (short)((65280 & n2) >>> 8 | (n2 & 255) << 8);
    }

    public static void a(long l2, long l3, long l4) {
        if ((l3 | l4) >= 0L && l3 <= l2 && l2 - l3 >= l4) {
            return;
        }
        Object[] arrobject = new Object[]{l2, l3, l4};
        throw new ArrayIndexOutOfBoundsException(String.format((String)"size=%s offset=%s byteCount=%s", (Object[])arrobject));
    }

    public static void a(Throwable throwable) {
        throw throwable;
    }

    public static boolean a(byte[] arrby, int n2, byte[] arrby2, int n3, int n4) {
        for (int i2 = 0; i2 < n4; ++i2) {
            if (arrby[i2 + n2] == arrby2[i2 + n3]) continue;
            return false;
        }
        return true;
    }
}

