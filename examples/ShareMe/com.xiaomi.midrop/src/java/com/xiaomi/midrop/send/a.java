/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcelable
 *  android.os.ResultReceiver
 *  android.support.v4.content.a
 *  android.support.v4.widget.ContentLoadingProgressBar
 *  android.support.v7.app.c
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.xiaomi.midrop.send.SendReceiveWaitConnectivityDialog
 *  com.xiaomi.midrop.send.SendReceiveWaitConnectivityDialog$showDialogForSendReceive
 *  com.xiaomi.midrop.sender.service.a
 *  com.xiaomi.midrop.util.af
 *  com.xiaomi.midrop.util.af$a
 *  com.xiaomi.midrop.util.af$b
 *  com.xiaomi.midrop.view.c
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  midrop.service.c.d
 */
package com.xiaomi.midrop.send;

import a.j;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.qrcode.a;
import com.xiaomi.midrop.receiver.service.ReceiverService;
import com.xiaomi.midrop.send.SendReceiveWaitConnectivityDialog;
import com.xiaomi.midrop.sender.service.SenderManagerService;
import com.xiaomi.midrop.util.af;

public final class a {
    public static final a a = new a(0);
    private static long o;
    private String b = "";
    private boolean c;
    private c d;
    private boolean e;
    private boolean f;
    private android.support.v7.app.c g;
    private com.xiaomi.midrop.qrcode.a h;
    private final String i = "SendReceiveWaitConnectivityDialog";
    private d j;
    private Handler k = new Handler();
    private Runnable l;
    private TextView m;
    private Intent n;

    static {
        long l2 = com.xiaomi.midrop.e.c() ? 7000L : 11000L;
        o = l2;
    }

    public static final /* synthetic */ void a(a a2, com.xiaomi.midrop.qrcode.a a3) {
        com.xiaomi.midrop.qrcode.a a4;
        com.xiaomi.midrop.qrcode.a a5;
        com.xiaomi.midrop.qrcode.a a6;
        com.xiaomi.midrop.qrcode.a a7;
        if (a2.h == null) {
            a2.h = new com.xiaomi.midrop.qrcode.a();
        }
        if ((a6 = a2.h) != null) {
            String string2 = a3 != null ? a3.a : null;
            a6.a = string2;
        }
        if ((a7 = a2.h) != null) {
            String string3 = a3 != null ? a3.b : null;
            a7.b = string3;
        }
        if ((a5 = a2.h) != null) {
            Boolean bl = a3 != null ? Boolean.valueOf((boolean)a3.c) : null;
            a5.c = bl;
        }
        if ((a4 = a2.h) != null) {
            Boolean bl = null;
            if (a3 != null) {
                bl = a3.f;
            }
            a4.f = bl;
        }
    }

    public static final /* synthetic */ void a(a a2, boolean bl) {
        a2.e = bl;
    }

    private final void a(String string2) {
        this.l = null;
        this.l = new Runnable((a)this, string2){
            final /* synthetic */ a a;
            final /* synthetic */ String b;
            {
                this.a = a2;
                this.b = string2;
            }

            public final void run() {
                if (this.a.b()) {
                    String string2 = this.b;
                    CharSequence charSequence = "receiver";
                    if (string2 == null) {
                        throw new j("null cannot be cast to non-null type java.lang.String");
                    }
                    b b2 = string2.contentEquals(charSequence) ? b.c : b.b;
                    if (b2 == b.c) {
                        c c2;
                        if (!this.a.f && !this.a.e) {
                            d d2 = this.a.j;
                            if (d2 != null) {
                                android.support.v7.app.c c3 = this.a.g;
                                if (c3 == null) {
                                    a.e.b.d.a();
                                }
                                d2.a(c3, b2, this.b);
                            }
                            a.l(this.a);
                            return;
                        }
                        if (this.a.e && this.a.f || this.a.e && !this.a.f) {
                            c c4 = this.a.d;
                            if (c4 != null) {
                                c4.a(this.a.h, false);
                            }
                            return;
                        }
                        if (!this.a.e && this.a.f && (c2 = this.a.d) != null) {
                            c2.a(this.a.h, true);
                        }
                        return;
                    }
                    d d3 = this.a.j;
                    if (d3 != null) {
                        android.support.v7.app.c c5 = this.a.g;
                        if (c5 == null) {
                            a.e.b.d.a();
                        }
                        d3.a(c5, b2, this.b);
                    }
                    a.l(this.a);
                }
            }
        };
        this.k.postDelayed(this.l, o);
    }

