/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.net.ServerSocket
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package b.c.a.a;

import b.c.a;
import b.c.a.a.b;
import b.c.a.a.c;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Map;
import java.util.Set;
import midrop.service.c.d;

public final class a
implements b.c.a,
b.a {
    private b a = new b();
    private a.a b;

    @Override
    public final int a(String string2) {
        b b2 = this.a;
        for (Map.Entry entry : b2.a.entrySet()) {
            String string3 = (String)entry.getKey();
            if (!((String)entry.getValue()).equals((Object)string2)) continue;
            b2.a.remove((Object)string3);
            break;
        }
        return 0;
    }

    @Override
    public final String a(String string2, String string3) {
        if (string3 == null) {
            return null;
        }
        b b2 = this.a;
        StringBuilder stringBuilder = new StringBuilder("/");
        stringBuilder.append(string2);
        String string4 = stringBuilder.toString();
        b2.a.put((Object)string4, (Object)string3);
        StringBuilder stringBuilder2 = new StringBuilder(":");
        stringBuilder2.append(b2.a());
        stringBuilder2.append(string4);
        return stringBuilder2.toString();
    }

    @Override
    public final void a(a.a a2) {
        this.b = a2;
    }

    @Override
    public final void a(String string2, long l2, long l3, long l4) {
        if (this.b != null) {
            this.b.a(string2, l2, l3, l4);
        }
    }

    @Override
    public final boolean a() {
        try {
            this.a.b = this;
            this.a.b();
            return true;
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = new StringBuilder("HttpServer start failed, exception: ");
            stringBuilder.append((Object)iOException);
            d.b("HttpFileServerImpl", stringBuilder.toString(), new Object[0]);
            iOException.printStackTrace();
            return false;
        }
    }

    @Override
    public final void b() {
        this.a.c();
    }

    @Override
    public final int c() {
        this.a.a.clear();
        return 0;
    }

    @Override
    public final boolean d() {
        b b2 = this.a;
        boolean bl = b2.c != null && b2.d != null;
        return bl && !b2.c.isClosed() && b2.d.isAlive();
    }
}

