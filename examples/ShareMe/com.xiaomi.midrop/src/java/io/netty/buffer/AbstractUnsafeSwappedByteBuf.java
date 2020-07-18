/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Short
 *  java.nio.ByteOrder
 */
package io.netty.buffer;

import io.netty.buffer.AbstractByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.SwappedByteBuf;
import io.netty.buffer.UnsafeByteBufUtil;
import java.nio.ByteOrder;

abstract class AbstractUnsafeSwappedByteBuf
extends SwappedByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final boolean nativeByteOrder;
    private final AbstractByteBuf wrapped;

    AbstractUnsafeSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
        this.wrapped = abstractByteBuf;
        boolean bl = UnsafeByteBufUtil.BIG_ENDIAN_NATIVE_ORDER;
        boolean bl2 = this.order() == ByteOrder.BIG_ENDIAN;
        boolean bl3 = false;
        if (bl == bl2) {
            bl3 = true;
        }
        this.nativeByteOrder = bl3;
    }

    protected abstract int _getInt(AbstractByteBuf var1, int var2);

    protected abstract long _getLong(AbstractByteBuf var1, int var2);

    protected abstract short _getShort(AbstractByteBuf var1, int var2);

    protected abstract void _setInt(AbstractByteBuf var1, int var2, int var3);

    protected abstract void _setLong(AbstractByteBuf var1, int var2, long var3);

    protected abstract void _setShort(AbstractByteBuf var1, int var2, short var3);

    @Override
    public final char getChar(int n2) {
        return (char)this.getShort(n2);
    }

    @Override
    public final double getDouble(int n2) {
        return Double.longBitsToDouble((long)this.getLong(n2));
    }

    @Override
    public final float getFloat(int n2) {
        return Float.intBitsToFloat((int)this.getInt(n2));
    }

    @Override
    public final int getInt(int n2) {
        this.wrapped.checkIndex0(n2, 4);
        int n3 = this._getInt(this.wrapped, n2);
        if (this.nativeByteOrder) {
            return n3;
        }
        return Integer.reverseBytes((int)n3);
    }

    @Override
    public final long getLong(int n2) {
        this.wrapped.checkIndex(n2, 8);
        long l2 = this._getLong(this.wrapped, n2);
        if (this.nativeByteOrder) {
            return l2;
        }
        return Long.reverseBytes((long)l2);
    }

    @Override
    public final short getShort(int n2) {
        this.wrapped.checkIndex0(n2, 2);
        short s2 = this._getShort(this.wrapped, n2);
        if (this.nativeByteOrder) {
            return s2;
        }
        return Short.reverseBytes((short)s2);
    }

    @Override
    public final long getUnsignedInt(int n2) {
        return 0xFFFFFFFFL & (long)this.getInt(n2);
    }

    @Override
    public final int getUnsignedShort(int n2) {
        return 65535 & this.getShort(n2);
    }

    @Override
    public final ByteBuf setChar(int n2, int n3) {
        this.setShort(n2, n3);
        return this;
    }

    @Override
    public final ByteBuf setDouble(int n2, double d2) {
        this.setLong(n2, Double.doubleToRawLongBits((double)d2));
        return this;
    }

    @Override
    public final ByteBuf setFloat(int n2, float f2) {
        this.setInt(n2, Float.floatToRawIntBits((float)f2));
        return this;
    }

    @Override
    public final ByteBuf setInt(int n2, int n3) {
        this.wrapped.checkIndex0(n2, 4);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        if (!this.nativeByteOrder) {
            n3 = Integer.reverseBytes((int)n3);
        }
        this._setInt(abstractByteBuf, n2, n3);
        return this;
    }

    @Override
    public final ByteBuf setLong(int n2, long l2) {
        this.wrapped.checkIndex(n2, 8);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        if (!this.nativeByteOrder) {
            l2 = Long.reverseBytes((long)l2);
        }
        this._setLong(abstractByteBuf, n2, l2);
        return this;
    }

    @Override
    public final ByteBuf setShort(int n2, int n3) {
        this.wrapped.checkIndex0(n2, 2);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        short s2 = this.nativeByteOrder ? (short)n3 : Short.reverseBytes((short)((short)n3));
        this._setShort(abstractByteBuf, n2, s2);
        return this;
    }

    @Override
    public final ByteBuf writeChar(int n2) {
        this.writeShort(n2);
        return this;
    }

    @Override
    public final ByteBuf writeDouble(double d2) {
        this.writeLong(Double.doubleToRawLongBits((double)d2));
        return this;
    }

    @Override
    public final ByteBuf writeFloat(float f2) {
        this.writeInt(Float.floatToRawIntBits((float)f2));
        return this;
    }

    @Override
    public final ByteBuf writeInt(int n2) {
        this.wrapped.ensureWritable0(4);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int n3 = this.wrapped.writerIndex;
        if (!this.nativeByteOrder) {
            n2 = Integer.reverseBytes((int)n2);
        }
        this._setInt(abstractByteBuf, n3, n2);
        AbstractByteBuf abstractByteBuf2 = this.wrapped;
        abstractByteBuf2.writerIndex = 4 + abstractByteBuf2.writerIndex;
        return this;
    }

    @Override
    public final ByteBuf writeLong(long l2) {
        this.wrapped.ensureWritable0(8);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int n2 = this.wrapped.writerIndex;
        if (!this.nativeByteOrder) {
            l2 = Long.reverseBytes((long)l2);
        }
        this._setLong(abstractByteBuf, n2, l2);
        AbstractByteBuf abstractByteBuf2 = this.wrapped;
        abstractByteBuf2.writerIndex = 8 + abstractByteBuf2.writerIndex;
        return this;
    }

    @Override
    public final ByteBuf writeShort(int n2) {
        this.wrapped.ensureWritable0(2);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int n3 = this.wrapped.writerIndex;
        short s2 = this.nativeByteOrder ? (short)n2 : Short.reverseBytes((short)((short)n2));
        this._setShort(abstractByteBuf, n3, s2);
        AbstractByteBuf abstractByteBuf2 = this.wrapped;
        abstractByteBuf2.writerIndex = 2 + abstractByteBuf2.writerIndex;
        return this;
    }
}

