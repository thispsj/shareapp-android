/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package midrop.c.a.b;

import java.util.Locale;

public class d {
    String a;
    a b = a.a;
    public String c;
    public String d;
    private int e;

    /*
     * Exception decompiling
     */
    public boolean a(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl45.1 : ICONST_0 : trying to set 0 previously set to 1
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

    public boolean equals(Object object) {
        block11 : {
            block13 : {
                d d2;
                block12 : {
                    if (this == object) {
                        return true;
                    }
                    if (object == null) break block11;
                    if (this.getClass() != object.getClass()) {
                        return false;
                    }
                    d2 = (d)object;
                    if (this.e != d2.e) {
                        return false;
                    }
                    if (this.a != null ? !this.a.equals((Object)d2.a) : d2.a != null) {
                        return false;
                    }
                    if (this.b != d2.b) {
                        return false;
                    }
                    if (this.c != null ? !this.c.equals((Object)d2.c) : d2.c != null) {
                        return false;
                    }
                    if (this.d == null) break block12;
                    if (!this.d.equals((Object)d2.d)) {
                        return false;
                    }
                    break block13;
                }
                if (d2.d != null) break block11;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : 0;
        int n3 = n2 * 31;
        int n4 = this.b != null ? this.b.hashCode() : 0;
        int n5 = 31 * (n3 + n4);
        int n6 = this.c != null ? this.c.hashCode() : 0;
        int n7 = 31 * (n5 + n6);
        String string2 = this.d;
        int n8 = 0;
        if (string2 != null) {
            n8 = this.d.hashCode();
        }
        return 31 * (n7 + n8) + this.e;
    }

    public String toString() {
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{"urn", this.a, this.b.toString(), this.c, this.d, this.e};
        return String.format((Locale)locale, (String)"%s:%s:%s:%s:%s:%d", (Object[])arrobject);
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        private static final /* synthetic */ a[] d;

        static {
            a[] arra = new a[]{a, b, c};
            d = arra;
        }

        public static a a(String string2) {
            if (string2.equals((Object)"undefined")) {
                return a;
            }
            if (string2.equals((Object)"device")) {
                return b;
            }
            if (string2.equals((Object)"service")) {
                return c;
            }
            return a;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])d.clone();
        }

        public final String toString() {
            switch (1.a[this.ordinal()]) {
                default: {
                    return "undefined";
                }
                case 2: {
                    return "service";
                }
                case 1: 
            }
            return "device";
        }
    }

}

