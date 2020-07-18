/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.globalmiuiapp.common.a;

import android.content.Context;

public final class a {
    public static a a;
    public final Context b;
    public final boolean c;
    public final String d;
    public final String e;
    public final String f;
    private final boolean g;

    private a(a a2) {
        this.b = a2.a;
        this.g = a2.b;
        this.c = a2.c;
        this.d = a2.d;
        this.e = a2.e;
        this.f = a2.f;
    }

    public /* synthetic */ a(a a2, byte by) {
        super(a2);
    }

    public static void a(a a2) {
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (a == null) {
                a = a2;
                if (a2.c) {
                    com.xiaomi.globalmiuiapp.common.e.a.a();
                }
            }
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return;
        }
    }

    public static final class a {
        public Context a;
        public boolean b;
        public boolean c;
        public String d;
        public String e;
        public String f;

        private a() {
        }

        public /* synthetic */ a(byte by) {
        }
    }

}

