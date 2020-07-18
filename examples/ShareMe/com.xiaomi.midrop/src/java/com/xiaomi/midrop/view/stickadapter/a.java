/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$b
 *  android.support.v7.widget.RecyclerView$w
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  com.xiaomi.midrop.view.stickadapter.a$a
 *  com.xiaomi.midrop.view.stickadapter.a$b
 *  com.xiaomi.midrop.view.stickadapter.a$c
 *  com.xiaomi.midrop.view.stickadapter.a$d
 *  java.lang.Boolean
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 */
package com.xiaomi.midrop.view.stickadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.midrop.view.stickadapter.a;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Exception performing whole class analysis.
 * Exception performing whole class analysis ignored.
 */
public class a
extends RecyclerView.a<f> {
    private HashMap<Integer, Boolean> c;
    private HashMap<Integer, Object> d;
    private int[] e;
    private int f;
    ArrayList<e> l;

    public a() {
        this.c = new HashMap();
        this.d = new HashMap();
    }

    private static int i(int n2) {
        return 255 & n2 >> 8;
    }

    public final int a() {
        if (this.l == null) {
            this.g();
        }
        return this.f;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final int a(int n2) {
        int n3;
        int n4;
        e e2;
        int n5;
        block18 : {
            block19 : {
                block20 : {
                    block17 : {
                        block21 : {
                            block16 : {
                                block15 : {
                                    if (this.l == null) {
                                        this.g();
                                    }
                                    if (n2 < 0) {
                                        StringBuilder stringBuilder = new StringBuilder("adapterPosition (");
                                        stringBuilder.append(n2);
                                        stringBuilder.append(") cannot be < 0");
                                        throw new IndexOutOfBoundsException(stringBuilder.toString());
                                    }
                                    if (n2 >= this.a()) {
                                        StringBuilder stringBuilder = new StringBuilder("adapterPosition (");
                                        stringBuilder.append(n2);
                                        stringBuilder.append(")  cannot be > getItemCount() (");
                                        stringBuilder.append(this.a());
                                        stringBuilder.append(")");
                                        throw new IndexOutOfBoundsException(stringBuilder.toString());
                                    }
                                    n5 = this.f(n2);
                                    e2 = this.l.get(n5);
                                    n3 = n2 - e2.a;
                                    boolean bl = e2.d;
                                    n4 = 2;
                                    if (!bl || !e2.e) break block15;
                                    if (n3 == 0) break block16;
                                    if (n3 == 1) break block17;
                                    if (n3 != e2.c - 1) break block18;
                                    break block19;
                                }
                                if (!e2.d) break block20;
                                if (n3 != 0) break block21;
                            }
                            n4 = 0;
                            break block18;
                        }
                        if (n3 != 1) break block18;
                    }
                    n4 = 1;
                    break block18;
                }
                if (!e2.e || n3 != e2.c - 1) break block18;
            }
            n4 = 3;
        }
        int n6 = 0;
        if (n4 == 0) return (n6 & 255) << 8 | n4 & 255;
        n6 = 0;
        switch (n4) {
            default: {
                n6 = 0;
                return (n6 & 255) << 8 | n4 & 255;
            }
            case 2: {
                if (e2.d) {
                    n3 -= 2;
                }
                if ((n6 = this.a(n5, n3)) >= 0) {
                    if (n6 <= 255) return (n6 & 255) << 8 | n4 & 255;
                }
                StringBuilder stringBuilder = new StringBuilder("Custom item view type (");
                stringBuilder.append(n6);
                stringBuilder.append(") must be in range [0,255]");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 3: 
        }
        return (n6 & 255) << 8 | n4 & 255;
    }

    public int a(int n2, int n3) {
        return 0;
    }

    public final /* synthetic */ RecyclerView.w a(ViewGroup viewGroup, int n2) {
        int n3 = n2 & 255;
        int n4 = a.i(n2);
        switch (n3) {
            default: {
                StringBuilder stringBuilder = new StringBuilder("unrecognized viewType: ");
                stringBuilder.append(n2);
                stringBuilder.append(" does not correspond to TYPE_ITEM, TYPE_HEADER or TYPE_FOOTER");
                throw new IndexOutOfBoundsException(stringBuilder.toString());
            }
            case 3: {
                return this.b(viewGroup);
            }
            case 2: {
                return this.c(viewGroup, n4);
            }
            case 1: {
                View view = new View(viewGroup.getContext());
                new ViewGroup.LayoutParams(-1, -2);
                return new /* Unavailable Anonymous Inner Class!! */;
            }
            case 0: 
        }
        return this.a(viewGroup);
    }

    public c a(ViewGroup viewGroup) {
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void a(int var1, boolean var2_2) {
        block9 : {
            block8 : {
                var3_3 = this.g(var1) != var2_2;
                this.c.put((Object)var1, (Object)var2_2);
                if (var3_3 == false) return;
                if (this.l == null) {
                    this.g();
                }
                var5_4 = (this.l.get((int)var1)).b;
                if (!var2_2) break block8;
                if (this.l == null) ** GOTO lbl-1000
                this.g();
                var12_5 = this.l.get(var1);
                if (var12_5.b < 0) {
                    var13_6 = new StringBuilder("itemIndex adapterPosition: 0 exceeds sectionIndex numberOfItems: ");
                    var13_6.append(var12_5.b);
                    throw new IndexOutOfBoundsException(var13_6.toString());
                }
                if (var5_4 + 0 > var12_5.b) {
                    var15_7 = new StringBuilder("itemIndex adapterPosition: 0");
                    var15_7.append(var5_4);
                    var15_7.append(" exceeds sectionIndex numberOfItems: ");
                    var15_7.append(var12_5.b);
                    throw new IndexOutOfBoundsException(var15_7.toString());
                }
                var19_8 = var12_5.d;
                var20_9 = 0;
                if (var19_8) {
                    var20_9 = 2;
                }
                var21_10 = var20_9 + var12_5.a;
                this.a.b(var21_10, var5_4);
                break block9;
            }
            if (this.l == null) lbl-1000: // 2 sources:
            {
                this.g();
                this.f();
            } else {
                this.g();
                var6_11 = this.l.get(var1);
                if (var6_11.b < 0) {
                    var7_12 = new StringBuilder("itemIndex adapterPosition: 0 exceeds sectionIndex numberOfItems: ");
                    var7_12.append(var6_11.b);
                    throw new IndexOutOfBoundsException(var7_12.toString());
                }
                var9_13 = var6_11.d;
                var10_14 = 0;
                if (var9_13) {
                    var10_14 = 2;
                }
                var11_15 = var10_14 + var6_11.a;
                this.a.a(var11_15, var5_4);
            }
        }
        this.a.b();
    }

    public final /* synthetic */ void a(RecyclerView.w w2, int n2) {
        f f2 = (f)w2;
        int n3 = this.f(n2);
        f.a(f2, n3);
        f2.s = this.d(n3);
        f2.a.setTag(2131296727, (Object)f2);
        int n4 = 255 & f2.f;
        int n5 = a.i(f2.f);
        switch (n4) {
            default: {
                StringBuilder stringBuilder = new StringBuilder("unrecognized viewType: ");
                stringBuilder.append(n4);
                stringBuilder.append(" does not correspond to TYPE_ITEM, TYPE_HEADER, TYPE_GHOST_HEADER or TYPE_FOOTER");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 3: {
                this.a(f2, n3, n5);
                return;
            }
            case 2: {
                d d2 = f2;
                if (this.l == null) {
                    this.g();
                }
                if (n3 < 0) {
                    StringBuilder stringBuilder = new StringBuilder("sectionIndex ");
                    stringBuilder.append(n3);
                    stringBuilder.append(" < 0");
                    throw new IndexOutOfBoundsException(stringBuilder.toString());
                }
                if (n3 >= this.l.size()) {
                    StringBuilder stringBuilder = new StringBuilder("sectionIndex ");
                    stringBuilder.append(n3);
                    stringBuilder.append(" >= sections.size (");
                    stringBuilder.append(this.l.size());
                    stringBuilder.append(")");
                    throw new IndexOutOfBoundsException(stringBuilder.toString());
                }
                e e2 = this.l.get(n3);
                int n6 = n2 - e2.a;
                if (n6 > e2.c) {
                    StringBuilder stringBuilder = new StringBuilder("adapterPosition: ");
                    stringBuilder.append(n2);
                    stringBuilder.append(" is beyond sectionIndex: ");
                    stringBuilder.append(n3);
                    stringBuilder.append(" length: ");
                    stringBuilder.append(e2.c);
                    throw new IndexOutOfBoundsException(stringBuilder.toString());
                }
                if (e2.d) {
                    n6 -= 2;
                }
                d.a(d2, (int)n6);
                this.a(d2, n3, n6, n5);
            }
            case 1: {
                return;
            }
            case 0: 
        }
        this.a(f2, n3, n5);
    }

    public void a(a a2, int n2, int n3) {
    }

    public void a(c c2, int n2, int n3) {
    }

    public void a(d d2, int n2, int n3, int n4) {
    }

    public a b(ViewGroup viewGroup) {
        return null;
    }

    public int c() {
        return 0;
    }

    public d c(ViewGroup viewGroup, int n2) {
        return null;
    }

    public int d(int n2) {
        return 0;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public boolean e(int n2) {
        return false;
    }

    public final int f(int n2) {
        if (this.l == null) {
            this.g();
        }
        if (this.a() == 0) {
            return -1;
        }
        if (n2 >= 0 && n2 < this.a()) {
            return this.e[n2];
        }
        StringBuilder stringBuilder = new StringBuilder("adapterPosition ");
        stringBuilder.append(n2);
        stringBuilder.append(" is not in range of items represented by adapter");
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final void f() {
        this.c.clear();
        this.d.clear();
        this.g();
        this.a.b();
    }

    final void g() {
        this.l = new ArrayList();
        if (this.c.isEmpty()) {
            for (int i2 = 0; i2 < this.c(); ++i2) {
                this.c.put((Object)i2, (Object)this.d());
            }
        }
        int n2 = this.c();
        int n3 = 0;
        for (int i3 = 0; i3 < n2; ++i3) {
            Object object = new Object(0){
                int a;
                int b;
                int c;
                boolean d;
                boolean e;
            };
            object.a = n3;
            object.d = this.e(i3);
            object.e = this.e();
            if (this.g(i3)) {
                object.c = 0;
                object.b = this.d(i3);
            } else {
                int n4;
                object.b = n4 = this.d(i3);
                object.c = n4;
            }
            if (object.d) {
                object.c = 2 + object.c;
            }
            if (object.e) {
                object.c = 1 + object.c;
            }
            this.l.add(object);
            n3 += object.c;
        }
        this.f = n3;
        this.e = new int[this.f];
        int n5 = this.c();
        int n6 = 0;
        for (int i4 = 0; i4 < n5; ++i4) {
            e e2 = this.l.get(i4);
            for (int i5 = 0; i5 < e2.c; ++i5) {
                this.e[n6 + i5] = i4;
            }
            n6 += e2.c;
        }
    }

    public final boolean g(int n2) {
        if (this.c.containsKey((Object)n2)) {
            return (Boolean)this.c.get((Object)n2);
        }
        return false;
    }

    public final int h(int n2) {
        return 255 & this.a(n2);
    }

    public static class f
    extends RecyclerView.w {
        private int n;
        int s;

        public f(View view) {
            super(view);
        }

        static /* synthetic */ void a(f f2, int n2) {
            f2.n = n2;
        }
    }

}

