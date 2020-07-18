/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.j
 *  com.google.a.k
 *  com.google.a.p
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Throwable
 */
package com.google.a.b;

import com.google.a.b.a.n;
import com.google.a.d.a;
import com.google.a.d.b;
import com.google.a.d.c;
import com.google.a.d.d;
import com.google.a.i;
import com.google.a.j;
import com.google.a.m;
import com.google.a.p;
import com.google.a.r;
import java.io.EOFException;
import java.io.IOException;

public final class k {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static i a(a a2) throws m {
        boolean bl;
        try {
            try {
                a2.f();
            }
            catch (EOFException eOFException) {
                bl = true;
            }
            try {
                return n.X.a(a2);
            }
            catch (EOFException eOFException) {
                bl = false;
            }
        }
        catch (NumberFormatException numberFormatException) {
            throw new p((Throwable)numberFormatException);
        }
        catch (IOException iOException) {
            throw new j((Throwable)iOException);
        }
        catch (d d2) {
            throw new p((Throwable)((Object)d2));
        }
        if (!bl) void var1_4;
        throw new p((Throwable)var1_4);
        return com.google.a.k.a;
    }

    public static void a(i i2, c c2) throws IOException {
        n.X.a(c2, i2);
    }
}

