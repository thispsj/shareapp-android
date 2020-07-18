/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Character
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 */
package com.xiaomi.globalmiuiapp.common.http;

import com.a.b.f;

public class NullPrimitiveAdapter {
    @f
    public boolean booleanFromJson(Boolean bl) {
        if (bl == null) {
            return false;
        }
        return bl;
    }

    @f
    public char charFromJson(Character c2) {
        if (c2 == null) {
            return '\u0000';
        }
        return c2.charValue();
    }

    @f
    public double doubleFromJson(Double d2) {
        if (d2 == null) {
            return 0.0;
        }
        return d2;
    }

    @f
    public float floatFromJson(Float f2) {
        if (f2 == null) {
            return 0.0f;
        }
        return f2.floatValue();
    }

    @f
    public int intFromJson(Integer n2) {
        if (n2 == null) {
            return 0;
        }
        return n2;
    }

    @f
    public long longFromJson(Long l2) {
        if (l2 == null) {
            return 0L;
        }
        return l2;
    }

    @f
    public short shortFromJson(Short s2) {
        if (s2 == null) {
            return 0;
        }
        return s2;
    }
}

