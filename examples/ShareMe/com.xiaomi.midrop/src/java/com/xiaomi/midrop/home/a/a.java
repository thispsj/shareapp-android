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

public final class a {
    @c(a="launch_action1")
    private String a;
    @c(a="package")
    private String b;
    @c(a="activity")
    private String c;
    @c(a="launch_action2")
    private String d;
    @c(a="uri")
    private String e;

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Action{launch_action1 = '");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(",package = '");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(",activity = '");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(",launch_action2 = '");
        stringBuilder.append(this.d);
        stringBuilder.append('\'');
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

