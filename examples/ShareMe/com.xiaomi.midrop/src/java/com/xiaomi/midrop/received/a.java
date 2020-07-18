/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$i
 *  android.view.View
 *  com.xiaomi.midrop.received.ReceivedActivity
 *  com.xiaomi.midrop.received.b
 *  com.xiaomi.midrop.view.DirNavigationView
 *  com.xiaomi.midrop.view.stickadapter.StickyHeaderLayoutManager
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.received;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.received.ReceivedActivity;
import com.xiaomi.midrop.received.b;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.util.f;
import com.xiaomi.midrop.util.z;
import com.xiaomi.midrop.view.DirNavigationView;
import com.xiaomi.midrop.view.stickadapter.StickyHeaderLayoutManager;
import java.util.List;

public final class a
implements d.a,
DirNavigationView.a {
    DirNavigationView a;
    private RecyclerView b;
    private b c;
    private List<g> d;
    private View e;

    public a(RecyclerView recyclerView, DirNavigationView dirNavigationView, View view) {
        this.b = recyclerView;
        this.c = new b(recyclerView.getContext(), 1);
        this.c.c = this;
        this.b.setLayoutManager((RecyclerView.i)new StickyHeaderLayoutManager());
        this.b.setAdapter((RecyclerView.a)this.c);
        this.a = dirNavigationView;
        this.a.setOnContentUpdateListener((DirNavigationView.a)this);
        this.e = view;
    }

    public final void a() {
        this.d = z.a(MiDropApplication.a(), 7);
        this.c.c(f.a(this.d, 1));
        this.c.f();
        this.a(true);
    }

    @Override
    public final void a(g g2) {
        this.a.a(g2.i, 0);
        this.a(false);
    }

    public final void a(boolean bl) {
        if (this.b != null) {
            RecyclerView recyclerView = this.b;
            int n2 = bl ? 0 : 8;
            recyclerView.setVisibility(n2);
        }
        if (this.a != null) {
            DirNavigationView dirNavigationView = this.a;
            int n3 = bl ? 8 : 0;
            dirNavigationView.setVisibility(n3);
        }
        if (bl && this.d.isEmpty()) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        if (this.b != null && this.a != null && this.b.getContext() instanceof ReceivedActivity) {
            ReceivedActivity receivedActivity = (ReceivedActivity)this.b.getContext();
            if (bl) {
                receivedActivity.a(7, this.d);
                return;
            }
            receivedActivity.a(7, this.a.getTransItems());
        }
    }

    public final void b() {
        if (this.a != null && this.a.getVisibility() == 0) {
            DirNavigationView dirNavigationView = this.a;
            dirNavigationView.c(dirNavigationView.c);
            return;
        }
        this.a();
    }

    public final void b(boolean bl) {
        if (this.c != null) {
            this.c.a(bl);
        }
        if (this.a != null) {
            this.a.setEnableCheck(bl);
        }
    }

    @Override
    public final void c() {
        this.a(false);
    }
}

