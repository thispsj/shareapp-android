/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.g
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 */
package com.xiaomi.midrop.feedback;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.midrop.WebActivity;
import com.xiaomi.midrop.feedback.a;

public class FeedBackErrorFragment
extends Fragment
implements View.OnClickListener {
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onClick(View view) {
        int n2 = view.getId();
        if (n2 != 2131296482) {
            if (n2 != 2131296568) {
                return;
            }
            a.a((Context)this.getActivity());
            return;
        }
        if (this.getActivity() instanceof WebActivity) {
            ((WebActivity)this.getActivity()).a();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2131427437, viewGroup, false);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.getArguments() != null) {
            bundle.putAll(this.getArguments());
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(2131296568).setOnClickListener((View.OnClickListener)this);
        view.findViewById(2131296482).setOnClickListener((View.OnClickListener)this);
    }
}

