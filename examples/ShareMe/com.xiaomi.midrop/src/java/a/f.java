/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package a;

import a.e.b.d;
import java.io.Serializable;

public final class f<A, B>
implements Serializable {
    public final A a;
    public final B b;

    public f(A a2, B b2) {
        this.a = a2;
        this.b = b2;
    }

    public final boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof f)) break block3;
                f f2 = (f)object;
                if (d.a(this.a, f2.a) && d.a(this.b, f2.b)) break block2;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        A a2 = this.a;
        int n2 = a2 != null ? a2.hashCode() : 0;
        int n3 = n2 * 31;
        B b2 = this.b;
        int n4 = 0;
        if (b2 != null) {
            n4 = b2.hashCode();
        }
        return n3 + n4;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("(");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

