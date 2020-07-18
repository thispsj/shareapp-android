/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.app.Fragment
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  java.lang.Class
 *  java.lang.String
 *  java.util.List
 */
package com.xiaomi.midrop.sender.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.xiaomi.midrop.sender.c.g;
import com.xiaomi.midrop.sender.fragment.BasePickFragment;
import java.util.List;

public abstract class BasePickFragment
extends Fragment
implements g.a {
    protected final String b = this.getClass().getCanonicalName();

    @Override
    public final void a(String string2, List<com.xiaomi.midrop.b.g> list) {
    }

    public boolean e() {
        return false;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setOnTouchListener(new View.OnTouchListener((BasePickFragment)this){
            final /* synthetic */ BasePickFragment a;
            {
                this.a = basePickFragment;
            }

            public final boolean onTouch(View view, android.view.MotionEvent motionEvent) {
                return true;
            }
        });
    }
}

