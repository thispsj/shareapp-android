/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.AbstractByteBuf
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.UnpooledUnsafeDirectByteBuf
 *  io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.ReadOnlyBufferException
 */
package io.netty.buffer;

import io.netty.buffer.AbstractByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledUnsafeDirectByteBuf;
import io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf;
import io.netty.d.b.j;
import io.netty.d.b.l;
import io.netty.d.b.n;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

final class UnsafeByteBufUtil {
    static final boolean BIG_ENDIAN_NATIVE_ORDER;
    private static final boolean UNALIGNED;
    private static final byte ZERO;

    static {
        boolean bl = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
        BIG_ENDIAN_NATIVE_ORDER = bl;
        UNALIGNED = n.g();
    }

    private UnsafeByteBufUtil() {
    }

    static ByteBuf copy(AbstractByteBuf abstractByteBuf, long l2, int n2, int n3) {
        abstractByteBuf.checkIndex(n2, n3);
        ByteBuf byteBuf = abstractByteBuf.alloc().directBuffer(n3, abstractByteBuf.maxCapacity());
        if (n3 != 0) {
            if (byteBuf.hasMemoryAddress()) {
                n.a(l2, byteBuf.memoryAddress(), (long)n3);
                byteBuf.setIndex(0, n3);
                return byteBuf;
            }
            byteBuf.writeBytes((ByteBuf)abstractByteBuf, n2, n3);
        }
        return byteBuf;
    }

    static byte getByte(long l2) {
        return n.b(l2);
    }

    static byte getByte(byte[] arrby, int n2) {
        return n.a(arrby, n2);
    }

    static void getBytes(AbstractByteBuf abstractByteBuf, long l2, int n2, ByteBuf byteBuf, int n3, int n4) {
        abstractByteBuf.checkIndex(n2, n4);
        l.a(byteBuf, "dst");
        if (j.a(n3, n4, byteBuf.capacity())) {
            StringBuilder stringBuilder = new StringBuilder("dstIndex: ");
            stringBuilder.append(n3);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        if (byteBuf.hasMemoryAddress()) {
            n.a(l2, byteBuf.memoryAddress() + (long)n3, (long)n4);
            return;
        }
        if (byteBuf.hasArray()) {
            n.a(l2, byteBuf.array(), n3 + byteBuf.arrayOffset(), (long)n4);
            return;
        }
        byteBuf.setBytes(n3, (ByteBuf)abstractByteBuf, n2, n4);
    }

    static void getBytes(AbstractByteBuf abstractByteBuf, long l2, int n2, OutputStream outputStream, int n3) throws IOException {
        abstractByteBuf.checkIndex(n2, n3);
        if (n3 != 0) {
            ByteBuf byteBuf = abstractByteBuf.alloc().heapBuffer(n3);
            try {
                byte[] arrby = byteBuf.array();
                int n4 = byteBuf.arrayOffset();
                n.a(l2, arrby, n4, (long)n3);
                outputStream.write(arrby, n4, n3);
                return;
            }
            finally {
                byteBuf.release();
            }
        }
    }

    static void getBytes(AbstractByteBuf abstractByteBuf, long l2, int n2, ByteBuffer byteBuffer) {
        abstractByteBuf.checkIndex(n2, byteBuffer.remaining());
        if (byteBuffer.remaining() == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            if (byteBuffer.isReadOnly()) {
                throw new ReadOnlyBufferException();
            }
            n.a(l2, n.b(byteBuffer) + (long)byteBuffer.position(), (long)byteBuffer.remaining());
            byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
            return;
        }
        if (byteBuffer.hasArray()) {
            n.a(l2, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), (long)byteBuffer.remaining());
            byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
            return;
        }
        byteBuffer.put(abstractByteBuf.nioBuffer());
    }

