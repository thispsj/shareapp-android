/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.io.UnsupportedEncodingException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URLDecoder
 *  java.util.List
 */
package com.github.lzyzsd.jsbridge;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.b;
import com.github.lzyzsd.jsbridge.f;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public class c
extends WebViewClient {
    private BridgeWebView a;

    public c(BridgeWebView bridgeWebView) {
        this.a = bridgeWebView;
    }

    public void onPageFinished(WebView webView, String string2) {
        super.onPageFinished(webView, string2);
        String string3 = b.a(webView.getContext(), "WebViewJavascriptBridge.js");
        StringBuilder stringBuilder = new StringBuilder("javascript:");
        stringBuilder.append(string3);
        webView.loadUrl(stringBuilder.toString());
        if (this.a.getStartupMessage() != null) {
            for (f f2 : this.a.getStartupMessage()) {
                this.a.b(f2);
            }
            this.a.setStartupMessage(null);
        }
    }

    public void onPageStarted(WebView webView, String string2, Bitmap bitmap) {
        super.onPageStarted(webView, string2, bitmap);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT >= 24) {
            String string2 = webResourceRequest.getUrl().toString();
            try {
                String string3;
                string2 = string3 = URLDecoder.decode((String)string2, (String)"UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            }
            if (string2.startsWith("yy://return/")) {
                this.a.a(string2);
                return true;
            }
            if (string2.startsWith("yy://")) {
                this.a.b();
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
        try {
            String string3;
            string2 = string3 = URLDecoder.decode((String)string2, (String)"UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
        if (string2.startsWith("yy://return/")) {
            this.a.a(string2);
            return true;
        }
        if (string2.startsWith("yy://")) {
            this.a.b();
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, string2);
    }
}

