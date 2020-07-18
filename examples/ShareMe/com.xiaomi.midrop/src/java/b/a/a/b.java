/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothServerSocket
 *  android.bluetooth.BluetoothSocket
 *  android.bluetooth.le.AdvertiseCallback
 *  android.bluetooth.le.AdvertiseData
 *  android.bluetooth.le.AdvertiseData$Builder
 *  android.bluetooth.le.AdvertiseSettings
 *  android.bluetooth.le.AdvertiseSettings$Builder
 *  android.bluetooth.le.BluetoothLeAdvertiser
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.AsyncTask
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.ParcelUuid
 *  android.support.v4.content.c
 *  android.text.TextUtils
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Void
 *  java.security.InvalidParameterException
 *  java.util.UUID
 *  java.util.concurrent.Executor
 */
package b.a.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import android.text.TextUtils;
import b.a.a.b;
import b.a.b;
import b.a.e;
import b.a.h;
import b.a.j;
import b.a.k;
import b.a.n;
import b.a.o;
import com.xiaomi.midrop.util.y;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.UUID;
import java.util.concurrent.Executor;
import midrop.service.c.c;
import midrop.service.c.d;

public final class b
implements n {
    Context a;
    h b;
    Handler c;
    b.a.b d;
    boolean e;
    a f;
    private b g;
    private BroadcastReceiver h;

    public b(Context context) {
        this.h = new BroadcastReceiver((b)this){
            final /* synthetic */ b a;
            {
                this.a = b2;
            }

            public final void onReceive(Context context, Intent intent) {
                if ("android.bluetooth.adapter.action.LOCAL_NAME_CHANGED".equals((Object)intent.getAction())) {
                    intent.getStringExtra("android.bluetooth.adapter.extra.LOCAL_NAME");
                }
            }
        };
        this.f = new Runnable((b)this, 0){
            boolean a;
            final /* synthetic */ b b;
            {
                this.b = b2;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public final void run() {
                block16 : {
                    b.a.b b2;
                    b.a a2;
                    block18 : {
                        String string2;
                        String string3;
                        block15 : {
                            block17 : {
                                block12 : {
                                    block13 : {
                                        b.a.b b3;
                                        String string4;
                                        String string5;
                                        b.a a3;
                                        block14 : {
                                            if (!this.a) break block12;
                                            b b4 = this.b;
                                            if (!o.b()) break block13;
                                            b3 = b4.d;
                                            string5 = j.b.toString();
                                            string4 = k.a(0, k.a.c, y.C());
                                            a3 = new b.a(){

                                                @Override
                                                public final void a() {
                                                    d.b("BtServerImpl", "ble advertise failure", new Object[0]);
                                                }
                                            };
                                            if (b3.a == null) {
                                                b3.a = BluetoothAdapter.getDefaultAdapter().getBluetoothLeAdvertiser();
                                            }
                                            if (b3.a != null) break block14;
                                            string3 = "BleAdvertiseProxy";
                                            string2 = "mBluetoothLeAdvertiser(start) is null";
                                            break block15;
                                        }
                                        try {
                                            if (b3.c != null) {
                                                d.b("BleAdvertiseProxy", "already start ble advertise", new Object[0]);
                                                return;
                                            }
                                            AdvertiseSettings.Builder builder = new AdvertiseSettings.Builder();
                                            builder.setAdvertiseMode(2);
                                            builder.setTxPowerLevel(0);
                                            builder.setConnectable(true);
                                            AdvertiseSettings advertiseSettings = builder.build();
                                            if (string4.length() > 18) {
                                                StringBuilder stringBuilder = new StringBuilder("too large ");
                                                stringBuilder.append(string4.length());
                                                throw new InvalidParameterException(stringBuilder.toString());
                                            }
                                            String string6 = o.a();
                                            if (TextUtils.isEmpty((CharSequence)string6)) {
                                                d.b("BleAdvertiseProxy", "address is empty", new Object[0]);
                                                return;
                                            }
                                            b3.b = a3;
                                            String string7 = j.d.toString();
                                            byte[] arrby = string4.getBytes();
                                            AdvertiseData.Builder builder2 = new AdvertiseData.Builder();
                                            builder2.setIncludeDeviceName(false);
                                            builder2.setIncludeTxPowerLevel(false);
                                            builder2.addServiceUuid(ParcelUuid.fromString((String)string5));
                                            builder2.addServiceData(ParcelUuid.fromString((String)string7), arrby);
                                            AdvertiseData advertiseData = builder2.build();
                                            e e2 = new e(c.a(), string6);
                                            String string8 = j.c.toString();
                                            byte[] arrby2 = e2.a();
                                            AdvertiseData.Builder builder3 = new AdvertiseData.Builder();
                                            builder3.setIncludeDeviceName(false);
                                            builder3.setIncludeTxPowerLevel(false);
                                            builder3.addServiceData(ParcelUuid.fromString((String)string8), arrby2);
                                            AdvertiseData advertiseData2 = builder3.build();
                                            b3.c = new b.b(b3, 0);
                                            b3.a.startAdvertising(advertiseSettings, advertiseData, advertiseData2, (AdvertiseCallback)b3.c);
                                            return;
                                        }
                                        catch (Exception exception) {
                                            d.a("BleAdvertiseProxy", "startAdvertise", exception, new Object[0]);
                                        }
                                    }
                                    return;
                                }
                                b b5 = this.b;
                                if (!o.b()) break block16;
                                b2 = b5.d;
                                a2 = new b.a(){

                                    @Override
                                    public final void a() {
                                        d.b("BtServerImpl", "stop ble advertise failure", new Object[0]);
                                    }
                                };
                                if (b2.c != null) break block17;
                                string3 = "BleAdvertiseProxy";
                                string2 = "stop ble callback is null";
                                break block15;
                            }
                            if (b2.a != null) break block18;
                            string3 = "BleAdvertiseProxy";
                            string2 = "mBluetoothLeAdvertiser(stop) is null";
                        }
                        d.b(string3, string2, new Object[0]);
                        return;
                    }
                    b2.b = a2;
                    try {
                        b2.a.stopAdvertising((AdvertiseCallback)b2.c);
                    }
                    catch (IllegalStateException illegalStateException) {}
                    b2.c = null;
                }
            }
        };
        this.a = context.getApplicationContext();
        this.c = new Handler(Looper.getMainLooper());
        if (o.b()) {
            this.d = new b.a.b();
        }
    }

    @Override
    public final void a(h h2) {
        this.b = h2;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.LOCAL_NAME_CHANGED");
        this.a.registerReceiver(this.h, intentFilter);
    }

    @Override
    public final boolean a() {
        if (this.g != null && this.g.isAlive()) {
            this.g.a();
            try {
                this.g.join(1000L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        this.g = new Thread(){
            BluetoothSocket a;
            private BluetoothAdapter c = BluetoothAdapter.getDefaultAdapter();
            private BluetoothServerSocket d;
            private OutputStream e;
            private boolean f;
            private final Object g = new Object();
            private boolean h;
            private int i = 0;
            private final int j = 5;
            private final int k = 5;

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Converted monitor instructions to comments
             * Lifted jumps to return sites
             */
            public final void a() {
                Object object;
                boolean bl;
                Object object2 = object = this.g;
                // MONITORENTER : object2
                this.f = true;
                if (this.a != null && (bl = this.a.isConnected())) {
                    try {
                        this.a.close();
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
                this.a = null;
                this.e = null;
                // MONITOREXIT : object2
                if (this.d == null) return;
                try {
                    this.d.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                this.d = null;
            }

            /*
             * Exception decompiling
             */
            public final void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl369 : ALOAD_0 : trying to set 1 previously set to 0
                // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
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
        this.g.start();
        this.e = false;
        return true;
    }

    @Override
    public final boolean a(final String string2) {
        if (this.g != null) {
            new AsyncTask<Void, Void, Void>(){

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                private /* varargs */ Void a() {
                    Object object;
                    Object object2 = object = b.this.g;
                    synchronized (object2) {
                        OutputStream outputStream = b.this.e;
                        if (outputStream != null) {
                            try {
                                b.this.e.write(string2.getBytes());
                            }
                            catch (IOException iOException) {
                                d.a("BtServerImpl", "write", iOException, new Object[0]);
                            }
                        }
                        return null;
                    }
                }

                /*
                 * Exception decompiling
                 */
                protected final /* synthetic */ Object doInBackground(Object[] var1) {
                    // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                    // java.lang.ArrayIndexOutOfBoundsException: length=0; index=-1
                    // java.util.ArrayList.get(ArrayList.java:315)
                    // org.benf.cfr.reader.b.a.a.c.ab.a(VarArgsRewriter.java:87)
                    // org.benf.cfr.reader.b.a.b.a.e.a(AbstractMemberFunctionInvokation.java:146)
                    // org.benf.cfr.reader.b.a.a.c.ab.a(VarArgsRewriter.java:56)
                    // org.benf.cfr.reader.b.a.d.b.u.a(StructuredReturn.java:90)
                    // org.benf.cfr.reader.b.a.a.c.ab.a(VarArgsRewriter.java:42)
                    // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:1185)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:760)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
                    // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
                    // org.benf.cfr.reader.entities.g.p(Method.java:396)
                    // org.benf.cfr.reader.entities.d.e(ClassFile.java:885)
                    // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                    // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
            return true;
        }
        return false;
    }

    @Override
    public final void b() {
        if (this.g != null) {
            this.g.a();
            this.g = null;
        }
        Intent intent = new Intent("com.xiaomi.midrop.action.STOP_ADVERTISE_BT_NAME");
        intent.setPackage(this.a.getPackageName());
        this.a.sendBroadcast(intent);
        this.e = false;
    }

    @Override
    public final void c() {
        try {
            this.a.unregisterReceiver(this.h);
            android.support.v4.content.c.a((Context)this.a).a(this.h);
        }
        catch (IllegalArgumentException illegalArgumentException) {}
    }

}

