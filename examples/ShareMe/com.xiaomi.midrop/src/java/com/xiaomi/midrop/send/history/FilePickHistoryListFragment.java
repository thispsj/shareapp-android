/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$c
 *  android.text.TextUtils
 *  android.view.View
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.midrop.send.history;

import a.e.b.d;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import com.google.a.e;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.db.TransferHistoryDatabase;
import com.xiaomi.midrop.send.base.FilePickBaseGroupListFragment;
import com.xiaomi.midrop.send.history.FilePickHistoryListFragment;
import com.xiaomi.midrop.util.f;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class FilePickHistoryListFragment
extends FilePickBaseGroupListFragment<List<? extends i>> {
    public static final a i = new Object(0){};
    public com.xiaomi.midrop.send.history.a h;
    private List<com.xiaomi.midrop.db.b.a> j = (List)new ArrayList();
    private HashMap k;

    public static final /* synthetic */ void a(FilePickHistoryListFragment filePickHistoryListFragment, boolean bl) {
        filePickHistoryListFragment.a(bl);
    }

    @Override
    protected final com.xiaomi.midrop.send.base.a a() {
        Bundle bundle;
        Context context = this.getContext();
        if (context == null) {
            d.a();
        }
        d.a((Object)context, "context!!");
        com.xiaomi.midrop.send.history.a a2 = this.h = new com.xiaomi.midrop.send.history.a(context);
        if (a2 == null) {
            d.a("adapter");
        }
        String string2 = (bundle = this.getArguments()) != null ? bundle.getString("from") : null;
        a2.d = true ^ TextUtils.equals((CharSequence)string2, (CharSequence)"from_webshare");
        com.xiaomi.midrop.send.history.a a3 = this.h;
        if (a3 == null) {
            d.a("adapter");
        }
        return a3;
    }

    public final void a(List<com.xiaomi.midrop.db.b.a> list) {
        d.b(list, "data");
        if (!list.isEmpty()) {
            this.j.clear();
            this.j.addAll((Collection)list);
            this.a(false);
            com.xiaomi.midrop.send.history.a a2 = this.h;
            if (a2 == null) {
                d.a("adapter");
            }
            List<com.xiaomi.midrop.db.b.a> list2 = this.j;
            d.b(list2, "sections");
            a2.c.clear();
            a2.c.addAll((Collection)list2);
            a2.f();
            return;
        }
        this.a(true);
    }

    @Override
    public final void b() {
        new AsyncTask<Void, Void, List<com.xiaomi.midrop.db.b.a>>(this){
            private List<com.xiaomi.midrop.db.b.a> a;
            private WeakReference<FilePickHistoryListFragment> b;
            private FilePickHistoryListFragment c;
            {
                d.b((Object)filePickHistoryListFragment, "fragment");
                this.c = filePickHistoryListFragment;
                this.a = (List)new ArrayList();
                this.b = new WeakReference((Object)this.c);
            }

            private /* varargs */ List<com.xiaomi.midrop.db.b.a> a(Void ... arrvoid) {
                d.b(arrvoid, "params");
                try {
                    TransferHistoryDatabase transferHistoryDatabase = TransferHistoryDatabase.i();
                    d.a((Object)transferHistoryDatabase, "TransferHistoryDatabase.getInstance()");
                    com.xiaomi.midrop.db.a.a a2 = transferHistoryDatabase.j();
                    d.a((Object)a2, "TransferHistoryDatabase.getInstance().transItemDao");
                    List<com.xiaomi.midrop.db.b.a> list = a2.a();
                    if (!list.isEmpty()) {
                        this.a.addAll((Collection)list);
                        Iterator iterator = this.a.iterator();
                        while (iterator.hasNext()) {
                            com.xiaomi.midrop.db.b.a a3 = (com.xiaomi.midrop.db.b.a)iterator.next();
                            String string2 = a3.d();
                            Type type = new com.google.a.c.a<List<? extends g>>(){}.b;
                            List list2 = (List)new e().a(string2, type);
                            List<g> list3 = f.a((List<g>)list2);
                            a3.a(list3);
                            a3.b((List<g>)list2);
                            if (!list3.isEmpty()) continue;
                            iterator.remove();
                        }
                    }
                }
                catch (Exception exception) {
                    new StringBuilder("Exception while getting data from db for history =").append((Object)exception);
                }
                return this.a;
            }

            public final /* synthetic */ Object doInBackground(Object[] arrobject) {
                return b.super.a((Void[])arrobject);
            }

            public final /* synthetic */ void onPostExecute(Object object) {
                super.onPostExecute((Object)((List)object));
                FilePickHistoryListFragment filePickHistoryListFragment = (FilePickHistoryListFragment)((Object)this.b.get());
                if (filePickHistoryListFragment != null) {
                    filePickHistoryListFragment.a(this.a);
                }
            }
        }.execute((Object[])new Void[0]);
    }

    @Override
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        if (this.k != null) {
            this.k.clear();
        }
    }

    @Override
    public final void onViewCreated(View view, Bundle bundle) {
        d.b((Object)view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = this.e();
        d.a((Object)recyclerView, "recyclerView");
        View view2 = (View)recyclerView;
        int n2 = Color.parseColor((String)"#efefef");
        d.b((Object)view2, "$receiver");
        view2.setBackgroundColor(n2);
        com.xiaomi.midrop.send.history.a a2 = this.h;
        if (a2 == null) {
            d.a("adapter");
        }
        a2.a(new RecyclerView.c((FilePickHistoryListFragment)this){
            final /* synthetic */ FilePickHistoryListFragment a;
            {
                this.a = filePickHistoryListFragment;
            }

            public final void a() {
                super.a();
                FilePickHistoryListFragment filePickHistoryListFragment = this.a;
                com.xiaomi.midrop.send.history.a a2 = this.a.h;
                if (a2 == null) {
                    d.a("adapter");
                }
                FilePickHistoryListFragment.a(filePickHistoryListFragment, a2.c.isEmpty());
            }
        });
    }

}

