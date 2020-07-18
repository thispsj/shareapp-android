/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Enum
 *  java.lang.Object
 */
package com.xiaomi.miftp.a;

import java.io.File;

public final class a {
    public File a;
    public int b;

    public a(File file, int n2) {
        this.a = file;
        this.b = n2;
    }

    public static final class a
    extends Enum<a> {
        public static final int a = 1;
        public static final int b = 2;
        private static final /* synthetic */ int[] c;

        static {
            int[] arrn = new int[]{a, b};
            c = arrn;
        }
    }

}

