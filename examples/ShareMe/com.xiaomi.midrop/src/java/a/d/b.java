/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.a
 *  java.io.Closeable
 *  java.lang.Object
 *  java.lang.Throwable
 */
package a.d;

import a.a;
import java.io.Closeable;

public final class b {
    public static final void a(Closeable closeable, Throwable throwable) {
        if (closeable != null) {
            if (throwable == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
                return;
            }
            catch (Throwable throwable2) {
                a.a((Throwable)throwable, (Throwable)throwable2);
            }
        }
    }
}

