/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.os.Binder
 *  android.os.RemoteException
 *  android.util.SparseArray
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.List
 *  midrop.a.c.c$a
 *  midrop.c.a.b.c
 *  midrop.service.transmitter.manipulator.b.a
 *  midrop.service.transmitter.manipulator.b.b.a
 *  midrop.service.transmitter.manipulator.b.b.b
 *  midrop.service.transmitter.manipulator.b.b.c
 *  midrop.service.transmitter.manipulator.b.b.d
 *  midrop.service.transmitter.manipulator.b.c
 *  midrop.service.transmitter.manipulator.b.d
 *  midrop.service.transmitter.manipulator.b.e
 */
package midrop.service.transmitter.manipulator;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.RemoteException;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;
import midrop.a.c.c;
import midrop.a.c.g;
import midrop.a.c.h;
import midrop.a.c.i;
import midrop.a.c.j;
import midrop.a.c.l;
import midrop.c.c.f;
import midrop.c.d.c;
import midrop.service.transmitter.manipulator.b.b.b;
import midrop.service.transmitter.manipulator.b.b.c;
import midrop.service.transmitter.manipulator.b.b.d;
import midrop.service.transmitter.manipulator.b.b.e;

public class a
extends c.a {
    private static a a;
    private static Object b;
    private boolean c;
    private Context d;
    private b.f.c e;
    private midrop.service.transmitter.manipulator.a.b f;

    static {
        b = a.class;
    }

    private a() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a b() {
        Object object;
        Object object2 = object = b;
        synchronized (object2) {
            if (a != null) return a;
            a = new a();
            return a;
        }
    }

    private String d() {
        int n2 = Binder.getCallingUid();
        return this.d.getPackageManager().getNameForUid(n2);
    }

    public final int a() throws RemoteException {
        midrop.service.transmitter.manipulator.a.a.a().b();
        return 0;
    }

    public final int a(int n2, g g2) throws RemoteException {
        return this.f.a(n2, g2);
    }

    public final int a(midrop.a.c.d d2) throws RemoteException {
        this.f.a(d2);
        return 0;
    }

    public final int a(midrop.c.a.a.a a2, h h2) throws RemoteException {
        Object[] arrobject = new Object[4];
        arrobject[0] = a2.a();
        String string2 = (String)a2.a(midrop.c.a.a.b.d);
        midrop.c.a.b.c c2 = new midrop.c.a.b.c();
        c2.a(string2);
        arrobject[1] = c2;
        arrobject[2] = a2.b();
        arrobject[3] = a.super.d();
        String.format((String)"invoke: [%s].[%s].[%s] (%s)", (Object[])arrobject);
        return this.e.a((b.f.a)new midrop.service.transmitter.manipulator.b.b.a(a.super.d(), a2, h2));
    }

    public final int a(midrop.c.a.a.d d2, g g2) throws RemoteException {
        Object[] arrobject = new Object[]{d2.a(), d2.b().toString()};
        String.format((String)"writeProperty: [%s].[%s]", (Object[])arrobject);
        for (midrop.c.c.d d3 : d2.a.a) {
            Object[] arrobject2 = new Object[]{d3.a.d, d3.b.a().toString()};
            String.format((String)"   %s = %s", (Object[])arrobject2);
        }
        return this.e.a((b.f.a)new c(a.super.d(), d2, g2));
    }

    public final int a(midrop.c.a.a.d d2, g g2, i i2, l l2) throws RemoteException {
        if (d2.a.a.size() == 0) {
            return 1;
        }
        e e2 = new e();
        e2.a = a.super.d();
        e2.b = d2.a();
        e2.c = d2.b();
        e2.d = d2.c();
        e2.f = l2;
        Iterator iterator = d2.a.a.iterator();
        while (iterator.hasNext()) {
            e2.a((midrop.c.c.d)iterator.next(), i2);
        }
        Object[] arrobject = new Object[]{e2.b, e2.c, a.super.d()};
        String.format((String)"addPropertyChangedListener: [%s].[%s] (%s)", (Object[])arrobject);
        return this.e.a((b.f.a)new d(e2, g2, d.a.a));
    }

    public final int a(midrop.c.a.a.d d2, j j2) throws RemoteException {
        Object[] arrobject = new Object[]{d2.a(), d2.b().toString()};
        String.format((String)"readProperty: [%s].[%s]", (Object[])arrobject);
        for (midrop.c.c.d d3 : d2.a.a) {
            Object[] arrobject2 = new Object[]{d3.a.d};
            String.format((String)"  property: %s", (Object[])arrobject2);
        }
        return this.e.a((b.f.a)new b(a.super.d(), d2, j2));
    }

    public final void a(Context context) {
        void var3_2 = this;
        synchronized (var3_2) {
            if (!this.c) {
                this.c = true;
                this.d = context.getApplicationContext();
                this.e = new b.f.c();
                this.e.a((b.f.d)new midrop.service.transmitter.manipulator.b.a(this.d, "JobActionInvocation"));
                this.e.a((b.f.d)new midrop.service.transmitter.manipulator.b.c(this.d, "JobPropertyGetting"));
                this.e.a((b.f.d)new midrop.service.transmitter.manipulator.b.d(this.d, "JobPropertySetting"));
                this.e.a((b.f.d)new midrop.service.transmitter.manipulator.b.e(this.d, "JobPropertySubscription"));
                this.e.a();
                this.f = new midrop.service.transmitter.manipulator.a.b(this.d);
            }
            return;
        }
    }

    public final void a(midrop.c.a.e e2) {
        midrop.service.transmitter.manipulator.a.b b2 = this.f;
        midrop.service.transmitter.manipulator.a.a.a().b(e2.a());
        try {
            ((midrop.service.transmitter.manipulator.a.a.a)b2.b.get((int)c.a.d.a())).a(e2.g(), e2.e());
            ((midrop.service.transmitter.manipulator.a.a.a)b2.b.get((int)c.a.b.a())).a(e2.g(), e2.e());
        }
        catch (Exception exception) {
            new StringBuilder("exception for removing item e=").append((Object)exception);
        }
        b2.b(e2);
    }

    public final int b(int n2, g g2) throws RemoteException {
        return this.f.b(n2, g2);
    }

    public final int b(midrop.a.c.d d2) throws RemoteException {
        this.f.b(d2);
        return 0;
    }

    public final int b(midrop.c.a.a.d d2, g g2) throws RemoteException {
        if (d2.a.a.size() == 0) {
            return 1;
        }
        e e2 = new e();
        e2.a = a.super.d();
        e2.b = d2.a();
        e2.c = d2.b();
        e2.d = d2.c();
        e2.f = null;
        Iterator iterator = d2.a.a.iterator();
        while (iterator.hasNext()) {
            e2.a((midrop.c.c.d)iterator.next(), null);
        }
        Object[] arrobject = new Object[]{e2.b, e2.c, a.super.d()};
        String.format((String)"removePropertyChangedListener: [%s].[%s] (%s)", (Object[])arrobject);
        return this.e.a((b.f.a)new d(e2, g2, d.a.b));
    }

    public final void c() {
        a a2 = this;
        synchronized (a2) {
            if (this.c) {
                this.c = false;
                this.e.b();
            }
            return;
        }
    }
}

