/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.b.a.f
 *  com.google.a.j
 *  com.google.a.r$1
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 */
package com.google.a;

import com.google.a.b.a.f;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.i;
import com.google.a.j;
import com.google.a.r;
import java.io.IOException;
import java.util.List;

public abstract class r<T> {
    public final i a(T t2) {
        try {
            f f2 = new f();
            this.a((c)f2, t2);
            if (!f2.a.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder("Expected one JSON element but was ");
                stringBuilder.append((Object)f2.a);
                throw new IllegalStateException(stringBuilder.toString());
            }
            i i2 = f2.b;
            return i2;
        }
        catch (IOException iOException) {
            throw new j((Throwable)iOException);
        }
    }

    public final r<T> a() {
        return new 1(this);
    }

    public abstract T a(a var1) throws IOException;

    public abstract void a(c var1, T var2) throws IOException;
}

