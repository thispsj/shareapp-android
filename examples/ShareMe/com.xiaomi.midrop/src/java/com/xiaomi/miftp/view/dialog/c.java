/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnShowListener
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.os.Message
 *  android.view.View
 *  android.view.Window
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.xiaomi.miftp.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.xiaomi.miftp.view.dialog.a;
import com.xiaomi.miftp.view.dialog.b;
import java.util.ArrayList;

public final class c
extends com.xiaomi.miftp.view.dialog.a {
    public b a;

    public c(Context context, DialogInterface dialogInterface, Window window) {
        this.a = new b(context, dialogInterface, window);
    }

    @Override
    public final void a(int n2) {
        b b2 = this.a;
        b2.i = n2;
        b2.h = null;
    }

    @Override
    public final void a(int n2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        b b2 = this.a;
        Message message = onClickListener != null ? b2.D.obtainMessage(n2, (Object)onClickListener) : null;
        switch (n2) {
            default: {
                throw new IllegalStateException("Button does not exist");
            }
            case -1: {
                b2.v = charSequence;
                b2.w = message;
                return;
            }
            case -2: {
                b2.y = charSequence;
                b2.z = message;
                return;
            }
            case -3: 
        }
        b2.B = charSequence;
        b2.C = message;
    }

    @Override
    public final void a(Drawable drawable2) {
        b b2 = this.a;
        b2.h = drawable2;
        b2.i = 0;
    }

    @Override
    public final void a(View view) {
        this.a.o = view;
    }

    @Override
    public final void a(CharSequence charSequence) {
        b b2 = this.a;
        b2.j = charSequence;
        if (b2.m != null) {
            b2.m.setText(charSequence);
        }
    }

    @Override
    public final void b(View view) {
        this.a.p = view;
    }

    @Override
    public final void b(CharSequence charSequence) {
        b b2 = this.a;
        b2.k = charSequence;
        if (b2.n != null) {
            b2.n.setText(charSequence);
        }
    }

    public static final class a
    extends a.a {
        public DialogInterface.OnClickListener D;
        public DialogInterface.OnDismissListener E;
        public DialogInterface.OnShowListener F;
        public ArrayList<Object> G;
        public boolean H;
        public boolean I;
        public CharSequence J;

        public a(Context context) {
            super(context);
        }
    }

}

