/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.ClosedChannelException
 *  java.nio.channels.GatheringByteChannel
 *  java.nio.channels.ScatteringByteChannel
 */
package io.netty.buffer;

import io.netty.buffer.AbstractByteBuf;
import io.netty.buffer.AbstractReferenceCountedByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.SwappedByteBuf;
import io.netty.buffer.UnsafeByteBufUtil;
import io.netty.buffer.UnsafeDirectSwappedByteBuf;
import io.netty.d.b.n;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

public class UnpooledUnsafeDirectByteBuf
extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator alloc;
    ByteBuffer buffer;
    private int capacity;
    private boolean doNotFree;
    long memoryAddress;
    private ByteBuffer tmpNioBuf;

    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, int n2, int n3) {
        super(n3);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        if (n2 < 0) {
            StringBuilder stringBuilder = new StringBuilder("initialCapacity: ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n3 < 0) {
            StringBuilder stringBuilder = new StringBuilder("maxCapacity: ");
            stringBuilder.append(n3);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n2 > n3) {
            Object[] arrobject = new Object[]{n2, n3};
            throw new IllegalArgumentException(String.format((String)"initialCapacity(%d) > maxCapacity(%d)", (Object[])arrobject));
        }
        this.alloc = byteBufAllocator;
        this.setByteBuffer(this.allocateDirect(n2), false);
    }

    protected UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int n2) {
        super(byteBufAllocator, byteBuffer.slice(), n2, false);
    }

    UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int n2, boolean bl) {
        super(n2);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        if (byteBuffer == null) {
            throw new NullPointerException("initialBuffer");
        }
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("initialBuffer is not a direct buffer.");
        }
        if (byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("initialBuffer is a read-only buffer.");
        }
        int n3 = byteBuffer.remaining();
        if (n3 > n2) {
            Object[] arrobject = new Object[]{n3, n2};
            throw new IllegalArgumentException(String.format((String)"initialCapacity(%d) > maxCapacity(%d)", (Object[])arrobject));
        }
        this.alloc = byteBufAllocator;
        this.doNotFree = bl ^ true;
        this.setByteBuffer(byteBuffer.order(ByteOrder.BIG_ENDIAN), false);
        this.writerIndex(n3);
    }

    private int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3, boolean bl) throws IOException {
        this.ensureAccessible();
        if (n3 == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = bl ? UnpooledUnsafeDirectByteBuf.super.internalNioBuffer() : this.buffer.duplicate();
        byteBuffer.clear().position(n2).limit(n2 + n3);
        return gatheringByteChannel.write(byteBuffer);
    }

    private ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer == null) {
            this.tmpNioBuf = byteBuffer = this.buffer.duplicate();
        }
        return byteBuffer;
    }

    @Override
    protected byte _getByte(int n2) {
        return UnsafeByteBufUtil.getByte(this.addr(n2));
    }

    @Override
    protected int _getInt(int n2) {
        return UnsafeByteBufUtil.getInt(this.addr(n2));
    }

    @Override
    protected long _getLong(int n2) {
        return UnsafeByteBufUtil.getLong(this.addr(n2));
    }

    @Override
    protected short _getShort(int n2) {
        return UnsafeByteBufUtil.getShort(this.addr(n2));
    }

    @Override
    protected int _getUnsignedMedium(int n2) {
        return UnsafeByteBufUtil.getUnsignedMedium(this.addr(n2));
    }

    @Override
    protected void _setByte(int n2, int n3) {
        UnsafeByteBufUtil.setByte(this.addr(n2), n3);
    }

    @Override
    protected void _setInt(int n2, int n3) {
        UnsafeByteBufUtil.setInt(this.addr(n2), n3);
    }

    @Override
    protected void _setLong(int n2, long l2) {
        UnsafeByteBufUtil.setLong(this.addr(n2), l2);
    }

    @Override
    protected void _setMedium(int n2, int n3) {
        UnsafeByteBufUtil.setMedium(this.addr(n2), n3);
    }

    @Override
    protected void _setShort(int n2, int n3) {
        UnsafeByteBufUtil.setShort(this.addr(n2), n3);
    }

    long addr(int n2) {
        return this.memoryAddress + (long)n2;
    }

    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    protected ByteBuffer allocateDirect(int n2) {
        return ByteBuffer.allocateDirect((int)n2);
    }

    public byte[] array() {
        throw new UnsupportedOperationException("direct buffer");
    }

    public int arrayOffset() {
        throw new UnsupportedOperationException("direct buffer");
    }

    public int capacity() {
        return this.capacity;
    }

    public ByteBuf capacity(int n2) {
        block9 : {
            ByteBuffer byteBuffer;
            block8 : {
                int n3;
                int n4;
                int n5;
                block7 : {
                    this.checkNewCapacity(n2);
                    n5 = this.readerIndex();
                    n4 = this.writerIndex();
                    n3 = this.capacity;
                    if (n2 <= n3) break block7;
                    ByteBuffer byteBuffer2 = this.buffer;
                    byteBuffer = this.allocateDirect(n2);
                    byteBuffer2.position(0).limit(byteBuffer2.capacity());
                    byteBuffer.position(0).limit(byteBuffer2.capacity());
                    byteBuffer.put(byteBuffer2);
                    byteBuffer.clear();
                    break block8;
                }
                if (n2 >= n3) break block9;
                ByteBuffer byteBuffer3 = this.buffer;
                ByteBuffer byteBuffer4 = this.allocateDirect(n2);
                if (n5 < n2) {
                    if (n4 > n2) {
                        this.writerIndex(n2);
                    } else {
                        n2 = n4;
                    }
                    byteBuffer3.position(n5).limit(n2);
                    byteBuffer4.position(n5).limit(n2);
                    byteBuffer4.put(byteBuffer3);
                    byteBuffer4.clear();
                } else {
                    this.setIndex(n2, n2);
                }
                byteBuffer = byteBuffer4;
            }
            this.setByteBuffer(byteBuffer, true);
        }
        return this;
    }

    public ByteBuf copy(int n2, int n3) {
        return UnsafeByteBufUtil.copy((AbstractByteBuf)this, this.addr(n2), n2, n3);
    }

    @Override
    protected void deallocate() {
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer == null) {
            return;
        }
        this.buffer = null;
        if (!this.doNotFree) {
            this.freeDirect(byteBuffer);
        }
    }

    protected void freeDirect(ByteBuffer byteBuffer) {
        n.a(byteBuffer);
    }

    public int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3) throws IOException {
        return UnpooledUnsafeDirectByteBuf.super.getBytes(n2, gatheringByteChannel, n3, false);
    }

    public ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        UnsafeByteBufUtil.getBytes((AbstractByteBuf)this, this.addr(n2), n2, byteBuf, n3, n4);
        return this;
    }

    public ByteBuf getBytes(int n2, OutputStream outputStream, int n3) throws IOException {
        UnsafeByteBufUtil.getBytes((AbstractByteBuf)this, this.addr(n2), n2, outputStream, n3);
        return this;
    }

    public ByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
        UnsafeByteBufUtil.getBytes((AbstractByteBuf)this, this.addr(n2), n2, byteBuffer);
        return this;
    }

    public ByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
        UnsafeByteBufUtil.getBytes((AbstractByteBuf)this, this.addr(n2), n2, arrby, n3, n4);
        return this;
    }

    public boolean hasArray() {
        return false;
    }

    public boolean hasMemoryAddress() {
        return true;
    }

    public ByteBuffer internalNioBuffer(int n2, int n3) {
        this.checkIndex(n2, n3);
        return (ByteBuffer)UnpooledUnsafeDirectByteBuf.super.internalNioBuffer().clear().position(n2).limit(n2 + n3);
    }

    public boolean isDirect() {
        return true;
    }

    public long memoryAddress() {
        this.ensureAccessible();
        return this.memoryAddress;
    }

    @Override
    protected SwappedByteBuf newSwappedByteBuf() {
        if (n.g()) {
            return new UnsafeDirectSwappedByteBuf(this);
        }
        return super.newSwappedByteBuf();
    }

    public ByteBuffer nioBuffer(int n2, int n3) {
        this.checkIndex(n2, n3);
        return ((ByteBuffer)this.buffer.duplicate().position(n2).limit(n2 + n3)).slice();
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
    public int readBytes(GatheringByteChannel gatheringByteChannel, int n2) throws IOException {
        this.checkReadableBytes(n2);
        int n3 = UnpooledUnsafeDirectByteBuf.super.getBytes(this.readerIndex, gatheringByteChannel, n2, true);
        this.readerIndex = n3 + this.readerIndex;
        return n3;
    }

    @Override
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.remaining();
        this.checkReadableBytes(n2);
        this.getBytes(this.readerIndex, byteBuffer);
        this.readerIndex = n2 + this.readerIndex;
        return this;
    }

    final void setByteBuffer(ByteBuffer byteBuffer, boolean bl) {
        ByteBuffer byteBuffer2;
        if (bl && (byteBuffer2 = this.buffer) != null) {
            if (this.doNotFree) {
                this.doNotFree = false;
            } else {
                this.freeDirect(byteBuffer2);
            }
        }
        this.buffer = byteBuffer;
        this.memoryAddress = n.b(byteBuffer);
        this.tmpNioBuf = null;
        this.capacity = byteBuffer.remaining();
    }

    public int setBytes(int n2, InputStream inputStream, int n3) throws IOException {
        return UnsafeByteBufUtil.setBytes((AbstractByteBuf)this, this.addr(n2), n2, inputStream, n3);
    }

    public int setBytes(int n2, ScatteringByteChannel scatteringByteChannel, int n3) throws IOException {
        this.ensureAccessible();
        ByteBuffer byteBuffer = UnpooledUnsafeDirectByteBuf.super.internalNioBuffer();
        byteBuffer.clear().position(n2).limit(n2 + n3);
        try {
            int n4 = scatteringByteChannel.read(byteBuffer);
            return n4;
        }
        catch (ClosedChannelException closedChannelException) {
            return -1;
        }
    }

    public ByteBuf setBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        UnsafeByteBufUtil.setBytes((AbstractByteBuf)this, this.addr(n2), n2, byteBuf, n3, n4);
        return this;
    }

    public ByteBuf setBytes(int n2, ByteBuffer byteBuffer) {
        UnsafeByteBufUtil.setBytes((AbstractByteBuf)this, this.addr(n2), n2, byteBuffer);
        return this;
    }

    public ByteBuf setBytes(int n2, byte[] arrby, int n3, int n4) {
        UnsafeByteBufUtil.setBytes((AbstractByteBuf)this, this.addr(n2), n2, arrby, n3, n4);
        return this;
    }

    @Override
    public ByteBuf setZero(int n2, int n3) {
        this.checkIndex(n2, n3);
        UnsafeByteBufUtil.setZero(this.addr(n2), n3);
        return this;
    }

    public ByteBuf unwrap() {
        return null;
    }

    @Override
    public ByteBuf writeZero(int n2) {
        this.ensureWritable(n2);
        int n3 = this.writerIndex;
        UnsafeByteBufUtil.setZero(this.addr(n3), n2);
        this.writerIndex = n3 + n2;
        return this;
    }
}

