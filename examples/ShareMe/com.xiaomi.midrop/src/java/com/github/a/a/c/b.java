/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumMap
 *  java.util.HashMap
 *  java.util.Map
 */
package com.github.a.a.c;

import com.github.a.a.a;
import com.github.a.a.c.a;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static final Map<a, Map<Boolean, com.github.a.a.c.a>> a = new EnumMap(a.class);
    private static final Map<a, Map<Boolean, com.github.a.a.c.a>> b;
    private static final Map<a, Map<Boolean, com.github.a.a.c.a>> c;
    private static final Map<a, Map<Boolean, Map<Boolean, com.github.a.a.c.a>>> d;

    static {
        a a2 = a.a;
        HashMap hashMap = new HashMap();
        hashMap.put((Object)false, (Object)new a.a().a().b("\r\n:.;").c());
        hashMap.put((Object)true, (Object)new a.a().b().b("[]=:.,").b(';').c());
        a.put((Object)a2, (Object)hashMap);
        a a3 = a.b;
        HashMap hashMap2 = new HashMap();
        hashMap2.put((Object)false, ((Map)a.get((Object)a.a)).get((Object)false));
        hashMap2.put((Object)true, (Object)new a.a().a(65, 90).a(97, 122).a(48, 57).a('-').c());
        a.put((Object)a3, (Object)hashMap2);
        b = a;
        c = new EnumMap(a.class);
        a a4 = a.a;
        HashMap hashMap3 = new HashMap();
        hashMap3.put((Object)false, (Object)new a.a().a().b("\r\n:;=").c());
        hashMap3.put((Object)true, ((Map)a.get((Object)a4)).get((Object)true));
        c.put((Object)a4, (Object)hashMap3);
        a a5 = a.b;
        HashMap hashMap4 = new HashMap();
        hashMap4.put((Object)false, ((Map)c.get((Object)a.a)).get((Object)false));
        hashMap4.put((Object)true, ((Map)a.get((Object)a5)).get((Object)true));
        c.put((Object)a5, (Object)hashMap4);
        d = new EnumMap(a.class);
        a a6 = a.a;
        HashMap hashMap5 = new HashMap();
        HashMap hashMap6 = new HashMap();
        hashMap6.put((Object)false, (Object)new a.a().a().b("\r\n:").c());
        com.github.a.a.c.a a7 = (com.github.a.a.c.a)((Map)c.get((Object)a6)).get((Object)true);
        hashMap6.put((Object)true, (Object)new a.a(a7).a(';').c());
        hashMap5.put((Object)false, (Object)hashMap6);
        hashMap5.put((Object)true, hashMap5.get((Object)false));
        d.put((Object)a6, (Object)hashMap5);
        a a8 = a.b;
        HashMap hashMap7 = new HashMap();
        HashMap hashMap8 = new HashMap();
        hashMap8.put((Object)false, (Object)new a.a().a().b("\r\n\"").c());
        Boolean bl = true;
        a.a a9 = new a.a().b();
        a9.a = true;
        hashMap8.put((Object)bl, (Object)a9.a('\t').b('\"').c());
        hashMap7.put((Object)false, (Object)hashMap8);
        HashMap hashMap9 = new HashMap();
        hashMap9.put((Object)false, (Object)new a.a().a().c());
        Boolean bl2 = true;
        a.a a10 = new a.a().b();
        a10.a = true;
        hashMap9.put((Object)bl2, (Object)a10.a("\r\n\t").c());
        hashMap7.put((Object)true, (Object)hashMap9);
        d.put((Object)a8, (Object)hashMap7);
    }

    public static com.github.a.a.c.a a(a a2) {
        return (com.github.a.a.c.a)((Map)b.get((Object)a2)).get((Object)true);
    }

    public static boolean a(String string2, a a2) {
        return b.b(a2).a(string2);
    }

    public static com.github.a.a.c.a b(a a2) {
        return (com.github.a.a.c.a)((Map)c.get((Object)a2)).get((Object)true);
    }

    public static boolean b(String string2, a a2) {
        return b.c(a2).a(string2);
    }

    public static com.github.a.a.c.a c(a a2) {
        return (com.github.a.a.c.a)((Map)((Map)d.get((Object)a2)).get((Object)false)).get((Object)true);
    }
}

