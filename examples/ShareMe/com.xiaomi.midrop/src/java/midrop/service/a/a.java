/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.wifi.WifiManager
 *  android.net.wifi.WifiManager$WifiLock
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  midrop.a.c.a.a.a
 *  midrop.a.c.b
 *  midrop.a.c.e$a
 *  midrop.b.b.a.b
 */
package midrop.service.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import b.g.b.a;
import com.xiaomi.midrop.b.f;
import com.xiaomi.midrop.util.ab;
import java.util.List;
import midrop.a.c.e;
import midrop.a.c.n;
import midrop.c.f.c;
import midrop.service.c.c;
import midrop.service.c.d;

public abstract class a {
    protected Context a;
    protected b b;
    protected a c;
    protected boolean d;
    protected String e;
    protected n f;
    private PowerManager.WakeLock g;
    private WifiManager.WifiLock h;

    public a(Context context) {
        this.a = context;
        this.f = new n();
        HandlerThread handlerThread = new HandlerThread("senderManager");
        handlerThread.start();
        this.b = (a)this.new b(handlerThread.getLooper());
        this.e = String.valueOf((int)c.a());
    }

    public int a(b.g.b.a a2) {
        return 8;
    }

    public int a(b.g.b.b b2) {
        return 8;
    }

    public final int a(String string2) {
        b.g.b.a a2 = new b.g.b.a(a.a.b, this.e, "http://www.xiaomi.com/midrop", "send_apk_list", string2);
        a2.f = com.xiaomi.midrop.util.e.a();
        return this.a(a2);
    }

    public final int a(String string2, String string3) {
        if (TextUtils.isEmpty((CharSequence)string3)) {
            d.b("BaseTransferProxy", "fileId is empty", new Object[0]);
            return 7;
        }
        String string4 = midrop.c.f.b.b(string3);
        b.g.b.a a2 = new b.g.b.a();
        a2.b = this.e;
        a2.a = a.a.b;
        a2.c = "http://www.xiaomi.com/midrop";
        a2.d = string2;
        a2.f = com.xiaomi.midrop.util.e.a();
        a2.e = string4;
        return this.a(a2);
    }

    public int a(String string2, String string3, List<midrop.c.f.a> list) {
        return 8;
    }

    public final int a(String string2, List<String> list, String string3) {
        if (list.isEmpty()) {
            d.b("BaseTransferProxy", "fileIDs is empty", new Object[0]);
            return 7;
        }
        String string4 = midrop.c.f.b.a(list, string3);
        b.g.b.a a2 = new b.g.b.a();
        a2.b = this.e;
        a2.a = a.a.b;
        a2.c = "http://www.xiaomi.com/midrop";
        a2.d = string2;
        a2.f = com.xiaomi.midrop.util.e.a();
        a2.e = string4;
        return this.a(a2);
    }

    public final int a(List<String> list, String string2) {
        if (list.isEmpty()) {
            d.b("BaseTransferProxy", "fileIDs is empty", new Object[0]);
            return 7;
        }
        String string3 = midrop.c.f.b.a(list, string2);
        b.g.b.a a2 = new b.g.b.a();
        a2.b = this.e;
        a2.a = a.a.b;
        a2.c = "http://www.xiaomi.com/midrop";
        a2.d = "delete_files_ack";
        a2.e = string3;
        return this.a(a2);
    }

    public final int a(e.a a2) {
        return this.f.c.a(a2);
    }

    protected final void a() {
        PowerManager powerManager = (PowerManager)this.a.getSystemService("power");
        if (!ab.a(powerManager)) {
            powerManager.newWakeLock(268435462, "receiver bright").acquire(5000L);
        }
    }

    public final void a(a a2) {
        this.c = a2;
    }

    public int b(String string2, String string3, List<f> list) {
        return 8;
    }

    public final int b(e.a a2) {
        return this.f.c.b(a2);
    }

    public final String b(String string2, String string3) {
        return this.f.c.b(string2, string3);
    }

    protected final void b() {
        if (this.g == null) {
            this.g = ((PowerManager)this.a.getSystemService("power")).newWakeLock(1, this.getClass().getSimpleName());
            this.g.setReferenceCounted(true);
            this.g.acquire();
        }
        if (this.h == null) {
            this.h = ((WifiManager)this.a.getApplicationContext().getSystemService("wifi")).createWifiLock(this.getClass().getSimpleName());
            this.h.setReferenceCounted(true);
            this.h.acquire();
        }
    }

    public final void b(String string2) {
        this.a(new b.g.b.b("0", midrop.c.f.c.a(c.a.d).toString()));
        b.g.b.a a2 = new b.g.b.a(a.a.b, this.e, "http://www.xiaomi.com/midrop", "downloaded_per_file", midrop.c.f.b.b(string2));
        this.a(a2);
    }

    public final int c(String string2) {
        return this.f.c.a(string2);
    }

    protected final void c() {
        if (this.g != null && this.g.isHeld()) {
            try {
                this.g.release();
            }
            catch (Exception exception) {
                d.a("BaseTransferProxy", "releaseWakeLock", exception, new Object[0]);
            }
            this.g = null;
        }
        if (this.h != null && this.h.isHeld()) {
            try {
                this.h.release();
            }
            catch (Exception exception) {
                d.a("BaseTransferProxy", "releaseWakeLock", exception, new Object[0]);
            }
            this.h = null;
        }
    }

    protected final int d() {
        return new midrop.b.b.a.b(this.a).f();
    }

    public abstract void e();

    public abstract void f();

    public void g() {
    }

    public abstract midrop.a.c.a.a.a h();

    public final void i() {
        this.b();
        this.l();
    }

    public final void j() {
        this.a(new b.g.b.b("0", midrop.c.f.c.a(c.b.d).toString()));
    }

    public final void k() {
        this.a(new b.g.b.b("0", midrop.c.f.c.a(c.b.f).toString()));
    }

    public final void l() {
        this.a(new b.g.b.b("0", midrop.c.f.c.a(c.b.c).toString()));
    }

    public final void m() {
        this.a(new b.g.b.b("0", midrop.c.f.c.a(c.a.g).toString()));
    }

    public final int n() {
        return this.f.c.h();
    }

    public final boolean o() {
        return this.f.c.i();
    }

    public static interface a {
        public void a(String var1);

        public void a(midrop.a.c.a.a.a var1);

        public void a(midrop.c.d.a var1);

        public boolean a(List<String> var1);

        public void b(String var1);

        public void b(midrop.a.c.a.a.a var1);

        public void c(String var1);

        public void c(midrop.a.c.a.a.a var1);

        public void d(midrop.a.c.a.a.a var1);
    }

    public final class b
    extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                default: {
                    return;
                }
                case 2: {
                    a.this.f();
                    return;
                }
                case 1: 
            }
            a.this.e();
        }
    }

}

