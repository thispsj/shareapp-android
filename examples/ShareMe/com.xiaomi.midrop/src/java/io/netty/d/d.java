/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.b.g
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.nio.charset.CharsetDecoder
 *  java.nio.charset.CharsetEncoder
 *  java.nio.charset.CodingErrorAction
 *  java.util.IdentityHashMap
 *  java.util.Map
 */
package io.netty.d;

import io.netty.d.b.g;
import io.netty.d.b.l;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.IdentityHashMap;
import java.util.Map;

public final class d {
    public static final Charset a = Charset.forName((String)"UTF-16");
    public static final Charset b = Charset.forName((String)"UTF-16BE");
    public static final Charset c = Charset.forName((String)"UTF-16LE");
    public static final Charset d = Charset.forName((String)"UTF-8");
    public static final Charset e = Charset.forName((String)"ISO-8859-1");
    public static final Charset f = Charset.forName((String)"US-ASCII");

    public static CharsetDecoder a(Charset charset, CodingErrorAction codingErrorAction, CodingErrorAction codingErrorAction2) {
        l.a(charset, "charset");
        CharsetDecoder charsetDecoder = charset.newDecoder();
        charsetDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction2);
        return charsetDecoder;
    }

    public static CharsetEncoder a(Charset charset) {
        CharsetEncoder charsetEncoder;
        l.a(charset, "charset");
        g g2 = g.b();
        Map map = g2.m;
        if (map == null) {
            g2.m = map = new IdentityHashMap();
        }
        if ((charsetEncoder = (CharsetEncoder)map.get((Object)charset)) != null) {
            charsetEncoder.reset().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
            return charsetEncoder;
        }
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CodingErrorAction codingErrorAction2 = CodingErrorAction.REPLACE;
        l.a(charset, "charset");
        CharsetEncoder charsetEncoder2 = charset.newEncoder();
        charsetEncoder2.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction2);
        map.put((Object)charset, (Object)charsetEncoder2);
        return charsetEncoder2;
    }

    public static CharsetDecoder b(Charset charset) {
        CharsetDecoder charsetDecoder;
        l.a(charset, "charset");
        g g2 = g.b();
        Map map = g2.n;
        if (map == null) {
            g2.n = map = new IdentityHashMap();
        }
        if ((charsetDecoder = (CharsetDecoder)map.get((Object)charset)) != null) {
            charsetDecoder.reset().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
            return charsetDecoder;
        }
        CharsetDecoder charsetDecoder2 = d.a(charset, CodingErrorAction.REPLACE, CodingErrorAction.REPLACE);
        map.put((Object)charset, (Object)charsetDecoder2);
        return charsetDecoder2;
    }
}