    public static final /* synthetic */ void b(a a2, boolean bl) {
        a2.f = bl;
    }

    public static final /* synthetic */ void d(a a2) {
        a2.d = null;
    }

    public static final /* synthetic */ void i(a a2) {
        a2.j = null;
    }

    public static final /* synthetic */ void k(a a2) {
        a2.g = null;
    }

    public static final /* synthetic */ void l(a a2) {
        TextView textView;
        TextView textView2;
        TextView textView3 = a2.m;
        if (textView3 != null) {
            textView3.setText(2131689537);
        }
        if ((textView = a2.m) != null) {
            textView.setEnabled(true);
        }
        if ((textView2 = a2.m) != null) {
            textView2.setTextColor(android.support.v4.content.a.c((Context)MiDropApplication.a(), (int)2131099808));
        }
    }

    public static final /* synthetic */ void n(a a2) {
        a2.h = null;
    }

    public static final /* synthetic */ void r(a a2) {
        a2.l = null;
    }

    public static final /* synthetic */ void s(a a2) {
        a2.m = null;
    }

    public final void a() {
        android.support.v7.app.c c2 = this.g;
        if (c2 != null) {
            c2.dismiss();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(Context context, Bundle bundle, c c2, Intent intent) {
        TextView textView;
        android.support.v7.app.c c3;
        TextView textView2;
        CharSequence charSequence;
        a.e.b.d.b((Object)context, "context");
        a.e.b.d.b((Object)bundle, "bundle");
        View view = LayoutInflater.from((Context)context).inflate(2131427563, null);
        this.n = intent;
        this.d = c2;
        a.e.b.d.a((Object)view, "view");
        this.j = new d(view);
        com.xiaomi.midrop.view.c c4 = new com.xiaomi.midrop.view.c(context);
        c4.b().a(2131689537, new View.OnClickListener((a)this, bundle, context){
            final /* synthetic */ a a;
            final /* synthetic */ Bundle b;
            final /* synthetic */ Context c;
            {
                this.a = a2;
                this.b = bundle;
                this.c = context;
            }

            public final void onClick(View view) {
                a.a(this.a);
                new StringBuilder("setNegativeButton listener which dialog=").append(this.b.getString("from").equals((Object)"receiver"));
                if (this.b.getString("from") != null) {
                    String string2 = this.b.getString("from");
                    if (string2 == null) {
                        a.e.b.d.a();
                    }
                    CharSequence charSequence = "receiver";
                    if (string2 == null) {
                        throw new j("null cannot be cast to non-null type java.lang.String");
                    }
                    if (string2.contentEquals(charSequence)) {
                        ReceiverService.a(this.c);
                        Intent intent = new Intent(this.c, ReceiverService.class);
                        this.c.stopService(intent);
                    } else {
                        c c2;
                        String string3 = this.b.getString("from");
                        if (string3 == null) {
                            a.e.b.d.a();
                        }
                        CharSequence charSequence2 = "sender";
                        if (string3 == null) {
                            throw new j("null cannot be cast to non-null type java.lang.String");
                        }
                        if (string3.contentEquals(charSequence2) && (c2 = a.c(this.a)) != null) {
                            c2.a();
                        }
                    }
                }
                if (a.g(this.a) != null) {
                    Context context = this.c;
                    if (context == null) {
                        throw new j("null cannot be cast to non-null type android.app.Activity");
                    }
                    android.app.Activity activity = (android.app.Activity)context;
                    if (activity != null) {
                        activity.finish();
                    }
                }
                if (a.h(this.a) != null) {
                    String string4 = this.b.getString("from");
                    if (string4 == null) {
                        return;
                    }
                    int n2 = string4.hashCode();
                    if (n2 != -905962955) {
                        if (n2 != -808719889) {
                            return;
                        }
                        if (string4.equals((Object)"receiver")) {
                            af.a((af.a)af.a.dX).a(af.b.ay, "close_receiver_preparation_popup").a();
                            return;
                        }
                    } else if (string4.equals((Object)"sender")) {
                        af.a((af.a)af.a.dX).a(af.b.ay, "close_send_preparation_popup").a();
                    }
                }
            }
        }).c().a(view);
        this.g = c4.d();
        View view2 = c4.e();
        if (!(view2 instanceof TextView)) {
            view2 = null;
        }
        if ((textView = (this.m = (TextView)view2)) != null) {
            textView.setEnabled(false);
        }
        if ((textView2 = this.m) != null) {
            textView2.setTextColor(android.support.v4.content.a.c((Context)context, (int)2131099820));
        }
        if ((c3 = this.g) != null) {
            c3.setOnDismissListener(new DialogInterface.OnDismissListener((a)this){
                final /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    this.a.i;
                    if (this.a.k != null && this.a.l != null) {
                        this.a.k.removeCallbacks(this.a.l);
                    }
                    a.d(this.a);
                    a.i(this.a);
                    a.r(this.a);
                    a.n(this.a);
                    a.k(this.a);
                    a.s(this.a);
                    a.a(this.a, false);
                    a.b(this.a, false);
                }
            });
        }
        Context context2 = context.getApplicationContext();
        a.e.b.d.a((Object)context2, "context.applicationContext");
        String string2 = bundle.getString("from");
        android.support.v7.app.c c5 = this.g;
        if (c5 != null) {
            c5.setCancelable(false);
        }
        if (string2 == null) {
            string2 = "";
        }
        if ("sender".contentEquals(charSequence = (CharSequence)string2)) {
            String string3 = bundle.getString("send_scene_value", "");
            a.e.b.d.a((Object)string3, "bundle.getString(SEND_SCENE_VALUE, \"\")");
            this.b = string3;
            this.c = bundle.getBoolean("finish_pick_activity", false);
            Intent intent2 = new Intent(context2, SenderManagerService.class);
            intent2.putExtra("result_receiver", (Parcelable)(a)this.new e(new Handler()));
            intent2.setAction("com.xiaomi.midrop.action.START_DISCOVERY");
            try {
                d d2 = this.j;
                if (d2 != null) {
                    android.support.v7.app.c c6 = this.g;
                    if (c6 == null) {
                        a.e.b.d.a();
                    }
                    d2.a(c6, b.a, "sender");
                }
                context2.startService(intent2);
                a.super.a("sender");
                return;
            }
            catch (IllegalStateException illegalStateException) {
                this.a();
                midrop.service.c.d.a((String)this.i, (String)"startDiscoverDevice if", (Throwable)illegalStateException, (Object[])new Object[0]);
                return;
            }
        }
        if ("receiver".contentEquals(charSequence)) {
            d d3 = this.j;
            if (d3 != null) {
                android.support.v7.app.c c7 = this.g;
                if (c7 == null) {
                    a.e.b.d.a();
                }
                d3.a(c7, b.a, "receiver");
            }
            try {
                ReceiverService.a(context2, (a)this.new e(new Handler()));
                a.super.a("receiver");
                return;
            }
            catch (IllegalStateException illegalStateException) {
                this.a();
                String string4 = this.i;
                StringBuilder stringBuilder = new StringBuilder("startDiscoverDevice else ");
                stringBuilder.append((Object)illegalStateException);
                midrop.service.c.d.b((String)string4, (String)stringBuilder.toString(), (Object[])new Object[0]);
            }
        }
    }

    public final boolean b() {
        android.support.v7.app.c c2 = this.g;
        if (c2 != null) {
            return c2.isShowing();
        }
        return false;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte by) {
        }
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b a;
        public static final /* enum */ b b;
        public static final /* enum */ b c;
        private static final /* synthetic */ b[] d;

        static {
            b b2;
            b b3;
            b b4;
            b[] arrb = new b[3];
            a = b2 = new b();
            arrb[0] = b2;
            b = b3 = new b();
            arrb[1] = b3;
            c = b4 = new b();
            arrb[2] = b4;
            d = arrb;
        }

        public static b valueOf(String string2) {
            return (b)Enum.valueOf(b.class, (String)string2);
        }

        public static b[] values() {
            return (b[])d.clone();
        }
    }

