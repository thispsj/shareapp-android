/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.f.b
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Iterator
 */
package a.f;

import a.a.s;
import a.c.c;
import a.f.b;
import java.util.Iterator;

public class a
implements Iterable<Integer> {
    public static final a d = new a(0);
    public final int a;
    public final int b;
    public final int c;

    public a(int n2, int n3, int n4) {
        block10 : {
            block9 : {
                block8 : {
                    if (n4 == 0) {
                        throw (Throwable)new IllegalArgumentException("Step must be non-zero.");
                    }
                    if (n4 == Integer.MIN_VALUE) {
                        throw (Throwable)new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
                    }
                    this.a = n2;
                    if (n4 <= 0) break block8;
                    if (n2 < n3) {
                        n3 -= c.a(n3, n2, n4);
                    }
                    break block9;
                }
                if (n4 >= 0) break block10;
                if (n2 > n3) {
                    n3 += c.a(n2, n3, -n4);
                }
            }
            this.b = n3;
            this.c = n4;
            return;
        }
        throw (Throwable)new IllegalArgumentException("Step is zero.");
    }

    public boolean a() {
        if (this.c > 0) {
            return this.a > this.b;
        }
        return this.a < this.b;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (!(object instanceof a)) break block2;
                if (this.a() && ((a)object).a()) break block3;
                int n2 = this.a;
                a a2 = (a)object;
                if (n2 != a2.a || this.b != a2.b || this.c != a2.c) break block2;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.a()) {
            return -1;
        }
        return 31 * (31 * this.a + this.b) + this.c;
    }

    public /* synthetic */ Iterator iterator() {
        return (s)new b(this.a, this.b, this.c);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        StringBuilder stringBuilder;
        int n2;
        if (this.c > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("..");
            stringBuilder.append(this.b);
            stringBuilder.append(" step ");
            n2 = this.c;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(" downTo ");
            stringBuilder.append(this.b);
            stringBuilder.append(" step ");
            n2 = -this.c;
        }
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte by) {
        }
    }

}

