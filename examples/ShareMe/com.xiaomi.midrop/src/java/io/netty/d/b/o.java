/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Byte
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.Error
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NoClassDefFoundError
 *  java.lang.NoSuchFieldException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.AccessibleObject
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Field
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.security.AccessController
 *  java.security.PrivilegedAction
 *  sun.misc.Unsafe
 */
package io.netty.d.b;

import io.netty.d.b.a.d;
import io.netty.d.b.l;
import io.netty.d.b.r;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import sun.misc.Unsafe;

final class o {
    static final Unsafe a;
    static final /* synthetic */ boolean b = true;
    private static final d c;
    private static final long d;
    private static final long e;
    private static final Constructor<?> f;
    private static final boolean g;
    private static final Method h;
    private static final int i;
    private static final boolean j;
    private static final Throwable k;
    private static final Object l;
    private static final boolean m;
    private static final boolean n;

    /*
     * Exception decompiling
     */
    static {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl341 : LLOAD : trying to set 1 previously set to 0
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

    private o() {
    }

    static byte a(long l2) {
        return a.getByte(l2);
    }

    static byte a(byte[] arrby, int n2) {
        return a.getByte((Object)arrby, e + (long)n2);
    }

    static long a(Field field) {
        return a.objectFieldOffset(field);
    }

    static long a(ByteBuffer byteBuffer) {
        long l2 = d;
        return a.getLong((Object)byteBuffer, l2);
    }

    static ClassLoader a(final Class<?> class_) {
        if (System.getSecurityManager() == null) {
            return class_.getClassLoader();
        }
        return (ClassLoader)AccessController.doPrivileged((PrivilegedAction)new PrivilegedAction<ClassLoader>(){

            public final /* synthetic */ Object run() {
                return class_.getClassLoader();
            }
        });
    }

    static Object a(Object object, long l2) {
        return a.getObject(object, l2);
    }

    static ByteBuffer a(int n2) {
        return o.a(a.allocateMemory((long)n2), n2);
    }

    static ByteBuffer a(long l2, int n2) {
        if (n2 < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("capacity");
            stringBuilder.append(": ");
            stringBuilder.append(n2);
            stringBuilder.append(" (expected: >= 0)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        try {
            Constructor<?> constructor = f;
            Object[] arrobject = new Object[]{l2, n2};
            ByteBuffer byteBuffer = (ByteBuffer)constructor.newInstance(arrobject);
            return byteBuffer;
        }
        catch (Throwable throwable) {
            if (throwable instanceof Error) {
                throw (Error)throwable;
            }
            throw new Error(throwable);
        }
    }

    static ByteBuffer a(ByteBuffer byteBuffer, int n2) {
        return o.a(a.reallocateMemory(o.a(byteBuffer), (long)n2), n2);
    }

    static void a(long l2, byte by) {
        a.putByte(l2, by);
    }

    static void a(long l2, long l3) {
        a.putLong(l2, l3);
    }

    static void a(long l2, long l3, long l4) {
        while (l4 > 0L) {
            long l5 = Math.min((long)l4, (long)0x100000L);
            a.copyMemory(l2, l3, l5);
            long l6 = l4 - l5;
            long l7 = l2 + l5;
            l3 += l5;
            l2 = l7;
            l4 = l6;
        }
    }

    static void a(long l2, short s2) {
        a.putShort(l2, s2);
    }

    static void a(Object object, long l2, long l3) {
        a.setMemory(object, l2, l3, (byte)0);
    }

    static void a(Object object, long l2, Object object2, long l3, long l4) {
        long l5 = l2;
        long l6 = l3;
        long l7 = l4;
        while (l7 > 0L) {
            long l8 = Math.min((long)l7, (long)0x100000L);
            a.copyMemory(object, l5, object2, l6, l8);
            long l9 = l7 - l8;
            long l10 = l5 + l8;
            long l11 = l6 + l8;
            l5 = l10;
            l7 = l9;
            l6 = l11;
        }
    }

    static void a(Throwable throwable) {
        a.throwException(l.a(throwable, "cause"));
    }

    static void a(byte[] arrby, int n2, byte by) {
        a.putByte((Object)arrby, e + (long)n2, by);
    }

    static void a(byte[] arrby, int n2, int n3) {
        a.putInt((Object)arrby, e + (long)n2, n3);
    }

    static void a(byte[] arrby, int n2, long l2) {
        a.putLong((Object)arrby, e + (long)n2, l2);
    }

    static void a(byte[] arrby, int n2, short s2) {
        a.putShort((Object)arrby, e + (long)n2, s2);
    }

    static boolean a() {
        return g;
    }

    static short b(long l2) {
        return a.getShort(l2);
    }

    static short b(byte[] arrby, int n2) {
        return a.getShort((Object)arrby, e + (long)n2);
    }

    static void b(long l2, int n2) {
        a.putInt(l2, n2);
    }

    static void b(long l2, long l3) {
        a.setMemory(l2, l3, (byte)0);
    }

    static boolean b() {
        return n;
    }

    static byte[] b(int n2) {
        try {
            Method method = h;
            Object object = l;
            Object[] arrobject = new Object[]{Byte.TYPE, n2};
            byte[] arrby = (byte[])method.invoke(object, arrobject);
            return arrby;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new Error((Throwable)invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new Error((Throwable)illegalAccessException);
        }
    }

    static int c(long l2) {
        return a.getInt(l2);
    }

    static int c(byte[] arrby, int n2) {
        return a.getInt((Object)arrby, e + (long)n2);
    }

    static boolean c() {
        return a != null;
    }

    static long d(long l2) {
        return a.getLong(l2);
    }

    static long d(byte[] arrby, int n2) {
        return a.getLong((Object)arrby, e + (long)n2);
    }

    static boolean d() {
        return f != null;
    }

    static void e(long l2) {
        a.freeMemory(l2);
    }

    static boolean e() {
        return h != null;
    }

    static long f() {
        return a.arrayBaseOffset(byte[].class);
    }

    static ClassLoader g() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader)AccessController.doPrivileged((PrivilegedAction)new PrivilegedAction<ClassLoader>(){

            public final /* synthetic */ Object run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }

    static int h() {
        return a.addressSize();
    }

    static boolean i() {
        return j;
    }

    static boolean j() {
        return m;
    }

    static int k() {
        return i;
    }

    private static boolean l() {
        boolean bl;
        bl = false;
        try {
            Class.forName((String)"android.app.Application", (boolean)false, (ClassLoader)o.g());
            bl = true;
        }
        catch (Throwable throwable) {}
        if (bl) {
            c.b("Platform: Android");
        }
        return bl;
    }

}

