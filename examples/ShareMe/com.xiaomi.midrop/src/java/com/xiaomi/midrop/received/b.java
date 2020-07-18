/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$b
 */
package com.xiaomi.midrop.received;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import com.xiaomi.midrop.received.b;
import com.xiaomi.midrop.send.base.a;
import com.xiaomi.midrop.sender.card.d;
import com.xiaomi.midrop.view.stickadapter.a;

public final class b
extends com.xiaomi.midrop.send.base.a {
    d.a c;
    Context d;
    private boolean j = false;

    public b(Context context, int n2) {
        super(n2);
        this.d = context;
    }

    @Override
    public final void a(a.d d2, int n2, int n3, int n4) {
        super.a(d2, n2, n3, n4);
        a.b b2 = (a.b)d2;
        if (this.e == 1) {
            b2.n.a(new d.a((b)this){
                final /* synthetic */ b a;
                {
                    this.a = b2;
                }

                public final void a(com.xiaomi.midrop.b.g g2) {
                    if (this.a.c != null) {
                        this.a.c.a(g2);
                    }
                }
            });
        }
        b2.n.a(new d.b((b)this){
            final /* synthetic */ b a;
            {
                this.a = b2;
            }

            public final void a() {
                if (this.a.d instanceof com.xiaomi.midrop.received.ReceivedActivity) {
                    ((com.xiaomi.midrop.received.ReceivedActivity)this.a.d).c();
                }
            }
        });
    }

    public final void a(boolean bl) {
        this.j = bl;
        this.a.b();
    }

    @Override
    protected final boolean g_() {
        return this.j;
    }
}

