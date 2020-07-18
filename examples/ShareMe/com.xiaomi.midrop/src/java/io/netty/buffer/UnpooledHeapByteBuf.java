/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.UnsupportedOperationException
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.ClosedChannelException
 *  java.nio.channels.GatheringByteChannel
 *  java.nio.channels.ScatteringByteChannel
 */
package io.netty.buffer;

import io.netty.buffer.AbstractReferenceCountedByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.HeapByteBufUtil;
import io.netty.d.b.l;
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

public class UnpooledHeapByteBuf
extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator alloc;
    byte[] array;
    private ByteBuffer tmpNioBuf;

    public UnpooledHeapByteBuf(ByteBufAllocator byteBufAllocator, int n2, int n3) {
        super(n3);
        l.a(byteBufAllocator, "alloc");
        if (n2 > n3) {
            Object[] arrobject = new Object[]{n2, n3};
            throw new IllegalArgumentException(String.format((String)"initialCapacity(%d) > maxCapacity(%d)", (Object[])arrobject));
        }
        this.alloc = byteBufAllocator;
        UnpooledHeapByteBuf.super.setArray(this.allocateArray(n2));
        this.setIndex(0, 0);
    }

    protected UnpooledHeapByteBuf(ByteBufAllocator byteBufAllocator, byte[] arrby, int n2) {
        super(n2);
        l.a(byteBufAllocator, "alloc");
        l.a(arrby, "initialArray");
        if (arrby.length > n2) {
            Object[] arrobject = new Object[]{arrby.length, n2};
            throw new IllegalArgumentException(String.format((String)"initialCapacity(%d) > maxCapacity(%d)", (Object[])arrobject));
        }
        this.alloc = byteBufAllocator;
        UnpooledHeapByteBuf.super.setArray(arrby);
        this.setIndex(0, arrby.length);
    }

    private int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3, boolean bl) throws IOException {
        this.ensureAccessible();
        ByteBuffer byteBuffer = bl ? UnpooledHeapByteBuf.super.internalNioBuffer() : ByteBuffer.wrap((byte[])this.array);
        return gatheringByteChannel.write((ByteBuffer)byteBuffer.clear().position(n2).limit(n2 + n3));
    }

    private ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer == null) {
            this.tmpNioBuf = byteBuffer = ByteBuffer.wrap((byte[])this.array);
        }
        return byteBuffer;
    }

    private void setArray(byte[] arrby) {
        this.array = arrby;
        this.tmpNioBuf = null;
    }

    @Override
    protected byte _getByte(int n2) {
        return HeapByteBufUtil.getByte(this.array, n2);
    }

    @Override
    protected int _getInt(int n2) {
        return HeapByteBufUtil.getInt(this.array, n2);
    }

    @Override
    protected long _getLong(int n2) {
        return HeapByteBufUtil.getLong(this.array, n2);
    }

    @Override
    protected short _getShort(int n2) {
        return HeapByteBufUtil.getShort(this.array, n2);
    }

    @Override
    protected int _getUnsignedMedium(int n2) {
        return HeapByteBufUtil.getUnsignedMedium(this.array, n2);
    }

    @Override
    protected void _setByte(int n2, int n3) {
        HeapByteBufUtil.setByte(this.array, n2, n3);
    }

    @Override
    protected void _setInt(int n2, int n3) {
        HeapByteBufUtil.setInt(this.array, n2, n3);
    }

    @Override
    protected void _setLong(int n2, long l2) {
        HeapByteBufUtil.setLong(this.array, n2, l2);
    }

    @Override
    protected void _setMedium(int n2, int n3) {
        HeapByteBufUtil.setMedium(this.array, n2, n3);
    }

    @Override
    protected void _setShort(int n2, int n3) {
        HeapByteBufUtil.setShort(this.array, n2, n3);
    }

    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    byte[] allocateArray(int n2) {
        return new byte[n2];
    }

    public byte[] array() {
        this.ensureAccessible();
        return this.array;
    }

    public int arrayOffset() {
        return 0;
    }

    public int capacity() {
        this.ensureAccessible();
        return this.array.length;
    }

    public ByteBuf capacity(int n2) {
        block9 : {
            byte[] arrby;
            byte[] arrby2;
            block8 : {
                int n3;
                block7 : {
                    this.checkNewCapacity(n2);
                    n3 = this.array.length;
                    arrby = this.array;
                    if (n2 <= n3) break block7;
                    arrby2 = this.allocateArray(n2);
                    System.arraycopy((Object)arrby, (int)0, (Object)arrby2, (int)0, (int)arrby.length);
                    break block8;
                }
                if (n2 >= n3) break block9;
                byte[] arrby3 = this.allocateArray(n2);
                int n4 = this.readerIndex();
                if (n4 < n2) {
                    int n5 = this.writerIndex();
                    if (n5 > n2) {
                        this.writerIndex(n2);
                    } else {
                        n2 = n5;
                    }
                    System.arraycopy((Object)arrby, (int)n4, (Object)arrby3, (int)n4, (int)(n2 - n4));
                } else {
                    this.setIndex(n2, n2);
                }
                arrby2 = arrby3;
            }
            UnpooledHeapByteBuf.super.setArray(arrby2);
            this.freeArray(arrby);
        }
        return this;
    }

    public ByteBuf copy(int n2, int n3) {
        this.checkIndex(n2, n3);
        byte[] arrby = new byte[n3];
        System.arraycopy((Object)this.array, (int)n2, (Object)arrby, (int)0, (int)n3);
        return new UnpooledHeapByteBuf(this.alloc(), arrby, this.maxCapacity());
    }

    @Override
    protected void deallocate() {
        this.freeArray(this.array);
        this.array = null;
    }

    void freeArray(byte[] arrby) {
    }

    @Override
    public byte getByte(int n2) {
        this.ensureAccessible();
        return this._getByte(n2);
    }

    public int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3) throws IOException {
        this.ensureAccessible();
        return UnpooledHeapByteBuf.super.getBytes(n2, gatheringByteChannel, n3, false);
    }

    public ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.checkDstIndex(n2, n4, n3, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            n.a(this.array, n2, byteBuf.memoryAddress() + (long)n3, (long)n4);
            return this;
        }
        if (byteBuf.hasArray()) {
            this.getBytes(n2, byteBuf.array(), n3 + byteBuf.arrayOffset(), n4);
            return this;
        }
        byteBuf.setBytes(n3, this.array, n2, n4);
        return this;
    }

    public ByteBuf getBytes(int n2, OutputStream outputStream, int n3) throws IOException {
        this.ensureAccessible();
        outputStream.write(this.array, n2, n3);
        return this;
    }

    public ByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
        this.checkIndex(n2, byteBuffer.remaining());
        byteBuffer.put(this.array, n2, byteBuffer.remaining());
        return this;
    }

    public ByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
        this.checkDstIndex(n2, n4, n3, arrby.length);
        System.arraycopy((Object)this.array, (int)n2, (Object)arrby, (int)n3, (int)n4);
        return this;
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
        return true;
    }

    public boolean hasMemoryAddress() {
        return false;
    }

    public ByteBuffer internalNioBuffer(int n2, int n3) {
        this.checkIndex(n2, n3);
        return (ByteBuffer)UnpooledHeapByteBuf.super.internalNioBuffer().clear().position(n2).limit(n2 + n3);
    }

    public boolean isDirect() {
        return false;
    }

    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    public ByteBuffer nioBuffer(int n2, int n3) {
        this.ensureAccessible();
        return ByteBuffer.wrap((byte[])this.array, (int)n2, (int)n3).slice();
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
        int n3 = UnpooledHeapByteBuf.super.getBytes(this.readerIndex, gatheringByteChannel, n2, true);
        this.readerIndex = n3 + this.readerIndex;
        return n3;
    }

    @Override
    public ByteBuf setByte(int n2, int n3) {
        this.ensureAccessible();
        this._setByte(n2, n3);
        return this;
    }

    public int setBytes(int n2, InputStream inputStream, int n3) throws IOException {
        this.ensureAccessible();
        return inputStream.read(this.array, n2, n3);
    }

    public int setBytes(int n2, ScatteringByteChannel scatteringByteChannel, int n3) throws IOException {
        this.ensureAccessible();
        try {
            int n4 = scatteringByteChannel.read((ByteBuffer)UnpooledHeapByteBuf.super.internalNioBuffer().clear().position(n2).limit(n2 + n3));
            return n4;
        }
        catch (ClosedChannelException closedChannelException) {
            return -1;
        }
    }

    public ByteBuf setBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.checkSrcIndex(n2, n4, n3, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            n.a(byteBuf.memoryAddress() + (long)n3, this.array, n2, (long)n4);
            return this;
        }
        if (byteBuf.hasArray()) {
            this.setBytes(n2, byteBuf.array(), n3 + byteBuf.arrayOffset(), n4);
            return this;
        }
        byteBuf.getBytes(n3, this.array, n2, n4);
        return this;
    }

    public ByteBuf setBytes(int n2, ByteBuffer byteBuffer) {
        this.ensureAccessible();
        byteBuffer.get(this.array, n2, byteBuffer.remaining());
        return this;
    }

    public ByteBuf setBytes(int n2, byte[] arrby, int n3, int n4) {
        this.checkSrcIndex(n2, n4, n3, arrby.length);
        System.arraycopy((Object)arrby, (int)n3, (Object)this.array, (int)n2, (int)n4);
        return this;
    }

    @Override
    public ByteBuf setInt(int n2, int n3) {
        this.ensureAccessible();
        this._setInt(n2, n3);
        return this;
    }

    @Override
    public ByteBuf setLong(int n2, long l2) {
        this.ensureAccessible();
        this._setLong(n2, l2);
        return this;
    }

    @Override
    public ByteBuf setMedium(int n2, int n3) {
        this.ensureAccessible();
        this._setMedium(n2, n3);
        return this;
    }

    @Override
    public ByteBuf setShort(int n2, int n3) {
        this.ensureAccessible();
        this._setShort(n2, n3);
        return this;
    }

    public ByteBuf unwrap() {
        return null;
    }
}

