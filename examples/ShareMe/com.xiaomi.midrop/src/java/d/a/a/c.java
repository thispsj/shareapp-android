/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  okhttp3.ad
 */
package d.a.a;

import c.f;
import com.a.b.h;
import com.a.b.l;
import d.e;
import java.io.IOException;
import okhttp3.ad;

final class c<T>
implements e<ad, T> {
    private static final f a = f.c("EFBBBF");
    private final h<T> b;

    c(h<T> h2) {
        this.b = h2;
    }

    @Override
    private T a(ad ad2) throws IOException {
        c.e e2 = ad2.c();
        try {
            if (e2.c(a)) {
                e2.i(a.h());
            }
            T t2 = this.b.a(l.a(e2));
            return t2;
        }
        finally {
            ad2.close();
        }
    }
}

