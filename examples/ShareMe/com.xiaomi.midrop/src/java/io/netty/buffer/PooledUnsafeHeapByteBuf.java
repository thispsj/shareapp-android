/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.PooledUnsafeHeapByteBuf$1
 *  java.lang.Deprecated
 *  java.lang.Object
 */
package io.netty.buffer;

import io.netty.buffer.AbstractByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledHeapByteBuf;
import io.netty.buffer.PooledUnsafeHeapByteBuf;
import io.netty.buffer.SwappedByteBuf;
import io.netty.buffer.UnsafeByteBufUtil;
import io.netty.buffer.UnsafeHeapSwappedByteBuf;
import io.netty.d.b.n;
import io.netty.d.j;

final class PooledUnsafeHeapByteBuf
extends PooledHeapByteBuf {
    private static final j<PooledUnsafeHeapByteBuf> RECYCLER = new 1();

    private PooledUnsafeHeapByteBuf(j.b b2, int n2) {
        super(b2, n2);
    }

    /* synthetic */ PooledUnsafeHeapByteBuf(j.b b2, int n2, 1 var3_2) {
        super(b2, n2);
    }

    static PooledUnsafeHeapByteBuf newUnsafeInstance(int n2) {
        PooledUnsafeHeapByteBuf pooledUnsafeHeapByteBuf = RECYCLER.get();
        pooledUnsafeHeapByteBuf.reuse(n2);
        return pooledUnsafeHeapByteBuf;
    }

    @Override
    protected final byte _getByte(int n2) {
        return UnsafeByteBufUtil.getByte((byte[])this.memory, this.idx(n2));
    }

    @Override
    protected final int _getInt(int n2) {
        return UnsafeByteBufUtil.getInt((byte[])this.memory, this.idx(n2));
    }

    @Override
    protected final long _getLong(int n2) {
        return UnsafeByteBufUtil.getLong((byte[])this.memory, this.idx(n2));
    }

    @Override
    protected final short _getShort(int n2) {
        return UnsafeByteBufUtil.getShort((byte[])this.memory, this.idx(n2));
    }

    @Override
    protected final int _getUnsignedMedium(int n2) {
        return UnsafeByteBufUtil.getUnsignedMedium((byte[])this.memory, this.idx(n2));
    }

    @Override
    protected final void _setByte(int n2, int n3) {
        UnsafeByteBufUtil.setByte((byte[])this.memory, this.idx(n2), n3);
    }

    @Override
    protected final void _setInt(int n2, int n3) {
        UnsafeByteBufUtil.setInt((byte[])this.memory, this.idx(n2), n3);
    }

    @Override
    protected final void _setLong(int n2, long l2) {
        UnsafeByteBufUtil.setLong((byte[])this.memory, this.idx(n2), l2);
    }

    @Override
    protected final void _setMedium(int n2, int n3) {
        UnsafeByteBufUtil.setMedium((byte[])this.memory, this.idx(n2), n3);
    }

    @Override
    protected final void _setShort(int n2, int n3) {
        UnsafeByteBufUtil.setShort((byte[])this.memory, this.idx(n2), n3);
    }

    @Deprecated
    @Override
    protected final SwappedByteBuf newSwappedByteBuf() {
        if (n.g()) {
            return new UnsafeHeapSwappedByteBuf(this);
        }
        return super.newSwappedByteBuf();
    }

    @Override
    protected final j<?> recycler() {
        return RECYCLER;
    }

    @Override
    public final ByteBuf setZero(int n2, int n3) {
        if (n.d() >= 7) {
            this.checkIndex(n2, n3);
            UnsafeByteBufUtil.setZero((byte[])this.memory, this.idx(n2), n3);
            return this;
        }
        return super.setZero(n2, n3);
    }

    @Override
    public final ByteBuf writeZero(int n2) {
        if (n.d() >= 7) {
            this.ensureWritable(n2);
            int n3 = this.writerIndex;
            UnsafeByteBufUtil.setZero((byte[])this.memory, this.idx(n3), n2);
            this.writerIndex = n3 + n2;
            return this;
        }
        return super.writeZero(n2);
    }
}

