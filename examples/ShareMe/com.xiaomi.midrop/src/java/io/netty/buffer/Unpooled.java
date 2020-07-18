/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.CompositeByteBuf
 *  io.netty.buffer.FixedCompositeByteBuf
 *  io.netty.buffer.ReadOnlyByteBuf
 *  io.netty.buffer.ReadOnlyByteBufferBuf
 *  io.netty.buffer.ReadOnlyUnsafeDirectByteBuf
 *  io.netty.buffer.UnpooledByteBufAllocator
 *  io.netty.buffer.UnpooledDirectByteBuf
 *  io.netty.buffer.UnpooledHeapByteBuf
 *  io.netty.buffer.UnpooledUnsafeDirectByteBuf
 *  io.netty.buffer.UnreleasableByteBuf
 *  io.netty.buffer.WrappedUnpooledUnsafeDirectByteBuf
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.CharBuffer
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 */
package io.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.FixedCompositeByteBuf;
import io.netty.buffer.ReadOnlyByteBuf;
import io.netty.buffer.ReadOnlyByteBufferBuf;
import io.netty.buffer.ReadOnlyUnsafeDirectByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.buffer.UnpooledDirectByteBuf;
import io.netty.buffer.UnpooledHeapByteBuf;
import io.netty.buffer.UnpooledUnsafeDirectByteBuf;
import io.netty.buffer.UnreleasableByteBuf;
import io.netty.buffer.WrappedUnpooledUnsafeDirectByteBuf;
import io.netty.d.b.n;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;

public final class Unpooled {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final ByteBufAllocator ALLOC = UnpooledByteBufAllocator.DEFAULT;
    public static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
    public static final ByteBuf EMPTY_BUFFER;
    public static final ByteOrder LITTLE_ENDIAN;

    static {
        LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        EMPTY_BUFFER = ALLOC.buffer(0, 0);
    }

    private Unpooled() {
    }

    public static ByteBuf buffer() {
        return ALLOC.heapBuffer();
    }

    public static ByteBuf buffer(int n2) {
        return ALLOC.heapBuffer(n2);
    }

    public static ByteBuf buffer(int n2, int n3) {
        return ALLOC.heapBuffer(n2, n3);
    }

    public static CompositeByteBuf compositeBuffer() {
        return Unpooled.compositeBuffer(16);
    }

    public static CompositeByteBuf compositeBuffer(int n2) {
        return new CompositeByteBuf(ALLOC, false, n2);
    }

