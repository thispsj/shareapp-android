/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  com.xiaomi.midrop.send.FilePickNewActivity
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.sender.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.send.FilePickNewActivity;

public abstract class d {
    protected String c;
    protected boolean d;
    protected View e;
    protected View f;
    protected Context g;
    protected a h;
    protected b i;
    protected Object j;
    protected boolean k;
    protected boolean l;
    public LayoutInflater m;

    public d(Context context) {
        this.c = this.getClass().getCanonicalName();
        this.g = context;
    }

    public final LayoutInflater a() {
        if (this.m == null) {
            this.m = LayoutInflater.from((Context)this.g);
        }
        return this.m;
    }

    public abstract View a(ViewGroup var1);

    public final void a(View view) {
        if (this.g instanceof FilePickNewActivity) {
            ((FilePickNewActivity)this.g).animate(view);
        }
    }

    public abstract void a(g var1, boolean var2, boolean var3);

    public final void a(a a2) {
        this.h = a2;
    }

    public final void a(b b2) {
        this.i = b2;
    }

    public final void a(Object object) {
        this.j = object;
    }

    public final void a(boolean bl) {
        this.k = bl;
    }

    public final void b(boolean bl) {
        this.l = bl;
    }

    public final boolean b() {
        return this.k;
    }

    public final boolean c() {
        return this.l;
    }

    public final Object d() {
        return this.j;
    }

    public static interface a {
        public void a(g var1);
    }

    public static interface b {
        public void a();
    }

}

