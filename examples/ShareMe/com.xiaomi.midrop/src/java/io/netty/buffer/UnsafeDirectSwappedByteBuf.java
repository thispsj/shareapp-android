/*
 * Decompiled with CFR 0.0.
 */
package io.netty.buffer;

import io.netty.buffer.AbstractByteBuf;
import io.netty.buffer.AbstractUnsafeSwappedByteBuf;
import io.netty.d.b.n;

final class UnsafeDirectSwappedByteBuf
extends AbstractUnsafeSwappedByteBuf {
    UnsafeDirectSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    private static long addr(AbstractByteBuf abstractByteBuf, int n2) {
        return abstractByteBuf.memoryAddress() + (long)n2;
    }

    @Override
    protected final int _getInt(AbstractByteBuf abstractByteBuf, int n2) {
        return n.d(UnsafeDirectSwappedByteBuf.addr(abstractByteBuf, n2));
    }

    @Override
    protected final long _getLong(AbstractByteBuf abstractByteBuf, int n2) {
        return n.e(UnsafeDirectSwappedByteBuf.addr(abstractByteBuf, n2));
    }

    @Override
    protected final short _getShort(AbstractByteBuf abstractByteBuf, int n2) {
        return n.c(UnsafeDirectSwappedByteBuf.addr(abstractByteBuf, n2));
    }

    @Override
    protected final void _setInt(AbstractByteBuf abstractByteBuf, int n2, int n3) {
        n.b(UnsafeDirectSwappedByteBuf.addr(abstractByteBuf, n2), n3);
    }

    @Override
    protected final void _setLong(AbstractByteBuf abstractByteBuf, int n2, long l2) {
        n.a(UnsafeDirectSwappedByteBuf.addr(abstractByteBuf, n2), l2);
    }

    @Override
    protected final void _setShort(AbstractByteBuf abstractByteBuf, int n2, short s2) {
        n.a(UnsafeDirectSwappedByteBuf.addr(abstractByteBuf, n2), s2);
    }
}

