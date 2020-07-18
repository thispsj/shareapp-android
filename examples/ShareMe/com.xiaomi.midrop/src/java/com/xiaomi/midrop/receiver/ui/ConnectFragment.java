/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.SystemClock
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.g
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.xiaomi.midrop.receiver.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.xiaomi.midrop.receiver.ui.ConnectFragment;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.view.ConnectIndicateView;
import com.xiaomi.midrop.view.rocket.RocketFlyCircleView;

public class ConnectFragment
extends Fragment {
    private ConnectIndicateView a;
    private ImageView b;
    private BroadcastReceiver c = new BroadcastReceiver(this){
        final /* synthetic */ ConnectFragment a;
        {
            this.a = connectFragment;
        }

        public final void onReceive(Context context, Intent intent) {
            if ("com.xiaomi.midrop.action.WIFI_AP_CONNECTED".equals((java.lang.Object)intent.getAction())) {
                ConnectFragment.a(this.a, ConnectIndicateView.b.c);
                return;
            }
            if ("com.xiaomi.midrop.action.XMPP_SERVER_CONNECTED".equals((java.lang.Object)intent.getAction())) {
                ConnectFragment.a(this.a, ConnectIndicateView.b.d);
            }
        }
    };
    private View.OnClickListener d = new View.OnClickListener(this){
        final /* synthetic */ ConnectFragment a;
        {
            this.a = connectFragment;
        }

        public void onClick(View view) {
            if (view.getId() != 2131296487) {
                return;
            }
            this.a.getActivity().onBackPressed();
        }
    };

    static /* synthetic */ void a(ConnectFragment connectFragment, ConnectIndicateView.b b2) {
        connectFragment.a.setConnectStep(b2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xiaomi.midrop.action.WIFI_AP_CONNECTED");
        intentFilter.addAction("com.xiaomi.midrop.action.XMPP_SERVER_CONNECTED");
        this.getActivity().registerReceiver(this.c, intentFilter);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2131427432, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
        this.getActivity().unregisterReceiver(this.c);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.a.setConnectStep(ConnectIndicateView.b.d);
        ConnectIndicateView connectIndicateView = this.a;
        RocketFlyCircleView rocketFlyCircleView = connectIndicateView.a;
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter(connectIndicateView){
            final /* synthetic */ com.xiaomi.midrop.view.ConnectIndicateView$a a;
            final /* synthetic */ ConnectIndicateView b;
            {
                this.b = connectIndicateView;
                this.a = null;
            }

            public final void onAnimationEnd(Animator animator2) {
            }
        };
        if (rocketFlyCircleView.n) {
            rocketFlyCircleView.n = false;
            rocketFlyCircleView.h = false;
            rocketFlyCircleView.F = false;
            rocketFlyCircleView.H.removeCallbacks(rocketFlyCircleView.I);
            Animator animator2 = rocketFlyCircleView.getRocketFlyAwayAnimation();
            animator2.addListener((Animator.AnimatorListener)animatorListenerAdapter);
            animator2.start();
        }
        connectIndicateView.a();
        ((a)this.getActivity()).s();
    }

    public void onResume() {
        super.onResume();
    }

    public void onViewCreated(View view, Bundle bundle) {
        this.a = (ConnectIndicateView)view.findViewById(2131296389);
        this.b = (ImageView)view.findViewById(2131296487);
        this.b.setOnClickListener(this.d);
        if (ac.c((Context)this.getActivity())) {
            this.b.setRotation(180.0f);
        }
        ((a)this.getActivity()).a(false);
        ((FrameLayout.LayoutParams)((RelativeLayout)view.findViewById(2131296284)).getLayoutParams()).setMargins(0, ag.a((Context)this.getActivity()), 0, 0);
        this.a.setVisibility(0);
        ConnectIndicateView connectIndicateView = this.a;
        connectIndicateView.a.setAnimationDuration(Integer.MAX_VALUE);
        RocketFlyCircleView rocketFlyCircleView = connectIndicateView.a;
        if (!rocketFlyCircleView.n) {
            rocketFlyCircleView.i = 20.0f;
            rocketFlyCircleView.k = 0;
            rocketFlyCircleView.m = rocketFlyCircleView.l = SystemClock.elapsedRealtime();
            rocketFlyCircleView.n = true;
            rocketFlyCircleView.v = 0;
            rocketFlyCircleView.x = 0;
            rocketFlyCircleView.y = 0.0f;
            rocketFlyCircleView.z = 0.0f;
            rocketFlyCircleView.A = 1.0f;
            rocketFlyCircleView.H.post(rocketFlyCircleView.I);
            rocketFlyCircleView.q = rocketFlyCircleView.s;
            rocketFlyCircleView.r = rocketFlyCircleView.t;
        }
        this.a.setConnectStep(ConnectIndicateView.b.b);
    }
}

