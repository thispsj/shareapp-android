/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.xiaomi.midrop.HomeActivity
 *  com.xiaomi.midrop.deeplink.RouterCenterActivity$1
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.String
 */
package com.xiaomi.midrop.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.globalmiuiapp.common.b.a;
import com.xiaomi.midrop.HomeActivity;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.deeplink.RouterCenterActivity;

public class RouterCenterActivity
extends Activity {
    private void a(Intent intent) {
        Uri uri;
        if (intent == null) {
            return;
        }
        1 var2_2 = new 1((RouterCenterActivity)this);
        if (intent != null && a.a(uri = intent.getData())) {
            var2_2.a(uri);
        }
        if (intent != null) {
            if (this == null) {
                return;
            }
            Uri uri2 = intent.getData();
            if (a.a(uri2)) {
                String string2 = uri2.getLastPathSegment();
                Bundle bundle = intent.getExtras();
                if (bundle == null) {
                    bundle = new Bundle();
                }
                if (!TextUtils.isEmpty((CharSequence)uri2.getQuery())) {
                    bundle.putString("query_params", uri2.getQuery());
                }
                a.a((Activity)this, string2, bundle);
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!MiDropApplication.b()) {
            this.startActivity(new Intent((Context)this, HomeActivity.class));
        }
        RouterCenterActivity.super.a(this.getIntent());
        this.finish();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        RouterCenterActivity.super.a(intent);
    }
}

