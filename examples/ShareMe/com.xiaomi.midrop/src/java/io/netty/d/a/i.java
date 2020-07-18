/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.ThreadGroup
 *  java.util.Locale
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.atomic.AtomicInteger
 */
package io.netty.d.a;

import io.netty.d.b.t;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class i
implements ThreadFactory {
    private static final AtomicInteger b = new AtomicInteger();
    protected final ThreadGroup a;
    private final AtomicInteger c;
    private final String d;
    private final boolean e;
    private final int f;

    public i(Class<?> class_) {
        super(class_, 5);
    }

    public i(Class<?> class_, byte by) {
        super(class_, 10);
    }

    private i(Class<?> class_, int n2) {
        super(i.a(class_), n2);
    }

    private i(String string2, int n2) {
        ThreadGroup threadGroup = System.getSecurityManager() == null ? Thread.currentThread().getThreadGroup() : System.getSecurityManager().getThreadGroup();
        super(string2, n2, threadGroup);
    }

    public i(String string2, int n2, ThreadGroup threadGroup) {
        this.c = new AtomicInteger();
        if (string2 == null) {
            throw new NullPointerException("poolName");
        }
        if (n2 > 0 && n2 <= 10) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append('-');
            stringBuilder.append(b.incrementAndGet());
            stringBuilder.append('-');
            this.d = stringBuilder.toString();
            this.e = false;
            this.f = n2;
            this.a = threadGroup;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("priority: ");
        stringBuilder.append(n2);
        stringBuilder.append(" (expected: Thread.MIN_PRIORITY <= priority <= Thread.MAX_PRIORITY)");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static String a(Class<?> class_) {
        if (class_ == null) {
            throw new NullPointerException("poolType");
        }
        String string2 = t.a(class_);
        switch (string2.length()) {
            default: {
                if (!Character.isUpperCase((char)string2.charAt(0)) || !Character.isLowerCase((char)string2.charAt(1))) break;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Character.toLowerCase((char)string2.charAt(0)));
                stringBuilder.append(string2.substring(1));
                return stringBuilder.toString();
            }
            case 1: {
                return string2.toLowerCase(Locale.US);
            }
            case 0: {
                string2 = "unknown";
            }
        }
        return string2;
    }

    /*
     * Exception decompiling
     */
    public final Thread newThread(Runnable var1) {
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
}

