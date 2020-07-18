/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningServiceInfo
 *  android.app.Dialog
 *  android.bluetooth.BluetoothAdapter
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnShowListener
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.net.wifi.WifiManager
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcelable
 *  android.preference.PreferenceManager
 *  android.support.design.widget.BottomSheetBehavior
 *  android.support.design.widget.BottomSheetBehavior$a
 *  android.support.v4.app.Fragment
 *  android.support.v4.app.k
 *  android.support.v4.content.a
 *  android.support.v4.view.ViewPager
 *  android.support.v4.view.ViewPager$e
 *  android.support.v4.view.n
 *  android.support.v4.widget.DrawerLayout
 *  android.support.v4.widget.DrawerLayout$c
 *  android.support.v4.widget.NestedScrollView
 *  android.support.v7.app.c
 *  android.support.v7.app.d
 *  android.support.v7.widget.GridLayoutManager
 *  android.support.v7.widget.LinearLayoutManager
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$b
 *  android.support.v7.widget.RecyclerView$h
 *  android.support.v7.widget.RecyclerView$i
 *  android.support.v7.widget.Toolbar
 *  android.text.TextUtils
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewStub
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Random
 *  java.util.concurrent.Executor
 */
package com.xiaomi.midrop.send;

import a.e.b.d;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.support.v4.view.ViewPager;
import android.support.v4.view.n;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.h;
import com.xiaomi.midrop.e;
import com.xiaomi.midrop.f;
import com.xiaomi.midrop.g;
import com.xiaomi.midrop.home.c;
import com.xiaomi.midrop.home.d;
import com.xiaomi.midrop.receiver.ui.ReceiveActivity;
import com.xiaomi.midrop.result.a;
import com.xiaomi.midrop.send.FilePickNewActivity;
import com.xiaomi.midrop.send.a;
import com.xiaomi.midrop.send.apk.FilePickApkTabFragment;
import com.xiaomi.midrop.send.audio.FilePickAudioTabFragment;
import com.xiaomi.midrop.send.base.FilePickBaseTabFragment;
import com.xiaomi.midrop.send.dir.FilePickDirTabFragment;
import com.xiaomi.midrop.send.dir.FilePickDirectoryFragment;
import com.xiaomi.midrop.send.history.FilePickHistoryListFragment;
import com.xiaomi.midrop.send.img.FilePickImageFragment;
import com.xiaomi.midrop.send.video.FilePickVideoTabFragment;
import com.xiaomi.midrop.sender.c.b;
import com.xiaomi.midrop.sender.c.g;
import com.xiaomi.midrop.sender.fragment.BasePickFragment;
import com.xiaomi.midrop.sender.service.SenderManagerService;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.Locale.c;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.ag;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.util.i;
import com.xiaomi.midrop.util.q;
import com.xiaomi.midrop.util.u;
import com.xiaomi.midrop.util.y;
import com.xiaomi.midrop.view.ViewPager;
import com.xiaomi.midrop.view.tablayout.CommonSlidingTabLayout;
import com.xiaomi.midrop.view.tablayout.a.a;
import com.xiaomi.midrop.webshare.WebshareGuideActivity;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;

