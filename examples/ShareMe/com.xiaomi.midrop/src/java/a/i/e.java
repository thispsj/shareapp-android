/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.Iterator
 */
package a.i;

import a.e.a.m;
import a.e.b.d;
import a.f;
import a.f.c;
import a.h.b;
import a.i.e;
import java.util.Iterator;

final class e
implements b<c> {
    final CharSequence a;
    final int b;
    final int c;
    final m<CharSequence, Integer, f<Integer, Integer>> d;

    public e(CharSequence charSequence, m<? super CharSequence, ? super Integer, f<Integer, Integer>> m2) {
        d.b((Object)charSequence, "input");
        d.b(m2, "getNextMatch");
        this.a = charSequence;
        this.b = 0;
        this.c = 0;
        this.d = m2;
    }

    @Override
    public final Iterator<c> a() {
        return (Iterator)new Iterator<c>(this){
            final /* synthetic */ e a;
            private int b;
            private int c;
            private int d;
            private c e;
            private int f;
            {
                this.a = e2;
                this.b = -1;
                this.d = this.c = a.f.d.a((int)e2.b, (int)0, (int)e2.a.length());
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            private final void a() {
                block6 : {
                    block5 : {
                        block4 : {
                            if (this.d < 0) {
                                this.b = 0;
                                this.e = null;
                                return;
                            }
                            var1_1 = this.a.c;
                            var2_2 = -1;
                            if (var1_1 <= 0) break block4;
                            this.f = 1 + this.f;
                            if (this.f >= this.a.c) break block5;
                        }
                        if (this.d <= this.a.a.length()) break block6;
                    }
                    var4_3 = new c(this.c, a.i.g.c((CharSequence)this.a.a));
                    ** GOTO lbl19
                }
                var3_4 = this.a.d.a(this.a.a, this.d);
                if (var3_4 == null) {
                    var4_3 = new c(this.c, a.i.g.c((CharSequence)this.a.a));
lbl19: // 2 sources:
                    this.e = var4_3;
                } else {
                    var5_5 = ((java.lang.Number)var3_4.a).intValue();
                    var6_6 = ((java.lang.Number)var3_4.b).intValue();
                    var7_7 = this.c;
                    var8_8 = var5_5 <= Integer.MIN_VALUE ? c.b() : new c(var7_7, var5_5 - 1);
                    this.e = var8_8;
                    var9_9 = this.c = var5_5 + var6_6;
                    var10_10 = 0;
                    if (var6_6 == 0) {
                        var10_10 = 1;
                    }
                    var2_2 = var9_9 + var10_10;
                }
                this.d = var2_2;
                this.b = 1;
            }

            public final boolean hasNext() {
                if (this.b == -1) {
                    this.a();
                }
                return this.b == 1;
            }

            public final /* synthetic */ Object next() {
                if (this.b == -1) {
                    this.a();
                }
                if (this.b == 0) {
                    throw (java.lang.Throwable)new java.util.NoSuchElementException();
                }
                c c2 = this.e;
                if (c2 == null) {
                    throw new a.j("null cannot be cast to non-null type kotlin.ranges.IntRange");
                }
                this.e = null;
                this.b = -1;
                return c2;
            }

            public final void remove() {
                throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }
}

