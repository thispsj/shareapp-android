/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.support.v7.widget.RecyclerView
 *  android.support.v7.widget.RecyclerView$a
 *  android.support.v7.widget.RecyclerView$i
 *  android.support.v7.widget.RecyclerView$j
 *  android.support.v7.widget.RecyclerView$o
 *  android.support.v7.widget.RecyclerView$s
 *  android.support.v7.widget.RecyclerView$t
 *  android.util.Log
 *  android.view.View
 *  com.xiaomi.midrop.view.stickadapter.StickyHeaderLayoutManager$d
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Enum
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 */
package com.xiaomi.midrop.view.stickadapter;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.xiaomi.midrop.view.stickadapter.StickyHeaderLayoutManager;
import com.xiaomi.midrop.view.stickadapter.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*
 * Exception performing whole class analysis.
 */
public class StickyHeaderLayoutManager
extends RecyclerView.i {
    private static final String a = "StickyHeaderLayoutManager";
    private com.xiaomi.midrop.view.stickadapter.a b;
    private HashSet<View> c;
    private HashMap<Integer, a> d;
    private b e;
    private int f;
    private int g;
    private int h;
    private c i;

    public StickyHeaderLayoutManager() {
        this.c = new HashSet();
        this.d = new HashMap();
        this.h = -1;
    }

    static /* synthetic */ int a(StickyHeaderLayoutManager stickyHeaderLayoutManager, int n2) {
        stickyHeaderLayoutManager.i();
        if (n2 > stickyHeaderLayoutManager.f) {
            return 1;
        }
        if (n2 < stickyHeaderLayoutManager.f) {
            return -1;
        }
        return 0;
    }

    private View a(RecyclerView.o o2, int n2) {
        if (this.b.e(n2)) {
            int n3;
            int n4 = this.p();
            for (int i2 = 0; i2 < n4; ++i2) {
                View view = this.g(i2);
                if (StickyHeaderLayoutManager.super.l(view) != 0 || StickyHeaderLayoutManager.super.m(view) != n2) continue;
                return view;
            }
            com.xiaomi.midrop.view.stickadapter.a a2 = this.b;
            if (a2.e(n2)) {
                if (a2.l == null) {
                    a2.g();
                }
                if (n2 < 0) {
                    StringBuilder stringBuilder = new StringBuilder("sectionIndex ");
                    stringBuilder.append(n2);
                    stringBuilder.append(" < 0");
                    throw new IndexOutOfBoundsException(stringBuilder.toString());
                }
                if (n2 >= a2.l.size()) {
                    StringBuilder stringBuilder = new StringBuilder("sectionIndex ");
                    stringBuilder.append(n2);
                    stringBuilder.append(" >= sections.size (");
                    stringBuilder.append(a2.l.size());
                    stringBuilder.append(")");
                    throw new IndexOutOfBoundsException(stringBuilder.toString());
                }
                n3 = 0 + (a2.l.get((int)n2)).a;
            } else {
                n3 = -1;
            }
            View view = o2.b(n3);
            this.c.add((Object)view);
            this.a(view);
            this.d(view);
            return view;
        }
        return null;
    }

    private void d(RecyclerView.o o2) {
        HashSet hashSet = new HashSet();
        int n2 = this.p();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = StickyHeaderLayoutManager.super.m(this.g(i2));
            if (!hashSet.add((Object)n3) || !this.b.e(n3)) continue;
            StickyHeaderLayoutManager.super.a(o2, n3);
        }
        int n4 = this.q();
        int n5 = this.D - this.s();
        for (View view : this.c) {
            int n6;
            int n7;
            int n8 = StickyHeaderLayoutManager.super.m(view);
            int n9 = this.p();
            View view2 = null;
            View view3 = null;
            for (int i3 = 0; i3 < n9; ++i3) {
                int n10;
                View view4 = this.g(i3);
                if (StickyHeaderLayoutManager.k(view4) || (n10 = StickyHeaderLayoutManager.super.l(view4)) == 0) continue;
                int n11 = StickyHeaderLayoutManager.super.m(view4);
                if (n11 == n8) {
                    if (n10 != 1) continue;
                    view2 = view4;
                    continue;
                }
                if (n11 != n8 + 1 || view3 != null) continue;
                view3 = view4;
            }
            int n12 = StickyHeaderLayoutManager.f((View)view);
            int n13 = this.r();
            a a2 = a.c;
            if (view2 != null && (n7 = StickyHeaderLayoutManager.h(view2)) >= n13) {
                a2 = a.b;
                n13 = n7;
            }
            if (view3 != null && (n6 = StickyHeaderLayoutManager.h(view3) - n12) < n13) {
                a2 = a.d;
                n13 = n6;
            }
            view.bringToFront();
            StickyHeaderLayoutManager.a((View)view, (int)n4, (int)n13, (int)n5, (int)(n12 + n13));
            if (this.d.containsKey((Object)n8)) {
                if ((Object)this.d.get((Object)n8) == a2) continue;
                this.d.put((Object)n8, (Object)a2);
                continue;
            }
            this.d.put((Object)n8, (Object)a2);
            if (this.e == null) continue;
        }
    }

    private static int e(RecyclerView recyclerView) {
        int n2 = recyclerView.getChildCount();
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 = Math.max((int)StickyHeaderLayoutManager.f((View)recyclerView.getChildAt(i2)), (int)n3);
        }
        return n3;
    }

    private View h() {
        int n2 = this.p();
        View view = null;
        if (n2 == 0) {
            return null;
        }
        int n3 = Integer.MAX_VALUE;
        int n4 = this.p();
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5;
            View view2 = this.g(i2);
            if (StickyHeaderLayoutManager.n(view2) == -1 || this.l(view2) == 0 || (n5 = StickyHeaderLayoutManager.h((View)view2)) >= n3) continue;
            view = view2;
            n3 = n5;
        }
        return view;
    }

    /*
     * Enabled aggressive block sorting
     */
    private int i() {
        int n2;
        if (this.p() == 0) {
            this.f = 0;
            n2 = this.r();
        } else {
            View view = this.h();
            if (view == null) {
                return this.g;
            }
            this.f = StickyHeaderLayoutManager.n(view);
            n2 = Math.min((int)view.getTop(), (int)this.r());
        }
        this.g = n2;
        return this.g;
    }

    private static boolean k(View view) {
        return StickyHeaderLayoutManager.n(view) == -1;
    }

    private int l(View view) {
        int n2 = StickyHeaderLayoutManager.n(view);
        return this.b.h(n2);
    }

    private int m(View view) {
        int n2 = StickyHeaderLayoutManager.n(view);
        return this.b.f(n2);
    }

    private static int n(View view) {
        return ((a.f)((Object)view.getTag(2131296727))).d();
    }

    public final void a(Parcelable parcelable) {
        if (parcelable == null) {
            return;
        }
        if (parcelable instanceof c) {
            this.i = parcelable;
            this.l();
            return;
        }
        String string2 = a;
        StringBuilder stringBuilder = new StringBuilder("onRestoreInstanceState: invalid saved state class, expected: ");
        stringBuilder.append(c.class.getCanonicalName());
        stringBuilder.append(" got: ");
        stringBuilder.append(parcelable.getClass().getCanonicalName());
        Log.e((String)string2, (String)stringBuilder.toString());
    }

    public final void a(RecyclerView.a a2, RecyclerView.a a3) {
        super.a(a2, a3);
        try {
            this.b = (com.xiaomi.midrop.view.stickadapter.a)a3;
        }
        catch (ClassCastException classCastException) {
            throw new ClassCastException("StickyHeaderLayoutManager must be used with a RecyclerView where the adapter is a kind of SectioningAdapter");
        }
        this.o();
        this.c.clear();
        this.d.clear();
    }

    public final void a(RecyclerView recyclerView, int n2) {
        if (n2 >= 0 && n2 <= this.v()) {
            this.i = null;
            View view = recyclerView.getChildAt(0);
            int n3 = Math.abs((int)(StickyHeaderLayoutManager.e(recyclerView) * (RecyclerView.d((View)view) - n2)));
            if (n3 == 0) {
                n3 = (int)Math.abs((float)view.getY());
            }
            d d2 = new /* Unavailable Anonymous Inner Class!! */;
            d2.g = n2;
            this.a((RecyclerView.s)d2);
            return;
        }
        throw new IndexOutOfBoundsException("adapter position out of range");
    }

    public final void a(RecyclerView recyclerView, RecyclerView.o o2) {
        super.a(recyclerView, o2);
        StickyHeaderLayoutManager.super.i();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final int b(int var1, RecyclerView.o var2_3, RecyclerView.t var3_2) {
        block20 : {
            block19 : {
                if (this.p() == 0) {
                    return 0;
                }
                var4_4 = this.q();
                var5_5 = this.D - this.s();
                if (var1 >= 0) break block19;
                var47_6 = StickyHeaderLayoutManager.super.h();
                var17_7 = 0;
                while (var17_7 > var1) {
                    var48_10 = Math.max((int)(-StickyHeaderLayoutManager.h((View)var47_6)), (int)0);
                    var49_8 = Math.min((int)(var17_7 - var1), (int)var48_10);
                    this.i(var49_8);
                    if (this.f <= 0 || (var17_7 -= var49_8) <= var1) break;
                    --this.f;
                    var50_12 = this.b.h(this.f);
                    var51_17 = var50_12 == 0;
                    if (var51_17) {
                        --this.f;
                        if (this.f < 0 || (var57_11 = (var50_12 = this.b.h(this.f)) == 0)) break;
                    }
                    var52_16 = var2_3.b(this.f);
                    super.a(var52_16, 0, false);
                    var53_9 = StickyHeaderLayoutManager.h((View)var47_6);
                    var54_14 = var50_12 == 1;
                    if (var54_14) {
                        var55_15 = StickyHeaderLayoutManager.f((View)StickyHeaderLayoutManager.super.a(var2_3, this.b.f(this.f)));
                    } else {
                        this.d(var52_16);
                        var55_15 = StickyHeaderLayoutManager.f((View)var52_16);
                    }
                    var56_13 = var53_9 - var55_15;
                    StickyHeaderLayoutManager.a((View)var52_16, (int)var4_4, (int)var56_13, (int)var5_5, (int)var53_9);
                    var47_6 = var52_16;
                }
                var15_18 = var2_3;
                var16_19 = this;
                break block20;
            }
            var6_20 = this.E;
            var7_21 = this.p();
            var8_22 = null;
            if (var7_21 == 0) {
                var13_23 = var4_4;
                var14_24 = var5_5;
            } else {
                var9_27 = this.p();
                var10_30 = null;
                var12_28 = Integer.MIN_VALUE;
                for (var11_26 = 0; var11_26 < var9_27; ++var11_26) {
                    var45_25 = this.g(var11_26);
                    if (StickyHeaderLayoutManager.n(var45_25) == -1 || StickyHeaderLayoutManager.super.l(var45_25) == 0 || (var46_29 = StickyHeaderLayoutManager.j((View)var45_25)) <= var12_28) continue;
                    var10_30 = var45_25;
                    var12_28 = var46_29;
                }
                var13_23 = var4_4;
                var14_24 = var5_5;
                var8_22 = var10_30;
            }
            var15_18 = var2_3;
            var16_19 = this;
            var17_7 = 0;
            while (var17_7 < var1) {
                block21 : {
                    var36_32 = Math.max((int)(StickyHeaderLayoutManager.j(var8_22) - var6_20), (int)0);
                    var37_31 = -Math.min((int)(var1 - var17_7), (int)var36_32);
                    var16_19.i(var37_31);
                    var38_38 = 1 + StickyHeaderLayoutManager.n(var8_22);
                    if ((var17_7 -= var37_31) >= var1 || var38_38 >= var3_2.a()) break;
                    var39_37 = StickyHeaderLayoutManager.j((View)var8_22);
                    var40_39 = var16_19.b.h(var38_38);
                    if (var40_39 != 0) break block21;
                    var44_35 = StickyHeaderLayoutManager.super.a(var15_18, var16_19.b.f(var38_38));
                    var43_36 = StickyHeaderLayoutManager.f((View)var44_35);
                    StickyHeaderLayoutManager.a((View)var44_35, (int)var13_23, (int)0, (int)var14_24, (int)var43_36);
                    ++var38_38;
                    ** GOTO lbl77
                }
                if (var40_39 == 1) {
                    var42_34 = StickyHeaderLayoutManager.super.a(var15_18, var16_19.b.f(var38_38));
                    var43_36 = StickyHeaderLayoutManager.f((View)var42_34);
                    StickyHeaderLayoutManager.a((View)var42_34, (int)var13_23, (int)0, (int)var14_24, (int)var43_36);
lbl77: // 2 sources:
                    var41_33 = var15_18.b(var38_38);
                    var16_19.a(var41_33);
                    StickyHeaderLayoutManager.a((View)var41_33, (int)var13_23, (int)var39_37, (int)var14_24, (int)(var43_36 + var39_37));
                } else {
                    var41_33 = var15_18.b(var38_38);
                    var16_19.a(var41_33);
                    var16_19.d(var41_33);
                    StickyHeaderLayoutManager.a((View)var41_33, (int)var13_23, (int)var39_37, (int)var14_24, (int)(var39_37 + StickyHeaderLayoutManager.f((View)var41_33)));
                }
                var8_22 = var41_33;
            }
        }
        var18_40 = StickyHeaderLayoutManager.super.h();
        if (var18_40 != null) {
            var16_19.g = StickyHeaderLayoutManager.h((View)var18_40);
        }
        StickyHeaderLayoutManager.super.d(var15_18);
        var19_41 = var16_19.E;
        var20_42 = var16_19.p();
        var21_43 = new HashSet();
        var22_44 = new HashSet();
        var23_45 = 0;
        do {
            if (var23_45 >= var20_42) break;
            var33_46 = var16_19.g(var23_45);
            if (!StickyHeaderLayoutManager.k(var33_46) && StickyHeaderLayoutManager.super.l(var33_46) != 0) {
                if (StickyHeaderLayoutManager.j((View)var33_46) >= 0 && StickyHeaderLayoutManager.h((View)var33_46) <= var19_41) {
                    var21_43.add((Object)StickyHeaderLayoutManager.super.m(var33_46));
                } else {
                    var22_44.add((Object)var33_46);
                }
            }
            ++var23_45;
        } while (true);
        for (var24_47 = 0; var24_47 < var20_42; ++var24_47) {
            var27_49 = var16_19.g(var24_47);
            if (StickyHeaderLayoutManager.k(var27_49)) continue;
            var28_50 = StickyHeaderLayoutManager.super.m(var27_49);
            if (StickyHeaderLayoutManager.super.l(var27_49) != 0 || var21_43.contains((Object)var28_50) || !((var29_48 = var27_49.getTranslationY()) + (float)StickyHeaderLayoutManager.j((View)var27_49) < 0.0f) && !(var29_48 + (float)StickyHeaderLayoutManager.h((View)var27_49) > (float)var19_41)) continue;
            var22_44.add((Object)var27_49);
            var16_19.c.remove((Object)var27_49);
            var16_19.d.remove((Object)var28_50);
        }
        var25_51 = var22_44.iterator();
        do {
            if (!var25_51.hasNext()) {
                StickyHeaderLayoutManager.super.i();
                return var17_7;
            }
            var16_19.a((View)var25_51.next(), var15_18);
        } while (true);
    }

    public final RecyclerView.j b() {
        return new RecyclerView.j(-1, -2);
    }

    public final void c(RecyclerView.o o2, RecyclerView.t t2) {
        boolean bl;
        int n2;
        if (this.b == null) {
            return;
        }
        int n3 = this.h;
        int n4 = 0;
        if (n3 >= 0) {
            this.f = this.h;
            this.g = 0;
            this.h = -1;
        } else if (this.i != null && (bl = this.i.a >= 0)) {
            this.f = this.i.a;
            this.g = this.i.b;
            this.i = null;
        } else {
            StickyHeaderLayoutManager.super.i();
        }
        int n5 = this.g;
        this.c.clear();
        this.d.clear();
        this.a(o2);
        int n6 = this.q();
        int n7 = this.D - this.s();
        int n8 = this.E - this.t();
        if (this.f >= t2.a()) {
            this.f = 0;
        }
        for (int i2 = this.f; i2 < t2.a(); ++i2) {
            int n9;
            View view = o2.b(i2);
            this.a(view);
            this.d(view);
            int n10 = StickyHeaderLayoutManager.super.l(view);
            if (n10 == 0) {
                this.c.add((Object)view);
                n9 = StickyHeaderLayoutManager.f((View)view);
                int n11 = n5 + n9;
                StickyHeaderLayoutManager.a((View)view, (int)n6, (int)n5, (int)n7, (int)n11);
                View view2 = o2.b(++i2);
                this.a(view2);
                StickyHeaderLayoutManager.a((View)view2, (int)n6, (int)n5, (int)n7, (int)n11);
            } else if (n10 == 1) {
                View view3 = o2.b(i2 - 1);
                this.c.add((Object)view3);
                this.a(view3);
                this.d(view3);
                int n12 = StickyHeaderLayoutManager.f((View)view3);
                int n13 = n5 + n12;
                StickyHeaderLayoutManager.a((View)view3, (int)n6, (int)n5, (int)n7, (int)n13);
                StickyHeaderLayoutManager.a((View)view, (int)n6, (int)n5, (int)n7, (int)n13);
                n9 = n12;
            } else {
                n9 = StickyHeaderLayoutManager.f((View)view);
                StickyHeaderLayoutManager.a((View)view, (int)n6, (int)n5, (int)n7, (int)(n5 + n9));
            }
            n5 += n9;
            n4 += n9;
            if (view.getBottom() >= n8) break;
        }
        if (n4 < (n2 = this.E - (this.r() + this.t()))) {
            this.b(n4 - n2, o2, null);
            return;
        }
        StickyHeaderLayoutManager.super.d(o2);
    }

    public final void c(RecyclerView recyclerView) {
        super.c(recyclerView);
        try {
            this.b = (com.xiaomi.midrop.view.stickadapter.a)recyclerView.getAdapter();
            return;
        }
        catch (ClassCastException classCastException) {
            throw new ClassCastException("StickyHeaderLayoutManager must be used with a RecyclerView where the adapter is a kind of SectioningAdapter");
        }
    }

    public final Parcelable e() {
        if (this.i != null) {
            return this.i;
        }
        if (this.b != null) {
            this.i();
        }
        Parcelable parcelable = new Parcelable(){
            public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>(){

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return new /* invalid duplicate definition of identical inner class */;
                }
            };
            int a;
            int b;
            {
                this.a = -1;
                this.b = 0;
            }
            {
                this.a = -1;
                this.b = 0;
                this.a = parcel.readInt();
                this.b = parcel.readInt();
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder("<");
                stringBuilder.append(this.getClass().getCanonicalName());
                stringBuilder.append(" firstViewAdapterPosition: ");
                stringBuilder.append(this.a);
                stringBuilder.append(" firstViewTop: ");
                stringBuilder.append(this.b);
                stringBuilder.append(">");
                return stringBuilder.toString();
            }

            public void writeToParcel(Parcel parcel, int n2) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b);
            }

        };
        parcelable.a = this.f;
        parcelable.b = this.g;
        return parcelable;
    }

    public final void e(int n2) {
        if (n2 >= 0 && n2 <= this.v()) {
            this.h = n2;
            this.i = null;
            this.l();
            return;
        }
        throw new IndexOutOfBoundsException("adapter position out of range");
    }

    public final boolean g() {
        return true;
    }

}

