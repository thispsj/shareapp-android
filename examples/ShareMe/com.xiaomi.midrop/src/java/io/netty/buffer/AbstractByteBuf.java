/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Math
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
import io.netty.buffer.DuplicatedAbstractByteBuf;
import io.netty.buffer.SlicedAbstractByteBuf;
import io.netty.buffer.SwappedByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.d.b.a.d;
import io.netty.d.b.a.e;
import io.netty.d.b.j;
import io.netty.d.b.t;
import io.netty.d.b.u;
import io.netty.d.f;
import io.netty.d.m;
import io.netty.d.n;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

public abstract class AbstractByteBuf
extends ByteBuf {
    private static final String PROP_MODE = "io.netty.buffer.bytebuf.checkAccessible";
    private static final boolean checkAccessible;
    static final m<ByteBuf> leakDetector;
    private static final d logger;
    private int markedReaderIndex;
    private int markedWriterIndex;
    private int maxCapacity;
    int readerIndex;
    private SwappedByteBuf swappedBuf;
    int writerIndex;

    static {
        logger = e.a(AbstractByteBuf.class);
        checkAccessible = u.a(PROP_MODE, true);
        if (logger.b()) {
            logger.b("-D{}: {}", (Object)PROP_MODE, (Object)checkAccessible);
        }
        leakDetector = n.a().b(ByteBuf.class);
    }

    protected AbstractByteBuf(int n2) {
        if (n2 < 0) {
            StringBuilder stringBuilder = new StringBuilder("maxCapacity: ");
            stringBuilder.append(n2);
            stringBuilder.append(" (expected: >= 0)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.maxCapacity = n2;
    }

    private int calculateNewCapacity(int n2) {
        int n3;
        int n4 = this.maxCapacity;
        if (n2 == 4194304) {
            return 4194304;
        }
        if (n2 > 4194304) {
            int n5 = 4194304 * (n2 / 4194304);
            if (n5 > n4 - 4194304) {
                return n4;
            }
            return n5 + 4194304;
        }
        for (n3 = 64; n3 < n2; n3 <<= 1) {
        }
        return Math.min((int)n3, (int)n4);
    }

    private void checkReadableBytes0(int n2) {
        this.ensureAccessible();
        if (this.readerIndex > this.writerIndex - n2) {
            Object[] arrobject = new Object[]{this.readerIndex, n2, this.writerIndex, this};
            throw new IndexOutOfBoundsException(String.format((String)"readerIndex(%d) + length(%d) exceeds writerIndex(%d): %s", (Object[])arrobject));
        }
    }

    private int forEachByteAsc0(int n2, int n3, ByteBufProcessor byteBufProcessor) throws Exception {
        while (n2 < n3) {
            if (!byteBufProcessor.process(this._getByte(n2))) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    private int forEachByteDesc0(int n2, int n3, ByteBufProcessor byteBufProcessor) throws Exception {
        while (n2 >= n3) {
            if (!byteBufProcessor.process(this._getByte(n2))) {
                return n2;
            }
            --n2;
        }
        return -1;
    }

    protected abstract byte _getByte(int var1);

    protected abstract int _getInt(int var1);

    protected abstract long _getLong(int var1);

    protected abstract short _getShort(int var1);

    protected abstract int _getUnsignedMedium(int var1);

    protected abstract void _setByte(int var1, int var2);

    protected abstract void _setInt(int var1, int var2);

    protected abstract void _setLong(int var1, long var2);

    protected abstract void _setMedium(int var1, int var2);

    protected abstract void _setShort(int var1, int var2);

    protected final void adjustMarkers(int n2) {
        int n3 = this.markedReaderIndex;
        if (n3 <= n2) {
            this.markedReaderIndex = 0;
            int n4 = this.markedWriterIndex;
            if (n4 <= n2) {
                this.markedWriterIndex = 0;
                return;
            }
            this.markedWriterIndex = n4 - n2;
            return;
        }
        this.markedReaderIndex = n3 - n2;
        this.markedWriterIndex -= n2;
    }

    public int bytesBefore(byte by) {
        return this.bytesBefore(this.readerIndex(), this.readableBytes(), by);
    }

    public int bytesBefore(int n2, byte by) {
        this.checkReadableBytes(n2);
        return this.bytesBefore(this.readerIndex(), n2, by);
    }

    public int bytesBefore(int n2, int n3, byte by) {
        int n4 = this.indexOf(n2, n3 + n2, by);
        if (n4 < 0) {
            return -1;
        }
        return n4 - n2;
    }

    protected final void checkDstIndex(int n2, int n3, int n4, int n5) {
        this.checkIndex(n2, n3);
        if (j.a(n4, n3, n5)) {
            Object[] arrobject = new Object[]{n4, n3, n5};
            throw new IndexOutOfBoundsException(String.format((String)"dstIndex: %d, length: %d (expected: range(0, %d))", (Object[])arrobject));
        }
    }

    protected final void checkIndex(int n2) {
        this.checkIndex(n2, 1);
    }

    protected final void checkIndex(int n2, int n3) {
        this.ensureAccessible();
        this.checkIndex0(n2, n3);
    }

    final void checkIndex0(int n2, int n3) {
        if (j.a(n2, n3, this.capacity())) {
            Object[] arrobject = new Object[]{n2, n3, this.capacity()};
            throw new IndexOutOfBoundsException(String.format((String)"index: %d, length: %d (expected: range(0, %d))", (Object[])arrobject));
        }
    }

    protected final void checkNewCapacity(int n2) {
        this.ensureAccessible();
        if (n2 >= 0 && n2 <= this.maxCapacity()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("newCapacity: ");
        stringBuilder.append(n2);
        stringBuilder.append(" (expected: 0-");
        stringBuilder.append(this.maxCapacity());
        stringBuilder.append(')');
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    protected final void checkReadableBytes(int n2) {
        if (n2 < 0) {
            StringBuilder stringBuilder = new StringBuilder("minimumReadableBytes: ");
            stringBuilder.append(n2);
            stringBuilder.append(" (expected: >= 0)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        AbstractByteBuf.super.checkReadableBytes0(n2);
    }

    protected final void checkSrcIndex(int n2, int n3, int n4, int n5) {
        this.checkIndex(n2, n3);
        if (j.a(n4, n3, n5)) {
            Object[] arrobject = new Object[]{n4, n3, n5};
            throw new IndexOutOfBoundsException(String.format((String)"srcIndex: %d, length: %d (expected: range(0, %d))", (Object[])arrobject));
        }
    }

    public ByteBuf clear() {
        this.writerIndex = 0;
        this.readerIndex = 0;
        return this;
    }

    public int compareTo(ByteBuf byteBuf) {
        return ByteBufUtil.compare((ByteBuf)this, byteBuf);
    }

    public ByteBuf copy() {
        return this.copy(this.readerIndex, this.readableBytes());
    }

    final void discardMarks() {
        this.markedWriterIndex = 0;
        this.markedReaderIndex = 0;
    }

    public ByteBuf discardReadBytes() {
        this.ensureAccessible();
        if (this.readerIndex == 0) {
            return this;
        }
        if (this.readerIndex != this.writerIndex) {
            this.setBytes(0, (ByteBuf)this, this.readerIndex, this.writerIndex - this.readerIndex);
            this.writerIndex -= this.readerIndex;
            this.adjustMarkers(this.readerIndex);
            this.readerIndex = 0;
            return this;
        }
        this.adjustMarkers(this.readerIndex);
        this.readerIndex = 0;
        this.writerIndex = 0;
        return this;
    }

    public ByteBuf discardSomeReadBytes() {
        this.ensureAccessible();
        if (this.readerIndex == 0) {
            return this;
        }
        if (this.readerIndex == this.writerIndex) {
            this.adjustMarkers(this.readerIndex);
            this.readerIndex = 0;
            this.writerIndex = 0;
            return this;
        }
        if (this.readerIndex >= this.capacity() >>> 1) {
            this.setBytes(0, (ByteBuf)this, this.readerIndex, this.writerIndex - this.readerIndex);
            this.writerIndex -= this.readerIndex;
            this.adjustMarkers(this.readerIndex);
            this.readerIndex = 0;
        }
        return this;
    }

    public ByteBuf duplicate() {
        return new DuplicatedAbstractByteBuf(this);
    }

    protected final void ensureAccessible() {
        if (checkAccessible && this.refCnt() == 0) {
            throw new f(0);
        }
    }

    public int ensureWritable(int n2, boolean bl) {
        int n3;
        this.ensureAccessible();
        if (n2 < 0) {
            Object[] arrobject = new Object[]{n2};
            throw new IllegalArgumentException(String.format((String)"minWritableBytes: %d (expected: >= 0)", (Object[])arrobject));
        }
        if (n2 <= this.writableBytes()) {
            return 0;
        }
        int n4 = this.maxCapacity();
        if (n2 > n4 - (n3 = this.writerIndex())) {
            if (bl) {
                if (this.capacity() == n4) {
                    return 1;
                }
                this.capacity(n4);
                return 3;
            }
            return 1;
        }
        this.capacity(AbstractByteBuf.super.calculateNewCapacity(n3 + n2));
        return 2;
    }

    public ByteBuf ensureWritable(int n2) {
        if (n2 < 0) {
            Object[] arrobject = new Object[]{n2};
            throw new IllegalArgumentException(String.format((String)"minWritableBytes: %d (expected: >= 0)", (Object[])arrobject));
        }
        this.ensureWritable0(n2);
        return this;
    }

    final void ensureWritable0(int n2) {
        this.ensureAccessible();
        if (n2 <= this.writableBytes()) {
            return;
        }
        if (n2 > this.maxCapacity - this.writerIndex) {
            Object[] arrobject = new Object[]{this.writerIndex, n2, this.maxCapacity, this};
            throw new IndexOutOfBoundsException(String.format((String)"writerIndex(%d) + minWritableBytes(%d) exceeds maxCapacity(%d): %s", (Object[])arrobject));
        }
        this.capacity(AbstractByteBuf.super.calculateNewCapacity(n2 + this.writerIndex));
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
        this.checkIndex(n2, n3);
        int n4 = n3 + n2;
        try {
            int n5 = AbstractByteBuf.super.forEachByteAsc0(n2, n4, byteBufProcessor);
            return n5;
        }
        catch (Exception exception) {
            io.netty.d.b.n.a(exception);
            return -1;
        }
    }

    public int forEachByte(ByteBufProcessor byteBufProcessor) {
        this.ensureAccessible();
        try {
            int n2 = AbstractByteBuf.super.forEachByteAsc0(this.readerIndex, this.writerIndex, byteBufProcessor);
            return n2;
        }
        catch (Exception exception) {
            io.netty.d.b.n.a(exception);
            return -1;
        }
    }

    public int forEachByteDesc(int n2, int n3, ByteBufProcessor byteBufProcessor) {
        this.checkIndex(n2, n3);
        int n4 = -1 + (n3 + n2);
        try {
            int n5 = AbstractByteBuf.super.forEachByteDesc0(n4, n2, byteBufProcessor);
            return n5;
        }
        catch (Exception exception) {
            io.netty.d.b.n.a(exception);
            return -1;
        }
    }

    public int forEachByteDesc(ByteBufProcessor byteBufProcessor) {
        this.ensureAccessible();
        try {
            int n2 = AbstractByteBuf.super.forEachByteDesc0(-1 + this.writerIndex, this.readerIndex, byteBufProcessor);
            return n2;
        }
        catch (Exception exception) {
            io.netty.d.b.n.a(exception);
            return -1;
        }
    }

    public boolean getBoolean(int n2) {
        return this.getByte(n2) != 0;
    }

    public byte getByte(int n2) {
        this.checkIndex(n2);
        return this._getByte(n2);
    }

    public ByteBuf getBytes(int n2, ByteBuf byteBuf) {
        this.getBytes(n2, byteBuf, byteBuf.writableBytes());
        return this;
    }

    public ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3) {
        this.getBytes(n2, byteBuf, byteBuf.writerIndex(), n3);
        byteBuf.writerIndex(n3 + byteBuf.writerIndex());
        return this;
    }

    public ByteBuf getBytes(int n2, byte[] arrby) {
        this.getBytes(n2, arrby, 0, arrby.length);
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
        this.checkIndex(n2, 4);
        return this._getInt(n2);
    }

    public long getLong(int n2) {
        this.checkIndex(n2, 8);
        return this._getLong(n2);
    }

    public int getMedium(int n2) {
        int n3 = this.getUnsignedMedium(n2);
        if ((8388608 & n3) != 0) {
            n3 |= -16777216;
        }
        return n3;
    }

    public short getShort(int n2) {
        this.checkIndex(n2, 2);
        return this._getShort(n2);
    }

    public short getUnsignedByte(int n2) {
        return (short)(255 & this.getByte(n2));
    }

    public long getUnsignedInt(int n2) {
        return 0xFFFFFFFFL & (long)this.getInt(n2);
    }

    public int getUnsignedMedium(int n2) {
        this.checkIndex(n2, 3);
        return this._getUnsignedMedium(n2);
    }

    public int getUnsignedShort(int n2) {
        return 65535 & this.getShort(n2);
    }

    public int hashCode() {
        return ByteBufUtil.hashCode(this);
    }

    public int indexOf(int n2, int n3, byte by) {
        return ByteBufUtil.indexOf((ByteBuf)this, n2, n3, by);
    }

    public boolean isReadable() {
        return this.writerIndex > this.readerIndex;
    }

    public boolean isReadable(int n2) {
        return this.writerIndex - this.readerIndex >= n2;
    }

    public boolean isWritable() {
        return this.capacity() > this.writerIndex;
    }

    public boolean isWritable(int n2) {
        return this.capacity() - this.writerIndex >= n2;
    }

    public ByteBuf markReaderIndex() {
        this.markedReaderIndex = this.readerIndex;
        return this;
    }

    public ByteBuf markWriterIndex() {
        this.markedWriterIndex = this.writerIndex;
        return this;
    }

    public int maxCapacity() {
        return this.maxCapacity;
    }

    protected final void maxCapacity(int n2) {
        this.maxCapacity = n2;
    }

    public int maxWritableBytes() {
        return this.maxCapacity() - this.writerIndex;
    }

    protected SwappedByteBuf newSwappedByteBuf() {
        return new SwappedByteBuf(this);
    }

    public ByteBuffer nioBuffer() {
        return this.nioBuffer(this.readerIndex, this.readableBytes());
    }

    public ByteBuffer[] nioBuffers() {
        return this.nioBuffers(this.readerIndex, this.readableBytes());
    }

    public ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        }
        if (byteOrder == this.order()) {
            return this;
        }
        SwappedByteBuf swappedByteBuf = this.swappedBuf;
        if (swappedByteBuf == null) {
            this.swappedBuf = swappedByteBuf = this.newSwappedByteBuf();
        }
        return swappedByteBuf;
    }

    public boolean readBoolean() {
        return this.readByte() != 0;
    }

    public byte readByte() {
        this.checkReadableBytes0(1);
        int n2 = this.readerIndex;
        byte by = this._getByte(n2);
        this.readerIndex = n2 + 1;
        return by;
    }

    public int readBytes(GatheringByteChannel gatheringByteChannel, int n2) throws IOException {
        this.checkReadableBytes(n2);
        int n3 = this.getBytes(this.readerIndex, gatheringByteChannel, n2);
        this.readerIndex = n3 + this.readerIndex;
        return n3;
    }

    public ByteBuf readBytes(int n2) {
        this.checkReadableBytes(n2);
        if (n2 == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBuf byteBuf = this.alloc().buffer(n2, this.maxCapacity);
        byteBuf.writeBytes((ByteBuf)this, this.readerIndex, n2);
        this.readerIndex = n2 + this.readerIndex;
        return byteBuf;
    }

    public ByteBuf readBytes(ByteBuf byteBuf) {
        this.readBytes(byteBuf, byteBuf.writableBytes());
        return this;
    }

    public ByteBuf readBytes(ByteBuf byteBuf, int n2) {
        if (n2 > byteBuf.writableBytes()) {
            Object[] arrobject = new Object[]{n2, byteBuf.writableBytes(), byteBuf};
            throw new IndexOutOfBoundsException(String.format((String)"length(%d) exceeds dst.writableBytes(%d) where dst is: %s", (Object[])arrobject));
        }
        this.readBytes(byteBuf, byteBuf.writerIndex(), n2);
        byteBuf.writerIndex(n2 + byteBuf.writerIndex());
        return this;
    }

    public ByteBuf readBytes(ByteBuf byteBuf, int n2, int n3) {
        this.checkReadableBytes(n3);
        this.getBytes(this.readerIndex, byteBuf, n2, n3);
        this.readerIndex = n3 + this.readerIndex;
        return this;
    }

    public ByteBuf readBytes(OutputStream outputStream, int n2) throws IOException {
        this.checkReadableBytes(n2);
        this.getBytes(this.readerIndex, outputStream, n2);
        this.readerIndex = n2 + this.readerIndex;
        return this;
    }

    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.remaining();
        this.checkReadableBytes(n2);
        this.getBytes(this.readerIndex, byteBuffer);
        this.readerIndex = n2 + this.readerIndex;
        return this;
    }

    public ByteBuf readBytes(byte[] arrby) {
        this.readBytes(arrby, 0, arrby.length);
        return this;
    }

    public ByteBuf readBytes(byte[] arrby, int n2, int n3) {
        this.checkReadableBytes(n3);
        this.getBytes(this.readerIndex, arrby, n2, n3);
        this.readerIndex = n3 + this.readerIndex;
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
        this.checkReadableBytes0(4);
        int n2 = this._getInt(this.readerIndex);
        this.readerIndex = 4 + this.readerIndex;
        return n2;
    }

    public long readLong() {
        this.checkReadableBytes0(8);
        long l2 = this._getLong(this.readerIndex);
        this.readerIndex = 8 + this.readerIndex;
        return l2;
    }

    public int readMedium() {
        int n2 = this.readUnsignedMedium();
        if ((8388608 & n2) != 0) {
            n2 |= -16777216;
        }
        return n2;
    }

    public short readShort() {
        this.checkReadableBytes0(2);
        short s2 = this._getShort(this.readerIndex);
        this.readerIndex = 2 + this.readerIndex;
        return s2;
    }

    public ByteBuf readSlice(int n2) {
        this.checkReadableBytes(n2);
        ByteBuf byteBuf = this.slice(this.readerIndex, n2);
        this.readerIndex = n2 + this.readerIndex;
        return byteBuf;
    }

    public short readUnsignedByte() {
        return (short)(255 & this.readByte());
    }

    public long readUnsignedInt() {
        return 0xFFFFFFFFL & (long)this.readInt();
    }

    public int readUnsignedMedium() {
        this.checkReadableBytes0(3);
        int n2 = this._getUnsignedMedium(this.readerIndex);
        this.readerIndex = 3 + this.readerIndex;
        return n2;
    }

    public int readUnsignedShort() {
        return 65535 & this.readShort();
    }

    public int readableBytes() {
        return this.writerIndex - this.readerIndex;
    }

    public int readerIndex() {
        return this.readerIndex;
    }

    public ByteBuf readerIndex(int n2) {
        if (n2 >= 0 && n2 <= this.writerIndex) {
            this.readerIndex = n2;
            return this;
        }
        Object[] arrobject = new Object[]{n2, this.writerIndex};
        throw new IndexOutOfBoundsException(String.format((String)"readerIndex: %d (expected: 0 <= readerIndex <= writerIndex(%d))", (Object[])arrobject));
    }

    public ByteBuf resetReaderIndex() {
        this.readerIndex(this.markedReaderIndex);
        return this;
    }

    public ByteBuf resetWriterIndex() {
        this.writerIndex = this.markedWriterIndex;
        return this;
    }

    public ByteBuf setBoolean(int n2, boolean bl) {
        this.setByte(n2, (int)bl);
        return this;
    }

    public ByteBuf setByte(int n2, int n3) {
        this.checkIndex(n2);
        this._setByte(n2, n3);
        return this;
    }

    public ByteBuf setBytes(int n2, ByteBuf byteBuf) {
        this.setBytes(n2, byteBuf, byteBuf.readableBytes());
        return this;
    }

    public ByteBuf setBytes(int n2, ByteBuf byteBuf, int n3) {
        this.checkIndex(n2, n3);
        if (byteBuf == null) {
            throw new NullPointerException("src");
        }
        if (n3 > byteBuf.readableBytes()) {
            Object[] arrobject = new Object[]{n3, byteBuf.readableBytes(), byteBuf};
            throw new IndexOutOfBoundsException(String.format((String)"length(%d) exceeds src.readableBytes(%d) where src is: %s", (Object[])arrobject));
        }
        this.setBytes(n2, byteBuf, byteBuf.readerIndex(), n3);
        byteBuf.readerIndex(n3 + byteBuf.readerIndex());
        return this;
    }

    public ByteBuf setBytes(int n2, byte[] arrby) {
        this.setBytes(n2, arrby, 0, arrby.length);
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
        if (n2 >= 0 && n2 <= n3 && n3 <= this.capacity()) {
            this.setIndex0(n2, n3);
            return this;
        }
        Object[] arrobject = new Object[]{n2, n3, this.capacity()};
        throw new IndexOutOfBoundsException(String.format((String)"readerIndex: %d, writerIndex: %d (expected: 0 <= readerIndex <= writerIndex <= capacity(%d))", (Object[])arrobject));
    }

    final void setIndex0(int n2, int n3) {
        this.readerIndex = n2;
        this.writerIndex = n3;
    }

    public ByteBuf setInt(int n2, int n3) {
        this.checkIndex(n2, 4);
        this._setInt(n2, n3);
        return this;
    }

    public ByteBuf setLong(int n2, long l2) {
        this.checkIndex(n2, 8);
        this._setLong(n2, l2);
        return this;
    }

    public ByteBuf setMedium(int n2, int n3) {
        this.checkIndex(n2, 3);
        this._setMedium(n2, n3);
        return this;
    }

    public ByteBuf setShort(int n2, int n3) {
        this.checkIndex(n2, 2);
        this._setShort(n2, n3);
        return this;
    }

    public ByteBuf setZero(int n2, int n3) {
        if (n3 == 0) {
            return this;
        }
        this.checkIndex(n2, n3);
        int n4 = n3 & 7;
        for (int i2 = n3 >>> 3; i2 > 0; --i2) {
            this._setLong(n2, 0L);
            n2 += 8;
        }
        if (n4 == 4) {
            this._setInt(n2, 0);
            return this;
        }
        if (n4 < 4) {
            while (n4 > 0) {
                this._setByte(n2, 0);
                ++n2;
                --n4;
            }
        } else {
            this._setInt(n2, 0);
            int n5 = n2 + 4;
            for (int i3 = n4 - 4; i3 > 0; --i3) {
                this._setByte(n5, 0);
                ++n5;
            }
        }
        return this;
    }

    public ByteBuf skipBytes(int n2) {
        this.checkReadableBytes(n2);
        this.readerIndex = n2 + this.readerIndex;
        return this;
    }

    public ByteBuf slice() {
        return this.slice(this.readerIndex, this.readableBytes());
    }

    public ByteBuf slice(int n2, int n3) {
        return new SlicedAbstractByteBuf((AbstractByteBuf)this, n2, n3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String toString() {
        StringBuilder stringBuilder;
        ByteBuf byteBuf;
        if (this.refCnt() == 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(t.a((Object)((Object)this)));
            stringBuilder.append("(freed)");
            do {
                return stringBuilder.toString();
                break;
            } while (true);
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(t.a((Object)((Object)this)));
        stringBuilder.append("(ridx: ");
        stringBuilder.append(this.readerIndex);
        stringBuilder.append(", widx: ");
        stringBuilder.append(this.writerIndex);
        stringBuilder.append(", cap: ");
        stringBuilder.append(this.capacity());
        if (this.maxCapacity != Integer.MAX_VALUE) {
            stringBuilder.append('/');
            stringBuilder.append(this.maxCapacity);
        }
        if ((byteBuf = this.unwrap()) != null) {
            stringBuilder.append(", unwrapped: ");
            stringBuilder.append((Object)byteBuf);
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public String toString(int n2, int n3, Charset charset) {
        return ByteBufUtil.decodeString((ByteBuf)this, n2, n3, charset);
    }

    public String toString(Charset charset) {
        return this.toString(this.readerIndex, this.readableBytes(), charset);
    }

    public int writableBytes() {
        return this.capacity() - this.writerIndex;
    }

    public ByteBuf writeBoolean(boolean bl) {
        this.writeByte((int)bl);
        return this;
    }

    public ByteBuf writeByte(int n2) {
        this.ensureWritable0(1);
        int n3 = this.writerIndex;
        this.writerIndex = n3 + 1;
        this._setByte(n3, n2);
        return this;
    }

    public int writeBytes(InputStream inputStream, int n2) throws IOException {
        this.ensureWritable(n2);
        int n3 = this.setBytes(this.writerIndex, inputStream, n2);
        if (n3 > 0) {
            this.writerIndex = n3 + this.writerIndex;
        }
        return n3;
    }

    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int n2) throws IOException {
        this.ensureWritable(n2);
        int n3 = this.setBytes(this.writerIndex, scatteringByteChannel, n2);
        if (n3 > 0) {
            this.writerIndex = n3 + this.writerIndex;
        }
        return n3;
    }

    public ByteBuf writeBytes(ByteBuf byteBuf) {
        this.writeBytes(byteBuf, byteBuf.readableBytes());
        return this;
    }

    public ByteBuf writeBytes(ByteBuf byteBuf, int n2) {
        if (n2 > byteBuf.readableBytes()) {
            Object[] arrobject = new Object[]{n2, byteBuf.readableBytes(), byteBuf};
            throw new IndexOutOfBoundsException(String.format((String)"length(%d) exceeds src.readableBytes(%d) where src is: %s", (Object[])arrobject));
        }
        this.writeBytes(byteBuf, byteBuf.readerIndex(), n2);
        byteBuf.readerIndex(n2 + byteBuf.readerIndex());
        return this;
    }

    public ByteBuf writeBytes(ByteBuf byteBuf, int n2, int n3) {
        this.ensureWritable(n3);
        this.setBytes(this.writerIndex, byteBuf, n2, n3);
        this.writerIndex = n3 + this.writerIndex;
        return this;
    }

    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.remaining();
        this.ensureWritable0(n2);
        this.setBytes(this.writerIndex, byteBuffer);
        this.writerIndex = n2 + this.writerIndex;
        return this;
    }

    public ByteBuf writeBytes(byte[] arrby) {
        this.writeBytes(arrby, 0, arrby.length);
        return this;
    }

    public ByteBuf writeBytes(byte[] arrby, int n2, int n3) {
        this.ensureWritable(n3);
        this.setBytes(this.writerIndex, arrby, n2, n3);
        this.writerIndex = n3 + this.writerIndex;
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
        this.ensureWritable0(4);
        this._setInt(this.writerIndex, n2);
        this.writerIndex = 4 + this.writerIndex;
        return this;
    }

    public ByteBuf writeLong(long l2) {
        this.ensureWritable0(8);
        this._setLong(this.writerIndex, l2);
        this.writerIndex = 8 + this.writerIndex;
        return this;
    }

    public ByteBuf writeMedium(int n2) {
        this.ensureWritable0(3);
        this._setMedium(this.writerIndex, n2);
        this.writerIndex = 3 + this.writerIndex;
        return this;
    }

    public ByteBuf writeShort(int n2) {
        this.ensureWritable0(2);
        this._setShort(this.writerIndex, n2);
        this.writerIndex = 2 + this.writerIndex;
        return this;
    }

    public ByteBuf writeZero(int n2) {
        if (n2 == 0) {
            return this;
        }
        this.ensureWritable(n2);
        int n3 = this.writerIndex;
        this.checkIndex0(n3, n2);
        int n4 = n2 & 7;
        for (int i2 = n2 >>> 3; i2 > 0; --i2) {
            this._setLong(n3, 0L);
            n3 += 8;
        }
        if (n4 == 4) {
            this._setInt(n3, 0);
            n3 += 4;
        } else if (n4 < 4) {
            while (n4 > 0) {
                this._setByte(n3, 0);
                ++n3;
                --n4;
            }
        } else {
            this._setInt(n3, 0);
            n3 += 4;
            for (int i3 = n4 - 4; i3 > 0; --i3) {
                this._setByte(n3, 0);
                ++n3;
            }
        }
        this.writerIndex = n3;
        return this;
    }

    public int writerIndex() {
        return this.writerIndex;
    }

    public ByteBuf writerIndex(int n2) {
        if (n2 >= this.readerIndex && n2 <= this.capacity()) {
            this.writerIndex = n2;
            return this;
        }
        Object[] arrobject = new Object[]{n2, this.readerIndex, this.capacity()};
        throw new IndexOutOfBoundsException(String.format((String)"writerIndex: %d (expected: readerIndex(%d) <= writerIndex <= capacity(%d))", (Object[])arrobject));
    }
}