    public static ByteBuf copiedBuffer(ByteBuf byteBuf) {
        int n2 = byteBuf.readableBytes();
        if (n2 > 0) {
            ByteBuf byteBuf2 = Unpooled.buffer(n2);
            byteBuf2.writeBytes(byteBuf, byteBuf.readerIndex(), n2);
            return byteBuf2;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copiedBuffer(CharSequence charSequence, int n2, int n3, Charset charset) {
        if (charSequence == null) {
            throw new NullPointerException("string");
        }
        if (n3 == 0) {
            return EMPTY_BUFFER;
        }
        if (charSequence instanceof CharBuffer) {
            CharBuffer charBuffer = (CharBuffer)charSequence;
            if (charBuffer.hasArray()) {
                return Unpooled.copiedBuffer(charBuffer.array(), n2 + (charBuffer.arrayOffset() + charBuffer.position()), n3, charset);
            }
            CharBuffer charBuffer2 = charBuffer.slice();
            charBuffer2.limit(n3);
            charBuffer2.position(n2);
            return Unpooled.copiedBuffer(charBuffer2, charset);
        }
        return Unpooled.copiedBuffer(CharBuffer.wrap((CharSequence)charSequence, (int)n2, (int)(n3 + n2)), charset);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ByteBuf copiedBuffer(CharSequence charSequence, Charset charset) {
        CharBuffer charBuffer;
        if (charSequence == null) {
            throw new NullPointerException("string");
        }
        if (charSequence instanceof CharBuffer) {
            charBuffer = (CharBuffer)charSequence;
            do {
                return Unpooled.copiedBuffer(charBuffer, charset);
                break;
            } while (true);
        }
        charBuffer = CharBuffer.wrap((CharSequence)charSequence);
        return Unpooled.copiedBuffer(charBuffer, charset);
    }

    public static ByteBuf copiedBuffer(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.remaining();
        if (n2 == 0) {
            return EMPTY_BUFFER;
        }
        byte[] arrby = new byte[n2];
        ByteBuffer byteBuffer2 = byteBuffer.duplicate();
        byteBuffer2.get(arrby);
        return Unpooled.wrappedBuffer(arrby).order(byteBuffer2.order());
    }

    private static ByteBuf copiedBuffer(CharBuffer charBuffer, Charset charset) {
        return ByteBufUtil.encodeString0(ALLOC, true, charBuffer, charset);
    }

    public static ByteBuf copiedBuffer(byte[] arrby) {
        if (arrby.length == 0) {
            return EMPTY_BUFFER;
        }
        return Unpooled.wrappedBuffer((byte[])arrby.clone());
    }

    public static ByteBuf copiedBuffer(byte[] arrby, int n2, int n3) {
        if (n3 == 0) {
            return EMPTY_BUFFER;
        }
        byte[] arrby2 = new byte[n3];
        System.arraycopy((Object)arrby, (int)n2, (Object)arrby2, (int)0, (int)n3);
        return Unpooled.wrappedBuffer(arrby2);
    }

    public static ByteBuf copiedBuffer(char[] arrc, int n2, int n3, Charset charset) {
        if (arrc == null) {
            throw new NullPointerException("array");
        }
        if (n3 == 0) {
            return EMPTY_BUFFER;
        }
        return Unpooled.copiedBuffer(CharBuffer.wrap((char[])arrc, (int)n2, (int)n3), charset);
    }

    public static ByteBuf copiedBuffer(char[] arrc, Charset charset) {
        if (arrc == null) {
            throw new NullPointerException("array");
        }
        return Unpooled.copiedBuffer(arrc, 0, arrc.length, charset);
    }

    public static /* varargs */ ByteBuf copiedBuffer(ByteBuf ... arrbyteBuf) {
        int n2;
        int n3;
        ByteOrder byteOrder;
        int n4 = arrbyteBuf.length;
        int n5 = 0;
        switch (n4) {
            default: {
                n2 = arrbyteBuf.length;
                n3 = 0;
                byteOrder = null;
                break;
            }
            case 1: {
                return Unpooled.copiedBuffer(arrbyteBuf[0]);
            }
            case 0: {
                return EMPTY_BUFFER;
            }
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            ByteBuf byteBuf = arrbyteBuf[i2];
            int n6 = byteBuf.readableBytes();
            if (n6 <= 0) continue;
            if (Integer.MAX_VALUE - n3 < n6) {
                throw new IllegalArgumentException("The total length of the specified buffers is too big.");
            }
            n3 += n6;
            if (byteOrder != null) {
                if (byteOrder.equals((Object)byteBuf.order())) continue;
                throw new IllegalArgumentException("inconsistent byte order");
            }
            byteOrder = byteBuf.order();
        }
        if (n3 == 0) {
            return EMPTY_BUFFER;
        }
        byte[] arrby = new byte[n3];
        int n7 = 0;
        while (n5 < arrbyteBuf.length) {
            ByteBuf byteBuf = arrbyteBuf[n5];
            int n8 = byteBuf.readableBytes();
            byteBuf.getBytes(byteBuf.readerIndex(), arrby, n7, n8);
            n7 += n8;
            ++n5;
        }
        return Unpooled.wrappedBuffer(arrby).order(byteOrder);
    }

    public static /* varargs */ ByteBuf copiedBuffer(ByteBuffer ... arrbyteBuffer) {
        int n2;
        int n3;
        ByteOrder byteOrder;
        int n4 = arrbyteBuffer.length;
        int n5 = 0;
        switch (n4) {
            default: {
                n2 = arrbyteBuffer.length;
                n3 = 0;
                byteOrder = null;
                break;
            }
            case 1: {
                return Unpooled.copiedBuffer(arrbyteBuffer[0]);
            }
            case 0: {
                return EMPTY_BUFFER;
            }
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            ByteBuffer byteBuffer = arrbyteBuffer[i2];
            int n6 = byteBuffer.remaining();
            if (n6 <= 0) continue;
            if (Integer.MAX_VALUE - n3 < n6) {
                throw new IllegalArgumentException("The total length of the specified buffers is too big.");
            }
            n3 += n6;
            if (byteOrder != null) {
                if (byteOrder.equals((Object)byteBuffer.order())) continue;
                throw new IllegalArgumentException("inconsistent byte order");
            }
            byteOrder = byteBuffer.order();
        }
        if (n3 == 0) {
            return EMPTY_BUFFER;
        }
        byte[] arrby = new byte[n3];
        int n7 = 0;
        while (n5 < arrbyteBuffer.length) {
            ByteBuffer byteBuffer = arrbyteBuffer[n5].duplicate();
            int n8 = byteBuffer.remaining();
            byteBuffer.get(arrby, n7, n8);
            n7 += n8;
            ++n5;
        }
        return Unpooled.wrappedBuffer(arrby).order(byteOrder);
    }

    public static /* varargs */ ByteBuf copiedBuffer(byte[] ... arrby) {
        int n2;
        int n3;
        switch (arrby.length) {
            default: {
                n2 = arrby.length;
                n3 = 0;
                break;
            }
            case 1: {
                if (arrby[0].length == 0) {
                    return EMPTY_BUFFER;
                }
                return Unpooled.copiedBuffer(arrby[0]);
            }
            case 0: {
                return EMPTY_BUFFER;
            }
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            byte[] arrby2 = arrby[i2];
            if (Integer.MAX_VALUE - n3 < arrby2.length) {
                throw new IllegalArgumentException("The total length of the specified arrays is too big.");
            }
            n3 += arrby2.length;
        }
        if (n3 == 0) {
            return EMPTY_BUFFER;
        }
        byte[] arrby3 = new byte[n3];
        int n4 = 0;
        for (int i3 = 0; i3 < arrby.length; ++i3) {
            byte[] arrby4 = arrby[i3];
            System.arraycopy((Object)arrby4, (int)0, (Object)arrby3, (int)n4, (int)arrby4.length);
            n4 += arrby4.length;
        }
        return Unpooled.wrappedBuffer(arrby3);
    }

    public static ByteBuf copyBoolean(boolean bl) {
        ByteBuf byteBuf = Unpooled.buffer(1);
        byteBuf.writeBoolean(bl);
        return byteBuf;
    }

    public static /* varargs */ ByteBuf copyBoolean(boolean ... arrbl) {
        if (arrbl != null && arrbl.length != 0) {
            ByteBuf byteBuf = Unpooled.buffer(arrbl.length);
            int n2 = arrbl.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                byteBuf.writeBoolean(arrbl[i2]);
            }
            return byteBuf;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyDouble(double d2) {
        ByteBuf byteBuf = Unpooled.buffer(8);
        byteBuf.writeDouble(d2);
        return byteBuf;
    }

    public static /* varargs */ ByteBuf copyDouble(double ... arrd) {
        if (arrd != null && arrd.length != 0) {
            ByteBuf byteBuf = Unpooled.buffer(8 * arrd.length);
            int n2 = arrd.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                byteBuf.writeDouble(arrd[i2]);
            }
            return byteBuf;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyFloat(float f2) {
        ByteBuf byteBuf = Unpooled.buffer(4);
        byteBuf.writeFloat(f2);
        return byteBuf;
    }

    public static /* varargs */ ByteBuf copyFloat(float ... arrf) {
        if (arrf != null && arrf.length != 0) {
            ByteBuf byteBuf = Unpooled.buffer(4 * arrf.length);
            int n2 = arrf.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                byteBuf.writeFloat(arrf[i2]);
            }
            return byteBuf;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyInt(int n2) {
        ByteBuf byteBuf = Unpooled.buffer(4);
        byteBuf.writeInt(n2);
        return byteBuf;
    }

    public static /* varargs */ ByteBuf copyInt(int ... arrn) {
        if (arrn != null && arrn.length != 0) {
            ByteBuf byteBuf = Unpooled.buffer(4 * arrn.length);
            int n2 = arrn.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                byteBuf.writeInt(arrn[i2]);
            }
            return byteBuf;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyLong(long l2) {
        ByteBuf byteBuf = Unpooled.buffer(8);
        byteBuf.writeLong(l2);
        return byteBuf;
    }

    public static /* varargs */ ByteBuf copyLong(long ... arrl) {
        if (arrl != null && arrl.length != 0) {
            ByteBuf byteBuf = Unpooled.buffer(8 * arrl.length);
            int n2 = arrl.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                byteBuf.writeLong(arrl[i2]);
            }
            return byteBuf;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyMedium(int n2) {
        ByteBuf byteBuf = Unpooled.buffer(3);
        byteBuf.writeMedium(n2);
        return byteBuf;
    }

    public static /* varargs */ ByteBuf copyMedium(int ... arrn) {
        if (arrn != null && arrn.length != 0) {
            ByteBuf byteBuf = Unpooled.buffer(3 * arrn.length);
            int n2 = arrn.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                byteBuf.writeMedium(arrn[i2]);
            }
            return byteBuf;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyShort(int n2) {
        ByteBuf byteBuf = Unpooled.buffer(2);
        byteBuf.writeShort(n2);
        return byteBuf;
    }

    public static /* varargs */ ByteBuf copyShort(int ... arrn) {
        if (arrn != null && arrn.length != 0) {
            ByteBuf byteBuf = Unpooled.buffer(2 * arrn.length);
            int n2 = arrn.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                byteBuf.writeShort(arrn[i2]);
            }
            return byteBuf;
        }
        return EMPTY_BUFFER;
    }

    public static /* varargs */ ByteBuf copyShort(short ... arrs) {
        if (arrs != null && arrs.length != 0) {
            ByteBuf byteBuf = Unpooled.buffer(2 * arrs.length);
            int n2 = arrs.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                byteBuf.writeShort((int)arrs[i2]);
            }
            return byteBuf;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf directBuffer() {
        return ALLOC.directBuffer();
    }

    public static ByteBuf directBuffer(int n2) {
        return ALLOC.directBuffer(n2);
    }

    public static ByteBuf directBuffer(int n2, int n3) {
        return ALLOC.directBuffer(n2, n3);
    }

    public static ByteBuf unmodifiableBuffer(ByteBuf byteBuf) {
        if (byteBuf.order() == BIG_ENDIAN) {
            return new ReadOnlyByteBuf(byteBuf);
        }
        return new ReadOnlyByteBuf(byteBuf.order(BIG_ENDIAN)).order(LITTLE_ENDIAN);
    }

    public static /* varargs */ ByteBuf unmodifiableBuffer(ByteBuf ... arrbyteBuf) {
        return new FixedCompositeByteBuf(ALLOC, arrbyteBuf);
    }

    public static ByteBuf unreleasableBuffer(ByteBuf byteBuf) {
        return new UnreleasableByteBuf(byteBuf);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* varargs */ ByteBuf wrappedBuffer(int var0_1, ByteBuf ... var1) {
        switch (var1.length) {
            default: {
                var4_2 = 0;
                ** break;
            }
            case 1: {
                var2_3 = var1[0];
                if (var2_3.isReadable()) {
                    return Unpooled.wrappedBuffer(var2_3.order(Unpooled.BIG_ENDIAN));
                }
                var2_3.release();
                return Unpooled.EMPTY_BUFFER;
            }
            case 0: 
        }
        return Unpooled.EMPTY_BUFFER;
lbl13: // 2 sources:
        while (var4_2 < var1.length) {
            var5_4 = var1[var4_2];
            if (var5_4.isReadable()) {
                return new CompositeByteBuf(Unpooled.ALLOC, false, var0_1, var1, var4_2, var1.length);
            }
            var5_4.release();
            ++var4_2;
        }
        return Unpooled.EMPTY_BUFFER;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static /* varargs */ ByteBuf wrappedBuffer(int var0_1, ByteBuffer ... var1) {
        switch (var1.length) {
            default: {
                var2_2 = new ArrayList(var1.length);
                var3_3 = var1.length;
                break;
            }
            case 1: {
                if (!var1[0].hasRemaining()) return Unpooled.EMPTY_BUFFER;
                return Unpooled.wrappedBuffer(var1[0].order(Unpooled.BIG_ENDIAN));
            }
        }
        for (var4_4 = 0; var4_4 < var3_3 && (var5_5 = var1[var4_4]) != null; ++var4_4) {
            if (var5_5.remaining() <= 0) continue;
            var2_2.add((Object)Unpooled.wrappedBuffer(var5_5.order(Unpooled.BIG_ENDIAN)));
        }
        if (var2_2.isEmpty()) return Unpooled.EMPTY_BUFFER;
        return new CompositeByteBuf(Unpooled.ALLOC, false, var0_1, (Iterable)var2_2);
        {
            ** case 0:
        }
lbl16: // 1 sources:
        return Unpooled.EMPTY_BUFFER;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static /* varargs */ ByteBuf wrappedBuffer(int var0_1, byte[] ... var1) {
        switch (var1.length) {
            default: {
                var2_2 = new ArrayList(var1.length);
                var3_3 = var1.length;
                break;
            }
            case 1: {
                if (var1[0].length == 0) return Unpooled.EMPTY_BUFFER;
                return Unpooled.wrappedBuffer(var1[0]);
            }
        }
        for (var4_4 = 0; var4_4 < var3_3 && (var5_5 = var1[var4_4]) != null; ++var4_4) {
            if (var5_5.length <= 0) continue;
            var2_2.add((Object)Unpooled.wrappedBuffer(var5_5));
        }
        if (var2_2.isEmpty()) return Unpooled.EMPTY_BUFFER;
        return new CompositeByteBuf(Unpooled.ALLOC, false, var0_1, (Iterable)var2_2);
        {
            ** case 0:
        }
lbl16: // 1 sources:
        return Unpooled.EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(long l2, int n2, boolean bl) {
        WrappedUnpooledUnsafeDirectByteBuf wrappedUnpooledUnsafeDirectByteBuf = new WrappedUnpooledUnsafeDirectByteBuf(ALLOC, l2, n2, bl);
        return wrappedUnpooledUnsafeDirectByteBuf;
    }

    public static ByteBuf wrappedBuffer(ByteBuf byteBuf) {
        if (byteBuf.isReadable()) {
            return byteBuf.slice();
        }
        byteBuf.release();
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return EMPTY_BUFFER;
        }
        if (!byteBuffer.isDirect() && byteBuffer.hasArray()) {
            return Unpooled.wrappedBuffer(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()).order(byteBuffer.order());
        }
        if (n.f()) {
            if (byteBuffer.isReadOnly()) {
                if (byteBuffer.isDirect()) {
                    return new ReadOnlyUnsafeDirectByteBuf(ALLOC, byteBuffer);
                }
                return new ReadOnlyByteBufferBuf(ALLOC, byteBuffer);
            }
            return new UnpooledUnsafeDirectByteBuf(ALLOC, byteBuffer, byteBuffer.remaining());
        }
        if (byteBuffer.isReadOnly()) {
            return new ReadOnlyByteBufferBuf(ALLOC, byteBuffer);
        }
        return new UnpooledDirectByteBuf(ALLOC, byteBuffer, byteBuffer.remaining());
    }

    public static ByteBuf wrappedBuffer(byte[] arrby) {
        if (arrby.length == 0) {
            return EMPTY_BUFFER;
        }
        return new UnpooledHeapByteBuf(ALLOC, arrby, arrby.length);
    }

    public static ByteBuf wrappedBuffer(byte[] arrby, int n2, int n3) {
        if (n3 == 0) {
            return EMPTY_BUFFER;
        }
        if (n2 == 0 && n3 == arrby.length) {
            return Unpooled.wrappedBuffer(arrby);
        }
        return Unpooled.wrappedBuffer(arrby).slice(n2, n3);
    }

    public static /* varargs */ ByteBuf wrappedBuffer(ByteBuf ... arrbyteBuf) {
        return Unpooled.wrappedBuffer(16, arrbyteBuf);
    }

    public static /* varargs */ ByteBuf wrappedBuffer(ByteBuffer ... arrbyteBuffer) {
        return Unpooled.wrappedBuffer(16, arrbyteBuffer);
    }

    public static /* varargs */ ByteBuf wrappedBuffer(byte[] ... arrby) {
        return Unpooled.wrappedBuffer(16, arrby);
    }
}

