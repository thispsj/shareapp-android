/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.b.a.i
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.b.a;

import com.b.a.g;
import com.b.a.h;
import com.b.a.i;
import java.io.File;

public final class a {
    public String a;
    public String b;
    public int c;
    int d;
    public g e;

    public a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(h.a);
        stringBuilder.append(File.separator);
        stringBuilder.append("download");
        this.a = stringBuilder.toString();
        this.c = 2;
        this.d = 2;
        this.e = new i();
    }

    /* synthetic */ a(byte by) {
    }

    public static final class a {
        public a a = new a(0);
    }

}

