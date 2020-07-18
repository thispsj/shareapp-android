/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Handler
 *  android.os.IInterface
 *  android.os.Message
 *  android.os.RemoteCallbackList
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  android.util.Log
 *  com.b.a.c
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.concurrent.Executor
 *  midrop.a.c.a.a.a
 *  midrop.a.c.a.a.a$a
 *  midrop.a.c.e$a
 *  midrop.service.a.b$1
 *  midrop.service.a.b$a
 *  midrop.service.a.b$b
 *  midrop.service.a.b$c
 *  midrop.service.b.a.a.a
 */
package midrop.service.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.b.a.c;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.sender.c.h;
import com.xiaomi.midrop.util.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import midrop.a.c.a.a.a;
import midrop.a.c.a.a.c;
import midrop.a.c.e;
import midrop.a.c.m;
import midrop.service.a.a;
import midrop.service.a.b;
import midrop.service.b.a.a;

/*
 * Exception performing whole class analysis.
 */
public final class b {
    Context a;
    public f b;
    public m c;
    public e d;
    RemoteCallbackList<midrop.a.b.a> e;
    protected midrop.service.a.a f;
    b g;
    c h;
    volatile boolean i;
    Handler j;
    private ArrayList<g> k;
    private boolean l;
    private a m;

    public b(Context context) {
        this.k = new ArrayList();
        this.j = new Handler(){

            /*
             * Exception decompiling
             */
            public final void handleMessage(Message var1) {
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
        this.a = context;
        this.m = new /* Unavailable Anonymous Inner Class!! */;
        this.g = new /* Unavailable Anonymous Inner Class!! */;
        this.h = new /* Unavailable Anonymous Inner Class!! */;
        this.e = new RemoteCallbackList();
        if (com.xiaomi.midrop.common.b.a("file_storage_loction", 0) == 1) {
            String string2 = String.valueOf((Object)com.xiaomi.midrop.util.d.b(context));
            this.g.a(string2);
            this.g.b(com.xiaomi.midrop.util.d.a(context));
            return;
        }
        this.g.a(com.xiaomi.midrop.util.d.a);
        this.g.b(com.xiaomi.midrop.util.d.c);
    }

    private void a(g g2, int n2, String string2, long l2, long l3) {
        d d2 = new d(0);
        d2.a = g2;
        d2.b = n2;
        d2.c = 0;
        d2.d = l2;
        d2.e = l3;
        d2.f = null;
        d2.g = string2;
        if (n2 != 1 && n2 != 2) {
            this.j.removeMessages(12);
            this.j.obtainMessage(13, (Object)d2).sendToTarget();
            return;
        }
        if (!this.j.hasMessages(12)) {
            Message message = this.j.obtainMessage(12, (Object)d2);
            this.j.sendMessageDelayed(message, 100L);
        }
    }

    static /* synthetic */ void a(b b2, String string2, int n2, String string3, long l2, long l3) {
        g g2 = b2.a(string2);
        if (g2 != null) {
            b2.a(g2, n2, string3, l2, l3);
        }
    }

    static /* synthetic */ void a(b b2, List list) {
        for (String string2 : list) {
            g g2 = b2.a(string2);
            if (g2 == null) {
                StringBuilder stringBuilder = new StringBuilder("Missing find trans item(cancelDownload), fileId =");
                stringBuilder.append(string2);
                midrop.service.c.d.b("TransferManager", stringBuilder.toString(), new Object[0]);
                continue;
            }
            if (g2.z == g.a.a) {
                b2.h.a(g2);
                continue;
            }
            b b3 = b2.g;
            if (g2 != null && b3.c != null) {
                String string3 = g2.s;
                midrop.service.b.a.a.a a2 = b3.a;
                if (!TextUtils.isEmpty((CharSequence)string3)) {
                    a2.h.contains((Object)string3);
                    if (a2.c.a.equals((Object)string3)) {
                        com.b.a.c c2 = a2.b;
                        com.b.a.f f2 = a2.c;
                        if (f2 != null) {
                            Object[] arrobject = new Object[]{f2.a, f2.b};
                            String.format((String)"removeDownload -> [TaskId=%s], [TaskName=%s]", (Object[])arrobject);
                            com.b.a.d d2 = (com.b.a.d)c2.b.get((Object)f2);
                            if (d2 != null) {
                                d2.a(3);
                            }
                        }
                    }
                }
                if (g2.m == 3) {
                    b3.c.b(b3.c.e() - g2.o);
                    j.e(g2.i);
                } else {
                    b3.c.a(string3);
                }
                b3.g.a(g2, 5, null, g2.o, g2.l);
                continue;
            }
            midrop.service.c.d.b("DownloadProxy", "Missing find trans item(notifyCancelTransItem)", new Object[0]);
        }
    }

    static /* synthetic */ void a(b b2, midrop.a.c.a.a.a a2) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = b2.k.iterator();
        long l2 = 0L;
        while (iterator.hasNext()) {
            g g2 = (g)iterator.next();
            if (g2.c() || g2.z != g.a.a) continue;
            long l3 = l2 + g2.l;
            c.a a3 = new c.a();
            a3.b = g2.k;
            a3.a = g2.i;
            arrayList.add((Object)a3);
            l2 = l3;
        }
        a2.c.a = l2;
        a2.c.j = arrayList;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static /* synthetic */ void a(b b2, d d2) {
        g g2 = d2.a;
        String string3 = d2.g;
        int n2 = d2.b;
        int n3 = d2.c;
        long l2 = d2.d;
        long l3 = d2.e;
        if (g2 == null) return;
        if (g2.c()) {
            return;
        }
        if (n2 == 3) {
            g2.m = 3;
            g2.o = l3;
            if (!TextUtils.isEmpty((CharSequence)string3)) {
                g2.j = string3;
                g2.i = string3;
            }
        } else {
            g2.m = n2 == 4 ? 4 : (n2 == 5 ? 5 : 2);
            g2.o = l2;
        }
        String string2 = g2.i;
        if (g2.z != g.a.b) {
            long l6;
            g g3;
            long l4 = l3;
            long l5 = l2;
            int n4 = n3;
            if (b2.c == null) return;
            midrop.a.c.a.a.a a2 = b2.f.h();
            if (a2 == null) return;
            midrop.a.c.a.a.c c2 = a2.c;
            if (n2 != 2 && n2 != 3) {
                if (n2 == 5) {
                    if (!TextUtils.isEmpty((CharSequence)string2)) {
                        Iterator iterator = c2.j.iterator();
                        while (iterator.hasNext()) {
                            if (!TextUtils.equals((CharSequence)((c.a)iterator.next()).a, (CharSequence)string2)) continue;
                            iterator.remove();
                            break;
                        }
                    }
                    if (TextUtils.equals((CharSequence)string2, (CharSequence)c2.h)) {
                        c2.c -= c2.d;
                        c2.d = 0L;
                    }
                }
                g3 = g2;
                l6 = l5;
            } else {
                if (!TextUtils.isEmpty((CharSequence)c2.h) && !TextUtils.equals((CharSequence)string2, (CharSequence)c2.h)) {
                    c2.i = c2.h;
                }
                if (!TextUtils.equals((CharSequence)string2, (CharSequence)c2.h)) {
                    c2.d = 0L;
                    c2.h = string2;
                }
                long l7 = c2.d;
                l6 = l5;
                long l8 = l6 - l7;
                long l9 = c2.c;
                g3 = g2;
                c2.c = l9 + l8;
                c2.b = l8 + c2.b;
                c2.d = l6;
            }
            if (!b2.j.hasMessages(11)) {
                b2.j.sendEmptyMessageDelayed(11, 1000L);
            }
            if (c2.g == 0L) {
                c2.b();
            }
            try {
                m m2 = b2.c;
                g g4 = g3;
                m2.a(g4.h, string2, true ^ TextUtils.isEmpty((CharSequence)g4.t), n2, n4, l6, l4, c2.g);
                return;
            }
            catch (RemoteException remoteException) {
                midrop.service.c.d.a("TransferManager", "RemoteException", remoteException, new Object[0]);
            }
            return;
        }
        int n5 = b2.e.beginBroadcast();
        int n6 = 0;
        do {
            long l11;
            int n7;
            int n8;
            int n9;
            long l10;
            block25 : {
                if (n6 >= n5) {
                    b2.e.finishBroadcast();
                    return;
                }
                midrop.a.b.a a3 = (midrop.a.b.a)b2.e.getBroadcastItem(n6);
                if (a3 != null) {
                    void var42_21;
                    block26 : {
                        String string4 = g2.h;
                        boolean bl = TextUtils.isEmpty((CharSequence)g2.t);
                        boolean bl2 = bl ^ true;
                        n8 = n6;
                        l11 = l3;
                        int n10 = n3;
                        l10 = l2;
                        n9 = n5;
                        n7 = n3;
                        long l12 = l11;
                        try {
                            a3.a(string4, string2, bl2, n2, n10, l2, l12);
                            break block25;
                        }
                        catch (RemoteException remoteException) {
                            break block26;
                        }
                        catch (RemoteException remoteException) {
                            n9 = n5;
                            n8 = n6;
                            l11 = l3;
                            l10 = l2;
                            n7 = n3;
                        }
                    }
                    midrop.service.c.d.a("TransferManager", "RemoteException", (Throwable)var42_21, new Object[0]);
                } else {
                    n9 = n5;
                    n8 = n6;
                    l11 = l3;
                    l10 = l2;
                    n7 = n3;
                }
            }
            n6 = n8 + 1;
            n3 = n7;
            l3 = l11;
            l2 = l10;
            n5 = n9;
        } while (true);
    }

    private void a(boolean bl) {
        Intent intent = new Intent("com.xiaomi.midrop.action.CONNECTION_USER_ACTION");
        intent.setPackage(this.a.getPackageName());
        intent.putExtra("extra_accept", bl);
        this.a.sendBroadcast(intent);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(List<Uri> list) {
        void var5_2 = this;
        synchronized (var5_2) {
            if (this.f == null) {
                midrop.service.c.d.b("TransferManager", "sendFiles: got a null DeviceProxy", new Object[0]);
                return;
            }
            midrop.a.c.a.a.a a2 = this.f.h();
            if (a2 == null) {
                midrop.service.c.d.b("TransferManager", "sendFiles: got a null FileReceiver", new Object[0]);
                return;
            }
            h<Uri> h2 = new h<Uri>(list);
            h2.b(20, (h.a<Uri>)new 1((b)this, h2, a2.b()));
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final int a(midrop.a.b.a a2) {
        if (a2 != null) {
            this.e.register((IInterface)a2);
        }
        midrop.c.d.a a3 = this.a();
        if (a2 == null || !this.e() || a3 == null) return 0;
        midrop.c.f.a a4 = a3.a();
        if (a4 == null) return 0;
        try {
            a2.a(a4.g, a3.h(), a3.e(), a3.i());
            return 0;
        }
        catch (RemoteException remoteException) {
            midrop.service.c.d.a("TransferManager", "RemoteException", remoteException, new Object[0]);
        }
        return 0;
    }

    public final int a(midrop.c.d.e e2) {
        block16 : {
            Handler handler;
            midrop.c.d.g g2 = e2.a();
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{g2.toString()};
            String.format((Locale)locale, (String)"setAction: %s", (Object[])arrobject);
            int n2 = 5.a[g2.ordinal()];
            int n3 = 2;
            switch (n2) {
                default: {
                    return 1;
                }
                case 8: {
                    this.j.post(new Runnable(){

                        public final void run() {
                            b.this.b.f();
                        }
                    });
                    break block16;
                }
                case 7: {
                    Intent intent = new Intent("com.xiaomi.midrop.action.CONNECTION_USER_ACTION");
                    intent.setPackage(this.a.getPackageName());
                    intent.putExtra("extra_cancel_connect", true);
                    this.a.sendBroadcast(intent);
                    break block16;
                }
                case 6: {
                    b.super.a(false);
                    break block16;
                }
                case 5: {
                    b.super.a(true);
                    break block16;
                }
                case 4: {
                    if (this.e()) {
                        b b2 = this.g;
                        midrop.service.b.a.a.a a2 = b2.a;
                        a2.i = false;
                        if (a2.b != null) {
                            com.b.a.c c2 = a2.b;
                            com.b.a.f f2 = a2.c;
                            com.b.a.b b3 = a2.j;
                            if (f2 != null) {
                                StringBuilder stringBuilder = new StringBuilder("cancelDownload: ");
                                stringBuilder.append(f2.b);
                                Log.v((String)"DownloadManager", (String)stringBuilder.toString());
                                com.b.a.d d2 = (com.b.a.d)c2.b.get((Object)f2);
                                if (d2 != null) {
                                    d2.a(n3);
                                } else {
                                    f2.i = 8;
                                    c2.e.post(new Runnable(c2, b3, f2){
                                        final /* synthetic */ com.b.a.b a;
                                        final /* synthetic */ com.b.a.f b;
                                        final /* synthetic */ com.b.a.c c;
                                        {
                                            this.c = c2;
                                            this.a = b2;
                                            this.b = f2;
                                        }

                                        public final void run() {
                                            if (this.a != null) {
                                                this.a.c(this.b);
                                            }
                                        }
                                    });
                                }
                            }
                            a2.b.b();
                        }
                        if (a2.c != null) {
                            a2.d.c(a2.c.a);
                        }
                        b2.g.j.removeMessages(12);
                    }
                    this.b.c();
                    break block16;
                }
                case 3: {
                    handler = this.j;
                    n3 = 7;
                    break;
                }
                case 2: {
                    handler = this.j;
                    n3 = 3;
                    break;
                }
                case 1: {
                    this.j.removeMessages(1);
                    handler = this.j;
                }
            }
            handler.sendEmptyMessage(n3);
        }
        return 0;
    }

    public final int a(midrop.service.a.a a2) {
        void var4_2 = this;
        synchronized (var4_2) {
            block4 : {
                this.j.removeCallbacksAndMessages(null);
                boolean bl = this.l;
                if (!bl) break block4;
                return 0;
            }
            this.c();
            this.l = true;
            this.f = a2;
            this.f.a((a.a)this.m);
            return 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final g a(String string2) {
        void var6_2 = this;
        synchronized (var6_2) {
            int n2;
            block6 : {
                if (!TextUtils.isEmpty((CharSequence)string2)) {
                    n2 = -1 + this.k.size();
                    while (n2 >= 0) {
                        boolean bl = TextUtils.equals((CharSequence)((g)this.k.get((int)n2)).s, (CharSequence)string2);
                        if (!bl) {
                            --n2;
                            continue;
                        }
                        break block6;
                    }
                    return null;
                }
                return null;
            }
            if (n2 != -1) return (g)this.k.get(n2);
            return null;
        }
    }

    public final List<g> a(int n2, int n3) {
        void var8_3 = this;
        synchronized (var8_3) {
            block6 : {
                block7 : {
                    if (this.k == null || this.k.isEmpty()) break block6;
                    if (n2 < this.k.size()) break block7;
                    ArrayList arrayList = new ArrayList();
                    return arrayList;
                }
                int n4 = n3 + n2;
                if (n4 > this.k.size()) {
                    n4 = this.k.size();
                }
                List list = this.k.subList(n2, n4);
                return list;
            }
            ArrayList arrayList = new ArrayList();
            return arrayList;
        }
    }

    public final midrop.c.d.a a() {
        b b2 = this;
        synchronized (b2) {
            b b3;
            block4 : {
                b3 = this.g;
                if (b3.a.i || b3.d == null) break block4;
                midrop.c.d.a a2 = b3.d;
                return a2;
            }
            midrop.c.d.a a3 = b3.c;
            return a3;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(final List<Uri> list) {
        void var7_2 = this;
        synchronized (var7_2) {
            if (this.f == null) {
                midrop.service.c.d.b("TransferManager", "sendFiles: got a null DeviceProxy", new Object[0]);
                return;
            }
            final midrop.a.c.a.a.a a2 = this.f.h();
            if (a2 == null) {
                midrop.service.c.d.b("TransferManager", "sendFiles: got a null FileReceiver", new Object[0]);
                return;
            }
            if (!this.f.o()) {
                midrop.service.c.d.b("TransferManager", "Failed to send, HttpFileServer did not start, ", new Object[0]);
                this.j.obtainMessage(6).sendToTarget();
                return;
            }
            midrop.c.a.e e2 = a2.a;
            boolean bl = e2 == null ? false : (Boolean)e2.b.b(midrop.c.a.f.C);
            if (bl) {
                b.super.c(list);
            }
            a2.c.a();
            new AsyncTask<Void, Void, ArrayList<midrop.c.f.a>>(){
                String a;
                boolean b;
                {
                    this.a = a2.b();
                    this.b = a2.d();
                }

                protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                    ArrayList arrayList = new ArrayList();
                    midrop.service.transmitter.a.a.a(b.this.f, (List<midrop.c.f.a>)arrayList, (List<Uri>)list, null, null);
                    b.this.j.obtainMessage(5, (Object)arrayList).sendToTarget();
                    return arrayList;
                }

                protected final /* synthetic */ void onPostExecute(Object object) {
                    ArrayList arrayList = (ArrayList)object;
                    ArrayList arrayList2 = new ArrayList();
                    if (!this.b) {
                        for (midrop.c.f.a a22 : arrayList) {
                            if (!TextUtils.isEmpty((CharSequence)a22.j)) continue;
                            arrayList2.add((Object)a22);
                        }
                        arrayList = arrayList2;
                    }
                    if (arrayList.isEmpty()) {
                        b.this.j.obtainMessage(6).sendToTarget();
                        return;
                    }
                    b.a(b.this, a2);
                    if (arrayList.size() > 500) {
                        b.this.f.a(this.a, "send_file_begin", null);
                        int n2 = 0;
                        int n3 = 0;
                        while (n2 < arrayList.size()) {
                            if ((n2 += 500) > arrayList.size()) {
                                n2 = arrayList.size();
                            }
                            StringBuilder stringBuilder = new StringBuilder("beginIndex=");
                            stringBuilder.append(n3);
                            stringBuilder.append(" endIndex= ");
                            stringBuilder.append(n2);
                            b.this.f.a(this.a, "send_files_part", (List<midrop.c.f.a>)arrayList.subList(n3, n2));
                            n3 = n2;
                        }
                        if (a2.a.j()) {
                            b.this.f.a(this.a, "send_files_end2", (List<midrop.c.f.a>)arrayList);
                            return;
                        }
                        b.this.f.a(this.a, "send_files_end", null);
                        return;
                    }
                    if (a2.a.j()) {
                        b.this.f.a(this.a, "send_files2", (List<midrop.c.f.a>)arrayList);
                        return;
                    }
                    b.this.f.a(this.a, "send_files", (List<midrop.c.f.a>)arrayList);
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
            return;
        }
    }

    public final int b() {
        b b2 = this;
        synchronized (b2) {
            block4 : {
                this.j.removeCallbacksAndMessages(null);
                boolean bl = this.l;
                if (bl) break block4;
                return 0;
            }
            this.c();
            this.l = false;
            this.f.b(this.h);
            this.f.n();
            this.f.a((a.a)null);
            return 0;
        }
    }

    public final int b(midrop.a.b.a a2) {
        if (this.g.a.i) {
            this.j.sendEmptyMessageDelayed(1, 2000L);
        }
        if (a2 != null) {
            this.e.unregister((IInterface)a2);
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final g b(String string2) {
        void var6_2 = this;
        synchronized (var6_2) {
            int n2;
            block6 : {
                if (!TextUtils.isEmpty((CharSequence)string2)) {
                    if (this.k == null) return null;
                    n2 = -1 + this.k.size();
                    while (n2 >= 0) {
                        boolean bl = TextUtils.equals((CharSequence)((g)this.k.get((int)n2)).i, (CharSequence)string2);
                        if (!bl) {
                            --n2;
                            continue;
                        }
                        break block6;
                    }
                    return null;
                }
                return null;
            }
            if (n2 != -1) return (g)this.k.get(n2);
            return null;
        }
    }

    final void b(List<g> list) {
        void var4_2 = this;
        synchronized (var4_2) {
            block6 : {
                if (list != null) {
                    if (list.isEmpty()) {
                        break block6;
                    }
                    this.k.addAll(list);
                    return;
                }
            }
            return;
        }
    }

    public final void c() {
        b b2 = this;
        synchronized (b2) {
            this.k.clear();
            this.g.a();
            c c2 = this.h;
            c2.c.j.removeMessages(11);
            c2.a = null;
            c2.b = 0L;
            return;
        }
    }

    public final boolean d() {
        b b2 = this;
        synchronized (b2) {
            block5 : {
                boolean bl = this.i;
                if (!bl) break block5;
                return false;
            }
            for (g g2 : this.k) {
                boolean bl;
                if (g2.z != g.a.a || (bl = g2.c())) continue;
            }
            return true;
            return false;
        }
    }

    public final boolean e() {
        b b2 = this;
        synchronized (b2) {
            block4 : {
                boolean bl = this.i;
                if (!bl) break block4;
                return false;
            }
            boolean bl = this.g.a.i;
            return bl;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean f() {
        b b2 = this;
        synchronized (b2) {
            boolean bl;
            boolean bl2 = true;
            Iterator iterator = this.k.iterator();
            do {
                if (!iterator.hasNext()) return bl2;
            } while (bl = ((g)iterator.next()).c());
            return false;
        }
    }

    private static final class d {
        g a;
        int b;
        int c;
        long d;
        long e;
        String f;
        String g;

        private d() {
        }

        /* synthetic */ d(byte by) {
        }
    }

    public static interface e {
        public void a(midrop.a.c.a.a.a var1);

        public void b(midrop.a.c.a.a.a var1);

        public void c(midrop.a.c.a.a.a var1);

        public void d(midrop.a.c.a.a.a var1);

        public void e(midrop.a.c.a.a.a var1);
    }

    public static interface f {
        public void a();

        public void b();

        public void c();

        public void d();

        public void e();

        public void f();
    }

}

