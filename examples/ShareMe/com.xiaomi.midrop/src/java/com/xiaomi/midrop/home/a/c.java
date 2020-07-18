/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package com.xiaomi.midrop.home.a;

import com.xiaomi.midrop.home.a.b;
import java.util.List;

public class c {
    @com.google.a.a.c(a="home_screen")
    private List<b> a;

    public final List<b> a() {
        return this.a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Response{home_screen = '");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

