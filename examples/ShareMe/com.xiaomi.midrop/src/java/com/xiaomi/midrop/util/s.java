/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  midrop.service.c.d
 */
package com.xiaomi.midrop.util;

import android.util.Base64;
import com.xiaomi.midrop.util.r;
import midrop.service.c.d;

public final class s {
    public static byte[] a(byte[] arrby, byte[] arrby2, byte[] arrby3) {
        try {
            byte[] arrby4 = Base64.encode((byte[])r.a(arrby, arrby2, arrby3, r.a.a.name()), (int)2);
            return arrby4;
        }
        catch (Exception exception) {
            d.a((String)"JDHHelper", (String)"encrypt", (Throwable)exception, (Object[])new Object[0]);
            return null;
        }
    }

    public static byte[] b(byte[] arrby, byte[] arrby2, byte[] arrby3) {
        try {
            byte[] arrby4 = r.b(Base64.decode((byte[])arrby, (int)2), arrby2, arrby3, r.a.a.name());
            return arrby4;
        }
        catch (Exception exception) {
            d.a((String)"JDHHelper", (String)"decrypt", (Throwable)exception, (Object[])new Object[0]);
            return null;
        }
    }
}

