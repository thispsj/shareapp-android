/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.support.v4.app.g
 *  android.support.v7.app.c
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Toast
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  midrop.a.c.a.a.a
 *  midrop.a.c.a.a.a$a
 */
package com.xiaomi.midrop.sender.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.c;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.xiaomi.midrop.b.b;
import com.xiaomi.midrop.g;
import com.xiaomi.midrop.receiver.ui.TransferFragment;
import com.xiaomi.midrop.receiver.ui.a;
import com.xiaomi.midrop.send.FilePickNewActivity;
import com.xiaomi.midrop.sender.fragment.SendListFragment;
import com.xiaomi.midrop.sender.fragment.a;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.y;
import java.util.List;
import midrop.a.c.a.a.a;
import midrop.a.c.k;
import midrop.c.a.e;
import midrop.service.a.c;
import midrop.service.c.d;

public class SendListFragment
extends TransferFragment {
    private final String p = SendListFragment.class.getSimpleName();
    private k q;
    private midrop.a.c.a.a.a r;
    private boolean s = true;
    private int t;
    private int u;
    private int v;
    private int w;

    public SendListFragment() {
        com.xiaomi.midrop.result.a.a().m = 1;
    }

    static /* synthetic */ k a(SendListFragment sendListFragment) {
        return sendListFragment.q;
    }

    static /* synthetic */ String b(SendListFragment sendListFragment) {
        return sendListFragment.p;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void t() {
        if (!this.s) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("reportTransferTrack ");
        stringBuilder.append(this.t);
        stringBuilder.append(" ");
        stringBuilder.append(this.u);
        stringBuilder.append(" ");
        stringBuilder.append(this.v);
        stringBuilder.append(" ");
        stringBuilder.append(this.w);
        if (this.t > 0) {
            af.a(af.a.ct).a();
        }
        if (this.v > 0) {
            af.a(af.a.cu).a();
        }
        if (this.t > 0 || this.v > 0) {
            af.a(af.a.cv).a();
            if (this.u == 0 && this.w == 0) {
                af.a(af.a.cw).a();
            }
        }
        if (this.r != null) {
            af.a a2 = this.r.a.i() ? af.a.cy : af.a.cx;
            af.a(a2).a(af.b.L, (int)(this.m / 1024L)).a();
        } else {
            d.b(this.p, "file receiver is NULL when report transfer state", new Object[0]);
        }
        this.s = false;
    }

    @Override
    protected final List<com.xiaomi.midrop.b.g> a(int n2, int n3) throws RemoteException {
        if (this.q == null) {
            return null;
        }
        return this.q.a(n2, n3);
    }

    @Override
    public final void a(Context context, b b2) {
        com.xiaomi.midrop.view.c c2 = new com.xiaomi.midrop.view.c(context);
        c2.b(2131689546).a(2131689547, null).b(2131689541, new View.OnClickListener((SendListFragment)this, b2){
            final /* synthetic */ b a;
            final /* synthetic */ SendListFragment b;
            {
                this.b = sendListFragment;
                this.a = b2;
            }

            public void onClick(View view) {
                if (this.a.m != 3) {
                    if (this.a.m == 4) {
                        return;
                    }
                    try {
                        if (this.b.e() != null) {
                            if (this.a.a) {
                                java.util.ArrayList arrayList = new java.util.ArrayList();
                                java.util.Iterator iterator = this.a.b.iterator();
                                while (iterator.hasNext()) {
                                    arrayList.add((Object)((com.xiaomi.midrop.b.g)iterator.next()).s);
                                }
                                SendListFragment.a(this.b).a((List<String>)arrayList, this.a.t);
                            } else {
                                SendListFragment.a(this.b).b(this.a.s);
                            }
                            af.a(af.a.az).a(af.b.F, com.xiaomi.midrop.util.j.a(this.a.i, this.a.a)).a();
                        }
                        return;
                    }
                    catch (RemoteException remoteException) {
                        d.b(SendListFragment.b(this.b), remoteException.toString(), new Object[0]);
                    }
                }
            }
        });
        c2.d();
        af.a(af.a.ay).a();
    }

    public final void a(k k2) {
        this.q = k2;
        if (this.q != null) {
            this.r = this.e();
            boolean bl = this.r != null && this.r.b.b();
            this.l = bl;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public final void a(c.a var1, midrop.a.c.a.a.a var2_2) {
        block15 : {
            block16 : {
                if (this.q() || this.n == TransferFragment.c.e) break block15;
                this.r = var2_2;
                switch (2.a[var1.ordinal()]) {
                    default: {
                        ** break;
                    }
                    case 4: {
                        this.l = false;
                        break;
                    }
                    case 3: {
                        if (this.r.b.g() == a.a.c.e && !var2_2.e()) {
                            Toast.makeText((Context)this.getActivity(), (int)2131689776, (int)1).show();
                        }
                        if (TextUtils.equals((CharSequence)(var3_3 = this.r.b.g().a()), (CharSequence)a.a.c.e.a())) {
                            this.a(TransferFragment.c.b);
                            y.b(1 + y.e());
                            g.a();
                            af.a(af.a.aB).a();
                            this.t = 1 + this.t;
                            SendListFragment.super.t();
                        } else if (TextUtils.equals((CharSequence)var3_3, (CharSequence)a.a.c.f.a())) {
                            this.a(TransferFragment.c.c);
                            var4_4 = Build.MODEL;
                            if (TextUtils.isEmpty((CharSequence)var4_4)) {
                                var4_4 = "unknown";
                            }
                            af.a(af.a.av).a(af.b.aD, "sender").a(af.b.A, var4_4).a();
                            this.u = 1 + this.u;
                        } else if (TextUtils.equals((CharSequence)var3_3, (CharSequence)a.a.c.g.a())) {
                            this.a(TransferFragment.c.e);
                            af.a(af.a.aw).a();
                        }
                        this.a(af.a.au);
                        ** break;
                    }
                    case 2: {
                        if (var2_2.b.f() == a.a.f.c) {
                            this.a(TransferFragment.c.a);
                            this.r();
                            this.p();
                            ** break;
                        }
                        break block16;
                    }
                    case 1: {
                        if (this.r.b.b()) {
                            this.l = true;
                            this.s();
                            ** break;
                        }
                        if (!this.r.b.c()) break block16;
                        this.l = false;
                        this.a(TransferFragment.c.c);
                        this.r();
                    }
                }
                SendListFragment.super.t();
                ** break;
            }
            this.r();
            return;
        }
        if (this.n != TransferFragment.c.e) return;
        SendListFragment.super.t();
    }

    @Override
    protected final int b() {
        return a.e.b;
    }

    public final void b(k k2) {
        this.a(k2);
        if (this.q()) {
            return;
        }
        this.p();
    }

    @Override
    public final boolean c() {
        if (this.q == null) {
            return false;
        }
        try {
            boolean bl = this.q.h();
            return bl;
        }
        catch (RemoteException remoteException) {
            String string2 = this.p;
            StringBuilder stringBuilder = new StringBuilder("isFileSendInProgress e: ");
            stringBuilder.append((Object)remoteException);
            d.b(string2, stringBuilder.toString(), new Object[0]);
            return false;
        }
    }

    @Override
    public final boolean d() {
        if (this.q == null) {
            return false;
        }
        try {
            boolean bl = this.q.i();
            return bl;
        }
        catch (RemoteException remoteException) {
            String string2 = this.p;
            StringBuilder stringBuilder = new StringBuilder("isDownloading e: ");
            stringBuilder.append((Object)remoteException);
            d.b(string2, stringBuilder.toString(), new Object[0]);
            return false;
        }
    }

    @Override
    public final midrop.a.c.a.a.a e() {
        if (this.q == null) {
            return null;
        }
        try {
            midrop.a.c.a.a.a a2 = this.q.b();
            return a2;
        }
        catch (RemoteException remoteException) {
            String string2 = this.p;
            StringBuilder stringBuilder = new StringBuilder("getConnectedFileReceiver e: ");
            stringBuilder.append((Object)remoteException);
            d.b(string2, stringBuilder.toString(), new Object[0]);
            return null;
        }
    }

    @Override
    public final midrop.c.d.a f() {
        if (this.q == null) {
            return null;
        }
        try {
            midrop.c.d.a a2 = this.q.f();
            return a2;
        }
        catch (RemoteException remoteException) {
            String string2 = this.p;
            StringBuilder stringBuilder = new StringBuilder("getDownloadingQueue e: ");
            stringBuilder.append((Object)remoteException);
            d.b(string2, stringBuilder.toString(), new Object[0]);
            return null;
        }
    }

    @Override
    protected final void g() {
        Intent intent = new Intent((Context)this.a, FilePickNewActivity.class);
        intent.putExtra("from", "from_sender");
        this.startActivity(intent);
        af.a(af.a.as).a();
        af.a(af.a.bv).a(af.b.p, "file_select_from_sender").a();
    }

    @Override
    protected final void h() {
        if (this.a instanceof a) {
            ((a)this.a).a();
        }
        af.a(af.a.ao).a();
    }

    @Override
    public final void k() {
        super.k();
        this.v = 1 + this.v;
    }

    @Override
    public final void m() {
        super.m();
        this.w = 1 + this.w;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.a = (Activity)context;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.r();
    }

    public final void s() {
        this.s = true;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
    }
}

