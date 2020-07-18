/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.graphics.drawable.Drawable
 *  android.os.AsyncTask
 *  android.support.v7.widget.GridLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$b
 *  android.support.v7.widget.RecyclerView$h
 *  android.support.v7.widget.RecyclerView$i
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  com.xiaomi.midrop.b.b
 *  com.xiaomi.midrop.receiver.ui.ReceiveAdapter
 *  com.xiaomi.midrop.receiver.ui.a$1
 *  com.xiaomi.midrop.receiver.ui.a$2
 *  com.xiaomi.midrop.receiver.ui.a$3
 *  com.xiaomi.midrop.receiver.ui.a$a
 *  com.xiaomi.midrop.receiver.ui.a$b
 *  com.xiaomi.midrop.receiver.ui.a$c
 *  com.xiaomi.midrop.receiver.ui.a$d
 *  com.xiaomi.midrop.receiver.ui.c
 *  com.xiaomi.midrop.util.a
 *  com.xiaomi.midrop.util.a$1
 *  com.xiaomi.midrop.util.a$a
 *  com.xiaomi.midrop.util.ac
 *  com.xiaomi.midrop.util.g
 *  com.xiaomi.midrop.util.h
 *  com.xiaomi.midrop.util.j
 *  com.xiaomi.midrop.view.CircleProgressBar
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.util.List
 *  java.util.concurrent.Executor
 */
package com.xiaomi.midrop.receiver.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.receiver.ui.ReceiveAdapter;
import com.xiaomi.midrop.receiver.ui.a;
import com.xiaomi.midrop.receiver.ui.c;
import com.xiaomi.midrop.send.contacts.a;
import com.xiaomi.midrop.util.a;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.h;
import com.xiaomi.midrop.util.j;
import com.xiaomi.midrop.view.CircleProgressBar;
import java.util.List;
import java.util.concurrent.Executor;

/*
 * Exception performing whole class analysis.
 */
