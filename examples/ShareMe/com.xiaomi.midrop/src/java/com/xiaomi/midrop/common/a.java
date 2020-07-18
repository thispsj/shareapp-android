/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Message
 *  com.xiaomi.midrop.common.a$1
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 */
package com.xiaomi.midrop.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.xiaomi.globalmiuiapp.common.f.f;
import com.xiaomi.midrop.common.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class a {
    public static f<a> a = new 1();
    private ArrayList<WeakReference<Dialog>> b;
    private a c;

    private a() {
        this.b = new ArrayList();
        this.c = new a(0);
    }

    /* synthetic */ a(byte by) {
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a() {
        Dialog dialog;
        do {
            Activity activity;
            if (this.b.isEmpty()) {
                return;
            }
            WeakReference weakReference = (WeakReference)this.b.get(0);
            dialog = (Dialog)weakReference.get();
            if (dialog != null && (!(dialog.getContext() instanceof Activity) || !(activity = (Activity)dialog.getContext()).isFinishing() && !activity.isDestroyed())) break;
            this.b.remove((Object)weakReference);
        } while (true);
        dialog.show();
    }

    static /* synthetic */ void a(a a2) {
        if (!a2.b.isEmpty()) {
            a2.b.remove(0);
        }
    }

    public final void a(Dialog dialog) {
        dialog.setDismissMessage(this.c.obtainMessage(0, (Object)this));
        this.b.add((Object)new WeakReference((Object)dialog));
        if (this.b.size() == 1) {
            a.super.a();
        }
    }

    private static final class a
    extends Handler {
        private a() {
        }

        /* synthetic */ a(byte by) {
        }

        public final void handleMessage(Message message) {
            a a2 = (a)message.obj;
            a.a(a2);
            a2.a();
        }
    }

}

