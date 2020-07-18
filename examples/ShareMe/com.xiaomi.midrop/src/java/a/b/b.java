/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.b.b$b
 *  a.b.b$c
 *  java.io.Serializable
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package a.b;

import a.b.b;
import a.b.e;
import a.b.f;
import a.e.a.m;
import a.e.b.d;
import a.e.b.f;
import a.j;
import a.l;
import java.io.Serializable;

public final class b
implements e,
Serializable {
    private final e a;
    private final e.b b;

    public b(e e2, e.b b2) {
        d.b(e2, "left");
        d.b(b2, "element");
        this.a = e2;
        this.b = b2;
    }

    private final int a() {
        b b2 = this;
        int n2 = 2;
        do {
            e e2;
            if (!((e2 = b2.a) instanceof b)) {
                e2 = null;
            }
            if ((b2 = (b)e2) == null) {
                return n2;
            }
            ++n2;
        } while (true);
    }

    private final boolean a(e.b b2) {
        return d.a(this.get(b2.getKey()), (Object)b2);
    }

    private final Object writeReplace() {
        int n2 = this.a();
        e[] arre = new e[n2];
        f.a a2 = new f.a();
        a2.a = 0;
        this.fold(l.a, (m)new c(arre, a2));
        int n3 = a2.a;
        boolean bl = false;
        if (n3 == n2) {
            bl = true;
        }
        if (!bl) {
            throw (Throwable)new IllegalStateException("Check failed.".toString());
        }
        return new Serializable(arre){
            public static final a a = new a(0);
            private static final long serialVersionUID;
            private final e[] b;
            {
                d.b(arre, "elements");
                this.b = arre;
            }

            private final Object readResolve() {
                e[] arre = this.b;
                e e2 = f.a;
                for (e e3 : arre) {
                    e2 = ((e)e2).plus(e3);
                }
                return e2;
            }

            public static final class a {
                private a() {
                }

                public /* synthetic */ a(byte by) {
                }
            }

        };
    }

    public final boolean equals(Object object) {
        block8 : {
            block9 : {
                boolean bl;
                block7 : {
                    b b2;
                    e e2;
                    if ((b)this == object) break block8;
                    if (!(object instanceof b) || (b2 = (b)object).a() != b.super.a()) break block9;
                    b b3 = this;
                    do {
                        if (!b2.a(b3.b)) {
                            bl = false;
                            break block7;
                        }
                        e2 = b3.a;
                        if (!(e2 instanceof b)) break;
                        b3 = (b)e2;
                    } while (true);
                    if (e2 == null) {
                        throw new j("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                    }
                    bl = b2.a(e2);
                }
                if (bl) break block8;
            }
            return false;
        }
        return true;
    }

    @Override
    public final <R> R fold(R r2, m<? super R, ? super e.b, ? extends R> m2) {
        d.b(m2, "operation");
        return m2.a(this.a.fold(r2, m2), this.b);
    }

    @Override
    public final <E extends e.b> E get(e.c<E> c2) {
        e e2;
        d.b(c2, "key");
        b b2 = (b)this;
        do {
            E e3;
            if ((e3 = b2.b.get(c2)) != null) {
                return e3;
            }
            e2 = b2.a;
            if (!(e2 instanceof b)) break;
            b2 = (b)e2;
        } while (true);
        return e2.get(c2);
    }

    public final int hashCode() {
        return this.a.hashCode() + this.b.hashCode();
    }

    @Override
    public final e minusKey(e.c<?> c2) {
        d.b(c2, "key");
        if (this.b.get(c2) != null) {
            return this.a;
        }
        e e2 = this.a.minusKey(c2);
        if (e2 == this.a) {
            return (e)this;
        }
        if (e2 == f.a) {
            return this.b;
        }
        return new b(e2, this.b);
    }

    @Override
    public final e plus(e e2) {
        d.b(e2, "context");
        return e.a.a((e)this, e2);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(this.fold("", (m)b.a));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}

