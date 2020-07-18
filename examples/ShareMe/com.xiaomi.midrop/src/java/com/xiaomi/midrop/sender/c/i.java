/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.text.TextUtils
 *  com.xiaomi.midrop.transmission.upgrade.util.b
 *  com.xiaomi.midrop.util.d
 *  com.xiaomi.midrop.util.y
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.xiaomi.midrop.sender.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.common.b;
import com.xiaomi.midrop.util.d;
import com.xiaomi.midrop.util.y;
import java.io.File;

public final class i {
    public static PackageInfo a(Context context) {
        File file = new File(i.a());
        if (!file.exists()) {
            return null;
        }
        File[] arrfile = file.listFiles();
        if (arrfile != null) {
            if (arrfile.length == 0) {
                return null;
            }
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = null;
            for (int i2 = 0; i2 < arrfile.length; ++i2) {
                PackageInfo packageInfo2;
                File file2 = arrfile[i2];
                if (!file2.isFile() || TextUtils.isEmpty((CharSequence)file2.getName()) || (packageInfo2 = packageManager.getPackageArchiveInfo(file2.getAbsolutePath(), 0)) == null || !TextUtils.equals((CharSequence)packageInfo2.packageName, (CharSequence)context.getPackageName()) || packageInfo2.versionCode <= 12826 || packageInfo != null && packageInfo.versionCode >= packageInfo2.versionCode) continue;
                packageInfo2.applicationInfo.sourceDir = file2.getAbsolutePath();
                packageInfo = packageInfo2;
            }
            return packageInfo;
        }
        return null;
    }

    public static String a() {
        String string2 = b.a("file_storage_loction", 0) == 1 ? String.valueOf((Object)d.b((Context)MiDropApplication.a())) : d.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("/.upgrade_package");
        return stringBuilder.toString();
    }

    /*
     * Exception decompiling
     */
    public static String b() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    public static boolean c() {
        return y.i() && com.xiaomi.midrop.transmission.upgrade.util.b.a().b();
    }
}

