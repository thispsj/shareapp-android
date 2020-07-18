/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.NoSuchElementException
 */
package a.i;

import a.e.a.m;
import a.e.b.d;
import a.f;
import a.f.c;
import a.h.h;
import a.i;
import a.i.e;
import a.i.g;
import a.i.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class p
extends o {
    public static /* synthetic */ int a(CharSequence charSequence, int n2, int n3) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        d.b((Object)charSequence, "receiver$0");
        boolean bl = charSequence instanceof String;
        if (!bl) {
            int n4;
            char[] arrc = new char[]{'.'};
            d.b((Object)charSequence, "receiver$0");
            d.b(arrc, "chars");
            if (bl) {
                d.b(arrc, "receiver$0");
                char c2 = arrc[0];
                return ((String)charSequence).indexOf((int)c2, n2);
            }
            int n5 = a.f.d.a(n2, 0);
            if (n5 <= (n4 = g.c(charSequence))) {
                do {
                    boolean bl2;
                    block7 : {
                        char c3 = charSequence.charAt(n5);
                        for (int i2 = 0; i2 <= 0; ++i2) {
                            if (!a.i.a.a(arrc[i2], c3, false)) continue;
                            bl2 = true;
                            break block7;
                        }
                        bl2 = false;
                    }
                    if (bl2) {
                        return n5;
                    }
                    if (n5 == n4) break;
                    ++n5;
                } while (true);
            }
            return -1;
        }
        return ((String)charSequence).indexOf(46, n2);
    }

    public static final int a(CharSequence charSequence, CharSequence charSequence2, int n2, int n3, boolean bl, boolean bl2) {
        a.f.a a2;
        if (!bl2) {
            a2 = new c(a.f.d.a(n2, 0), a.f.d.b(n3, charSequence.length()));
        } else {
            int n4 = a.f.d.b(n2, g.c(charSequence));
            int n5 = a.f.d.a(n3, 0);
            a2 = new a.f.a(n4, n5, -1);
        }
        if (charSequence instanceof String && charSequence2 instanceof String) {
            int n6 = a2.a;
            int n7 = a2.b;
            int n8 = a2.c;
            if (n8 > 0 ? n6 <= n7 : n6 >= n7) {
                do {
                    if (g.a((String)charSequence2, (String)charSequence, n6, charSequence2.length(), false)) {
                        return n6;
                    }
                    if (n6 != n7) {
                        n6 += n8;
                        continue;
                    }
                    break;
                } while (true);
            }
        } else {
            int n9 = a2.a;
            int n10 = a2.b;
            int n11 = a2.c;
            if (n11 > 0 ? n9 <= n10 : n9 >= n10) {
                do {
                    if (g.a(charSequence2, charSequence, n9, charSequence2.length(), false)) {
                        return n9;
                    }
                    if (n9 == n10) break;
                    n9 += n11;
                } while (true);
            }
        }
        return -1;
    }

    public static final int a(CharSequence charSequence, String string, int n2) {
        d.b((Object)charSequence, "receiver$0");
        d.b(string, "string");
        if (!(charSequence instanceof String)) {
            return p.a(charSequence, (CharSequence)string, n2, charSequence.length(), false, false);
        }
        return ((String)charSequence).indexOf(string, n2);
    }

    public static /* synthetic */ int a(CharSequence charSequence, String string, int n2, int n3) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        return g.a(charSequence, string, n2);
    }

    static /* synthetic */ a.h.b a(CharSequence charSequence, String[] arrstring) {
        return new e(charSequence, (m<? super CharSequence, ? super Integer, f<Integer, Integer>>)new m<CharSequence, Integer, f<? extends Integer, ? extends Integer>>(a.a.a.a(arrstring)){
            final /* synthetic */ List a;
            final /* synthetic */ boolean b;
            {
                this.a = list;
                this.b = false;
                super(2);
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            @Override
            public final /* synthetic */ Object a(Object var1, Object var2_2) {
                block14 : {
                    block13 : {
                        block21 : {
                            block20 : {
                                block19 : {
                                    block16 : {
                                        block18 : {
                                            block17 : {
                                                var3_3 = (CharSequence)var1;
                                                var4_4 = ((Number)var2_2).intValue();
                                                d.b((Object)var3_3, "receiver$0");
                                                var5_5 = (Collection)this.a;
                                                var6_6 = this.b;
                                                if (var6_6 || var5_5.size() != 1) break block16;
                                                var21_7 = (Iterable)var5_5;
                                                d.b((Object)var21_7, "receiver$0");
                                                if (!(var21_7 instanceof List)) break block17;
                                                var27_8 = (List)var21_7;
                                                d.b((Object)var27_8, "receiver$0");
                                                switch (var27_8.size()) {
                                                    default: {
                                                        throw (Throwable)new IllegalArgumentException("List has more than one element.");
                                                    }
                                                    case 1: {
                                                        var24_9 = var27_8.get(0);
                                                        break block18;
                                                    }
                                                    case 0: {
                                                        throw (Throwable)new NoSuchElementException("List is empty.");
                                                    }
                                                }
                                            }
                                            var22_10 = var21_7.iterator();
                                            if (!var22_10.hasNext()) {
                                                throw (Throwable)new NoSuchElementException("Collection is empty.");
                                            }
                                            var23_11 = var22_10.next();
                                            if (var22_10.hasNext()) {
                                                throw (Throwable)new IllegalArgumentException("Collection has more than one element.");
                                            }
                                            var24_9 = var23_11;
                                        }
                                        var25_12 = (String)var24_9;
                                        var26_13 = g.a(var3_3, var25_12, var4_4, 4);
                                        if (var26_13 < 0) break block13;
                                        var11_14 = i.a((int)var26_13, var25_12);
                                        break block14;
                                    }
                                    var7_15 = new c(a.f.d.a(var4_4, 0), var3_3.length());
                                    if (!(var3_3 instanceof String)) break block19;
                                    var8_16 = var7_15.a;
                                    var16_17 = var7_15.b;
                                    var17_18 = var7_15.c;
                                    if (!(var17_18 > 0 ? var8_16 <= var16_17 : var8_16 >= var16_17)) break block13;
                                    break block20;
                                }
                                var8_16 = var7_15.a;
                                var9_23 = var7_15.b;
                                var10_24 = var7_15.c;
                                if (!(var10_24 > 0 ? var8_16 <= var9_23 : var8_16 >= var9_23)) break block13;
                                break block21;
                            }
                            do {
                                block12 : {
                                    for (Object var19_19 : (Iterable)var5_5) {
                                        var20_22 = (String)var19_19;
                                        if (!g.a(var20_22, (String)var3_3, var8_16, var20_22.length(), var6_6)) continue;
                                        break block12;
                                    }
                                    var19_19 = null;
                                }
                                var14_21 = (String)var19_19;
                                if (var14_21 != null) break;
                                if (var8_16 != var16_17) {
                                    var8_16 += var17_18;
                                    continue;
                                }
                                break block13;
                                break;
                            } while (true);
                            do {
                                var11_14 = i.a((int)var8_16, var14_21);
                                break block14;
                                break;
                            } while (true);
                        }
                        do {
                            block15 : {
                                for (Object var13_25 : (Iterable)var5_5) {
                                    var15_26 = (String)var13_25;
                                    if (!g.a(var15_26, var3_3, var8_16, var15_26.length(), var6_6)) continue;
                                    break block15;
                                }
                                var13_25 = null;
                            }
                            if ((var14_21 = (String)var13_25) != null) ** continue;
                            if (var8_16 == var9_23) break;
                            var8_16 += var10_24;
                        } while (true);
                    }
                    var11_14 = null;
                }
                if (var11_14 == null) return null;
                return i.a(var11_14.a, (int)((String)var11_14.b).length());
            }
        });
    }

    public static final String a(CharSequence charSequence, c c2) {
        d.b((Object)charSequence, "receiver$0");
        d.b(c2, "range");
        return charSequence.subSequence(Integer.valueOf((int)c2.a).intValue(), 1 + Integer.valueOf((int)c2.b)).toString();
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, CharSequence charSequence2) {
        d.b((Object)charSequence, "receiver$0");
        d.b((Object)charSequence2, "other");
        if (charSequence2 instanceof String) {
            return g.a(charSequence, (String)charSequence2, 0, 2) >= 0;
        }
        return p.a(charSequence, charSequence2, 0, charSequence.length(), false, false) >= 0;
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, int n2, int n3, boolean bl) {
        d.b((Object)charSequence, "receiver$0");
        d.b((Object)charSequence2, "other");
        if (n2 >= 0 && charSequence.length() - n3 >= 0) {
            if (n2 > charSequence2.length() - n3) {
                return false;
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                if (a.i.a.a(charSequence.charAt(i2 + 0), charSequence2.charAt(n2 + i2), bl)) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public static final CharSequence b(CharSequence charSequence) {
        d.b((Object)charSequence, "receiver$0");
        int n2 = charSequence.length() - 1;
        int n3 = 0;
        boolean bl = false;
        while (n3 <= n2) {
            int n4 = !bl ? n3 : n2;
            boolean bl2 = a.i.a.a(charSequence.charAt(n4));
            if (!bl) {
                if (!bl2) {
                    bl = true;
                    continue;
                }
                ++n3;
                continue;
            }
            if (!bl2) break;
            --n2;
        }
        return charSequence.subSequence(n3, n2 + 1);
    }

    public static /* synthetic */ List b(CharSequence charSequence, String[] arrstring) {
        d.b((Object)charSequence, "receiver$0");
        d.b(arrstring, "delimiters");
        int n2 = 0;
        String string = arrstring[0];
        boolean bl = ((CharSequence)string).length() == 0;
        if (!bl) {
            int n3 = g.a(charSequence, string, 0);
            if (n3 == -1) {
                return a.a.f.a(charSequence.toString());
            }
            ArrayList arrayList = new ArrayList(10);
            do {
                arrayList.add((Object)charSequence.subSequence(n2, n3).toString());
                n2 = n3 + string.length();
            } while ((n3 = g.a(charSequence, string, n2)) != -1);
            arrayList.add((Object)charSequence.subSequence(n2, charSequence.length()).toString());
            return (List)arrayList;
        }
        a.h.b b2 = p.a(charSequence, arrstring);
        d.b(b2, "receiver$0");
        Iterable iterable = new Iterable<T>(b2){
            final /* synthetic */ a.h.b a;
            {
                this.a = b2;
            }

            public final Iterator<T> iterator() {
                return this.a.a();
            }
        };
        Collection collection = (Collection)new ArrayList(a.a.f.a(iterable));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            collection.add((Object)g.a(charSequence, (c)iterator.next()));
        }
        return (List)collection;
    }

    public static final int c(CharSequence charSequence) {
        d.b((Object)charSequence, "receiver$0");
        return -1 + charSequence.length();
    }

}

