/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.PackageInfo
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.support.v4.app.g
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.view.View
 *  de.greenrobot.event.c
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 */
package com.xiaomi.midrop.received;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.received.ReceivedActivity;
import com.xiaomi.midrop.send.base.FilePickBaseGroupListFragment;
import com.xiaomi.midrop.util.f;
import com.xiaomi.midrop.util.j;
import com.xiaomi.midrop.util.x;
import com.xiaomi.midrop.util.z;
import com.xiaomi.midrop.view.LoadingView;
import de.greenrobot.event.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ReceivedFragment
extends FilePickBaseGroupListFragment {
    private static final SparseIntArray j;
    private int h;
    private com.xiaomi.midrop.received.b i;
    private b k;

    static {
        SparseIntArray sparseIntArray;
        j = sparseIntArray = new SparseIntArray();
        sparseIntArray.append(4, 2);
        j.append(2, 10);
        j.append(3, 7);
        j.append(1, 3);
        j.append(7, 1);
    }

    public static ReceivedFragment a(int n2) {
        ReceivedFragment receivedFragment = new ReceivedFragment();
        receivedFragment.h = n2;
        return receivedFragment;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(List<g> list, boolean bl) {
        ArrayList arrayList;
        block14 : {
            ArrayList arrayList2;
            Iterator iterator;
            ArrayList arrayList3;
            ArrayList arrayList4;
            block13 : {
                block9 : {
                    int n2;
                    block10 : {
                        block12 : {
                            block11 : {
                                if (this.getView() == null || this.getActivity() == null || this.getActivity().isFinishing() || this.getActivity().isDestroyed() || this.b == null) break block9;
                                if (this.i == null) {
                                    return;
                                }
                                this.b.setVisibility(8);
                                n2 = 1;
                                if (list == null || list.isEmpty()) break block10;
                                if (this.h != 2) break block11;
                                n2 = 4;
                                break block12;
                            }
                            if (this.h != n2) break block12;
                            arrayList = new ArrayList();
                            arrayList4 = new ArrayList();
                            arrayList2 = new ArrayList();
                            arrayList3 = new ArrayList();
                            iterator = list.iterator();
                            break block13;
                        }
                        arrayList = f.a(list, n2);
                        break block14;
                    }
                    this.a((boolean)n2);
                }
                return;
            }
            block5 : while (iterator.hasNext()) {
                g g2 = (g)iterator.next();
                switch (g2.E) {
                    default: {
                        continue block5;
                    }
                    case 2: {
                        arrayList2.add((Object)g2);
                        continue block5;
                    }
                    case 1: {
                        arrayList4.add((Object)g2);
                        continue block5;
                    }
                    case 0: 
                }
                arrayList3.add((Object)g2);
            }
            ArrayList arrayList5 = new ArrayList();
            arrayList5.add((Object)arrayList4);
            arrayList5.add((Object)arrayList2);
            arrayList5.add((Object)arrayList3);
            int[] arrn = new int[]{2131689513, 2131689514, 2131689512};
            for (int i2 = 0; i2 < arrayList5.size(); ++i2) {
                f.a((List<i>)arrayList, (List<g>)((List)arrayList5.get(i2)), arrn[i2]);
            }
        }
        com.xiaomi.midrop.received.b b2 = this.i;
        boolean bl2 = this.getActivity() instanceof ReceivedActivity ? ((ReceivedActivity)this.getActivity()).b() : false;
        b2.a(bl2);
        this.i.c((List<i>)arrayList);
        this.i.f();
        if (bl && this.getActivity() instanceof ReceivedActivity) {
            ((ReceivedActivity)this.getActivity()).a(this.h, list);
        }
        this.a(false);
    }

    @Override
    protected final com.xiaomi.midrop.send.base.a a() {
        this.i = new com.xiaomi.midrop.received.b((Context)this.getActivity(), j.get(this.h));
        return this.i;
    }

    @Override
    protected final void b() {
        if (this.getActivity() instanceof ReceivedActivity) {
            ReceivedActivity receivedActivity = (ReceivedActivity)this.getActivity();
            int n2 = this.h;
            boolean bl = receivedActivity.a.indexOfKey(n2) >= 0;
            if (bl) {
                int n3 = this.h;
                this.a((List<g>)((List)receivedActivity.a.get(n3)), false);
                return;
            }
            new AsyncTask<Integer, List<g>, List<g>>(this, this.h, true){
                private Integer a;
                private WeakReference<ReceivedFragment> b;
                private HashMap<String, PackageInfo> c = new HashMap();
                private boolean d;
                {
                    this.b = new WeakReference((Object)receivedFragment);
                    this.a = n2;
                    this.d = bl;
                }

                protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                    if (this.b.get() != null) {
                        List<g> list = z.a(MiDropApplication.a(), (int)this.a);
                        if (this.a == 1) {
                            List<PackageInfo> list2 = x.a();
                            this.c.clear();
                            for (PackageInfo packageInfo : list2) {
                                this.c.put((Object)packageInfo.packageName, (Object)packageInfo);
                            }
                            int n2 = list.size();
                            ArrayList arrayList = new ArrayList();
                            for (int i2 = 0; i2 < n2; ++i2) {
                                g g2 = (g)list.get(i2);
                                com.xiaomi.midrop.util.a.a(g2, this.c);
                                if (!this.d || n2 < 15 || i2 >= 15) continue;
                                arrayList.add((Object)g2);
                                if (i2 != 14) continue;
                                this.publishProgress((Object[])new List[]{arrayList});
                            }
                        } else if (this.a == 4) {
                            for (g g3 : list) {
                                if (g3.v != 0L) continue;
                                g3.v = j.h(g3.i);
                            }
                        }
                        return list;
                    }
                    return null;
                }

                protected final /* synthetic */ void onPostExecute(Object object) {
                    List list = (List)object;
                    if (this.b.get() != null) {
                        ((ReceivedFragment)((Object)this.b.get())).a((List<g>)list, true);
                    }
                }

                protected final /* synthetic */ void onProgressUpdate(Object[] arrobject) {
                    Object[] arrobject2 = (List[])arrobject;
                    super.onProgressUpdate(arrobject2);
                    Object object = arrobject2[0];
                    if (this.b.get() != null) {
                        ((ReceivedFragment)((Object)this.b.get())).a((List<g>)((List)object), false);
                    }
                }
            }.execute((Object[])new Integer[0]);
            this.b.a();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.h = bundle.getInt("fragment_type");
        }
        if (this.h == 1) {
            this.k = new BroadcastReceiver((ReceivedFragment)this, 0){
                final /* synthetic */ ReceivedFragment a;
                {
                    this.a = receivedFragment;
                }

                public final void onReceive(Context context, Intent intent) {
                    if (intent != null) {
                        if (intent.getAction() == null) {
                            return;
                        }
                        if (this.a.h == 1) {
                            new /* invalid duplicate definition of identical inner class */.execute((Object[])new Integer[0]);
                        }
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme("package");
            if (this.getActivity() != null) {
                this.getActivity().registerReceiver((BroadcastReceiver)this.k, intentFilter);
            }
        }
    }

    public void onDestroy() {
        if (this.getActivity() != null && this.k != null) {
            this.getActivity().unregisterReceiver((BroadcastReceiver)this.k);
        }
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onEvent(com.xiaomi.midrop.received.a.a a2) {
        if (this.i != null) {
            this.i.a(a2.a);
        }
    }

    public void onEvent(com.xiaomi.midrop.received.a.b b2) {
        if (this.i != null) {
            this.b();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("fragment_type", this.h);
    }

    public void onStart() {
        super.onStart();
        c.a().a((Object)this);
    }

    public void onStop() {
        super.onStop();
        c.a().b((Object)this);
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

}

