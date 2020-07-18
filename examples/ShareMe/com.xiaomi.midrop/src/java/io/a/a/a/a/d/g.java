/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.a.a.a.a.d.h
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.String
 *  java.util.zip.GZIPOutputStream
 */
package io.a.a.a.a.d;

import android.content.Context;
import io.a.a.a.a.d.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public final class g
extends h {
    public g(Context context, File file, String string2, String string3) throws IOException {
        super(context, file, string2, string3);
    }

    public final OutputStream a(File file) throws IOException {
        return new GZIPOutputStream((OutputStream)new FileOutputStream(file));
    }
}

