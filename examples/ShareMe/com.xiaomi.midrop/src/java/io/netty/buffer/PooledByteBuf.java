/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.PoolArena
 *  io.netty.buffer.PoolChunk
 *  java.lang.Math
 *  java.lang.Object
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 */
package io.netty.buffer;

import io.netty.buffer.AbstractReferenceCountedByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PoolArena;
import io.netty.buffer.PoolChunk;
import io.netty.buffer.PoolThreadCache;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.d.j;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

abstract class PooledByteBuf<T>
extends AbstractReferenceCountedByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled;
    private ByteBufAllocator allocator;
    PoolThreadCache cache;
    protected PoolChunk<T> chunk;
    protected long handle;
    protected int length;
    int maxLength;
    protected T memory;
    protected int offset;
    private final j.b recyclerHandle;
    private ByteBuffer tmpNioBuf;

    protected PooledByteBuf(j.b b2, int n2) {
        super(n2);
        this.recyclerHandle = b2;
    }

    private void init0(PoolChunk<T> poolChunk, long l2, int n2, int n3, int n4, PoolThreadCache poolThreadCache) {
        this.chunk = poolChunk;
        this.memory = poolChunk.memory;
        this.allocator = poolChunk.arena.parent;
        this.cache = poolThreadCache;
        this.handle = l2;
        this.offset = n2;
        this.length = n3;
        this.maxLength = n4;
        this.tmpNioBuf = null;
    }

    private void recycle() {
        j.b b2 = this.recyclerHandle;
        if (b2 != null) {
            this.recycler().recycle(this, b2);
        }
    }

    public final ByteBufAllocator alloc() {
        return this.allocator;
    }

    public final int capacity() {
        return this.length;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final ByteBuf capacity(int n2) {
        this.checkNewCapacity(n2);
        if (this.chunk.unpooled) {
            if (n2 == this.length) {
                return this;
            }
        } else if (n2 > this.length) {
            if (n2 <= this.maxLength) {
                this.length = n2;
                return this;
            }
        } else {
            if (n2 >= this.length) return this;
            if (n2 > this.maxLength >>> 1) {
                if (this.maxLength <= 512) {
                    if (n2 > -16 + this.maxLength) {
                        this.length = n2;
                        this.setIndex(Math.min((int)this.readerIndex(), (int)n2), Math.min((int)this.writerIndex(), (int)n2));
                        return this;
                    }
                } else {
                    this.length = n2;
                    this.setIndex(Math.min((int)this.readerIndex(), (int)n2), Math.min((int)this.writerIndex(), (int)n2));
                    return this;
                }
            }
        }
        this.chunk.arena.reallocate((PooledByteBuf)this, n2, true);
        return this;
    }

    @Override
    protected final void deallocate() {
        if (this.handle >= 0L) {
            long l2 = this.handle;
            this.handle = -1L;
            this.memory = null;
            this.tmpNioBuf = null;
            this.chunk.arena.free(this.chunk, l2, this.maxLength, this.cache);
            this.chunk = null;
            this.recycle();
        }
    }

    protected final int idx(int n2) {
        return n2 + this.offset;
    }

    void init(PoolChunk<T> poolChunk, long l2, int n2, int n3, int n4, PoolThreadCache poolThreadCache) {
        this.init0(poolChunk, l2, n2, n3, n4, poolThreadCache);
    }

    void initUnpooled(PoolChunk<T> poolChunk, int n2) {
        PooledByteBuf.super.init0(poolChunk, 0L, poolChunk.offset, n2, n2, null);
    }

    protected final ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer == null) {
            this.tmpNioBuf = byteBuffer = this.newInternalNioBuffer(this.memory);
        }
        return byteBuffer;
    }

    protected abstract ByteBuffer newInternalNioBuffer(T var1);

    public final ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    protected abstract j<?> recycler();

    final void reuse(int n2) {
        this.maxCapacity(n2);
        this.setRefCnt(1);
        this.setIndex0(0, 0);
        this.discardMarks();
    }

    public final ByteBuf unwrap() {
        return null;
    }
}

