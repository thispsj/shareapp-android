/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Message
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.Window
 *  android.widget.TextView
 *  com.xiaomi.midrop.DeleteOldTmpFileService
 *  com.xiaomi.midrop.korea.privacy.AppPermissionsUseActivity
 *  com.xiaomi.midrop.korea.privacy.AppPrivacyActivity
 *  com.xiaomi.midrop.send.FilePickNewActivity
 *  com.xiaomi.midrop.util.Locale.b
 *  com.xiaomi.midrop.util.aa
 *  com.xiaomi.midrop.util.af
 *  com.xiaomi.midrop.util.af$a
 *  com.xiaomi.midrop.util.am
 *  com.xiaomi.midrop.util.y
 *  com.xiaomi.midrop.view.e
 *  com.xiaomi.midrop.welcome.WelcomeActivity
 *  java.io.FileDescriptor
 *  java.io.PrintWriter
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.String
 *  java.lang.StringBuilder
 *  midrop.service.c.e
 */
package com.xiaomi.midrop;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.xiaomi.midrop.DeleteOldTmpFileService;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.h;
import com.xiaomi.midrop.g;
import com.xiaomi.midrop.korea.privacy.AppPermissionsUseActivity;
import com.xiaomi.midrop.korea.privacy.AppPrivacyActivity;
import com.xiaomi.midrop.send.FilePickNewActivity;
import com.xiaomi.midrop.sender.c.a;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.aa;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.util.y;
import com.xiaomi.midrop.view.e;
import com.xiaomi.midrop.welcome.WelcomeActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class SplashScreen
extends Activity {
    private static int b = 350;
    Intent a = null;
    private Handler c = new Handler(){

        public final void handleMessage(Message message) {
            Intent intent;
            if (SplashScreen.this.a != null) {
                intent = new Intent(SplashScreen.this.a.getAction());
                intent.setComponent(new ComponentName((Context)SplashScreen.this, FilePickNewActivity.class));
            } else {
                intent = null;
            }
            if (intent != null) {
                SplashScreen.this.startActivity(intent);
            } else {
                SplashScreen.this.startActivity(new Intent((Context)SplashScreen.this, FilePickNewActivity.class));
            }
            SplashScreen.this.finish();
            SplashScreen.this.a = null;
            af.a((af.a)af.a.cf).a();
        }
    };

    private void a(boolean bl) {
        if (com.xiaomi.midrop.e.c()) {
            new e((Activity)this).a(bl);
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            Window window = this.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            View view = window.getDecorView();
            int n = view.getSystemUiVisibility();
            int n2 = bl ? n & 8192 : n & -8193;
            view.setSystemUiVisibility(n2);
        }
    }

    public void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        StringBuilder stringBuilder = new StringBuilder("Score dialog shown:");
        stringBuilder.append(y.d());
        printWriter.println(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder("Transmission count:");
        stringBuilder2.append(y.e());
        printWriter.println(stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder("Transmission succeed:");
        stringBuilder3.append(g.b());
        printWriter.println(stringBuilder3.toString());
        StringBuilder stringBuilder4 = new StringBuilder("MiDrop score:");
        stringBuilder4.append(y.b());
        printWriter.println(stringBuilder4.toString());
        super.dump(string2, fileDescriptor, printWriter, arrstring);
    }

    public void onBackPressed() {
        if (this.c != null) {
            this.c.removeMessages(b);
        }
        a.a().b();
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = this.getIntent();
        a.a().b();
        if (Build.VERSION.SDK_INT >= 29 && am.b((Context)this)) {
            SplashScreen.super.a(false);
        } else {
            SplashScreen.super.a(true);
        }
        if (!midrop.service.c.e.b((String)"user_notice_agree_state", (boolean)false)) {
            Intent intent = TextUtils.equals((CharSequence)aa.c(), (CharSequence)"KR") ? (!midrop.service.c.e.b((String)"user_notice_agree_permissions_state", (boolean)false) ? new Intent((Context)this, AppPermissionsUseActivity.class) : new Intent((Context)this, AppPrivacyActivity.class)) : new Intent((Context)this, WelcomeActivity.class);
            this.startActivity(intent);
            this.finish();
        } else {
            this.setContentView(2131427380);
            ((TextView)this.findViewById(2131296765)).setText((CharSequence)b.a().b(2131689938));
            ((TextView)this.findViewById(2131296318)).setText((CharSequence)b.a().b(2131689523));
            this.c.sendMessageDelayed(this.c.obtainMessage(b), (long)b);
        }
        DeleteOldTmpFileService.a((Context)this.getApplicationContext(), (Intent)new Intent());
        af.a((Intent)this.getIntent());
        if (com.xiaomi.midrop.e.a((Context)this, "android.permission.READ_EXTERNAL_STORAGE")) {
            h.a().b();
        }
    }

    protected void onDestroy() {
        MiDropApplication.a(false);
        super.onDestroy();
    }

    protected void onStart() {
        super.onStart();
        MiDropApplication.a(true);
    }

}

