/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.lang.NullPointerException
 *  java.lang.String
 *  java.nio.ByteOrder
 */
package io.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.SwappedByteBuf;
import io.netty.buffer.WrappedByteBuf;
import io.netty.d.l;
import java.nio.ByteOrder;

final class UnreleasableByteBuf
extends WrappedByteBuf {
    private SwappedByteBuf swappedBuf;

    UnreleasableByteBuf(ByteBuf byteBuf) {
        super(byteBuf);
    }

    @Override
    public final ByteBuf duplicate() {
        return new UnreleasableByteBuf(this.buf.duplicate());
    }

    @Override
    public final ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        }
        if (byteOrder == this.order()) {
            return this;
        }
        SwappedByteBuf swappedByteBuf = this.swappedBuf;
        if (swappedByteBuf == null) {
            this.swappedBuf = swappedByteBuf = new SwappedByteBuf((ByteBuf)this);
        }
        return swappedByteBuf;
    }

    @Override
    public final ByteBuf readSlice(int n2) {
        return new UnreleasableByteBuf(this.buf.readSlice(n2));
    }

    @Override
    public final boolean release() {
        return false;
    }

    @Override
    public final boolean release(int n2) {
        return false;
    }

    @Override
    public final ByteBuf retain() {
        return this;
    }

    @Override
    public final ByteBuf retain(int n2) {
        return this;
    }

    @Override
    public final ByteBuf slice() {
        return new UnreleasableByteBuf(this.buf.slice());
    }

    @Override
    public final ByteBuf slice(int n2, int n3) {
        return new UnreleasableByteBuf(this.buf.slice(n2, n3));
    }
}

