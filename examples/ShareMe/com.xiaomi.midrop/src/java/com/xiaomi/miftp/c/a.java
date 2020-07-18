/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.lang.Exception
 *  java.lang.Object
 */
package com.xiaomi.miftp.c;

import java.io.Closeable;

public final class a {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
                return;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

