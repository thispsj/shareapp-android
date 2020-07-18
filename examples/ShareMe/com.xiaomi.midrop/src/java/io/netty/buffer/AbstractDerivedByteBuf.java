/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.lang.Deprecated
 *  java.nio.ByteBuffer
 */
package io.netty.buffer;

import io.netty.buffer.AbstractByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.d.l;
import java.nio.ByteBuffer;

@Deprecated
public abstract class AbstractDerivedByteBuf
extends AbstractByteBuf {
    protected AbstractDerivedByteBuf(int n2) {
        super(n2);
    }

    public ByteBuffer internalNioBuffer(int n2, int n3) {
        return this.nioBuffer(n2, n3);
    }

    public ByteBuffer nioBuffer(int n2, int n3) {
        return this.unwrap().nioBuffer(n2, n3);
    }

    public final int refCnt() {
        return this.unwrap().refCnt();
    }

    public final boolean release() {
        return this.unwrap().release();
    }

    public final boolean release(int n2) {
        return this.unwrap().release(n2);
    }

    public final ByteBuf retain() {
        this.unwrap().retain();
        return this;
    }

    public final ByteBuf retain(int n2) {
        this.unwrap().retain(n2);
        return this;
    }
}

