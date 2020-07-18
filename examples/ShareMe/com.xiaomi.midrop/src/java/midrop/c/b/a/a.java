/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.io.InputStream
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  org.w3c.dom.Element
 */
package midrop.c.b.a;

import android.util.Log;
import java.io.InputStream;
import midrop.c.a.e;
import midrop.c.b.a.c;
import org.w3c.dom.Element;

public class a {
    private static final String a = "a";

    /*
     * Exception decompiling
     */
    public static boolean a(e var0_1, InputStream var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 7[TRYBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean a(Element element) {
        String string2;
        String string3;
        Element element2 = c.b(element, "specVersion");
        if (element2 == null) {
            string2 = a;
            string3 = String.format((String)"<%s> not found", (Object[])new Object[]{"specVersion"});
        } else {
            String string4 = c.a(element2, "major");
            String string5 = c.a(element2, "minor");
            if (string4 != null && string5 != null) {
                String string6;
                int n2;
                int n3;
                try {
                    n3 = Integer.valueOf((String)string4.trim());
                    n2 = Integer.valueOf((String)string5.trim());
                    if (n3 == 1 && n2 == 0) {
                        return true;
                    }
                    string6 = a;
                }
                catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                    return false;
                }
                Object[] arrobject = new Object[]{"major", n3, "minor", n2};
                Log.d((String)string6, (String)String.format((String)"%s=%d %s=%d", (Object[])arrobject));
                return false;
            }
            string2 = a;
            string3 = String.format((String)"<%s> or <%s> is null", (Object[])new Object[]{"major", "minor"});
        }
        Log.d((String)string2, (String)string3);
        return false;
    }
}

