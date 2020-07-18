/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.Object
 */
package com.xiaomi.midrop.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class b
extends BroadcastReceiver {
    boolean a;
    Context b;
    private a c;

    public b(Context context, a a2) {
        this.b = context;
        this.c = a2;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.c != null) {
            this.c.a(intent);
        }
    }

    public static interface a {
        public void a(Intent var1);
    }

}

