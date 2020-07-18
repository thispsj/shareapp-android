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
import c.t;
import c.u;
import java.io.IOException;

public abstract class h
implements t {
    protected final t d;

    public h(t t2) {
        if (t2 == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.d = t2;
    }

    @Override
    public long a(c c2, long l2) throws IOException {
        return this.d.a(c2, l2);
    }

    @Override
    public final u a() {
        return this.d.a();
    }

    @Override
    public void close() throws IOException {
        this.d.close();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append("(");
        stringBuilder.append(this.d.toString());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

