/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.a.aa
 *  org.a.b
 *  org.a.e
 *  org.a.f
 *  org.a.g
 *  org.a.h
 *  org.a.i
 *  org.a.j
 *  org.a.k
 *  org.a.l
 *  org.a.m
 *  org.a.n
 *  org.a.o
 *  org.a.p
 *  org.a.q
 *  org.a.r
 *  org.a.s
 *  org.a.t
 *  org.a.u
 *  org.a.v
 *  org.a.w
 *  org.a.x
 *  org.a.y
 *  org.a.z
 */
package org.a;

import com.xiaomi.miftp.c.c;
import java.io.File;
import org.a.aa;
import org.a.ae;
import org.a.aj;
import org.a.b;
import org.a.e;
import org.a.f;
import org.a.g;
import org.a.h;
import org.a.i;
import org.a.j;
import org.a.k;
import org.a.l;
import org.a.m;
import org.a.n;
import org.a.o;
import org.a.p;
import org.a.q;
import org.a.r;
import org.a.s;
import org.a.t;
import org.a.u;
import org.a.v;
import org.a.w;
import org.a.x;
import org.a.y;
import org.a.z;

abstract class ad
implements Runnable {
    private static final String b = "ad";
    aj a;

    ad(aj aj2) {
        this.a = aj2;
    }

    /*
     * Exception decompiling
     */
    static File a(File var0, String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl14.1 : NEW : trying to set 1 previously set to 0
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

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static void a(aj var0_1, String var1) {
        block10 : {
            block34 : {
                block33 : {
                    block32 : {
                        block31 : {
                            block30 : {
                                block29 : {
                                    block28 : {
                                        block27 : {
                                            block26 : {
                                                block25 : {
                                                    block24 : {
                                                        block23 : {
                                                            block22 : {
                                                                block21 : {
                                                                    block20 : {
                                                                        block19 : {
                                                                            block18 : {
                                                                                block17 : {
                                                                                    block16 : {
                                                                                        block15 : {
                                                                                            block14 : {
                                                                                                block13 : {
                                                                                                    block12 : {
                                                                                                        block11 : {
                                                                                                            block9 : {
                                                                                                                block8 : {
                                                                                                                    var2_2 = var1.split(" ");
                                                                                                                    if (var2_2.length <= 0) {
                                                                                                                        c.d(ad.b, "No strings parsed");
                                                                                                                        var0_1.b("502 Command not recognized\r\n");
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    var3_3 = var2_2[0];
                                                                                                                    if (var3_3.length() <= 0) {
                                                                                                                        c.d(ad.b, "Invalid command verb");
                                                                                                                        var0_1.b("502 Command not recognized\r\n");
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    var4_4 = var3_3.trim().toUpperCase();
                                                                                                                    if (!"SYST".equals((Object)var4_4)) break block8;
                                                                                                                    var5_5 = new y(var0_1);
                                                                                                                    ** GOTO lbl123
                                                                                                                }
                                                                                                                if (!"USER".equals((Object)var4_4)) break block9;
                                                                                                                var6_6 = new aa(var0_1, var1);
                                                                                                                break block10;
                                                                                                            }
                                                                                                            if (!"PASS".equals((Object)var4_4)) break block11;
                                                                                                            var6_6 = new n(var0_1, var1);
                                                                                                            break block10;
                                                                                                        }
                                                                                                        if (!"TYPE".equals((Object)var4_4)) break block12;
                                                                                                        var6_6 = new z(var0_1, var1);
                                                                                                        break block10;
                                                                                                    }
                                                                                                    if (!"CWD".equals((Object)var4_4)) break block13;
                                                                                                    var6_6 = new f(var0_1, var1);
                                                                                                    break block10;
                                                                                                }
                                                                                                if (!"PWD".equals((Object)var4_4)) break block14;
                                                                                                var5_5 = new q(var0_1);
                                                                                                ** GOTO lbl123
                                                                                            }
                                                                                            if (!"LIST".equals((Object)var4_4)) break block15;
                                                                                            var6_6 = new i(var0_1, var1);
                                                                                            break block10;
                                                                                        }
                                                                                        if (!"PASV".equals((Object)var4_4)) break block16;
                                                                                        var5_5 = new o(var0_1);
                                                                                        ** GOTO lbl123
                                                                                    }
                                                                                    if (!"RETR".equals((Object)var4_4)) break block17;
                                                                                    var6_6 = new s(var0_1, var1);
                                                                                    break block10;
                                                                                }
                                                                                if (!"NLST".equals((Object)var4_4)) break block18;
                                                                                var6_6 = new k(var0_1, var1);
                                                                                break block10;
                                                                            }
                                                                            if (!"NOOP".equals((Object)var4_4)) break block19;
                                                                            var5_5 = new l(var0_1);
                                                                            ** GOTO lbl123
                                                                        }
                                                                        if (!"STOR".equals((Object)var4_4)) break block20;
                                                                        var6_6 = new x(var0_1, var1);
                                                                        break block10;
                                                                    }
                                                                    if (!"DELE".equals((Object)var4_4)) break block21;
                                                                    var6_6 = new g(var0_1, var1);
                                                                    break block10;
                                                                }
                                                                if (!"RNFR".equals((Object)var4_4)) break block22;
                                                                var6_6 = new u(var0_1, var1);
                                                                break block10;
                                                            }
                                                            if (!"RNTO".equals((Object)var4_4)) break block23;
                                                            var6_6 = new v(var0_1, var1);
                                                            break block10;
                                                        }
                                                        if (!"RMD".equals((Object)var4_4)) break block24;
                                                        var6_6 = new t(var0_1, var1);
                                                        break block10;
                                                    }
                                                    if (!"MKD".equals((Object)var4_4)) break block25;
                                                    var6_6 = new j(var0_1, var1);
                                                    break block10;
                                                }
                                                if (!"OPTS".equals((Object)var4_4)) break block26;
                                                var6_6 = new m(var0_1, var1);
                                                break block10;
                                            }
                                            if (!"PORT".equals((Object)var4_4)) break block27;
                                            var6_6 = new p(var0_1, var1);
                                            break block10;
                                        }
                                        if (!"QUIT".equals((Object)var4_4)) break block28;
                                        var5_5 = new r(var0_1);
                                        ** GOTO lbl123
                                    }
                                    if (!"FEAT".equals((Object)var4_4)) break block29;
                                    var5_5 = new h(var0_1);
                                    ** GOTO lbl123
                                }
                                if (!"SIZE".equals((Object)var4_4)) break block30;
                                var6_6 = new w(var0_1, var1);
                                break block10;
                            }
                            if (!"CDUP".equals((Object)var4_4)) break block31;
                            var5_5 = new e(var0_1);
                            ** GOTO lbl123
                        }
                        if (!"APPE".equals((Object)var4_4)) break block32;
                        var6_6 = new b(var0_1, var1);
                        break block10;
                    }
                    if (!"XCUP".equals((Object)var4_4)) break block33;
                    var5_5 = new e(var0_1);
                    ** GOTO lbl123
                }
                if (!"XPWD".equals((Object)var4_4)) break block34;
                var5_5 = new q(var0_1);
                ** GOTO lbl123
            }
            if ("XMKD".equals((Object)var4_4)) {
                var6_6 = new j(var0_1, var1);
            } else if ("XRMD".equals((Object)var4_4)) {
                var6_6 = new t(var0_1, var1);
            } else {
                var5_5 = null;
lbl123: // 10 sources:
                var6_6 = var5_5;
            }
        }
        if (var6_6 == null) {
            var7_7 = ad.b;
            var8_8 = new StringBuilder("Ignoring unrecognized FTP verb: ");
            var8_8.append(var4_4);
            c.a(var7_7, var8_8.toString());
            var0_1.b("502 Command not recognized\r\n");
            return;
        }
        if (!(var0_1.e || var6_6.getClass().equals(aa.class) || var6_6.getClass().equals(n.class) || var6_6.getClass().equals(aa.class))) {
            var0_1.b("530 Login first with USER and PASS\r\n");
            return;
        }
        var6_6.run();
    }

    static String b(String string2, boolean bl) {
        if (string2 == null) {
            return "";
        }
        int n2 = string2.indexOf(32);
        if (n2 == -1) {
            return "";
        }
        String string3 = string2.substring(n2 + 1).replaceAll("\\s+$", "");
        if (!bl) {
            String string4 = b;
            StringBuilder stringBuilder = new StringBuilder("Parsed argument: ");
            stringBuilder.append(string3);
            c.a(string4, stringBuilder.toString());
        }
        return string3;
    }

    static boolean b(File file) {
        File file2 = ae.b();
        try {
            String string2 = file.getCanonicalPath();
            if (!string2.startsWith(file2.toString())) {
                c.d(b, "Path violated folder restriction, denying");
                String string3 = b;
                StringBuilder stringBuilder = new StringBuilder("path: ");
                stringBuilder.append(string2);
                c.a(string3, stringBuilder.toString());
                String string4 = b;
                StringBuilder stringBuilder2 = new StringBuilder("chroot: ");
                stringBuilder2.append((Object)file2);
                c.a(string4, stringBuilder2.toString());
                return true;
            }
            return false;
        }
        catch (Exception exception) {
            String string5 = b;
            StringBuilder stringBuilder = new StringBuilder("Path canonicalization problem: ");
            stringBuilder.append((Object)exception);
            c.d(string5, stringBuilder.toString());
            String string6 = b;
            StringBuilder stringBuilder3 = new StringBuilder("When checking file: ");
            stringBuilder3.append(file.getAbsolutePath());
            c.d(string6, stringBuilder3.toString());
            return true;
        }
    }

    public abstract void run();
}

