/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.g
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.String
 */
package com.xiaomi.midrop.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.midrop.WebActivity;
import com.xiaomi.midrop.util.Locale.b;

public class ActivityErrorFragment
extends Fragment
implements View.OnClickListener {
    public void onClick(View view) {
        if (view.getId() != 2131296482) {
            return;
        }
        if (this.getActivity() instanceof WebActivity) {
            ((WebActivity)this.getActivity()).a();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2131427437, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(2131296568).setVisibility(8);
        view.findViewById(2131296482).setOnClickListener((View.OnClickListener)this);
        ((TextView)view.findViewById(2131296850)).setText((CharSequence)b.a().b(2131690036));
    }
}

