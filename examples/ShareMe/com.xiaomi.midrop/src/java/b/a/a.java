/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.security.Key
 *  javax.crypto.Cipher
 *  javax.crypto.spec.SecretKeySpec
 *  midrop.service.c.d
 */
package b.a;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import midrop.service.c.d;

public final class a {
    static byte[] a(byte[] arrby, byte[] arrby2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(arrby2, "AES");
            Cipher cipher = Cipher.getInstance((String)"AES/ECB/PKCS5Padding");
            cipher.init(1, (Key)secretKeySpec);
            byte[] arrby3 = cipher.doFinal(arrby);
            return arrby3;
        }
        catch (Exception exception) {
            d.a((String)"AesUtils", (String)"decrypt", (Throwable)exception, (Object[])new Object[0]);
            return null;
        }
    }

    static byte[] b(byte[] arrby, byte[] arrby2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(arrby2, "AES");
            Cipher cipher = Cipher.getInstance((String)"AES/ECB/PKCS5Padding");
            cipher.init(2, (Key)secretKeySpec);
            byte[] arrby3 = cipher.doFinal(arrby);
            return arrby3;
        }
        catch (Exception exception) {
            d.a((String)"AesUtils", (String)"decrypt", (Throwable)exception, (Object[])new Object[0]);
            return null;
        }
    }
}

