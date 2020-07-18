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
 *  android.preference.EditTextPreference
 *  android.preference.PreferenceManager
 *  android.preference.PreferenceManager$OnActivityDestroyListener
 *  android.text.Editable
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.widget.EditText
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
import android.preference.EditTextPreference;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import com.xiaomi.miftp.R;
import com.xiaomi.miftp.view.dialog.c;
import com.xiaomi.miftp.view.dialog.d;
import java.lang.reflect.Method;

public class MyEditTextPreference
extends EditTextPreference {
    private d.a a;
    private Dialog b;
    private int c;
    private EditText d;

    public MyEditTextPreference(Context context) {
        super(context);
        this.setDialogLayoutResource(R.layout.textinput_dialog);
    }

    public MyEditTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setDialogLayoutResource(R.layout.textinput_dialog);
    }

    public MyEditTextPreference(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.setDialogLayoutResource(R.layout.textinput_dialog);
    }

    public Dialog getDialog() {
        return this.b;
    }

    public EditText getEditText() {
        if (this.d != null) {
            return this.d;
        }
        return super.getEditText();
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        this.c = n2;
    }

    protected View onCreateDialogView() {
        if (this.getDialogLayoutResource() == 0) {
            return null;
        }
        View view = LayoutInflater.from((Context)this.a.a.a).inflate(this.getDialogLayoutResource(), null);
        this.d = (EditText)view.findViewById(R.id.text);
        this.d.setInputType(2);
        this.d.setSelectAllOnFocus(true);
        return view;
    }

    protected void onDialogClosed(boolean bl) {
        String string2;
        if (bl && this.callChangeListener((Object)(string2 = this.getEditText().getText().toString()))) {
            this.setText(string2);
        }
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
        if (d2.getWindow() != null) {
            d2.getWindow().setSoftInputMode(5);
        }
        d2.setOnDismissListener((DialogInterface.OnDismissListener)this);
        d2.show();
    }
}

