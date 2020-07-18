/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package midrop.service.transmitter.manipulator.a;

import java.util.HashMap;
import java.util.Map;
import midrop.c.a.e;

public class a {
    private static a b;
    private static Object c;
    private final String a = this.getClass().getSimpleName();
    private Map<String, e> d = new HashMap();

    static {
        c = a.class;
    }

    private a() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a() {
        Object object;
        Object object2 = object = c;
        synchronized (object2) {
            if (b != null) return b;
            b = new a();
            return b;
        }
    }

    public final e a(String string2) {
        void var4_2 = this;
        synchronized (var4_2) {
            e e2 = (e)this.d.get((Object)string2);
            return e2;
        }
    }

    public final void a(e e2) {
        void var4_2 = this;
        synchronized (var4_2) {
            this.d.put((Object)e2.a(), (Object)e2);
            return;
        }
    }

    public final void b() {
        a a2 = this;
        synchronized (a2) {
            this.d.clear();
            return;
        }
    }

    public final void b(String string2) {
        void var4_2 = this;
        synchronized (var4_2) {
            this.d.remove((Object)string2);
            return;
        }
    }
}

