/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.midrop.home.a;

import com.google.a.a.c;
import com.xiaomi.midrop.home.a.a;

public final class b {
    @c(a="icon")
    private String a;
    @c(a="action")
    private a b;
    @c(a="title")
    private String c;
    @c(a="event")
    private String d;

    public final a a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("HomeScreenItem{icon = '");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(",action = '");
        stringBuilder.append((Object)this.b);
        stringBuilder.append('\'');
        stringBuilder.append(",title = '");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

