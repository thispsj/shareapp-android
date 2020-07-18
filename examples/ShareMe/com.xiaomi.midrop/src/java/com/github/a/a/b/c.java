/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.github.a.a.b;

import com.github.a.a.a;
import java.util.HashMap;
import java.util.Map;

public final class c {
    public a a;
    public final Map<String, Map<String, a>> b = new HashMap();

    public c(a a2) {
        this.a = a2;
    }

    public final void a(String string2, String string3, a a2) {
        String string4 = string2.toUpperCase();
        Map map = (Map)this.b.get((Object)string4);
        if (map == null) {
            map = new HashMap();
            this.b.put((Object)string4, (Object)map);
        }
        map.put((Object)string3, (Object)a2);
    }
}

