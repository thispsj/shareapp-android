/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.GatheringByteChannel
 *  java.nio.channels.ScatteringByteChannel
 *  java.nio.charset.Charset
 */
package io.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufProcessor;
import io.netty.buffer.SimpleLeakAwareByteBuf;
import io.netty.d.b.a.d;
import io.netty.d.b.a.e;
import io.netty.d.b.u;
import io.netty.d.l;
import io.netty.d.m;
import io.netty.d.o;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

final class AdvancedLeakAwareByteBuf
extends SimpleLeakAwareByteBuf {
    private static final boolean ACQUIRE_AND_RELEASE_ONLY = false;
    private static final String PROP_ACQUIRE_AND_RELEASE_ONLY = "io.netty.leakDetection.acquireAndReleaseOnly";
    private static final d logger = e.a(AdvancedLeakAwareByteBuf.class);

    static {
        ACQUIRE_AND_RELEASE_ONLY = u.a(PROP_ACQUIRE_AND_RELEASE_ONLY, false);
        if (logger.b()) {
            logger.b("-D{}: {}", (Object)PROP_ACQUIRE_AND_RELEASE_ONLY, (Object)ACQUIRE_AND_RELEASE_ONLY);
        }
        m.a(AdvancedLeakAwareByteBuf.class, "recordLeakNonRefCountingOperation");
    }

    AdvancedLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, o<ByteBuf> o2) {
        super(byteBuf, byteBuf2, o2);
    }

    AdvancedLeakAwareByteBuf(ByteBuf byteBuf, o<ByteBuf> o2) {
        super(byteBuf, o2);
    }

    static void recordLeakNonRefCountingOperation(o<ByteBuf> o2) {
        if (!ACQUIRE_AND_RELEASE_ONLY) {
            o2.a();
        }
    }

    @Override
    public final int bytesBefore(byte by) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(by);
    }

    @Override
    public final int bytesBefore(int n2, byte by) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(n2, by);
    }

    @Override
    public final int bytesBefore(int n2, int n3, byte by) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(n2, n3, by);
    }

    @Override
    public final ByteBuf capacity(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.capacity(n2);
    }

    @Override
    public final ByteBuf copy() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.copy();
    }

    @Override
    public final ByteBuf copy(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.copy(n2, n3);
    }

    @Override
    public final ByteBuf discardReadBytes() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.discardReadBytes();
    }

    @Override
    public final ByteBuf discardSomeReadBytes() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.discardSomeReadBytes();
    }

    @Override
    public final ByteBuf duplicate() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.duplicate();
    }

    @Override
    public final int ensureWritable(int n2, boolean bl) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.ensureWritable(n2, bl);
    }

    @Override
    public final ByteBuf ensureWritable(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.ensureWritable(n2);
    }

    @Override
    public final int forEachByte(int n2, int n3, ByteBufProcessor byteBufProcessor) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByte(n2, n3, byteBufProcessor);
    }

    @Override
    public final int forEachByte(ByteBufProcessor byteBufProcessor) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByte(byteBufProcessor);
    }

    @Override
    public final int forEachByteDesc(int n2, int n3, ByteBufProcessor byteBufProcessor) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByteDesc(n2, n3, byteBufProcessor);
    }

    @Override
    public final int forEachByteDesc(ByteBufProcessor byteBufProcessor) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByteDesc(byteBufProcessor);
    }

    @Override
    public final boolean getBoolean(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBoolean(n2);
    }

    @Override
    public final byte getByte(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getByte(n2);
    }

    @Override
    public final int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(n2, gatheringByteChannel, n3);
    }

    @Override
    public final ByteBuf getBytes(int n2, ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(n2, byteBuf);
    }

    @Override
    public final ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(n2, byteBuf, n3);
    }

    @Override
    public final ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(n2, byteBuf, n3, n4);
    }

    @Override
    public final ByteBuf getBytes(int n2, OutputStream outputStream, int n3) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(n2, outputStream, n3);
    }

    @Override
    public final ByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(n2, byteBuffer);
    }

    @Override
    public final ByteBuf getBytes(int n2, byte[] arrby) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(n2, arrby);
    }

    @Override
    public final ByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(n2, arrby, n3, n4);
    }

    @Override
    public final char getChar(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getChar(n2);
    }

    @Override
    public final double getDouble(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getDouble(n2);
    }

    @Override
    public final float getFloat(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getFloat(n2);
    }

    @Override
    public final int getInt(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getInt(n2);
    }

    @Override
    public final long getLong(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getLong(n2);
    }

    @Override
    public final int getMedium(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getMedium(n2);
    }

    @Override
    public final short getShort(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getShort(n2);
    }

    @Override
    public final short getUnsignedByte(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedByte(n2);
    }

    @Override
    public final long getUnsignedInt(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedInt(n2);
    }

    @Override
    public final int getUnsignedMedium(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedMedium(n2);
    }

    @Override
    public final int getUnsignedShort(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedShort(n2);
    }

    @Override
    public final int indexOf(int n2, int n3, byte by) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.indexOf(n2, n3, by);
    }

    @Override
    public final ByteBuffer internalNioBuffer(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.internalNioBuffer(n2, n3);
    }

    @Override
    protected final AdvancedLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, o<ByteBuf> o2) {
        return new AdvancedLeakAwareByteBuf(byteBuf, byteBuf2, o2);
    }

    @Override
    public final ByteBuffer nioBuffer() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffer();
    }

    @Override
    public final ByteBuffer nioBuffer(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffer(n2, n3);
    }

    @Override
    public final int nioBufferCount() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBufferCount();
    }

    @Override
    public final ByteBuffer[] nioBuffers() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffers();
    }

    @Override
    public final ByteBuffer[] nioBuffers(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffers(n2, n3);
    }

    @Override
    public final ByteBuf order(ByteOrder byteOrder) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.order(byteOrder);
    }

    @Override
    public final boolean readBoolean() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBoolean();
    }

    @Override
    public final byte readByte() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readByte();
    }

    @Override
    public final int readBytes(GatheringByteChannel gatheringByteChannel, int n2) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(gatheringByteChannel, n2);
    }

    @Override
    public final ByteBuf readBytes(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(n2);
    }

    @Override
    public final ByteBuf readBytes(ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf);
    }

    @Override
    public final ByteBuf readBytes(ByteBuf byteBuf, int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf, n2);
    }

    @Override
    public final ByteBuf readBytes(ByteBuf byteBuf, int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf, n2, n3);
    }

    @Override
    public final ByteBuf readBytes(OutputStream outputStream, int n2) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(outputStream, n2);
    }

    @Override
    public final ByteBuf readBytes(ByteBuffer byteBuffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuffer);
    }

    @Override
    public final ByteBuf readBytes(byte[] arrby) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(arrby);
    }

    @Override
    public final ByteBuf readBytes(byte[] arrby, int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(arrby, n2, n3);
    }

    @Override
    public final char readChar() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readChar();
    }

    @Override
    public final double readDouble() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readDouble();
    }

    @Override
    public final float readFloat() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readFloat();
    }

    @Override
    public final int readInt() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readInt();
    }

    @Override
    public final long readLong() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readLong();
    }

    @Override
    public final int readMedium() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readMedium();
    }

    @Override
    public final short readShort() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readShort();
    }

    @Override
    public final ByteBuf readSlice(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readSlice(n2);
    }

    @Override
    public final short readUnsignedByte() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedByte();
    }

    @Override
    public final long readUnsignedInt() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedInt();
    }

    @Override
    public final int readUnsignedMedium() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedMedium();
    }

    @Override
    public final int readUnsignedShort() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedShort();
    }

    @Override
    public final boolean release() {
        this.leak.a();
        return super.release();
    }

    @Override
    public final boolean release(int n2) {
        this.leak.a();
        return super.release(n2);
    }

    @Override
    public final ByteBuf retain() {
        this.leak.a();
        return super.retain();
    }

    @Override
    public final ByteBuf retain(int n2) {
        this.leak.a();
        return super.retain(n2);
    }

    @Override
    public final ByteBuf setBoolean(int n2, boolean bl) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBoolean(n2, bl);
    }

    @Override
    public final ByteBuf setByte(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setByte(n2, n3);
    }

    @Override
    public final int setBytes(int n2, InputStream inputStream, int n3) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(n2, inputStream, n3);
    }

    @Override
    public final int setBytes(int n2, ScatteringByteChannel scatteringByteChannel, int n3) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(n2, scatteringByteChannel, n3);
    }

    @Override
    public final ByteBuf setBytes(int n2, ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(n2, byteBuf);
    }

    @Override
    public final ByteBuf setBytes(int n2, ByteBuf byteBuf, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(n2, byteBuf, n3);
    }

    @Override
    public final ByteBuf setBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(n2, byteBuf, n3, n4);
    }

    @Override
    public final ByteBuf setBytes(int n2, ByteBuffer byteBuffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(n2, byteBuffer);
    }

    @Override
    public final ByteBuf setBytes(int n2, byte[] arrby) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(n2, arrby);
    }

    @Override
    public final ByteBuf setBytes(int n2, byte[] arrby, int n3, int n4) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(n2, arrby, n3, n4);
    }

    @Override
    public final ByteBuf setChar(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setChar(n2, n3);
    }

    @Override
    public final ByteBuf setDouble(int n2, double d2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setDouble(n2, d2);
    }

    @Override
    public final ByteBuf setFloat(int n2, float f2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setFloat(n2, f2);
    }

    @Override
    public final ByteBuf setInt(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setInt(n2, n3);
    }

    @Override
    public final ByteBuf setLong(int n2, long l2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setLong(n2, l2);
    }

    @Override
    public final ByteBuf setMedium(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setMedium(n2, n3);
    }

    @Override
    public final ByteBuf setShort(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setShort(n2, n3);
    }

    @Override
    public final ByteBuf setZero(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setZero(n2, n3);
    }

    @Override
    public final ByteBuf skipBytes(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.skipBytes(n2);
    }

    @Override
    public final ByteBuf slice() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.slice();
    }

    @Override
    public final ByteBuf slice(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.slice(n2, n3);
    }

    @Override
    public final String toString(int n2, int n3, Charset charset) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.toString(n2, n3, charset);
    }

    @Override
    public final String toString(Charset charset) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.toString(charset);
    }

    @Override
    public final ByteBuf writeBoolean(boolean bl) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBoolean(bl);
    }

    @Override
    public final ByteBuf writeByte(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeByte(n2);
    }

    @Override
    public final int writeBytes(InputStream inputStream, int n2) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(inputStream, n2);
    }

    @Override
    public final int writeBytes(ScatteringByteChannel scatteringByteChannel, int n2) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(scatteringByteChannel, n2);
    }

    @Override
    public final ByteBuf writeBytes(ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf);
    }

    @Override
    public final ByteBuf writeBytes(ByteBuf byteBuf, int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf, n2);
    }

    @Override
    public final ByteBuf writeBytes(ByteBuf byteBuf, int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf, n2, n3);
    }

    @Override
    public final ByteBuf writeBytes(ByteBuffer byteBuffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuffer);
    }

    @Override
    public final ByteBuf writeBytes(byte[] arrby) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(arrby);
    }

    @Override
    public final ByteBuf writeBytes(byte[] arrby, int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(arrby, n2, n3);
    }

    @Override
    public final ByteBuf writeChar(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeChar(n2);
    }

    @Override
    public final ByteBuf writeDouble(double d2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeDouble(d2);
    }

    @Override
    public final ByteBuf writeFloat(float f2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeFloat(f2);
    }

    @Override
    public final ByteBuf writeInt(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeInt(n2);
    }

    @Override
    public final ByteBuf writeLong(long l2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeLong(l2);
    }

    @Override
    public final ByteBuf writeMedium(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeMedium(n2);
    }

    @Override
    public final ByteBuf writeShort(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeShort(n2);
    }

    @Override
    public final ByteBuf writeZero(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeZero(n2);
    }
}

