/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package com.xiaomi.midrop.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.midrop.view.rocket.RocketFlyCircleView;
import java.util.Locale;

public class ConnectIndicateView
extends FrameLayout {
    public RocketFlyCircleView a;
    private TextView b;
    private String c;
    private ValueAnimator d;

    public ConnectIndicateView(Context context) {
        super(context);
        ConnectIndicateView.super.b();
    }

    public ConnectIndicateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ConnectIndicateView.super.b();
    }

    private void a(int n2, int n3, int n4) {
        this.a();
        this.d = ValueAnimator.ofInt((int[])new int[]{n2, n3});
        this.d.setDuration((long)n4);
        this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TextView textView = ConnectIndicateView.this.b;
                Locale locale = Locale.getDefault();
                String string2 = ConnectIndicateView.this.c;
                Object[] arrobject = new Object[]{valueAnimator.getAnimatedValue().toString()};
                textView.setText((CharSequence)String.format((Locale)locale, (String)string2, (Object[])arrobject));
            }
        });
        this.d.start();
    }

    private void b() {
        LayoutInflater.from((Context)this.getContext()).inflate(2131427405, (ViewGroup)this, true);
        this.a = (RocketFlyCircleView)this.findViewById(2131296688);
        this.a.setShowClouds(true);
        this.b = (TextView)this.findViewById(2131296658);
        this.c = this.getContext().getString(2131689606);
    }

    public final void a() {
        if (this.d != null && this.d.isRunning()) {
            this.d.end();
            this.d = null;
        }
    }

    public void setConnectStep(b b2) {
        switch (3.a[b2.ordinal()]) {
            default: {
                return;
            }
            case 4: {
                this.b.setText((CharSequence)String.format((Locale)Locale.getDefault(), (String)this.c, (Object[])new Object[]{"100"}));
                return;
            }
            case 3: {
                ConnectIndicateView.super.a(90, 99, 3000);
                this.a.a();
                return;
            }
            case 2: {
                ConnectIndicateView.super.a(0, 90, 10000);
                return;
            }
            case 1: 
        }
        this.b.setText((CharSequence)String.format((Locale)Locale.getDefault(), (String)this.c, (Object[])new Object[]{"0"}));
    }

    public static interface a {
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b a = new b();
        public static final /* enum */ b b = new b();
        public static final /* enum */ b c = new b();
        public static final /* enum */ b d = new b();
        private static final /* synthetic */ b[] e;

        static {
            b[] arrb = new b[]{a, b, c, d};
            e = arrb;
        }

        public static b valueOf(String string2) {
            return (b)Enum.valueOf(b.class, (String)string2);
        }

        public static b[] values() {
            return (b[])e.clone();
        }
    }

}

