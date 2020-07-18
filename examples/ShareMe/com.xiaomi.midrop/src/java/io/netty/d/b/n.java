/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.b.b
 *  io.netty.d.b.b.a.a.a.a.j
 *  io.netty.d.b.b.a.a.a.a.t
 *  io.netty.d.b.b.a.a.a.a.u
 *  io.netty.d.b.b.a.a.a.l
 *  io.netty.d.b.b.a.a.a.t
 *  io.netty.d.b.b.a.a.a.v
 *  io.netty.d.b.c
 *  io.netty.d.b.h
 *  io.netty.d.b.n$1
 *  io.netty.d.b.n$2
 *  io.netty.d.b.n$3
 *  io.netty.d.b.n$a
 *  java.io.File
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.security.AccessController
 *  java.security.PrivilegedAction
 *  java.util.Locale
 *  java.util.Queue
 *  java.util.Random
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.ConcurrentMap
 *  java.util.concurrent.atomic.AtomicLong
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 *  sun.misc.Unsafe
 */
package io.netty.d.b;

import io.netty.d.b.a.d;
import io.netty.d.b.a.e;
import io.netty.d.b.b.a.a.a.a.j;
import io.netty.d.b.b.a.a.a.a.t;
import io.netty.d.b.b.a.a.a.a.u;
import io.netty.d.b.b.a.a.a.l;
import io.netty.d.b.b.a.a.a.v;
import io.netty.d.b.h;
import io.netty.d.b.i;
import io.netty.d.b.m;
import io.netty.d.b.n;
import io.netty.d.b.o;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Locale;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sun.misc.Unsafe;

/*
 * Exception performing whole class analysis.
 */
