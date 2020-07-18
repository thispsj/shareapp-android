/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  midrop.a.c.a.a.a
 *  midrop.a.c.a.a.a$a
 */
package midrop.a.c.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import midrop.a.c.a.a.a;

public class b {
    private static b c;
    public Map<String, a> a = new HashMap();
    private final String b = b.class.getSimpleName();

    private b() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b a() {
        Class<b> class_ = b.class;
        synchronized (b.class) {
            if (c != null) return c;
            c = new b();
            return c;
        }
    }

    public final a a(String string2) {
        void var4_2 = this;
        synchronized (var4_2) {
            a a2 = (a)this.a.get((Object)string2);
            return a2;
        }
    }

    public final void a(a a2) {
        void var6_2 = this;
        synchronized (var6_2) {
            Object[] arrobject = new Object[]{a2.b(), a2.a()};
            String.format((String)"addFileReceiver()--[DeviceId=%s],[DeviceName=%s]", (Object[])arrobject);
            this.a.put((Object)a2.b(), (Object)a2);
            return;
        }
    }

    public final a b() {
        for (a a2 : this.a.values()) {
            if (!a2.b.b()) continue;
            return a2;
        }
        return null;
    }

    public final void b(String string2) {
        void var5_2 = this;
        synchronized (var5_2) {
            String.format((String)"removeFileReceiver()--[DeviceId=%s]", (Object[])new Object[]{string2});
            this.a.remove((Object)string2);
            return;
        }
    }

    public final a c() {
        for (a a2 : this.a.values()) {
            if (a2.b.a() != a.a.b.c) continue;
            return a2;
        }
        return null;
    }

    public final ArrayList<a> d() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            arrayList.add((Object)((a)iterator.next()));
        }
        return arrayList;
    }
}

