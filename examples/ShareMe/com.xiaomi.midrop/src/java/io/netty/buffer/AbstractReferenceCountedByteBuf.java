/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 */
package io.netty.buffer;

import io.netty.buffer.AbstractByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.d.b.l;
import io.netty.d.f;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class AbstractReferenceCountedByteBuf
extends AbstractByteBuf {
    private static final AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> refCntUpdater = AtomicIntegerFieldUpdater.newUpdater(AbstractReferenceCountedByteBuf.class, (String)"refCnt");
    private volatile int refCnt;

    protected AbstractReferenceCountedByteBuf(int n2) {
        super(n2);
        refCntUpdater.set((Object)this, 1);
    }

    private boolean release0(int n2) {
        int n3 = refCntUpdater.getAndAdd((Object)this, -n2);
        if (n3 == n2) {
            this.deallocate();
            return true;
        }
        if (n3 >= n2 && n3 - n2 <= n3) {
            return false;
        }
        refCntUpdater.getAndAdd((Object)this, n2);
        throw new f(n3, n2);
    }

    private ByteBuf retain0(int n2) {
        int n3 = refCntUpdater.getAndAdd((Object)this, n2);
        if (n3 > 0 && n3 + n2 >= n3) {
            return this;
        }
        refCntUpdater.getAndAdd((Object)this, -n2);
        throw new f(n3, n2);
    }

    protected abstract void deallocate();

    public int refCnt() {
        return this.refCnt;
    }

    public boolean release() {
        return this.release0(1);
    }

    public boolean release(int n2) {
        return AbstractReferenceCountedByteBuf.super.release0(l.a(n2, "decrement"));
    }

    public ByteBuf retain() {
        return this.retain0(1);
    }

    public ByteBuf retain(int n2) {
        return AbstractReferenceCountedByteBuf.super.retain0(l.a(n2, "increment"));
    }

    protected final void setRefCnt(int n2) {
        refCntUpdater.set((Object)this, n2);
    }
}

