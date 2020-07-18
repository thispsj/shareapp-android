/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.PoolArena
 *  io.netty.buffer.PoolChunk
 *  io.netty.buffer.PoolThreadCache$MemoryRegionCache$1
 *  io.netty.buffer.PoolThreadCache$NormalMemoryRegionCache
 *  io.netty.buffer.PoolThreadCache$SubPageMemoryRegionCache
 *  io.netty.buffer.PooledByteBuf
 *  java.lang.Error
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.nio.ByteBuffer
 *  java.util.Queue
 *  java.util.concurrent.atomic.AtomicInteger
 */
package io.netty.buffer;

import io.netty.buffer.PoolArena;
import io.netty.buffer.PoolChunk;
import io.netty.buffer.PoolThreadCache;
import io.netty.buffer.PooledByteBuf;
import io.netty.d.b.a.d;
import io.netty.d.b.a.e;
import io.netty.d.b.j;
import io.netty.d.b.n;
import io.netty.d.j;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Exception performing whole class analysis.
 */
final class PoolThreadCache {
    private static final d logger;
    private int allocations;
    final PoolArena<ByteBuffer> directArena;
    private final int freeSweepAllocationThreshold;
    final PoolArena<byte[]> heapArena;
    private final MemoryRegionCache<ByteBuffer>[] normalDirectCaches;
    private final MemoryRegionCache<byte[]>[] normalHeapCaches;
    private final int numShiftsNormalDirect;
    private final int numShiftsNormalHeap;
    private final MemoryRegionCache<ByteBuffer>[] smallSubPageDirectCaches;
    private final MemoryRegionCache<byte[]>[] smallSubPageHeapCaches;
    private final MemoryRegionCache<ByteBuffer>[] tinySubPageDirectCaches;
    private final MemoryRegionCache<byte[]>[] tinySubPageHeapCaches;

    static {
        logger = e.a(PoolThreadCache.class);
    }

