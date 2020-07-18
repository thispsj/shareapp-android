/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.l
 *  d.o
 *  java.lang.CloneNotSupportedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Type
 *  java.util.concurrent.Executor
 */
package d;

import d.b;
import d.c;
import d.d;
import d.g;
import d.l;
import d.o;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

final class g
extends c.a {
    final Executor a;

    g(Executor executor) {
        this.a = executor;
    }

    @Override
    public final c<?, ?> a(Type type) {
        if (o.a((Type)type) != b.class) {
            return null;
        }
        return new c<Object, b<?>>(o.e((Type)type)){
            final /* synthetic */ Type a;
            {
                this.a = type;
            }

            @Override
            public final /* synthetic */ Object a(b b2) {
                return new a(g.this.a, b2);
            }

            @Override
            public final Type a() {
                return this.a;
            }
        };
    }

    static final class a<T>
    implements b<T> {
        final Executor a;
        final b<T> b;

        a(Executor executor, b<T> b2) {
            this.a = executor;
            this.b = b2;
        }

        @Override
        public final void a(final d<T> d2) {
            o.a(d2, (String)"callback == null");
            this.b.a(new d<T>(){

                @Override
                public final void a(l<T> l2) {
                    a.this.a.execute(new Runnable(this, l2){
                        final /* synthetic */ l a;
                        final /* synthetic */ 1 b;
                        {
                            this.b = var1;
                            this.a = l2;
                        }

                        public final void run() {
                            if (this.b.a.this.b.a()) {
                                this.b.d2.a(new java.io.IOException("Canceled"));
                                return;
                            }
                            this.b.d2.a(this.a);
                        }
                    });
                }

                @Override
                public final void a(Throwable throwable) {
                    a.this.a.execute(new Runnable(this, throwable){
                        final /* synthetic */ Throwable a;
                        final /* synthetic */ 1 b;
                        {
                            this.b = var1;
                            this.a = throwable;
                        }

                        public final void run() {
                            this.b.d2.a(this.a);
                        }
                    });
                }
            });
        }

        @Override
        public final boolean a() {
            return this.b.a();
        }

        @Override
        public final b<T> b() {
            return new a<T>(this.a, this.b.b());
        }

        public final /* synthetic */ Object clone() throws CloneNotSupportedException {
            return this.b();
        }

    }

}