public final class a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    Context h;
    f i;
    public boolean j;
    private int k;
    private LayoutInflater l;
    private double[] m;
    private com.xiaomi.midrop.util.a n;

    public a(Context context, int n2) {
        this.m = new double[]{2.5, 2.35, 1.55, 1.15, 1.0};
        this.h = context;
        this.k = n2;
        this.l = LayoutInflater.from((Context)this.h);
        this.a = this.h.getResources().getDimensionPixelSize(2131165742);
        this.b = this.h.getResources().getDimensionPixelSize(2131165757);
        this.f = this.h.getResources().getDimensionPixelSize(2131165743);
        this.g = this.h.getResources().getDimensionPixelSize(2131165733);
        this.d = this.h.getResources().getDimensionPixelSize(2131165734);
        this.c = ac.b((Context)this.h).x - 2 * this.d - this.b - this.g;
        this.e = (this.c - 2 * this.f - 4 * this.a) / 5;
        this.n = new com.xiaomi.midrop.util.a();
        new a.1(this.n).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void a(a var1_4, com.xiaomi.midrop.b.b var2_5, int var3_2, boolean var4_3, boolean var5_1) {
        block40 : {
            block39 : {
                var6_6 = var1_4 instanceof c;
                var7_7 = 5;
                var8_8 = 1;
                if (!var6_6) break block39;
                if (var2_5.b.size() < var7_7) {
                    var8_8 = 0;
                }
                var52_9 = var4_3 | var8_8;
                var53_10 = var1_4;
                var54_11 = var2_5.d;
                var55_12 = c.a(var53_10);
                var56_13 = c.b(var53_10);
                if (var55_12 == null) {
                    var55_12 = new com.xiaomi.midrop.receiver.ui.c(this.h);
                    var55_12.d = 15;
                    c.a(var53_10, (com.xiaomi.midrop.receiver.ui.c)var55_12);
                    var56_13 = new GridLayoutManager(this.h, 15);
                    c.a(var53_10, (GridLayoutManager)var56_13);
                    c.c(var53_10).a((RecyclerView.h)new /* Unavailable Anonymous Inner Class!! */);
                }
                var55_12.f = new 1(this, var2_5);
                if (c.d(var53_10) == var2_5) {
                    if (var5_1) {
                        var55_12.a.b();
                    } else if (var54_11 < 15) {
                        var55_12.c(var54_11);
                    }
                } else {
                    if (var52_9) {
                        var53_10.p.setVisibility(0);
                        if (var2_5.b.size() > 15) {
                            c.e(var53_10).setVisibility(0);
                        } else {
                            c.e(var53_10).setVisibility(8);
                        }
                        c.e(var53_10).setOnClickListener(new View.OnClickListener(this, var2_5){
                            final /* synthetic */ com.xiaomi.midrop.b.b a;
                            final /* synthetic */ a b;
                            {
                                this.b = a2;
                                this.a = b2;
                            }

                            public void onClick(View view) {
                                com.xiaomi.midrop.TransferGridViewActivity.a((Context)this.b.h, (List)this.a.b);
                                com.xiaomi.midrop.util.af.a((com.xiaomi.midrop.util.af$a)com.xiaomi.midrop.util.af$a.bU).a();
                            }
                        });
                    } else {
                        var53_10.p.setVisibility(8);
                    }
                    var55_12.c = var2_5.b;
                    var59_14 = var55_12.a();
                    var60_15 = (int)Math.ceil((double)(Math.max((double)var59_14, (double)5.0) / 5.0));
                    if (!var52_9) {
                        var7_7 = Math.min((int)var7_7, (int)var59_14);
                    }
                    var55_12.e = var61_16 = (int)(this.m[var7_7 - 1] * (double)this.e);
                    var62_17 = new LinearLayout.LayoutParams(c.c(var53_10).getLayoutParams());
                    var62_17.width = var7_7 * (var61_16 + this.a) - this.a;
                    var62_17.height = var60_15 * (var61_16 + this.a);
                    c.c(var53_10).setLayoutParams((ViewGroup.LayoutParams)var62_17);
                    var56_13.a(var7_7);
                    c.c(var53_10).setAdapter((RecyclerView.a)var55_12);
                    c.c(var53_10).setLayoutManager((RecyclerView.i)var56_13);
                    c.a(var53_10, (com.xiaomi.midrop.b.b)var2_5);
                }
                var10_18 = var52_9;
                break block40;
            }
            var9_19 = var3_2 == 0;
            var10_18 = var4_3 & var9_19;
            var11_20 = var1_4;
            var12_21 = (com.xiaomi.midrop.b.b)var2_5.b.get(var3_2);
            d.a(var11_20).setScaleType(ImageView.ScaleType.CENTER_CROP);
            d.b(var11_20).setVisibility(8);
            if (var12_21.a) {
                d.a(var11_20).setImageResource(2131230988);
            } else if (!TextUtils.isEmpty((CharSequence)var12_21.j)) {
                d.a(var11_20).setScaleType(ImageView.ScaleType.CENTER_CROP);
                var48_22 = this.h;
                var49_23 = d.a(var11_20);
                var50_24 = var12_21.j;
                if (!TextUtils.isEmpty((CharSequence)var50_24)) {
                    var51_25 = j.d((String)var50_24);
                    if (com.xiaomi.midrop.util.g.d((String)var51_25)) {
                        h.b((Context)var48_22, (ImageView)var49_23, (String)var50_24, (int)2131231006);
                    } else if (com.xiaomi.midrop.util.g.b((String)var51_25)) {
                        h.a((Context)var48_22, (ImageView)var49_23, (String)var50_24);
                    } else {
                        h.b((Context)var48_22, (ImageView)var49_23, (String)var50_24);
                    }
                }
                if (var2_5.g == 2) {
                    d.b(var11_20).setVisibility(0);
                }
            } else if (com.xiaomi.midrop.util.g.a((String)j.d((String)var12_21.i))) {
                h.b((Context)this.h, (ImageView)d.a(var11_20), (String)var12_21.i);
            } else {
                h.c((Context)this.h, (ImageView)d.a(var11_20), (String)var12_21.i, (int)h.b((String)var12_21.i));
            }
            d.c(var11_20).setText((CharSequence)var12_21.k);
            d.d(var11_20).setOnClickListener(new View.OnClickListener(this, var12_21){
                final /* synthetic */ com.xiaomi.midrop.b.b a;
                final /* synthetic */ a b;
                {
                    this.b = a2;
                    this.a = b2;
                }

                public void onClick(View view) {
                    int n2 = this.a.m;
                    int n3 = 1;
                    if (n2 != 2 && n2 != n3) {
                        n3 = 0;
                    }
                    if (this.b.i != null && n3 != 0) {
                        this.b.i.a(this.b.h, this.a);
                    }
                }
            });
            var13_26 = var12_21.z == g.a.a;
            d.e(var11_20).setProgressColor(2131100021);
            var14_27 = d.e(var11_20);
            var15_28 = var13_26 != false ? 2131100025 : 2131100024;
            var14_27.setRingOuterColor(var15_28);
            d.f(var11_20).setTag((Object)var12_21);
            d.g(var11_20).setVisibility(8);
            switch (var12_21.m) {
                default: {
                    break;
                }
                case 5: {
                    d.f(var11_20).setVisibility(8);
                    d.d(var11_20).setVisibility(8);
                    d.d(var11_20).setImageDrawable(null);
                    d.d(var11_20).setOnClickListener(null);
                    d.i(var11_20).setVisibility(8);
                    d.h(var11_20).setVisibility(0);
                    var11_20.o.setOnClickListener(null);
                    d.h(var11_20).setText((CharSequence)this.h.getString(2131690001));
                    d.e(var11_20).setVisibility(8);
                    break;
                }
                case 4: {
                    d.f(var11_20).setVisibility(8);
                    d.d(var11_20).setVisibility(0);
                    d.d(var11_20).setImageResource(2131231104);
                    d.d(var11_20).setOnClickListener(null);
                    d.h(var11_20).setVisibility(8);
                    var11_20.o.setOnClickListener(null);
                    d.e(var11_20).setVisibility(0);
                    d.e(var11_20).setProgressColor(2131100023);
                    d.i(var11_20).setVisibility(0);
                    if (var12_21.b() > 0L) {
                        var42_29 = d.e(var11_20);
                        var43_30 = var12_21.a() == 0L ? 0 : (int)(100L * var12_21.b() / var12_21.a());
                        var42_29.setProgress(var43_30);
                        var40_31 = d.i(var11_20);
                        var44_32 = new StringBuilder();
                        var44_32.append(j.b((long)var12_21.b()));
                        var44_32.append("/");
                        var44_32.append(j.b((long)var12_21.a()));
                        var41_33 = var44_32.toString();
                    } else {
                        d.e(var11_20).setProgress(0);
                        var40_31 = d.i(var11_20);
                        var41_33 = j.b((long)var12_21.a());
                    }
                    var40_31.setText((CharSequence)var41_33);
                    if (var12_21.n != var8_8) break;
                    d.h(var11_20).setVisibility(0);
                    var11_20.o.setAlpha(0.3f);
                    d.h(var11_20).setText((CharSequence)this.h.getString(2131689550));
                    d.d(var11_20).setImageDrawable(null);
                    break;
                }
                case 3: {
                    var30_34 = var12_21.j;
                    d.d(var11_20).setOnClickListener(null);
                    d.h(var11_20).setVisibility(8);
                    d.i(var11_20).setVisibility(0);
                    d.i(var11_20).setText((CharSequence)j.b((long)var12_21.a()));
                    var11_20.o.setAlpha(1.0f);
                    d.e(var11_20).setVisibility(8);
                    var31_35 = new View.OnClickListener(this, var13_26, var12_21, var11_20, var30_34){
                        final /* synthetic */ boolean a;
                        final /* synthetic */ com.xiaomi.midrop.b.b b;
                        final /* synthetic */ d c;
                        final /* synthetic */ String d;
                        final /* synthetic */ a e;
                        {
                            this.e = a2;
                            this.a = bl;
                            this.b = b2;
                            this.c = d2;
                            this.d = string2;
                        }

                        public void onClick(View view) {
                            if (this.e.j) {
                                if (this.a && this.b.E == 0) {
                                    return;
                                }
                                if (com.xiaomi.midrop.util.g.h((String)this.b.i)) {
                                    if (!this.a) {
                                        d.f(this.c).setVisibility(8);
                                        d.g(this.c).setText(2131689722);
                                        d.g(this.c).setVisibility(0);
                                        if (this.e.h instanceof com.xiaomi.midrop.util.Locale.a) {
                                            ((com.xiaomi.midrop.util.Locale.a)this.e.h).a(this.b.j, (com.xiaomi.midrop.send.contacts.a$c)new com.xiaomi.midrop.receiver.ui.ReceiveAdapter$4$1(this));
                                        }
                                    }
                                } else {
                                    com.xiaomi.midrop.transmission.a.a(this.e.h, (g)this.b, this.b.a);
                                }
                                com.xiaomi.midrop.util.af.a((com.xiaomi.midrop.util.af$a)com.xiaomi.midrop.util.af$a.bV).a(com.xiaomi.midrop.util.af$b.D, j.a((String)this.d, (boolean)this.b.a)).a();
                            }
                        }
                    };
                    var32_36 = j.d((String)var12_21.i);
                    if (var13_26) ** GOTO lbl188
                    d.f(var11_20).setVisibility(0);
                    d.d(var11_20).setVisibility(8);
                    d.f(var11_20).setOnClickListener(var31_35);
                    var11_20.o.setOnClickListener(null);
                    if (!com.xiaomi.midrop.util.g.d((String)var32_36)) ** GOTO lbl162
                    if (var12_21.E >= 0) ** GOTO lbl158
                    d.f(var11_20).setVisibility(8);
                    var33_37 = this.n;
                    var34_38 = new 2(this, var11_20);
                    ** GOTO lbl195
lbl158: // 1 sources:
                    var35_39 = this.h;
                    var36_40 = d.f(var11_20);
                    var37_41 = var12_21.E;
                    ** GOTO lbl184
lbl162: // 1 sources:
                    if (com.xiaomi.midrop.util.g.b((String)var32_36) || com.xiaomi.midrop.util.g.a((String)var32_36)) ** GOTO lbl186
                    if (!com.xiaomi.midrop.util.g.h((String)var12_21.i)) ** GOTO lbl181
                    if (!com.xiaomi.midrop.send.contacts.a.a(var12_21.j)) ** GOTO lbl170
                    d.f(var11_20).setVisibility(8);
                    d.g(var11_20).setVisibility(0);
                    var38_42 = d.g(var11_20);
                    var39_43 = 2131689721;
                    ** GOTO lbl175
lbl170: // 1 sources:
                    if (!com.xiaomi.midrop.send.contacts.a.b(var12_21.j)) ** GOTO lbl177
                    d.f(var11_20).setVisibility(8);
                    d.g(var11_20).setVisibility(0);
                    var38_42 = d.g(var11_20);
                    var39_43 = 2131689722;
lbl175: // 2 sources:
                    var38_42.setText(var39_43);
                    break;
lbl177: // 1 sources:
                    var35_39 = this.h;
                    var36_40 = d.f(var11_20);
                    var37_41 = 5;
                    ** GOTO lbl184
lbl181: // 1 sources:
                    var35_39 = this.h;
                    var36_40 = d.f(var11_20);
                    var37_41 = 4;
lbl184: // 3 sources:
                    com.xiaomi.midrop.util.a.a((Context)var35_39, (TextView)var36_40, (int)var37_41);
                    break;
lbl186: // 1 sources:
                    com.xiaomi.midrop.util.a.a((Context)this.h, (TextView)d.f(var11_20), (int)3);
                    break;
lbl188: // 1 sources:
                    d.f(var11_20).setVisibility(8);
                    d.d(var11_20).setVisibility(0);
                    d.d(var11_20).setImageResource(2131231103);
                    var11_20.o.setOnClickListener(var31_35);
                    if (!com.xiaomi.midrop.util.g.d((String)var32_36) || var12_21.E >= 0) break;
                    var33_37 = this.n;
                    var34_38 = null;
lbl195: // 2 sources:
                    var33_37.a((g)var12_21, var34_38);
                    break;
                }
                case 2: {
                    if (var12_21.m == 3 || var12_21.a() == 0L) break;
                    d.f(var11_20).setVisibility(8);
                    d.d(var11_20).setVisibility(0);
                    d.h(var11_20).setVisibility(8);
                    d.d(var11_20).setImageResource(2131231102);
                    d.i(var11_20).setVisibility(0);
                    var25_44 = d.i(var11_20);
                    var26_45 = new StringBuilder();
                    var26_45.append(j.b((long)var12_21.b()));
                    var26_45.append("/");
                    var26_45.append(j.b((long)var12_21.a()));
                    var25_44.setText((CharSequence)var26_45.toString());
                    var11_20.o.setOnClickListener(null);
                    var11_20.o.setAlpha(1.0f);
                    d.e(var11_20).setVisibility(0);
                    d.e(var11_20).setProgress((int)(100L * var12_21.b() / var12_21.a()));
                    break;
                }
                case 1: {
                    new StringBuilder("Size ").append(var12_21.a());
                    if (var12_21.m == 3) break;
                    d.f(var11_20).setVisibility(8);
                    d.d(var11_20).setVisibility(0);
                    d.h(var11_20).setVisibility(8);
                    d.i(var11_20).setVisibility(0);
                    d.i(var11_20).setText((CharSequence)j.b((long)var12_21.a()));
                    d.d(var11_20).setImageResource(2131231102);
                    var11_20.o.setOnClickListener(null);
                    var11_20.o.setAlpha(1.0f);
                    d.e(var11_20).setVisibility(0);
                    d.e(var11_20).setProgress(0);
                }
            }
            if (com.xiaomi.midrop.util.g.h((String)var12_21.i)) {
                com.xiaomi.midrop.send.contacts.a.a(var12_21.i, (a.b)new 3(this, var11_20));
            }
        }
        if (var10_18) {
            var1_4.p.setVisibility(0);
            a.a(var1_4).setText((CharSequence)var2_5.c);
            var17_46 = var2_5.e;
            var18_47 = var2_5.d();
            var19_48 = a.b(var1_4);
            var20_49 = new StringBuilder("(");
            var20_49.append(var17_46);
            var20_49.append("/");
            var20_49.append(var18_47);
            var20_49.append(")");
            var19_48.setText((CharSequence)var20_49.toString());
            return;
        }
        var1_4.p.setVisibility(8);
    }

    public static final class e
    extends Enum<e> {
        public static final int a = 1;
        public static final int b = 2;
        private static final /* synthetic */ int[] c;

        static {
            int[] arrn = new int[]{a, b};
            c = arrn;
        }
    }

    public static interface f {
        public void a(Context var1, com.xiaomi.midrop.b.b var2);
    }

}

