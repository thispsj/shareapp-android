/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 *  com.xiaomi.midrop.util.am
 *  com.xiaomi.midrop.util.e
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.security.InvalidParameterException
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  midrop.b.b.a.b
 *  midrop.service.c.d
 */
package b.a;

import android.text.TextUtils;
import android.util.Base64;
import b.a.o;
import b.a.p;
import b.a.q;
import com.xiaomi.midrop.util.am;
import com.xiaomi.midrop.util.e;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import midrop.b.b.a.b;
import midrop.service.c.d;

public final class k {
    public String a;
    public String b;
    public String c;
    public String d;
    public q e;
    public int f;
    public int g;
    public boolean h;
    public int i;
    private int j;

    private k(String string2, q q2, int n2, int n3) {
        this.g = 0;
        this.j = a.a;
        this.a = string2;
        this.e = q2;
        this.f = n2;
        this.i = n3;
        k.super.c();
    }

    private k(String string2, q q2, int n2, int n3, int n4) {
        this.g = 0;
        this.j = n3;
        this.a = string2;
        this.e = q2;
        this.f = n2;
        this.i = n4;
        this.c();
    }

    public k(String string2, String string3, String string4, String string5, q q2, int n2, int n3, boolean bl, int n4) {
        this.g = 0;
        this.j = a.b;
        this.a = string2;
        this.b = string3;
        this.c = string4;
        this.d = string5;
        this.e = q2;
        this.g = n2;
        this.f = n3;
        this.h = bl;
        this.i = n4;
    }

