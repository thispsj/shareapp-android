/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Deprecated
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.ReadOnlyBufferException
 *  java.nio.channels.GatheringByteChannel
 *  java.nio.channels.ScatteringByteChannel
 */
package io.netty.buffer;

import io.netty.buffer.AbstractDerivedByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufProcessor;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.Unpooled;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

@Deprecated
public class ReadOnlyByteBuf
extends AbstractDerivedByteBuf {
    private final ByteBuf buffer;

    public ReadOnlyByteBuf(ByteBuf byteBuf) {
        super(byteBuf.maxCapacity());
        this.buffer = !(byteBuf instanceof ReadOnlyByteBuf) && !(byteBuf instanceof DuplicatedByteBuf) ? byteBuf : byteBuf.unwrap();
        this.setIndex(byteBuf.readerIndex(), byteBuf.writerIndex());
    }

    @Override
    protected byte _getByte(int n2) {
        return this.unwrap().getByte(n2);
    }

    @Override
    protected int _getInt(int n2) {
        return this.unwrap().getInt(n2);
    }

    @Override
    protected long _getLong(int n2) {
        return this.unwrap().getLong(n2);
    }

    @Override
    protected short _getShort(int n2) {
        return this.unwrap().getShort(n2);
    }

    @Override
    protected int _getUnsignedMedium(int n2) {
        return this.unwrap().getUnsignedMedium(n2);
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
        return this.unwrap().alloc();
    }

    public byte[] array() {
        throw new ReadOnlyBufferException();
    }

    public int arrayOffset() {
        throw new ReadOnlyBufferException();
    }

    public int capacity() {
        return this.unwrap().capacity();
    }

    public ByteBuf capacity(int n2) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf copy(int n2, int n3) {
        return this.unwrap().copy(n2, n3);
    }

    @Override
    public ByteBuf discardReadBytes() {
        throw new ReadOnlyBufferException();
    }

    @Override
    public ByteBuf duplicate() {
        return new ReadOnlyByteBuf(this);
    }

    @Override
    public int ensureWritable(int n2, boolean bl) {
        return 1;
    }

    @Override
    public ByteBuf ensureWritable(int n2) {
        throw new ReadOnlyBufferException();
    }

    @Override
    public int forEachByte(int n2, int n3, ByteBufProcessor byteBufProcessor) {
        return this.unwrap().forEachByte(n2, n3, byteBufProcessor);
    }

    @Override
    public int forEachByteDesc(int n2, int n3, ByteBufProcessor byteBufProcessor) {
        return this.unwrap().forEachByteDesc(n2, n3, byteBufProcessor);
    }

    @Override
    public byte getByte(int n2) {
        return this.unwrap().getByte(n2);
    }

    public int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3) throws IOException {
        return this.unwrap().getBytes(n2, gatheringByteChannel, n3);
    }

    public ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.unwrap().getBytes(n2, byteBuf, n3, n4);
        return this;
    }

    public ByteBuf getBytes(int n2, OutputStream outputStream, int n3) throws IOException {
        this.unwrap().getBytes(n2, outputStream, n3);
        return this;
    }

    public ByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
        this.unwrap().getBytes(n2, byteBuffer);
        return this;
    }

    public ByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
        this.unwrap().getBytes(n2, arrby, n3, n4);
        return this;
    }

    @Override
    public int getInt(int n2) {
        return this.unwrap().getInt(n2);
    }

    @Override
    public long getLong(int n2) {
        return this.unwrap().getLong(n2);
    }

    @Override
    public short getShort(int n2) {
        return this.unwrap().getShort(n2);
    }

    @Override
    public int getUnsignedMedium(int n2) {
        return this.unwrap().getUnsignedMedium(n2);
    }

    public boolean hasArray() {
        return false;
    }

    public boolean hasMemoryAddress() {
        return this.unwrap().hasMemoryAddress();
    }

    public boolean isDirect() {
        return this.unwrap().isDirect();
    }

    @Override
    public boolean isWritable() {
        return false;
    }

    @Override
    public boolean isWritable(int n2) {
        return false;
    }

    public long memoryAddress() {
        return this.unwrap().memoryAddress();
    }

    @Override
    public ByteBuffer nioBuffer(int n2, int n3) {
        return this.unwrap().nioBuffer(n2, n3).asReadOnlyBuffer();
    }

    public int nioBufferCount() {
        return this.unwrap().nioBufferCount();
    }

    public ByteBuffer[] nioBuffers(int n2, int n3) {
        return this.unwrap().nioBuffers(n2, n3);
    }

    @Deprecated
    public ByteOrder order() {
        return this.unwrap().order();
    }

    @Override
    public ByteBuf setByte(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    public int setBytes(int n2, InputStream inputStream, int n3) {
        throw new ReadOnlyBufferException();
    }

    public int setBytes(int n2, ScatteringByteChannel scatteringByteChannel, int n3) {
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

    @Override
    public ByteBuf slice(int n2, int n3) {
        return Unpooled.unmodifiableBuffer(this.unwrap().slice(n2, n3));
    }

    public ByteBuf unwrap() {
        return this.buffer;
    }
}

