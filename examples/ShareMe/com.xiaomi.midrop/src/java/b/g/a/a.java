/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.xiaomi.midrop.util.s
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.security.KeyPair
 *  java.security.PrivateKey
 */
package b.g.a;

import b.g.b.c;
import com.xiaomi.midrop.util.s;
import java.security.KeyPair;
import java.security.PrivateKey;

public class a {
    protected KeyPair a;
    protected byte[] b;

    protected final byte[] a(byte[] arrby) {
        if (this.d() && this.a != null) {
            arrby = s.a((byte[])arrby, (byte[])this.a.getPrivate().getEncoded(), (byte[])this.b);
        }
        return arrby;
    }

    protected final byte[] b(byte[] arrby) {
        if (this.d() && this.a != null) {
            arrby = s.b((byte[])arrby, (byte[])this.a.getPrivate().getEncoded(), (byte[])this.b);
        }
        return arrby;
    }

    protected final boolean d() {
        return this.b != null;
    }

}

