/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.RemoteException
 *  android.support.v4.app.g
 *  android.support.v4.view.ViewPager
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 *  android.widget.ImageView
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  midrop.a.c.a.a.a
 */
package com.xiaomi.midrop.sender.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v4.app.g;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.xiaomi.midrop.sender.fragment.ScannerFragment;
import com.xiaomi.midrop.sender.ui.e;
import com.xiaomi.midrop.sender.ui.f;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.util.y;
import com.xiaomi.midrop.view.BaseFragment;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import midrop.a.c.k;
import midrop.service.c.d;

@Deprecated
public class ScannerFragment
extends BaseFragment {
    private static final String b = "ScannerFragment";
    f.b a = new f.b(this){
        final /* synthetic */ ScannerFragment a;
        {
            this.a = scannerFragment;
        }

        public final void a(midrop.a.c.a.a.a a2) {
            if (a2 != null) {
                new AsyncTask<Void, Void, Void>(ScannerFragment.b(this.a), a2, (List<Uri>)ScannerFragment.c(this.a)){
                    private WeakReference<k> a;
                    private midrop.a.c.a.a.a b;
                    private List<Uri> c;
                    {
                        this.a = new WeakReference((Object)k2);
                        this.b = a2;
                        this.c = list;
                    }

                    private /* varargs */ Void a() {
                        k k2 = (k)this.a.get();
                        if (this.b != null && k2 != null && this.c != null) {
                            try {
                                k2.a(this.b.b(), ScannerFragment.a(this.c));
                            }
                            catch (RemoteException remoteException) {
                                d.a(b, "RemoteException", remoteException, new Object[0]);
                            }
                        } else {
                            String string2 = b;
                            StringBuilder stringBuilder = new StringBuilder("Connect failed, fileReceiver=");
                            stringBuilder.append((Object)this.b);
                            stringBuilder.append(" senderManagerService=");
                            stringBuilder.append(this.a);
                            stringBuilder.append(" fileUris=");
                            stringBuilder.append(this.c);
                            d.b(string2, stringBuilder.toString(), new Object[0]);
                        }
                        return null;
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
                }.execute((Object[])new Void[0]);
            }
        }
    };
    private final int c = 1;
    private final int d = 2;
    private final int e = 3;
    private final int f = 30000;
    private int g;
    private Activity h;
    private View i;
    private View j;
    private View k;
    private Animation l;
    private com.xiaomi.midrop.sender.ui.a m;
    private f n;
    private k o;
    private List<Uri> p;
    private Handler q;
    private String r;
    private String s;
    private Runnable t = new Runnable(this){
        final /* synthetic */ ScannerFragment a;
        {
            this.a = scannerFragment;
        }

        public final void run() {
            ScannerFragment.d(this.a);
        }
    };

    static /* synthetic */ Activity a(ScannerFragment scannerFragment) {
        return scannerFragment.h;
    }

    /*
     * Exception decompiling
     */
    private void a(int var1) {
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

    static /* synthetic */ boolean a(List list) {
        if (list != null) {
            long l2 = 0L;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                String string2 = ((Uri)iterator.next()).getPath();
                if (TextUtils.isEmpty((CharSequence)string2)) continue;
                l2 += new File(string2).length();
            }
            if (l2 < 31457280L) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ k b(ScannerFragment scannerFragment) {
        return scannerFragment.o;
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

    static /* synthetic */ List c(ScannerFragment scannerFragment) {
        return scannerFragment.p;
    }

    static /* synthetic */ void d(ScannerFragment scannerFragment) {
        scannerFragment.a(3);
    }

    static /* synthetic */ void e(ScannerFragment scannerFragment) {
        scannerFragment.b();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.h = (Activity)context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.q = new Handler();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.i = layoutInflater.inflate(2131427442, viewGroup, false);
        return this.i;
    }

    public void onDestroy() {
        if (this.n != null) {
            f f2 = this.n;
            f2.a.clear();
            f2.e.clear();
            f2.c.removeAllViews();
            f2.d.clear();
        }
        super.onDestroy();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onDestroyView() {
        this.q.removeCallbacks(this.t);
        super.onDestroyView();
        if (TextUtils.isEmpty((CharSequence)this.r)) {
            this.r = "none";
        } else {
            af.a(af.a.ch).a();
            af.a a2 = y.u() ? af.a.cG : af.a.cI;
            af.a(a2).a();
        }
        af.a(af.a.ar).a(af.b.s, this.r).a(af.b.w, this.s).a();
    }

    public void onPause() {
        super.onPause();
        if (this.g == 1) {
            com.xiaomi.midrop.sender.ui.a a2 = this.m;
            if (a2.k && a2.m) {
                a2.b.setVisibility(4);
                a2.b.clearAnimation();
                a2.c.setVisibility(4);
                a2.c.clearAnimation();
                a2.d.setVisibility(4);
                a2.d.clearAnimation();
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (this.g == 1) {
            this.m.d();
        }
    }

    public void onStart() {
        super.onStart();
        this.k.startAnimation(this.l);
    }

    public void onStop() {
        super.onStop();
        this.k.clearAnimation();
    }

    public void onViewCreated(View view, Bundle bundle) {
        View.OnClickListener onClickListener = new View.OnClickListener((ScannerFragment)this){
            final /* synthetic */ ScannerFragment a;
            {
                this.a = scannerFragment;
            }

            public void onClick(View view) {
                ScannerFragment.a(this.a).onBackPressed();
            }
        };
        view.findViewById(2131296810).setOnClickListener(onClickListener);
        View view2 = view.findViewById(2131296485);
        if (ac.c(this.getContext())) {
            view2.setRotation(180.0f);
        }
        view2.setOnClickListener(onClickListener);
        this.k = view.findViewById(2131296340);
        view.setBackgroundDrawable((Drawable)new ColorDrawable(this.getResources().getColor(2131100072)));
        view.setPadding(0, ag.a((Context)this.getActivity()), 0, 0);
        this.l = AnimationUtils.loadAnimation((Context)this.h, (int)2130771983);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.l.setInterpolator((Interpolator)linearInterpolator);
        this.l.setFillAfter(true);
        com.xiaomi.midrop.sender.ui.a a2 = this.m = new com.xiaomi.midrop.sender.ui.a((Context)this.h, view);
        if (a2.k) {
            a2.d();
        } else {
            a2.l = false;
            a2.m = false;
            a2.n = false;
            a2.p.sendEmptyMessage(1);
        }
        View view3 = view.findViewById(2131296680);
        this.n = new f((Context)this.h, view3, this.a);
        this.g = 1;
        this.q.postDelayed(this.t, 30000L);
        ScannerFragment.super.b();
        ((com.xiaomi.midrop.util.Locale.a)this.h).s();
    }

}

