/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.os.Environment
 *  android.os.Parcelable
 *  android.os.StatFs
 *  android.support.v7.app.c
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  com.xiaomi.midrop.receiver.ui.ReceiveDialogReceiver
 *  com.xiaomi.midrop.util.af
 *  com.xiaomi.midrop.util.af$a
 *  com.xiaomi.midrop.util.ai
 *  com.xiaomi.midrop.view.ProfileImageView
 *  com.xiaomi.midrop.view.c
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  midrop.b.a.a
 */
package com.xiaomi.midrop.receiver.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Parcelable;
import android.os.StatFs;
import android.support.v7.app.c;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.d;
import com.xiaomi.midrop.receiver.ui.ReceiveDialogReceiver;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.ai;
import com.xiaomi.midrop.view.ProfileImageView;
import java.util.List;

public final class b
extends BroadcastReceiver {
    public Context a;
    public boolean b;
    public boolean c;
    boolean d;
    c e;
    c f;
    private a g;
    private d h;
    private String i;

    public b(Context context, a a2) {
        this.a = context;
        this.g = a2;
        this.b = false;
    }

    static /* synthetic */ a a(b b2) {
        return b2.g;
    }

    static /* synthetic */ boolean a(b b2, boolean bl) {
        b2.b = bl;
        return bl;
    }

    static /* synthetic */ d b(b b2) {
        return b2.h;
    }

    private void c() {
        Intent intent = new Intent("com.xiaomi.midrop.action.CONNECT_DIALOG_SHOWN");
        intent.setPackage("com.xiaomi.midrop");
        this.a.sendBroadcast(intent);
    }

    static /* synthetic */ String d(b b2) {
        return b2.i;
    }

    public final void a() {
        if (this.e != null) {
            this.e.dismiss();
            this.e = null;
        }
    }

    public final void b() {
        if (this.f != null) {
            this.f.dismiss();
            this.f = null;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void onReceive(Context var1, Intent var2_2) {
        block25 : {
            block26 : {
                var3_3 = var2_2.getStringExtra("device_id");
                var4_4 = "miui.intent.action.SHOW_RECEIVE_DIALOG".equals((Object)var2_2.getAction());
                var5_5 = 2131689845;
                var6_6 = 2131427403;
                if (!var4_4) break block25;
                this.g.b();
                this.h = (d)var2_2.getParcelableExtra("dialog_info");
                var15_7 = var2_2.getBooleanExtra("need_confirm", true);
                if (!this.c && var15_7) {
                    if (!TextUtils.isEmpty((CharSequence)var3_3) && !TextUtils.equals((CharSequence)var3_3, (CharSequence)this.i)) {
                        this.b = false;
                    }
                } else {
                    this.b = true;
                }
                this.i = var3_3;
                this.b();
                var16_8 = this.h.d;
                if (com.xiaomi.midrop.common.b.a("file_storage_loction", 0) != 1) break block26;
                var33_9 = ai.b((Context)MiDropApplication.a());
                if (TextUtils.isEmpty((CharSequence)var33_9)) {
                    var35_10 = 0L;
                } else {
                    var34_11 = new StatFs(var33_9);
                    var35_10 = var34_11.getBlockSizeLong() * var34_11.getBlockCountLong();
                }
                if (var16_8 >= var35_10) ** GOTO lbl-1000
                ** GOTO lbl-1000
            }
            if (Environment.getExternalStorageState().equals((Object)"mounted")) {
                var18_13 = new StatFs(Environment.getExternalStorageDirectory().getPath());
                var19_14 = var18_13.getBlockSizeLong() * var18_13.getAvailableBlocksLong();
            } else {
                var19_14 = -1L;
            }
            if (var16_8 < var19_14) lbl-1000: // 2 sources:
            {
                var21_12 = true;
            } else lbl-1000: // 2 sources:
            {
                var21_12 = false;
            }
            this.d = var21_12;
            if (var21_12 && this.b) {
                this.b = this.g.a(this.h.c, this.h.b);
            } else {
                var22_15 = new Intent("miui.intent.action.GARBAGE_CLEANUP");
                var23_16 = this.a.getPackageManager().queryIntentActivities(var22_15, 0).size() > 0;
                var24_17 = new com.xiaomi.midrop.view.c(this.a);
                var24_17.h = false;
                var24_17.b().c(var6_6);
                if (!var21_12) {
                    if (var23_16) {
                        var24_17.b(2131689830, new View.OnClickListener((b)this){
                            final /* synthetic */ b a;
                            {
                                this.a = b2;
                            }

                            public void onClick(View view) {
                                b.a(this.a).c();
                            }
                        });
                    }
                    var5_5 = 2131689718;
                } else {
                    var24_17.b(2131689828, new View.OnClickListener((b)this){
                        final /* synthetic */ b a;
                        {
                            this.a = b2;
                        }

                        public void onClick(View view) {
                            b.a(this.a, b.a(this.a).a(b.b((b)this.a).c, b.b((b)this.a).b));
                            af.a((af.a)af.a.aD).a();
                        }
                    });
                }
                var24_17.a(var5_5, new View.OnClickListener((b)this){
                    final /* synthetic */ b a;
                    {
                        this.a = b2;
                    }

                    public void onClick(View view) {
                        af.a((af.a)af.a.aE).a();
                        b.a(this.a).e();
                    }
                });
                this.f = var24_17.d();
                if (this.f != null) {
                    this.f.setOnDismissListener(new DialogInterface.OnDismissListener(){

                        public final void onDismiss(DialogInterface dialogInterface) {
                            b.this.f = null;
                        }
                    });
                }
                var24_17.d(2131296812).setVisibility(8);
                ((ProfileImageView)var24_17.d(2131296452)).a(this.i, this.h.b);
                var28_18 = (TextView)var24_17.d(2131296814);
                var29_19 = this.a;
                var30_20 = new Object[]{this.h.b};
                var28_18.setText((CharSequence)var29_19.getString(2131690031, var30_20));
                var31_21 = (TextView)var24_17.d(2131296788);
                if (!var21_12) {
                    if (!var23_16) {
                        var24_17.d(2131296426).setVisibility(8);
                        var24_17.d(2131296653).setVisibility(8);
                    }
                    this.g.d();
                    var31_21.setTextColor(this.a.getResources().getColor(2131100033));
                    var31_21.setText(2131689835);
                    var31_21.setVisibility(0);
                } else {
                    var31_21.setVisibility(8);
                }
                b.super.c();
            }
            af.a((af.a)af.a.aC).a();
            return;
        }
        if ("miui.intent.action.SHOW_CONNECT_DIALOG".equals((Object)var2_2.getAction()) == false) return;
        if (!var2_2.getBooleanExtra("need_confirm", true)) {
            this.b = true;
        } else if (!TextUtils.isEmpty((CharSequence)var3_3) && !TextUtils.equals((CharSequence)var3_3, (CharSequence)this.i)) {
            this.b = false;
        }
        this.h = (d)var2_2.getParcelableExtra("dialog_info");
        this.i = var3_3;
        var7_22 = midrop.b.a.a.a((String)this.h.a);
        if (this.b && !var7_22) {
            this.b = this.g.a(this.h.b, this.i, true);
            return;
        }
        var8_23 = new com.xiaomi.midrop.view.c(this.a);
        if (var7_22) {
            var6_6 = 2131427404;
        }
        var9_24 = var8_23.c(var6_6);
        var9_24.i = 80;
        var9_24.h = false;
        var9_24.b().a(var5_5, new View.OnClickListener((b)this){
            final /* synthetic */ b a;
            {
                this.a = b2;
            }

            public void onClick(View view) {
                b.a(this.a).f();
            }
        }).b(2131689828, new View.OnClickListener((b)this){
            final /* synthetic */ b a;
            {
                this.a = b2;
            }

            public void onClick(View view) {
                b.a(this.a, b.a(this.a).a(b.b((b)this.a).b, b.d(this.a), false));
            }
        });
        this.e = var8_23.d();
        if (this.e != null) {
            this.e.setOnDismissListener(new DialogInterface.OnDismissListener(){

                public final void onDismiss(DialogInterface dialogInterface) {
                    b.this.e = null;
                }
            });
        }
        var8_23.d(2131296812).setVisibility(8);
        ((ProfileImageView)var8_23.d(2131296452)).a(this.i, this.h.b);
        var11_25 = (TextView)var8_23.d(2131296814);
        var12_26 = this.a;
        var13_27 = new Object[]{this.h.b};
        var11_25.setText((CharSequence)var12_26.getString(2131690031, var13_27));
        if (var7_22) {
            var14_28 = (TextView)var8_23.d(2131296383);
            var14_28.setVisibility(0);
            var8_23.d(2131296382).setVisibility(0);
            var14_28.setText((CharSequence)String.valueOf((Object)this.h.a));
        }
        b.super.c();
    }

    public static interface a {
        public boolean a(String var1, String var2);

        public boolean a(String var1, String var2, boolean var3);

        public void b();

        public void c();

        public void d();

        public void e();

        public void f();
    }

}

