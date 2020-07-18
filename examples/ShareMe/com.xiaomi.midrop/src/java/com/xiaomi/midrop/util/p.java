/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FilenameFilter
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.util;

import java.io.File;
import java.io.FilenameFilter;

public class p
implements FilenameFilter {
    public boolean accept(File file, String string2) {
        return !new File(string2).isHidden();
    }
}

