/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.ReadOnlyBufferException
 *  java.nio.channels.GatheringByteChannel
 *  java.nio.channels.ScatteringByteChannel
 *  java.nio.charset.Charset
 */
package io.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufProcessor;
import io.netty.d.b.e;
import io.netty.d.b.t;
import io.netty.d.l;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

public final class EmptyByteBuf
extends ByteBuf {
    private static final ByteBuffer EMPTY_BYTE_BUFFER;
    private static final long EMPTY_BYTE_BUFFER_ADDRESS;
    private final ByteBufAllocator alloc;
    private final ByteOrder order;
    private final String str;
    private EmptyByteBuf swapped;

    /*
     * Exception decompiling
     */
    static {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public EmptyByteBuf(ByteBufAllocator byteBufAllocator) {
        super(byteBufAllocator, ByteOrder.BIG_ENDIAN);
    }

    private EmptyByteBuf(ByteBufAllocator byteBufAllocator, ByteOrder byteOrder) {
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        this.alloc = byteBufAllocator;
        this.order = byteOrder;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(t.a(this));
        String string2 = byteOrder == ByteOrder.BIG_ENDIAN ? "BE" : "LE";
        stringBuilder.append(string2);
        this.str = stringBuilder.toString();
    }

    private ByteBuf checkIndex(int n2) {
        if (n2 != 0) {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    private ByteBuf checkIndex(int n2, int n3) {
        if (n3 < 0) {
            StringBuilder stringBuilder = new StringBuilder("length: ");
            stringBuilder.append(n3);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n2 == 0 && n3 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    private ByteBuf checkLength(int n2) {
        if (n2 < 0) {
            StringBuilder stringBuilder = new StringBuilder("length: ");
            stringBuilder.append(n2);
            stringBuilder.append(" (expected: >= 0)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n2 != 0) {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    public final ByteBufAllocator alloc() {
        return this.alloc;
    }

    public final byte[] array() {
        return e.a;
    }

    public final int arrayOffset() {
        return 0;
    }

    public final int bytesBefore(byte by) {
        return -1;
    }

    public final int bytesBefore(int n2, byte by) {
        EmptyByteBuf.super.checkLength(n2);
        return -1;
    }

    public final int bytesBefore(int n2, int n3, byte by) {
        EmptyByteBuf.super.checkIndex(n2, n3);
        return -1;
    }

    public final int capacity() {
        return 0;
    }

    public final ByteBuf capacity(int n2) {
        throw new ReadOnlyBufferException();
    }

    public final ByteBuf clear() {
        return this;
    }

    public final int compareTo(ByteBuf byteBuf) {
        if (byteBuf.isReadable()) {
            return -1;
        }
        return 0;
    }

    public final ByteBuf copy() {
        return this;
    }

    public final ByteBuf copy(int n2, int n3) {
        return EmptyByteBuf.super.checkIndex(n2, n3);
    }

    public final ByteBuf discardReadBytes() {
        return this;
    }

    public final ByteBuf discardSomeReadBytes() {
        return this;
    }

    public final ByteBuf duplicate() {
        return this;
    }

    public final int ensureWritable(int n2, boolean bl) {
        if (n2 < 0) {
            StringBuilder stringBuilder = new StringBuilder("minWritableBytes: ");
            stringBuilder.append(n2);
            stringBuilder.append(" (expected: >= 0)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return n2 != 0;
    }

    public final ByteBuf ensureWritable(int n2) {
        if (n2 < 0) {
            StringBuilder stringBuilder = new StringBuilder("minWritableBytes: ");
            stringBuilder.append(n2);
            stringBuilder.append(" (expected: >= 0)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n2 != 0) {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    public final boolean equals(Object object) {
        return object instanceof ByteBuf && !((ByteBuf)object).isReadable();
    }

    public final int forEachByte(int n2, int n3, ByteBufProcessor byteBufProcessor) {
        EmptyByteBuf.super.checkIndex(n2, n3);
        return -1;
    }

    public final int forEachByte(ByteBufProcessor byteBufProcessor) {
        return -1;
    }

    public final int forEachByteDesc(int n2, int n3, ByteBufProcessor byteBufProcessor) {
        EmptyByteBuf.super.checkIndex(n2, n3);
        return -1;
    }

    public final int forEachByteDesc(ByteBufProcessor byteBufProcessor) {
        return -1;
    }

    public final boolean getBoolean(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final byte getByte(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3) {
        EmptyByteBuf.super.checkIndex(n2, n3);
        return 0;
    }

    public final ByteBuf getBytes(int n2, ByteBuf byteBuf) {
        return EmptyByteBuf.super.checkIndex(n2, byteBuf.writableBytes());
    }

    public final ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3) {
        return EmptyByteBuf.super.checkIndex(n2, n3);
    }

    public final ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        return EmptyByteBuf.super.checkIndex(n2, n4);
    }

    public final ByteBuf getBytes(int n2, OutputStream outputStream, int n3) {
        return EmptyByteBuf.super.checkIndex(n2, n3);
    }

    public final ByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
        return EmptyByteBuf.super.checkIndex(n2, byteBuffer.remaining());
    }

    public final ByteBuf getBytes(int n2, byte[] arrby) {
        return EmptyByteBuf.super.checkIndex(n2, arrby.length);
    }

    public final ByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
        return EmptyByteBuf.super.checkIndex(n2, n4);
    }

    public final char getChar(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final double getDouble(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final float getFloat(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final int getInt(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final long getLong(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final int getMedium(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final short getShort(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final short getUnsignedByte(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final long getUnsignedInt(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final int getUnsignedMedium(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final int getUnsignedShort(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final boolean hasArray() {
        return true;
    }

    public final boolean hasMemoryAddress() {
        return EMPTY_BYTE_BUFFER_ADDRESS != 0L;
    }

    public final int hashCode() {
        return 0;
    }

    public final int indexOf(int n2, int n3, byte by) {
        EmptyByteBuf.super.checkIndex(n2);
        EmptyByteBuf.super.checkIndex(n3);
        return -1;
    }

    public final ByteBuffer internalNioBuffer(int n2, int n3) {
        return EMPTY_BYTE_BUFFER;
    }

    public final boolean isDirect() {
        return true;
    }

    public final boolean isReadable() {
        return false;
    }

    public final boolean isReadable(int n2) {
        return false;
    }

    public final boolean isWritable() {
        return false;
    }

    public final boolean isWritable(int n2) {
        return false;
    }

    public final ByteBuf markReaderIndex() {
        return this;
    }

    public final ByteBuf markWriterIndex() {
        return this;
    }

    public final int maxCapacity() {
        return 0;
    }

    public final int maxWritableBytes() {
        return 0;
    }

    public final long memoryAddress() {
        if (this.hasMemoryAddress()) {
            return EMPTY_BYTE_BUFFER_ADDRESS;
        }
        throw new UnsupportedOperationException();
    }

    public final ByteBuffer nioBuffer() {
        return EMPTY_BYTE_BUFFER;
    }

    public final ByteBuffer nioBuffer(int n2, int n3) {
        EmptyByteBuf.super.checkIndex(n2, n3);
        return this.nioBuffer();
    }

    public final int nioBufferCount() {
        return 1;
    }

    public final ByteBuffer[] nioBuffers() {
        ByteBuffer[] arrbyteBuffer = new ByteBuffer[]{EMPTY_BYTE_BUFFER};
        return arrbyteBuffer;
    }

    public final ByteBuffer[] nioBuffers(int n2, int n3) {
        EmptyByteBuf.super.checkIndex(n2, n3);
        return this.nioBuffers();
    }

    public final ByteBuf order(ByteOrder byteOrder) {
        EmptyByteBuf emptyByteBuf;
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        }
        if (byteOrder == this.order()) {
            return this;
        }
        EmptyByteBuf emptyByteBuf2 = this.swapped;
        if (emptyByteBuf2 != null) {
            return emptyByteBuf2;
        }
        this.swapped = emptyByteBuf = new EmptyByteBuf(this.alloc(), byteOrder);
        return emptyByteBuf;
    }

    public final ByteOrder order() {
        return this.order;
    }

    public final boolean readBoolean() {
        throw new IndexOutOfBoundsException();
    }

    public final byte readByte() {
        throw new IndexOutOfBoundsException();
    }

    public final int readBytes(GatheringByteChannel gatheringByteChannel, int n2) {
        EmptyByteBuf.super.checkLength(n2);
        return 0;
    }

    public final ByteBuf readBytes(int n2) {
        return EmptyByteBuf.super.checkLength(n2);
    }

    public final ByteBuf readBytes(ByteBuf byteBuf) {
        return EmptyByteBuf.super.checkLength(byteBuf.writableBytes());
    }

    public final ByteBuf readBytes(ByteBuf byteBuf, int n2) {
        return EmptyByteBuf.super.checkLength(n2);
    }

    public final ByteBuf readBytes(ByteBuf byteBuf, int n2, int n3) {
        return EmptyByteBuf.super.checkLength(n3);
    }

    public final ByteBuf readBytes(OutputStream outputStream, int n2) {
        return EmptyByteBuf.super.checkLength(n2);
    }

    public final ByteBuf readBytes(ByteBuffer byteBuffer) {
        return EmptyByteBuf.super.checkLength(byteBuffer.remaining());
    }

    public final ByteBuf readBytes(byte[] arrby) {
        return EmptyByteBuf.super.checkLength(arrby.length);
    }

    public final ByteBuf readBytes(byte[] arrby, int n2, int n3) {
        return EmptyByteBuf.super.checkLength(n3);
    }

    public final char readChar() {
        throw new IndexOutOfBoundsException();
    }

    public final double readDouble() {
        throw new IndexOutOfBoundsException();
    }

    public final float readFloat() {
        throw new IndexOutOfBoundsException();
    }

    public final int readInt() {
        throw new IndexOutOfBoundsException();
    }

    public final long readLong() {
        throw new IndexOutOfBoundsException();
    }

    public final int readMedium() {
        throw new IndexOutOfBoundsException();
    }

    public final short readShort() {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf readSlice(int n2) {
        return EmptyByteBuf.super.checkLength(n2);
    }

    public final short readUnsignedByte() {
        throw new IndexOutOfBoundsException();
    }

    public final long readUnsignedInt() {
        throw new IndexOutOfBoundsException();
    }

    public final int readUnsignedMedium() {
        throw new IndexOutOfBoundsException();
    }

    public final int readUnsignedShort() {
        throw new IndexOutOfBoundsException();
    }

    public final int readableBytes() {
        return 0;
    }

    public final int readerIndex() {
        return 0;
    }

    public final ByteBuf readerIndex(int n2) {
        return EmptyByteBuf.super.checkIndex(n2);
    }

    public final int refCnt() {
        return 1;
    }

    public final boolean release() {
        return false;
    }

    public final boolean release(int n2) {
        return false;
    }

    public final ByteBuf resetReaderIndex() {
        return this;
    }

    public final ByteBuf resetWriterIndex() {
        return this;
    }

    public final ByteBuf retain() {
        return this;
    }

    public final ByteBuf retain(int n2) {
        return this;
    }

    public final ByteBuf setBoolean(int n2, boolean bl) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf setByte(int n2, int n3) {
        throw new IndexOutOfBoundsException();
    }

    public final int setBytes(int n2, InputStream inputStream, int n3) {
        EmptyByteBuf.super.checkIndex(n2, n3);
        return 0;
    }

    public final int setBytes(int n2, ScatteringByteChannel scatteringByteChannel, int n3) {
        EmptyByteBuf.super.checkIndex(n2, n3);
        return 0;
    }

    public final ByteBuf setBytes(int n2, ByteBuf byteBuf) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf setBytes(int n2, ByteBuf byteBuf, int n3) {
        return EmptyByteBuf.super.checkIndex(n2, n3);
    }

    public final ByteBuf setBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        return EmptyByteBuf.super.checkIndex(n2, n4);
    }

    public final ByteBuf setBytes(int n2, ByteBuffer byteBuffer) {
        return EmptyByteBuf.super.checkIndex(n2, byteBuffer.remaining());
    }

    public final ByteBuf setBytes(int n2, byte[] arrby) {
        return EmptyByteBuf.super.checkIndex(n2, arrby.length);
    }

    public final ByteBuf setBytes(int n2, byte[] arrby, int n3, int n4) {
        return EmptyByteBuf.super.checkIndex(n2, n4);
    }

    public final ByteBuf setChar(int n2, int n3) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf setDouble(int n2, double d2) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf setFloat(int n2, float f2) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf setIndex(int n2, int n3) {
        EmptyByteBuf.super.checkIndex(n2);
        EmptyByteBuf.super.checkIndex(n3);
        return this;
    }

    public final ByteBuf setInt(int n2, int n3) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf setLong(int n2, long l2) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf setMedium(int n2, int n3) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf setShort(int n2, int n3) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf setZero(int n2, int n3) {
        return EmptyByteBuf.super.checkIndex(n2, n3);
    }

    public final ByteBuf skipBytes(int n2) {
        return EmptyByteBuf.super.checkLength(n2);
    }

    public final ByteBuf slice() {
        return this;
    }

    public final ByteBuf slice(int n2, int n3) {
        return EmptyByteBuf.super.checkIndex(n2, n3);
    }

    public final String toString() {
        return this.str;
    }

    public final String toString(int n2, int n3, Charset charset) {
        EmptyByteBuf.super.checkIndex(n2, n3);
        return this.toString(charset);
    }

    public final String toString(Charset charset) {
        return "";
    }

    public final ByteBuf unwrap() {
        return null;
    }

    public final int writableBytes() {
        return 0;
    }

    public final ByteBuf writeBoolean(boolean bl) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf writeByte(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final int writeBytes(InputStream inputStream, int n2) {
        EmptyByteBuf.super.checkLength(n2);
        return 0;
    }

    public final int writeBytes(ScatteringByteChannel scatteringByteChannel, int n2) {
        EmptyByteBuf.super.checkLength(n2);
        return 0;
    }

    public final ByteBuf writeBytes(ByteBuf byteBuf) {
        return EmptyByteBuf.super.checkLength(byteBuf.readableBytes());
    }

    public final ByteBuf writeBytes(ByteBuf byteBuf, int n2) {
        return EmptyByteBuf.super.checkLength(n2);
    }

    public final ByteBuf writeBytes(ByteBuf byteBuf, int n2, int n3) {
        return EmptyByteBuf.super.checkLength(n3);
    }

    public final ByteBuf writeBytes(ByteBuffer byteBuffer) {
        return EmptyByteBuf.super.checkLength(byteBuffer.remaining());
    }

    public final ByteBuf writeBytes(byte[] arrby) {
        return EmptyByteBuf.super.checkLength(arrby.length);
    }

    public final ByteBuf writeBytes(byte[] arrby, int n2, int n3) {
        return EmptyByteBuf.super.checkLength(n3);
    }

    public final ByteBuf writeChar(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf writeDouble(double d2) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf writeFloat(float f2) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf writeInt(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf writeLong(long l2) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf writeMedium(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf writeShort(int n2) {
        throw new IndexOutOfBoundsException();
    }

    public final ByteBuf writeZero(int n2) {
        return EmptyByteBuf.super.checkLength(n2);
    }

    public final int writerIndex() {
        return 0;
    }

    public final ByteBuf writerIndex(int n2) {
        return EmptyByteBuf.super.checkIndex(n2);
    }
}

