/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$f
 *  android.support.v7.widget.aq
 *  android.view.View
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Comparator
 *  java.util.List
 *  java.util.TreeMap
 */
package com.xiaomi.midrop.send.video;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.aq;
import android.view.View;
import com.xiaomi.midrop.b.a.l;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.send.base.FilePickBaseGroupListFragment;
import com.xiaomi.midrop.send.base.FilePickBaseListFragment;
import com.xiaomi.midrop.send.base.a;
import com.xiaomi.midrop.sender.c.f;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class FilePickVideoListGroupFragment
extends FilePickBaseGroupListFragment<TreeMap<String, List<g>>> {
    @Override
    protected final a a() {
        return new a(12);
    }

    @Override
    protected final /* synthetic */ List a(Object object) {
        return this.a((TreeMap<String, List<g>>)((TreeMap)object), f.b());
    }

    @Override
    protected final com.xiaomi.midrop.b.a.a<TreeMap<String, List<g>>> c() {
        return new l();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((aq)this.a.getItemAnimator()).m = false;
    }
}

