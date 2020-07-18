/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.support.v4.app.DialogFragment
 *  android.support.v4.app.g
 *  android.support.v7.widget.GridLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$i
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.midrop.transmission.upgrade;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.sender.c.b;
import com.xiaomi.midrop.transmission.c;
import com.xiaomi.midrop.transmission.upgrade.UpgradeListDialog;
import com.xiaomi.midrop.transmission.upgrade.b;
import com.xiaomi.midrop.transmission.upgrade.util.a;
import com.xiaomi.midrop.util.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class UpgradeListDialog
extends DialogFragment
implements a.a {
    public a a;
    boolean b;
    private TextView c;
    private ImageView d;
    private LinearLayout e;
    private RecyclerView f;
    private Button g;
    private Button h;
    private b i;
    private ArrayList<com.xiaomi.midrop.transmission.upgrade.a.a> j;
    private ArrayList<com.xiaomi.midrop.transmission.upgrade.a.a> k;
    private final int l = 3;

    static /* synthetic */ boolean a(UpgradeListDialog upgradeListDialog) {
        return upgradeListDialog.b;
    }

    static /* synthetic */ boolean a(UpgradeListDialog upgradeListDialog, boolean bl) {
        upgradeListDialog.b = bl;
        return bl;
    }

    static /* synthetic */ ArrayList b(UpgradeListDialog upgradeListDialog) {
        return upgradeListDialog.k;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b() {
        int n2;
        Resources resources;
        int n3 = com.xiaomi.midrop.transmission.upgrade.util.a.e().c.size();
        boolean bl = this.k.size() > 0 && this.k.size() == n3;
        this.b = bl;
        this.d.setSelected(this.b);
        Button button = this.h;
        boolean bl2 = false;
        if (n3 > 0) {
            bl2 = true;
        }
        button.setEnabled(bl2);
        Button button2 = this.h;
        if (this.h.isEnabled()) {
            resources = this.getResources();
            n2 = 2131099723;
        } else {
            resources = this.getResources();
            n2 = 2131099724;
        }
        int n4 = resources.getColor(n2);
        button2.setTextColor(n4);
    }

    private static boolean b(com.xiaomi.midrop.transmission.upgrade.a.a a2) {
        for (g g2 : c.e().f) {
            if (g2.z == g.a.a || g2.m == 5 || g2.m == 4 || !com.xiaomi.midrop.util.g.d(j.d(g2.i)) || !TextUtils.equals((CharSequence)g2.i, (CharSequence)a2.g) && !a2.a(g2.C)) continue;
            a2.i = true;
            return true;
        }
        return false;
    }

    static /* synthetic */ b c(UpgradeListDialog upgradeListDialog) {
        return upgradeListDialog.i;
    }

    private void c() {
        this.j.clear();
        List<com.xiaomi.midrop.transmission.upgrade.a.a> list = com.xiaomi.midrop.transmission.upgrade.util.a.e().e;
        this.j.addAll(list);
        if (this.j.size() == 0) {
            return;
        }
        Iterator iterator = this.j.iterator();
        ArrayList arrayList = new ArrayList();
        while (iterator.hasNext()) {
            com.xiaomi.midrop.transmission.upgrade.a.a a2 = (com.xiaomi.midrop.transmission.upgrade.a.a)iterator.next();
            if (!a2.i && !UpgradeListDialog.b(a2)) continue;
            iterator.remove();
            arrayList.add((Object)a2);
        }
        this.k.addAll(this.j);
        this.j.addAll((Collection)arrayList);
    }

    @Override
    public final void a(com.xiaomi.midrop.transmission.upgrade.a.a a2) {
        if (!this.k.contains((Object)a2)) {
            this.k.add((Object)a2);
        }
    }

    @Override
    public final void a(List<com.xiaomi.midrop.transmission.upgrade.a.a> list) {
        UpgradeListDialog.super.b();
    }

    @Override
    public final void b(List<com.xiaomi.midrop.transmission.upgrade.a.a> list) {
        UpgradeListDialog.super.b();
    }

    @Override
    public final void h_() {
        this.b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.i = new b((Context)this.getActivity(), (List<com.xiaomi.midrop.transmission.upgrade.a.a>)this.j);
        UpgradeListDialog.super.c();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog((Context)this.getActivity(), 2131755181);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
            dialog.setCanceledOnTouchOutside(false);
        }
        return dialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!com.xiaomi.midrop.transmission.upgrade.util.a.e().c((b.a)this)) {
            com.xiaomi.midrop.transmission.upgrade.util.a.e().a((b.a)this);
        }
        return layoutInflater.inflate(2131427587, (ViewGroup)new FrameLayout(this.getContext()));
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (com.xiaomi.midrop.transmission.upgrade.util.a.e().c(this)) {
            com.xiaomi.midrop.transmission.upgrade.util.a.e().b(this);
        }
        com.xiaomi.midrop.transmission.upgrade.util.a.e().c();
    }

    public void onStart() {
        super.onStart();
        if (this.getDialog() != null && this.getDialog().getWindow() != null) {
            Dialog dialog = this.getDialog();
            WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
            layoutParams.width = -1;
            layoutParams.gravity = 80;
            dialog.getWindow().setAttributes(layoutParams);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setOnTouchListener(new View.OnTouchListener((UpgradeListDialog)this){
            final /* synthetic */ UpgradeListDialog a;
            {
                this.a = upgradeListDialog;
            }

            public final boolean onTouch(View view, android.view.MotionEvent motionEvent) {
                return true;
            }
        });
        this.c = (TextView)view.findViewById(2131296842);
        this.g = (Button)view.findViewById(2131296841);
        this.h = (Button)view.findViewById(2131296875);
        this.d = (ImageView)view.findViewById(2131296734);
        this.e = (LinearLayout)view.findViewById(2131296730);
        this.e.setOnClickListener(new View.OnClickListener((UpgradeListDialog)this){
            final /* synthetic */ UpgradeListDialog a;
            {
                this.a = upgradeListDialog;
            }

            public void onClick(View view) {
                UpgradeListDialog.a(this.a, true ^ UpgradeListDialog.a(this.a));
                if (UpgradeListDialog.a(this.a)) {
                    com.xiaomi.midrop.transmission.upgrade.util.a.e().b(UpgradeListDialog.b(this.a));
                } else {
                    com.xiaomi.midrop.transmission.upgrade.util.a.e().c(UpgradeListDialog.b(this.a));
                }
                UpgradeListDialog.c((UpgradeListDialog)this.a).a.b();
            }
        });
        this.g.setOnClickListener(new View.OnClickListener((UpgradeListDialog)this){
            final /* synthetic */ UpgradeListDialog a;
            {
                this.a = upgradeListDialog;
            }

            public void onClick(View view) {
                this.a.dismiss();
            }
        });
        this.h.setOnClickListener(new View.OnClickListener((UpgradeListDialog)this){
            final /* synthetic */ UpgradeListDialog a;
            {
                this.a = upgradeListDialog;
            }

            public void onClick(View view) {
                UpgradeListDialog upgradeListDialog = this.a;
                ArrayList arrayList = new ArrayList();
                if (upgradeListDialog.a != null) {
                    for (com.xiaomi.midrop.transmission.upgrade.a.a a2 : com.xiaomi.midrop.transmission.upgrade.util.a.e().c) {
                        if (a2.i) continue;
                        arrayList.add((Object)a2);
                        a2.i = true;
                    }
                    upgradeListDialog.a.a((List<com.xiaomi.midrop.transmission.upgrade.a.a>)arrayList);
                }
                if (arrayList.size() != 0) {
                    com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.cW).a(com.xiaomi.midrop.util.af$b.aa, arrayList.size()).a();
                    com.xiaomi.midrop.util.af af2 = com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.cW);
                    com.xiaomi.midrop.util.af$b b2 = com.xiaomi.midrop.util.af$b.ab;
                    String string2 = upgradeListDialog.b ? "YES" : "NO";
                    af2.a(b2, string2).a();
                    for (com.xiaomi.midrop.transmission.upgrade.a.a a3 : arrayList) {
                        com.xiaomi.midrop.util.af.a(com.xiaomi.midrop.util.af$a.cW).a(com.xiaomi.midrop.util.af$b.ac, a3.b).a();
                    }
                }
                this.a.dismiss();
            }
        });
        this.f = (RecyclerView)view.findViewById(2131296676);
        GridLayoutManager gridLayoutManager = new GridLayoutManager((Context)this.getActivity(), 3);
        this.f.setLayoutManager((RecyclerView.i)gridLayoutManager);
        this.f.setAdapter((RecyclerView.a)this.i);
        TextView textView = this.c;
        Resources resources = this.getResources();
        int n2 = this.j.size();
        Object[] arrobject = new Object[]{this.j.size()};
        textView.setText((CharSequence)resources.getQuantityString(2131558413, n2, arrobject));
        if (this.k.size() == 0) {
            this.e.setEnabled(false);
            this.d.setEnabled(false);
        }
        com.xiaomi.midrop.transmission.upgrade.util.a.e().b(this.k);
        UpgradeListDialog.super.b();
    }

}