    public static interface c {
        public void a();

        public void a(com.xiaomi.midrop.qrcode.a var1, boolean var2);

        public void a(String var1, boolean var2, Intent var3);
    }

    public static final class d {
        private android.support.v7.app.c a;
        private final TextView b;
        private final TextView c;
        private ImageView d;
        private TextView e;
        private final ContentLoadingProgressBar f;

        public d(View view) {
            a.e.b.d.b((Object)view, "customView");
            View view2 = view.findViewById(2131296472);
            if (view2 == null) {
                throw new j("null cannot be cast to non-null type android.widget.TextView");
            }
            this.b = (TextView)view2;
            View view3 = view.findViewById(2131296609);
            if (view3 == null) {
                throw new j("null cannot be cast to non-null type android.widget.TextView");
            }
            this.c = (TextView)view3;
            View view4 = view.findViewById(2131296654);
            if (view4 == null) {
                throw new j("null cannot be cast to non-null type android.support.v4.widget.ContentLoadingProgressBar");
            }
            this.f = (ContentLoadingProgressBar)view4;
            View view5 = view.findViewById(2131296925);
            if (view5 == null) {
                throw new j("null cannot be cast to non-null type android.widget.ImageView");
            }
            this.d = (ImageView)view5;
            View view6 = view.findViewById(2131296609);
            if (view6 == null) {
                throw new j("null cannot be cast to non-null type android.widget.TextView");
            }
            this.e = (TextView)view6;
        }

