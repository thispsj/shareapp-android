/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package io.netty.buffer;

import io.netty.buffer.AbstractByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.DuplicatedByteBuf;

final class DuplicatedAbstractByteBuf
extends DuplicatedByteBuf {
    DuplicatedAbstractByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    @Override
    protected final byte _getByte(int n2) {
        return this.unwrap()._getByte(n2);
    }

    @Override
    protected final int _getInt(int n2) {
        return this.unwrap()._getInt(n2);
    }

    @Override
    protected final long _getLong(int n2) {
        return this.unwrap()._getLong(n2);
    }

    @Override
    protected final short _getShort(int n2) {
        return this.unwrap()._getShort(n2);
    }

    @Override
    protected final int _getUnsignedMedium(int n2) {
        return this.unwrap()._getUnsignedMedium(n2);
    }

    @Override
    protected final void _setByte(int n2, int n3) {
        this.unwrap()._setByte(n2, n3);
    }

    @Override
    protected final void _setInt(int n2, int n3) {
        this.unwrap()._setInt(n2, n3);
    }

    @Override
    protected final void _setLong(int n2, long l2) {
        this.unwrap()._setLong(n2, l2);
    }

    @Override
    protected final void _setMedium(int n2, int n3) {
        this.unwrap()._setMedium(n2, n3);
    }

    @Override
    protected final void _setShort(int n2, int n3) {
        this.unwrap()._setShort(n2, n3);
    }

    @Override
    public final AbstractByteBuf unwrap() {
        return (AbstractByteBuf)super.unwrap();
    }
}

