/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$i
 *  android.view.View
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.List
 */
package com.xiaomi.midrop.send.img;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.xiaomi.midrop.b.a.j;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.send.base.FilePickBaseListFragment;
import com.xiaomi.midrop.send.base.a;
import com.xiaomi.midrop.view.stickadapter.StickyHeaderLayoutManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FilePickImageTimeFragment
extends FilePickBaseListFragment<List<i>> {
    @Override
    protected final a a() {
        return new a(10);
    }

    @Override
    protected final /* synthetic */ List a(Object object) {
        List list = (List)object;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = null;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            i i3 = (i)list.get(i2);
            if (i3.d == 0) {
                arrayList2 = new ArrayList();
                i i4 = i.a(i3.c, i3, (List<g>)arrayList2);
                arrayList.add((Object)i4);
                i4.a = i3.b;
                continue;
            }
            if (arrayList2 == null) continue;
            arrayList2.add((Object)i3);
        }
        for (int i5 = 0; i5 < arrayList.size(); ++i5) {
            List<g> list2 = ((i)arrayList.get((int)i5)).b;
            if (i5 >= -1 + arrayList.size() || list2 == null || list2.isEmpty()) continue;
            this.e.add(list2.get(0));
            this.f.add(list2.get(-1 + list2.size()));
        }
        return arrayList;
    }

    @Override
    protected final com.xiaomi.midrop.b.a.a<List<i>> c() {
        this.getContext();
        return new j();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.a.setLayoutManager((RecyclerView.i)new StickyHeaderLayoutManager());
    }
}

