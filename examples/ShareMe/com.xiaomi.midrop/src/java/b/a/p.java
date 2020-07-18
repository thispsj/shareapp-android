/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.security.InvalidParameterException
 */
package b.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidParameterException;

public final class p {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static int a(char c2) {
        int n2 = Character.digit((char)c2, (int)16);
        if (n2 == -1) {
            StringBuilder stringBuilder = new StringBuilder("Illegal hexadecimal character ");
            stringBuilder.append(c2);
            throw new InvalidParameterException(stringBuilder.toString());
        }
        return n2;
    }

    public static int a(byte[] arrby) {
        return p.a(arrby, 0);
    }

    public static int a(byte[] arrby, int n2) {
        if (arrby != null && arrby.length >= n2 + 4) {
            return ByteBuffer.wrap((byte[])arrby, (int)n2, (int)4).order(ByteOrder.LITTLE_ENDIAN).getInt();
        }
        return 0;
    }

    public static byte[] a(int n2) {
        return ByteBuffer.allocate((int)4).order(ByteOrder.LITTLE_ENDIAN).putInt(n2).array();
    }

    public static byte[] a(char[] arrc) {
        int n2 = arrc.length;
        if ((n2 & 1) != 0) {
            throw new InvalidParameterException("data len");
        }
        byte[] arrby = new byte[n2 >> 1];
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2) {
            int n5 = p.a(arrc[n3]) << 4;
            int n6 = n3 + 1;
            int n7 = n5 | p.a(arrc[n6]);
            n3 = n6 + 1;
            arrby[n4] = (byte)(n7 & 255);
            ++n4;
        }
        return arrby;
    }

    public static char[] b(byte[] arrby) {
        char[] arrc = new char[12];
        int n2 = 0;
        for (int i2 = 0; i2 < 6; ++i2) {
            int n3 = n2 + 1;
            arrc[n2] = a[(240 & arrby[i2]) >>> 4];
            n2 = n3 + 1;
            arrc[n3] = a[15 & arrby[i2]];
        }
        return arrc;
    }
}

