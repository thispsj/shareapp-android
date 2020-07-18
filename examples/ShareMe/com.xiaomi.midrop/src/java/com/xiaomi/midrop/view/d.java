/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcelable
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.k
 *  android.support.v4.app.q
 *  android.support.v4.view.n
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.ClassLoader
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.midrop.view;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.support.v4.app.q;
import android.support.v4.view.n;
import android.view.View;
import android.view.ViewGroup;

public abstract class d
extends n {
    private final k a;
    private q b = null;
    private Fragment c = null;

    public d(k k2) {
        this.a = k2;
    }

    private static String a(int n2, long l2) {
        StringBuilder stringBuilder = new StringBuilder("android:switcher:");
        stringBuilder.append(n2);
        stringBuilder.append(":");
        stringBuilder.append(l2);
        return stringBuilder.toString();
    }

    public abstract Fragment a(int var1);

    public final Object a(ViewGroup viewGroup, int n2) {
        if (this.b == null) {
            this.b = this.a.a();
        }
        long l2 = n2;
        String string2 = d.a(viewGroup.getId(), l2);
        Fragment fragment = this.a.a(string2);
        if (fragment != null) {
            this.b.c(fragment);
        } else {
            fragment = this.a(n2);
            this.b.a(viewGroup.getId(), fragment, d.a(viewGroup.getId(), l2));
        }
        if (fragment != this.c) {
            fragment.setMenuVisibility(false);
            fragment.setUserVisibleHint(false);
        }
        return fragment;
    }

    public final void a() {
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
    }

    public final void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public final void a(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            StringBuilder stringBuilder = new StringBuilder("ViewPager with adapter ");
            stringBuilder.append((Object)this);
            stringBuilder.append(" requires a view id");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public final void a(ViewGroup viewGroup, int n2, Object object) {
        if (this.b == null) {
            this.b = this.a.a();
        }
        this.b.b((Fragment)object);
    }

    public final void a(Object object) {
        Fragment fragment = (Fragment)object;
        if (fragment != this.c) {
            if (this.c != null) {
                this.c.setMenuVisibility(false);
                this.c.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.c = fragment;
        }
    }

    public final boolean a(View view, Object object) {
        return ((Fragment)object).getView() == view;
    }

    public final Parcelable b() {
        return null;
    }
}

