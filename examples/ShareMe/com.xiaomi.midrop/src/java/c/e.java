/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.channels.ReadableByteChannel
 *  java.nio.charset.Charset
 */
package c;

import c.c;
import c.f;
import c.m;
import c.s;
import c.t;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

public interface e
extends t,
ReadableByteChannel {
    public int a(m var1) throws IOException;

    public long a(s var1) throws IOException;

    public String a(Charset var1) throws IOException;

    public void a(long var1) throws IOException;

    public void a(byte[] var1) throws IOException;

    public long b(f var1) throws IOException;

    public c b();

    public boolean b(long var1) throws IOException;

    public boolean c() throws IOException;

    public boolean c(f var1) throws IOException;

    public f d(long var1) throws IOException;

    public byte e() throws IOException;

    public String f(long var1) throws IOException;

    public short f() throws IOException;

    public int g() throws IOException;

    public short h() throws IOException;

    public byte[] h(long var1) throws IOException;

    public int i() throws IOException;

    public void i(long var1) throws IOException;

    public long j() throws IOException;

    public long k() throws IOException;

    public String n() throws IOException;

    public long q() throws IOException;
}

