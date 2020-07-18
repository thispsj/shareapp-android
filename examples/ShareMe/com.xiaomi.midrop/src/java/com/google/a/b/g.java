/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ObjectStreamException
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigDecimal
 */
package com.google.a.b;

import java.io.ObjectStreamException;
import java.math.BigDecimal;

public final class g
extends Number {
    private final String a;

    public g(String string2) {
        this.a = string2;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.a);
    }

    public final double doubleValue() {
        return Double.parseDouble((String)this.a);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof g) {
            g g2 = (g)((Object)object);
            if (this.a != g2.a) {
                return this.a.equals((Object)g2.a);
            }
            return true;
        }
        return false;
    }

    public final float floatValue() {
        return Float.parseFloat((String)this.a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final int intValue() {
        try {
            int n2 = Integer.parseInt((String)this.a);
            return n2;
        }
        catch (NumberFormatException numberFormatException) {
            long l2;
            try {
                l2 = Long.parseLong((String)this.a);
            }
            catch (NumberFormatException numberFormatException2) {
                return new BigDecimal(this.a).intValue();
            }
            return (int)l2;
        }
    }

    public final long longValue() {
        try {
            long l2 = Long.parseLong((String)this.a);
            return l2;
        }
        catch (NumberFormatException numberFormatException) {
            return new BigDecimal(this.a).longValue();
        }
    }

    public final String toString() {
        return this.a;
    }
}

