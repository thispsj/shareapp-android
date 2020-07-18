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
 *  android.support.v7.app.c
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  midrop.a.c.a.a.a
 *  midrop.a.c.a.a.a$a
 */
package com.xiaomi.midrop.receiver.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.c;
import android.text.TextUtils;
import android.view.View;
import com.xiaomi.midrop.b.b;
import com.xiaomi.midrop.g;
import com.xiaomi.midrop.receiver.ui.ReceiveActivity;
import com.xiaomi.midrop.receiver.ui.ReceiveFragment;
import com.xiaomi.midrop.receiver.ui.TransferFragment;
import com.xiaomi.midrop.receiver.ui.a;
import com.xiaomi.midrop.send.FilePickNewActivity;
import com.xiaomi.midrop.sender.ui.BottomBarView;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.y;
import java.util.List;
import midrop.a.c.a.a.a;
import midrop.service.a.c;
import midrop.service.c.d;

public class ReceiveFragment
extends TransferFragment {
    private midrop.a.b.b p;

    public ReceiveFragment() {
        com.xiaomi.midrop.result.a.a().m = 2;
    }

    static /* synthetic */ midrop.a.b.b a(ReceiveFragment receiveFragment) {
        return receiveFragment.p;
    }

    @Override
    protected final List<com.xiaomi.midrop.b.g> a(int n2, int n3) throws RemoteException {
        if (this.p == null) {
            return null;
        }
        return this.p.a(n2, n3);
    }

    @Override
    public final void a(Context context, b b2) {
        com.xiaomi.midrop.view.c c2 = new com.xiaomi.midrop.view.c(context);
        c2.b(2131689546).a(2131689547, null).b(2131689541, new View.OnClickListener((ReceiveFragment)this, b2){
            final /* synthetic */ b a;
            final /* synthetic */ ReceiveFragment b;
            {
                this.b = receiveFragment;
                this.a = b2;
            }

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public void onClick(View view) {
                block9 : {
                    if (this.a.m == 4) return;
                    if (this.a.m == 3) {
                        return;
                    }
                    android.support.v4.app.g g2 = this.b.getActivity();
                    if (!(g2 instanceof ReceiveActivity)) return;
                    if (ReceiveFragment.a(this.b) == null) return;
                    java.util.Locale locale = java.util.Locale.US;
                    Object[] arrobject = new Object[]{this.a.k, this.a.h, this.a.a};
                    String.format((java.util.Locale)locale, (String)"onDeleteItem --> [Name=%s], [Uri=%s], [IsDir=%s]", (Object[])arrobject);
                    if (this.a.a) {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        java.util.Iterator iterator = this.a.b.iterator();
                        while (iterator.hasNext()) {
                            arrayList.add((Object)((com.xiaomi.midrop.b.g)iterator.next()).s);
                        }
                        ReceiveActivity receiveActivity = (ReceiveActivity)g2;
                        String string2 = this.a.t;
                        if (receiveActivity.a != null) {
                            receiveActivity.a.a((List<String>)arrayList, string2);
                        }
                    } else {
                        ReceiveActivity receiveActivity = (ReceiveActivity)g2;
                        String string3 = this.a.s;
                        if (receiveActivity.a != null) {
                            receiveActivity.a.a(string3);
                        }
                    }
                    break block9;
                    catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                    }
                }
                af.a(af.a.az).a(af.b.F, com.xiaomi.midrop.util.j.a(this.a.i, this.a.a)).a();
            }
        });
        c2.d();
        af.a(af.a.aM).a();
    }

    public final void a(midrop.a.b.b b2) {
        this.p = b2;
        boolean bl = this.p != null;
        this.l = bl;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public final void a(c.a var1, midrop.a.c.a.a.a var2_2) {
        block16 : {
            block17 : {
                block18 : {
                    new StringBuilder("onReceiveServiceMessage ").append((Object)var1);
                    if (this.q()) {
                        return;
                    }
                    switch (2.a[var1.ordinal()]) {
                        default: {
                            break block16;
                        }
                        case 4: {
                            this.l = false;
                            var4_3 = TransferFragment.c.e;
                            break block17;
                        }
                        case 3: {
                            var5_4 = var2_2.b.g();
                            var6_5 = var2_2.b;
                            if (a.a.c.c.equals((Object)var6_5.g())) break;
                            if (!var2_2.b.e()) ** GOTO lbl22
                            this.a(TransferFragment.c.b);
                            af.a(af.a.aB).a();
                            this.a(af.a.au);
                            y.b(1 + y.e());
                            g.a();
                            break block16;
lbl22: // 1 sources:
                            if (var5_4 != a.a.c.g) ** GOTO lbl26
                            this.a(TransferFragment.c.e);
                            var8_6 = af.a(af.a.aw);
                            ** GOTO lbl32
lbl26: // 1 sources:
                            if (var5_4 != a.a.c.f) break block16;
                            this.a(TransferFragment.c.d);
                            var7_7 = Build.MODEL;
                            if (TextUtils.isEmpty((CharSequence)var7_7)) {
                                var7_7 = "unknown";
                            }
                            var8_6 = af.a(af.a.av).a(af.b.aD, "receiver").a(af.b.A, var7_7);
lbl32: // 2 sources:
                            var8_6.a();
                            this.a(af.a.au);
                            break block16;
                        }
                        case 2: {
                            if (var2_2.b.f() == a.a.f.c) {
                                this.p();
                            }
                            break block16;
                        }
                        case 1: {
                            if (!var2_2.b.b()) break block18;
                            this.l = true;
                        }
                    }
                    var4_3 = TransferFragment.c.a;
                    break block17;
                }
                if (!var2_2.b.c()) break block16;
                this.l = false;
                var4_3 = TransferFragment.c.c;
            }
            this.a(var4_3);
        }
        this.r();
    }

    @Override
    protected final int b() {
        return a.e.a;
    }

    @Override
    public final boolean c() {
        if (this.p == null) {
            return false;
        }
        try {
            boolean bl = this.p.e();
            return bl;
        }
        catch (RemoteException remoteException) {
            StringBuilder stringBuilder = new StringBuilder("isFileSendInProgress e: ");
            stringBuilder.append((Object)remoteException);
            d.b("ReceiveFragment", stringBuilder.toString(), new Object[0]);
            return false;
        }
    }

    @Override
    public final boolean d() {
        if (this.p == null) {
            return false;
        }
        try {
            boolean bl = this.p.f();
            return bl;
        }
        catch (RemoteException remoteException) {
            StringBuilder stringBuilder = new StringBuilder("isDownloading e: ");
            stringBuilder.append((Object)remoteException);
            d.b("ReceiveFragment", stringBuilder.toString(), new Object[0]);
            return false;
        }
    }

    @Override
    public final midrop.a.c.a.a.a e() {
        if (this.p == null) {
            return null;
        }
        try {
            midrop.a.c.a.a.a a2 = this.p.d();
            return a2;
        }
        catch (RemoteException remoteException) {
            StringBuilder stringBuilder = new StringBuilder("getConnectedFileReceiver e: ");
            stringBuilder.append((Object)remoteException);
            d.b("ReceiveFragment", stringBuilder.toString(), new Object[0]);
            return null;
        }
    }

    @Override
    public final midrop.c.d.a f() {
        if (this.p == null) {
            return null;
        }
        try {
            midrop.c.d.a a2 = this.p.c();
            return a2;
        }
        catch (RemoteException remoteException) {
            StringBuilder stringBuilder = new StringBuilder("getDownloadingQueue e: ");
            stringBuilder.append((Object)remoteException);
            d.b("ReceiveFragment", stringBuilder.toString(), new Object[0]);
            return null;
        }
    }

    @Override
    protected final void g() {
        Intent intent = new Intent((Context)this.a, FilePickNewActivity.class);
        intent.putExtra("from", "from_receiver");
        this.startActivity(intent);
        af.a(af.a.as).a(af.b.r, "enter_file_select").a();
        af.a(af.a.bv).a(af.b.p, "file_select_from_receiver").a();
    }

    @Override
    protected final void h() {
        if (this.a instanceof ReceiveActivity) {
            ((ReceiveActivity)this.a).a();
        }
        af.a(af.a.ao).a();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        BottomBarView bottomBarView = this.k;
        bottomBarView.b = true;
        bottomBarView.a(bottomBarView.a);
    }
}

