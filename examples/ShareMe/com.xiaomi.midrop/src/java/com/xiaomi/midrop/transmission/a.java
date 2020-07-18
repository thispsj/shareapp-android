/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ActivityNotFoundException
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.support.v7.app.c
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  com.xiaomi.midrop.GalleryActivity
 *  com.xiaomi.midrop.OpenDirectoryActivity
 *  com.xiaomi.midrop.b.b
 *  com.xiaomi.midrop.transmission.OpenTransItemUtils
 *  com.xiaomi.midrop.transmission.c
 *  com.xiaomi.midrop.util.af
 *  com.xiaomi.midrop.util.af$a
 *  com.xiaomi.midrop.util.af$b
 *  com.xiaomi.midrop.util.d
 *  com.xiaomi.midrop.util.j
 *  com.xiaomi.midrop.util.y
 *  com.xiaomi.midrop.view.c
 *  com.xiaomi.miftp.view.dialog.d
 *  com.xiaomi.miftp.view.dialog.d$a
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  midrop.service.c.d
 */
package com.xiaomi.midrop.transmission;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.xiaomi.midrop.GalleryActivity;
import com.xiaomi.midrop.OpenDirectoryActivity;
import com.xiaomi.midrop.b.b;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.transmission.OpenTransItemUtils;
import com.xiaomi.midrop.transmission.c;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.d;
import com.xiaomi.midrop.util.j;
import com.xiaomi.midrop.util.y;
import com.xiaomi.miftp.view.dialog.d;
import java.util.List;

public final class a {
    private static String a = "OpenTransItemUtils";
    private static boolean b;
    private static boolean c;

    static /* synthetic */ void a(Context context, Intent intent) {
        a.b(context, intent);
    }

