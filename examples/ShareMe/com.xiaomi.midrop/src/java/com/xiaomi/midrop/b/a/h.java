/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.util.List
 */
package com.xiaomi.midrop.b.a;

import android.content.Context;
import com.xiaomi.midrop.b.a.a;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.h;
import java.util.List;

public abstract class h<T>
extends a<T> {
    Context b;
    private h.a c;

    public h(Context context) {
        this.c = new h.a(){

            @Override
            public final void a(int n2, List<g> list) {
                for (g g2 : list) {
                    h.this.a(g2);
                }
                h.this.a(h.this.d());
            }
        };
        this.b = context;
    }

    @Override
    protected abstract void a(g var1);

    @Override
    protected final T b() {
        com.xiaomi.midrop.b.h.a().a(3, this.c);
        return this.d();
    }

    protected abstract T d();

}

