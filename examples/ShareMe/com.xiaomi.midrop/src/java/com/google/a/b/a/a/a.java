/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.ParseException
 *  java.text.ParsePosition
 *  java.util.Date
 *  java.util.TimeZone
 */
package com.google.a.b.a.a;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.TimeZone;

public final class a {
    private static final TimeZone a = TimeZone.getTimeZone((String)"UTC");

    private static int a(String string2, int n2) {
        while (n2 < string2.length()) {
            char c2 = string2.charAt(n2);
            if (c2 >= '0') {
                if (c2 > '9') {
                    return n2;
                }
                ++n2;
                continue;
            }
            return n2;
        }
        return string2.length();
    }

    private static int a(String string2, int n2, int n3) throws NumberFormatException {
        if (n2 >= 0 && n3 <= string2.length() && n2 <= n3) {
            int n4;
            int n5;
            if (n2 < n3) {
                n5 = n2 + 1;
                int n6 = Character.digit((char)string2.charAt(n2), (int)10);
                if (n6 < 0) {
                    StringBuilder stringBuilder = new StringBuilder("Invalid number: ");
                    stringBuilder.append(string2.substring(n2, n3));
                    throw new NumberFormatException(stringBuilder.toString());
                }
                n4 = -n6;
            } else {
                n5 = n2;
                n4 = 0;
            }
            while (n5 < n3) {
                int n7 = n5 + 1;
                int n8 = Character.digit((char)string2.charAt(n5), (int)10);
                if (n8 < 0) {
                    StringBuilder stringBuilder = new StringBuilder("Invalid number: ");
                    stringBuilder.append(string2.substring(n2, n3));
                    throw new NumberFormatException(stringBuilder.toString());
                }
                n4 = n4 * 10 - n8;
                n5 = n7;
            }
            return -n4;
        }
        throw new NumberFormatException(string2);
    }

    /*
     * Exception decompiling
     */
    public static Date a(String var0_1, ParsePosition var1) throws ParseException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: First case is not immediately after switch.
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:358)
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:61)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:372)
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

    private static boolean a(String string2, int n2, char c2) {
        return n2 < string2.length() && string2.charAt(n2) == c2;
    }
}

