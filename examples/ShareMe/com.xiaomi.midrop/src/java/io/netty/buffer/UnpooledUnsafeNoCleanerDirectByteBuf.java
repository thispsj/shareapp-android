/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.nio.ByteBuffer
 */
package io.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledUnsafeDirectByteBuf;
import io.netty.d.b.n;
import java.nio.ByteBuffer;

class UnpooledUnsafeNoCleanerDirectByteBuf
extends UnpooledUnsafeDirectByteBuf {
    UnpooledUnsafeNoCleanerDirectByteBuf(ByteBufAllocator byteBufAllocator, int n2, int n3) {
        super(byteBufAllocator, n2, n3);
    }

    @Override
    protected ByteBuffer allocateDirect(int n2) {
        return n.b(n2);
    }

    @Override
    public ByteBuf capacity(int n2) {
        this.checkNewCapacity(n2);
        int n3 = this.capacity();
        if (n2 == n3) {
            return this;
        }
        ByteBuffer byteBuffer = this.reallocateDirect(this.buffer, n2);
        if (n2 < n3) {
            if (this.readerIndex() < n2) {
                if (this.writerIndex() > n2) {
                    this.writerIndex(n2);
                }
            } else {
                this.setIndex(n2, n2);
            }
        }
        this.setByteBuffer(byteBuffer, false);
        return this;
    }

    @Override
    protected void freeDirect(ByteBuffer byteBuffer) {
        n.c(byteBuffer);
    }

    ByteBuffer reallocateDirect(ByteBuffer byteBuffer, int n2) {
        return n.a(byteBuffer, n2);
    }
}

