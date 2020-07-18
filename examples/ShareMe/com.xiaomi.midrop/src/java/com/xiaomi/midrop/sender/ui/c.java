/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$w
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  com.xiaomi.midrop.sender.ui.DirNaviAdapter
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.sender.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.midrop.sender.ui.DirNaviAdapter;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.j;
import java.util.List;

public final class c
extends RecyclerView.a {
    public b c;
    private Context d;
    private List<String> e;

    public c(Context context, List<String> list) {
        this.d = context;
        this.e = list;
    }

    public final int a() {
        if (this.e == null) {
            return 0;
        }
        return this.e.size();
    }

    public final RecyclerView.w a(ViewGroup viewGroup, int n2) {
        View view = LayoutInflater.from((Context)this.d).inflate(2131427508, viewGroup, false);
        return (c)this.new a(this.d, view);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void a(RecyclerView.w w2, int n2) {
        View view;
        int n3;
        String string2 = (String)this.e.get(n2);
        String string3 = j.a(string2);
        a a2 = (a)w2;
        a2.o.setText((CharSequence)string3);
        w2.a.setOnClickListener(new View.OnClickListener((c)this, string2){
            final /* synthetic */ String a;
            final /* synthetic */ c b;
            {
                this.b = c2;
                this.a = string2;
            }

            public void onClick(View view) {
                if (this.b.c != null) {
                    this.b.c.a(this.a);
                }
            }
        });
        if (n2 == -1 + this.e.size()) {
            view = a2.p;
            n3 = 0;
        } else {
            view = a2.p;
            n3 = 8;
        }
        view.setVisibility(n3);
    }

    final class a
    extends RecyclerView.w {
        private TextView o;
        private View p;

        public a(Context context, View view) {
            super(view);
            this.o = (TextView)view.findViewById(2131296871);
            this.p = view.findViewById(2131296321);
            if (ac.c(context)) {
                this.p.setRotation(180.0f);
                this.o.setBackgroundResource(2131231029);
            }
        }
    }

}

