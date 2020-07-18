/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$h
 *  android.support.v7.widget.RecyclerView$i
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewStub
 *  android.widget.RelativeLayout
 *  com.xiaomi.midrop.send.contacts.ContactPickFragment$initView
 *  java.lang.Boolean
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.util.HashMap
 *  java.util.List
 *  kotlinx.coroutines.af
 *  kotlinx.coroutines.al
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.y
 *  kotlinx.coroutines.z
 */
package com.xiaomi.midrop.send.contacts;

import a.b.b.a.d;
import a.e.a.m;
import a.g;
import a.j;
import a.l;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.xiaomi.midrop.R;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.h;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.e;
import com.xiaomi.midrop.send.contacts.ContactPickFragment;
import com.xiaomi.midrop.send.contacts.c;
import com.xiaomi.midrop.sender.c.b;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.view.BaseFragment;
import com.xiaomi.midrop.view.LoadingView;
import com.xiaomi.midrop.view.stickadapter.StickyHeaderLayoutManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlinx.coroutines.af;
import kotlinx.coroutines.al;
import kotlinx.coroutines.y;
import kotlinx.coroutines.z;

public final class ContactPickFragment
extends BaseFragment {
    private final c a = new c();
    private View b;
    private final int c = 1;
    private boolean d;
    private HashMap e;

    private View a(int n2) {
        View view;
        if (this.e == null) {
            this.e = new HashMap();
        }
        if ((view = (View)this.e.get((Object)n2)) == null) {
            View view2 = this.getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(n2);
            this.e.put((Object)n2, (Object)view);
        }
        return view;
    }

    private final void a() {
        LoadingView loadingView;
        LoadingView loadingView2;
        View view = this.b;
        if (view != null) {
            view.setVisibility(8);
        }
        if ((loadingView = (LoadingView)this.a(R.id.loading_view)) != null) {
            loadingView.setVisibility(0);
        }
        if ((loadingView2 = (LoadingView)this.a(R.id.loading_view)) != null) {
            loadingView2.a();
        }
        WeakReference weakReference = new WeakReference((Object)this);
        kotlinx.coroutines.e.a((y)z.a((a.b.e)((a.b.e)al.b())), (m)new m<y, a.b.c<? super l>, Object>(weakReference, null){
            Object a;
            int b;
            final /* synthetic */ WeakReference c;
            private y d;
            {
                this.c = weakReference;
                super(c2);
            }

            @Override
            public final a.b.c<l> a(Object object, a.b.c<?> c2) {
                a.e.b.d.b(c2, "completion");
                m<y, a.b.c<? super l>, Object> m2 = new /* invalid duplicate definition of identical inner class */;
                m2.d = (y)object;
                return m2;
            }

            @Override
            public final Object a(Object object) {
                a.b.a.a a2 = a.b.a.a.a;
                int n2 = this.b;
                boolean bl = true;
                switch (n2) {
                    default: {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    case 1: {
                        if (!(object instanceof g.b)) break;
                        throw ((g.b)object).a;
                    }
                    case 0: {
                        if (object instanceof g.b) {
                            throw ((g.b)object).a;
                        }
                        af af2 = kotlinx.coroutines.e.a((y)this.d, (a.b.e)((a.b.e)al.c()), (m)new m<y, a.b.c<? super i>, Object>(null){
                            int a;
                            private y b;

                            @Override
                            public final a.b.c<l> a(Object object, a.b.c<?> c2) {
                                a.e.b.d.b(c2, "completion");
                                m<y, a.b.c<? super i>, Object> m2 = new /* invalid duplicate definition of identical inner class */;
                                m2.b = (y)object;
                                return m2;
                            }

                            @Override
                            public final Object a(Object object) {
                                if (this.a != 0) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                if (object instanceof g.b) {
                                    throw ((g.b)object).a;
                                }
                                h.a();
                                return h.c();
                            }

                            @Override
                            public final Object a(Object object, Object object2) {
                                return (this.a(object, (a.b.c)object2)).a(l.a);
                            }
                        });
                        this.a = af2;
                        this.b = bl;
                        object = af2.a((a.b.c)this);
                        if (object != a2) break;
                        return a2;
                    }
                }
                i i2 = (i)object;
                ContactPickFragment contactPickFragment = (ContactPickFragment)((Object)this.c.get());
                if (contactPickFragment != null) {
                    a.e.b.d.a((Object)contactPickFragment, "it");
                    if (contactPickFragment.getView() == null) {
                        bl = false;
                    }
                    if (!Boolean.valueOf((boolean)bl).booleanValue()) {
                        contactPickFragment = null;
                    }
                    if (contactPickFragment != null) {
                        ContactPickFragment.a(contactPickFragment, i2);
                    }
                }
                return l.a;
            }

            @Override
            public final Object a(Object object, Object object2) {
                return (this.a(object, (a.b.c)object2)).a(l.a);
            }

        });
    }

    public static final /* synthetic */ void a(ContactPickFragment contactPickFragment) {
        contactPickFragment.a(false);
    }

    public static final /* synthetic */ void a(ContactPickFragment contactPickFragment, i i2) {
        boolean bl;
        if (i2 != null && !i2.a().isEmpty()) {
            c c2 = contactPickFragment.a;
            a.e.b.d.b(i2, "itemContainer");
            c2.c = i2;
            contactPickFragment.a.f();
            bl = false;
        } else {
            bl = true;
        }
        contactPickFragment.b(bl);
        LoadingView loadingView = (LoadingView)contactPickFragment.a(R.id.loading_view);
        if (loadingView != null) {
            loadingView.b();
        }
    }

    private final void a(boolean bl) {
        Context context;
        if (bl) {
            if (com.xiaomi.midrop.util.y.A()) {
                return;
            }
            com.xiaomi.midrop.util.y.B();
        }
        if ((context = this.getContext()) != null) {
            com.xiaomi.midrop.util.Locale.a a2;
            if (!(context instanceof com.xiaomi.midrop.util.Locale.a)) {
                context = null;
            }
            if ((a2 = (com.xiaomi.midrop.util.Locale.a)context) != null) {
                a2.a(new String[]{"android.permission.READ_CONTACTS"}, this.c, new a.a((ContactPickFragment)this){
                    final /* synthetic */ ContactPickFragment a;
                    {
                        this.a = contactPickFragment;
                    }

                    public final void a() {
                    }

                    public final void a(int n2) {
                        ContactPickFragment.b(this.a);
                    }
                });
            }
        }
    }

    public static final /* synthetic */ void b(ContactPickFragment contactPickFragment) {
        contactPickFragment.a();
    }

    private final void b(boolean bl) {
        View view;
        RecyclerView recyclerView;
        RelativeLayout relativeLayout = (RelativeLayout)ContactPickFragment.super.a(R.id.empty_view);
        if (relativeLayout != null) {
            int n2 = bl ? 0 : 8;
            relativeLayout.setVisibility(n2);
        }
        if ((recyclerView = (RecyclerView)ContactPickFragment.super.a(R.id.recyclerview)) != null) {
            int n3 = 0;
            if (bl) {
                n3 = 8;
            }
            recyclerView.setVisibility(n3);
        }
        if ((view = this.b) != null) {
            view.setVisibility(8);
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.getUserVisibleHint()) {
            ContactPickFragment.super.a(true);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a.e.b.d.b((Object)layoutInflater, "inflater");
        return layoutInflater.inflate(2131427434, viewGroup, false);
    }

    public final void onDestroyView() {
        if (com.xiaomi.midrop.sender.c.g.e().c(this.a)) {
            com.xiaomi.midrop.sender.c.g.e().b(this.a);
        }
        super.onDestroyView();
        if (this.e != null) {
            this.e.clear();
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        a.e.b.d.b((Object)view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView)ContactPickFragment.super.a(R.id.recyclerview);
        a.e.b.d.a((Object)recyclerView, "recyclerview");
        recyclerView.setLayoutManager((RecyclerView.i)new StickyHeaderLayoutManager());
        RecyclerView recyclerView2 = (RecyclerView)ContactPickFragment.super.a(R.id.recyclerview);
        a.e.b.d.a((Object)recyclerView2, "recyclerview");
        recyclerView2.setAdapter((RecyclerView.a)this.a);
        if (!com.xiaomi.midrop.sender.c.g.e().c(this.a)) {
            com.xiaomi.midrop.sender.c.g.e().a(this.a);
        }
        if (e.a(this.getContext(), "android.permission.READ_CONTACTS")) {
            ContactPickFragment.super.a();
        } else {
            View view2 = this.getView();
            View view3 = view2 != null ? view2.findViewById(2131296391) : null;
            if (view3 == null) {
                throw new j("null cannot be cast to non-null type android.view.ViewStub");
            }
            View view4 = ((ViewStub)view3).inflate();
            a.e.b.d.a((Object)view4, "container");
            View view5 = view4.findViewById(2131296834);
            a.e.b.d.a((Object)view5, "findViewById(id)");
            view5.setOnClickListener(new View.OnClickListener((ContactPickFragment)this){
                final /* synthetic */ ContactPickFragment a;
                {
                    this.a = contactPickFragment;
                }

                public final void onClick(View view) {
                    ContactPickFragment.a(this.a);
                }
            });
            this.b = view4;
        }
        this.d = true;
        com.xiaomi.midrop.view.a a2 = new com.xiaomi.midrop.view.a();
        ((RecyclerView)ContactPickFragment.super.a(R.id.recyclerview)).a((RecyclerView.h)a2);
    }

    public final void setUserVisibleHint(boolean bl) {
        super.setUserVisibleHint(bl);
        if (this.d) {
            ContactPickFragment.super.a(true);
        }
    }

}

