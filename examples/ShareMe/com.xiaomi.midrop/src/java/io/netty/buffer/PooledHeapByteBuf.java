/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.PooledHeapByteBuf$1
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.System
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
import io.netty.buffer.HeapByteBufUtil;
import io.netty.buffer.PooledByteBuf;
import io.netty.buffer.PooledHeapByteBuf;
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

class PooledHeapByteBuf
extends PooledByteBuf<byte[]> {
    private static final j<PooledHeapByteBuf> RECYCLER = new 1();

    PooledHeapByteBuf(j.b b2, int n2) {
        super(b2, n2);
    }

    private int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3, boolean bl) throws IOException {
        this.checkIndex(n2, n3);
        int n4 = this.idx(n2);
        ByteBuffer byteBuffer = bl ? this.internalNioBuffer() : ByteBuffer.wrap((byte[])((byte[])this.memory));
        return gatheringByteChannel.write((ByteBuffer)byteBuffer.clear().position(n4).limit(n4 + n3));
    }

    static PooledHeapByteBuf newInstance(int n2) {
        PooledHeapByteBuf pooledHeapByteBuf = RECYCLER.get();
        pooledHeapByteBuf.reuse(n2);
        return pooledHeapByteBuf;
    }

    @Override
    protected byte _getByte(int n2) {
        return HeapByteBufUtil.getByte((byte[])this.memory, this.idx(n2));
    }

    @Override
    protected int _getInt(int n2) {
        return HeapByteBufUtil.getInt((byte[])this.memory, this.idx(n2));
    }

    @Override
    protected long _getLong(int n2) {
        return HeapByteBufUtil.getLong((byte[])this.memory, this.idx(n2));
    }

    @Override
    protected short _getShort(int n2) {
        return HeapByteBufUtil.getShort((byte[])this.memory, this.idx(n2));
    }

    @Override
    protected int _getUnsignedMedium(int n2) {
        return HeapByteBufUtil.getUnsignedMedium((byte[])this.memory, this.idx(n2));
    }

    @Override
    protected void _setByte(int n2, int n3) {
        HeapByteBufUtil.setByte((byte[])this.memory, this.idx(n2), n3);
    }

    @Override
    protected void _setInt(int n2, int n3) {
        HeapByteBufUtil.setInt((byte[])this.memory, this.idx(n2), n3);
    }

    @Override
    protected void _setLong(int n2, long l2) {
        HeapByteBufUtil.setLong((byte[])this.memory, this.idx(n2), l2);
    }

    @Override
    protected void _setMedium(int n2, int n3) {
        HeapByteBufUtil.setMedium((byte[])this.memory, this.idx(n2), n3);
    }

    @Override
    protected void _setShort(int n2, int n3) {
        HeapByteBufUtil.setShort((byte[])this.memory, this.idx(n2), n3);
    }

    public final byte[] array() {
        this.ensureAccessible();
        return (byte[])this.memory;
    }

    public final int arrayOffset() {
        return this.offset;
    }

    public final ByteBuf copy(int n2, int n3) {
        this.checkIndex(n2, n3);
        ByteBuf byteBuf = this.alloc().heapBuffer(n3, this.maxCapacity());
        byteBuf.writeBytes((byte[])this.memory, this.idx(n2), n3);
        return byteBuf;
    }

    public final int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3) throws IOException {
        return PooledHeapByteBuf.super.getBytes(n2, gatheringByteChannel, n3, false);
    }

    public final ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.checkDstIndex(n2, n4, n3, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            n.a((byte[])this.memory, this.idx(n2), byteBuf.memoryAddress() + (long)n3, (long)n4);
            return this;
        }
        if (byteBuf.hasArray()) {
            this.getBytes(n2, byteBuf.array(), n3 + byteBuf.arrayOffset(), n4);
            return this;
        }
        byteBuf.setBytes(n3, (byte[])this.memory, this.idx(n2), n4);
        return this;
    }

    public final ByteBuf getBytes(int n2, OutputStream outputStream, int n3) throws IOException {
        this.checkIndex(n2, n3);
        outputStream.write((byte[])this.memory, this.idx(n2), n3);
        return this;
    }

    public final ByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
        this.checkIndex(n2, byteBuffer.remaining());
        byteBuffer.put((byte[])this.memory, this.idx(n2), byteBuffer.remaining());
        return this;
    }

    public final ByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
        this.checkDstIndex(n2, n4, n3, arrby.length);
        System.arraycopy((Object)this.memory, (int)this.idx(n2), (Object)arrby, (int)n3, (int)n4);
        return this;
    }

    public final boolean hasArray() {
        return true;
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
        return false;
    }

    public final long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected final ByteBuffer newInternalNioBuffer(byte[] arrby) {
        return ByteBuffer.wrap((byte[])arrby);
    }

    public final ByteBuffer nioBuffer(int n2, int n3) {
        this.checkIndex(n2, n3);
        int n4 = this.idx(n2);
        return ByteBuffer.wrap((byte[])((byte[])this.memory), (int)n4, (int)n3).slice();
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
        int n3 = PooledHeapByteBuf.super.getBytes(this.readerIndex, gatheringByteChannel, n2, true);
        this.readerIndex = n3 + this.readerIndex;
        return n3;
    }

    @Override
    protected j<?> recycler() {
        return RECYCLER;
    }

    public final int setBytes(int n2, InputStream inputStream, int n3) throws IOException {
        this.checkIndex(n2, n3);
        return inputStream.read((byte[])this.memory, this.idx(n2), n3);
    }

    public final int setBytes(int n2, ScatteringByteChannel scatteringByteChannel, int n3) throws IOException {
        this.checkIndex(n2, n3);
        int n4 = this.idx(n2);
        try {
            int n5 = scatteringByteChannel.read((ByteBuffer)this.internalNioBuffer().clear().position(n4).limit(n4 + n3));
            return n5;
        }
        catch (ClosedChannelException closedChannelException) {
            return -1;
        }
    }

    public final ByteBuf setBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.checkSrcIndex(n2, n4, n3, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            n.a(byteBuf.memoryAddress() + (long)n3, (byte[])this.memory, this.idx(n2), (long)n4);
            return this;
        }
        if (byteBuf.hasArray()) {
            this.setBytes(n2, byteBuf.array(), n3 + byteBuf.arrayOffset(), n4);
            return this;
        }
        byteBuf.getBytes(n3, (byte[])this.memory, this.idx(n2), n4);
        return this;
    }

    public final ByteBuf setBytes(int n2, ByteBuffer byteBuffer) {
        int n3 = byteBuffer.remaining();
        this.checkIndex(n2, n3);
        byteBuffer.get((byte[])this.memory, this.idx(n2), n3);
        return this;
    }

    public final ByteBuf setBytes(int n2, byte[] arrby, int n3, int n4) {
        this.checkSrcIndex(n2, n4, n3, arrby.length);
        System.arraycopy((Object)arrby, (int)n3, (Object)this.memory, (int)this.idx(n2), (int)n4);
        return this;
    }
}

