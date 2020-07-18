/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.NotificationManager
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.text.TextUtils
 *  com.xiaomi.midrop.util.ac
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  midrop.c.d.a
 *  midrop.c.f.a
 *  midrop.service.c.d
 */
package com.xiaomi.midrop.receiver.a;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.xiaomi.midrop.d;
import com.xiaomi.midrop.receiver.service.ReceiverService;
import com.xiaomi.midrop.util.ac;

public final class a {
    public Context a;
    public d b;
    public BroadcastReceiver c;
    public boolean d;
    public Class e;

    public a(Context context, Class class_) {
        this.a = context;
        this.e = class_;
        this.b = new d(context);
    }

    /*
     * Enabled aggressive block sorting
     */
    private String a(String string2, midrop.c.d.a a2) {
        StringBuilder stringBuilder;
        Object[] arrobject = new Object[]{Float.valueOf((float)((float)(a2.d() / 1024L) / 1024.0f))};
        String string3 = String.format((String)"%.2f", (Object[])arrobject);
        if (ac.c((Context)this.a)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(" - ");
            stringBuilder.append(string3);
            string2 = " MB";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(" MB - ");
        }
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public final void a() {
        this.b.a.cancel(2131689777);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void a(midrop.c.d.a a2) {
        Intent intent;
        int n2;
        String string2;
        block7 : {
            String string3;
            block8 : {
                block6 : {
                    if (!this.d) {
                        return;
                    }
                    if (a2 == null) {
                        return;
                    }
                    n2 = a2.k();
                    if (n2 == 0) {
                        midrop.service.c.d.b((String)"NotificationBar", (String)"showProgress file size is 0", (Object[])new Object[0]);
                        return;
                    }
                    intent = new Intent(this.a, this.e);
                    intent.putExtra("from", a2.b());
                    intent.putExtra("file_preview_path", a2.f());
                    intent.putExtra("receiver_service_pid", ReceiverService.b(this.a));
                    intent.addFlags(270532608);
                    string2 = "";
                    if (n2 != 1) break block6;
                    midrop.c.f.a a3 = a2.l();
                    if (a3 == null) break block7;
                    string3 = a3.b;
                    if (!TextUtils.isEmpty((CharSequence)string3) && string3.length() > 20) {
                        StringBuilder stringBuilder;
                        String string4 = string3.substring(0, 21);
                        if (ac.c((Context)this.a)) {
                            stringBuilder = new StringBuilder("...");
                        } else {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(string4);
                            string4 = "...";
                        }
                        stringBuilder.append(string4);
                        string3 = stringBuilder.toString();
                    }
                    break block8;
                }
                Resources resources = this.a.getResources();
                Object[] arrobject = new Object[]{n2};
                string3 = resources.getQuantityString(2131558410, n2, arrobject);
            }
            string2 = a.super.a(string3, a2);
        }
        String string5 = string2;
        Resources resources = this.a.getResources();
        Object[] arrobject = new Object[]{a2.b()};
        String string6 = resources.getQuantityString(2131558405, n2, arrobject);
        this.b.a(2131558405, (int)(a2.e() / 1000L), (int)(a2.d() / 1000L), string6, string5, string6, intent, 1);
    }

    public final void b(midrop.c.d.a a2) {
        if (!this.d) {
            return;
        }
        if (a2 != null) {
            if (a2.k() == 0) {
                return;
            }
            Intent intent = new Intent(this.a, this.e);
            intent.putExtra("from", a2.b());
            intent.putExtra("file_preview_path", a2.f());
            intent.putExtra("receiver_service_pid", ReceiverService.b(this.a));
            intent.addFlags(270532608);
            Resources resources = this.a.getResources();
            int n2 = a2.k();
            Object[] arrobject = new Object[]{a2.b()};
            String string2 = resources.getQuantityString(2131558405, n2, arrobject);
            this.b.a(2131558405, string2, intent, 1);
            String.format((String)"showFloatProgressNotification-[title=%s]", (Object[])new Object[]{string2});
        }
    }

}