public final class n {
    public static final boolean a = false;
    static final /* synthetic */ boolean b = true;
    private static final d c;
    private static final Pattern d;
    private static final boolean e;
    private static final boolean f;
    private static final boolean g;
    private static final boolean h;
    private static final boolean i;
    private static final boolean j;
    private static final long k;
    private static final long l;
    private static final File m;
    private static final int n;
    private static final String o;
    private static final String p;
    private static final int q;
    private static final boolean r;
    private static final AtomicLong s;
    private static final long t;
    private static final c u;
    private static final io.netty.d.b.a v;
    private static final int w;
    private static final io.netty.d.b.a x;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static {
        block26 : {
            block24 : {
                block22 : {
                    block25 : {
                        block23 : {
                            block21 : {
                                block20 : {
                                    n.c = e.a(n.class);
                                    n.d = Pattern.compile((String)"\\s*-XX:MaxDirectMemorySize\\s*=\\s*([0-9]+)\\s*([kKmMgG]?)\\s*$");
                                    var0 = io.netty.d.b.u.a("os.name", "").toLowerCase(Locale.US).contains((CharSequence)"win");
                                    if (var0) {
                                        n.c.b("Platform: Windows");
                                    }
                                    n.e = var0;
                                    var1_1 = io.netty.d.b.u.a("os.name", "").toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
                                    var2_2 = var1_1.startsWith("macosx");
                                    var3_3 = 1;
                                    var4_4 = var2_2 || var1_1.startsWith("osx");
                                    if (var4_4) {
                                        n.c.b("Platform: MacOS");
                                    }
                                    n.f = var4_4;
                                    n.h = var3_3 ^ o.i();
                                    n.i = var5_5 = n.q();
                                    var6_6 = var5_5 != false && io.netty.d.b.u.a("io.netty.noPreferDirect", false) == false;
                                    n.j = var6_6;
                                    n.k = n.r();
                                    var7_7 = n.i == false ? -1L : o.f();
                                    n.l = var7_7;
                                    n.m = n.s();
                                    var9_8 = io.netty.d.b.u.a("io.netty.bitMode", 0);
                                    if (var9_8 <= 0) break block20;
                                    var27_9 = n.c;
                                    var28_10 = "-Dio.netty.bitMode: {}";
                                    ** GOTO lbl38
                                }
                                var9_8 = io.netty.d.b.u.a("sun.arch.data.model", 0);
                                if (var9_8 <= 0) break block21;
                                var27_9 = n.c;
                                var28_10 = "-Dio.netty.bitMode: {} (sun.arch.data.model)";
                                ** GOTO lbl38
                            }
                            var9_8 = io.netty.d.b.u.a("com.ibm.vm.bitmode", 0);
                            if (var9_8 > 0) {
                                var27_9 = n.c;
                                var28_10 = "-Dio.netty.bitMode: {} (com.ibm.vm.bitmode)";
lbl38: // 3 sources:
                                var27_9.b(var28_10, (Object)var9_8);
                            } else {
                                var10_11 = io.netty.d.b.u.a("os.arch", "").toLowerCase(Locale.US).trim();
                                if (!"amd64".equals((Object)var10_11) && !"x86_64".equals((Object)var10_11)) {
                                    if ("i386".equals((Object)var10_11) || "i486".equals((Object)var10_11) || "i586".equals((Object)var10_11) || "i686".equals((Object)var10_11)) {
                                        var9_8 = 32;
                                    }
                                } else {
                                    var9_8 = 64;
                                }
                                if (var9_8 > 0) {
                                    n.c.b("-Dio.netty.bitMode: {} (os.arch: {})", (Object)var9_8, (Object)var10_11);
                                }
                                var11_12 = io.netty.d.b.u.a("java.vm.name", "").toLowerCase(Locale.US);
                                var12_13 = Pattern.compile((String)"([1-9][0-9]+)-?bit").matcher((CharSequence)var11_12);
                                var9_8 = var12_13.find() != false ? Integer.parseInt((String)var12_13.group(var3_3)) : 64;
                            }
                            n.n = var9_8;
                            var13_14 = n.b(io.netty.d.b.u.a("os.arch", ""));
                            var14_15 = var13_14.matches("^(x8664|amd64|ia32e|em64t|x64)$") != false ? "x86_64" : (var13_14.matches("^(x8632|x86|i[3-6]86|ia32|x32)$") != false ? "x86_32" : (var13_14.matches("^(ia64|itanium64)$") != false ? "itanium_64" : (var13_14.matches("^(sparc|sparc32)$") != false ? "sparc_32" : (var13_14.matches("^(sparcv9|sparc64)$") != false ? "sparc_64" : (var13_14.matches("^(arm|arm32)$") != false ? "arm_32" : ("aarch64".equals((Object)var13_14) != false ? "aarch_64" : (var13_14.matches("^(ppc|ppc32)$") != false ? "ppc_32" : ("ppc64".equals((Object)var13_14) != false ? "ppc_64" : ("ppc64le".equals((Object)var13_14) != false ? "ppcle_64" : ("s390".equals((Object)var13_14) != false ? "s390_32" : ("s390x".equals((Object)var13_14) != false ? "s390_64" : "unknown")))))))))));
                            n.o = var14_15;
                            var15_16 = n.b(io.netty.d.b.u.a("os.name", ""));
                            var16_17 = var15_16.startsWith("aix") ? "aix" : (var15_16.startsWith("hpux") ? "hpux" : (var15_16.startsWith("os400") && (var15_16.length() <= 5 || !Character.isDigit((char)var15_16.charAt(5))) ? "os400" : (var15_16.startsWith("linux") ? "linux" : (!var15_16.startsWith("macosx") && !var15_16.startsWith("osx") ? (var15_16.startsWith("freebsd") ? "freebsd" : (var15_16.startsWith("openbsd") ? "openbsd" : (var15_16.startsWith("netbsd") ? "netbsd" : (!var15_16.startsWith("solaris") && !var15_16.startsWith("sunos") ? (var15_16.startsWith("windows") ? "windows" : "unknown") : "sunos")))) : "osx"))));
                            n.p = var16_17;
                            var17_18 = n.i == false ? -1 : o.h();
                            n.q = var17_18;
                            var18_19 = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
                            n.a = var18_19;
                            n.x = new 1();
                            var19_20 /* !! */  = o.k() >= 7 ? new 2() : new 3();
                            n.u = var19_20 /* !! */ ;
                            if (n.c.b()) {
                                n.c.b("-Dio.netty.noPreferDirect: {}", (Object)((boolean)(var3_3 ^ n.j)));
                            }
                            if (!(n.i || o.i() || o.a())) {
                                n.c.c("Your platform does not provide complete low-level API for accessing direct buffers reliably. Unless explicitly requested, heap buffer will always be preferred to avoid potential system instability.");
                            }
                            if ((var20_21 = io.netty.d.b.u.a("io.netty.maxDirectMemory", -1L)) == 0L || !n.i || !o.d()) break block22;
                            n.r = var3_3;
                            if (var20_21 >= 0L) break block23;
                            var20_21 = n.r();
                            if (var20_21 <= 0L) break block24;
                            var26_22 = new AtomicLong();
                            break block25;
                        }
                        var26_22 = new AtomicLong();
                    }
                    n.s = var26_22;
                    break block26;
                }
                n.r = false;
            }
            n.s = null;
        }
        n.t = var20_21;
        n.c.b("-Dio.netty.maxDirectMemory: {} bytes", (Object)var20_21);
        var22_23 = io.netty.d.b.u.a("io.netty.uninitializedArrayAllocationThreshold", 1024);
        if (o.k() < 9 || !o.e()) {
            var22_23 = -1;
        }
        n.w = var22_23;
        n.c.b("-Dio.netty.uninitializedArrayAllocationThreshold: {}", (Object)n.w);
        var23_24 = io.netty.d.b.u.b("user.name");
        if (n.e) {
            var3_3 = "Administrator".equals((Object)var23_24) ? 1 : 0;
        } else if (!"root".equals((Object)var23_24) && !"toor".equals((Object)var23_24)) {
            var3_3 = 0;
        }
        n.g = var3_3;
        if (!o.i() && n.i) {
            if (o.k() >= 9) {
                if (io.netty.d.b.c.a()) {
                    var25_25 = new io.netty.d.b.c();
                } else {
                    var25_26 = n.x;
                }
                n.v = var25_27;
                return;
            }
            if (io.netty.d.b.b.a()) {
                var24_28 = new io.netty.d.b.b();
            } else {
                var24_29 = n.x;
            }
            n.v = var24_30;
            return;
        }
        n.v = n.x;
    }

