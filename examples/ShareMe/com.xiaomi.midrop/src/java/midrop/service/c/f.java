/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.content.Context
 *  android.net.wifi.WifiInfo
 *  android.net.wifi.WifiManager
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  b.e.a.a.a
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 */
package midrop.service.c;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import b.a.k;
import b.a.o;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.e;
import midrop.service.c.d;

public class f {
    private static f a;
    private static Object b;
    private boolean c;
    private boolean d;
    private int e = a.a;
    private int f = -1;
    private WifiManager g;
    private boolean h;
    private String i;
    private BluetoothAdapter j;

    static {
        b = f.class;
    }

    private f(Context context) {
        this.g = (WifiManager)context.getApplicationContext().getSystemService("wifi");
        this.j = BluetoothAdapter.getDefaultAdapter();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static f a(Context context) {
        Object object;
        Object object2 = object = b;
        synchronized (object2) {
            if (a != null) return a;
            a = new f(context.getApplicationContext());
            return a;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(int n2) {
        void var9_2 = this;
        synchronized (var9_2) {
            if (this.e == a.a && this.g != null) {
                int n3 = this.g.getWifiState();
                boolean bl = true;
                boolean bl2 = n3 == 3;
                this.c = bl2;
                if (b.e.a.a.a.a.d.a(this.g) != 13) {
                    bl = false;
                }
                this.d = bl;
                if (this.c && this.g.getConnectionInfo() != null) {
                    this.f = this.g.getConnectionInfo().getNetworkId();
                }
                if (this.j == null) {
                    d.b("SystemState", "bluetooth adapter is null", new Object[0]);
                } else {
                    this.h = this.j.isEnabled();
                    String string2 = this.j.getName();
                    if (k.a(string2)) {
                        string2 = Build.MODEL;
                    }
                    this.i = string2;
                }
            }
            this.e = n2;
            new StringBuilder("save wifiEnabled:").append(this.c);
            new StringBuilder("save wifiApEnabled:").append(this.d);
            return;
        }
    }

    public final void b(int n2) {
        void var17_2 = this;
        synchronized (var17_2) {
            block13 : {
                int n3 = this.e;
                if (n3 == n2) break block13;
                return;
            }
            new b.e.a.a.a(MiDropApplication.a()).a();
            StringBuilder stringBuilder = new StringBuilder("wifi enable state = ");
            stringBuilder.append(this.g.isWifiEnabled());
            stringBuilder.append(" ");
            stringBuilder.append(this.c);
            if (!(this.c && Build.VERSION.SDK_INT >= 26 && e.c() || this.g.isWifiEnabled() == this.c && this.c)) {
                this.g.setWifiEnabled(this.c);
                if (this.f >= 0) {
                    this.g.enableNetwork(this.f, true);
                }
            }
            new StringBuilder("restoreState, mPrevBtOpen=").append(this.h);
            if (this.j == null) {
                d.b("SystemState", "bluetooth adapter is null", new Object[0]);
            } else {
                if (this.h) {
                    if (!this.j.isEnabled()) {
                        new AsyncTask<Void, Void, Boolean>(){

                            protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                                return f.this.j.enable();
                            }
                        }.execute((Object[])new Void[0]);
                    }
                } else if (this.j.isEnabled() && this.j != null) {
                    new AsyncTask<Void, Void, Boolean>(){

                        protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                            return f.this.j.disable();
                        }
                    }.execute((Object[])new Void[0]);
                }
                if (!TextUtils.isEmpty((CharSequence)this.i)) {
                    o.a(this.j, this.i);
                }
            }
            new StringBuilder("restore wifiEnabled:").append(this.c);
            new StringBuilder("restore wifiApEnabled:").append(this.d);
            this.e = a.a;
            a = null;
            return;
        }
    }

    public static final class a
    extends Enum<a> {
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

