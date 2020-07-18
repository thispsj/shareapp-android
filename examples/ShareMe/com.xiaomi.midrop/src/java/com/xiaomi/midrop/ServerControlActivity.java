/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.ServiceConnection
 *  android.content.SharedPreferences
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.net.wifi.WifiInfo
 *  android.net.wifi.WifiManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.preference.PreferenceManager
 *  android.support.v4.content.a
 *  android.support.v7.app.c
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.widget.CheckBox
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.TextView
 *  android.widget.Toast
 *  com.xiaomi.midrop.ChooseFTPTypeDialogHelper
 *  de.greenrobot.event.c
 *  java.io.File
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.InetAddress
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Locale
 */
package com.xiaomi.midrop;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.xiaomi.midrop.ChooseFTPTypeDialogHelper;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.ServerControlActivity;
import com.xiaomi.midrop.ServerControlPreference;
import com.xiaomi.midrop.b;
import com.xiaomi.midrop.b.e;
import com.xiaomi.midrop.service.FTPServerService;
import com.xiaomi.midrop.util.Locale.a;
import com.xiaomi.midrop.util.ac;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.ah;
import com.xiaomi.midrop.util.ai;
import com.xiaomi.midrop.view.c;
import com.xiaomi.miftp.R;
import com.xiaomi.miftp.c.g;
import com.xiaomi.miftp.view.a;
import com.xiaomi.miftp.view.dialog.c;
import com.xiaomi.miftp.view.dialog.d;
import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.a.ae;

