/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.k
 *  android.support.v4.view.ViewPager
 *  android.support.v4.view.ViewPager$e
 *  android.support.v4.view.n
 *  android.support.v7.app.c
 *  android.support.v7.app.d
 *  android.text.TextUtils
 *  android.util.SparseArray
 *  android.util.SparseBooleanArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.view.animation.LayoutAnimationController
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  android.widget.Toast
 *  de.greenrobot.event.c
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.List
 */
package com.xiaomi.midrop.received;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.support.v4.view.ViewPager;
import android.support.v4.view.n;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.e;
import com.xiaomi.midrop.received.ReceivedActivity;
import com.xiaomi.midrop.received.ReceivedDirFragment;
import com.xiaomi.midrop.received.ReceivedFragment;
import com.xiaomi.midrop.send.dir.FilePickDirectoryFragment;
import com.xiaomi.midrop.sender.c.b;
import com.xiaomi.midrop.sender.c.c;
import com.xiaomi.midrop.sender.c.g;
import com.xiaomi.midrop.sender.fragment.BasePickFragment;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.util.u;
import com.xiaomi.midrop.view.ViewPager;
import com.xiaomi.midrop.view.action.MoreAction;
import com.xiaomi.midrop.view.d;
import com.xiaomi.midrop.view.tablayout.CommonSlidingTabLayout;
import com.xiaomi.midrop.view.tablayout.a.a;
import com.xiaomi.midrop.view.tablayout.a.b;
import com.xiaomi.midrop.view.tablayout.widget.MsgView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class ReceivedActivity
extends com.xiaomi.midrop.util.Locale.a
implements g.a,
MoreAction.a {
    public static final int[] b = new int[]{7, 4, 2, 1, 3};
    SparseArray<List<g>> a = new SparseArray();
    private CommonSlidingTabLayout c;
    private ViewPager d;
    private ArrayList<com.xiaomi.midrop.view.tablayout.a.a> e = new ArrayList();
    private List<Fragment> f = new ArrayList();
    private boolean g = false;
    private MoreAction h;
    private int i;
    private SparseBooleanArray j = new SparseBooleanArray();
    private a k;

    public static int a(int n2) {
        for (int i2 = 0; i2 < b.length; ++i2) {
            if (b[i2] != n2) continue;
            return i2;
        }
        return 2;
    }

    static /* synthetic */ void a(ReceivedActivity receivedActivity) {
        if (receivedActivity.f.isEmpty()) {
            if (!receivedActivity.e.isEmpty()) {
                return;
            }
            receivedActivity.i = receivedActivity.getIntent().getIntExtra("param_index", 2);
            SparseArray<HashSet<String>> sparseArray = com.xiaomi.midrop.result.a.a().d;
            int n2 = 0;
            for (int i2 = 0; i2 < sparseArray.size(); ++i2) {
                int n3 = sparseArray.keyAt(i2);
                HashSet hashSet = (HashSet)sparseArray.get(n3);
                if (hashSet == null || hashSet.isEmpty()) continue;
                receivedActivity.j.put(n3, true);
            }
            receivedActivity.j.put(ReceivedActivity.e(receivedActivity.i), false);
            receivedActivity.d = (ViewPager)receivedActivity.findViewById(2131296908);
            receivedActivity.c = (CommonSlidingTabLayout)receivedActivity.findViewById(2131296790);
            receivedActivity.f.add((Object)ReceivedDirFragment.a(FilePickDirectoryFragment.a.b));
            receivedActivity.f.add((Object)ReceivedFragment.a(4));
            receivedActivity.f.add((Object)ReceivedFragment.a(2));
            receivedActivity.f.add((Object)ReceivedFragment.a(1));
            receivedActivity.f.add((Object)ReceivedFragment.a(3));
            receivedActivity.d.a(new ViewPager.e(receivedActivity){
                final /* synthetic */ ReceivedActivity a;
                {
                    this.a = receivedActivity;
                }

                public final void a(int n2) {
                    if (this.a.b()) {
                        this.a.d();
                    }
                    ReceivedActivity.c(this.a).put(ReceivedActivity.b(n2), false);
                    ReceivedActivity.d(this.a).c(n2);
                }

                public final void a(int n2, float f2) {
                }
            });
            receivedActivity.k = new a(receivedActivity.f, receivedActivity.getSupportFragmentManager());
            receivedActivity.d.setAdapter((n)receivedActivity.k);
            receivedActivity.e.add((Object)new com.xiaomi.midrop.view.tablayout.a(2131231041, 2131231040, a.a.b));
            receivedActivity.e.add((Object)new com.xiaomi.midrop.view.tablayout.a(2131231050, 2131231049, a.a.c));
            receivedActivity.e.add((Object)new com.xiaomi.midrop.view.tablayout.a(2131231048, 2131231047, a.a.e));
            receivedActivity.e.add((Object)new com.xiaomi.midrop.view.tablayout.a(2131231039, 2131231038, a.a.d));
            receivedActivity.e.add((Object)new com.xiaomi.midrop.view.tablayout.a(2131231046, 2131231045, a.a.f));
            receivedActivity.c.setTabData(receivedActivity.e);
            receivedActivity.c.setOnTabSelectListener(new b(receivedActivity){
                final /* synthetic */ ReceivedActivity a;
                {
                    this.a = receivedActivity;
                }

                public final void a(int n2) {
                    if (ReceivedActivity.e(this.a).getCurrentItem() != n2) {
                        ReceivedActivity.e(this.a).a(n2, false);
                    }
                }
            });
            receivedActivity.c.setViewPager(receivedActivity.d);
            receivedActivity.d.setCurrentItem(receivedActivity.i);
            while (n2 < receivedActivity.c.getTabCount()) {
                int n4 = ReceivedActivity.e(n2);
                if (receivedActivity.j.get(n4)) {
                    receivedActivity.c.b(n2);
                    CommonSlidingTabLayout commonSlidingTabLayout = receivedActivity.c;
                    int n5 = n2 >= commonSlidingTabLayout.b ? commonSlidingTabLayout.b - 1 : n2;
                    MsgView msgView = (MsgView)commonSlidingTabLayout.a.getChildAt(n5).findViewById(2131296694);
                    msgView.setStrokeWidth(1);
                    msgView.setStrokeColor(receivedActivity.getResources().getColor(2131099891));
                    msgView.setBackgroundColor(Color.parseColor((String)"#ff6464"));
                    int n6 = c.a((Context)receivedActivity, 8.7f);
                    if (msgView != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)msgView.getLayoutParams();
                        layoutParams.width = n6;
                        layoutParams.height = n6;
                        msgView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                    }
                }
                ++n2;
            }
        }
    }

    static /* synthetic */ int b(int n2) {
        return ReceivedActivity.e(n2);
    }

    static /* synthetic */ void b(ReceivedActivity receivedActivity) {
        super.onBackPressed();
    }

    static /* synthetic */ SparseBooleanArray c(ReceivedActivity receivedActivity) {
        return receivedActivity.j;
    }

    static /* synthetic */ CommonSlidingTabLayout d(ReceivedActivity receivedActivity) {
        return receivedActivity.c;
    }

    private static int e(int n2) {
        if (n2 < b.length) {
            return b[n2];
        }
        return b[0];
    }

    static /* synthetic */ ViewPager e(ReceivedActivity receivedActivity) {
        return receivedActivity.d;
    }

    static /* synthetic */ void f(ReceivedActivity receivedActivity) {
        receivedActivity.i();
    }

    static /* synthetic */ SparseArray g(ReceivedActivity receivedActivity) {
        return receivedActivity.a;
    }

    private void i() {
        this.h.a();
        this.g = false;
        de.greenrobot.event.c.a().c((Object)new com.xiaomi.midrop.received.a.a(false));
        com.xiaomi.midrop.sender.c.g.e().c();
    }

    private List<g> j() {
        if (this.c != null) {
            switch (this.c.getCurrentTab()) {
                default: {
                    break;
                }
                case 4: {
                    return (List)this.a.get(3);
                }
                case 3: {
                    return (List)this.a.get(1);
                }
                case 2: {
                    return (List)this.a.get(2);
                }
                case 1: {
                    return (List)this.a.get(4);
                }
                case 0: {
                    return (List)this.a.get(7);
                }
            }
        }
        return new ArrayList();
    }

    public final void a(int n2, List<g> list) {
        this.a.put(n2, list);
    }

    @Override
    public final void a(String string2, List<g> list) {
    }

    @Override
    public final void a(List<g> list) {
        this.d();
    }

    @Override
    public final void b(List<g> list) {
        this.d();
    }

    public final boolean b() {
        return this.g && this.h != null && this.h.k;
    }

    public final void c() {
        if (!this.g) {
            MoreAction moreAction = this.h;
            boolean bl = this.j() != null && com.xiaomi.midrop.sender.c.g.e().a(this.j());
            if (!moreAction.k) {
                if (moreAction.i != null) {
                    MoreAction.a(moreAction.b, moreAction.i);
                    moreAction.i.addView(moreAction.b, new ViewGroup.LayoutParams(-1, -1));
                    moreAction.b.setAnimation(AnimationUtils.loadAnimation((Context)moreAction.a, (int)2130771980));
                    moreAction.c = moreAction.b.findViewById(16908313);
                    moreAction.d = moreAction.b.findViewById(16908314);
                    moreAction.e = (TextView)moreAction.b.findViewById(16908310);
                    moreAction.c.setOnClickListener((View.OnClickListener)moreAction);
                    moreAction.d.setOnClickListener((View.OnClickListener)moreAction);
                    moreAction.d.setSelected(bl);
                }
                if (moreAction.j != null) {
                    moreAction.j.setVisibility(0);
                    moreAction.f = moreAction.j.findViewById(2131296735);
                    moreAction.g = moreAction.j.findViewById(2131296411);
                    moreAction.j.setLayoutAnimation(AnimationUtils.loadLayoutAnimation((Context)moreAction.a, (int)2130771981));
                    moreAction.f.setOnClickListener((View.OnClickListener)moreAction);
                    moreAction.g.setOnClickListener((View.OnClickListener)moreAction);
                }
                if (moreAction.l != null) {
                    moreAction.l.setVisibility(0);
                }
                if (moreAction.m != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)moreAction.m.getLayoutParams();
                    int n2 = (int)moreAction.a.getResources().getDimension(2131165460);
                    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, n2);
                }
                moreAction.k = true;
            }
            this.g = true;
            de.greenrobot.event.c.a().c((Object)new com.xiaomi.midrop.received.a.a(true));
            this.d();
        }
    }

    public final void d() {
        if (this.b()) {
            int n2 = com.xiaomi.midrop.sender.c.g.e().a();
            if (!com.xiaomi.midrop.sender.c.g.e().b() && this.j() != null && !this.j().isEmpty()) {
                if (this.j() != null && com.xiaomi.midrop.sender.c.g.e().a(this.j())) {
                    this.h.a(false, true, n2);
                    return;
                }
                this.h.a(false, false, n2);
                return;
            }
            this.h.a(com.xiaomi.midrop.sender.c.g.e().b(), false, n2);
        }
    }

    @Override
    public final void e() {
        this.i();
    }

    @Override
    public final boolean f() {
        if (this.j() != null) {
            if (this.j().isEmpty()) {
                return false;
            }
            if (com.xiaomi.midrop.sender.c.g.e().a(this.j())) {
                com.xiaomi.midrop.sender.c.g.e().c(this.j());
                this.d();
                return false;
            }
            if (this.c != null && this.c.getCurrentTabEntity().c() == a.a.b) {
                List<g> list = this.j();
                ArrayList arrayList = new ArrayList();
                for (g g2 : list) {
                    if (TextUtils.isEmpty((CharSequence)g2.i)) continue;
                    arrayList.add((Object)g2.i);
                }
                if (!arrayList.isEmpty()) {
                    for (String string2 : arrayList) {
                        File file = new File(string2);
                        if (!file.exists() || !file.isDirectory()) continue;
                        com.xiaomi.midrop.sender.c.g.e().b(string2);
                    }
                }
            }
            com.xiaomi.midrop.sender.c.g.e().b(this.j());
            this.d();
            return true;
        }
        return false;
    }

    @Override
    public final void g() {
        u.b b2 = new u.b(this){
            final /* synthetic */ ReceivedActivity a;
            {
                this.a = receivedActivity;
            }

            public final void onClick() {
                ReceivedActivity.f(this.a);
            }
        };
        if (this != null) {
            ArrayList<Uri> arrayList = com.xiaomi.midrop.sender.c.g.e().f();
            if (arrayList.isEmpty()) {
                Toast.makeText((Context)this, (int)2131689768, (int)0).show();
                return;
            }
            new u.a(this, (List<Uri>)arrayList, "file_select_from_received", b2).execute((Object[])new Void[0]);
        }
    }

    @Override
    public final void h() {
        String string2;
        int n2 = com.xiaomi.midrop.sender.c.g.e().a();
        if (n2 == 1) {
            string2 = this.getResources().getString(2131689624);
        } else {
            Resources resources = this.getResources();
            Object[] arrobject = new Object[]{n2};
            string2 = resources.getQuantityString(2131558401, n2, arrobject);
        }
        com.xiaomi.midrop.view.c c2 = new com.xiaomi.midrop.view.c((Context)this);
        com.xiaomi.midrop.view.c c3 = c2.a(2131689623);
        c3.b = string2;
        com.xiaomi.midrop.view.c c4 = c3.a(2131689536, null);
        c4.j = 2;
        c4.b(2131689623, new View.OnClickListener(this){
            final /* synthetic */ ReceivedActivity a;
            {
                this.a = receivedActivity;
            }

            public void onClick(View view) {
                HashSet hashSet = new HashSet();
                for (int i2 = 0; i2 < ReceivedActivity.g(this.a).size(); ++i2) {
                    List list = (List)ReceivedActivity.g(this.a).get(ReceivedActivity.g(this.a).keyAt(i2));
                    if (list == null || list.isEmpty()) continue;
                    java.util.Iterator iterator = list.iterator();
                    while (iterator.hasNext()) {
                        g g2 = (g)iterator.next();
                        if (!com.xiaomi.midrop.sender.c.g.e().a(g2)) continue;
                        hashSet.add((Object)g2.i);
                        iterator.remove();
                    }
                }
                java.util.Iterator<T> iterator = com.xiaomi.midrop.sender.c.g.e().d();
                while (iterator.hasNext()) {
                    hashSet.add((Object)((g)iterator.next()).i);
                }
                com.xiaomi.midrop.sender.c.g.e().c();
                MoreAction.b();
                ReceivedActivity.f(this.a);
                if (!hashSet.isEmpty()) {
                    new AsyncTask<HashSet<String>, Void, Void>(this){
                        final /* synthetic */ 7 a;
                        {
                            this.a = var1;
                        }

                        protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                            java.util.Iterator iterator = ((HashSet[])arrobject)[0].iterator();
                            while (iterator.hasNext()) {
                                com.xiaomi.midrop.util.j.e((String)iterator.next());
                            }
                            return null;
                        }

                        protected final /* synthetic */ void onPostExecute(Object object) {
                            super.onPostExecute((Object)((Void)object));
                            de.greenrobot.event.c.a().c((Object)new com.xiaomi.midrop.received.a.b());
                        }
                    }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new HashSet[]{hashSet});
                }
            }
        });
        c2.d();
    }

    @Override
    public final void h_() {
    }

    public void onBackPressed() {
        BasePickFragment basePickFragment;
        if (this.c != null && this.c.getCurrentTabEntity().c() == a.a.b && this.f.get(this.c.getCurrentTab()) instanceof BasePickFragment && (basePickFragment = (BasePickFragment)this.f.get(this.c.getCurrentTab())) != null && basePickFragment.e()) {
            return;
        }
        if (this.h.k && this.g) {
            this.i();
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a(false);
        this.setContentView(2131427373);
        com.xiaomi.midrop.result.a.a().n = false;
        ag.a((Activity)this, this.getResources().getColor(2131099891));
        this.c(2131427431);
        View view = this.t();
        View view2 = view.findViewById(2131296485);
        if (ac.c((Context)this)) {
            view2.setRotation(180.0f);
        }
        view2.setOnClickListener(new View.OnClickListener((ReceivedActivity)this){
            final /* synthetic */ ReceivedActivity a;
            {
                this.a = receivedActivity;
            }

            public void onClick(View view) {
                try {
                    ReceivedActivity.b(this.a);
                }
                catch (java.lang.IllegalStateException illegalStateException) {}
            }
        });
        view.findViewById(2131296431).setVisibility(8);
        TextView textView = (TextView)view.findViewById(2131296810);
        textView.setTextColor(this.getResources().getColor(2131100072));
        textView.setText((CharSequence)this.getResources().getString(2131689826));
        view.setBackgroundColor(this.getResources().getColor(2131099891));
        ImageView imageView = (ImageView)view.findViewById(2131296491);
        imageView.setVisibility(0);
        imageView.setImageResource(2131231033);
        imageView.setOnClickListener(new View.OnClickListener((ReceivedActivity)this){
            final /* synthetic */ ReceivedActivity a;
            {
                this.a = receivedActivity;
            }

            public void onClick(View view) {
                this.a.c();
                MoreAction.a("edit");
            }
        });
        this.h = new MoreAction((com.xiaomi.midrop.util.Locale.a)this, (MoreAction.a)this);
        com.xiaomi.midrop.sender.c.a.a().a((Activity)this);
        com.xiaomi.midrop.sender.c.g.e().a((b.a)this);
    }

    @Override
    protected void onDestroy() {
        com.xiaomi.midrop.sender.c.g.e().b(this);
        com.xiaomi.midrop.sender.c.g.e().c();
        for (int i2 = 0; i2 < this.j.size(); ++i2) {
            if (this.j.valueAt(i2)) continue;
            int n2 = this.j.keyAt(i2);
            com.xiaomi.midrop.result.a a2 = com.xiaomi.midrop.result.a.a();
            if (a2.d.get(n2) == null) continue;
            a2.d.delete(n2);
        }
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.a(e.b, 0, new a.a(this){
            final /* synthetic */ ReceivedActivity a;
            {
                this.a = receivedActivity;
            }

            public final void a() {
                this.a.u();
            }

            public final void a(int n2) {
                ReceivedActivity.a(this.a);
            }
        });
    }

    private static final class a
    extends d {
        private List<Fragment> a;

        public a(List<Fragment> list, k k2) {
            super(k2);
            this.a = list;
        }

        @Override
        public final Fragment a(int n2) {
            return (Fragment)this.a.get(n2);
        }

        public final CharSequence b(int n2) {
            return "";
        }

        public final int c() {
            if (this.a != null) {
                return this.a.size();
            }
            return 0;
        }
    }

}

