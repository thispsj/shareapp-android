/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  midrop.service.c.d
 */
package b.a;

import android.util.Base64;
import b.a.p;
import java.nio.ByteBuffer;
import midrop.service.c.d;

public final class e {
    public int a;
    public String b;

    public e(int n2, String string2) {
        this.a = n2;
        this.b = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static e a(byte[] arrby) {
        int n2;
        int n3;
        String string2;
        StringBuilder stringBuilder;
        int n4;
        try {
            byte[] arrby2 = Base64.decode((byte[])arrby, (int)2);
            if (p.a(arrby2) != 1450709556) {
                d.b((String)"BleRespData", (String)"magic not match", (Object[])new Object[0]);
                return null;
            }
            n3 = p.a(arrby2, 4);
            if (arrby2.length - 8 < 6) {
                return null;
            }
            byte[] arrby3 = new byte[6];
            System.arraycopy((Object)arrby2, (int)8, (Object)arrby3, (int)0, (int)6);
            string2 = String.valueOf((char[])p.b(arrby3));
            stringBuilder = new StringBuilder(17);
            n4 = string2.length() - 2;
            n2 = 0;
        }
        catch (Exception exception) {
            d.a((String)"BleRespData", (String)"parse", (Throwable)exception, (Object[])new Object[0]);
            return null;
        }
        while (n2 <= n4) {
            int n5 = n2 + 2;
            stringBuilder.append(string2.substring(n2, n5));
            if (n2 < n4) {
                stringBuilder.append(":");
            }
            n2 = n5;
        }
        return new e(n3, stringBuilder.toString());
    }

    public final byte[] a() {
        byte[] arrby;
        ByteBuffer byteBuffer;
        block3 : {
            try {
                byteBuffer = ByteBuffer.allocate((int)14);
                byteBuffer.put(p.a(1450709556));
                byteBuffer.put(p.a(this.a));
                String string2 = this.b.replace((CharSequence)":", (CharSequence)"");
                arrby = p.a(string2.toCharArray());
                if (arrby.length == 6) break block3;
                StringBuilder stringBuilder = new StringBuilder("invalid len ");
                stringBuilder.append(string2);
                d.b((String)"BleRespData", (String)stringBuilder.toString(), (Object[])new Object[0]);
                return null;
            }
            catch (Exception exception) {
                d.a((String)"BleRespData", (String)"parse", (Throwable)exception, (Object[])new Object[0]);
                return null;
            }
        }
        byteBuffer.put(arrby);
        byte[] arrby2 = Base64.encode((byte[])byteBuffer.array(), (int)2);
        return arrby2;
    }
}

