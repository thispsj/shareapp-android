/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.SharedPreferences
 *  android.preference.PreferenceManager
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.EditText
 *  com.xiaomi.miftp.view.FTPAccountDialogHelper
 *  java.lang.Object
 */
package com.xiaomi.miftp.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import com.xiaomi.miftp.view.FTPAccountDialogHelper;

public final class a {
    public Context a;
    public a b;
    public Dialog c;
    public EditText d;
    public EditText e;
    public View.OnClickListener f;

    public a(Context context) {
        this.f = new View.OnClickListener((a)this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public void onClick(View view) {
                if (this.a.d != null && this.a.e != null) {
                    if (this.a.c == null) {
                        return;
                    }
                    java.lang.String string2 = this.a.d.getText().toString();
                    java.lang.String string3 = this.a.e.getText().toString();
                    if (com.xiaomi.miftp.c.g.b(string2) && com.xiaomi.miftp.c.g.b(string3)) {
                        SharedPreferences sharedPreferences = this.a.a();
                        if (sharedPreferences == null) {
                            return;
                        }
                        android.content.SharedPreferences$Editor editor = sharedPreferences.edit();
                        editor.putString("username", string2);
                        editor.putString("password", string3);
                        editor.apply();
                        if (this.a.c != null) {
                            this.a.c.dismiss();
                        }
                        if (this.a.b != null) {
                            this.a.b.a();
                        }
                        return;
                    }
                    android.widget.Toast.makeText((Context)this.a.a, (int)com.xiaomi.miftp.R$string.ftp_invalid_username_or_password, (int)0).show();
                }
            }
        };
        this.a = context;
    }

    public final SharedPreferences a() {
        if (this.a == null) {
            return null;
        }
        return PreferenceManager.getDefaultSharedPreferences((Context)this.a);
    }

    public static interface a {
        public void a();
    }

}

