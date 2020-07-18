/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Type
 *  javax.annotation.Nullable
 *  okhttp3.ab
 *  okhttp3.ad
 */
package d;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.ab;
import okhttp3.ad;

public interface e<F, T> {
    public T a(F var1) throws IOException;

    public static abstract class a {
        @Nullable
        public e<ad, ?> a(Type type, Annotation[] arrannotation) {
            return null;
        }

        @Nullable
        public e<?, ab> b(Type type, Annotation[] arrannotation) {
            return null;
        }
    }

}

