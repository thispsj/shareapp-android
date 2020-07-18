/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  e.a.a
 *  e.a.a$b
 *  java.io.File
 *  java.io.FileFilter
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.text.SimpleDateFormat
 *  java.util.Arrays
 *  java.util.Comparator
 */
package com.xiaomi.globalmiuiapp.common.e;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.globalmiuiapp.common.e.b;
import com.xiaomi.globalmiuiapp.common.f.f;
import e.a.a;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

public final class b
extends a.b {
    public static f<b> a = new f<b>(){

        @Override
        protected final /* synthetic */ Object a() {
            return new b();
        }
    };
    final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    final a c;
    long d = 0x500000L;
    File e;

    b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com.xiaomi.globalmiuiapp.common.a.a.a.b.getPackageName());
        stringBuilder.append("_log");
        HandlerThread handlerThread = new HandlerThread(stringBuilder.toString());
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper()){

            /*
             * Exception decompiling
             */
            public final void dispatchMessage(Message var1) {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl224 : ALOAD_2 : trying to set 1 previously set to 0
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
        };
    }

    final void a() {
        File file = this.e;
        if (file != null) {
            if (!file.exists()) {
                return;
            }
            Object[] arrobject = file.listFiles(new FileFilter(this){
                final /* synthetic */ b a;
                {
                    this.a = b2;
                }

                public final boolean accept(File file) {
                    return file.isFile() && !android.text.TextUtils.isEmpty((java.lang.CharSequence)file.getName()) && file.getName().startsWith("log_");
                }
            });
            if (arrobject != null) {
                if (arrobject.length == 0) {
                    return;
                }
                Arrays.sort((Object[])arrobject, (Comparator)new Comparator<File>(this){
                    final /* synthetic */ b a;
                    {
                        this.a = b2;
                    }

                    public final /* synthetic */ int compare(Object object, Object object2) {
                        File file = (File)object;
                        File file2 = (File)object2;
                        return file.getName().compareTo(file2.getName());
                    }
                });
                long l2 = 0L;
                if (arrobject != null) {
                    int n2 = arrobject.length;
                    long l3 = l2;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        long l4 = l3 + arrobject[i2].length();
                        l3 = l4;
                    }
                    l2 = l3;
                }
                long l5 = l2 LCMP this.d;
                if (l5 > 0) {
                    for (int i3 = 0; i3 < arrobject.length && l2 > this.d; ++i3) {
                        Object object = arrobject[i3];
                        object.delete();
                        long l6 = l2 - object.length();
                        l2 = l6;
                    }
                }
            }
        }
    }

    protected final void a(int n2, String string2, String string3, Throwable throwable) {
        Message message = this.c.obtainMessage(1);
        message.obj = b.a(n2, string2, string3, throwable);
        this.c.sendMessage(message);
    }

}

