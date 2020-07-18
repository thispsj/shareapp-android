/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.util.Log
 *  java.lang.Enum
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 */
package midrop.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import midrop.service.c.d;

public abstract class a {
    private static final String b = "a";
    protected Context a;
    private ServiceConnection c;
    private final b d;

    public a(Context context) {
        this.d = new b((a)this, 0);
        this.a = context;
    }

    public final Context a() {
        return this.a;
    }

    public abstract void a(IBinder var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected final boolean a(String string2, String string3) {
        void var16_3 = this;
        synchronized (var16_3) {
            if (this.a == null) {
                Log.d((String)b, (String)"context is null");
            } else if (this.d.b != c.a) {
                String string4 = b;
                Object[] arrobject = new Object[]{this.d.b.toString()};
                d.b(string4, String.format((String)"bind, but serviceState is: %s", (Object[])arrobject), new Object[0]);
            } else {
                this.d.b = c.b;
                a a2 = new a((a)this, 0);
                Intent intent = new Intent(string3);
                intent.setPackage(string2);
                if (this.a.bindService(intent, (ServiceConnection)a2, 1)) {
                    b b2;
                    this.c = a2;
                    b b3 = b2 = this.d;
                    synchronized (b3) {
                        if (this.d.b == c.b) {
                            Log.d((String)b, (String)String.format((String)"(%s) waiting...", (Object[])new Object[]{string3}));
                            try {
                                this.d.a = true;
                                this.d.wait();
                                this.d.a = false;
                            }
                            catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                        }
                    }
                } else {
                    this.d.b = c.a;
                }
            }
            c c2 = this.d.b;
            c c3 = c.c;
            return c2 == c3;
            {
            }
        }
    }

    public final boolean b() {
        a a2 = this;
        synchronized (a2) {
            block6 : {
                if (this.d.b == c.a) {
                    String string2 = b;
                    Object[] arrobject = new Object[]{this.d.b.toString()};
                    d.b(string2, String.format((String)"unbind, but serviceState is: %s", (Object[])arrobject), new Object[0]);
                } else {
                    if (this.c != null) {
                        this.a.unbindService(this.c);
                        this.c = null;
                        this.d();
                    }
                    this.d.b = c.a;
                }
                c c2 = this.d.b;
                c c3 = c.a;
                if (c2 != c3) break block6;
                return true;
            }
            return false;
        }
    }

    protected final boolean c() {
        return this.d.b == c.c;
    }

    public abstract void d();

    private final class a
    implements ServiceConnection {
        final /* synthetic */ a a;

        private a(a a2) {
            this.a = a2;
        }

        /* synthetic */ a(a a2, byte by) {
            super(a2);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b b2;
            b;
            Object[] arrobject = new Object[]{componentName.getShortClassName()};
            String.format((String)"onServiceConnected: %s", (Object[])arrobject);
            this.a.a(iBinder);
            b b3 = b2 = this.a.d;
            synchronized (b3) {
                a.a((a)this.a).b = c.c;
                if (a.a((a)this.a).a) {
                    this.a.d.notify();
                }
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public final void onServiceDisconnected(ComponentName componentName) {
            b b2;
            b;
            Object[] arrobject = new Object[]{componentName.getShortClassName()};
            String.format((String)"onServiceDisconnected: %s", (Object[])arrobject);
            b b3 = b2 = this.a.d;
            synchronized (b3) {
                a.a((a)this.a).b = c.a;
                if (a.a((a)this.a).a) {
                    this.a.d.notify();
                }
            }
            this.a.d();
        }
    }

    private final class b {
        boolean a;
        c b;
        final /* synthetic */ a c;

        private b(a a2) {
            this.c = a2;
            this.a = false;
            this.b = c.a;
        }

        /* synthetic */ b(a a2, byte by) {
            super(a2);
        }
    }

    private static final class c
    extends Enum<c> {
        public static final /* enum */ c a = new c();
        public static final /* enum */ c b = new c();
        public static final /* enum */ c c = new c();
        private static final /* synthetic */ c[] d;

        static {
            c[] arrc = new c[]{a, b, c};
            d = arrc;
        }

        public static c valueOf(String string2) {
            return (c)Enum.valueOf(c.class, (String)string2);
        }

        public static c[] values() {
            return (c[])d.clone();
        }
    }

}

