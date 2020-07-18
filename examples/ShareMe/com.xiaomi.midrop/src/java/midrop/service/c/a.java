/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.lang.reflect.Method
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package midrop.service.c;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import b.a.k;
import b.a.o;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.util.y;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import midrop.service.c.c;
import midrop.service.c.d;

public final class a {
    public BluetoothAdapter a = BluetoothAdapter.getDefaultAdapter();
    public a b;
    int c;
    boolean d;
    public int e = b.a;
    boolean f;
    public String g;
    boolean h;
    Handler i = new Handler();
    AtomicBoolean j = new AtomicBoolean(false);
    private boolean k = true;
    private boolean l = false;
    private String m;
    private BroadcastReceiver n = new BroadcastReceiver(){

        public final void onReceive(Context context, Intent intent) {
            String string2 = intent.getAction();
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals((Object)string2)) {
                int n2 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
                if (n2 != 13) {
                    if (n2 == 10) {
                        if (a.this.j.get()) {
                            Intent intent2 = new Intent("com.xiaomi.midrop.ACTION_BLUETOOTH_OFF_EXCEPTION");
                            intent2.setPackage("com.xiaomi.midrop");
                            MiDropApplication.a().sendBroadcast(intent2);
                            return;
                        }
                        a.this.i.postDelayed(new Runnable(){

                            public final void run() {
                                a a2 = a.this;
                                if (a2.d) {
                                    a2.c();
                                    a2.d = false;
                                    return;
                                }
                                if (Build.VERSION.SDK_INT >= 26) {
                                    a2.b(false);
                                }
                            }
                        }, 1000L);
                        return;
                    }
                    if (n2 != 11 && n2 == 12) {
                        if (a.this.e == b.b) {
                            if (a.this.h) {
                                a.a(a.this);
                            }
                            if (a.this.a.getScanMode() != 23) {
                                a.this.d();
                                return;
                            }
                            a.this.b(true);
                            return;
                        }
                        if (a.this.e == b.c) {
                            a.this.b(true);
                        }
                    }
                }
                return;
            }
            if ("android.bluetooth.adapter.action.SCAN_MODE_CHANGED".equals((Object)string2)) {
                int n3 = intent.getIntExtra("android.bluetooth.adapter.extra.SCAN_MODE", 20);
                if (a.this.f) {
                    if (a.this.c == 23 && n3 != 23 && a.this.b == null) {
                        MiDropApplication.a().sendBroadcast(new Intent("com.xiaomi.midrop.ACTION_BLUETOOTH_NOT_DISCOVERABLE"));
                    } else if (n3 == 23) {
                        a.this.b(true);
                    }
                }
                a.this.c = n3;
                return;
            }
            if ("com.xiaomi.midrop.ACTION_BLUETOOTH_CLOSED".equals((Object)string2)) {
                a.this.f = false;
                return;
            }
            if ("android.bluetooth.adapter.action.LOCAL_NAME_CHANGED".equals((Object)string2)) {
                String string3 = intent.getStringExtra("android.bluetooth.adapter.extra.LOCAL_NAME");
                if (a.this.h && !TextUtils.isEmpty((CharSequence)a.this.g) && !TextUtils.equals((CharSequence)string3, (CharSequence)a.this.g)) {
                    a.a(a.this);
                }
                return;
            }
            if ("com.xiaomi.midrop.action.START_ADVERTISE_BT_NAME".equals((Object)string2)) {
                a.this.h = true;
                a.a(a.this);
                a.this.d();
                return;
            }
            if ("com.xiaomi.midrop.action.STOP_ADVERTISE_BT_NAME".equals((Object)string2)) {
                a.this.h = false;
                if (!a.this.e()) {
                    d.b("BluetoothOpener", "restore bt name failed", new Object[0]);
                }
            }
        }

    };

    static /* synthetic */ boolean a(a a2) {
        a2.g = k.a(c.a(), k.a.a, y.C());
        return o.a(a2.a, a2.g);
    }

    public final void a() {
        if (this.l) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
        intentFilter.addAction("com.xiaomi.midrop.ACTION_BLUETOOTH_CLOSED");
        intentFilter.addAction("android.bluetooth.adapter.action.LOCAL_NAME_CHANGED");
        intentFilter.addAction("com.xiaomi.midrop.action.START_ADVERTISE_BT_NAME");
        intentFilter.addAction("com.xiaomi.midrop.action.STOP_ADVERTISE_BT_NAME");
        MiDropApplication.a().registerReceiver(this.n, intentFilter);
        this.l = true;
    }

    public final void a(a a2) {
        if (this.b != null) {
            d.b("BluetoothOpener", "action listener(discoverable) not null", new Object[0]);
        }
        this.b = a2;
        if (this.a == null) {
            d.b("BluetoothOpener", "bluetooth adapter null", new Object[0]);
            this.b(false);
            return;
        }
        this.e = b.b;
        this.f = true;
        BluetoothAdapter bluetoothAdapter = this.a;
        String string2 = bluetoothAdapter != null && bluetoothAdapter.isEnabled() ? bluetoothAdapter.getName() : "";
        this.m = string2;
        if (this.a.isEnabled()) {
            this.b(true);
            return;
        }
        this.c();
    }

    public final void a(boolean bl) {
        this.j.set(bl);
    }

    public final void b() {
        if (!this.l) {
            return;
        }
        try {
            MiDropApplication.a().unregisterReceiver(this.n);
        }
        catch (IllegalArgumentException illegalArgumentException) {}
        this.l = false;
        this.f = false;
        if (this.e == b.b) {
            this.e();
        }
    }

    public final void b(boolean bl) {
        if (this.b != null) {
            if (bl) {
                this.b.a();
            } else {
                this.b.b();
            }
            this.b = null;
        }
    }

    public final void c() {
        new AsyncTask<Void, Void, Boolean>(){

            protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                d.a("Will enable bt", new Object[0]);
                return a.this.a.enable();
            }

            protected final /* synthetic */ void onPostExecute(Object object) {
                Boolean bl = (Boolean)object;
                StringBuilder stringBuilder = new StringBuilder("Enable bt ret ");
                stringBuilder.append((Object)bl);
                d.a(stringBuilder.toString(), new Object[0]);
                if (!bl.booleanValue()) {
                    a.this.b(bl);
                }
            }
        }.execute((Object[])new Void[0]);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    final boolean d() {
        Class class_ = this.a.getClass();
        Class[] arrclass = new Class[]{Integer.TYPE, Integer.TYPE};
        Method method = class_.getMethod("setScanMode", arrclass);
        if (method == null) return false;
        try {
            BluetoothAdapter bluetoothAdapter = this.a;
            Object[] arrobject = new Object[]{23, 300};
            return (Boolean)method.invoke((Object)bluetoothAdapter, arrobject);
        }
        catch (Exception exception) {
            d.a("BluetoothOpener", "setScanMode", exception, new Object[0]);
        }
        return false;
    }

    final boolean e() {
        if (TextUtils.isEmpty((CharSequence)this.m) || k.a(k.a.a, this.m) != null) {
            this.m = Build.DEVICE;
            d.b("BluetoothOpener", "Bt prev name is not good", new Object[0]);
        }
        return o.a(this.a, this.m);
    }

    public static interface a {
        public void a();

        public void b();
    }

    private static final class b
    extends Enum<b> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d;

        static {
            int[] arrn = new int[]{a, b, c};
            d = arrn;
        }
    }

}

