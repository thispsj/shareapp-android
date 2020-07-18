/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  okhttp3.ab
 *  okhttp3.v
 */
package d.a.a;

import c.c;
import c.f;
import com.a.b.h;
import com.a.b.p;
import d.e;
import java.io.IOException;
import okhttp3.ab;
import okhttp3.v;

final class b<T>
implements e<T, ab> {
    private static final v a = v.a((String)"application/json; charset=UTF-8");
    private final h<T> b;

    b(h<T> h2) {
        this.b = h2;
    }

    @Override
    public final /* synthetic */ Object a(Object object) throws IOException {
        c c2 = new c();
        p p2 = p.a(c2);
        this.b.a(p2, object);
        return ab.a((v)a, (f)c2.l());
    }
}

