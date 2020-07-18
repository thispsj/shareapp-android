/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.g
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package com.xiaomi.midrop.connect;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.midrop.connect.ConnectionFragment;
import com.xiaomi.midrop.sender.ui.b;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.view.ConnectionCircleView;
import com.xiaomi.midrop.view.ProfileImageView;
import java.util.Locale;

public class ConnectionFragment
extends Fragment {
    public int a = 0;
    public int b;
    private ProfileImageView c;
    private ConnectionCircleView d;
    private String e;
    private String f;
    private TextView g;
    private View h;
    private boolean i;
    private boolean j;
    private View.OnClickListener k = new View.OnClickListener(this){
        final /* synthetic */ ConnectionFragment a;
        {
            this.a = connectionFragment;
        }

        public void onClick(View view) {
            int n2 = view.getId();
            if (n2 != 2131296485 && n2 != 2131296810) {
                return;
            }
            this.a.getActivity().onBackPressed();
        }
    };

    public static ConnectionFragment a(String string2, String string3, boolean bl) {
        ConnectionFragment connectionFragment = new ConnectionFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", string2);
        bundle.putString("deviceId", string3);
        bundle.putBoolean("by_qrcode", bl);
        connectionFragment.setArguments(bundle);
        return connectionFragment;
    }

    public final void a() {
        if (this.i) {
            boolean bl = !this.isAdded() || this.isDetached() || this.isHidden() || this.isRemoving();
            if (bl) {
                return;
            }
            switch (this.a) {
                default: {
                    return;
                }
                case 6: {
                    this.d.a();
                    this.d.a(0, 324, 20000L);
                    TextView textView = this.g;
                    Locale locale = Locale.getDefault();
                    String string2 = com.xiaomi.midrop.util.Locale.b.a().b(2131689615);
                    Object[] arrobject = new Object[]{this.e};
                    textView.setText((CharSequence)String.format((Locale)locale, (String)string2, (Object[])arrobject));
                    return;
                }
                case 5: {
                    this.d.a();
                    int n2 = this.d.getSweepAngle();
                    if (n2 <= 0 || n2 >= 360) break;
                    this.d.a(this.d.getSweepAngle(), 360, 200L);
                    return;
                }
                case 2: {
                    this.d.a();
                    if (this.d.getSweepAngle() > 0) {
                        this.d.a(this.d.getSweepAngle(), 360, 2000L);
                    }
                    if (this.j || this.b > 2) break;
                    TextView textView = this.g;
                    Locale locale = Locale.getDefault();
                    String string3 = com.xiaomi.midrop.util.Locale.b.a().b(2131689615);
                    Object[] arrobject = new Object[]{this.e};
                    textView.setText((CharSequence)String.format((Locale)locale, (String)string3, (Object[])arrobject));
                    return;
                }
                case 1: 
                case 3: 
                case 4: {
                    this.d.setSweepAngle(0);
                    if (this.a == 3) {
                        this.d.a(0, 324, 20000L);
                    } else {
                        this.d.a(0, 324, 12000L);
                    }
                    TextView textView = this.g;
                    Locale locale = Locale.getDefault();
                    String string4 = com.xiaomi.midrop.util.Locale.b.a().b(2131689608);
                    Object[] arrobject = new Object[]{this.e};
                    textView.setText((CharSequence)String.format((Locale)locale, (String)string4, (Object[])arrobject));
                }
            }
        }
    }

    public final void a(String string2) {
        if (this.h != null) {
            if (!midrop.b.a.a.a(string2)) {
                return;
            }
            this.h.setVisibility(0);
            ((TextView)this.h.findViewById(2131296383)).setText((CharSequence)string2);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.e = bundle.getString("name");
            this.f = bundle.getString("deviceId");
            this.j = bundle.getBoolean("by_qrcode");
            return;
        }
        if (this.getArguments() != null) {
            Bundle bundle2 = this.getArguments();
            this.e = bundle2.getString("name");
            this.f = bundle2.getString("deviceId");
            this.j = bundle2.getBoolean("by_qrcode");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ((a)this.getActivity()).a(true);
        return layoutInflater.inflate(2131427433, viewGroup, false);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.d.a();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.e);
        bundle.putString("deviceId", this.f);
        bundle.putBoolean("by_qrcode", this.j);
    }

    public void onViewCreated(View view, Bundle bundle) {
        View view2 = view.findViewById(2131296485);
        view2.setOnClickListener(this.k);
        if (ac.c((Context)this.getActivity())) {
            view2.setRotation(180.0f);
        }
        view.findViewById(2131296810).setVisibility(8);
        this.h = view.findViewById(2131296384);
        ((RelativeLayout.LayoutParams)((ViewGroup)view.findViewById(2131296284)).getLayoutParams()).setMargins(0, ag.a((Context)this.getActivity()), 0, 0);
        this.c = (ProfileImageView)view.findViewById(2131296418);
        this.d = (ConnectionCircleView)view.findViewById(2131296364);
        this.g = (TextView)view.findViewById(2131296388);
        this.i = true;
        this.c.a(this.f, this.e);
        this.d.setCircleColor(com.xiaomi.midrop.a.a.a(this.f, this.e));
        this.a();
        if (this.getActivity() instanceof b) {
            this.a(((b)this.getActivity()).h());
        }
    }
}

