/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$b
 *  android.support.v7.widget.RecyclerView$w
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  com.xiaomi.midrop.receiver.ui.a$c
 *  com.xiaomi.midrop.receiver.ui.a$d
 *  com.xiaomi.midrop.transmission.ViewHolder.UpgradeViewHolder
 *  com.xiaomi.midrop.transmission.a.b
 *  com.xiaomi.midrop.transmission.a.c
 *  com.xiaomi.midrop.transmission.a.d
 *  com.xiaomi.midrop.transmission.a.e
 *  com.xiaomi.midrop.transmission.c
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.midrop.f;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.receiver.ui.a;
import com.xiaomi.midrop.transmission.ViewHolder.UpgradeViewHolder;
import com.xiaomi.midrop.transmission.a.c;
import com.xiaomi.midrop.transmission.a.d;
import com.xiaomi.midrop.transmission.a.e;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.j;
import java.util.Iterator;
import java.util.List;

public final class a
extends RecyclerView.a<RecyclerView.w> {
    public com.xiaomi.midrop.receiver.ui.a c;
    public RecyclerView d;
    public String e;
    private LayoutInflater f;
    private Context g;

    public a(Context context, RecyclerView recyclerView, com.xiaomi.midrop.receiver.ui.a a2) {
        this.g = context;
        this.c = a2;
        this.d = recyclerView;
        this.f = LayoutInflater.from((Context)context);
    }

    private static int e(int n2) {
        Iterator iterator = com.xiaomi.midrop.transmission.c.e().e.iterator();
        int n3 = 0;
        int n4 = 0;
        while (iterator.hasNext() && n2 >= (n3 += ((com.xiaomi.midrop.transmission.a.a)iterator.next()).a())) {
            ++n4;
        }
        return n4;
    }

    public final int a() {
        List list = com.xiaomi.midrop.transmission.c.e().e;
        int n2 = 0;
        if (list == null) {
            return 0;
        }
        Iterator iterator = com.xiaomi.midrop.transmission.c.e().e.iterator();
        while (iterator.hasNext()) {
            n2 += ((com.xiaomi.midrop.transmission.a.a)iterator.next()).a();
        }
        return n2;
    }

    public final int a(int n2) {
        int n3;
        int n4 = a.e(n2);
        com.xiaomi.midrop.transmission.a.a a2 = (com.xiaomi.midrop.transmission.a.a)com.xiaomi.midrop.transmission.c.e().e.get(n4);
        boolean bl = a2 instanceof d;
        if (bl) {
            n3 = 0;
            for (int i2 = 0; i2 < n4; ++i2) {
                n3 += ((com.xiaomi.midrop.transmission.a.a)com.xiaomi.midrop.transmission.c.e().e.get(i2)).a();
            }
        } else {
            n3 = 0;
        }
        return a2.a(n2 - n3);
    }

    public final RecyclerView.w a(ViewGroup viewGroup, int n2) {
        if (n2 == 1) {
            return (a)this.new b(this.f.inflate(2131427538, viewGroup, false));
        }
        if (n2 == 2) {
            return (a)this.new b(this.f.inflate(2131427537, viewGroup, false));
        }
        if (n2 == 3) {
            return new a.d(this.f.inflate(2131427536, viewGroup, false));
        }
        if (n2 == 4) {
            return new a.c(this.f.inflate(2131427575, viewGroup, false));
        }
        if (n2 == 6) {
            return new UpgradeViewHolder(this.f.inflate(2131427539, viewGroup, false));
        }
        return (a)this.new a(this.f.inflate(2131427534, viewGroup, false));
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void a(RecyclerView.w w2, int n2) {
        int n3;
        int n4 = a.e(n2);
        com.xiaomi.midrop.transmission.a.a a2 = (com.xiaomi.midrop.transmission.a.a)com.xiaomi.midrop.transmission.c.e().e.get(n4);
        boolean bl = w2 instanceof b;
        int n5 = 8;
        int n6 = 1;
        if (bl) {
            b b2 = (b)w2;
            c c2 = (c)a2;
            d d2 = (d)com.xiaomi.midrop.transmission.c.e().e.get(n4 + 1);
            int n7 = d2.c;
            long l2 = d2.d;
            int n8 = c2.a == 0 ? 2131558412 : 2131558411;
            Resources resources = this.g.getResources();
            Object[] arrobject = new Object[2];
            arrobject[0] = n7;
            arrobject[n6] = j.b(l2);
            String string2 = resources.getQuantityString(n8, n7, arrobject);
            b2.o.setText((CharSequence)string2);
            if (n4 <= 0) {
                b2.p.setVisibility(n5);
                return;
            }
            com.xiaomi.midrop.transmission.a.a a3 = (com.xiaomi.midrop.transmission.a.a)com.xiaomi.midrop.transmission.c.e().e.get(n4 - n6);
            if (!(a3 instanceof d)) return;
            View view = b2.p;
            if (c2.a != ((d)a3).e) {
                n5 = 0;
            }
            view.setVisibility(n5);
            return;
        }
        if (w2 instanceof a) {
            a a4 = (a)w2;
            com.xiaomi.midrop.transmission.a.b b3 = (com.xiaomi.midrop.transmission.a.b)a2;
            a4.o.setText((CharSequence)b3.a);
            return;
        }
        if (w2 instanceof UpgradeViewHolder) {
            UpgradeViewHolder upgradeViewHolder = (UpgradeViewHolder)w2;
            upgradeViewHolder.o = (e)a2;
            upgradeViewHolder.n.setEnabled(upgradeViewHolder.o.b());
            return;
        }
        d d3 = (d)a2;
        int n9 = 0;
        for (int i2 = 0; i2 < n4; n9 += ((com.xiaomi.midrop.transmission.a.a)com.xiaomi.midrop.transmission.c.e().e.get((int)i2)).a(), ++i2) {
        }
        int n10 = n2 - n9;
        d.a a5 = null;
        if (n10 >= 0) {
            if (n10 >= d3.b) {
                return;
            }
            Iterator iterator = d3.a.iterator();
            int n11 = 0;
            block1 : do {
                boolean bl2 = iterator.hasNext();
                a5 = null;
                if (!bl2) break;
                com.xiaomi.midrop.b.b b4 = (com.xiaomi.midrop.b.b)iterator.next();
                if (b4.g == n6) {
                    if (n10 == n11) {
                        a5 = new d.a(d3);
                        a5.a = b4;
                        a5.b = 0;
                        break;
                    }
                    ++n11;
                    continue;
                }
                int n12 = n11;
                for (int i3 = 0; i3 < b4.b.size(); ++n12, ++i3) {
                    if (n10 != n12) continue;
                    a5 = new d.a(d3);
                    a5.a = b4;
                    a5.b = i3;
                    break block1;
                }
                n11 = n12;
            } while (true);
        }
        if (a5 == null) {
            return;
        }
        a.a a6 = w2;
        LinearLayout linearLayout = a6.o;
        View view = a6.n;
        boolean bl3 = d3.c();
        boolean bl4 = n10 == 0;
        boolean bl5 = a5.a() || a5.b == a5.a.b.size() - n6;
        if (n10 != d3.b - n6 || !bl5) {
            n6 = 0;
        }
        this.c.a(a6, a5.a, a5.b, bl3, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(linearLayout.getLayoutParams());
        if (d3.e == 0) {
            int n13 = bl4 ? (ac.c(this.g) ? (n6 != 0 ? 2131231326 : 2131231328) : (n6 != 0 ? 2131231325 : 2131231327)) : (n6 != 0 ? (ac.c(this.g) ? 2131231322 : 2131231321) : (ac.c(this.g) ? 2131231324 : 2131231323));
            linearLayout.setBackgroundResource(n13);
            layoutParams.setMarginEnd(0);
            layoutParams.setMarginStart(this.g.getResources().getDimensionPixelSize(2131165757));
            n3 = 21;
        } else {
            int n14 = bl4 ? (ac.c(this.g) ? (n6 != 0 ? 2131231318 : 2131231320) : (n6 != 0 ? 2131231317 : 2131231319)) : (n6 != 0 ? (ac.c(this.g) ? 2131231314 : 2131231313) : (ac.c(this.g) ? 2131231316 : 2131231315));
            linearLayout.setBackgroundResource(n14);
            layoutParams.setMarginStart(0);
            layoutParams.setMarginEnd(this.g.getResources().getDimensionPixelSize(2131165757));
            n3 = 20;
        }
        layoutParams.addRule(n3);
        if (n6 != 0) {
            n5 = 4;
        } else if (bl5) {
            n5 = 0;
        }
        view.setVisibility(n5);
        linearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    public final void d(int n2) {
        this.c.j = true;
        switch (n2) {
            default: {
                return;
            }
            case 102: 
            case 103: {
                com.xiaomi.midrop.transmission.c c2 = com.xiaomi.midrop.transmission.c.e();
                for (int i2 = 0; i2 < c2.f.size(); ++i2) {
                    g g2 = (g)c2.f.get(i2);
                    if (g2.c()) continue;
                    g2.a(4);
                }
                c2.h = 0;
                c2.j = 0L;
                c2.i = 0L;
                this.a.b();
                return;
            }
            case 101: 
        }
        this.a.b();
    }

    public final class a
    extends RecyclerView.w {
        private TextView o;

        a(View view) {
            super(view);
            this.o = (TextView)view.findViewById(2131296846);
        }
    }

    public final class b
    extends RecyclerView.w {
        private TextView o;
        private View p;

        b(View view) {
            super(view);
            this.o = (TextView)view.findViewById(2131296893);
            this.p = view.findViewById(2131296915);
        }
    }

}

