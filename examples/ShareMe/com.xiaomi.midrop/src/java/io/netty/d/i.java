/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runtime
 *  java.lang.String
 *  java.util.Locale
 */
package io.netty.d;

import io.netty.d.b.l;
import io.netty.d.b.u;
import java.util.Locale;

public final class i {
    private static final a a = new a();

    public static int a() {
        return a.a();
    }

    static final class a {
        private int a;

        a() {
        }

        private void a(int n2) {
            void var6_2 = this;
            synchronized (var6_2) {
                l.a(n2, "availableProcessors");
                if (this.a != 0) {
                    Locale locale = Locale.ROOT;
                    Object[] arrobject = new Object[]{this.a, n2};
                    throw new IllegalStateException(String.format((Locale)locale, (String)"availableProcessors is already set to [%d], rejecting [%d]", (Object[])arrobject));
                }
                this.a = n2;
                return;
            }
        }

        final int a() {
            a a2 = this;
            synchronized (a2) {
                if (this.a == 0) {
                    this.a(u.a("io.netty.availableProcessors", Runtime.getRuntime().availableProcessors()));
                }
                int n2 = this.a;
                return n2;
            }
        }
    }

}

