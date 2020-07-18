/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.res.Resources
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.Message
 *  android.os.RemoteException
 *  android.os.SystemClock
 *  android.support.v4.app.g
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$b
 *  android.support.v7.widget.RecyclerView$f
 *  android.support.v7.widget.RecyclerView$i
 *  android.support.v7.widget.RecyclerView$w
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  java.io.File
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.ConcurrentHashMap
 *  midrop.a.c.a.a.a
 */
package com.xiaomi.midrop.receiver.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.a;
import com.xiaomi.midrop.b.f;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.db.TransferHistoryDatabase;
import com.xiaomi.midrop.g;
import com.xiaomi.midrop.receiver.ui.TransferFragment;
import com.xiaomi.midrop.receiver.ui.a;
import com.xiaomi.midrop.sender.c.b;
import com.xiaomi.midrop.sender.c.h;
import com.xiaomi.midrop.sender.ui.BottomBarView;
import com.xiaomi.midrop.transmission.a.d;
import com.xiaomi.midrop.transmission.c;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.util.j;
import com.xiaomi.midrop.util.y;
import com.xiaomi.midrop.view.BaseFragment;
import com.xiaomi.midrop.view.TransferSpeedView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import midrop.c.a.e;
import midrop.c.f.a;
import midrop.service.a.c;

