/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.f
 *  a.e.a.m
 *  a.i.g
 *  android.content.Context
 *  android.net.Uri
 *  com.xiaomi.midrop.send.contacts.a$a$b
 *  com.xiaomi.midrop.send.contacts.a$a$c
 *  com.xiaomi.midrop.util.Locale.b
 *  com.xiaomi.midrop.util.ad
 *  com.xiaomi.midrop.util.ad$a
 *  com.xiaomi.midrop.util.j
 *  ezvcard.VCard
 *  ezvcard.a
 *  ezvcard.property.FormattedName
 *  ezvcard.property.Telephone
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Set
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 *  kotlinx.coroutines.al
 *  kotlinx.coroutines.e
 *  kotlinx.coroutines.y
 *  kotlinx.coroutines.z
 *  midrop.service.c.d
 */
package com.xiaomi.midrop.send.contacts;

import a.e.a.m;
import a.e.b.d;
import a.i.f;
import a.i.g;
import android.content.Context;
import android.net.Uri;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.send.contacts.a;
import com.xiaomi.midrop.sender.c.e;
import com.xiaomi.midrop.util.ad;
import com.xiaomi.midrop.util.j;
import ezvcard.VCard;
import ezvcard.property.FormattedName;
import ezvcard.property.Telephone;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.coroutines.al;
import kotlinx.coroutines.y;
import kotlinx.coroutines.z;

public final class a {
    public static final a a = new a(0);
    private static final List<String> b = (List)new ArrayList();
    private static final Set<String> c = (Set)new LinkedHashSet();

    public static final /* synthetic */ List a() {
        return b;
    }

