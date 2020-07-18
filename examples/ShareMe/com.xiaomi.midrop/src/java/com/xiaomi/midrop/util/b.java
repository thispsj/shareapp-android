/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Thread
 *  java.util.LinkedList
 *  java.util.Queue
 */
package com.xiaomi.midrop.util;

import java.util.LinkedList;
import java.util.Queue;

public final class b<E> {
    Thread a;
    public final Queue<E> b;
    final int c;
    final b<E> d;

    private b(a<E> a2) {
        this.a = null;
        this.b = new LinkedList();
        this.c = a2.a;
        this.d = a2.b;
    }

    public /* synthetic */ b(a a2, byte by) {
        super(a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(E e2) {
        Queue<E> queue;
        Queue<E> queue2 = queue = this.b;
        synchronized (queue2) {
            this.b.offer(e2);
            if (this.a == null) {
                this.a = new Thread(){

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    public final void run() {
                        do {
                            Queue queue;
                            Object object;
                            Queue queue2 = queue = b.this.b;
                            synchronized (queue2) {
                                boolean bl = b.this.b.isEmpty();
                                if (bl) {
                                    try {
                                        b.this.b.wait((long)b.this.c);
                                        if (b.this.b.isEmpty()) {
                                            b.this.a = null;
                                            return;
                                        }
                                    }
                                    catch (InterruptedException interruptedException) {
                                        b.this.a = null;
                                        return;
                                    }
                                }
                                object = b.this.b.poll();
                                if (b.this.d == null) continue;
                            }
                            b.this.d.a(object);
                        } while (true);
                    }
                };
                this.a.start();
            }
            this.b.notify();
            return;
        }
    }

    public static final class a<E> {
        public int a = 17000;
        public b<E> b = null;
    }

    public static interface b<E> {
        public void a(E var1);
    }

}

