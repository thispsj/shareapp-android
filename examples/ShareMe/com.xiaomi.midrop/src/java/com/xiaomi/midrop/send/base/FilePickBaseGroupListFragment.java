/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$i
 *  java.lang.Object
 */
package com.xiaomi.midrop.send.base;

import android.support.v7.widget.RecyclerView;
import com.xiaomi.midrop.send.base.FilePickBaseListFragment;
import com.xiaomi.midrop.view.stickadapter.StickyHeaderLayoutManager;

public abstract class FilePickBaseGroupListFragment<T>
extends FilePickBaseListFragment<T> {
    @Override
    protected final RecyclerView.i d() {
        return new StickyHeaderLayoutManager();
    }
}

