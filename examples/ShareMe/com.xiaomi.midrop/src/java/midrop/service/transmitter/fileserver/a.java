/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 *  android.os.RemoteCallbackList
 *  android.os.RemoteException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  midrop.a.c.f$a
 *  midrop.service.transmitter.fileserver.b
 */
package midrop.service.transmitter.fileserver;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import b.c.a;
import midrop.a.c.e;
import midrop.a.c.f;
import midrop.service.c.d;
import midrop.service.transmitter.fileserver.b;

public class a
extends f.a {
    private static final String a = "a";
    private b b;
    private String c;

    public a(String string2, b b2) {
        this.c = string2;
        this.b = b2;
    }

    public final int a() throws RemoteException {
        int n2;
        b b2 = this.b;
        if (b.c) {
            return 0;
        }
        if (b2.b == null) {
            b2.b = new b.c.a.a.a();
        }
        if (b2.b.a()) {
            b2.b.a((a.a)b2);
            n2 = 0;
        } else {
            b2.b = null;
            n2 = 7001;
            d.b(b.a, "HttpFileServer start failed", new Object[0]);
        }
        boolean bl = false;
        if (n2 == 0) {
            bl = true;
        }
        b.c = bl;
        return n2;
    }

    public final int a(String string2) throws RemoteException {
        b b2 = this.b;
        String.format((String)"removeFile(%s)", (Object[])new Object[]{string2});
        if (b2.b != null) {
            return b2.b.a(string2);
        }
        return 3;
    }

    public final int a(e e2) throws RemoteException {
        b b2 = this.b;
        if (e2 != null) {
            b2.d.register((IInterface)e2);
        }
        return 0;
    }

    public final String a(String string2, String string3) throws RemoteException {
        b b2 = this.b;
        if (b2.b != null) {
            return b2.b.a(string2, string3);
        }
        return null;
    }

    public final int b() throws RemoteException {
        b b2 = this.b;
        b.c = false;
        if (b2.b != null) {
            b2.b.c();
            b2.b.a((a.a)null);
            b2.b.b();
            return 0;
        }
        return 3;
    }

    public final int b(e e2) throws RemoteException {
        b b2 = this.b;
        if (e2 != null) {
            b2.d.unregister((IInterface)e2);
        }
        return 0;
    }

    public final int c() throws RemoteException {
        int n2;
        b b2 = this.b;
        if (b2.b != null) {
            n2 = b2.b.c();
            for (int i2 = 0; i2 < b2.d.getRegisteredCallbackCount(); ++i2) {
                try {
                    b2.d.unregister(b2.d.getBroadcastItem(i2));
                    continue;
                }
                catch (NullPointerException nullPointerException) {
                    nullPointerException.printStackTrace();
                }
            }
        } else {
            n2 = 3;
        }
        return n2;
    }

    public final boolean d() throws RemoteException {
        b b2 = this.b;
        return b2.b != null && b.c && b2.b.d();
    }
}

