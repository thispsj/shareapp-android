/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.nio.ByteOrder
 */
package io.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.SimpleLeakAwareByteBuf;
import io.netty.buffer.WrappedCompositeByteBuf;
import io.netty.d.b.l;
import io.netty.d.o;
import java.nio.ByteOrder;

class SimpleLeakAwareCompositeByteBuf
extends WrappedCompositeByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled;
    final o<ByteBuf> leak;

    SimpleLeakAwareCompositeByteBuf(CompositeByteBuf compositeByteBuf, o<ByteBuf> o2) {
        super(compositeByteBuf);
        this.leak = l.a(o2, "leak");
    }

    private void closeLeak(ByteBuf byteBuf) {
        this.leak.a(byteBuf);
    }

    private SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf) {
        return this.newLeakAwareByteBuf(byteBuf, this.unwrap(), this.leak);
    }

    @Override
    public ByteBuf duplicate() {
        return this.newLeakAwareByteBuf(super.duplicate());
    }

    protected SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, o<ByteBuf> o2) {
        return new SimpleLeakAwareByteBuf(byteBuf, byteBuf2, o2);
    }

    @Override
    public ByteBuf order(ByteOrder byteOrder) {
        if (this.order() == byteOrder) {
            return this;
        }
        return SimpleLeakAwareCompositeByteBuf.super.newLeakAwareByteBuf(super.order(byteOrder));
    }

    @Override
    public ByteBuf readSlice(int n2) {
        return SimpleLeakAwareCompositeByteBuf.super.newLeakAwareByteBuf(super.readSlice(n2));
    }

    @Override
    public boolean release() {
        ByteBuf byteBuf = this.unwrap();
        if (super.release()) {
            this.closeLeak(byteBuf);
            return true;
        }
        return false;
    }

    @Override
    public boolean release(int n2) {
        ByteBuf byteBuf = this.unwrap();
        if (super.release(n2)) {
            SimpleLeakAwareCompositeByteBuf.super.closeLeak(byteBuf);
            return true;
        }
        return false;
    }

    @Override
    public ByteBuf slice() {
        return this.newLeakAwareByteBuf(super.slice());
    }

    @Override
    public ByteBuf slice(int n2, int n3) {
        return SimpleLeakAwareCompositeByteBuf.super.newLeakAwareByteBuf(super.slice(n2, n3));
    }
}

