/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  midrop.c.a.b.c
 */
package midrop.service.transmitter.manipulator.b.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import midrop.a.c.i;
import midrop.a.c.l;
import midrop.c.a.b.c;
import midrop.c.c.d;

public final class e {
    public String a;
    public String b;
    public c c;
    public String d;
    public Map<d, i> e = new HashMap();
    public l f;

    public final List<d> a() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.e.keySet().iterator();
        while (iterator.hasNext()) {
            arrayList.add((Object)((d)iterator.next()));
        }
        return arrayList;
    }

    public final boolean a(d d2, i i2) {
        if ((i)this.e.get((Object)d2) != null) {
            return false;
        }
        this.e.put((Object)d2, (Object)i2);
        return true;
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
        e e2 = (e)object;
        if (this.a == null ? e2.a != null : !this.a.equals((Object)e2.a)) {
            return false;
        }
        if (this.b == null ? e2.b != null : !this.b.equals((Object)e2.b)) {
            return false;
        }
        return !(this.c == null ? e2.c != null : !this.c.equals((Object)e2.c));
    }

    public final int hashCode() {
        int n2 = this.a == null ? 0 : this.a.hashCode();
        int n3 = 31 * (n2 + 31);
        int n4 = this.b == null ? 0 : this.b.hashCode();
        int n5 = 31 * (n3 + n4);
        int n6 = this.c == null ? 0 : this.c.hashCode();
        return n5 + n6;
    }
}

