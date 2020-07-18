/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.k
 *  android.support.v4.app.q
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.webkit.WebView
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.String
 */
package com.xiaomi.midrop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.support.v4.app.q;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaomi.globalmiuiapp.common.view.CommonWebView;
import com.xiaomi.midrop.WebActivity;
import com.xiaomi.midrop.c;
import com.xiaomi.midrop.util.Locale.a;

public class WebActivity
extends a {
    public static final String a = "WebActivity";
    private String b;
    private String c;
    private int d;
    private TextView e;
    private CommonWebView f;
    private ProgressBar g;
    private FrameLayout h;
    private Fragment i;

    static /* synthetic */ int a(WebActivity webActivity) {
        return webActivity.d;
    }

    static /* synthetic */ Fragment a(WebActivity webActivity, Fragment fragment) {
        webActivity.i = fragment;
        return fragment;
    }

    public static void a(Context context, String string2, String string3, int n2) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("param_title", string2);
        intent.putExtra("param_url", string3);
        intent.putExtra("param_err_type", n2 - 1);
        context.startActivity(intent);
    }

    static /* synthetic */ FrameLayout b(WebActivity webActivity) {
        return webActivity.h;
    }

    static /* synthetic */ ProgressBar c(WebActivity webActivity) {
        return webActivity.g;
    }

    static /* synthetic */ String d(WebActivity webActivity) {
        return webActivity.b;
    }

    static /* synthetic */ TextView e(WebActivity webActivity) {
        return webActivity.e;
    }

    static /* synthetic */ CommonWebView f(WebActivity webActivity) {
        return webActivity.f;
    }

    public final void a() {
        this.f.reload();
        this.b();
    }

    final void b() {
        if (this.i != null) {
            this.h.setVisibility(8);
            this.getSupportFragmentManager().a().a(this.i);
            this.i = null;
        }
    }

    public void onBackPressed() {
        boolean bl;
        CommonWebView commonWebView = this.f;
        if (commonWebView.canGoBack()) {
            commonWebView.goBack();
            bl = true;
        } else {
            if (commonWebView.e != null) {
                commonWebView.e.destroy();
                commonWebView.e = null;
            }
            bl = false;
        }
        if (bl && this.i == null) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131427386);
        this.s();
        this.b = this.getIntent().getStringExtra("param_title");
        this.c = this.getIntent().getStringExtra("param_url");
        this.d = c.a.a(this.getIntent().getIntExtra("param_err_type", 0));
        this.g = (ProgressBar)this.findViewById(2131296923);
        this.h = (FrameLayout)this.findViewById(2131296444);
        this.c(2131427591);
        View view = this.t();
        ImageView imageView = (ImageView)view.findViewById(2131296487);
        imageView.setImageResource(2131231019);
        imageView.setOnClickListener(new View.OnClickListener((WebActivity)this){
            final /* synthetic */ WebActivity a;
            {
                this.a = webActivity;
            }

            public void onClick(View view) {
                this.a.onBackPressed();
            }
        });
        this.e = (TextView)view.findViewById(2131296871);
        this.e.setTextColor(-16777216);
        this.e.setText((CharSequence)this.b);
        this.f = (CommonWebView)this.findViewById(2131296922);
        this.f.setLoadListener(new CommonWebView.b((WebActivity)this){
            final /* synthetic */ WebActivity a;
            {
                this.a = webActivity;
            }

            public final void a() {
                this.a.b();
            }

            public final void b() {
                Fragment fragment;
                int n2 = WebActivity.a(this.a);
                switch (com.xiaomi.midrop.c$1.a[n2 - 1]) {
                    default: {
                        fragment = null;
                        break;
                    }
                    case 2: {
                        fragment = new com.xiaomi.midrop.activity.ActivityErrorFragment();
                        break;
                    }
                    case 1: {
                        fragment = new com.xiaomi.midrop.feedback.FeedBackErrorFragment();
                    }
                }
                if (fragment == null) {
                    return;
                }
                WebActivity.a(this.a, fragment);
                WebActivity.b(this.a).setVisibility(0);
                q q2 = this.a.getSupportFragmentManager().a();
                q2.b(2131296444, fragment);
                q2.c();
                q2.f();
            }
        });
        this.f.setWebViewHelper(new CommonWebView.a((WebActivity)this){
            final /* synthetic */ WebActivity a;
            {
                this.a = webActivity;
            }

            public final ProgressBar a() {
                return WebActivity.c(this.a);
            }

            public final void a(String string2, int n2) {
                if (!android.text.TextUtils.isEmpty((CharSequence)string2) && !this.a.isFinishing()) {
                    if (this.a.isDestroyed()) {
                        return;
                    }
                    WebActivity webActivity = this.a;
                    int n3 = n2 == 0 ? 0 : 1;
                    android.widget.Toast.makeText((Context)webActivity, (CharSequence)string2, (int)n3).show();
                }
            }

            public final void a(String string2, com.github.lzyzsd.jsbridge.d d2) {
                com.xiaomi.midrop.activity.a.a((android.app.Activity)this.a, WebActivity.f(this.a), string2, d2);
            }

            /*
             * Enabled aggressive block sorting
             */
            public final void a(String string2, String string3, com.github.lzyzsd.jsbridge.d d2) {
                if (android.text.TextUtils.isEmpty((CharSequence)string2)) return;
                if (android.text.TextUtils.isEmpty((CharSequence)string3)) {
                    return;
                }
                if ("facebook".equals((java.lang.Object)string2)) {
                    com.xiaomi.midrop.ShareActivity.a((android.app.Activity)this.a, string3);
                } else {
                    if (!"whatsapp".equals((java.lang.Object)string2)) return;
                    com.xiaomi.midrop.ShareActivity.b((android.app.Activity)this.a, string3);
                }
                boolean bl = true;
                if (!bl) return;
                WebActivity.f(this.a);
                CommonWebView.a("share", d2, string2);
            }

            public final void a(String string2, boolean bl) {
                if ((android.text.TextUtils.isEmpty((CharSequence)WebActivity.d(this.a)) || bl) && !android.text.TextUtils.isEmpty((CharSequence)string2)) {
                    if (string2.length() > 15) {
                        java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                        stringBuilder.append(string2.substring(0, 14));
                        stringBuilder.append("\u2026");
                        string2 = stringBuilder.toString();
                    }
                    WebActivity.e(this.a).setText((CharSequence)string2);
                }
            }

            /*
             * Exception decompiling
             */
            public final boolean a(}
        java.lang.IllegalStateException: Parameters not created
        
        