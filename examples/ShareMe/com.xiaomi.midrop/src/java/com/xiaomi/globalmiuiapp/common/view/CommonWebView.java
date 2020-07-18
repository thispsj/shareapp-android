/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.Context
 *  android.net.Uri
 *  android.net.http.SslError
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.webkit.SslErrorHandler
 *  android.webkit.WebChromeClient
 *  android.webkit.WebResourceError
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.widget.ProgressBar
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.xiaomi.globalmiuiapp.common.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.c;
import com.github.lzyzsd.jsbridge.d;
import com.github.lzyzsd.jsbridge.f;
import com.xiaomi.globalmiuiapp.common.view.CommonWebView;
import java.util.Map;
import org.json.JSONObject;

public class CommonWebView
extends BridgeWebView {
    public WebView e;
    private final String f = "CommonWebView";
    private a g;
    private WebChromeClient h;
    private b i;

    public CommonWebView(Context context) {
        super(context);
        this.h = new WebChromeClient((CommonWebView)this){
            final /* synthetic */ CommonWebView a;
            {
                this.a = commonWebView;
            }

            public final void onCloseWindow(WebView webView) {
                super.onCloseWindow(webView);
            }

            public final boolean onCreateWindow(WebView webView, boolean bl, boolean bl2, android.os.Message message) {
                if (CommonWebView.a(this.a) != null) {
                    CommonWebView.a(this.a).destroy();
                    CommonWebView.a(this.a, null);
                }
                try {
                    CommonWebView.a(this.a, new WebView(this.a.getContext()));
                    CommonWebView.a(this.a).setWebViewClient(new android.webkit.WebViewClient(this){
                        final /* synthetic */ 1 a;
                        {
                            this.a = var1;
                        }

                        private void a(Uri uri) {
                            if (uri == null) {
                                return;
                            }
                            try {
                                android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
                                intent.setData(uri);
                                this.a.a.getContext().startActivity(intent);
                                return;
                            }
                            catch (Exception exception) {
                                exception.printStackTrace();
                                return;
                            }
                        }

                        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                            if (Build.VERSION.SDK_INT > 20) {
                                com.xiaomi.globalmiuiapp.common.view.CommonWebView$1$1.super.a(webResourceRequest.getUrl());
                            }
                            return true;
                        }

                        public final boolean shouldOverrideUrlLoading(WebView webView, String string2) {
                            if (TextUtils.isEmpty((CharSequence)string2)) {
                                return true;
                            }
                            com.xiaomi.globalmiuiapp.common.view.CommonWebView$1$1.super.a(Uri.parse((String)string2));
                            return true;
                        }
                    });
                    ((android.webkit.WebView$WebViewTransport)message.obj).setWebView(CommonWebView.a(this.a));
                    message.sendToTarget();
                    return true;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return true;
                }
            }

            public final void onProgressChanged(WebView webView, int n2) {
                super.onProgressChanged(webView, n2);
                ProgressBar progressBar = (ProgressBar)CommonWebView.a(this.a, "progressBar", new Object[0]);
                if (progressBar != null) {
                    progressBar.setProgress(n2);
                    if (n2 >= 100) {
                        progressBar.setVisibility(8);
                        return;
                    }
                    progressBar.setVisibility(0);
                    progressBar.setProgress(java.lang.Math.min((int)100, (int)java.lang.Math.max((int)0, (int)n2)));
                }
            }
        };
        CommonWebView.super.c();
    }

    public CommonWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = new /* invalid duplicate definition of identical inner class */;
        CommonWebView.super.c();
    }

    public CommonWebView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.h = new /* invalid duplicate definition of identical inner class */;
        CommonWebView.super.c();
    }

    static /* synthetic */ WebView a(CommonWebView commonWebView) {
        return commonWebView.e;
    }

    static /* synthetic */ WebView a(CommonWebView commonWebView, WebView webView) {
        commonWebView.e = webView;
        return webView;
    }

    /*
     * Exception decompiling
     */
    private static /* varargs */ <T> T a(int var0, T var1, Object ... var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl23.1 : ALOAD_1 : trying to set 0 previously set to 1
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    private /* varargs */ <T> T a(String string2, Object ... arrobject) {
        if (this.g == null) {
            return null;
        }
        if ("progressBar".equals((Object)string2)) {
            return (T)this.g.a();
        }
        if ("customUA".equals((Object)string2)) {
            return (T)this.g.b();
        }
        if ("deviceId".equals((Object)string2)) {
            return (T)this.g.c();
        }
        if ("language".equals((Object)string2)) {
            return (T)this.g.e();
        }
        if ("isPkgInstalled".equals((Object)string2)) {
            return this.g.b(CommonWebView.a(0, "", arrobject));
        }
        if ("appVersionName".equals((Object)string2)) {
            return (T)this.g.d();
        }
        if ("appVersionCode".equals((Object)string2)) {
            return 12826;
        }
        if ("hasRenamed".equals((Object)string2)) {
            return this.g.f();
        }
        if ("getName".equals((Object)string2)) {
            return (T)this.g.g();
        }
        return null;
    }

    /*
     * Exception decompiling
     */
    public static /* varargs */ void a(String var0, d var1, Object ... var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    static /* synthetic */ void b(CommonWebView commonWebView, String string2, Object[] arrobject) {
        if (commonWebView.g != null) {
            if ("updateTitle".equals((Object)string2)) {
                String string3 = CommonWebView.a(0, "", arrobject);
                boolean bl = CommonWebView.a(1, false, arrobject);
                commonWebView.g.a(string3, bl);
                return;
            }
            if ("share".equals((Object)string2)) {
                String string4 = CommonWebView.a(0, "", arrobject);
                String string5 = CommonWebView.a(1, "", arrobject);
                d d2 = CommonWebView.a(2, null, arrobject);
                commonWebView.g.a(string4, string5, d2);
                return;
            }
            if ("setName".equals((Object)string2)) {
                String string6 = CommonWebView.a(0, "", arrobject);
                commonWebView.g.c(string6);
                return;
            }
            if ("syncTransRecords".equals((Object)string2)) {
                String string7 = CommonWebView.a(0, "", arrobject);
                d d3 = CommonWebView.a(1, null, arrobject);
                commonWebView.g.a(string7, d3);
                return;
            }
            if ("toast".equals((Object)string2)) {
                String string8 = CommonWebView.a(0, "", arrobject);
                int n2 = CommonWebView.a(1, 0, arrobject);
                commonWebView.g.a(string8, n2);
                return;
            }
            if ("goHome".equals((Object)string2)) {
                commonWebView.g.h();
            }
        }
    }

    private void c() {
        this.setHorizontalScrollBarEnabled(false);
        this.getSettings().setJavaScriptEnabled(true);
        this.getSettings().setDatabaseEnabled(true);
        this.getSettings().setDomStorageEnabled(true);
        this.getSettings().setGeolocationEnabled(true);
        this.getSettings().setCacheMode(-1);
        this.getSettings().setAppCacheEnabled(true);
        this.getSettings().setUseWideViewPort(true);
        this.getSettings().setLoadWithOverviewMode(true);
        this.getSettings().setSupportZoom(true);
        this.getSettings().setBuiltInZoomControls(true);
        this.getSettings().setDisplayZoomControls(false);
        this.getSettings().setSupportMultipleWindows(true);
        this.getSettings().setTextZoom(100);
        this.setWebChromeClient(this.h);
    }

    private Activity getActivity() {
        return (Activity)this.getContext();
    }

    @Override
    protected final c a() {
        return new c(this){

            @Override
            public final void onPageFinished(WebView webView, String string2) {
                if (CommonWebView.this.g != null && CommonWebView.this.g.a(string2)) {
                    super.onPageFinished(webView, string2);
                }
                CommonWebView commonWebView = CommonWebView.this;
                Object[] arrobject = new Object[]{webView.getTitle(), false};
                CommonWebView.b(commonWebView, "updateTitle", arrobject);
            }

            public final void onReceivedError(WebView webView, int n2, String string2, String string3) {
                super.onReceivedError(webView, n2, string2, string3);
                if (Build.VERSION.SDK_INT < 23 && CommonWebView.this.i != null) {
                    CommonWebView.this.i.b();
                }
            }

            @TargetApi(value=23)
            public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (Build.VERSION.SDK_INT >= 23 && CommonWebView.this.i != null && webResourceRequest != null && webResourceError != null) {
                    b b2 = CommonWebView.this.i;
                    webResourceError.getErrorCode();
                    if (webResourceError.getDescription() != null) {
                        webResourceError.getDescription().toString();
                    }
                    if (webResourceRequest.getUrl() != null) {
                        webResourceRequest.getUrl().toString();
                    }
                    b2.b();
                }
            }

            @TargetApi(value=23)
            public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (Build.VERSION.SDK_INT >= 23 && CommonWebView.this.i != null && webResourceRequest != null && webResourceResponse != null) {
                    b b2 = CommonWebView.this.i;
                    webResourceResponse.getStatusCode();
                    webResourceResponse.getReasonPhrase();
                    if (webResourceRequest.getUrl() != null) {
                        webResourceRequest.getUrl().toString();
                    }
                    b2.b();
                }
            }

            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                sslErrorHandler.proceed();
            }

            @Override
            public final boolean shouldOverrideUrlLoading(WebView webView, String string2) {
                if (!TextUtils.isEmpty((CharSequence)string2) && (string2.startsWith("http://") || string2.startsWith("https://") || string2.startsWith("yy://"))) {
                    if (CommonWebView.this.i != null) {
                        CommonWebView.this.i.a();
                    }
                    return super.shouldOverrideUrlLoading(webView, string2);
                }
                return true;
            }
        };
    }

    public void onResume() {
        long l2;
        d d2 = new d(){

            @Override
            public final void a(String string2) {
                StringBuilder stringBuilder = new StringBuilder("jsFunctionOnResume onCallBack: ");
                stringBuilder.append(string2);
                Log.d((String)"CommonWebView", (String)stringBuilder.toString());
            }
        };
        f f2 = new f();
        if (!TextUtils.isEmpty((CharSequence)"")) {
            f2.d = "";
        }
        Object[] arrobject = new Object[1];
        StringBuilder stringBuilder = new StringBuilder();
        this.d = l2 = 1L + this.d;
        stringBuilder.append(l2);
        stringBuilder.append("_");
        stringBuilder.append(SystemClock.currentThreadTimeMillis());
        arrobject[0] = stringBuilder.toString();
        String string2 = String.format((String)"JAVA_CB_%s", (Object[])arrobject);
        this.a.put((Object)string2, (Object)d2);
        f2.a = string2;
        if (!TextUtils.isEmpty((CharSequence)"jsFunctionOnResume")) {
            f2.e = "jsFunctionOnResume";
        }
        super.a(f2);
    }

    public void setLoadListener(b b2) {
        this.i = b2;
    }

    public void setWebViewHelper(a a2) {
        this.g = a2;
        String string2 = (String)CommonWebView.super.a("customUA", new Object[0]);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            String string3 = this.getSettings().getUserAgentString();
            WebSettings webSettings = this.getSettings();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append("; ");
            stringBuilder.append(string2);
            webSettings.setUserAgentString(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder("initSetting: ua = ");
        stringBuilder.append(this.getSettings().getUserAgentString());
        Log.d((String)"CommonWebView", (String)stringBuilder.toString());
        this.a("getDeviceId", new com.github.lzyzsd.jsbridge.a(){

            @Override
            public final void a(String string2, d d2) {
                try {
                    String string3 = (String)CommonWebView.this.a("deviceId", new Object[0]);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("deviceId", (Object)string3);
                    d2.a(jSONObject.toString());
                }
                catch (Exception exception) {}
            }
        });
        this.a("getLanguage", new com.github.lzyzsd.jsbridge.a(){

            @Override
            public final void a(String string2, d d2) {
                try {
                    String string3 = (String)CommonWebView.this.a("language", new Object[0]);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("language", (Object)string3);
                    d2.a(jSONObject.toString());
                }
                catch (Exception exception) {}
            }
        });
        this.a("getAppVersionName", new com.github.lzyzsd.jsbridge.a(){

            @Override
            public final void a(String string2, d d2) {
                try {
                    String string3 = (String)CommonWebView.this.a("appVersionName", new Object[0]);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appVersionName", (Object)string3);
                    d2.a(jSONObject.toString());
                }
                catch (Exception exception) {}
            }
        });
        this.a("getAppVersionCode", new com.github.lzyzsd.jsbridge.a(){

            @Override
            public final void a(String string2, d d2) {
                try {
                    Integer n2 = (Integer)CommonWebView.this.a("appVersionCode", new Object[0]);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appVersionCode", (Object)n2);
                    d2.a(jSONObject.toString());
                }
                catch (Exception exception) {}
            }
        });
        this.a("isPkgInstalled", new com.github.lzyzsd.jsbridge.a(){

            @Override
            public final void a(String string2, d d2) {
                try {
                    String string3 = new JSONObject(string2).getString("pkg");
                    Boolean bl = (Boolean)CommonWebView.this.a("isPkgInstalled", new Object[]{string3});
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("installed", (Object)bl);
                    d2.a(jSONObject.toString());
                }
                catch (Exception exception) {}
            }
        });
        this.a("share", new com.github.lzyzsd.jsbridge.a(){

            @Override
            public final void a(String string2, d d2) {
                try {
                    JSONObject jSONObject = new JSONObject(string2);
                    String string3 = jSONObject.getString("type");
                    String string4 = jSONObject.getString("content");
                    CommonWebView.b(CommonWebView.this, "share", new Object[]{string3, string4, d2});
                }
                catch (Exception exception) {}
            }
        });
        this.a("refresh", new com.github.lzyzsd.jsbridge.a(){

            @Override
            public final void a(String string2, d d2) {
                try {
                    CommonWebView.this.reload();
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }
        });
        this.a("updateTitle", new com.github.lzyzsd.jsbridge.a(){

            @Override
            public final void a(String string2, d d2) {
                try {
                    String string3 = new JSONObject(string2).getString("title");
                    CommonWebView commonWebView = CommonWebView.this;
                    Object[] arrobject = new Object[]{string3, true};
                    CommonWebView.b(commonWebView, "updateTitle", arrobject);
                }
                catch (Exception exception) {}
            }
        });
        this.a("hasRenamed", new com.github.lzyzsd.jsbridge.a(){

            @Override
            public final void a(String string2, d d2) {
                try {
                    Boolean bl = (Boolean)CommonWebView.this.a("hasRenamed", new Object[0]);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("renamed", (Object)bl);
                    d2.a(jSONObject.toString());
                }
                catch (Exception exception) {}
            }
        });
        this.a("getName", new com.github.lzyzsd.jsbridge.a(){

            @Override
            public final void a(String string2, d d2) {
                try {
                    String string3 = (String)CommonWebView.this.a("getName", new Object[0]);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", (Object)string3);
                    d2.a(jSONObject.toString());
                }
                catch (Exception exception) {}
            }
        });
        this.a("setName", new com.github.lzyzsd.jsbridge.a(){

            @Override
            public final void a(String string2, d d2) {
                try {
                    String string3 = new JSONObject(string2).getString("name");
                    CommonWebView.b(CommonWebView.this, "setName", new Object[]{string3});
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }
        });
        this.a("syncTransRecords", new com.github.lzyzsd.jsbridge.a(){

            @Override
            public final void a(String string2, d d2) {
                try {
                    String string3 = new JSONObject(string2).getString("activityId");
                    CommonWebView.b(CommonWebView.this, "syncTransRecords", new Object[]{string3, d2});
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }
        });
        this.a("toast", new com.github.lzyzsd.jsbridge.a(){

            @Override
            public final void a(String string2, d d2) {
                try {
                    JSONObject jSONObject = new JSONObject(string2);
                    String string3 = jSONObject.getString("text");
                    int n2 = jSONObject.getInt("duration");
                    CommonWebView commonWebView = CommonWebView.this;
                    Object[] arrobject = new Object[]{string3, n2};
                    CommonWebView.b(commonWebView, "toast", arrobject);
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }
        });
        this.a("goHome", new com.github.lzyzsd.jsbridge.a(){

            @Override
            public final void a(String string2, d d2) {
                try {
                    CommonWebView.b(CommonWebView.this, "goHome", new Object[0]);
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }
        });
    }

}

