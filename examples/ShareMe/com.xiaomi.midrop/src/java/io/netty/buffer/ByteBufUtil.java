/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.AbstractByteBuf
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.ByteBufUtil$1
 *  io.netty.buffer.ByteBufUtil$2
 *  io.netty.buffer.ByteBufUtil$IndexOfProcessor
 *  io.netty.buffer.ByteBufUtil$ThreadLocalDirectByteBuf
 *  io.netty.buffer.ByteBufUtil$ThreadLocalUnsafeDirectByteBuf
 *  io.netty.buffer.PooledByteBufAllocator
 *  io.netty.buffer.UnpooledByteBufAllocator
 *  io.netty.buffer.WrappedByteBuf
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.CharBuffer
 *  java.nio.charset.CharacterCodingException
 *  java.nio.charset.Charset
 *  java.nio.charset.CharsetDecoder
 *  java.nio.charset.CharsetEncoder
 *  java.nio.charset.CoderResult
 *  java.nio.charset.CodingErrorAction
 *  java.util.Locale
 */
package io.netty.buffer;

import io.netty.buffer.AbstractByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufProcessor;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.buffer.WrappedByteBuf;
import io.netty.d.a.m;
import io.netty.d.b.a.e;
import io.netty.d.b.j;
import io.netty.d.b.l;
import io.netty.d.b.n;
import io.netty.d.b.t;
import io.netty.d.b.u;
import io.netty.d.d;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Locale;

/*
 * Exception performing whole class analysis.
 * Exception performing whole class analysis ignored.
 */
public final class ByteBufUtil {
    private static final m<CharBuffer> CHAR_BUFFERS;
    static final ByteBufAllocator DEFAULT_ALLOCATOR;
    private static final ByteBufProcessor FIND_NON_ASCII;
    private static final int MAX_BYTES_PER_CHAR_UTF8 = 0;
    private static final int MAX_CHAR_BUFFER_SIZE = 0;
    private static final int THREAD_LOCAL_BUFFER_SIZE = 0;
    private static final byte WRITE_UTF_UNKNOWN = 63;
    private static final io.netty.d.b.a.d logger;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static {
        block2 : {
            ByteBufUtil.logger = e.a(ByteBufUtil.class);
            ByteBufUtil.CHAR_BUFFERS = new 1();
            ByteBufUtil.MAX_BYTES_PER_CHAR_UTF8 = (int)d.a(d.d).maxBytesPerChar();
            var0 = u.a("io.netty.allocator.type", "unpooled").toLowerCase(Locale.US).trim();
            if (!"unpooled".equals((Object)var0)) break block2;
            var1_1 = UnpooledByteBufAllocator.DEFAULT;
            ** GOTO lbl11
        }
        if ("pooled".equals((Object)var0)) {
            var1_1 = PooledByteBufAllocator.DEFAULT;
lbl11: // 2 sources:
            var2_2 = ByteBufUtil.logger;
            var3_3 = "-Dio.netty.allocator.type: {}";
        } else {
            var1_1 = UnpooledByteBufAllocator.DEFAULT;
            var2_2 = ByteBufUtil.logger;
            var3_3 = "-Dio.netty.allocator.type: unpooled (unknown: {})";
        }
        var2_2.b(var3_3, (Object)var0);
        ByteBufUtil.DEFAULT_ALLOCATOR = var1_1;
        ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE = u.a("io.netty.threadLocalDirectBufferSize", 65536);
        ByteBufUtil.logger.b("-Dio.netty.threadLocalDirectBufferSize: {}", (Object)ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE);
        ByteBufUtil.MAX_CHAR_BUFFER_SIZE = u.a("io.netty.maxThreadLocalCharBufferSize", 16384);
        ByteBufUtil.logger.b("-Dio.netty.maxThreadLocalCharBufferSize: {}", (Object)ByteBufUtil.MAX_CHAR_BUFFER_SIZE);
        ByteBufUtil.FIND_NON_ASCII = new 2();
    }

