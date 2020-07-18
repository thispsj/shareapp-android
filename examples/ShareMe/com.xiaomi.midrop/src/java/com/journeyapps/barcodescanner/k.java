/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.zxing.b
 *  com.google.zxing.b.j
 *  com.google.zxing.c
 *  com.google.zxing.j
 *  com.google.zxing.o
 */
package com.journeyapps.barcodescanner;

import com.google.zxing.b;
import com.google.zxing.c;
import com.google.zxing.j;
import com.google.zxing.o;
import com.journeyapps.barcodescanner.e;

public final class k
extends e {
    private boolean b = true;

    public k(o o2) {
        super(o2);
    }

    @Override
    protected final c b(j j2) {
        if (this.b) {
            this.b = false;
            return new c((b)new com.google.zxing.b.j(j2.c()));
        }
        this.b = true;
        return new c((b)new com.google.zxing.b.j(j2));
    }
}

