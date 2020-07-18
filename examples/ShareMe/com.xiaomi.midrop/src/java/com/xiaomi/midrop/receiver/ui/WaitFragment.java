/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.support.v4.app.g
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.String
 */
package com.xiaomi.midrop.receiver.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.midrop.receiver.ui.WaitFragment;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.util.e;
import com.xiaomi.midrop.view.AnimIconView;
import com.xiaomi.midrop.view.BaseFragment;
import com.xiaomi.midrop.view.CircleProgressView;
import com.xiaomi.midrop.view.WaveView;

public class WaitFragment
extends BaseFragment {
    private AnimIconView a;
    private TextView b;
    private View c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = layoutInflater.inflate(2131427445, viewGroup, false);
        return this.c;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDestroyView() {
        AnimIconView animIconView;
        int n2;
        block11 : {
            super.onDestroyView();
            animIconView = this.a;
            animIconView.a = 0;
            switch (animIconView.a) {
                default: {
                    break block11;
                }
                case 3: {
                    animIconView.d.setVisibility(8);
                    animIconView.c.setVisibility(8);
                    animIconView.e.setVisibility(0);
                    break block11;
                }
                case 2: {
                    animIconView.d.setVisibility(8);
                    animIconView.c.setVisibility(0);
                    break;
                }
                case 1: {
                    animIconView.d.setVisibility(0);
                    animIconView.c.setVisibility(8);
                    break;
                }
                case 0: {
                    animIconView.d.setVisibility(8);
                    animIconView.d.a();
                    animIconView.c.setVisibility(8);
                    animIconView.c.a();
                }
            }
            animIconView.e.setVisibility(8);
        }
        switch (animIconView.a) {
            default: {
                n2 = 0;
                break;
            }
            case 1: 
            case 2: {
                n2 = animIconView.getResources().getDimensionPixelSize(2131165725);
                break;
            }
            case 0: 
            case 3: {
                n2 = animIconView.getResources().getDimensionPixelSize(2131165724);
            }
        }
        float f2 = animIconView.getHeight() - n2 - animIconView.b.getHeight();
        if ((double)Math.abs((float)(f2 - animIconView.b.getY())) >= 1.0E-5) {
            animIconView.b.setY(f2);
            animIconView.requestLayout();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.a = (AnimIconView)view.findViewById(2131296313);
        this.b = (TextView)view.findViewById(2131296423);
        View view2 = view.findViewById(2131296485);
        if (ac.c((Context)this.getActivity())) {
            view2.setRotation(180.0f);
        }
        View.OnClickListener onClickListener = new View.OnClickListener((WaitFragment)this){
            final /* synthetic */ WaitFragment a;
            {
                this.a = waitFragment;
            }

            public void onClick(View view) {
                this.a.getActivity().onBackPressed();
            }
        };
        view2.setOnClickListener(onClickListener);
        TextView textView = (TextView)view.findViewById(2131296810);
        textView.setText(2131690029);
        textView.setOnClickListener(onClickListener);
        view.findViewById(2131296431).setVisibility(8);
        view.setBackgroundColor(this.getResources().getColor(2131099936));
        view.setPadding(0, ag.a((Context)this.getActivity()), 0, 0);
        this.a.setMainIconSize(this.getResources().getDimensionPixelOffset(2131165519));
        this.getActivity();
        String string2 = e.a();
        this.b.setText((CharSequence)string2);
        ((a)this.getActivity()).s();
    }
}

