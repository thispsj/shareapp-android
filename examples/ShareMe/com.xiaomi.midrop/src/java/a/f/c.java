/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package a.f;

public final class c
extends a.f.a {
    public static final a e = new Object(0){};
    private static final c f = new c(1, 0);

    public c(int n2, int n3) {
        super(n2, n3, 1);
    }

    public static final /* synthetic */ c b() {
        return f;
    }

    @Override
    public final boolean a() {
        return this.a > this.b;
    }

    @Override
    public final boolean equals(Object object) {
        block2 : {
            block3 : {
                if (!(object instanceof c)) break block2;
                if (this.a() && ((c)object).a()) break block3;
                int n2 = this.a;
                c c2 = (c)object;
                if (n2 != c2.a || this.b != c2.b) break block2;
            }
            return true;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        if (this.a()) {
            return -1;
        }
        return 31 * this.a + this.b;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("..");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }

}

