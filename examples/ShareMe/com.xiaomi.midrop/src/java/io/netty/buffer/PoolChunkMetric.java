/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package io.netty.buffer;

public interface PoolChunkMetric {
    public int chunkSize();

    public int freeBytes();

    public int usage();
}

