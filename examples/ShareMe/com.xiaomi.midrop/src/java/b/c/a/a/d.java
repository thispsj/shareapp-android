/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.i.g
 *  android.text.TextUtils
 *  android.util.SparseArray
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 */
package b.c.a.a;

import a.i.g;
import android.text.TextUtils;
import android.util.SparseArray;
import b.c.a.a.c;
import b.c.a.a.d;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.e;
import com.xiaomi.midrop.util.y;
import com.xiaomi.midrop.webshare.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class d
extends c {
    private static final String b = "d";
    public a a;
    private com.xiaomi.midrop.webshare.b g;
    private Map<String, b> h;
    private SparseArray<List<com.xiaomi.midrop.webshare.b>> i;
    private int j;
    private String k;
    private String l;

    public d() {
        this(0);
    }

    private d(byte by) {
        super('\u0000');
    }

    private d(char c2) {
        super(7007);
        this.h = new HashMap();
        this.k = "";
        this.l = "";
    }

    private static c.k a(c.k.b b2, String string2, String string3) {
        c.k k2 = new c.k(b2, string2, string3);
        k2.a("Accept-Ranges", "bytes");
        return k2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private c.k a(final String var1_4, Map<String, String> var2_5, final String var3_2, String var4_3, String var5_1) {
        block38 : {
            block36 : {
                block39 : {
                    block37 : {
                        block35 : {
                            block34 : {
                                block33 : {
                                    block32 : {
                                        block29 : {
                                            block30 : {
                                                var6_6 = new File(var3_2);
                                                var7_7 = new StringBuilder();
                                                var7_7.append(var6_6.getAbsolutePath());
                                                var7_7.append(var6_6.lastModified());
                                                var7_7.append(var6_6.length());
                                                var14_8 = Integer.toHexString((int)var7_7.toString().hashCode());
                                                var15_9 = (String)var2_5.get((Object)"range");
                                                if (var15_9 == null) break block29;
                                                if (!var15_9.startsWith("bytes=")) break block29;
                                                var60_10 = (var15_9 = var15_9.substring(6)).indexOf(45);
                                                if (var60_10 > 0) {
                                                    block31 : {
                                                        var63_11 = Long.parseLong((String)var15_9.substring(0, var60_10));
                                                        var67_12 = var60_10 + 1;
                                                        try {
                                                            var61_13 = Long.parseLong((String)var15_9.substring(var67_12));
                                                            break block30;
                                                        }
                                                        catch (NumberFormatException var68_14) {
                                                            var66_15 = var68_14;
                                                            break block31;
                                                        }
                                                        catch (NumberFormatException var65_16) {
                                                            var66_15 = var65_16;
                                                            var63_11 = 0L;
                                                        }
                                                    }
                                                    var66_15.printStackTrace();
                                                    var16_17 = var63_11;
                                                    break block32;
                                                }
                                                var61_13 = -1L;
                                                var63_11 = 0L;
                                            }
                                            var18_18 = var61_13;
                                            var16_17 = var63_11;
                                            break block33;
                                        }
                                        var16_17 = 0L;
                                    }
                                    var18_18 = -1L;
                                }
                                var20_21 = TextUtils.isEmpty((CharSequence)var1_4);
                                if (var20_21) break block34;
                                var59_22 = var1_4.endsWith("-__");
                                if (var59_22) ** GOTO lbl-1000
                            }
                            var21_23 = TextUtils.equals((CharSequence)"/", (CharSequence)var1_4);
                            if (var21_23) lbl-1000: // 2 sources:
                            {
                                var22_24 = "attachment";
                            } else {
                                var22_24 = "inline";
                            }
                            var23_25 = String.format((String)"%s; filename=%s", (Object[])new Object[]{var22_24, var5_1});
                            var24_26 = var6_6.length();
                            if (var15_9 == null || var16_17 < 0L) break block35;
                            ** if (var16_17 < var24_26) goto lbl-1000
lbl-1000: // 1 sources:
                            {
                                var56_27 = d.a(c.k.b.m, "text/plain", "");
                                var57_28 = new StringBuilder("bytes 0-0/");
                                var57_28.append(var24_26);
                                var56_27.a("Content-Range", var57_28.toString());
                                var56_27.a("ETag", var14_8);
                                return var56_27;
                            }
lbl-1000: // 1 sources:
                            {
                                break block36;
                            }
                            catch (IOException var55_19) {
                                var9_20 = var55_19;
                            }
                            break block38;
                        }
                        try {
                            var26_37 = var14_8.equals(var2_5.get((Object)"if-none-match"));
                            if (!var26_37) break block37;
                        }
                        catch (IOException var8_47) {}
                        return d.a(c.k.b.g, var4_3, "");
                    }
                    var27_39 = c.k.b.a;
                    var28_40 = new FileInputStream(var6_6);
                    try {
                        var29_41 = new c.k.a(){

                            @Override
                            public final void a(long l2) {
                                if (d.this.a != null) {
                                    a a2 = d.this.a;
                                    long l3 = var24_26;
                                    d.this.a();
                                    a2.a(l2, l3);
                                }
                                d.a(d.this, var1_4, l2, var24_26);
                            }
                        };
                        var30_43 = var10_42;
                    }
                    catch (IOException var8_46) {}
                    try {
                        var30_43(var27_39, var4_3, var24_26, (InputStream)var28_40, var29_41);
                        var10_42.a("Accept-Ranges", "bytes");
                        var10_42.a("Content-Disposition", var23_25);
                        var10_42.a("Content-Length", String.valueOf((long)var24_26));
                        var10_42.a("ETag", var14_8);
                        if (this.i == null) return var10_42;
                        if (TextUtils.isEmpty((CharSequence)var1_4) != false) return var10_42;
                        if (var1_4.endsWith("-__") == false) return var10_42;
                        var31_44 = this.g != null && var1_4.endsWith(this.g.c) != false ? af.a(af.a.dP).a(af.b.at, 6) : af.a(af.a.dP).a(af.b.at, 7);
                        var31_44.a();
                        return var10_42;
                    }
                    catch (IOException var8_45) {}
                    break block39;
                    catch (IOException var8_48) {
                        // empty catch block
                    }
                }
                var9_20 = var8_49;
                break block38;
            }
            if (var18_18 < 0L) {
                var18_18 = var24_26 - 1L;
            }
            if ((var36_51 = 1L + ((var34_50 = var18_18) - var16_17)) < 0L) {
                var38_29 = var34_50;
                var40_30 = 0L;
            } else {
                var38_29 = var34_50;
                var40_30 = var36_51;
            }
            var42_31 = new FileInputStream(this, var6_6, var40_30){
                final /* synthetic */ long a;
                final /* synthetic */ d b;
                {
                    this.b = d2;
                    this.a = l2;
                    super(file);
                }

                public final int available() throws IOException {
                    return (int)this.a;
                }
            };
            var42_31.skip(var16_17);
            var45_32 = c.k.b.e;
            var46_33 = var16_17;
            var48_34 = new c.k.a(){

                @Override
                public final void a(long l2) {
                    if (d.this.a != null) {
                        a a2 = d.this.a;
                        long l3 = var24_26;
                        d.this.a();
                        a2.a(l2, l3);
                    }
                    d.a(d.this, var1_4, l2, var24_26);
                }
            };
            var33_35 = new c.k(var45_32, var4_3, (InputStream)var42_31, var48_34);
            var33_35.a("Accept-Ranges", "bytes");
            var33_35.a("Content-Disposition", var23_25);
            var33_35.a("Content-Length", String.valueOf((long)var40_30));
            var49_36 = new StringBuilder("bytes ");
            var49_36.append(var46_33);
            var49_36.append("-");
            var49_36.append(var38_29);
            var49_36.append("/");
            var49_36.append(var24_26);
            var33_35.a("Content-Range", var49_36.toString());
            var33_35.a("ETag", var14_8);
            return var33_35;
            catch (IOException var32_38) {
                var9_20 = var32_38;
            }
        }
        var9_20.printStackTrace();
        return d.a(c.k.b.j, "text/plain", "FORBIDDEN: Reading file failed.");
    }

    static /* synthetic */ void a(d d2, String string2, long l2, long l3) {
        if (d2.i != null && !TextUtils.isEmpty((CharSequence)string2)) {
            if (!string2.endsWith("-__")) {
                return;
            }
            String string3 = d.b(string2);
            b b2 = d2.h.get((Object)string3);
            if (b2 != null && b2.d < l3) {
                b2.d = l2 + b2.d;
                if (b2.d >= l3) {
                    y.n();
                    if (d2.g != null && TextUtils.equals((CharSequence)d2.g.c, (CharSequence)string3)) {
                        af.a(af.a.dP).a(af.b.at, 8).a();
                        return;
                    }
                    af.a(af.a.dP).a(af.b.at, 9).a();
                }
            }
        }
    }

    private void a(com.xiaomi.midrop.webshare.b b2) {
        if (b2 == null) {
            return;
        }
        if (!TextUtils.isEmpty((CharSequence)b2.c) && !TextUtils.isEmpty((CharSequence)b2.f)) {
            this.h.put((Object)b2.c, new Object(b2.f, b2.d, b2.h){
                String a;
                String b;
                String c;
                long d = 0L;
                {
                    this.a = string2;
                    this.b = string3;
                    this.c = string4;
                }
            });
        }
        if (!TextUtils.isEmpty((CharSequence)b2.a) && !TextUtils.isEmpty((CharSequence)b2.b)) {
            this.h.put((Object)b2.a, new /* invalid duplicate definition of identical inner class */);
        }
    }

    private static String b(String string2) {
        if (string2.startsWith("/") && string2.length() > 1) {
            string2 = string2.substring(1);
        }
        return string2;
    }

    public final int a() {
        return super.d();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final c.k a(c.i i2) {
        c.k k2;
        block10 : {
            String string2;
            block12 : {
                String string3;
                String string4;
                void var55_10;
                String string5;
                Map<String, String> map;
                String string6;
                block11 : {
                    block9 : {
                        string3 = i2.d().trim();
                        map = i2.c();
                        StringBuilder stringBuilder = new StringBuilder("==========Headers Info==========\n");
                        stringBuilder.append(map);
                        stringBuilder.append("\n{Uri=");
                        stringBuilder.append(string3);
                        stringBuilder.append("}");
                        if (this.i != null) break block9;
                        string4 = this.g != null ? this.g.f : null;
                        boolean bl = TextUtils.isEmpty((CharSequence)string4);
                        k2 = null;
                        if (bl) break block10;
                        string6 = "application/octet-stream";
                        string5 = "MiDrop.apk";
                        var55_10 = this;
                        break block11;
                    }
                    if (TextUtils.isEmpty((CharSequence)string3) || TextUtils.equals((CharSequence)string3, (CharSequence)"/")) break block12;
                    String string7 = d.b(string3);
                    b b2 = this.h.get((Object)string7);
                    k2 = null;
                    if (b2 == null) break block10;
                    string4 = b2.a;
                    String string8 = b2.b;
                    String string9 = TextUtils.isEmpty((CharSequence)b2.c) ? "application/octet-stream" : b2.c;
                    String string10 = string9;
                    if (!TextUtils.isEmpty((CharSequence)string8)) {
                        string7 = string8;
                    }
                    boolean bl = TextUtils.isEmpty((CharSequence)string4);
                    k2 = null;
                    if (bl) break block10;
                    var55_10 = this;
                    string6 = string10;
                    string5 = string7;
                }
                k2 = d.super.a(string3, map, string4, string6, string5);
                break block10;
            }
            String string11 = e.a();
            com.xiaomi.midrop.webshare.b b3 = this.g;
            int n2 = this.j;
            SparseArray<List<com.xiaomi.midrop.webshare.b>> sparseArray = this.i;
            String string12 = this.k;
            String string13 = this.l;
            a.e.b.d.b(string11, "nickanme");
            a.e.b.d.b(b3, "midropInfo");
            a.e.b.d.b(sparseArray, "typedFileInfos");
            a.e.b.d.b(string12, "downloadImgUrl");
            a.e.b.d.b(string13, "downloadAnimationUrl");
            String string14 = com.xiaomi.midrop.webshare.c.a();
            if (string14 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                com.xiaomi.midrop.util.Locale.b b4 = com.xiaomi.midrop.util.Locale.b.a();
                Object[] arrobject = new Object[]{c.a.a(string11), c.a.a(String.valueOf((int)n2))};
                String string15 = b4.a(2131558414, n2, arrobject);
                a.e.b.d.a((Object)string15, "LanguageUtil.getIns().ge\u2026nt(fileCount.toString()))");
                StringBuilder stringBuilder2 = new StringBuilder("<div class=\"title\"><div class=\"topic strong\">");
                stringBuilder2.append(string15);
                stringBuilder2.append("</div><div class=\"des\">");
                stringBuilder2.append(com.xiaomi.midrop.util.Locale.b.a().b(2131690033));
                stringBuilder2.append("</div></div>");
                stringBuilder.append(stringBuilder2.toString());
                String string16 = b3.a;
                String string17 = b3.c;
                StringBuilder stringBuilder3 = new StringBuilder("<div class=\"drop\"><img src=\"");
                stringBuilder3.append(string16);
                stringBuilder3.append("\" alt=\"icon\" class=\"left\"/><div class=\"center\"><div class=\"strong\">");
                stringBuilder3.append(com.xiaomi.midrop.util.Locale.b.a().b(2131689523));
                stringBuilder3.append("</div><div id=\"midrop_des\" class=\"des\">");
                stringBuilder3.append(com.xiaomi.midrop.util.Locale.b.a().b(2131690034));
                stringBuilder3.append("</div></div><div class=\"right\" onclick=\"downloadMidrop('");
                stringBuilder3.append(string17);
                stringBuilder3.append("')\"><img id=\"midrop_download\" class=\"download\" src=\"");
                stringBuilder3.append(string12);
                stringBuilder3.append("\" alt=\"download\"/><embed id=\"midrop_download_active\" type=\"image/svg+xml\" class=\"download-active\"/></div></div>");
                stringBuilder.append(stringBuilder3.toString());
                stringBuilder.append(c.a.a(sparseArray, string12));
                String string18 = stringBuilder.toString();
                string2 = g.a((String)g.a((String)string14, (String)"{downloadAnimationUrl}", (String)string13), (String)"{body}", (String)string18);
            } else {
                string2 = null;
            }
            k2 = null;
            if (string2 != null) {
                k2 = new c.k(c.k.b.a, "text/html", string2);
            }
            af.a(af.a.dP).a(af.b.at, 5).a();
        }
        if (k2 != null) {
            return k2;
        }
        return d.a(c.k.b.k, "text/plain", "Error 404, file not found.");
    }

    public final void a(com.xiaomi.midrop.webshare.b b2, SparseArray<List<com.xiaomi.midrop.webshare.b>> sparseArray) {
        String string2;
        String string3;
        this.h.clear();
        this.g = b2;
        d.super.a(b2);
        this.i = sparseArray;
        if (sparseArray != null) {
            this.j = 0;
            int[] arrn = new int[]{com.xiaomi.midrop.webshare.a.c.ordinal(), com.xiaomi.midrop.webshare.a.d.ordinal(), com.xiaomi.midrop.webshare.a.a.ordinal(), com.xiaomi.midrop.webshare.a.b.ordinal(), com.xiaomi.midrop.webshare.a.e.ordinal()};
            for (int i2 = 0; i2 < 5; ++i2) {
                Iterator iterator = ((List)sparseArray.get(arrn[i2])).iterator();
                while (iterator.hasNext()) {
                    d.super.a((com.xiaomi.midrop.webshare.b)iterator.next());
                    this.j = 1 + this.j;
                }
            }
        }
        if (!TextUtils.isEmpty((CharSequence)(string3 = com.xiaomi.midrop.webshare.c.b()))) {
            this.k = midrop.service.c.c.b(string3);
            this.h.put((Object)this.k, new /* invalid duplicate definition of identical inner class */);
        }
        if (!TextUtils.isEmpty((CharSequence)(string2 = com.xiaomi.midrop.webshare.c.c()))) {
            this.l = midrop.service.c.c.b(string2);
            this.h.put((Object)this.l, new /* invalid duplicate definition of identical inner class */);
        }
    }

}

