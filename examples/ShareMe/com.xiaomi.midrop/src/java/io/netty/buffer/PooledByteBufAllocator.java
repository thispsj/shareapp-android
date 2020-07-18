/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.AbstractByteBufAllocator
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.PoolArena
 *  io.netty.buffer.PooledByteBufAllocator$PoolThreadLocalCache
 *  io.netty.buffer.PooledByteBufAllocatorMetric
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicInteger
 */
package io.netty.buffer;

import io.netty.buffer.AbstractByteBufAllocator;
import io.netty.buffer.AbstractReferenceCountedByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufAllocatorMetric;
import io.netty.buffer.ByteBufAllocatorMetricProvider;
import io.netty.buffer.PoolArena;
import io.netty.buffer.PoolArenaMetric;
import io.netty.buffer.PoolThreadCache;
import io.netty.buffer.PooledByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocatorMetric;
import io.netty.buffer.UnpooledDirectByteBuf;
import io.netty.buffer.UnpooledHeapByteBuf;
import io.netty.buffer.UnpooledUnsafeHeapByteBuf;
import io.netty.buffer.UnsafeByteBufUtil;
import io.netty.d.b.a.d;
import io.netty.d.b.a.e;
import io.netty.d.b.n;
import io.netty.d.b.t;
import io.netty.d.b.u;
import io.netty.d.i;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Exception performing whole class analysis.
 */
