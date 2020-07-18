/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.nio.ByteBuffer
 */
package io.netty.buffer;

import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledUnsafeDirectByteBuf;
import io.netty.d.b.n;
import java.nio.ByteBuffer;

final class WrappedUnpooledUnsafeDirectByteBuf
extends UnpooledUnsafeDirectByteBuf {
    WrappedUnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, long l2, int n2, boolean bl) {
        super(byteBufAllocator, n.a(l2, n2), n2, bl);
    }

    @Override
    protected final void freeDirect(ByteBuffer byteBuffer) {
        n.a(this.memoryAddress);
    }
}

