/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.res.Resources
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.util.zip.ZipEntry
 *  java.util.zip.ZipFile
 */
package com.xiaomi.midrop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.midrop.ShareActivity;
import com.xiaomi.midrop.ShareViaQRCodeActivity;
import com.xiaomi.midrop.coolboot.activity.CoolBootActivity;
import com.xiaomi.midrop.e;
import com.xiaomi.midrop.share.ShareViaBluetoothActivity;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.util.y;
import com.xiaomi.miftp.c.f;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import midrop.service.c.d;

public class ShareActivity
extends a
implements View.OnClickListener {
    private static final String a = "com.xiaomi.midrop.ShareActivity";
    private b b;
    private View c;
    private TextView d;
    private ViewGroup e;
    private ViewGroup f;

    public static final void a(Activity activity, String string2) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setPackage("com.facebook.katana");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", string2);
            intent.putExtra("com.facebook.platform.extra.APPLICATION_ID", activity.getString(2131689658));
            activity.startActivity(intent);
            return;
        }
        catch (Exception exception) {
            String string3 = a;
            StringBuilder stringBuilder = new StringBuilder("facebookShare:");
            stringBuilder.append((Object)exception);
            d.b(string3, stringBuilder.toString(), new Object[0]);
            return;
        }
    }

    private boolean a() {
        String string2 = this.getApplicationInfo().sourceDir;
        try {
            ZipEntry zipEntry = new ZipFile(string2).getEntry("classes.dex");
            return zipEntry != null;
        }
        catch (IOException iOException) {
            d.a(a, "isSupportShareMiDrop", iOException, new Object[0]);
            return false;
        }
    }

    static /* synthetic */ boolean a(ShareActivity shareActivity) {
        return shareActivity.a();
    }

    static /* synthetic */ View b(ShareActivity shareActivity) {
        return shareActivity.c;
    }

    public static final void b(Activity activity, String string2) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setPackage("com.whatsapp");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", string2);
            activity.startActivity(intent);
            return;
        }
        catch (Exception exception) {
            String string3 = a;
            StringBuilder stringBuilder = new StringBuilder("whatsAppShare:");
            stringBuilder.append((Object)exception);
            d.b(string3, stringBuilder.toString(), new Object[0]);
            return;
        }
    }

    static /* synthetic */ TextView c(ShareActivity shareActivity) {
        return shareActivity.d;
    }

    static /* synthetic */ ViewGroup d(ShareActivity shareActivity) {
        return shareActivity.e;
    }

    protected void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
    }

    public void onClick(View view) {
        block7 : {
            af.a a2;
            block8 : {
                Intent intent;
                int n2 = view.getId();
                if (n2 == 2131296485) break block7;
                switch (n2) {
                    default: {
                        a2 = null;
                        break block8;
                    }
                    case 2131296575: {
                        a2 = af.a.bo;
                        ShareActivity.b((Activity)this, "https://play.google.com/store/apps/details?id=com.xiaomi.midrop&referrer=utm_source%3Dsocialmedia%26utm_medium%3Dinapp\n\n");
                        this.findViewById(2131296632).setVisibility(8);
                        y.a(false);
                        break block8;
                    }
                    case 2131296574: {
                        a2 = af.a.bl;
                        intent = new Intent((Context)this, CoolBootActivity.class);
                        break;
                    }
                    case 2131296573: {
                        a2 = af.a.bq;
                        intent = new Intent((Context)this, ShareViaQRCodeActivity.class);
                        break;
                    }
                    case 2131296572: {
                        a2 = af.a.br;
                        Intent intent2 = new Intent();
                        intent2.setAction("android.intent.action.SEND");
                        intent2.putExtra("android.intent.extra.TEXT", "https://play.google.com/store/apps/details?id=com.xiaomi.midrop&referrer=utm_source%3Dsocialmedia%26utm_medium%3Dinapp");
                        intent2.setType("text/plain");
                        intent = Intent.createChooser((Intent)intent2, (CharSequence)"");
                        break;
                    }
                    case 2131296571: {
                        a2 = af.a.bm;
                        intent = new Intent((Context)this, ShareViaBluetoothActivity.class);
                    }
                }
                this.startActivity(intent);
            }
            af.a(af.a.bk).a();
            af.a(a2).a();
            return;
        }
        this.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131427377);
        this.c = this.findViewById(2131296750);
        this.e = (ViewGroup)this.findViewById(2131296745);
        this.d = (TextView)this.findViewById(2131296751);
        this.f = (ViewGroup)this.findViewById(2131296749);
        if (am.a()) {
            this.d.setVisibility(8);
            this.f.setVisibility(8);
        }
        this.b = b.a();
        this.c(2131427429);
        View view = this.t();
        view.setBackgroundColor(this.getResources().getColor(2131100072));
        ag.a((Activity)this, this.getResources().getColor(2131100072));
        ((TextView)view.findViewById(2131296810)).setText(this.b.a(2131689618));
        View view2 = view.findViewById(2131296485);
        view2.setOnClickListener((View.OnClickListener)this);
        if (ac.c((Context)this)) {
            view2.setRotation(180.0f);
        }
        af.a(af.a.bu).a();
        if (e.c()) {
            new AsyncTask<Void, Void, Boolean>((ShareActivity)this){
                final /* synthetic */ ShareActivity a;
                {
                    this.a = shareActivity;
                }

                protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                    return ShareActivity.a(this.a);
                }

                protected final /* synthetic */ void onPostExecute(Object object) {
                    if (!((Boolean)object).booleanValue()) {
                        ShareActivity.b(this.a).setVisibility(8);
                        ShareActivity.c(this.a).setVisibility(8);
                        ShareActivity.d(this.a).setVisibility(8);
                    }
                }
            }.execute((Object[])new Void[0]);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (f.a("com.whatsapp")) {
            this.findViewById(2131296575).setVisibility(0);
            if (y.f()) {
                this.findViewById(2131296632).setVisibility(0);
            }
            af.a(af.a.bj).a();
        }
    }
}

