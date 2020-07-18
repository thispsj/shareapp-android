/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.NotificationManager
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.res.Resources
 *  android.text.TextUtils
 *  com.xiaomi.midrop.received.ReceivedActivity
 *  com.xiaomi.midrop.sender.ui.NotificationActivity
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  midrop.a.c.a.a.c
 *  midrop.a.c.a.a.c$a
 *  midrop.c.d.a
 */
package com.xiaomi.midrop.util;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.text.TextUtils;
import com.xiaomi.midrop.d;
import com.xiaomi.midrop.received.ReceivedActivity;
import com.xiaomi.midrop.receiver.a.a;
import com.xiaomi.midrop.sender.ui.NotificationActivity;
import com.xiaomi.midrop.util.ac;
import java.util.List;
import midrop.a.c.a.a.c;
import midrop.c.d.a;

public final class w {
    public com.xiaomi.midrop.sender.b.a a;
    public com.xiaomi.midrop.receiver.a.a b;
    public boolean c;

    public w(Activity activity) {
        this.a = new com.xiaomi.midrop.sender.b.a((Context)activity, activity.getClass());
        com.xiaomi.midrop.receiver.a.a a2 = this.b = new com.xiaomi.midrop.receiver.a.a((Context)activity, activity.getClass());
        if (a2.c == null) {
            a2.c = new BroadcastReceiver(a2){
                final /* synthetic */ com.xiaomi.midrop.receiver.a.a a;
                {
                    this.a = a2;
                }

                public final void onReceive(Context context, Intent intent) {
                    this.a.a();
                }
            };
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        a2.a.registerReceiver(a2.c, intentFilter);
    }

    public final void a() {
        this.a.a.a.cancelAll();
        this.b.b.a.cancelAll();
    }

    public final void a(int n2, String string2) {
        com.xiaomi.midrop.sender.b.a a2 = this.a;
        if (a2.c) {
            int n3 = 2131689778;
            if (n2 == 1) {
                n3 = 2131689780;
            }
            a2.a.a.cancelAll();
            String string3 = a2.b.getString(n3, new Object[]{string2});
            Intent intent = new Intent(a2.b, NotificationActivity.class);
            a2.a.a(n3, string3, intent, 0);
        }
    }

    public final void a(int n2, a a2) {
        com.xiaomi.midrop.receiver.a.a a3 = this.b;
        if (a3.d) {
            int n3;
            String string2 = "";
            if (a2 != null) {
                string2 = a2.b();
                n3 = a2.k();
            } else {
                n3 = 1;
            }
            if (a3.d) {
                a3.b.a.cancelAll();
                String string3 = a3.a.getResources().getQuantityString(n2, n3, new Object[]{string2});
                Intent intent = n2 == 2131558404 ? new Intent(a3.a, NotificationActivity.class) : new Intent(a3.a, ReceivedActivity.class);
                a3.b.a(n2, string3, intent, 1);
                String.format((String)"show-[title=%s]", (Object[])new Object[]{string3});
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void a(c c2, String string2) {
        com.xiaomi.midrop.sender.b.a a2 = this.a;
        List list = c2.j;
        if (a2.c) {
            if (c2 != null) {
                StringBuilder stringBuilder;
                String string3 = a2.b.getString(2131689779, new Object[]{string2});
                Intent intent = new Intent(a2.b, a2.d);
                intent.setAction("android.intent.action.VIEW");
                intent.addFlags(268435456);
                String string4 = "";
                int n2 = list.size();
                if (n2 == 1) {
                    string4 = ((c.a)list.get((int)0)).b;
                    if (!TextUtils.isEmpty((CharSequence)string4) && string4.length() > 20) {
                        StringBuilder stringBuilder2;
                        String string5 = string4.substring(0, 21);
                        if (ac.c(a2.b)) {
                            stringBuilder2 = new StringBuilder("...");
                        } else {
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(string5);
                            string5 = "...";
                        }
                        stringBuilder2.append(string5);
                        string4 = stringBuilder2.toString();
                    }
                } else if (n2 > 1) {
                    Resources resources = a2.b.getResources();
                    Object[] arrobject = new Object[]{n2};
                    string4 = resources.getQuantityString(2131558410, n2, arrobject);
                }
                Object[] arrobject = new Object[]{Float.valueOf((float)((float)(c2.a / 1024L) / 1024.0f))};
                String string6 = String.format((String)"%.2f", (Object[])arrobject);
                if (ac.c(a2.b)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(string4);
                    stringBuilder.append(" - ");
                    stringBuilder.append(string6);
                    stringBuilder.append(" MB");
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(string6);
                    stringBuilder.append(" MB - ");
                    stringBuilder.append(string4);
                }
                String string7 = stringBuilder.toString();
                a2.a.a(2131689779, (int)(c2.c / 1000L), (int)(c2.a / 1000L), string3, string7, string3, intent, 0);
                return;
            }
            String string8 = a2.b.getString(2131689899);
            Intent intent = new Intent(a2.b, a2.d);
            intent.setAction("android.intent.action.VIEW");
            intent.addFlags(268435456);
            a2.a.a(2131689899, string8, intent, 0);
        }
    }

    public final void a(boolean bl) {
        this.c = bl;
        this.a.c = bl;
        this.b.d = bl;
    }
}