        /*
         * Enabled aggressive block sorting
         */
        public final void a(android.support.v7.app.c c2, b b2, String string2) {
            String string3;
            af af2;
            af.b b3;
            a.e.b.d.b((Object)c2, "dialog");
            a.e.b.d.b((Object)b2, "status");
            a.e.b.d.b(string2, "from");
            if (this.a != null) {
                c2 = this.a;
            }
            this.a = c2;
            if (this.a == null) return;
            switch (com.xiaomi.midrop.send.b.a[b2.ordinal()]) {
                default: {
                    return;
                }
                case 3: {
                    ImageView imageView;
                    this.f.a();
                    this.b.setText(2131689659);
                    ImageView imageView2 = this.d;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                    if ((imageView = this.d) != null) {
                        imageView.setImageResource(2131231359);
                    }
                    this.c.setText(2131689655);
                    this.e.setText(2131689655);
                    af.a((af.a)af.a.dX).a(af.b.ay, "failed_receiver_preparation_popup").a();
                    return;
                }
                case 2: {
                    ImageView imageView;
                    this.f.a();
                    this.b.setText(2131689659);
                    ImageView imageView3 = this.d;
                    if (imageView3 != null) {
                        imageView3.setVisibility(0);
                    }
                    if ((imageView = this.d) != null) {
                        imageView.setImageResource(2131231359);
                    }
                    this.c.setText(2131689656);
                    this.e.setText(2131689656);
                    af2 = af.a((af.a)af.a.dX);
                    b3 = af.b.ay;
                    string3 = "failed_send_preparation_popup";
                    break;
                }
                case 1: {
                    this.f.setVisibility(0);
                    this.f.b();
                    ImageView imageView = this.d;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    this.b.setText(2131689704);
                    this.e.setText(2131689629);
                    int n2 = string2.hashCode();
                    if (n2 != -905962955) {
                        if (n2 != -808719889) {
                            return;
                        }
                        if (!string2.equals((Object)"receiver")) return;
                        {
                            af.a((af.a)af.a.dX).a(af.b.ay, "appear_receiver_preparation_popup").a();
                            return;
                        }
                    }
                    if (!string2.equals((Object)"sender")) return;
                    af2 = af.a((af.a)af.a.dX);
                    b3 = af.b.ay;
                    string3 = "appear_send_preparation_popup";
                }
            }
            af2.a(b3, string3).a();
        }
    }

