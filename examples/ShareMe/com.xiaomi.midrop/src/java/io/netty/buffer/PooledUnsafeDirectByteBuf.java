/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.PoolChunk
 *  io.netty.buffer.PooledUnsafeDirectByteBuf$1
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

import io.netty.buffer.AbstractByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PoolChunk;
import io.netty.buffer.PoolThreadCache;
import io.netty.buffer.PooledByteBuf;
import io.netty.buffer.PooledUnsafeDirectByteBuf;
import io.netty.buffer.SwappedByteBuf;
import io.netty.buffer.UnsafeByteBufUtil;
import io.netty.buffer.UnsafeDirectSwappedByteBuf;
import io.netty.d.b.n;
import io.netty.d.j;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

final class PooledUnsafeDirectByteBuf
extends PooledByteBuf<ByteBuffer> {
    private static final j<PooledUnsafeDirectByteBuf> RECYCLER = new 1();
    private long memoryAddress;

    private PooledUnsafeDirectByteBuf(j.b b2, int n2) {
        super(b2, n2);
    }

    /* synthetic */ PooledUnsafeDirectByteBuf(j.b b2, int n2, 1 var3_2) {
        super(b2, n2);
    }

    private long addr(int n2) {
        return this.memoryAddress + (long)n2;
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

    private void initMemoryAddress() {
        this.memoryAddress = n.b((ByteBuffer)this.memory) + (long)this.offset;
    }

    static PooledUnsafeDirectByteBuf newInstance(int n2) {
        PooledUnsafeDirectByteBuf pooledUnsafeDirectByteBuf = RECYCLER.get();
        pooledUnsafeDirectByteBuf.reuse(n2);
        return pooledUnsafeDirectByteBuf;
    }

    @Override
    protected final byte _getByte(int n2) {
        return UnsafeByteBufUtil.getByte(PooledUnsafeDirectByteBuf.super.addr(n2));
    }

    @Override
    protected final int _getInt(int n2) {
        return UnsafeByteBufUtil.getInt(PooledUnsafeDirectByteBuf.super.addr(n2));
    }

    @Override
    protected final long _getLong(int n2) {
        return UnsafeByteBufUtil.getLong(PooledUnsafeDirectByteBuf.super.addr(n2));
    }

    @Override
    protected final short _getShort(int n2) {
        return UnsafeByteBufUtil.getShort(PooledUnsafeDirectByteBuf.super.addr(n2));
    }

    @Override
    protected final int _getUnsignedMedium(int n2) {
        return UnsafeByteBufUtil.getUnsignedMedium(PooledUnsafeDirectByteBuf.super.addr(n2));
    }

    @Override
    protected final void _setByte(int n2, int n3) {
        UnsafeByteBufUtil.setByte(PooledUnsafeDirectByteBuf.super.addr(n2), (byte)n3);
    }

    @Override
    protected final void _setInt(int n2, int n3) {
        UnsafeByteBufUtil.setInt(PooledUnsafeDirectByteBuf.super.addr(n2), n3);
    }

    @Override
    protected final void _setLong(int n2, long l2) {
        UnsafeByteBufUtil.setLong(PooledUnsafeDirectByteBuf.super.addr(n2), l2);
    }

    @Override
    protected final void _setMedium(int n2, int n3) {
        UnsafeByteBufUtil.setMedium(PooledUnsafeDirectByteBuf.super.addr(n2), n3);
    }

    @Override
    protected final void _setShort(int n2, int n3) {
        UnsafeByteBufUtil.setShort(PooledUnsafeDirectByteBuf.super.addr(n2), n3);
    }

    public final byte[] array() {
        throw new UnsupportedOperationException("direct buffer");
    }

    public final int arrayOffset() {
        throw new UnsupportedOperationException("direct buffer");
    }

    public final ByteBuf copy(int n2, int n3) {
        return UnsafeByteBufUtil.copy((AbstractByteBuf)this, PooledUnsafeDirectByteBuf.super.addr(n2), n2, n3);
    }

    public final int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3) throws IOException {
        return PooledUnsafeDirectByteBuf.super.getBytes(n2, gatheringByteChannel, n3, false);
    }

    public final ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        UnsafeByteBufUtil.getBytes((AbstractByteBuf)this, PooledUnsafeDirectByteBuf.super.addr(n2), n2, byteBuf, n3, n4);
        return this;
    }

    public final ByteBuf getBytes(int n2, OutputStream outputStream, int n3) throws IOException {
        UnsafeByteBufUtil.getBytes((AbstractByteBuf)this, PooledUnsafeDirectByteBuf.super.addr(n2), n2, outputStream, n3);
        return this;
    }

    public final ByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
        UnsafeByteBufUtil.getBytes((AbstractByteBuf)this, PooledUnsafeDirectByteBuf.super.addr(n2), n2, byteBuffer);
        return this;
    }

    public final ByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
        UnsafeByteBufUtil.getBytes((AbstractByteBuf)this, PooledUnsafeDirectByteBuf.super.addr(n2), n2, arrby, n3, n4);
        return this;
    }

    public final boolean hasArray() {
        return false;
    }

    public final boolean hasMemoryAddress() {
        return true;
    }

    @Override
    final void init(PoolChunk<ByteBuffer> poolChunk, long l2, int n2, int n3, int n4, PoolThreadCache poolThreadCache) {
        super.init(poolChunk, l2, n2, n3, n4, poolThreadCache);
        this.initMemoryAddress();
    }

    @Override
    final void initUnpooled(PoolChunk<ByteBuffer> poolChunk, int n2) {
        super.initUnpooled(poolChunk, n2);
        PooledUnsafeDirectByteBuf.super.initMemoryAddress();
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
        this.ensureAccessible();
        return this.memoryAddress;
    }

    @Override
    protected final ByteBuffer newInternalNioBuffer(ByteBuffer byteBuffer) {
        return byteBuffer.duplicate();
    }

    @Override
    protected final SwappedByteBuf newSwappedByteBuf() {
        if (n.g()) {
            return new UnsafeDirectSwappedByteBuf(this);
        }
        return super.newSwappedByteBuf();
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
        int n3 = PooledUnsafeDirectByteBuf.super.getBytes(this.readerIndex, gatheringByteChannel, n2, true);
        this.readerIndex = n3 + this.readerIndex;
        return n3;
    }

    @Override
    public final ByteBuf readBytes(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.remaining();
        this.checkReadableBytes(n2);
        this.getBytes(this.readerIndex, byteBuffer);
        this.readerIndex = n2 + this.readerIndex;
        return this;
    }

    @Override
    protected final j<?> recycler() {
        return RECYCLER;
    }

    public final int setBytes(int n2, InputStream inputStream, int n3) throws IOException {
        return UnsafeByteBufUtil.setBytes((AbstractByteBuf)this, PooledUnsafeDirectByteBuf.super.addr(n2), n2, inputStream, n3);
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
        UnsafeByteBufUtil.setBytes((AbstractByteBuf)this, PooledUnsafeDirectByteBuf.super.addr(n2), n2, byteBuf, n3, n4);
        return this;
    }

    public final ByteBuf setBytes(int n2, ByteBuffer byteBuffer) {
        UnsafeByteBufUtil.setBytes((AbstractByteBuf)this, PooledUnsafeDirectByteBuf.super.addr(n2), n2, byteBuffer);
        return this;
    }

    public final ByteBuf setBytes(int n2, byte[] arrby, int n3, int n4) {
        UnsafeByteBufUtil.setBytes((AbstractByteBuf)this, PooledUnsafeDirectByteBuf.super.addr(n2), n2, arrby, n3, n4);
        return this;
    }

    @Override
    public final ByteBuf setZero(int n2, int n3) {
        this.checkIndex(n2, n3);
        UnsafeByteBufUtil.setZero(PooledUnsafeDirectByteBuf.super.addr(n2), n3);
        return this;
    }

    @Override
    public final ByteBuf writeZero(int n2) {
        this.ensureWritable(n2);
        int n3 = this.writerIndex;
        UnsafeByteBufUtil.setZero(PooledUnsafeDirectByteBuf.super.addr(n3), n2);
        this.writerIndex = n3 + n2;
        return this;
    }
}

