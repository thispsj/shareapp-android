/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.app.Notification
 *  android.app.Notification$Builder
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.ServiceConnection
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcelable
 *  android.os.PowerManager
 *  android.os.RemoteException
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.k
 *  android.support.v4.app.q
 *  android.support.v7.app.c
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewStub
 *  android.widget.TextView
 *  android.widget.Toast
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.concurrent.Executor
 *  midrop.a.c.a.a.a
 *  midrop.a.c.a.a.a$a
 */
package com.xiaomi.midrop.receiver.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.support.v4.app.q;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import android.widget.Toast;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.d;
import com.xiaomi.midrop.e;
import com.xiaomi.midrop.receiver.a;
import com.xiaomi.midrop.receiver.service.ReceiverService;
import com.xiaomi.midrop.receiver.ui.ReceiveActivity;
import com.xiaomi.midrop.receiver.ui.ReceiveFragment;
import com.xiaomi.midrop.receiver.ui.TransferFragment;
import com.xiaomi.midrop.receiver.ui.WaitQrCodeFragment;
import com.xiaomi.midrop.receiver.ui.b;
import com.xiaomi.midrop.sender.c.h;
import com.xiaomi.midrop.sender.ui.b;
import com.xiaomi.midrop.transmission.b;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.ab;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.util.aq;
import com.xiaomi.midrop.util.ar;
import com.xiaomi.midrop.util.w;
import com.xiaomi.midrop.util.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import midrop.a.c.a.a.a;
import midrop.a.c.m;
import midrop.c.d.g;
import midrop.service.a.c;

