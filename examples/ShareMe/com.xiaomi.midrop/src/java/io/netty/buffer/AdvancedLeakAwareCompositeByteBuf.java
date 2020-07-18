/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Iterable
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

import io.netty.buffer.AdvancedLeakAwareByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufProcessor;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.SimpleLeakAwareByteBuf;
import io.netty.buffer.SimpleLeakAwareCompositeByteBuf;
import io.netty.d.l;
import io.netty.d.o;
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

final class AdvancedLeakAwareCompositeByteBuf
extends SimpleLeakAwareCompositeByteBuf {
    AdvancedLeakAwareCompositeByteBuf(CompositeByteBuf compositeByteBuf, o<ByteBuf> o2) {
        super(compositeByteBuf, o2);
    }

    @Override
    public final CompositeByteBuf addComponent(int n2, ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponent(n2, byteBuf);
    }

    @Override
    public final CompositeByteBuf addComponent(ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponent(byteBuf);
    }

    @Override
    public final CompositeByteBuf addComponent(boolean bl, int n2, ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponent(bl, n2, byteBuf);
    }

    @Override
    public final CompositeByteBuf addComponent(boolean bl, ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponent(bl, byteBuf);
    }

    @Override
    public final CompositeByteBuf addComponents(int n2, Iterable<ByteBuf> iterable) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(n2, iterable);
    }

    @Override
    public final /* varargs */ CompositeByteBuf addComponents(int n2, ByteBuf ... arrbyteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(n2, arrbyteBuf);
    }

    @Override
    public final CompositeByteBuf addComponents(Iterable<ByteBuf> iterable) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(iterable);
    }

    @Override
    public final CompositeByteBuf addComponents(boolean bl, Iterable<ByteBuf> iterable) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(bl, iterable);
    }

    @Override
    public final /* varargs */ CompositeByteBuf addComponents(boolean bl, ByteBuf ... arrbyteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(bl, arrbyteBuf);
    }

    @Override
    public final /* varargs */ CompositeByteBuf addComponents(ByteBuf ... arrbyteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(arrbyteBuf);
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
    public final CompositeByteBuf capacity(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.capacity(n2);
    }

    @Override
    public final CompositeByteBuf consolidate() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.consolidate();
    }

    @Override
    public final CompositeByteBuf consolidate(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.consolidate(n2, n3);
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
    public final List<ByteBuf> decompose(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.decompose(n2, n3);
    }

    @Override
    public final CompositeByteBuf discardReadBytes() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.discardReadBytes();
    }

    @Override
    public final CompositeByteBuf discardReadComponents() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.discardReadComponents();
    }

    @Override
    public final CompositeByteBuf discardSomeReadBytes() {
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
    public final CompositeByteBuf ensureWritable(int n2) {
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
    public final CompositeByteBuf getBytes(int n2, ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(n2, byteBuf);
    }

    @Override
    public final CompositeByteBuf getBytes(int n2, ByteBuf byteBuf, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(n2, byteBuf, n3);
    }

    @Override
    public final CompositeByteBuf getBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(n2, byteBuf, n3, n4);
    }

    @Override
    public final CompositeByteBuf getBytes(int n2, OutputStream outputStream, int n3) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(n2, outputStream, n3);
    }

    @Override
    public final CompositeByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(n2, byteBuffer);
    }

    @Override
    public final CompositeByteBuf getBytes(int n2, byte[] arrby) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(n2, arrby);
    }

    @Override
    public final CompositeByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
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
    public final Iterator<ByteBuf> iterator() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.iterator();
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
    public final CompositeByteBuf readBytes(ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf);
    }

    @Override
    public final CompositeByteBuf readBytes(ByteBuf byteBuf, int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf, n2);
    }

    @Override
    public final CompositeByteBuf readBytes(ByteBuf byteBuf, int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf, n2, n3);
    }

    @Override
    public final CompositeByteBuf readBytes(OutputStream outputStream, int n2) throws IOException {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(outputStream, n2);
    }

    @Override
    public final CompositeByteBuf readBytes(ByteBuffer byteBuffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuffer);
    }

    @Override
    public final CompositeByteBuf readBytes(byte[] arrby) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(arrby);
    }

    @Override
    public final CompositeByteBuf readBytes(byte[] arrby, int n2, int n3) {
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
    public final CompositeByteBuf removeComponent(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.removeComponent(n2);
    }

    @Override
    public final CompositeByteBuf removeComponents(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.removeComponents(n2, n3);
    }

    @Override
    public final CompositeByteBuf retain() {
        this.leak.a();
        return super.retain();
    }

    @Override
    public final CompositeByteBuf retain(int n2) {
        this.leak.a();
        return super.retain(n2);
    }

    @Override
    public final CompositeByteBuf setBoolean(int n2, boolean bl) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBoolean(n2, bl);
    }

    @Override
    public final CompositeByteBuf setByte(int n2, int n3) {
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
    public final CompositeByteBuf setBytes(int n2, ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(n2, byteBuf);
    }

    @Override
    public final CompositeByteBuf setBytes(int n2, ByteBuf byteBuf, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(n2, byteBuf, n3);
    }

    @Override
    public final CompositeByteBuf setBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(n2, byteBuf, n3, n4);
    }

    @Override
    public final CompositeByteBuf setBytes(int n2, ByteBuffer byteBuffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(n2, byteBuffer);
    }

    @Override
    public final CompositeByteBuf setBytes(int n2, byte[] arrby) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(n2, arrby);
    }

    @Override
    public final CompositeByteBuf setBytes(int n2, byte[] arrby, int n3, int n4) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(n2, arrby, n3, n4);
    }

    @Override
    public final CompositeByteBuf setChar(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setChar(n2, n3);
    }

    @Override
    public final CompositeByteBuf setDouble(int n2, double d2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setDouble(n2, d2);
    }

    @Override
    public final CompositeByteBuf setFloat(int n2, float f2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setFloat(n2, f2);
    }

    @Override
    public final CompositeByteBuf setInt(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setInt(n2, n3);
    }

    @Override
    public final CompositeByteBuf setLong(int n2, long l2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setLong(n2, l2);
    }

    @Override
    public final CompositeByteBuf setMedium(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setMedium(n2, n3);
    }

    @Override
    public final CompositeByteBuf setShort(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setShort(n2, n3);
    }

    @Override
    public final CompositeByteBuf setZero(int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setZero(n2, n3);
    }

    @Override
    public final CompositeByteBuf skipBytes(int n2) {
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
    public final CompositeByteBuf writeBoolean(boolean bl) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBoolean(bl);
    }

    @Override
    public final CompositeByteBuf writeByte(int n2) {
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
    public final CompositeByteBuf writeBytes(ByteBuf byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf);
    }

    @Override
    public final CompositeByteBuf writeBytes(ByteBuf byteBuf, int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf, n2);
    }

    @Override
    public final CompositeByteBuf writeBytes(ByteBuf byteBuf, int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf, n2, n3);
    }

    @Override
    public final CompositeByteBuf writeBytes(ByteBuffer byteBuffer) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuffer);
    }

    @Override
    public final CompositeByteBuf writeBytes(byte[] arrby) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(arrby);
    }

    @Override
    public final CompositeByteBuf writeBytes(byte[] arrby, int n2, int n3) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(arrby, n2, n3);
    }

    @Override
    public final CompositeByteBuf writeChar(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeChar(n2);
    }

    @Override
    public final CompositeByteBuf writeDouble(double d2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeDouble(d2);
    }

    @Override
    public final CompositeByteBuf writeFloat(float f2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeFloat(f2);
    }

    @Override
    public final CompositeByteBuf writeInt(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeInt(n2);
    }

    @Override
    public final CompositeByteBuf writeLong(long l2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeLong(l2);
    }

    @Override
    public final CompositeByteBuf writeMedium(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeMedium(n2);
    }

    @Override
    public final CompositeByteBuf writeShort(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeShort(n2);
    }

    @Override
    public final CompositeByteBuf writeZero(int n2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeZero(n2);
    }
}

