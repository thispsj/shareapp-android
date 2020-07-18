/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.zxing.b
 *  com.google.zxing.b.j
 *  com.google.zxing.c
 *  com.google.zxing.j
 *  com.google.zxing.k
 *  com.google.zxing.o
 *  com.google.zxing.q
 *  com.google.zxing.s
 *  com.google.zxing.t
 *  java.lang.Exception
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 */
package com.journeyapps.barcodescanner;

import com.google.zxing.b;
import com.google.zxing.c;
import com.google.zxing.j;
import com.google.zxing.k;
import com.google.zxing.o;
import com.google.zxing.q;
import com.google.zxing.s;
import com.google.zxing.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class e
implements t {
    List<s> a = new ArrayList();
    private o b;

    public e(o o2) {
        this.b = o2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private q a(c c2) {
        this.a.clear();
        try {
            q q2;
            if (this.b instanceof k) {
                k k2 = (k)this.b;
                if (k2.a == null) {
                    k2.a(null);
                }
                q2 = k2.b(c2);
                do {
                    return q2;
                    break;
                } while (true);
            }
            q2 = this.b.a(c2);
            return q2;
        }
        catch (Exception exception) {
            return null;
        }
        finally {
            this.b.a();
        }
    }

    public final q a(j j2) {
        return e.super.a(this.b(j2));
    }

    public final void a(s s2) {
        this.a.add((Object)s2);
    }

    protected c b(j j2) {
        return new c((b)new com.google.zxing.b.j(j2));
    }
}