    public static final List<Uri> a(List<? extends Uri> list) {
        Uri uri;
        d.b(list, "uris");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Uri uri2 : list) {
            if (d.a((Object)"midrop.contact", (Object)uri2.getScheme())) {
                arrayList.add((Object)uri2);
                continue;
            }
            arrayList2.add((Object)uri2);
        }
        Context context = MiDropApplication.a();
        if (context != null && (uri = ad.a.a((Context)context, (List)((List)arrayList))) != null) {
            arrayList2.add((Object)uri);
        }
        return (List)arrayList2;
    }

    public static final void a(Context context, String string2, c c2) {
        d.b((Object)context, "context");
        d.b(c2, "callback");
        if (string2 == null) {
            c2.a(false);
        }
        kotlinx.coroutines.e.a((y)z.a((a.b.e)((a.b.e)al.b())), (m)((m)new a.b(string2, c2, context, null)));
    }

    public static final void a(String string2, b b2) {
        d.b(string2, "filePath");
        d.b(b2, "callback");
        String string3 = j.a((String)string2);
        d.a((Object)string3, "FileUtils.getNameFromFilepath(filePath)");
        List list = g.b((CharSequence)string3, (String[])new String[]{"-"});
        String string4 = "";
        String string5 = "";
        int n2 = list.size();
        int n3 = 1;
        if (n2 > 4) {
            int n4;
            try {
                n4 = Integer.parseInt((String)((String)list.get(n3)));
            }
            catch (NumberFormatException numberFormatException) {
                midrop.service.c.d.a((String)"ContactHelper", (String)"phone number format exception", (Throwable)numberFormatException, (Object[])new Object[0]);
                n4 = 0;
            }
            if (n4 > n3) {
                com.xiaomi.midrop.util.Locale.b b3 = com.xiaomi.midrop.util.Locale.b.a();
                Object[] arrobject = new Object[n3];
                arrobject[0] = n4;
                String string6 = b3.a(2131558400, n4, arrobject);
                d.a((Object)string6, "LanguageUtil.getIns().ge\u2026ntactCount, contactCount)");
                String string7 = (String)list.get(2);
                if (n4 > 2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string7);
                    stringBuilder.append("\u2026");
                    string7 = stringBuilder.toString();
                }
                string5 = string7;
                string4 = string6;
            } else {
                string4 = (String)list.get(2);
                string5 = (String)list.get(3);
            }
        } else {
            n3 = 0;
        }
        b2.a((boolean)n3, string4, string5);
    }

    public static final boolean a(String string2) {
        if (string2 == null) {
            return false;
        }
        File file = new File(string2);
        if (!file.exists()) {
            return false;
        }
        String string3 = a.a(file);
        return b.contains((Object)string3);
    }

    public static final /* synthetic */ Set b() {
        return c;
    }

    public static final boolean b(String string2) {
        if (string2 == null) {
            return false;
        }
        File file = new File(string2);
        if (!file.exists()) {
            return false;
        }
        String string3 = a.a(file);
        return c.contains((Object)string3);
    }

    public static final void c() {
        kotlinx.coroutines.e.a((y)z.a((a.b.e)((a.b.e)al.c())), (m)((m)new a.c(null)));
    }

    public static final boolean c(String string2) {
        if (string2 != null) {
            CharSequence charSequence = string2;
            f f2 = new f("^midrop-\\d+-.*\\.vcf$");
            d.b((Object)charSequence, "input");
            return f2.a.matcher(charSequence).matches();
        }
        return false;
    }

    public static final boolean d(String string2) {
        return a.a(string2);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte by) {
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        public static String a(Context var0_1, List<? extends Uri> var1, int var2_2) {
            block10 : {
                block9 : {
                    d.b((Object)var0_1, "context");
                    d.b(var1, "fileUris");
                    var3_3 = (List)new ArrayList();
                    var4_4 = "";
                    try {
                        var14_5 = var1.iterator();
                        var15_6 = 0;
lbl8: // 2 sources:
                        while (var14_5.hasNext()) {
                            var16_17 = ezvcard.a.a((File)new File(e.a(var0_1, (Uri)var14_5.next()))).a();
                            if (var16_17 == null) break block9;
                            var17_15 = var16_17.b();
                            var18_10 = true;
                            if (var17_15 == null || (var19_7 = (String)var17_15.getValue()) == null || (var20_18 = g.a((String)var19_7, (String)"-", (String)"")) == null) ** GOTO lbl22
                            if (var20_18 == null) {
                                throw new a.j("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                            var26_11 = g.b((CharSequence)var20_18).toString();
                            if (var26_11 == null) ** GOTO lbl22
                        }
                        break block10;
lbl19: // 2 sources:
                        do {
                            if (var26_11 != null) {
                                var3_3.add((Object)var26_11);
                            }
lbl22: // 5 sources:
                            if (var15_6 != 0 || (var21_16 = (Telephone)a.a.f.a((List)var16_17.b(Telephone.class))) == null || (var22_8 = var21_16.getText()) == null || (var23_12 = g.a((String)var22_8, (String)"-", (String)"")) == null) break;
                            if (var23_12 == null) {
                                throw new a.j("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                            var24_13 = g.b((CharSequence)var23_12).toString();
                            if (var24_13 == null) break;
                            var25_14 = ((CharSequence)var24_13).length();
                            if (var25_14 <= 0) {
                                var18_10 = false;
                            }
                            if (!var18_10) {
                                var24_13 = null;
                            }
                            if (var24_13 == null) break;
                            var4_4 = var24_13;
                            break;
                        } while (true);
                    }
                    catch (Exception var5_19) {
                        midrop.service.c.d.a((String)"ContactHelper", (String)"parse first contact failed", (Throwable)var5_19, (Object[])new Object[0]);
                    }
                }
                if (++var15_6 == 2) break block10;
                ** GOTO lbl8
            }
            var6_20 = a.a.f.a((Iterable)((Iterable)var3_3), (CharSequence)"\u3001");
            var7_21 = new StringBuilder("midrop-");
            var7_21.append(var2_2);
            var7_21.append('-');
            var7_21.append(var6_20);
            var7_21.append('-');
            var7_21.append(var4_4);
            var7_21.append("-.vcf");
            return var7_21.toString();
            var27_9 = ((CharSequence)var26_11).length() > 0;
            if (var27_9) ** GOTO lbl19
            var26_11 = null;
            ** while (true)
        }

        static String a(File file) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(file.hashCode());
            stringBuilder.append('-');
            stringBuilder.append(file.length());
            return stringBuilder.toString();
        }

        public static boolean a(String string2) {
            if (string2 != null) {
                List list = g.b((CharSequence)string2, (String[])new String[]{"-"});
                if (list != null) {
                    boolean bl = list.size() > 4;
                    if (!bl) {
                        list = null;
                    }
                    if (list != null) {
                        try {
                            int n2 = Integer.parseInt((String)((String)list.get(1)));
                            boolean bl2 = false;
                            if (n2 > 2) {
                                bl2 = true;
                            }
                            return bl2;
                        }
                        catch (NumberFormatException numberFormatException) {
                            midrop.service.c.d.a((String)"ContactHelper", (String)"Contact file path parse failed,e:", (Throwable)numberFormatException, (Object[])new Object[0]);
                        }
                    }
                }
            }
            return false;
        }
    }

    public static interface b {
        public void a(boolean var1, String var2, String var3);
    }

    public static interface c {
        public void a(boolean var1);
    }

}

