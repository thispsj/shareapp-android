/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.os.Handler
 *  android.support.v4.widget.ContentLoadingProgressBar
 *  android.support.v7.app.c
 *  android.view.KeyEvent
 *  android.view.View
 *  android.widget.TextView
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.transmission.upgrade.util;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.midrop.transmission.upgrade.a;
import com.xiaomi.midrop.util.af;

public final class c {
    public a a;
    private Handler b;

    public c(Handler handler) {
        this.b = handler;
    }

    public static final class a {
        public android.support.v7.app.c a;
        private View b;
        private TextView c;
        private TextView d;
        private ContentLoadingProgressBar e;

        public a(View view) {
            this.b = view;
            this.c = (TextView)this.b.findViewById(2131296810);
            this.d = (TextView)this.b.findViewById(2131296608);
            this.e = (ContentLoadingProgressBar)this.b.findViewById(2131296654);
        }

        public final void a(a.b b2) {
            if (this.a == null) {
                return;
            }
            this.a.getContext();
            switch (3.a[b2.ordinal()]) {
                default: {
                    return;
                }
                case 2: {
                    this.e.a();
                }
                case 3: {
                    this.a.dismiss();
                    return;
                }
                case 1: 
            }
            this.e.b();
        }
    }

}

