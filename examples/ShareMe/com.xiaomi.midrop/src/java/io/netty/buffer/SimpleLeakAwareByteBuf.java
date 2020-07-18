/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.nio.ByteOrder
 */
package io.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.WrappedByteBuf;
import io.netty.d.b.l;
import io.netty.d.o;
import java.nio.ByteOrder;

class SimpleLeakAwareByteBuf
extends WrappedByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled;
    final o<ByteBuf> leak;
    private final ByteBuf trackedByteBuf;

    SimpleLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, o<ByteBuf> o2) {
        super(byteBuf);
        this.trackedByteBuf = l.a(byteBuf2, "trackedByteBuf");
        this.leak = l.a(o2, "leak");
    }

    SimpleLeakAwareByteBuf(ByteBuf byteBuf, o<ByteBuf> o2) {
        super(byteBuf, byteBuf, o2);
    }

    private void closeLeak() {
        this.leak.a(this.trackedByteBuf);
    }

    private SimpleLeakAwareByteBuf newSharedLeakAwareByteBuf(ByteBuf byteBuf) {
        return this.newLeakAwareByteBuf(byteBuf, this.trackedByteBuf, this.leak);
    }

    @Override
    public ByteBuf duplicate() {
        return this.newSharedLeakAwareByteBuf(super.duplicate());
    }

    protected SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, o<ByteBuf> o2) {
        return new SimpleLeakAwareByteBuf(byteBuf, byteBuf2, o2);
    }

    @Override
    public ByteBuf order(ByteOrder byteOrder) {
        if (this.order() == byteOrder) {
            return this;
        }
        return SimpleLeakAwareByteBuf.super.newSharedLeakAwareByteBuf(super.order(byteOrder));
    }

    @Override
    public ByteBuf readSlice(int n2) {
        return SimpleLeakAwareByteBuf.super.newSharedLeakAwareByteBuf(super.readSlice(n2));
    }

    @Override
    public boolean release() {
        if (super.release()) {
            this.closeLeak();
            return true;
        }
        return false;
    }

    @Override
    public boolean release(int n2) {
        if (super.release(n2)) {
            SimpleLeakAwareByteBuf.super.closeLeak();
            return true;
        }
        return false;
    }

    @Override
    public ByteBuf slice() {
        return this.newSharedLeakAwareByteBuf(super.slice());
    }

    @Override
    public ByteBuf slice(int n2, int n3) {
        return SimpleLeakAwareByteBuf.super.newSharedLeakAwareByteBuf(super.slice(n2, n3));
    }
}

