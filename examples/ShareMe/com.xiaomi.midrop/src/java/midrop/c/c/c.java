/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 */
package midrop.c.c;

import android.os.Parcel;
import android.os.Parcelable;

public class c
implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new c(parcel);
        }
    };
    a a;
    public Class<?> b;
    private String c;

    private c() {
        this.a = a.d;
        this.c = null;
        this.b = null;
        this.a = a.a;
    }

    public c(Parcel parcel) {
        this.a = a.d;
        this.c = null;
        this.b = null;
        c.super.c(parcel.readString());
    }

    public static c a(Class<?> class_) {
        boolean bl;
        c c2 = new c();
        a a2 = a.a(class_);
        if (a2 == a.a) {
            bl = false;
        } else {
            c2.a = a2;
            c2.b = class_;
            c2.c = a2.toString();
            bl = true;
        }
        if (!bl) {
            return null;
        }
        return c2;
    }

    public static c a(String string2) {
        c c2 = new c();
        if (!c2.c(string2)) {
            return null;
        }
        return c2;
    }

    private boolean c(String string2) {
        Class<String> class_;
        a a2 = a.a(string2);
        if (a2 == a.a) {
            return false;
        }
        this.a = a2;
        switch (2.a[a2.ordinal()]) {
            default: {
                class_ = null;
                break;
            }
            case 9: {
                class_ = String.class;
                break;
            }
            case 8: {
                class_ = Long.class;
                break;
            }
            case 7: {
                class_ = Integer.class;
                break;
            }
            case 6: {
                class_ = Float.class;
                break;
            }
            case 5: {
                class_ = Double.class;
                break;
            }
            case 4: {
                class_ = byte[].class;
                break;
            }
            case 3: {
                class_ = Boolean.class;
                break;
            }
            case 2: {
                class_ = Short.class;
                break;
            }
            case 1: {
                class_ = Byte.class;
            }
        }
        this.b = class_;
        this.c = string2;
        return true;
    }

    /*
     * Exception decompiling
     */
    public final Object b(String var1) {
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

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.c);
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
        public static final /* enum */ a h = new a();
        public static final /* enum */ a i = new a();
        public static final /* enum */ a j = new a();
        private static final /* synthetic */ a[] k;

        static {
            a[] arra = new a[]{a, b, c, d, e, f, g, h, i, j};
            k = arra;
        }

        public static a a(Class<?> class_) {
            if (class_.isAssignableFrom(Byte.class)) {
                return b;
            }
            if (class_.isAssignableFrom(Short.class)) {
                return c;
            }
            if (class_.isAssignableFrom(Integer.class)) {
                return d;
            }
            if (class_.isAssignableFrom(Long.class)) {
                return e;
            }
            if (class_.isAssignableFrom(Float.class)) {
                return f;
            }
            if (class_.isAssignableFrom(Double.class)) {
                return g;
            }
            if (class_.isAssignableFrom(String.class)) {
                return h;
            }
            if (class_.isAssignableFrom(Boolean.class)) {
                return i;
            }
            if (class_.isAssignableFrom(byte[].class)) {
                return j;
            }
            return a;
        }

        public static a a(String string2) {
            if (string2.equals((Object)"undefined")) {
                return a;
            }
            if (string2.equals((Object)"short")) {
                return b;
            }
            if (string2.equals((Object)"short")) {
                return c;
            }
            if (!(string2.equals((Object)"integer") || string2.equals((Object)"ui1") || string2.equals((Object)"ui2") || string2.equals((Object)"i1") || string2.equals((Object)"i2") || string2.equals((Object)"i4") || string2.equals((Object)"int"))) {
                if (!(string2.equals((Object)"long") || string2.equals((Object)"ui4") || string2.equals((Object)"time") || string2.equals((Object)"time.tz"))) {
                    if (!string2.equals((Object)"float") && !string2.equals((Object)"r4")) {
                        if (!(string2.equals((Object)"double") || string2.equals((Object)"r8") || string2.equals((Object)"number") || string2.equals((Object)"fixed.14.4"))) {
                            if (!(string2.equals((Object)"string") || string2.equals((Object)"string") || string2.equals((Object)"uri") || string2.equals((Object)"uuid"))) {
                                if (string2.equals((Object)"boolean")) {
                                    return i;
                                }
                                if (!(string2.equals((Object)"bytes") || string2.equals((Object)"bin.base64") || string2.equals((Object)"bin.hex"))) {
                                    return a;
                                }
                                return j;
                            }
                            return h;
                        }
                        return g;
                    }
                    return f;
                }
                return e;
            }
            return d;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])k.clone();
        }

        public final String toString() {
            switch (2.a[this.ordinal()]) {
                default: {
                    return "undefined";
                }
                case 9: {
                    return "string";
                }
                case 8: {
                    return "long";
                }
                case 7: {
                    return "integer";
                }
                case 6: {
                    return "float";
                }
                case 5: {
                    return "double";
                }
                case 4: {
                    return "bytes";
                }
                case 3: {
                    return "boolean";
                }
                case 1: 
                case 2: 
            }
            return "short";
        }
    }

}

