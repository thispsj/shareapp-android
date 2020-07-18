/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.lang.annotation.Annotation
 */
package a.b.b.a;

import a.b.b.a.d;
import a.b.b.a.e;
import a.b.c;
import a.g;
import a.h;
import a.l;
import java.io.Serializable;
import java.lang.annotation.Annotation;

public abstract class a
implements c<Object>,
Serializable {
    final c<Object> h;

    public a(c<Object> c2) {
        this.h = c2;
    }

    public c<l> a(Object object, c<?> c2) {
        a.e.b.d.b(c2, "completion");
        throw (Throwable)new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public abstract Object a(Object var1);

    protected void b() {
    }

    @Override
    public final void b(Object object) {
        c<Object> c2;
        a.e.b.d.b((c)this, "frame");
        a a2 = (a)this;
        do {
            if ((c2 = a2.h) == null) {
                a.e.b.d.a();
            }
            try {
                Object object2 = a2.a(object);
                if (object2 == a.b.a.a.a) {
                    return;
                }
                object = g.c(object2);
            }
            catch (Throwable throwable) {
                object = g.c(h.a(throwable));
            }
            a2.b();
            if (!(c2 instanceof a)) break;
            a2 = (a)c2;
        } while (true);
        c2.b(object);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        String string2;
        StringBuilder stringBuilder = new StringBuilder("Continuation at ");
        a.e.b.d.b(this, "receiver$0");
        d d2 = (d)this.getClass().getAnnotation(d.class);
        if (d2 == null) {
            string2 = null;
        } else {
            int n2 = d2.a();
            if (n2 > 1) {
                StringBuilder stringBuilder2 = new StringBuilder("Debug metadata version mismatch. Expected: 1, got ");
                stringBuilder2.append(n2);
                stringBuilder2.append(". Please update the Kotlin standard library.");
                throw (Throwable)new IllegalStateException(stringBuilder2.toString().toString());
            }
            int n3 = e.a(this);
            int n4 = n3 < 0 ? -1 : d2.c()[n3];
            string2 = new StackTraceElement(d2.e(), d2.d(), d2.b(), n4);
        }
        if (string2 == null) {
            string2 = this.getClass().getName();
        }
        Serializable serializable = (Serializable)string2;
        stringBuilder.append((Object)serializable);
        return stringBuilder.toString();
    }
}

