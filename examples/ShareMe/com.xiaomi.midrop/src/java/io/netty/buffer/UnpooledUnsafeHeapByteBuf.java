/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.lang.Deprecated
 */
package io.netty.buffer;

import io.netty.buffer.AbstractByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.SwappedByteBuf;
import io.netty.buffer.UnpooledHeapByteBuf;
import io.netty.buffer.UnsafeByteBufUtil;
import io.netty.buffer.UnsafeHeapSwappedByteBuf;
import io.netty.d.b.n;

class UnpooledUnsafeHeapByteBuf
extends UnpooledHeapByteBuf {
    UnpooledUnsafeHeapByteBuf(ByteBufAllocator byteBufAllocator, int n2, int n3) {
        super(byteBufAllocator, n2, n3);
    }

    @Override
    protected byte _getByte(int n2) {
        return UnsafeByteBufUtil.getByte(this.array, n2);
    }

    @Override
    protected int _getInt(int n2) {
        return UnsafeByteBufUtil.getInt(this.array, n2);
    }

    @Override
    protected long _getLong(int n2) {
        return UnsafeByteBufUtil.getLong(this.array, n2);
    }

    @Override
    protected short _getShort(int n2) {
        return UnsafeByteBufUtil.getShort(this.array, n2);
    }

    @Override
    protected int _getUnsignedMedium(int n2) {
        return UnsafeByteBufUtil.getUnsignedMedium(this.array, n2);
    }

    @Override
    protected void _setByte(int n2, int n3) {
        UnsafeByteBufUtil.setByte(this.array, n2, n3);
    }

    @Override
    protected void _setInt(int n2, int n3) {
        UnsafeByteBufUtil.setInt(this.array, n2, n3);
    }

    @Override
    protected void _setLong(int n2, long l2) {
        UnsafeByteBufUtil.setLong(this.array, n2, l2);
    }

    @Override
    protected void _setMedium(int n2, int n3) {
        UnsafeByteBufUtil.setMedium(this.array, n2, n3);
    }

    @Override
    protected void _setShort(int n2, int n3) {
        UnsafeByteBufUtil.setShort(this.array, n2, n3);
    }

    @Override
    byte[] allocateArray(int n2) {
        return n.a(n2);
    }

    @Override
    public byte getByte(int n2) {
        this.checkIndex(n2);
        return this._getByte(n2);
    }

    @Override
    public int getInt(int n2) {
        this.checkIndex(n2, 4);
        return this._getInt(n2);
    }

    @Override
    public long getLong(int n2) {
        this.checkIndex(n2, 8);
        return this._getLong(n2);
    }

    @Override
    public short getShort(int n2) {
        this.checkIndex(n2, 2);
        return this._getShort(n2);
    }

    @Override
    public int getUnsignedMedium(int n2) {
        this.checkIndex(n2, 3);
        return this._getUnsignedMedium(n2);
    }

    @Deprecated
    @Override
    protected SwappedByteBuf newSwappedByteBuf() {
        if (n.g()) {
            return new UnsafeHeapSwappedByteBuf(this);
        }
        return super.newSwappedByteBuf();
    }

    @Override
    public ByteBuf setByte(int n2, int n3) {
        this.checkIndex(n2);
        this._setByte(n2, n3);
        return this;
    }

    @Override
    public ByteBuf setInt(int n2, int n3) {
        this.checkIndex(n2, 4);
        this._setInt(n2, n3);
        return this;
    }

    @Override
    public ByteBuf setLong(int n2, long l2) {
        this.checkIndex(n2, 8);
        this._setLong(n2, l2);
        return this;
    }

    @Override
    public ByteBuf setMedium(int n2, int n3) {
        this.checkIndex(n2, 3);
        this._setMedium(n2, n3);
        return this;
    }

    @Override
    public ByteBuf setShort(int n2, int n3) {
        this.checkIndex(n2, 2);
        this._setShort(n2, n3);
        return this;
    }

    @Override
    public ByteBuf setZero(int n2, int n3) {
        if (n.d() >= 7) {
            this.checkIndex(n2, n3);
            UnsafeByteBufUtil.setZero(this.array, n2, n3);
            return this;
        }
        return super.setZero(n2, n3);
    }

    @Override
    public ByteBuf writeZero(int n2) {
        if (n.d() >= 7) {
            this.ensureWritable(n2);
            int n3 = this.writerIndex;
            UnsafeByteBufUtil.setZero(this.array, n3, n2);
            this.writerIndex = n3 + n2;
            return this;
        }
        return super.writeZero(n2);
    }
}

