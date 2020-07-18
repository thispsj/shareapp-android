/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.support.v4.content.a
 *  android.support.v7.app.c
 *  android.support.v7.app.c$a
 *  android.text.TextUtils
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.TextView
 *  com.xiaomi.midrop.view.CustomDialogBuilder
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.xiaomi.midrop.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a;
import android.support.v7.app.c;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.view.CustomDialogBuilder;

public final class c {
    public CharSequence a;
    public CharSequence b;
    View.OnClickListener c;
    View.OnClickListener d;
    public View e;
    public View f;
    Context g;
    public boolean h = true;
    public int i = 80;
    public int j = 0;
    private CharSequence k;
    private CharSequence l;
    private View m;
    private View n;
    private Boolean o = null;
    private Boolean p = false;

    public c(Context context) {
        this.g = context;
    }

    public final c a() {
        this.j = 2;
        return this;
    }

    public final c a(int n2) {
        this.a = this.g.getString(n2);
        return this;
    }

    public final c a(int n2, View.OnClickListener onClickListener) {
        return this.a(this.g.getString(n2), onClickListener);
    }

    public final c a(View view) {
        this.f = view;
        return this;
    }

    public final c a(CharSequence charSequence) {
        this.b = charSequence;
        return this;
    }

    public final c a(String string2, View.OnClickListener onClickListener) {
        this.k = string2;
        this.c = onClickListener;
        return this;
    }

    public final c b() {
        this.o = false;
        return this;
    }

    public final c b(int n2) {
        this.b = this.g.getString(n2);
        return this;
    }

    public final c b(int n2, View.OnClickListener onClickListener) {
        return this.b(this.g.getString(n2), onClickListener);
    }

    public final c b(String string2, View.OnClickListener onClickListener) {
        this.l = string2;
        this.d = onClickListener;
        return this;
    }

    public final c c() {
        this.p = true;
        return this;
    }

    public final c c(int n2) {
        this.f = LayoutInflater.from((Context)this.g).inflate(n2, null);
        return this;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final android.support.v7.app.c d() {
        block20 : {
            var1_1 = new c.a(this.g);
            var1_1.a(this.h);
            var3_2 = var1_1.a();
            try {
                var3_2.show();
                if (this.o == null) break block20;
            }
            catch (Exception var4_13) {
                var4_13.printStackTrace();
                return null;
            }
            var3_2.setCanceledOnTouchOutside(this.o.booleanValue());
        }
        var5_3 = var3_2.getWindow().getAttributes();
        var5_3.width = -1;
        var5_3.gravity = this.i;
        var3_2.getWindow().setAttributes(var5_3);
        var3_2.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
        var3_2.setContentView(2131427406);
        this.m = var3_2.findViewById(2131296427);
        var6_4 = (TextView)var3_2.findViewById(2131296810);
        var7_5 = (TextView)var3_2.findViewById(2131296608);
        var8_6 = (TextView)var3_2.findViewById(2131296623);
        var9_7 = (ViewGroup)var3_2.findViewById(2131296582);
        this.n = var8_6;
        var10_8 = (TextView)var3_2.findViewById(2131296653);
        switch (this.j) {
            default: {
                break;
            }
            case 2: {
                var11_9 = this.g;
                var12_10 = 2131099801;
                ** break;
            }
            case 1: {
                var11_9 = this.g;
                var12_10 = 2131099808;
lbl35: // 2 sources:
                var10_8.setTextColor(a.c((Context)var11_9, (int)var12_10));
            }
        }
        this.e = var10_8;
        if (TextUtils.isEmpty((CharSequence)this.a)) {
            var6_4.setVisibility(8);
        } else {
            var6_4.setText(this.a);
        }
        var7_5.setHighlightColor(0);
        var7_5.setMovementMethod(LinkMovementMethod.getInstance());
        if (TextUtils.isEmpty((CharSequence)this.b)) {
            var7_5.setVisibility(8);
        } else {
            var7_5.setText(this.b);
            if (TextUtils.isEmpty((CharSequence)this.a)) {
                var7_5.setTextSize(0, this.g.getResources().getDimension(2131165419));
                var7_5.setAlpha(1.0f);
            }
            var7_5.post(new Runnable(){

                public final void run() {
                    if (var7_5.getLineCount() > 1) {
                        var7_5.setTextSize(0, c.this.g.getResources().getDimension(2131165420));
                        var7_5.setAlpha(0.6f);
                    }
                }
            });
        }
        if (TextUtils.isEmpty((CharSequence)this.k)) {
            var8_6.setText(2131689547);
        } else {
            var8_6.setText(this.k);
        }
        var8_6.setOnClickListener(new View.OnClickListener(this, var3_2){
            final /* synthetic */ android.support.v7.app.c a;
            final /* synthetic */ c b;
            {
                this.b = c2;
                this.a = c3;
            }

            public void onClick(View view) {
                this.a.dismiss();
                if (this.b.c != null) {
                    this.b.c.onClick(view);
                }
            }
        });
        if (this.p.booleanValue()) {
            var10_8.setVisibility(8);
            var3_2.findViewById(2131296426).setVisibility(8);
        } else if (TextUtils.isEmpty((CharSequence)this.l)) {
            var10_8.setText(2131690021);
        } else {
            var10_8.setText(this.l);
        }
        var10_8.setOnClickListener(new View.OnClickListener(this, var3_2){
            final /* synthetic */ android.support.v7.app.c a;
            final /* synthetic */ c b;
            {
                this.b = c2;
                this.a = c3;
            }

            public void onClick(View view) {
                this.a.dismiss();
                if (this.b.d != null) {
                    this.b.d.onClick(view);
                }
            }
        });
        if (ac.c(this.g)) {
            var8_6.setBackground(a.a((Context)this.g, (int)2131230970));
            var14_11 = a.a((Context)this.g, (int)2131230969);
        } else {
            var8_6.setBackground(a.a((Context)this.g, (int)2131230969));
            var14_11 = a.a((Context)this.g, (int)2131230970);
        }
        var10_8.setBackground(var14_11);
        if (this.f == null) {
            var15_12 = var9_7.getLayoutParams();
            var15_12.height = com.xiaomi.midrop.sender.c.c.a(this.g, 27.2f);
            var9_7.setLayoutParams(var15_12);
            return var3_2;
        }
        var9_7.addView(this.f);
        return var3_2;
    }

    public final View d(int n2) {
        if (this.m != null) {
            return this.m.findViewById(n2);
        }
        return null;
    }

    public final View e() {
        return this.n;
    }

}