    private static void a(Context context, View.OnClickListener onClickListener) {
        if (b) {
            Log.e((String)a, (String)"mOpenFileDialog: skip");
            return;
        }
        if (y.z()) {
            onClickListener.onClick(null);
            return;
        }
        View view = LayoutInflater.from((Context)context).inflate(2131427422, null);
        CheckBox checkBox = (CheckBox)view.findViewById(2131296354);
        checkBox.setPaddingRelative(checkBox.getPaddingStart() + com.xiaomi.midrop.sender.c.c.a(context, 7.0f), checkBox.getPaddingTop(), checkBox.getPaddingEnd(), checkBox.getPaddingBottom());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            public final void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
                y.e((boolean)bl);
                String string2 = bl ? "on" : "off";
                af.a((af.a)af.a.dD).a(af.b.af, string2).a();
            }
        });
        com.xiaomi.midrop.view.c c2 = new com.xiaomi.midrop.view.c(context);
        c2.a = context.getString(2131689641);
        c2.b = context.getString(2131689783);
        c2.f = view;
        c2.b(context.getString(2131689541), onClickListener);
        c2.a((String)context.getString((int)2131689544), null).j = 1;
        android.support.v7.app.c c3 = c2.d();
        if (c3 != null) {
            b = true;
            c3.setOnDismissListener(new DialogInterface.OnDismissListener(){

                public final void onDismiss(DialogInterface dialogInterface) {
                    b = false;
                }
            });
        }
    }

    static /* synthetic */ void a(Context context, g g2) {
        a.b(context, g2);
    }

    public static void a(final Context context, final g g2, boolean bl) {
        if (g2 == null) {
            return;
        }
        String string2 = g2.i;
        String string3 = j.f((String)string2);
        if (bl) {
            if (g2.z == g.a.b) {
                b b2 = (b)g2;
                String string4 = b2.t;
                if (b2.b.size() > 1) {
                    g g3 = (g)b2.b.get(1);
                    int n2 = g3.r.indexOf("/");
                    string4 = n2 > 0 ? g3.r.substring(0, n2) : g3.r;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(d.c((Context)context));
                stringBuilder.append("/");
                stringBuilder.append(string4);
                string2 = stringBuilder.toString();
            }
            OpenDirectoryActivity.a((Context)context, (String)g2.t, (String)string2);
            return;
        }
        if (g2.E == 0 && !TextUtils.isEmpty((CharSequence)g2.x)) {
            if (!c.e().f() && !TextUtils.equals((CharSequence)g2.x, (CharSequence)context.getPackageName())) {
                a.a(context, new View.OnClickListener(context, g2){
                    final /* synthetic */ Context a;
                    final /* synthetic */ g b;
                    {
                        this.a = context;
                        this.b = g2;
                    }

                    public final void onClick(View view) {
                        a.a(this.a, this.b);
                    }
                });
                return;
            }
            a.b(context, g2);
            return;
        }
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            a.b(context, string3, string2, c.e().f(), g2);
            return;
        }
        d.a a2 = new d.a(context, 3);
        a2.a(2131689754);
        CharSequence[] arrcharSequence = new CharSequence[]{context.getString(2131689756), context.getString(2131689753), context.getString(2131689757), context.getString(2131689755)};
        a2.a(arrcharSequence, new DialogInterface.OnClickListener(){

            public final void onClick(DialogInterface dialogInterface, int n2) {
                String string2 = "";
                boolean bl = c.e().f();
                switch (n2) {
                    default: {
                        break;
                    }
                    case 3: {
                        string2 = "image/*";
                        bl = true;
                        break;
                    }
                    case 2: {
                        string2 = "video/*";
                        break;
                    }
                    case 1: {
                        string2 = "audio/*";
                        break;
                    }
                    case 0: {
                        string2 = "text/*";
                    }
                }
                a.b(context, string2, g2.i, bl, g2);
                dialogInterface.dismiss();
            }
        });
        a2.b();
    }

    private static void b(Context context, Intent intent) {
        try {
            context.startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            new StringBuilder("Activity not found=").append((Object)activityNotFoundException);
            return;
        }
    }

    private static void b(Context context, g g2) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(g2.x);
        if (intent != null) {
            if (TextUtils.equals((CharSequence)intent.getPackage(), (CharSequence)context.getPackageName())) {
                return;
            }
            a.b(context, intent);
        }
    }

    private static void b(Context context, String string2, String string3, boolean bl, g g2) {
        if (TextUtils.equals((CharSequence)"image/*", (CharSequence)string2) && g2 != null) {
            GalleryActivity.a((Context)context, (g)g2, (String)"gallery.view");
            return;
        }
        Intent intent = j.a((Context)context, (String)string2, (String)string3);
        if (intent == null) {
            midrop.service.c.d.b((String)a, (String)"openFileByType get intent failed!", (Object[])new Object[0]);
            return;
        }
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            return;
        }
        if (TextUtils.equals((CharSequence)"application/vnd.android.package-archive", (CharSequence)string2) && TextUtils.equals((CharSequence)g2.x, (CharSequence)context.getPackageName())) {
            View.OnClickListener onClickListener = new View.OnClickListener(context, intent){
                final /* synthetic */ Context a;
                final /* synthetic */ Intent b;
                {
                    this.a = context;
                    this.b = intent;
                }

                public final void onClick(View view) {
                    a.a(this.a, this.b);
                }
            };
            if (c) {
                Log.e((String)a, (String)"mInstallMiDropDialog: skip");
                return;
            }
            com.xiaomi.midrop.view.c c2 = new com.xiaomi.midrop.view.c(context);
            c2.a = context.getString(2131689641);
            c2.b = context.getString(2131689730);
            c2.b(context.getString(2131689541), onClickListener);
            c2.a((String)context.getString((int)2131689544), null).j = 1;
            android.support.v7.app.c c3 = c2.d();
            if (c3 != null) {
                c = true;
                c3.setOnDismissListener(new DialogInterface.OnDismissListener(){

                    public final void onDismiss(DialogInterface dialogInterface) {
                        c = false;
                    }
                });
            }
            return;
        }
        boolean bl2 = TextUtils.equals((CharSequence)intent.getPackage(), (CharSequence)"com.miui.player");
        if (!bl && !bl2) {
            a.a(context, new View.OnClickListener(context, intent){
                final /* synthetic */ Context a;
                final /* synthetic */ Intent b;
                {
                    this.a = context;
                    this.b = intent;
                }

                public final void onClick(View view) {
                    a.a(this.a, this.b);
                }
            });
            return;
        }
        a.b(context, intent);
    }

}

