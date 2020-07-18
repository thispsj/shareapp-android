/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.math.BigInteger
 */
package com.google.a;

import com.google.a.b.a;
import com.google.a.b.g;
import com.google.a.i;
import java.math.BigInteger;

public final class n
extends i {
    private static final Class<?>[] b;
    public Object a;

    static {
        Class[] arrclass = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
        b = arrclass;
    }

    public n(Boolean bl) {
        n.super.a((Object)bl);
    }

    public n(Number number) {
        n.super.a((Object)number);
    }

    public n(String string2) {
        n.super.a(string2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(Object var1) {
        block11 : {
            block8 : {
                block5 : {
                    block10 : {
                        block9 : {
                            block7 : {
                                block6 : {
                                    if (!(var1 instanceof Character)) break block6;
                                    var1 = String.valueOf((char)((Character)var1).charValue());
                                    break block7;
                                }
                                if (var1 instanceof Number) break block8;
                                if (var1 instanceof String) break block9;
                                var3_3 = var1.getClass();
                                var4_4 = n.b;
                                var5_5 = var4_4.length;
                                break block10;
                            }
lbl12: // 2 sources:
                            do {
                                this.a = var1;
                                return;
                                break;
                            } while (true);
                        }
                        do {
                            var7_2 = true;
                            break block5;
                            break;
                        } while (true);
                    }
                    for (var6_6 = 0; var6_6 < var5_5; ++var6_6) {
                        if (var4_4[var6_6].isAssignableFrom(var3_3)) ** continue;
                    }
                    var7_2 = false;
                }
                var2_7 = false;
                if (!var7_2) break block11;
            }
            var2_7 = true;
        }
        a.a(var2_7);
        ** while (true)
    }

    private static boolean a(n n2) {
        if (n2.a instanceof Number) {
            Number number = (Number)n2.a;
            return number instanceof BigInteger || number instanceof Long || number instanceof Integer || number instanceof Short || number instanceof Byte;
            {
            }
        }
        return false;
    }

    @Override
    public final Number a() {
        if (this.a instanceof String) {
            return new g((String)this.a);
        }
        return (Number)this.a;
    }

    @Override
    public final String b() {
        if (this.a instanceof Number) {
            return this.a().toString();
        }
        if (this.a instanceof Boolean) {
            return ((Boolean)this.a).toString();
        }
        return (String)this.a;
    }

    @Override
    public final double c() {
        if (this.a instanceof Number) {
            return this.a().doubleValue();
        }
        return Double.parseDouble((String)this.b());
    }

    @Override
    public final long d() {
        if (this.a instanceof Number) {
            return this.a().longValue();
        }
        return Long.parseLong((String)this.b());
    }

    @Override
    public final int e() {
        if (this.a instanceof Number) {
            return this.a().intValue();
        }
        return Integer.parseInt((String)this.b());
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            n n2 = (n)object;
            if (this.a == null) {
                return n2.a == null;
            }
            if (n.a((n)this) && n.a(n2)) {
                return this.a().longValue() == n2.a().longValue();
            }
            if (this.a instanceof Number && n2.a instanceof Number) {
                double d2;
                double d3 = this.a().doubleValue();
                if (d3 != (d2 = n2.a().doubleValue())) {
                    return Double.isNaN((double)d3) && Double.isNaN((double)d2);
                }
                return true;
            }
            return this.a.equals(n2.a);
        }
        return false;
    }

    @Override
    public final boolean f() {
        if (this.a instanceof Boolean) {
            return (Boolean)this.a;
        }
        return Boolean.parseBoolean((String)this.b());
    }

    public final int hashCode() {
        if (this.a == null) {
            return 31;
        }
        if (n.a(this)) {
            long l2 = this.a().longValue();
            return (int)(l2 ^ l2 >>> 32);
        }
        if (this.a instanceof Number) {
            long l3 = Double.doubleToLongBits((double)this.a().doubleValue());
            return (int)(l3 ^ l3 >>> 32);
        }
        return this.a.hashCode();
    }
}

