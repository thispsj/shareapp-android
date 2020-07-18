/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 */
package midrop.c.b.a;

import java.io.InputStream;
import midrop.c.a.e;
import midrop.c.b.a.a;

public class b {
    private static final String a = "b";

    public static e a(InputStream inputStream) {
        e e2 = null;
        if (inputStream != null) {
            e e3 = new e();
            new a();
            if (!a.a(e3, inputStream)) {
                return null;
            }
            e2 = e3;
        }
        return e2;
    }
}

