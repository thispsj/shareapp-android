/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package c;

import java.io.UnsupportedEncodingException;

final class b {
    private static final byte[] a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] b = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    public static String a(byte[] arrby) {
        return b.a(arrby, a);
    }

    private static String a(byte[] arrby, byte[] arrby2) {
        byte[] arrby3 = new byte[4 * ((2 + arrby.length) / 3)];
        int n2 = arrby.length - arrby.length % 3;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; i2 += 3) {
            int n4 = n3 + 1;
            arrby3[n3] = arrby2[(255 & arrby[i2]) >> 2];
            int n5 = n4 + 1;
            int n6 = (3 & arrby[i2]) << 4;
            int n7 = i2 + 1;
            arrby3[n4] = arrby2[n6 | (255 & arrby[n7]) >> 4];
            int n8 = n5 + 1;
            int n9 = (15 & arrby[n7]) << 2;
            int n10 = i2 + 2;
            arrby3[n5] = arrby2[n9 | (255 & arrby[n10]) >> 6];
            n3 = n8 + 1;
            arrby3[n8] = arrby2[63 & arrby[n10]];
        }
        switch (arrby.length % 3) {
            default: {
                break;
            }
            case 2: {
                int n11 = n3 + 1;
                arrby3[n3] = arrby2[(255 & arrby[n2]) >> 2];
                int n12 = n11 + 1;
                int n13 = (3 & arrby[n2]) << 4;
                int n14 = n2 + 1;
                arrby3[n11] = arrby2[n13 | (255 & arrby[n14]) >> 4];
                int n15 = n12 + 1;
                arrby3[n12] = arrby2[(15 & arrby[n14]) << 2];
                arrby3[n15] = 61;
                break;
            }
            case 1: {
                int n16 = n3 + 1;
                arrby3[n3] = arrby2[(255 & arrby[n2]) >> 2];
                int n17 = n16 + 1;
                arrby3[n16] = arrby2[(3 & arrby[n2]) << 4];
                int n18 = n17 + 1;
                arrby3[n17] = 61;
                arrby3[n18] = 61;
            }
        }
        try {
            String string2 = new String(arrby3, "US-ASCII");
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new AssertionError((Object)unsupportedEncodingException);
        }
    }

    public static byte[] a(String string2) {
        char c2;
        int n2;
        for (n2 = string2.length(); n2 > 0 && ((c2 = string2.charAt(n2 - 1)) == '=' || c2 == '\n' || c2 == '\r' || c2 == ' ' || c2 == '\t'); --n2) {
        }
        byte[] arrby = new byte[(int)(6L * (long)n2 / 8L)];
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n6;
            char c3 = string2.charAt(i2);
            if (c3 >= 'A' && c3 <= 'Z') {
                n6 = c3 - 65;
            } else if (c3 >= 'a' && c3 <= 'z') {
                n6 = c3 - 71;
            } else if (c3 >= '0' && c3 <= '9') {
                n6 = c3 + 4;
            } else if (c3 != '+' && c3 != '-') {
                if (c3 != '/' && c3 != '_') {
                    if (c3 == '\n' || c3 == '\r' || c3 == ' ' || c3 == '\t') continue;
                    return null;
                }
                n6 = 63;
            } else {
                n6 = 62;
            }
            n4 = n4 << 6 | (byte)n6;
            if (++n3 % 4 != 0) continue;
            int n7 = n5 + 1;
            arrby[n5] = (byte)(n4 >> 16);
            int n8 = n7 + 1;
            arrby[n7] = (byte)(n4 >> 8);
            int n9 = n8 + 1;
            arrby[n8] = (byte)n4;
            n5 = n9;
        }
        int n10 = n3 % 4;
        if (n10 == 1) {
            return null;
        }
        if (n10 == 2) {
            int n11 = n4 << 12;
            int n12 = n5 + 1;
            arrby[n5] = (byte)(n11 >> 16);
            n5 = n12;
        } else if (n10 == 3) {
            int n13 = n4 << 6;
            int n14 = n5 + 1;
            arrby[n5] = (byte)(n13 >> 16);
            n5 = n14 + 1;
            arrby[n14] = (byte)(n13 >> 8);
        }
        if (n5 == arrby.length) {
            return arrby;
        }
        byte[] arrby2 = new byte[n5];
        System.arraycopy((Object)arrby, (int)0, (Object)arrby2, (int)0, (int)n5);
        return arrby2;
    }
}

