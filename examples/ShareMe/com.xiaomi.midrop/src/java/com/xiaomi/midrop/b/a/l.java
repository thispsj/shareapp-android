/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.TreeMap
 */
package com.xiaomi.midrop.b.a;

import android.text.TextUtils;
import com.xiaomi.midrop.b.a.a;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.h;
import com.xiaomi.midrop.util.j;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public final class l
extends a<TreeMap<String, List<g>>> {
    TreeMap<String, List<g>> b = new TreeMap();
    String c = "_";
    List<g> d;
    private h.a e = new h.a(){

        @Override
        public final void a(int n2, List<g> list) {
            for (g g2 : list) {
                String string2 = j.c(g2.i);
                if (!TextUtils.equals((CharSequence)string2, (CharSequence)l.this.c)) {
                    l.this.d = (List)l.this.b.get((Object)string2);
                    if (l.this.d == null) {
                        l.this.d = new ArrayList();
                    }
                    l.this.b.put((Object)string2, l.this.d);
                    l.this.c = string2;
                }
                if (l.this.d == null) {
                    l.this.d = new ArrayList();
                }
                if (!l.this.b.containsKey((Object)string2)) {
                    l.this.b.put((Object)string2, l.this.d);
                }
                l.this.d.add((Object)g2);
            }
            l.this.a(l.this.b);
        }
    };

    @Override
    protected final /* synthetic */ Object b() {
        h.a().a(4, this.e);
        return this.b;
    }

    @Override
    protected final void c() {
        this.b.clear();
    }

}

