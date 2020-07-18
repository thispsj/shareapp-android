/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.nio.channels.SelectionKey
 *  java.nio.channels.Selector
 *  java.nio.channels.spi.SelectorProvider
 *  java.util.Set
 */
package io.netty.b.a;

import io.netty.b.a.f;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

final class g
extends Selector {
    private final f a;
    private final Selector b;

    g(Selector selector, f f2) {
        this.b = selector;
        this.a = f2;
    }

    public final void close() throws IOException {
        this.b.close();
    }

    public final boolean isOpen() {
        return this.b.isOpen();
    }

    public final Set<SelectionKey> keys() {
        return this.b.keys();
    }

    public final SelectorProvider provider() {
        return this.b.provider();
    }

    public final int select() throws IOException {
        this.a.a(0);
        return this.b.select();
    }

    public final int select(long l2) throws IOException {
        this.a.a(0);
        return this.b.select(l2);
    }

    public final int selectNow() throws IOException {
        this.a.a(0);
        return this.b.selectNow();
    }

    public final Set<SelectionKey> selectedKeys() {
        return this.b.selectedKeys();
    }

    public final Selector wakeup() {
        return this.b.wakeup();
    }
}

