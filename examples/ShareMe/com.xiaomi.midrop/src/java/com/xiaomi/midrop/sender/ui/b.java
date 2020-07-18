/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Message
 *  android.os.RemoteException
 *  android.provider.Settings
 *  android.provider.Settings$System
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.k
 *  android.support.v4.app.q
 *  android.support.v7.app.c
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.concurrent.ConcurrentHashMap
 *  midrop.a.b.a$a
 *  midrop.a.c.a.a.a
 *  midrop.a.c.a.a.a$a
 *  midrop.a.c.m$a
 */
package com.xiaomi.midrop.sender.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.support.v4.app.q;
import android.util.Log;
import android.view.View;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.f;
import com.xiaomi.midrop.connect.ConnectionFragment;
import com.xiaomi.midrop.d;
import com.xiaomi.midrop.receiver.ui.TransferFragment;
import com.xiaomi.midrop.receiver.ui.b;
import com.xiaomi.midrop.sender.a;
import com.xiaomi.midrop.sender.ui.b;
import com.xiaomi.midrop.transmission.c;
import com.xiaomi.midrop.transmission.upgrade.a;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.util.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import midrop.a.b.a;
import midrop.a.c.a.a.a;
import midrop.a.c.m;
import midrop.c.d.e;
import midrop.service.a.c;

