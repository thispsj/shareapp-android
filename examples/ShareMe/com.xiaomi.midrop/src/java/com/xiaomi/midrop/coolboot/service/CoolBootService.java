/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Message
 *  android.util.SparseArray
 *  b.c.a.a.d
 *  com.xiaomi.midrop.coolboot.service.CoolBootService$2
 *  com.xiaomi.midrop.webshare.b
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.concurrent.Executor
 *  midrop.b.c.a
 *  midrop.b.c.a$a
 *  midrop.b.c.a$b
 *  midrop.b.c.a.e
 *  midrop.service.b.b.a
 *  midrop.service.b.b.a.a
 *  midrop.service.b.b.a.a$a
 */
package com.xiaomi.midrop.coolboot.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.SparseArray;
import b.f.c;
import b.f.d;
import com.xiaomi.midrop.coolboot.service.CoolBootService;
import com.xiaomi.midrop.webshare.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import midrop.b.c.a;
import midrop.b.c.a.e;
import midrop.service.b.b.a.a;

public class CoolBootService
extends Service {
    private static final String a = CoolBootService.class.getCanonicalName();
    private final int b = 1;
    private final int c = 5000;
    private c d;
    private e e;
    private Handler f = new Handler(){

        public final void handleMessage(Message message) {
            a;
            if (message.what != 1) {
                return;
            }
            CoolBootService.this.stopSelf();
        }
    };
    private a.b g = new 2(this);

    static /* synthetic */ e a(CoolBootService coolBootService) {
        return coolBootService.e;
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, CoolBootService.class);
        intent.putExtra("extra_command", "stop");
        try {
            context.startService(intent);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            new StringBuilder("stopCoolBootService, exp=").append((Object)illegalStateException);
            return;
        }
    }

    public static void a(Context context, List<Uri> list) {
        Intent intent = new Intent(context, CoolBootService.class);
        intent.putExtra("extra_command", "start");
        if (list != null && !list.isEmpty()) {
            intent.putParcelableArrayListExtra("extra_files", new ArrayList(list));
        }
        context.startService(intent);
    }

    static /* synthetic */ void a(CoolBootService coolBootService, String string2, String string3, String string4, int n) {
        Intent intent = new Intent("com.xiaomi.midrop.action.WIFI_AP_STARTED");
        intent.putExtra("extra_ssid", string2);
        intent.putExtra("extra_password", string3);
        intent.putExtra("extra_host_ip", string4);
        intent.putExtra("extra_port", n);
        intent.setPackage(coolBootService.getPackageName());
        coolBootService.sendBroadcast(intent);
    }

    static /* synthetic */ void b(CoolBootService coolBootService) {
        Intent intent = new Intent("com.xiaomi.midrop.action.WIFI_AP_STARTED_ERROR");
        intent.setPackage(coolBootService.getPackageName());
        coolBootService.sendBroadcast(intent);
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void onCreate() {
        super.onCreate();
        this.d = new c();
        this.d.a((d)new midrop.service.b.b.a((Context)this, "JobHost"));
        this.d.a();
        this.e = new e((Context)this);
        this.e.c = this.g;
    }

    public void onDestroy() {
        super.onDestroy();
        this.d.b();
    }

    public int onStartCommand(Intent intent, int n, int n2) {
        boolean bl;
        ArrayList arrayList;
        if (intent != null) {
            bl = "stop".equals((Object)intent.getStringExtra("extra_command"));
            arrayList = intent.getParcelableArrayListExtra("extra_files");
        } else {
            arrayList = null;
            bl = false;
        }
        if (bl) {
            this.d.a((b.f.a)new midrop.service.b.b.a.a((midrop.b.c.a)this.e, a.a.b));
            this.f.removeMessages(1);
            this.f.sendEmptyMessage(1);
            return 2;
        }
        this.f.removeMessages(1);
        this.d.c();
        this.d.a((b.f.a)new midrop.service.b.b.a.a((midrop.b.c.a)this.e, a.a.a));
        if (this.e != null) {
            new a((List<Uri>)arrayList, this.e).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
        }
        return 1;
    }

    private static final class a
    extends AsyncTask<Void, Void, Void> {
        SparseArray<List<b>> a;
        private List<Uri> b;
        private WeakReference<e> c;
        private b d;

        a(List<Uri> list, e e2) {
            this.b = list;
            this.c = new WeakReference((Object)e2);
        }

        /*
         * Exception decompiling
         */
        protected final /* synthetic */ Object doInBackground(Object[] var1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl45 : ALOAD : trying to set 1 previously set to 0
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:885)
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

        protected final /* synthetic */ void onPostExecute(Object object) {
            super.onPostExecute((Object)((Void)object));
            e e2 = (e)this.c.get();
            if (e2 != null) {
                b b2 = this.d;
                SparseArray<List<b>> sparseArray = this.a;
                e2.d = b2;
                e2.e = sparseArray;
                if (e2.a != null) {
                    e2.a.a(b2, sparseArray);
                }
            }
        }
    }

}

