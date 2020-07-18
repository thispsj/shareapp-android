/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.o
 *  java.lang.Object
 *  java.lang.reflect.Type
 */
package d;

import d.b;
import d.c;
import d.o;
import java.lang.reflect.Type;

final class f
extends c.a {
    static final c.a a = new f();

    f() {
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
            public final Type a() {
                return this.a;
            }
        };
    }

}

