/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 */
package a.d;

import a.e.b.d;
import java.io.InputStream;
import java.io.OutputStream;

public final class a {
    public static final long a(InputStream inputStream, OutputStream outputStream) {
        d.b((Object)inputStream, "receiver$0");
        d.b((Object)outputStream, "out");
        byte[] arrby = new byte[8192];
        int n2 = inputStream.read(arrby);
        long l2 = 0L;
        while (n2 >= 0) {
            outputStream.write(arrby, 0, n2);
            long l3 = l2 + (long)n2;
            n2 = inputStream.read(arrby);
            l2 = l3;
        }
        return l2;
    }
}

