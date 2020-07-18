/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.ProgressBar
 *  android.widget.TextView
 *  java.lang.Object
 */
package com.xiaomi.midrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadingView
extends FrameLayout {
    private TextView a;
    private Button b;
    private ProgressBar c;
    private a d;

    public LoadingView(Context context) {
        super(context, null);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        LayoutInflater.from((Context)context).inflate(2131427499, (ViewGroup)this, true);
        this.a = (TextView)this.findViewById(2131296475);
        this.b = (Button)this.findViewById(2131296677);
        this.b.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
            }
        });
        this.c = (ProgressBar)this.findViewById(2131296654);
        this.setVisibility(8);
    }

    public final void a() {
        this.setVisibility(0);
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(0);
    }

    public final void b() {
        this.setVisibility(8);
    }

    public void setOnRefreshListener(a a2) {
        this.d = a2;
    }

    public static interface a {
    }

}