    private ByteBufUtil() {
    }

    static /* synthetic */ int access$500() {
        return THREAD_LOCAL_BUFFER_SIZE;
    }

    public static void appendPrettyHexDump(StringBuilder stringBuilder, ByteBuf byteBuf) {
        ByteBufUtil.appendPrettyHexDump(stringBuilder, byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static void appendPrettyHexDump(StringBuilder stringBuilder, ByteBuf byteBuf, int n2, int n3) {
        HexUtil.appendPrettyHexDump(stringBuilder, byteBuf, n2, n3);
    }

    public static int compare(ByteBuf byteBuf, ByteBuf byteBuf2) {
        int n2 = byteBuf.readableBytes();
        int n3 = byteBuf2.readableBytes();
        int n4 = Math.min((int)n2, (int)n3);
        int n5 = n4 >>> 2;
        int n6 = n4 & 3;
        int n7 = byteBuf.readerIndex();
        int n8 = byteBuf2.readerIndex();
        if (n5 > 0) {
            boolean bl = byteBuf.order() == ByteOrder.BIG_ENDIAN;
            int n9 = n5 << 2;
            long l2 = byteBuf.order() == byteBuf2.order() ? (bl ? ByteBufUtil.compareUintBigEndian(byteBuf, byteBuf2, n7, n8, n9) : ByteBufUtil.compareUintLittleEndian(byteBuf, byteBuf2, n7, n8, n9)) : (bl ? ByteBufUtil.compareUintBigEndianA(byteBuf, byteBuf2, n7, n8, n9) : ByteBufUtil.compareUintBigEndianB(byteBuf, byteBuf2, n7, n8, n9));
            if (l2 != 0L) {
                return (int)Math.min((long)Integer.MAX_VALUE, (long)Math.max((long)Integer.MIN_VALUE, (long)l2));
            }
            n7 += n9;
            n8 += n9;
        }
        int n10 = n6 + n7;
        while (n7 < n10) {
            int n11 = byteBuf.getUnsignedByte(n7) - byteBuf2.getUnsignedByte(n8);
            if (n11 != 0) {
                return n11;
            }
            ++n7;
            ++n8;
        }
        return n2 - n3;
    }

    private static long compareUintBigEndian(ByteBuf byteBuf, ByteBuf byteBuf2, int n2, int n3, int n4) {
        int n5 = n4 + n2;
        while (n2 < n5) {
            long l2 = byteBuf.getUnsignedInt(n2) - byteBuf2.getUnsignedInt(n3);
            if (l2 != 0L) {
                return l2;
            }
            n2 += 4;
            n3 += 4;
        }
        return 0L;
    }

    private static long compareUintBigEndianA(ByteBuf byteBuf, ByteBuf byteBuf2, int n2, int n3, int n4) {
        int n5 = n4 + n2;
        while (n2 < n5) {
            long l2 = byteBuf.getUnsignedInt(n2) - (0xFFFFFFFFL & (long)ByteBufUtil.swapInt(byteBuf2.getInt(n3)));
            if (l2 != 0L) {
                return l2;
            }
            n2 += 4;
            n3 += 4;
        }
        return 0L;
    }

    private static long compareUintBigEndianB(ByteBuf byteBuf, ByteBuf byteBuf2, int n2, int n3, int n4) {
        int n5 = n4 + n2;
        while (n2 < n5) {
            long l2 = (0xFFFFFFFFL & (long)ByteBufUtil.swapInt(byteBuf.getInt(n2))) - byteBuf2.getUnsignedInt(n3);
            if (l2 != 0L) {
                return l2;
            }
            n2 += 4;
            n3 += 4;
        }
        return 0L;
    }

    private static long compareUintLittleEndian(ByteBuf byteBuf, ByteBuf byteBuf2, int n2, int n3, int n4) {
        int n5 = n4 + n2;
        while (n2 < n5) {
            long l2 = (0xFFFFFFFFL & (long)ByteBufUtil.swapInt(byteBuf.getInt(n2))) - (0xFFFFFFFFL & (long)ByteBufUtil.swapInt(byteBuf2.getInt(n3)));
            if (l2 != 0L) {
                return l2;
            }
            n2 += 4;
            n3 += 4;
        }
        return 0L;
    }

    public static byte decodeHexByte(CharSequence charSequence, int n2) {
        return t.a(charSequence, n2);
    }

    public static byte[] decodeHexDump(CharSequence charSequence) {
        return t.a(charSequence, 0, charSequence.length());
    }

    public static byte[] decodeHexDump(CharSequence charSequence, int n2, int n3) {
        return t.a(charSequence, n2, n3);
    }

    static String decodeString(ByteBuf byteBuf, int n2, int n3, Charset charset) {
        ByteBuf byteBuf2;
        if (n3 == 0) {
            return "";
        }
        CharsetDecoder charsetDecoder = d.b(charset);
        int n4 = (int)((double)n3 * (double)charsetDecoder.maxCharsPerByte());
        CharBuffer charBuffer = CHAR_BUFFERS.get();
        if (charBuffer.length() < n4) {
            charBuffer = CharBuffer.allocate((int)n4);
            if (n4 <= MAX_CHAR_BUFFER_SIZE) {
                CHAR_BUFFERS.set(charBuffer);
            }
        } else {
            charBuffer.clear();
        }
        if (byteBuf.nioBufferCount() == 1) {
            ByteBufUtil.decodeString(charsetDecoder, byteBuf.nioBuffer(n2, n3), charBuffer);
        } else {
            byteBuf2 = byteBuf.alloc().heapBuffer(n3);
            byteBuf2.writeBytes(byteBuf, n2, n3);
            ByteBufUtil.decodeString(charsetDecoder, byteBuf2.internalNioBuffer(byteBuf2.readerIndex(), n3), charBuffer);
        }
        return charBuffer.flip().toString();
        finally {
            byteBuf2.release();
        }
    }

    private static void decodeString(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        try {
            CoderResult coderResult;
            CoderResult coderResult2 = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!coderResult2.isUnderflow()) {
                coderResult2.throwException();
            }
            if (!(coderResult = charsetDecoder.flush(charBuffer)).isUnderflow()) {
                coderResult.throwException();
            }
            return;
        }
        catch (CharacterCodingException characterCodingException) {
            throw new IllegalStateException((Throwable)characterCodingException);
        }
    }

    public static ByteBuf encodeString(ByteBufAllocator byteBufAllocator, CharBuffer charBuffer, Charset charset) {
        return ByteBufUtil.encodeString0(byteBufAllocator, false, charBuffer, charset);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static ByteBuf encodeString0(ByteBufAllocator byteBufAllocator, boolean bl, CharBuffer charBuffer, Charset charset) {
        ByteBuf byteBuf;
        Throwable throwable2222;
        block6 : {
            CharsetEncoder charsetEncoder = d.a(charset);
            int n2 = (int)((double)charBuffer.remaining() * (double)charsetEncoder.maxBytesPerChar());
            byteBuf = bl ? byteBufAllocator.heapBuffer(n2) : byteBufAllocator.buffer(n2);
            try {
                CoderResult coderResult;
                ByteBuffer byteBuffer = byteBuf.internalNioBuffer(byteBuf.readerIndex(), n2);
                int n3 = byteBuffer.position();
                CoderResult coderResult2 = charsetEncoder.encode(charBuffer, byteBuffer, true);
                if (!coderResult2.isUnderflow()) {
                    coderResult2.throwException();
                }
                if (!(coderResult = charsetEncoder.flush(byteBuffer)).isUnderflow()) {
                    coderResult.throwException();
                }
                byteBuf.writerIndex(byteBuf.writerIndex() + byteBuffer.position() - n3);
                return byteBuf;
            }
            catch (Throwable throwable2222) {
                break block6;
            }
            catch (CharacterCodingException characterCodingException) {
                throw new IllegalStateException((Throwable)characterCodingException);
            }
        }
        byteBuf.release();
        throw throwable2222;
    }

    public static boolean equals(ByteBuf byteBuf, ByteBuf byteBuf2) {
        int n2;
        int n3 = byteBuf.readableBytes();
        if (n3 != byteBuf2.readableBytes()) {
            return false;
        }
        int n4 = n3 & 7;
        int n5 = byteBuf.readerIndex();
        int n6 = byteBuf2.readerIndex();
        if (byteBuf.order() == byteBuf2.order()) {
            for (n2 = n3 >>> 3; n2 > 0; --n2) {
                if (byteBuf.getLong(n5) != byteBuf2.getLong(n6)) {
                    return false;
                }
                n5 += 8;
                n6 += 8;
            }
        } else {
            while (n2 > 0) {
                if (byteBuf.getLong(n5) != ByteBufUtil.swapLong(byteBuf2.getLong(n6))) {
                    return false;
                }
                n5 += 8;
                n6 += 8;
                --n2;
            }
        }
        while (n4 > 0) {
            if (byteBuf.getByte(n5) != byteBuf2.getByte(n6)) {
                return false;
            }
            ++n5;
            ++n6;
            --n4;
        }
        return true;
    }

    private static int firstIndexOf(ByteBuf byteBuf, int n2, int n3, byte by) {
        int n4 = Math.max((int)n2, (int)0);
        if (n4 < n3 && byteBuf.capacity() != 0) {
            return byteBuf.forEachByte(n4, n3 - n4, (ByteBufProcessor)new /* Unavailable Anonymous Inner Class!! */);
        }
        return -1;
    }

    public static int hashCode(ByteBuf byteBuf) {
        int n2;
        int n3;
        int n4;
        int n5 = byteBuf.readableBytes();
        int n6 = n5 & 3;
        int n7 = byteBuf.readerIndex();
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            n4 = n7;
            n2 = 1;
            for (n3 = n5 >>> 2; n3 > 0; --n3) {
                n2 = n2 * 31 + byteBuf.getInt(n4);
                n4 += 4;
            }
        } else {
            n4 = n7;
            n2 = 1;
            while (n3 > 0) {
                n2 = n2 * 31 + ByteBufUtil.swapInt(byteBuf.getInt(n4));
                n4 += 4;
                --n3;
            }
        }
        while (n6 > 0) {
            int n8 = n2 * 31;
            int n9 = n4 + 1;
            n2 = n8 + byteBuf.getByte(n4);
            --n6;
            n4 = n9;
        }
        if (n2 == 0) {
            n2 = 1;
        }
        return n2;
    }

    public static String hexDump(ByteBuf byteBuf) {
        return ByteBufUtil.hexDump(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static String hexDump(ByteBuf byteBuf, int n2, int n3) {
        return HexUtil.hexDump(byteBuf, n2, n3);
    }

    public static String hexDump(byte[] arrby) {
        return ByteBufUtil.hexDump(arrby, 0, arrby.length);
    }

    public static String hexDump(byte[] arrby, int n2, int n3) {
        return HexUtil.hexDump(arrby, n2, n3);
    }

    public static int indexOf(ByteBuf byteBuf, int n2, int n3, byte by) {
        if (n2 <= n3) {
            return ByteBufUtil.firstIndexOf(byteBuf, n2, n3, by);
        }
        return ByteBufUtil.lastIndexOf(byteBuf, n2, n3, by);
    }

    private static boolean isAscii(ByteBuf byteBuf, int n2, int n3) {
        return byteBuf.forEachByte(n2, n3, FIND_NON_ASCII) == -1;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean isText(ByteBuf byteBuf, int n2, int n3, Charset charset) {
        l.a(byteBuf, "buf");
        l.a(charset, "charset");
        int n4 = byteBuf.readerIndex() + byteBuf.readableBytes();
        if (n2 >= 0 && n3 >= 0 && n2 <= n4 - n3) {
            ByteBuf byteBuf2;
            if (charset.equals((Object)d.d)) {
                return ByteBufUtil.isUtf8(byteBuf, n2, n3);
            }
            if (charset.equals((Object)d.f)) {
                return ByteBufUtil.isAscii(byteBuf, n2, n3);
            }
            CharsetDecoder charsetDecoder = d.a(charset, CodingErrorAction.REPORT, CodingErrorAction.REPORT);
            try {
                if (byteBuf.nioBufferCount() == 1) {
                    charsetDecoder.decode(byteBuf.nioBuffer(n2, n3));
                    return true;
                }
                byteBuf2 = byteBuf.alloc().heapBuffer(n3);
            }
            catch (CharacterCodingException characterCodingException) {
                return false;
            }
            byteBuf2.writeBytes(byteBuf, n2, n3);
            charsetDecoder.decode(byteBuf2.internalNioBuffer(byteBuf2.readerIndex(), n3));
            {
                catch (Throwable throwable) {
                    byteBuf2.release();
                    throw throwable;
                }
            }
            byteBuf2.release();
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder("index: ");
        stringBuilder.append(n2);
        stringBuilder.append(" length: ");
        stringBuilder.append(n3);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public static boolean isText(ByteBuf byteBuf, Charset charset) {
        return ByteBufUtil.isText(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), charset);
    }

    private static boolean isUtf8(ByteBuf byteBuf, int n2, int n3) {
        int n4 = n3 + n2;
        while (n2 < n4) {
            int n5 = n2 + 1;
            byte by = byteBuf.getByte(n2);
            if ((by & 128) != 0) {
                if ((by & 224) == 192) {
                    if (n5 >= n4) {
                        return false;
                    }
                    int n6 = n5 + 1;
                    if ((192 & byteBuf.getByte(n5)) != 128) {
                        return false;
                    }
                    if ((by & 255) < 194) {
                        return false;
                    }
                    n2 = n6;
                    continue;
                }
                if ((by & 240) == 224) {
                    if (n5 > n4 - 2) {
                        return false;
                    }
                    int n7 = n5 + 1;
                    byte by2 = byteBuf.getByte(n5);
                    int n8 = n7 + 1;
                    byte by3 = byteBuf.getByte(n7);
                    if ((by2 & 192) == 128) {
                        if ((by3 & 192) != 128) {
                            return false;
                        }
                        int n9 = by & 15;
                        if (n9 == 0 && (by2 & 255) < 160) {
                            return false;
                        }
                        if (n9 == 13 && (by2 & 255) > 159) {
                            return false;
                        }
                        n2 = n8;
                        continue;
                    }
                    return false;
                }
                if ((by & 248) == 240) {
                    if (n5 > n4 - 3) {
                        return false;
                    }
                    int n10 = n5 + 1;
                    byte by4 = byteBuf.getByte(n5);
                    int n11 = n10 + 1;
                    byte by5 = byteBuf.getByte(n10);
                    int n12 = n11 + 1;
                    byte by6 = byteBuf.getByte(n11);
                    if ((by4 & 192) == 128 && (by5 & 192) == 128) {
                        if ((by6 & 192) != 128) {
                            return false;
                        }
                        int n13 = by & 255;
                        if (n13 <= 244 && (n13 != 240 || (by4 & 255) >= 144)) {
                            if (n13 == 244 && (by4 & 255) > 143) {
                                return false;
                            }
                            n2 = n12;
                            continue;
                        }
                    }
                }
                return false;
            }
            n2 = n5;
        }
        return true;
    }

    private static int lastIndexOf(ByteBuf byteBuf, int n2, int n3, byte by) {
        int n4 = Math.min((int)n2, (int)byteBuf.capacity());
        if (n4 >= 0 && byteBuf.capacity() != 0) {
            return byteBuf.forEachByteDesc(n3, n4 - n3, (ByteBufProcessor)new /* Unavailable Anonymous Inner Class!! */);
        }
        return -1;
    }

    public static String prettyHexDump(ByteBuf byteBuf) {
        return ByteBufUtil.prettyHexDump(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static String prettyHexDump(ByteBuf byteBuf, int n2, int n3) {
        return HexUtil.prettyHexDump(byteBuf, n2, n3);
    }

    public static ByteBuf readBytes(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, int n2) {
        ByteBuf byteBuf2 = byteBufAllocator.buffer(n2);
        try {
            byteBuf.readBytes(byteBuf2);
            return byteBuf2;
        }
        catch (Throwable throwable) {
            byteBuf2.release();
            throw throwable;
        }
    }

    public static int swapInt(int n2) {
        return Integer.reverseBytes((int)n2);
    }

    public static long swapLong(long l2) {
        return Long.reverseBytes((long)l2);
    }

    public static int swapMedium(int n2) {
        int n3 = 16711680 & n2 << 16 | 65280 & n2 | 255 & n2 >>> 16;
        if ((8388608 & n3) != 0) {
            n3 |= -16777216;
        }
        return n3;
    }

    public static short swapShort(short s2) {
        return Short.reverseBytes((short)s2);
    }

    public static ByteBuf threadLocalDirectBuffer() {
        if (THREAD_LOCAL_BUFFER_SIZE <= 0) {
            return null;
        }
        if (n.f()) {
            return ThreadLocalUnsafeDirectByteBuf.newInstance();
        }
        return ThreadLocalDirectByteBuf.newInstance();
    }

    public static int writeAscii(ByteBuf byteBuf, CharSequence charSequence) {
        int n2 = charSequence.length();
        byteBuf.ensureWritable(n2);
        do {
            if (byteBuf instanceof AbstractByteBuf) {
                ByteBufUtil.writeAscii((AbstractByteBuf)byteBuf, charSequence, n2);
                return n2;
            }
            if (!(byteBuf instanceof WrappedByteBuf)) break;
            byteBuf = byteBuf.unwrap();
        } while (true);
        byte[] arrby = charSequence.toString().getBytes(d.f);
        byteBuf.writeBytes(arrby);
        return arrby.length;
    }

    public static ByteBuf writeAscii(ByteBufAllocator byteBufAllocator, CharSequence charSequence) {
        ByteBuf byteBuf = byteBufAllocator.buffer(charSequence.length());
        ByteBufUtil.writeAscii(byteBuf, charSequence);
        return byteBuf;
    }

    private static void writeAscii(AbstractByteBuf abstractByteBuf, CharSequence charSequence, int n2) {
        int n3 = abstractByteBuf.writerIndex;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = n3 + 1;
            abstractByteBuf._setByte(n3, (int)((byte)charSequence.charAt(i2)));
            n3 = n4;
        }
        abstractByteBuf.writerIndex = n3;
    }

    /*
     * Exception decompiling
     */
    private static int writeUtf8(AbstractByteBuf var0, CharSequence var1, int var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl221 : ALOAD_0 : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public static int writeUtf8(ByteBuf byteBuf, CharSequence charSequence) {
        int n2 = charSequence.length();
        byteBuf.ensureWritable(n2 * MAX_BYTES_PER_CHAR_UTF8);
        do {
            if (byteBuf instanceof AbstractByteBuf) {
                return ByteBufUtil.writeUtf8((AbstractByteBuf)byteBuf, charSequence, n2);
            }
            if (!(byteBuf instanceof WrappedByteBuf)) break;
            byteBuf = byteBuf.unwrap();
        } while (true);
        byte[] arrby = charSequence.toString().getBytes(d.d);
        byteBuf.writeBytes(arrby);
        return arrby.length;
    }

    public static ByteBuf writeUtf8(ByteBufAllocator byteBufAllocator, CharSequence charSequence) {
        ByteBuf byteBuf = byteBufAllocator.buffer(charSequence.length() * MAX_BYTES_PER_CHAR_UTF8);
        ByteBufUtil.writeUtf8(byteBuf, charSequence);
        return byteBuf;
    }

    private static final class HexUtil {
        private static final char[] BYTE2CHAR = new char[256];
        private static final String[] BYTE2HEX;
        private static final String[] BYTEPADDING;
        private static final String[] HEXDUMP_ROWPREFIXES;
        private static final char[] HEXDUMP_TABLE;
        private static final String[] HEXPADDING;

        static {
            HEXDUMP_TABLE = new char[1024];
            HEXPADDING = new String[16];
            HEXDUMP_ROWPREFIXES = new String[4096];
            BYTE2HEX = new String[256];
            BYTEPADDING = new String[16];
            char[] arrc = "0123456789abcdef".toCharArray();
            for (int i2 = 0; i2 < 256; ++i2) {
                char[] arrc2 = HEXDUMP_TABLE;
                int n2 = i2 << 1;
                arrc2[n2] = arrc[15 & i2 >>> 4];
                HexUtil.HEXDUMP_TABLE[n2 + 1] = arrc[i2 & 15];
            }
            for (int i3 = 0; i3 < HEXPADDING.length; ++i3) {
                int n3 = HEXPADDING.length - i3;
                StringBuilder stringBuilder = new StringBuilder(n3 * 3);
                for (int i4 = 0; i4 < n3; ++i4) {
                    stringBuilder.append("   ");
                }
                HexUtil.HEXPADDING[i3] = stringBuilder.toString();
            }
            for (int i5 = 0; i5 < HEXDUMP_ROWPREFIXES.length; ++i5) {
                StringBuilder stringBuilder = new StringBuilder(12);
                stringBuilder.append(t.a);
                stringBuilder.append(Long.toHexString((long)(0x100000000L | 0xFFFFFFFFL & (long)(i5 << 4))));
                stringBuilder.setCharAt(-9 + stringBuilder.length(), '|');
                stringBuilder.append('|');
                HexUtil.HEXDUMP_ROWPREFIXES[i5] = stringBuilder.toString();
            }
            for (int i6 = 0; i6 < BYTE2HEX.length; ++i6) {
                String[] arrstring = BYTE2HEX;
                StringBuilder stringBuilder = new StringBuilder(" ");
                stringBuilder.append(t.a(i6));
                arrstring[i6] = stringBuilder.toString();
            }
            int n4 = 0;
            do {
                int n5 = BYTEPADDING.length;
                if (n4 >= n5) break;
                int n6 = BYTEPADDING.length - n4;
                StringBuilder stringBuilder = new StringBuilder(n6);
                for (int i7 = 0; i7 < n6; ++i7) {
                    stringBuilder.append(' ');
                }
                HexUtil.BYTEPADDING[n4] = stringBuilder.toString();
                ++n4;
            } while (true);
            for (int i8 = 0; i8 < BYTE2CHAR.length; ++i8) {
                if (i8 > 31 && i8 < 127) {
                    HexUtil.BYTE2CHAR[i8] = (char)i8;
                    continue;
                }
                HexUtil.BYTE2CHAR[i8] = 46;
            }
        }

        private HexUtil() {
        }

        private static void appendHexDumpRowPrefix(StringBuilder stringBuilder, int n2, int n3) {
            if (n2 < HEXDUMP_ROWPREFIXES.length) {
                stringBuilder.append(HEXDUMP_ROWPREFIXES[n2]);
                return;
            }
            stringBuilder.append(t.a);
            stringBuilder.append(Long.toHexString((long)(0x100000000L | 0xFFFFFFFFL & (long)n3)));
            stringBuilder.setCharAt(-9 + stringBuilder.length(), '|');
            stringBuilder.append('|');
        }

        private static void appendPrettyHexDump(StringBuilder stringBuilder, ByteBuf byteBuf, int n2, int n3) {
            if (j.a(n2, n3, byteBuf.capacity())) {
                StringBuilder stringBuilder2 = new StringBuilder("expected: 0 <= offset(");
                stringBuilder2.append(n2);
                stringBuilder2.append(") <= offset + length(");
                stringBuilder2.append(n3);
                stringBuilder2.append(") <= buf.capacity(");
                stringBuilder2.append(byteBuf.capacity());
                stringBuilder2.append(')');
                throw new IndexOutOfBoundsException(stringBuilder2.toString());
            }
            if (n3 == 0) {
                return;
            }
            StringBuilder stringBuilder3 = new StringBuilder("         +-------------------------------------------------+");
            stringBuilder3.append(t.a);
            stringBuilder3.append("         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |");
            stringBuilder3.append(t.a);
            stringBuilder3.append("+--------+-------------------------------------------------+----------------+");
            stringBuilder.append(stringBuilder3.toString());
            int n4 = n3 >>> 4;
            int n5 = n3 & 15;
            for (int i2 = 0; i2 < n4; ++i2) {
                int n6 = n2 + (i2 << 4);
                HexUtil.appendHexDumpRowPrefix(stringBuilder, i2, n6);
                int n7 = n6 + 16;
                for (int i3 = n6; i3 < n7; ++i3) {
                    stringBuilder.append(BYTE2HEX[byteBuf.getUnsignedByte(i3)]);
                }
                stringBuilder.append(" |");
                while (n6 < n7) {
                    stringBuilder.append(BYTE2CHAR[byteBuf.getUnsignedByte(n6)]);
                    ++n6;
                }
                stringBuilder.append('|');
            }
            if (n5 != 0) {
                int n8 = n2 + (n4 << 4);
                HexUtil.appendHexDumpRowPrefix(stringBuilder, n4, n8);
                int n9 = n8 + n5;
                for (int i4 = n8; i4 < n9; ++i4) {
                    stringBuilder.append(BYTE2HEX[byteBuf.getUnsignedByte(i4)]);
                }
                stringBuilder.append(HEXPADDING[n5]);
                stringBuilder.append(" |");
                while (n8 < n9) {
                    stringBuilder.append(BYTE2CHAR[byteBuf.getUnsignedByte(n8)]);
                    ++n8;
                }
                stringBuilder.append(BYTEPADDING[n5]);
                stringBuilder.append('|');
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(t.a);
            stringBuilder4.append("+--------+-------------------------------------------------+----------------+");
            stringBuilder.append(stringBuilder4.toString());
        }

        private static String hexDump(ByteBuf byteBuf, int n2, int n3) {
            if (n3 < 0) {
                StringBuilder stringBuilder = new StringBuilder("length: ");
                stringBuilder.append(n3);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            if (n3 == 0) {
                return "";
            }
            int n4 = n2 + n3;
            char[] arrc = new char[n3 << 1];
            int n5 = 0;
            while (n2 < n4) {
                System.arraycopy((Object)HEXDUMP_TABLE, (int)(byteBuf.getUnsignedByte(n2) << 1), (Object)arrc, (int)n5, (int)2);
                ++n2;
                n5 += 2;
            }
            return new String(arrc);
        }

        private static String hexDump(byte[] arrby, int n2, int n3) {
            if (n3 < 0) {
                StringBuilder stringBuilder = new StringBuilder("length: ");
                stringBuilder.append(n3);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            if (n3 == 0) {
                return "";
            }
            int n4 = n2 + n3;
            char[] arrc = new char[n3 << 1];
            int n5 = 0;
            while (n2 < n4) {
                System.arraycopy((Object)HEXDUMP_TABLE, (int)((255 & arrby[n2]) << 1), (Object)arrc, (int)n5, (int)2);
                ++n2;
                n5 += 2;
            }
            return new String(arrc);
        }

        private static String prettyHexDump(ByteBuf byteBuf, int n2, int n3) {
            if (n3 == 0) {
                return "";
            }
            int n4 = n3 / 16;
            int n5 = n3 % 15 == 0 ? 0 : 1;
            StringBuilder stringBuilder = new StringBuilder(80 * (4 + (n4 + n5)));
            HexUtil.appendPrettyHexDump(stringBuilder, byteBuf, n2, n3);
            return stringBuilder.toString();
        }
    }

}

