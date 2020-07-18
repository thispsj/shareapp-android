/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.NotificationManager
 *  android.app.Service
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.SharedPreferences
 *  android.net.wifi.WifiInfo
 *  android.net.wifi.WifiManager
 *  android.net.wifi.WifiManager$WifiLock
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  de.greenrobot.event.c
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.net.InetAddress
 *  java.net.InetSocketAddress
 *  java.net.ServerSocket
 *  java.net.Socket
 *  java.net.SocketAddress
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.midrop.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import com.xiaomi.midrop.service.FTPServerService;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.g;
import com.xiaomi.midrop.util.j;
import com.xiaomi.miftp.a.a;
import com.xiaomi.miftp.a.b;
import de.greenrobot.event.c;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.a.ag;
import org.a.aj;
import org.a.ak;
import org.a.al;

public class FTPServerService
extends Service
implements com.xiaomi.miftp.b.a,
Runnable {
    private static final String b = "FTPServerService";
    private static Thread c;
    private static WifiManager.WifiLock f;
    private static SharedPreferences m;
    public int a;
    private boolean d;
    private ServerSocket e;
    private boolean g;
    private boolean h;
    private boolean i;
    private ak j;
    private ag k;
    private List<aj> l = new ArrayList();
    private PowerManager.WakeLock n;
    private final BroadcastReceiver o = new BroadcastReceiver(this){
        final /* synthetic */ FTPServerService a;
        {
            this.a = fTPServerService;
        }

        public final void onReceive(Context context, Intent intent) {
            String string2 = intent.getAction();
            if ((string2.equals((Object)"android.intent.action.MEDIA_UNMOUNTED") || string2.equals((Object)"android.intent.action.MEDIA_BAD_REMOVAL")) && FTPServerService.a()) {
                this.a.stopSelf();
                return;
            }
            if (string2.equals((Object)"android.intent.action.TIME_TICK") && !FTPServerService.a()) {
                com.xiaomi.miftp.c.c.a(FTPServerService.d(), "Server has been killed");
                this.a.stopSelf();
            }
        }
    };
    private HashSet<String> p;
    private HashSet<String> q;
    private int r = 123456;

    private static void a(af.a a2, HashSet<String> hashSet) {
        if (a2 != null && hashSet != null && hashSet.size() > 0) {
            Iterator iterator = hashSet.iterator();
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            while (iterator.hasNext()) {
                String string2 = j.d((String)iterator.next());
                if (g.l.contains((Object)string2)) {
                    ++n2;
                    continue;
                }
                if (g.i.contains((Object)string2)) {
                    ++n4;
                    continue;
                }
                if (g.h.contains((Object)string2)) {
                    ++n3;
                    continue;
                }
                if (g.j.contains((Object)string2)) {
                    ++n5;
                    continue;
                }
                ++n6;
            }
            af.a(a2).a(af.b.a, n2).a(af.b.c, n3).a(af.b.b, n4).a(af.b.d, n5).a(af.b.e, n6).a();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean a() {
        String string2;
        String string3;
        if (c == null) {
            com.xiaomi.miftp.c.c.a(b, "Server is not running (null serverThread)");
            return false;
        }
        if (!c.isAlive()) {
            string3 = b;
            string2 = "serverThread non-null but !isAlive()";
        } else {
            string3 = b;
            string2 = "Server is alive";
        }
        com.xiaomi.miftp.c.c.a(string3, string2);
        return true;
    }

    static /* synthetic */ String d() {
        return b;
    }

    private void e() {
        this.d = true;
        if (c == null) {
            com.xiaomi.miftp.c.c.c(b, "Stopping with null serverThread");
            return;
        }
        c.interrupt();
        try {
            c.join(10000L);
        }
        catch (InterruptedException interruptedException) {}
        if (c.isAlive()) {
            com.xiaomi.miftp.c.c.c(b, "Server thread failed to exit");
        } else {
            com.xiaomi.miftp.c.c.a(b, "serverThread join()ed ok");
            c = null;
        }
        com.xiaomi.miftp.c.a.a((Closeable)this.e);
        c.a().c((Object)new b());
        if (f != null) {
            f.release();
            f = null;
        }
        this.f();
        this.unregisterReceiver(this.o);
        FTPServerService.a(af.a.be, this.q);
        FTPServerService.a(af.a.bf, this.p);
        c.a().b((Object)this);
        com.xiaomi.miftp.c.c.a(b, "FTPServerService.onDestroy() finished");
    }

    private void f() {
        ((NotificationManager)this.getSystemService("notification")).cancel(this.r);
        com.xiaomi.miftp.c.c.a(b, "Cleared notification");
    }

    private boolean g() {
        try {
            this.e = new ServerSocket();
            this.e.setReuseAddress(true);
            this.e.bind((SocketAddress)new InetSocketAddress(this.a));
            return true;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void h() {
        String string2 = b;
        StringBuilder stringBuilder = new StringBuilder("Terminating ");
        stringBuilder.append(this.l.size());
        stringBuilder.append(" session thread(s)");
        com.xiaomi.miftp.c.c.a(string2, stringBuilder.toString());
        FTPServerService fTPServerService = this;
        synchronized (fTPServerService) {
            Iterator iterator = this.l.iterator();
            while (iterator.hasNext()) {
                aj aj2 = (aj)((Object)iterator.next());
                if (aj2 == null) continue;
                aj2.b();
                com.xiaomi.miftp.c.a.a((Closeable)aj2.a);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void i() {
        String string2;
        String string3;
        com.xiaomi.miftp.c.c.a(b, "Releasing wake lock");
        if (this.n != null) {
            this.n.release();
            this.n = null;
            string2 = b;
            string3 = "Finished releasing wake lock";
        } else {
            string2 = b;
            string3 = "Couldn't release null wake lock";
        }
        com.xiaomi.miftp.c.c.a(string2, string3);
    }

    private static void j() {
        com.xiaomi.miftp.c.c.a(b, "Releasing wifi lock");
        if (f != null) {
            f.release();
            f = null;
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    public final void a(aj var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl13 : ALOAD : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public final InetAddress b() {
        WifiInfo wifiInfo = ((WifiManager)this.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        if (wifiInfo == null) {
            return null;
        }
        int n2 = wifiInfo.getIpAddress();
        if (n2 == 0) {
            return null;
        }
        return al.a(n2);
    }

    @Override
    public final void c() {
        c.a().c((Object)new b());
    }

    public IBinder onBind(Intent intent) {
        return new Binder(){};
    }

    public void onCreate() {
        com.xiaomi.miftp.c.c.a(b, "SwiFTP server created");
        this.p = new HashSet();
        this.q = new HashSet();
    }

    public void onDestroy() {
        com.xiaomi.miftp.c.c.d(b, "onDestroy() Stopping server");
        this.e();
        this.stopForeground(true);
        super.onDestroy();
    }

    public void onEventMainThread(com.xiaomi.miftp.a.a a2) {
        File file = a2.a;
        if (file != null) {
            if (a2.b == a.a.a) {
                this.q.add((Object)file.getPath());
                return;
            }
            if (a2.b == a.a.b) {
                this.p.add((Object)file.getPath());
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public int onStartCommand(Intent intent, int n2, int n3) {
        if (intent == null) {
            FTPServerService.super.f();
        } else {
            if ("action_start_ftp_service".equals((Object)intent.getAction())) {
                this.d = false;
                int n4 = 10;
                do {
                    if (c == null) {
                        Thread thread;
                        this.p.clear();
                        this.q.clear();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
                        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
                        intentFilter.addAction("android.intent.action.TIME_TICK");
                        this.registerReceiver(this.o, intentFilter);
                        c.a().a((Object)this);
                        com.xiaomi.miftp.c.c.a(b, "Creating server thread");
                        c = thread = new Thread((Runnable)this, "FTP Service");
                        thread.start();
                        return 2;
                    }
                    com.xiaomi.miftp.c.c.c(b, "Won't start, server thread exists");
                    if (n4 <= 0) {
                        com.xiaomi.miftp.c.c.b(b, "Server thread already exists");
                        return 2;
                    }
                    --n4;
                    al.c();
                } while (true);
            }
            if (!"action_stop_ftp_service".equals((Object)intent.getAction())) return 2;
        }
        FTPServerService.super.e();
        return 2;
    }

    /*
     * Exception decompiling
     */
    public void run() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl299 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

}

