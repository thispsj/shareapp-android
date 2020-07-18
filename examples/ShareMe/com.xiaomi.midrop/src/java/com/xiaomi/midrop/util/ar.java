/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.provider.Settings
 *  android.provider.Settings$System
 *  android.support.v7.app.c
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.xiaomi.midrop.util.WifiAssistantUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.util;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.v7.app.c;
import android.view.View;
import com.xiaomi.globalmiuiapp.common.f.b;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.util.WifiAssistantUtils;

public final class ar {
    static Intent a() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$WifiAssistantSettingsActivity"));
        return intent;
    }

    public static void a(Context context) {
        com.xiaomi.midrop.view.c c2 = new com.xiaomi.midrop.view.c(context);
        c2.h = true;
        c2.i = 80;
        c2.a = context.getString(2131690046);
        c2.b = context.getString(2131690045);
        c2.a(2131689540, new View.OnClickListener(){

            public final void onClick(View view) {
            }
        }).b(2131689907, new View.OnClickListener(context){
            final /* synthetic */ Context a;
            {
                this.a = context;
            }

            public final void onClick(View view) {
                Intent intent = ar.a();
                if (ar.a(this.a, intent)) {
                    this.a.startActivity(intent);
                }
            }
        }).d();
    }

    static boolean a(Context context, Intent intent) {
        ActivityInfo activityInfo;
        return intent.resolveActivity(context.getPackageManager()) != null && (activityInfo = intent.resolveActivityInfo(context.getPackageManager(), intent.getFlags())) != null && activityInfo.exported;
    }

    public static boolean b(Context context) {
        if (!b.a()) {
            return false;
        }
        return Settings.System.getInt((ContentResolver)MiDropApplication.a().getContentResolver(), (String)"wifi_assistant", (int)0) == 1 && ar.a(context, ar.a());
    }
}

