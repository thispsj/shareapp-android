/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$b
 *  android.support.v7.widget.RecyclerView$i
 *  android.support.v7.widget.RecyclerView$m
 *  android.text.Editable
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.EditText
 *  android.widget.TextView
 *  android.widget.TextView$OnEditorActionListener
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.Executor
 */
package com.xiaomi.midrop.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.h;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.e;
import com.xiaomi.midrop.search.SearchActivity;
import com.xiaomi.midrop.search.a;
import com.xiaomi.midrop.sender.c.b;
import com.xiaomi.midrop.sender.c.g;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.util.j;
import com.xiaomi.midrop.util.q;
import com.xiaomi.midrop.view.stickadapter.StickyHeaderLayoutManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class SearchActivity
extends com.xiaomi.midrop.util.Locale.a
implements g.a {
    private SparseArray<List<g>> a = new SparseArray();
    private com.xiaomi.midrop.search.a b;
    private List<i> c = new ArrayList();
    private CountDownLatch d = new CountDownLatch(4);
    private int[] e = new int[]{260, 261, 259, 262, 258};
    private SparseIntArray f = new SparseIntArray();
    private SparseIntArray g = new SparseIntArray();
    private List<Integer> h = new ArrayList();
    private b i;
    private a j;
    private String k;
    private int l;
    private String m;
    private TextView n;
    private List<g> o;
    private List<g> p;
    private h.a q = new h.a(this){
        final /* synthetic */ SearchActivity a;
        {
            this.a = searchActivity;
        }

        public final void a(int n2, List<g> arrayList) {
            SearchActivity.e(this.a).countDown();
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            if (n2 != 1 && n2 != 11) {
                SearchActivity.h(this.a).put(n2, (Object)arrayList);
                return;
            }
            if (n2 == 1) {
                SearchActivity.a(this.a, (List)arrayList);
            } else {
                SearchActivity.b(this.a, (List)arrayList);
            }
            if (SearchActivity.f(this.a) != null && SearchActivity.g(this.a) != null) {
                ArrayList arrayList2 = new ArrayList((Collection)SearchActivity.f(this.a));
                arrayList2.addAll((Collection)SearchActivity.g(this.a));
                SearchActivity.h(this.a).put(1, (Object)arrayList2);
            }
        }
    };

    static /* synthetic */ String a(SearchActivity searchActivity, int n2) {
        Resources resources;
        int n3;
        switch (n2) {
            default: {
                return "";
            }
            case 4: {
                resources = searchActivity.getResources();
                n3 = 2131689556;
                break;
            }
            case 3: {
                resources = searchActivity.getResources();
                n3 = 2131689554;
                break;
            }
            case 2: {
                resources = searchActivity.getResources();
                n3 = 2131689555;
                break;
            }
            case 1: {
                resources = searchActivity.getResources();
                n3 = 2131689553;
            }
        }
        return resources.getString(n3);
    }

    static /* synthetic */ List a(SearchActivity searchActivity, List list) {
        searchActivity.o = list;
        return list;
    }

    static /* synthetic */ void a(SearchActivity searchActivity) {
        h.a().a(2, searchActivity.q);
        h.a().a(4, searchActivity.q);
        h.a().a(3, searchActivity.q);
        h.a().a(1, searchActivity.q);
        h.a().a(11, searchActivity.q);
    }

    static /* synthetic */ void a(SearchActivity searchActivity, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager)searchActivity.getSystemService("input_method");
        if (inputMethodManager.isActive() && view.getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    static /* synthetic */ void a(SearchActivity searchActivity, String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            if (searchActivity.i != null) {
                searchActivity.i.cancel(true);
                searchActivity.i = null;
            }
            searchActivity.i = new AsyncTask<Void, Void, List<i>>(searchActivity, string2, searchActivity.a, searchActivity.h){
                private String a;
                private WeakReference<SearchActivity> b;
                private SparseArray<List<g>> c;
                private List<Integer> d;
                {
                    this.a = string2;
                    this.b = new WeakReference((Object)searchActivity);
                    this.c = sparseArray;
                    this.d = list;
                }

                protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                    ArrayList arrayList = new ArrayList();
                    SearchActivity searchActivity = (SearchActivity)this.b.get();
                    if (searchActivity != null && !searchActivity.isDestroyed()) {
                        if (searchActivity.isFinishing()) {
                            return arrayList;
                        }
                        Iterator iterator = this.d.iterator();
                        while (iterator.hasNext()) {
                            int n2 = (Integer)iterator.next();
                            int n3 = searchActivity.f.get(n2);
                            if (this.c.get(n3) == null || ((List)this.c.get(n3)).isEmpty()) continue;
                            List list = (List)this.c.get(n3);
                            ArrayList arrayList2 = new ArrayList();
                            for (g g2 : list) {
                                String string2;
                                if (TextUtils.isEmpty((CharSequence)g2.k)) continue;
                                if (n3 == 1 && g2.k.contains((CharSequence)"base")) {
                                    g2.k = j.a((Context)searchActivity, g2.i);
                                }
                                if (TextUtils.isEmpty((CharSequence)g2.k) || !(string2 = g2.k.toLowerCase()).contains((CharSequence)this.a.toLowerCase()) && !string2.replaceAll(" ", "").contains((CharSequence)this.a.toLowerCase())) continue;
                                g2.g = n3;
                                arrayList2.add((Object)g2);
                            }
                            if (arrayList2.isEmpty()) continue;
                            arrayList.add((Object)i.a(n3, SearchActivity.a(searchActivity, n3), (List<g>)arrayList2));
                        }
                    }
                    return arrayList;
                }

                protected final /* synthetic */ void onPostExecute(Object object) {
                    List list = (List)object;
                    super.onPostExecute((Object)list);
                    SearchActivity searchActivity = (SearchActivity)this.b.get();
                    if (searchActivity != null && !searchActivity.isDestroyed()) {
                        if (searchActivity.isFinishing()) {
                            return;
                        }
                        SearchActivity.a(searchActivity, list, false);
                    }
                }
            };
            searchActivity.i.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
        } else {
            searchActivity.c.clear();
            searchActivity.b.c = "";
            searchActivity.b.a(searchActivity.c);
        }
        if (TextUtils.isEmpty((CharSequence)string2)) {
            searchActivity.findViewById(2131296557).setVisibility(8);
            return;
        }
        searchActivity.findViewById(2131296557).setVisibility(0);
    }

    static /* synthetic */ void a(SearchActivity searchActivity, List list, boolean bl) {
        String string2 = ((EditText)searchActivity.findViewById(2131296713)).getText().toString().trim();
        if (searchActivity.c != null) {
            if (!bl) {
                searchActivity.c.clear();
                searchActivity.c.addAll((Collection)list);
                searchActivity.b.c = string2;
                searchActivity.b.a(searchActivity.c);
                if (searchActivity.j != null) {
                    searchActivity.j.cancel(true);
                    searchActivity.j = null;
                }
                searchActivity.j = new AsyncTask<String, Void, List<i>>(searchActivity, TextUtils.equals((CharSequence)searchActivity.m, (CharSequence)"from_webshare")){
                    private WeakReference<SearchActivity> a;
                    private boolean b;
                    {
                        this.a = new WeakReference((Object)searchActivity);
                        this.b = bl;
                    }

                    protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                        String string2 = ((String[])arrobject)[0];
                        ArrayList arrayList = new ArrayList();
                        List<g> list = h.a().a(string2);
                        Iterator iterator = list.iterator();
                        while (iterator.hasNext()) {
                            g g2 = (g)iterator.next();
                            if (!new File(g2.i).isDirectory()) continue;
                            if (this.b) {
                                iterator.remove();
                                continue;
                            }
                            g2.g = 7;
                        }
                        SearchActivity searchActivity = (SearchActivity)this.a.get();
                        if (!(list.isEmpty() || searchActivity == null || searchActivity.isFinishing() || searchActivity.isDestroyed())) {
                            arrayList.add((Object)i.a(7, searchActivity.getResources().getString(2131689786), list));
                        }
                        return arrayList;
                    }

                    protected final /* synthetic */ void onPostExecute(Object object) {
                        List list = (List)object;
                        super.onPostExecute((Object)list);
                        SearchActivity searchActivity = (SearchActivity)this.a.get();
                        if (searchActivity != null && !searchActivity.isFinishing() && !searchActivity.isDestroyed()) {
                            SearchActivity.a(searchActivity, list, true);
                        }
                    }
                };
                searchActivity.j.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new String[]{string2});
                return;
            }
            if ((Integer)searchActivity.h.get(0) != 262 && !searchActivity.c.isEmpty()) {
                if (((i)searchActivity.c.get((int)(searchActivity.c.size() - 1))).d == 2) {
                    searchActivity.c.addAll(searchActivity.c.size() - 1, (Collection)list);
                } else {
                    searchActivity.c.addAll((Collection)list);
                }
            } else {
                searchActivity.c.addAll(0, (Collection)list);
            }
            searchActivity.b.c = string2;
            searchActivity.b.a(searchActivity.c);
            if (searchActivity.c.isEmpty()) {
                searchActivity.findViewById(2131296685).setVisibility(0);
            } else {
                searchActivity.findViewById(2131296685).setVisibility(8);
            }
            af.a a2 = searchActivity.c.isEmpty() ? af.a.bR : af.a.bQ;
            af.a(a2).a();
        }
    }

    static /* synthetic */ void a(SearchActivity searchActivity, boolean bl) {
        af af2 = af.a(af.a.bS).a(af.b.B, searchActivity.k);
        af.b b2 = af.b.C;
        String string2 = bl ? "true" : "false";
        af2.a(b2, string2).a();
    }

    static /* synthetic */ SparseIntArray b(SearchActivity searchActivity) {
        return searchActivity.g;
    }

    static /* synthetic */ List b(SearchActivity searchActivity, List list) {
        searchActivity.p = list;
        return list;
    }

    private void b() {
        int n2 = com.xiaomi.midrop.sender.c.g.e().a();
        if (n2 > 99) {
            this.n.setText((CharSequence)this.getString(2131689750));
        } else {
            TextView textView = this.n;
            Object[] arrobject = new Object[]{n2};
            textView.setText((CharSequence)this.getString(2131689877, arrobject));
        }
        this.n.setEnabled(true ^ com.xiaomi.midrop.sender.c.g.e().b());
        this.findViewById(2131296889).setEnabled(true ^ com.xiaomi.midrop.sender.c.g.e().b());
        this.b.a.b();
    }

    static /* synthetic */ int c(SearchActivity searchActivity) {
        return searchActivity.l;
    }

    static /* synthetic */ String d(SearchActivity searchActivity) {
        return searchActivity.m;
    }

    static /* synthetic */ CountDownLatch e(SearchActivity searchActivity) {
        return searchActivity.d;
    }

    static /* synthetic */ List f(SearchActivity searchActivity) {
        return searchActivity.o;
    }

    static /* synthetic */ List g(SearchActivity searchActivity) {
        return searchActivity.p;
    }

    static /* synthetic */ SparseArray h(SearchActivity searchActivity) {
        return searchActivity.a;
    }

    @Override
    public final void a(String string2, List<g> list) {
    }

    @Override
    public final void a(List<g> list) {
        SearchActivity.super.b();
    }

    public void animate(View view) {
        q.a((Context)this, view, (View)this.n);
    }

    @Override
    public final void b(List<g> list) {
        SearchActivity.super.b();
    }

    @Override
    public final void h_() {
        this.b();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    protected void onCreate(Bundle var1) {
        super.onCreate(var1);
        this.setContentView(2131427375);
        ag.a((Activity)this, this.getResources().getColor(2131099891));
        this.findViewById(2131296283).setBackgroundColor(this.getResources().getColor(2131099891));
        if (ac.c((Context)this)) {
            this.findViewById(2131296487).setRotation(180.0f);
        }
        var2_2 = (EditText)this.findViewById(2131296713);
        var2_2.setFocusableInTouchMode(true);
        var2_2.requestFocus();
        var2_2.addTextChangedListener(new TextWatcher((SearchActivity)this){
            final /* synthetic */ SearchActivity a;
            {
                this.a = searchActivity;
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
            }

            public final void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
                SearchActivity.a(this.a, charSequence.toString().trim());
            }
        });
        var2_2.setImeOptions(3);
        var2_2.setOnEditorActionListener(new TextView.OnEditorActionListener((SearchActivity)this){
            final /* synthetic */ SearchActivity a;
            {
                this.a = searchActivity;
            }

            public final boolean onEditorAction(TextView textView, int n2, android.view.KeyEvent keyEvent) {
                if (n2 == 0 || n2 == 6 || n2 == 3) {
                    textView.clearFocus();
                    SearchActivity.a(this.a, (View)textView);
                }
                return true;
            }
        });
        this.b = new com.xiaomi.midrop.search.a((Context)this);
        var4_3 = (RecyclerView)this.findViewById(2131296675);
        var4_3.setLayoutManager((RecyclerView.i)new StickyHeaderLayoutManager());
        var4_3.setAdapter((RecyclerView.a)this.b);
        var4_3.setOnTouchListener(new View.OnTouchListener((SearchActivity)this, var4_3){
            final /* synthetic */ RecyclerView a;
            final /* synthetic */ SearchActivity b;
            {
                this.b = searchActivity;
                this.a = recyclerView;
            }

            public final boolean onTouch(View view, android.view.MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    SearchActivity.a(this.b, (View)this.a);
                }
                return false;
            }
        });
        var4_3.a(new RecyclerView.m((SearchActivity)this){
            final /* synthetic */ SearchActivity a;
            {
                this.a = searchActivity;
            }

            public final void a(RecyclerView recyclerView, int n2) {
                super.a(recyclerView, n2);
                if (n2 != 0) {
                    SearchActivity.a(this.a, (View)recyclerView);
                }
            }
        });
        this.b.e = new a.c((SearchActivity)this){
            final /* synthetic */ SearchActivity a;
            {
                this.a = searchActivity;
            }

            public final void a(g g2) {
                SearchActivity searchActivity = this.a;
                boolean bl = SearchActivity.b(this.a).get(g2.g) == SearchActivity.c(this.a);
                SearchActivity.a(searchActivity, bl);
            }
        };
        this.findViewById(2131296487).setOnClickListener(new View.OnClickListener((SearchActivity)this){
            final /* synthetic */ SearchActivity a;
            {
                this.a = searchActivity;
            }

            public void onClick(View view) {
                this.a.onBackPressed();
            }
        });
        this.findViewById(2131296557).setOnClickListener(new View.OnClickListener((SearchActivity)this){
            final /* synthetic */ SearchActivity a;
            {
                this.a = searchActivity;
            }

            public void onClick(View view) {
                ((EditText)this.a.findViewById(2131296713)).setText((CharSequence)"");
                this.a.findViewById(2131296557).setVisibility(8);
            }
        });
        this.n = (TextView)this.findViewById(2131296842);
        this.n.setOnClickListener(new View.OnClickListener((SearchActivity)this){
            final /* synthetic */ SearchActivity a;
            {
                this.a = searchActivity;
            }

            /*
             * Exception decompiling
             */
            public void onClick(}
        java.lang.IllegalStateException: Parameters not created
        
        