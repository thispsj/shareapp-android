/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package com.xiaomi.midrop.b.a;

import com.xiaomi.midrop.b.a.a;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.h;
import java.util.List;

public abstract class k<T>
extends a<T> {
    private h.a b = new h.a(){

        @Override
        public final void a(int n2, List<g> list) {
            for (g g2 : list) {
                k.this.a(g2);
            }
            k.this.a(k.this.d());
        }
    };

    @Override
    protected abstract void a(g var1);

    @Override
    protected final T b() {
        h.a().a(2, this.b);
        return null;
    }

    protected abstract T d();

}

