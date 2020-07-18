/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.preference.PreferenceManager
 *  android.view.View
 *  android.widget.CheckBox
 *  java.lang.Object
 */
package com.xiaomi.midrop;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;

public final class b {
    Context a;
    a b;
    CheckBox c;
    CheckBox d;
    CheckBox e;
    View f;

    public b(Context context) {
        this.a = context;
    }

    static /* synthetic */ void a(b b2, int n) {
        if (b2.c != null) {
            if (b2.d == null) {
                return;
            }
            CheckBox checkBox = b2.c;
            boolean bl = n == 0;
            checkBox.setChecked(bl);
            CheckBox checkBox2 = b2.d;
            boolean bl2 = false;
            if (n == 1) {
                bl2 = true;
            }
            checkBox2.setChecked(bl2);
            b2.f.setEnabled(true);
        }
    }

    final SharedPreferences a() {
        if (this.a == null) {
            return null;
        }
        return PreferenceManager.getDefaultSharedPreferences((Context)this.a);
    }

    public static interface a {
        public void a(boolean var1);
    }

}

