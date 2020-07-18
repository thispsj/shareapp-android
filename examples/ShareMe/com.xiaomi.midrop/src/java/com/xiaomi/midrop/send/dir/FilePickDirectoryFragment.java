/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$b
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.send.dir;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.midrop.sender.c.b;
import com.xiaomi.midrop.sender.c.g;
import com.xiaomi.midrop.sender.fragment.BasePickFragment;
import com.xiaomi.midrop.sender.ui.d;
import com.xiaomi.midrop.util.y;
import com.xiaomi.midrop.view.DirNavigationView;
import java.io.File;
import java.util.List;

public class FilePickDirectoryFragment
extends BasePickFragment {
    protected DirNavigationView a;
    private int c;
    private String d;
    private String e;

    public static FilePickDirectoryFragment b(int n2) {
        FilePickDirectoryFragment filePickDirectoryFragment = new FilePickDirectoryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("directory_type", n2 - 1);
        filePickDirectoryFragment.setArguments(bundle);
        return filePickDirectoryFragment;
    }

    @Override
    public final void a(List<com.xiaomi.midrop.b.g> list) {
        this.b();
    }

    public void b() {
        if (this.a != null) {
            DirNavigationView dirNavigationView = this.a;
            if (dirNavigationView.b != null) {
                dirNavigationView.b.a.b();
            }
        }
    }

    @Override
    public final void b(List<com.xiaomi.midrop.b.g> list) {
        this.b();
    }

    public int c() {
        return this.c != a.d;
    }

    public boolean d() {
        if (this.a == null) {
            return false;
        }
        DirNavigationView dirNavigationView = this.a;
        if (TextUtils.equals((CharSequence)dirNavigationView.d, (CharSequence)dirNavigationView.c)) {
            return false;
        }
        dirNavigationView.b(new File(dirNavigationView.c).getParent());
        return true;
    }

    @Override
    public final boolean e() {
        if (this.d()) {
            return true;
        }
        return super.e();
    }

    @Override
    public final void h_() {
        this.b();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onCreate(Bundle bundle) {
        block5 : {
            block4 : {
                super.onCreate(bundle);
                if (bundle != null) break block4;
                if (this.getArguments() == null) break block5;
                bundle = this.getArguments();
            }
            this.c = a.a(bundle.getInt("directory_type"));
            this.d = bundle.getString("directory_root_path");
            this.e = bundle.getString("directory_name");
        }
        if (!g.e().c((b.a)this)) {
            g.e().a((b.a)this);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2131427436, viewGroup, false);
    }

    public void onDestroy() {
        g.e().b(this);
        super.onDestroy();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("directory_type", -1 + this.c);
        bundle.putString("directory_root_path", this.d);
        bundle.putString("directory_name", this.e);
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.a = (DirNavigationView)view.findViewById(2131296428);
        this.a.setShowHiddenFile(y.j());
        DirNavigationView dirNavigationView = this.a;
        String string2 = this.d;
        int n2 = this.c();
        dirNavigationView.a = this.e;
        dirNavigationView.a(string2, n2);
        this.a.setEnableCheck(true);
        if (this.c == a.d) {
            this.a.setEnableCheck(false);
            return;
        }
        if (this.c == a.c) {
            this.a.setDirEnableCheck(false);
        }
    }

}

