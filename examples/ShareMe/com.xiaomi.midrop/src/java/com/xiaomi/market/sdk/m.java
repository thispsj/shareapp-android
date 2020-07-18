/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.market.sdk;

public final class m
extends Enum<m> {
    public static final /* enum */ m a = new m("https://api.developer.xiaomi.com/autoupdate/", "https://global.developer.xiaomi.com/autoupdate/");
    public static final /* enum */ m b = new m("http://staging.api.developer.appstore.pt.xiaomi.com/autoupdate/", "http://global.staging.developer.appstore.pt.xiaomi.com/autoupdate/");
    public static final /* enum */ m c = new m("http://preview.api.developer.appstore.pt.xiaomi.com/autoupdate/", "http://global.preview.developer.appstore.pt.xiaomi.com/autoupdate/");
    private static final /* synthetic */ m[] f;
    String d;
    String e;

    static {
        m[] arrm = new m[]{a, b, c};
        f = arrm;
    }

    private m(String string3, String string4) {
        this.d = string3;
        this.e = string4;
    }

    public static m valueOf(String string2) {
        return (m)Enum.valueOf(m.class, (String)string2);
    }

    public static m[] values() {
        return (m[])f.clone();
    }
}

