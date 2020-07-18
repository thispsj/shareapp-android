/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  d.o
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Type
 *  okhttp3.ab
 *  okhttp3.ad
 */
package d;

import d.b.w;
import d.e;
import d.o;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.ab;
import okhttp3.ad;

final class a
extends e.a {
    a() {
    }

    @Override
    public final d.e<ad, ?> a(Type type, Annotation[] arrannotation) {
        if (type == ad.class) {
            if (o.a((Annotation[])arrannotation, w.class)) {
                return c.a;
            }
            return a.a;
        }
        if (type == Void.class) {
            return e.a;
        }
        return null;
    }

    @Override
    public final d.e<?, ab> b(Type type, Annotation[] arrannotation) {
        if (ab.class.isAssignableFrom(o.a((Type)type))) {
            return b.a;
        }
        return null;
    }

    static final class a
    implements d.e<ad, ad> {
        static final a a = new a();

        a() {
        }

        private static ad a(ad ad2) throws IOException {
            try {
                ad ad3 = o.a((ad)ad2);
                return ad3;
            }
            finally {
                ad2.close();
            }
        }
    }

    static final class b
    implements d.e<ab, ab> {
        static final b a = new b();

        b() {
        }
    }

    static final class c
    implements d.e<ad, ad> {
        static final c a = new c();

        c() {
        }
    }

    static final class d
    implements d.e<Object, String> {
        static final d a = new d();

        d() {
        }

        @Override
        public final /* synthetic */ Object a(Object object) throws IOException {
            return object.toString();
        }
    }

    static final class e
    implements d.e<ad, Void> {
        static final e a = new e();

        e() {
        }

        @Override
        public final /* synthetic */ Object a(Object object) throws IOException {
            ((ad)object).close();
            return null;
        }
    }

}

