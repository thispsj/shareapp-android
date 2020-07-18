/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  com.xiaomi.midrop.search.SearchSectionAdapter
 *  java.io.File
 *  java.io.FilenameFilter
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Locale
 */
package com.xiaomi.midrop.search;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.search.SearchSectionAdapter;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.util.h;
import com.xiaomi.midrop.util.j;
import com.xiaomi.midrop.util.p;
import com.xiaomi.midrop.view.stickadapter.a;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public final class a
extends com.xiaomi.midrop.view.stickadapter.a {
    String c;
    Context d;
    c e;
    private List<i> f = new ArrayList();
    private LayoutInflater g;

    public a(Context context) {
        this.d = context;
        this.g = LayoutInflater.from((Context)context);
    }

    @Override
    public final a.c a(ViewGroup viewGroup) {
        return (a)this.new a(this.g.inflate(2131427547, viewGroup, false));
    }

    @Override
    public final void a(a.c c2, int n2, int n3) {
        super.a(c2, n2, n3);
        a a2 = (a)c2;
        i i2 = (i)this.f.get(n2);
        a2.o.setText((CharSequence)i2.c);
        a2.a.setOnClickListener(new View.OnClickListener((a)this, n2){
            final /* synthetic */ int a;
            final /* synthetic */ a b;
            {
                this.b = a2;
                this.a = n2;
            }

            public void onClick(View view) {
                if (this.b.c() == 0) {
                    return;
                }
                this.b.a(this.a, true ^ this.b.g(this.a));
            }
        });
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public final void a(a.d var1_1, int var2_4, int var3_3, int var4) {
        block6 : {
            block4 : {
                block5 : {
                    super.a(var1_1, var2_4, var3_3, var4);
                    var5_5 = (b)var1_1;
                    var6_6 = (g)((i)this.f.get((int)var2_4)).b.get(var3_3);
                    b.a(var5_5).setBackgroundDrawable(null);
                    am.a(b.b(var5_5), var6_6.k, this.c, this.d.getResources().getColor(2131099953));
                    b.c(var5_5).setVisibility(8);
                    var7_7 = new StringBuilder();
                    var7_7.append(j.b(var6_6.l));
                    var7_7.append(" | ");
                    var7_7.append(j.c(1000L * var6_6.w));
                    var11_8 = var7_7.toString();
                    var12_9 = var6_6.g;
                    if (var12_9 == 4) break block4;
                    if (var12_9 == 7) break block5;
                    switch (var12_9) {
                        default: {
                            var24_10 = j.d(var6_6.i);
                            if (!com.xiaomi.midrop.util.g.l.contains((Object)var24_10)) ** GOTO lbl24
                            b.a(var5_5).setBackgroundDrawable(this.d.getResources().getDrawable(2131231159));
                            var21_11 = this.d;
                            var22_12 = b.d(var5_5);
                            var25_13 = new File(var6_6.i);
                            ** GOTO lbl29
lbl24: // 1 sources:
                            if (!com.xiaomi.midrop.util.g.h.contains((Object)var24_10)) ** GOTO lbl31
                            b.a(var5_5).setBackgroundDrawable(this.d.getResources().getDrawable(2131231159));
                            var21_11 = this.d;
                            var22_12 = b.d(var5_5);
                            var25_13 = new File(var6_6.i);
lbl29: // 2 sources:
                            var23_14 = Uri.fromFile((File)var25_13).toString();
                            ** GOTO lbl38
lbl31: // 1 sources:
                            h.b(this.d, b.d(var5_5), var6_6.i);
                            break block6;
                        }
                        case 2: {
                            b.a(var5_5).setBackgroundDrawable(this.d.getResources().getDrawable(2131231159));
                            var21_11 = this.d;
                            var22_12 = b.d(var5_5);
                            var23_14 = var6_6.h;
lbl38: // 2 sources:
                            h.a(var21_11, var22_12, var23_14);
                            break block6;
                        }
                        case 1: 
                    }
                    b.d(var5_5).setImageResource(2131231209);
                    h.b(this.d, b.d(var5_5), var6_6.i, 2131231142);
                    break block6;
                }
                b.d(var5_5).setImageResource(2131230988);
                var15_15 = new File(var6_6.i).list((FilenameFilter)new p());
                var16_16 = var15_15 == null ? 0 : var15_15.length;
                var17_17 = this.d;
                var18_18 = new Object[]{var16_16};
                var19_19 = var17_17.getString(2131689666, var18_18);
                var20_20 = j.c(1000L * var6_6.w);
                var11_8 = String.format((Locale)Locale.getDefault(), (String)"%s | %s", (Object[])new Object[]{var19_19, var20_20});
                break block6;
            }
            b.a(var5_5).setBackgroundDrawable(this.d.getResources().getDrawable(2131231159));
            h.a(this.d, b.d(var5_5), var6_6.i);
            var13_21 = Locale.getDefault();
            var14_22 = new Object[]{j.a(var6_6.v), j.b(var6_6.l)};
            var11_8 = String.format((Locale)var13_21, (String)"%s   %s", (Object[])var14_22);
            b.c(var5_5).setVisibility(0);
        }
        b.e(var5_5).setText((CharSequence)var11_8);
        b.f(var5_5).setSelected(com.xiaomi.midrop.sender.c.g.e().a(var6_6));
        var5_5.a.setOnClickListener(new View.OnClickListener((a)this, var5_5, var6_6){
            final /* synthetic */ b a;
            final /* synthetic */ g b;
            final /* synthetic */ a c;
            {
                this.c = a2;
                this.a = b2;
                this.b = g2;
            }

            public void onClick(View view) {
                boolean bl = b.f(this.a).isSelected();
                b.f(this.a).setSelected(bl ^ true);
                if (!bl) {
                    ((com.xiaomi.midrop.search.SearchActivity)this.c.d).animate(b.a(this.a));
                    com.xiaomi.midrop.sender.c.g.e().b(this.b);
                    if (this.c.e != null) {
                        this.c.e.a(this.b);
                        return;
                    }
                } else {
                    com.xiaomi.midrop.sender.c.g.e().c(this.b);
                }
            }
        });
    }

    public final void a(List<i> list) {
        if (list != null) {
            this.f.clear();
            this.f.addAll(list);
            this.f();
        }
    }

    @Override
    public final int c() {
        return this.f.size();
    }

    @Override
    public final a.d c(ViewGroup viewGroup, int n2) {
        return (a)this.new b(this.g.inflate(2131427546, viewGroup, false));
    }

    @Override
    public final int d(int n2) {
        return ((i)this.f.get((int)n2)).b.size();
    }

    @Override
    public final boolean e(int n2) {
        return true;
    }

    private final class a
    extends a.c {
        private TextView o;

        public a(View view) {
            super(view);
            this.o = (TextView)view.findViewById(2131296810);
        }
    }

    private final class b
    extends a.d {
        private TextView o;
        private TextView p;
        private RelativeLayout q;
        private ImageView r;
        private View t;
        private View u;

        public b(View view) {
            super(view);
            this.o = (TextView)view.findViewById(2131296810);
            this.p = (TextView)view.findViewById(2131296412);
            this.q = (RelativeLayout)view.findViewById(2131296400);
            this.r = (ImageView)view.findViewById(2131296505);
            this.t = view.findViewById(2131296734);
            this.u = view.findViewById(2131296509);
        }

        static /* synthetic */ View a(b b2) {
            return b2.u;
        }

        static /* synthetic */ TextView b(b b2) {
            return b2.o;
        }

        static /* synthetic */ RelativeLayout c(b b2) {
            return b2.q;
        }

        static /* synthetic */ ImageView d(b b2) {
            return b2.r;
        }

        static /* synthetic */ TextView e(b b2) {
            return b2.p;
        }

        static /* synthetic */ View f(b b2) {
            return b2.t;
        }
    }

}

