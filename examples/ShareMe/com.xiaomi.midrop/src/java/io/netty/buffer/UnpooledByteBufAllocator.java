/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.AbstractByteBufAllocator
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.UnpooledByteBufAllocator$UnpooledByteBufAllocatorMetric
 *  java.lang.Object
 *  java.nio.ByteBuffer
 */
package io.netty.buffer;

import io.netty.buffer.AbstractByteBufAllocator;
import io.netty.buffer.AbstractReferenceCountedByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufAllocatorMetric;
import io.netty.buffer.ByteBufAllocatorMetricProvider;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.buffer.UnpooledDirectByteBuf;
import io.netty.buffer.UnpooledHeapByteBuf;
import io.netty.buffer.UnpooledUnsafeDirectByteBuf;
import io.netty.buffer.UnpooledUnsafeHeapByteBuf;
import io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf;
import io.netty.d.b.i;
import io.netty.d.b.n;
import java.nio.ByteBuffer;

/*
 * Exception performing whole class analysis.
 */
public final class UnpooledByteBufAllocator
extends AbstractByteBufAllocator
implements ByteBufAllocatorMetricProvider {
    public static final UnpooledByteBufAllocator DEFAULT;
    private final boolean disableLeakDetector;
    private final UnpooledByteBufAllocatorMetric metric;
    private final boolean noCleaner;

    static {
        DEFAULT = new UnpooledByteBufAllocator(n.h());
    }

    public UnpooledByteBufAllocator(boolean bl) {
        super(bl, false);
    }

    public UnpooledByteBufAllocator(boolean bl, boolean bl2) {
        super(bl, bl2, n.l());
    }

    public UnpooledByteBufAllocator(boolean bl, boolean bl2, boolean bl3) {
        super(bl);
        this.metric = new /* Unavailable Anonymous Inner Class!! */;
        this.disableLeakDetector = bl2;
        boolean bl4 = bl3 && n.f() && n.a();
        this.noCleaner = bl4;
    }

    public final CompositeByteBuf compositeDirectBuffer(int n2) {
        CompositeByteBuf compositeByteBuf = new CompositeByteBuf((ByteBufAllocator)this, true, n2);
        if (this.disableLeakDetector) {
            return compositeByteBuf;
        }
        return UnpooledByteBufAllocator.toLeakAwareBuffer((CompositeByteBuf)compositeByteBuf);
    }

    public final CompositeByteBuf compositeHeapBuffer(int n2) {
        CompositeByteBuf compositeByteBuf = new CompositeByteBuf((ByteBufAllocator)this, false, n2);
        if (this.disableLeakDetector) {
            return compositeByteBuf;
        }
        return UnpooledByteBufAllocator.toLeakAwareBuffer((CompositeByteBuf)compositeByteBuf);
    }

    final void decrementDirect(int n2) {
        this.metric.directCounter.add(-n2);
    }

    final void decrementHeap(int n2) {
        this.metric.heapCounter.add(-n2);
    }

    final void incrementDirect(int n2) {
        this.metric.directCounter.add(n2);
    }

    final void incrementHeap(int n2) {
        this.metric.heapCounter.add(n2);
    }

    public final boolean isDirectBufferPooled() {
        return false;
    }

    @Override
    public final ByteBufAllocatorMetric metric() {
        return this.metric;
    }

    protected final ByteBuf newDirectBuffer(int n2, int n3) {
        AbstractReferenceCountedByteBuf abstractReferenceCountedByteBuf = n.f() ? (this.noCleaner ? new InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf((UnpooledByteBufAllocator)this, n2, n3) : new InstrumentedUnpooledUnsafeDirectByteBuf((UnpooledByteBufAllocator)this, n2, n3)) : new InstrumentedUnpooledDirectByteBuf((UnpooledByteBufAllocator)this, n2, n3);
        if (this.disableLeakDetector) {
            return abstractReferenceCountedByteBuf;
        }
        return UnpooledByteBufAllocator.toLeakAwareBuffer((ByteBuf)abstractReferenceCountedByteBuf);
    }

    protected final ByteBuf newHeapBuffer(int n2, int n3) {
        if (n.f()) {
            return new InstrumentedUnpooledUnsafeHeapByteBuf((UnpooledByteBufAllocator)this, n2, n3);
        }
        return new InstrumentedUnpooledHeapByteBuf((UnpooledByteBufAllocator)this, n2, n3);
    }

    private static final class InstrumentedUnpooledDirectByteBuf
    extends UnpooledDirectByteBuf {
        InstrumentedUnpooledDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int n2, int n3) {
            super((ByteBufAllocator)((Object)unpooledByteBufAllocator), n2, n3);
        }

        @Override
        protected final ByteBuffer allocateDirect(int n2) {
            ByteBuffer byteBuffer = super.allocateDirect(n2);
            ((UnpooledByteBufAllocator)((Object)this.alloc())).incrementDirect(byteBuffer.capacity());
            return byteBuffer;
        }

        @Override
        protected final void freeDirect(ByteBuffer byteBuffer) {
            int n2 = byteBuffer.capacity();
            super.freeDirect(byteBuffer);
            ((UnpooledByteBufAllocator)((Object)this.alloc())).decrementDirect(n2);
        }
    }

    private static final class InstrumentedUnpooledHeapByteBuf
    extends UnpooledHeapByteBuf {
        InstrumentedUnpooledHeapByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int n2, int n3) {
            super((ByteBufAllocator)((Object)unpooledByteBufAllocator), n2, n3);
        }

        @Override
        final byte[] allocateArray(int n2) {
            byte[] arrby = super.allocateArray(n2);
            ((UnpooledByteBufAllocator)((Object)this.alloc())).incrementHeap(arrby.length);
            return arrby;
        }

        @Override
        final void freeArray(byte[] arrby) {
            int n2 = arrby.length;
            super.freeArray(arrby);
            ((UnpooledByteBufAllocator)((Object)this.alloc())).decrementHeap(n2);
        }
    }

    private static final class InstrumentedUnpooledUnsafeDirectByteBuf
    extends UnpooledUnsafeDirectByteBuf {
        InstrumentedUnpooledUnsafeDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int n2, int n3) {
            super((ByteBufAllocator)((Object)unpooledByteBufAllocator), n2, n3);
        }

        @Override
        protected final ByteBuffer allocateDirect(int n2) {
            ByteBuffer byteBuffer = super.allocateDirect(n2);
            ((UnpooledByteBufAllocator)((Object)this.alloc())).incrementDirect(byteBuffer.capacity());
            return byteBuffer;
        }

        @Override
        protected final void freeDirect(ByteBuffer byteBuffer) {
            int n2 = byteBuffer.capacity();
            super.freeDirect(byteBuffer);
            ((UnpooledByteBufAllocator)((Object)this.alloc())).decrementDirect(n2);
        }
    }

    private static final class InstrumentedUnpooledUnsafeHeapByteBuf
    extends UnpooledUnsafeHeapByteBuf {
        InstrumentedUnpooledUnsafeHeapByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int n2, int n3) {
            super((ByteBufAllocator)((Object)unpooledByteBufAllocator), n2, n3);
        }

        @Override
        final byte[] allocateArray(int n2) {
            byte[] arrby = super.allocateArray(n2);
            ((UnpooledByteBufAllocator)((Object)this.alloc())).incrementHeap(arrby.length);
            return arrby;
        }

        @Override
        final void freeArray(byte[] arrby) {
            int n2 = arrby.length;
            super.freeArray(arrby);
            ((UnpooledByteBufAllocator)((Object)this.alloc())).decrementHeap(n2);
        }
    }

    private static final class InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf
    extends UnpooledUnsafeNoCleanerDirectByteBuf {
        InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int n2, int n3) {
            super((ByteBufAllocator)((Object)unpooledByteBufAllocator), n2, n3);
        }

        @Override
        protected final ByteBuffer allocateDirect(int n2) {
            ByteBuffer byteBuffer = super.allocateDirect(n2);
            ((UnpooledByteBufAllocator)((Object)this.alloc())).incrementDirect(byteBuffer.capacity());
            return byteBuffer;
        }

        @Override
        protected final void freeDirect(ByteBuffer byteBuffer) {
            int n2 = byteBuffer.capacity();
            super.freeDirect(byteBuffer);
            ((UnpooledByteBufAllocator)((Object)this.alloc())).decrementDirect(n2);
        }

        @Override
        final ByteBuffer reallocateDirect(ByteBuffer byteBuffer, int n2) {
            int n3 = byteBuffer.capacity();
            ByteBuffer byteBuffer2 = super.reallocateDirect(byteBuffer, n2);
            ((UnpooledByteBufAllocator)((Object)this.alloc())).incrementDirect(byteBuffer2.capacity() - n3);
            return byteBuffer2;
        }
    }

}

