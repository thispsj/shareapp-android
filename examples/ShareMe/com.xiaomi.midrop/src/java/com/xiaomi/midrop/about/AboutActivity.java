/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$h
 *  android.support.v7.widget.RecyclerView$i
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  android.widget.Toast
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 */
package com.xiaomi.midrop.about;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.about.AboutActivity;
import com.xiaomi.midrop.about.a;
import com.xiaomi.midrop.about.b;
import com.xiaomi.midrop.update.c;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.util.y;
import com.xiaomi.miftp.c.f;
import java.lang.ref.WeakReference;

public class AboutActivity
extends com.xiaomi.midrop.util.Locale.a {
    private boolean a = false;
    private Toast b;
    private View.OnClickListener c = new View.OnClickListener(this){
        final /* synthetic */ AboutActivity a;
        {
            this.a = aboutActivity;
        }

        public void onClick(View view) {
            this.a.onBackPressed();
        }
    };
    private com.xiaomi.midrop.about.a d = null;
    private boolean e = y.h();
    private boolean f = y.i();

    private void a(int n2, int n3) {
        if (this.b != null) {
            this.b.cancel();
        }
        this.b = Toast.makeText((Context)this, (CharSequence)com.xiaomi.midrop.util.Locale.b.a().b(n2), (int)n3);
        this.b.show();
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, AboutActivity.class));
    }

    static /* synthetic */ void a(AboutActivity aboutActivity) {
        if (aboutActivity.a) {
            aboutActivity.a(2131689559, 1);
            return;
        }
        aboutActivity.a = true;
        new AsyncTask<Void, Void, Boolean>(aboutActivity){
            private WeakReference<AboutActivity> a;
            {
                this.a = new WeakReference((Object)aboutActivity);
            }

            protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                return am.a(MiDropApplication.a());
            }

            protected final /* synthetic */ void onPostExecute(Object object) {
                Boolean bl = (Boolean)object;
                super.onPostExecute((Object)bl);
                AboutActivity aboutActivity = (AboutActivity)((Object)this.a.get());
                if (aboutActivity != null && !aboutActivity.isDestroyed()) {
                    if (aboutActivity.isFinishing()) {
                        return;
                    }
                    if (bl.booleanValue()) {
                        AboutActivity.e(aboutActivity);
                        return;
                    }
                    aboutActivity.a = false;
                    aboutActivity.a(2131689763, 0);
                }
            }
        }.execute((Object[])new Void[0]);
    }

    static /* synthetic */ void b(AboutActivity aboutActivity) {
        aboutActivity.toServiceWebPage();
    }

    static /* synthetic */ void c(AboutActivity aboutActivity) {
        aboutActivity.toPrivacyWebPage();
    }

    static /* synthetic */ void d(AboutActivity aboutActivity) {
        Intent intent = com.xiaomi.midrop.about.a.c();
        if (f.a(intent) != null) {
            aboutActivity.startActivity(intent);
        }
    }

    static /* synthetic */ void e(AboutActivity aboutActivity) {
        if (c.a()) {
            c.a((Activity)aboutActivity);
            aboutActivity.a = false;
            return;
        }
        aboutActivity.a(2131689559, 1);
        c.a((Activity)aboutActivity, new c.a(aboutActivity, (Activity)aboutActivity){
            final /* synthetic */ Activity a;
            final /* synthetic */ AboutActivity b;
            {
                this.b = aboutActivity;
                this.a = activity;
            }

            public final void a(String string2, boolean bl) {
                AboutActivity.f(this.b);
                if (!this.a.isFinishing()) {
                    if (this.a.isDestroyed()) {
                        return;
                    }
                    if (bl) {
                        AboutActivity.a(this.b, 2131689763);
                        return;
                    }
                    if (android.text.TextUtils.isEmpty((CharSequence)string2)) {
                        AboutActivity.a(this.b, 2131689772);
                        return;
                    }
                    AboutActivity.g(this.b).c(1);
                }
            }
        });
    }

    static /* synthetic */ com.xiaomi.midrop.about.a g(AboutActivity aboutActivity) {
        return aboutActivity.d;
    }

    private void toPrivacyWebPage() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)am.g()));
        if (f.a(intent) != null) {
            this.startActivity(intent);
        }
    }

    private void toServiceWebPage() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)com.xiaomi.midrop.util.Locale.b.a().b(2131690019)));
        if (f.a(intent) != null) {
            this.startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131427361);
        this.c(2131427429);
        View view = this.t();
        View view2 = view.findViewById(2131296485);
        if (ac.c((Context)this)) {
            view2.setRotation(180.0f);
        }
        view2.setOnClickListener(this.c);
        TextView textView = (TextView)view.findViewById(2131296810);
        textView.setText(com.xiaomi.midrop.util.Locale.b.a().a(2131689503));
        textView.setOnClickListener(this.c);
        this.d = new com.xiaomi.midrop.about.a((Context)this, new a.e((AboutActivity)this){
            final /* synthetic */ AboutActivity a;
            {
                this.a = aboutActivity;
            }

            public final void onClick(long l2) {
                if (l2 == 2131296278L) {
                    AboutActivity.a(this.a);
                    return;
                }
                if (l2 == 2131296277L) {
                    AboutActivity.b(this.a);
                    return;
                }
                if (l2 == 2131296276L) {
                    AboutActivity.c(this.a);
                    return;
                }
                if (l2 == 2131296272L) {
                    AboutActivity.d(this.a);
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView)this.findViewById(2131296676);
        recyclerView.a((RecyclerView.h)new b((Context)this));
        recyclerView.setLayoutManager((RecyclerView.i)new LinearLayoutManager((Context)this, 1, false));
        recyclerView.setAdapter((RecyclerView.a)this.d);
    }

    @Override
    protected void onDestroy() {
        if (this.b != null) {
            this.b.cancel();
        }
        if (this.e && !y.h()) {
            af.a(af.a.cQ).a();
        }
        if (this.f && !y.i()) {
            af.a(af.a.cX).a();
        }
        super.onDestroy();
    }

}

