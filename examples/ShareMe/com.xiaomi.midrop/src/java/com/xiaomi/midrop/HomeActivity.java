/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.midrop.SplashScreen;
import com.xiaomi.midrop.WebActivity;
import com.xiaomi.midrop.util.Locale.a;

public class HomeActivity
extends a {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundle2 = this.getIntent().getBundleExtra("push_bundle");
        if (bundle2 != null) {
            Intent intent;
            String string = bundle2.getString("push_url");
            if (!TextUtils.isEmpty((CharSequence)string) && Uri.parse((String)string).getPath().equals((Object)"/midrop/webview")) {
                intent = new Intent((Context)this, WebActivity.class);
                String string2 = Uri.parse((String)string).getQueryParameter("webUrl");
                intent.putExtra("param_title", Uri.parse((String)string).getQueryParameter("webTitle"));
                intent.putExtra("param_url", string2);
            } else {
                intent = null;
            }
            if (intent != null) {
                this.startActivity(intent);
                return;
            }
        }
        this.startActivity(new Intent((Context)this, SplashScreen.class));
    }
}

