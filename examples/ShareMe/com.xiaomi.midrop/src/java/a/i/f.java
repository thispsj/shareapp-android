/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.regex.Pattern
 */
package a.i;

import a.e.b.d;
import java.io.Serializable;
import java.util.regex.Pattern;

public final class f
implements Serializable {
    public static final a b = new a(0);
    public final Pattern a;

    public f(String string2) {
        d.b(string2, "pattern");
        Pattern pattern = Pattern.compile((String)string2);
        d.a((Object)pattern, "Pattern.compile(pattern)");
        super(pattern);
    }

    public f(Pattern pattern) {
        d.b((Object)pattern, "nativePattern");
        this.a = pattern;
    }

    private final Object writeReplace() {
        String string2 = this.a.pattern();
        d.a((Object)string2, "nativePattern.pattern()");
        return new b(string2, this.a.flags());
    }

    public final String toString() {
        String string2 = this.a.toString();
        d.a((Object)string2, "nativePattern.toString()");
        return string2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte by) {
        }
    }

    private static final class b
    implements Serializable {
        public static final a a = new a(0);
        private static final long serialVersionUID;
        private final String b;
        private final int c;

        public b(String string2, int n2) {
            d.b(string2, "pattern");
            this.b = string2;
            this.c = n2;
        }

        private final Object readResolve() {
            Pattern pattern = Pattern.compile((String)this.b, (int)this.c);
            d.a((Object)pattern, "Pattern.compile(pattern, flags)");
            return new f(pattern);
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte by) {
            }
        }

    }

}

