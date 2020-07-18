/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.support.design.widget.BottomSheetDialogFragment
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.g
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.widget.ImageView
 *  android.widget.TextView
 *  java.lang.String
 */
package com.xiaomi.midrop.receiver.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.am;

public class QRAutoScanDialogFragment
extends BottomSheetDialogFragment
implements View.OnClickListener {
    private boolean a = false;

    public void onActivityResult(int n2, int n3, Intent intent) {
        Fragment fragment = this.getParentFragment();
        if (fragment != null) {
            fragment.onActivityResult(n2, n3, intent);
        }
        this.dismiss();
    }

    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int n2 = view.getId();
        if (n2 != 2131296385) {
            if (n2 != 2131296476) {
                return;
            }
            this.dismiss();
            return;
        }
        this.a = true;
        af.a(af.a.dS).a(af.b.ay, "scan_qr_code_popup_click").a();
        am.a((Fragment)this, "Scan_popup_page");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = this.getDialog();
        if (dialog != null) {
            dialog.getWindow().addFlags(134217728);
            if (Build.VERSION.SDK_INT > 28) {
                am.a(dialog.getWindow());
            }
        }
        View view = layoutInflater.inflate(2131427395, viewGroup);
        TextView textView = (TextView)view.findViewById(2131296385);
        am.a((Context)this.getActivity(), textView, 2131231264);
        return view;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (!this.a) {
            af.a(af.a.dS).a(af.b.ay, "QR_code_popup_close").a();
        }
    }

    public void onStart() {
        super.onStart();
        this.a = false;
        af.a(af.a.dS).a(af.b.ay, "QR_code_popup_appear").a();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (view == null) {
            return;
        }
        ((TextView)view.findViewById(2131296385)).setOnClickListener((View.OnClickListener)this);
        ((ImageView)view.findViewById(2131296476)).setOnClickListener((View.OnClickListener)this);
    }
}

