/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.preference.DialogPreference
 *  android.preference.PreferenceManager
 *  android.preference.PreferenceManager$OnActivityDestroyListener
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  com.xiaomi.miftp.view.dialog.c
 *  com.xiaomi.miftp.view.dialog.c$a
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 */
package com.xiaomi.miftp.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.miftp.view.dialog.c;
import com.xiaomi.miftp.view.dialog.d;
import java.lang.reflect.Method;

public class b
extends DialogPreference {
    private d.a a;
    private Dialog b;
    private int c;

    public b(Context context) {
        super(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public b(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    public b(Context context, AttributeSet attributeSet, int n2, int n3) {
        super(context, attributeSet, n2, n3);
    }

    public Dialog getDialog() {
        return this.b;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        this.c = n2;
    }

    protected View onCreateDialogView() {
        if (this.getDialogLayoutResource() == 0) {
            return null;
        }
        return LayoutInflater.from((Context)this.a.a.a).inflate(this.getDialogLayoutResource(), null);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        try {
            PreferenceManager preferenceManager = this.getPreferenceManager();
            PreferenceManager.class.getDeclaredMethod("unregisterOnActivityDestroyListener", new Class[]{PreferenceManager.OnActivityDestroyListener.class}).invoke((Object)preferenceManager, new Object[]{this});
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.b = null;
        int n2 = this.c;
        boolean bl = false;
        if (n2 == -1) {
            bl = true;
        }
        this.onDialogClosed(bl);
    }

    protected void showDialog(Bundle bundle) {
        Context context = this.getContext();
        this.c = -2;
        this.a = new d.a(context).a(this.getDialogTitle()).a(this.getDialogIcon()).a(this.getPositiveButtonText(), (DialogInterface.OnClickListener)this).b(this.getNegativeButtonText(), (DialogInterface.OnClickListener)this);
        View view = this.onCreateDialogView();
        if (view != null) {
            this.onBindDialogView(view);
            this.a.a(view);
        } else {
            this.a.b(this.getDialogMessage());
        }
        try {
            PreferenceManager preferenceManager = this.getPreferenceManager();
            PreferenceManager.class.getDeclaredMethod("registerOnActivityDestroyListener", new Class[]{PreferenceManager.OnActivityDestroyListener.class}).invoke((Object)preferenceManager, new Object[]{this});
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        d d2 = this.a.a();
        this.b = d2;
        if (bundle != null) {
            d2.onRestoreInstanceState(bundle);
        }
        d2.setOnDismissListener((DialogInterface.OnDismissListener)this);
        d2.show();
    }
}

