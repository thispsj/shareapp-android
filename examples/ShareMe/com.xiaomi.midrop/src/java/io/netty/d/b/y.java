/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.b.g
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ThreadLocal
 *  java.nio.charset.Charset
 *  java.nio.charset.CharsetDecoder
 *  java.nio.charset.CharsetEncoder
 *  java.util.ArrayList
 *  java.util.Map
 *  java.util.concurrent.atomic.AtomicInteger
 */
package io.netty.d.b;

import io.netty.d.b.f;
import io.netty.d.b.g;
import io.netty.d.b.v;
import io.netty.d.b.x;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class y {
    static final ThreadLocal<g> b = new ThreadLocal();
    static final AtomicInteger c = new AtomicInteger();
    public Object[] d;
    public int e;
    public int f;
    public Map<Class<?>, Boolean> g;
    public f h;
    public v i;
    public Map<Class<?>, x> j;
    public Map<Class<?>, Map<String, x>> k;
    public StringBuilder l;
    public Map<Charset, CharsetEncoder> m;
    public Map<Charset, CharsetDecoder> n;
    public ArrayList<Object> o;

    y(Object[] arrobject) {
        this.d = arrobject;
    }
}

