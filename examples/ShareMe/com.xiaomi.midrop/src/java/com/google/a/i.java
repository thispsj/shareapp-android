/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.n
 *  java.io.IOException
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 */
package com.google.a;

import com.google.a.b.k;
import com.google.a.d.c;
import com.google.a.n;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class i {
    public Number a() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public String b() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public double c() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public long d() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public int e() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public boolean f() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public final n g() {
        if (this instanceof n) {
            return (n)this;
        }
        StringBuilder stringBuilder = new StringBuilder("Not a JSON Primitive: ");
        stringBuilder.append((Object)this);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            c c2 = new c((Writer)stringWriter);
            c2.e = true;
            k.a(this, c2);
            String string2 = stringWriter.toString();
            return string2;
        }
        catch (IOException iOException) {
            throw new AssertionError((Object)iOException);
        }
    }
}

