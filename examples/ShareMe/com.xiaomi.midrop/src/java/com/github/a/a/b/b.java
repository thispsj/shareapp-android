/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.List
 */
package com.github.a.a.b;

import com.github.a.a.b.a;
import java.util.Collections;
import java.util.List;

public final class b {
    public final List<String> a;
    public final a b = new a();
    public int c = 1;
    public boolean d = false;

    b(List<String> list) {
        this.a = Collections.unmodifiableList(list);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Context [parentComponents=");
        stringBuilder.append(this.a);
        stringBuilder.append(", unfoldedLine=");
        stringBuilder.append(this.b.a.toString());
        stringBuilder.append(", lineNumber=");
        stringBuilder.append(this.c);
        stringBuilder.append(", stop=");
        stringBuilder.append(this.d);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

