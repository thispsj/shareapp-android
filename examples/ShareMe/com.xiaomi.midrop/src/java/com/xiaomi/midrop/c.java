/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 */
package com.xiaomi.midrop;

public final class c {

    public static final class a
    extends Enum<a> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d;

        static {
            int[] arrn = new int[]{a, b, c};
            d = arrn;
        }

        public static int a(int n) {
            int n2 = a;
            if (-1 + b == n) {
                return b;
            }
            if (-1 + c == n) {
                n2 = c;
            }
            return n2;
        }

        public static int[] a() {
            return (int[])d.clone();
        }
    }

}

