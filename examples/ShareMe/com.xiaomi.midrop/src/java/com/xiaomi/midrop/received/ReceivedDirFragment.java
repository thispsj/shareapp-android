/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.app.g
 *  android.support.v7.widget.RecyclerView
 *  android.view.View
 *  de.greenrobot.event.c
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.received;

import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.xiaomi.midrop.received.ReceivedActivity;
import com.xiaomi.midrop.received.ReceivedDirFragment;
import com.xiaomi.midrop.received.a.a;
import com.xiaomi.midrop.received.a.b;
import com.xiaomi.midrop.send.dir.FilePickDirectoryFragment;
import com.xiaomi.midrop.view.DirNavigationView;
import de.greenrobot.event.c;

public class ReceivedDirFragment
extends FilePickDirectoryFragment {
    private com.xiaomi.midrop.received.a c;

    public static ReceivedDirFragment a(int n2) {
        ReceivedDirFragment receivedDirFragment = new ReceivedDirFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("directory_type", n2 - 1);
        receivedDirFragment.setArguments(bundle);
        return receivedDirFragment;
    }

    static /* synthetic */ com.xiaomi.midrop.received.a a(ReceivedDirFragment receivedDirFragment) {
        return receivedDirFragment.c;
    }

    @Override
    protected final void b() {
        if (this.c != null) {
            this.c.b();
        }
    }

    @Override
    protected final int c() {
        return 0;
    }

    @Override
    protected final boolean d() {
        if (!super.d()) {
            if (this.c != null) {
                boolean bl;
                com.xiaomi.midrop.received.a a2 = this.c;
                if (a2.a != null && a2.a.getVisibility() == 0) {
                    a2.a(true);
                    bl = true;
                } else {
                    bl = false;
                }
                if (bl) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public void onEvent(a a2) {
        if (this.c != null) {
            this.c.b(a2.a);
        }
    }

    public void onEvent(b b2) {
        if (this.c != null) {
            this.c.b();
        }
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
        com.xiaomi.midrop.received.a a2 = this.c = new com.xiaomi.midrop.received.a((RecyclerView)view.findViewById(2131296690), this.a, view.findViewById(2131296439));
        boolean bl = this.getActivity() instanceof ReceivedActivity ? ((ReceivedActivity)this.getActivity()).b() : false;
        a2.b(bl);
        this.c.a();
        this.a.setOnHomeClickListener(new DirNavigationView.b((ReceivedDirFragment)this){
            final /* synthetic */ ReceivedDirFragment a;
            {
                this.a = receivedDirFragment;
            }

            public final void a() {
                ReceivedDirFragment.a(this.a).a(true);
            }
        });
    }
}

