/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothSocket
 *  android.bluetooth.le.BluetoothLeScanner
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.AsyncTask
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.SystemClock
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.HashMap
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package b.a.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.bluetooth.le.BluetoothLeScanner;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import b.a.a.a;
import b.a.c;
import b.a.e;
import b.a.f;
import b.a.h;
import b.a.k;
import b.a.m;
import b.a.o;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import midrop.service.c.d;

public final class a
implements f {
    private static int l;
    private Context a;
    private BluetoothAdapter b;
    private Handler c;
    private m d;
    private b e;
    private HashMap<String, a> f;
    private boolean g = false;
    private boolean h;
    private b.a.c i;
    private h j;
    private boolean k;
    private BroadcastReceiver m;
    private Runnable n;

    public a(Context context) {
        this.m = new BroadcastReceiver((a)this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public final void onReceive(Context context, Intent intent) {
                String string2 = intent.getAction();
                if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals((Object)string2)) {
                    intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    return;
                }
                if ("android.bluetooth.device.action.FOUND".equals((Object)string2)) {
                    k k2;
                    BluetoothDevice bluetoothDevice = (BluetoothDevice)intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (!android.text.TextUtils.isEmpty((java.lang.CharSequence)bluetoothDevice.getName()) && (k2 = k.a(k.a.a, bluetoothDevice.getName())) != null && android.text.TextUtils.isEmpty((java.lang.CharSequence)k2.b)) {
                        a.a(this.a, bluetoothDevice.getAddress(), k2);
                    }
                    return;
                }
                if (!"android.bluetooth.adapter.action.DISCOVERY_STARTED".equals((Object)string2) && "android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals((Object)string2) && a.a(this.a) && !a.b(this.a).isDiscovering()) {
                    a.d(this.a).removeCallbacks(a.c(this.a));
                    a.d(this.a).postDelayed(a.c(this.a), 500L);
                }
            }
        };
        this.n = new Runnable((a)this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public final void run() {
                long l2 = SystemClock.elapsedRealtime();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (java.util.Map$Entry entry : a.e(this.a).entrySet()) {
                    if (l2 - (entry.getValue()).c <= 60000L) continue;
                    arrayList.add(entry.getValue());
                }
                for (a a2 : arrayList) {
                    a.e(this.a).remove((Object)a2.a);
                    if (a.f(this.a) == null) continue;
                    a.f(this.a).a(a2.a);
                }
                StringBuilder stringBuilder = new StringBuilder();
                java.util.Iterator iterator = a.e(this.a).entrySet().iterator();
                while (iterator.hasNext()) {
                    stringBuilder.append((((java.util.Map$Entry)iterator.next()).getValue()).b.a);
                    stringBuilder.append(", ");
                }
                StringBuilder stringBuilder2 = new StringBuilder("bt found, result = ");
                stringBuilder2.append(stringBuilder.toString());
                d.a(stringBuilder2.toString(), new Object[0]);
                a.g(this.a);
            }
        };
        this.a = context.getApplicationContext();
        this.b = BluetoothAdapter.getDefaultAdapter();
        this.c = new Handler(Looper.getMainLooper());
        this.f = new HashMap();
        if (o.b()) {
            this.i = new b.a.c(this.a);
        }
    }

    static /* synthetic */ void a(a a2, BluetoothDevice bluetoothDevice) {
        if (a2.e != null) {
            a2.e.a();
        }
        a2.e = new Thread(bluetoothDevice){
            private BluetoothDevice b;
            private BluetoothSocket c;
            private OutputStream d;
            private final Object e = new Object();
            private AtomicBoolean f = new AtomicBoolean(false);
            private long g = 0L;
            private c h;
            {
                this.b = bluetoothDevice;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            private void c() {
                Object object;
                Object object2 = object = this.e;
                synchronized (object2) {
                    boolean bl;
                    if (this.c != null && (bl = this.c.isConnected())) {
                        try {
                            this.c.close();
                            if (this.d != null) {
                                this.d.close();
                            }
                        }
                        catch (IOException iOException) {
                            iOException.printStackTrace();
                        }
                    }
                    this.c = null;
                    this.d = null;
                    return;
                }
            }

            public final void a() {
                this.f.set(true);
                this.c();
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public final boolean b() {
                Object object;
                Object object2 = object = this.e;
                synchronized (object2) {
                    if (this.c == null) return false;
                    if (!this.c.isConnected()) return false;
                    return true;
                }
            }

            /*
             * Exception decompiling
             */
            public final void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
                // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
                // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
                // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                // org.benf.cfr.reader.entities.g.p(Method.java:396)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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

        };
        a2.e.start();
    }

    static /* synthetic */ void a(a a2, String string2, k k2) {
        long l2 = SystemClock.elapsedRealtime();
        a a3 = a2.f.get((Object)string2);
        if (a3 != null) {
            a3.c = l2;
            return;
        }
        a2.f.put((Object)string2, new Object(string2, k2, l2){
            String a;
            k b;
            long c;
            {
                this.a = string2;
                this.b = k2;
                this.c = l2;
            }
        });
        if (a2.d != null) {
            a2.d.a(string2, k2);
        }
    }

    static /* synthetic */ boolean a(a a2) {
        return a2.g;
    }

    static /* synthetic */ BluetoothAdapter b(a a2) {
        return a2.b;
    }

    static /* synthetic */ int c() {
        return l;
    }

    static /* synthetic */ Runnable c(a a2) {
        return a2.n;
    }

    static /* synthetic */ int d() {
        int n2 = l;
        l = n2 + 1;
        return n2;
    }

    static /* synthetic */ Handler d(a a2) {
        return a2.c;
    }

    static /* synthetic */ HashMap e(a a2) {
        return a2.f;
    }

    private void e() {
        this.b.startDiscovery();
        d.a("bt scanner start", new Object[0]);
        this.g();
        this.f();
        this.c.postDelayed(new Runnable(this){
            final /* synthetic */ a a;
            {
                this.a = a2;
            }

            public final void run() {
                a.b(this.a).cancelDiscovery();
                a.h(this.a);
            }
        }, 10000L);
    }

    static /* synthetic */ m f(a a2) {
        return a2.d;
    }

    private void f() {
        if (o.b()) {
            b.a.c c2 = this.i;
            c.a a2 = new c.a(){

                @Override
                public final void a(String string2, String string3) {
                    k k2 = k.a(k.a.c, string3);
                    e e2 = e.a(string2.getBytes());
                    if (k2 != null && e2 != null) {
                        k2.f = e2.a;
                        String.valueOf((int)k2.f);
                        a.a(a.this, e2.b, k2);
                    }
                }
            };
            if (c2.b == null) {
                c2.b = c2.a.getBluetoothLeScanner();
            }
            c2.c.post(new Runnable(c2, a2){
                final /* synthetic */ c.a a;
                final /* synthetic */ b.a.c b;
                {
                    this.b = c2;
                    this.a = a2;
                }

                public final void run() {
                    if (this.b.d) {
                        d.b("BleGattClient", "Already start scanning", new Object[0]);
                        return;
                    }
                    this.b.d = true;
                    this.b.e = this.a;
                    this.b.f.clear();
                    try {
                        BluetoothLeScanner bluetoothLeScanner = this.b.b;
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        android.bluetooth.le.ScanFilter$Builder builder = new android.bluetooth.le.ScanFilter$Builder();
                        builder.setServiceUuid(android.os.ParcelUuid.fromString((String)b.a.j.b.toString()));
                        arrayList.add((Object)builder.build());
                        android.bluetooth.le.ScanSettings$Builder builder2 = new android.bluetooth.le.ScanSettings$Builder();
                        builder2.setScanMode(2);
                        bluetoothLeScanner.startScan((java.util.List)arrayList, builder2.build(), this.b.j);
                    }
                    catch (Exception exception) {}
                }
            });
        }
    }

    private void g() {
        if (o.b()) {
            b.a.c c2 = this.i;
            c2.c.post(new Runnable(c2){
                final /* synthetic */ b.a.c a;
                {
                    this.a = c2;
                }

                /*
                 * Exception decompiling
                 */
                public final void run(}
        }
        java.lang.IllegalStateException: Parameters not created
        
        