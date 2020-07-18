/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.util.SparseArray
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Iterator
 *  midrop.service.transmitter.manipulator.a.b$1
 */
package midrop.service.transmitter.manipulator.a;

import android.content.Context;
import android.os.RemoteException;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import midrop.a.c.d;
import midrop.a.c.g;
import midrop.c.a.e;
import midrop.c.d.c;
import midrop.service.transmitter.manipulator.a.a.a;
import midrop.service.transmitter.manipulator.a.a.c;
import midrop.service.transmitter.manipulator.a.b;

public final class b {
    Context a;
    public SparseArray<a> b = new SparseArray();
    private HashSet<d> c = new HashSet();

    public b(Context context) {
        this.a = context;
        b.super.a((int)c.a.b.a(), midrop.service.transmitter.manipulator.a.a.b.a(context, midrop.c.a.b.b.b));
        b.super.a((int)c.a.d.a(), midrop.service.transmitter.manipulator.a.a.b.a(context, midrop.c.a.b.b.d));
    }

    private boolean a(int n2, a a2) {
        a2.a((a.a)new 1((b)this));
        this.b.put(n2, (Object)a2);
        return true;
    }

    public final int a(int n2, g g2) {
        a a2 = (a)this.b.get(n2);
        if (a2 == null) {
            try {
                g2.a(1, "discover not found");
                return 1;
            }
            catch (RemoteException remoteException) {
                remoteException.printStackTrace();
                return 1;
            }
        }
        try {
            g2.a();
        }
        catch (RemoteException remoteException) {
            remoteException.printStackTrace();
        }
        a2.a();
        return 0;
    }

    public final void a(d d2) {
        void var4_2 = this;
        synchronized (var4_2) {
            this.c.add((Object)d2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final void a(e e2) {
        void var7_2 = this;
        synchronized (var7_2) {
            Object[] arrobject = new Object[]{e2.a(), e2.f()};
            midrop.service.c.d.b("DiscoveryManager", String.format((String)"doDeviceFound: %s, %s", (Object[])arrobject), new Object[0]);
            Iterator iterator = this.c.iterator();
            while (iterator.hasNext()) {
                d d2 = (d)iterator.next();
                try {
                    d2.a(e2);
                }
                catch (RemoteException remoteException) {
                    remoteException.printStackTrace();
                    continue;
                }
                break;
            }
            return;
        }
    }

    public final int b(int n2, g g2) {
        a a2 = (a)this.b.get(n2);
        if (a2 == null) {
            try {
                g2.a(1, "discover not found");
                return 1;
            }
            catch (RemoteException remoteException) {
                remoteException.printStackTrace();
                return 1;
            }
        }
        a2.b();
        try {
            g2.a();
        }
        catch (RemoteException remoteException) {
            remoteException.printStackTrace();
        }
        return 0;
    }

    public final void b(d d2) {
        void var4_2 = this;
        synchronized (var4_2) {
            this.c.remove((Object)d2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b(e e2) {
        void var7_2 = this;
        synchronized (var7_2) {
            Object[] arrobject = new Object[]{e2.a()};
            midrop.service.c.d.b("DiscoveryManager", String.format((String)"doDeviceLost: %s", (Object[])arrobject), new Object[0]);
            Iterator iterator = this.c.iterator();
            while (iterator.hasNext()) {
                d d2 = (d)iterator.next();
                try {
                    d2.b(e2);
                }
                catch (RemoteException remoteException) {
                    remoteException.printStackTrace();
                    continue;
                }
                break;
            }
            return;
        }
    }

}

