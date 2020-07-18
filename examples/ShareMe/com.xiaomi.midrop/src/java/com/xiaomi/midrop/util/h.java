/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v4.content.a
 *  android.text.TextUtils
 *  android.widget.ImageView
 *  com.bumptech.glide.e
 *  com.bumptech.glide.e.a
 *  com.bumptech.glide.e.a.i
 *  com.bumptech.glide.e.h
 *  com.bumptech.glide.k
 *  com.bumptech.glide.load.b.j
 *  com.bumptech.glide.load.d.a.f
 *  com.bumptech.glide.load.d.c.c
 *  com.bumptech.glide.m
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 */
package com.xiaomi.midrop.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.e;
import com.bumptech.glide.e.a;
import com.bumptech.glide.e.a.i;
import com.bumptech.glide.k;
import com.bumptech.glide.load.d.a.f;
import com.bumptech.glide.load.d.c.c;
import com.bumptech.glide.m;
import com.xiaomi.midrop.util.g;
import com.xiaomi.midrop.util.j;
import java.util.Locale;

public final class h {
    public static int a(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return 2131231212;
        }
        String string3 = j.d(string2);
        if (g.d(string3)) {
            return 2131231208;
        }
        if (!"txt".equals((Object)string3)) {
            if ("zip".equals((Object)string3)) {
                return 2131231212;
            }
            if (g.a(string3)) {
                return 2131231210;
            }
            if (g.b(string3)) {
                return 2131231216;
            }
            if (g.c(string3)) {
                return 2131231214;
            }
        }
        return 2131231212;
    }

    public static void a(Context context, ImageView imageView, int n2) {
        com.bumptech.glide.e.h h2 = (com.bumptech.glide.e.h)((com.bumptech.glide.e.h)new com.bumptech.glide.e.h().a(com.bumptech.glide.load.b.j.b)).b(n2);
        e.b((Context)context).a(Integer.valueOf((int)n2)).a((m)c.b()).a((a)h2).a(imageView);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(Context context, ImageView imageView, String string2) {
        com.bumptech.glide.e.h h2;
        c c2;
        k k2;
        if (!TextUtils.isEmpty((CharSequence)string2) && string2.endsWith("gif")) {
            h2 = (com.bumptech.glide.e.h)new com.bumptech.glide.e.h().a(com.bumptech.glide.load.b.j.d);
            k2 = e.b((Context)context).d().a(string2);
            c2 = f.b();
        } else {
            h2 = (com.bumptech.glide.e.h)new com.bumptech.glide.e.h().a(com.bumptech.glide.load.b.j.b);
            k2 = e.b((Context)context).a(string2);
            c2 = c.b();
        }
        k2.a((m)c2).a((a)h2).a(imageView);
    }

    public static void a(Context context, ImageView imageView, String string2, int n2) {
        com.bumptech.glide.e.h h2 = (com.bumptech.glide.e.h)((com.bumptech.glide.e.h)((com.bumptech.glide.e.h)((com.bumptech.glide.e.h)new com.bumptech.glide.e.h().a(com.bumptech.glide.load.b.j.d)).e()).a(n2)).h();
        e.b((Context)context).d().a(string2).a((m)f.b()).a((a)h2).a(imageView);
    }

    public static int b(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return 2131231036;
        }
        String string3 = j.d(string2);
        if (g.d(string3)) {
            return 2131231006;
        }
        if (!"txt".equals((Object)string3)) {
            if ("zip".equals((Object)string3)) {
                return 2131231036;
            }
            if (g.b(string3)) {
                return 2131231120;
            }
            if (g.c(string3)) {
                return 2131231066;
            }
            if (g.h(string2)) {
                if (com.xiaomi.midrop.send.contacts.a.d(j.a(string2))) {
                    return 2131231022;
                }
                return 2131231021;
            }
        }
        return 2131231036;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void b(Context var0_1, ImageView var1, String var2_2) {
        block30 : {
            block35 : {
                block36 : {
                    block32 : {
                        block34 : {
                            block33 : {
                                block31 : {
                                    var3_3 = j.d(var2_2).toLowerCase();
                                    var4_4 = g.e(var3_3);
                                    var5_5 = 2131100015;
                                    var6_6 = 2131100011;
                                    var7_7 = 2131100012;
                                    if (var4_4) {
                                        if (!TextUtils.equals((CharSequence)var3_3, (CharSequence)"doc") && !TextUtils.equals((CharSequence)var3_3, (CharSequence)"docx")) {
                                            if (TextUtils.equals((CharSequence)var3_3, (CharSequence)"wps")) {
                                                var6_6 = 2131100012;
                                            } else if (!TextUtils.equals((CharSequence)var3_3, (CharSequence)"xls") && !TextUtils.equals((CharSequence)var3_3, (CharSequence)"xlsx")) {
                                                if (TextUtils.equals((CharSequence)var3_3, (CharSequence)"ppt") || TextUtils.equals((CharSequence)var3_3, (CharSequence)"pptx")) {
                                                    var6_6 = 2131100008;
                                                }
                                            } else {
                                                var6_6 = 2131100015;
                                            }
                                        }
                                        var15_8 = android.support.v4.content.a.c((Context)var0_1, (int)var6_6);
lbl17: // 3 sources:
                                        do {
                                            var9_9 = var15_8;
                                            var8_10 = true;
                                            break block30;
                                            break;
                                        } while (true);
                                    }
                                    if (!g.a(var3_3)) break block31;
                                    if (TextUtils.equals((CharSequence)var3_3, (CharSequence)"mp3")) {
                                        do {
                                            var5_5 = 2131100009;
                                            break;
                                        } while (true);
                                    } else if (TextUtils.equals((CharSequence)var3_3, (CharSequence)"m4a")) {
                                        var5_5 = 2131100007;
                                    } else if (TextUtils.equals((CharSequence)var3_3, (CharSequence)"wma")) {
                                        var5_5 = 2131100010;
                                    } else if (TextUtils.equals((CharSequence)var3_3, (CharSequence)"wav")) {
                                        var5_5 = 2131100011;
                                    } else if (TextUtils.equals((CharSequence)var3_3, (CharSequence)"aac")) {
                                        var5_5 = 2131100012;
                                    } else if (TextUtils.equals((CharSequence)var3_3, (CharSequence)"ape")) {
                                        var5_5 = 2131100013;
                                    } else if (TextUtils.equals((CharSequence)var3_3, (CharSequence)"flac")) {
                                        var5_5 = 2131100014;
                                    } else if (!TextUtils.equals((CharSequence)var3_3, (CharSequence)"ogg")) {
                                        if (TextUtils.equals((CharSequence)var3_3, (CharSequence)"mid")) {
                                            var5_5 = 2131100016;
                                        } else {
                                            if (!TextUtils.equals((CharSequence)var3_3, (CharSequence)"amr")) ** continue;
                                            var5_5 = 2131100008;
                                        }
                                    }
                                    var15_8 = android.support.v4.content.a.c((Context)var0_1, (int)var5_5);
                                    ** GOTO lbl17
                                }
                                if (!g.f(var3_3)) break block32;
                                if (TextUtils.equals((CharSequence)var3_3, (CharSequence)"zip")) ** GOTO lbl67
                                if (!TextUtils.equals((CharSequence)var3_3, (CharSequence)"rar")) break block33;
lbl56: // 2 sources:
                                do {
                                    var7_7 = 2131100007;
                                    ** GOTO lbl67
                                    break;
                                } while (true);
                            }
                            if (!TextUtils.equals((CharSequence)var3_3, (CharSequence)"7z")) break block34;
                            var7_7 = 2131100015;
                            ** GOTO lbl67
                        }
                        if (!TextUtils.equals((CharSequence)var3_3, (CharSequence)"iso")) ** GOTO lbl67
lbl65: // 2 sources:
                        do {
                            var7_7 = 2131100011;
lbl67: // 8 sources:
                            do {
                                var15_8 = android.support.v4.content.a.c((Context)var0_1, (int)var7_7);
                                ** continue;
                                break;
                            } while (true);
                            break;
                        } while (true);
                    }
                    if (!g.g(var3_3)) break block35;
                    if (TextUtils.equals((CharSequence)var3_3, (CharSequence)"txt")) ** GOTO lbl67
                    if (!TextUtils.equals((CharSequence)var3_3, (CharSequence)"pdf")) break block36;
                    var7_7 = 2131100008;
                    ** GOTO lbl67
                }
                ** while (TextUtils.equals((CharSequence)var3_3, (CharSequence)"umd"))
lbl78: // 1 sources:
                if (TextUtils.equals((CharSequence)var3_3, (CharSequence)"ebk") || TextUtils.equals((CharSequence)var3_3, (CharSequence)"chm")) ** break;
                ** while (true)
                ** while (true)
            }
            var8_10 = false;
            var9_9 = 0;
        }
        if (var8_10) {
            var10_11 = (com.bumptech.glide.e.h)((com.bumptech.glide.e.h)new com.bumptech.glide.e.h().a(com.bumptech.glide.load.b.j.e)).a(2131231036);
            var11_12 = Locale.US;
            var12_13 = new Object[]{"midrop:icon/", var3_3, var9_9};
            var13_14 = String.format((Locale)var11_12, (String)"%s%s#%d", (Object[])var12_13);
            e.b((Context)var0_1).a(var13_14).a((a)var10_11).a(var1);
            return;
        }
        var1.setImageResource(h.b(var2_2));
    }

    public static void b(Context context, ImageView imageView, String string2, int n2) {
        StringBuilder stringBuilder = new StringBuilder("midrop:apk/");
        stringBuilder.append(string2);
        String string3 = stringBuilder.toString();
        com.bumptech.glide.e.h h2 = (com.bumptech.glide.e.h)((com.bumptech.glide.e.h)new com.bumptech.glide.e.h().a(com.bumptech.glide.load.b.j.e)).a(n2);
        e.b((Context)context).a(string3).a((a)h2).a(imageView);
    }

    public static void c(Context context, ImageView imageView, String string2, int n2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            com.bumptech.glide.e.h h2 = (com.bumptech.glide.e.h)((com.bumptech.glide.e.h)new com.bumptech.glide.e.h().a(com.bumptech.glide.load.b.j.b)).a(n2);
            String string3 = String.format((Locale)Locale.US, (String)"%s%s", (Object[])new Object[]{"midrop:base64/", string2});
            e.b((Context)context).a(string3).a((a)h2).a(imageView);
        }
    }
}

