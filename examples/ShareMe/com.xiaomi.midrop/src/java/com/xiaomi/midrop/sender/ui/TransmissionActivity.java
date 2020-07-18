/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningServiceInfo
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.ServiceConnection
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.a
 *  android.support.v4.app.a$a
 *  android.support.v4.app.k
 *  android.support.v4.app.q
 *  android.text.TextUtils
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.widget.Toast
 *  java.io.File
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.Executor
 *  midrop.a.c.a.a.a
 *  midrop.a.c.a.a.a$a
 *  midrop.a.c.k$a
 */
package com.xiaomi.midrop.sender.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.a;
import android.support.v4.app.k;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.e;
import com.xiaomi.midrop.profile.a;
import com.xiaomi.midrop.qrcode.ModifiedDecoratedBarcodeView;
import com.xiaomi.midrop.receiver.service.ReceiverService;
import com.xiaomi.midrop.receiver.ui.ReceiverInProgressDialog;
import com.xiaomi.midrop.receiver.ui.TransferFragment;
import com.xiaomi.midrop.sender.c.h;
import com.xiaomi.midrop.sender.fragment.QRCodeScannerFragment;
import com.xiaomi.midrop.sender.fragment.RadarScannerFragment;
import com.xiaomi.midrop.sender.fragment.SendListFragment;
import com.xiaomi.midrop.sender.ui.TransmissionActivity;
import com.xiaomi.midrop.sender.ui.b;
import com.xiaomi.midrop.transmission.b;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.ad;
import com.xiaomi.midrop.util.ae;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.util.aq;
import com.xiaomi.midrop.util.ar;
import com.xiaomi.midrop.util.y;
import com.xiaomi.midrop.welcome.WelcomeActivity;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import midrop.a.c.a.a.a;
import midrop.a.c.k;
import midrop.a.c.m;
import midrop.c.d.c;
import midrop.service.a.c;

