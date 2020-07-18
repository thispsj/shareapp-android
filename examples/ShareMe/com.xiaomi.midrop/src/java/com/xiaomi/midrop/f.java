/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.ActivityNotFoundException
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Bundle
 *  android.support.v4.content.a
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.ImageView
 *  android.widget.TextView
 *  android.widget.Toast
 *  com.xiaomi.midrop.ScoreDialog
 *  com.xiaomi.midrop.util.Locale.b
 *  com.xiaomi.midrop.util.ac
 *  com.xiaomi.midrop.util.y
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.midrop;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.xiaomi.midrop.ScoreDialog;
import com.xiaomi.midrop.feedback.a;
import com.xiaomi.midrop.util.Locale.b;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.y;

public final class f
extends Dialog {
    private ImageView[] a;
    private TextView b;
    private TextView c;
    private TextView d;
    private int e = -1;
    private int[] f;
    private int[] g;
    private View.OnClickListener h;

    public f(Context context) {
        super(context, 2131755517);
        this.h = new View.OnClickListener((f)this){
            final /* synthetic */ f a;
            {
                this.a = f2;
            }

            public void onClick(View view) {
                int n;
                for (n = 0; n < f.a(this.a).length && f.a(this.a)[n] != view; ++n) {
                }
                f.a(this.a, n);
                f.b(this.a, n);
                f.b(this.a).setEnabled(true);
                f.b(this.a).setTextColor(android.support.v4.content.a.c((Context)this.a.getContext(), (int)2131099800));
                com.xiaomi.midrop.util.af.a((com.xiaomi.midrop.util.af$a)com.xiaomi.midrop.util.af$a.r).a();
            }
        };
    }

    static /* synthetic */ int a(f f2, int n) {
        f2.e = n;
        return n;
    }

    private void a() {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2].setImageResource(this.f[i2]);
        }
    }

    public static void a(Activity activity) {
        new f((Context)activity).show();
    }

    static /* synthetic */ ImageView[] a(f f2) {
        return f2.a;
    }

    static /* synthetic */ TextView b(f f2) {
        return f2.c;
    }

    /*
     * Enabled aggressive block sorting
     */
    static /* synthetic */ void b(f f2, int n) {
        b b2;
        int n2;
        TextView textView;
        f2.a();
        for (int i2 = 0; i2 <= n; ++i2) {
            f2.a[i2].setImageResource(f2.g[n]);
        }
        if (n == -1 + f2.a.length) {
            textView = f2.d;
            b2 = b.a();
            n2 = 2131689637;
        } else {
            textView = f2.d;
            b2 = b.a();
            n2 = 2131689636;
        }
        textView.setText(b2.a(n2));
    }

    static /* synthetic */ int c(f f2) {
        return f2.e;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static /* synthetic */ void d(f var0) {
        var1_1 = var0.getContext().getPackageName();
        var2_2 = new StringBuilder("https://play.google.com/store/apps/details?id=");
        var2_2.append(var1_1);
        var4_3 = Uri.parse((String)var2_2.toString());
        var5_4 = new Intent("android.intent.action.VIEW", var4_3);
        var5_4.setPackage("com.android.vending");
        try {
            block4 : {
                if (var5_4.resolveActivity(var0.getContext().getPackageManager()) == null) break block4;
                var12_5 = var0.getContext();
                ** GOTO lbl17
            }
            var9_6 = new StringBuilder("market://details?id=");
            var9_6.append(var1_1);
            var5_4 = new Intent("android.intent.action.VIEW", Uri.parse((String)var9_6.toString()));
            if (var5_4.resolveActivity(var0.getContext().getPackageManager()) != null) {
                var12_5 = var0.getContext();
lbl17: // 2 sources:
                var12_5.startActivity(var5_4);
            } else {
                var11_7 = new Intent("android.intent.action.VIEW", var4_3);
                var0.getContext().startActivity(var11_7);
            }
        }
        catch (ActivityNotFoundException var7_8) {
            new StringBuilder("ActivityNotFoundException ").append((Object)var7_8);
        }
        Toast.makeText((Context)var0.getContext(), (int)2131689962, (int)1).show();
    }

    static /* synthetic */ void e(f f2) {
        a.a(f2.getContext());
    }

    /*
     * Enabled aggressive block sorting
     */
    protected final void onCreate(Bundle bundle) {
        Drawable drawable2;
        TextView textView;
        super.onCreate(bundle);
        this.setContentView(2131427423);
        WindowManager.LayoutParams layoutParams = this.getWindow().getAttributes();
        layoutParams.width = -1;
        this.getWindow().setAttributes(layoutParams);
        this.setCanceledOnTouchOutside(false);
        this.f = new int[]{2131231144, 2131231146, 2131231148, 2131231150, 2131231152};
        this.g = new int[]{2131231145, 2131231147, 2131231149, 2131231151, 2131231153};
        this.a = new ImageView[5];
        this.a[0] = (ImageView)this.findViewById(2131296702);
        this.a[1] = (ImageView)this.findViewById(2131296703);
        this.a[2] = (ImageView)this.findViewById(2131296704);
        this.a[3] = (ImageView)this.findViewById(2131296705);
        this.a[4] = (ImageView)this.findViewById(2131296706);
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2].setOnClickListener(this.h);
        }
        this.d = (TextView)this.findViewById(2131296659);
        this.b = (TextView)this.findViewById(2131296345);
        this.b.setOnClickListener(new View.OnClickListener((f)this){
            final /* synthetic */ f a;
            {
                this.a = f2;
            }

            public void onClick(View view) {
                this.a.dismiss();
            }
        });
        this.c = (TextView)this.findViewById(2131296638);
        this.c.setOnClickListener(new View.OnClickListener((f)this){
            final /* synthetic */ f a;
            {
                this.a = f2;
            }

            public void onClick(View view) {
                if (f.c(this.a) == -1 + f.a(this.a).length) {
                    f.d(this.a);
                } else if (f.c(this.a) >= 0) {
                    f.e(this.a);
                }
                y.a((int)(1 + f.c(this.a)));
                this.a.dismiss();
                com.xiaomi.midrop.util.af.a((com.xiaomi.midrop.util.af$a)com.xiaomi.midrop.util.af$a.s).a(com.xiaomi.midrop.util.af$b.o, String.valueOf((int)(1 + f.c(this.a)))).a();
            }
        });
        this.c.setEnabled(false);
        this.c.setTextColor(android.support.v4.content.a.c((Context)this.getContext(), (int)2131099933));
        if (ac.c((Context)this.getContext())) {
            this.b.setBackground(android.support.v4.content.a.a((Context)this.getContext(), (int)2131230970));
            textView = this.c;
            drawable2 = android.support.v4.content.a.a((Context)this.getContext(), (int)2131230969);
        } else {
            this.b.setBackground(android.support.v4.content.a.a((Context)this.getContext(), (int)2131230969));
            textView = this.c;
            drawable2 = android.support.v4.content.a.a((Context)this.getContext(), (int)2131230970);
        }
        textView.setBackground(drawable2);
        f.super.a();
        y.c();
    }
}

