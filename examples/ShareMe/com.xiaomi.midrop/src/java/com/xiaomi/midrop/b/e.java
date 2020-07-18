/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.b;

public final class e {
    public String a;
    public String b;
    public boolean c;
    public String d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    private String i;

    public e(String string2, String string3, String string4) {
        this.a = string2;
        this.b = string3;
        this.i = string4;
    }

    public final boolean a() {
        return "mounted".equals((Object)this.i);
    }

    public final String b() {
        if (this.a == null) {
            return "";
        }
        return this.a;
    }

    public final String c() {
        if (this.b == null) {
            return "";
        }
        return this.b;
    }
}

