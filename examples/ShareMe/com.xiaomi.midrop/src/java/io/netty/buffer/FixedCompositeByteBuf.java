/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.ReadOnlyBufferException
 *  java.nio.channels.GatheringByteChannel
 *  java.nio.channels.ScatteringByteChannel
 */
package io.netty.buffer;

import io.netty.buffer.AbstractReferenceCountedByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

final class FixedCompositeByteBuf
extends AbstractReferenceCountedByteBuf {
    private static final ByteBuf[] EMPTY;
    private final ByteBufAllocator allocator;
    private final Object[] buffers;
    private final int capacity;
    private final boolean direct;
    private final int nioBufferCount;
    private final ByteOrder order;

    static {
        ByteBuf[] arrbyteBuf = new ByteBuf[]{Unpooled.EMPTY_BUFFER};
        EMPTY = arrbyteBuf;
    }

    /* varargs */ FixedCompositeByteBuf(ByteBufAllocator byteBufAllocator, ByteBuf ... arrbyteBuf) {
        int n2;
        super(Integer.MAX_VALUE);
        int n3 = arrbyteBuf.length;
        if (n3 == 0) {
            this.buffers = EMPTY;
            this.order = ByteOrder.BIG_ENDIAN;
            this.nioBufferCount = n2;
            this.capacity = 0;
            this.direct = false;
        } else {
            ByteBuf byteBuf = arrbyteBuf[0];
            this.buffers = new Object[arrbyteBuf.length];
            this.buffers[0] = byteBuf;
            int n4 = byteBuf.nioBufferCount();
            int n5 = byteBuf.readableBytes();
            this.order = byteBuf.order();
            boolean bl = true;
            for (n2 = 1; n2 < arrbyteBuf.length; ++n2) {
                ByteBuf byteBuf2 = arrbyteBuf[n2];
                if (arrbyteBuf[n2].order() != this.order) {
                    throw new IllegalArgumentException("All ByteBufs need to have same ByteOrder");
                }
                n4 += byteBuf2.nioBufferCount();
                n5 += byteBuf2.readableBytes();
                if (!byteBuf2.isDirect()) {
                    bl = false;
                }
                this.buffers[n2] = byteBuf2;
            }
            this.nioBufferCount = n4;
            this.capacity = n5;
            this.direct = bl;
        }
        this.setIndex(0, this.capacity());
        this.allocator = byteBufAllocator;
    }

    private ByteBuf buffer(int n2) {
        Object object = this.buffers[n2];
        if (object instanceof ByteBuf) {
            return (ByteBuf)object;
        }
        return (object).buf;
    }

    private Component findComponent(int n2) {
        int n3 = 0;
        for (int i2 = 0; i2 < this.buffers.length; ++i2) {
            ByteBuf byteBuf;
            Component component;
            boolean bl;
            Object object = this.buffers[i2];
            if (object instanceof ByteBuf) {
                byteBuf = (ByteBuf)object;
                bl = true;
                component = null;
            } else {
                component = object;
                byteBuf = component.buf;
                bl = false;
            }
            if (n2 >= (n3 += byteBuf.readableBytes())) continue;
            if (bl) {
                component = new Object(i2, n3 - byteBuf.readableBytes(), byteBuf){
                    private final ByteBuf buf;
                    private final int endOffset;
                    private final int index;
                    private final int offset;
                    {
                        this.index = n2;
                        this.offset = n3;
                        this.endOffset = n3 + byteBuf.readableBytes();
                        this.buf = byteBuf;
                    }
                };
                this.buffers[i2] = component;
            }
            return component;
        }
        throw new IllegalStateException();
    }

    @Override
    protected final byte _getByte(int n2) {
        Component component = FixedCompositeByteBuf.super.findComponent(n2);
        return component.buf.getByte(n2 - component.offset);
    }

    @Override
    protected final int _getInt(int n2) {
        Component component = FixedCompositeByteBuf.super.findComponent(n2);
        if (n2 + 4 <= component.endOffset) {
            return component.buf.getInt(n2 - component.offset);
        }
        if (this.order() == ByteOrder.BIG_ENDIAN) {
            return (65535 & this._getShort(n2)) << 16 | 65535 & this._getShort(n2 + 2);
        }
        return 65535 & this._getShort(n2) | (65535 & this._getShort(n2 + 2)) << 16;
    }

    @Override
    protected final long _getLong(int n2) {
        Component component = FixedCompositeByteBuf.super.findComponent(n2);
        if (n2 + 8 <= component.endOffset) {
            return component.buf.getLong(n2 - component.offset);
        }
        if (this.order() == ByteOrder.BIG_ENDIAN) {
            return (0xFFFFFFFFL & (long)this._getInt(n2)) << 32 | 0xFFFFFFFFL & (long)this._getInt(n2 + 4);
        }
        return 0xFFFFFFFFL & (long)this._getInt(n2) | (0xFFFFFFFFL & (long)this._getInt(n2 + 4)) << 32;
    }

    @Override
    protected final short _getShort(int n2) {
        Component component = FixedCompositeByteBuf.super.findComponent(n2);
        if (n2 + 2 <= component.endOffset) {
            return component.buf.getShort(n2 - component.offset);
        }
        if (this.order() == ByteOrder.BIG_ENDIAN) {
            return (short)((255 & this._getByte(n2)) << 8 | 255 & this._getByte(n2 + 1));
        }
        return (short)(255 & this._getByte(n2) | (255 & this._getByte(n2 + 1)) << 8);
    }

    @Override
    protected final int _getUnsignedMedium(int n2) {
        Component component = FixedCompositeByteBuf.super.findComponent(n2);
        if (n2 + 3 <= component.endOffset) {
            return component.buf.getUnsignedMedium(n2 - component.offset);
        }
        if (this.order() == ByteOrder.BIG_ENDIAN) {
            return (65535 & this._getShort(n2)) << 8 | 255 & this._getByte(n2 + 2);
        }
        return 65535 & this._getShort(n2) | (255 & this._getByte(n2 + 2)) << 16;
    }

    @Override
    protected final void _setByte(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    @Override
    protected final void _setInt(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    @Override
    protected final void _setLong(int n2, long l2) {
        throw new ReadOnlyBufferException();
    }

    @Override
    protected final void _setMedium(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    @Override
    protected final void _setShort(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    public final ByteBufAllocator alloc() {
        return this.allocator;
    }

    public final byte[] array() {
        throw new UnsupportedOperationException();
    }

    public final int arrayOffset() {
        throw new UnsupportedOperationException();
    }

    public final int capacity() {
        return this.capacity;
    }

    public final ByteBuf capacity(int n2) {
        throw new ReadOnlyBufferException();
    }

    public final ByteBuf copy(int n2, int n3) {
        this.checkIndex(n2, n3);
        ByteBuf byteBuf = this.alloc().buffer(n3);
        try {
            byteBuf.writeBytes((ByteBuf)this, n2, n3);
            return byteBuf;
        }
        catch (Throwable throwable) {
            byteBuf.release();
            throw throwable;
        }
    }

    @Override
    protected final void deallocate() {
        for (int i2 = 0; i2 < this.buffers.length; ++i2) {
            this.buffer(i2).release();
        }
    }

    @Override
    public final ByteBuf discardReadBytes() {
        throw new ReadOnlyBufferException();
    }

    @Override
    public final byte getByte(int n2) {
        return this._getByte(n2);
    }

    public final int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3) throws IOException {
        if (this.nioBufferCount() == 1) {
            return gatheringByteChannel.write(this.internalNioBuffer(n2, n3));
        }
        long l2 = gatheringByteChannel.write(this.nioBuffers(n2, n3));
        if (l2 > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)l2;
    }

    public final ByteBuf getBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.checkDstIndex(n2, n4, n3, byteBuf.capacity());
        if (n4 == 0) {
            return this;
        }
        Component component = FixedCompositeByteBuf.super.findComponent(n2);
        int n5 = component.index;
        int n6 = component.offset;
        ByteBuf byteBuf2 = component.buf;
        do {
            int n7 = byteBuf2.readableBytes();
            int n8 = n2 - n6;
            int n9 = Math.min((int)n4, (int)(n7 - n8));
            byteBuf2.getBytes(n8, byteBuf, n3, n9);
            n2 += n9;
            n3 += n9;
            n6 += byteBuf2.readableBytes();
            if ((n4 -= n9) <= 0) break;
            byteBuf2 = FixedCompositeByteBuf.super.buffer(++n5);
        } while (true);
        return this;
    }

    public final ByteBuf getBytes(int n2, OutputStream outputStream, int n3) throws IOException {
        this.checkIndex(n2, n3);
        if (n3 == 0) {
            return this;
        }
        Component component = FixedCompositeByteBuf.super.findComponent(n2);
        int n4 = component.index;
        int n5 = component.offset;
        ByteBuf byteBuf = component.buf;
        do {
            int n6 = byteBuf.readableBytes();
            int n7 = n2 - n5;
            int n8 = Math.min((int)n3, (int)(n6 - n7));
            byteBuf.getBytes(n7, outputStream, n8);
            n2 += n8;
            n5 += byteBuf.readableBytes();
            if ((n3 -= n8) <= 0) break;
            byteBuf = FixedCompositeByteBuf.super.buffer(++n4);
        } while (true);
        return this;
    }

    public final ByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
        ByteBuf byteBuf;
        int n3;
        int n4;
        int n5;
        int n6 = byteBuffer.limit();
        int n7 = byteBuffer.remaining();
        this.checkIndex(n2, n7);
        if (n7 == 0) {
            return this;
        }
        try {
            Component component = FixedCompositeByteBuf.super.findComponent(n2);
            n5 = component.index;
            n4 = component.offset;
            byteBuf = component.buf;
            do {
                n3 = byteBuf.readableBytes();
                break;
            } while (true);
        }
        catch (Throwable throwable) {
            byteBuffer.limit(n6);
            throw throwable;
        }
        {
            int n8 = n2 - n4;
            int n9 = Math.min((int)n7, (int)(n3 - n8));
            byteBuffer.limit(n9 + byteBuffer.position());
            byteBuf.getBytes(n8, byteBuffer);
            n2 += n9;
            n7 -= n9;
            n4 += byteBuf.readableBytes();
            if (n7 <= 0) break;
            ++n5;
            byteBuf = FixedCompositeByteBuf.super.buffer(n5);
            continue;
        }
        byteBuffer.limit(n6);
        return this;
    }

    public final ByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
        this.checkDstIndex(n2, n4, n3, arrby.length);
        if (n4 == 0) {
            return this;
        }
        Component component = FixedCompositeByteBuf.super.findComponent(n2);
        int n5 = component.index;
        int n6 = component.offset;
        ByteBuf byteBuf = component.buf;
        do {
            int n7 = byteBuf.readableBytes();
            int n8 = n2 - n6;
            int n9 = Math.min((int)n4, (int)(n7 - n8));
            byteBuf.getBytes(n8, arrby, n3, n9);
            n2 += n9;
            n3 += n9;
            n6 += byteBuf.readableBytes();
            if ((n4 -= n9) <= 0) break;
            byteBuf = FixedCompositeByteBuf.super.buffer(++n5);
        } while (true);
        return this;
    }

    public final boolean hasArray() {
        return false;
    }

    public final boolean hasMemoryAddress() {
        return false;
    }

    public final ByteBuffer internalNioBuffer(int n2, int n3) {
        if (this.buffers.length == 1) {
            return FixedCompositeByteBuf.super.buffer(0).internalNioBuffer(n2, n3);
        }
        throw new UnsupportedOperationException();
    }

    public final boolean isDirect() {
        return this.direct;
    }

    @Override
    public final boolean isWritable() {
        return false;
    }

    @Override
    public final boolean isWritable(int n2) {
        return false;
    }

    @Override
    public final int maxCapacity() {
        return this.capacity;
    }

    public final long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    public final ByteBuffer nioBuffer(int n2, int n3) {
        ByteBuf byteBuf;
        this.checkIndex(n2, n3);
        int n4 = this.buffers.length;
        if (n4 == 1 && (byteBuf = FixedCompositeByteBuf.super.buffer(0)).nioBufferCount() == 1) {
            return byteBuf.nioBuffer(n2, n3);
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)n3).order(this.order());
        ByteBuffer[] arrbyteBuffer = this.nioBuffers(n2, n3);
        for (int i2 = 0; i2 < arrbyteBuffer.length; ++i2) {
            byteBuffer.put(arrbyteBuffer[i2]);
        }
        byteBuffer.flip();
        return byteBuffer;
    }

    public final int nioBufferCount() {
        return this.nioBufferCount;
    }

    /*
     * Exception decompiling
     */
    public final ByteBuffer[] nioBuffers(int var1, int var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [9[UNCONDITIONALDOLOOP]], but top level block is 3[TRYBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    public final ByteOrder order() {
        return this.order;
    }

    @Override
    public final ByteBuf setByte(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    public final int setBytes(int n2, InputStream inputStream, int n3) {
        throw new ReadOnlyBufferException();
    }

    public final int setBytes(int n2, ScatteringByteChannel scatteringByteChannel, int n3) {
        throw new ReadOnlyBufferException();
    }

    public final ByteBuf setBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        throw new ReadOnlyBufferException();
    }

    public final ByteBuf setBytes(int n2, ByteBuffer byteBuffer) {
        throw new ReadOnlyBufferException();
    }

    public final ByteBuf setBytes(int n2, byte[] arrby, int n3, int n4) {
        throw new ReadOnlyBufferException();
    }

    @Override
    public final ByteBuf setInt(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    @Override
    public final ByteBuf setLong(int n2, long l2) {
        throw new ReadOnlyBufferException();
    }

    @Override
    public final ByteBuf setMedium(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    @Override
    public final ByteBuf setShort(int n2, int n3) {
        throw new ReadOnlyBufferException();
    }

    @Override
    public final String toString() {
        String string2 = super.toString();
        String string3 = string2.substring(0, -1 + string2.length());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append(", components=");
        stringBuilder.append(this.buffers.length);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public final ByteBuf unwrap() {
        return null;
    }

}

