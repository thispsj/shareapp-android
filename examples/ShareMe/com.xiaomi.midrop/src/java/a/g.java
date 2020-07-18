/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package a;

import a.e.b.d;
import java.io.Serializable;

public final class g<T>
implements Serializable {
    public static final a a = new a(0);
    private final Object b;

    public static final boolean a(Object object) {
        return !(object instanceof b);
    }

    public static final Throwable b(Object object) {
        if (object instanceof b) {
            return ((b)object).a;
        }
        return null;
    }

    public static Object c(Object object) {
        return object;
    }

    public final boolean equals(Object object) {
        Object object2 = this.b;
        return object instanceof g && d.a(object2, ((g)object).b);
    }

    public final int hashCode() {
        Object object = this.b;
        if (object != null) {
            return object.hashCode();
        }
        return 0;
    }

    public final String toString() {
        Object object = this.b;
        if (object instanceof b) {
            return object.toString();
        }
        StringBuilder stringBuilder = new StringBuilder("Success(");
        stringBuilder.append(object);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte by) {
        }
    }

    public static final class b
    implements Serializable {
        public final Throwable a;

        public b(Throwable throwable) {
            d.b((Object)throwable, "exception");
            this.a = throwable;
        }

        public final boolean equals(Object object) {
            return object instanceof b && d.a((Object)this.a, (Object)((b)object).a);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Failure(");
            stringBuilder.append((Object)this.a);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

}