    public final class e
    extends ResultReceiver {
        private boolean b;

        public e(Handler handler) {
            super(handler);
        }

        /*
         * Enabled aggressive block sorting
         */
        protected final void onReceiveResult(int n2, Bundle bundle) {
            block17 : {
                block26 : {
                    c c2;
                    block25 : {
                        block21 : {
                            block24 : {
                                block22 : {
                                    block19 : {
                                        d d2;
                                        android.support.v7.app.c c3;
                                        block20 : {
                                            block23 : {
                                                c c4;
                                                block18 : {
                                                    block15 : {
                                                        block16 : {
                                                            a.e.b.d.b((Object)bundle, "resultData");
                                                            if (n2 != com.xiaomi.midrop.sender.service.a.b) break block15;
                                                            a.this.i;
                                                            new StringBuilder("WIFI_ENABLED, result=").append(bundle.getBoolean("is_wifi_enabled"));
                                                            if (!bundle.getBoolean("is_wifi_enabled")) break block16;
                                                            this.b = true;
                                                            if (!a.this.e || a.this.d == null || (c4 = a.this.d) == null) break block17;
                                                            break block18;
                                                        }
                                                        this.b = false;
                                                        if (a.this.e) break block17;
                                                        d2 = a.this.j;
                                                        if (d2 == null) break block19;
                                                        c3 = a.this.g;
                                                        if (c3 == null) {
                                                            a.e.b.d.a();
                                                        }
                                                        break block20;
                                                    }
                                                    if (n2 != com.xiaomi.midrop.sender.service.a.c) break block21;
                                                    bundle.setClassLoader(MiDropApplication.a().getClass().getClassLoader());
                                                    a.this.i;
                                                    new StringBuilder("BT_ENABLED, result=").append(bundle.getBoolean("is_bt_enabled"));
                                                    if (!bundle.getString("call_back_from").equals((Object)"sender")) break block22;
                                                    if (!bundle.getBoolean("is_bt_enabled")) break block23;
                                                    a.a(a.this, true);
                                                    if (!this.b || a.this.d == null || (c4 = a.this.d) == null) break block17;
                                                }
                                                c4.a(a.this.b, a.this.c, a.this.n);
                                                break block17;
                                            }
                                            a.a(a.this, false);
                                            if (this.b) break block17;
                                            d2 = a.this.j;
                                            if (d2 == null) break block19;
                                            c3 = a.this.g;
                                            if (c3 == null) {
                                                a.e.b.d.a();
                                            }
                                        }
                                        d2.a(c3, b.b, "sender");
                                    }
                                    a.l(a.this);
                                    break block17;
                                }
                                if (!bundle.getBoolean("is_bt_enabled")) break block24;
                                com.xiaomi.midrop.qrcode.a a2 = (com.xiaomi.midrop.qrcode.a)bundle.getParcelable("extra_info");
                                if (a2 == null) {
                                    throw new j("null cannot be cast to non-null type com.xiaomi.midrop.qrcode.ReceiverInfo");
                                }
                                a.a(a.this, a2);
                                com.xiaomi.midrop.qrcode.a a3 = a.this.h;
                                if (a3 != null) {
                                    a3.e = a2.e;
                                }
                                a.a(a.this, true);
                                if (!a.this.f || a.this.d == null || (c2 = a.this.d) == null) break block17;
                                break block25;
                            }
                            a.a(a.this, false);
                            break block17;
                        }
                        if (n2 != 1030) break block17;
                        bundle.setClassLoader(MiDropApplication.a().getClass().getClassLoader());
                        if (!bundle.getBoolean("is_ap_enabled")) break block26;
                        com.xiaomi.midrop.qrcode.a a4 = (com.xiaomi.midrop.qrcode.a)bundle.getParcelable("extra_info");
                        a a5 = a.this;
                        if (a4 == null) {
                            a.e.b.d.a();
                        }
                        a.a(a5, a4);
                        a.this.i;
                        new StringBuilder("onReceive, ACTION_AP_STARTED mIsBtEnabled=").append(a.this.e);
                        com.xiaomi.midrop.qrcode.a a6 = a.this.h;
                        if (a6 != null) {
                            a6.d = a4.d;
                        }
                        a.b(a.this, true);
                        if (!a.this.e || a.this.d == null || (c2 = a.this.d) == null) break block17;
                    }
                    c2.a(a.this.h, false);
                    break block17;
                }
                a.this.i;
                new StringBuilder("onReceive, ACTION_AP_FAILED mIsBtEnabled=").append(a.this.e);
                a.b(a.this, false);
            }
            super.onReceiveResult(n2, bundle);
        }
    }

}

