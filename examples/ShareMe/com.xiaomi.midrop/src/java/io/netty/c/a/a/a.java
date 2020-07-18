/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.lang.Exception
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.util.List
 */
package io.netty.c.a.a;

import io.netty.b.j;
import io.netty.buffer.ByteBuf;
import io.netty.c.a.f;
import java.nio.charset.Charset;
import java.util.List;

@j.a
public final class a
extends f<ByteBuf> {
    private final Charset a;

    public a() {
        this(Charset.defaultCharset());
    }

    private a(Charset charset) {
        if (charset == null) {
            throw new NullPointerException("charset");
        }
        this.a = charset;
    }

    @Override
    protected final /* synthetic */ void a(Object object, List list) throws Exception {
        list.add((Object)((ByteBuf)object).toString(this.a));
    }
}

