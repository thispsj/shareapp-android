/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.k
 *  android.support.v4.app.p
 *  android.support.v4.view.ViewPager
 *  android.support.v4.view.ViewPager$e
 *  android.support.v4.view.n
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.xiaomi.midrop.send.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.support.v4.app.p;
import android.support.v4.view.ViewPager;
import android.support.v4.view.n;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.midrop.send.base.FilePickBaseListFragment;
import com.xiaomi.midrop.send.base.FilePickBaseTabFragment;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.view.BaseFragment;
import com.xiaomi.midrop.view.ViewPager;
import com.xiaomi.midrop.view.tablayout.SlidingTabLayout;
import java.util.ArrayList;
import java.util.List;

public abstract class FilePickBaseTabFragment
extends BaseFragment {
    protected SlidingTabLayout a;
    ViewPager b;
    private List<a> c;
    private String[] d;
    private List<Fragment> e;

    public abstract List<a> a();

    public final int b() {
        if (this.b != null) {
            return this.b.getCurrentItem();
        }
        return 0;
    }

    public final Fragment c() {
        if (this.e != null) {
            if (this.e.isEmpty()) {
                return null;
            }
            int n2 = this.b();
            if (n2 >= this.e.size()) {
                return null;
            }
            return (Fragment)this.e.get(n2);
        }
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = this.a();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2131427440, viewGroup, false);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!this.isAdded()) {
            return;
        }
        if (!(this.c == null || this.c.isEmpty() || this.d != null && this.e != null)) {
            this.d = new String[this.c.size()];
            this.e = new ArrayList();
            for (int i2 = 0; i2 < this.c.size(); ++i2) {
                a a2 = this.c.get(i2);
                Fragment fragment = Fragment.instantiate((Context)this.getContext(), (String)a2.b, (Bundle)a2.c);
                if (fragment instanceof FilePickBaseListFragment) {
                    ((FilePickBaseListFragment)fragment).g = true;
                }
                this.e.add((Object)fragment);
                this.d[i2] = a2.a;
            }
        }
        this.a = (SlidingTabLayout)view.findViewById(2131296790);
        this.b = (ViewPager)view.findViewById(2131296908);
        this.b.setOffscreenPageLimit(this.c.size());
        this.b.setAdapter((n)(FilePickBaseTabFragment)this.new b(this.getChildFragmentManager(), this.e));
        this.a.setViewPager(this.b);
        this.a.setSnapOnTabClick(true);
        if (ac.c(this.getContext())) {
            this.a.setCurrentTab(this.c.size() - 1);
        }
        this.b.a(new ViewPager.e((FilePickBaseTabFragment)this){
            final /* synthetic */ FilePickBaseTabFragment a;
            {
                this.a = filePickBaseTabFragment;
            }

            public final void a(int n2) {
                if (this.a.getActivity() instanceof com.xiaomi.midrop.send.FilePickNewActivity) {
                    ((com.xiaomi.midrop.send.FilePickNewActivity)this.a.getActivity()).c();
                }
            }

            public final void a(int n2, float f2) {
            }
        });
    }

    private final class b
    extends p {
        private List<Fragment> b;

        public b(k k2, List<Fragment> list) {
            super(k2);
            this.b = list;
        }

        public final Fragment a(int n2) {
            return (Fragment)this.b.get(n2);
        }

        public final CharSequence b(int n2) {
            if (FilePickBaseTabFragment.this.c != null && !FilePickBaseTabFragment.this.c.isEmpty() && FilePickBaseTabFragment.this.c.size() > n2) {
                return (FilePickBaseTabFragment.a((FilePickBaseTabFragment)FilePickBaseTabFragment.this).get((int)n2)).a;
            }
            return "";
        }

        public final int c() {
            return this.b.size();
        }
    }

}

