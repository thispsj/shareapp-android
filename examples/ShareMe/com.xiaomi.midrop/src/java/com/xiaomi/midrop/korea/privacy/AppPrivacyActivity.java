/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 *  java.lang.String
 */
package com.xiaomi.midrop.korea.privacy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.profile.ProfileSettingActivity;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.miftp.c.f;
import midrop.service.c.e;

public class AppPrivacyActivity
extends a {
    private ImageView a;
    private ImageView b;
    private ImageView c;
    private TextView d;

    public void onBackPressed() {
        super.onBackPressed();
        com.xiaomi.midrop.sender.c.a.a().b();
    }

    public void onClick(View view) {
        af.a(af.a.dI).a();
        af.a(af.a.dW).a(af.b.aE, 2).a();
        this.startActivity(ProfileSettingActivity.a.a((Context)this, true));
        e.a("user_notice_agree_state", true);
        com.xiaomi.midrop.sender.c.a.a().c();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s();
        ag.a((Activity)this);
        this.setContentView(2131427363);
        com.xiaomi.midrop.sender.c.a.a().a((Activity)this);
        this.s();
        this.a = (ImageView)this.findViewById(2131296731);
        this.c = (ImageView)this.findViewById(2131296733);
        this.b = (ImageView)this.findViewById(2131296729);
        this.d = (TextView)this.findViewById(2131296845);
        af.a(af.a.dW).a(af.b.aF, 2).a();
    }

    @Override
    protected void onDestroy() {
        com.xiaomi.midrop.sender.c.a.a().b((Activity)this);
        super.onDestroy();
    }

    public void onSelectAgreement(View view) {
        boolean bl = view.isSelected();
        boolean bl2 = true;
        view.setSelected(bl ^ bl2);
        ImageView imageView = this.a;
        if (!this.c.isSelected() || !this.b.isSelected()) {
            bl2 = false;
        }
        imageView.setSelected(bl2);
        this.d.setEnabled(this.a.isSelected());
    }

    public void onSelectAll(View view) {
        this.a.setSelected(true ^ view.isSelected());
        this.c.setSelected(view.isSelected());
        this.b.setSelected(view.isSelected());
        this.d.setEnabled(this.a.isSelected());
    }

    public void onSelectPrivacy(View view) {
        boolean bl = view.isSelected();
        boolean bl2 = true;
        view.setSelected(bl ^ bl2);
        ImageView imageView = this.a;
        if (!this.c.isSelected() || !this.b.isSelected()) {
            bl2 = false;
        }
        imageView.setSelected(bl2);
        this.d.setEnabled(this.a.isSelected());
    }

    public void toPrivacyWebPage(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)b.a().b(2131689810)));
        if (f.a(intent) != null) {
            this.startActivity(intent);
        }
    }

    public void toServiceWebPage(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)b.a().b(2131690019)));
        if (f.a(intent) != null) {
            this.startActivity(intent);
        }
    }
}