    private n() {
    }

    public static byte a(byte[] arrby, int n2) {
        return o.a(arrby, n2);
    }

    private static File a(String string2) {
        if (string2 == null) {
            return null;
        }
        File file = new File(string2);
        file.mkdirs();
        if (!file.isDirectory()) {
            return null;
        }
        try {
            File file2 = file.getAbsoluteFile();
            return file2;
        }
        catch (Exception exception) {
            return file;
        }
    }

    public static ByteBuffer a(long l2, int n2) {
        if (o.d()) {
            return o.a(l2, n2);
        }
        throw new UnsupportedOperationException("sun.misc.Unsafe or java.nio.DirectByteBuffer.<init>(long, int) not available");
    }

    public static ByteBuffer a(ByteBuffer byteBuffer, int n2) {
        if (!b && !r) {
            throw new AssertionError();
        }
        int n3 = n2 - byteBuffer.capacity();
        n.e(n3);
        try {
            ByteBuffer byteBuffer2 = o.a(byteBuffer, n2);
            return byteBuffer2;
        }
        catch (Throwable throwable) {
            n.f(n3);
            n.a(throwable);
            return null;
        }
    }

    public static void a(long l2) {
        o.e(l2);
    }

    public static void a(long l2, byte by) {
        o.a(l2, by);
    }

    public static void a(long l2, long l3) {
        o.a(l2, l3);
    }

    public static void a(long l2, long l3, long l4) {
        o.a(l2, l3, l4);
    }

    public static void a(long l2, short s2) {
        o.a(l2, s2);
    }

    public static void a(long l2, byte[] arrby, int n2, long l3) {
        o.a(null, l2, arrby, l + (long)n2, l3);
    }

    public static void a(Throwable throwable) {
        if (i) {
            o.a(throwable);
            return;
        }
        throw throwable;
    }

    public static void a(ByteBuffer byteBuffer) {
        v.a(byteBuffer);
    }

    public static void a(byte[] arrby, int n2, byte by) {
        o.a(arrby, n2, by);
    }

    public static void a(byte[] arrby, int n2, int n3) {
        o.a(arrby, n2, n3);
    }

    public static void a(byte[] arrby, int n2, long l2) {
        o.a(arrby, n2, l2);
    }

    public static void a(byte[] arrby, int n2, long l2, long l3) {
        o.a(arrby, l + (long)n2, null, l2, l3);
    }

    public static void a(byte[] arrby, int n2, short s2) {
        o.a(arrby, n2, s2);
    }

    public static boolean a() {
        return o.d();
    }

    public static byte[] a(int n2) {
        if (w >= 0 && w <= n2) {
            return o.b(n2);
        }
        return new byte[n2];
    }

    public static byte b(long l2) {
        return o.a(l2);
    }

    public static long b(ByteBuffer byteBuffer) {
        return o.a(byteBuffer);
    }

    private static String b(String string2) {
        return string2.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
    }

    public static ByteBuffer b(int n2) {
        if (!b && !r) {
            throw new AssertionError();
        }
        n.e(n2);
        try {
            ByteBuffer byteBuffer = o.a(n2);
            return byteBuffer;
        }
        catch (Throwable throwable) {
            n.f(n2);
            n.a(throwable);
            return null;
        }
    }