    static void getBytes(AbstractByteBuf abstractByteBuf, long l2, int n2, byte[] arrby, int n3, int n4) {
        abstractByteBuf.checkIndex(n2, n4);
        l.a(arrby, "dst");
        if (j.a(n3, n4, arrby.length)) {
            StringBuilder stringBuilder = new StringBuilder("dstIndex: ");
            stringBuilder.append(n3);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        if (n4 != 0) {
            n.a(l2, arrby, n3, (long)n4);
        }
    }

    static int getInt(long l2) {
        if (UNALIGNED) {
            int n2 = n.d(l2);
            if (BIG_ENDIAN_NATIVE_ORDER) {
                return n2;
            }
            return Integer.reverseBytes((int)n2);
        }
        return n.b(l2) << 24 | (255 & n.b(l2 + 1L)) << 16 | (255 & n.b(l2 + 2L)) << 8 | 255 & n.b(l2 + 3L);
    }

    static int getInt(byte[] arrby, int n2) {
        if (UNALIGNED) {
            int n3 = n.c(arrby, n2);
            if (BIG_ENDIAN_NATIVE_ORDER) {
                return n3;
            }
            return Integer.reverseBytes((int)n3);
        }
        return n.a(arrby, n2) << 24 | (255 & n.a(arrby, n2 + 1)) << 16 | (255 & n.a(arrby, n2 + 2)) << 8 | 255 & n.a(arrby, n2 + 3);
    }

    static long getLong(long l2) {
        if (UNALIGNED) {
            long l3 = n.e(l2);
            if (BIG_ENDIAN_NATIVE_ORDER) {
                return l3;
            }
            return Long.reverseBytes((long)l3);
        }
        return (long)n.b(l2) << 56 | (255L & (long)n.b(l2 + 1L)) << 48 | (255L & (long)n.b(l2 + 2L)) << 40 | (255L & (long)n.b(l2 + 3L)) << 32 | (255L & (long)n.b(l2 + 4L)) << 24 | (255L & (long)n.b(l2 + 5L)) << 16 | (255L & (long)n.b(l2 + 6L)) << 8 | 255L & (long)n.b(l2 + 7L);
    }

    static long getLong(byte[] arrby, int n2) {
        if (UNALIGNED) {
            long l2 = n.d(arrby, n2);
            if (BIG_ENDIAN_NATIVE_ORDER) {
                return l2;
            }
            return Long.reverseBytes((long)l2);
        }
        return (long)n.a(arrby, n2) << 56 | (255L & (long)n.a(arrby, n2 + 1)) << 48 | (255L & (long)n.a(arrby, n2 + 2)) << 40 | (255L & (long)n.a(arrby, n2 + 3)) << 32 | (255L & (long)n.a(arrby, n2 + 4)) << 24 | (255L & (long)n.a(arrby, n2 + 5)) << 16 | (255L & (long)n.a(arrby, n2 + 6)) << 8 | 255L & (long)n.a(arrby, n2 + 7);
    }

    static short getShort(long l2) {
        if (UNALIGNED) {
            short s2 = n.c(l2);
            if (BIG_ENDIAN_NATIVE_ORDER) {
                return s2;
            }
            return Short.reverseBytes((short)s2);
        }
        return (short)(n.b(l2) << 8 | 255 & n.b(l2 + 1L));
    }

    static short getShort(byte[] arrby, int n2) {
        if (UNALIGNED) {
            short s2 = n.b(arrby, n2);
            if (BIG_ENDIAN_NATIVE_ORDER) {
                return s2;
            }
            return Short.reverseBytes((short)s2);
        }
        return (short)(n.a(arrby, n2) << 8 | 255 & n.a(arrby, n2 + 1));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static int getUnsignedMedium(long l2) {
        int n2;
        int n3;
        if (UNALIGNED) {
            n2 = (255 & n.b(l2)) << 16;
            short s2 = BIG_ENDIAN_NATIVE_ORDER ? n.c(l2 + 1L) : Short.reverseBytes((short)n.c(l2 + 1L));
            n3 = s2 & 65535;
            do {
                return n3 | n2;
                break;
            } while (true);
        }
        n2 = (255 & n.b(l2)) << 16 | (255 & n.b(l2 + 1L)) << 8;
        n3 = 255 & n.b(l2 + 2L);
        return n3 | n2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static int getUnsignedMedium(byte[] arrby, int n2) {
        int n3;
        int n4;
        if (UNALIGNED) {
            n3 = (255 & n.a(arrby, n2)) << 16;
            short s2 = BIG_ENDIAN_NATIVE_ORDER ? n.b(arrby, n2 + 1) : Short.reverseBytes((short)n.b(arrby, n2 + 1));
            n4 = s2 & 65535;
            do {
                return n4 | n3;
                break;
            } while (true);
        }
        n3 = (255 & n.a(arrby, n2)) << 16 | (255 & n.a(arrby, n2 + 1)) << 8;
        n4 = 255 & n.a(arrby, n2 + 2);
        return n4 | n3;
    }

    static UnpooledUnsafeDirectByteBuf newUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, int n2, int n3) {
        if (n.l()) {
            return new UnpooledUnsafeNoCleanerDirectByteBuf(byteBufAllocator, n2, n3);
        }
        return new UnpooledUnsafeDirectByteBuf(byteBufAllocator, n2, n3);
    }

    static void setByte(long l2, int n2) {
        n.a(l2, (byte)n2);
    }

    static void setByte(byte[] arrby, int n2, int n3) {
        n.a(arrby, n2, (byte)n3);
    }

    static int setBytes(AbstractByteBuf abstractByteBuf, long l2, int n2, InputStream inputStream, int n3) throws IOException {
        ByteBuf byteBuf;
        int n4;
        block4 : {
            abstractByteBuf.checkIndex(n2, n3);
            byteBuf = abstractByteBuf.alloc().heapBuffer(n3);
            byte[] arrby = byteBuf.array();
            int n5 = byteBuf.arrayOffset();
            n4 = inputStream.read(arrby, n5, n3);
            if (n4 <= 0) break block4;
            n.a(arrby, n5, l2, (long)n4);
        }
        return n4;
        finally {
            byteBuf.release();
        }
    }

    static void setBytes(AbstractByteBuf abstractByteBuf, long l2, int n2, ByteBuf byteBuf, int n3, int n4) {
        abstractByteBuf.checkIndex(n2, n4);
        l.a(byteBuf, "src");
        if (j.a(n3, n4, byteBuf.capacity())) {
            StringBuilder stringBuilder = new StringBuilder("srcIndex: ");
            stringBuilder.append(n3);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        if (n4 != 0) {
            if (byteBuf.hasMemoryAddress()) {
                n.a(byteBuf.memoryAddress() + (long)n3, l2, (long)n4);
                return;
            }
            if (byteBuf.hasArray()) {
                n.a(byteBuf.array(), n3 + byteBuf.arrayOffset(), l2, (long)n4);
                return;
            }
            byteBuf.getBytes(n3, (ByteBuf)abstractByteBuf, n2, n4);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void setBytes(AbstractByteBuf abstractByteBuf, long l2, int n2, ByteBuffer byteBuffer) {
        int n3;
        block9 : {
            block8 : {
                block7 : {
                    abstractByteBuf.checkIndex(n2, byteBuffer.remaining());
                    n3 = byteBuffer.remaining();
                    if (n3 == 0) {
                        return;
                    }
                    if (!byteBuffer.isDirect()) break block7;
                    n.a(n.b(byteBuffer) + (long)byteBuffer.position(), l2, (long)byteBuffer.remaining());
                    break block8;
                }
                if (!byteBuffer.hasArray()) break block9;
                n.a(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), l2, (long)n3);
            }
            byteBuffer.position(n3 + byteBuffer.position());
            return;
        }
        ByteBuf byteBuf = abstractByteBuf.alloc().heapBuffer(n3);
        try {
            byte[] arrby = byteBuf.array();
            byteBuffer.get(arrby, byteBuf.arrayOffset(), n3);
            n.a(arrby, byteBuf.arrayOffset(), l2, (long)n3);
            return;
        }
        finally {
            byteBuf.release();
        }
    }

    static void setBytes(AbstractByteBuf abstractByteBuf, long l2, int n2, byte[] arrby, int n3, int n4) {
        abstractByteBuf.checkIndex(n2, n4);
        if (n4 != 0) {
            n.a(arrby, n3, l2, (long)n4);
        }
    }

    static void setInt(long l2, int n2) {
        if (UNALIGNED) {
            if (!BIG_ENDIAN_NATIVE_ORDER) {
                n2 = Integer.reverseBytes((int)n2);
            }
            n.b(l2, n2);
            return;
        }
        n.a(l2, (byte)(n2 >>> 24));
        n.a(l2 + 1L, (byte)(n2 >>> 16));
        n.a(l2 + 2L, (byte)(n2 >>> 8));
        n.a(l2 + 3L, (byte)n2);
    }

    static void setInt(byte[] arrby, int n2, int n3) {
        if (UNALIGNED) {
            if (!BIG_ENDIAN_NATIVE_ORDER) {
                n3 = Integer.reverseBytes((int)n3);
            }
            n.a(arrby, n2, n3);
            return;
        }
        n.a(arrby, n2, (byte)(n3 >>> 24));
        n.a(arrby, n2 + 1, (byte)(n3 >>> 16));
        n.a(arrby, n2 + 2, (byte)(n3 >>> 8));
        n.a(arrby, n2 + 3, (byte)n3);
    }

    static void setLong(long l2, long l3) {
        if (UNALIGNED) {
            if (!BIG_ENDIAN_NATIVE_ORDER) {
                l3 = Long.reverseBytes((long)l3);
            }
            n.a(l2, l3);
            return;
        }
        n.a(l2, (byte)(l3 >>> 56));
        n.a(l2 + 1L, (byte)(l3 >>> 48));
        n.a(l2 + 2L, (byte)(l3 >>> 40));
        n.a(l2 + 3L, (byte)(l3 >>> 32));
        n.a(l2 + 4L, (byte)(l3 >>> 24));
        n.a(l2 + 5L, (byte)(l3 >>> 16));
        n.a(l2 + 6L, (byte)(l3 >>> 8));
        n.a(l2 + 7L, (byte)l3);
    }

    static void setLong(byte[] arrby, int n2, long l2) {
        if (UNALIGNED) {
            if (!BIG_ENDIAN_NATIVE_ORDER) {
                l2 = Long.reverseBytes((long)l2);
            }
            n.a(arrby, n2, l2);
            return;
        }
        n.a(arrby, n2, (byte)(l2 >>> 56));
        n.a(arrby, n2 + 1, (byte)(l2 >>> 48));
        n.a(arrby, n2 + 2, (byte)(l2 >>> 40));
        n.a(arrby, n2 + 3, (byte)(l2 >>> 32));
        n.a(arrby, n2 + 4, (byte)(l2 >>> 24));
        n.a(arrby, n2 + 5, (byte)(l2 >>> 16));
        n.a(arrby, n2 + 6, (byte)(l2 >>> 8));
        n.a(arrby, n2 + 7, (byte)l2);
    }

    static void setMedium(long l2, int n2) {
        n.a(l2, (byte)(n2 >>> 16));
        if (UNALIGNED) {
            long l3 = l2 + 1L;
            short s2 = BIG_ENDIAN_NATIVE_ORDER ? (short)n2 : Short.reverseBytes((short)((short)n2));
            n.a(l3, s2);
            return;
        }
        n.a(l2 + 1L, (byte)(n2 >>> 8));
        n.a(l2 + 2L, (byte)n2);
    }

    static void setMedium(byte[] arrby, int n2, int n3) {
        n.a(arrby, n2, (byte)(n3 >>> 16));
        if (UNALIGNED) {
            int n4 = n2 + 1;
            short s2 = BIG_ENDIAN_NATIVE_ORDER ? (short)n3 : Short.reverseBytes((short)((short)n3));
            n.a(arrby, n4, s2);
            return;
        }
        n.a(arrby, n2 + 1, (byte)(n3 >>> 8));
        n.a(arrby, n2 + 2, (byte)n3);
    }

    static void setShort(long l2, int n2) {
        if (UNALIGNED) {
            short s2 = BIG_ENDIAN_NATIVE_ORDER ? (short)n2 : Short.reverseBytes((short)((short)n2));
            n.a(l2, s2);
            return;
        }
        n.a(l2, (byte)(n2 >>> 8));
        n.a(l2 + 1L, (byte)n2);
    }

    static void setShort(byte[] arrby, int n2, int n3) {
        if (UNALIGNED) {
            short s2 = BIG_ENDIAN_NATIVE_ORDER ? (short)n3 : Short.reverseBytes((short)((short)n3));
            n.a(arrby, n2, s2);
            return;
        }
        n.a(arrby, n2, (byte)(n3 >>> 8));
        n.a(arrby, n2 + 1, (byte)n3);
    }

    static void setZero(long l2, int n2) {
        if (n2 == 0) {
            return;
        }
        n.b(l2, (long)n2);
    }

    static void setZero(byte[] arrby, int n2, int n3) {
        if (n3 == 0) {
            return;
        }
        n.b(arrby, n2, n3);
    }
}

