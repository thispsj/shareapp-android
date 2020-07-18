/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Bundle
 *  android.preference.Preference
 *  android.preference.Preference$OnPreferenceChangeListener
 *  android.preference.Preference$OnPreferenceClickListener
 *  android.preference.PreferenceCategory
 *  android.preference.PreferenceManager
 *  android.preference.SwitchPreference
 *  android.support.v7.widget.Toolbar
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.EditText
 *  android.widget.TextView
 *  android.widget.Toast
 *  com.xiaomi.miftp.view.AccountPreference
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package com.xiaomi.midrop;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.xiaomi.midrop.a;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.miftp.c.g;
import com.xiaomi.miftp.view.AccountPreference;
import com.xiaomi.miftp.view.MyEditTextPreference;
import com.xiaomi.miftp.view.RadioButtonPreference;
import java.util.Locale;

public class ServerControlPreference
extends a
implements Preference.OnPreferenceChangeListener,
Preference.OnPreferenceClickListener,
View.OnClickListener,
AccountPreference.a {
    private RadioButtonPreference b;
    private RadioButtonPreference c;
    private RadioButtonPreference d;
    private MyEditTextPreference e;
    private SwitchPreference f;
    private AccountPreference g;
    private SharedPreferences h;
    private b i;

    @Override
    public final void a() {
        this.f.setChecked(false);
    }

    public void onClick(View view) {
        if (view.getId() != 2131296485) {
            return;
        }
        this.onBackPressed();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void onCreate(Bundle bundle) {
        String string2;
        super.onCreate(bundle);
        this.i = b.a();
        this.addPreferencesFromResource(2131886082);
        LayoutInflater.from((Context)this).inflate(2131427429, (ViewGroup)this.a, true);
        View view = this.a.getRootView();
        ((TextView)view.findViewById(2131296810)).setText(this.i.a(2131689901));
        View view2 = view.findViewById(2131296485);
        view2.setOnClickListener((View.OnClickListener)this);
        if (ac.c((Context)this)) {
            view2.setRotation(180.0f);
        }
        this.h = PreferenceManager.getDefaultSharedPreferences((Context)this);
        this.b = (RadioButtonPreference)this.findPreference((CharSequence)"pref_charset_utf8");
        this.b.setOnPreferenceClickListener((Preference.OnPreferenceClickListener)this);
        this.c = (RadioButtonPreference)this.findPreference((CharSequence)"pref_charset_gbk");
        this.c.setOnPreferenceClickListener((Preference.OnPreferenceClickListener)this);
        this.d = (RadioButtonPreference)this.findPreference((CharSequence)"pref_charset_big5");
        this.d.setOnPreferenceClickListener((Preference.OnPreferenceClickListener)this);
        if (!b.a().a.getLanguage().equalsIgnoreCase("Zh")) {
            PreferenceCategory preferenceCategory = (PreferenceCategory)this.findPreference((CharSequence)"pref_charset");
            preferenceCategory.removePreference((Preference)this.c);
            preferenceCategory.removePreference((Preference)this.d);
            this.b.setChecked(true);
            this.h.edit().putString("pref_charset", "UTF-8").apply();
        }
        RadioButtonPreference radioButtonPreference = "UTF-8".equals((Object)(string2 = this.h.getString("pref_charset", org.a.ac.d))) ? this.b : ("big5".equals((Object)string2) ? this.d : this.c);
        radioButtonPreference.setChecked(true);
        this.e = (MyEditTextPreference)this.findPreference((CharSequence)"portNum");
        this.e.setOnPreferenceClickListener((Preference.OnPreferenceClickListener)this);
        this.e.setOnPreferenceChangeListener((Preference.OnPreferenceChangeListener)this);
        this.e.setSummary((CharSequence)this.h.getString("portNum", "2121"));
        this.f = (SwitchPreference)this.findPreference((CharSequence)"anonymous_login");
        this.f.setOnPreferenceChangeListener((Preference.OnPreferenceChangeListener)this);
        this.g = (AccountPreference)this.findPreference((CharSequence)"pref_ftp_account");
        this.g.a = this;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.finish();
        return true;
    }

    public boolean onPreferenceChange(Preference preference, Object object) {
        if (preference == this.e) {
            if (g.a(String.valueOf((Object)object))) {
                this.e.setSummary((CharSequence)String.valueOf((int)Integer.parseInt((String)object.toString())));
                return true;
            }
            Toast.makeText((Context)this, (CharSequence)this.i.b(2131689809), (int)0).show();
            return false;
        }
        if (preference == this.f) {
            if (!this.h.getBoolean("ar_fp_at_cf", false)) {
                this.h.edit().putBoolean("ar_fp_at_cf", true).apply();
            }
            if (!((Boolean)object).booleanValue()) {
                this.g.a();
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean onPreferenceClick(Preference preference) {
        SharedPreferences.Editor editor = this.h.edit();
        if (preference == this.b) {
            editor.putString("pref_charset", "UTF-8").apply();
            return true;
        }
        if (preference == this.c) {
            editor.putString("pref_charset", "GBK").apply();
            return true;
        }
        if (preference == this.d) {
            editor.putString("pref_charset", "big5").apply();
            return true;
        }
        if (preference == this.e) {
            this.e.getEditText().setText(this.e.getSummary());
            return true;
        }
        return false;
    }
}

