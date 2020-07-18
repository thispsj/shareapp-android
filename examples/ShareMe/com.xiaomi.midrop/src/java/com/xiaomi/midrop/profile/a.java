/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.widget.ImageView
 *  com.xiaomi.midrop.util.y
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Random
 */
package com.xiaomi.midrop.profile;

import a.e.b.d;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.sender.c.i;
import com.xiaomi.midrop.util.y;
import java.io.File;
import java.util.Random;

public final class a {
    public static final a a = new a(0);
    private static final Uri b;
    private static final Uri c;
    private static final Uri d;
    private static final String e;

    static {
        Context context = MiDropApplication.a();
        d.a((Object)context, "MiDropApplication.getApplication()");
        Uri uri = Uri.fromFile((File)new File(context.getFilesDir(), "profile_crop_temp"));
        d.a((Object)uri, "Uri.fromFile(File(MiDrop\u2026ir, \"profile_crop_temp\"))");
        b = uri;
        Context context2 = MiDropApplication.a();
        d.a((Object)context2, "MiDropApplication.getApplication()");
        Uri uri2 = Uri.fromFile((File)new File(context2.getFilesDir(), "profile_temp"));
        d.a((Object)uri2, "Uri.fromFile(File(MiDrop\u2026ilesDir, \"profile_temp\"))");
        c = uri2;
        Context context3 = MiDropApplication.a();
        d.a((Object)context3, "MiDropApplication.getApplication()");
        Uri uri3 = Uri.fromFile((File)new File(context3.getFilesDir(), "profile"));
        d.a((Object)uri3, "Uri.fromFile(File(MiDrop\u2026.filesDir, PROFILE_NAME))");
        d = uri3;
        String string2 = i.a();
        d.a((Object)string2, "UpgradePackageUtils.getSilenceStoragePath()");
        e = string2;
    }

    public static final /* synthetic */ Uri a() {
        return b;
    }

    public static final /* synthetic */ Uri b() {
        return c;
    }

    public static final /* synthetic */ Uri c() {
        return d;
    }

    public static final /* synthetic */ String d() {
        return e;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte by) {
        }

        public static int a(int n) {
            return (int)(new Random().nextFloat() * (float)(n - 3));
        }

        public static int a(String string2) {
            d.b(string2, "deviceId");
            return y.b((String)string2);
        }

        public static /* synthetic */ void a(ImageView imageView, int n, Uri uri, int n2) {
            if ((n2 & 2) != 0) {
                n = -1;
            }
            if ((n2 & 4) != 0) {
                uri = null;
            }
            d.b((Object)imageView, "view");
            Context context = MiDropApplication.a();
            d.a((Object)context, "MiDropApplication.getApplication()");
            TypedArray typedArray = context.getResources().obtainTypedArray(2130903044);
            d.a((Object)typedArray, "MiDropApplication.getApp\u2026ray(R.array.profile_icon)");
            int n3 = -3 + typedArray.length();
            if (n >= 0 && n3 >= n) {
                int n4 = typedArray.getResourceId(n, -1);
                Context context2 = imageView.getContext();
                d.a((Object)context2, "view.context");
                imageView.setImageDrawable(context2.getResources().getDrawable(n4));
            } else {
                imageView.setImageURI(uri);
            }
            typedArray.recycle();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public static void a(ImageView var0_1, int var1, String var2_3, String var3_2) {
            d.b((Object)var0_1, "view");
            d.b(var2_3, "deviceId");
            if (var1 < 0 && !TextUtils.isEmpty((CharSequence)var3_2)) {
                var0_1.setImageDrawable((Drawable)new com.xiaomi.midrop.a.a(var3_2));
                return;
            }
            var4_4 = MiDropApplication.a();
            d.a((Object)var4_4, "MiDropApplication.getApplication()");
            var5_5 = var4_4.getResources().obtainTypedArray(2130903044);
            d.a((Object)var5_5, "MiDropApplication.getApp\u2026ray(R.array.profile_icon)");
            var6_6 = -3 + var5_5.length();
            if (var1 >= 0 && var6_6 >= var1) ** GOTO lbl20
            var7_9 = new File(a.d(), var2_3);
            if (var7_9.exists()) {
                var0_1.setImageURI(Uri.fromFile((File)var7_9));
            } else if (!TextUtils.isEmpty((CharSequence)var3_2)) {
                var0_1.setImageDrawable((Drawable)new com.xiaomi.midrop.a.a(var3_2));
            } else {
                var1 = a.a(var5_5.length());
lbl20: // 2 sources:
                var8_7 = var5_5.getResourceId(var1, -1);
                var9_8 = var0_1.getContext();
                d.a((Object)var9_8, "view.context");
                var0_1.setImageDrawable(var9_8.getResources().getDrawable(var8_7));
                a.a(var2_3, var1);
            }
            var5_5.recycle();
        }

        public static void a(String string2, int n) {
            d.b(string2, "deviceId");
            y.b((String)string2, (int)n);
        }

        public static boolean b(String string2) {
            d.b(string2, "deviceId");
            return a.a(string2) >= 0;
        }
    }

}