public class PooledByteBufAllocator
extends AbstractByteBufAllocator
implements ByteBufAllocatorMetricProvider {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final PooledByteBufAllocator DEFAULT;
    private static final int DEFAULT_CACHE_TRIM_INTERVAL = 0;
    private static final int DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT = 0;
    private static final int DEFAULT_MAX_CACHED_BUFFER_CAPACITY = 0;
    private static final int DEFAULT_MAX_ORDER = 0;
    private static final int DEFAULT_NORMAL_CACHE_SIZE = 0;
    private static final int DEFAULT_NUM_DIRECT_ARENA = 0;
    private static final int DEFAULT_NUM_HEAP_ARENA = 0;
    private static final int DEFAULT_PAGE_SIZE = 0;
    private static final int DEFAULT_SMALL_CACHE_SIZE = 0;
    private static final int DEFAULT_TINY_CACHE_SIZE = 0;
    private static final boolean DEFAULT_USE_CACHE_FOR_ALL_THREADS = false;
    private static final int MAX_CHUNK_SIZE = 1073741824;
    private static final int MIN_PAGE_SIZE = 4096;
    private static final d logger;
    private final int chunkSize;
    private final List<PoolArenaMetric> directArenaMetrics;
    private final PoolArena<ByteBuffer>[] directArenas;
    private final List<PoolArenaMetric> heapArenaMetrics;
    private final PoolArena<byte[]>[] heapArenas;
    private final PooledByteBufAllocatorMetric metric;
    private final int normalCacheSize;
    private final int smallCacheSize;
    private final PoolThreadLocalCache threadCache;
    private final int tinyCacheSize;

    static {
        Throwable throwable;
        Throwable throwable2;
        logger = e.a(PooledByteBufAllocator.class);
        int n2 = u.a("io.netty.allocator.pageSize", 8192);
        try {
            PooledByteBufAllocator.validateAndCalculatePageShifts(n2);
            throwable2 = null;
        }
        catch (Throwable throwable3) {
            throwable2 = throwable3;
            n2 = 8192;
        }
        DEFAULT_PAGE_SIZE = n2;
        int n3 = u.a("io.netty.allocator.maxOrder", 11);
        try {
            PooledByteBufAllocator.validateAndCalculateChunkSize(DEFAULT_PAGE_SIZE, n3);
            throwable = null;
        }
        catch (Throwable throwable4) {
            throwable = throwable4;
            n3 = 11;
        }
        DEFAULT_MAX_ORDER = n3;
        Runtime runtime = Runtime.getRuntime();
        int n4 = 2 * i.a();
        int n5 = DEFAULT_PAGE_SIZE << DEFAULT_MAX_ORDER;
        long l2 = n4;
        long l3 = runtime.maxMemory();
        long l4 = n5;
        DEFAULT_NUM_HEAP_ARENA = Math.max((int)0, (int)u.a("io.netty.allocator.numHeapArenas", (int)Math.min((long)l2, (long)(l3 / l4 / 2L / 3L))));
        DEFAULT_NUM_DIRECT_ARENA = Math.max((int)0, (int)u.a("io.netty.allocator.numDirectArenas", (int)Math.min((long)l2, (long)(n.i() / l4 / 2L / 3L))));
        DEFAULT_TINY_CACHE_SIZE = u.a("io.netty.allocator.tinyCacheSize", 512);
        DEFAULT_SMALL_CACHE_SIZE = u.a("io.netty.allocator.smallCacheSize", 256);
        DEFAULT_NORMAL_CACHE_SIZE = u.a("io.netty.allocator.normalCacheSize", 64);
        DEFAULT_MAX_CACHED_BUFFER_CAPACITY = u.a("io.netty.allocator.maxCachedBufferCapacity", 32768);
        DEFAULT_CACHE_TRIM_INTERVAL = u.a("io.netty.allocator.cacheTrimInterval", 8192);
        DEFAULT_USE_CACHE_FOR_ALL_THREADS = u.a("io.netty.allocator.useCacheForAllThreads", true);
        DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT = u.a("io.netty.allocator.directMemoryCacheAlignment", 0);
        if (logger.b()) {
            logger.b("-Dio.netty.allocator.numHeapArenas: {}", (Object)DEFAULT_NUM_HEAP_ARENA);
            logger.b("-Dio.netty.allocator.numDirectArenas: {}", (Object)DEFAULT_NUM_DIRECT_ARENA);
            if (throwable2 == null) {
                logger.b("-Dio.netty.allocator.pageSize: {}", (Object)DEFAULT_PAGE_SIZE);
            } else {
                logger.b("-Dio.netty.allocator.pageSize: {}", (Object)DEFAULT_PAGE_SIZE, (Object)throwable2);
            }
            if (throwable == null) {
                logger.b("-Dio.netty.allocator.maxOrder: {}", (Object)DEFAULT_MAX_ORDER);
            } else {
                logger.b("-Dio.netty.allocator.maxOrder: {}", (Object)DEFAULT_MAX_ORDER, (Object)throwable);
            }
            logger.b("-Dio.netty.allocator.chunkSize: {}", (Object)(DEFAULT_PAGE_SIZE << DEFAULT_MAX_ORDER));
            logger.b("-Dio.netty.allocator.tinyCacheSize: {}", (Object)DEFAULT_TINY_CACHE_SIZE);
            logger.b("-Dio.netty.allocator.smallCacheSize: {}", (Object)DEFAULT_SMALL_CACHE_SIZE);
            logger.b("-Dio.netty.allocator.normalCacheSize: {}", (Object)DEFAULT_NORMAL_CACHE_SIZE);
            logger.b("-Dio.netty.allocator.maxCachedBufferCapacity: {}", (Object)DEFAULT_MAX_CACHED_BUFFER_CAPACITY);
            logger.b("-Dio.netty.allocator.cacheTrimInterval: {}", (Object)DEFAULT_CACHE_TRIM_INTERVAL);
            logger.b("-Dio.netty.allocator.useCacheForAllThreads: {}", (Object)DEFAULT_USE_CACHE_FOR_ALL_THREADS);
        }
        DEFAULT = new PooledByteBufAllocator(n.h());
    }

    public PooledByteBufAllocator() {
        this(false);
    }

    public PooledByteBufAllocator(int n2, int n3, int n4, int n5) {
        super(false, n2, n3, n4, n5);
    }

    public PooledByteBufAllocator(boolean bl) {
        super(bl, DEFAULT_NUM_HEAP_ARENA, DEFAULT_NUM_DIRECT_ARENA, DEFAULT_PAGE_SIZE, DEFAULT_MAX_ORDER);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean bl, int n2, int n3, int n4, int n5) {
        this(bl, n2, n3, n4, n5, DEFAULT_TINY_CACHE_SIZE, DEFAULT_SMALL_CACHE_SIZE, DEFAULT_NORMAL_CACHE_SIZE);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean bl, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        super(bl, n2, n3, n4, n5, n6, n7, n8, DEFAULT_USE_CACHE_FOR_ALL_THREADS, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean bl, int n2, int n3, int n4, int n5, int n6, int n7, int n8, long l2) {
        super(bl, n2, n3, n4, n5, n6, n7, n8);
    }

    public PooledByteBufAllocator(boolean bl, int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl2) {
        super(bl, n2, n3, n4, n5, n6, n7, n8, bl2, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    public PooledByteBufAllocator(boolean bl, int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl2, int n9) {
        List list;
        List list2;
        super(bl);
        this.threadCache = new /* Unavailable Anonymous Inner Class!! */;
        this.tinyCacheSize = n6;
        this.smallCacheSize = n7;
        this.normalCacheSize = n8;
        this.chunkSize = PooledByteBufAllocator.validateAndCalculateChunkSize(n4, n5);
        if (n2 < 0) {
            StringBuilder stringBuilder = new StringBuilder("nHeapArena: ");
            stringBuilder.append(n2);
            stringBuilder.append(" (expected: >= 0)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n3 < 0) {
            StringBuilder stringBuilder = new StringBuilder("nDirectArea: ");
            stringBuilder.append(n3);
            stringBuilder.append(" (expected: >= 0)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n9 < 0) {
            StringBuilder stringBuilder = new StringBuilder("directMemoryCacheAlignment: ");
            stringBuilder.append(n9);
            stringBuilder.append(" (expected: >= 0)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n9 > 0 && !PooledByteBufAllocator.isDirectMemoryCacheAlignmentSupported()) {
            throw new IllegalArgumentException("directMemoryCacheAlignment is not supported");
        }
        if ((n9 & -n9) != n9) {
            StringBuilder stringBuilder = new StringBuilder("directMemoryCacheAlignment: ");
            stringBuilder.append(n9);
            stringBuilder.append(" (expected: power of two)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int n10 = PooledByteBufAllocator.validateAndCalculatePageShifts(n4);
        int n11 = 0;
        if (n2 > 0) {
            this.heapArenas = PooledByteBufAllocator.newArenaArray(n2);
            ArrayList arrayList = new ArrayList(this.heapArenas.length);
            for (int i2 = 0; i2 < this.heapArenas.length; ++i2) {
                PoolArena.HeapArena heapArena;
                this.heapArenas[i2] = heapArena = new PoolArena.HeapArena((PooledByteBufAllocator)this, n4, n5, n10, this.chunkSize, n9);
                arrayList.add((Object)heapArena);
            }
            list = Collections.unmodifiableList((List)arrayList);
        } else {
            this.heapArenas = null;
            list = Collections.emptyList();
        }
        this.heapArenaMetrics = list;
        if (n3 > 0) {
            this.directArenas = PooledByteBufAllocator.newArenaArray(n3);
            ArrayList arrayList = new ArrayList(this.directArenas.length);
            while (n11 < this.directArenas.length) {
                PoolArena.DirectArena directArena;
                this.directArenas[n11] = directArena = new PoolArena.DirectArena((PooledByteBufAllocator)this, n4, n5, n10, this.chunkSize, n9);
                arrayList.add((Object)directArena);
                ++n11;
            }
            list2 = Collections.unmodifiableList((List)arrayList);
        } else {
            this.directArenas = null;
            list2 = Collections.emptyList();
        }
        this.directArenaMetrics = list2;
        this.metric = new PooledByteBufAllocatorMetric((PooledByteBufAllocator)this);
    }

    static /* synthetic */ PoolArena[] access$000(PooledByteBufAllocator pooledByteBufAllocator) {
        return pooledByteBufAllocator.heapArenas;
    }

    static /* synthetic */ PoolArena[] access$100(PooledByteBufAllocator pooledByteBufAllocator) {
        return pooledByteBufAllocator.directArenas;
    }

    static /* synthetic */ int access$200(PooledByteBufAllocator pooledByteBufAllocator) {
        return pooledByteBufAllocator.tinyCacheSize;
    }

    static /* synthetic */ int access$300(PooledByteBufAllocator pooledByteBufAllocator) {
        return pooledByteBufAllocator.smallCacheSize;
    }

    static /* synthetic */ int access$400(PooledByteBufAllocator pooledByteBufAllocator) {
        return pooledByteBufAllocator.normalCacheSize;
    }

    static /* synthetic */ int access$500() {
        return DEFAULT_MAX_CACHED_BUFFER_CAPACITY;
    }

    static /* synthetic */ int access$600() {
        return DEFAULT_CACHE_TRIM_INTERVAL;
    }

    public static int defaultMaxOrder() {
        return DEFAULT_MAX_ORDER;
    }

    public static int defaultNormalCacheSize() {
        return DEFAULT_NORMAL_CACHE_SIZE;
    }

    public static int defaultNumDirectArena() {
        return DEFAULT_NUM_DIRECT_ARENA;
    }

    public static int defaultNumHeapArena() {
        return DEFAULT_NUM_HEAP_ARENA;
    }

    public static int defaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public static boolean defaultPreferDirect() {
        return n.h();
    }

    public static int defaultSmallCacheSize() {
        return DEFAULT_SMALL_CACHE_SIZE;
    }

    public static int defaultTinyCacheSize() {
        return DEFAULT_TINY_CACHE_SIZE;
    }

    public static boolean defaultUseCacheForAllThreads() {
        return DEFAULT_USE_CACHE_FOR_ALL_THREADS;
    }

    public static boolean isDirectMemoryCacheAlignmentSupported() {
        return n.f();
    }

    private static <T> PoolArena<T>[] newArenaArray(int n2) {
        return new PoolArena[n2];
    }

    private static /* varargs */ long usedMemory(PoolArena<?> ... arrpoolArena) {
        if (arrpoolArena == null) {
            return -1L;
        }
        int n2 = arrpoolArena.length;
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            long l3 = l2 + arrpoolArena[i2].numActiveBytes();
            if (l3 < 0L) {
                return Long.MAX_VALUE;
            }
            l2 = l3;
        }
        return l2;
    }

    private static int validateAndCalculateChunkSize(int n2, int n3) {
        if (n3 > 14) {
            StringBuilder stringBuilder = new StringBuilder("maxOrder: ");
            stringBuilder.append(n3);
            stringBuilder.append(" (expected: 0-14)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int n4 = n2;
        for (int i2 = n3; i2 > 0; --i2) {
            if (n4 > 536870912) {
                Object[] arrobject = new Object[]{n2, n3, 1073741824};
                throw new IllegalArgumentException(String.format((String)"pageSize (%d) << maxOrder (%d) must not exceed %d", (Object[])arrobject));
            }
            n4 <<= 1;
        }
        return n4;
    }

    private static int validateAndCalculatePageShifts(int n2) {
        if (n2 < 4096) {
            StringBuilder stringBuilder = new StringBuilder("pageSize: ");
            stringBuilder.append(n2);
            stringBuilder.append(" (expected: 4096)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if ((n2 & n2 - 1) != 0) {
            StringBuilder stringBuilder = new StringBuilder("pageSize: ");
            stringBuilder.append(n2);
            stringBuilder.append(" (expected: power of 2)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return 31 - Integer.numberOfLeadingZeros((int)n2);
    }

    @Deprecated
    public final int chunkSize() {
        return this.chunkSize;
    }

    @Deprecated
    public List<PoolArenaMetric> directArenas() {
        return this.directArenaMetrics;
    }

    public String dumpStats() {
        PoolArena<byte[]>[] arrpoolArena = this.heapArenas;
        int n2 = 0;
        int n3 = arrpoolArena == null ? 0 : this.heapArenas.length;
        StringBuilder stringBuilder = new StringBuilder(512);
        stringBuilder.append(n3);
        stringBuilder.append(" heap arena(s):");
        stringBuilder.append(t.a);
        if (n3 > 0) {
            PoolArena<byte[]>[] arrpoolArena2 = this.heapArenas;
            int n4 = arrpoolArena2.length;
            for (int i2 = 0; i2 < n4; ++i2) {
                stringBuilder.append(arrpoolArena2[i2]);
            }
        }
        int n5 = this.directArenas == null ? 0 : this.directArenas.length;
        stringBuilder.append(n5);
        stringBuilder.append(" direct arena(s):");
        stringBuilder.append(t.a);
        if (n5 > 0) {
            PoolArena<ByteBuffer>[] arrpoolArena3 = this.directArenas;
            int n6 = arrpoolArena3.length;
            while (n2 < n6) {
                stringBuilder.append(arrpoolArena3[n2]);
                ++n2;
            }
        }
        return stringBuilder.toString();
    }

    @Deprecated
    public void freeThreadLocalCache() {
        this.threadCache.remove();
    }

    @Deprecated
    public boolean hasThreadLocalCache() {
        return this.threadCache.isSet();
    }

    @Deprecated
    public List<PoolArenaMetric> heapArenas() {
        return this.heapArenaMetrics;
    }

    public boolean isDirectBufferPooled() {
        return this.directArenas != null;
    }

    public PooledByteBufAllocatorMetric metric() {
        return this.metric;
    }

    protected ByteBuf newDirectBuffer(int n2, int n3) {
        PoolThreadCache poolThreadCache = (PoolThreadCache)this.threadCache.get();
        PoolArena<ByteBuffer> poolArena = poolThreadCache.directArena;
        AbstractReferenceCountedByteBuf abstractReferenceCountedByteBuf = poolArena != null ? poolArena.allocate(poolThreadCache, n2, n3) : (n.f() ? UnsafeByteBufUtil.newUnsafeDirectByteBuf((ByteBufAllocator)this, n2, n3) : new UnpooledDirectByteBuf((ByteBufAllocator)this, n2, n3));
        return PooledByteBufAllocator.toLeakAwareBuffer((ByteBuf)abstractReferenceCountedByteBuf);
    }

    protected ByteBuf newHeapBuffer(int n2, int n3) {
        PoolThreadCache poolThreadCache = (PoolThreadCache)this.threadCache.get();
        PoolArena<byte[]> poolArena = poolThreadCache.heapArena;
        AbstractReferenceCountedByteBuf abstractReferenceCountedByteBuf = poolArena != null ? poolArena.allocate(poolThreadCache, n2, n3) : (n.f() ? new UnpooledUnsafeHeapByteBuf((ByteBufAllocator)this, n2, n3) : new UnpooledHeapByteBuf((ByteBufAllocator)this, n2, n3));
        return PooledByteBufAllocator.toLeakAwareBuffer((ByteBuf)abstractReferenceCountedByteBuf);
    }

    @Deprecated
    public int normalCacheSize() {
        return this.normalCacheSize;
    }

    @Deprecated
    public int numDirectArenas() {
        return this.directArenaMetrics.size();
    }

    @Deprecated
    public int numHeapArenas() {
        return this.heapArenaMetrics.size();
    }

    @Deprecated
    public int numThreadLocalCaches() {
        Object[] arrobject = this.heapArenas != null ? this.heapArenas : this.directArenas;
        if (arrobject == null) {
            return 0;
        }
        int n2 = arrobject.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 += arrobject[i2].numThreadCaches.get();
        }
        return n3;
    }

    @Deprecated
    public int smallCacheSize() {
        return this.smallCacheSize;
    }

    final PoolThreadCache threadCache() {
        return (PoolThreadCache)this.threadCache.get();
    }

    @Deprecated
    public int tinyCacheSize() {
        return this.tinyCacheSize;
    }

    final long usedDirectMemory() {
        return PooledByteBufAllocator.usedMemory(this.directArenas);
    }

    final long usedHeapMemory() {
        return PooledByteBufAllocator.usedMemory(this.heapArenas);
    }
}

