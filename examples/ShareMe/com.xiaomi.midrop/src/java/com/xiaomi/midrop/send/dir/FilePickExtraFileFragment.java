/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.util.SparseIntArray
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.List
 */
package com.xiaomi.midrop.send.dir;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.SparseIntArray;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.b.h;
import com.xiaomi.midrop.b.i;
import com.xiaomi.midrop.send.base.FilePickBaseGroupListFragment;
import com.xiaomi.midrop.util.f;
import com.xiaomi.midrop.view.LoadingView;
import java.lang.ref.WeakReference;
import java.util.List;

public class FilePickExtraFileFragment
extends FilePickBaseGroupListFragment<List<i>> {
    private int h;
    private SparseIntArray i = new SparseIntArray();

    static /* synthetic */ void a(FilePickExtraFileFragment filePickExtraFileFragment, List list) {
        boolean bl;
        if (list != null && !list.isEmpty()) {
            filePickExtraFileFragment.c.c((List<i>)list);
            filePickExtraFileFragment.c.f();
            bl = false;
        } else {
            bl = true;
        }
        filePickExtraFileFragment.a(bl);
        filePickExtraFileFragment.b.setVisibility(8);
    }

    @Override
    protected final com.xiaomi.midrop.send.base.a a() {
        return new com.xiaomi.midrop.send.base.a(1);
    }

    @Override
    protected final void b() {
        this.b.a();
        new AsyncTask<Integer, Object, List<i>>(this, this.h, this.i.get(this.h)){
            private int a;
            private int b;
            private WeakReference<FilePickExtraFileFragment> c;
            {
                this.c = new WeakReference((Object)filePickExtraFileFragment);
                this.a = n2;
                this.b = n3;
            }

            protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                if (this.c.get() != null) {
                    return f.b(h.a().a(this.a), this.b);
                }
                return null;
            }

            protected final /* synthetic */ void onPostExecute(Object object) {
                List list = (List)object;
                FilePickExtraFileFragment filePickExtraFileFragment = (FilePickExtraFileFragment)((Object)this.c.get());
                if (filePickExtraFileFragment != null) {
                    FilePickExtraFileFragment.a(filePickExtraFileFragment, list);
                }
            }
        }.execute((Object[])new Integer[0]);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onCreate(Bundle bundle) {
        block3 : {
            block2 : {
                super.onCreate(bundle);
                if (bundle != null) break block2;
                if (this.getArguments() == null) break block3;
                bundle = this.getArguments();
            }
            this.h = bundle.getInt("TypeExtraFile");
        }
        this.i.put(5, 2131689667);
        this.i.put(8, 2131689664);
        this.i.put(9, 2131689668);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("TypeExtraFile", this.h);
    }

}

