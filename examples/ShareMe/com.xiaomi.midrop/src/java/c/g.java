/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c;

import c.c;
import c.s;
import c.u;
import java.io.IOException;

public abstract class g
implements s {
    private final s a;

    public g(s s2) {
        if (s2 == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = s2;
    }

    @Override
    public final u a() {
        return this.a.a();
    }

    @Override
    public void a_(c c2, long l2) throws IOException {
        this.a.a_(c2, l2);
    }

    @Override
    public void close() throws IOException {
        this.a.close();
    }

    @Override
    public void flush() throws IOException {
        this.a.flush();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append("(");
        stringBuilder.append(this.a.toString());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

