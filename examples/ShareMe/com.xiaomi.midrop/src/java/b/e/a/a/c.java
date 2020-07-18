/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.wifi.WifiManager
 *  java.lang.Object
 *  java.lang.String
 */
package b.e.a.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import b.e.a.a.a.a;
import midrop.service.c.d;

public final class c
implements b.e.a.c {
    private Context a;
    private a b;

    public c(Context context) {
        WifiManager wifiManager = (WifiManager)context.getApplicationContext().getSystemService("wifi");
        this.a = context;
        this.b = new a(context, wifiManager);
    }

    @Override
    public final int a() {
        d.b("WifiStationImpl", "doDisconnect", new Object[0]);
        return this.b.a();
    }

    @Override
    public final int a(String string2, String string3, String string4) {
        return this.b.a(string2, string3, string4, a.a.c, 25000);
    }
}

