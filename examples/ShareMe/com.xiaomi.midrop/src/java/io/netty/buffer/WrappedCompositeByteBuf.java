/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.GatheringByteChannel
 *  java.nio.channels.ScatteringByteChannel
 *  java.nio.charset.Charset
 *  java.util.Iterator
 *  java.util.List
 */
package io.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufProcessor;
import io.netty.buffer.CompositeByteBuf;
import io.netty.d.l;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

class WrappedCompositeByteBuf
extends CompositeByteBuf {
    private final CompositeByteBuf wrapped;

    WrappedCompositeByteBuf(CompositeByteBuf compositeByteBuf) {
        super(compositeByteBuf.alloc());
        this.wrapped = compositeByteBuf;
    }

    @Override
    protected final byte _getByte(int n2) {
        return this.wrapped._getByte(n2);
    }

    @Override
    protected final int _getInt(int n2) {
        return this.wrapped._getInt(n2);
    }

    @Override
    protected final long _getLong(int n2) {
        return this.wrapped._getLong(n2);
    }

    @Override
    protected final short _getShort(int n2) {
        return this.wrapped._getShort(n2);
    }

    @Override
    protected final int _getUnsignedMedium(int n2) {
        return this.wrapped._getUnsignedMedium(n2);
    }

    @Override
    protected final void _setByte(int n2, int n3) {
        this.wrapped._setByte(n2, n3);
    }

    @Override
    protected final void _setInt(int n2, int n3) {
        this.wrapped._setInt(n2, n3);
    }

    @Override
    protected final void _setLong(int n2, long l2) {
        this.wrapped._setLong(n2, l2);
    }

    @Override
    protected final void _setMedium(int n2, int n3) {
        this.wrapped._setMedium(n2, n3);
    }

    @Override
    protected final void _setShort(int n2, int n3) {
        this.wrapped._setShort(n2, n3);
    }

    @Override
    public CompositeByteBuf addComponent(int n2, ByteBuf byteBuf) {
        this.wrapped.addComponent(n2, byteBuf);
        return this;
    }

    @Override
    public CompositeByteBuf addComponent(ByteBuf byteBuf) {
        this.wrapped.addComponent(byteBuf);
        return this;
    }

    @Override
    public CompositeByteBuf addComponent(boolean bl, int n2, ByteBuf byteBuf) {
        this.wrapped.addComponent(bl, n2, byteBuf);
        return this;
    }

    @Override
    public CompositeByteBuf addComponent(boolean bl, ByteBuf byteBuf) {
        this.wrapped.addComponent(bl, byteBuf);
        return this;
    }

    @Override
    public CompositeByteBuf addComponents(int n2, Iterable<ByteBuf> iterable) {
        this.wrapped.addComponents(n2, iterable);
        return this;
    }

    @Override
    public /* varargs */ CompositeByteBuf addComponents(int n2, ByteBuf ... arrbyteBuf) {
        this.wrapped.addComponents(n2, arrbyteBuf);
        return this;
    }

    @Override
    public CompositeByteBuf addComponents(Iterable<ByteBuf> iterable) {
        this.wrapped.addComponents(iterable);
        return this;
    }

    @Override
    public CompositeByteBuf addComponents(boolean bl, Iterable<ByteBuf> iterable) {
        this.wrapped.addComponents(bl, iterable);
        return this;
    }

    @Override
    public /* varargs */ CompositeByteBuf addComponents(boolean bl, ByteBuf ... arrbyteBuf) {
        this.wrapped.addComponents(bl, arrbyteBuf);
        return this;
    }

    @Override
    public /* varargs */ CompositeByteBuf addComponents(ByteBuf ... arrbyteBuf) {
        this.wrapped.addComponents(arrbyteBuf);
        return this;
    }

    @Override
    public final ByteBufAllocator alloc() {
        return this.wrapped.alloc();
    }

    @Override
    public final byte[] array() {
        return this.wrapped.array();
    }

    @Override
    public final int arrayOffset() {
        return this.wrapped.arrayOffset();
    }

    @Override
    public int bytesBefore(byte by) {
        return this.wrapped.bytesBefore(by);
    }

    @Override
    public int bytesBefore(int n2, byte by) {
        return this.wrapped.bytesBefore(n2, by);
    }

    @Override
    public int bytesBefore(int n2, int n3, byte by) {
        return this.wrapped.bytesBefore(n2, n3, by);
    }

    @Override
    public final int capacity() {
        return this.wrapped.capacity();
    }

    @Override
    public CompositeByteBuf capacity(int n2) {
        this.wrapped.capacity(n2);
        return this;
    }

    @Override
    public final CompositeByteBuf clear() {
        this.wrapped.clear();
        return this;
    }

    @Override
    public final int compareTo(ByteBuf byteBuf) {
        return this.wrapped.compareTo(byteBuf);
    }

    @Override
    public final ByteBuf component(int n2) {
        return this.wrapped.component(n2);
    }

    @Override
    public final ByteBuf componentAtOffset(int n2) {
        return this.wrapped.componentAtOffset(n2);
    }

    @Override
    public CompositeByteBuf consolidate() {
        this.wrapped.consolidate();
        return this;
    }

    @Override
    public CompositeByteBuf consolidate(int n2, int n3) {
        this.wrapped.consolidate(n2, n3);
        return this;
    }

    @Override
    public ByteBuf copy() {
        return this.wrapped.copy();
    }

    @Override
    public ByteBuf copy(int n2, int n3) {
        return this.wrapped.copy(n2, n3);
    }

    @Override
    public final void deallocate() {
        this.wrapped.deallocate();
    }

    @Override
    public List<ByteBuf> decompose(int n2, int n3) {
        return this.wrapped.decompose(n2, n3);
    }

    @Override
    public CompositeByteBuf discardReadBytes() {
        this.wrapped.discardReadBytes();
        return this;
    }

    @Override
    public CompositeByteBuf discardReadComponents() {
        this.wrapped.discardReadComponents();
        return this;
    }

    @Override
    public CompositeByteBuf discardSomeReadBytes() {
        this.wrapped.discardSomeReadBytes();
        return this;
    }

    @Override
    public ByteBuf duplicate() {
        return this.wrapped.duplicate();
    }

    @Override
    public int ensureWritable(int n2, boolean bl) {
        return this.wrapped.ensureWritable(n2, bl);
    }

    @Override
    public CompositeByteBuf ensureWritable(int n2) {
        this.wrapped.ensureWritable(n2);
        return this;
    }

    @Override
    public final boolean equals(Object object) {
        return this.wrapped.equals(object);
    }

    @Override
    public int forEachByte(int n2, int n3, ByteBufProcessor byteBufProcessor) {
        return this.wrapped.forEachByte(n2, n3, byteBufProcessor);
    }

    @Override
    public int forEachByte(ByteBufProcessor byteBufProcessor) {
        return this.wrapped.forEachByte(byteBufProcessor);
    }

    @Override
    public int forEachByteDesc(int n2, int n3, ByteBufProcessor byteBufProcessor) {
        return this.wrapped.forEachByteDesc(n2, n3, byteBufProcessor);
    }

    @Override
    public int forEachByteDesc(ByteBufProcessor byteBufProcessor) {
        return this.wrapped.forEachByteDesc(byteBufProcessor);
    }

    @Override
    public boolean getBoolean(int n2) {
        return this.wrapped.getBoolean(n2);
    }

    @Override
    public byte getByte(int n2) {
        return this.wrapped.getByte(n2);
    }

    @Override
    public int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3) throws IOException {
        return this.wrapped.getBytes(n2, gatheringByteChannel, n3);
    }

    @Override
    public CompositeByteBuf getBytes(int n2, ByteBuf byteBuf) {
        this.wrapped.getBytes(n2, byteBuf);
        return this;
    }

    @Override
    public CompositeByteBuf getBytes(int n2, ByteBuf byteBuf, int n3) {
        this.wrapped.getBytes(n2, byteBuf, n3);
        return this;
    }

    @Override
    public CompositeByteBuf getBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.wrapped.getBytes(n2, byteBuf, n3, n4);
        return this;
    }

    @Override
    public CompositeByteBuf getBytes(int n2, OutputStream outputStream, int n3) throws IOException {
        this.wrapped.getBytes(n2, outputStream, n3);
        return this;
    }

    @Override
    public CompositeByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
        this.wrapped.getBytes(n2, byteBuffer);
        return this;
    }

    @Override
    public CompositeByteBuf getBytes(int n2, byte[] arrby) {
        this.wrapped.getBytes(n2, arrby);
        return this;
    }

    @Override
    public CompositeByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
        this.wrapped.getBytes(n2, arrby, n3, n4);
        return this;
    }

    @Override
    public char getChar(int n2) {
        return this.wrapped.getChar(n2);
    }

    @Override
    public double getDouble(int n2) {
        return this.wrapped.getDouble(n2);
    }

    @Override
    public float getFloat(int n2) {
        return this.wrapped.getFloat(n2);
    }

    @Override
    public int getInt(int n2) {
        return this.wrapped.getInt(n2);
    }

    @Override
    public long getLong(int n2) {
        return this.wrapped.getLong(n2);
    }

    @Override
    public int getMedium(int n2) {
        return this.wrapped.getMedium(n2);
    }

    @Override
    public short getShort(int n2) {
        return this.wrapped.getShort(n2);
    }

    @Override
    public short getUnsignedByte(int n2) {
        return this.wrapped.getUnsignedByte(n2);
    }

    @Override
    public long getUnsignedInt(int n2) {
        return this.wrapped.getUnsignedInt(n2);
    }

    @Override
    public int getUnsignedMedium(int n2) {
        return this.wrapped.getUnsignedMedium(n2);
    }

    @Override
    public int getUnsignedShort(int n2) {
        return this.wrapped.getUnsignedShort(n2);
    }

    @Override
    public final boolean hasArray() {
        return this.wrapped.hasArray();
    }

    @Override
    public final boolean hasMemoryAddress() {
        return this.wrapped.hasMemoryAddress();
    }

    @Override
    public final int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override
    public int indexOf(int n2, int n3, byte by) {
        return this.wrapped.indexOf(n2, n3, by);
    }

    @Override
    public final ByteBuf internalComponent(int n2) {
        return this.wrapped.internalComponent(n2);
    }

    @Override
    public final ByteBuf internalComponentAtOffset(int n2) {
        return this.wrapped.internalComponentAtOffset(n2);
    }

    @Override
    public ByteBuffer internalNioBuffer(int n2, int n3) {
        return this.wrapped.internalNioBuffer(n2, n3);
    }

    @Override
    public final boolean isDirect() {
        return this.wrapped.isDirect();
    }

    @Override
    public final boolean isReadable() {
        return this.wrapped.isReadable();
    }

    @Override
    public final boolean isReadable(int n2) {
        return this.wrapped.isReadable(n2);
    }

    @Override
    public final boolean isWritable() {
        return this.wrapped.isWritable();
    }

    @Override
    public final boolean isWritable(int n2) {
        return this.wrapped.isWritable(n2);
    }

    @Override
    public Iterator<ByteBuf> iterator() {
        return this.wrapped.iterator();
    }

    @Override
    public final CompositeByteBuf markReaderIndex() {
        this.wrapped.markReaderIndex();
        return this;
    }

    @Override
    public final CompositeByteBuf markWriterIndex() {
        this.wrapped.markWriterIndex();
        return this;
    }

    @Override
    public final int maxCapacity() {
        return this.wrapped.maxCapacity();
    }

    @Override
    public final int maxNumComponents() {
        return this.wrapped.maxNumComponents();
    }

    @Override
    public final int maxWritableBytes() {
        return this.wrapped.maxWritableBytes();
    }

    @Override
    public final long memoryAddress() {
        return this.wrapped.memoryAddress();
    }

    @Override
    public ByteBuffer nioBuffer() {
        return this.wrapped.nioBuffer();
    }

    @Override
    public ByteBuffer nioBuffer(int n2, int n3) {
        return this.wrapped.nioBuffer(n2, n3);
    }

    @Override
    public int nioBufferCount() {
        return this.wrapped.nioBufferCount();
    }

    @Override
    public ByteBuffer[] nioBuffers() {
        return this.wrapped.nioBuffers();
    }

    @Override
    public ByteBuffer[] nioBuffers(int n2, int n3) {
        return this.wrapped.nioBuffers(n2, n3);
    }

    @Override
    public final int numComponents() {
        return this.wrapped.numComponents();
    }

    @Override
    public ByteBuf order(ByteOrder byteOrder) {
        return this.wrapped.order(byteOrder);
    }

    @Override
    public final ByteOrder order() {
        return this.wrapped.order();
    }

    @Override
    public boolean readBoolean() {
        return this.wrapped.readBoolean();
    }

    @Override
    public byte readByte() {
        return this.wrapped.readByte();
    }

    @Override
    public int readBytes(GatheringByteChannel gatheringByteChannel, int n2) throws IOException {
        return this.wrapped.readBytes(gatheringByteChannel, n2);
    }

    @Override
    public ByteBuf readBytes(int n2) {
        return this.wrapped.readBytes(n2);
    }

    @Override
    public CompositeByteBuf readBytes(ByteBuf byteBuf) {
        this.wrapped.readBytes(byteBuf);
        return this;
    }

    @Override
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int n2) {
        this.wrapped.readBytes(byteBuf, n2);
        return this;
    }

    @Override
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int n2, int n3) {
        this.wrapped.readBytes(byteBuf, n2, n3);
        return this;
    }

    @Override
    public CompositeByteBuf readBytes(OutputStream outputStream, int n2) throws IOException {
        this.wrapped.readBytes(outputStream, n2);
        return this;
    }

    @Override
    public CompositeByteBuf readBytes(ByteBuffer byteBuffer) {
        this.wrapped.readBytes(byteBuffer);
        return this;
    }

    @Override
    public CompositeByteBuf readBytes(byte[] arrby) {
        this.wrapped.readBytes(arrby);
        return this;
    }

    @Override
    public CompositeByteBuf readBytes(byte[] arrby, int n2, int n3) {
        this.wrapped.readBytes(arrby, n2, n3);
        return this;
    }

    @Override
    public char readChar() {
        return this.wrapped.readChar();
    }

    @Override
    public double readDouble() {
        return this.wrapped.readDouble();
    }

    @Override
    public float readFloat() {
        return this.wrapped.readFloat();
    }

    @Override
    public int readInt() {
        return this.wrapped.readInt();
    }

    @Override
    public long readLong() {
        return this.wrapped.readLong();
    }

    @Override
    public int readMedium() {
        return this.wrapped.readMedium();
    }

    @Override
    public short readShort() {
        return this.wrapped.readShort();
    }

    @Override
    public ByteBuf readSlice(int n2) {
        return this.wrapped.readSlice(n2);
    }

    @Override
    public short readUnsignedByte() {
        return this.wrapped.readUnsignedByte();
    }

    @Override
    public long readUnsignedInt() {
        return this.wrapped.readUnsignedInt();
    }

    @Override
    public int readUnsignedMedium() {
        return this.wrapped.readUnsignedMedium();
    }

    @Override
    public int readUnsignedShort() {
        return this.wrapped.readUnsignedShort();
    }

    @Override
    public final int readableBytes() {
        return this.wrapped.readableBytes();
    }

    @Override
    public final int readerIndex() {
        return this.wrapped.readerIndex();
    }

    @Override
    public final CompositeByteBuf readerIndex(int n2) {
        this.wrapped.readerIndex(n2);
        return this;
    }

    @Override
    public final int refCnt() {
        return this.wrapped.refCnt();
    }

    @Override
    public boolean release() {
        return this.wrapped.release();
    }

    @Override
    public boolean release(int n2) {
        return this.wrapped.release(n2);
    }

    @Override
    public CompositeByteBuf removeComponent(int n2) {
        this.wrapped.removeComponent(n2);
        return this;
    }

    @Override
    public CompositeByteBuf removeComponents(int n2, int n3) {
        this.wrapped.removeComponents(n2, n3);
        return this;
    }

    @Override
    public final CompositeByteBuf resetReaderIndex() {
        this.wrapped.resetReaderIndex();
        return this;
    }

    @Override
    public final CompositeByteBuf resetWriterIndex() {
        this.wrapped.resetWriterIndex();
        return this;
    }

    @Override
    public CompositeByteBuf retain() {
        this.wrapped.retain();
        return this;
    }

    @Override
    public CompositeByteBuf retain(int n2) {
        this.wrapped.retain(n2);
        return this;
    }

    @Override
    public CompositeByteBuf setBoolean(int n2, boolean bl) {
        this.wrapped.setBoolean(n2, bl);
        return this;
    }

    @Override
    public CompositeByteBuf setByte(int n2, int n3) {
        this.wrapped.setByte(n2, n3);
        return this;
    }

    @Override
    public int setBytes(int n2, InputStream inputStream, int n3) throws IOException {
        return this.wrapped.setBytes(n2, inputStream, n3);
    }

    @Override
    public int setBytes(int n2, ScatteringByteChannel scatteringByteChannel, int n3) throws IOException {
        return this.wrapped.setBytes(n2, scatteringByteChannel, n3);
    }

    @Override
    public CompositeByteBuf setBytes(int n2, ByteBuf byteBuf) {
        this.wrapped.setBytes(n2, byteBuf);
        return this;
    }

    @Override
    public CompositeByteBuf setBytes(int n2, ByteBuf byteBuf, int n3) {
        this.wrapped.setBytes(n2, byteBuf, n3);
        return this;
    }

    @Override
    public CompositeByteBuf setBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.wrapped.setBytes(n2, byteBuf, n3, n4);
        return this;
    }

    @Override
    public CompositeByteBuf setBytes(int n2, ByteBuffer byteBuffer) {
        this.wrapped.setBytes(n2, byteBuffer);
        return this;
    }

    @Override
    public CompositeByteBuf setBytes(int n2, byte[] arrby) {
        this.wrapped.setBytes(n2, arrby);
        return this;
    }

    @Override
    public CompositeByteBuf setBytes(int n2, byte[] arrby, int n3, int n4) {
        this.wrapped.setBytes(n2, arrby, n3, n4);
        return this;
    }

    @Override
    public CompositeByteBuf setChar(int n2, int n3) {
        this.wrapped.setChar(n2, n3);
        return this;
    }

    @Override
    public CompositeByteBuf setDouble(int n2, double d2) {
        this.wrapped.setDouble(n2, d2);
        return this;
    }

    @Override
    public CompositeByteBuf setFloat(int n2, float f2) {
        this.wrapped.setFloat(n2, f2);
        return this;
    }

    @Override
    public final CompositeByteBuf setIndex(int n2, int n3) {
        this.wrapped.setIndex(n2, n3);
        return this;
    }

    @Override
    public CompositeByteBuf setInt(int n2, int n3) {
        this.wrapped.setInt(n2, n3);
        return this;
    }

    @Override
    public CompositeByteBuf setLong(int n2, long l2) {
        this.wrapped.setLong(n2, l2);
        return this;
    }

    @Override
    public CompositeByteBuf setMedium(int n2, int n3) {
        this.wrapped.setMedium(n2, n3);
        return this;
    }

    @Override
    public CompositeByteBuf setShort(int n2, int n3) {
        this.wrapped.setShort(n2, n3);
        return this;
    }

    @Override
    public CompositeByteBuf setZero(int n2, int n3) {
        this.wrapped.setZero(n2, n3);
        return this;
    }

    @Override
    public CompositeByteBuf skipBytes(int n2) {
        this.wrapped.skipBytes(n2);
        return this;
    }

    @Override
    public ByteBuf slice() {
        return this.wrapped.slice();
    }

    @Override
    public ByteBuf slice(int n2, int n3) {
        return this.wrapped.slice(n2, n3);
    }

    @Override
    public final int toByteIndex(int n2) {
        return this.wrapped.toByteIndex(n2);
    }

    @Override
    public final int toComponentIndex(int n2) {
        return this.wrapped.toComponentIndex(n2);
    }

    @Override
    public final String toString() {
        return this.wrapped.toString();
    }

    @Override
    public String toString(int n2, int n3, Charset charset) {
        return this.wrapped.toString(n2, n3, charset);
    }

    @Override
    public String toString(Charset charset) {
        return this.wrapped.toString(charset);
    }

    @Override
    public final ByteBuf unwrap() {
        return this.wrapped;
    }

    @Override
    public final int writableBytes() {
        return this.wrapped.writableBytes();
    }

    @Override
    public CompositeByteBuf writeBoolean(boolean bl) {
        this.wrapped.writeBoolean(bl);
        return this;
    }

    @Override
    public CompositeByteBuf writeByte(int n2) {
        this.wrapped.writeByte(n2);
        return this;
    }

    @Override
    public int writeBytes(InputStream inputStream, int n2) throws IOException {
        return this.wrapped.writeBytes(inputStream, n2);
    }

    @Override
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int n2) throws IOException {
        return this.wrapped.writeBytes(scatteringByteChannel, n2);
    }

    @Override
    public CompositeByteBuf writeBytes(ByteBuf byteBuf) {
        this.wrapped.writeBytes(byteBuf);
        return this;
    }

    @Override
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int n2) {
        this.wrapped.writeBytes(byteBuf, n2);
        return this;
    }

    @Override
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int n2, int n3) {
        this.wrapped.writeBytes(byteBuf, n2, n3);
        return this;
    }

    @Override
    public CompositeByteBuf writeBytes(ByteBuffer byteBuffer) {
        this.wrapped.writeBytes(byteBuffer);
        return this;
    }

    @Override
    public CompositeByteBuf writeBytes(byte[] arrby) {
        this.wrapped.writeBytes(arrby);
        return this;
    }

    @Override
    public CompositeByteBuf writeBytes(byte[] arrby, int n2, int n3) {
        this.wrapped.writeBytes(arrby, n2, n3);
        return this;
    }

    @Override
    public CompositeByteBuf writeChar(int n2) {
        this.wrapped.writeChar(n2);
        return this;
    }

    @Override
    public CompositeByteBuf writeDouble(double d2) {
        this.wrapped.writeDouble(d2);
        return this;
    }

    @Override
    public CompositeByteBuf writeFloat(float f2) {
        this.wrapped.writeFloat(f2);
        return this;
    }

    @Override
    public CompositeByteBuf writeInt(int n2) {
        this.wrapped.writeInt(n2);
        return this;
    }

    @Override
    public CompositeByteBuf writeLong(long l2) {
        this.wrapped.writeLong(l2);
        return this;
    }

    @Override
    public CompositeByteBuf writeMedium(int n2) {
        this.wrapped.writeMedium(n2);
        return this;
    }

    @Override
    public CompositeByteBuf writeShort(int n2) {
        this.wrapped.writeShort(n2);
        return this;
    }

    @Override
    public CompositeByteBuf writeZero(int n2) {
        this.wrapped.writeZero(n2);
        return this;
    }

    @Override
    public final int writerIndex() {
        return this.wrapped.writerIndex();
    }

    @Override
    public final CompositeByteBuf writerIndex(int n2) {
        this.wrapped.writerIndex(n2);
        return this;
    }
}

