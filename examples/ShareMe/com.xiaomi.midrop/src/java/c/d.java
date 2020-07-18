/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.channels.WritableByteChannel
 */
package c;

import c.c;
import c.f;
import c.s;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;

public interface d
extends s,
WritableByteChannel {
    public c b();

    public d b(String var1) throws IOException;

    public d b(String var1, int var2, int var3) throws IOException;

    public d c(byte[] var1) throws IOException;

    public d c(byte[] var1, int var2, int var3) throws IOException;

    public d d(f var1) throws IOException;

    public d f(int var1) throws IOException;

    @Override
    public void flush() throws IOException;

    public d g(int var1) throws IOException;

    public d h(int var1) throws IOException;

    public d l(long var1) throws IOException;

    public d m(long var1) throws IOException;

    public d s() throws IOException;
}

