/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Environment
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.b.a;

import android.os.Environment;
import java.io.File;

public final class h {
    public static String a;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
        stringBuilder.append(File.separator);
        stringBuilder.append("GloHounyChang");
        a = stringBuilder.toString();
    }
}

