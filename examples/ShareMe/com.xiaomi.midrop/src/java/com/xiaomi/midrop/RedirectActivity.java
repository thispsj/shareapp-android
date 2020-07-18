/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningTaskInfo
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.xiaomi.midrop.korea.privacy.AppPermissionsUseActivity
 *  com.xiaomi.midrop.korea.privacy.AppPrivacyActivity
 *  com.xiaomi.midrop.send.FilePickNewActivity
 *  com.xiaomi.midrop.util.aa
 *  com.xiaomi.midrop.util.af
 *  com.xiaomi.midrop.welcome.WelcomeActivity
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  midrop.service.c.e
 */
package com.xiaomi.midrop;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.midrop.korea.privacy.AppPermissionsUseActivity;
import com.xiaomi.midrop.korea.privacy.AppPrivacyActivity;
import com.xiaomi.midrop.send.FilePickNewActivity;
import com.xiaomi.midrop.util.aa;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.welcome.WelcomeActivity;
import java.util.List;
import midrop.service.c.e;

public class RedirectActivity
extends Activity {
    protected void onCreate(Bundle bundle) {
        Intent intent;
        int n;
        String string2;
        block10 : {
            block9 : {
                super.onCreate(bundle);
                intent = this.getIntent();
                string2 = "from_other";
                ActivityManager activityManager = (ActivityManager)this.getSystemService("activity");
                n = 1;
                List list = activityManager.getRunningTasks(n);
                if (list == null || list.size() <= 0) break block9;
                ActivityManager.RunningTaskInfo runningTaskInfo = (ActivityManager.RunningTaskInfo)list.get(0);
                String string3 = runningTaskInfo.topActivity.getShortClassName();
                if (!TextUtils.isEmpty((CharSequence)string3) && (!TextUtils.equals((CharSequence)".RedirectActivity", (CharSequence)string3) || runningTaskInfo.numActivities != n)) break block10;
            }
            n = 0;
        }
        if (n == 0) {
            Intent intent2;
            if (!e.b((String)"user_notice_agree_state", (boolean)false)) {
                intent2 = TextUtils.equals((CharSequence)aa.b(), (CharSequence)"KR") ? (!e.b((String)"user_notice_agree_permissions_state", (boolean)false) ? new Intent((Context)this, AppPermissionsUseActivity.class) : new Intent((Context)this, AppPrivacyActivity.class)) : new Intent((Context)this, WelcomeActivity.class);
            } else {
                String string4;
                intent2 = new Intent((Context)this, FilePickNewActivity.class);
                if (intent != null && !TextUtils.isEmpty((CharSequence)(string4 = intent.getStringExtra("from_other")))) {
                    string2 = string4;
                }
                intent2.putExtra("from", string2);
            }
            this.startActivity(intent2);
        }
        this.finish();
        if (intent != null) {
            if ("from_other".equals((Object)string2)) {
                string2 = "Other";
            }
            intent.putExtra("entrance_id", string2);
            af.a((Intent)intent);
        }
    }
}

