/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.app.Application
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.res.Configuration
 *  android.os.Process
 *  android.support.b.a
 *  com.google.firebase.FirebaseApp
 *  com.google.firebase.FirebaseOptions
 *  com.xiaomi.midrop.util.Locale.b
 *  com.xiaomi.midrop.util.Locale.c
 *  com.xiaomi.midrop.util.Locale.c$a
 *  com.xiaomi.midrop.util.k
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Locale
 *  midrop.service.c.d
 *  org.a.ae
 */
package com.xiaomi.midrop;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Process;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.xiaomi.globalmiuiapp.common.a.a;
import com.xiaomi.midrop.activity.c;
import com.xiaomi.midrop.d.a.a;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.Locale.c;
import com.xiaomi.midrop.util.k;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import midrop.service.c.d;
import org.a.ae;

public class MiDropApplication
extends Application {
    private static Context a;
    private static boolean b;

    public static Context a() {
        return a;
    }

    public static void a(boolean bl) {
        b = bl;
    }

    public static boolean b() {
        return b;
    }

    protected void attachBaseContext(Context context) {
        Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)new Thread.UncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()){
            final /* synthetic */ Thread.UncaughtExceptionHandler a;
            {
                this.a = uncaughtExceptionHandler;
            }

            public final void uncaughtException(final Thread thread, final Throwable throwable) {
                d.a((String)"MiDrop:MiDropApplication", (String)"UncaughtException", (Throwable)throwable, (Object[])new Object[0]);
                com.xiaomi.globalmiuiapp.common.e.a.a(new Runnable(){

                    public final void run() {
                        if (1.this.a != null) {
                            1.this.a.uncaughtException(thread, throwable);
                        }
                    }
                });
            }

        });
        b.a((Context)context);
        super.attachBaseContext(b.a().b(context));
        android.support.b.a.a((Context)this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        new StringBuilder("ApplicationDelegate - onConfigurationChanged:").append((Object)configuration.locale);
        b b2 = b.a();
        Locale locale = configuration.locale;
        if (com.xiaomi.midrop.util.Locale.c.a((Context)b2.b, (Locale)locale)) {
            new StringBuilder("isLanguageChanged - ").append((Object)configuration.locale);
            b b3 = b.a();
            Context context = b3.b;
            SharedPreferences sharedPreferences = context.getSharedPreferences("LocaleModel", 4);
            com.xiaomi.midrop.util.Locale.c.a((Context)context, (c.a)c.a.a((String)sharedPreferences.getString("SHARE_KEY_USER_SEL_LANG", ""), (String)sharedPreferences.getString("SHARE_KEY_USER_SEL_COUNTRY", "")));
            b3.c();
        }
    }

    public void onCreate() {
        boolean bl;
        super.onCreate();
        a = this;
        ae.a((Context)this);
        a.a a2 = new a.a(0);
        a2.a = this;
        a2.b = false;
        a2.c = bl = true;
        a2.f = "MiDrop";
        a2.e = "MiDrop 1.28.26";
        a2.d = c.a("https://api.setting.intl.miui.com");
        com.xiaomi.globalmiuiapp.common.a.a.a(new com.xiaomi.globalmiuiapp.common.a.a(a2, 0));
        List list = ((ActivityManager)this.getSystemService("activity")).getRunningAppProcesses();
        String string2 = this.getPackageName();
        int n = Process.myPid();
        if (list != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                if (runningAppProcessInfo.pid != n || !string2.equals((Object)runningAppProcessInfo.processName)) continue;
                break;
            }
        } else {
            bl = false;
        }
        if (!bl) {
            try {
                FirebaseApp.initializeApp((Context)this, (FirebaseOptions)FirebaseOptions.fromResource((Context)this));
            }
            catch (Exception exception) {
                d.a((String)"MiDrop:MiDropApplication", (String)"[FirebaseApp.initializeApp]", (Throwable)exception, (Object[])new Object[0]);
            }
        }
        k.a((Context)this);
        com.xiaomi.midrop.d.a.b.a().a((Context)this);
        new HashMap();
    }

}

