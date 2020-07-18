/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.TreeMap
 */
package com.xiaomi.midrop.b.a;

import android.text.TextUtils;
import com.xiaomi.midrop.b.a.k;
import com.xiaomi.midrop.b.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public final class i
extends k<TreeMap<String, List<g>>> {
    private TreeMap<String, List<g>> b = new TreeMap();
    private String c = "_";
    private List<g> d;

    @Override
    protected final void a(g g2) {
        String string2 = g2.i.substring(0, g2.i.lastIndexOf(File.separator));
        if (!TextUtils.equals((CharSequence)string2, (CharSequence)this.c)) {
            this.d = (List)this.b.get((Object)string2);
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.b.put((Object)string2, this.d);
            this.c = string2;
        }
        this.d.add((Object)g2);
    }

    @Override
    protected final void c() {
        this.b.clear();
    }
}

