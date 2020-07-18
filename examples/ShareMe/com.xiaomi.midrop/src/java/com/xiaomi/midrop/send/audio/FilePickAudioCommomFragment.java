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
 *  java.util.Collection
 *  java.util.List
 */
package com.xiaomi.midrop.send.audio;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.aq;
import android.view.View;
import com.xiaomi.midrop.b.a.d;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.send.audio.a;
import com.xiaomi.midrop.send.base.FilePickBaseListFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilePickAudioCommomFragment
extends FilePickBaseListFragment<List<g>> {
    private List<g> h = new ArrayList();

    static /* synthetic */ List a(FilePickAudioCommomFragment filePickAudioCommomFragment) {
        return filePickAudioCommomFragment.h;
    }

    @Override
    protected final com.xiaomi.midrop.send.base.a a() {
        return new com.xiaomi.midrop.send.base.a(7);
    }

    @Override
    protected final /* synthetic */ List a(Object object) {
        List list = (List)object;
        if (list != null && !list.isEmpty()) {
            this.h.clear();
            this.h.addAll((Collection)list);
            List<g> list2 = this.h;
            a.e.b.d.b(list2, "dada");
            a.a.a(list2, a.a.a());
            ArrayList arrayList = new ArrayList();
            arrayList.add((Object)i.a(this.h));
            return arrayList;
        }
        return null;
    }

    @Override
    protected final com.xiaomi.midrop.b.a.a<List<g>> c() {
        return new d(this.getContext());
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((aq)this.a.getItemAnimator()).m = false;
    }
}

