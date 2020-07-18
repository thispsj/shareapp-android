/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.i.g
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package a.c;

import a.c.a;
import a.e.b.d;
import a.i.g;
import a.j;

public final class b {
    public static final a a;

    /*
     * Exception decompiling
     */
    static {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl237 : ALOAD_1 : trying to set 1 previously set to 0
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

    private static final int a() {
        int n2;
        int n3;
        CharSequence charSequence;
        int n4;
        String string2;
        int n5;
        block8 : {
            int n6;
            string2 = System.getProperty((String)"java.specification.version");
            n2 = 65542;
            if (string2 == null) {
                return n2;
            }
            charSequence = string2;
            n4 = g.a((CharSequence)charSequence, (int)0, (int)6);
            if (n4 >= 0) break block8;
            try {
                n6 = Integer.parseInt((String)string2);
            }
            catch (NumberFormatException numberFormatException) {}
            n2 = n6 * 65536;
            return n2;
        }
        int n7 = n4 + 1;
        int n8 = g.a((CharSequence)charSequence, (int)n7, (int)4);
        if (n8 < 0) {
            n8 = string2.length();
        }
        if (string2 == null) {
            throw new j("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = string2.substring(0, n4);
        d.a((Object)string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        if (string2 == null) {
            throw new j("null cannot be cast to non-null type java.lang.String");
        }
        String string4 = string2.substring(n7, n8);
        d.a((Object)string4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        try {
            n3 = 65536 * Integer.parseInt((String)string3);
            n5 = Integer.parseInt((String)string4);
        }
        catch (NumberFormatException numberFormatException) {}
        n2 = n3 + n5;
        return n2;
    }
}

