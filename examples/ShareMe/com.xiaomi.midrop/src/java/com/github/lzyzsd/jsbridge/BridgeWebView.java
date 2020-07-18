/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Looper
 *  android.util.AttributeSet
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.github.lzyzsd.jsbridge.BridgeWebView$1
 *  com.github.lzyzsd.jsbridge.e
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package com.github.lzyzsd.jsbridge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.a;
import com.github.lzyzsd.jsbridge.c;
import com.github.lzyzsd.jsbridge.d;
import com.github.lzyzsd.jsbridge.e;
import com.github.lzyzsd.jsbridge.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint(value={"SetJavaScriptEnabled"})
public class BridgeWebView
extends WebView {
    protected Map<String, d> a = new HashMap();
    Map<String, a> b = new HashMap();
    a c = new e();
    protected long d = 0L;
    private final String e = "BridgeWebView";
    private List<f> f = new ArrayList();

    public BridgeWebView(Context context) {
        super(context);
        BridgeWebView.super.c();
    }

    public BridgeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        BridgeWebView.super.c();
    }

    public BridgeWebView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        BridgeWebView.super.c();
    }

    static /* synthetic */ void a(BridgeWebView bridgeWebView, f f2) {
        bridgeWebView.a(f2);
    }

    private void c() {
        this.setVerticalScrollBarEnabled(false);
        this.setHorizontalScrollBarEnabled(false);
        this.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled((boolean)true);
        }
        this.setWebViewClient((WebViewClient)this.a());
    }

    public c a() {
        return new c(this);
    }

    protected final void a(f f2) {
        if (this.f != null) {
            this.f.add((Object)f2);
            return;
        }
        this.b(f2);
    }

    final void a(String string2) {
        String string3;
        String[] arrstring = string2.replace((CharSequence)"yy://return/", (CharSequence)"").split("/");
        String string4 = arrstring.length > 0 ? arrstring[0] : null;
        d d2 = (d)this.a.get((Object)string4);
        if (string2.startsWith("yy://return/_fetchQueue/")) {
            string3 = string2.replace((CharSequence)"yy://return/_fetchQueue/", (CharSequence)"");
        } else {
            String[] arrstring2 = string2.replace((CharSequence)"yy://return/", (CharSequence)"").split("/");
            int n2 = arrstring2.length;
            string3 = null;
            if (n2 >= 2) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i2 = 1; i2 < arrstring2.length; ++i2) {
                    stringBuilder.append(arrstring2[i2]);
                }
                string3 = stringBuilder.toString();
            }
        }
        if (d2 != null) {
            d2.a(string3);
            this.a.remove((Object)string4);
        }
    }

    public final void a(String string2, a a2) {
        this.b.put((Object)string2, (Object)a2);
    }

    final void b() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            1 var1_1 = new 1(this);
            this.loadUrl("javascript:WebViewJavascriptBridge._fetchQueue();");
            this.a.put((Object)"javascript:WebViewJavascriptBridge._fetchQueue();".replace((CharSequence)"javascript:WebViewJavascriptBridge.", (CharSequence)"").replaceAll("\\(.*\\);", ""), (Object)var1_1);
        }
    }

    final void b(f f2) {
        String string2 = String.format((String)"javascript:WebViewJavascriptBridge._handleMessageFromNative('%s');", (Object[])new Object[]{f2.a().replaceAll("(\\\\)([^utrn])", "\\\\\\\\$1$2").replaceAll("(?<=[^\\\\])(\")", "\\\\\"")});
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.loadUrl(string2);
        }
    }

    public List<f> getStartupMessage() {
        return this.f;
    }

    public void setDefaultHandler(a a2) {
        this.c = a2;
    }

    public void setStartupMessage(List<f> list) {
        this.f = list;
    }
}

