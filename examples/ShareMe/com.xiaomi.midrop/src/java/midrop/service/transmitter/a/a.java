/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.xiaomi.midrop.b.b
 *  com.xiaomi.midrop.transmission.a.c
 *  com.xiaomi.midrop.transmission.a.d
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileNotFoundException
 *  java.io.FilenameFilter
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.math.BigInteger
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package midrop.service.transmitter.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.midrop.b.b;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.transmission.a.c;
import com.xiaomi.midrop.util.j;
import com.xiaomi.midrop.util.p;
import com.xiaomi.midrop.util.y;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import midrop.service.c.d;

public class a {
    private static final String a = "midrop.service.transmitter.a.a";

    public static long a(File file) {
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    public static List<com.xiaomi.midrop.transmission.a.a> a(Context context, List<b> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(list);
        while (arrayList2.size() > 0) {
            int n2;
            ArrayList arrayList3 = new ArrayList();
            b b2 = (b)arrayList2.get(0);
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = new ArrayList();
            ArrayList arrayList8 = new ArrayList();
            for (int i2 = arrayList2.size() - 1; i2 >= 0; --i2) {
                b b3 = (b)arrayList2.get(i2);
                if (b3.A != b2.A) continue;
                String string2 = j.d(b3.i);
                if (com.xiaomi.midrop.util.g.d(string2)) {
                    arrayList7.add(0, (Object)b3);
                } else if (com.xiaomi.midrop.util.g.c(string2)) {
                    arrayList4.add(0, (Object)b3);
                } else if (com.xiaomi.midrop.util.g.a(string2)) {
                    arrayList5.add(0, (Object)b3);
                } else if (com.xiaomi.midrop.util.g.b(string2)) {
                    arrayList6.add(0, (Object)b3);
                } else {
                    arrayList8.add(0, (Object)b3);
                }
                arrayList2.remove(i2);
            }
            if (arrayList4.size() > 0) {
                b b4 = new b();
                b4.c = context.getString(2131689555);
                b4.z = b2.z;
                b4.g = n2 = 1;
                b4.b = arrayList4;
                arrayList3.add((Object)b4);
            } else {
                n2 = 1;
            }
            if (arrayList5.size() > 0) {
                b b5 = new b();
                b5.c = context.getString(2131689554);
                b5.z = b2.z;
                b5.g = 3;
                b5.b = arrayList5;
                arrayList3.add((Object)b5);
            }
            if (arrayList6.size() > 0) {
                b b6 = new b();
                b6.c = context.getString(2131689556);
                b6.z = b2.z;
                b6.g = 2;
                b6.b = arrayList6;
                arrayList3.add((Object)b6);
            }
            if (arrayList7.size() > 0) {
                b b7 = new b();
                b7.c = context.getString(2131689553);
                b7.z = b2.z;
                b7.g = 4;
                b7.b = arrayList7;
                arrayList3.add((Object)b7);
            }
            if (arrayList8.size() > 0) {
                b b8 = new b();
                b8.c = context.getString(2131689552);
                b8.z = b2.z;
                b8.g = 5;
                b8.b = arrayList8;
                arrayList3.add((Object)b8);
            }
            if (b2.z == g.a.a) {
                n2 = 0;
            }
            com.xiaomi.midrop.transmission.a.d d2 = new com.xiaomi.midrop.transmission.a.d((List)arrayList3, n2);
            arrayList.add((Object)new c(n2));
            arrayList.add((Object)d2);
        }
        return arrayList;
    }

    private static void a(String string2, List<Uri> list) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return;
        }
        File file = new File(string2);
        if (!file.exists()) {
            return;
        }
        File[] arrfile = y.j() ? file.listFiles() : file.listFiles((FilenameFilter)new p());
        if (arrfile != null) {
            for (File file2 : arrfile) {
                if (file2.isDirectory()) {
                    a.a(file2.getAbsolutePath(), list);
                    continue;
                }
                list.add((Object)Uri.fromFile((File)file2.getAbsoluteFile()));
            }
        }
    }

    /*
     * Exception decompiling
     */
    public static void a(midrop.service.a.a var0, List<midrop.c.f.a> var1, List<Uri> var2, String var3, String var4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl76 : ACONST_NULL : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
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
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String b(File var0) {
        block17 : {
            var4_1 = MessageDigest.getInstance((String)"MD5");
            ** try [egrp 1[TRYBLOCK] [1 : 8->18)] { 
lbl4: // 1 sources:
            break block17;
lbl5: // 1 sources:
            catch (FileNotFoundException var1_13) {
                block18 : {
                    var2_16 = a.a;
                    var3_17 = "Exception while getting FileInputStream";
                    break block18;
                    catch (NoSuchAlgorithmException var1_15) {
                        var2_16 = a.a;
                        var3_17 = "Exception while getting digest";
                    }
                }
                d.a(var2_16, var3_17, (Throwable)var1_14, new Object[0]);
                return null;
            }
        }
        var5_2 = new FileInputStream(var0);
        var6_3 = new byte[8192];
        var7_4 = 0L;
        do {
            block16 : {
                var13_6 = var5_2.read(var6_3);
                if (var13_6 > 0) {
                    var4_1.update(var6_3, 0, var13_6);
                    var14_5 = var7_4 + (long)var13_6;
                    if (var14_5 <= 102400L) break block16;
                }
                var16_7 = String.format((String)"%32s", (Object[])new Object[]{new BigInteger(1, var4_1.digest()).toString(16)}).replace(' ', '0');
                try {
                    var5_2.close();
                    return var16_7;
                }
                catch (IOException var17_8) {
                    d.a(a.a, "Exception on closing MD5 input stream", var17_8, new Object[0]);
                    return var16_7;
                }
            }
            var7_4 = var14_5;
        } while (true);
        {
            catch (Throwable var11_9) {
            }
            catch (IOException var9_10) {}
            {
                d.a(a.a, "calculateMD5", var9_10, new Object[0]);
            }
            try {
                var5_2.close();
                return "";
            }
            catch (IOException var10_11) {
                d.a(a.a, "Exception on closing MD5 input stream", var10_11, new Object[0]);
                return "";
            }
        }
        try {
            var5_2.close();
            throw var11_9;
        }
        catch (IOException var12_12) {
            d.a(a.a, "Exception on closing MD5 input stream", var12_12, new Object[0]);
        }
        throw var11_9;
    }
}

