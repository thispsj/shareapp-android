/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 */
package io.netty.buffer;

import io.netty.buffer.AbstractByteBuf;
import io.netty.buffer.AbstractUnsafeSwappedByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.d.b.n;

final class UnsafeHeapSwappedByteBuf
extends AbstractUnsafeSwappedByteBuf {
    UnsafeHeapSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    private static int idx(ByteBuf byteBuf, int n2) {
        return n2 + byteBuf.arrayOffset();
    }

    @Override
    protected final int _getInt(AbstractByteBuf abstractByteBuf, int n2) {
        return n.c(abstractByteBuf.array(), UnsafeHeapSwappedByteBuf.idx(abstractByteBuf, n2));
    }

    @Override
    protected final long _getLong(AbstractByteBuf abstractByteBuf, int n2) {
        return n.d(abstractByteBuf.array(), UnsafeHeapSwappedByteBuf.idx(abstractByteBuf, n2));
    }

    @Override
    protected final short _getShort(AbstractByteBuf abstractByteBuf, int n2) {
        return n.b(abstractByteBuf.array(), UnsafeHeapSwappedByteBuf.idx(abstractByteBuf, n2));
    }

    @Override
    protected final void _setInt(AbstractByteBuf abstractByteBuf, int n2, int n3) {
        n.a(abstractByteBuf.array(), UnsafeHeapSwappedByteBuf.idx(abstractByteBuf, n2), n3);
    }

    @Override
    protected final void _setLong(AbstractByteBuf abstractByteBuf, int n2, long l2) {
        n.a(abstractByteBuf.array(), UnsafeHeapSwappedByteBuf.idx(abstractByteBuf, n2), l2);
    }

    @Override
    protected final void _setShort(AbstractByteBuf abstractByteBuf, int n2, short s2) {
        n.a(abstractByteBuf.array(), UnsafeHeapSwappedByteBuf.idx(abstractByteBuf, n2), s2);
    }
}

