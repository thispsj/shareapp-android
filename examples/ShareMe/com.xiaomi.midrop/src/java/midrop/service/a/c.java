/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package midrop.service.a;

import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public int a = d.a;
    public a b = a.a;
    public int c = c.a;
    public int d = b.a;

    public static c a(int n2) {
        c c2 = new c();
        c2.a = d.c;
        c2.c = n2;
        return c2;
    }

    public static c a(a a2) {
        c c2 = new c();
        c2.a = d.b;
        c2.b = a2;
        return c2;
    }

    public static c b(int n2) {
        c c2 = new c();
        c2.a = d.d;
        c2.d = n2;
        return c2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final int a(String string2) {
        this.a = d.a;
        try {
            JSONObject jSONObject = new JSONObject(string2);
            int n2 = jSONObject.getInt("status");
            int n3 = jSONObject.getInt("value");
            this.a = d.a(n2);
            switch (1.a[-1 + this.a]) {
                case 3: {
                    this.d = b.a(n3);
                    return this.a;
                }
                case 2: {
                    this.c = c.a(n3);
                    return this.a;
                }
                case 1: {
                    this.b = a.a(n3);
                    return this.a;
                }
            }
            return this.a;
        }
        catch (JSONException jSONException) {
            midrop.service.c.d.a("TransferStatus", "parse: ", jSONException, new Object[0]);
        }
        return this.a;
    }

    /*
     * Exception decompiling
     */
    public final String toString() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 1[SWITCH]
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

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        public static final /* enum */ a d = new a();
        public static final /* enum */ a e = new a();
        public static final /* enum */ a f = new a();
        public static final /* enum */ a g = new a();
        private static final /* synthetic */ a[] h;

        static {
            a[] arra = new a[]{a, b, c, d, e, f, g};
            h = arra;
        }

        public static a a(int n2) {
            if (a.ordinal() == n2) {
                return a;
            }
            if (b.ordinal() == n2) {
                return b;
            }
            if (c.ordinal() == n2) {
                return c;
            }
            if (d.ordinal() == n2) {
                return d;
            }
            if (e.ordinal() == n2) {
                return e;
            }
            if (f.ordinal() == n2) {
                return f;
            }
            if (g.ordinal() == n2) {
                return g;
            }
            return a;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])h.clone();
        }
    }

    public static final class b
    extends Enum<b> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        public static final int h = 8;
        private static final /* synthetic */ int[] i;

        static {
            int[] arrn = new int[]{a, b, c, d, e, f, g, h};
            i = arrn;
        }

        public static int a(int n2) {
            if (-1 + a == n2) {
                return a;
            }
            if (-1 + b == n2) {
                return b;
            }
            if (-1 + c == n2) {
                return c;
            }
            if (-1 + d == n2) {
                return d;
            }
            if (-1 + f == n2) {
                return f;
            }
            if (-1 + g == n2) {
                return g;
            }
            if (-1 + h == n2) {
                return h;
            }
            if (-1 + e == n2) {
                return e;
            }
            return a;
        }

        public static int[] a() {
            return (int[])i.clone();
        }
    }

    public static final class c
    extends Enum<c> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        private static final /* synthetic */ int[] f;

        static {
            int[] arrn = new int[]{a, b, c, d, e};
            f = arrn;
        }

        public static int a(int n2) {
            if (-1 + a == n2) {
                return a;
            }
            if (-1 + b == n2) {
                return b;
            }
            if (-1 + c == n2) {
                return c;
            }
            if (-1 + d == n2) {
                return d;
            }
            if (-1 + e == n2) {
                return e;
            }
            return a;
        }

        public static int[] a() {
            return (int[])f.clone();
        }
    }

    public static final class d
    extends Enum<d> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        private static final /* synthetic */ int[] e;

        static {
            int[] arrn = new int[]{a, b, c, d};
            e = arrn;
        }

        public static int a(int n2) {
            if (-1 + a == n2) {
                return a;
            }
            if (-1 + b == n2) {
                return b;
            }
            if (-1 + c == n2) {
                return c;
            }
            if (-1 + d == n2) {
                return d;
            }
            return a;
        }

        public static int[] a() {
            return (int[])e.clone();
        }
    }

}

