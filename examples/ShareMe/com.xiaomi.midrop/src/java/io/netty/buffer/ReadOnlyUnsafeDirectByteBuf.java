/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 */
package io.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ReadOnlyByteBufferBuf;
import io.netty.buffer.UnsafeByteBufUtil;
import io.netty.d.b.n;
import java.nio.Buffer;
import java.nio.ByteBuffer;

final class ReadOnlyUnsafeDirectByteBuf
extends ReadOnlyByteBufferBuf {
    private final long memoryAddress;

    ReadOnlyUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer) {
        super(byteBufAllocator, byteBuffer);
        this.memoryAddress = n.b(this.buffer);
    }

    private long addr(int n2) {
        return this.memoryAddress + (long)n2;
    }

    @Override
    protected final byte _getByte(int n2) {
        return UnsafeByteBufUtil.getByte(ReadOnlyUnsafeDirectByteBuf.super.addr(n2));
    }

    @Override
    protected final int _getInt(int n2) {
        return UnsafeByteBufUtil.getInt(ReadOnlyUnsafeDirectByteBuf.super.addr(n2));
    }

    @Override
    protected final long _getLong(int n2) {
        return UnsafeByteBufUtil.getLong(ReadOnlyUnsafeDirectByteBuf.super.addr(n2));
    }

    @Override
    protected final short _getShort(int n2) {
        return UnsafeByteBufUtil.getShort(ReadOnlyUnsafeDirectByteBuf.super.addr(n2));
    }

    @Override
    protected final int _getUnsignedMedium(int n2) {
        return UnsafeByteBufUtil.getUnsignedMedium(ReadOnlyUnsafeDirectByteBuf.super.addr(n2));
    }

    @Override
    public final ByteBuf copy(int n2, int n3) {
        this.checkIndex(n2, n3);
        ByteBuf byteBuf = this.alloc().directBuffer(n3, this.maxCapacity());
        if (n3 != 0) {
            if (byteBuf.hasMemoryAddress()) {
                n.a(ReadOnlyUnsafeDirectByteBuf.super.addr(n2), byteBuf.memoryAddress(), (long)n3);
                byteBuf.setIndex(0, n3);
                return byteBuf;
            }
            byteBuf.writeBytes((ByteBuf)this, n2, n3);
        }
        return byteBuf;
    }

    @Override
    public final ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.checkIndex(n2, n4);
        if (byteBuf == null) {
            throw new NullPointerException("dst");
        }
        if (n3 >= 0 && n3 <= byteBuf.capacity() - n4) {
            if (byteBuf.hasMemoryAddress()) {
                n.a(ReadOnlyUnsafeDirectByteBuf.super.addr(n2), byteBuf.memoryAddress() + (long)n3, (long)n4);
                return this;
            }
            if (byteBuf.hasArray()) {
                n.a(ReadOnlyUnsafeDirectByteBuf.super.addr(n2), byteBuf.array(), n3 + byteBuf.arrayOffset(), (long)n4);
                return this;
            }
            byteBuf.setBytes(n3, (ByteBuf)this, n2, n4);
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder("dstIndex: ");
        stringBuilder.append(n3);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    @Override
    public final ByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
        this.checkIndex(n2);
        if (byteBuffer == null) {
            throw new NullPointerException("dst");
        }
        int n3 = Math.min((int)(this.capacity() - n2), (int)byteBuffer.remaining());
        ByteBuffer byteBuffer2 = this.internalNioBuffer();
        byteBuffer2.clear().position(n2).limit(n2 + n3);
        byteBuffer.put(byteBuffer2);
        return this;
    }

    @Override
    public final ByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
        this.checkIndex(n2, n4);
        if (arrby == null) {
            throw new NullPointerException("dst");
        }
        if (n3 >= 0 && n3 <= arrby.length - n4) {
            if (n4 != 0) {
                n.a(ReadOnlyUnsafeDirectByteBuf.super.addr(n2), arrby, n3, (long)n4);
            }
            return this;
        }
        Object[] arrobject = new Object[]{n3, n4, arrby.length};
        throw new IndexOutOfBoundsException(String.format((String)"dstIndex: %d, length: %d (expected: range(0, %d))", (Object[])arrobject));
    }

    @Override
    public final boolean hasMemoryAddress() {
        return true;
    }

    @Override
    public final long memoryAddress() {
        return this.memoryAddress;
    }
}

