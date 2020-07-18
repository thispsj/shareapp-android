/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 *  java.lang.Class
 */
package com.xiaomi.midrop.korea.privacy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.xiaomi.midrop.korea.privacy.AppPrivacyActivity;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.ag;
import midrop.service.c.e;

public class AppPermissionsUseActivity
extends a {
    public void onBackPressed() {
        super.onBackPressed();
        com.xiaomi.midrop.sender.c.a.a().b();
    }

    public void onClick(View view) {
        af.a(af.a.dW).a(af.b.aE, 1).a();
        this.startActivity(new Intent((Context)this, AppPrivacyActivity.class));
        e.a("user_notice_agree_permissions_state", true);
        this.finish();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s();
        ag.a((Activity)this);
        this.setContentView(2131427362);
        com.xiaomi.midrop.sender.c.a.a().a((Activity)this);
        this.s();
        af.a(af.a.dW).a(af.b.aF, 1).a();
    }

    @Override
    protected void onDestroy() {
        com.xiaomi.midrop.sender.c.a.a().b((Activity)this);
        super.onDestroy();
    }
}