public class FilePickNewActivity
extends com.xiaomi.midrop.util.Locale.a
implements g.a {
    private View A;
    private ImageView B;
    private RelativeLayout C;
    private RelativeLayout D;
    private View E;
    private View F;
    private boolean G = false;
    private boolean H = false;
    private com.xiaomi.midrop.send.a I;
    private List<com.xiaomi.midrop.home.a.b> J;
    private RecyclerView K;
    private c L;
    private BottomSheetBehavior M;
    private int N;
    private NestedScrollView O;
    private View P;
    private SharedPreferences Q;
    private boolean R;
    private RelativeLayout S;
    private boolean T;
    private boolean U;
    private final BroadcastReceiver V = new BroadcastReceiver(this){
        final /* synthetic */ FilePickNewActivity a;
        {
            this.a = filePickNewActivity;
        }

        public final void onReceive(Context context, Intent intent) {
            String string2 = intent.getAction();
            StringBuilder stringBuilder = new StringBuilder("received broadcast:");
            stringBuilder.append((Object)intent);
            android.util.Log.v((String)"MiDrop:FilePickActivity", (String)stringBuilder.toString());
            if ("android.intent.action.MEDIA_BAD_REMOVAL".equals((Object)string2) || "android.intent.action.MEDIA_UNMOUNTED".equals((Object)string2) || "android.intent.action.MEDIA_REMOVED".equals((Object)string2) || "android.intent.action.MEDIA_EJECT".equals((Object)string2)) {
                midrop.service.c.e.a("file_storage_loction", 0);
                FilePickNewActivity.a(this.a);
                StringBuilder stringBuilder2 = new StringBuilder("remove SD:");
                stringBuilder2.append((Object)intent);
                android.util.Log.v((String)"MiDrop:FilePickActivity", (String)stringBuilder2.toString());
            }
            if ("android.intent.action.MEDIA_MOUNTED".equals((Object)string2)) {
                FilePickNewActivity.a(this.a);
            }
        }
    };
    private android.support.v7.app.c W;
    public ViewStub a;
    public boolean b = false;
    public boolean c;
    a.c d = new a.c(this){
        final /* synthetic */ FilePickNewActivity a;
        {
            this.a = filePickNewActivity;
        }

        public final void a() {
            FilePickNewActivity.b(this.a, false);
        }

        /*
         * Enabled aggressive block sorting
         */
        public final void a(com.xiaomi.midrop.qrcode.a a2, boolean bl) {
            af af2;
            FilePickNewActivity.o(this.a).a();
            FilePickNewActivity.a(this.a, a2, bl);
            if (bl) {
                af af3 = af.a(af.a.dX);
                af.b b2 = af.b.ay;
                StringBuilder stringBuilder = new StringBuilder("success_receiver_preparation_popup_failed=");
                stringBuilder.append("bt");
                af2 = af3.a(b2, stringBuilder.toString());
            } else {
                af2 = af.a(af.a.dX).a(af.b.ay, "success_receiver_preparation_popup");
            }
            af2.a();
        }

        public final void a(String string2, boolean bl, Intent intent) {
            u.a(this.a, "", string2, bl, true, intent);
            FilePickNewActivity.o(this.a).a();
            af.a(af.a.dX).a(af.b.ay, "success_send_preparation_popup").a();
        }
    };
    View.OnClickListener e = new View.OnClickListener(this){
        final /* synthetic */ FilePickNewActivity a;
        {
            this.a = filePickNewActivity;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                default: {
                    break;
                }
                case 2131296737: 
                case 2131296742: {
                    if (view.getId() == 2131296742) {
                        FilePickNewActivity.d(this.a, true);
                    }
                    af af2 = af.a(af.a.j);
                    af2.a(af.b.az, 1);
                    af2.a();
                    FilePickNewActivity.G(this.a);
                    FilePickNewActivity.H(this.a);
                    break;
                }
                case 2131296678: {
                    if (FilePickNewActivity.F(this.a) != null) {
                        FilePickNewActivity.F(this.a).c(4);
                        ag.a((Activity)this.a, this.a.getResources().getColor(2131100017));
                        com.xiaomi.midrop.c.a.d();
                    }
                    return;
                }
                case 2131296671: 
                case 2131296674: {
                    if (FilePickNewActivity.I(this.a)) {
                        return;
                    }
                    if (view.getId() == 2131296674) {
                        FilePickNewActivity.A(this.a).setAlpha(1.0f);
                        FilePickNewActivity.A(this.a).setVisibility(0);
                        FilePickNewActivity.E(this.a).setOnClickListener(this.a.e);
                    }
                    af af3 = af.a(af.a.k);
                    af3.a(af.b.aA, 1);
                    af3.a();
                    if (com.xiaomi.midrop.util.aq.a()) {
                        com.xiaomi.midrop.util.aq.a((Context)this.a, new View.OnClickListener(this){
                            final /* synthetic */ 33 a;
                            {
                                this.a = var1;
                            }

                            public void onClick(View view) {
                                FilePickNewActivity.J(this.a.a);
                            }
                        });
                        return;
                    }
                    FilePickNewActivity.J(this.a);
                    break;
                }
                case 2131296405: {
                    FilePickNewActivity.e(this.a);
                    FilePickNewActivity.c(this.a, true);
                    com.xiaomi.midrop.c.a.a();
                }
            }
            if (FilePickNewActivity.F(this.a) != null) {
                FilePickNewActivity.F((FilePickNewActivity)this.a).c = true;
                FilePickNewActivity.F(this.a).c(5);
            }
        }
    };
    private TextView f;
    private TextView g;
    private TextView h;
    private ImageView i;
    private ImageView j;
    private String k;
    private CommonSlidingTabLayout l;
    private ViewPager m;
    private ArrayList<com.xiaomi.midrop.view.tablayout.a.a> n = new ArrayList();
    private List<Fragment> o = new ArrayList();
    private String p;
    private int[] q = new int[]{271, 262, 261, 260, 258, 259};
    private int[] r = new int[]{0, 1, 2, 3};
    private int[] u = new int[]{4, 5};
    private int[] v = new int[]{6, 7};
    private com.xiaomi.midrop.home.b w;
    private List<com.xiaomi.midrop.home.d> x = new ArrayList();
    private com.xiaomi.midrop.util.Locale.b y;
    private DrawerLayout z;

    static /* synthetic */ View A(FilePickNewActivity filePickNewActivity) {
        return filePickNewActivity.E;
    }

    private void A() {
        if (this.B()) {
            return;
        }
        this.stopService(new Intent((Context)this, SenderManagerService.class));
    }

    static /* synthetic */ View B(FilePickNewActivity filePickNewActivity) {
        return filePickNewActivity.P;
    }

    private boolean B() {
        return "from_sender".equalsIgnoreCase(this.k) || "from_receiver".equalsIgnoreCase(this.k);
        {
        }
    }

    static /* synthetic */ boolean C(FilePickNewActivity filePickNewActivity) {
        return filePickNewActivity.T;
    }

    static /* synthetic */ boolean D(FilePickNewActivity filePickNewActivity) {
        return filePickNewActivity.R;
    }

    static /* synthetic */ RelativeLayout E(FilePickNewActivity filePickNewActivity) {
        return filePickNewActivity.S;
    }

    static /* synthetic */ BottomSheetBehavior F(FilePickNewActivity filePickNewActivity) {
        return filePickNewActivity.M;
    }

    static /* synthetic */ void G(FilePickNewActivity filePickNewActivity) {
        filePickNewActivity.q();
    }

    static /* synthetic */ void H(FilePickNewActivity filePickNewActivity) {
        filePickNewActivity.k();
    }

    static /* synthetic */ boolean I(FilePickNewActivity filePickNewActivity) {
        return filePickNewActivity.d(2131689537);
    }

    static /* synthetic */ void J(FilePickNewActivity filePickNewActivity) {
        filePickNewActivity.i();
    }

    static /* synthetic */ int a(FilePickNewActivity filePickNewActivity, int n2) {
        if (n2 < filePickNewActivity.q.length) {
            return filePickNewActivity.q[n2];
        }
        return filePickNewActivity.q[0];
    }

    static /* synthetic */ int a(int[] arrn) {
        return FilePickNewActivity.a(arrn, 259);
    }

    private static int a(int[] arrn, int n2) {
        for (int i2 = 0; i2 < arrn.length; ++i2) {
            if (arrn[i2] != n2) continue;
            return i2;
        }
        return 0;
    }

    static /* synthetic */ com.xiaomi.midrop.send.a a(FilePickNewActivity filePickNewActivity, com.xiaomi.midrop.send.a a2) {
        filePickNewActivity.I = a2;
        return a2;
    }

    private void a(int n2) {
        if (this.W == null) {
            com.xiaomi.midrop.util.Locale.b b2 = com.xiaomi.midrop.util.Locale.b.a();
            com.xiaomi.midrop.view.c c2 = new com.xiaomi.midrop.view.c((Context)this);
            c2.b = b2.b(n2);
            c2.b(b2.b(2131689907), new View.OnClickListener((FilePickNewActivity)this){
                final /* synthetic */ FilePickNewActivity a;
                {
                    this.a = filePickNewActivity;
                }

                public void onClick(View view) {
                    FilePickNewActivity.w(this.a);
                }
            }).a(b2.b(2131689657), new View.OnClickListener((FilePickNewActivity)this, b2, n2){
                final /* synthetic */ com.xiaomi.midrop.util.Locale.b a;
                final /* synthetic */ int b;
                final /* synthetic */ FilePickNewActivity c;
                {
                    this.c = filePickNewActivity;
                    this.a = b2;
                    this.b = n2;
                }

                public void onClick(View view) {
                    android.widget.Toast.makeText((Context)MiDropApplication.a(), (CharSequence)this.a.b(this.b), (int)0).show();
                    this.c.finish();
                }
            });
            this.W = c2.d();
            this.W.setCancelable(false);
            if (this.W != null) {
                this.W.setOnDismissListener(new DialogInterface.OnDismissListener((FilePickNewActivity)this){
                    final /* synthetic */ FilePickNewActivity a;
                    {
                        this.a = filePickNewActivity;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        FilePickNewActivity.x(this.a);
                    }
                });
            }
        }
    }

    private void a(Intent intent) {
        if (this.I == null) {
            this.I = new com.xiaomi.midrop.send.a();
        }
        Bundle bundle = new Bundle();
        bundle.putString("from", "sender");
        String string2 = "";
        if (intent != null) {
            string2 = intent.getAction();
        }
        bundle.putString("send_scene_value", string2);
        bundle.putBoolean("finish_pick_activity", true);
        this.I.a((Context)this, bundle, this.d, intent);
    }

    private void a(com.xiaomi.midrop.qrcode.a a2, Boolean bl) {
        if (!this.G) {
            this.H = true;
        }
        Intent intent = new Intent((Context)this, ReceiveActivity.class);
        intent.putExtra("extra_vpn_alert", false);
        intent.putExtra("extra_msg", (Serializable)bl);
        if (a2 != null) {
            intent.putExtra("receiverinfo", (Parcelable)a2);
        }
        this.startActivityForResult(intent, 1000);
    }

    static /* synthetic */ void a(FilePickNewActivity filePickNewActivity) {
        filePickNewActivity.n();
    }

    static /* synthetic */ void a(FilePickNewActivity filePickNewActivity, com.xiaomi.midrop.qrcode.a a2, Boolean bl) {
        filePickNewActivity.a(a2, bl);
    }

    static /* synthetic */ void a(FilePickNewActivity filePickNewActivity, boolean bl) {
        filePickNewActivity.b(bl);
    }

    private void a(String string2) {
        if (TextUtils.equals((CharSequence)this.p, (CharSequence)string2)) {
            return;
        }
        this.p = string2;
        af.a(af.a.cz).a(af.b.M, this.p).a();
    }

    static /* synthetic */ String b(FilePickNewActivity filePickNewActivity) {
        return filePickNewActivity.k;
    }

    private void b(boolean bl) {
        BasePickFragment basePickFragment;
        FilePickDirTabFragment filePickDirTabFragment;
        if (!bl && this.l != null && this.l.getCurrentTabEntity().c() == a.a.b && this.o.get(this.l.getCurrentTab()) instanceof FilePickDirTabFragment && (filePickDirTabFragment = (FilePickDirTabFragment)((Object)this.o.get(this.l.getCurrentTab()))) != null && filePickDirTabFragment.c() instanceof BasePickFragment && (basePickFragment = (BasePickFragment)filePickDirTabFragment.c()) != null && basePickFragment.e()) {
            return;
        }
        if (!com.xiaomi.midrop.sender.c.g.e().b()) {
            com.xiaomi.midrop.view.c c2 = new com.xiaomi.midrop.view.c((Context)this);
            com.xiaomi.midrop.view.c c3 = c2.b(2131689882);
            c3.j = 1;
            c3.a(2131689884, new View.OnClickListener((FilePickNewActivity)this){
                final /* synthetic */ FilePickNewActivity a;
                {
                    this.a = filePickNewActivity;
                }

                public void onClick(View view) {
                    af.a(af.a.K).a();
                    if (!("from_sender".equalsIgnoreCase(FilePickNewActivity.b(this.a)) || "from_receiver".equalsIgnoreCase(FilePickNewActivity.b(this.a)) || "from_webshare".equalsIgnoreCase(FilePickNewActivity.b(this.a)) || "com.xiaomi.CHOOSE_SEND".equalsIgnoreCase(FilePickNewActivity.b(this.a)))) {
                        FilePickNewActivity.e(this.a);
                        return;
                    }
                    this.a.finish();
                }
            }).b(2131689883, null);
            c2.d();
            af.a(af.a.L).a();
            return;
        }
        try {
            if (this.M != null && this.M.d != 4) {
                if (this.M != null) {
                    this.M.c(4);
                }
                ag.a((Activity)this, this.getResources().getColor(2131100017));
                this.C.setVisibility(0);
                this.B.setVisibility(8);
                this.h.setText((CharSequence)com.xiaomi.midrop.util.Locale.b.a().b(2131689736));
                this.P.setVisibility(0);
                this.P.setOnClickListener(this.e);
                return;
            }
            super.onBackPressed();
        }
        catch (IllegalStateException illegalStateException) {}
    }

    static /* synthetic */ boolean b(FilePickNewActivity filePickNewActivity, boolean bl) {
        filePickNewActivity.U = bl;
        return bl;
    }

    static /* synthetic */ boolean c(FilePickNewActivity filePickNewActivity) {
        filePickNewActivity.G = false;
        return false;
    }

    static /* synthetic */ boolean c(FilePickNewActivity filePickNewActivity, boolean bl) {
        filePickNewActivity.T = bl;
        return bl;
    }

    static /* synthetic */ boolean d(FilePickNewActivity filePickNewActivity) {
        return filePickNewActivity.G;
    }

    static /* synthetic */ boolean d(FilePickNewActivity filePickNewActivity, boolean bl) {
        filePickNewActivity.R = bl;
        return bl;
    }

    static /* synthetic */ void e(FilePickNewActivity filePickNewActivity) {
        filePickNewActivity.l();
    }

    static /* synthetic */ boolean e() {
        return FilePickNewActivity.g();
    }

    static /* synthetic */ DrawerLayout f(FilePickNewActivity filePickNewActivity) {
        return filePickNewActivity.z;
    }

    private boolean f() {
        return ((WifiManager)this.getApplicationContext().getSystemService("wifi")).isWifiEnabled();
    }

    static /* synthetic */ CommonSlidingTabLayout g(FilePickNewActivity filePickNewActivity) {
        return filePickNewActivity.l;
    }

    private static boolean g() {
        if (BluetoothAdapter.getDefaultAdapter() != null) {
            return BluetoothAdapter.getDefaultAdapter().isEnabled();
        }
        return false;
    }

    private boolean h() {
        return e.a((Context)this, "android.permission.ACCESS_COARSE_LOCATION") && e.a((Context)this, "android.permission.ACCESS_FINE_LOCATION") && e.d((Context)this) && e.a((Context)this);
    }

    static /* synthetic */ int[] h(FilePickNewActivity filePickNewActivity) {
        return filePickNewActivity.q;
    }

    static /* synthetic */ List i(FilePickNewActivity filePickNewActivity) {
        return filePickNewActivity.o;
    }

    private void i() {
        if (!e.f((Context)this)) {
            this.a(null, false);
            return;
        }
        if (this.I == null) {
            this.I = new com.xiaomi.midrop.send.a();
        }
        Bundle bundle = new Bundle();
        bundle.putString("from", "receiver");
        this.I.a((Context)this, bundle, this.d, null);
    }

    private void j() {
        if (this.M == null || this.M.d == 5) {
            ag.a((Activity)this, this.getResources().getColor(2131099891));
        }
    }

    static /* synthetic */ void j(FilePickNewActivity filePickNewActivity) {
        filePickNewActivity.z();
    }

    private void k() {
        this.G = true;
        this.E.setVisibility(8);
        this.S.setOnClickListener(null);
        this.F.setVisibility(0);
    }

    static /* synthetic */ boolean k(FilePickNewActivity filePickNewActivity) {
        return filePickNewActivity.U;
    }

    private void l() {
        this.E.setVisibility(0);
        this.E.setAlpha(1.0f);
        this.S.setOnClickListener(this.e);
        this.F.setVisibility(8);
        this.G = false;
        com.xiaomi.midrop.sender.c.g.e().c();
    }

    static /* synthetic */ boolean l(FilePickNewActivity filePickNewActivity) {
        return filePickNewActivity.d(2131689537);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void m() {
        block2 : {
            if (!am.b((Context)this)) break block2;
            var1_1 = this.t().findViewById(2131296631);
            ** GOTO lbl-1000
        }
        var1_1 = this.t().findViewById(2131296631);
        if (y.l()) {
            var2_2 = 0;
        } else lbl-1000: // 2 sources:
        {
            var2_2 = 4;
        }
        var1_1.setVisibility(var2_2);
    }

    static /* synthetic */ boolean m(FilePickNewActivity filePickNewActivity) {
        return filePickNewActivity.f();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void n() {
        int n2;
        com.xiaomi.midrop.util.Locale.b b2;
        this.x.clear();
        List<com.xiaomi.midrop.home.d> list = this.x;
        com.xiaomi.midrop.home.d d2 = new com.xiaomi.midrop.home.d(this.y.b(2131689614), "", "new_settings_connect_to_computer", false, 2131231132, new d.a(this){
            final /* synthetic */ FilePickNewActivity a;
            {
                this.a = filePickNewActivity;
            }

            public final void onClick() {
                Intent intent = new Intent((Context)this.a, com.xiaomi.midrop.ServerControlActivity.class);
                this.a.startActivity(intent);
                midrop.service.c.e.a("new_settings_connect_to_computer", false);
                af.a(af.a.bb).a();
                this.a.b();
            }
        });
        list.add((Object)d2);
        List<com.xiaomi.midrop.home.d> list2 = this.x;
        com.xiaomi.midrop.home.d d3 = new com.xiaomi.midrop.home.d((CharSequence)this.y.b(2131690032), "", false, 2131231137, new d.a(this){
            final /* synthetic */ FilePickNewActivity a;
            {
                this.a = filePickNewActivity;
            }

            public final void onClick() {
                FilePickNewActivity.q(this.a);
                af.a(af.a.dP).a(af.b.at, 2).a();
                this.a.b();
            }
        });
        list2.add((Object)d3);
        List<com.xiaomi.midrop.home.d> list3 = this.x;
        com.xiaomi.midrop.home.d d4 = new com.xiaomi.midrop.home.d((CharSequence)this.y.b(2131689618), "", true, 2131231283, new d.a(this){
            final /* synthetic */ FilePickNewActivity a;
            {
                this.a = filePickNewActivity;
            }

            public final void onClick() {
                af.a(af.a.i).a(af.b.aB, 0).a();
                Intent intent = new Intent((Context)this.a, com.xiaomi.midrop.ShareActivity.class);
                this.a.startActivity(intent);
            }
        });
        list3.add((Object)d4);
        int n3 = com.xiaomi.midrop.common.b.a("file_storage_loction", 0);
        String string2 = this.y.b(2131689688);
        String string3 = n3 == 1 ? i.a((Context)this) : i.a();
        this.x.add((Object)new com.xiaomi.midrop.home.d(string2, string3, 2131231136, new d.a(this){
            final /* synthetic */ FilePickNewActivity a;
            {
                this.a = filePickNewActivity;
            }

            public final void onClick() {
                af.a(af.a.bg).a();
                FilePickNewActivity filePickNewActivity = this.a;
                com.xiaomi.midrop.util.i$a a2 = new com.xiaomi.midrop.util.i$a(this){
                    final /* synthetic */ 14 a;
                    {
                        this.a = var1;
                    }

                    public final void a() {
                        FilePickNewActivity.a(this.a.a);
                    }
                };
                String string2 = i.a();
                String string3 = com.xiaomi.midrop.util.Locale.b.a().b(2131689735);
                String string4 = i.a((Context)filePickNewActivity);
                String string5 = com.xiaomi.midrop.util.Locale.b.a().b(2131689953);
                ArrayList arrayList = new ArrayList();
                arrayList.add((Object)new com.xiaomi.midrop.b.c(string3, string2));
                if (!TextUtils.isEmpty((CharSequence)com.xiaomi.midrop.util.d.b((Context)filePickNewActivity))) {
                    arrayList.add((Object)new com.xiaomi.midrop.b.c(string5, string4));
                }
                filePickNewActivity.getApplicationContext();
                int n2 = com.xiaomi.midrop.common.b.a("file_storage_loction", 0);
                com.xiaomi.midrop.view.OptionPickerDialogBuilder optionPickerDialogBuilder = new com.xiaomi.midrop.view.OptionPickerDialogBuilder((Context)filePickNewActivity);
                com.xiaomi.midrop.view.OptionPickerDialogBuilder optionPickerDialogBuilder2 = optionPickerDialogBuilder.a(2131689688);
                optionPickerDialogBuilder2.a = arrayList;
                optionPickerDialogBuilder2.c = n2;
                optionPickerDialogBuilder2.b = new com.xiaomi.midrop.view.OptionPickerDialogBuilder$a((Activity)filePickNewActivity, n2, a2){
                    final /* synthetic */ Activity a;
                    final /* synthetic */ int b;
                    final /* synthetic */ com.xiaomi.midrop.util.i$a c;
                    {
                        this.a = activity;
                        this.b = n2;
                        this.c = a2;
                    }

                    public final void a(int n2) {
                        boolean bl;
                        boolean bl2 = android.os.Environment.getExternalStorageState().equals((Object)"mounted") && (bl = android.support.v4.content.a.a((Context)this.a).length >= 2);
                        Boolean bl3 = bl2;
                        if (n2 != this.b) {
                            new AsyncTask<Void, Void, Void>(this, bl3){
                                final /* synthetic */ Boolean a;
                                final /* synthetic */ com.xiaomi.midrop.util.i$1 b;
                                {
                                    this.b = var1;
                                    this.a = bl;
                                }

                                protected final /* synthetic */ Object doInBackground(Object[] arrobject) {
                                    block1 : {
                                        String string2;
                                        block2 : {
                                            block0 : {
                                                if (this.b.b != 1) break block0;
                                                if (!this.a.booleanValue()) break block1;
                                                string2 = com.xiaomi.midrop.util.d.a((Context)this.b.a);
                                                break block2;
                                            }
                                            string2 = com.xiaomi.midrop.util.d.c;
                                        }
                                        i.a(string2);
                                    }
                                    return null;
                                }
                            }.execute((Object[])new Void[0]);
                        }
                        if (n2 == 1) {
                            if (bl3.booleanValue()) {
                                midrop.service.c.e.a("file_storage_loction", 1);
                                af.a(af.a.bh).a();
                            }
                        } else {
                            midrop.service.c.e.a("file_storage_loction", 0);
                        }
                        this.c.a();
                    }
                };
                optionPickerDialogBuilder.a();
            }
        }));
        com.xiaomi.midrop.util.Locale.b b3 = com.xiaomi.midrop.util.Locale.b.a();
        String[] arrstring = c.a.a();
        int n4 = com.xiaomi.midrop.util.Locale.c.a(b3.b);
        arrstring[0] = b3.b(2131689621);
        String string4 = n4 < c.a.a().length ? arrstring[n4] : "";
        String string5 = string4;
        List<com.xiaomi.midrop.home.d> list4 = this.x;
        com.xiaomi.midrop.home.d d5 = new com.xiaomi.midrop.home.d((CharSequence)this.y.b(2131689744), string5, false, 2131231134, new d.a(this){
            final /* synthetic */ FilePickNewActivity a;
            {
                this.a = filePickNewActivity;
            }

            public final void onClick() {
                com.xiaomi.midrop.util.Locale.b b2 = FilePickNewActivity.r(this.a);
                FilePickNewActivity filePickNewActivity = this.a;
                com.xiaomi.midrop.util.Locale.b$a a2 = new com.xiaomi.midrop.util.Locale.b$a(this){
                    final /* synthetic */ 15 a;
                    {
                        this.a = var1;
                    }

                    public final void a() {
                        Intent intent = this.a.a.getIntent();
                        this.a.a.finish();
                        this.a.a.startActivity(intent);
                        this.a.a.overridePendingTransition(0, 0);
                    }
                };
                String[] arrstring = c.a.a();
                int n2 = com.xiaomi.midrop.util.Locale.c.a(b2.b);
                String string2 = b2.b(2131689621);
                arrstring[0] = string2;
                ArrayList arrayList = new ArrayList();
                int n3 = arrstring.length;
                for (int i2 = 0; i2 < n3; ++i2) {
                    arrayList.add((Object)new com.xiaomi.midrop.b.c(arrstring[i2], null));
                }
                com.xiaomi.midrop.view.OptionPickerDialogBuilder optionPickerDialogBuilder = new com.xiaomi.midrop.view.OptionPickerDialogBuilder((Context)filePickNewActivity);
                com.xiaomi.midrop.view.OptionPickerDialogBuilder optionPickerDialogBuilder2 = optionPickerDialogBuilder.a(2131689875);
                optionPickerDialogBuilder2.a = arrayList;
                optionPickerDialogBuilder2.c = n2;
                optionPickerDialogBuilder2.b = new com.xiaomi.midrop.view.OptionPickerDialogBuilder$a(b2, n2, a2){
                    final /* synthetic */ int a;
                    final /* synthetic */ com.xiaomi.midrop.util.Locale.b$a b;
                    final /* synthetic */ com.xiaomi.midrop.util.Locale.b c;
                    {
                        this.c = b2;
                        this.a = n2;
                        this.b = a2;
                    }

                    public final void a(int n2) {
                        if (this.a != n2) {
                            c.a[] arra = c.a.values();
                            c.a a2 = n2 > arra.length ? c.a.a : arra[n2];
                            com.xiaomi.midrop.util.Locale.c.a(com.xiaomi.midrop.util.Locale.b.a(this.c), a2);
                            this.c.c();
                            this.b.a();
                        }
                    }
                };
                optionPickerDialogBuilder.a();
            }
        });
        list4.add((Object)d5);
        int n5 = this.x.size();
        if (y.j()) {
            b2 = this.y;
            n2 = 2131689714;
        } else {
            b2 = this.y;
            n2 = 2131689713;
        }
        String string6 = b2.b(n2);
        List<com.xiaomi.midrop.home.d> list5 = this.x;
        com.xiaomi.midrop.home.d d6 = new com.xiaomi.midrop.home.d((CharSequence)this.y.b(2131689712), string6, true, 2131231130, new d.a(this, n5){
            final /* synthetic */ int a;
            final /* synthetic */ FilePickNewActivity b;
            {
                this.b = filePickNewActivity;
                this.a = n2;
            }

            public final void onClick() {
                ArrayList arrayList = new ArrayList();
                arrayList.add((Object)new com.xiaomi.midrop.b.c(FilePickNewActivity.r(this.b).b(2131689713), null));
                arrayList.add((Object)new com.xiaomi.midrop.b.c(FilePickNewActivity.r(this.b).b(2131689714), null));
                int n2 = y.j();
                com.xiaomi.midrop.view.OptionPickerDialogBuilder optionPickerDialogBuilder = new com.xiaomi.midrop.view.OptionPickerDialogBuilder((Context)this.b);
                com.xiaomi.midrop.view.OptionPickerDialogBuilder optionPickerDialogBuilder2 = optionPickerDialogBuilder.a(2131689712);
                optionPickerDialogBuilder2.a = arrayList;
                optionPickerDialogBuilder2.c = n2;
                optionPickerDialogBuilder2.b = new com.xiaomi.midrop.view.OptionPickerDialogBuilder$a(this, n2, arrayList){
                    final /* synthetic */ int a;
                    final /* synthetic */ ArrayList b;
                    final /* synthetic */ 16 c;
                    {
                        this.c = var1;
                        this.a = n2;
                        this.b = arrayList;
                    }

                    public final void a(int n2) {
                        if (this.a != n2) {
                            boolean bl = n2 == 1;
                            y.d(bl);
                            ((com.xiaomi.midrop.home.d)FilePickNewActivity.s((FilePickNewActivity)this.c.b).get((int)this.c.a)).b = ((com.xiaomi.midrop.b.c)this.b.get((int)n2)).a;
                            FilePickNewActivity.t((FilePickNewActivity)this.c.b).a.b();
                            if (n2 == 1) {
                                af.a(af.a.h).a(af.b.aE, 2).a();
                            }
                        }
                    }
                };
                optionPickerDialogBuilder.a();
                af.a(af.a.h).a(af.b.aE, 1).a();
            }
        });
        list5.add((Object)d6);
        if (!am.a()) {
            List<com.xiaomi.midrop.home.d> list6 = this.x;
            com.xiaomi.midrop.home.d d7 = new com.xiaomi.midrop.home.d((CharSequence)this.y.b(2131689909), "", 2131231135, new d.a(this){
                final /* synthetic */ FilePickNewActivity a;
                {
                    this.a = filePickNewActivity;
                }

                public final void onClick() {
                    f.a((Activity)this.a);
                    af.a(af.a.q).a(af.b.n, "Settings").a();
                    af.a(af.a.o).a();
                }
            }, 0);
            list6.add((Object)d7);
        }
        List<com.xiaomi.midrop.home.d> list7 = this.x;
        com.xiaomi.midrop.home.d d8 = new com.xiaomi.midrop.home.d((CharSequence)this.y.b(2131689908), "", 2131231133, new d.a(this){
            final /* synthetic */ FilePickNewActivity a;
            {
                this.a = filePickNewActivity;
            }

            /*
             * Exception decompiling
             */
            public final void onClick(}
        java.lang.IllegalStateException: Parameters not created
        
        