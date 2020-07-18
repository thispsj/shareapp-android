/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  java.lang.CharSequence
 */
package com.xiaomi.midrop.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.midrop.util.j;

public class TransferSpeedView
extends RelativeLayout {
    public ProgressBar a;
    public TextView b;
    public TextView c;
    public long d;
    public long e;
    public int f;
    public int g;
    private TextView h;
    private ImageView i;
    private ImageView j;
    private RelativeLayout k;
    private long l;
    private int m;

    public TransferSpeedView(Context context) {
        super(context);
        TransferSpeedView.super.a();
    }

    public TransferSpeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TransferSpeedView.super.a();
    }

    public TransferSpeedView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        TransferSpeedView.super.a();
    }

    private void a() {
        LayoutInflater.from((Context)this.getContext()).inflate(2131427577, (ViewGroup)this, true);
        this.a = (ProgressBar)this.findViewById(2131296654);
        this.b = (TextView)this.findViewById(2131296890);
        this.h = (TextView)this.findViewById(2131296891);
        this.i = (ImageView)this.findViewById(2131296521);
        this.j = (ImageView)this.findViewById(2131296520);
        this.k = (RelativeLayout)this.findViewById(2131296579);
        this.c = (TextView)this.findViewById(2131296455);
        this.k.setPaddingRelative(this.getResources().getDimensionPixelOffset(2131165761), 0, this.getResources().getDimensionPixelOffset(2131165759), 0);
    }

    public int getStatus() {
        return this.m;
    }

    public void setSentSize(long l2) {
        this.e = l2;
    }

    public void setSpeed(long l2) {
        this.l = l2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void setState(int var1) {
        switch (var1) {
            default: {
                ** break;
            }
            case 3: {
                var2_2 = this.a;
                var3_3 = this.getResources();
                var4_4 = 2131231331;
                break;
            }
            case 2: {
                if (this.m == 1) {
                    this.k.setPaddingRelative(this.getResources().getDimensionPixelOffset(2131165762), 0, this.getResources().getDimensionPixelOffset(2131165760), 0);
                }
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                this.b.setText((CharSequence)j.b(this.e));
                this.a.setProgress(0);
                ** break;
            }
            case 1: {
                if (this.m == 2) {
                    this.k.setPaddingRelative(this.getResources().getDimensionPixelOffset(2131165761), 0, this.getResources().getDimensionPixelOffset(2131165759), 0);
                }
                this.i.setVisibility(8);
                this.j.setVisibility(8);
                var2_2 = this.a;
                var3_3 = this.getResources();
                var4_4 = 2131231329;
            }
        }
        var2_2.setProgressDrawable(var3_3.getDrawable(var4_4));
        ** break;
lbl27: // 3 sources:
        this.m = var1;
    }

    public void setTotalSize(long l2) {
        this.d = l2;
    }
}

