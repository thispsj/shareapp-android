/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$f
 *  android.support.v7.widget.aq
 *  android.view.View
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
package com.xiaomi.midrop.send.video;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.aq;
import android.view.View;
import com.xiaomi.midrop.b.a.m;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.send.base.FilePickBaseListFragment;
import com.xiaomi.midrop.send.base.a;
import java.util.ArrayList;
import java.util.List;

public class FilePickVideoFragment
extends FilePickBaseListFragment<List<g>> {
    @Override
    protected final a a() {
        return new a(2);
    }

    @Override
    protected final /* synthetic */ List a(Object object) {
        List list = (List)object;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Object)i.a((List<g>)list));
            return arrayList;
        }
        return null;
    }

    @Override
    protected final com.xiaomi.midrop.b.a.a<List<g>> c() {
        this.getContext();
        return new m();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((aq)this.a.getItemAnimator()).m = false;
    }
}

