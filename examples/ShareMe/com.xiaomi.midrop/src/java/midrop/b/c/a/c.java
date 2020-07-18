/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.text.TextUtils
 *  android.util.Pair
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Locale
 *  midrop.a.c.a.a.a
 */
package midrop.b.c.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Pair;
import b.g.b.a;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.util.an;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import midrop.b.c.a;
import midrop.c.a.e;
import midrop.c.d.c;
import midrop.c.f.b;

public abstract class c {
    private ArrayList<midrop.c.f.a> a = new ArrayList();
    private BroadcastReceiver b = new BroadcastReceiver(){

        public final void onReceive(Context context, Intent intent) {
            if ("com.xiaomi.midrop.action.CONNECTION_USER_ACTION".equals((Object)intent.getAction())) {
                if (intent.hasExtra("extra_accept")) {
                    c.this.a(intent);
                    return;
                }
                if (intent.hasExtra("extra_cancel_connect")) {
                    c.this.x_();
                }
            }
        }
    };
    String e;
    String f;
    int g;
    int h;
    String i;
    midrop.a.c.a.a.a j;
    protected boolean k;

    private ArrayList<midrop.c.f.a> a(String string2) {
        ArrayList<midrop.c.f.a> arrayList = b.a(string2);
        for (midrop.c.f.a a2 : arrayList) {
            String string3 = a2.e;
            if (string3 != null && string3.length() > 0) {
                Locale locale = Locale.US;
                Object[] arrobject = new Object[]{this.f, string3};
                a2.e = String.format((Locale)locale, (String)"http://%s%s", (Object[])arrobject);
                a2.g = string3.substring(1 + string3.indexOf("/"));
            }
            if (a2.d == null || a2.d.length() <= 0) continue;
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{this.f, a2.d};
            a2.d = String.format((Locale)locale, (String)"http://%s%s", (Object[])arrobject);
        }
        return arrayList;
    }

    protected abstract void a(Intent var1);

    protected final void a(String string2, String string3, int n2, String string4, boolean bl, boolean bl2) {
        midrop.c.e.a a2 = new midrop.c.e.a();
        a2.a(string2);
        a2.c(string3);
        a2.a(n2);
        a2.b(string4);
        a2.a(c.a.b);
        a2.a((byte)0);
        a2.a(true);
        a2.b(true);
        a2.c(bl);
        a2.d(bl2);
        e e2 = midrop.c.b.a.a(MiDropApplication.a(), a2);
        e2.a(a2.i());
        this.j = midrop.a.c.a.a.a.a((e)e2);
    }

    abstract void a_(b.g.b.a var1);

    final void c(b.g.b.a a2) {
        if (a2.a == a.a.b && a2.c.equals((Object)"http://www.xiaomi.com/midrop")) {
            this.e = a2.b;
            this.h = a2.g;
            if (this.j == null) {
                this.a(this.e, this.f, this.g, a2.f, an.a(a2.h), an.b(a2.h));
            } else {
                this.j.a.h(an.a(a2.h));
                this.j.a.i(an.b(a2.h));
            }
            if (TextUtils.isEmpty((CharSequence)this.j.b())) {
                if (TextUtils.isEmpty((CharSequence)this.e)) {
                    this.h = -1;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(a2.f);
                    stringBuilder.append("&");
                    stringBuilder.append(this.f);
                    stringBuilder.append(":");
                    stringBuilder.append(this.g);
                    this.e = midrop.service.c.c.a(stringBuilder.toString().getBytes());
                }
                this.j.a.a(this.e);
                this.j.a.b(a2.f);
                this.j.a.h(an.a(a2.h));
            }
            new StringBuilder("action=").append(a2.d);
            if (!a2.d.equals((Object)"send_files") && !a2.d.equals((Object)"send_files2")) {
                if (a2.d.equals((Object)"cancel_sending")) {
                    this.onEvent(a.a.k);
                    return;
                }
                if (a2.d.equals((Object)"query")) {
                    this.onEvent(a.a.l);
                    return;
                }
                if (!a2.d.equals((Object)"single_delete") && !a2.d.equals((Object)"single_delete_ack")) {
                    if (!a2.d.equals((Object)"delete_files") && !a2.d.equals((Object)"delete_files_ack")) {
                        if (a2.d.equals((Object)"send_file_begin")) {
                            this.a.clear();
                            return;
                        }
                        if (a2.d.equals((Object)"send_files_part")) {
                            ArrayList<midrop.c.f.a> arrayList = c.super.a(a2.e);
                            if (!arrayList.isEmpty()) {
                                this.a.addAll(arrayList);
                            }
                            new StringBuilder("SEND_FILES_PART, count=").append(arrayList.size());
                            return;
                        }
                        if (a2.d.equals((Object)"send_files_end")) {
                            a.a a3 = a.a.i;
                            a3.D = this.a;
                            this.onEvent(a3);
                            return;
                        }
                        if (a2.d.equals((Object)"send_files_end2")) {
                            a.a a4 = a.a.j;
                            a4.D = this.a;
                            this.onEvent(a4);
                            return;
                        }
                        if (a2.d.equals((Object)"downloaded_per_file")) {
                            a.a a5 = a.a.v;
                            a5.D = b.c(a2.e);
                            this.onEvent(a5);
                            return;
                        }
                        if (a2.d.equals((Object)"send_apk_list")) {
                            a.a a6 = a.a.m;
                            a6.D = a2.e;
                            this.onEvent(a6);
                            return;
                        }
                        if (a2.d.equals((Object)"send_file_thumb_list")) {
                            a.a a7 = a.a.n;
                            a7.D = a2.e;
                            this.onEvent(a7);
                            return;
                        }
                        b.g.b.a a8 = new b.g.b.a(a.a.b, null, "http://www.xiaomi.com/midrop", "unknown_action_ack", a2.d);
                        this.a_(a8);
                        return;
                    }
                    a.a a9 = a.a.u;
                    a9.D = b.d(a2.e);
                    this.onEvent(a9);
                    return;
                }
                Pair pair = new Pair((Object)b.c(a2.e), (Object)a2.d.equals((Object)"single_delete"));
                a.a a10 = a.a.o;
                a10.D = pair;
                this.onEvent(a10);
                return;
            }
            ArrayList<midrop.c.f.a> arrayList = c.super.a(a2.e);
            if (arrayList.size() != 0) {
                a.a a11 = a.a.i;
                if (a2.d.equals((Object)"send_files2")) {
                    a11 = a.a.j;
                }
                a11.D = arrayList;
                this.onEvent(a11);
            }
        }
    }

    public final void h() {
        if (this.k) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xiaomi.midrop.action.CONNECTION_USER_ACTION");
        MiDropApplication.a().registerReceiver(this.b, intentFilter);
        this.k = true;
    }

    public final void i() {
        if (!this.k) {
            return;
        }
        try {
            MiDropApplication.a().unregisterReceiver(this.b);
        }
        catch (Exception exception) {}
        this.k = false;
    }

    abstract void onEvent(a.a var1);

    protected abstract void x_();

}

