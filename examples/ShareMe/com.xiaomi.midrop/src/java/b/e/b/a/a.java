/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.net.wifi.WifiManager
 *  android.net.wifi.p2p.WifiP2pManager
 *  android.net.wifi.p2p.WifiP2pManager$ActionListener
 *  android.net.wifi.p2p.WifiP2pManager$Channel
 *  android.util.Log
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.HashMap
 */
package b.e.b.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;
import b.e.b.a.a.a;
import java.util.HashMap;
import midrop.service.c.d;

public class a
implements b.e.b.a {
    private static final String a = "a";
    private static a b;
    private static Object c;
    private Context d;
    private b.e.b.a.a.a e;
    private a f;

    static {
        c = a.class;
    }

    private a(Context context) {
        this.f = new Object((a)this, 0){
            public boolean a;
            public boolean b;
            String c;
            String d;
            String e;
            String f;
            final /* synthetic */ a g;
            {
                this.g = a2;
                this.a = false;
                this.b = false;
            }
        };
        this.d = context;
        this.e = new b.e.b.a.a.a(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a(Context context) {
        Object object;
        Object object2 = object = c;
        synchronized (object2) {
            if (b != null) return b;
            b = new a(context);
            return b;
        }
    }

    @Override
    public final boolean a() {
        d.b(a, "doDestroy", new Object[0]);
        if (this.f.a) {
            this.e.a(null);
            this.f.a = false;
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final boolean a(boolean bl) {
        a a2;
        d.b(a, "doInitialize", new Object[0]);
        long l2 = System.currentTimeMillis();
        if (this.f.a) {
            a a3;
            d.b(a, "GroupOwner is opened, must close it.", new Object[0]);
            this.e.a(new a$a(){

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                @Override
                public final void a() {
                    a a2;
                    a a3 = a2 = a.this.f;
                    synchronized (a3) {
                        if (a.a((a)a.this).b) {
                            a.this.f.notify();
                        }
                        return;
                    }
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                @Override
                public final void b() {
                    a a2;
                    a a3 = a2 = a.this.f;
                    synchronized (a3) {
                        if (a.a((a)a.this).b) {
                            a.this.f.notify();
                        }
                        return;
                    }
                }
            });
            a a4 = a3 = this.f;
            synchronized (a4) {
                this.f.b = true;
                try {
                    this.f.wait(2000L);
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                this.f.b = false;
            }
            this.f.a = false;
        }
        b.e.b.a.a.a a5 = this.e;
        a$b b2 = new a$b(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public final void a() {
                a a2;
                a a3 = a2 = a.this.f;
                synchronized (a3) {
                    if (a.a((a)a.this).b) {
                        a.a((a)a.this).a = false;
                        a.this.f.notify();
                    }
                    return;
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public final void a(String string2, String string3, String string4, String string5) {
                a a2;
                a a3 = a2 = a.this.f;
                synchronized (a3) {
                    if (a.a((a)a.this).b) {
                        a.a((a)a.this).a = true;
                        a.a((a)a.this).c = string2;
                        a.a((a)a.this).d = string3;
                        a.a((a)a.this).e = string4;
                        a.a((a)a.this).f = string5;
                        a.this.f.notify();
                    }
                    return;
                }
            }
        };
        Log.d((String)b.e.b.a.a.a.a, (String)"open");
        if (!a5.e) {
            a5.e = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.p2p.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.p2p.PEERS_CHANGED");
            intentFilter.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.p2p.THIS_DEVICE_CHANGED");
            Log.d((String)b.e.b.a.a.a.a, (String)"registerMyReceiver");
            a5.b.registerReceiver((BroadcastReceiver)a5.f, intentFilter);
        }
        Log.d((String)b.e.b.a.a.a.a, (String)"enableWifiIfNecessary");
        if (!a5.c.isWifiEnabled()) {
            a5.i = a$d.b;
            a5.c.setWifiEnabled(true);
        } else {
            a5.i = a$d.a;
        }
        a5.h = b2;
        a5.j = "";
        a5.k.clear();
        a5.d.removeGroup(a5.g, new WifiP2pManager.ActionListener(a5, bl){
            final /* synthetic */ boolean a;
            final /* synthetic */ b.e.b.a.a.a b;
            {
                this.b = a2;
                this.a = bl;
            }

            public final void onFailure(int n2) {
                String string2 = b.e.b.a.a.a.a();
                java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder("remove group failed: ");
                stringBuilder.append(b.e.b.a.a.b.a(n2));
                d.b(string2, stringBuilder.toString(), new Object[0]);
                b.e.b.a.a.a.a(this.b, this.a);
            }

            public final void onSuccess() {
                b.e.b.a.a.a.a(this.b, this.a);
            }
        });
        a a6 = a2 = this.f;
        synchronized (a6) {
            this.f.b = true;
            try {
                this.f.wait(2000L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            this.f.b = false;
        }
        long l3 = System.currentTimeMillis();
        String string2 = a;
        Object[] arrobject = new Object[]{Boolean.toString((boolean)this.f.a), l3 - l2};
        d.b(string2, String.format((String)"doInitialize -> %s [%d ms]", (Object[])arrobject), new Object[0]);
        return this.f.a;
    }

    @Override
    public final String b() {
        return this.f.d;
    }

    @Override
    public final String c() {
        return this.f.e;
    }

    @Override
    public final String d() {
        return this.f.c;
    }

}

