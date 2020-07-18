/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.os.Bundle
 *  android.preference.PreferenceManager
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.EditText
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.miftp.view;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.xiaomi.miftp.R;
import com.xiaomi.miftp.c.g;
import com.xiaomi.miftp.view.AccountPreference;
import com.xiaomi.miftp.view.dialog.b;
import com.xiaomi.miftp.view.dialog.c;
import com.xiaomi.miftp.view.dialog.d;

public class AccountPreference
extends com.xiaomi.miftp.view.b {
    public a a;
    private EditText b;
    private EditText c;
    private String d;
    private String e;
    private boolean f = true;
    private SharedPreferences g;

    public AccountPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setDialogLayoutResource(R.layout.ftp_account);
        this.g = PreferenceManager.getDefaultSharedPreferences((Context)this.getContext());
        this.d = this.g.getString("username", "");
        this.e = this.g.getString("password", "");
    }

    static /* synthetic */ EditText a(AccountPreference accountPreference) {
        return accountPreference.b;
    }

    static /* synthetic */ String a(AccountPreference accountPreference, String string2) {
        accountPreference.d = string2;
        return string2;
    }

    static /* synthetic */ EditText b(AccountPreference accountPreference) {
        return accountPreference.c;
    }

    static /* synthetic */ String b(AccountPreference accountPreference, String string2) {
        accountPreference.e = string2;
        return string2;
    }

    static /* synthetic */ SharedPreferences c(AccountPreference accountPreference) {
        return accountPreference.g;
    }

    static /* synthetic */ String d(AccountPreference accountPreference) {
        return accountPreference.d;
    }

    static /* synthetic */ String e(AccountPreference accountPreference) {
        return accountPreference.e;
    }

    static /* synthetic */ a f(AccountPreference accountPreference) {
        return accountPreference.a;
    }

    public final void a() {
        this.f = false;
        boolean bl = g.b(this.g.getString("username", ""));
        boolean bl2 = false;
        if (bl) {
            boolean bl3 = g.b(this.g.getString("password", ""));
            bl2 = false;
            if (bl3) {
                bl2 = true;
            }
        }
        if (bl2) {
            this.a.a();
            return;
        }
        super.onClick();
    }

    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        this.b = (EditText)view.findViewById(R.id.username);
        this.b.setText((CharSequence)this.d);
        this.c = (EditText)view.findViewById(R.id.password);
        this.c.setText((CharSequence)this.e);
    }

    @Override
    protected void showDialog(Bundle bundle) {
        super.showDialog(bundle);
        this.b.requestFocus();
        ((d)this.getDialog()).a.a.u.setOnClickListener(new View.OnClickListener((AccountPreference)this){
            final /* synthetic */ AccountPreference a;
            {
                this.a = accountPreference;
            }

            public void onClick(View view) {
                String string2 = AccountPreference.a(this.a).getText().toString();
                String string3 = AccountPreference.b(this.a).getText().toString();
                if (g.b(string2) && g.b(string3)) {
                    AccountPreference.a(this.a, string2);
                    AccountPreference.b(this.a, string3);
                    android.content.SharedPreferences$Editor editor = AccountPreference.c(this.a).edit();
                    editor.putString("username", AccountPreference.d(this.a));
                    editor.putString("password", AccountPreference.e(this.a));
                    editor.apply();
                    AccountPreference.f(this.a).a();
                    this.a.getDialog().dismiss();
                    return;
                }
                android.widget.Toast.makeText((Context)this.a.getContext(), (int)com.xiaomi.miftp.R$string.ftp_invalid_username_or_password, (int)0).show();
            }
        });
    }

}

