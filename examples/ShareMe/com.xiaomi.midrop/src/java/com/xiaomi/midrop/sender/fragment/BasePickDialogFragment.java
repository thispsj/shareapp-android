/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.support.v4.app.DialogFragment
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.Window
 *  java.lang.Class
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.sender.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.Window;
import com.xiaomi.midrop.sender.c.g;
import com.xiaomi.midrop.sender.fragment.BasePickDialogFragment;
import com.xiaomi.midrop.util.ac;
import java.util.List;

public abstract class BasePickDialogFragment
extends DialogFragment
implements g.a {
    protected final String a = this.getClass().getCanonicalName();

    @Override
    public void a(String string2, List<com.xiaomi.midrop.b.g> list) {
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = super.onCreateDialog(bundle);
        if (dialog != null && dialog.getWindow() != null) {
            Window window = dialog.getWindow();
            window.requestFeature(1);
            int n2 = (int)((float)ac.b((Context)this.getContext()).x - 2.0f * this.getResources().getDimension(2131165457));
            window.setBackgroundDrawable(this.getResources().getDrawable(2131230993));
            window.setLayout(n2, -2);
        }
        return dialog;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setOnTouchListener(new View.OnTouchListener((BasePickDialogFragment)this){
            final /* synthetic */ BasePickDialogFragment a;
            {
                this.a = basePickDialogFragment;
            }

            public final boolean onTouch(View view, android.view.MotionEvent motionEvent) {
                return true;
            }
        });
    }
}

