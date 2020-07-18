/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 */
package b.e.a.a;

import b.e.a.a.b.a;
import b.e.a.b;
import java.util.Map;

public class b
implements a$b,
b.e.a.b {
    private static b d;
    private static Object e;
    public boolean a;
    public a b;
    public boolean c = false;
    private b.a f;

    static {
        e = b.class;
    }

    private b() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b b() {
        Object object;
        Object object2 = object = e;
        synchronized (object2) {
            if (d != null) return d;
            d = new b();
            return d;
        }
    }

    @Override
    public final void a() {
        new StringBuilder("stop scan ").append(this.c);
        if (!this.c) {
            return;
        }
        this.b.b();
        this.a = false;
    }

    @Override
    public final void a(b.a a2) {
        new StringBuilder("start scan ").append(this.c);
        if (!this.c) {
            return;
        }
        this.f = a2;
        this.b.a();
        this.a = true;
    }

    @Override
    public final void a(b.e.a.b.a a2) {
        this.f.a(a2);
    }

    @Override
    public final void a(String string2) {
        this.b.c.remove((Object)string2);
    }

    @Override
    public final void b(b.e.a.b.a a2) {
        this.f.b(a2);
    }
}

