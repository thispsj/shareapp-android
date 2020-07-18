/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.f
 *  a.i.g
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.support.v4.view.ViewPager
 *  android.support.v4.view.ViewPager$e
 *  android.support.v4.view.n
 *  android.view.View
 *  android.view.Window
 *  com.xiaomi.midrop.welcome.WelcomeActivity$b
 *  com.xiaomi.midrop.welcome.WelcomeActivity$c
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Locale
 */
package com.xiaomi.midrop.welcome;

import a.a.f;
import a.i.g;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.n;
import android.view.View;
import android.view.Window;
import com.xiaomi.midrop.R;
import com.xiaomi.midrop.e;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.util.d;
import com.xiaomi.midrop.welcome.WelcomeActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/*
 * Exception performing whole class analysis.
 */
public final class WelcomeActivity
extends Activity {
    private final String a;
    private final List<a> b;
    private HashMap c;

    public WelcomeActivity() {
        this.a = "WelcomeActivity";
        this.b = f.a((Object)new a(this));
    }

    private View a(int n2) {
        View view;
        if (this.c == null) {
            this.c = new HashMap();
        }
        if ((view = (View)this.c.get((Object)n2)) == null) {
            view = this.findViewById(n2);
            this.c.put((Object)n2, (Object)view);
        }
        return view;
    }

    public static final /* synthetic */ String a() {
        String string2 = "http://h5.app.intl.miui.com/midrop/software-license-and-user-agreement-en.html";
        if (com.xiaomi.midrop.util.Locale.b.a() != null) {
            com.xiaomi.midrop.util.Locale.b b2 = com.xiaomi.midrop.util.Locale.b.a();
            a.e.b.d.a((Object)b2, "LanguageUtil.getIns()");
            if (b2.b() != null) {
                com.xiaomi.midrop.util.Locale.b b3 = com.xiaomi.midrop.util.Locale.b.a();
                a.e.b.d.a((Object)b3, "LanguageUtil.getIns()");
                Locale locale = b3.b();
                a.e.b.d.a((Object)locale, "locale");
                String string3 = locale.getLanguage();
                a.e.b.d.a((Object)string3, "language");
                CharSequence charSequence = string3;
                Locale locale2 = d.b;
                a.e.b.d.a((Object)locale2, "Constants.SPANISH");
                String string4 = locale2.getLanguage();
                a.e.b.d.a((Object)string4, "Constants.SPANISH.language");
                if (g.a((CharSequence)charSequence, (CharSequence)string4)) {
                    return "http://h5.app.intl.miui.com/shareme/software-license-and-user-agreement-es_es.html";
                }
                Locale locale3 = Locale.CHINESE;
                a.e.b.d.a((Object)locale3, "Locale.CHINESE");
                String string5 = locale3.getLanguage();
                a.e.b.d.a((Object)string5, "Locale.CHINESE.language");
                if (g.a((CharSequence)charSequence, (CharSequence)string5)) {
                    string2 = "http://h5.app.intl.miui.com/midrop/software-license-and-user-agreement-cn.html";
                }
            }
        }
        return string2;
    }

    private final void a(boolean bl) {
        if (e.c()) {
            new com.xiaomi.midrop.view.e((Activity)this).a(bl);
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            Window window = this.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            a.e.b.d.a((Object)window, "window");
            View view = window.getDecorView();
            a.e.b.d.a((Object)view, "decorView");
            int n2 = view.getSystemUiVisibility();
            int n3 = bl ? n2 & 8192 : n2 & -8193;
            view.setSystemUiVisibility(n3);
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
        com.xiaomi.midrop.sender.c.a.a().b();
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean bl = true;
        this.requestWindowFeature((int)bl);
        this.setContentView(2131427388);
        if (Build.VERSION.SDK_INT >= 29 && am.b((Context)this)) {
            bl = false;
        }
        WelcomeActivity.super.a(bl);
        com.xiaomi.midrop.sender.c.a.a().a((Activity)this);
        ViewPager viewPager = (ViewPager)WelcomeActivity.super.a(R.id.viewPager);
        a.e.b.d.a((Object)viewPager, "viewPager");
        viewPager.setAdapter((n)new /* Unavailable Anonymous Inner Class!! */);
        ((ViewPager)WelcomeActivity.super.a(R.id.viewPager)).a((ViewPager.e)new c());
    }

    protected final void onDestroy() {
        com.xiaomi.midrop.sender.c.a.a().b(this);
        super.onDestroy();
    }

    public final class a {
        final /* synthetic */ WelcomeActivity a;
        private int b = 0;
        private int c = 0;

        public a(int n2) {
            this.a = (WelcomeActivity)n2;
        }
    }

}

