/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  java.lang.String
 */
package com.xiaomi.midrop.qrcode;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.journeyapps.barcodescanner.BarcodeView;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.ViewfinderView;
import com.xiaomi.midrop.qrcode.QrCodeScannerActivity;
import com.xiaomi.midrop.qrcode.QrCodeViewfinderView;
import com.xiaomi.midrop.sender.c.c;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.util.am;

public class QrCodeScannerActivity
extends a
implements DecoratedBarcodeView.a {
    private DecoratedBarcodeView a;
    private BarcodeView b;
    private Handler c = new Handler();
    private com.journeyapps.barcodescanner.a d = new com.journeyapps.barcodescanner.a(this){
        final /* synthetic */ QrCodeScannerActivity a;
        {
            this.a = qrCodeScannerActivity;
        }

        public final void a(com.journeyapps.barcodescanner.c c2) {
            if (c2.b() != null) {
                if (com.xiaomi.midrop.qrcode.a.a(c2.b()) != null) {
                    QrCodeScannerActivity qrCodeScannerActivity = this.a;
                    qrCodeScannerActivity.setResult(-1, com.journeyapps.barcodescanner.d.a(c2, null));
                    qrCodeScannerActivity.a();
                    return;
                }
                QrCodeScannerActivity.c(this.a).postDelayed(new java.lang.Runnable(this){
                    final /* synthetic */ 1 a;
                    {
                        this.a = var1;
                    }

                    public final void run() {
                        QrCodeScannerActivity.b(this.a.a).a(QrCodeScannerActivity.a(this.a.a));
                    }
                }, 1000L);
            }
        }

        public final void a(java.util.List<com.google.zxing.s> list) {
        }
    };
    private View.OnClickListener e = new View.OnClickListener(this){
        final /* synthetic */ QrCodeScannerActivity a;
        {
            this.a = qrCodeScannerActivity;
        }

        public void onClick(View view) {
            int n2 = view.getId();
            if (n2 != 2131296485 && n2 != 2131296810) {
                return;
            }
            QrCodeScannerActivity.d(this.a);
        }
    };

    static /* synthetic */ com.journeyapps.barcodescanner.a a(QrCodeScannerActivity qrCodeScannerActivity) {
        return qrCodeScannerActivity.d;
    }

    static /* synthetic */ DecoratedBarcodeView b(QrCodeScannerActivity qrCodeScannerActivity) {
        return qrCodeScannerActivity.a;
    }

    static /* synthetic */ Handler c(QrCodeScannerActivity qrCodeScannerActivity) {
        return qrCodeScannerActivity.c;
    }

    static /* synthetic */ void d(QrCodeScannerActivity qrCodeScannerActivity) {
        qrCodeScannerActivity.a();
    }

    final void a() {
        this.a.a.c();
        this.finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.a.a.c();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a(2131427365, false);
        ((FrameLayout.LayoutParams)((LinearLayout)this.findViewById(2131296284)).getLayoutParams()).setMargins(0, ag.a((Context)this), 0, 0);
        this.a = (DecoratedBarcodeView)this.findViewById(2131296938);
        this.a.setTorchListener((DecoratedBarcodeView.a)this);
        this.a.a(this.d);
        this.b = (BarcodeView)this.findViewById(2131296939);
        if (am.d()) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.a.getLayoutParams();
            layoutParams.width = c.a((Context)this, 300.0f);
            layoutParams.height = c.a((Context)this, 400.0f);
            this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        }
        this.findViewById(2131296810).setOnClickListener(this.e);
        View view = this.findViewById(2131296485);
        if (ac.c((Context)this)) {
            view.setRotation(180.0f);
        }
        view.setOnClickListener(this.e);
    }

    @Override
    protected void onDestroy() {
        if (this.a != null) {
            this.a.setTorchListener(null);
        }
        if (this.b != null) {
            this.b.a();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int n2, KeyEvent keyEvent) {
        return this.a.onKeyDown(n2, keyEvent) || super.onKeyDown(n2, keyEvent);
        {
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.a.a.c();
        ((QrCodeViewfinderView)this.a.getViewFinder()).c();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.a.a.d();
        ((QrCodeViewfinderView)this.a.getViewFinder()).b();
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.a(new String[]{"android.permission.CAMERA"}, 711, new a.a(this){
            final /* synthetic */ QrCodeScannerActivity a;
            {
                this.a = qrCodeScannerActivity;
            }

            public final void a() {
                if (android.os.Build$VERSION.SDK_INT >= 23) {
                    com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.dA).a();
                    if (this.a.shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
                        this.a.c(new View.OnClickListener(this){
                            final /* synthetic */ 3 a;
                            {
                                this.a = var1;
                            }

                            public void onClick(View view) {
                                com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.dB).a();
                                this.a.a.onStart();
                            }
                        });
                        return;
                    }
                    this.a.u();
                }
            }

            public final void a(int n2) {
                com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.dw).a();
                QrCodeScannerActivity.b((QrCodeScannerActivity)this.a).a.d();
            }
        });
    }
}

