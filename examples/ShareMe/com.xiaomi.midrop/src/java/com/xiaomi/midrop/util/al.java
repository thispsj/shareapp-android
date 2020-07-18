/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.String
 */
package com.xiaomi.midrop.util;

import android.text.TextUtils;
import com.xiaomi.midrop.util.g;
import com.xiaomi.midrop.util.j;
import com.xiaomi.midrop.util.p;
import java.io.File;

public final class al
extends p {
    private String a;
    private boolean b;

    public al(String string2, boolean bl) {
        this.a = string2;
        this.b = bl;
    }

    @Override
    public final boolean accept(File file, String string2) {
        if (TextUtils.equals((CharSequence)file.getPath(), (CharSequence)this.a)) {
            String string3 = j.d(string2);
            if (g.c(string3)) {
                return false;
            }
            if (g.b(string3)) {
                return false;
            }
            if (g.a(string3)) {
                return false;
            }
            if (g.d(string3)) {
                return false;
            }
        }
        if (this.b) {
            return true;
        }
        return super.accept(file, string2);
    }
}