public class ServerControlActivity
extends a
implements View.OnClickListener {
    private static final String a = "ServerControlActivity";
    private TextView b;
    private TextView c;
    private TextView d;
    private View e;
    private View f;
    private com.xiaomi.midrop.util.Locale.b g;
    private boolean h;
    private FTPServerService i;
    private ServiceConnection j = new ServiceConnection(this){
        final /* synthetic */ ServerControlActivity a;
        {
            this.a = serverControlActivity;
        }

        public final void onServiceConnected(ComponentName componentName, android.os.IBinder iBinder) {
            ServerControlActivity.a(this.a, (iBinder).a);
            ServerControlActivity.a(this.a);
            af.a(af.a.bc).a();
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            ServerControlActivity.b(this.a).stopSelf();
            ServerControlActivity.a(this.a, null);
        }
    };
    private BroadcastReceiver k = new BroadcastReceiver(this){
        final /* synthetic */ ServerControlActivity a;
        {
            this.a = serverControlActivity;
        }

        public final void onReceive(Context context, Intent intent) {
            com.xiaomi.miftp.c.c.a(ServerControlActivity.a(), "Wifi status broadcast received");
            ServerControlActivity.a(this.a);
        }
    };

    static /* synthetic */ FTPServerService a(ServerControlActivity serverControlActivity, FTPServerService fTPServerService) {
        serverControlActivity.i = fTPServerService;
        return fTPServerService;
    }

    static /* synthetic */ String a() {
        return a;
    }

    static /* synthetic */ void a(ServerControlActivity serverControlActivity) {
        serverControlActivity.b();
    }

    static /* synthetic */ void a(ServerControlActivity serverControlActivity, e e2) {
        serverControlActivity.a(e2);
    }

    private void a(e e2) {
        if (this.h) {
            return;
        }
        if (!e2.a()) {
            com.xiaomi.miftp.c.c.d(a, "Warning due to storage state ");
            Toast toast = Toast.makeText((Context)this, (CharSequence)this.g.a(2131689955), (int)1);
            toast.setGravity(17, 0, 0);
            toast.show();
        }
        if (e2.a()) {
            File file = new File(e2.b());
            if (!file.isDirectory()) {
                return;
            }
            ae.a(file);
            this.h = this.bindService(new Intent((Context)this, FTPServerService.class), this.j, 1);
            if (!FTPServerService.a()) {
                Intent intent = new Intent((Context)this, FTPServerService.class);
                intent.setAction("action_start_ftp_service");
                this.startService(intent);
            }
        }
    }

    static /* synthetic */ FTPServerService b(ServerControlActivity serverControlActivity) {
        return serverControlActivity.i;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b() {
        com.xiaomi.miftp.c.c.a(a, "Updating UI");
        WifiInfo wifiInfo = ((WifiManager)this.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        String string = wifiInfo != null ? wifiInfo.getSSID() : null;
        boolean bl = true;
        boolean bl2 = wifiInfo != null && wifiInfo.getIpAddress() != 0;
        if (!bl2) {
            string = this.g.b(2131689774);
        }
        ((TextView)this.findViewById(2131296927)).setText((CharSequence)string);
        ImageView imageView = (ImageView)this.findViewById(2131296928);
        int n2 = bl2 ? 2131231362 : 2131231361;
        imageView.setImageResource(n2);
        if (this.i == null || !FTPServerService.a()) {
            bl = false;
        }
        if (bl && this.h) {
            com.xiaomi.miftp.c.c.a(a, "updateUi: server is running");
            InetAddress inetAddress = this.i.b();
            if (inetAddress != null) {
                StringBuilder stringBuilder = new StringBuilder(":");
                stringBuilder.append(this.i.a);
                String string2 = stringBuilder.toString();
                TextView textView = this.b;
                StringBuilder stringBuilder2 = new StringBuilder("ftp://");
                stringBuilder2.append(inetAddress.getHostAddress());
                if (this.i.a == 21) {
                    string2 = "";
                }
                stringBuilder2.append(string2);
                textView.setText((CharSequence)stringBuilder2.toString());
            } else {
                this.c();
                this.b.setText((CharSequence)"");
            }
        }
        this.e.setEnabled(bl2);
        TextView textView = (TextView)this.findViewById(2131296774);
        if (bl2) {
            com.xiaomi.midrop.util.Locale.b b2;
            int n3;
            if (bl) {
                b2 = this.g;
                n3 = 2131689948;
            } else {
                b2 = this.g;
                n3 = 2131689939;
            }
            CharSequence charSequence = b2.a(n3);
            textView.setText(charSequence);
            textView.setTextColor(this.getResources().getColor(2131099994));
            int n4 = bl ? 2131231000 : 2131230999;
            textView.setCompoundDrawablesWithIntrinsicBounds(n4, 0, 0, 0);
            this.f.setEnabled(bl ^ true);
        } else {
            textView.setText(this.g.a(2131689773));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            textView.setTextColor(-7829368);
        }
        TextView textView2 = this.b;
        int n5 = 8;
        int n6 = bl ? 0 : 8;
        textView2.setVisibility(n6);
        this.b.setSelected(bl);
        TextView textView3 = this.c;
        int n7 = bl ? 0 : 8;
        textView3.setVisibility(n7);
        TextView textView4 = this.d;
        if (!bl) {
            n5 = 0;
        }
        textView4.setVisibility(n5);
        if (ae.c() != null) {
            Toast.makeText((Context)this, (CharSequence)ae.c(), (int)0).show();
            ae.d();
        }
    }

    private void c() {
        if (!this.h) {
            return;
        }
        this.h = false;
        this.unbindService(this.j);
        this.stopService(new Intent((Context)this, FTPServerService.class));
    }

    static /* synthetic */ void c(ServerControlActivity serverControlActivity) {
        serverControlActivity.e();
    }

    private void d() {
        com.xiaomi.miftp.view.a a2 = new com.xiaomi.miftp.view.a((Context)this);
        a2.b = new a.a(this){
            final /* synthetic */ ServerControlActivity a;
            {
                this.a = serverControlActivity;
            }

            public final void a() {
                ServerControlActivity.c(this.a);
            }
        };
        SharedPreferences sharedPreferences = a2.a();
        if (sharedPreferences != null) {
            View view;
            View view2;
            String string2 = sharedPreferences.getString("username", "");
            String string3 = sharedPreferences.getString("password", "");
            View view3 = LayoutInflater.from((Context)this).inflate(R.layout.ftp_account, null);
            a2.d = (EditText)view3.findViewById(R.id.username);
            a2.e = (EditText)view3.findViewById(R.id.password);
            boolean bl = this != null && TextUtils.getLayoutDirectionFromLocale((Locale)this.getResources().getConfiguration().locale) == 1;
            if (bl) {
                a2.d.setLayoutDirection(1);
                a2.e.setLayoutDirection(1);
            } else {
                a2.d.setLayoutDirection(3);
                a2.e.setLayoutDirection(3);
            }
            a2.d.setText((CharSequence)string2);
            a2.e.setText((CharSequence)string3);
            a2.d.requestFocus();
            d.a a3 = new d.a(a2.a).a(view3).a(R.string.ftp_username_and_passworld);
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener(a2){
                final /* synthetic */ com.xiaomi.miftp.view.a a;
                {
                    this.a = a2;
                }

                public final void onClick(DialogInterface dialogInterface, int n2) {
                    this.a.f.onClick(null);
                }
            };
            a3.a.h = a3.a.a.getText(2131689541);
            a3.a.i = onClickListener;
            a3.a.j = a3.a.a.getText(2131689536);
            a3.a.k = null;
            a2.c = a3.b();
            Window window = a2.c.getWindow();
            if (window != null && (view = window.getDecorView()) != null && (view2 = view.findViewById(16908313)) != null) {
                view2.setOnClickListener(a2.f);
            }
        }
    }

    static /* synthetic */ void d(ServerControlActivity serverControlActivity) {
        serverControlActivity.d();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void e() {
        var1_1 = ah.a();
        var2_2 = ai.a(MiDropApplication.a());
        var3_3 = new ArrayList();
        if (var2_2 != null) {
            for (e var16_5 : var2_2) {
                if (!var16_5.a()) continue;
                var3_3.add((Object)var16_5);
            }
        }
        var1_1.a = var3_3;
        if (var3_3.isEmpty()) {
            return;
        }
        if (var3_3.size() <= 1) {
            this.a((e)var3_3.get(0));
            return;
        }
        var4_6 = new String[var3_3.size()];
        var5_7 = 0;
        do {
            block10 : {
                block8 : {
                    block12 : {
                        block11 : {
                            block9 : {
                                if (var5_7 >= var3_3.size()) {
                                    var6_14 = new d.a((Context)this).a(this.g.b(2131689876));
                                    var7_15 = new DialogInterface.OnClickListener(this, var3_3){
                                        final /* synthetic */ ArrayList a;
                                        final /* synthetic */ ServerControlActivity b;
                                        {
                                            this.b = serverControlActivity;
                                            this.a = arrayList;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int n2) {
                                            ServerControlActivity.a(this.b, (e)this.a.get(n2));
                                        }
                                    };
                                    var6_14.a.q = var4_6;
                                    var6_14.a.s = var7_15;
                                    var6_14.b(this.g.a(2131689544), new DialogInterface.OnClickListener(this){
                                        final /* synthetic */ ServerControlActivity a;
                                        {
                                            this.a = serverControlActivity;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int n2) {
                                            dialogInterface.dismiss();
                                        }
                                    }).a().show();
                                    return;
                                }
                                var8_8 = (e)var3_3.get(var5_7);
                                if (!TextUtils.isEmpty((CharSequence)var8_8.c())) break block8;
                                ah.a();
                                if (var8_8 != null) break block9;
                                var9_11 = "";
                                break block10;
                            }
                            var11_9 = var8_8.c();
                            if (!TextUtils.isEmpty((CharSequence)var11_9)) ** GOTO lbl-1000
                            var12_12 = var8_8.f || !var8_8.c && !ah.c(var8_8) && !ah.a(var8_8);
                            if (!var12_12) break block11;
                            var13_10 = MiDropApplication.a();
                            var14_13 = 2131689954;
                            ** GOTO lbl48
                        }
                        if (!ah.c(var8_8)) break block12;
                        var13_10 = MiDropApplication.a().getApplicationContext();
                        var14_13 = 2131689953;
                        ** GOTO lbl48
                    }
                    if (ah.b(var8_8)) {
                        var13_10 = MiDropApplication.a();
                        var14_13 = 2131689950;
lbl48: // 3 sources:
                        var9_11 = var13_10.getString(var14_13);
                    } else lbl-1000: // 2 sources:
                    {
                        var9_11 = var11_9;
                    }
                    break block10;
                }
                var9_11 = var8_8.c();
            }
            var4_6[var5_7] = var9_11;
            ++var5_7;
        } while (true);
    }

    public void onClick(View view) {
        int n2 = view.getId();
        if (n2 != 2131296300) {
            if (n2 != 2131296485) {
                if (n2 != 2131296773) {
                    if (n2 != 2131296926) {
                        return;
                    }
                    this.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                    return;
                }
                ae.d();
                if (this.h && this.i != null && FTPServerService.a()) {
                    ServerControlActivity.super.c();
                    return;
                }
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)this);
                if (sharedPreferences != null) {
                    if (!sharedPreferences.getBoolean("rmb_fp_cf", false) && !sharedPreferences.getBoolean("ar_fp_at_cf", false)) {
                        b b2 = new b((Context)this);
                        b2.b = new b.a((ServerControlActivity)this){
                            final /* synthetic */ ServerControlActivity a;
                            {
                                this.a = serverControlActivity;
                            }

                            public final void a(boolean bl) {
                                if (bl) {
                                    ServerControlActivity.c(this.a);
                                    return;
                                }
                                ServerControlActivity.d(this.a);
                            }
                        };
                        if (b2.a != null && b2.a() != null) {
                            View view2 = LayoutInflater.from((Context)b2.a).inflate(2131427449, null);
                            View view3 = view2.findViewById(2131296315);
                            View view4 = view2.findViewById(2131296280);
                            b2.c = (CheckBox)view3.findViewById(2131296314);
                            b2.d = (CheckBox)view4.findViewById(2131296279);
                            b2.e = (CheckBox)view2.findViewById(2131296679);
                            b2.c.setOnClickListener(new View.OnClickListener(b2){
                                final /* synthetic */ b a;
                                {
                                    this.a = b2;
                                }

                                public void onClick(View view) {
                                    b.a(this.a, 0);
                                }
                            });
                            b2.d.setOnClickListener(new View.OnClickListener(b2){
                                final /* synthetic */ b a;
                                {
                                    this.a = b2;
                                }

                                public void onClick(View view) {
                                    b.a(this.a, 1);
                                }
                            });
                            view3.setOnClickListener(new View.OnClickListener(b2){
                                final /* synthetic */ b a;
                                {
                                    this.a = b2;
                                }

                                public void onClick(View view) {
                                    b.a(this.a, 0);
                                }
                            });
                            view4.setOnClickListener(new View.OnClickListener(b2){
                                final /* synthetic */ b a;
                                {
                                    this.a = b2;
                                }

                                public void onClick(View view) {
                                    b.a(this.a, 1);
                                }
                            });
                            c c2 = new c(b2.a);
                            c2.a = b2.a.getString(2131689560);
                            c2.f = view2;
                            c2.b(b2.a.getString(2131689541), new View.OnClickListener(b2){
                                final /* synthetic */ b a;
                                {
                                    this.a = b2;
                                }

                                public void onClick(View view) {
                                    boolean bl = this.a.c.isChecked();
                                    boolean bl2 = this.a.e.isChecked();
                                    SharedPreferences sharedPreferences = this.a.a();
                                    if (sharedPreferences == null) {
                                        return;
                                    }
                                    android.content.SharedPreferences$Editor editor = sharedPreferences.edit();
                                    editor.putInt("lst_fp_cf", bl ^ true);
                                    editor.putBoolean("rmb_fp_cf", bl2);
                                    editor.putBoolean("anonymous_login", bl);
                                    editor.apply();
                                    if (this.a.b != null) {
                                        this.a.b.a(bl);
                                    }
                                }
                            });
                            c2.a((String)b2.a.getString((int)2131689536), null).j = 0;
                            android.support.v7.app.c c3 = c2.d();
                            if (c3.getWindow() != null) {
                                c3.getWindow().setSoftInputMode(5);
                            }
                            b2.f = c2.e;
                            b2.f.setEnabled(false);
                        }
                        return;
                    }
                    if (!sharedPreferences.getBoolean("anonymous_login", false)) {
                        String string2 = sharedPreferences.getString("username", "");
                        String string3 = sharedPreferences.getString("password", "");
                        if (!g.b(string2) || !g.b(string3)) {
                            ServerControlActivity.super.d();
                            return;
                        }
                    }
                    ServerControlActivity.super.e();
                }
                return;
            }
            this.onBackPressed();
            return;
        }
        this.startActivity(new Intent((Context)this, ServerControlPreference.class));
        af.a(af.a.bd).a();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void onCreate(Bundle bundle) {
        Intent intent;
        int n2;
        com.xiaomi.midrop.util.Locale.b b2;
        super.onCreate(bundle);
        this.setContentView(2131427564);
        this.g = com.xiaomi.midrop.util.Locale.b.a();
        this.b = (TextView)this.findViewById(2131296540);
        this.c = (TextView)this.findViewById(2131296531);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1.");
        stringBuilder.append(this.g.a(2131689732));
        stringBuilder.append("\n2.");
        stringBuilder.append(this.g.a(2131689731));
        this.c.setText((CharSequence)stringBuilder.toString());
        TextView textView = this.d = (TextView)this.findViewById(2131296532);
        if (com.xiaomi.miftp.c.b.b.booleanValue()) {
            b2 = this.g;
            n2 = 2131689733;
        } else {
            b2 = this.g;
            n2 = 2131689734;
        }
        CharSequence charSequence = b2.a(n2);
        textView.setText(charSequence);
        this.e = this.findViewById(2131296773);
        this.e.setOnClickListener((View.OnClickListener)this);
        this.c(2131427448);
        View view = this.t();
        ((TextView)view.findViewById(2131296810)).setText(this.g.a(2131689614));
        View view2 = view.findViewById(2131296485);
        view2.setOnClickListener((View.OnClickListener)this);
        if (ac.c((Context)this)) {
            view2.setRotation(180.0f);
        }
        this.f = view.findViewById(2131296300);
        this.f.setOnClickListener((View.OnClickListener)this);
        ServerControlActivity.super.b();
        this.findViewById(2131296926).setOnClickListener(new View.OnClickListener((ServerControlActivity)this){
            final /* synthetic */ ServerControlActivity a;
            {
                this.a = serverControlActivity;
            }

            public void onClick(View view) {
                Intent intent = new Intent("android.settings.WIFI_SETTINGS");
                this.a.startActivity(intent);
            }
        });
        com.xiaomi.miftp.c.c.a(a, "Registered for wifi updates");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.registerReceiver(this.k, intentFilter);
        if (Build.VERSION.SDK_INT >= 23 && android.support.v4.content.a.a((Context)this, (String)"android.permission.READ_EXTERNAL_STORAGE") != 0) {
            this.a(com.xiaomi.midrop.e.b, 114, new a.a((ServerControlActivity)this){
                final /* synthetic */ ServerControlActivity a;
                {
                    this.a = serverControlActivity;
                }

                public final void a() {
                    this.a.u();
                }

                public final void a(int n2) {
                }
            });
        }
        if ((intent = this.getIntent()) != null) {
            intent.getAction();
            if ("android.intent.action.SEND".equals((Object)"com.xiaomi.midrop.action.FTP")) {
                af.a(intent);
            }
        }
        if (FTPServerService.a()) {
            this.h = this.bindService(new Intent((Context)this, FTPServerService.class), this.j, 1);
        }
    }

    @Override
    public void onDestroy() {
        if (this.i != null && FTPServerService.a()) {
            this.c();
        }
        this.unregisterReceiver(this.k);
        super.onDestroy();
    }

    public void onEventMainThread(com.xiaomi.miftp.a.b b2) {
        ServerControlActivity.super.b();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.finish();
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.b();
    }

    @Override
    public void onStart() {
        super.onStart();
        de.greenrobot.event.c.a().a((Object)this);
        this.b();
    }

    @Override
    protected void onStop() {
        super.onStop();
        de.greenrobot.event.c.a().b((Object)this);
    }
}

