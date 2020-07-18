/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a.a
 *  a.i.g
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.media.ThumbnailUtils
 *  android.net.Uri
 *  android.support.v4.content.a
 *  android.util.SparseArray
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  midrop.service.c.c
 *  midrop.service.transmitter.a.a
 */
package com.xiaomi.midrop.webshare;

import a.e;
import a.f;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.util.SparseArray;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.util.g;
import com.xiaomi.midrop.util.j;
import com.xiaomi.midrop.util.v;
import com.xiaomi.midrop.webshare.b;
import com.xiaomi.midrop.webshare.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class c {
    public static final a a = new a(0);
    private static String b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;

    public static final /* synthetic */ String a() {
        return b;
    }

    public static final /* synthetic */ void a(String string2) {
        b = string2;
    }

    public static final /* synthetic */ String b() {
        return f;
    }

    public static final /* synthetic */ void b(String string2) {
        f = string2;
    }

    public static final /* synthetic */ String c() {
        return g;
    }

    public static final /* synthetic */ void c(String string2) {
        g = string2;
    }

    public static final /* synthetic */ String d() {
        return e;
    }

    public static final /* synthetic */ void d(String string2) {
        e = string2;
    }

    public static final /* synthetic */ String e() {
        return c;
    }

    public static final /* synthetic */ void e(String string2) {
        c = string2;
    }

    public static final /* synthetic */ String f() {
        return d;
    }

    public static final /* synthetic */ void f(String string2) {
        d = string2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte by) {
        }

        /*
         * Exception decompiling
         */
        private static Bitmap a(ContentResolver var0_1, String var1) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // java.lang.IllegalStateException: Backjump on non jumping statement [4] lbl22 : af: try { 2[TRYBLOCK]

            // org.benf.cfr.reader.b.a.a.b.g$1.a(Cleaner.java:44)
            // org.benf.cfr.reader.b.a.a.b.g$1.a(Cleaner.java:22)
            // org.benf.cfr.reader.util.d.c.d(GraphVisitorDFS.java:68)
            // org.benf.cfr.reader.b.a.a.b.g.a(Cleaner.java:54)
            // org.benf.cfr.reader.b.a.a.b.ao.a(RemoveDeterministicJumps.java:38)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:443)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
            // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
            // org.benf.cfr.reader.b.a(Driver.java:128)
            // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
            // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
            // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
            // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
            // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
            // java.lang.Thread.run(Thread.java:818)
            throw new IllegalStateException("Decompilation failed");
        }

        public static File a() {
            Context context = MiDropApplication.a();
            a.e.b.d.a((Object)context, "MiDropApplication.getApplication()");
            File file = context.getExternalCacheDir();
            String string2 = file != null ? file.getPath() : null;
            return new File(a.e.b.d.a(string2, (Object)"/webshare"));
        }

        public static String a(Context context, int n2, File file, String string2) {
            Drawable drawable2 = android.support.v4.content.a.a((Context)context, (int)n2);
            if (drawable2 == null) {
                return null;
            }
            a.e.b.d.a((Object)drawable2, "ContextCompat.getDrawabl\u2026text, res) ?: return null");
            return a.a(drawable2, file, string2);
        }

        /*
         * Exception decompiling
         */
        public static String a(Context var0, File var1, String var2) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl133.1 : ACONST_NULL : trying to set 0 previously set to 1
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
            // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
            // org.benf.cfr.reader.b.a(Driver.java:128)
            // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
            // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
            // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
            // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
            // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
            // java.lang.Thread.run(Thread.java:818)
            throw new IllegalStateException("Decompilation failed");
        }

        /*
         * Exception decompiling
         */
        private static String a(Bitmap var0, File var1, String var2) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl40 : ALOAD : trying to set 1 previously set to 0
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
            // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.g.p(Method.java:396)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
            // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
            // org.benf.cfr.reader.b.a(Driver.java:128)
            // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
            // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
            // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
            // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
            // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
            // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
            // java.lang.Thread.run(Thread.java:818)
            throw new IllegalStateException("Decompilation failed");
        }

        private static String a(Drawable drawable2, File file, String string2) {
            Bitmap bitmap;
            if (drawable2 instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable)drawable2).getBitmap();
                a.e.b.d.a((Object)bitmap, "drawable.bitmap");
            } else {
                Bitmap bitmap2 = Bitmap.createBitmap((int)drawable2.getIntrinsicWidth(), (int)drawable2.getIntrinsicHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap2);
                drawable2.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable2.draw(canvas);
                a.e.b.d.a((Object)bitmap2, "bitmap");
                bitmap = bitmap2;
            }
            return a.a(bitmap, file, string2);
        }

        public static String a(SparseArray<List<b>> sparseArray, String string2) {
            String string3 = "";
            Object[] arrobject = new f[]{new f<Integer, Integer>(com.xiaomi.midrop.webshare.a.c.ordinal(), 2131689553), new f<Integer, Integer>(com.xiaomi.midrop.webshare.a.b.ordinal(), 2131689556), new f<Integer, Integer>(com.xiaomi.midrop.webshare.a.d.ordinal(), 2131689555), new f<Integer, Integer>(com.xiaomi.midrop.webshare.a.e.ordinal(), 2131689552), new f<Integer, Integer>(com.xiaomi.midrop.webshare.a.a.ordinal(), 2131689554)};
            a.e.b.d.b(arrobject, "elements");
            for (f f2 : (Iterable)a.a.a.a((Object[])arrobject)) {
                List list = (List)sparseArray.get(((Number)f2.a).intValue());
                if (list.isEmpty()) continue;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                String string4 = com.xiaomi.midrop.util.Locale.b.a().b(((Number)f2.b).intValue());
                a.e.b.d.a((Object)string4, "LanguageUtil.getIns().getString(it.second)");
                a.e.b.d.a((Object)list, "fileInfos");
                stringBuilder.append(a.a(string4, (List<b>)list, string2));
                string3 = stringBuilder.toString();
            }
            return string3;
        }

        public static String a(String string2) {
            StringBuilder stringBuilder = new StringBuilder("<span class=\"blue\">");
            stringBuilder.append(string2);
            stringBuilder.append("</span>");
            return stringBuilder.toString();
        }

        private static String a(String string2, List<b> list, String string3) {
            StringBuilder stringBuilder = new StringBuilder("<div class=\"content\"><div class=\"topic\">");
            stringBuilder.append(string2);
            stringBuilder.append(" (");
            stringBuilder.append(list.size());
            stringBuilder.append(")</div>");
            String string4 = stringBuilder.toString();
            for (b b2 : (Iterable)list) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string4);
                String string5 = b2.a;
                String string6 = b2.d;
                String string7 = j.b(b2.e);
                a.e.b.d.a((Object)string7, "FileUtils.formatFileSize(it.size)");
                String string8 = b2.c;
                StringBuilder stringBuilder3 = new StringBuilder("<div class=\"item\"><div class=\"left\" style=\"background-image: url('");
                stringBuilder3.append(string5);
                stringBuilder3.append("')\"></div><div class=\"center\"><div class=\"strong\">");
                stringBuilder3.append(string6);
                stringBuilder3.append("</div><div class=\"des\">");
                stringBuilder3.append(string7);
                stringBuilder3.append("</div></div><div class=\"right\" onclick=\"download('");
                stringBuilder3.append(string8);
                stringBuilder3.append("')\"><img class=\"download\" src=\"");
                stringBuilder3.append(string3);
                stringBuilder3.append("\" alt=\"download\"/></div></div>");
                stringBuilder2.append(stringBuilder3.toString());
                string4 = stringBuilder2.toString();
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(string4);
            stringBuilder4.append("</div>");
            return stringBuilder4.toString();
        }

        private static void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
            int n2;
            byte[] arrby = new byte[1024];
            do {
                if ((n2 = inputStream.read(arrby)) == -1) continue;
                fileOutputStream.write(arrby, 0, n2);
            } while (n2 != -1);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        public final b a(Uri var1) {
            block32 : {
                block31 : {
                    block30 : {
                        var55_2 = this;
                        // MONITORENTER : var55_2
                        a.e.b.d.b((Object)var1, "uri");
                        var3_3 = var1.getPath();
                        var4_4 = var1.getQuery();
                        var5_5 = var4_4 == null || var4_4.length() == 0;
                        if (!var5_5) {
                            var6_6 = var1.getQueryParameter("name");
                            if (var3_3 != null) {
                                var7_7 = var1.getQuery();
                                if (var7_7 == null) {
                                    a.e.b.d.a();
                                }
                                var3_3 = a.i.g.a((String)var3_3, (String)var7_7, (String)"");
                            } else {
                                var3_3 = null;
                            }
                        } else {
                            var6_6 = null;
                        }
                        if (!(var8_8 = new File(var3_3)).exists()) {
                            // MONITOREXIT : var55_2
                            return null;
                        }
                        if (var8_8.isDirectory()) {
                            return null;
                        }
                        var9_9 = v.a(j.d(var3_3));
                        if (a.e.b.d.a((Object)var9_9, (Object)"*/*")) {
                            var9_9 = v.b(var3_3);
                        }
                        var10_10 = var9_9;
                        var11_11 = new StringBuilder();
                        var11_11.append(midrop.service.c.c.b((String)var3_3));
                        var11_11.append("-__");
                        var14_12 = var11_11.toString();
                        var15_13 = var8_8.getName();
                        a.e.b.d.a((Object)var15_13, "file.name");
                        var16_14 = j.d(var15_13);
                        var17_15 = g.d(var16_14) != false ? com.xiaomi.midrop.webshare.a.c : (g.a(var16_14) != false ? com.xiaomi.midrop.webshare.a.a : (g.b(var16_14) != false ? com.xiaomi.midrop.webshare.a.b : (g.c(var16_14) != false ? com.xiaomi.midrop.webshare.a.d : com.xiaomi.midrop.webshare.a.e)));
                        var18_16 = var17_15;
                        if (var18_16 != com.xiaomi.midrop.webshare.a.c) ** GOTO lbl-1000
                        var52_17 = var6_6;
                        if (var52_17 == null) break block30;
                        var53_18 = var52_17.length();
                        var54_19 = false;
                        if (var53_18 != 0) break block31;
                    }
                    var54_19 = true;
                }
                if (!var54_19) {
                    if (var6_6 == null) {
                        a.e.b.d.a();
                    }
                } else lbl-1000: // 2 sources:
                {
                    var6_6 = var8_8.getName();
                }
                var19_20 = var6_6;
                a.e.b.d.a((Object)var19_20, "fileName");
                var20_21 = midrop.service.transmitter.a.a.a((File)var8_8);
                a.e.b.d.a((Object)var10_10, "mime");
                var22_22 = new b(var14_12, var19_20, var20_21, var3_3, var18_16, var10_10);
                if (var3_3 == null) {
                    a.e.b.d.a();
                }
                switch (d.a[var18_16.ordinal()]) {
                    default: {
                        throw new e();
                    }
                    case 5: {
                        var41_23 = MiDropApplication.a();
                        a.e.b.d.a((Object)var41_23, "MiDropApplication.getApplication()");
                        var42_24 = var41_23.getPackageManager();
                        var43_25 = var42_24.getPackageArchiveInfo(var3_3, 1);
                        var23_26 = null;
                        if (var43_25 != null) {
                            var44_27 = var43_25.applicationInfo;
                            var44_27.sourceDir = var3_3;
                            var44_27.publicSourceDir = var3_3;
                            var45_28 = var42_24.getApplicationIcon(var44_27);
                            a.e.b.d.a((Object)var45_28, "icon");
                            var48_29 = a.a();
                            var49_30 = new StringBuilder();
                            var49_30.append(midrop.service.c.c.b((String)var3_3));
                            var49_30.append(".png");
                            var23_26 = a.a(var45_28, var48_29, var49_30.toString());
                            ** break;
                        }
                        break block32;
                    }
                    case 4: {
                        var34_31 = ThumbnailUtils.createVideoThumbnail((String)var3_3, (int)3);
                        var23_26 = null;
                        if (var34_31 != null) {
                            var37_32 = a.a();
                            var38_33 = new StringBuilder();
                            var38_33.append(midrop.service.c.c.b((String)var3_3));
                            var38_33.append(".png");
                            var23_26 = a.a(var34_31, var37_32, var38_33.toString());
                        }
                        if (var23_26 == null) {
                            var23_26 = c.f();
                            ** break;
                        }
                        break block32;
                    }
                    case 3: {
                        var23_26 = c.e();
                        ** break;
                    }
                    case 2: {
                        var25_34 = MiDropApplication.a();
                        a.e.b.d.a((Object)var25_34, "MiDropApplication.getApplication()");
                        var26_35 = var25_34.getContentResolver();
                        a.e.b.d.a((Object)var26_35, "context.contentResolver");
                        var27_36 = a.a(var26_35, var3_3);
                        var23_26 = null;
                        if (var27_36 == null) break;
                        var30_37 = a.a();
                        var31_38 = new StringBuilder();
                        var31_38.append(midrop.service.c.c.b((String)var3_3));
                        var31_38.append(".png");
                        var23_26 = a.a(var27_36, var30_37, var31_38.toString());
                        break;
                    }
                    case 1: {
                        var23_26 = c.d();
                        break block32;
                    }
                }
                if (var23_26 == null) {
                    var23_26 = var3_3;
                }
            }
            if (var23_26 != null) {
                a.e.b.d.b(var23_26, "<set-?>");
                var22_22.b = var23_26;
                var24_39 = midrop.service.c.c.b((String)var23_26);
                a.e.b.d.a((Object)var24_39, "IdUtil.generateTransID(it)");
                a.e.b.d.b(var24_39, "<set-?>");
                var22_22.a = var24_39;
            }
            // MONITOREXIT : var55_2
            return var22_22;
        }
    }

}

