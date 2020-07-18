/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.j$1
 *  io.netty.d.j$2
 *  io.netty.d.j$3
 *  io.netty.d.j$a
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.util.Arrays
 *  java.util.Map
 *  java.util.concurrent.atomic.AtomicInteger
 */
package io.netty.d;

import io.netty.d.a.m;
import io.netty.d.b.a.e;
import io.netty.d.b.u;
import io.netty.d.i;
import io.netty.d.j;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Exception performing whole class analysis.
 */
public abstract class j<T> {
    private static final int DEFAULT_INITIAL_MAX_CAPACITY = 32768;
    private static final int DEFAULT_MAX_CAPACITY;
    private static final m<Map<c<?>, d>> DELAYED_RECYCLED;
    private static final AtomicInteger ID_GENERATOR;
    private static final int INITIAL_CAPACITY;
    private static final int LINK_CAPACITY;
    private static final int MAX_DELAYED_QUEUES_PER_THREAD;
    private static final int MAX_SHARED_CAPACITY_FACTOR;
    private static final b NOOP_HANDLE;
    private static final int OWN_THREAD_ID;
    private static final int RATIO;
    private static final io.netty.d.b.a.d logger;
    private final int maxCapacity;
    private final int maxDelayedQueuesPerThread;
    private final int maxSharedCapacityFactor;
    private final int ratioMask;
    private final m<c<T>> threadLocal;

    static {
        AtomicInteger atomicInteger;
        logger = e.a(j.class);
        NOOP_HANDLE = new 1();
        ID_GENERATOR = atomicInteger = new AtomicInteger(Integer.MIN_VALUE);
        OWN_THREAD_ID = atomicInteger.getAndIncrement();
        int n2 = u.a("io.netty.recycler.maxCapacity.default", 32768);
        if (n2 < 0) {
            n2 = 32768;
        }
        DEFAULT_MAX_CAPACITY = n2;
        MAX_SHARED_CAPACITY_FACTOR = Math.max((int)2, (int)u.a("io.netty.recycler.maxSharedCapacityFactor", 2));
        MAX_DELAYED_QUEUES_PER_THREAD = Math.max((int)0, (int)u.a("io.netty.recycler.maxDelayedQueuesPerThread", 2 * i.a()));
        LINK_CAPACITY = io.netty.d.b.j.a(Math.max((int)u.a("io.netty.recycler.linkCapacity", 16), (int)16));
        RATIO = io.netty.d.b.j.a(u.a("io.netty.recycler.ratio", 8));
        if (logger.b()) {
            if (DEFAULT_MAX_CAPACITY == 0) {
                logger.b("-Dio.netty.recycler.maxCapacity.default: disabled");
                logger.b("-Dio.netty.recycler.maxSharedCapacityFactor: disabled");
                logger.b("-Dio.netty.recycler.linkCapacity: disabled");
                logger.b("-Dio.netty.recycler.ratio: disabled");
            } else {
                logger.b("-Dio.netty.recycler.maxCapacity.default: {}", (Object)DEFAULT_MAX_CAPACITY);
                logger.b("-Dio.netty.recycler.maxSharedCapacityFactor: {}", (Object)MAX_SHARED_CAPACITY_FACTOR);
                logger.b("-Dio.netty.recycler.linkCapacity: {}", (Object)LINK_CAPACITY);
                logger.b("-Dio.netty.recycler.ratio: {}", (Object)RATIO);
            }
        }
        INITIAL_CAPACITY = Math.min((int)DEFAULT_MAX_CAPACITY, (int)256);
        DELAYED_RECYCLED = new 3();
    }

    protected j() {
        this(DEFAULT_MAX_CAPACITY);
    }

    protected j(int n2) {
        super(n2, MAX_SHARED_CAPACITY_FACTOR);
    }

    protected j(int n2, int n3) {
        super(n2, n3, RATIO, MAX_DELAYED_QUEUES_PER_THREAD);
    }

    protected j(int n2, int n3, int n4, int n5) {
        this.threadLocal = new 2((j)this);
        this.ratioMask = io.netty.d.b.j.a(n4) - 1;
        if (n2 <= 0) {
            this.maxCapacity = 0;
            this.maxSharedCapacityFactor = 1;
            this.maxDelayedQueuesPerThread = 0;
            return;
        }
        this.maxCapacity = n2;
        this.maxSharedCapacityFactor = Math.max((int)1, (int)n3);
        this.maxDelayedQueuesPerThread = Math.max((int)0, (int)n5);
    }

    static /* synthetic */ int access$000(j j2) {
        return j2.maxCapacity;
    }

    static /* synthetic */ int access$100(j j2) {
        return j2.maxSharedCapacityFactor;
    }

    static /* synthetic */ int access$200(j j2) {
        return j2.ratioMask;
    }

