/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.TreeMap
 */
package com.xiaomi.midrop.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.midrop.b.a.h;
import com.xiaomi.midrop.util.j;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public final class g
extends h<TreeMap<String, List<com.xiaomi.midrop.b.g>>> {
    private TreeMap<String, List<com.xiaomi.midrop.b.g>> c = new TreeMap();
    private String d = "_";
    private List<com.xiaomi.midrop.b.g> e;

    public g(Context context) {
        super(context);
    }

    @Override
    protected final void a(com.xiaomi.midrop.b.g g2) {
        String string2 = j.c(g2.i);
        if (!TextUtils.equals((CharSequence)string2, (CharSequence)this.d)) {
            this.e = (List)this.c.get((Object)string2);
            if (this.e == null) {
                this.e = new ArrayList();
            }
            this.c.put((Object)string2, this.e);
            this.d = string2;
        }
        if (this.e == null) {
            this.e = new ArrayList();
        }
        if (!this.c.containsKey((Object)string2)) {
            this.c.put((Object)string2, this.e);
        }
        this.e.add((Object)g2);
    }

    @Override
    protected final void c() {
        this.c.clear();
    }
}

