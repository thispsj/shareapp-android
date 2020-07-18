/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.nio.charset.Charset
 *  java.nio.charset.IllegalCharsetNameException
 *  java.nio.charset.UnsupportedCharsetException
 *  java.util.ArrayList
 *  java.util.List
 */
package com.github.a.a.b;

import com.github.a.a.b.b;
import com.github.a.a.b.c;
import com.github.a.a.b.d;
import com.github.a.a.b.g;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.List;

public final class f
implements Closeable {
    public final String a = System.getProperty((String)"line.separator");
    public final Reader b;
    public final c c;
    public boolean d = true;
    public Charset e;
    public final a f;
    public final com.github.a.a.b.a g = new com.github.a.a.b.a();
    public final b h;
    public int i = -1;
    public int j = 1;
    public boolean k = false;

    /*
     * Enabled aggressive block sorting
     */
    public f(Reader reader, c c2) {
        this.b = reader;
        this.c = c2;
        this.f = new a(c2.a);
        this.h = new b(this.f.a);
        Charset charset = reader instanceof InputStreamReader ? Charset.forName((String)((InputStreamReader)reader).getEncoding()) : Charset.defaultCharset();
        this.e = charset;
    }

    public static boolean a(char c2) {
        return c2 == '\n' || c2 == '\r';
        {
        }
    }

    public static boolean b(char c2) {
        return c2 == ' ' || c2 == '\t';
        {
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final Charset a(com.github.a.a.c c2, d d2) {
        String string2;
        List<String> list = c2.c.a(com.github.a.a.b.b("CHARSET"));
        if (list == null) return null;
        try {
            if (list.isEmpty()) return null;
            string2 = (String)list.get(0);
        }
        catch (IllegalCharsetNameException | UnsupportedCharsetException throwable) {
            d2.a(g.f, c2, this.h);
            return null;
        }
        if (string2 != null) return Charset.forName(string2);
        return null;
    }

    public final void close() throws IOException {
        this.b.close();
    }

    private static final class a {
        public final List<String> a = new ArrayList();
        public final List<com.github.a.a.a> b = new ArrayList();

        public a(com.github.a.a.a a2) {
            this.b.add((Object)a2);
        }

        public final com.github.a.a.a a() {
            if (this.b.isEmpty()) {
                return null;
            }
            return (com.github.a.a.a)((Object)this.b.get(-1 + this.b.size()));
        }
    }

}

