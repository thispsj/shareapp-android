/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Environment
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.LinearLayoutManager$d
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$b
 *  android.support.v7.widget.RecyclerView$h
 *  android.support.v7.widget.RecyclerView$i
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.TextView
 *  com.xiaomi.midrop.sender.ui.d
 *  java.io.File
 *  java.io.FilenameFilter
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.List
 */
package com.xiaomi.midrop.view;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.sender.c.f;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.sender.ui.c;
import com.xiaomi.midrop.sender.ui.d;
import com.xiaomi.midrop.sender.ui.j;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.ai;
import com.xiaomi.midrop.util.al;
import com.xiaomi.midrop.util.p;
import com.xiaomi.midrop.view.DirNavigationView;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DirNavigationView
extends FrameLayout
implements View.OnClickListener,
d.a,
c.b {
    public String a;
    public d b;
    public String c;
    public String d;
    private int e = 0;
    private RecyclerView f;
    private com.xiaomi.midrop.sender.ui.c g;
    private List<String> h = new ArrayList();
    private TextView i;
    private View j;
    private ImageView k;
    private View l;
    private View m;
    private RecyclerView n;
    private LinearLayoutManager o;
    private List<g> p = new ArrayList();
    private boolean q = false;
    private String r;
    private String s;
    private HashMap<String, c> t = new HashMap();
    private b u;
    private a v;
    private j w;
    private boolean x;

    public DirNavigationView(Context context) {
        super(context);
        DirNavigationView.super.a();
    }

    public DirNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        DirNavigationView.super.a();
    }

    public DirNavigationView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        DirNavigationView.super.a();
    }

    static /* synthetic */ ImageView a(DirNavigationView dirNavigationView) {
        return dirNavigationView.k;
    }

    private void a() {
        LayoutInflater.from((Context)this.getContext()).inflate(2131427479, (ViewGroup)this);
        this.f = (RecyclerView)this.findViewById(2131296670);
        this.g = new com.xiaomi.midrop.sender.ui.c(this.getContext(), this.h);
        this.g.c = this;
        this.f.setLayoutManager((RecyclerView.i)new LinearLayoutManager(this.getContext(), 0, false));
        this.f.setAdapter((RecyclerView.a)this.g);
        this.i = (TextView)this.findViewById(2131296871);
        this.i.setOnClickListener((View.OnClickListener)this);
        this.j = this.findViewById(2131296321);
        this.j.setOnClickListener((View.OnClickListener)this);
        this.k = (ImageView)this.findViewById(2131296783);
        this.k.setOnClickListener((View.OnClickListener)this);
        this.k.setImageLevel(0);
        this.m = this.findViewById(2131296812);
        this.m.setOnClickListener((View.OnClickListener)this);
        this.n = (RecyclerView)this.findViewById(2131296676);
        this.o = new LinearLayoutManager(this.getContext());
        this.n.setLayoutManager((RecyclerView.i)this.o);
        this.b = new d(this.getContext(), this.p, this.q);
        this.b.a((d.a)this);
        this.n.setAdapter((RecyclerView.a)this.b);
        this.l = this.findViewById(2131296438);
        this.r = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.s = ai.b(this.getContext());
        if (ac.c(this.getContext())) {
            this.j.setRotation(180.0f);
            this.m.setBackgroundResource(2131231031);
        }
        com.xiaomi.midrop.view.a a2 = new com.xiaomi.midrop.view.a();
        this.n.a((RecyclerView.h)a2);
    }

    @Override
    public final void a(g g2) {
        if (new File(g2.i).isDirectory()) {
            this.b(g2.i);
        }
    }

    @Override
    public final void a(String string2) {
        this.b(string2);
    }

    public final void a(String string2, int n2) {
        this.e = n2;
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string2 = this.r;
        }
        this.d = string2;
        this.b(string2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void b(String string2) {
        block13 : {
            block12 : {
                block10 : {
                    block11 : {
                        block9 : {
                            TextView textView;
                            String string3;
                            int n2 = this.o.k();
                            View view = this.o.g(0);
                            int n3 = view == null ? 0 : view.getTop();
                            Object object = new Object(n2, n3){
                                int a;
                                int b;
                                {
                                    this.a = n3;
                                    this.b = n2;
                                }
                            };
                            this.t.remove((Object)this.c);
                            this.t.put((Object)this.c, object);
                            this.c = string2;
                            if (this.e != 0) break block9;
                            if (!TextUtils.isEmpty((CharSequence)this.a)) {
                                textView = this.i;
                                string3 = this.a;
                            } else {
                                textView = this.i;
                                string3 = com.xiaomi.midrop.util.Locale.b.a().a(2131689786);
                            }
                            textView.setText((CharSequence)string3);
                            break block10;
                        }
                        if (!TextUtils.equals((CharSequence)string2, (CharSequence)this.r)) break block11;
                        this.i.setText(com.xiaomi.midrop.util.Locale.b.a().a(2131689735));
                        if (TextUtils.isEmpty((CharSequence)this.s)) break block10;
                        break block12;
                    }
                    if (!TextUtils.equals((CharSequence)string2, (CharSequence)this.s)) break block10;
                    this.i.setText(com.xiaomi.midrop.util.Locale.b.a().a(2131689953));
                    break block12;
                }
                this.k.setVisibility(8);
                break block13;
            }
            this.k.setVisibility(0);
        }
        if (TextUtils.equals((CharSequence)string2, (CharSequence)this.r) || TextUtils.equals((CharSequence)string2, (CharSequence)this.s) || !TextUtils.isEmpty((CharSequence)this.a) && TextUtils.equals((CharSequence)this.d, (CharSequence)this.c)) {
            this.h.clear();
            this.g.a.b();
        } else {
            int n4 = this.h.lastIndexOf((Object)string2);
            if (n4 != -1) {
                for (int i2 = -1 + this.h.size(); i2 > n4; --i2) {
                    this.h.remove(i2);
                }
            } else {
                this.h.add((Object)string2);
            }
            this.g.a.b();
            if (!this.h.isEmpty()) {
                this.f.b(-1 + this.h.size());
            }
        }
        this.c(string2);
        if (this.h != null && !this.h.isEmpty()) {
            this.j.setVisibility(8);
            return;
        }
        this.j.setVisibility(0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void c(String string2) {
        View view;
        c c2;
        File file = new File(string2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        File[] arrfile = this.e == 1 && (TextUtils.equals((CharSequence)string2, (CharSequence)this.r) || TextUtils.equals((CharSequence)string2, (CharSequence)this.s)) ? file.listFiles((FilenameFilter)new al(string2, this.x)) : (this.x ? file.listFiles() : file.listFiles((FilenameFilter)new p()));
        int n2 = 0;
        if (arrfile != null) {
            for (File file2 : arrfile) {
                g g2 = new g();
                if (file2.isDirectory()) {
                    g2.k = file2.getName();
                    g2.i = file2.getPath();
                    g2.h = Uri.fromFile((File)new File(g2.i)).toString();
                    g2.w = file2.lastModified() / 1000L;
                    arrayList.add((Object)g2);
                    continue;
                }
                g2.k = file2.getName();
                g2.i = file2.getPath();
                g2.h = Uri.fromFile((File)file2).toString();
                g2.w = file2.lastModified() / 1000L;
                g2.l = file2.length();
                arrayList2.add((Object)g2);
            }
        }
        Collections.sort((List)arrayList, f.a());
        Collections.sort((List)arrayList2, f.a());
        this.p.clear();
        this.p.addAll((Collection)arrayList);
        this.p.addAll((Collection)arrayList2);
        this.b.a(this.p);
        this.b.a.b();
        if (this.v != null) {
            this.v.c();
        }
        if ((c2 = this.t.get((Object)this.c)) != null) {
            LinearLayoutManager linearLayoutManager = this.o;
            int n3 = c2.b;
            int n4 = c2.a;
            linearLayoutManager.l = n3;
            linearLayoutManager.m = n4;
            if (linearLayoutManager.n != null) {
                linearLayoutManager.n.a = -1;
            }
            linearLayoutManager.l();
        }
        if (this.p.isEmpty()) {
            view = this.l;
        } else {
            view = this.l;
            n2 = 8;
        }
        view.setVisibility(n2);
    }

    public List<g> getTransItems() {
        return this.p;
    }

    public void onClick(View view) {
        int n2 = view.getId();
        if (n2 != 2131296321 && n2 != 2131296783 && n2 != 2131296812 && n2 != 2131296871) {
            return;
        }
        if (this.h != null) {
            this.h.clear();
        }
        if (this.g != null) {
            this.g.a.b();
        }
        if (this.n != null) {
            this.n.e();
        }
        if (!TextUtils.isEmpty((CharSequence)this.s) && (TextUtils.equals((CharSequence)this.c, (CharSequence)this.s) || TextUtils.equals((CharSequence)this.c, (CharSequence)this.r))) {
            this.k.setImageLevel(1);
            if (this.w == null) {
                j j2 = this.w = new j(this.getContext(), this.r, this.s, new PopupWindow.OnDismissListener((DirNavigationView)this){
                    final /* synthetic */ DirNavigationView a;
                    {
                        this.a = dirNavigationView;
                    }

                    public final void onDismiss() {
                        DirNavigationView.a(this.a).setImageLevel(0);
                    }
                });
                int n3 = this.m.getWidth();
                j2.a.setWidth(n3);
                this.w.d = new j.a(){

                    @Override
                    public final void a(String string2) {
                        DirNavigationView.this.a(string2, 1);
                    }
                };
            } else {
                this.w.c = this.s;
            }
            j j3 = this.w;
            View view2 = this.m;
            j3.a.showAsDropDown(view2, 0, 0);
        }
        if (this.e == 0) {
            this.p.clear();
            this.b.a.b();
        }
        this.b(this.d);
        if (this.u != null) {
            this.u.a();
        }
    }

    public void setDirEnableCheck(boolean bl) {
        if (this.b != null) {
            d d2 = this.b;
            d2.c = bl;
            d2.a.b();
        }
    }

    public void setEnableCheck(boolean bl) {
        if (this.b != null) {
            this.q = bl;
            this.b.a(bl);
        }
    }

    public void setOnContentUpdateListener(a a2) {
        this.v = a2;
    }

    public void setOnHomeClickListener(b b2) {
        this.u = b2;
    }

    public void setShowHiddenFile(boolean bl) {
        this.x = bl;
    }

}