    private static int a(byte[] arrby, int n2) {
        if (n2 >= arrby.length) {
            return 0;
        }
        return arrby[n2];
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static k a(int n2, String string2) {
        int n3;
        int n4;
        String string3;
        String string4;
        q q2;
        int n5;
        String string5;
        byte[] arrby;
        String string6;
        int n6;
        block28 : {
            block25 : {
                int n7;
                int n8;
                int n9;
                block27 : {
                    block26 : {
                        int n10;
                        int n11;
                        int n12;
                        int n13;
                        q q3;
                        block23 : {
                            block22 : {
                                int n14;
                                block24 : {
                                    arrby = k.b(n2, string2);
                                    if (arrby == null) {
                                        return null;
                                    }
                                    n6 = p.a(arrby, 4);
                                    int n15 = a.a;
                                    n13 = 8;
                                    n10 = -1;
                                    int n16 = 9;
                                    n9 = 1;
                                    if (n2 == n15) {
                                        String string7;
                                        int n17 = k.a(arrby, n13);
                                        if (n17 > 0) {
                                            string7 = k.a(arrby, n16, n17);
                                            n16 += n17;
                                        } else {
                                            string7 = null;
                                        }
                                        q q4 = new q();
                                        int n18 = k.a(arrby, n16);
                                        int n19 = n16 + n9;
                                        if (n18 == n9) {
                                            q4.a((byte)k.a(arrby, n19));
                                            ++n19;
                                        }
                                        if (arrby.length <= n19) return new k(string7, q4, n6, n10);
                                        n10 = p.a(arrby, n19);
                                        return new k(string7, q4, n6, n10);
                                    }
                                    if (n2 == a.c) {
                                        q3 = new q();
                                        q3.a((byte)k.a(arrby, 0));
                                        if (!q3.e) break block22;
                                        n11 = n9 >= arrby.length ? 0 : arrby[n9];
                                        break block23;
                                    }
                                    if (n2 != a.b) return null;
                                    int n20 = k.a(arrby, n13);
                                    if (n20 > 0) {
                                        string4 = k.a(arrby, n16, n20);
                                        n16 += n20;
                                    } else {
                                        string4 = null;
                                    }
                                    int n21 = k.a(arrby, n16);
                                    int n22 = n16 + n9;
                                    if (n21 > 0) {
                                        ByteBuffer byteBuffer = ByteBuffer.allocate((int)n21);
                                        byteBuffer.put(arrby, n22, n21);
                                        string3 = new String(b.a.a.b(byteBuffer.array(), k.c(string4)));
                                        n22 += n21;
                                    } else {
                                        string3 = null;
                                    }
                                    int n23 = k.a(arrby, n22);
                                    int n24 = n22 + n9;
                                    if (n23 > 0) {
                                        String string8 = k.a(arrby, n24, n23);
                                        n24 += n23;
                                        string5 = string8;
                                    } else {
                                        string5 = null;
                                    }
                                    int n25 = k.a(arrby, n24);
                                    int n26 = n24 + n9;
                                    if (n25 > 0) {
                                        string6 = k.a(arrby, n26, n25);
                                        n26 += n25;
                                    } else {
                                        string6 = null;
                                    }
                                    q2 = new q();
                                    int n27 = k.a(arrby, n26);
                                    n14 = n26 + n9;
                                    if (n27 != n9) break block24;
                                    q2.a((byte)k.a(arrby, n14));
                                    ++n14;
                                }
                                try {
                                    int n28 = k.a(arrby, n14);
                                    n5 = n14 + n9;
                                    if (n28 > 0) {
                                        int n29 = k.b(arrby, n5);
                                        n5 += n28;
                                        n4 = n29;
                                    } else {
                                        n4 = 8181;
                                    }
                                    if ((n8 = k.a(arrby, n5)) <= 0) break block25;
                                    n7 = n5 + 1;
                                    if (k.b(arrby, n7) == 0) break block26;
                                    break block27;
                                }
                                catch (Exception exception) {
                                    d.a((String)"BtDeviceInfo", (String)"parse", (Throwable)exception, (Object[])new Object[0]);
                                }
                                return null;
                            }
                            n11 = -1;
                        }
                        if ((n12 = k.a(arrby, 2)) <= 0) return null;
                        String string9 = k.a(arrby, 3, n12);
                        n13 = 3 + n12;
                        if (string9 == null) {
                            return null;
                        }
                        if (n11 != n10) return new k(string9, q3, n6, n11);
                        if (k.a(arrby, n13) > 0) {
                            n10 = p.a(arrby, n13);
                        }
                        if (n10 < 0) return new k(string9, q3, n6, n11);
                        n11 = n10;
                        return new k(string9, q3, n6, n11);
                    }
                    n9 = 0;
                }
                n5 = n7 + n8;
                n3 = n9;
                break block28;
            }
            n3 = 0;
        }
        int n30 = arrby.length > n5 ? p.a(arrby, n5) : -1;
        return new k(string6, string4, string3, string5, q2, n4, n6, (boolean)n3, n30);
    }

    public static String a(int n2, int n3, int n4) {
        q q2 = new q();
        q2.a = b.g();
        am.e();
        q2.b = false;
        q2.c = true;
        q2.d = o.d();
        q2.e = true;
        q2.f = true;
        q2.g = true;
        k k2 = new k(e.a(), q2, n2, n3, n4);
        return k2.a();
    }

    private static String a(byte[] arrby, int n2, int n3) {
        if (n2 + n3 > arrby.length) {
            return null;
        }
        return new String(arrby, n2, n3);
    }

    /*
     * Exception decompiling
     */
    public static boolean a(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl13 : ALOAD_1 : trying to set 1 previously set to 0
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

    private static boolean a(byte[] arrby) {
        if (arrby == null) {
            return false;
        }
        return 1296647248 == p.a(arrby);
    }

    private static int b(byte[] arrby, int n2) {
        if (n2 + 4 > arrby.length) {
            return 0;
        }
        return p.a(arrby, n2);
    }

    private static byte[] b() {
        return ByteBuffer.allocate((int)1).put((byte)0).array();
    }

    /*
     * Exception decompiling
     */
    private static byte[] b(int var0, String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl25 : ALOAD_2 : trying to set 1 previously set to 0
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

    public static byte[] b(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return k.b();
        }
        return k.b(string2.getBytes());
    }

    private static byte[] b(byte[] arrby) {
        if (arrby == null) {
            return k.b();
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)(1 + arrby.length));
        if (arrby.length > 127) {
            throw new InvalidParameterException("too long");
        }
        byteBuffer.put((byte)arrby.length);
        byteBuffer.put(arrby);
        return byteBuffer.array();
    }

    private void c() {
        if (this.a == null) {
            return;
        }
        if (this.a.getBytes().length > 15) {
            throw new InvalidParameterException("name too long");
        }
    }

    private static byte[] c(String string2) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance((String)"MD5");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
            return null;
        }
        return messageDigest.digest(string2.getBytes());
    }

    public final String a() {
        ByteBuffer byteBuffer;
        byte[] arrby = p.a(1296647248);
        byte[] arrby2 = p.a(this.f);
        byte[] arrby3 = p.a(this.i);
        if (this.j == a.a) {
            byte[] arrby4;
            byte[] arrby5 = k.b(this.a);
            if (this.e != null) {
                byte[] arrby6 = new byte[]{this.e.a()};
                arrby4 = k.b(arrby6);
            } else {
                arrby4 = k.b("");
            }
            byteBuffer = ByteBuffer.allocate((int)(arrby.length + arrby2.length + arrby5.length + arrby4.length + arrby3.length));
            byteBuffer.put(arrby);
            byteBuffer.put(arrby2);
            byteBuffer.put(arrby5);
            byteBuffer.put(arrby4);
            byteBuffer.put(arrby3);
        } else {
            byte[] arrby7;
            if (this.j == a.c) {
                byte[] arrby8 = k.b(this.a);
                ByteBuffer byteBuffer2 = ByteBuffer.allocate((int)(1 + (1 + arrby8.length)));
                if (this.e != null) {
                    byteBuffer2.put(this.e.a());
                } else {
                    byteBuffer2.put((byte)0);
                }
                byteBuffer2.put((byte)this.i);
                byteBuffer2.put(arrby8);
                return new String(byteBuffer2.array());
            }
            byte[] arrby9 = k.b(this.b);
            byte[] arrby10 = k.b(b.a.a.a(this.c.getBytes(), k.c(this.b)));
            byte[] arrby11 = k.b(this.d);
            byte[] arrby12 = k.b(this.a);
            if (this.e != null) {
                byte[] arrby13 = new byte[]{this.e.a()};
                arrby7 = k.b(arrby13);
            } else {
                arrby7 = k.b("");
            }
            byte[] arrby14 = k.b(p.a(this.g));
            byte[] arrby15 = k.b(p.a((int)this.h));
            ByteBuffer byteBuffer3 = ByteBuffer.allocate((int)(arrby.length + arrby2.length + arrby9.length + arrby10.length + arrby11.length + arrby12.length + arrby7.length + arrby14.length + arrby15.length + arrby3.length));
            byteBuffer3.put(arrby);
            byteBuffer3.put(arrby2);
            byteBuffer3.put(arrby9);
            byteBuffer3.put(arrby10);
            byteBuffer3.put(arrby11);
            byteBuffer3.put(arrby12);
            byteBuffer3.put(arrby7);
            byteBuffer3.put(arrby14);
            byteBuffer3.put(arrby15);
            byteBuffer3.put(arrby3);
            byteBuffer = byteBuffer3;
        }
        return new String(Base64.encode((byte[])byteBuffer.array(), (int)2));
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && object instanceof k) {
            k k2 = (k)object;
            return TextUtils.equals((CharSequence)this.b, (CharSequence)k2.b);
        }
        return false;
    }

    public static final class a
    extends Enum<a> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d;

        static {
            int[] arrn = new int[]{a, b, c};
            d = arrn;
        }
    }

}

