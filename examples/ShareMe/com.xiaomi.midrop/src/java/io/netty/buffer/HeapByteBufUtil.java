/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package io.netty.buffer;

final class HeapByteBufUtil {
    private HeapByteBufUtil() {
    }

    static byte getByte(byte[] arrby, int n2) {
        return arrby[n2];
    }

    static int getInt(byte[] arrby, int n2) {
        return (255 & arrby[n2]) << 24 | (255 & arrby[n2 + 1]) << 16 | (255 & arrby[n2 + 2]) << 8 | 255 & arrby[n2 + 3];
    }

    static long getLong(byte[] arrby, int n2) {
        return (255L & (long)arrby[n2]) << 56 | (255L & (long)arrby[n2 + 1]) << 48 | (255L & (long)arrby[n2 + 2]) << 40 | (255L & (long)arrby[n2 + 3]) << 32 | (255L & (long)arrby[n2 + 4]) << 24 | (255L & (long)arrby[n2 + 5]) << 16 | (255L & (long)arrby[n2 + 6]) << 8 | 255L & (long)arrby[n2 + 7];
    }

    static short getShort(byte[] arrby, int n2) {
        return (short)(arrby[n2] << 8 | 255 & arrby[n2 + 1]);
    }

    static int getUnsignedMedium(byte[] arrby, int n2) {
        return (255 & arrby[n2]) << 16 | (255 & arrby[n2 + 1]) << 8 | 255 & arrby[n2 + 2];
    }

    static void setByte(byte[] arrby, int n2, int n3) {
        arrby[n2] = (byte)n3;
    }

    static void setInt(byte[] arrby, int n2, int n3) {
        arrby[n2] = (byte)(n3 >>> 24);
        arrby[n2 + 1] = (byte)(n3 >>> 16);
        arrby[n2 + 2] = (byte)(n3 >>> 8);
        arrby[n2 + 3] = (byte)n3;
    }

    static void setLong(byte[] arrby, int n2, long l2) {
        arrby[n2] = (byte)(l2 >>> 56);
        arrby[n2 + 1] = (byte)(l2 >>> 48);
        arrby[n2 + 2] = (byte)(l2 >>> 40);
        arrby[n2 + 3] = (byte)(l2 >>> 32);
        arrby[n2 + 4] = (byte)(l2 >>> 24);
        arrby[n2 + 5] = (byte)(l2 >>> 16);
        arrby[n2 + 6] = (byte)(l2 >>> 8);
        arrby[n2 + 7] = (byte)l2;
    }

    static void setMedium(byte[] arrby, int n2, int n3) {
        arrby[n2] = (byte)(n3 >>> 16);
        arrby[n2 + 1] = (byte)(n3 >>> 8);
        arrby[n2 + 2] = (byte)n3;
    }

    static void setShort(byte[] arrby, int n2, int n3) {
        arrby[n2] = (byte)(n3 >>> 8);
        arrby[n2 + 1] = (byte)n3;
    }
}

