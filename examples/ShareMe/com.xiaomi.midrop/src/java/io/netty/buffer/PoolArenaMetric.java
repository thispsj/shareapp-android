/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package io.netty.buffer;

import io.netty.buffer.PoolChunkListMetric;
import io.netty.buffer.PoolSubpageMetric;
import java.util.List;

public interface PoolArenaMetric {
    public List<PoolChunkListMetric> chunkLists();

    public long numActiveAllocations();

    public long numActiveBytes();

    public long numActiveHugeAllocations();

    public long numActiveNormalAllocations();

    public long numActiveSmallAllocations();

    public long numActiveTinyAllocations();

    public long numAllocations();

    public int numChunkLists();

    public long numDeallocations();

    public long numHugeAllocations();

    public long numHugeDeallocations();

    public long numNormalAllocations();

    public long numNormalDeallocations();

    public long numSmallAllocations();

    public long numSmallDeallocations();

    public int numSmallSubpages();

    public long numTinyAllocations();

    public long numTinyDeallocations();

    public int numTinySubpages();

    public List<PoolSubpageMetric> smallSubpages();

    public List<PoolSubpageMetric> tinySubpages();
}

