/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.zxing.a
 *  com.google.zxing.e
 *  com.google.zxing.k
 *  com.google.zxing.o
 *  com.journeyapps.barcodescanner.j
 *  com.journeyapps.barcodescanner.k
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.EnumMap
 *  java.util.Map
 */
package com.journeyapps.barcodescanner;

import com.google.zxing.a;
import com.google.zxing.o;
import com.journeyapps.barcodescanner.e;
import com.journeyapps.barcodescanner.f;
import com.journeyapps.barcodescanner.j;
import com.journeyapps.barcodescanner.k;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

public final class i
implements f {
    private Collection<a> a;
    private Map<com.google.zxing.e, ?> b;
    private String c;
    private int d;

    public i() {
    }

    public i(Collection<a> collection, Map<com.google.zxing.e, ?> map, String string2, int n2) {
        this.a = collection;
        this.b = map;
        this.c = string2;
        this.d = n2;
    }

    @Override
    public final e a(Map<com.google.zxing.e, ?> map) {
        EnumMap enumMap = new EnumMap(com.google.zxing.e.class);
        enumMap.putAll(map);
        if (this.b != null) {
            enumMap.putAll(this.b);
        }
        if (this.a != null) {
            enumMap.put((Object)com.google.zxing.e.c, this.a);
        }
        if (this.c != null) {
            enumMap.put((Object)com.google.zxing.e.e, (Object)this.c);
        }
        com.google.zxing.k k2 = new com.google.zxing.k();
        k2.a((Map)enumMap);
        switch (this.d) {
            default: {
                return new e((o)k2);
            }
            case 2: {
                return new k((o)k2);
            }
            case 1: {
                return new j((o)k2);
            }
            case 0: 
        }
        return new e((o)k2);
    }
}