    static /* synthetic */ int access$300(j j2) {
        return j2.maxDelayedQueuesPerThread;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final T get() {
        block15 : {
            block12 : {
                block16 : {
                    block13 : {
                        block14 : {
                            if (this.maxCapacity == 0) {
                                return this.newObject(j.NOOP_HANDLE);
                            }
                            var1_1 = this.threadLocal.get();
                            var2_2 = var1_1.g;
                            if (var2_2 != 0) ** GOTO lbl51
                            var6_3 = var1_1.h;
                            var7_4 = true;
                            if (var6_3 != null) break block13;
                            var6_3 = var1_1.j;
                            if (var6_3 != null) break block14;
                            var9_5 = false;
                            break block15;
                        }
                        var8_6 = null;
                        break block16;
                    }
                    var8_6 = var1_1.i;
                }
                var9_5 = false;
                do {
                    if (var6_3.a(var1_1)) {
                        var9_5 = true;
                        break block12;
                    }
                    var10_8 = d.a(var6_3);
                    if (d.b(var6_3).get() == null) {
                        var11_7 = d.a.b(var6_3.b) != var6_3.b.get();
                        if (var11_7) {
                            while (var6_3.a(var1_1)) {
                                var9_5 = true;
                            }
                        }
                        if (var8_6 != null) {
                            d.a(var8_6, var10_8);
                        }
                    } else {
                        var8_6 = var6_3;
                    }
                    if (var10_8 == null || var9_5) break;
                    var6_3 = var10_8;
                } while (true);
                var6_3 = var10_8;
            }
            var1_1.i = var8_6;
            var1_1.h = var6_3;
        }
        if (!var9_5) {
            var1_1.i = null;
            var1_1.h = var1_1.j;
            var7_4 = false;
        }
        if (!var7_4) {
            var5_9 = null;
        } else {
            var2_2 = var1_1.g;
lbl51: // 2 sources:
            var3_10 = var2_2 - 1;
            var4_11 = var1_1.f[var3_10];
            var1_1.f[var3_10] = null;
            if (var4_11.a != var4_11.b) {
                throw new IllegalStateException("recycled multiple times");
            }
            var4_11.b = 0;
            var4_11.a = 0;
            var1_1.g = var3_10;
            var5_9 = var4_11;
        }
        if (var5_9 != null) return (T)var5_9.e;
        var5_9 = new /* Unavailable Anonymous Inner Class!! */;
        var5_9.e = this.newObject((b)var5_9);
        return (T)var5_9.e;
    }

    public abstract T newObject(b var1);

    public final boolean recycle(T t2, b b2) {
        block13 : {
            int n2;
            a a2;
            d.a a3;
            block16 : {
                d d2;
                block15 : {
                    block14 : {
                        c c2;
                        Thread thread;
                        block12 : {
                            int n3;
                            if (b2 == NOOP_HANDLE) {
                                return false;
                            }
                            a2 = b2;
                            if (a2.d.a != this) {
                                return false;
                            }
                            if (t2 != a2.e) {
                                throw new IllegalArgumentException("o does not belong to handle");
                            }
                            c2 = a2.d;
                            thread = Thread.currentThread();
                            if (c2.b.get() != thread) break block12;
                            if ((a2.b | a2.a) != 0) {
                                throw new IllegalStateException("recycled already");
                            }
                            a2.a = n3 = j.OWN_THREAD_ID;
                            a2.b = n3;
                            int n4 = c2.g;
                            if (n4 < c2.e) {
                                if (c2.a(a2)) {
                                    return true;
                                }
                                if (n4 == c2.f.length) {
                                    c2.f = (a[])Arrays.copyOf((Object[])c2.f, (int)Math.min((int)(n4 << 1), (int)c2.e));
                                }
                                c2.f[n4] = a2;
                                c2.g = n4 + 1;
                                return true;
                            }
                            break block13;
                        }
                        Map map = (Map)j.DELAYED_RECYCLED.get();
                        d2 = (d)map.get((Object)c2);
                        if (d2 != null) break block14;
                        if (map.size() >= c2.d) {
                            map.put((Object)c2, (Object)d.a);
                            return true;
                        }
                        d2 = d.a(c2, thread);
                        if (d2 == null) break block13;
                        map.put((Object)c2, (Object)d2);
                        break block15;
                    }
                    if (d2 == d.a) break block13;
                }
                a2.a = d2.c;
                a3 = d2.b;
                n2 = a3.get();
                if (n2 != j.LINK_CAPACITY) break block16;
                if (!d.a(d2.d, j.LINK_CAPACITY)) break block13;
                d2.b = a3 = (a3.c = new d.a(0));
                n2 = a3.get();
            }
            d.a.a((d.a)a3)[n2] = a2;
            a2.d = null;
            a3.lazySet(n2 + 1);
        }
        return true;
    }

    final int threadLocalCapacity() {
        return this.threadLocal.get().f.length;
    }

    final int threadLocalSize() {
        return this.threadLocal.get().g;
    }

    public static interface b {
    }

    static final class c<T> {
        final j<T> a;
        final WeakReference<Thread> b;
        final AtomicInteger c;
        final int d;
        final int e;
        a[] f;
        int g;
        d h;
        d i;
        volatile d j;
        private final int k;
        private int l = -1;

        c(j<T> j2, Thread thread, int n2, int n3, int n4, int n5) {
            this.a = j2;
            this.b = new WeakReference((Object)thread);
            this.e = n2;
            this.c = new AtomicInteger(Math.max((int)(n2 / n3), (int)LINK_CAPACITY));
            this.f = new a[Math.min((int)INITIAL_CAPACITY, (int)n2)];
            this.k = n4;
            this.d = n5;
        }

        final void a(d d2) {
            void var3_2 = this;
            synchronized (var3_2) {
                d.a(d2, this.j);
                this.j = d2;
                return;
            }
        }

        final boolean a(a a2) {
            if (!a2.c) {
                int n2;
                this.l = n2 = 1 + this.l;
                if ((n2 & this.k) != 0) {
                    return true;
                }
                a2.c = true;
            }
            return false;
        }
    }

    private static final class d {
        static final d a = new d();
        static final /* synthetic */ boolean e = true;
        a b;
        final int c;
        final AtomicInteger d;
        private a f;
        private d g;
        private final WeakReference<Thread> h;

        private d() {
            this.c = ID_GENERATOR.getAndIncrement();
            this.h = null;
            this.d = null;
        }

        private d(c<?> c2, Thread thread) {
            a a2;
            this.c = ID_GENERATOR.getAndIncrement();
            this.b = a2 = new a(0);
            this.f = a2;
            this.h = new WeakReference((Object)thread);
            this.d = c2.c;
        }

        static d a(c<?> c2, Thread thread) {
            if (d.a(c2.c, LINK_CAPACITY)) {
                d d2 = new d(c2, thread);
                c2.a(d2);
                return d2;
            }
            return null;
        }

        static /* synthetic */ d a(d d2) {
            return d2.g;
        }

        private void a(int n2) {
            if (!e && n2 < 0) {
                throw new AssertionError();
            }
            this.d.addAndGet(n2);
        }

        static /* synthetic */ void a(d d2, d d3) {
            if (!e && d3 == d2) {
                throw new AssertionError();
            }
            d2.g = d3;
        }

        static boolean a(AtomicInteger atomicInteger, int n2) {
            int n3;
            if (!e && n2 < 0) {
                throw new AssertionError();
            }
            do {
                if ((n3 = atomicInteger.get()) >= n2) continue;
                return false;
            } while (!atomicInteger.compareAndSet(n3, n3 - n2));
            return true;
        }

        static /* synthetic */ WeakReference b(d d2) {
            return d2.h;
        }

        final boolean a(c<?> c2) {
            a a2 = this.f;
            if (a2 == null) {
                return false;
            }
            if (a2.b == LINK_CAPACITY) {
                if (a2.c == null) {
                    return false;
                }
                this.f = a2 = a2.c;
            }
            int n2 = a2.b;
            int n3 = a2.get();
            int n4 = n3 - n2;
            if (n4 == 0) {
                return false;
            }
            int n5 = c2.g;
            int n6 = n4 + n5;
            if (n6 > c2.f.length) {
                int n7 = c2.f.length;
                int n8 = c2.e;
                while ((n7 <<= 1) < n6 && n7 < n8) {
                }
                int n9 = Math.min((int)n7, (int)n8);
                if (n9 != c2.f.length) {
                    c2.f = (io.netty.d.j$a[])Arrays.copyOf((Object[])c2.f, (int)n9);
                }
                n3 = Math.min((int)(n9 + n2 - n5), (int)n3);
            }
            if (n2 != n3) {
                io.netty.d.j$a[] arra = a2.a;
                io.netty.d.j$a[] arra2 = c2.f;
                while (n2 < n3) {
                    io.netty.d.j$a a3 = arra[n2];
                    if (a3.b == 0) {
                        a3.b = a3.a;
                    } else if (a3.b != a3.a) {
                        throw new IllegalStateException("recycled already");
                    }
                    arra[n2] = null;
                    if (!c2.a(a3)) {
                        a3.d = c2;
                        int n10 = n5 + 1;
                        arra2[n5] = a3;
                        n5 = n10;
                    }
                    ++n2;
                }
                if (n3 == LINK_CAPACITY && a2.c != null) {
                    d.super.a(LINK_CAPACITY);
                    this.f = a2.c;
                }
                a2.b = n3;
                if (c2.g == n5) {
                    return false;
                }
                c2.g = n5;
                return true;
            }
            return false;
        }

        protected final void finalize() throws Throwable {
            try {
                super.finalize();
                return;
            }
            finally {
                a a2 = this.f;
                while (a2 != null) {
                    this.a(LINK_CAPACITY);
                    a2 = a2.c;
                }
            }
        }

        private static final class a
        extends AtomicInteger {
            private final io.netty.d.j$a[] a;
            private int b;
            private a c;

            private a() {
                this.a = new io.netty.d.j$a[LINK_CAPACITY];
            }

            /* synthetic */ a(byte by) {
            }
        }

    }

}

