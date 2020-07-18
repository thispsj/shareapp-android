/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.ReadOnlyBufferException
 *  java.nio.channels.GatheringByteChannel
 *  java.nio.channels.ScatteringByteChannel
 */
package io.netty.buffer;

import io.netty.buffer.AbstractReferenceCountedByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.d.b.t;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

class ReadOnlyByteBufferBuf
extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator allocator;
    protected final ByteBuffer buffer;
    private ByteBuffer tmpNioBuf;

    ReadOnlyByteBufferBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer) {
        super(byteBuffer.remaining());
        if (!byteBuffer.isReadOnly()) {
            StringBuilder stringBuilder = new StringBuilder("must be a readonly buffer: ");
            stringBuilder.append(t.a((Object)byteBuffer));
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.allocator = byteBufAllocator;
        this.buffer = byteBuffer.slice().order(ByteOrder.BIG_ENDIAN);
        this.writerIndex(this.buffer.limit());
    }

    @Override
    protected byte _getByte(int n2) {
        return this.buffer.get(n2);
    }

    @Override
    protected int _getInt(int n2) {
        return this.buffer.getInt(n2);
    }

    @Override
    protected long _getLong(int n2) {
        return this.buffer.getLong(n2);
    }

    @Override
    protected short _getShort(int n2) {
        return this.buffer.getShort(n2);
    }

    @Override
    protected int _getUnsignedMedium(int n2) {
        return (255 & this.getByte(n2)) << 16 | (255 & this.getByte(n2 + 1)) << 8 | 255 & this.getByte(n2 + 2);
    }

    @Override
    protected void _setByte(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    @Override
    protected void _setInt(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    @Override
    protected void _setLong(int n2, long l2) {
        throw new ReadOnlyBufferException();
    }

    @Override
    protected void _setMedium(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    @Override
    protected void _setShort(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    public ByteBufAllocator alloc() {
        return this.allocator;
    }

    public byte[] array() {
        return this.buffer.array();
    }

    public int arrayOffset() {
        return this.buffer.arrayOffset();
    }

    public int capacity() {
        return this.maxCapacity();
    }

    public ByteBuf capacity(int n2) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf copy(int n2, int n3) {
        ByteBuffer byteBuffer;
        this.ensureAccessible();
        try {
            byteBuffer = (ByteBuffer)this.internalNioBuffer().clear().position(n2).limit(n2 + n3);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            StringBuilder stringBuilder = new StringBuilder("Too many bytes to read - Need ");
            stringBuilder.append(n2 + n3);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        ByteBuf byteBuf = byteBuffer.isDirect() ? this.alloc().directBuffer(n3) : this.alloc().heapBuffer(n3);
        byteBuf.writeBytes(byteBuffer);
        return byteBuf;
    }

    @Override
    protected void deallocate() {
    }

    @Override
    public byte getByte(int n2) {
        this.ensureAccessible();
        return this._getByte(n2);
    }

    public int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3) throws IOException {
        this.ensureAccessible();
        if (n3 == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = this.internalNioBuffer();
        byteBuffer.clear().position(n2).limit(n2 + n3);
        return gatheringByteChannel.write(byteBuffer);
    }

    public ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
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

    public ByteBuf getBytes(int n2, OutputStream outputStream, int n3) throws IOException {
        this.ensureAccessible();
        if (n3 == 0) {
            return this;
        }
        if (this.buffer.hasArray()) {
            outputStream.write(this.buffer.array(), n2 + this.buffer.arrayOffset(), n3);
            return this;
        }
        byte[] arrby = new byte[n3];
        ByteBuffer byteBuffer = this.internalNioBuffer();
        byteBuffer.clear().position(n2);
        byteBuffer.get(arrby);
        outputStream.write(arrby);
        return this;
    }

    public ByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
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

    public ByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
        this.checkDstIndex(n2, n4, n3, arrby.length);
        if (n3 >= 0 && n3 <= arrby.length - n4) {
            ByteBuffer byteBuffer = this.internalNioBuffer();
            byteBuffer.clear().position(n2).limit(n2 + n4);
            byteBuffer.get(arrby, n3, n4);
            return this;
        }
        Object[] arrobject = new Object[]{n3, n4, arrby.length};
        throw new IndexOutOfBoundsException(String.format((String)"dstIndex: %d, length: %d (expected: range(0, %d))", (Object[])arrobject));
    }

    @Override
    public int getInt(int n2) {
        this.ensureAccessible();
        return this._getInt(n2);
    }

    @Override
    public long getLong(int n2) {
        this.ensureAccessible();
        return this._getLong(n2);
    }

    @Override
    public short getShort(int n2) {
        this.ensureAccessible();
        return this._getShort(n2);
    }

    @Override
    public int getUnsignedMedium(int n2) {
        this.ensureAccessible();
        return this._getUnsignedMedium(n2);
    }

    public boolean hasArray() {
        return this.buffer.hasArray();
    }

    public boolean hasMemoryAddress() {
        return false;
    }

    protected final ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer == null) {
            this.tmpNioBuf = byteBuffer = this.buffer.duplicate();
        }
        return byteBuffer;
    }

    public ByteBuffer internalNioBuffer(int n2, int n3) {
        this.ensureAccessible();
        return (ByteBuffer)this.internalNioBuffer().clear().position(n2).limit(n2 + n3);
    }

    public boolean isDirect() {
        return this.buffer.isDirect();
    }

    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    public ByteBuffer nioBuffer(int n2, int n3) {
        return (ByteBuffer)this.buffer.duplicate().position(n2).limit(n2 + n3);
    }

    public int nioBufferCount() {
        return 1;
    }

    public ByteBuffer[] nioBuffers(int n2, int n3) {
        ByteBuffer[] arrbyteBuffer = new ByteBuffer[]{this.nioBuffer(n2, n3)};
        return arrbyteBuffer;
    }

    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override
    public ByteBuf setByte(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    public int setBytes(int n2, InputStream inputStream, int n3) throws IOException {
        throw new ReadOnlyBufferException();
    }

    public int setBytes(int n2, ScatteringByteChannel scatteringByteChannel, int n3) throws IOException {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf setBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf setBytes(int n2, ByteBuffer byteBuffer) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf setBytes(int n2, byte[] arrby, int n3, int n4) {
        throw new ReadOnlyBufferException();
    }

    @Override
    public ByteBuf setInt(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    @Override
    public ByteBuf setLong(int n2, long l2) {
        throw new ReadOnlyBufferException();
    }

    @Override
    public ByteBuf setMedium(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    @Override
    public ByteBuf setShort(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf unwrap() {
        return null;
    }
}

