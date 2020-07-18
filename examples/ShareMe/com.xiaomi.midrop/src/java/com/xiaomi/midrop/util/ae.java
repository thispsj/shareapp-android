/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.bumptech.glide.e
 *  com.bumptech.glide.e.c
 *  com.bumptech.glide.e.g
 *  com.xiaomi.midrop.util.ae$1
 *  com.xiaomi.midrop.util.n
 *  com.xiaomi.midrop.util.o
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package com.xiaomi.midrop.util;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.e;
import com.bumptech.glide.e.c;
import com.bumptech.glide.e.g;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.util.ae;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.n;
import com.xiaomi.midrop.util.o;
import java.util.Locale;

public final class ae {
    public static void a(af.a a2, String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            ae.a(a2, false);
            return;
        }
        ((o)e.b((Context)MiDropApplication.a())).b(string2).d(true).c((g)new 1(a2)).b();
    }

    static void a(af.a a2, boolean bl) {
        af af2 = af.a(a2);
        af.b b2 = af.b.ae;
        String string2 = bl ? "Y" : "N";
        af2.a(b2, string2).a();
    }

    public static final class a {
        public static long a;
        public static long b;
        public static long c;
        public static long d;
        public static boolean e;

        public static String a(long l2) {
            if (e) {
                return "byQRCode";
            }
            long l3 = l2 / 1000L;
            if (l3 < 0L) {
                return "<0s";
            }
            if (l3 > 30L) {
                return ">30s";
            }
            Locale locale = Locale.getDefault();
            Object[] arrobject = new Object[]{l3};
            return String.format((Locale)locale, (String)"%ds", (Object[])arrobject);
        }
    }

}