public class ReceiveActivity
extends com.xiaomi.midrop.sender.ui.b
implements b.a {
    private static boolean u = false;
    private static int z = 1;
    private int A = 0;
    private boolean B;
    private com.xiaomi.midrop.qrcode.a C = null;
    private BroadcastReceiver D = new BroadcastReceiver(this){
        final /* synthetic */ ReceiveActivity a;
        {
            this.a = receiveActivity;
        }

        /*
         * Enabled aggressive block sorting
         */
        public final void onReceive(Context context, Intent intent) {
            if ("com.xiaomi.midrop.ACTION_BLUETOOTH_NOT_DISCOVERABLE".equals((Object)intent.getAction()) || "com.xiaomi.midrop.action.OPEN_BLUETOOTH_FAIL".equals((Object)intent.getAction())) {
                ReceiveActivity.a(this.a);
                return;
            }
            if ("com.xiaomi.midrop.action.AP_STARTED".equals((Object)intent.getAction()) || "com.xiaomi.midrop.action.BT_SERVICE_STARTED".equals((Object)intent.getAction())) {
                com.xiaomi.midrop.qrcode.a a2 = (com.xiaomi.midrop.qrcode.a)intent.getParcelableExtra("extra_info");
                if (ReceiveActivity.b(this.a) != null) {
                    ReceiveActivity.b(this.a).a(a2);
                }
            }
        }
    };
    private a.a E = new a.a(this){
        final /* synthetic */ ReceiveActivity a;
        {
            this.a = receiveActivity;
        }

        public final void a() {
            this.a.u();
        }

        public final void a(int n2) {
            if (n2 == 1) {
                e.a((Activity)this.a);
                af.a(af.a.w).a();
                return;
            }
            ReceiveActivity.c(this.a);
        }
    };
    private ServiceConnection F = new ServiceConnection(this){
        final /* synthetic */ ReceiveActivity a;
        {
            this.a = receiveActivity;
        }

        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            Object[] arrobject = new Object[]{componentName.getShortClassName()};
            String.format((String)"onServiceConnected: %s", (Object[])arrobject);
            ReceiveActivity.a(this.a, midrop.a.b.b$a.a((android.os.IBinder)iBinder));
            ReceiveActivity.i(this.a);
            ReceiveActivity.j(this.a);
            try {
                ReceiveActivity.l(this.a).a(ReceiveActivity.k(this.a));
                ReceiveActivity.l(this.a).a(ReceiveActivity.m(this.a));
                return;
            }
            catch (RemoteException remoteException) {
                midrop.service.c.d.a("ReceiveActivity", "RemoteExcption", remoteException, new Object[0]);
                return;
            }
        }

        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            Object[] arrobject = new Object[]{componentName.getShortClassName()};
            String.format((String)"onServiceDisconnected: %s", (Object[])arrobject);
        }
    };
    midrop.a.b.b a;
    private ReceiveFragment v;
    private WaitQrCodeFragment w;
    private a x;
    private boolean y = false;

    private void A() {
        Intent intent = new Intent("midrop.api.receiver.IReceiverService");
        intent.setPackage("com.xiaomi.midrop");
        ReceiverService.a((Context)this, null);
        this.bindService(intent, this.F, 1);
    }

    private void B() {
        com.xiaomi.midrop.util.Locale.b b2 = com.xiaomi.midrop.util.Locale.b.a();
        this.a(this.findViewById(2131296463), b2.b(2131689818), b2.b(2131689814), new View.OnClickListener(this){
            final /* synthetic */ ReceiveActivity a;
            {
                this.a = receiveActivity;
            }

            public void onClick(View view) {
                if (ReceiveActivity.l(this.a) != null) {
                    try {
                        ReceiveActivity.l(this.a).a(new midrop.c.d.e(g.k));
                        return;
                    }
                    catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                    }
                }
            }
        });
    }

    private void C() {
        if (this.a != null) {
            try {
                this.a.b();
                return;
            }
            catch (RemoteException remoteException) {
                midrop.service.c.d.a("ReceiveActivity", "stopReceiverService", remoteException, new Object[0]);
            }
        }
    }

    static /* synthetic */ midrop.a.b.b a(ReceiveActivity receiveActivity, midrop.a.b.b b2) {
        receiveActivity.a = b2;
        return b2;
    }

    private void a(Activity activity) {
        if (this.d(2131689657)) {
            return;
        }
        if (e.c((Context)this)) {
            this.w();
            return;
        }
        if (!e.a((Context)activity)) {
            com.xiaomi.midrop.util.Locale.b b2 = com.xiaomi.midrop.util.Locale.b.a();
            this.a(b2.b(2131689644), b2.b(2131689634), new View.OnClickListener((ReceiveActivity)this){
                final /* synthetic */ ReceiveActivity a;
                {
                    this.a = receiveActivity;
                }

                public void onClick(View view) {
                    this.a.a(e.c, 1, ReceiveActivity.d(this.a));
                    af.a(af.a.u).a(af.b.m, "Receive").a();
                }
            });
            af.a(af.a.t).a(af.b.m, "Receive").a();
            return;
        }
        this.a(e.c, 2, this.E);
    }

    static /* synthetic */ void a(ReceiveActivity receiveActivity) {
        receiveActivity.B();
    }

    static /* synthetic */ WaitQrCodeFragment b(ReceiveActivity receiveActivity) {
        return receiveActivity.w;
    }

    static /* synthetic */ void c(ReceiveActivity receiveActivity) {
        receiveActivity.A();
    }

    static /* synthetic */ a.a d(ReceiveActivity receiveActivity) {
        return receiveActivity.E;
    }

    static /* synthetic */ midrop.a.c.a.a.a e(ReceiveActivity receiveActivity) {
        return receiveActivity.m;
    }

    static /* synthetic */ midrop.a.c.a.a.a f(ReceiveActivity receiveActivity) {
        return receiveActivity.m;
    }

    static /* synthetic */ midrop.a.c.a.a.a g(ReceiveActivity receiveActivity) {
        return receiveActivity.m;
    }

    static /* synthetic */ com.xiaomi.midrop.sender.a h(ReceiveActivity receiveActivity) {
        return receiveActivity.i;
    }

    static /* synthetic */ void i(ReceiveActivity receiveActivity) {
        receiveActivity.i();
    }

    static /* synthetic */ int j(ReceiveActivity receiveActivity) {
        receiveActivity.d = 0;
        return 0;
    }

    static /* synthetic */ m k(ReceiveActivity receiveActivity) {
        return receiveActivity.p;
    }

    static /* synthetic */ midrop.a.b.a m(ReceiveActivity receiveActivity) {
        return receiveActivity.o;
    }

    static /* synthetic */ boolean p(ReceiveActivity receiveActivity) {
        return receiveActivity.B;
    }

    static /* synthetic */ boolean q(ReceiveActivity receiveActivity) {
        receiveActivity.B = true;
        return true;
    }

    private void y() {
        this.s();
        this.f = "";
        this.v = null;
        this.w = WaitQrCodeFragment.a();
        q q2 = this.getSupportFragmentManager().a();
        q2.b(2131296463, (Fragment)this.w);
        q2.b();
        q2.f();
        if (this.getIntent().getBooleanExtra("extra_vpn_alert", true) && aq.a()) {
            aq.a((Context)this, null);
        }
        if (this.getIntent().getBooleanExtra("extra_msg", true)) {
            this.B();
        }
        if (ar.b((Context)this) && !am.b()) {
            ar.a((Context)this);
        }
        if (this.b != null) {
            this.b.b();
            this.b.a();
        }
        this.C = (com.xiaomi.midrop.qrcode.a)this.getIntent().getParcelableExtra("receiverinfo");
    }

    private void z() {
        this.C();
        if (this.w != null) {
            WaitQrCodeFragment waitQrCodeFragment = this.w;
            waitQrCodeFragment.b();
            if (waitQrCodeFragment.b == null) {
                waitQrCodeFragment.b = ((ViewStub)waitQrCodeFragment.a.findViewById(2131296914)).inflate();
                if (waitQrCodeFragment.b != null) {
                    waitQrCodeFragment.b.findViewById(2131296519).setOnClickListener(waitQrCodeFragment.d);
                }
            }
            if (waitQrCodeFragment.b != null) {
                waitQrCodeFragment.b.setVisibility(0);
            }
            if (waitQrCodeFragment.c != null) {
                waitQrCodeFragment.c.setVisibility(4);
            }
        }
    }

    public final void a() {
        try {
            this.y();
            this.a.a();
        }
        catch (RemoteException remoteException) {
            new StringBuilder("restartWaitingReceive e=").append((Object)remoteException);
            remoteException.printStackTrace();
        }
        af.a(af.a.aG).a();
    }

    /*
     * Exception decompiling
     */
    @Override
    public final void a(b.b var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl29 : ICONST_1 : trying to set 1 previously set to 0
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

    @Override
    protected final void a(com.xiaomi.midrop.transmission.a.e e2) {
        if (this.v != null) {
            this.v.a(e2);
        }
    }

    @Override
    public final void a(List<Uri> list) {
        this.g = new ArrayList(list);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    protected final void a(midrop.a.c.a.a.a var1) {
        var2_2 = var1.b.a();
        var3_3 = 9.a[var2_2.ordinal()];
        var4_4 = 1;
        switch (var3_3) {
            default: {
                return;
            }
            case 2: {
                new StringBuilder("DEVICE_DISCONNECTED ").append(this.e);
                if (!this.e) ** GOTO lbl21
                if (this.p()) ** GOTO lbl15
                if (this.b == null) ** GOTO lbl16
                var6_5 = this.b;
                var7_6 = var6_5.f != null && var6_5.f.isShowing() != false;
                if (!var7_6 || this.b.d) ** GOTO lbl16
lbl15: // 2 sources:
                var4_4 = 0;
lbl16: // 3 sources:
                if (var4_4 != 0) {
                    ReceiveActivity.super.y();
                    this.g();
                } else {
                    ReceiveActivity.super.C();
                }
lbl21: // 3 sources:
                this.i.f = false;
                this.e = false;
                this.B = false;
                this.m = null;
                this.f = "";
                return;
            }
            case 1: 
        }
        this.m = var1;
        this.e = var4_4;
        this.i.f = var4_4;
        com.xiaomi.midrop.e.a.a(var1.b(), var4_4, y.w());
    }

    @Override
    protected final void a(midrop.c.d.e e2) {
        if (this.a != null) {
            try {
                this.a.a(e2);
                return;
            }
            catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
        }
    }

    @Override
    protected final void a(c c2, midrop.a.c.a.a.a a2) {
        if (this.a == null) {
            return;
        }
        if (c2.a == c.d.d) {
            int n2 = c2.d;
            int[] arrn = 9.b;
            int n3 = 1;
            switch (arrn[n2 - n3]) {
                default: {
                    return;
                }
                case 7: {
                    ReceiveActivity.super.B();
                    return;
                }
                case 6: {
                    return;
                }
                case 5: {
                    if (this.o()) {
                        ReceiveActivity.super.y();
                    }
                    if (this.b != null) {
                        b b2 = this.b;
                        if (b2.e == null || !b2.e.isShowing()) {
                            n3 = 0;
                        }
                        if (n3 != 0) {
                            this.b.a();
                        }
                    }
                    this.g();
                    return;
                }
                case 4: {
                    ReceiveActivity.super.z();
                    return;
                }
                case 3: {
                    if (this.w == null) break;
                    new StringBuilder("try to restart receiver, count=").append(this.A);
                    if (this.A < z) {
                        this.A = n3 + this.A;
                        this.g();
                        return;
                    }
                    ReceiveActivity.super.z();
                    return;
                }
                case 2: {
                    ReceiveActivity.super.z();
                }
                case 1: 
            }
            return;
        }
        super.a(c2, a2);
        if (this.k != null) {
            c.a a3 = c2.b;
            this.k.a(a3, a2);
        }
    }

    @Override
    public final boolean a(String string2, String string3) {
        super.a(string2, string3);
        if (this.a == null) {
            Toast.makeText((Context)MiDropApplication.a(), (int)2131689894, (int)1).show();
            return false;
        }
        this.w = null;
        this.v();
        if (this.v == null) {
            this.v = new ReceiveFragment();
            this.k = this.v;
            this.v.a(this.a);
            q q2 = this.getSupportFragmentManager().a();
            q2.a();
            q2.b(2131296463, (Fragment)this.v);
            q2.b();
            q2.f();
            this.q.post(new Runnable((ReceiveActivity)this){
                final /* synthetic */ ReceiveActivity a;
                {
                    this.a = receiveActivity;
                }

                public final void run() {
                    if (ReceiveActivity.e(this.a) == null) {
                        midrop.service.c.d.b("ReceiveActivity", "loadPackages err, mFileReceiver is null", new Object[0]);
                        return;
                    }
                    new StringBuilder("Safe transfer ").append(ReceiveActivity.f(this.a).f());
                    ReceiveActivity.h(this.a).a(ReceiveActivity.g(this.a).f());
                }
            });
        } else {
            this.v.a(TransferFragment.c.a);
        }
        try {
            this.a.a(new midrop.c.d.e(g.c));
            this.m = this.a.d();
        }
        catch (RemoteException remoteException) {}
        if (!ab.a((PowerManager)this.getSystemService("power")) || this.v == null) {
            Intent intent = new Intent((Context)this, ReceiveActivity.class);
            intent.putExtra("from", string3);
            intent.putExtra("file_preview_path", string2);
            intent.putExtra("receiver_service_pid", ReceiverService.b((Context)this));
            com.xiaomi.midrop.receiver.a.a a2 = this.l.b;
            a2.a();
            d d2 = a2.b;
            String string4 = a2.a.getString(2131689777);
            PendingIntent pendingIntent = PendingIntent.getActivity((Context)d2.b, (int)0, (Intent)intent, (int)1073741824);
            Notification.Builder builder = d2.a();
            builder.setDefaults(5);
            builder.setTicker((CharSequence)"MiDrop");
            builder.setContentTitle((CharSequence)"MiDrop");
            builder.setContentText((CharSequence)string4);
            builder.setContentIntent(pendingIntent);
            builder.setWhen(System.currentTimeMillis());
            builder.setOngoing(false);
            builder.setAutoCancel(true);
            Notification notification = builder.build();
            d2.a.notify(2131689777, notification);
            String.format((String)"showLockScreenNotification-[title=%s]", (Object[])new Object[]{"MiDrop"});
        }
        this.r.sendEmptyMessage(2);
        this.r.post(new Runnable((ReceiveActivity)this){
            final /* synthetic */ ReceiveActivity a;
            {
                this.a = receiveActivity;
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final void run() {
                midrop.a.c.a.a.a a2;
                try {
                    a2 = ReceiveActivity.l(this.a).d();
                    if (ReceiveActivity.p(this.a) || a2 == null) return;
                }
                catch (Exception exception) {
                    midrop.service.c.d.a("ReceiveActivity", "send uri list", exception, new Object[0]);
                    return;
                }
                if (!com.xiaomi.midrop.profile.a$a.b(a2.b()) || y.C() != 101) return;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(com.xiaomi.midrop.profile.a.c().getPath());
                stringBuilder.append("?silent_transfer=true");
                Uri uri = Uri.parse((String)stringBuilder.toString());
                ArrayList arrayList = new ArrayList();
                arrayList.add((Object)uri);
                ReceiveActivity.l(this.a).a((List<Uri>)arrayList);
                ReceiveActivity.q(this.a);
            }
        });
        return true;
    }

    @Override
    public final boolean a(String string2, String string3, boolean bl) {
        if (this.a == null) {
            return false;
        }
        try {
            this.a.a(new midrop.c.d.e(g.h));
        }
        catch (RemoteException remoteException) {
            midrop.service.c.d.a("ReceiveActivity", "RemoteException", remoteException, new Object[0]);
        }
        if (!bl) {
            this.b(string2, string3, false);
            this.a(1);
        }
        return true;
    }

    @Override
    public final void b() {
        super.b();
        this.d = 1;
    }

    @Override
    public final void b(String string2, String string3, boolean bl) {
        super.b(string2, string3, bl);
        this.v = null;
        this.w = null;
    }

    @Override
    public final void b(List<Uri> list) {
        if (list != null && !list.isEmpty()) {
            if (this.v == null) {
                return;
            }
            if (this.a == null) {
                midrop.service.c.d.b("ReceiveActivity", "receiver service is null!", new Object[0]);
                return;
            }
            if (list != null) {
                if (list.isEmpty()) {
                    return;
                }
                try {
                    h<Uri> h2 = new h<Uri>(list);
                    h2.b(50, new h.a<Uri>((ReceiveActivity)this, h2){
                        final /* synthetic */ h a;
                        final /* synthetic */ ReceiveActivity b;
                        {
                            this.b = receiveActivity;
                            this.a = h2;
                        }

                        public final List<Uri> a(int n2, int n3) {
                            List<T> list = this.a.a(n2, n3);
                            try {
                                ReceiveActivity.l(this.b).b(list);
                                return list;
                            }
                            catch (RemoteException remoteException) {
                                remoteException.printStackTrace();
                                return list;
                            }
                        }
                    });
                    this.a.b((List<Uri>)null);
                    return;
                }
                catch (RemoteException remoteException) {
                    remoteException.printStackTrace();
                }
            }
        }
    }

    @Override
    public final void c() {
        super.c();
        if (this.a == null) {
            Toast.makeText((Context)MiDropApplication.a(), (int)2131689894, (int)1).show();
            return;
        }
        try {
            this.a.a(new midrop.c.d.e(g.d));
            Intent intent = new Intent();
            intent.setAction("miui.intent.action.GARBAGE_CLEANUP");
            this.startActivity(intent);
            this.finish();
            return;
        }
        catch (IllegalStateException illegalStateException) {
            midrop.service.c.d.a("ReceiveActivity", "IllegalStateException", illegalStateException, new Object[0]);
            return;
        }
        catch (RemoteException remoteException) {
            midrop.service.c.d.a("ReceiveActivity", "RemoteException", remoteException, new Object[0]);
            return;
        }
    }

    @Override
    public final void d() {
        super.d();
        if (this.a == null) {
            return;
        }
        try {
            this.a.a(new midrop.c.d.e(g.g));
        }
        catch (RemoteException remoteException) {}
    }

    @Override
    public final void e() {
        super.e();
        if (this.a == null) {
            return;
        }
        try {
            this.a.a(new midrop.c.d.e(g.d));
        }
        catch (RemoteException remoteException) {
            midrop.service.c.d.a("ReceiveActivity", "RemoteException", remoteException, new Object[0]);
        }
        if (this.b != null && !this.b.d && !this.p()) {
            this.a();
        }
    }

    @Override
    public final void f() {
        if (this.a == null) {
            return;
        }
        try {
            this.a.a(new midrop.c.d.e(g.i));
            return;
        }
        catch (RemoteException remoteException) {
            midrop.service.c.d.a("ReceiveActivity", "RemoteException", remoteException, new Object[0]);
            return;
        }
    }

    public final void g() {
        this.v();
        if (this.a != null) {
            try {
                this.a.a(new midrop.c.d.e(g.l));
                return;
            }
            catch (RemoteException remoteException) {
                midrop.service.c.d.a("ReceiveActivity", "start", remoteException, new Object[0]);
            }
        }
    }

    @SuppressLint(value={"NewApi"})
    protected void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        if (n2 == 1015 && e.a((Context)this)) {
            ReceiveActivity.super.A();
            af.a(af.a.x).a();
            return;
        }
        if (n2 != 1014 && n2 != 1012) {
            e.b();
            this.finish();
            return;
        }
        ReceiveActivity.super.a((Activity)this);
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a(2131427374, true);
        this.setTitle((CharSequence)this.getString(2131690029));
        ReceiveActivity.super.y();
        this.x = new a((Context)this);
        this.x.a();
        u = true;
        try {
            this.unregisterReceiver(this.D);
        }
        catch (Exception exception) {}
        IntentFilter intentFilter = new IntentFilter("com.xiaomi.midrop.ACTION_BLUETOOTH_NOT_DISCOVERABLE");
        intentFilter.addAction("com.xiaomi.midrop.action.OPEN_BLUETOOTH_FAIL");
        intentFilter.addAction("com.xiaomi.midrop.action.AP_STARTED");
        intentFilter.addAction("com.xiaomi.midrop.action.BT_SERVICE_STARTED");
        this.registerReceiver(this.D, intentFilter);
    }

    @Override
    public void onDestroy() {
        if (this.a != null) {
            try {
                this.p = null;
                this.a.a((m)null);
                this.a.b(this.o);
                this.o = null;
                this.a.b();
            }
            catch (RemoteException remoteException) {
                midrop.service.c.d.a("ReceiveActivity", "RemoteExcption", remoteException, new Object[0]);
            }
            this.unbindService(this.F);
            this.a = null;
            this.stopService(new Intent((Context)this, ReceiverService.class));
        }
        if (this.x != null) {
            this.x.b();
        }
        this.j();
        u = false;
        this.unregisterReceiver(this.D);
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.setIntent(intent);
        if ("com.xiaomi.midrop.FILE_LIST_SHARE".equals((Object)intent.getAction()) && this.a != null) {
            if ("com.xiaomi.midrop.FILE_LIST_SHARE".equals((Object)this.getIntent().getAction())) {
                this.g = com.xiaomi.midrop.sender.c.e.a((Context)this, com.xiaomi.midrop.sender.c.d.a());
            }
            if (this.g == null || this.g.isEmpty()) {
                Toast.makeText((Context)this, (int)2131689977, (int)1).show();
            }
            if (!this.g.isEmpty()) {
                new com.xiaomi.midrop.transmission.b((b.a)this, (List<Uri>)this.g).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!this.o()) {
            if (this.p()) {
                return;
            }
            Intent intent = this.getIntent();
            if (intent != null && "com.xiaomi.midrop.FILE_LIST_SHARE".equals((Object)intent.getAction())) {
                this.a((Activity)this);
                return;
            }
            if (this.w != null) {
                WaitQrCodeFragment waitQrCodeFragment = this.w;
                boolean bl = waitQrCodeFragment.b != null && waitQrCodeFragment.b.getVisibility() == 0;
                if (!bl) {
                    this.a((Activity)this);
                }
            }
            this.w.a(this.C);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}

