/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 */
package com.xiaomi.midrop.util.Locale;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.xiaomi.midrop.util.Locale.c;
import java.util.Locale;

public final class b {
    private static b c;
    public Locale a = null;
    public Context b = null;

    private b(Context context) {
        this.b = context;
    }

    static /* synthetic */ Context a(b b2) {
        return b2.b;
    }

    public static b a() {
        return c;
    }

    public static void a(Context context) {
        if (c == null) {
            b b2;
            c = b2 = new b(context);
            b2.c();
        }
    }

    public final CharSequence a(int n2) {
        return this.b.getResources().getText(n2);
    }

    public final /* varargs */ String a(int n2, int n3, Object ... arrobject) {
        return this.b.getResources().getQuantityString(n2, n3, arrobject);
    }

    public final /* varargs */ String a(int n2, Object ... arrobject) {
        return this.b.getResources().getString(n2, arrobject);
    }

    public final Context b(Context context) {
        new StringBuilder("getUserSelLangContext(): ").append(this.a.getLanguage());
        if (context != null && context.getResources() != null) {
            Configuration configuration = new Configuration(context.getResources().getConfiguration());
            configuration.setLocale(this.a);
            return context.createConfigurationContext(configuration);
        }
        return this.b;
    }

    public final String b(int n2) {
        return this.b.getResources().getString(n2);
    }

    public final Locale b() {
        return this.a;
    }

    public final void c() {
        Context context = this.b;
        SharedPreferences sharedPreferences = context.getSharedPreferences("LocaleModel", 4);
        String string2 = sharedPreferences.getString("SHARE_KEY_USER_SEL_LANG", "");
        String string3 = sharedPreferences.getString("SHARE_KEY_USER_SEL_COUNTRY", "");
        Locale locale = c.a();
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            if (c.a(context, locale)) {
                c.a(context, c.a.a);
            } else {
                locale = new Locale(string2, string3);
            }
        }
        this.a = locale;
        Locale.setDefault((Locale)this.a);
        new StringBuilder("updateLocate - ").append(this.a.getDisplayLanguage());
        this.b = this.b(this.b);
    }

    public static interface a {
        public void a();
    }

}

