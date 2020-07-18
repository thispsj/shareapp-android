/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.github.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
implements Iterable<Map.Entry<String, List<String>>> {
    public final Map<String, List<String>> a = new LinkedHashMap();

    public static String b(String string2) {
        if (string2 == null) {
            return null;
        }
        return string2.toUpperCase();
    }

    public final List<String> a(String string2) {
        return (List)this.a.get((Object)string2);
    }

    public final void a(String string2, String string3) {
        String string4 = b.b(string2);
        ArrayList arrayList = this.a(string4);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.a.put((Object)string4, (Object)arrayList);
        }
        arrayList.add((Object)string3);
    }

    public final boolean a() {
        String[] arrstring = new String[]{"ENCODING", null};
        for (int i2 = 0; i2 < 2; ++i2) {
            List<String> list = this.a(arrstring[i2]);
            if (list == null) continue;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                if (!"QUOTED-PRINTABLE".equalsIgnoreCase((String)iterator.next())) continue;
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        b b2 = (b)object;
        return this.a.equals(b2.a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final Iterator<Map.Entry<String, List<String>>> iterator() {
        return this.a.entrySet().iterator();
    }

    public final String toString() {
        return this.a.toString();
    }
}

