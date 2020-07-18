/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.preference.Preference
 *  android.preference.Preference$OnPreferenceChangeListener
 *  android.preference.Preference$OnPreferenceClickListener
 *  android.preference.PreferenceCategory
 *  android.util.AttributeSet
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.miftp.view;

import android.content.Context;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.util.AttributeSet;
import com.xiaomi.miftp.view.RadioButtonPreference;

public class RadioButtonPreferenceCategory
extends PreferenceCategory
implements Preference.OnPreferenceChangeListener {
    private RadioButtonPreference a;
    private int b;

    public RadioButtonPreferenceCategory(Context context) {
        super(context, null);
    }

    public RadioButtonPreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1;
    }

    public RadioButtonPreferenceCategory(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.b = -1;
    }

    public boolean addPreference(Preference preference) {
        if (!(preference instanceof RadioButtonPreference)) {
            throw new IllegalArgumentException("Only RadioButtonPreference can be added toRadioButtonPreferenceCategory");
        }
        boolean bl = super.addPreference(preference);
        if (bl) {
            preference.setOnPreferenceChangeListener((Preference.OnPreferenceChangeListener)this);
        }
        return bl;
    }

    public boolean onPreferenceChange(Preference preference, Object object) {
        Preference.OnPreferenceClickListener onPreferenceClickListener;
        if (preference != this.a) {
            int n2 = this.getPreferenceCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                RadioButtonPreference radioButtonPreference = (RadioButtonPreference)this.getPreference(i2);
                if (radioButtonPreference == preference) {
                    this.a = radioButtonPreference;
                    this.b = i2;
                    radioButtonPreference.setChecked(true);
                    continue;
                }
                radioButtonPreference.setChecked(false);
            }
        }
        if ((onPreferenceClickListener = this.getOnPreferenceClickListener()) != null) {
            onPreferenceClickListener.onPreferenceClick((Preference)this);
        }
        return false;
    }
}