public abstract class b
extends com.xiaomi.midrop.util.Locale.a
implements b.a {
    private BroadcastReceiver a;
    protected com.xiaomi.midrop.receiver.ui.b b;
    protected String c;
    protected int d = 0;
    protected boolean e;
    protected String f;
    protected List<Uri> g = new ArrayList();
    protected android.support.v7.app.c h = null;
    protected com.xiaomi.midrop.sender.a i;
    protected ConnectionFragment j;
    protected TransferFragment k;
    protected w l;
    protected midrop.a.c.a.a.a m;
    protected long n;
    protected midrop.a.b.a o = new a(this);
    protected m p = new c(this);
    protected Handler q = new Handler();
    protected Handler r = new Handler(this){
        final /* synthetic */ b a;
        {
            this.a = b2;
        }

        public final void handleMessage(Message message) {
            if (this.a.k == null) {
                return;
            }
            switch (message.what) {
                default: {
                    return;
                }
                case 8: {
                    Bundle bundle = message.getData();
                    b b2 = this.a;
                    bundle.getString("uri");
                    bundle.getString("file_path");
                    bundle.getBoolean("in_dir");
                    b2.k();
                    return;
                }
                case 7: {
                    Bundle bundle = message.getData();
                    b b3 = this.a;
                    String string2 = bundle.getString("uri");
                    String string3 = bundle.getString("file_path");
                    bundle.getBoolean("in_dir");
                    b3.a(string2, string3, message.arg1, message.arg2, bundle.getLong("completed_size"), bundle.getLong("total_size"), bundle.getLong("extra_speed"));
                    return;
                }
                case 6: {
                    this.a.d = 6;
                    if (this.a.isFinishing()) break;
                    this.a.m();
                    return;
                }
                case 5: {
                    this.a.d = 5;
                    this.a.l();
                    return;
                }
                case 4: {
                    this.a.d = 4;
                    this.a.n();
                    return;
                }
                case 3: {
                    this.a.d = 3;
                    this.a.a((String)message.obj);
                    return;
                }
                case 2: {
                    this.a.d = 2;
                    this.a.k.i();
                }
            }
        }
    };

    protected final List<Uri> a(int n2, int n3) {
        if (this.g != null && !this.g.isEmpty() && n2 < this.g.size()) {
            int n4 = n3 + n2;
            if (n4 > this.g.size()) {
                n4 = this.g.size();
            }
            return this.g.subList(n2, n4);
        }
        return new ArrayList();
    }

    public final void a(int n2) {
        if (this.j == null) {
            return;
        }
        ConnectionFragment connectionFragment = this.j;
        if (connectionFragment.a != n2) {
            if (n2 != 5 && (connectionFragment.a == 3 || connectionFragment.a == 4)) {
                return;
            }
            if (n2 != 2 || connectionFragment.a != 6) {
                connectionFragment.b = 1 + connectionFragment.b;
                connectionFragment.a = n2;
                connectionFragment.a();
            }
        }
    }

    protected final void a(View.OnClickListener onClickListener) {
        if (this.h != null) {
            Log.e((String)"BaseTransingActivity", (String)"mAbortDialog: skip");
            return;
        }
        com.xiaomi.midrop.view.c c2 = new com.xiaomi.midrop.view.c((Context)this);
        c2.b = this.getString(2131689502);
        c2.b(this.getString(2131689501), onClickListener);
        c2.a(this.getString(2131689544), null);
        this.h = c2.d();
        af.a(af.a.ax).a();
        if (this.h != null) {
            this.h.setOnDismissListener(new DialogInterface.OnDismissListener((b)this, c2){
                final /* synthetic */ com.xiaomi.midrop.view.c a;
                final /* synthetic */ b b;
                {
                    this.b = b2;
                    this.a = c2;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    this.b.h.setOnDismissListener(null);
                    this.a.b(this.b.getString(2131689501), null);
                    this.b.h = null;
                }
            });
        }
    }

    public abstract void a(b var1);

    public void a(com.xiaomi.midrop.transmission.a.e e2) {
    }

    protected final void a(String string2) {
        this.c = string2;
        if (this.k != null) {
            this.k.j();
        }
    }

    protected final void a(String string2, String string3, int n2, int n3, long l2, long l3, long l4) {
        if (this.k != null) {
            this.k.b(string2, string3, n2, n3, l2, l3, l4);
            if (this.l.c) {
                w w2 = this.l;
                midrop.c.d.a a2 = this.k.f();
                if (a2 != null) {
                    w2.b.a(a2);
                }
            }
        }
    }

    protected final void a(String string2, String string3, boolean bl, int n2, int n3, long l2, long l3, long l4) {
        Handler handler = this.q;
        Runnable runnable = new Runnable((b)this, string2, string3, bl, n2, n3, l2, l3, l4){
            final /* synthetic */ String a;
            final /* synthetic */ String b;
            final /* synthetic */ boolean c;
            final /* synthetic */ int d;
            final /* synthetic */ int e;
            final /* synthetic */ long f;
            final /* synthetic */ long g;
            final /* synthetic */ long h;
            final /* synthetic */ b i;
            {
                this.i = b2;
                this.a = string2;
                this.b = string3;
                this.c = bl;
                this.d = n2;
                this.e = n3;
                this.f = l2;
                this.g = l3;
                this.h = l4;
            }

            public final void run() {
                if (this.i.k != null) {
                    this.i.k.a(this.a, this.b, this.d, this.e, this.f, this.g, this.h);
                    midrop.a.c.a.a.a a2 = this.i.k.e();
                    if (this.i.l.c && a2 != null) {
                        midrop.a.c.a.a.c c2 = a2.c;
                        this.i.l.a(c2, a2.a());
                    }
                }
            }
        };
        handler.post(runnable);
    }

    public void a(midrop.a.c.a.a.a a2) {
    }

    public abstract void a(e var1);

    public void a(midrop.service.a.c c2, midrop.a.c.a.a.a a2) {
        if (c2.a == c.d.b) {
            if (a2 == null) {
                return;
            }
            c.a a3 = c2.b;
            switch (8.a[a3.ordinal()]) {
                default: {
                    return;
                }
                case 4: {
                    this.e = false;
                    this.l.a(2, a2.a());
                    return;
                }
                case 3: {
                    if (!a2.b.e()) break;
                    if (a2.c.a > 0L) {
                        this.l.a(1, a2.a());
                        return;
                    }
                    this.l.a(2, a2.a());
                    return;
                }
                case 2: {
                    this.b(a2);
                    return;
                }
                case 1: {
                    this.a(a2);
                    if (this.e) break;
                    this.l.a();
                }
            }
        }
    }

    @Override
    public boolean a(String string2, String string3) {
        return false;
    }

    @Override
    public void b() {
    }

    /*
     * Enabled aggressive block sorting
     */
    protected final void b(View.OnClickListener onClickListener) {
        if (this.h != null) {
            Log.e((String)"BaseTransingActivity", (String)"mAbortDialog: skip");
            return;
        }
        com.xiaomi.midrop.view.c c2 = new com.xiaomi.midrop.view.c((Context)this);
        c2.b = this.getString(2131689548);
        int n2 = this.e ? 2131689501 : 2131689657;
        c2.b(this.getString(n2), onClickListener);
        c2.a((String)this.getString((int)2131689544), null).j = 1;
        this.h = c2.d();
        if (this.h != null) {
            this.h.setOnDismissListener(new DialogInterface.OnDismissListener((b)this, c2){
                final /* synthetic */ com.xiaomi.midrop.view.c a;
                final /* synthetic */ b b;
                {
                    this.b = b2;
                    this.a = c2;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    this.b.h.setOnDismissListener(null);
                    this.a.b(this.b.getString(2131689501), null);
                    this.b.h = null;
                }
            });
        }
    }

    protected final void b(String string2) {
        com.xiaomi.midrop.sender.a a2 = this.i;
        a.a a3 = a.d.a(string2);
        ArrayList<com.xiaomi.midrop.transmission.upgrade.a.a> arrayList = a.d.b(string2);
        switch (a.7.b[a3.ordinal()]) {
            default: {
                return;
            }
            case 5: {
                a2.d.post(new Runnable(a2){
                    final /* synthetic */ com.xiaomi.midrop.sender.a a;
                    {
                        this.a = a2;
                    }

                    public final void run() {
                        if (this.a.g != null) {
                            this.a.g.a = a.b.b;
                            if (this.a.h.a != null) {
                                this.a.h.a.a(a.b.b);
                                com.xiaomi.midrop.sender.a.a(this.a);
                                af.a(af.a.cU).a(com.xiaomi.midrop.util.af$b.Y, "auto").a();
                            }
                        }
                    }
                });
                return;
            }
            case 4: {
                a2.d.post(new Runnable(a2){
                    final /* synthetic */ com.xiaomi.midrop.sender.a a;
                    {
                        this.a = a2;
                    }

                    public final void run() {
                        if (this.a.g != null) {
                            this.a.g.a = a.b.c;
                            if (this.a.h.a != null) {
                                this.a.h.a.a(a.b.c);
                                android.widget.Toast.makeText((Context)this.a.a, (CharSequence)this.a.a.getString(2131690017), (int)0).show();
                            }
                        }
                    }
                });
                return;
            }
            case 3: {
                Message message = a2.d.obtainMessage();
                message.obj = a.b.c;
                message.sendToTarget();
                return;
            }
            case 2: {
                a2.d.post(new Runnable(a2, arrayList){
                    final /* synthetic */ ArrayList a;
                    final /* synthetic */ com.xiaomi.midrop.sender.a b;
                    {
                        this.b = a2;
                        this.a = arrayList;
                    }

                    public final void run() {
                        com.xiaomi.midrop.sender.a a2 = this.b;
                        for (com.xiaomi.midrop.transmission.upgrade.a.a a3 : this.a) {
                            com.xiaomi.midrop.transmission.upgrade.a.a a4 = (com.xiaomi.midrop.transmission.upgrade.a.a)a2.b.get((Object)a3.b);
                            if (a4 == null) continue;
                            a3.c = a4.c;
                            a3.g = a4.g;
                            a3.a = a4.a;
                        }
                        Activity activity = this.b.a;
                        ArrayList arrayList = this.a;
                        if (activity != null) {
                            if (arrayList == null) {
                                return;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            for (com.xiaomi.midrop.transmission.upgrade.a.a a5 : arrayList) {
                                java.io.File file;
                                if (android.text.TextUtils.isEmpty((CharSequence)a5.g) || android.text.TextUtils.isEmpty((CharSequence)a5.a) || !(file = new java.io.File(a5.g)).exists() || file.length() == 0L) continue;
                                android.net.Uri$Builder builder = new android.net.Uri$Builder();
                                builder.scheme("file");
                                builder.authority("");
                                builder.path(a5.g);
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(a5.a);
                                stringBuilder.append(".apk");
                                builder.appendQueryParameter("name", stringBuilder.toString());
                                if (a5.a("com.xiaomi.midrop")) {
                                    builder.appendQueryParameter("silent_transfer", "true");
                                }
                                arrayList2.add((Object)builder.build());
                            }
                            if (!arrayList2.isEmpty()) {
                                Intent intent;
                                com.xiaomi.midrop.sender.c.d.a = arrayList2;
                                if (activity instanceof com.xiaomi.midrop.sender.ui.TransmissionActivity) {
                                    intent = new Intent((Context)activity, com.xiaomi.midrop.sender.ui.TransmissionActivity.class);
                                } else {
                                    boolean bl = activity instanceof com.xiaomi.midrop.receiver.ui.ReceiveActivity;
                                    intent = null;
                                    if (bl) {
                                        intent = new Intent((Context)activity, com.xiaomi.midrop.receiver.ui.ReceiveActivity.class);
                                    }
                                }
                                intent.setAction("com.xiaomi.midrop.FILE_LIST_SHARE");
                                activity.startActivity(intent);
                            }
                        }
                    }
                });
                return;
            }
            case 1: 
        }
        new a.b((List<com.xiaomi.midrop.transmission.upgrade.a.a>)arrayList, a2).execute((Object[])new Void[0]);
    }

    public void b(String string2, String string3, boolean bl) {
        this.j = ConnectionFragment.a(string2, string3, bl);
        q q2 = this.getSupportFragmentManager().a();
        q2.a();
        q2.b(2131296463, (Fragment)this.j);
        q2.b();
        q2.f();
    }

    protected void b(midrop.a.c.a.a.a a2) {
    }

    @Override
    public void c() {
    }

    @Override
    public void d() {
    }

    @Override
    public void e() {
    }

    public final String h() {
        return this.f;
    }

    protected final void i() {
        if (this.b == null) {
            this.b = new com.xiaomi.midrop.receiver.ui.b((Context)this, this);
        }
        com.xiaomi.midrop.receiver.ui.b b2 = this.b;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("miui.intent.action.SHOW_RECEIVE_DIALOG");
        intentFilter.addAction("miui.intent.action.SHOW_CONNECT_DIALOG");
        b2.a.registerReceiver((BroadcastReceiver)b2, intentFilter);
    }

    protected final void j() {
        if (this.b != null) {
            com.xiaomi.midrop.receiver.ui.b b2 = this.b;
            b2.a.unregisterReceiver((BroadcastReceiver)b2);
            this.b = null;
        }
    }

    protected final void k() {
        if (this.k != null) {
            TransferFragment.o();
        }
    }

    protected final void l() {
        if (this.k != null) {
            this.k.m();
            midrop.c.d.a a2 = this.k.f();
            if (a2 != null) {
                this.l.a(2131558404, a2);
            }
        }
    }

    protected final void m() {
        if (this.k != null) {
            this.k.l();
        }
    }

    protected final void n() {
        if (this.k != null) {
            this.k.k();
            midrop.c.d.a a2 = this.k.f();
            if (a2 != null) {
                if (a2.d() == 0L) {
                    this.l.a(2131558404, a2);
                    return;
                }
                if (a2.k() > 0) {
                    this.l.a(2131558406, a2);
                }
            }
        }
    }

    protected final boolean o() {
        return this.getSupportFragmentManager().a(2131296463) instanceof ConnectionFragment;
    }

    public void onBackPressed() {
        this.a(null);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = new w((Activity)this);
        this.i = new com.xiaomi.midrop.sender.a((Activity)this, new a.a((b)this){
            final /* synthetic */ b a;
            {
                this.a = b2;
            }

            public final void a(com.xiaomi.midrop.transmission.a.e e2) {
                this.a.a(e2);
            }

            public final void a(String string2) {
                if (!android.text.TextUtils.isEmpty((CharSequence)string2)) {
                    this.a.a(new e(midrop.c.d.g.m, string2));
                }
            }
        });
        com.xiaomi.midrop.transmission.c c2 = com.xiaomi.midrop.transmission.c.e();
        if (c2.p == null) {
            c2.p = new BroadcastReceiver(c2, 0){
                final /* synthetic */ com.xiaomi.midrop.transmission.c a;
                {
                    this.a = c2;
                }

                public final void onReceive(Context context, Intent intent) {
                    if (intent != null) {
                        if (intent.getAction() == null) {
                            return;
                        }
                        new Object[1][0] = intent.getAction();
                        if (intent.getAction().equals((Object)"com.xiaomi.midrop.action.XMPP_RECEIVE_THUMB_INFO")) {
                            ArrayList<f> arrayList = midrop.c.f.d.a(intent.getStringExtra("extra_thumbInfo"));
                            if (arrayList.isEmpty()) {
                                return;
                            }
                            for (f f2 : arrayList) {
                                if (com.xiaomi.midrop.transmission.c.a(this.a).containsKey((Object)f2.a)) continue;
                                com.xiaomi.midrop.transmission.c.a(this.a).put((Object)f2.a, (Object)f2);
                            }
                            for (int i2 = this.a.d.size() - 1; i2 >= 0; --i2) {
                                com.xiaomi.midrop.transmission.c$b b2 = (com.xiaomi.midrop.transmission.c$b)this.a.d.get(i2);
                                com.xiaomi.midrop.transmission.c.a(this.a);
                                b2.n();
                            }
                        }
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter("com.xiaomi.midrop.action.XMPP_RECEIVE_THUMB_INFO");
            this.registerReceiver((BroadcastReceiver)c2.p, intentFilter);
        }
        if (this.a == null) {
            this.a = new BroadcastReceiver((b)this){
                final /* synthetic */ b a;
                {
                    this.a = b2;
                }

                public final void onReceive(Context context, Intent intent) {
                    if ("getting_conn_id_action".equals((Object)intent.getAction())) {
                        this.a.f = intent.getStringExtra("extra_conn_id");
                        if (this.a.j != null) {
                            this.a.j.a(this.a.f);
                        }
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("getting_conn_id_action");
            this.registerReceiver(this.a, intentFilter);
        }
        if (com.xiaomi.globalmiuiapp.common.f.b.a()) {
            if (!am.b()) {
                return;
            }
            try {
                if (Settings.System.getInt((ContentResolver)MiDropApplication.a().getContentResolver(), (String)"wifi_assistant", (int)1) == 1) {
                    Settings.System.putInt((ContentResolver)MiDropApplication.a().getContentResolver(), (String)"wifi_assistant", (int)0);
                    midrop.service.c.e.a("need_enable_wifi_assistant_key", true);
                }
                return;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder("disableWifiAssistant e: ");
                stringBuilder.append((Object)((Object)exception));
                midrop.service.c.d.b("WifiAssistantUtils", stringBuilder.toString(), new Object[0]);
            }
        }
    }

    @Override
    public void onDestroy() {
        com.xiaomi.midrop.receiver.a.a a2 = this.l.b;
        if (a2.c != null) {
            try {
                a2.a.unregisterReceiver(a2.c);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                Log.e((String)"NotificationBar", (String)"mScreenStateReceiver is not register. ", (Throwable)illegalArgumentException);
            }
            a2.c = null;
        }
        this.l.a();
        com.xiaomi.midrop.transmission.c c2 = com.xiaomi.midrop.transmission.c.e();
        if (c2.p != null) {
            try {
                this.unregisterReceiver((BroadcastReceiver)c2.p);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                midrop.service.c.d.a("TransferDataCenter", "unregisterThumbInfoReceiver e:", illegalArgumentException, new Object[0]);
            }
            c2.p = null;
            c2.g.clear();
        }
        if (this.a != null) {
            this.unregisterReceiver(this.a);
            this.a = null;
        }
        if (com.xiaomi.globalmiuiapp.common.f.b.a() && am.b()) {
            try {
                if (midrop.service.c.e.b("need_enable_wifi_assistant_key", false)) {
                    Settings.System.putInt((ContentResolver)MiDropApplication.a().getContentResolver(), (String)"wifi_assistant", (int)1);
                    midrop.service.c.e.a("need_enable_wifi_assistant_key", false);
                }
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder("enableWifiAssistant e: ");
                stringBuilder.append((Object)((Object)exception));
                midrop.service.c.d.b("WifiAssistantUtils", stringBuilder.toString(), new Object[0]);
            }
        }
        super.onDestroy();
    }

    @Override
    public void onPause() {
        midrop.a.c.a.a.a a2;
        super.onPause();
        this.l.a(true);
        if (this.k != null && (a2 = this.k.e()) != null) {
            if (this.k.c()) {
                w w2 = this.l;
                midrop.a.c.a.a.c c2 = a2.c;
                String string2 = a2.a();
                com.xiaomi.midrop.sender.b.a a3 = w2.a;
                if (a3.c && c2 != null) {
                    String string3 = a3.b.getString(2131689779, new Object[]{string2});
                    Intent intent = new Intent(a3.b, a3.d);
                    intent.setAction("android.intent.action.VIEW");
                    intent.addFlags(268435456);
                    a3.a.a(2131689779, string3, intent, 0);
                }
            }
            if (this.k.d()) {
                w w3 = this.l;
                midrop.c.d.a a4 = this.k.f();
                if (a4 != null) {
                    w3.b.b(a4);
                    w3.b.a(a4);
                }
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.l.a();
        this.l.a(false);
    }

    protected final boolean p() {
        return this.getSupportFragmentManager().a(2131296463) instanceof TransferFragment;
    }

    protected final void q() {
        this.q.post(new Runnable(this){
            final /* synthetic */ b a;
            {
                this.a = b2;
            }

            public final void run() {
                midrop.a.c.a.a.a a2;
                if (this.a.k != null && this.a.l.c && (a2 = this.a.k.e()) != null) {
                    if (a2.c == null) {
                        return;
                    }
                    this.a.l.a(a2.c, a2.a());
                    return;
                }
            }
        });
    }

    @Override
    public final void r() {
        super.r();
        if (this.h != null && this.h.isShowing()) {
            this.h.dismiss();
        }
    }

    private static final class a
    extends a.a {
        WeakReference<b> a;

        public a(b b2) {
            this.a = new WeakReference((Object)b2);
        }

        public final void a() throws RemoteException {
            b b2 = (b)this.a.get();
            if (b2 != null) {
                if (b2.d == 1) {
                    b2.finish();
                    return;
                }
                b2.r.sendEmptyMessage(6);
            }
        }

        public final void a(long l2) throws RemoteException {
            b b2 = (b)this.a.get();
            if (b2 != null) {
                b2.r.sendEmptyMessage(4);
            }
        }

        public final void a(String string2, long l2, long l3, long l4) throws RemoteException {
            b b2 = (b)this.a.get();
            if (b2 != null) {
                b2.n = l4;
            }
        }

        public final void a(String string2, String string3, long l2) throws RemoteException {
            b b2 = (b)this.a.get();
            if (b2 != null) {
                Message message = Message.obtain();
                message.what = 3;
                message.obj = string3;
                b2.r.sendMessage(message);
            }
        }

        public final void a(String string2, String string3, boolean bl) throws RemoteException {
            b b2 = (b)this.a.get();
            if (b2 != null) {
                Message message = Message.obtain();
                message.what = 8;
                Bundle bundle = new Bundle();
                bundle.putString("uri", string2);
                bundle.putString("file_path", string3);
                bundle.putBoolean("in_dir", bl);
                message.setData(bundle);
                b2.r.sendMessage(message);
            }
        }

        public final void a(String string2, String string3, boolean bl, int n2, int n3, long l2, long l3) {
            b b2 = (b)this.a.get();
            if (b2 != null) {
                Message message = Message.obtain();
                message.what = 7;
                message.arg1 = n2;
                message.arg2 = n3;
                Bundle bundle = new Bundle();
                bundle.putString("uri", string2);
                bundle.putString("file_path", string3);
                bundle.putLong("completed_size", l2);
                bundle.putLong("total_size", l3);
                bundle.putLong("extra_speed", b2.n);
                bundle.putBoolean("in_dir", bl);
                message.setData(bundle);
                b2.r.sendMessage(message);
            }
        }

        public final void b(long l2) throws RemoteException {
            b b2 = (b)this.a.get();
            if (b2 != null) {
                b2.r.removeMessages(7);
                b2.r.sendEmptyMessage(5);
            }
        }
    }

    private static final class c
    extends m.a {
        private WeakReference<b> a;

        public c(b b2) {
            this.a = new WeakReference((Object)b2);
        }

        public final List<Uri> a(int n2, int n3) throws RemoteException {
            List<Uri> list = new List<Uri>();
            b b2 = (b)this.a.get();
            if (b2 != null) {
                list = b2.a(n2, n3);
            }
            return list;
        }

        public final void a(String string2) throws RemoteException {
            b b2 = (b)this.a.get();
            if (b2 != null) {
                b2.b(string2);
            }
        }

        public final void a(String string2, String string3, boolean bl, int n2, int n3, long l2, long l3, long l4) throws RemoteException {
            b b2 = (b)this.a.get();
            if (b2 != null) {
                b2.a(string2, string3, bl, n2, n3, l2, l3, l4);
            }
        }

        public final void a(String string2, midrop.a.c.a.a.a a2) {
            b b2 = (b)this.a.get();
            midrop.service.a.c c2 = new midrop.service.a.c();
            c2.a(string2);
            if (b2 != null) {
                b2.q.post(new Runnable((c)this, b2, c2, a2){
                    final /* synthetic */ b a;
                    final /* synthetic */ midrop.service.a.c b;
                    final /* synthetic */ midrop.a.c.a.a.a c;
                    final /* synthetic */ c d;
                    {
                        this.d = c2;
                        this.a = b2;
                        this.b = c3;
                        this.c = a2;
                    }

                    public final void run() {
                        this.a.a(this.b, this.c);
                    }
                });
            }
        }

        public final void a(List<String> list) throws RemoteException {
            b b2 = (b)this.a.get();
            if (b2 != null) {
                b2.q();
            }
        }
    }

}

