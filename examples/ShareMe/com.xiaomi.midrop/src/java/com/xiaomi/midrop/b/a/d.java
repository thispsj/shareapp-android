/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package com.xiaomi.midrop.b.a;

import android.content.Context;
import com.xiaomi.midrop.b.a.h;
import com.xiaomi.midrop.b.g;
import java.util.ArrayList;
import java.util.List;

public final class d
extends h<List<g>> {
    private List<g> c = new ArrayList();

    public d(Context context) {
        super(context);
    }

    @Override
    protected final void a(g g2) {
        this.c.add((Object)g2);
    }

    @Override
    protected final void c() {
        this.c.clear();
    }
}

