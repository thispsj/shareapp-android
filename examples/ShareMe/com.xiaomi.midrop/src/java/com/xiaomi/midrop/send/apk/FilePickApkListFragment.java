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
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.send.apk;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.aq;
import android.view.View;
import com.xiaomi.midrop.b.a.b;
import com.xiaomi.midrop.b.a.c;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.send.base.FilePickBaseGroupListFragment;
import com.xiaomi.midrop.send.base.FilePickBaseListFragment;
import com.xiaomi.midrop.send.base.a;
import java.util.List;

public class FilePickApkListFragment
extends FilePickBaseGroupListFragment<List<i>> {
    private int h = 0;

    @Override
    protected final a a() {
        if (this.h == 0) {
            return new a(13);
        }
        return new a(3);
    }

    @Override
    protected final com.xiaomi.midrop.b.a.a<List<i>> c() {
        if (this.h == 0) {
            this.getContext();
            return new c();
        }
        return new b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.h = bundle.getInt("fragment_apk_type");
            return;
        }
        if (this.getArguments() != null) {
            this.h = this.getArguments().getInt("fragment_apk_type");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("fragment_apk_type", this.h);
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((aq)this.a.getItemAnimator()).m = false;
    }
}

