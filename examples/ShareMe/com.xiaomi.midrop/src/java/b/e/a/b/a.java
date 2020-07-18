/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  android.util.Log
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.Locale
 *  midrop.c.d.c
 *  midrop.c.d.c$a
 */
package b.e.a.b;

import android.util.Base64;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import midrop.c.d.c;

public final class a {
    public String a;
    public int b;
    public String c;
    public byte d;
    public b.b.a e;
    public c.a f;
    public String g;
    public String h;
    private String i;
    private int j;

    public a() {
    }

    public a(String string2, int n2, c.a a2, b.b.a a3, String string3, int n3, byte by) {
        this.a = string2;
        this.f = a2;
        this.e = a3;
        this.b = n2;
        this.c = string3;
        this.d = by;
        this.j = n3;
    }

    private static int a(byte[] arrby, int n2) {
        int n3;
        int n4 = arrby.length;
        if (n4 >= n2) {
            n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                n3 += arrby[i2];
            }
        } else {
            n3 = 0;
        }
        return n3;
    }

    private static boolean a(byte[] arrby) {
        int n2 = arrby.length - 1;
        if (n2 <= 0) {
            StringBuilder stringBuilder = new StringBuilder("validateRawSsid end = ");
            stringBuilder.append(n2);
            stringBuilder.append(", skip");
            Log.w((String)"MiDrop:CustomSsid", (String)stringBuilder.toString());
        } else {
            int n3 = a.a(arrby, n2);
            if (arrby[n2] == (byte)(n3 & 255)) {
                return true;
            }
        }
        return false;
    }

    private static String b(byte[] arrby) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance((String)"MD5");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
        }
        byte[] arrby2 = messageDigest.digest(arrby);
        if (arrby2 != null) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{arrby2[0], arrby2[1], arrby2[2], arrby2[3]};
            return String.format((Locale)locale, (String)"%02X%02X%02X%02X", (Object[])arrobject);
        }
        return null;
    }

    public final String a() {
        block15 : {
            if (this.i == null) {
                byte[] arrby;
                block14 : {
                    arrby = new byte[12];
                    if (this.b >= 0) {
                        arrby[0] = (byte)(255 & this.b);
                    }
                    if (this.c != null && this.c.length() > 0) {
                        int n2;
                        try {
                            n2 = Integer.valueOf((String)this.c);
                            if (n2 == 0) break block14;
                        }
                        catch (NumberFormatException numberFormatException) {
                            numberFormatException.printStackTrace();
                            break block15;
                        }
                        arrby[4] = (byte)(n2 & 255);
                        arrby[5] = (byte)(255 & n2 >> 8);
                        arrby[6] = (byte)(255 & n2 >> 16);
                        arrby[7] = (byte)(255 & n2 >> 24);
                    }
                }
                arrby[8] = this.d;
                if (this.e != null) {
                    b.b.a a2 = this.e;
                    int n3 = a2.a;
                    if (a2.b) {
                        n3 = (byte)(n3 | 2);
                    }
                    if (a2.c) {
                        n3 = (byte)(n3 | 64);
                    }
                    if (a2.d) {
                        n3 = (byte)(n3 | 4);
                    }
                    if (a2.e) {
                        n3 = (byte)(n3 | 8);
                    }
                    if (a2.f) {
                        n3 = (byte)(n3 | 16);
                    }
                    if (a2.g) {
                        n3 = (byte)(n3 | 32);
                    }
                    arrby[9] = n3;
                }
                if (this.f != null) {
                    arrby[10] = this.f.a();
                }
                arrby[11] = (byte)(255 & a.a(arrby, 11));
                byte[] arrby2 = Base64.encode((byte[])arrby, (int)2);
                Locale locale = Locale.US;
                Object[] arrobject = new Object[]{new String(arrby2), b.d.a.a(this.a)};
                this.i = String.format((Locale)locale, (String)"%s%s", (Object[])arrobject);
                this.h = a.b(this.i.getBytes());
                Locale locale2 = Locale.US;
                Object[] arrobject2 = new Object[]{this.i.getBytes().length};
                Log.d((String)"MiDrop:CustomSsid", (String)String.format((Locale)locale2, (String)"ssid length: %d", (Object[])arrobject2));
                Locale locale3 = Locale.US;
                Object[] arrobject3 = new Object[]{this.a.getBytes().length};
                Log.d((String)"MiDrop:CustomSsid", (String)String.format((Locale)locale3, (String)"name length: %d", (Object[])arrobject3));
                Locale locale4 = Locale.US;
                Object[] arrobject4 = new Object[]{this.h.length()};
                Log.d((String)"MiDrop:CustomSsid", (String)String.format((Locale)locale4, (String)"password length: %d", (Object[])arrobject4));
            }
        }
        return this.i;
    }

    /*
     * Exception decompiling
     */
    public final boolean a(String var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl240.1 : IINC : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{this.a(), this.h};
        return String.format((Locale)locale, (String)"%s:%s", (Object[])arrobject);
    }
}

