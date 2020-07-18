/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.PooledDirectByteBuf$1
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.channels.ClosedChannelException
 *  java.nio.channels.GatheringByteChannel
 *  java.nio.channels.ScatteringByteChannel
 */
package io.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBuf;
import io.netty.buffer.PooledDirectByteBuf;
import io.netty.d.j;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

final class PooledDirectByteBuf
extends PooledByteBuf<ByteBuffer> {
    private static final j<PooledDirectByteBuf> RECYCLER = new 1();

    private PooledDirectByteBuf(j.b b2, int n2) {
        super(b2, n2);
    }

    /* synthetic */ PooledDirectByteBuf(j.b b2, int n2, 1 var3_2) {
        super(b2, n2);
    }

    private int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3, boolean bl) throws IOException {
        this.checkIndex(n2, n3);
        if (n3 == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = bl ? this.internalNioBuffer() : ((ByteBuffer)this.memory).duplicate();
        int n4 = this.idx(n2);
        byteBuffer.clear().position(n4).limit(n4 + n3);
        return gatheringByteChannel.write(byteBuffer);
    }

    private void getBytes(int n2, OutputStream outputStream, int n3, boolean bl) throws IOException {
        this.checkIndex(n2, n3);
        if (n3 == 0) {
            return;
        }
        byte[] arrby = new byte[n3];
        ByteBuffer byteBuffer = bl ? this.internalNioBuffer() : ((ByteBuffer)this.memory).duplicate();
        byteBuffer.clear().position(this.idx(n2));
        byteBuffer.get(arrby);
        outputStream.write(arrby);
    }

    private void getBytes(int n2, ByteBuffer byteBuffer, boolean bl) {
        this.checkIndex(n2, byteBuffer.remaining());
        ByteBuffer byteBuffer2 = bl ? this.internalNioBuffer() : ((ByteBuffer)this.memory).duplicate();
        int n3 = this.idx(n2);
        byteBuffer2.clear().position(n3).limit(n3 + byteBuffer.remaining());
        byteBuffer.put(byteBuffer2);
    }

    private void getBytes(int n2, byte[] arrby, int n3, int n4, boolean bl) {
        this.checkDstIndex(n2, n4, n3, arrby.length);
        ByteBuffer byteBuffer = bl ? this.internalNioBuffer() : ((ByteBuffer)this.memory).duplicate();
        int n5 = this.idx(n2);
        byteBuffer.clear().position(n5).limit(n5 + n4);
        byteBuffer.get(arrby, n3, n4);
    }

    static PooledDirectByteBuf newInstance(int n2) {
        PooledDirectByteBuf pooledDirectByteBuf = RECYCLER.get();
        pooledDirectByteBuf.reuse(n2);
        return pooledDirectByteBuf;
    }

    @Override
    protected final byte _getByte(int n2) {
        return ((ByteBuffer)this.memory).get(this.idx(n2));
    }

    @Override
    protected final int _getInt(int n2) {
        return ((ByteBuffer)this.memory).getInt(this.idx(n2));
    }

    @Override
    protected final long _getLong(int n2) {
        return ((ByteBuffer)this.memory).getLong(this.idx(n2));
    }

    @Override
    protected final short _getShort(int n2) {
        return ((ByteBuffer)this.memory).getShort(this.idx(n2));
    }

    @Override
    protected final int _getUnsignedMedium(int n2) {
        int n3 = this.idx(n2);
        return (255 & ((ByteBuffer)this.memory).get(n3)) << 16 | (255 & ((ByteBuffer)this.memory).get(n3 + 1)) << 8 | 255 & ((ByteBuffer)this.memory).get(n3 + 2);
    }

    @Override
    protected final void _setByte(int n2, int n3) {
        ((ByteBuffer)this.memory).put(this.idx(n2), (byte)n3);
    }

    @Override
    protected final void _setInt(int n2, int n3) {
        ((ByteBuffer)this.memory).putInt(this.idx(n2), n3);
    }

    @Override
    protected final void _setLong(int n2, long l2) {
        ((ByteBuffer)this.memory).putLong(this.idx(n2), l2);
    }

    @Override
    protected final void _setMedium(int n2, int n3) {
        int n4 = this.idx(n2);
        ((ByteBuffer)this.memory).put(n4, (byte)(n3 >>> 16));
        ((ByteBuffer)this.memory).put(n4 + 1, (byte)(n3 >>> 8));
        ((ByteBuffer)this.memory).put(n4 + 2, (byte)n3);
    }

    @Override
    protected final void _setShort(int n2, int n3) {
        ((ByteBuffer)this.memory).putShort(this.idx(n2), (short)n3);
    }

    public final byte[] array() {
        throw new UnsupportedOperationException("direct buffer");
    }

    public final int arrayOffset() {
        throw new UnsupportedOperationException("direct buffer");
    }

    public final ByteBuf copy(int n2, int n3) {
        this.checkIndex(n2, n3);
        ByteBuf byteBuf = this.alloc().directBuffer(n3, this.maxCapacity());
        byteBuf.writeBytes((ByteBuf)this, n2, n3);
        return byteBuf;
    }

    public final int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3) throws IOException {
        return PooledDirectByteBuf.super.getBytes(n2, gatheringByteChannel, n3, false);
    }

    public final ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.checkDstIndex(n2, n4, n3, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            this.getBytes(n2, byteBuf.array(), n3 + byteBuf.arrayOffset(), n4);
            return this;
        }
        if (byteBuf.nioBufferCount() > 0) {
            for (ByteBuffer byteBuffer : byteBuf.nioBuffers(n3, n4)) {
                int n5 = byteBuffer.remaining();
                this.getBytes(n2, byteBuffer);
                n2 += n5;
            }
        } else {
            byteBuf.setBytes(n3, (ByteBuf)this, n2, n4);
        }
        return this;
    }

    public final ByteBuf getBytes(int n2, OutputStream outputStream, int n3) throws IOException {
        PooledDirectByteBuf.super.getBytes(n2, outputStream, n3, false);
        return this;
    }

    public final ByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
        PooledDirectByteBuf.super.getBytes(n2, byteBuffer, false);
        return this;
    }

    public final ByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
        PooledDirectByteBuf.super.getBytes(n2, arrby, n3, n4, false);
        return this;
    }

    public final boolean hasArray() {
        return false;
    }

    public final boolean hasMemoryAddress() {
        return false;
    }

    public final ByteBuffer internalNioBuffer(int n2, int n3) {
        this.checkIndex(n2, n3);
        int n4 = this.idx(n2);
        return (ByteBuffer)this.internalNioBuffer().clear().position(n4).limit(n4 + n3);
    }

    public final boolean isDirect() {
        return true;
    }

    public final long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected final ByteBuffer newInternalNioBuffer(ByteBuffer byteBuffer) {
        return byteBuffer.duplicate();
    }

    public final ByteBuffer nioBuffer(int n2, int n3) {
        this.checkIndex(n2, n3);
        int n4 = this.idx(n2);
        return ((ByteBuffer)((ByteBuffer)this.memory).duplicate().position(n4).limit(n4 + n3)).slice();
    }

    public final int nioBufferCount() {
        return 1;
    }

    public final ByteBuffer[] nioBuffers(int n2, int n3) {
        ByteBuffer[] arrbyteBuffer = new ByteBuffer[]{this.nioBuffer(n2, n3)};
        return arrbyteBuffer;
    }

    @Override
    public final int readBytes(GatheringByteChannel gatheringByteChannel, int n2) throws IOException {
        this.checkReadableBytes(n2);
        int n3 = PooledDirectByteBuf.super.getBytes(this.readerIndex, gatheringByteChannel, n2, true);
        this.readerIndex = n3 + this.readerIndex;
        return n3;
    }

    @Override
    public final ByteBuf readBytes(OutputStream outputStream, int n2) throws IOException {
        this.checkReadableBytes(n2);
        PooledDirectByteBuf.super.getBytes(this.readerIndex, outputStream, n2, true);
        this.readerIndex = n2 + this.readerIndex;
        return this;
    }

    @Override
    public final ByteBuf readBytes(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.remaining();
        this.checkReadableBytes(n2);
        PooledDirectByteBuf.super.getBytes(this.readerIndex, byteBuffer, true);
        this.readerIndex = n2 + this.readerIndex;
        return this;
    }

    @Override
    public final ByteBuf readBytes(byte[] arrby, int n2, int n3) {
        this.checkReadableBytes(n3);
        PooledDirectByteBuf.super.getBytes(this.readerIndex, arrby, n2, n3, true);
        this.readerIndex = n3 + this.readerIndex;
        return this;
    }

    @Override
    protected final j<?> recycler() {
        return RECYCLER;
    }

    public final int setBytes(int n2, InputStream inputStream, int n3) throws IOException {
        this.checkIndex(n2, n3);
        byte[] arrby = new byte[n3];
        int n4 = inputStream.read(arrby);
        if (n4 <= 0) {
            return n4;
        }
        ByteBuffer byteBuffer = this.internalNioBuffer();
        byteBuffer.clear().position(this.idx(n2));
        byteBuffer.put(arrby, 0, n4);
        return n4;
    }

    public final int setBytes(int n2, ScatteringByteChannel scatteringByteChannel, int n3) throws IOException {
        this.checkIndex(n2, n3);
        ByteBuffer byteBuffer = this.internalNioBuffer();
        int n4 = this.idx(n2);
        byteBuffer.clear().position(n4).limit(n4 + n3);
        try {
            int n5 = scatteringByteChannel.read(byteBuffer);
            return n5;
        }
        catch (ClosedChannelException closedChannelException) {
            return -1;
        }
    }

    public final ByteBuf setBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.checkSrcIndex(n2, n4, n3, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            this.setBytes(n2, byteBuf.array(), n3 + byteBuf.arrayOffset(), n4);
            return this;
        }
        if (byteBuf.nioBufferCount() > 0) {
            for (ByteBuffer byteBuffer : byteBuf.nioBuffers(n3, n4)) {
                int n5 = byteBuffer.remaining();
                this.setBytes(n2, byteBuffer);
                n2 += n5;
            }
        } else {
            byteBuf.getBytes(n3, (ByteBuf)this, n2, n4);
        }
        return this;
    }

    public final ByteBuf setBytes(int n2, ByteBuffer byteBuffer) {
        this.checkIndex(n2, byteBuffer.remaining());
        ByteBuffer byteBuffer2 = this.internalNioBuffer();
        if (byteBuffer == byteBuffer2) {
            byteBuffer = byteBuffer.duplicate();
        }
        int n3 = this.idx(n2);
        byteBuffer2.clear().position(n3).limit(n3 + byteBuffer.remaining());
        byteBuffer2.put(byteBuffer);
        return this;
    }

    public final ByteBuf setBytes(int n2, byte[] arrby, int n3, int n4) {
        this.checkSrcIndex(n2, n4, n3, arrby.length);
        ByteBuffer byteBuffer = this.internalNioBuffer();
        int n5 = this.idx(n2);
        byteBuffer.clear().position(n5).limit(n5 + n4);
        byteBuffer.put(arrby, n3, n4);
        return this;
    }
}

