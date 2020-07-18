/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.SystemClock
 *  android.preference.PreferenceActivity
 *  android.support.v7.widget.Toolbar
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.widget.LinearLayout
 *  android.widget.ListView
 *  com.xiaomi.midrop.BasePreferenceActivity
 *  com.xiaomi.midrop.util.Locale.b
 *  com.xiaomi.midrop.util.ag
 *  com.xiaomi.midrop.util.am
 *  com.xiaomi.midrop.view.e
 *  com.xiaomi.miftp.c.b
 *  java.lang.Boolean
 *  java.lang.String
 */
package com.xiaomi.midrop;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.xiaomi.midrop.BasePreferenceActivity;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.view.e;

public class a
extends PreferenceActivity {
    Toolbar a;
    private long b;
    private boolean c = false;
    private e d;

    private void a(boolean bl) {
        if (com.xiaomi.midrop.e.c()) {
            if (this.d == null) {
                this.d = new e((Activity)this);
            }
            this.d.a(bl);
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

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(b.a().b(context));
    }

    public void onBackPressed() {
        if (!this.c) {
            super.onBackPressed();
            return;
        }
        if (!this.isFinishing() && !this.isDestroyed()) {
            this.finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        View view;
        super.onCreate(bundle);
        this.c = false;
        if (Build.VERSION.SDK_INT >= 29 && am.b((Context)this)) {
            a.super.a(false);
        } else {
            a.super.a(true);
        }
        if (com.xiaomi.miftp.c.b.b.booleanValue()) {
            this.setRequestedOrientation(-1);
        }
        if ((view = this.findViewById(Resources.getSystem().getIdentifier("list", "id", "android"))) != null) {
            if (!(view instanceof ListView)) {
                return;
            }
            ((ListView)view).setPadding(0, 0, 0, 0);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.b = SystemClock.elapsedRealtime();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.c = true;
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        super.onStart();
    }

    public void setContentView(int n) {
        ViewGroup viewGroup = (ViewGroup)LayoutInflater.from((Context)this).inflate(2131427567, (ViewGroup)new LinearLayout((Context)this), false);
        this.a = (Toolbar)viewGroup.findViewById(2131296284);
        this.a.setNavigationOnClickListener(new View.OnClickListener((a)this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public void onClick(View view) {
                this.a.finish();
            }
        });
        ViewGroup viewGroup2 = (ViewGroup)viewGroup.findViewById(2131296397);
        LayoutInflater.from((Context)this).inflate(n, viewGroup2, true);
        this.getWindow().setContentView((View)viewGroup);
        ag.a((Activity)this, (int)this.getTheme().obtainStyledAttributes(new int[]{2130968695}).getColor(0, this.getResources().getColor(2131099748)));
    }
}

