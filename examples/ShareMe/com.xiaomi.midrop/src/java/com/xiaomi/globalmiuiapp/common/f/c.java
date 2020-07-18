/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.globalmiuiapp.common.f;

public final class c {
    public static final int a(String string2) {
        try {
            int n2 = Integer.parseInt((String)string2);
            return n2;
        }
        catch (Exception exception) {
            return 0;
        }
    }
}