    public static short b(byte[] arrby, int n2) {
        return o.b(arrby, n2);
    }

    public static void b(long l2, int n2) {
        o.b(l2, n2);
    }

    public static void b(long l2, long l3) {
        o.b(l2, l3);
    }

    public static void b(byte[] arrby, int n2, long l2) {
        o.a((Object)arrby, l + (long)n2, l2);
    }

    public static boolean b() {
        return e;
    }

    public static int c(byte[] arrby, int n2) {
        return o.c(arrby, n2);
    }

    public static <T> Queue<T> c(int n2) {
        return b.a(n2);
    }

    public static short c(long l2) {
        return o.b(l2);
    }

    public static void c(ByteBuffer byteBuffer) {
        if (!b && !r) {
            throw new AssertionError();
        }
        int n2 = byteBuffer.capacity();
        o.e(o.a(byteBuffer));
        n.f(n2);
    }

    public static boolean c() {
        return g;
    }

    public static int d() {
        return o.k();
    }

    public static int d(long l2) {
        return o.c(l2);
    }

    public static long d(byte[] arrby, int n2) {
        return o.d(arrby, n2);
    }

    public static <T> Queue<T> d(int n2) {
        if (i) {
            return new l(n2);
        }
        return new j(n2);
    }

    public static long e(long l2) {
        return o.d(l2);
    }

    private static void e(int n2) {
        if (s != null) {
            long l2;
            long l3;
            do {
                if ((l3 = (l2 = s.get()) + (long)n2) <= t) continue;
                StringBuilder stringBuilder = new StringBuilder("failed to allocate ");
                stringBuilder.append(n2);
                stringBuilder.append(" byte(s) of direct memory (used: ");
                stringBuilder.append(l2);
                stringBuilder.append(", max: ");
                stringBuilder.append(t);
                stringBuilder.append(')');
                throw new m(stringBuilder.toString());
            } while (!s.compareAndSet(l2, l3));
        }
    }

    public static boolean e() {
        return h;
    }

    private static void f(int n2) {
        if (s != null) {
            long l2 = s.addAndGet((long)(-n2));
            if (!b && l2 < 0L) {
                throw new AssertionError();
            }
        }
    }

    public static boolean f() {
        return i;
    }

    public static boolean g() {
        return o.b();
    }

    public static boolean h() {
        return j;
    }

    public static long i() {
        return k;
    }

    public static <K, V> ConcurrentMap<K, V> j() {
        return new ConcurrentHashMap();
    }

    public static i k() {
        if (o.k() >= 8) {
            return new h();
        }
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static boolean l() {
        return r;
    }

    public static <T> Queue<T> m() {
        return b.a();
    }

    public static ClassLoader n() {
        return o.g();
    }

    public static Random o() {
        return u.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean q() {
        if (o.i()) {
            c.b("sun.misc.Unsafe: unavailable (Android)");
            return false;
        }
        if (o.a()) {
            return false;
        }
        try {
            boolean bl = o.c();
            d d2 = c;
            String string2 = bl ? "available" : "unavailable";
            d2.b("sun.misc.Unsafe: {}", (Object)string2);
            return bl;
        }
        catch (Throwable throwable) {
            c.a("Could not determine if Unsafe is available", throwable);
            return false;
        }
    }

    /*
     * Exception decompiling
     */
    private static long r() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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
     * Exception decompiling
     */
    private static File s() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl104.1 : GETSTATIC : trying to set 1 previously set to 0
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

    private static final class b {
        private static final boolean a;

        /*
         * Enabled aggressive block sorting
         */
        static {
            boolean bl;
            Object object = n.f() ? AccessController.doPrivileged((PrivilegedAction)new PrivilegedAction<Object>(){

                public final Object run() {
                    return io.netty.d.b.b.a.a.b.c.b;
                }
            }) : null;
            if (object == null) {
                c.b("org.jctools-core.MpscChunkedArrayQueue: unavailable");
                bl = false;
            } else {
                c.b("org.jctools-core.MpscChunkedArrayQueue: available");
                bl = true;
            }
            a = bl;
        }

        static <T> Queue<T> a() {
            if (a) {
                return new v();
            }
            return new u();
        }

        static <T> Queue<T> a(int n2) {
            int n3 = Math.max((int)Math.min((int)n2, (int)1073741824), (int)2048);
            if (a) {
                return new io.netty.d.b.b.a.a.a.t(n3);
            }
            return new t(n3);
        }

    }

    private static interface c {
        public Random a();
    }

}

