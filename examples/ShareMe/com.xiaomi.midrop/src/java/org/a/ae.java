/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 */
package org.a;

import android.content.Context;
import java.io.File;
import org.a.ac;
import org.a.ag;

public final class ae {
    private static String a;
    private static File b;
    private static ag c;
    private static Context d;

    static {
        b = new File(ac.c);
    }

    static ag a() {
        if (c != null && !c.isAlive()) {
            return null;
        }
        return c;
    }

    public static void a(Context context) {
        d = context;
    }

    public static void a(File file) {
        if (file.isDirectory()) {
            b = file;
        }
    }

    public static void a(ag ag2) {
        c = ag2;
    }

    static File b() {
        return b;
    }

    public static String c() {
        return a;
    }

    public static void d() {
        a = null;
    }

    public static Context e() {
        return d;
    }
}

