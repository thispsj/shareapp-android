/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.support.v4.view.ViewPager
 *  android.support.v4.view.ViewPager$e
 *  android.support.v4.view.n
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.GridView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ListAdapter
 *  com.xiaomi.midrop.sender.ui.ScreenChildViewManager
 *  com.xiaomi.midrop.sender.ui.f$1
 *  com.xiaomi.midrop.sender.ui.f$2
 *  com.xiaomi.midrop.sender.ui.f$c
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  midrop.a.c.a.a.a
 *  midrop.a.c.a.a.a$a
 */
package com.xiaomi.midrop.sender.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.n;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.xiaomi.midrop.sender.ui.ScreenChildViewManager;
import com.xiaomi.midrop.sender.ui.e;
import com.xiaomi.midrop.sender.ui.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import midrop.a.c.a.a.a;

/*
 * Exception performing whole class analysis.
 */
public class f {
    private static final String g = "com.xiaomi.midrop.sender.ui.f";
    public List<midrop.a.c.a.a.a> a;
    public View b;
    public ViewPager c;
    public ArrayList<e> d;
    public ArrayList<midrop.a.c.a.a.a> e;
    public ViewGroup f;
    private Context h;
    private b i;
    private int j;
    private c k;
    private LinearLayout l;
    private int m;
    private View.OnClickListener n;
    private midrop.a.c.a.a.a o;
    private String p;
    private Handler q;

    public f(Context context, View view, b b2) {
        this.n = new View.OnClickListener((f)this){
            final /* synthetic */ f a;
            {
                this.a = f2;
            }

            public void onClick(View view) {
                if (f.a(this.a) != null) {
                    return;
                }
                midrop.a.c.a.a.a a2 = (midrop.a.c.a.a.a)view.getTag();
                if (f.b(this.a) != null) {
                    f.b(this.a).a(a2);
                }
            }
        };
        this.q = new Handler();
        this.h = context;
        this.b = view;
        this.i = b2;
        this.j = this.h.getResources().getInteger(2131361805);
        this.a = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = (ViewGroup)this.b.findViewById(2131296809);
        this.c = (ViewPager)this.b.findViewById(2131296916);
        this.l = (LinearLayout)view.findViewById(2131296597);
        this.k = new /* Unavailable Anonymous Inner Class!! */;
        this.c.setAdapter((n)this.k);
        this.c.a((ViewPager.e)new 1((f)this));
        f.super.a();
    }

    static /* synthetic */ int a(f f2, int n2) {
        f2.m = n2;
        return n2;
    }

    static /* synthetic */ midrop.a.c.a.a.a a(f f2) {
        return f2.o;
    }

    private void a() {
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            this.b((midrop.a.c.a.a.a)iterator.next());
        }
    }

    static /* synthetic */ b b(f f2) {
        return f2.i;
    }

    static /* synthetic */ int c(f f2) {
        return f2.m;
    }

    static /* synthetic */ LinearLayout d(f f2) {
        return f2.l;
    }

    public final int a(String string2) {
        Iterator iterator = this.a.iterator();
        int n2 = 0;
        while (iterator.hasNext() && !((midrop.a.c.a.a.a)iterator.next()).b().equals((Object)string2)) {
            ++n2;
        }
        return n2;
    }

    public final e a(int n2) {
        int n3 = n2 / this.j;
        e e2 = n3 < this.d.size() ? (e)((Object)this.d.get(n3)) : null;
        if (e2 == null) {
            ArrayList arrayList = new ArrayList();
            e e3 = new e(this.h, (List<midrop.a.c.a.a.a>)arrayList, this.n);
            this.d.add(n3, (Object)e3);
            e3.d = new 2((f)this);
            e2 = e3;
        }
        return e2;
    }

    public final boolean a(midrop.a.c.a.a.a a2) {
        boolean bl;
        String string2;
        block3 : {
            string2 = a2.b();
            Iterator iterator = this.a.iterator();
            while (iterator.hasNext()) {
                if (!((midrop.a.c.a.a.a)iterator.next()).b().equals((Object)string2)) continue;
                bl = true;
                break block3;
            }
            bl = false;
        }
        if (bl) {
            Iterator iterator = this.e.iterator();
            while (iterator.hasNext()) {
                if (!((midrop.a.c.a.a.a)iterator.next()).b().equals((Object)string2)) continue;
                bl = false;
                break;
            }
        }
        return bl;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void b(final midrop.a.c.a.a.a var1) {
        block6 : {
            var2_2 = var1.b();
            var3_3 = this.a(var2_2) / this.j;
            var4_4 = c.a(this.k, (int)var3_3);
            if (var4_4 == null && (var10_6 = this.j - (var9_5 = this.a(var2_2)) % this.j == this.j)) {
                var11_7 = LayoutInflater.from((Context)this.h).inflate(2131427385, null);
                ((GridView)var11_7.findViewById(2131296466)).setAdapter((ListAdapter)this.a(this.k.c() * this.j));
                this.k.a.add((Object)var11_7);
                this.k.d();
                this.l.removeAllViews();
                if (this.k.c() > 0) {
                    var15_8 = this.h.getResources().getDimensionPixelSize(2131165772);
                    var16_9 = this.h.getResources().getDimensionPixelOffset(2131165771);
                    for (var17_10 = 0; var17_10 < this.k.c(); ++var17_10) {
                        var18_12 = new View(this.h);
                        var18_12.setBackgroundDrawable(this.h.getResources().getDrawable(2131231255));
                        var19_11 = new LinearLayout.LayoutParams(var15_8, var15_8);
                        var19_11.setMargins(var16_9, 0, var16_9, 0);
                        var18_12.setLayoutParams((ViewGroup.LayoutParams)var19_11);
                        var18_12.setEnabled(false);
                        this.l.addView(var18_12);
                    }
                    this.l.getChildAt(this.c.getCurrentItem()).setEnabled(true);
                }
                var13_13 = this.l;
                var14_14 = this.k.c() <= 1 ? 4 : 0;
                var13_13.setVisibility(var14_14);
                var4_4 = c.a(this.k, (int)var3_3);
            }
            if (var4_4 == null) return;
            var5_15 = (GridView)var4_4.findViewById(2131296466);
            if (!var1.b.d()) break block6;
            this.o = var1;
            this.p = this.o.b();
            ** GOTO lbl37
        }
        if (this.o != null && TextUtils.equals((CharSequence)var1.b(), (CharSequence)this.o.b())) {
            this.o = null;
            this.q.postDelayed(new Runnable(){

                public final void run() {
                    f.this.p = null;
                    if (var1 != null) {
                        var1.g();
                        ((e)var5_15.getAdapter()).b(var1);
                    }
                }
            }, 3000L);
lbl37: // 2 sources:
            var7_16 = true;
        } else {
            var6_17 = TextUtils.equals((CharSequence)this.p, (CharSequence)var1.b());
            var7_16 = false;
            if (!var6_17) {
                var1.g();
            }
        }
        ((e)var5_15.getAdapter()).b(var1);
        if (var7_16 == false) return;
        if (this.k.c() <= 1) return;
        this.k.d();
    }

    static interface a {
        public midrop.a.c.a.a.a a();
    }

    public static interface b {
        public void a(midrop.a.c.a.a.a var1);
    }

}

