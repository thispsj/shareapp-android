/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.ByteBufHolder
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.d.b.t;
import io.netty.d.f;
import io.netty.d.l;

public class DefaultByteBufHolder
implements ByteBufHolder {
    private final ByteBuf data;

    public DefaultByteBufHolder(ByteBuf byteBuf) {
        if (byteBuf == null) {
            throw new NullPointerException("data");
        }
        this.data = byteBuf;
    }

    public ByteBuf content() {
        if (this.data.refCnt() <= 0) {
            throw new f(this.data.refCnt());
        }
        return this.data;
    }

    protected final String contentToString() {
        return this.data.toString();
    }

    public ByteBufHolder copy() {
        return new DefaultByteBufHolder(this.data.copy());
    }

    public ByteBufHolder duplicate() {
        return new DefaultByteBufHolder(this.data.duplicate());
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof ByteBufHolder) {
            return this.data.equals((Object)((ByteBufHolder)object).content());
        }
        return false;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public int refCnt() {
        return this.data.refCnt();
    }

    public boolean release() {
        return this.data.release();
    }

    public boolean release(int n2) {
        return this.data.release(n2);
    }

    public ByteBufHolder retain() {
        this.data.retain();
        return this;
    }

    public ByteBufHolder retain(int n2) {
        this.data.retain(n2);
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(t.a(this));
        stringBuilder.append('(');
        stringBuilder.append(this.contentToString());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

