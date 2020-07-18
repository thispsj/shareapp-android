/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package io.netty.buffer;

public interface PoolSubpageMetric {
    public int elementSize();

    public int maxNumElements();

    public int numAvailable();

    public int pageSize();
}

