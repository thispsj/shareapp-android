/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.support.v7.app.c
 *  com.xiaomi.midrop.receiver.a$1
 *  com.xiaomi.midrop.receiver.a$2
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.c;
import b.e.c.b;
import com.xiaomi.midrop.receiver.a;
import com.xiaomi.midrop.receiver.b;

public final class a {
    Context a;
    c b;
    private b c;
    private b.e.c.b d;

    public a(Context context) {
        this.a = context;
    }

    static /* synthetic */ void a(a a2) {
        if (a2.b != null && a2.b.isShowing()) {
            a2.b.dismiss();
        }
    }

    public final void a() {
        if (this.c == null) {
            b b2 = this.c = new b(this.a, (b.a)new 1(this));
            if (!b2.a) {
                IntentFilter intentFilter = new IntentFilter("com.xiaomi.midrop.action.ENABLE_AP_BY_SETTING");
                intentFilter.addAction("miui.intent.action.SHOW_CONNECT_DIALOG");
                b2.b.registerReceiver((BroadcastReceiver)b2, intentFilter);
                b2.a = true;
            }
        }
        if (this.d == null) {
            this.d = new b.e.c.b(this.a, (b.a)new 2(this));
            this.d.a();
        }
    }

    public final void b() {
        b b2 = this.c;
        if (b2.a) {
            b2.b.unregisterReceiver((BroadcastReceiver)b2);
            b2.a = false;
        }
        this.d.b();
    }

}

