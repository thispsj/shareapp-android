/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Deprecated
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.GatheringByteChannel
 *  java.nio.channels.ScatteringByteChannel
 */
package io.netty.buffer;

import io.netty.buffer.AbstractDerivedByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufProcessor;
import io.netty.buffer.DuplicatedByteBuf;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

@Deprecated
public class SlicedByteBuf
extends AbstractDerivedByteBuf {
    private final int adjustment;
    private final ByteBuf buffer;
    private final int length;

    public SlicedByteBuf(ByteBuf byteBuf, int n2, int n3) {
        super(n3);
        if (n2 >= 0 && n2 <= byteBuf.capacity() - n3) {
            if (byteBuf instanceof SlicedByteBuf) {
                SlicedByteBuf slicedByteBuf = (SlicedByteBuf)byteBuf;
                this.buffer = slicedByteBuf.buffer;
                this.adjustment = n2 + slicedByteBuf.adjustment;
            } else {
                if (byteBuf instanceof DuplicatedByteBuf) {
                    byteBuf = byteBuf.unwrap();
                }
                this.buffer = byteBuf;
                this.adjustment = n2;
            }
            this.length = n3;
            this.writerIndex(n3);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)byteBuf);
        stringBuilder.append(".slice(");
        stringBuilder.append(n2);
        stringBuilder.append(", ");
        stringBuilder.append(n3);
        stringBuilder.append(')');
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    @Override
    protected byte _getByte(int n2) {
        return this.unwrap().getByte(this.idx(n2));
    }

    @Override
    protected int _getInt(int n2) {
        return this.unwrap().getInt(this.idx(n2));
    }

    @Override
    protected long _getLong(int n2) {
        return this.unwrap().getLong(this.idx(n2));
    }

    @Override
    protected short _getShort(int n2) {
        return this.unwrap().getShort(this.idx(n2));
    }

    @Override
    protected int _getUnsignedMedium(int n2) {
        return this.unwrap().getUnsignedMedium(this.idx(n2));
    }

    @Override
    protected void _setByte(int n2, int n3) {
        this.unwrap().setByte(this.idx(n2), n3);
    }

    @Override
    protected void _setInt(int n2, int n3) {
        this.unwrap().setInt(this.idx(n2), n3);
    }

    @Override
    protected void _setLong(int n2, long l2) {
        this.unwrap().setLong(this.idx(n2), l2);
    }

    @Override
    protected void _setMedium(int n2, int n3) {
        this.unwrap().setMedium(this.idx(n2), n3);
    }

    @Override
    protected void _setShort(int n2, int n3) {
        this.unwrap().setShort(this.idx(n2), n3);
    }

    public ByteBufAllocator alloc() {
        return this.unwrap().alloc();
    }

    public byte[] array() {
        return this.unwrap().array();
    }

    public int arrayOffset() {
        return this.idx(this.unwrap().arrayOffset());
    }

    public int capacity() {
        return this.length;
    }

    public ByteBuf capacity(int n2) {
        throw new UnsupportedOperationException("sliced buffer");
    }

    public ByteBuf copy(int n2, int n3) {
        this.checkIndex0(n2, n3);
        return this.unwrap().copy(this.idx(n2), n3);
    }

    @Override
    public ByteBuf duplicate() {
        return this.unwrap().duplicate().setIndex(this.idx(this.readerIndex()), this.idx(this.writerIndex()));
    }

    @Override
    public int forEachByte(int n2, int n3, ByteBufProcessor byteBufProcessor) {
        this.checkIndex0(n2, n3);
        int n4 = this.unwrap().forEachByte(this.idx(n2), n3, byteBufProcessor);
        if (n4 >= this.adjustment) {
            return n4 - this.adjustment;
        }
        return -1;
    }

    @Override
    public int forEachByteDesc(int n2, int n3, ByteBufProcessor byteBufProcessor) {
        this.checkIndex0(n2, n3);
        int n4 = this.unwrap().forEachByteDesc(this.idx(n2), n3, byteBufProcessor);
        if (n4 >= this.adjustment) {
            return n4 - this.adjustment;
        }
        return -1;
    }

    @Override
    public byte getByte(int n2) {
        this.checkIndex0(n2, 1);
        return this.unwrap().getByte(this.idx(n2));
    }

    public int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3) throws IOException {
        this.checkIndex0(n2, n3);
        return this.unwrap().getBytes(this.idx(n2), gatheringByteChannel, n3);
    }

    public ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.checkIndex0(n2, n4);
        this.unwrap().getBytes(this.idx(n2), byteBuf, n3, n4);
        return this;
    }

    public ByteBuf getBytes(int n2, OutputStream outputStream, int n3) throws IOException {
        this.checkIndex0(n2, n3);
        this.unwrap().getBytes(this.idx(n2), outputStream, n3);
        return this;
    }

    public ByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
        this.checkIndex0(n2, byteBuffer.remaining());
        this.unwrap().getBytes(this.idx(n2), byteBuffer);
        return this;
    }

    public ByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
        this.checkIndex0(n2, n4);
        this.unwrap().getBytes(this.idx(n2), arrby, n3, n4);
        return this;
    }

    @Override
    public int getInt(int n2) {
        this.checkIndex0(n2, 4);
        return this.unwrap().getInt(this.idx(n2));
    }

    @Override
    public long getLong(int n2) {
        this.checkIndex0(n2, 8);
        return this.unwrap().getLong(this.idx(n2));
    }

    @Override
    public short getShort(int n2) {
        this.checkIndex0(n2, 2);
        return this.unwrap().getShort(this.idx(n2));
    }

    @Override
    public int getUnsignedMedium(int n2) {
        this.checkIndex0(n2, 3);
        return this.unwrap().getUnsignedMedium(this.idx(n2));
    }

    public boolean hasArray() {
        return this.unwrap().hasArray();
    }

    public boolean hasMemoryAddress() {
        return this.unwrap().hasMemoryAddress();
    }

    final int idx(int n2) {
        return n2 + this.adjustment;
    }

    public boolean isDirect() {
        return this.unwrap().isDirect();
    }

    public long memoryAddress() {
        return this.unwrap().memoryAddress() + (long)this.adjustment;
    }

    @Override
    public ByteBuffer nioBuffer(int n2, int n3) {
        this.checkIndex0(n2, n3);
        return this.unwrap().nioBuffer(this.idx(n2), n3);
    }

    public int nioBufferCount() {
        return this.unwrap().nioBufferCount();
    }

    public ByteBuffer[] nioBuffers(int n2, int n3) {
        this.checkIndex0(n2, n3);
        return this.unwrap().nioBuffers(this.idx(n2), n3);
    }

    @Deprecated
    public ByteOrder order() {
        return this.unwrap().order();
    }

    @Override
    public ByteBuf setByte(int n2, int n3) {
        this.checkIndex0(n2, 1);
        this.unwrap().setByte(this.idx(n2), n3);
        return this;
    }

    public int setBytes(int n2, InputStream inputStream, int n3) throws IOException {
        this.checkIndex0(n2, n3);
        return this.unwrap().setBytes(this.idx(n2), inputStream, n3);
    }

    public int setBytes(int n2, ScatteringByteChannel scatteringByteChannel, int n3) throws IOException {
        this.checkIndex0(n2, n3);
        return this.unwrap().setBytes(this.idx(n2), scatteringByteChannel, n3);
    }

    public ByteBuf setBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.checkIndex0(n2, n4);
        this.unwrap().setBytes(this.idx(n2), byteBuf, n3, n4);
        return this;
    }

    public ByteBuf setBytes(int n2, ByteBuffer byteBuffer) {
        this.checkIndex0(n2, byteBuffer.remaining());
        this.unwrap().setBytes(this.idx(n2), byteBuffer);
        return this;
    }

    public ByteBuf setBytes(int n2, byte[] arrby, int n3, int n4) {
        this.checkIndex0(n2, n4);
        this.unwrap().setBytes(this.idx(n2), arrby, n3, n4);
        return this;
    }

    @Override
    public ByteBuf setInt(int n2, int n3) {
        this.checkIndex0(n2, 4);
        this.unwrap().setInt(this.idx(n2), n3);
        return this;
    }

    @Override
    public ByteBuf setLong(int n2, long l2) {
        this.checkIndex0(n2, 8);
        this.unwrap().setLong(this.idx(n2), l2);
        return this;
    }

    @Override
    public ByteBuf setMedium(int n2, int n3) {
        this.checkIndex0(n2, 3);
        this.unwrap().setMedium(this.idx(n2), n3);
        return this;
    }

    @Override
    public ByteBuf setShort(int n2, int n3) {
        this.checkIndex0(n2, 2);
        this.unwrap().setShort(this.idx(n2), n3);
        return this;
    }

    @Override
    public ByteBuf slice(int n2, int n3) {
        this.checkIndex0(n2, n3);
        return this.unwrap().slice(this.idx(n2), n3);
    }

    public ByteBuf unwrap() {
        return this.buffer;
    }
}

