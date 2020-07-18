/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewStub
 *  android.widget.ImageView
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  com.google.zxing.a
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  midrop.b.c.a.e
 */
package com.xiaomi.midrop.coolboot.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.xiaomi.midrop.coolboot.a;
import com.xiaomi.midrop.coolboot.activity.CoolBootActivity;
import com.xiaomi.midrop.coolboot.service.CoolBootService;
import com.xiaomi.midrop.e;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.ag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import midrop.service.c.d;

public class CoolBootActivity
extends com.xiaomi.midrop.util.Locale.a
implements View.OnClickListener {
    private static final String a = CoolBootActivity.class.getCanonicalName();
    private static boolean e;
    private ScrollView b;
    private ViewStub c;
    private Bitmap d;
    private com.xiaomi.midrop.receiver.a f;
    private List<Uri> g = null;
    private BroadcastReceiver h = new BroadcastReceiver(this){
        final /* synthetic */ CoolBootActivity a;
        {
            this.a = coolBootActivity;
        }

        public final void onReceive(Context context, Intent intent) {
            if ("com.xiaomi.midrop.action.WIFI_AP_STARTED".equals((Object)intent.getAction())) {
                String string2 = intent.getStringExtra("extra_ssid");
                String string3 = intent.getStringExtra("extra_password");
                String string4 = intent.getStringExtra("extra_host_ip");
                int n2 = intent.getIntExtra("extra_port", 7007);
                if (!android.text.TextUtils.isEmpty((CharSequence)string2) && !android.text.TextUtils.isEmpty((CharSequence)string3)) {
                    CoolBootActivity.a(this.a);
                    CoolBootActivity.a(this.a, string2, string3, string4, n2);
                }
                af.a(af.a.bX).a();
                return;
            }
            if ("com.xiaomi.midrop.action.WIFI_AP_STARTED_ERROR".equals((Object)intent.getAction()) && !com.xiaomi.midrop.util.am.c() && midrop.b.c.a.e.c()) {
                CoolBootActivity.b(this.a).setVisibility(8);
                CoolBootActivity.c(this.a);
                CoolBootActivity.d(this.a).setVisibility(0);
            }
        }
    };
    private a.a i = new a.a(this){
        final /* synthetic */ CoolBootActivity a;
        {
            this.a = coolBootActivity;
        }

        public final void a() {
            this.a.u();
        }

        public final void a(int n2) {
            if (n2 == 1) {
                e.a((Activity)this.a);
                af.a(af.a.w).a();
                return;
            }
            CoolBootActivity.e(this.a);
            CoolBootActivity.f(this.a);
        }
    };

    static /* synthetic */ void a(CoolBootActivity coolBootActivity) {
        coolBootActivity.b.setVisibility(0);
        if (coolBootActivity.c != null) {
            coolBootActivity.c.setVisibility(8);
        }
    }

    static /* synthetic */ void a(CoolBootActivity coolBootActivity, String string2, String string3, String string4, int n2) {
        coolBootActivity.a(string2, string3, string4, n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String string2, String string3, String string4, int n2) {
        ((TextView)this.findViewById(2131296878)).setText((CharSequence)string2);
        ((TextView)this.findViewById(2131296879)).setText((CharSequence)string3);
        TextView textView = (TextView)this.findViewById(2131296832);
        Object[] arrobject = new Object[]{string4, n2};
        textView.setText((CharSequence)String.format((String)"%s:%s", (Object[])arrobject));
        if (midrop.b.c.a.e.c() && !(true ^ this.s) && !"192.168.43.1".equalsIgnoreCase(string4)) {
            ImageView imageView = (ImageView)this.findViewById(2131296327);
            String string5 = textView.getText().toString();
            if (imageView != null) {
                try {
                    int n3 = this.getResources().getDimensionPixelSize(2131165605);
                    new com.journeyapps.barcodescanner.b();
                    Bitmap bitmap = com.journeyapps.barcodescanner.b.a(string5, com.google.zxing.a.l, n3, n3);
                    if (bitmap != null && !bitmap.sameAs(this.d)) {
                        if (this.d != null) {
                            this.d.recycle();
                        }
                        this.d = bitmap;
                    }
                    imageView.setImageBitmap(this.d);
                    return;
                }
                catch (Exception exception) {
                    d.a(a, "updateQrCodeView encodeBitmap exception", exception, new Object[0]);
                }
            }
        }
    }

    private boolean a() {
        return this.g != null && !this.g.isEmpty();
    }

    static /* synthetic */ ScrollView b(CoolBootActivity coolBootActivity) {
        return coolBootActivity.b;
    }

    private void b() {
        if (this.d(2131689657)) {
            return;
        }
        if (e.c((Context)this)) {
            this.w();
            return;
        }
        if (!e.a((Context)this)) {
            b b2 = b.a();
            this.a(b2.b(2131689644), b2.b(2131689634), new View.OnClickListener(this){
                final /* synthetic */ CoolBootActivity a;
                {
                    this.a = coolBootActivity;
                }

                public void onClick(View view) {
                    this.a.a(e.a, 1, CoolBootActivity.g(this.a));
                    af.a(af.a.u).a(af.b.m, "ShareMiDrop").a();
                }
            });
            af.a(af.a.t).a(af.b.m, "ShareMiDrop").a();
            return;
        }
        this.a(e.a, 2, this.i);
    }

    private void c() {
        CoolBootService.a((Context)this, this.g);
    }

    static /* synthetic */ void c(CoolBootActivity coolBootActivity) {
        if (coolBootActivity.c == null) {
            coolBootActivity.c = (ViewStub)coolBootActivity.findViewById(2131296914);
            coolBootActivity.c.inflate();
            coolBootActivity.findViewById(2131296519).setOnClickListener(new View.OnClickListener(coolBootActivity){
                final /* synthetic */ CoolBootActivity a;
                {
                    this.a = coolBootActivity;
                }

                public void onClick(View view) {
                    CoolBootActivity.f(this.a);
                    CoolBootActivity.a(this.a);
                }
            });
        }
    }

    static /* synthetic */ ViewStub d(CoolBootActivity coolBootActivity) {
        return coolBootActivity.c;
    }

    private void d() {
        this.f = new com.xiaomi.midrop.receiver.a((Context)this);
        this.f.a();
    }

    static /* synthetic */ void e(CoolBootActivity coolBootActivity) {
        coolBootActivity.d();
    }

    static /* synthetic */ void f(CoolBootActivity coolBootActivity) {
        coolBootActivity.c();
    }

    static /* synthetic */ a.a g(CoolBootActivity coolBootActivity) {
        return coolBootActivity.i;
    }

    @SuppressLint(value={"NewApi"})
    protected void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        if (n2 != 1014 && n2 != 1012) {
            if (n2 == 1015 && e.a((Context)this)) {
                CoolBootActivity.super.d();
                CoolBootActivity.super.c();
                af.a(af.a.x).a();
                return;
            }
            e.b();
            this.finish();
            return;
        }
        CoolBootActivity.super.b();
    }

    public void onClick(View view) {
        if (view.getId() != 2131296862) {
            return;
        }
        view.setVisibility(8);
        this.findViewById(2131296869).setVisibility(8);
        this.findViewById(2131296594).setVisibility(0);
        af.a(af.a.bZ).a();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131427364);
        ArrayList arrayList = bundle != null ? bundle.getParcelableArrayList("webshare_uris") : this.getIntent().getParcelableArrayListExtra("webshare_uris");
        this.g = arrayList;
        this.c(2131427429);
        View view = this.t();
        view.setBackgroundColor(this.getResources().getColor(2131100072));
        ag.a((Activity)this, this.getResources().getColor(2131100072));
        ImageView imageView = (ImageView)view.findViewById(2131296485);
        TextView textView = (TextView)view.findViewById(2131296810);
        Resources resources = this.getResources();
        int n2 = CoolBootActivity.super.a() ? 2131690032 : 2131689918;
        textView.setText((CharSequence)resources.getString(n2));
        View.OnClickListener onClickListener = new View.OnClickListener((CoolBootActivity)this){
            final /* synthetic */ CoolBootActivity a;
            {
                this.a = coolBootActivity;
            }

            public void onClick(View view) {
                this.a.onBackPressed();
            }
        };
        imageView.setOnClickListener(onClickListener);
        if (ac.c((Context)this)) {
            imageView.setRotation(180.0f);
        }
        textView.setOnClickListener(onClickListener);
        if (!midrop.b.c.a.e.c()) {
            CoolBootActivity.super.a(com.xiaomi.midrop.util.e.a(), a.a, "192.168.43.1", 7007);
        }
        this.b = (ScrollView)this.findViewById(2131296396);
        e = true;
        IntentFilter intentFilter = new IntentFilter("com.xiaomi.midrop.action.WIFI_AP_STARTED");
        intentFilter.addAction("com.xiaomi.midrop.action.WIFI_AP_STARTED_ERROR");
        this.registerReceiver(this.h, intentFilter);
        CoolBootActivity.super.b();
    }

    @Override
    protected void onDestroy() {
        CoolBootService.a((Context)this);
        if (this.d != null) {
            this.d.recycle();
        }
        this.d = null;
        if (this.f != null) {
            this.f.b();
        }
        e = false;
        this.unregisterReceiver(this.h);
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (CoolBootActivity.super.a()) {
            bundle.putParcelableArrayList("webshare_uris", new ArrayList(this.g));
        }
    }
}

