/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.RectF
 *  android.os.Bundle
 *  android.support.v4.app.g
 *  android.support.v7.app.c
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewStub
 *  android.view.animation.LinearInterpolator
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.google.zxing.a
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.receiver.ui;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v7.app.c;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.journeyapps.barcodescanner.b;
import com.xiaomi.midrop.qrcode.a;
import com.xiaomi.midrop.receiver.ui.ReceiveActivity;
import com.xiaomi.midrop.receiver.ui.WaitQrCodeFragment;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.util.e;
import com.xiaomi.midrop.view.BaseFragment;
import com.xiaomi.midrop.view.ConnectionCircleView;
import com.xiaomi.midrop.view.ProfileImageView;
import midrop.service.c.d;

public class WaitQrCodeFragment
extends BaseFragment {
    View a;
    View b;
    TextView c;
    View.OnClickListener d = new View.OnClickListener(this){
        final /* synthetic */ WaitQrCodeFragment a;
        {
            this.a = waitQrCodeFragment;
        }

        public void onClick(View view) {
            int n2 = view.getId();
            if (n2 != 2131296485) {
                if (n2 != 2131296519) {
                    if (n2 != 2131296810) {
                        return;
                    }
                } else {
                    WaitQrCodeFragment.a(this.a);
                    return;
                }
            }
            this.a.getActivity().onBackPressed();
        }
    };
    private View e;
    private ProfileImageView f;
    private ConnectionCircleView g;
    private ImageView h;
    private ImageView i;
    private TextView j;
    private com.xiaomi.midrop.qrcode.a k = new com.xiaomi.midrop.qrcode.a();
    private c l;
    private int m = 0;
    private TextView n;
    private boolean o = false;
    private Bitmap p;
    private BroadcastReceiver q = new BroadcastReceiver(this){
        final /* synthetic */ WaitQrCodeFragment a;
        {
            this.a = waitQrCodeFragment;
        }

        public final void onReceive(Context context, Intent intent) {
            if ("com.xiaomi.midrop.action.CONNECT_DIALOG_SHOWN".equals((Object)intent.getAction())) {
                WaitQrCodeFragment.b(this.a);
            }
        }
    };

    public static WaitQrCodeFragment a() {
        return new WaitQrCodeFragment();
    }

    private void a(int n2) {
        if (this.h != null) {
            this.h.setVisibility(n2);
        }
        if (this.i != null) {
            this.i.setVisibility(n2);
        }
        if (this.n != null) {
            this.n.setVisibility(n2);
        }
    }

    static /* synthetic */ void a(WaitQrCodeFragment waitQrCodeFragment) {
        ReceiveActivity receiveActivity = (ReceiveActivity)waitQrCodeFragment.getActivity();
        if (receiveActivity != null) {
            receiveActivity.g();
            waitQrCodeFragment.b.setVisibility(8);
            waitQrCodeFragment.c();
        }
    }

    private void b(int n2) {
        if (this.m == n2) {
            return;
        }
        this.m = n2;
        switch (this.m) {
            default: {
                return;
            }
            case 2: {
                WaitQrCodeFragment.super.a(0);
                return;
            }
            case 1: 
        }
        ConnectionCircleView connectionCircleView = this.g;
        connectionCircleView.a();
        connectionCircleView.d = 4;
        connectionCircleView.g = (int)(connectionCircleView.a.width() / 2.0f);
        int n3 = connectionCircleView.e - connectionCircleView.f;
        connectionCircleView.h = connectionCircleView.g - n3 * 4 / 10;
        connectionCircleView.i = connectionCircleView.g - n3 * 8 / 10;
        connectionCircleView.c = new ValueAnimator();
        connectionCircleView.c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(connectionCircleView){
            final /* synthetic */ ConnectionCircleView a;
            {
                this.a = connectionCircleView;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f2 = ((java.lang.Float)valueAnimator.getAnimatedValue()).floatValue();
                ConnectionCircleView.a(this.a, f2);
            }
        });
        connectionCircleView.c.setFloatValues(new float[]{0.0f, 1.0f});
        connectionCircleView.c.setDuration(2000L);
        connectionCircleView.c.setInterpolator((TimeInterpolator)new LinearInterpolator());
        connectionCircleView.c.setRepeatCount(-1);
        connectionCircleView.c.setRepeatMode(2);
        connectionCircleView.c.start();
        WaitQrCodeFragment.super.a(4);
    }

    static /* synthetic */ void b(WaitQrCodeFragment waitQrCodeFragment) {
        waitQrCodeFragment.d();
    }

    private void c() {
        this.b();
        if (this.e == null) {
            this.e = ((ViewStub)this.a.findViewById(2131296920)).inflate();
            this.j = (TextView)this.e.findViewById(2131296423);
            this.getActivity();
            String string2 = e.a();
            this.j.setText((CharSequence)string2);
            this.f = (ProfileImageView)this.e.findViewById(2131296418);
            this.f.a();
            this.h = (ImageView)this.e.findViewById(2131296665);
            this.i = (ImageView)this.e.findViewById(2131296666);
            this.g = (ConnectionCircleView)this.e.findViewById(2131296386);
            this.g.setCircleColor(this.getResources().getColor(2131100066));
            this.n = (TextView)this.e.findViewById(2131296335);
        }
        this.e.setVisibility(0);
        this.c.setVisibility(0);
    }

    private void d() {
        if (this.l != null) {
            this.l.dismiss();
            this.l = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(com.xiaomi.midrop.qrcode.a a2) {
        if (a2 != null) {
            if (!a2.b()) {
                return;
            }
            if (!TextUtils.isEmpty((CharSequence)a2.a)) {
                this.k.a = a2.a;
            }
            if (!TextUtils.isEmpty((CharSequence)a2.b)) {
                this.k.b = a2.b;
            }
            if (a2.d != null && a2.d.a()) {
                a.a a3 = this.k.d;
                a.a a4 = a2.d;
                a3.a = a4.a;
                a3.b = a4.b;
                a3.c = a4.c;
                a3.d = a4.d;
            }
            if (a2.e != null && a2.e.a()) {
                a.b b2 = this.k.e;
                a.b b3 = a2.e;
                b2.a = b3.a;
                b2.b = b3.b;
                b2.c = b3.c;
            }
            this.k.c = a2.c;
            this.k.f = a2.f;
            if (this.c != null) {
                this.c.setText(2131689855);
            }
            if (this.h != null && this.k.b()) {
                try {
                    int n2 = this.getResources().getDimensionPixelSize(2131165632);
                    new b();
                    Bitmap bitmap = b.a(this.k.c(), com.google.zxing.a.l, n2, n2);
                    if (bitmap != null && !bitmap.sameAs(this.p)) {
                        if (this.p != null) {
                            this.p.recycle();
                        }
                        this.p = bitmap;
                    }
                    if (this.h != null) {
                        this.h.setImageBitmap(this.p);
                        if (!this.o) {
                            af.a(af.a.dS).a(af.b.ay, "Receiver_qr_code_show").a();
                            this.o = true;
                        }
                    }
                }
                catch (Exception exception) {
                    d.a("WaitQrCodeFragment", "encodeBitmap", exception, new Object[0]);
                }
            }
            WaitQrCodeFragment.super.b(2);
        }
    }

    final void b() {
        if (this.e != null) {
            this.e.setVisibility(8);
        }
        if (this.b != null) {
            this.b.setVisibility(8);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xiaomi.midrop.action.CONNECT_DIALOG_SHOWN");
        this.getActivity().registerReceiver(this.q, intentFilter);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(2131427446, viewGroup, false);
        return this.a;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.p != null) {
            this.p.recycle();
        }
        this.p = null;
        this.h = null;
        this.getActivity().unregisterReceiver(this.q);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.g.a();
        this.d();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        View view2 = view.findViewById(2131296485);
        if (ac.c((Context)this.getActivity())) {
            view2.setRotation(180.0f);
        }
        view2.setOnClickListener(this.d);
        view.findViewById(2131296431).setVisibility(8);
        view.setBackgroundColor(this.getResources().getColor(2131099936));
        view.setPadding(0, ag.a((Context)this.getActivity()), 0, 0);
        this.c = (TextView)view.findViewById(2131296921);
        this.c.setText(2131689844);
        WaitQrCodeFragment.super.c();
        WaitQrCodeFragment.super.b(1);
        ((a)this.getActivity()).s();
    }
}

