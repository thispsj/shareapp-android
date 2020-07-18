/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  midrop.service.c.e
 */
package com.xiaomi.midrop.home;

import android.text.TextUtils;
import midrop.service.c.e;

public final class d {
    public CharSequence a;
    public String b;
    public boolean c;
    public a d;
    public String e;
    public boolean f;
    public int g;

    public d(CharSequence charSequence, String string2, int n, a a2) {
        super(charSequence, string2, "", false, n, a2);
    }

    public d(CharSequence charSequence, String string2, int n, a a2, byte by) {
        this(charSequence, string2, n, a2);
    }

    public d(CharSequence charSequence, String string2, String string3, boolean bl, int n, a a2) {
        this.a = charSequence;
        this.b = string2;
        this.c = false;
        this.d = a2;
        this.e = string3;
        this.f = bl;
        this.g = n;
    }

    public d(CharSequence charSequence, String string2, boolean bl, int n, a a2) {
        this(charSequence, string2, "", bl, n, a2);
    }

    public final boolean a() {
        if (!TextUtils.isEmpty((CharSequence)this.e)) {
            return e.b((String)this.e, (boolean)true);
        }
        return false;
    }

    public final void onClick() {
        if (this.d != null) {
            this.d.onClick();
        }
    }

    public static interface a {
        public void onClick();
    }

}

