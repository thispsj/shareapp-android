/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.reflect.Type
 *  javax.annotation.Nullable
 */
package d;

import d.b;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

public interface c<R, T> {
    public T a(b<R> var1);

    public Type a();

    public static abstract class a {
        @Nullable
        public abstract c<?, ?> a(Type var1);
    }

}

