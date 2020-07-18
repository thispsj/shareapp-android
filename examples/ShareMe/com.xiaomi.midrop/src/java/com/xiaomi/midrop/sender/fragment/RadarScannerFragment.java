/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.RemoteException
 *  android.os.SystemClock
 *  android.support.v4.app.g
 *  android.support.v4.app.k
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.google.zxing.d.a.a
 *  com.google.zxing.d.a.b
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.Executor
 *  midrop.a.c.a.a.a
 */
package com.xiaomi.midrop.sender.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.midrop.receiver.ui.QRAutoScanDialogFragment;
import com.xiaomi.midrop.sender.fragment.RadarScannerFragment;
import com.xiaomi.midrop.sender.ui.TransmissionActivity;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.ae;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.view.BaseFragment;
import com.xiaomi.midrop.view.ProfileImageView;
import com.xiaomi.midrop.view.RadarScanView;
import com.xiaomi.midrop.view.RadarViewLayout;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import midrop.c.a.e;
import midrop.service.c.d;

public class RadarScannerFragment
extends BaseFragment {
    private View.OnClickListener A = new View.OnClickListener(this){
        final /* synthetic */ RadarScannerFragment a;
        {
            this.a = radarScannerFragment;
        }

        public void onClick(View view) {
            block6 : {
                block3 : {
                    block4 : {
                        block5 : {
                            int n2 = view.getId();
                            if (n2 == 2131296485) break block3;
                            if (n2 == 2131296553) break block4;
                            if (n2 == 2131296700) break block5;
                            if (n2 != 2131296810) {
                                return;
                            }
                            break block3;
                        }
                        RadarScannerFragment.j(this.a);
                        return;
                    }
                    long l2 = SystemClock.elapsedRealtime();
                    if (l2 - RadarScannerFragment.d(this.a) < 1000L) {
                        d.b("RadarScannerFragment", "You click portrait too fast!", new Object[0]);
                        return;
                    }
                    RadarScannerFragment.a(this.a, l2);
                    midrop.a.c.a.a.a a2 = (midrop.a.c.a.a.a)view.getTag();
                    if (a2 != null) {
                        com.xiaomi.midrop.profile.a$a.a(a2.b(), a2.a.l());
                        RadarScannerFragment.e(this.a);
                        RadarScannerFragment.f(this.a);
                        AsyncTask<Void, Void, b> asyncTask = new AsyncTask<Void, Void, b>(this.a, RadarScannerFragment.g(this.a), a2, (List<Uri>)RadarScannerFragment.h(this.a), false, RadarScannerFragment.i(this.a)){
                            private WeakReference<RadarScannerFragment> a;
                            private WeakReference<midrop.a.c.k> b;
                            private midrop.a.c.a.a.a c;
                            private List<Uri> d;
                            private boolean e;
                            private boolean f;
                            {
                                this.a = new WeakReference((Object)radarScannerFragment);
                                this.b = new WeakReference((Object)k2);
                                this.c = a2;
                                this.d = list;
                                this.e = bl;
                                this.f = bl2;
                            }

                            /*
                             * Unable to fully structure code
                             * Enabled aggressive block sorting
                             * Enabled unnecessary exception pruning
                             * Enabled aggressive exception aggregation
                             * Lifted jumps to return sites
                             */
                            private /* varargs */ b a() {
                                var1_1 = (midrop.a.c.k)this.b.get();
                                var2_2 = new Object(){
                                    public int a;
                                    public boolean b;
                                    public String c = "2GHZ";
                                    public String d;
                                    public String e;
                                };
                                if (var1_1 != null && this.d != null) {
                                    try {
                                        var10_3 = RadarScannerFragment.a(this.d);
                                        var11_4 = (var10_3 != false || this.c.a.i() == false || am.f() != false) && TextUtils.isEmpty((CharSequence)this.c.a.e()) == false;
                                        var12_5 = "2GHZ";
                                        if (!var11_4) {
                                            var13_6 = "BT";
                                            if (!this.c.a.i()) ** GOTO lbl27
                                            var12_5 = "5GHZ";
                                        }
                                        break block8;
                                    }
                                    catch (RemoteException var9_9) {
                                        d.a("RadarScannerFragment", "RemoteException", var9_9, new Object[0]);
                                        return var2_2;
                                    }
                                } else {
                                    block8 : {
                                        var3_10 = new StringBuilder("Connect failed, deviceId=");
                                        var3_10.append(this.c.b());
                                        var3_10.append(" senderManagerService=");
                                        var3_10.append(this.b);
                                        var3_10.append(" fileUris=");
                                        var3_10.append(this.d);
                                        d.b("RadarScannerFragment", var3_10.toString(), new Object[0]);
                                        return var2_2;
                                    }
                                    var13_6 = "AP";
                                }
lbl27: // 3 sources:
                                if (this.e) {
                                    af.a(af.a.dx).a(af.b.ag, var13_6).a(af.b.ah, var12_5).a();
                                    var14_7 = "ScanQR";
                                } else {
                                    af.a(af.a.cj).a(af.b.ag, var13_6).a();
                                    var14_7 = "ClickPortrait";
                                }
                                af.a(af.a.ck).a(af.b.ag, var13_6).a(af.b.ah, var12_5).a(af.b.ai, var14_7).a();
                                if (this.f) {
                                    af.a(af.a.dS).a(af.b.ay, "connect_start_send_popup").a();
                                }
                                var2_2.a = var1_1.a(this.c.b(), var10_3);
                                var2_2.b = var11_4;
                                var2_2.d = var13_6;
                                var2_2.c = var12_5;
                                var2_2.e = var14_7;
                                if (var2_2.a == 0) return var2_2;
                                RadarScannerFragment.a(var2_2.a, this.e, var11_4);
                                var15_8 = new StringBuilder("Connect fail, ret=");
                                var15_8.append(var2_2.a);
                                d.b("RadarScannerFragment", var15_8.toString(), new Object[0]);
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
                                b b2 = object;
                                RadarScannerFragment radarScannerFragment = (RadarScannerFragment)((Object)this.a.get());
                                if (radarScannerFragment == null) {
                                    d.b("RadarScannerFragment", "fragment is null!", new Object[0]);
                                    return;
                                }
                                b b3 = radarScannerFragment.r;
                                b3.a = b2.a;
                                b3.b = b2.b;
                                b3.c = b2.c;
                                b3.d = b2.d;
                                b3.e = b2.e;
                                if (b2.a == 0) {
                                    RadarScannerFragment.a(radarScannerFragment, b2.b);
                                    int n2 = b2.b ? (this.e ? 4 : 1) : (this.e ? 3 : 6);
                                    RadarScannerFragment.a(radarScannerFragment, n2);
                                    return;
                                }
                                RadarScannerFragment.b(radarScannerFragment, b2.a);
                            }

                            protected final void onPreExecute() {
                                if (this.a.get() != null) {
                                    RadarScannerFragment.a((RadarScannerFragment)((Object)this.a.get()), this.c.a(), this.c.b(), this.e);
                                }
                                ae.a.e = this.e;
                                ae.a.c = System.currentTimeMillis();
                            }
                        };
                        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
                        return;
                    }
                    break block6;
                }
                this.a.getActivity().onBackPressed();
            }
        }
    };
    QRAutoScanDialogFragment a = null;
    Handler b = new Handler(this){
        final /* synthetic */ RadarScannerFragment a;
        {
            this.a = radarScannerFragment;
        }

        public final void handleMessage(android.os.Message message) {
            switch (message.what) {
                default: {
                    return;
                }
                case 2: {
                    RadarScannerFragment.a(this.a);
                    return;
                }
                case 1: 
            }
            RadarScannerFragment.b(this.a);
        }
    };
    private View c;
    private View d;
    private RadarScanView e;
    private RadarViewLayout f;
    private List<Uri> g;
    private midrop.a.c.k h;
    private Map<String, View> i;
    private ProfileImageView j;
    private TextView k;
    private View l;
    private View m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q = true;
    private b r = new /* invalid duplicate definition of identical inner class */;
    private long s;
    private boolean t;
    private long u;
    private boolean v;
    private long w = 0L;
    private final int x = 5000;
    private boolean y;
    private boolean z = true;

    static /* synthetic */ long a(RadarScannerFragment radarScannerFragment, long l2) {
        radarScannerFragment.u = l2;
        return l2;
    }

    static /* synthetic */ void a(int n2, boolean bl, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder("recordConnectFail, err=");
        stringBuilder.append(n2);
        stringBuilder.append(" scanQrCode=");
        stringBuilder.append(bl);
        stringBuilder.append(" useAp=");
        stringBuilder.append(bl2);
        d.a("RadarScannerFragment", stringBuilder.toString(), new Object[0]);
        if (bl) {
            af.a(af.a.dz).a(af.b.O, n2).a();
        }
        String string2 = bl ? "ScanQR" : "ClickPortrait";
        String string3 = bl2 ? "AP" : "BT";
        af.a(af.a.cr).a(af.b.O, n2).a(af.b.ai, string2).a(af.b.ag, string3).a();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(View view, midrop.a.c.a.a.a a2) {
        view.setTag((Object)a2);
        view.setOnClickListener(this.A);
        ((ProfileImageView)view.findViewById(2131296418)).a(a2.a.l(), a2.b(), a2.a());
        ((TextView)view.findViewById(2131296423)).setText((CharSequence)a2.a());
        ImageView imageView = (ImageView)view.findViewById(2131296687);
        int n2 = a2.a.i() ? 0 : 8;
        imageView.setVisibility(n2);
    }

    static /* synthetic */ void a(RadarScannerFragment radarScannerFragment) {
        if (!radarScannerFragment.a()) {
            radarScannerFragment.e.a();
            radarScannerFragment.b();
        }
    }

    static /* synthetic */ void a(RadarScannerFragment radarScannerFragment, int n2) {
        TransmissionActivity transmissionActivity = (TransmissionActivity)radarScannerFragment.getActivity();
        if (transmissionActivity != null) {
            transmissionActivity.a(n2);
        }
    }

    static /* synthetic */ void a(RadarScannerFragment radarScannerFragment, String string2, String string3, boolean bl) {
        TransmissionActivity transmissionActivity = (TransmissionActivity)radarScannerFragment.getActivity();
        if (transmissionActivity != null) {
            transmissionActivity.b(string2, string3, bl);
        }
    }

    static /* synthetic */ void a(RadarScannerFragment radarScannerFragment, boolean bl) {
        radarScannerFragment.p = bl;
    }

    private boolean a() {
        return !this.isAdded() || this.isDetached() || this.isHidden() || this.isRemoving();
        {
        }
    }

    static /* synthetic */ boolean a(List list) {
        if (list != null) {
            long l2 = 0L;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                String string2 = ((Uri)iterator.next()).getPath();
                if (TextUtils.isEmpty((CharSequence)string2)) continue;
                l2 += new File(string2).length();
            }
            if (l2 < 524288000L) {
                return true;
            }
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    private void b() {
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

    static /* synthetic */ void b(RadarScannerFragment radarScannerFragment) {
        g g2 = radarScannerFragment.getActivity();
        if (g2 != null && !g2.isDestroyed() && !g2.isFinishing()) {
            if (!radarScannerFragment.isVisible()) {
                return;
            }
            if (radarScannerFragment.a != null) {
                if (radarScannerFragment.a.isVisible()) {
                    radarScannerFragment.a.dismissAllowingStateLoss();
                }
                radarScannerFragment.a = null;
            }
            radarScannerFragment.a = new QRAutoScanDialogFragment();
            if (radarScannerFragment.a != null) {
                radarScannerFragment.a.show(radarScannerFragment.getChildFragmentManager(), "AutoScanHint");
            }
        }
    }

    static /* synthetic */ void b(RadarScannerFragment radarScannerFragment, int n2) {
        TransmissionActivity transmissionActivity = (TransmissionActivity)radarScannerFragment.getActivity();
        am.a(n2);
        if (transmissionActivity != null) {
            transmissionActivity.g();
        }
    }

    static /* synthetic */ long d(RadarScannerFragment radarScannerFragment) {
        return radarScannerFragment.u;
    }

    static /* synthetic */ boolean e(RadarScannerFragment radarScannerFragment) {
        radarScannerFragment.o = false;
        return false;
    }

    static /* synthetic */ boolean f(RadarScannerFragment radarScannerFragment) {
        radarScannerFragment.v = true;
        return true;
    }

    static /* synthetic */ midrop.a.c.k g(RadarScannerFragment radarScannerFragment) {
        return radarScannerFragment.h;
    }

    static /* synthetic */ List h(RadarScannerFragment radarScannerFragment) {
        return radarScannerFragment.g;
    }

    static /* synthetic */ boolean i(RadarScannerFragment radarScannerFragment) {
        return radarScannerFragment.y;
    }

    static /* synthetic */ void j(RadarScannerFragment radarScannerFragment) {
        am.a(radarScannerFragment, "scan_page");
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.b.sendEmptyMessageDelayed(2, 300L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onActivityResult(int n2, int n3, Intent intent) {
        String string2;
        String string3;
        com.google.zxing.d.a.b b2 = com.google.zxing.d.a.a.a((int)n2, (int)n3, (Intent)intent);
        if (b2 != null && b2.a != null) {
            if (this.h != null) {
                try {
                    midrop.a.c.a.a.a a2 = this.h.c(b2.a);
                    if (a2 != null) {
                        this.o = true;
                        this.v = true;
                        AsyncTask<Void, Void, b> asyncTask = new /* invalid duplicate definition of identical inner class */;
                        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
                    }
                    return;
                }
                catch (RemoteException remoteException) {
                    remoteException.printStackTrace();
                    return;
                }
            }
            string3 = "RadarScannerFragment";
            string2 = "mSenderManagerService is null!";
        } else {
            string3 = "RadarScannerFragment";
            string2 = "scan result is null!";
        }
        d.b(string3, string2, new Object[0]);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i = new HashMap();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = layoutInflater.inflate(2131427443, viewGroup, false);
        return this.c;
    }

    public void onDestroy() {
        super.onDestroy();
        this.j = null;
        if (this.a != null) {
            this.a = null;
        }
        this.b.removeMessages(1);
        this.b = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.e.b();
        int n2 = (int)((SystemClock.elapsedRealtime() - this.s) / 1000L);
        af af2 = af.a(af.a.ci).a(af.b.au, n2);
        af.b b2 = af.b.av;
        String string2 = this.t ? "yes" : "no";
        af2.a(b2, string2).a();
    }

    public void onResume() {
        super.onResume();
        if (this.j != null) {
            this.j.a();
        }
        this.b();
    }

    public void onStop() {
        super.onStop();
        this.b.removeMessages(1);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(2131296810).setVisibility(8);
        View view2 = view.findViewById(2131296485);
        if (ac.c(this.getContext())) {
            view2.setRotation(180.0f);
        }
        view2.setOnClickListener(this.A);
        view.findViewById(2131296340).setVisibility(8);
        view.setBackgroundDrawable((Drawable)new ColorDrawable(this.getResources().getColor(2131099932)));
        view.setPadding(0, ag.a((Context)this.getActivity()), 0, 0);
        this.d = view.findViewById(2131296700);
        am.a((Context)this.getActivity(), (TextView)this.d, 2131231356);
        this.d.setOnClickListener(this.A);
        this.e = (RadarScanView)view.findViewById(2131296668);
        this.f = (RadarViewLayout)view.findViewById(2131296555);
        if (this.j == null) {
            this.j = (ProfileImageView)view.findViewById(2131296418);
        }
        this.e.setGradientEndColor(this.getResources().getColor(2131100066));
        this.k = (TextView)view.findViewById(2131296723);
        this.l = view.findViewById(2131296662);
        this.m = view.findViewById(2131296660);
        af.a(af.a.cg).a();
        this.s = SystemClock.elapsedRealtime();
        this.i.clear();
        this.w = System.currentTimeMillis();
        this.v = false;
    }

}

