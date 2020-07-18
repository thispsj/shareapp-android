/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  com.bumptech.glide.e
 *  com.bumptech.glide.e.a
 *  com.bumptech.glide.e.h
 *  com.bumptech.glide.k
 *  com.bumptech.glide.l
 *  com.bumptech.glide.manager.h
 *  com.bumptech.glide.manager.l
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.String
 */
package com.xiaomi.midrop.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.e;
import com.bumptech.glide.e.a;
import com.bumptech.glide.e.h;
import com.bumptech.glide.k;
import com.bumptech.glide.manager.l;
import com.xiaomi.midrop.util.m;
import com.xiaomi.midrop.util.n;

public final class o
extends com.bumptech.glide.l {
    public o(e e2, com.bumptech.glide.manager.h h2, l l2, Context context) {
        super(e2, h2, l2, context);
    }

    public final /* synthetic */ k a(Class class_) {
        return new n(this.a, (com.bumptech.glide.l)this, class_, this.b);
    }

    public final /* synthetic */ k a(String string2) {
        return this.b(string2);
    }

    protected final void a(h h2) {
        if (h2 instanceof m) {
            super.a(h2);
            return;
        }
        super.a((h)new m().a((a<?>)h2));
    }

    public final n<Drawable> b(String string2) {
        return (n)super.a(string2);
    }
}

