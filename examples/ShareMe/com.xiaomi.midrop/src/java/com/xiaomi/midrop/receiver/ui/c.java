/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$w
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  com.bumptech.glide.e
 *  com.bumptech.glide.e.a
 *  com.bumptech.glide.e.a.i
 *  com.bumptech.glide.e.h
 *  com.bumptech.glide.k
 *  com.bumptech.glide.load.b.j
 *  com.bumptech.glide.load.d.a.f
 *  com.bumptech.glide.load.d.c.c
 *  com.bumptech.glide.m
 *  com.xiaomi.midrop.receiver.ui.TransferGridViewAdapter
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.receiver.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.bumptech.glide.e;
import com.bumptech.glide.e.a.i;
import com.bumptech.glide.k;
import com.bumptech.glide.load.b.j;
import com.bumptech.glide.load.d.a.f;
import com.bumptech.glide.m;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.receiver.ui.TransferGridViewAdapter;
import com.xiaomi.midrop.util.h;
import java.util.List;

public final class c
extends RecyclerView.a<a> {
    List<g> c;
    int d;
    public int e;
    public b f;
    private LayoutInflater g;
    private Context h;

    public c(Context context) {
        this.d = -1;
        this.h = context;
        this.g = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public c(Context context, List<g> list) {
        super(context);
        this.c = list;
    }

    public final int a() {
        if (this.c == null) {
            return 0;
        }
        if (this.d == -1) {
            return this.c.size();
        }
        return Math.min((int)this.d, (int)this.c.size());
    }

    public final /* synthetic */ RecyclerView.w a(ViewGroup viewGroup, int n2) {
        return (c)this.new a(this.g.inflate(2131427574, viewGroup, false));
    }

    public final /* synthetic */ void a(RecyclerView.w w2, int n2) {
        int n3;
        a a2 = (a)w2;
        ViewGroup.LayoutParams layoutParams = a2.a.getLayoutParams();
        if (layoutParams != null && layoutParams.width != (n3 = this.e)) {
            layoutParams.width = n3;
            layoutParams.height = n3;
            a2.a.setLayoutParams(layoutParams);
        }
        a2.a.setOnClickListener(new View.OnClickListener((c)this, n2){
            final /* synthetic */ int a;
            final /* synthetic */ c b;
            {
                this.b = c2;
                this.a = n2;
            }

            public void onClick(View view) {
                if (this.b.f != null) {
                    this.b.f.a(this.b, this.a);
                }
            }
        });
        com.xiaomi.midrop.b.b b2 = this.d(n2);
        if (b2 == null) {
            throw new NullPointerException("UpdateSingleItemView got a null transitem");
        }
        ImageView imageView = a2.n;
        ProgressBar progressBar = a2.p;
        ImageView imageView2 = a2.o;
        if (!TextUtils.isEmpty((CharSequence)b2.j)) {
            k k2;
            com.bumptech.glide.e.h h2;
            com.bumptech.glide.load.d.c.c c2;
            Context context = this.h;
            String string2 = b2.j;
            if (!TextUtils.isEmpty((CharSequence)string2) && string2.endsWith("gif")) {
                h2 = (com.bumptech.glide.e.h)((com.bumptech.glide.e.h)new com.bumptech.glide.e.h().a(j.d)).a(2131231106);
                k2 = e.b((Context)context).d().a(string2);
                c2 = f.b();
            } else {
                h2 = (com.bumptech.glide.e.h)((com.bumptech.glide.e.h)new com.bumptech.glide.e.h().a(j.b)).a(2131231106);
                k2 = e.b((Context)context).a(string2);
                c2 = com.bumptech.glide.load.d.c.c.b();
            }
            k2.a((m)c2).a((com.bumptech.glide.e.a)h2).a(imageView);
        } else {
            h.c(this.h, a2.n, b2.i, 2131231106);
        }
        switch (b2.m) {
            default: {
                return;
            }
            case 5: {
                imageView2.setImageResource(2131231104);
                progressBar.setVisibility(0);
                return;
            }
            case 4: {
                imageView2.setImageResource(2131231104);
                progressBar.setVisibility(0);
                return;
            }
            case 3: {
                imageView2.setImageDrawable(null);
                progressBar.setVisibility(8);
                return;
            }
            case 2: {
                if (b2.m == 3 || b2.a() == 0L) break;
                imageView2.setImageDrawable(null);
                progressBar.setVisibility(0);
                progressBar.setProgress(100 - (int)(100L * b2.b() / b2.a()));
                return;
            }
            case 1: {
                if (b2.m == 3) break;
                imageView2.setImageDrawable(null);
                progressBar.setVisibility(0);
            }
        }
    }

    public final com.xiaomi.midrop.b.b d(int n2) {
        if (n2 >= this.c.size()) {
            return null;
        }
        return (com.xiaomi.midrop.b.b)this.c.get(n2);
    }

    public final class a
    extends RecyclerView.w {
        public ImageView n;
        public ImageView o;
        public ProgressBar p;

        public a(View view) {
            super(view);
            this.n = (ImageView)view.findViewById(2131296522);
            this.p = (ProgressBar)view.findViewById(2131296821);
            this.o = (ImageView)view.findViewById(2131296521);
        }
    }

}

