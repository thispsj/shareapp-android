/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Message
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.animation.AlphaAnimation
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.ScaleAnimation
 *  android.widget.BaseAdapter
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.xiaomi.midrop.view.ProfileImageView
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  midrop.a.c.a.a
 *  midrop.a.c.a.a.a
 *  midrop.a.c.a.a.a$a
 *  midrop.a.c.a.a.a$a$b
 *  midrop.a.c.a.a.a$a$c
 *  midrop.a.c.a.a.a$a$f
 *  midrop.a.c.a.a.c
 *  midrop.c.a.e
 */
package com.xiaomi.midrop.sender.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.sender.ui.f;
import com.xiaomi.midrop.sender.ui.i;
import com.xiaomi.midrop.sender.ui.k;
import com.xiaomi.midrop.view.ProfileImageView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import midrop.a.c.a.a;
import midrop.a.c.a.a.a;
import midrop.a.c.a.a.c;

public final class e
extends BaseAdapter {
    public List<midrop.a.c.a.a.a> a;
    public List<midrop.a.c.a.a.a> b;
    public List<Boolean> c;
    f.a d;
    private int e;
    private LayoutInflater f;
    private Context g;
    private View.OnClickListener h;
    private Handler i;

    public e(Context context, List<midrop.a.c.a.a.a> list, View.OnClickListener onClickListener) {
        this.i = new Handler(){

            public final void handleMessage(Message message) {
                if (e.this.b.size() > 0) {
                    midrop.a.c.a.a.a a2 = (midrop.a.c.a.a.a)e.this.b.remove(0);
                    e.this.a(a2);
                }
            }
        };
        this.g = context;
        this.e = 2131427460;
        this.a = list;
        this.f = (LayoutInflater)context.getSystemService("layout_inflater");
        this.h = onClickListener;
        this.c = new ArrayList();
        this.b = new ArrayList();
    }

    public final void a(midrop.a.c.a.a.a a2) {
        this.a.add((Object)a2);
        this.c.add((Object)false);
        this.notifyDataSetChanged();
    }

    public final void b(midrop.a.c.a.a.a a2) {
        boolean bl;
        Iterator iterator = this.a.iterator();
        int n2 = 0;
        do {
            boolean bl2 = iterator.hasNext();
            bl = false;
            if (!bl2) break;
            if (((midrop.a.c.a.a.a)iterator.next()).b().equals((Object)a2.b())) {
                bl = true;
                break;
            }
            ++n2;
        } while (true);
        if (bl) {
            this.a.set(n2, (Object)a2);
            this.notifyDataSetChanged();
        }
    }

    public final int getCount() {
        return this.a.size();
    }

    public final Object getItem(int n2) {
        return this.a.get(n2);
    }

    public final long getItemId(int n2) {
        return 0L;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final View getView(int var1, View var2_3, ViewGroup var3_2) {
        block27 : {
            var4_4 = (midrop.a.c.a.a.a)this.a.get(var1);
            var5_5 = var2_3 == null ? this.f.inflate(this.e, null) : var2_3;
            if (!((Boolean)this.c.get(var1)).booleanValue()) {
                this.c.set(var1, (Object)true);
                var32_6 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                var32_6.setDuration(400L);
                var32_6.setFillAfter(true);
                var32_6.setAnimationListener(new Animation.AnimationListener(){

                    public final void onAnimationEnd(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                        if (e.this.b.size() > 0) {
                            e.this.i.sendEmptyMessageDelayed(0, 80L);
                        }
                    }
                });
                var5_5.setAnimation((Animation)var32_6);
            }
            ((ProfileImageView)var5_5.findViewById(2131296418)).a(var4_4.a.l(), var4_4.b(), var4_4.a());
            var6_7 = (TextView)var5_5.findViewById(2131296423);
            var6_7.setTag((Object)var4_4);
            var7_8 = (ImageView)var5_5.findViewById(2131296687);
            if (var4_4.a.i()) {
                var7_8.setVisibility(0);
            } else {
                var7_8.setVisibility(8);
            }
            var8_9 = (ImageView)var5_5.findViewById(2131296419);
            var8_9.setTag((Object)var4_4);
            var8_9.setOnClickListener(this.h);
            var8_9.setImageResource(2131230839);
            var6_7.setText((CharSequence)var4_4.a());
            var9_10 = (TextView)var5_5.findViewById(2131296424);
            var10_11 = (TextView)var5_5.findViewById(2131296425);
            var11_12 = (ImageView)var5_5.findViewById(2131296422);
            if (var4_4.b.a() != a.a.b.b) break block27;
            var12_13 = 2131689900;
            ** GOTO lbl32
        }
        if (var4_4.b.d()) {
            var12_13 = 2131689891;
lbl32: // 2 sources:
            var13_14 = true;
        } else {
            var12_13 = 0;
            var13_14 = false;
        }
        var14_15 = var4_4.b.f();
        if (var14_15 == a.a.f.i) {
            var12_13 = 2131689890;
        } else if (var14_15 == a.a.f.d) {
            var12_13 = 2131689846;
        } else if (var14_15 == a.a.f.e) {
            var12_13 = 2131689896;
        } else if (var14_15 == a.a.f.f) {
            var12_13 = 2131689834;
        } else if (var14_15 == a.a.f.h || var14_15 == a.a.f.g) {
            var12_13 = 0;
        }
        if (var12_13 != 0) {
            var9_10.setText(var12_13);
            var9_10.setVisibility(0);
        } else {
            var9_10.setVisibility(4);
        }
        var15_16 = var9_10.getAnimation();
        var9_10.setTag((Object)var13_14);
        if (!var13_14) {
            var9_10.clearAnimation();
        } else if (var15_16 == null) {
            var16_17 = new AlphaAnimation(0.5f, 1.0f);
            var16_17.setDuration(440L);
            var17_18 = new AlphaAnimation(0.5f, 1.0f);
            var17_18.setDuration(720L);
            var18_19 = new AlphaAnimation(1.0f, 0.5f);
            var18_19.setDuration(720L);
            var17_18.setAnimationListener(new Animation.AnimationListener(var9_10, var18_19){
                final /* synthetic */ TextView a;
                final /* synthetic */ AlphaAnimation b;
                {
                    this.a = textView;
                    this.b = alphaAnimation;
                }

                public final void onAnimationEnd(Animation animation) {
                    if (((Boolean)this.a.getTag()).booleanValue()) {
                        this.a.startAnimation((Animation)this.b);
                    }
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }
            });
            var18_19.setAnimationListener(new Animation.AnimationListener(var9_10, var17_18){
                final /* synthetic */ TextView a;
                final /* synthetic */ AlphaAnimation b;
                {
                    this.a = textView;
                    this.b = alphaAnimation;
                }

                public final void onAnimationEnd(Animation animation) {
                    if (((Boolean)this.a.getTag()).booleanValue()) {
                        this.a.startAnimation((Animation)this.b);
                    }
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }
            });
            var16_17.setAnimationListener(new Animation.AnimationListener(var9_10, var18_19){
                final /* synthetic */ TextView a;
                final /* synthetic */ AlphaAnimation b;
                {
                    this.a = textView;
                    this.b = alphaAnimation;
                }

                public final void onAnimationEnd(Animation animation) {
                    if (((Boolean)this.a.getTag()).booleanValue()) {
                        this.a.startAnimation((Animation)this.b);
                    }
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }
            });
            var9_10.startAnimation((Animation)var16_17);
        }
        var19_20 = this.g;
        var20_21 = var4_4.b.g();
        switch (k.1.a[var20_21.ordinal()]) {
            default: {
                var21_22 = 0L;
                ** break;
            }
            case 2: {
                var28_23 = var4_4.c;
                var29_24 = var28_23.f + var28_23.e;
                if (var29_24 <= 0L) {
                    var21_22 = var29_24 + 1000L;
                    ** break;
                }
                var21_22 = var29_24;
                ** break;
            }
            case 1: 
        }
        var21_22 = var4_4.c.f;
lbl88: // 4 sources:
        if (var21_22 > 0L) {
            var10_11.setVisibility(0);
            var26_25 = var19_20.getString(2131689885);
            var27_26 = var19_20.getString(2131689886);
            if (var21_22 >= 60000L) {
                var27_26 = var26_25;
            }
            var10_11.setText((CharSequence)new SimpleDateFormat(var27_26).format((Object)var21_22));
            var11_12.setVisibility(0);
        } else {
            var10_11.setVisibility(8);
            var11_12.setVisibility(8);
        }
        var23_27 = this.d.a();
        var24_28 = var23_27 != null ? TextUtils.equals((CharSequence)var23_27.b(), (CharSequence)var4_4.b()) : true;
        var8_9.setEnabled(var24_28);
        var25_29 = var24_28 != false ? 1.0f : 0.5f;
        var5_5.setAlpha(var25_29);
        return var5_5;
    }

}

