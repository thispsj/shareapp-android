/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package com.xiaomi.midrop.b.a;

import com.xiaomi.midrop.b.a.a;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.h;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.util.f;
import java.util.ArrayList;
import java.util.List;

public final class b
extends a<List<i>> {
    List<i> b = new ArrayList();
    private h.a c = new h.a(){

        @Override
        public final void a(int n2, List<g> list) {
            b.this.b = f.b(list, 2131689669);
            b.this.a(b.this.b);
        }
    };

    @Override
    protected final /* synthetic */ Object b() {
        h.a().a(10, this.c);
        return this.b;
    }

    @Override
    protected final void c() {
        if (this.b != null) {
            this.b.clear();
        }
    }

}

