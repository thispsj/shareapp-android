/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.os.Bundle
 *  android.support.v7.app.AlertController
 *  android.support.v7.app.AlertController$a
 *  android.support.v7.app.c
 *  android.support.v7.app.c$a
 *  java.lang.CharSequence
 *  java.lang.String
 */
package com.xiaomi.midrop.receiver.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertController;
import android.support.v7.app.c;
import com.xiaomi.midrop.receiver.ui.ReceiverInProgressDialog;
import com.xiaomi.midrop.util.Locale.a;

public class ReceiverInProgressDialog
extends a {
    private static final String a = "ReceiverInProgressDialog";

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.showDialog(1);
    }

    protected Dialog onCreateDialog(int n2) {
        if (n2 != 1) {
            return null;
        }
        c.a a2 = new c.a((Context)this);
        a2.a.f = a2.a.a.getText(2131689833);
        a2.a.h = a2.a.a.getText(2131689832);
        a2.a.i = a2.a.a.getText(2131689718);
        a2.a.k = null;
        c c2 = a2.a();
        c2.setOnDismissListener(new DialogInterface.OnDismissListener((ReceiverInProgressDialog)this){
            final /* synthetic */ ReceiverInProgressDialog a;
            {
                this.a = receiverInProgressDialog;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.a.finish();
            }
        });
        return c2;
    }
}

