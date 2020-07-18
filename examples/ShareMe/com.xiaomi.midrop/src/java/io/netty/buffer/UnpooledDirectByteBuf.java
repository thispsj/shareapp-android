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

import io.netty.buffer.AbstractReferenceCountedByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
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

public class UnpooledDirectByteBuf
extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator alloc;
    private ByteBuffer buffer;
    private int capacity;
    private boolean doNotFree;
    private ByteBuffer tmpNioBuf;

    public UnpooledDirectByteBuf(ByteBufAllocator byteBufAllocator, int n2, int n3) {
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
        UnpooledDirectByteBuf.super.setByteBuffer(ByteBuffer.allocateDirect((int)n2));
    }

    protected UnpooledDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int n2) {
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
        this.doNotFree = true;
        UnpooledDirectByteBuf.super.setByteBuffer(byteBuffer.slice().order(ByteOrder.BIG_ENDIAN));
        this.writerIndex(n3);
    }

    private int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3, boolean bl) throws IOException {
        this.ensureAccessible();
        if (n3 == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = bl ? UnpooledDirectByteBuf.super.internalNioBuffer() : this.buffer.duplicate();
        byteBuffer.clear().position(n2).limit(n2 + n3);
        return gatheringByteChannel.write(byteBuffer);
    }

    private void getBytes(int n2, OutputStream outputStream, int n3, boolean bl) throws IOException {
        this.ensureAccessible();
        if (n3 == 0) {
            return;
        }
        if (this.buffer.hasArray()) {
            outputStream.write(this.buffer.array(), n2 + this.buffer.arrayOffset(), n3);
            return;
        }
        byte[] arrby = new byte[n3];
        ByteBuffer byteBuffer = bl ? UnpooledDirectByteBuf.super.internalNioBuffer() : this.buffer.duplicate();
        byteBuffer.clear().position(n2);
        byteBuffer.get(arrby);
        outputStream.write(arrby);
    }

    private void getBytes(int n2, ByteBuffer byteBuffer, boolean bl) {
        this.checkIndex(n2, byteBuffer.remaining());
        ByteBuffer byteBuffer2 = bl ? UnpooledDirectByteBuf.super.internalNioBuffer() : this.buffer.duplicate();
        byteBuffer2.clear().position(n2).limit(n2 + byteBuffer.remaining());
        byteBuffer.put(byteBuffer2);
    }

    private void getBytes(int n2, byte[] arrby, int n3, int n4, boolean bl) {
        this.checkDstIndex(n2, n4, n3, arrby.length);
        ByteBuffer byteBuffer = bl ? this.internalNioBuffer() : this.buffer.duplicate();
        byteBuffer.clear().position(n2).limit(n2 + n4);
        byteBuffer.get(arrby, n3, n4);
    }

    private ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer == null) {
            this.tmpNioBuf = byteBuffer = this.buffer.duplicate();
        }
        return byteBuffer;
    }

    private void setByteBuffer(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = this.buffer;
        if (byteBuffer2 != null) {
            if (this.doNotFree) {
                this.doNotFree = false;
            } else {
                this.freeDirect(byteBuffer2);
            }
        }
        this.buffer = byteBuffer;
        this.tmpNioBuf = null;
        this.capacity = byteBuffer.remaining();
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
        this.buffer.put(n2, (byte)n3);
    }

    @Override
    protected void _setInt(int n2, int n3) {
        this.buffer.putInt(n2, n3);
    }

    @Override
    protected void _setLong(int n2, long l2) {
        this.buffer.putLong(n2, l2);
    }

    @Override
    protected void _setMedium(int n2, int n3) {
        this.setByte(n2, (byte)(n3 >>> 16));
        this.setByte(n2 + 1, (byte)(n3 >>> 8));
        this.setByte(n2 + 2, (byte)n3);
    }

    @Override
    protected void _setShort(int n2, int n3) {
        this.buffer.putShort(n2, (short)n3);
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
            UnpooledDirectByteBuf.super.setByteBuffer(byteBuffer);
        }
        return this;
    }

    public ByteBuf copy(int n2, int n3) {
        ByteBuffer byteBuffer;
        this.ensureAccessible();
        try {
            byteBuffer = (ByteBuffer)this.buffer.duplicate().clear().position(n2).limit(n2 + n3);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            StringBuilder stringBuilder = new StringBuilder("Too many bytes to read - Need ");
            stringBuilder.append(n2 + n3);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        return this.alloc().directBuffer(n3, this.maxCapacity()).writeBytes(byteBuffer);
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

    @Override
    public byte getByte(int n2) {
        this.ensureAccessible();
        return this._getByte(n2);
    }

    public int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3) throws IOException {
        return UnpooledDirectByteBuf.super.getBytes(n2, gatheringByteChannel, n3, false);
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
        UnpooledDirectByteBuf.super.getBytes(n2, outputStream, n3, false);
        return this;
    }

    public ByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
        UnpooledDirectByteBuf.super.getBytes(n2, byteBuffer, false);
        return this;
    }

    public ByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
        UnpooledDirectByteBuf.super.getBytes(n2, arrby, n3, n4, false);
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
        return false;
    }

    public boolean hasMemoryAddress() {
        return false;
    }

    public ByteBuffer internalNioBuffer(int n2, int n3) {
        this.checkIndex(n2, n3);
        return (ByteBuffer)UnpooledDirectByteBuf.super.internalNioBuffer().clear().position(n2).limit(n2 + n3);
    }

    public boolean isDirect() {
        return true;
    }

    public long memoryAddress() {
        throw new UnsupportedOperationException();
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
        int n3 = UnpooledDirectByteBuf.super.getBytes(this.readerIndex, gatheringByteChannel, n2, true);
        this.readerIndex = n3 + this.readerIndex;
        return n3;
    }

    @Override
    public ByteBuf readBytes(OutputStream outputStream, int n2) throws IOException {
        this.checkReadableBytes(n2);
        UnpooledDirectByteBuf.super.getBytes(this.readerIndex, outputStream, n2, true);
        this.readerIndex = n2 + this.readerIndex;
        return this;
    }

    @Override
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.remaining();
        this.checkReadableBytes(n2);
        UnpooledDirectByteBuf.super.getBytes(this.readerIndex, byteBuffer, true);
        this.readerIndex = n2 + this.readerIndex;
        return this;
    }

    @Override
    public ByteBuf readBytes(byte[] arrby, int n2, int n3) {
        this.checkReadableBytes(n3);
        UnpooledDirectByteBuf.super.getBytes(this.readerIndex, arrby, n2, n3, true);
        this.readerIndex = n3 + this.readerIndex;
        return this;
    }

    @Override
    public ByteBuf setByte(int n2, int n3) {
        this.ensureAccessible();
        this._setByte(n2, n3);
        return this;
    }

    public int setBytes(int n2, InputStream inputStream, int n3) throws IOException {
        this.ensureAccessible();
        if (this.buffer.hasArray()) {
            return inputStream.read(this.buffer.array(), n2 + this.buffer.arrayOffset(), n3);
        }
        byte[] arrby = new byte[n3];
        int n4 = inputStream.read(arrby);
        if (n4 <= 0) {
            return n4;
        }
        ByteBuffer byteBuffer = UnpooledDirectByteBuf.super.internalNioBuffer();
        byteBuffer.clear().position(n2);
        byteBuffer.put(arrby, 0, n4);
        return n4;
    }

    public int setBytes(int n2, ScatteringByteChannel scatteringByteChannel, int n3) throws IOException {
        this.ensureAccessible();
        UnpooledDirectByteBuf.super.internalNioBuffer().clear().position(n2).limit(n2 + n3);
        try {
            int n4 = scatteringByteChannel.read(this.tmpNioBuf);
            return n4;
        }
        catch (ClosedChannelException closedChannelException) {
            return -1;
        }
    }

    public ByteBuf setBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.checkSrcIndex(n2, n4, n3, byteBuf.capacity());
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

    public ByteBuf setBytes(int n2, ByteBuffer byteBuffer) {
        this.ensureAccessible();
        ByteBuffer byteBuffer2 = UnpooledDirectByteBuf.super.internalNioBuffer();
        if (byteBuffer == byteBuffer2) {
            byteBuffer = byteBuffer.duplicate();
        }
        byteBuffer2.clear().position(n2).limit(n2 + byteBuffer.remaining());
        byteBuffer2.put(byteBuffer);
        return this;
    }

    public ByteBuf setBytes(int n2, byte[] arrby, int n3, int n4) {
        this.checkSrcIndex(n2, n4, n3, arrby.length);
        ByteBuffer byteBuffer = UnpooledDirectByteBuf.super.internalNioBuffer();
        byteBuffer.clear().position(n2).limit(n2 + n4);
        byteBuffer.put(arrby, n3, n4);
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

