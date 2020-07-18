/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.RemoteException
 *  android.support.v4.app.g
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$b
 *  android.support.v7.widget.RecyclerView$i
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.google.zxing.d.a.a
 *  com.google.zxing.d.a.b
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  midrop.a.c.a.a.a
 */
package com.xiaomi.midrop.sender.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v4.app.g;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.zxing.d.a.b;
import com.journeyapps.barcodescanner.BarcodeView;
import com.journeyapps.barcodescanner.ViewfinderView;
import com.journeyapps.barcodescanner.d;
import com.xiaomi.midrop.qrcode.ModifiedDecoratedBarcodeView;
import com.xiaomi.midrop.qrcode.QrCodeViewfinderView;
import com.xiaomi.midrop.sender.adapter.a;
import com.xiaomi.midrop.sender.c.c;
import com.xiaomi.midrop.sender.fragment.QRCodeScannerFragment;
import com.xiaomi.midrop.sender.ui.TransmissionActivity;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.util.y;
import com.xiaomi.midrop.view.BaseFragment;
import com.xiaomi.midrop.view.ProfileImageView;
import com.xiaomi.midrop.view.RadarScanView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import midrop.a.c.k;
import midrop.c.a.e;
import midrop.c.d.c;

public class QRCodeScannerFragment
extends BaseFragment
implements a.a {
    public ModifiedDecoratedBarcodeView a;
    public boolean b;
    public boolean c = true;
    public com.xiaomi.midrop.sender.adapter.a d;
    public Map<String, midrop.a.c.a.a.a> e;
    public long f = 0L;
    private final int g = 5000;
    private com.xiaomi.midrop.view.e h;
    private View i;
    private BarcodeView j;
    private k k;
    private boolean l = true;
    private Handler m = new Handler();
    private TextView n;
    private Context o;
    private boolean p = false;
    private com.journeyapps.barcodescanner.a q = new com.journeyapps.barcodescanner.a(this){
        final /* synthetic */ QRCodeScannerFragment a;
        {
            this.a = qRCodeScannerFragment;
        }

        public final void a(com.journeyapps.barcodescanner.c c2) {
            if (c2.b() != null) {
                if (com.xiaomi.midrop.qrcode.a.a(c2.b()) != null) {
                    QRCodeScannerFragment.a(this.a, c2);
                    return;
                }
                QRCodeScannerFragment.c(this.a).postDelayed(new Runnable(this){
                    final /* synthetic */ 1 a;
                    {
                        this.a = var1;
                    }

                    public final void run() {
                        if (QRCodeScannerFragment.a(this.a.a) != null) {
                            QRCodeScannerFragment.a(this.a.a).a(QRCodeScannerFragment.b(this.a.a));
                        }
                    }
                }, 1000L);
            }
        }

        public final void a(List<com.google.zxing.s> list) {
        }
    };
    private View.OnClickListener r = new View.OnClickListener(this){
        final /* synthetic */ QRCodeScannerFragment a;
        {
            this.a = qRCodeScannerFragment;
        }

        public void onClick(View view) {
            if (view.getId() != 2131296485) {
                return;
            }
            QRCodeScannerFragment.d(this.a);
        }
    };

    static /* synthetic */ ModifiedDecoratedBarcodeView a(QRCodeScannerFragment qRCodeScannerFragment) {
        return qRCodeScannerFragment.a;
    }

    static /* synthetic */ void a(QRCodeScannerFragment qRCodeScannerFragment, com.journeyapps.barcodescanner.c c2) {
        b b2 = com.google.zxing.d.a.a.a((int)-1, (Intent)d.a(c2, null));
        if (b2.a != null) {
            if (qRCodeScannerFragment.k != null) {
                try {
                    qRCodeScannerFragment.c(qRCodeScannerFragment.k.c(b2.a));
                    return;
                }
                catch (RemoteException remoteException) {
                    qRCodeScannerFragment.b = false;
                    remoteException.printStackTrace();
                    return;
                }
            }
            midrop.service.c.d.b("QRCodeScannerFragment", "mSenderManagerService is null!", new Object[0]);
            return;
        }
        midrop.service.c.d.b("QRCodeScannerFragment", "scan result is null!", new Object[0]);
    }

    static /* synthetic */ com.journeyapps.barcodescanner.a b(QRCodeScannerFragment qRCodeScannerFragment) {
        return qRCodeScannerFragment.q;
    }

    static /* synthetic */ Handler c(QRCodeScannerFragment qRCodeScannerFragment) {
        return qRCodeScannerFragment.m;
    }

    private void c(midrop.a.c.a.a.a a2) {
        if (a2 != null) {
            this.b = true;
            ((TransmissionActivity)this.getActivity()).c(a2);
            return;
        }
        this.b = false;
    }

    private void d() {
        if (this.a()) {
            return;
        }
        if (this.k != null) {
            try {
                Iterator iterator = this.k.e().iterator();
                while (iterator.hasNext()) {
                    this.b((midrop.a.c.a.a.a)iterator.next());
                }
                return;
            }
            catch (RemoteException remoteException) {
                midrop.service.c.d.a("QRCodeScannerFragment", "updateExistFileReceivers", remoteException, new Object[0]);
            }
        }
    }

    static /* synthetic */ void d(QRCodeScannerFragment qRCodeScannerFragment) {
        if (qRCodeScannerFragment.a != null) {
            qRCodeScannerFragment.a.a.c();
        }
        ((TransmissionActivity)qRCodeScannerFragment.getActivity()).onBackPressed();
    }

    static /* synthetic */ com.xiaomi.midrop.sender.adapter.a e(QRCodeScannerFragment qRCodeScannerFragment) {
        return qRCodeScannerFragment.d;
    }

    @Override
    public final void a(midrop.a.c.a.a.a a2) {
        QRCodeScannerFragment.super.c(a2);
    }

    public final void a(k k2) {
        this.k = k2;
        QRCodeScannerFragment.super.d();
        this.c();
    }

    public final void a(boolean bl) {
        if (this.i == null) {
            return;
        }
        View view = this.i.findViewById(2131296474);
        View view2 = this.i.findViewById(2131296598);
        View view3 = this.i.findViewById(2131296701);
        RadarScanView radarScanView = (RadarScanView)this.i.findViewById(2131296667);
        if (bl) {
            view2.setVisibility(0);
            view3.setVisibility(8);
            radarScanView.a();
            view.setVisibility(8);
            return;
        }
        view2.setVisibility(8);
        view3.setVisibility(0);
        radarScanView.b();
        if (this.p) {
            view.setVisibility(0);
            this.p = false;
        }
    }

    public final boolean a() {
        return !this.isAdded() || this.isDetached() || this.isHidden() || this.isRemoving();
        {
        }
    }

    public final void b() {
        String string2;
        if (this.n == null) {
            return;
        }
        int n2 = this.e.size();
        if (n2 > 0) {
            Resources resources = this.o.getResources();
            Object[] arrobject = new Object[]{n2};
            string2 = resources.getQuantityString(2131558402, n2, arrobject);
        } else {
            string2 = this.o.getResources().getString(2131689767);
        }
        this.n.setText((CharSequence)string2);
    }

    public final void b(midrop.a.c.a.a.a a2) {
        if (a2 == null) {
            return;
        }
        new StringBuilder("addFileReceiver, empty?=").append(this.e.isEmpty());
        if (!this.p) {
            this.p = a2.a.i();
        }
        this.a(false);
        if (!this.e.isEmpty() && (midrop.a.c.a.a.a)this.e.get((Object)a2.b()) != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable((QRCodeScannerFragment)this){
                final /* synthetic */ QRCodeScannerFragment a;
                {
                    this.a = qRCodeScannerFragment;
                }

                public final void run() {
                    if (QRCodeScannerFragment.e(this.a) != null) {
                        QRCodeScannerFragment.e((QRCodeScannerFragment)this.a).a.b();
                    }
                }
            });
            return;
        }
        if (this.d != null) {
            this.e.put((Object)a2.b(), (Object)a2);
            com.xiaomi.midrop.sender.adapter.a a3 = this.d;
            a.e.b.d.b((Object)a2, "fileReceiver");
            List<midrop.a.c.a.a.a> list = a3.c;
            List<midrop.a.c.a.a.a> list2 = a3.c;
            Integer n2 = list2 != null ? Integer.valueOf((int)list2.size()) : null;
            list.add(n2.intValue(), (Object)a2);
            a3.a.b();
        }
        this.b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void c() {
        if (!this.l) {
            return;
        }
        List<midrop.a.c.a.a.a> list = null;
        try {
            k k2 = this.k;
            list = null;
            if (k2 != null) {
                List<midrop.a.c.a.a.a> list2;
                list = list2 = this.k.e();
            }
        }
        catch (RemoteException remoteException) {
            midrop.service.c.d.a("QRCodeScannerFragment", "getFileReceiverList", remoteException, new Object[0]);
        }
        if (list != null) {
            if (list.isEmpty()) {
                return;
            }
            Iterator iterator = list.iterator();
            boolean bl = false;
            boolean bl2 = false;
            while (iterator.hasNext()) {
                midrop.a.c.a.a.a a2 = (midrop.a.c.a.a.a)iterator.next();
                if (a2.a.f() == c.a.d) {
                    bl2 = true;
                    continue;
                }
                if (a2.a.f() != c.a.b) continue;
                bl = true;
            }
            String string2 = "";
            if (bl) {
                string2 = "AP";
            }
            if (bl2) {
                string2 = "BT";
            }
            if (bl || bl2) {
                af.a(af.a.ch).a(af.b.ag, string2).a(af.b.aj, list.size()).a();
                af.a a3 = y.u() ? af.a.cG : af.a.cI;
                af.a(a3).a();
            }
            this.l = false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = new LinkedHashMap();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.i = layoutInflater.inflate(2131427365, viewGroup, false);
        this.o = this.getActivity();
        ((a)this.getActivity()).a(false);
        ((FrameLayout.LayoutParams)((LinearLayout)this.i.findViewById(2131296284)).getLayoutParams()).setMargins(0, ag.a(this.o), 0, 0);
        this.a = (ModifiedDecoratedBarcodeView)this.i.findViewById(2131296938);
        this.a.a(this.q);
        this.j = (BarcodeView)this.i.findViewById(2131296939);
        RecyclerView recyclerView = (RecyclerView)this.i.findViewById(2131296701);
        ((ProfileImageView)this.i.findViewById(2131296420)).a();
        if (this.d == null) {
            this.d = new com.xiaomi.midrop.sender.adapter.a(this.getContext());
            this.d.a(this);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), 0, false);
        linearLayoutManager.a(false);
        if (recyclerView != null) {
            recyclerView.setLayoutManager((RecyclerView.i)linearLayoutManager);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter((RecyclerView.a)this.d);
        }
        this.n = (TextView)this.i.findViewById(2131296421);
        if (am.d()) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.a.getLayoutParams();
            layoutParams.width = c.a(this.o, 300.0f);
            layoutParams.height = c.a(this.o, 400.0f);
            this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        }
        View view = this.i.findViewById(2131296485);
        if (ac.c((Context)this.getActivity())) {
            view.setRotation(180.0f);
        }
        view.setOnClickListener(this.r);
        this.a(true);
        return this.i;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.d != null) {
            this.d.a(this);
        }
        if (this.a != null) {
            this.a = null;
        }
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
        if (this.h != null) {
            this.h = null;
        }
        this.d = null;
    }

    public void onPause() {
        super.onPause();
        if (this.a != null) {
            this.a.a.c();
        }
        ((QrCodeViewfinderView)this.a.getViewFinder()).c();
    }

    public void onResume() {
        super.onResume();
        this.d();
        if (this.a != null) {
            this.a.a.d();
        }
        ((QrCodeViewfinderView)this.a.getViewFinder()).b();
        this.b();
    }

    public void onStart() {
        super.onStart();
        a a2 = (a)this.getActivity();
        a2.a(new String[]{"android.permission.CAMERA"}, 711, new a.a(this, a2){
            final /* synthetic */ a a;
            final /* synthetic */ QRCodeScannerFragment b;
            {
                this.b = qRCodeScannerFragment;
                this.a = a2;
            }

            public final void a() {
                if (android.os.Build$VERSION.SDK_INT >= 23) {
                    af.a(af.a.dA).a();
                    if (this.a.shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
                        this.a.c(new View.OnClickListener(this){
                            final /* synthetic */ 3 a;
                            {
                                this.a = var1;
                            }

                            public void onClick(View view) {
                                af.a(af.a.dB).a();
                                this.a.b.onStart();
                            }
                        });
                        return;
                    }
                    this.a.u();
                }
            }

            public final void a(int n2) {
                af.a(af.a.dw).a();
                if (QRCodeScannerFragment.a(this.b) != null) {
                    QRCodeScannerFragment.a((QRCodeScannerFragment)this.b).a.d();
                }
            }
        });
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.b = false;
        this.f = System.currentTimeMillis();
        this.e.clear();
        af.a(af.a.cg).a();
    }
}

