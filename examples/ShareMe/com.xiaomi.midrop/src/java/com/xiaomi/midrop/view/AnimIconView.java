/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.midrop.view.CircleProgressView;
import com.xiaomi.midrop.view.ProfileImageView;
import com.xiaomi.midrop.view.WaveView;

public class AnimIconView
extends FrameLayout {
    public int a;
    public TextView b;
    public WaveView c;
    public WaveView d;
    public CircleProgressView e;
    private int f;
    private FrameLayout g;
    private ProfileImageView h;

    public AnimIconView(Context context) {
        super(context, null);
    }

    public AnimIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public AnimIconView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a = 0;
        this.f = 0;
        ((LayoutInflater)context.getApplicationContext().getSystemService("layout_inflater")).inflate(2131427390, (ViewGroup)this, true);
        this.h = (ProfileImageView)this.findViewById(2131296515);
        this.g = (FrameLayout)this.findViewById(2131296600);
        this.b = (TextView)this.findViewById(2131296883);
        this.e = (CircleProgressView)this.findViewById(2131296401);
        this.c = (WaveView)this.findViewById(2131296936);
        this.d = (WaveView)this.findViewById(2131296935);
        this.e.setProgress(0);
        this.d.setWaveColor(this.getResources().getColor(2131100066));
        this.c.setWaveColor(this.getResources().getColor(2131100030));
        this.h.a();
    }

    public void setMainIcon(int n2) {
        this.h.setImageResource(n2);
    }

    public void setMainIconSize(int n2) {
        ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
        layoutParams.width = n2;
        layoutParams.height = n2;
        this.h.setLayoutParams(layoutParams);
        this.h.invalidate();
    }

    public void setReverse(boolean bl) {
        this.d.setReverse(bl);
        this.c.setReverse(bl);
    }
}

