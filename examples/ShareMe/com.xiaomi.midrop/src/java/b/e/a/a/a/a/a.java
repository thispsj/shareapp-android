/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.Method
 *  midrop.service.c.d
 */
package b.e.a.a.a.a;

import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import midrop.service.c.d;

public final class a
implements InvocationHandler {
    private a a;

    public a(a a2) {
        this.a = a2;
    }

    public final Object invoke(Object object, Method method, Object[] arrobject) throws Throwable {
        block4 : {
            new StringBuilder("invoke, method: ").append(method.getName());
            if (!TextUtils.equals((CharSequence)method.getName(), (CharSequence)"onSuccess") || this.a == null) break block4;
            this.a.a();
            return object;
        }
        try {
            if (TextUtils.equals((CharSequence)method.getName(), (CharSequence)"onFailure") && this.a != null) {
                this.a.b();
                return object;
            }
        }
        catch (Exception exception) {
            d.a((String)"ContentValues", (String)exception.toString(), (Throwable)exception, (Object[])new Object[0]);
        }
        return object;
    }

    public static interface a {
        public void a();

        public void b();
    }

}

