/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$b
 *  android.support.v7.widget.RecyclerView$w
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.Switch
 *  android.widget.TextView
 *  com.xiaomi.midrop.about.AboutAdapter
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 */
package com.xiaomi.midrop.about;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import com.xiaomi.midrop.about.AboutAdapter;
import com.xiaomi.midrop.about.a;
import com.xiaomi.midrop.util.y;
import java.util.ArrayList;

public final class a
extends RecyclerView.a<RecyclerView.w> {
    e c;
    private final int d = 1;
    private final int e = 2;
    private final int f = 3;
    private final int g = 4;
    private ArrayList<c> h;
    private Context i;
    private LayoutInflater j;

    public a(Context context, e e2) {
        this.i = context;
        this.c = e2;
        this.j = LayoutInflater.from((Context)context);
        this.h = new ArrayList();
        this.h.add(new Object((a)this){
            int a;
            int b;
            int c;
            int d;
            final /* synthetic */ a e;
            {
                this.e = a2;
                this.b = n3;
                this.a = n2;
                this.c = n4;
                this.d = n5;
            }
        });
        this.h.add(new /* invalid duplicate definition of identical inner class */);
        boolean bl = com.xiaomi.miftp.c.f.a(a.c()) != null;
        if (bl) {
            this.h.add(new /* invalid duplicate definition of identical inner class */);
        }
        ArrayList<c> arrayList = this.h;
        Object object = new /* invalid duplicate definition of identical inner class */;
        arrayList.add(object);
        if (com.xiaomi.midrop.transmission.upgrade.util.b.a().b()) {
            ArrayList<c> arrayList2 = this.h;
            Object object2 = new /* invalid duplicate definition of identical inner class */;
            arrayList2.add(object2);
        }
        this.h.add(new /* invalid duplicate definition of identical inner class */);
        this.h.add(new /* invalid duplicate definition of identical inner class */);
        if (this.a.a()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.b = true;
    }

    public static Intent c() {
        Intent intent = new Intent("android.intent.action.SEARCH");
        intent.setPackage("com.xiaomi.discover");
        return intent;
    }

    public final int a() {
        return this.h.size();
    }

    public final int a(int n2) {
        return (this.h.get((int)n2)).b;
    }

    public final RecyclerView.w a(ViewGroup viewGroup, int n2) {
        if (n2 != 1) {
            switch (n2) {
                default: {
                    return new d(this.j.inflate(2131427356, viewGroup, false));
                }
                case 4: {
                    return new a(this.j.inflate(2131427357, viewGroup, false));
                }
                case 3: 
            }
            return new f(this.j.inflate(2131427358, viewGroup, false));
        }
        return new b(this.j.inflate(2131427355, viewGroup, false));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void a(RecyclerView.w var1, int var2_2) {
        block9 : {
            var3_3 = this.h.get(var2_2);
            var4_4 = com.xiaomi.midrop.util.Locale.b.a().b(var3_3.c);
            var5_5 = com.xiaomi.midrop.util.Locale.b.a().b(var3_3.d);
            if (!(var1 instanceof d)) break block9;
            var19_6 = ((d)var1).n;
            ** GOTO lbl11
        }
        if (var1 instanceof b) {
            var19_6 = ((b)var1).n;
            var4_4 = "1.28.26";
lbl11: // 2 sources:
            var19_6.setText((CharSequence)var4_4);
        } else if (var1 instanceof f) {
            var9_7 = (f)var1;
            var9_7.n.setText((CharSequence)var4_4);
            var10_8 = y.p();
            var11_9 = var9_7.a.getLayoutParams();
            if (y.q() > 12826 && !TextUtils.isEmpty((CharSequence)var10_8)) {
                var14_10 = var9_7.o;
                var15_11 = new StringBuilder();
                var15_11.append(this.i.getString(2131689647));
                var15_11.append(" ");
                var15_11.append(var10_8);
                var14_10.setText((CharSequence)var15_11.toString());
                var9_7.o.setVisibility(0);
                var12_12 = this.i.getResources();
                var13_13 = 2131165260;
            } else {
                var9_7.o.setVisibility(8);
                var12_12 = this.i.getResources();
                var13_13 = 2131165259;
            }
            var11_9.height = (int)var12_12.getDimension(var13_13);
        } else if (var1 instanceof a) {
            var6_14 = (a)var1;
            var6_14.n.setText((CharSequence)var4_4);
            var6_14.o.setText((CharSequence)var5_5);
            if (var3_3.a == 2131296273) {
                var6_14.p.setChecked(y.h());
                var7_15 = var6_14.p;
                var8_16 = new CompoundButton.OnCheckedChangeListener((a)this){
                    final /* synthetic */ a a;
                    {
                        this.a = a2;
                    }

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                        y.b(bl);
                    }
                };
            } else {
                var6_14.p.setChecked(y.i());
                var7_15 = var6_14.p;
                var8_18 = new CompoundButton.OnCheckedChangeListener((a)this){
                    final /* synthetic */ a a;
                    {
                        this.a = a2;
                    }

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                        y.c(bl);
                    }
                };
            }
            var7_15.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)var8_17);
        }
        var1.a.setOnClickListener(new View.OnClickListener((a)this, var1){
            final /* synthetic */ RecyclerView.w a;
            final /* synthetic */ a b;
            {
                this.b = a2;
                this.a = w2;
            }

            public void onClick(View view) {
                if (this.b.c != null) {
                    this.b.c.onClick(this.a.e);
                }
                if (this.a instanceof a) {
                    a a2 = (a)this.a;
                    a2.p.setChecked(true ^ a2.p.isChecked());
                }
            }
        });
    }

    public final long b(int n2) {
        return (this.h.get((int)n2)).a;
    }

    private static final class a
    extends RecyclerView.w {
        TextView n;
        TextView o;
        Switch p;

        a(View view) {
            super(view);
            this.n = (TextView)view.findViewById(2131296810);
            this.o = (TextView)view.findViewById(2131296784);
            this.p = (Switch)view.findViewById(2131296789);
        }
    }

    private static final class b
    extends RecyclerView.w {
        TextView n;

        b(View view) {
            super(view);
            this.n = (TextView)view.findViewById(2131296319);
        }
    }

    private static final class d
    extends RecyclerView.w {
        TextView n;

        d(View view) {
            super(view);
            this.n = (TextView)view.findViewById(2131296810);
        }
    }

    private static final class f
    extends RecyclerView.w {
        TextView n;
        TextView o;

        f(View view) {
            super(view);
            this.n = (TextView)view.findViewById(2131296810);
            this.o = (TextView)view.findViewById(2131296784);
        }
    }

}