    PoolThreadCache(PoolArena<byte[]> poolArena, PoolArena<ByteBuffer> poolArena2, int n2, int n3, int n4, int n5, int n6) {
        if (n5 < 0) {
            StringBuilder stringBuilder = new StringBuilder("maxCachedBufferCapacity: ");
            stringBuilder.append(n5);
            stringBuilder.append(" (expected: >= 0)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.freeSweepAllocationThreshold = n6;
        this.heapArena = poolArena;
        this.directArena = poolArena2;
        if (poolArena2 != null) {
            this.tinySubPageDirectCaches = PoolThreadCache.createSubPageCaches(n2, 32, PoolArena.SizeClass.Tiny);
            this.smallSubPageDirectCaches = PoolThreadCache.createSubPageCaches(n3, poolArena2.numSmallSubpagePools, PoolArena.SizeClass.Small);
            this.numShiftsNormalDirect = PoolThreadCache.log2(poolArena2.pageSize);
            this.normalDirectCaches = PoolThreadCache.createNormalCaches(n4, n5, poolArena2);
            poolArena2.numThreadCaches.getAndIncrement();
        } else {
            this.tinySubPageDirectCaches = null;
            this.smallSubPageDirectCaches = null;
            this.normalDirectCaches = null;
            this.numShiftsNormalDirect = -1;
        }
        if (poolArena != null) {
            this.tinySubPageHeapCaches = PoolThreadCache.createSubPageCaches(n2, 32, PoolArena.SizeClass.Tiny);
            this.smallSubPageHeapCaches = PoolThreadCache.createSubPageCaches(n3, poolArena.numSmallSubpagePools, PoolArena.SizeClass.Small);
            this.numShiftsNormalHeap = PoolThreadCache.log2(poolArena.pageSize);
            this.normalHeapCaches = PoolThreadCache.createNormalCaches(n4, n5, poolArena);
            poolArena.numThreadCaches.getAndIncrement();
        } else {
            this.tinySubPageHeapCaches = null;
            this.smallSubPageHeapCaches = null;
            this.normalHeapCaches = null;
            this.numShiftsNormalHeap = -1;
        }
        if ((this.tinySubPageDirectCaches != null || this.smallSubPageDirectCaches != null || this.normalDirectCaches != null || this.tinySubPageHeapCaches != null || this.smallSubPageHeapCaches != null || this.normalHeapCaches != null) && n6 <= 0) {
            StringBuilder stringBuilder = new StringBuilder("freeSweepAllocationThreshold: ");
            stringBuilder.append(n6);
            stringBuilder.append(" (expected: > 0)");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private boolean allocate(MemoryRegionCache<?> memoryRegionCache, PooledByteBuf pooledByteBuf, int n2) {
        int n3;
        if (memoryRegionCache == null) {
            return false;
        }
        boolean bl = memoryRegionCache.allocate(pooledByteBuf, n2);
        this.allocations = n3 = 1 + this.allocations;
        if (n3 >= this.freeSweepAllocationThreshold) {
            this.allocations = 0;
            this.trim();
        }
        return bl;
    }

    private MemoryRegionCache<?> cache(PoolArena<?> poolArena, int n2, PoolArena.SizeClass sizeClass) {
        switch (1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[sizeClass.ordinal()]) {
            default: {
                throw new Error();
            }
            case 3: {
                return PoolThreadCache.super.cacheForTiny(poolArena, n2);
            }
            case 2: {
                return PoolThreadCache.super.cacheForSmall(poolArena, n2);
            }
            case 1: 
        }
        return PoolThreadCache.super.cacheForNormal(poolArena, n2);
    }

    private static <T> MemoryRegionCache<T> cache(MemoryRegionCache<T>[] arrmemoryRegionCache, int n2) {
        if (arrmemoryRegionCache != null && n2 <= -1 + arrmemoryRegionCache.length) {
            return arrmemoryRegionCache[n2];
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private MemoryRegionCache<?> cacheForNormal(PoolArena<?> poolArena, int n2) {
        MemoryRegionCache<ByteBuffer>[] arrmemoryRegionCache;
        int n3;
        if (poolArena.isDirect()) {
            n3 = PoolThreadCache.log2(n2 >> this.numShiftsNormalDirect);
            arrmemoryRegionCache = this.normalDirectCaches;
            do {
                return PoolThreadCache.cache(arrmemoryRegionCache, n3);
                break;
            } while (true);
        }
        n3 = PoolThreadCache.log2(n2 >> this.numShiftsNormalHeap);
        arrmemoryRegionCache = this.normalHeapCaches;
        return PoolThreadCache.cache(arrmemoryRegionCache, n3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private MemoryRegionCache<?> cacheForSmall(PoolArena<?> poolArena, int n2) {
        MemoryRegionCache<ByteBuffer>[] arrmemoryRegionCache;
        int n3 = PoolArena.smallIdx((int)n2);
        if (poolArena.isDirect()) {
            arrmemoryRegionCache = this.smallSubPageDirectCaches;
            do {
                return PoolThreadCache.cache(arrmemoryRegionCache, n3);
                break;
            } while (true);
        }
        arrmemoryRegionCache = this.smallSubPageHeapCaches;
        return PoolThreadCache.cache(arrmemoryRegionCache, n3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private MemoryRegionCache<?> cacheForTiny(PoolArena<?> poolArena, int n2) {
        MemoryRegionCache<ByteBuffer>[] arrmemoryRegionCache;
        int n3 = PoolArena.tinyIdx((int)n2);
        if (poolArena.isDirect()) {
            arrmemoryRegionCache = this.tinySubPageDirectCaches;
            do {
                return PoolThreadCache.cache(arrmemoryRegionCache, n3);
                break;
            } while (true);
        }
        arrmemoryRegionCache = this.tinySubPageHeapCaches;
        return PoolThreadCache.cache(arrmemoryRegionCache, n3);
    }

    private static <T> MemoryRegionCache<T>[] createNormalCaches(int n2, int n3, PoolArena<T> poolArena) {
        if (n2 > 0 && n3 > 0) {
            int n4 = Math.max((int)1, (int)(1 + PoolThreadCache.log2(Math.min((int)poolArena.chunkSize, (int)n3) / poolArena.pageSize)));
            MemoryRegionCache[] arrmemoryRegionCache = new MemoryRegionCache[n4];
            for (int i2 = 0; i2 < n4; ++i2) {
                arrmemoryRegionCache[i2] = new /* Unavailable Anonymous Inner Class!! */;
            }
            return arrmemoryRegionCache;
        }
        return null;
    }

    private static <T> MemoryRegionCache<T>[] createSubPageCaches(int n2, int n3, PoolArena.SizeClass sizeClass) {
        if (n2 > 0 && n3 > 0) {
            MemoryRegionCache[] arrmemoryRegionCache = new MemoryRegionCache[n3];
            for (int i2 = 0; i2 < n3; ++i2) {
                arrmemoryRegionCache[i2] = new /* Unavailable Anonymous Inner Class!! */;
            }
            return arrmemoryRegionCache;
        }
        return null;
    }

    private static int free(MemoryRegionCache<?> memoryRegionCache) {
        if (memoryRegionCache == null) {
            return 0;
        }
        return memoryRegionCache.free();
    }

    private static int free(MemoryRegionCache<?>[] arrmemoryRegionCache) {
        if (arrmemoryRegionCache == null) {
            return 0;
        }
        int n2 = arrmemoryRegionCache.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 += PoolThreadCache.free(arrmemoryRegionCache[i2]);
        }
        return n3;
    }

    private static int log2(int n2) {
        int n3 = 0;
        while (n2 > 1) {
            n2 >>= 1;
            ++n3;
        }
        return n3;
    }

    private static void trim(MemoryRegionCache<?> memoryRegionCache) {
        if (memoryRegionCache == null) {
            return;
        }
        memoryRegionCache.trim();
    }

    private static void trim(MemoryRegionCache<?>[] arrmemoryRegionCache) {
        if (arrmemoryRegionCache == null) {
            return;
        }
        int n2 = arrmemoryRegionCache.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            PoolThreadCache.trim(arrmemoryRegionCache[i2]);
        }
    }

    final boolean add(PoolArena<?> poolArena, PoolChunk poolChunk, long l2, int n2, PoolArena.SizeClass sizeClass) {
        MemoryRegionCache<?> memoryRegionCache = this.cache(poolArena, n2, sizeClass);
        if (memoryRegionCache == null) {
            return false;
        }
        return memoryRegionCache.add(poolChunk, l2);
    }

    final boolean allocateNormal(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int n2, int n3) {
        return PoolThreadCache.super.allocate(PoolThreadCache.super.cacheForNormal(poolArena, n3), pooledByteBuf, n2);
    }

    final boolean allocateSmall(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int n2, int n3) {
        return PoolThreadCache.super.allocate(PoolThreadCache.super.cacheForSmall(poolArena, n3), pooledByteBuf, n2);
    }

    final boolean allocateTiny(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int n2, int n3) {
        return PoolThreadCache.super.allocate(PoolThreadCache.super.cacheForTiny(poolArena, n3), pooledByteBuf, n2);
    }

    final void free() {
        int n2 = PoolThreadCache.free(this.tinySubPageDirectCaches) + PoolThreadCache.free(this.smallSubPageDirectCaches) + PoolThreadCache.free(this.normalDirectCaches) + PoolThreadCache.free(this.tinySubPageHeapCaches) + PoolThreadCache.free(this.smallSubPageHeapCaches) + PoolThreadCache.free(this.normalHeapCaches);
        if (n2 > 0 && logger.b()) {
            logger.b("Freed {} thread-local buffer(s) from thread: {}", (Object)n2, (Object)Thread.currentThread().getName());
        }
        if (this.directArena != null) {
            this.directArena.numThreadCaches.getAndDecrement();
        }
        if (this.heapArena != null) {
            this.heapArena.numThreadCaches.getAndDecrement();
        }
    }

    final void trim() {
        PoolThreadCache.trim(this.tinySubPageDirectCaches);
        PoolThreadCache.trim(this.smallSubPageDirectCaches);
        PoolThreadCache.trim(this.normalDirectCaches);
        PoolThreadCache.trim(this.tinySubPageHeapCaches);
        PoolThreadCache.trim(this.smallSubPageHeapCaches);
        PoolThreadCache.trim(this.normalHeapCaches);
    }

    private static abstract class MemoryRegionCache<T> {
        private static final io.netty.d.j<Entry> RECYCLER = new 1();
        private int allocations;
        private final Queue<Entry<T>> queue;
        private final int size;
        private final PoolArena.SizeClass sizeClass;

        MemoryRegionCache(int n2, PoolArena.SizeClass sizeClass) {
            this.size = j.a(n2);
            this.queue = n.d(this.size);
            this.sizeClass = sizeClass;
        }

        private int free(int n2) {
            int n3;
            Entry entry;
            for (n3 = 0; n3 < n2 && (entry = (Entry)this.queue.poll()) != null; ++n3) {
                MemoryRegionCache.super.freeEntry(entry);
            }
            return n3;
        }

        private void freeEntry(Entry entry) {
            PoolChunk poolChunk = entry.chunk;
            long l2 = entry.handle;
            entry.recycle();
            poolChunk.arena.freeChunk(poolChunk, l2, this.sizeClass);
        }

        private static Entry newEntry(PoolChunk<?> poolChunk, long l2) {
            Entry entry = RECYCLER.get();
            entry.chunk = poolChunk;
            entry.handle = l2;
            return entry;
        }

        public final boolean add(PoolChunk<T> poolChunk, long l2) {
            Entry entry = MemoryRegionCache.newEntry(poolChunk, l2);
            boolean bl = this.queue.offer((Object)entry);
            if (!bl) {
                entry.recycle();
            }
            return bl;
        }

        public final boolean allocate(PooledByteBuf<T> pooledByteBuf, int n2) {
            Entry entry = (Entry)this.queue.poll();
            if (entry == null) {
                return false;
            }
            this.initBuf(entry.chunk, entry.handle, pooledByteBuf, n2);
            entry.recycle();
            this.allocations = 1 + this.allocations;
            return true;
        }

        public final int free() {
            return this.free(Integer.MAX_VALUE);
        }

        protected abstract void initBuf(PoolChunk<T> var1, long var2, PooledByteBuf<T> var4, int var5);

        public final void trim() {
            int n2 = this.size - this.allocations;
            this.allocations = 0;
            if (n2 > 0) {
                this.free(n2);
            }
        }

        static final class Entry<T> {
            PoolChunk<T> chunk;
            long handle = -1L;
            final j.b recyclerHandle;

            Entry(j.b b2) {
                this.recyclerHandle = b2;
            }

            final void recycle() {
                this.chunk = null;
                this.handle = -1L;
                RECYCLER.recycle(this, this.recyclerHandle);
            }
        }

    }

}

