/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Error
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Iterable
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.channels.GatheringByteChannel
 *  java.nio.channels.ScatteringByteChannel
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.ConcurrentModificationException
 *  java.util.Iterator
 *  java.util.List
 *  java.util.ListIterator
 *  java.util.NoSuchElementException
 */
package io.netty.buffer;

import io.netty.buffer.AbstractReferenceCountedByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.d.b.e;
import io.netty.d.b.l;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class CompositeByteBuf
extends AbstractReferenceCountedByteBuf
implements Iterable<ByteBuf> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Iterator<ByteBuf> EMPTY_ITERATOR;
    private static final ByteBuffer EMPTY_NIO_BUFFER;
    private final ByteBufAllocator alloc;
    private final ComponentList components;
    private final boolean direct;
    private boolean freed;
    private final int maxNumComponents;

    static {
        EMPTY_NIO_BUFFER = Unpooled.EMPTY_BUFFER.nioBuffer();
        EMPTY_ITERATOR = Collections.emptyList().iterator();
    }

    CompositeByteBuf(ByteBufAllocator byteBufAllocator) {
        super(Integer.MAX_VALUE);
        this.alloc = byteBufAllocator;
        this.direct = false;
        this.maxNumComponents = 0;
        this.components = null;
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean bl, int n2) {
        super(Integer.MAX_VALUE);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        this.alloc = byteBufAllocator;
        this.direct = bl;
        this.maxNumComponents = n2;
        this.components = CompositeByteBuf.newList(n2);
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean bl, int n2, Iterable<ByteBuf> iterable) {
        super(Integer.MAX_VALUE);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        if (n2 < 2) {
            StringBuilder stringBuilder = new StringBuilder("maxNumComponents: ");
            stringBuilder.append(n2);
            stringBuilder.append(" (expected: >= 2)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.alloc = byteBufAllocator;
        this.direct = bl;
        this.maxNumComponents = n2;
        this.components = CompositeByteBuf.newList(n2);
        CompositeByteBuf.super.addComponents0(false, 0, iterable);
        CompositeByteBuf.super.consolidateIfNeeded();
        this.setIndex(0, this.capacity());
    }

    public /* varargs */ CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean bl, int n2, ByteBuf ... arrbyteBuf) {
        super(byteBufAllocator, bl, n2, arrbyteBuf, 0, arrbyteBuf.length);
    }

    CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean bl, int n2, ByteBuf[] arrbyteBuf, int n3, int n4) {
        super(Integer.MAX_VALUE);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        if (n2 < 2) {
            StringBuilder stringBuilder = new StringBuilder("maxNumComponents: ");
            stringBuilder.append(n2);
            stringBuilder.append(" (expected: >= 2)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.alloc = byteBufAllocator;
        this.direct = bl;
        this.maxNumComponents = n2;
        this.components = CompositeByteBuf.newList(n2);
        this.addComponents0(false, 0, arrbyteBuf, n3, n4);
        this.consolidateIfNeeded();
        this.setIndex(0, this.capacity());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private int addComponent0(boolean var1, int var2_3, ByteBuf var3_2) {
        block14 : {
            block13 : {
                var4_4 = false;
                CompositeByteBuf.super.checkComponentIndex(var2_3);
                var7_5 = var3_2.readableBytes();
                var8_6 = new Object(var3_2.order(ByteOrder.BIG_ENDIAN).slice()){
                    final ByteBuf buf;
                    int endOffset;
                    final int length;
                    int offset;
                    {
                        this.buf = byteBuf;
                        this.length = byteBuf.readableBytes();
                    }

                    final void freeIfNecessary() {
                        this.buf.release();
                    }
                };
                var9_7 = this.components.size();
                var4_4 = false;
                if (var2_3 != var9_7) break block13;
                var10_8 = this.components.add(var8_6);
                if (var2_3 != 0) ** GOTO lbl14
                var8_6.endOffset = var7_5;
lbl14: // 1 sources:
                var8_6.offset = (this.components.get((int)(var2_3 - 1))).endOffset;
                var8_6.endOffset = var7_5 + var8_6.offset;
                return var8_6.endOffset;
            }
            this.components.add(var2_3, var8_6);
            if (var7_5 == 0) break block14;
            try {
                CompositeByteBuf.super.updateComponentOffsets(var2_3);
            }
            catch (Throwable var5_9) {
                var4_4 = true;
                ** GOTO lbl38
            }
        }
        var4_4 = true;
lbl29: // 2 sources:
        do {
            if (var1) {
                this.writerIndex(this.writerIndex() + var3_2.readableBytes());
            }
            if (!var4_4) {
                var3_2.release();
            }
            return var2_3;
            catch (Throwable var5_10) {
                // empty catch block
            }
lbl38: // 2 sources:
            if (!var4_4) {
                var3_2.release();
            }
            throw var5_11;
            break;
        } while (true);
        finally {
            var4_4 = var10_8;
            ** continue;
        }
    }

    /*
     * Exception decompiling
     */
    private int addComponents0(boolean var1, int var2, Iterable<ByteBuf> var3) {
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

    /*
     * Exception decompiling
     */
    private int addComponents0(boolean var1, int var2, ByteBuf[] var3, int var4, int var5) {
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

    private ByteBuf allocBuffer(int n2) {
        if (this.direct) {
            return this.alloc().directBuffer(n2);
        }
        return this.alloc().heapBuffer(n2);
    }

    private void checkComponentIndex(int n2) {
        this.ensureAccessible();
        if (n2 >= 0 && n2 <= this.components.size()) {
            return;
        }
        Object[] arrobject = new Object[]{n2, this.components.size()};
        throw new IndexOutOfBoundsException(String.format((String)"cIndex: %d (expected: >= 0 && <= numComponents(%d))", (Object[])arrobject));
    }

    private void checkComponentIndex(int n2, int n3) {
        this.ensureAccessible();
        if (n2 >= 0 && n2 + n3 <= this.components.size()) {
            return;
        }
        Object[] arrobject = new Object[]{n2, n3, this.components.size()};
        throw new IndexOutOfBoundsException(String.format((String)"cIndex: %d, numComponents: %d (expected: cIndex >= 0 && cIndex + numComponents <= totalNumComponents(%d))", (Object[])arrobject));
    }

    private void consolidateIfNeeded() {
        int n2 = this.components.size();
        if (n2 > this.maxNumComponents) {
            ByteBuf byteBuf = this.allocBuffer((this.components.get((int)(n2 - 1))).endOffset);
            for (int i2 = 0; i2 < n2; ++i2) {
                Component component = this.components.get(i2);
                byteBuf.writeBytes(component.buf);
                component.freeIfNecessary();
            }
            Object object = new /* invalid duplicate definition of identical inner class */;
            object.endOffset = object.length;
            this.components.clear();
            this.components.add(object);
        }
    }

    private void copyTo(int n2, int n3, int n4, ByteBuf byteBuf) {
        int n5 = 0;
        while (n3 > 0) {
            Component component = this.components.get(n4);
            ByteBuf byteBuf2 = component.buf;
            int n6 = component.offset;
            int n7 = byteBuf2.capacity();
            int n8 = n2 - n6;
            int n9 = Math.min((int)n3, (int)(n7 - n8));
            byteBuf2.getBytes(n8, byteBuf, n5, n9);
            n2 += n9;
            n5 += n9;
            n3 -= n9;
            ++n4;
        }
        byteBuf.writerIndex(byteBuf.capacity());
    }

    private Component findComponent(int n2) {
        this.checkIndex(n2);
        int n3 = this.components.size();
        int n4 = 0;
        while (n4 <= n3) {
            int n5 = n4 + n3 >>> 1;
            Component component = this.components.get(n5);
            if (n2 >= component.endOffset) {
                n4 = n5 + 1;
                continue;
            }
            if (n2 < component.offset) {
                n3 = n5 - 1;
                continue;
            }
            return component;
        }
        throw new Error("should not reach here");
    }

    private static ComponentList newList(int n2) {
        return new ArrayList<Component>(Math.min((int)16, (int)n2)){

            public final void removeRange(int n2, int n3) {
                super.removeRange(n2, n3);
            }
        };
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void updateComponentOffsets(int var1) {
        var2_2 = this.components.size();
        if (var2_2 <= var1) {
            return;
        }
        var3_3 = this.components.get(var1);
        if (var1 != 0) ** GOTO lbl10
        var3_3.offset = 0;
        var3_3.endOffset = var3_3.length;
        do {
            ++var1;
lbl10: // 2 sources:
            if (var1 >= var2_2) return;
            var4_4 = this.components.get(var1 - 1);
            var5_5 = this.components.get(var1);
            var5_5.offset = var4_4.endOffset;
            var5_5.endOffset = var5_5.offset + var5_5.length;
        } while (true);
    }

    @Override
    protected byte _getByte(int n2) {
        Component component = CompositeByteBuf.super.findComponent(n2);
        return component.buf.getByte(n2 - component.offset);
    }

    @Override
    protected int _getInt(int n2) {
        Component component = CompositeByteBuf.super.findComponent(n2);
        if (n2 + 4 <= component.endOffset) {
            return component.buf.getInt(n2 - component.offset);
        }
        if (this.order() == ByteOrder.BIG_ENDIAN) {
            return (65535 & this._getShort(n2)) << 16 | 65535 & this._getShort(n2 + 2);
        }
        return 65535 & this._getShort(n2) | (65535 & this._getShort(n2 + 2)) << 16;
    }

    @Override
    protected long _getLong(int n2) {
        Component component = CompositeByteBuf.super.findComponent(n2);
        if (n2 + 8 <= component.endOffset) {
            return component.buf.getLong(n2 - component.offset);
        }
        if (this.order() == ByteOrder.BIG_ENDIAN) {
            return (0xFFFFFFFFL & (long)this._getInt(n2)) << 32 | 0xFFFFFFFFL & (long)this._getInt(n2 + 4);
        }
        return 0xFFFFFFFFL & (long)this._getInt(n2) | (0xFFFFFFFFL & (long)this._getInt(n2 + 4)) << 32;
    }

    @Override
    protected short _getShort(int n2) {
        Component component = CompositeByteBuf.super.findComponent(n2);
        if (n2 + 2 <= component.endOffset) {
            return component.buf.getShort(n2 - component.offset);
        }
        if (this.order() == ByteOrder.BIG_ENDIAN) {
            return (short)((255 & this._getByte(n2)) << 8 | 255 & this._getByte(n2 + 1));
        }
        return (short)(255 & this._getByte(n2) | (255 & this._getByte(n2 + 1)) << 8);
    }

    @Override
    protected int _getUnsignedMedium(int n2) {
        Component component = CompositeByteBuf.super.findComponent(n2);
        if (n2 + 3 <= component.endOffset) {
            return component.buf.getUnsignedMedium(n2 - component.offset);
        }
        if (this.order() == ByteOrder.BIG_ENDIAN) {
            return (65535 & this._getShort(n2)) << 8 | 255 & this._getByte(n2 + 2);
        }
        return 65535 & this._getShort(n2) | (255 & this._getByte(n2 + 2)) << 16;
    }

    @Override
    protected void _setByte(int n2, int n3) {
        this.setByte(n2, n3);
    }

    @Override
    protected void _setInt(int n2, int n3) {
        Component component = CompositeByteBuf.super.findComponent(n2);
        if (n2 + 4 <= component.endOffset) {
            component.buf.setInt(n2 - component.offset, n3);
            return;
        }
        if (this.order() == ByteOrder.BIG_ENDIAN) {
            this._setShort(n2, (short)(n3 >>> 16));
            this._setShort(n2 + 2, (short)n3);
            return;
        }
        this._setShort(n2, (short)n3);
        this._setShort(n2 + 2, (short)(n3 >>> 16));
    }

    @Override
    protected void _setLong(int n2, long l2) {
        Component component = CompositeByteBuf.super.findComponent(n2);
        if (n2 + 8 <= component.endOffset) {
            component.buf.setLong(n2 - component.offset, l2);
            return;
        }
        if (this.order() == ByteOrder.BIG_ENDIAN) {
            this._setInt(n2, (int)(l2 >>> 32));
            this._setInt(n2 + 4, (int)l2);
            return;
        }
        this._setInt(n2, (int)l2);
        this._setInt(n2 + 4, (int)(l2 >>> 32));
    }

    @Override
    protected void _setMedium(int n2, int n3) {
        Component component = CompositeByteBuf.super.findComponent(n2);
        if (n2 + 3 <= component.endOffset) {
            component.buf.setMedium(n2 - component.offset, n3);
            return;
        }
        if (this.order() == ByteOrder.BIG_ENDIAN) {
            this._setShort(n2, (short)(n3 >> 8));
            this._setByte(n2 + 2, (byte)n3);
            return;
        }
        this._setShort(n2, (short)n3);
        this._setByte(n2 + 2, (byte)(n3 >>> 16));
    }

    @Override
    protected void _setShort(int n2, int n3) {
        Component component = CompositeByteBuf.super.findComponent(n2);
        if (n2 + 2 <= component.endOffset) {
            component.buf.setShort(n2 - component.offset, n3);
            return;
        }
        if (this.order() == ByteOrder.BIG_ENDIAN) {
            this._setByte(n2, (byte)(n3 >>> 8));
            this._setByte(n2 + 1, (byte)n3);
            return;
        }
        this._setByte(n2, (byte)n3);
        this._setByte(n2 + 1, (byte)(n3 >>> 8));
    }

    public CompositeByteBuf addComponent(int n2, ByteBuf byteBuf) {
        return this.addComponent(false, n2, byteBuf);
    }

    public CompositeByteBuf addComponent(ByteBuf byteBuf) {
        return this.addComponent(false, byteBuf);
    }

    public CompositeByteBuf addComponent(boolean bl, int n2, ByteBuf byteBuf) {
        l.a(byteBuf, "buffer");
        CompositeByteBuf.super.addComponent0(bl, n2, byteBuf);
        CompositeByteBuf.super.consolidateIfNeeded();
        return this;
    }

    public CompositeByteBuf addComponent(boolean bl, ByteBuf byteBuf) {
        l.a(byteBuf, "buffer");
        CompositeByteBuf.super.addComponent0(bl, this.components.size(), byteBuf);
        CompositeByteBuf.super.consolidateIfNeeded();
        return this;
    }

    public CompositeByteBuf addComponents(int n2, Iterable<ByteBuf> iterable) {
        CompositeByteBuf.super.addComponents0(false, n2, iterable);
        CompositeByteBuf.super.consolidateIfNeeded();
        return this;
    }

    public /* varargs */ CompositeByteBuf addComponents(int n2, ByteBuf ... arrbyteBuf) {
        CompositeByteBuf.super.addComponents0(false, n2, arrbyteBuf, 0, arrbyteBuf.length);
        CompositeByteBuf.super.consolidateIfNeeded();
        return this;
    }

    public CompositeByteBuf addComponents(Iterable<ByteBuf> iterable) {
        return this.addComponents(false, iterable);
    }

    public CompositeByteBuf addComponents(boolean bl, Iterable<ByteBuf> iterable) {
        CompositeByteBuf.super.addComponents0(bl, this.components.size(), iterable);
        CompositeByteBuf.super.consolidateIfNeeded();
        return this;
    }

    public /* varargs */ CompositeByteBuf addComponents(boolean bl, ByteBuf ... arrbyteBuf) {
        CompositeByteBuf.super.addComponents0(bl, this.components.size(), arrbyteBuf, 0, arrbyteBuf.length);
        CompositeByteBuf.super.consolidateIfNeeded();
        return this;
    }

    public /* varargs */ CompositeByteBuf addComponents(ByteBuf ... arrbyteBuf) {
        return this.addComponents(false, arrbyteBuf);
    }

    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    public byte[] array() {
        switch (this.components.size()) {
            default: {
                throw new UnsupportedOperationException();
            }
            case 1: {
                return (this.components.get((int)0)).buf.array();
            }
            case 0: 
        }
        return e.a;
    }

    public int arrayOffset() {
        switch (this.components.size()) {
            default: {
                throw new UnsupportedOperationException();
            }
            case 1: {
                return (this.components.get((int)0)).buf.arrayOffset();
            }
            case 0: 
        }
        return 0;
    }

    public int capacity() {
        int n2 = this.components.size();
        if (n2 == 0) {
            return 0;
        }
        return (this.components.get((int)(n2 - 1))).endOffset;
    }

    public CompositeByteBuf capacity(int n2) {
        this.checkNewCapacity(n2);
        int n3 = this.capacity();
        if (n2 > n3) {
            int n4 = n2 - n3;
            if (this.components.size() < this.maxNumComponents) {
                ByteBuf byteBuf = CompositeByteBuf.super.allocBuffer(n4);
                byteBuf.setIndex(0, n4);
                CompositeByteBuf.super.addComponent0(false, this.components.size(), byteBuf);
                return this;
            }
            ByteBuf byteBuf = CompositeByteBuf.super.allocBuffer(n4);
            byteBuf.setIndex(0, n4);
            CompositeByteBuf.super.addComponent0(false, this.components.size(), byteBuf);
            CompositeByteBuf.super.consolidateIfNeeded();
            return this;
        }
        if (n2 < n3) {
            int n5 = n3 - n2;
            ListIterator listIterator = this.components.listIterator(this.components.size());
            while (listIterator.hasPrevious()) {
                Component component = listIterator.previous();
                if (n5 >= component.length) {
                    n5 -= component.length;
                    listIterator.remove();
                    continue;
                }
                Object object = new /* invalid duplicate definition of identical inner class */;
                object.offset = component.offset;
                object.endOffset = object.offset + object.length;
                listIterator.set(object);
                break;
            }
            if (this.readerIndex() > n2) {
                this.setIndex(n2, n2);
                return this;
            }
            if (this.writerIndex() > n2) {
                this.writerIndex(n2);
            }
        }
        return this;
    }

    @Override
    public CompositeByteBuf clear() {
        return (CompositeByteBuf)super.clear();
    }

    public ByteBuf component(int n2) {
        return this.internalComponent(n2).duplicate();
    }

    public ByteBuf componentAtOffset(int n2) {
        return this.internalComponentAtOffset(n2).duplicate();
    }

    public CompositeByteBuf consolidate() {
        this.ensureAccessible();
        int n2 = this.numComponents();
        if (n2 <= 1) {
            return this;
        }
        ByteBuf byteBuf = this.allocBuffer((this.components.get((int)(n2 - 1))).endOffset);
        for (int i2 = 0; i2 < n2; ++i2) {
            Component component = this.components.get(i2);
            byteBuf.writeBytes(component.buf);
            component.freeIfNecessary();
        }
        this.components.clear();
        this.components.add(new /* invalid duplicate definition of identical inner class */);
        this.updateComponentOffsets(0);
        return this;
    }

    public CompositeByteBuf consolidate(int n2, int n3) {
        CompositeByteBuf.super.checkComponentIndex(n2, n3);
        if (n3 <= 1) {
            return this;
        }
        int n4 = n3 + n2;
        ByteBuf byteBuf = CompositeByteBuf.super.allocBuffer((this.components.get((int)(n4 - 1))).endOffset - (this.components.get((int)n2)).offset);
        for (int i2 = n2; i2 < n4; ++i2) {
            Component component = this.components.get(i2);
            byteBuf.writeBytes(component.buf);
            component.freeIfNecessary();
        }
        this.components.removeRange(n2 + 1, n4);
        this.components.set(n2, new /* invalid duplicate definition of identical inner class */);
        CompositeByteBuf.super.updateComponentOffsets(n2);
        return this;
    }

    public ByteBuf copy(int n2, int n3) {
        this.checkIndex(n2, n3);
        ByteBuf byteBuf = CompositeByteBuf.super.allocBuffer(n3);
        if (n3 != 0) {
            CompositeByteBuf.super.copyTo(n2, n3, this.toComponentIndex(n2), byteBuf);
        }
        return byteBuf;
    }

    @Override
    protected void deallocate() {
        if (this.freed) {
            return;
        }
        this.freed = true;
        int n2 = this.components.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            (this.components.get(i2)).freeIfNecessary();
        }
    }

    public List<ByteBuf> decompose(int n2, int n3) {
        int n4;
        this.checkIndex(n2, n3);
        if (n3 == 0) {
            return Collections.emptyList();
        }
        int n5 = this.toComponentIndex(n2);
        ArrayList arrayList = new ArrayList(this.components.size());
        Component component = this.components.get(n5);
        ByteBuf byteBuf = component.buf.duplicate();
        byteBuf.readerIndex(n2 - component.offset);
        do {
            if (n3 <= (n4 = byteBuf.readableBytes())) {
                byteBuf.writerIndex(n3 + byteBuf.readerIndex());
                arrayList.add((Object)byteBuf);
                break;
            }
            arrayList.add((Object)byteBuf);
            byteBuf = (this.components.get((int)(++n5))).buf.duplicate();
        } while ((n3 -= n4) > 0);
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            arrayList.set(i2, (Object)((ByteBuf)arrayList.get(i2)).slice());
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public CompositeByteBuf discardReadBytes() {
        this.ensureAccessible();
        int n2 = this.readerIndex();
        if (n2 == 0) {
            return this;
        }
        int n3 = this.writerIndex();
        if (n2 == n3 && n3 == this.capacity()) {
            int n4 = this.components.size();
            for (int i2 = 0; i2 < n4; ++i2) {
                (this.components.get(i2)).freeIfNecessary();
            }
            this.components.clear();
            this.setIndex(0, 0);
        } else {
            int n5 = this.toComponentIndex(n2);
            for (int i3 = 0; i3 < n5; ++i3) {
                (this.components.get(i3)).freeIfNecessary();
            }
            Component component = this.components.get(n5);
            int n6 = n2 - component.offset;
            if (n6 == component.length) {
                ++n5;
            } else {
                Object object = new /* invalid duplicate definition of identical inner class */;
                this.components.set(n5, object);
            }
            this.components.removeRange(0, n5);
            this.updateComponentOffsets(0);
            this.setIndex(0, n3 - n2);
        }
        this.adjustMarkers(n2);
        return this;
    }

    public CompositeByteBuf discardReadComponents() {
        this.ensureAccessible();
        int n2 = this.readerIndex();
        if (n2 == 0) {
            return this;
        }
        int n3 = this.writerIndex();
        if (n2 == n3 && n3 == this.capacity()) {
            int n4 = this.components.size();
            for (int i2 = 0; i2 < n4; ++i2) {
                (this.components.get(i2)).freeIfNecessary();
            }
            this.components.clear();
            this.setIndex(0, 0);
            this.adjustMarkers(n2);
            return this;
        }
        int n5 = this.toComponentIndex(n2);
        for (int i3 = 0; i3 < n5; ++i3) {
            (this.components.get(i3)).freeIfNecessary();
        }
        this.components.removeRange(0, n5);
        int n6 = (this.components.get((int)0)).offset;
        this.updateComponentOffsets(0);
        this.setIndex(n2 - n6, n3 - n6);
        this.adjustMarkers(n6);
        return this;
    }

    @Override
    public CompositeByteBuf discardSomeReadBytes() {
        return this.discardReadComponents();
    }

    @Override
    public CompositeByteBuf ensureWritable(int n2) {
        return (CompositeByteBuf)super.ensureWritable(n2);
    }

    @Override
    public byte getByte(int n2) {
        return this._getByte(n2);
    }

    public int getBytes(int n2, GatheringByteChannel gatheringByteChannel, int n3) throws IOException {
        if (this.nioBufferCount() == 1) {
            return gatheringByteChannel.write(this.internalNioBuffer(n2, n3));
        }
        long l2 = gatheringByteChannel.write(this.nioBuffers(n2, n3));
        if (l2 > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)l2;
    }

    @Override
    public CompositeByteBuf getBytes(int n2, ByteBuf byteBuf) {
        return (CompositeByteBuf)super.getBytes(n2, byteBuf);
    }

    @Override
    public CompositeByteBuf getBytes(int n2, ByteBuf byteBuf, int n3) {
        return (CompositeByteBuf)super.getBytes(n2, byteBuf, n3);
    }

    public CompositeByteBuf getBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.checkDstIndex(n2, n4, n3, byteBuf.capacity());
        if (n4 == 0) {
            return this;
        }
        int n5 = this.toComponentIndex(n2);
        while (n4 > 0) {
            Component component = this.components.get(n5);
            ByteBuf byteBuf2 = component.buf;
            int n6 = component.offset;
            int n7 = byteBuf2.capacity();
            int n8 = n2 - n6;
            int n9 = Math.min((int)n4, (int)(n7 - n8));
            byteBuf2.getBytes(n8, byteBuf, n3, n9);
            n2 += n9;
            n3 += n9;
            n4 -= n9;
            ++n5;
        }
        return this;
    }

    public CompositeByteBuf getBytes(int n2, OutputStream outputStream, int n3) throws IOException {
        this.checkIndex(n2, n3);
        if (n3 == 0) {
            return this;
        }
        int n4 = this.toComponentIndex(n2);
        while (n3 > 0) {
            Component component = this.components.get(n4);
            ByteBuf byteBuf = component.buf;
            int n5 = component.offset;
            int n6 = byteBuf.capacity();
            int n7 = n2 - n5;
            int n8 = Math.min((int)n3, (int)(n6 - n7));
            byteBuf.getBytes(n7, outputStream, n8);
            n2 += n8;
            n3 -= n8;
            ++n4;
        }
        return this;
    }

    public CompositeByteBuf getBytes(int n2, ByteBuffer byteBuffer) {
        int n3 = byteBuffer.limit();
        int n4 = byteBuffer.remaining();
        this.checkIndex(n2, n4);
        if (n4 == 0) {
            return this;
        }
        int n5 = this.toComponentIndex(n2);
        while (n4 > 0) {
            ByteBuf byteBuf;
            int n6;
            int n7;
            try {
                Component component = this.components.get(n5);
                byteBuf = component.buf;
                n6 = component.offset;
                n7 = byteBuf.capacity();
            }
            catch (Throwable throwable) {
                byteBuffer.limit(n3);
                throw throwable;
            }
            int n8 = n2 - n6;
            int n9 = Math.min((int)n4, (int)(n7 - n8));
            byteBuffer.limit(n9 + byteBuffer.position());
            byteBuf.getBytes(n8, byteBuffer);
            n2 += n9;
            n4 -= n9;
            ++n5;
        }
        byteBuffer.limit(n3);
        return this;
    }

    @Override
    public CompositeByteBuf getBytes(int n2, byte[] arrby) {
        return (CompositeByteBuf)super.getBytes(n2, arrby);
    }

    public CompositeByteBuf getBytes(int n2, byte[] arrby, int n3, int n4) {
        this.checkDstIndex(n2, n4, n3, arrby.length);
        if (n4 == 0) {
            return this;
        }
        int n5 = this.toComponentIndex(n2);
        while (n4 > 0) {
            Component component = this.components.get(n5);
            ByteBuf byteBuf = component.buf;
            int n6 = component.offset;
            int n7 = byteBuf.capacity();
            int n8 = n2 - n6;
            int n9 = Math.min((int)n4, (int)(n7 - n8));
            byteBuf.getBytes(n8, arrby, n3, n9);
            n2 += n9;
            n3 += n9;
            n4 -= n9;
            ++n5;
        }
        return this;
    }

    public boolean hasArray() {
        switch (this.components.size()) {
            default: {
                return false;
            }
            case 1: {
                return (this.components.get((int)0)).buf.hasArray();
            }
            case 0: 
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean hasMemoryAddress() {
        ByteBuf byteBuf;
        switch (this.components.size()) {
            default: {
                return false;
            }
            case 1: {
                byteBuf = (this.components.get((int)0)).buf;
                do {
                    return byteBuf.hasMemoryAddress();
                    break;
                } while (true);
            }
            case 0: 
        }
        byteBuf = Unpooled.EMPTY_BUFFER;
        return byteBuf.hasMemoryAddress();
    }

    public ByteBuf internalComponent(int n2) {
        CompositeByteBuf.super.checkComponentIndex(n2);
        return (this.components.get((int)n2)).buf;
    }

    public ByteBuf internalComponentAtOffset(int n2) {
        return CompositeByteBuf.super.findComponent((int)n2).buf;
    }

    public ByteBuffer internalNioBuffer(int n2, int n3) {
        switch (this.components.size()) {
            default: {
                throw new UnsupportedOperationException();
            }
            case 1: {
                return (this.components.get((int)0)).buf.internalNioBuffer(n2, n3);
            }
            case 0: 
        }
        return EMPTY_NIO_BUFFER;
    }

    public boolean isDirect() {
        int n2 = this.components.size();
        if (n2 == 0) {
            return false;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            if ((this.components.get((int)i2)).buf.isDirect()) continue;
            return false;
        }
        return true;
    }

    public Iterator<ByteBuf> iterator() {
        this.ensureAccessible();
        if (this.components.isEmpty()) {
            return EMPTY_ITERATOR;
        }
        return new Iterator<ByteBuf>(this, null){
            private int index;
            private final int size;
            final /* synthetic */ CompositeByteBuf this$0;
            {
                this.this$0 = compositeByteBuf;
                this.size = this.this$0.components.size();
            }

            public final boolean hasNext() {
                return this.size > this.index;
            }

            public final ByteBuf next() {
                if (this.size != this.this$0.components.size()) {
                    throw new ConcurrentModificationException();
                }
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                try {
                    ComponentList componentList = this.this$0.components;
                    int n2 = this.index;
                    this.index = n2 + 1;
                    ByteBuf byteBuf = (componentList.get((int)n2)).buf;
                    return byteBuf;
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    throw new ConcurrentModificationException();
                }
            }

            public final void remove() {
                throw new UnsupportedOperationException("Read-Only");
            }
        };
    }

    @Override
    public CompositeByteBuf markReaderIndex() {
        return (CompositeByteBuf)super.markReaderIndex();
    }

    @Override
    public CompositeByteBuf markWriterIndex() {
        return (CompositeByteBuf)super.markWriterIndex();
    }

    public int maxNumComponents() {
        return this.maxNumComponents;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public long memoryAddress() {
        ByteBuf byteBuf;
        switch (this.components.size()) {
            default: {
                throw new UnsupportedOperationException();
            }
            case 1: {
                byteBuf = (this.components.get((int)0)).buf;
                do {
                    return byteBuf.memoryAddress();
                    break;
                } while (true);
            }
            case 0: 
        }
        byteBuf = Unpooled.EMPTY_BUFFER;
        return byteBuf.memoryAddress();
    }

    public ByteBuffer nioBuffer(int n2, int n3) {
        this.checkIndex(n2, n3);
        int n4 = this.components.size();
        int n5 = 0;
        switch (n4) {
            default: {
                break;
            }
            case 1: {
                if ((this.components.get((int)0)).buf.nioBufferCount() != 1) break;
                return (this.components.get((int)0)).buf.nioBuffer(n2, n3);
            }
            case 0: {
                return EMPTY_NIO_BUFFER;
            }
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)n3).order(this.order());
        ByteBuffer[] arrbyteBuffer = this.nioBuffers(n2, n3);
        int n6 = arrbyteBuffer.length;
        while (n5 < n6) {
            byteBuffer.put(arrbyteBuffer[n5]);
            ++n5;
        }
        byteBuffer.flip();
        return byteBuffer;
    }

    public int nioBufferCount() {
        int n2;
        int n3;
        switch (this.components.size()) {
            default: {
                n2 = this.components.size();
                n3 = 0;
                break;
            }
            case 1: {
                return (this.components.get((int)0)).buf.nioBufferCount();
            }
            case 0: {
                return 1;
            }
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 += (this.components.get((int)i2)).buf.nioBufferCount();
        }
        return n3;
    }

    @Override
    public ByteBuffer[] nioBuffers() {
        return this.nioBuffers(this.readerIndex(), this.readableBytes());
    }

    public ByteBuffer[] nioBuffers(int n2, int n3) {
        this.checkIndex(n2, n3);
        if (n3 == 0) {
            ByteBuffer[] arrbyteBuffer = new ByteBuffer[]{EMPTY_NIO_BUFFER};
            return arrbyteBuffer;
        }
        ArrayList arrayList = new ArrayList(this.components.size());
        int n4 = this.toComponentIndex(n2);
        while (n3 > 0) {
            Component component = this.components.get(n4);
            ByteBuf byteBuf = component.buf;
            int n5 = component.offset;
            int n6 = byteBuf.capacity();
            int n7 = n2 - n5;
            int n8 = Math.min((int)n3, (int)(n6 - n7));
            switch (byteBuf.nioBufferCount()) {
                default: {
                    Collections.addAll((Collection)arrayList, (Object[])byteBuf.nioBuffers(n7, n8));
                    break;
                }
                case 1: {
                    arrayList.add((Object)byteBuf.nioBuffer(n7, n8));
                    break;
                }
                case 0: {
                    throw new UnsupportedOperationException();
                }
            }
            n2 += n8;
            n3 -= n8;
            ++n4;
        }
        return (ByteBuffer[])arrayList.toArray((Object[])new ByteBuffer[arrayList.size()]);
    }

    public int numComponents() {
        return this.components.size();
    }

    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override
    public CompositeByteBuf readBytes(ByteBuf byteBuf) {
        return (CompositeByteBuf)super.readBytes(byteBuf);
    }

    @Override
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int n2) {
        return (CompositeByteBuf)super.readBytes(byteBuf, n2);
    }

    @Override
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int n2, int n3) {
        return (CompositeByteBuf)super.readBytes(byteBuf, n2, n3);
    }

    @Override
    public CompositeByteBuf readBytes(OutputStream outputStream, int n2) throws IOException {
        return (CompositeByteBuf)super.readBytes(outputStream, n2);
    }

    @Override
    public CompositeByteBuf readBytes(ByteBuffer byteBuffer) {
        return (CompositeByteBuf)super.readBytes(byteBuffer);
    }

    @Override
    public CompositeByteBuf readBytes(byte[] arrby) {
        return (CompositeByteBuf)super.readBytes(arrby);
    }

    @Override
    public CompositeByteBuf readBytes(byte[] arrby, int n2, int n3) {
        return (CompositeByteBuf)super.readBytes(arrby, n2, n3);
    }

    @Override
    public CompositeByteBuf readerIndex(int n2) {
        return (CompositeByteBuf)super.readerIndex(n2);
    }

    public CompositeByteBuf removeComponent(int n2) {
        CompositeByteBuf.super.checkComponentIndex(n2);
        Component component = this.components.remove(n2);
        component.freeIfNecessary();
        if (component.length > 0) {
            CompositeByteBuf.super.updateComponentOffsets(n2);
        }
        return this;
    }

    public CompositeByteBuf removeComponents(int n2, int n3) {
        CompositeByteBuf.super.checkComponentIndex(n2, n3);
        if (n3 == 0) {
            return this;
        }
        int n4 = n3 + n2;
        boolean bl = false;
        for (int i2 = n2; i2 < n4; ++i2) {
            Component component = this.components.get(i2);
            if (component.length > 0) {
                bl = true;
            }
            component.freeIfNecessary();
        }
        this.components.removeRange(n2, n4);
        if (bl) {
            CompositeByteBuf.super.updateComponentOffsets(n2);
        }
        return this;
    }

    @Override
    public CompositeByteBuf resetReaderIndex() {
        return (CompositeByteBuf)super.resetReaderIndex();
    }

    @Override
    public CompositeByteBuf resetWriterIndex() {
        return (CompositeByteBuf)super.resetWriterIndex();
    }

    @Override
    public CompositeByteBuf retain() {
        return (CompositeByteBuf)super.retain();
    }

    @Override
    public CompositeByteBuf retain(int n2) {
        return (CompositeByteBuf)super.retain(n2);
    }

    @Override
    public CompositeByteBuf setBoolean(int n2, boolean bl) {
        return (CompositeByteBuf)super.setBoolean(n2, bl);
    }

    @Override
    public CompositeByteBuf setByte(int n2, int n3) {
        Component component = CompositeByteBuf.super.findComponent(n2);
        component.buf.setByte(n2 - component.offset, n3);
        return this;
    }

    public int setBytes(int n2, InputStream inputStream, int n3) throws IOException {
        this.checkIndex(n2, n3);
        if (n3 == 0) {
            return inputStream.read(e.a);
        }
        int n4 = this.toComponentIndex(n2);
        int n5 = 0;
        do {
            Component component = this.components.get(n4);
            ByteBuf byteBuf = component.buf;
            int n6 = component.offset;
            int n7 = n2 - n6;
            int n8 = byteBuf.capacity();
            int n9 = Math.min((int)n3, (int)(n8 - n7));
            int n10 = byteBuf.setBytes(n7, inputStream, n9);
            if (n10 < 0) {
                if (n5 != 0) break;
                return -1;
            }
            if (n10 == n9) {
                n2 += n9;
                n3 -= n9;
                n5 += n9;
                ++n4;
                continue;
            }
            n2 += n10;
            n3 -= n10;
            n5 += n10;
        } while (n3 > 0);
        return n5;
    }

    public int setBytes(int n2, ScatteringByteChannel scatteringByteChannel, int n3) throws IOException {
        this.checkIndex(n2, n3);
        if (n3 == 0) {
            return scatteringByteChannel.read(EMPTY_NIO_BUFFER);
        }
        int n4 = this.toComponentIndex(n2);
        int n5 = 0;
        do {
            Component component = this.components.get(n4);
            ByteBuf byteBuf = component.buf;
            int n6 = component.offset;
            int n7 = n2 - n6;
            int n8 = byteBuf.capacity();
            int n9 = Math.min((int)n3, (int)(n8 - n7));
            int n10 = byteBuf.setBytes(n7, scatteringByteChannel, n9);
            if (n10 == 0) break;
            if (n10 < 0) {
                if (n5 != 0) break;
                return -1;
            }
            if (n10 == n9) {
                n2 += n9;
                n3 -= n9;
                n5 += n9;
                ++n4;
                continue;
            }
            n2 += n10;
            n3 -= n10;
            n5 += n10;
        } while (n3 > 0);
        return n5;
    }

    @Override
    public CompositeByteBuf setBytes(int n2, ByteBuf byteBuf) {
        return (CompositeByteBuf)super.setBytes(n2, byteBuf);
    }

    @Override
    public CompositeByteBuf setBytes(int n2, ByteBuf byteBuf, int n3) {
        return (CompositeByteBuf)super.setBytes(n2, byteBuf, n3);
    }

    public CompositeByteBuf setBytes(int n2, ByteBuf byteBuf, int n3, int n4) {
        this.checkSrcIndex(n2, n4, n3, byteBuf.capacity());
        if (n4 == 0) {
            return this;
        }
        int n5 = this.toComponentIndex(n2);
        while (n4 > 0) {
            Component component = this.components.get(n5);
            ByteBuf byteBuf2 = component.buf;
            int n6 = component.offset;
            int n7 = byteBuf2.capacity();
            int n8 = n2 - n6;
            int n9 = Math.min((int)n4, (int)(n7 - n8));
            byteBuf2.setBytes(n8, byteBuf, n3, n9);
            n2 += n9;
            n3 += n9;
            n4 -= n9;
            ++n5;
        }
        return this;
    }

    public CompositeByteBuf setBytes(int n2, ByteBuffer byteBuffer) {
        int n3 = byteBuffer.limit();
        int n4 = byteBuffer.remaining();
        this.checkIndex(n2, n4);
        if (n4 == 0) {
            return this;
        }
        int n5 = this.toComponentIndex(n2);
        while (n4 > 0) {
            ByteBuf byteBuf;
            int n6;
            int n7;
            try {
                Component component = this.components.get(n5);
                byteBuf = component.buf;
                n6 = component.offset;
                n7 = byteBuf.capacity();
            }
            catch (Throwable throwable) {
                byteBuffer.limit(n3);
                throw throwable;
            }
            int n8 = n2 - n6;
            int n9 = Math.min((int)n4, (int)(n7 - n8));
            byteBuffer.limit(n9 + byteBuffer.position());
            byteBuf.setBytes(n8, byteBuffer);
            n2 += n9;
            n4 -= n9;
            ++n5;
        }
        byteBuffer.limit(n3);
        return this;
    }

    @Override
    public CompositeByteBuf setBytes(int n2, byte[] arrby) {
        return (CompositeByteBuf)super.setBytes(n2, arrby);
    }

    public CompositeByteBuf setBytes(int n2, byte[] arrby, int n3, int n4) {
        this.checkSrcIndex(n2, n4, n3, arrby.length);
        if (n4 == 0) {
            return this;
        }
        int n5 = this.toComponentIndex(n2);
        while (n4 > 0) {
            Component component = this.components.get(n5);
            ByteBuf byteBuf = component.buf;
            int n6 = component.offset;
            int n7 = byteBuf.capacity();
            int n8 = n2 - n6;
            int n9 = Math.min((int)n4, (int)(n7 - n8));
            byteBuf.setBytes(n8, arrby, n3, n9);
            n2 += n9;
            n3 += n9;
            n4 -= n9;
            ++n5;
        }
        return this;
    }

    @Override
    public CompositeByteBuf setChar(int n2, int n3) {
        return (CompositeByteBuf)super.setChar(n2, n3);
    }

    @Override
    public CompositeByteBuf setDouble(int n2, double d2) {
        return (CompositeByteBuf)super.setDouble(n2, d2);
    }

    @Override
    public CompositeByteBuf setFloat(int n2, float f2) {
        return (CompositeByteBuf)super.setFloat(n2, f2);
    }

    @Override
    public CompositeByteBuf setIndex(int n2, int n3) {
        return (CompositeByteBuf)super.setIndex(n2, n3);
    }

    @Override
    public CompositeByteBuf setInt(int n2, int n3) {
        return (CompositeByteBuf)super.setInt(n2, n3);
    }

    @Override
    public CompositeByteBuf setLong(int n2, long l2) {
        return (CompositeByteBuf)super.setLong(n2, l2);
    }

    @Override
    public CompositeByteBuf setMedium(int n2, int n3) {
        return (CompositeByteBuf)super.setMedium(n2, n3);
    }

    @Override
    public CompositeByteBuf setShort(int n2, int n3) {
        return (CompositeByteBuf)super.setShort(n2, n3);
    }

    @Override
    public CompositeByteBuf setZero(int n2, int n3) {
        return (CompositeByteBuf)super.setZero(n2, n3);
    }

    @Override
    public CompositeByteBuf skipBytes(int n2) {
        return (CompositeByteBuf)super.skipBytes(n2);
    }

    public int toByteIndex(int n2) {
        CompositeByteBuf.super.checkComponentIndex(n2);
        return (this.components.get((int)n2)).offset;
    }

    public int toComponentIndex(int n2) {
        this.checkIndex(n2);
        int n3 = this.components.size();
        int n4 = 0;
        while (n4 <= n3) {
            int n5 = n4 + n3 >>> 1;
            Component component = this.components.get(n5);
            if (n2 >= component.endOffset) {
                n4 = n5 + 1;
                continue;
            }
            if (n2 < component.offset) {
                n3 = n5 - 1;
                continue;
            }
            return n5;
        }
        throw new Error("should not reach here");
    }

    @Override
    public String toString() {
        String string2 = super.toString();
        String string3 = string2.substring(0, -1 + string2.length());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append(", components=");
        stringBuilder.append(this.components.size());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public ByteBuf unwrap() {
        return null;
    }

    @Override
    public CompositeByteBuf writeBoolean(boolean bl) {
        return (CompositeByteBuf)super.writeBoolean(bl);
    }

    @Override
    public CompositeByteBuf writeByte(int n2) {
        return (CompositeByteBuf)super.writeByte(n2);
    }

    @Override
    public CompositeByteBuf writeBytes(ByteBuf byteBuf) {
        return (CompositeByteBuf)super.writeBytes(byteBuf);
    }

    @Override
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int n2) {
        return (CompositeByteBuf)super.writeBytes(byteBuf, n2);
    }

    @Override
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int n2, int n3) {
        return (CompositeByteBuf)super.writeBytes(byteBuf, n2, n3);
    }

    @Override
    public CompositeByteBuf writeBytes(ByteBuffer byteBuffer) {
        return (CompositeByteBuf)super.writeBytes(byteBuffer);
    }

    @Override
    public CompositeByteBuf writeBytes(byte[] arrby) {
        return (CompositeByteBuf)super.writeBytes(arrby);
    }

    @Override
    public CompositeByteBuf writeBytes(byte[] arrby, int n2, int n3) {
        return (CompositeByteBuf)super.writeBytes(arrby, n2, n3);
    }

    @Override
    public CompositeByteBuf writeChar(int n2) {
        return (CompositeByteBuf)super.writeChar(n2);
    }

    @Override
    public CompositeByteBuf writeDouble(double d2) {
        return (CompositeByteBuf)super.writeDouble(d2);
    }

    @Override
    public CompositeByteBuf writeFloat(float f2) {
        return (CompositeByteBuf)super.writeFloat(f2);
    }

    @Override
    public CompositeByteBuf writeInt(int n2) {
        return (CompositeByteBuf)super.writeInt(n2);
    }

    @Override
    public CompositeByteBuf writeLong(long l2) {
        return (CompositeByteBuf)super.writeLong(l2);
    }

    @Override
    public CompositeByteBuf writeMedium(int n2) {
        return (CompositeByteBuf)super.writeMedium(n2);
    }

    @Override
    public CompositeByteBuf writeShort(int n2) {
        return (CompositeByteBuf)super.writeShort(n2);
    }

    @Override
    public CompositeByteBuf writeZero(int n2) {
        return (CompositeByteBuf)super.writeZero(n2);
    }

    @Override
    public CompositeByteBuf writerIndex(int n2) {
        return (CompositeByteBuf)super.writerIndex(n2);
    }

}

