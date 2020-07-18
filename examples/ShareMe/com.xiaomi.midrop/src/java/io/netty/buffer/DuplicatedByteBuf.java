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
 *  java.nio.channels.GatheringByteChannel
 *  java.nio.channels.ScatteringByteChannel
 */
package io.netty.buffer;

import io.netty.buffer.AbstractDerivedByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufProcessor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

@Deprecated
public class DuplicatedByteBuf
extends AbstractDerivedByteBuf {
    private final ByteBuf buffer;

    public DuplicatedByteBuf(ByteBuf byteBuf) {
        super(byteBuf.maxCapacity());
        this.buffer = byteBuf instanceof DuplicatedByteBuf ? ((DuplicatedByteBuf)byteBuf).buffer : byteBuf;
        this.setIndex(byteBuf.readerIndex(), byteBuf.writerIndex());
        this.markReaderIndex();
        this.markWriterIndex();
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
        this.unwrap().setByte(n2, n3);
    }

    @Override
    protected void _setInt(int n2, int n3) {
        this.unwrap().setInt(n2, n3);
    }

    @Override
    protected void _setLong(int n2, long l2) {
        this.unwrap().setLong(n2, l2);
    }

    @Override
    protected void _setMedium(int n2, int n3) {
        this.unwrap().setMedium(n2, n3);
    }

    @Override
    protected void _setShort(int n2, int n3) {
        this.unwrap().setShort(n2, n3);
    }

    public ByteBufAllocator alloc() {
        return this.unwrap().alloc();
    }

    public byte[] array() {
        return this.unwrap().array();
    }

    public int arrayOffset() {
        return this.unwrap().arrayOffset();
    }

    public int capacity() {
        return this.unwrap().capacity();
    }

    public ByteBuf capacity(int n2) {
        this.unwrap().capacity(n2);
        return this;
    }

    public ByteBuf copy(int n2, int n3) {
        return this.unwrap().copy(n2, n3);
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
        return this.unwrap().hasArray();
    }

    public boolean hasMemoryAddress() {
        return this.unwrap().hasMemoryAddress();
    }

    public boolean isDirect() {
        return this.unwrap().isDirect();
    }

    public long memoryAddress() {
        return this.unwrap().memoryAddress();
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
        this.unwrap().setByte(n2, n3);
        return this;
    }

    public int setBytes(int n2, InputStream inputStream, int n3) throws IOException {
        return this.unwrap().setBytes(n2, inputStream, n3);
    }

    public int setBytes(int n2, ScatteringByteChannel scatteringByteChannel, int n3) throws IOException {
        return this.unwrap().setBytes(n2, scatteringByteChannel, n3);
    }

    public ByteBuf setBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.unwrap().setBytes(n2, byteBuf, n3, n4);
        return this;
    }

    public ByteBuf setBytes(int n2, ByteBuffer byteBuffer) {
        this.unwrap().setBytes(n2, byteBuffer);
        return this;
    }

    public ByteBuf setBytes(int n2, byte[] arrby, int n3, int n4) {
        this.unwrap().setBytes(n2, arrby, n3, n4);
        return this;
    }

    @Override
    public ByteBuf setInt(int n2, int n3) {
        this.unwrap().setInt(n2, n3);
        return this;
    }

    @Override
    public ByteBuf setLong(int n2, long l2) {
        this.unwrap().setLong(n2, l2);
        return this;
    }

    @Override
    public ByteBuf setMedium(int n2, int n3) {
        this.unwrap().setMedium(n2, n3);
        return this;
    }

    @Override
    public ByteBuf setShort(int n2, int n3) {
        this.unwrap().setShort(n2, n3);
        return this;
    }

    @Override
    public ByteBuf slice(int n2, int n3) {
        return this.unwrap().slice(n2, n3);
    }

    public ByteBuf unwrap() {
        return this.buffer;
    }
}

