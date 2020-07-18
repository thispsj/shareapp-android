/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package a.e.b;

import java.io.Serializable;

public final class f {

    public static final class a
    implements Serializable {
        public int a;

        public final String toString() {
            return String.valueOf((int)this.a);
        }
    }

    public static final class b<T>
    implements Serializable {
        public T a;

        public final String toString() {
            return String.valueOf(this.a);
        }
    }

}