public abstract class TransferFragment
extends BaseFragment
implements a.a,
a.f,
c.b {
    static final /* synthetic */ boolean o = true;
    protected Activity a;
    protected com.xiaomi.midrop.receiver.ui.a b;
    protected com.xiaomi.midrop.f.a c;
    protected RecyclerView d;
    protected TextView e;
    protected ImageView f;
    protected ImageView g;
    protected TransferSpeedView h;
    protected View i;
    protected RelativeLayout j;
    protected BottomBarView k;
    protected boolean l;
    protected long m = 0L;
    protected int n = c.a;
    private long p = SystemClock.elapsedRealtime();
    private a q;
    private String r;
    private String s;
    private com.xiaomi.midrop.db.b.a t;
    private com.xiaomi.midrop.db.b.a u;
    private d v = new Object(0){
        long a;
        long b;
        long c;
        long d;
        int e;
        int f;

        public final long a() {
            long l2 = this.b + this.c + this.d;
            if (l2 >= this.a) {
                return this.a;
            }
            return l2;
        }

        /*
         * Enabled aggressive block sorting
         */
        public final void a(List<com.xiaomi.midrop.b.g> list) {
            this.b = 0L;
            this.a = 0L;
            this.f = 0;
            if (list != null) {
                this.e = list.size();
            }
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                long l2;
                com.xiaomi.midrop.b.g g2 = (com.xiaomi.midrop.b.g)iterator.next();
                if (g2.c()) continue;
                com.xiaomi.midrop.b.b b2 = (com.xiaomi.midrop.b.b)g2;
                if (b2.b.size() > 0) {
                    Iterator iterator2 = b2.b.iterator();
                    long l3 = 0L;
                    while (iterator2.hasNext()) {
                        com.xiaomi.midrop.b.g g3 = (com.xiaomi.midrop.b.g)iterator2.next();
                        if (g3.m == 5) continue;
                        long l4 = l3 + g3.l;
                        if (g3.c()) {
                            this.b += g3.o;
                        }
                        l3 = l4;
                    }
                    l2 = l3 + this.a;
                } else {
                    l2 = this.a + b2.a();
                }
                this.a = l2;
            }
            return;
        }

        public final boolean b() {
            return this.a() >= this.a;
        }

        public final void c() {
            this.c = 0L;
            this.d = 0L;
        }
    };

    private void a(long l2, long l3, long l4, int n2, int n3) {
        this.h.setTotalSize(l4);
        this.h.setSentSize(l3);
        this.h.setSpeed(l2);
        TransferSpeedView transferSpeedView = this.h;
        transferSpeedView.f = n3;
        transferSpeedView.g = n2;
        TransferSpeedView transferSpeedView2 = this.h;
        TextView textView = transferSpeedView2.b;
        Resources resources = transferSpeedView2.getResources();
        Object[] arrobject = new Object[]{j.b(transferSpeedView2.e)};
        textView.setText((CharSequence)resources.getString(2131689999, arrobject));
        ProgressBar progressBar = transferSpeedView2.a;
        int n4 = transferSpeedView2.d == 0L ? 0 : (int)(100L * transferSpeedView2.e / transferSpeedView2.d);
        progressBar.setProgress(n4);
        TextView textView2 = transferSpeedView2.c;
        Resources resources2 = transferSpeedView2.getResources();
        int n5 = transferSpeedView2.g;
        Object[] arrobject2 = new Object[]{transferSpeedView2.g, transferSpeedView2.f};
        textView2.setText((CharSequence)resources2.getQuantityString(2131558403, n5, arrobject2));
    }

    private void a(String string2) {
        if (this.c != null && this.d != null) {
            com.xiaomi.midrop.transmission.c c2 = com.xiaomi.midrop.transmission.c.e();
            if (c2.e != null && !c2.e.isEmpty()) {
                boolean bl;
                block5 : {
                    Iterator iterator = c2.e.iterator();
                    do {
                        boolean bl2 = iterator.hasNext();
                        bl = false;
                        if (!bl2) break block5;
                    } while (!((com.xiaomi.midrop.transmission.a.a)iterator.next() instanceof com.xiaomi.midrop.transmission.a.b));
                    bl = true;
                }
                if (!bl) {
                    com.xiaomi.midrop.transmission.a.b b2 = new com.xiaomi.midrop.transmission.a.b(string2);
                    c2.e.add((Object)b2);
                }
            }
            this.c.a.b();
            if (this.c.a() > 0) {
                this.d.b(this.c.a() - 1);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void c(String var1_5, String var2_7, int var3_3, int var4_4, long var5_2, long var7_6, long var9_1) {
        block43 : {
            block48 : {
                block47 : {
                    block46 : {
                        block45 : {
                            block44 : {
                                if (this.q() != false) return;
                                if (this.n == c.e) {
                                    return;
                                }
                                var11_8 = this.c;
                                var12_9 = var11_8.a();
                                var13_10 = com.xiaomi.midrop.transmission.c.e().e.size() - 1;
                                var14_11 = null;
                                var15_12 = null;
                                do {
                                    block38 : {
                                        block37 : {
                                            block36 : {
                                                if (var13_10 < 0) break block36;
                                                var55_20 = (com.xiaomi.midrop.transmission.a.a)com.xiaomi.midrop.transmission.c.e().e.get(var13_10);
                                                if (var55_20 instanceof com.xiaomi.midrop.transmission.a.d) break block37;
                                                var16_22 = var11_8;
                                                --var12_9;
                                                break block38;
                                            }
                                            var16_22 = var11_8;
                                            break;
                                        }
                                        var14_11 = (com.xiaomi.midrop.transmission.a.d)var55_20;
                                        var56_18 = new Object(var14_11){
                                            public com.xiaomi.midrop.b.b a;
                                            public int b;
                                            public int c;
                                            public int d;
                                            final /* synthetic */ com.xiaomi.midrop.transmission.a.d e;
                                            {
                                                this.e = d2;
                                                this.d = -1;
                                            }

                                            public final boolean a() {
                                                return this.a.g == 1;
                                            }
                                        };
                                        var57_14 = var14_11.a.iterator();
                                        block1 : do {
                                            if (!var57_14.hasNext()) {
                                                var16_22 = var11_8;
                                                var15_12 = null;
                                                break;
                                            }
                                            var58_19 = var57_14.next();
                                            var59_16 = var57_14;
                                            var60_21 = (com.xiaomi.midrop.b.b)var58_19;
                                            var16_22 = var11_8;
                                            var61_15 = 0;
                                            do {
                                                block42 : {
                                                    block41 : {
                                                        block39 : {
                                                            block40 : {
                                                                if (var61_15 >= var60_21.b.size()) break block39;
                                                                var63_23 = (com.xiaomi.midrop.b.b)var60_21.b.get(var61_15);
                                                                if (!var63_23.a) break block40;
                                                                break block41;
                                                            }
                                                            if (!TextUtils.equals((CharSequence)var63_23.h, (CharSequence)var1_5)) break block42;
                                                            var56_18.a = var60_21;
                                                            var56_18.b = var61_15;
                                                            var64_24 = var56_18.c;
                                                            if (var60_21.g == 1) {
                                                                var61_15 = 0;
                                                            }
                                                            ** GOTO lbl59
                                                        }
                                                        var62_17 = var60_21.g == 1 ? 1 + var56_18.c : var56_18.c + var60_21.b.size();
                                                        var56_18.c = var62_17;
                                                        var57_14 = var59_16;
                                                        var11_8 = var16_22;
                                                        continue block1;
                                                    }
                                                    for (var65_13 = 0; var65_13 < var63_23.b.size(); ++var65_13) {
                                                        if (!TextUtils.equals((CharSequence)((com.xiaomi.midrop.b.g)var63_23.b.get((int)var65_13)).h, (CharSequence)var1_5)) continue;
                                                        var56_18.a = var60_21;
                                                        var56_18.b = var61_15;
                                                        var56_18.d = var65_13;
                                                        var64_24 = var56_18.c;
lbl59: // 2 sources:
                                                        var56_18.c = var64_24 + var61_15;
                                                        var15_12 = var56_18;
                                                        break block1;
                                                    }
                                                }
                                                ++var61_15;
                                            } while (true);
                                            break;
                                        } while (true);
                                        if (var15_12 != null) {
                                            var12_9 -= var14_11.b - var15_12.c;
                                            break;
                                        }
                                        var12_9 -= var55_20.a();
                                    }
                                    --var13_10;
                                    var11_8 = var16_22;
                                } while (true);
                                if (var12_9 < 0 || var15_12 == null || var14_11 == null) break block43;
                                var22_25 = var15_12.a;
                                var23_26 = (com.xiaomi.midrop.b.g)var22_25.b.get(var15_12.b);
                                if (var23_26.c()) break block43;
                                var24_27 = com.xiaomi.midrop.transmission.c.e();
                                var25_28 = var15_12.b;
                                if (var25_28 != -1) break block44;
                                var26_29 = new StringBuilder("Missing trans item, uri=");
                                var26_29.append(var1_5);
                                var26_29.append(" path=");
                                var26_29.append(var2_7);
                                var26_29.append(" inDir=");
                                midrop.service.c.d.b("TransferDataCenter", var26_29.toString(), new Object[0]);
                                break block45;
                            }
                            var39_31 = (com.xiaomi.midrop.b.g)var15_12.a.b.get(var25_28);
                            var40_32 = var15_12.d != -1;
                            if (!var40_32) break block46;
                            var41_33 = (com.xiaomi.midrop.b.g)((com.xiaomi.midrop.b.b)var39_31).b.get(var15_12.d);
                            if (var41_33 != null) break block47;
                            var51_34 = new StringBuilder("Missing trans item, ");
                            var51_34.append(var1_5);
                            var51_34.append(" ");
                            var51_34.append(var2_7);
                            midrop.service.c.d.b("TransferDataCenter", var51_34.toString(), new Object[0]);
                        }
                        var31_30 = var14_11;
                        break block48;
                    }
                    var41_33 = var39_31;
                }
                var41_33.m = var3_3;
                var41_33.n = var4_4;
                if (var3_3 == 3) {
                    var31_30 = var14_11;
                    var42_35 = var7_6;
                } else {
                    var31_30 = var14_11;
                    var42_35 = var5_2;
                }
                var41_33.o = var42_35;
                var41_33.p = var7_6;
                if (var39_31.z == g.a.b) {
                    var24_27.i = var44_36 = var9_1;
                } else {
                    var24_27.j = var44_36 = var9_1;
                }
                if (var44_36 > var24_27.k) {
                    var24_27.k = var44_36;
                }
                if (var3_3 == 3) {
                    var24_27.g.remove((Object)var41_33.i);
                    var41_33.j = var2_7;
                    var41_33.i = var2_7;
                }
                if (var40_32) {
                    var39_31.a(var3_3);
                    var39_31.n = var4_4;
                }
                if (var39_31.m == 3) {
                    if (var40_32) {
                        var24_27.o.add((Object)var39_31.i);
                    } else {
                        var24_27.n.add((Object)var2_7);
                    }
                    var48_37 = var15_12.a;
                    if (var48_37.e < var48_37.d()) {
                        var48_37.e = 1 + var48_37.e;
                    }
                } else if (var39_31.m == 5) {
                    var46_38 = var15_12.a;
                    if (var46_38.f < var46_38.b.size() - var46_38.e) {
                        var46_38.f = 1 + var46_38.f;
                    }
                }
            }
            if (var3_3 == 5) {
                var32_39 = var31_30;
                var32_39.b();
            } else {
                var32_39 = var31_30;
            }
            var33_40 = var16_22;
            var34_41 = var33_40.d.c(var12_9);
            if (var34_41 == null) {
                var22_25.d = -1;
                var33_40.c(var12_9);
            } else if (var34_41 instanceof a.a) {
                var22_25.d = var15_12.b;
                var33_40.c.a(var34_41, var22_25, var15_12.b, var32_39.c(), false);
                var38_42 = var12_9 - var15_12.b - 1;
                if (var38_42 >= 0) {
                    var33_40.c(var38_42);
                }
            }
            if (var15_12.a()) {
                var36_43 = com.xiaomi.midrop.b.a.a().a.get((Object)"TransfezrGridViewActivity") != null;
                if (var36_43) {
                    var37_44 = Message.obtain();
                    var37_44.what = var15_12.b;
                    com.xiaomi.midrop.b.a.a().a("TransfezrGridViewActivity", var37_44);
                }
            } else if (var23_26.c() && (var35_45 = var12_9 - var15_12.b) >= 0) {
                var33_40.c(var35_45);
            }
            if (var32_39.e == 1 && var3_3 == 5) {
                com.xiaomi.midrop.transmission.upgrade.util.a.e().a(var2_7);
            }
        }
        var17_46 = com.xiaomi.midrop.transmission.c.e().i + com.xiaomi.midrop.transmission.c.e().j;
        this.m = this.m == 0L ? var17_46 : (var17_46 + this.m) / 2L;
        var19_47 = this.v;
        var20_48 = com.xiaomi.midrop.transmission.c.e().a(var3_3);
        var21_49 = com.xiaomi.midrop.transmission.c.e().l;
        if (var3_3 == 5) {
            var19_47.a -= var7_6;
        } else if (var3_3 == 3) {
            var19_47.b = var5_2 + var19_47.b;
        }
        var19_47.f = var20_48;
        var19_47.e = var21_49;
        this.a(this.m, this.v.a(), this.v.a, this.v.f, this.v.e);
    }

    public static void o() {
    }

    public abstract List<com.xiaomi.midrop.b.g> a(int var1, int var2) throws RemoteException;

    public final void a(int n2) {
        if (this.n == c.e) {
            return;
        }
        this.n = n2;
    }

    @Override
    public final void a(Message message) {
        if (message.obj != null) {
            com.xiaomi.midrop.b.a a2 = com.xiaomi.midrop.b.a.a();
            a.a a3 = a2.a.get((Object)"TransfezrGridViewActivity") == null ? null : (a.a)((WeakReference)a2.a.get((Object)"TransfezrGridViewActivity")).get();
            this.a((Context)a3, (com.xiaomi.midrop.b.b)message.obj);
        }
    }

    public final void a(com.xiaomi.midrop.transmission.a.e e2) {
        if (this.c != null && this.d != null) {
            com.xiaomi.midrop.transmission.c c2 = com.xiaomi.midrop.transmission.c.e();
            if (c2.e != null && !c2.e.isEmpty()) {
                boolean bl;
                block5 : {
                    Iterator iterator = c2.e.iterator();
                    do {
                        boolean bl2 = iterator.hasNext();
                        bl = false;
                        if (!bl2) break block5;
                    } while (!((com.xiaomi.midrop.transmission.a.a)iterator.next() instanceof com.xiaomi.midrop.transmission.a.e));
                    bl = true;
                }
                if (!bl) {
                    c2.e.add((Object)e2);
                }
            }
            this.c.a.b();
            if (this.c.a() > 0) {
                this.d.b(this.c.a() - 1);
            }
        }
    }

    protected final void a(af.a a2) {
        if (a2 != null) {
            HashSet<String> hashSet = com.xiaomi.midrop.transmission.c.e().n;
            int n2 = com.xiaomi.midrop.transmission.c.e().o.size();
            Iterator iterator = hashSet.iterator();
            int n3 = 0;
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            while (iterator.hasNext()) {
                String string2 = j.d((String)iterator.next());
                if (com.xiaomi.midrop.util.g.l.contains((Object)string2)) {
                    ++n3;
                    continue;
                }
                if (com.xiaomi.midrop.util.g.i.contains((Object)string2)) {
                    ++n5;
                    continue;
                }
                if (com.xiaomi.midrop.util.g.h.contains((Object)string2)) {
                    ++n4;
                    continue;
                }
                if (com.xiaomi.midrop.util.g.j.contains((Object)string2)) {
                    ++n6;
                    continue;
                }
                ++n7;
            }
            af.a(a2).a(af.b.a, n3).a(af.b.c, n4).a(af.b.b, n5).a(af.b.d, n6).a(af.b.e, n7).a(af.b.h, n2).a(af.b.j, (int)((SystemClock.elapsedRealtime() - this.p) / 1000L)).a();
            com.xiaomi.midrop.transmission.c.e().n.clear();
            com.xiaomi.midrop.transmission.c.e().o.clear();
            this.p = SystemClock.elapsedRealtime();
        }
    }

    public final void a(String string2, String string3, int n2, int n3, long l2, long l3, long l4) {
        this.v.c = n2 != 3 && n2 != 5 ? l2 : 0L;
        this.c(string2, string3, n2, n3, l2, l3, l4);
    }

    public final void a(List list) {
    }

    public abstract void a(c.a var1, midrop.a.c.a.a.a var2);

    public abstract int b();

    public final void b(String string2, String string3, int n2, int n3, long l2, long l3, long l4) {
        this.v.d = n2 != 3 && n2 != 5 ? l2 : 0L;
        this.c(string2, string3, n2, n3, l2, l3, l4);
    }

    public final void b(List list) {
    }

    public abstract boolean c();

    public abstract boolean d();

    public abstract midrop.a.c.a.a.a e();

    public abstract midrop.c.d.a f();

    public void g() {
    }

    public void h() {
    }

    @Override
    public final void h_() {
        if (this.c != null) {
            this.c.a.b();
        }
    }

    public final void i() {
        this.p();
    }

    public final void j() {
        this.a(c.a);
        this.r();
    }

    public void k() {
        this.a(c.b);
        this.r();
        this.a(af.a.aI);
        af.a(af.a.aO).a();
        y.b(1 + y.e());
        g.a();
    }

    public final void l() {
        this.a(c.e);
        this.r();
        this.a(af.a.aI);
        af.a(af.a.aK).a();
    }

    public void m() {
        this.a(c.c);
        this.r();
        this.a(af.a.aI);
        af.a(af.a.aJ).a();
    }

    @Override
    public final void n() {
        if (this.c != null) {
            this.c.a.b();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.a = (Activity)context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.xiaomi.midrop.b.a.a().a("TransferFragment", (a.a)this);
        this.q = new BroadcastReceiver((TransferFragment)this, 0){
            final /* synthetic */ TransferFragment a;
            {
                this.a = transferFragment;
            }

            public final void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    boolean bl;
                    boolean bl2;
                    if (intent.getAction() == null) {
                        return;
                    }
                    new Object[1][0] = intent.getAction();
                    String string2 = "";
                    if (!intent.getAction().equals((Object)"android.intent.action.PACKAGE_ADDED") && !intent.getAction().equals((Object)"android.intent.action.PACKAGE_REPLACED")) {
                        bl = false;
                    } else {
                        string2 = intent.getDataString();
                        bl = true;
                    }
                    if (intent.getAction().equals((Object)"android.intent.action.PACKAGE_REMOVED")) {
                        string2 = intent.getDataString();
                        bl2 = true;
                        bl = false;
                    } else {
                        bl2 = false;
                    }
                    if (!TextUtils.isEmpty((CharSequence)string2)) {
                        if (!string2.contains((CharSequence)":")) {
                            return;
                        }
                        int n2 = 1 + string2.indexOf(":");
                        if (n2 >= string2.length()) {
                            return;
                        }
                        String string3 = string2.substring(n2);
                        for (com.xiaomi.midrop.b.g g2 : com.xiaomi.midrop.transmission.c.e().f) {
                            if (!TextUtils.equals((CharSequence)g2.x, (CharSequence)string3)) continue;
                            if (bl) {
                                g2.E = 0;
                                continue;
                            }
                            if (!bl2) continue;
                            g2.E = 1;
                        }
                        this.a.c.a.b();
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        this.a.registerReceiver((BroadcastReceiver)this.q, intentFilter);
        com.xiaomi.midrop.transmission.c.e().a((b.a)this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2131427444, viewGroup, false);
    }

    public void onDestroy() {
        new AsyncTask<Void, Void, Void>(this.t, this.u){
            private com.xiaomi.midrop.db.b.a a;
            private com.xiaomi.midrop.db.b.a b;
            {
                this.a = a2;
                this.b = a3;
            }

            protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                if (this.a != null && this.a.e != null && !this.a.e.isEmpty()) {
                    this.a.b = System.currentTimeMillis();
                    TransferHistoryDatabase.i().j().a(this.a);
                }
                if (this.b != null && this.b.e != null && !this.b.e.isEmpty()) {
                    this.b.b = System.currentTimeMillis();
                    TransferHistoryDatabase.i().j().a(this.b);
                }
                return null;
            }
        }.execute((Object[])new Void[0]);
        com.xiaomi.midrop.b.a.a().a("TransferFragment");
        this.a.unregisterReceiver((BroadcastReceiver)this.q);
        com.xiaomi.midrop.transmission.c.e().c();
        com.xiaomi.midrop.transmission.c.e().b(this);
        super.onDestroy();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void onPause() {
        super.onPause();
        if (com.xiaomi.midrop.transmission.c.e().f.isEmpty() != false) return;
        if (TextUtils.isEmpty((CharSequence)this.s)) {
            midrop.service.c.d.b("TransferFragment", "Device name is null!", new Object[0]);
            var27_1 = this.e();
            if (var27_1 != null && !TextUtils.isEmpty((CharSequence)(var30_2 = var27_1.a()))) {
                this.s = var30_2;
            }
            if ((var28_3 = this.f()) != null && !TextUtils.isEmpty((CharSequence)(var29_4 = var28_3.b()))) {
                this.s = var29_4;
            }
        }
        if (this.u == null) {
            var23_5 = g.a.b - 1;
            var24_6 = new StringBuilder();
            var24_6.append(System.currentTimeMillis() + (long)var23_5);
            var24_6.append(this.r);
            this.u = new com.xiaomi.midrop.db.b.a(var24_6.toString(), this.r, var23_5, this.s);
        }
        if (this.t == null) {
            var19_7 = g.a.a - 1;
            var20_8 = new StringBuilder();
            var20_8.append(System.currentTimeMillis() + (long)var19_7);
            var20_8.append(this.r);
            this.t = new com.xiaomi.midrop.db.b.a(var20_8.toString(), this.r, var19_7, this.s);
        }
        var1_9 = new ArrayList();
        var2_10 = new ArrayList();
        var3_11 = com.xiaomi.midrop.transmission.c.e().f.iterator();
        do {
            if (!var3_11.hasNext()) ** GOTO lbl55
            var4_14 = (com.xiaomi.midrop.b.g)var3_11.next();
            if (var4_14.m == 5) continue;
            var5_13 = (com.xiaomi.midrop.b.b)var4_14;
            if (var4_14.z != g.a.b) ** GOTO lbl49
            if (var4_14.g == 1 && var5_13.b.size() > 0) {
                var14_18 = var5_13.b.iterator();
            } else {
                if (TextUtils.isEmpty((CharSequence)var4_14.i) || var4_14.m != 3) continue;
                if (new File(var4_14.i).isFile()) {
                    com.xiaomi.midrop.result.a.a().a(var4_14.i);
                } else {
                    com.xiaomi.midrop.result.a.a().a(var4_14.k);
                    var8_12 = new StringBuilder();
                    var8_12.append(com.xiaomi.midrop.util.d.a);
                    var8_12.append("/");
                    var8_12.append(var4_14.k);
                    var4_14.i = var8_12.toString();
                    var12_17 = new File(var4_14.i);
                    if (var12_17.exists()) {
                        var4_14.w = var12_17.lastModified() / 1000L;
                    }
                }
                var2_10.add((Object)var4_14);
                continue;
lbl49: // 1 sources:
                if (var4_14.g == 1 && var5_13.b.size() > 0) {
                    var1_9.addAll(var5_13.b);
                    continue;
                }
                if (TextUtils.isEmpty((CharSequence)var4_14.i) || var4_14.m != 3) continue;
                var1_9.add((Object)var4_14);
                continue;
lbl55: // 1 sources:
                com.xiaomi.midrop.result.a.a().a = com.xiaomi.midrop.transmission.c.e().k;
                com.xiaomi.midrop.result.a.a().b = com.xiaomi.midrop.transmission.c.e().g();
                if (!var1_9.isEmpty() && this.t != null) {
                    this.t.e = new com.google.a.e().a((Object)var1_9);
                    y.g(0);
                }
                if (var2_10.isEmpty() != false) return;
                if (this.u == null) return;
                this.u.e = new com.google.a.e().a((Object)var2_10);
                y.g(0);
                return;
            }
            while (var14_18.hasNext()) {
                var16_19 = (com.xiaomi.midrop.b.g)var14_18.next();
                if (TextUtils.isEmpty((CharSequence)var16_19.i) || var16_19.m != 3) continue;
                if (new File(var16_19.i).isFile()) {
                    var17_16 = com.xiaomi.midrop.result.a.a();
                    var18_15 = var16_19.i;
                } else {
                    var17_16 = com.xiaomi.midrop.result.a.a();
                    var18_15 = var16_19.k;
                }
                var17_16.a(var18_15);
            }
            var2_10.addAll(var5_13.b);
        } while (true);
    }

    public void onResume() {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.getArguments() != null) {
            bundle.putAll(this.getArguments());
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.d = (RecyclerView)view.findViewById(2131296599);
        this.i = view.findViewById(2131296339);
        this.g = (ImageView)view.findViewById(2131296341);
        this.h = (TransferSpeedView)view.findViewById(2131296579);
        this.j = (RelativeLayout)view.findViewById(2131296639);
        this.k = (BottomBarView)view.findViewById(2131296628);
        if (TextUtils.equals((CharSequence)com.xiaomi.midrop.d.a.b.a("sending_more_button"), (CharSequence)"new")) {
            this.k.setVisibility(0);
        } else {
            this.j.setVisibility(0);
        }
        this.d.setLayoutManager((RecyclerView.i)new LinearLayoutManager(this.getContext()));
        view.findViewById(2131296823).findViewById(2131296431).setVisibility(8);
        this.e = (TextView)view.findViewById(2131296871);
        this.e.setTextColor(this.getResources().getColor(2131100072));
        this.f = (ImageView)view.findViewById(2131296487);
        this.f.setImageResource(2131231014);
        this.f = (ImageView)view.findViewById(2131296487);
        view.setBackgroundDrawable((Drawable)new ColorDrawable(this.getResources().getColor(2131099891)));
        view.setPadding(0, ag.a((Context)this.getActivity()), 0, 0);
        if (this.a instanceof com.xiaomi.midrop.util.Locale.a) {
            ((com.xiaomi.midrop.util.Locale.a)this.a).a(false);
        }
        View.OnClickListener onClickListener = new View.OnClickListener((TransferFragment)this){
            final /* synthetic */ TransferFragment a;
            {
                this.a = transferFragment;
            }

            public void onClick(View view) {
                int n2 = view.getId();
                if (n2 != 2131296339) {
                    if (n2 != 2131296341) {
                        if (n2 != 2131296487) {
                            return;
                        }
                        this.a.getActivity().onBackPressed();
                        return;
                    }
                    this.a.g();
                    return;
                }
                this.a.h();
                com.xiaomi.midrop.transmission.c.e().c();
            }
        };
        this.f.setOnClickListener(onClickListener);
        this.i.setOnClickListener(onClickListener);
        this.g.setOnClickListener(onClickListener);
        this.k.setBottomBarClickListener(new BottomBarView.b((TransferFragment)this){
            final /* synthetic */ TransferFragment a;
            {
                this.a = transferFragment;
            }

            public final void a(int n2) {
                switch (4.a[n2 - 1]) {
                    default: {
                        return;
                    }
                    case 3: {
                        android.support.v4.app.g g2 = this.a.getActivity();
                        if (!(g2 instanceof com.xiaomi.midrop.sender.ui.b)) break;
                        ((com.xiaomi.midrop.sender.ui.b)g2).a(new com.xiaomi.midrop.sender.ui.b$b(this){
                            final /* synthetic */ 2 a;
                            {
                                this.a = var1;
                            }

                            public final void a() {
                                Intent intent = new Intent((Context)this.a.a.getActivity(), com.xiaomi.midrop.received.ReceivedActivity.class);
                                this.a.a.startActivity(intent);
                            }
                        });
                        return;
                    }
                    case 2: {
                        this.a.g();
                        return;
                    }
                    case 1: {
                        this.a.h();
                        com.xiaomi.midrop.transmission.c.e().c();
                    }
                }
            }
        });
        this.b = new com.xiaomi.midrop.receiver.ui.a(this.getContext(), this.b());
        this.c = new com.xiaomi.midrop.f.a(this.getContext(), this.d, this.b);
        this.d.setAdapter((RecyclerView.a)this.c);
        this.d.setItemAnimator(null);
        this.b.i = this;
        midrop.a.c.a.a.a a2 = this.e();
        if (a2 != null) {
            this.e.setText((CharSequence)a2.a());
            this.c.e = a2.a();
            this.s = a2.a();
            this.r = a2.a.a();
        }
        if (!o && TextUtils.isEmpty((CharSequence)this.s)) {
            throw new AssertionError();
        }
        this.p();
        TransferFragment.super.a(0L, 0L, 0L, 0, 0);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
    }

    protected final void p() {
        if (this.e() != null) {
            List<com.xiaomi.midrop.b.g> list = h.a(50, new h.a<com.xiaomi.midrop.b.g>(this, com.xiaomi.midrop.transmission.c.e().h){
                final /* synthetic */ int a;
                final /* synthetic */ TransferFragment b;
                {
                    this.b = transferFragment;
                    this.a = n2;
                }

                /*
                 * Loose catch block
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Lifted jumps to return sites
                 */
                public final List<com.xiaomi.midrop.b.g> a(int n2, int n3) {
                    void var3_9;
                    List<com.xiaomi.midrop.b.g> list;
                    block4 : {
                        list = this.b.a(n2 + this.a, n3);
                        try {
                            java.util.Locale locale = java.util.Locale.getDefault();
                            Object[] arrobject = new Object[2];
                            arrobject[0] = n2;
                            int n4 = list == null ? 0 : list.size();
                            arrobject[1] = n4;
                            String.format((java.util.Locale)locale, (String)"updateTransUi => [startIndex=%d], [length=%d]", (Object[])arrobject);
                            return list;
                        }
                        catch (RemoteException remoteException) {}
                        break block4;
                        catch (RemoteException remoteException) {
                            list = null;
                        }
                    }
                    midrop.service.c.d.a("TransferFragment", "updateTransUi", (java.lang.Throwable)var3_9, new Object[0]);
                    return list;
                }
            });
            boolean bl = list.isEmpty();
            int n2 = 0;
            if (!bl && this.c != null) {
                com.xiaomi.midrop.transmission.c c2 = com.xiaomi.midrop.transmission.c.e();
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    com.xiaomi.midrop.b.b b2 = null;
                    for (com.xiaomi.midrop.b.g g2 : list) {
                        String string2;
                        if (TextUtils.isEmpty((CharSequence)g2.t)) {
                            com.xiaomi.midrop.b.b b3 = new com.xiaomi.midrop.b.b();
                            b3.g = g2.g;
                            b3.h = g2.h;
                            b3.i = g2.i;
                            b3.j = g2.j;
                            b3.k = g2.k;
                            b3.l = g2.l;
                            b3.m = g2.m;
                            b3.n = g2.n;
                            b3.o = g2.o;
                            b3.p = g2.p;
                            b3.u = g2.u;
                            b3.v = g2.v;
                            b3.w = g2.w;
                            b3.x = g2.x;
                            b3.y = g2.y;
                            b3.q = g2.q;
                            b3.r = g2.r;
                            b3.s = g2.s;
                            b3.t = g2.t;
                            b3.A = g2.A;
                            b3.z = g2.z;
                            b3.C = g2.C;
                            arrayList.add((Object)b3);
                            continue;
                        }
                        String string3 = new File(g2.i).getParent();
                        if (!TextUtils.isEmpty((CharSequence)g2.q)) {
                            int n3 = string3.lastIndexOf(g2.q);
                            if (n3 < 0) {
                                StringBuilder stringBuilder = new StringBuilder("invalid path=");
                                stringBuilder.append(string3);
                                stringBuilder.append(" parentPath=");
                                stringBuilder.append(g2.q);
                                midrop.service.c.d.b("TransferDataCenter", stringBuilder.toString(), new Object[0]);
                                continue;
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(string3.substring(0, n3));
                            stringBuilder.append(g2.t);
                            string2 = stringBuilder.toString();
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(string3);
                            stringBuilder.append("/");
                            stringBuilder.append(g2.t);
                            string2 = stringBuilder.toString();
                        }
                        if (b2 != null && b2.i.equals((Object)string2) && b2.z == g2.z) {
                            b2.b.add((Object)g2);
                            b2.a(g2.m);
                            b2.n = g2.n;
                            continue;
                        }
                        File file = new File(string2);
                        com.xiaomi.midrop.b.b b4 = new com.xiaomi.midrop.b.b(a.a.f.ordinal());
                        b4.a(g2.m);
                        b4.h = Uri.fromFile((File)file).toString();
                        b4.i = string2;
                        b4.j = g2.j;
                        b4.k = file.getName();
                        b4.a = true;
                        b4.n = g2.n;
                        b4.t = g2.t;
                        b4.z = g2.z;
                        b4.A = g2.A;
                        b4.b.add((Object)g2);
                        arrayList.add((Object)b4);
                        b2 = b4;
                    }
                    c2.h += list.size();
                    List<com.xiaomi.midrop.transmission.a.a> list2 = midrop.service.transmitter.a.a.a(MiDropApplication.a(), (List<com.xiaomi.midrop.b.b>)arrayList);
                    c2.e.addAll(list2);
                    ArrayList arrayList2 = new ArrayList();
                    while (n2 < list2.size()) {
                        com.xiaomi.midrop.transmission.a.a a2 = (com.xiaomi.midrop.transmission.a.a)list2.get(n2);
                        if (a2 instanceof com.xiaomi.midrop.transmission.a.d) {
                            for (com.xiaomi.midrop.b.b b5 : ((com.xiaomi.midrop.transmission.a.d)a2).a) {
                                if (b5.g == 1) {
                                    arrayList2.add((Object)b5);
                                } else {
                                    Iterator iterator = b5.b.iterator();
                                    while (iterator.hasNext()) {
                                        arrayList2.add((Object)((com.xiaomi.midrop.b.b)((com.xiaomi.midrop.b.g)iterator.next())));
                                    }
                                }
                                c2.l += b5.b.size();
                            }
                        }
                        ++n2;
                    }
                    c2.f.addAll((Collection)arrayList2);
                    c2.h();
                }
                this.c.a.b();
                if (this.d != null && this.c.a() > 0) {
                    this.d.b(this.c.a() - 1);
                }
                this.v.a(com.xiaomi.midrop.transmission.c.e().f);
                return;
            }
            midrop.service.c.d.b("TransferFragment", "Failed to get transItem list!", new Object[0]);
        }
    }

    protected final boolean q() {
        return !this.isAdded() || this.isDetached() || this.isHidden() || this.isRemoving();
        {
        }
    }

    protected final void r() {
        switch (4.b[this.n - 1]) {
            default: {
                return;
            }
            case 5: {
                if (this.c == null) break;
                this.c.d(102);
                return;
            }
            case 4: {
                if (this.c != null) {
                    this.c.d(103);
                }
                if (this.g != null) {
                    this.g.setEnabled(false);
                }
                if (this.i != null) {
                    this.i.setVisibility(8);
                }
                if (this.k != null) {
                    this.k.a(com.xiaomi.midrop.sender.a.a.d);
                }
                this.a(this.a.getResources().getString(2131689966));
                if (this.h.getStatus() == 2) break;
                this.h.setState(3);
                this.h.setSpeed(0L);
                return;
            }
            case 3: {
                if (this.l) break;
                if (this.g != null) {
                    this.g.setEnabled(false);
                    this.g.setVisibility(8);
                }
                if (this.i != null) {
                    this.i.setVisibility(0);
                }
                if (this.k != null) {
                    this.k.a(com.xiaomi.midrop.sender.a.a.b);
                }
                this.a(this.a.getResources().getString(2131689965));
                if (this.c != null) {
                    this.c.d(102);
                }
                if (this.h != null) {
                    if (this.v.b()) {
                        this.h.setState(2);
                        this.h.setSpeed(com.xiaomi.midrop.transmission.c.e().k);
                    } else if (this.h.getStatus() != 2) {
                        this.h.setState(3);
                        this.h.setSpeed(0L);
                    }
                }
                if (this.v == null) break;
                this.v.c();
                return;
            }
            case 2: {
                if (this.c != null) {
                    this.c.d(101);
                }
                if (this.g != null) {
                    this.g.setEnabled(true);
                    this.g.setVisibility(0);
                }
                if (this.i != null) {
                    this.i.setVisibility(8);
                }
                if (this.k != null) {
                    this.k.a(com.xiaomi.midrop.sender.a.a.c);
                }
                if (this.v == null || !this.v.b()) break;
                if (this.h != null) {
                    this.h.setState(2);
                    this.h.setSpeed(com.xiaomi.midrop.transmission.c.e().k);
                }
                this.v.c();
                return;
            }
            case 1: {
                if (this.c != null) {
                    this.c.d(100);
                }
                if (this.g != null) {
                    this.g.setEnabled(true);
                    this.g.setVisibility(0);
                }
                if (this.i != null) {
                    this.i.setVisibility(8);
                }
                if (this.k != null) {
                    this.k.a(com.xiaomi.midrop.sender.a.a.a);
                }
                if (this.h == null) break;
                this.h.setState(1);
            }
        }
    }

}

