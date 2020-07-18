/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.market.sdk;

import com.xiaomi.market.sdk.c;
import com.xiaomi.market.sdk.m;

public final class f {
    public static volatile String a;
    public static String b;
    private static volatile boolean c;
    private static volatile m d;

    static {
        c = c.n();
        d = m.a;
    }

    public static void a() {
        c = true;
        f.b();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void b() {
        String string2 = c ? f.d.e : f.d.d;
        a = string2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("updateself");
        b = stringBuilder.toString();
    }

    public static final class a {
        public static final String[] a = new String[]{"update_download.package_name", "update_download.download_id", "update_download.version_code", "update_download.apk_url", "update_download.apk_hash", "update_download.diff_url", "update_download.diff_hash", "update_download.apk_path"};
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b a = new b();
        public static final /* enum */ b b = new b();
        private static final /* synthetic */ b[] c;

        static {
            b[] arrb = new b[]{a, b};
            c = arrb;
        }

        public static b valueOf(String string2) {
            return (b)Enum.valueOf(b.class, (String)string2);
        }

        public static b[] values() {
            return (b[])c.clone();
        }
    }

}

