/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.support.v4.app.g
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$h
 *  android.support.v7.widget.RecyclerView$i
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewStub
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Comparator
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Set
 *  java.util.TreeMap
 */
package com.xiaomi.midrop.send.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.xiaomi.midrop.b.a.a;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.send.FilePickNewActivity;
import com.xiaomi.midrop.send.base.FilePickBaseListFragment;
import com.xiaomi.midrop.send.base.a;
import com.xiaomi.midrop.sender.c.b;
import com.xiaomi.midrop.view.BaseFragment;
import com.xiaomi.midrop.view.LoadingView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public abstract class FilePickBaseListFragment<T>
extends BaseFragment {
    public RecyclerView a;
    protected LoadingView b;
    protected a c;
    protected String d;
    protected HashSet<g> e = new HashSet();
    protected HashSet<g> f = new HashSet();
    boolean g;
    private View h;
    private com.xiaomi.midrop.b.a.a<T> i;
    private boolean j;

    static /* synthetic */ void a(FilePickBaseListFragment filePickBaseListFragment, Object object) {
        if (object != null) {
            new Handler().post(new Runnable(filePickBaseListFragment, object){
                final /* synthetic */ Object a;
                final /* synthetic */ FilePickBaseListFragment b;
                {
                    this.b = filePickBaseListFragment;
                    this.a = object;
                }

                /*
                 * Enabled aggressive block sorting
                 */
                public final void run() {
                    boolean bl;
                    FilePickBaseListFragment filePickBaseListFragment;
                    List<i> list = this.b.a(this.a);
                    if (list != null && !list.isEmpty()) {
                        this.b.c.c(list);
                        a a2 = this.b.c;
                        HashSet<g> hashSet = this.b.e;
                        if (hashSet != null) {
                            a2.f.clear();
                            a2.f.addAll(hashSet);
                        }
                        a a3 = this.b.c;
                        HashSet<g> hashSet2 = this.b.f;
                        if (hashSet2 != null) {
                            a3.g.clear();
                            a3.g.addAll(hashSet2);
                        }
                        this.b.c.f();
                        filePickBaseListFragment = this.b;
                        bl = false;
                    } else {
                        filePickBaseListFragment = this.b;
                        bl = true;
                    }
                    filePickBaseListFragment.a(bl);
                }
            });
            if (filePickBaseListFragment.getActivity() instanceof FilePickNewActivity) {
                ((FilePickNewActivity)filePickBaseListFragment.getActivity()).a.setVisibility(8);
            }
        }
    }

    private void f() {
        if (!this.g || this.getUserVisibleHint() && this.isVisible() && !this.j) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getClass().getSimpleName());
            stringBuilder.append(" begin loading");
            this.b();
            this.j = true;
        }
    }

    public abstract a a();

    public List<i> a(T t2) {
        return null;
    }

    protected final List<i> a(TreeMap<String, List<g>> treeMap, Comparator<String> comparator) {
        ArrayList arrayList = new ArrayList();
        if (treeMap != null && !treeMap.isEmpty()) {
            Object[] arrobject = (String[])treeMap.keySet().toArray((Object[])new String[treeMap.size()]);
            if (comparator != null) {
                Arrays.sort((Object[])arrobject, comparator);
            }
            for (int i2 = 0; i2 < arrobject.length; ++i2) {
                Object object = arrobject[i2];
                List list = (List)treeMap.get(object);
                i i3 = i.a((String)object, (g)list.get(0), (List<g>)list);
                i3.G = this.d;
                i3.d = 0;
                if (!list.isEmpty()) {
                    this.f.add(list.get(-1 + list.size()));
                }
                arrayList.add((Object)i3);
            }
        }
        return arrayList;
    }

    protected final void a(boolean bl) {
        View view = this.h;
        int n2 = 8;
        int n3 = bl ? 0 : 8;
        view.setVisibility(n3);
        RecyclerView recyclerView = this.a;
        if (!bl) {
            n2 = 0;
        }
        recyclerView.setVisibility(n2);
    }

    public void b() {
        if (this.i == null) {
            this.i = this.c();
        }
        if (this.i != null) {
            this.i.a((T)new a.a<T>(this){
                final /* synthetic */ FilePickBaseListFragment a;
                {
                    this.a = filePickBaseListFragment;
                }

                public final void a(T t2) {
                    if (this.a.isAdded() && !this.a.isHidden()) {
                        FilePickBaseListFragment.a(this.a, t2);
                        this.a.b.setVisibility(8);
                    }
                }
            });
            if (this.isVisible()) {
                this.b.a();
            }
            this.i.a();
        }
    }

    public com.xiaomi.midrop.b.a.a<T> c() {
        return null;
    }

    protected RecyclerView.i d() {
        return new LinearLayoutManager(this.getContext());
    }

    public final RecyclerView e() {
        return this.a;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2131427439, viewGroup, false);
    }

    public void onDestroyView() {
        if (this.c != null && com.xiaomi.midrop.sender.c.g.e().c(this.c)) {
            com.xiaomi.midrop.sender.c.g.e().b(this.c);
        }
        this.j = false;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.c = this.a();
        this.a = (RecyclerView)view.findViewById(2131296676);
        this.a.setLayoutManager(this.d());
        this.a.setAdapter((RecyclerView.a)this.c);
        this.h = view.findViewById(2131296439);
        this.b = (LoadingView)view.findViewById(2131296598);
        if (!com.xiaomi.midrop.sender.c.g.e().c(this.c)) {
            com.xiaomi.midrop.sender.c.g.e().a(this.c);
        }
        FilePickBaseListFragment.super.f();
        com.xiaomi.midrop.view.a a2 = new com.xiaomi.midrop.view.a();
        this.a.a((RecyclerView.h)a2);
    }

    public void setUserVisibleHint(boolean bl) {
        super.setUserVisibleHint(bl);
        if (this.g) {
            FilePickBaseListFragment.super.f();
        }
    }
}

