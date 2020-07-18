/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.ConcurrentHashMap
 */
package com.xiaomi.midrop.transmission;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.midrop.b.f;
import com.xiaomi.midrop.b.g;
import com.xiaomi.midrop.sender.c.b;
import com.xiaomi.midrop.transmission.a.d;
import com.xiaomi.midrop.util.af;
import com.xiaomi.midrop.util.aj;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class c
extends com.xiaomi.midrop.sender.c.b<com.xiaomi.midrop.transmission.a.a> {
    private static c q;
    public List<com.xiaomi.midrop.transmission.a.a> e = new ArrayList();
    public List<g> f = new ArrayList();
    public volatile ConcurrentHashMap<String, f> g = new ConcurrentHashMap();
    public int h;
    public long i;
    public long j;
    public long k;
    public int l = 0;
    public int m = 0;
    public HashSet<String> n = new HashSet();
    public HashSet<String> o = new HashSet();
    public a p;

    private static boolean a(g g2) {
        return g2.m == 3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c e() {
        if (q != null) return q;
        Class<c> class_ = c.class;
        synchronized (c.class) {
            if (q != null) return q;
            q = new c();
            // ** MonitorExit[var1] (shouldn't be in output)
            return q;
        }
    }

    public final int a(int n2) {
        if (n2 != 3) {
            return this.m;
        }
        int n3 = 0;
        for (g g2 : this.f) {
            if (g2 instanceof com.xiaomi.midrop.b.b && g2.g == 1) {
                Iterator iterator = ((com.xiaomi.midrop.b.b)g2).b.iterator();
                while (iterator.hasNext()) {
                    if (!c.a((g)iterator.next())) continue;
                    ++n3;
                }
                continue;
            }
            if (!c.a(g2)) continue;
            ++n3;
        }
        this.m = n3;
        return this.m;
    }

    @Override
    public final void c() {
        int n2 = this.f.size();
        this.f.clear();
        this.e.clear();
        this.n.clear();
        this.o.clear();
        this.k = 0L;
        this.j = 0L;
        this.i = 0L;
        this.h = 0;
        this.l = 0;
        this.m = 0;
        super.c();
        af.a(af.a.bw).a(af.b.q, n2).a();
    }

    public final boolean f() {
        Iterator iterator = this.f.iterator();
        while (iterator.hasNext()) {
            if (((g)iterator.next()).c()) continue;
            return false;
        }
        return true;
    }

    public final long g() {
        Iterator iterator = this.f.iterator();
        long l2 = 0L;
        while (iterator.hasNext()) {
            g g2 = (g)iterator.next();
            if (g2.m == 5) continue;
            com.xiaomi.midrop.b.b b2 = (com.xiaomi.midrop.b.b)g2;
            if (g2.g == 1 && b2.b.size() > 0) {
                for (g g3 : b2.b) {
                    if (g3.m != 3) continue;
                    l2 += g3.l;
                }
                continue;
            }
            if (g2.m != 3) continue;
            l2 += b2.a();
        }
        return l2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void h() {
        if (this.e == null) return;
        if (this.e.size() <= 0) return;
        var1_1 = (com.xiaomi.midrop.transmission.a.a)this.e.get(this.e.size() - 1);
        if (var1_1 instanceof d == false) return;
        var2_2 = (d)var1_1;
        if (var2_2.e != 0) return;
        var3_3 = new ArrayList();
        var4_4 = var2_2.a.iterator();
        block0 : do {
            block13 : {
                block9 : {
                    block12 : {
                        block11 : {
                            block10 : {
                                block8 : {
                                    if (!var4_4.hasNext()) {
                                        af.a(af.a.bT).a(af.b.E, aj.a("_", (List<String>)var3_3)).a();
                                        return;
                                    }
                                    var5_8 = (com.xiaomi.midrop.b.b)var4_4.next();
                                    if (var5_8.g != 1) break block8;
                                    var11_6 = "picture";
                                    break block9;
                                }
                                if (var5_8.g != 3) break block10;
                                var11_6 = "audio";
                                break block9;
                            }
                            if (var5_8.g != 2) break block11;
                            var11_6 = "video";
                            break block9;
                        }
                        if (var5_8.g != 4) break block12;
                        var11_6 = "apk";
                        break block9;
                    }
                    if (var5_8.g != 5) continue;
                    var6_11 = var5_8.b.iterator();
                    var7_10 = false;
                    var8_5 = false;
                    var9_7 = false;
                    break block13;
                }
lbl37: // 2 sources:
                do {
                    var3_3.add((Object)var11_6);
                    continue block0;
                    break;
                } while (true);
            }
            while (var6_11.hasNext()) {
                var10_9 = new File(((g)var6_11.next()).i);
                var9_7 = var10_9.isHidden();
                if (var10_9.isDirectory()) {
                    var8_5 = true;
                } else {
                    var7_10 = true;
                }
                if (!(var7_10 & var8_5)) continue;
            }
            if (var8_5) {
                var3_3.add((Object)"folder");
            }
            if (var7_10) {
                var3_3.add((Object)"others");
            }
            if (var9_7) break;
        } while (true);
        var11_6 = "hide_file";
        ** while (true)
    }

    public static interface b
    extends b.a {
        public void n();
    }

}

