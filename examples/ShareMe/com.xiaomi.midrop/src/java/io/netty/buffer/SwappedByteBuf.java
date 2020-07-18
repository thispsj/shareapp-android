/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.GatheringByteChannel
 *  java.nio.channels.ScatteringByteChannel
 *  java.nio.charset.Charset
 */
package io.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufProcessor;
import io.netty.buffer.ByteBufUtil;
import io.netty.d.l;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

public class SwappedByteBuf
extends ByteBuf {
    private final ByteBuf buf;
    private final ByteOrder order;

    /*
     * Enabled aggressive block sorting
     */
    public SwappedByteBuf(ByteBuf byteBuf) {
        if (byteBuf == null) {
            throw new NullPointerException("buf");
        }
        this.buf = byteBuf;
        ByteOrder byteOrder = byteBuf.order() == ByteOrder.BIG_ENDIAN ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
        this.order = byteOrder;
    }

    public ByteBufAllocator alloc() {
        return this.buf.alloc();
    }

    public byte[] array() {
        return this.buf.array();
    }

    public int arrayOffset() {
        return this.buf.arrayOffset();
    }

    public int bytesBefore(byte by) {
        return this.buf.bytesBefore(by);
    }

    public int bytesBefore(int n2, byte by) {
        return this.buf.bytesBefore(n2, by);
    }

    public int bytesBefore(int n2, int n3, byte by) {
        return this.buf.bytesBefore(n2, n3, by);
    }

    public int capacity() {
        return this.buf.capacity();
    }

    public ByteBuf capacity(int n2) {
        this.buf.capacity(n2);
        return this;
    }

    public ByteBuf clear() {
        this.buf.clear();
        return this;
    }

    public int compareTo(ByteBuf byteBuf) {
        return ByteBufUtil.compare((ByteBuf)this, byteBuf);
    }

    public ByteBuf copy() {
        return this.buf.copy().order(this.order);
    }

    public ByteBuf copy(int n2, int n3) {
        return this.buf.copy(n2, n3).order(this.order);
    }

    public ByteBuf discardReadBytes() {
        this.buf.discardReadBytes();
        return this;
    }

    public ByteBuf discardSomeReadBytes() {
        this.buf.discardSomeReadBytes();
        return this;
    }

    public ByteBuf duplicate() {
        return this.buf.duplicate().order(this.order);
    }

    public int ensureWritable(int n2, boolean bl) {
        return this.buf.ensureWritable(n2, bl);
    }

    public ByteBuf ensureWritable(int n2) {
        this.buf.ensureWritable(n2);
        return this;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof ByteBuf) {
            return ByteBufUtil.equals((ByteBuf)this, (ByteBuf)object);
        }
        return false;
    }

    public int forEachByte(int n2, int n3, ByteBufProcessor byteBufProcessor) {
        return this.buf.forEachByte(n2, n3, byteBufProcessor);
    }

    public int forEachByte(ByteBufProcessor byteBufProcessor) {
        return this.buf.forEachByte(byteBufProcessor);
    }

    public int forEachByteDesc(int n2, int n3, ByteBufProcessor byteBufProcessor) {
        return this.buf.forEachByteDesc(n2, n3, byteBufProcessor);
    }

    public int forEachByteDesc(ByteBufProcessor byteBufProcessor) {
        return this.buf.forEachByteDesc(byteBufProcessor);
    }

    public boolean getBoolean(int n2) {
        return this.buf.getBoolean(n2);
    }

    public byte getByte(int n2) {
        return this.buf.getByte(n2);
    }

    public int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3) throws IOException {
        return this.buf.getBytes(n2, gatheringByteChannel, n3);
    }

    public ByteBuf getBytes(int n2, ByteBuf byteBuf) {
        this.buf.getBytes(n2, byteBuf);
        return this;
    }

    public ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3) {
        this.buf.getBytes(n2, byteBuf, n3);
        return this;
    }

    public ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.buf.getBytes(n2, byteBuf, n3, n4);
        return this;
    }

    public ByteBuf getBytes(int n2, OutputStream outputStream, int n3) throws IOException {
        this.buf.getBytes(n2, outputStream, n3);
        return this;
    }

    public ByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
        this.buf.getBytes(n2, byteBuffer);
        return this;
    }

    public ByteBuf getBytes(int n2, byte[] arrby) {
        this.buf.getBytes(n2, arrby);
        return this;
    }

    public ByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
        this.buf.getBytes(n2, arrby, n3, n4);
        return this;
    }

    public char getChar(int n2) {
        return (char)this.getShort(n2);
    }

    public double getDouble(int n2) {
        return Double.longBitsToDouble((long)this.getLong(n2));
    }

    public float getFloat(int n2) {
        return Float.intBitsToFloat((int)this.getInt(n2));
    }

    public int getInt(int n2) {
        return ByteBufUtil.swapInt(this.buf.getInt(n2));
    }

    public long getLong(int n2) {
        return ByteBufUtil.swapLong(this.buf.getLong(n2));
    }

    public int getMedium(int n2) {
        return ByteBufUtil.swapMedium(this.buf.getMedium(n2));
    }

    public short getShort(int n2) {
        return ByteBufUtil.swapShort(this.buf.getShort(n2));
    }

    public short getUnsignedByte(int n2) {
        return this.buf.getUnsignedByte(n2);
    }

    public long getUnsignedInt(int n2) {
        return 0xFFFFFFFFL & (long)this.getInt(n2);
    }

    public int getUnsignedMedium(int n2) {
        return 16777215 & this.getMedium(n2);
    }

    public int getUnsignedShort(int n2) {
        return 65535 & this.getShort(n2);
    }

    public boolean hasArray() {
        return this.buf.hasArray();
    }

    public boolean hasMemoryAddress() {
        return this.buf.hasMemoryAddress();
    }

    public int hashCode() {
        return this.buf.hashCode();
    }

    public int indexOf(int n2, int n3, byte by) {
        return this.buf.indexOf(n2, n3, by);
    }

    public ByteBuffer internalNioBuffer(int n2, int n3) {
        return this.nioBuffer(n2, n3);
    }

    public boolean isDirect() {
        return this.buf.isDirect();
    }

    public boolean isReadable() {
        return this.buf.isReadable();
    }

    public boolean isReadable(int n2) {
        return this.buf.isReadable(n2);
    }

    public boolean isWritable() {
        return this.buf.isWritable();
    }

    public boolean isWritable(int n2) {
        return this.buf.isWritable(n2);
    }

    public ByteBuf markReaderIndex() {
        this.buf.markReaderIndex();
        return this;
    }

    public ByteBuf markWriterIndex() {
        this.buf.markWriterIndex();
        return this;
    }

    public int maxCapacity() {
        return this.buf.maxCapacity();
    }

    public int maxWritableBytes() {
        return this.buf.maxWritableBytes();
    }

    public long memoryAddress() {
        return this.buf.memoryAddress();
    }

    public ByteBuffer nioBuffer() {
        return this.buf.nioBuffer().order(this.order);
    }

    public ByteBuffer nioBuffer(int n2, int n3) {
        return this.buf.nioBuffer(n2, n3).order(this.order);
    }

    public int nioBufferCount() {
        return this.buf.nioBufferCount();
    }

    public ByteBuffer[] nioBuffers() {
        ByteBuffer[] arrbyteBuffer = this.buf.nioBuffers();
        for (int i2 = 0; i2 < arrbyteBuffer.length; ++i2) {
            arrbyteBuffer[i2] = arrbyteBuffer[i2].order(this.order);
        }
        return arrbyteBuffer;
    }

    public ByteBuffer[] nioBuffers(int n2, int n3) {
        ByteBuffer[] arrbyteBuffer = this.buf.nioBuffers(n2, n3);
        for (int i2 = 0; i2 < arrbyteBuffer.length; ++i2) {
            arrbyteBuffer[i2] = arrbyteBuffer[i2].order(this.order);
        }
        return arrbyteBuffer;
    }

    public ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        }
        if (byteOrder == this.order) {
            return this;
        }
        return this.buf;
    }

    public ByteOrder order() {
        return this.order;
    }

    public boolean readBoolean() {
        return this.buf.readBoolean();
    }

    public byte readByte() {
        return this.buf.readByte();
    }

    public int readBytes(GatheringByteChannel gatheringByteChannel, int n2) throws IOException {
        return this.buf.readBytes(gatheringByteChannel, n2);
    }

    public ByteBuf readBytes(int n2) {
        return this.buf.readBytes(n2).order(this.order());
    }

    public ByteBuf readBytes(ByteBuf byteBuf) {
        this.buf.readBytes(byteBuf);
        return this;
    }

    public ByteBuf readBytes(ByteBuf byteBuf, int n2) {
        this.buf.readBytes(byteBuf, n2);
        return this;
    }

    public ByteBuf readBytes(ByteBuf byteBuf, int n2, int n3) {
        this.buf.readBytes(byteBuf, n2, n3);
        return this;
    }

    public ByteBuf readBytes(OutputStream outputStream, int n2) throws IOException {
        this.buf.readBytes(outputStream, n2);
        return this;
    }

    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        this.buf.readBytes(byteBuffer);
        return this;
    }

    public ByteBuf readBytes(byte[] arrby) {
        this.buf.readBytes(arrby);
        return this;
    }

    public ByteBuf readBytes(byte[] arrby, int n2, int n3) {
        this.buf.readBytes(arrby, n2, n3);
        return this;
    }

    public char readChar() {
        return (char)this.readShort();
    }

    public double readDouble() {
        return Double.longBitsToDouble((long)this.readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat((int)this.readInt());
    }

    public int readInt() {
        return ByteBufUtil.swapInt(this.buf.readInt());
    }

    public long readLong() {
        return ByteBufUtil.swapLong(this.buf.readLong());
    }

    public int readMedium() {
        return ByteBufUtil.swapMedium(this.buf.readMedium());
    }

    public short readShort() {
        return ByteBufUtil.swapShort(this.buf.readShort());
    }

    public ByteBuf readSlice(int n2) {
        return this.buf.readSlice(n2).order(this.order);
    }

    public short readUnsignedByte() {
        return this.buf.readUnsignedByte();
    }

    public long readUnsignedInt() {
        return 0xFFFFFFFFL & (long)this.readInt();
    }

    public int readUnsignedMedium() {
        return 16777215 & this.readMedium();
    }

    public int readUnsignedShort() {
        return 65535 & this.readShort();
    }

    public int readableBytes() {
        return this.buf.readableBytes();
    }

    public int readerIndex() {
        return this.buf.readerIndex();
    }

    public ByteBuf readerIndex(int n2) {
        this.buf.readerIndex(n2);
        return this;
    }

    public int refCnt() {
        return this.buf.refCnt();
    }

    public boolean release() {
        return this.buf.release();
    }

    public boolean release(int n2) {
        return this.buf.release(n2);
    }

    public ByteBuf resetReaderIndex() {
        this.buf.resetReaderIndex();
        return this;
    }

    public ByteBuf resetWriterIndex() {
        this.buf.resetWriterIndex();
        return this;
    }

    public ByteBuf retain() {
        this.buf.retain();
        return this;
    }

    public ByteBuf retain(int n2) {
        this.buf.retain(n2);
        return this;
    }

    public ByteBuf setBoolean(int n2, boolean bl) {
        this.buf.setBoolean(n2, bl);
        return this;
    }

    public ByteBuf setByte(int n2, int n3) {
        this.buf.setByte(n2, n3);
        return this;
    }

    public int setBytes(int n2, InputStream inputStream, int n3) throws IOException {
        return this.buf.setBytes(n2, inputStream, n3);
    }

    public int setBytes(int n2, ScatteringByteChannel scatteringByteChannel, int n3) throws IOException {
        return this.buf.setBytes(n2, scatteringByteChannel, n3);
    }

    public ByteBuf setBytes(int n2, ByteBuf byteBuf) {
        this.buf.setBytes(n2, byteBuf);
        return this;
    }

    public ByteBuf setBytes(int n2, ByteBuf byteBuf, int n3) {
        this.buf.setBytes(n2, byteBuf, n3);
        return this;
    }

    public ByteBuf setBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.buf.setBytes(n2, byteBuf, n3, n4);
        return this;
    }

    public ByteBuf setBytes(int n2, ByteBuffer byteBuffer) {
        this.buf.setBytes(n2, byteBuffer);
        return this;
    }

    public ByteBuf setBytes(int n2, byte[] arrby) {
        this.buf.setBytes(n2, arrby);
        return this;
    }

    public ByteBuf setBytes(int n2, byte[] arrby, int n3, int n4) {
        this.buf.setBytes(n2, arrby, n3, n4);
        return this;
    }

    public ByteBuf setChar(int n2, int n3) {
        this.setShort(n2, n3);
        return this;
    }

    public ByteBuf setDouble(int n2, double d2) {
        this.setLong(n2, Double.doubleToRawLongBits((double)d2));
        return this;
    }

    public ByteBuf setFloat(int n2, float f2) {
        this.setInt(n2, Float.floatToRawIntBits((float)f2));
        return this;
    }

    public ByteBuf setIndex(int n2, int n3) {
        this.buf.setIndex(n2, n3);
        return this;
    }

    public ByteBuf setInt(int n2, int n3) {
        this.buf.setInt(n2, ByteBufUtil.swapInt(n3));
        return this;
    }

    public ByteBuf setLong(int n2, long l2) {
        this.buf.setLong(n2, ByteBufUtil.swapLong(l2));
        return this;
    }

    public ByteBuf setMedium(int n2, int n3) {
        this.buf.setMedium(n2, ByteBufUtil.swapMedium(n3));
        return this;
    }

    public ByteBuf setShort(int n2, int n3) {
        this.buf.setShort(n2, (int)ByteBufUtil.swapShort((short)n3));
        return this;
    }

    public ByteBuf setZero(int n2, int n3) {
        this.buf.setZero(n2, n3);
        return this;
    }

    public ByteBuf skipBytes(int n2) {
        this.buf.skipBytes(n2);
        return this;
    }

    public ByteBuf slice() {
        return this.buf.slice().order(this.order);
    }

    public ByteBuf slice(int n2, int n3) {
        return this.buf.slice(n2, n3).order(this.order);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Swapped(");
        stringBuilder.append(this.buf.toString());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public String toString(int n2, int n3, Charset charset) {
        return this.buf.toString(n2, n3, charset);
    }

    public String toString(Charset charset) {
        return this.buf.toString(charset);
    }

    public ByteBuf unwrap() {
        return this.buf;
    }

    public int writableBytes() {
        return this.buf.writableBytes();
    }

    public ByteBuf writeBoolean(boolean bl) {
        this.buf.writeBoolean(bl);
        return this;
    }

    public ByteBuf writeByte(int n2) {
        this.buf.writeByte(n2);
        return this;
    }

    public int writeBytes(InputStream inputStream, int n2) throws IOException {
        return this.buf.writeBytes(inputStream, n2);
    }

    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int n2) throws IOException {
        return this.buf.writeBytes(scatteringByteChannel, n2);
    }

    public ByteBuf writeBytes(ByteBuf byteBuf) {
        this.buf.writeBytes(byteBuf);
        return this;
    }

    public ByteBuf writeBytes(ByteBuf byteBuf, int n2) {
        this.buf.writeBytes(byteBuf, n2);
        return this;
    }

    public ByteBuf writeBytes(ByteBuf byteBuf, int n2, int n3) {
        this.buf.writeBytes(byteBuf, n2, n3);
        return this;
    }

    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        this.buf.writeBytes(byteBuffer);
        return this;
    }

    public ByteBuf writeBytes(byte[] arrby) {
        this.buf.writeBytes(arrby);
        return this;
    }

    public ByteBuf writeBytes(byte[] arrby, int n2, int n3) {
        this.buf.writeBytes(arrby, n2, n3);
        return this;
    }

    public ByteBuf writeChar(int n2) {
        this.writeShort(n2);
        return this;
    }

    public ByteBuf writeDouble(double d2) {
        this.writeLong(Double.doubleToRawLongBits((double)d2));
        return this;
    }

    public ByteBuf writeFloat(float f2) {
        this.writeInt(Float.floatToRawIntBits((float)f2));
        return this;
    }

    public ByteBuf writeInt(int n2) {
        this.buf.writeInt(ByteBufUtil.swapInt(n2));
        return this;
    }

    public ByteBuf writeLong(long l2) {
        this.buf.writeLong(ByteBufUtil.swapLong(l2));
        return this;
    }

    public ByteBuf writeMedium(int n2) {
        this.buf.writeMedium(ByteBufUtil.swapMedium(n2));
        return this;
    }

    public ByteBuf writeShort(int n2) {
        this.buf.writeShort((int)ByteBufUtil.swapShort((short)n2));
        return this;
    }

    public ByteBuf writeZero(int n2) {
        this.buf.writeZero(n2);
        return this;
    }

    public int writerIndex() {
        return this.buf.writerIndex();
    }

    public ByteBuf writerIndex(int n2) {
        this.buf.writerIndex(n2);
        return this;
    }
}

