/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.xiaomi.midrop.transmission.upgrade;

import java.util.ArrayList;
import java.util.List;

public final class a {
    public static List<String> a;

    static {
        ArrayList arrayList;
        a = arrayList = new ArrayList();
        arrayList.add((Object)"com.lenovo.anyshare.gps");
        a.add((Object)"cn.xender");
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        public static final /* enum */ a d = new a();
        public static final /* enum */ a e = new a();
        public static final /* enum */ a f = new a();
        private static final /* synthetic */ a[] g;

        static {
            a[] arra = new a[]{a, b, c, d, e, f};
            g = arra;
        }

        public static a a(int n2) {
            if (b.ordinal() == n2) {
                return b;
            }
            if (c.ordinal() == n2) {
                return c;
            }
            if (d.ordinal() == n2) {
                return d;
            }
            if (e.ordinal() == n2) {
                return e;
            }
            if (f.ordinal() == n2) {
                return f;
            }
            return a;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])g.clone();
        }

        public final String toString() {
            switch (1.a[this.ordinal()]) {
                default: {
                    return "undefined";
                }
                case 5: {
                    return "accepted";
                }
                case 4: {
                    return "rejected";
                }
                case 3: {
                    return "requesting";
                }
                case 2: {
                    return "upgradeApkList";
                }
                case 1: 
            }
            return "compareApkList";
        }
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b a = new b();
        public static final /* enum */ b b = new b();
        public static final /* enum */ b c = new b();
        private static final /* synthetic */ b[] d;

        static {
            b[] arrb = new b[]{a, b, c};
            d = arrb;
        }

        public static b valueOf(String string2) {
            return (b)Enum.valueOf(b.class, (String)string2);
        }

        public static b[] values() {
            return (b[])d.clone();
        }
    }

}