public class TransmissionActivity
extends com.xiaomi.midrop.sender.ui.b
implements a.a,
com.xiaomi.midrop.sender.fragment.a,
b.a {
    private static boolean C;
    private boolean A;
    private b B = new Object(){
        public int a;
        public boolean b;
        public String c = "2GHZ";
        public String d;
        public String e;
    };
    private QRCodeScannerFragment D;
    private SendListFragment E;
    private com.xiaomi.midrop.receiver.a F;
    private boolean G;
    private boolean H = true;
    private boolean I;
    private BroadcastReceiver J = new BroadcastReceiver(this){
        final /* synthetic */ TransmissionActivity a;
        {
            this.a = transmissionActivity;
        }

        public final void onReceive(Context context, Intent intent) {
            if ("com.xiaomi.midrop.action.OPEN_BLUETOOTH_FAIL".equals((Object)intent.getAction())) {
                TransmissionActivity.a(this.a);
                return;
            }
            if ("com.xiaomi.midrop.ACTION_BLUETOOTH_OFF_EXCEPTION".equals((Object)intent.getAction())) {
                TransmissionActivity.a(this.a);
            }
        }
    };
    public boolean a;
    private midrop.a.c.k u;
    private d v;
    private boolean w;
    private final int x = 1;
    private final int y = 2;
    private boolean z;

    private void A() {
        this.f = "";
        if (this.D == null) {
            this.D = new QRCodeScannerFragment();
            if (this.u != null) {
                this.D.a(this.u);
            }
        }
        if (!this.D.isAdded()) {
            q q2 = this.getSupportFragmentManager().a();
            q2.b(2131296463, (Fragment)this.D);
            q2.f();
            if (aq.a()) {
                aq.a((Context)this, null);
            }
            if (ar.b((Context)this) && !am.b()) {
                ar.a((Context)this);
            }
        }
    }

    private void B() {
        if (this.u != null) {
            try {
                this.u.c();
                return;
            }
            catch (RemoteException remoteException) {
                new StringBuilder("restartFindDevices of transact exception =").append((Object)remoteException);
            }
        }
    }

    /*
     * Exception decompiling
     */
    private boolean C() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl53.1 : ICONST_0 : trying to set 1 previously set to 0
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static /* synthetic */ ArrayList a(Intent intent) {
        ArrayList<Uri> arrayList;
        Context context = MiDropApplication.a();
        ArrayList arrayList2 = new ArrayList();
        String string2 = intent.getAction();
        String string3 = intent.getType();
        if ("android.intent.action.SEND".equals((Object)string2) && string3 != null) {
            Uri uri = (Uri)intent.getParcelableExtra("android.intent.extra.STREAM");
            if (uri == null && TextUtils.equals((CharSequence)"text/plain", (CharSequence)string3)) {
                uri = ad.a.a(context, intent);
            }
            if (uri == null) return arrayList2;
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add((Object)uri);
            return com.xiaomi.midrop.sender.c.e.a(context, (ArrayList<Uri>)arrayList3);
        }
        if ("android.intent.action.SEND_MULTIPLE".equals((Object)string2)) {
            arrayList = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            do {
                return com.xiaomi.midrop.sender.c.e.a(context, arrayList);
                break;
            } while (true);
        }
        if (!"com.xiaomi.midrop.FILE_LIST_SHARE".equals((Object)string2)) return arrayList2;
        arrayList = com.xiaomi.midrop.sender.c.d.a();
        return com.xiaomi.midrop.sender.c.e.a(context, arrayList);
    }

    static /* synthetic */ void a(int n2, boolean bl, boolean bl2) {
        TransmissionActivity.b(n2, bl, bl2);
    }

    static /* synthetic */ void a(TransmissionActivity transmissionActivity) {
        com.xiaomi.midrop.util.Locale.b b2 = com.xiaomi.midrop.util.Locale.b.a();
        transmissionActivity.a(transmissionActivity.findViewById(2131296463), b2.b(2131689819), b2.b(2131689814), new View.OnClickListener(transmissionActivity){
            final /* synthetic */ TransmissionActivity a;
            {
                this.a = transmissionActivity;
            }

            public void onClick(View view) {
                if (TransmissionActivity.d(this.a) != null) {
                    try {
                        TransmissionActivity.d(this.a).a(new midrop.c.d.e(midrop.c.d.g.k));
                        return;
                    }
                    catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                    }
                }
            }
        });
    }

    static /* synthetic */ void a(TransmissionActivity transmissionActivity, int n2) {
        transmissionActivity.b(n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    static /* synthetic */ void a(TransmissionActivity transmissionActivity, List list) {
        if (transmissionActivity.H) {
            transmissionActivity.H = false;
            long l2 = 0L;
            String string2 = transmissionActivity.getIntent().getAction();
            if (!TextUtils.equals((CharSequence)"android.intent.action.SEND_MULTIPLE", (CharSequence)string2) && !TextUtils.equals((CharSequence)"android.intent.action.SEND", (CharSequence)string2)) {
                if (TextUtils.equals((CharSequence)"com.xiaomi.midrop.FILE_LIST_SHARE", (CharSequence)string2)) {
                    Iterator iterator = com.xiaomi.midrop.sender.c.g.e().d();
                    while (iterator.hasNext()) {
                        l2 += ((g)iterator.next()).l;
                    }
                }
            } else {
                for (Uri uri : list) {
                    File file;
                    if (TextUtils.isEmpty((CharSequence)uri.getPath()) || !(file = new File(uri.getPath())).exists()) continue;
                    l2 += file.length();
                }
            }
            long l3 = l2 / 1024L / 1024L;
            long l4 = 1000L;
            long l5 = l3 LCMP l4;
            long l6 = 10L;
            if (l5 > 0 || l3 > (l4 = 100L)) {
                l6 = l4 + l4 * (l3 / l4);
            } else if (l3 > l6) {
                l6 += l6 * (l3 / l6);
            }
            af.a(af.a.cJ).a(af.b.P, (int)l6).a();
        }
    }

    static /* synthetic */ void a(TransmissionActivity transmissionActivity, boolean bl) {
        transmissionActivity.A = bl;
    }

    private void b(int n2) {
        this.a(e.a, n2, new a.a((TransmissionActivity)this){
            final /* synthetic */ TransmissionActivity a;
            {
                this.a = transmissionActivity;
            }

            public final void a() {
                this.a.u();
            }

            public final void a(int n2) {
                if (n2 == 1) {
                    TransmissionActivity.c(this.a);
                    return;
                }
                if (n2 == 2) {
                    e.a((Activity)this.a);
                }
            }
        });
    }

    private static void b(int n2, boolean bl, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder("recordConnectFail, err=");
        stringBuilder.append(n2);
        stringBuilder.append(" scanQrCode=");
        stringBuilder.append(bl);
        stringBuilder.append(" useAp=");
        stringBuilder.append(bl2);
        midrop.service.c.d.a("TransmissionActivity", stringBuilder.toString(), new Object[0]);
        if (bl) {
            af.a(af.a.dz).a(af.b.O, n2).a();
        }
        String string2 = bl ? "ScanQR" : "ClickPortrait";
        String string3 = bl2 ? "AP" : "BT";
        af.a(af.a.cr).a(af.b.O, n2).a(af.b.ai, string2).a(af.b.ag, string3).a();
    }

    static /* synthetic */ void b(TransmissionActivity transmissionActivity) {
        if (!transmissionActivity.e) {
            transmissionActivity.A();
            return;
        }
        new com.xiaomi.midrop.transmission.b(transmissionActivity, (List<Uri>)transmissionActivity.g).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
    }

    static /* synthetic */ void c(TransmissionActivity transmissionActivity) {
        new StringBuilder("bindSenderManagerService ").append(transmissionActivity.w);
        if (transmissionActivity.w) {
            transmissionActivity.B();
            return;
        }
        transmissionActivity.w = true;
        Intent intent = new Intent("midrop.api.transmitter.ISenderManagerService");
        intent.setPackage("com.xiaomi.midrop");
        transmissionActivity.bindService(intent, (ServiceConnection)transmissionActivity.v, 1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(List<Uri> list) {
        String string2;
        String string3;
        if (this.m == null) {
            string2 = "TransmissionActivity";
            string3 = "Send failed,the connection is disconnected";
        } else {
            if (list != null && !list.isEmpty()) {
                try {
                    if (!this.I && a.a.b(this.m.b()) && y.C() == 101) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(com.xiaomi.midrop.profile.a.c().getPath());
                        stringBuilder.append("?silent_transfer=true");
                        list.add(0, (Object)Uri.parse((String)stringBuilder.toString()));
                        this.I = true;
                    }
                    h<Uri> h2 = new h<Uri>(list);
                    h2.b(50, new h.a<Uri>((TransmissionActivity)this, h2){
                        final /* synthetic */ h a;
                        final /* synthetic */ TransmissionActivity b;
                        {
                            this.b = transmissionActivity;
                            this.a = h2;
                        }

                        public final List<Uri> a(int n2, int n3) {
                            List<T> list = this.a.a(n2, n3);
                            try {
                                if (TransmissionActivity.d(this.b) != null) {
                                    TransmissionActivity.d(this.b).b(list);
                                    return list;
                                }
                            }
                            catch (RemoteException remoteException) {
                                midrop.service.c.d.a("TransmissionActivity", "send uri list", remoteException, new Object[0]);
                            }
                            return list;
                        }
                    });
                    if (this.u != null) {
                        this.u.b((List<Uri>)null);
                    }
                    return;
                }
                catch (RemoteException remoteException) {
                    remoteException.printStackTrace();
                    return;
                }
            }
            string2 = "TransmissionActivity";
            string3 = "Send failed,uri list is null!";
        }
        midrop.service.c.d.b(string2, string3, new Object[0]);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void y() {
        if (!midrop.service.c.e.b("user_notice_agree_state", false)) {
            Intent intent = new Intent((Context)this, WelcomeActivity.class).addFlags(65536);
            intent.putExtra("from_third_party", true);
            com.xiaomi.midrop.sender.c.a.a().a((Activity)this);
            this.startActivity(intent);
        }
        if (!this.e) {
            this.A();
            af.a a2 = y.u() ? af.a.cF : af.a.cH;
            af.a(a2).a();
        }
        new AsyncTask<Void, Void, List<Uri>>(this){
            private WeakReference<TransmissionActivity> a;
            private Intent b;
            {
                this.a = new WeakReference((Object)transmissionActivity);
                this.b = transmissionActivity.getIntent();
            }

            protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                if (this.b == null) {
                    return new ArrayList();
                }
                List<Uri> list = TransmissionActivity.a(this.b);
                if (list != null && !list.isEmpty()) {
                    list = com.xiaomi.midrop.send.contacts.a.a((List<? extends Uri>)list);
                }
                return list;
            }

            protected final /* synthetic */ void onPostExecute(Object object) {
                List list = (List)object;
                super.onPostExecute((Object)list);
                TransmissionActivity transmissionActivity = (TransmissionActivity)this.a.get();
                if (transmissionActivity != null && !transmissionActivity.isFinishing()) {
                    if (transmissionActivity.isDestroyed()) {
                        return;
                    }
                    if (list != null && !list.isEmpty()) {
                        transmissionActivity.g = list;
                        TransmissionActivity.b(transmissionActivity);
                        TransmissionActivity.a(transmissionActivity, list);
                        return;
                    }
                    Toast.makeText((Context)transmissionActivity, (int)2131689977, (int)1).show();
                    transmissionActivity.finish();
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
    }

    private void z() {
        if (this.d(2131689657)) {
            return;
        }
        if (e.b((Context)this)) {
            this.w();
            return;
        }
        boolean bl = true ^ e.a((Context)this);
        if (!e.a((Context)this, e.a) && !bl) {
            this.b(1);
            return;
        }
        com.xiaomi.midrop.util.Locale.b b2 = com.xiaomi.midrop.util.Locale.b.a();
        this.a(b2.b(2131689644), b2.b(2131689633), new View.OnClickListener(this, bl){
            final /* synthetic */ boolean a;
            final /* synthetic */ TransmissionActivity b;
            {
                this.b = transmissionActivity;
                this.a = bl;
            }

            public void onClick(View view) {
                int n2 = this.a ? 2 : 1;
                TransmissionActivity.a(this.b, n2);
                af.a(af.a.u).a(af.b.m, "Send").a();
            }
        });
        af.a(af.a.t).a(af.b.m, "Send").a();
    }

    @Override
    public final void a() {
        if (this.u != null) {
            try {
                this.u.k();
            }
            catch (RemoteException remoteException) {
                midrop.service.c.d.a("TransmissionActivity", "start", remoteException, new Object[0]);
            }
        }
        this.A();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public final void a(b.b b2) {
        QRCodeScannerFragment qRCodeScannerFragment;
        boolean bl2;
        boolean bl;
        block17 : {
            if (this.u != null) {
                RemoteException remoteException;
                boolean bl3;
                block18 : {
                    block16 : {
                        boolean bl4;
                        if (!this.u.i() && !(bl4 = this.u.h())) {
                            bl = false;
                            break block16;
                        }
                        bl = true;
                    }
                    try {
                        bl2 = this.u.j();
                        break block17;
                    }
                    catch (RemoteException remoteException2) {
                        bl3 = bl;
                        remoteException = remoteException2;
                        break block18;
                    }
                    catch (RemoteException remoteException3) {
                        bl3 = false;
                    }
                }
                midrop.service.c.d.a("TransmissionActivity", "RemoteException", remoteException, new Object[0]);
                bl = bl3;
            } else {
                bl = false;
            }
            bl2 = true;
        }
        if (bl) {
            this.b(new View.OnClickListener(true, b2){
                boolean a = false;
                b.b b;
                {
                    this.a = bl;
                    this.b = b2;
                }

                public void onClick(View view) {
                    if (TransmissionActivity.this.u != null) {
                        try {
                            TransmissionActivity.this.u.a();
                        }
                        catch (RemoteException remoteException) {
                            midrop.service.c.d.a("TransmissionActivity", "RemoteException when abort", remoteException, new Object[0]);
                        }
                    }
                    if (this.a) {
                        TransmissionActivity.this.setResult(-1);
                    }
                    TransmissionActivity.this.finish();
                    if (this.b != null) {
                        this.b.a();
                    }
                    af.a(af.a.an).a();
                }
            });
            af.a(af.a.ax).a();
            return;
        }
        if (this.e) {
            this.a(new /* invalid duplicate definition of identical inner class */);
            af.a(af.a.ax).a();
            return;
        }
        if (!bl2) {
            this.b(new /* invalid duplicate definition of identical inner class */);
            af.a(af.a.ax).a();
            return;
        }
        if (this.o()) {
            this.a(new /* invalid duplicate definition of identical inner class */);
            return;
        }
        if (TransmissionActivity.super.C()) {
            this.a(new /* invalid duplicate definition of identical inner class */);
            return;
        }
        if (this.getSupportFragmentManager().a(2131296463) instanceof TransferFragment) {
            this.setResult(-1);
        }
        this.finish();
        if (b2 != null) {
            b2.a();
        }
        if (!(qRCodeScannerFragment = this.D).isVisible()) return;
        if (qRCodeScannerFragment.b) {
            return;
        }
        long l2 = System.currentTimeMillis() - qRCodeScannerFragment.f;
        int n2 = qRCodeScannerFragment.e.size();
        boolean bl5 = false;
        if (n2 > 0) {
            bl5 = true;
        }
        String string2 = bl5 ? "after_results" : (l2 < 5000L ? "before_5_sec" : "after_5_sec");
        af.a(af.a.aA).a(af.b.aC, string2).a();
    }

    @Override
    protected final void a(com.xiaomi.midrop.transmission.a.e e2) {
    }

    @Override
    public final void a(List<Uri> list) {
        this.g = new ArrayList(list);
    }

    @Override
    protected final void a(midrop.a.c.a.a.a a2) {
        switch (7.b[a2.b.a().ordinal()]) {
            default: {
                return;
            }
            case 3: {
                midrop.service.c.d.b("TransmissionActivity", "connect fail", new Object[0]);
                this.g();
                return;
            }
            case 2: {
                if (this.o()) {
                    TransmissionActivity.super.A();
                    try {
                        if (this.u != null && a2.a != null) {
                            this.u.a(a2.a);
                        }
                    }
                    catch (RemoteException remoteException) {
                        midrop.service.c.d.a("TransmissionActivity", "Exception when try to remove the receiver", remoteException, new Object[0]);
                    }
                    TransmissionActivity.super.B();
                } else if (this.p() && this.u != null) {
                    try {
                        this.u.l();
                    }
                    catch (RemoteException remoteException) {
                        midrop.service.c.d.a("TransmissionActivity", "stop", remoteException, new Object[0]);
                    }
                }
                this.e = false;
                this.m = null;
                this.I = false;
                this.f = "";
                return;
            }
            case 1: 
        }
        this.m = a2;
        this.e = true;
        TransmissionActivity.super.c((List<Uri>)this.g);
        com.xiaomi.midrop.e.a.a(this.m.b(), 0, y.w());
        this.i.e = this.m.a();
        ae.a.d = System.currentTimeMillis();
        String string2 = "2GHZ";
        String string3 = "";
        String string4 = "";
        if (this.D != null) {
            string2 = this.B.c;
            string3 = this.B.d;
            string4 = this.B.e;
        }
        af.a(af.a.cq).a(af.b.ag, string3).a(af.b.ah, string2).a(af.b.ai, string4).a();
        this.G = true;
        if (this.E != null) {
            this.E.s();
        }
    }

    @Override
    protected final void a(midrop.c.d.e e2) {
        if (this.u != null) {
            try {
                this.u.a(e2);
                return;
            }
            catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
        }
    }

    @Override
    protected final void a(midrop.service.a.c c2, midrop.a.c.a.a.a a2) {
        if (this.u != null) {
            if (a2 == null) {
                return;
            }
            if (c2.a == c.d.c) {
                int n2 = c2.c;
                switch (7.a[n2 - 1]) {
                    default: {
                        return;
                    }
                    case 2: {
                        QRCodeScannerFragment qRCodeScannerFragment = this.D;
                        if (qRCodeScannerFragment.a()) break;
                        new StringBuilder("removeFileReceiver fileReceiver=").append((Object)a2);
                        if (a2 == null || (midrop.a.c.a.a.a)qRCodeScannerFragment.e.get((Object)a2.b()) == null) break;
                        qRCodeScannerFragment.e.remove((Object)a2.b());
                        if (qRCodeScannerFragment.d != null) {
                            qRCodeScannerFragment.d.a(a2);
                        }
                        int n3 = qRCodeScannerFragment.e.size();
                        boolean bl = false;
                        if (n3 <= 0) {
                            bl = true;
                        }
                        qRCodeScannerFragment.a(bl);
                        qRCodeScannerFragment.b();
                        return;
                    }
                    case 1: {
                        QRCodeScannerFragment qRCodeScannerFragment = this.D;
                        if (qRCodeScannerFragment.a()) break;
                        if (qRCodeScannerFragment.c) {
                            ae.a.b = System.currentTimeMillis();
                            qRCodeScannerFragment.c = false;
                        }
                        qRCodeScannerFragment.b(a2);
                        qRCodeScannerFragment.c();
                    }
                }
                return;
            }
            super.a(c2, a2);
            c.a a3 = c2.b;
            if (a3 == c.a.d && a2.b.b()) {
                new StringBuilder("device connected, useQrCode=").append(this.z);
                if (this.z) {
                    String string2;
                    String string3 = "2GHZ";
                    if (!this.A) {
                        string2 = "BT";
                        if (a2.a.i()) {
                            string3 = "5GHZ";
                        }
                    } else {
                        string2 = "AP";
                    }
                    af.a(af.a.dy).a(af.b.ag, string2).a(af.b.ah, string3).a();
                }
            }
            StringBuilder stringBuilder = new StringBuilder("onReceiveServiceMsg-[status:");
            stringBuilder.append((Object)a3);
            stringBuilder.append("]");
            if (7.d[a3.ordinal()] == 1 && 7.c[a2.b.f().ordinal()] == 4) {
                TransmissionActivity.b(a2.a.h(), this.z, this.A);
            }
            if (this.E != null) {
                this.E.a(a3, a2);
            }
        }
    }

    @Override
    public final boolean a(String string2, String string3) {
        if (this.u == null) {
            Toast.makeText((Context)MiDropApplication.a(), (int)2131689894, (int)1).show();
            return false;
        }
        try {
            this.u.a(new midrop.c.d.e(midrop.c.d.g.c));
        }
        catch (RemoteException remoteException) {}
        this.r.sendEmptyMessage(2);
        return true;
    }

    @Override
    public final boolean a(String string2, String string3, boolean bl) {
        return false;
    }

    @Override
    public final void b(List<Uri> list) {
        if (list != null) {
            if (list.isEmpty()) {
                return;
            }
            if (this.u == null) {
                midrop.service.c.d.b("TransmissionActivity", "sender manager service is null!", new Object[0]);
                return;
            }
            TransmissionActivity.super.c(list);
        }
    }

    @Override
    protected final void b(midrop.a.c.a.a.a a2) {
        switch (7.c[a2.b.f().ordinal()]) {
            default: {
                return;
            }
            case 7: {
                Toast.makeText((Context)MiDropApplication.a(), (int)2131689834, (int)1).show();
                return;
            }
            case 6: {
                Context context = MiDropApplication.a();
                String string2 = this.getString(2131689607);
                Object[] arrobject = new Object[]{a2.a()};
                Toast.makeText((Context)context, (CharSequence)String.format((String)string2, (Object[])arrobject), (int)1).show();
                TransmissionActivity.super.B();
                return;
            }
            case 5: {
                this.a(2);
                return;
            }
            case 4: {
                midrop.service.c.d.b("TransmissionActivity", "connect fail", new Object[0]);
                this.g();
                return;
            }
            case 3: {
                midrop.service.c.d.b("TransmissionActivity", "connect cancel", new Object[0]);
                Toast.makeText((Context)MiDropApplication.a(), (int)2131689961, (int)1).show();
                TransmissionActivity.super.A();
                TransmissionActivity.super.B();
                return;
            }
            case 2: {
                this.a(5);
                int n2 = TransferFragment.c.a;
                com.xiaomi.midrop.sender.c.a.a().b((Activity)this);
                com.xiaomi.midrop.sender.c.a.a().c();
                this.v();
                if (this.E == null) {
                    this.E = new SendListFragment();
                    this.k = this.E;
                    this.E.a(this.u);
                    if (n2 == TransferFragment.c.a) {
                        this.q.post(new Runnable((TransmissionActivity)this){
                            final /* synthetic */ TransmissionActivity a;
                            {
                                this.a = transmissionActivity;
                            }

                            public final void run() {
                                if (this.a.m == null) {
                                    midrop.service.c.d.b("TransmissionActivity", "loadPackages err, mFileReceiver is null", new Object[0]);
                                    return;
                                }
                                new StringBuilder("Safe transfer ").append(this.a.m.f());
                                this.a.i.a(this.a.m.f());
                            }
                        });
                    }
                }
                this.E.a(n2);
                q q2 = this.getSupportFragmentManager().a();
                q2.a();
                q2.b(2131296463, (Fragment)this.E);
                q2.f();
                String string3 = "ap";
                String string4 = "false";
                if (this.m != null) {
                    midrop.a.c.a.a.a a3 = this.m;
                    c.a a4 = a3.a == null ? c.a.a : a3.a.f();
                    if (a4 == c.a.d) {
                        string3 = "bt";
                    }
                    if (this.m.a != null && this.m.a.i()) {
                        string4 = "true";
                    }
                }
                af.a(af.a.at).a(af.b.s, string3).a(af.b.w, string4).a();
                if (this.G) {
                    af.a(af.a.cs).a();
                    this.G = false;
                }
                return;
            }
            case 1: 
        }
        this.a(1);
    }

    @Override
    public final void c() {
        if (this.u == null) {
            Toast.makeText((Context)MiDropApplication.a(), (int)2131689894, (int)1).show();
            return;
        }
        try {
            this.u.a(new midrop.c.d.e(midrop.c.d.g.d));
        }
        catch (RemoteException remoteException) {
            midrop.service.c.d.a("TransmissionActivity", "RemoteException", remoteException, new Object[0]);
        }
        Intent intent = new Intent();
        intent.setAction("miui.intent.action.GARBAGE_CLEANUP");
        this.startActivity(intent);
    }

    public final void c(midrop.a.c.a.a.a a2) {
        this.z = true;
        AsyncTask<Void, Void, RadarScannerFragment.b> asyncTask = new AsyncTask<Void, Void, RadarScannerFragment.b>((TransmissionActivity)this, this.u, a2, (List<Uri>)this.g, this.a){
            private WeakReference<TransmissionActivity> a;
            private WeakReference<midrop.a.c.k> b;
            private midrop.a.c.a.a.a c;
            private List<Uri> d;
            private boolean e;
            private boolean f;
            {
                this.a = new WeakReference((Object)transmissionActivity);
                this.b = new WeakReference((Object)k2);
                this.c = a2;
                this.d = list;
                this.e = true;
                this.f = bl;
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            private /* varargs */ RadarScannerFragment.b a() {
                block13 : {
                    var1_1 = (midrop.a.c.k)this.b.get();
                    var2_2 = new Object(){
                        public int a;
                        public boolean b;
                        public String c = "2GHZ";
                        public String d;
                        public String e;
                    };
                    if (var1_1 == null || this.d == null) break block13;
                    try {
                        var10_3 = this.d;
                        var11_4 = true;
                        if (var10_3 != null) {
                            var18_5 = 0L;
                            var20_6 = var10_3.iterator();
                            while (var20_6.hasNext()) {
                                var21_7 = ((Uri)var20_6.next()).getPath();
                                if (TextUtils.isEmpty((CharSequence)var21_7)) continue;
                                var18_5 += new File(var21_7).length();
                            }
                        }
                        ** GOTO lbl-1000
                    }
                    catch (RemoteException var9_13) {
                        midrop.service.c.d.a("TransmissionActivity", "RemoteException", var9_13, new Object[0]);
                        return var2_2;
                    }
                }
                var3_14 = new StringBuilder("Connect failed, deviceId=");
                var3_14.append(this.c.b());
                var3_14.append(" senderManagerService=");
                var3_14.append(this.b);
                var3_14.append(" fileUris=");
                var3_14.append(this.d);
                midrop.service.c.d.b("TransmissionActivity", var3_14.toString(), new Object[0]);
                return var2_2;
                if (var18_5 < 524288000L) {
                    var12_8 = true;
                } else lbl-1000: // 2 sources:
                {
                    var12_8 = false;
                }
                if (!var12_8 && this.c.a.i() && !am.f() || TextUtils.isEmpty((CharSequence)this.c.a.e())) {
                    var11_4 = false;
                }
                var13_9 = "2GHZ";
                if (!var11_4) {
                    var14_10 = "BT";
                    if (this.c.a.i()) {
                        var13_9 = "5GHZ";
                    }
                } else {
                    var14_10 = "AP";
                }
                if (this.e) {
                    af.a(af.a.dx).a(af.b.ag, var14_10).a(af.b.ah, var13_9).a();
                    var15_11 = "ScanQR";
                } else {
                    af.a(af.a.cj).a(af.b.ag, var14_10).a();
                    var15_11 = "ClickPortrait";
                }
                af.a(af.a.ck).a(af.b.ag, var14_10).a(af.b.ah, var13_9).a(af.b.ai, var15_11).a();
                if (this.f) {
                    af.a(af.a.dS).a(af.b.ay, "connect_start_send_popup").a();
                }
                var2_2.a = var1_1.a(this.c.b(), var12_8);
                var2_2.b = var11_4;
                var2_2.d = var14_10;
                var2_2.c = var13_9;
                var2_2.e = var15_11;
                if (var2_2.a == 0) return var2_2;
                TransmissionActivity.a(var2_2.a, this.e, var11_4);
                var16_12 = new StringBuilder("Connect fail, ret=");
                var16_12.append(var2_2.a);
                midrop.service.c.d.b("TransmissionActivity", var16_12.toString(), new Object[0]);
                return var2_2;
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
                RadarScannerFragment.b b2 = object;
                TransmissionActivity transmissionActivity = (TransmissionActivity)this.a.get();
                if (transmissionActivity == null) {
                    midrop.service.c.d.b("TransmissionActivity", "activity is null!", new Object[0]);
                    return;
                }
                b b3 = transmissionActivity.B;
                b3.a = b2.a;
                b3.b = b2.b;
                b3.c = b2.c;
                b3.d = b2.d;
                b3.e = b2.e;
                if (b2.a == 0) {
                    TransmissionActivity.a(transmissionActivity, b2.b);
                    int n2 = b2.b ? (this.e ? 4 : 1) : (this.e ? 3 : 6);
                    transmissionActivity.a(n2);
                    return;
                }
                am.a(b2.a);
                transmissionActivity.g();
            }

            protected final void onPreExecute() {
                if (this.a.get() != null) {
                    ((com.xiaomi.midrop.sender.ui.b)this.a.get()).b(this.c.a(), this.c.b(), this.e);
                }
                ae.a.e = this.e;
                ae.a.c = System.currentTimeMillis();
            }
        };
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
    }

    @Override
    public final void d() {
        if (this.u == null) {
            return;
        }
        try {
            this.u.a(new midrop.c.d.e(midrop.c.d.g.g));
        }
        catch (RemoteException remoteException) {}
    }

    @Override
    public final void e() {
        if (this.u == null) {
            return;
        }
        try {
            this.u.a(new midrop.c.d.e(midrop.c.d.g.d));
            return;
        }
        catch (RemoteException remoteException) {
            midrop.service.c.d.a("TransmissionActivity", "RemoteException", remoteException, new Object[0]);
            return;
        }
    }

    @Override
    public final void f() {
    }

    public final void g() {
        Toast.makeText((Context)MiDropApplication.a(), (int)2131689612, (int)1).show();
        this.A();
        this.B();
        af.a(af.a.dU).a();
    }

    protected void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        if (n2 == 1014 || n2 == 1015 || n2 == 1012) {
            TransmissionActivity.super.z();
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        String string2;
        super.onCreate(bundle);
        this.a = this.getIntent().getBooleanExtra("is_dialog_shown", false);
        C = true;
        ActivityManager.RunningServiceInfo runningServiceInfo = ReceiverService.c((Context)this);
        if (b.d.b.a() && runningServiceInfo != null) {
            if (runningServiceInfo.pid != 0) {
                this.startActivity(new Intent((Context)this, ReceiverInProgressDialog.class));
                this.finish();
                return;
            }
            ReceiverService.a((Context)this);
        }
        this.a(2131427384, true);
        TransmissionActivity.super.y();
        this.v = new ServiceConnection((TransmissionActivity)this, 0){
            final /* synthetic */ TransmissionActivity a;
            {
                this.a = transmissionActivity;
            }

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                boolean bl;
                this.a.u = k.a.a((IBinder)iBinder);
                try {
                    this.a.u.g();
                    this.a.u.a(this.a.p);
                    this.a.u.a(this.a.o);
                    this.a.u.a(new midrop.c.d.e(midrop.c.d.g.o));
                }
                catch (RemoteException remoteException) {
                    midrop.service.c.d.a("TransmissionActivity", "RemoteException", remoteException, new Object[0]);
                }
                if (this.a.D != null) {
                    this.a.D.a(this.a.u);
                }
                if (this.a.E != null) {
                    this.a.E.b(this.a.u);
                }
                this.a.i();
                com.xiaomi.midrop.receiver.ui.b b2 = this.a.b;
                b2.b = bl = Boolean.valueOf((boolean)true).booleanValue();
                b2.c = bl;
            }

            public final void onServiceDisconnected(ComponentName componentName) {
                Object[] arrobject = new Object[]{componentName.getShortClassName()};
                String.format((String)"onServiceDisconnected: %s", (Object[])arrobject);
            }
        };
        Intent intent = this.getIntent();
        if (intent != null && ("android.intent.action.SEND_MULTIPLE".equals((Object)(string2 = intent.getAction())) || "android.intent.action.SEND".equals((Object)string2))) {
            af.a("SendSelector");
        }
        this.F = new com.xiaomi.midrop.receiver.a((Context)this);
        this.F.a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xiaomi.midrop.action.OPEN_BLUETOOTH_FAIL");
        intentFilter.addAction("com.xiaomi.midrop.ACTION_BLUETOOTH_OFF_EXCEPTION");
        this.registerReceiver(this.J, intentFilter);
        ae.a.a = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        C = false;
        if (this.u != null) {
            try {
                this.u.a((m)null);
                this.u.b(this.o);
            }
            catch (RemoteException remoteException) {}
            this.unbindService((ServiceConnection)this.v);
            this.u = null;
            this.w = false;
            this.j();
        }
        if (this.F != null) {
            this.F.b();
        }
        try {
            this.unregisterReceiver(this.J);
        }
        catch (IllegalArgumentException illegalArgumentException) {}
        y.v();
        com.xiaomi.midrop.sender.c.a.a().b((Activity)this);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean onKeyDown(int var1, KeyEvent var2_2) {
        if (this.D == null) ** GOTO lbl-1000
        var4_3 = this.D;
        if (var4_3.a != null) {
            var3_4 = var4_3.a.onKeyDown(var1, var2_2);
        } else lbl-1000: // 2 sources:
        {
            var3_4 = false;
        }
        if (var3_4 != false) return true;
        if (super.onKeyDown(var1, var2_2) == false) return false;
        return true;
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.setIntent(intent);
        if ("android.intent.action.SEND".equals((Object)intent.getAction()) || "android.intent.action.SEND_MULTIPLE".equals((Object)intent.getAction()) || "com.xiaomi.midrop.FILE_LIST_SHARE".equals((Object)intent.getAction())) {
            TransmissionActivity.super.y();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.z();
        this.getWindow().addFlags(128);
        if (!this.o()) {
            if (this.p()) {
                return;
            }
            this.B();
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    protected void onStop() {
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

