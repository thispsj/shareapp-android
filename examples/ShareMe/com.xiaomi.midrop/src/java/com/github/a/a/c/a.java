/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.BitSet
 */
package com.github.a.a.c;

import java.util.BitSet;

public final class a {
    final BitSet a;
    final boolean b;

    public a(BitSet bitSet, boolean bl) {
        this.a = bitSet;
        this.b = bl;
    }

    public final a a() {
        BitSet bitSet = (BitSet)this.a.clone();
        bitSet.flip(0, 128);
        return new a(bitSet, true ^ this.b);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final String a(boolean var1) {
        var2_2 = new StringBuilder();
        var2_2.append('[');
        var4_3 = 0;
        do {
            block10 : {
                block13 : {
                    block11 : {
                        block12 : {
                            if (var4_3 >= 128) {
                                var2_2.append(" ]");
                                return var2_2.toString();
                            }
                            if (!this.a.get(var4_3)) break block10;
                            var6_6 = (char)var4_3;
                            if (var6_6 == '\r') break block11;
                            if (var6_6 == ' ') break block12;
                            switch (var6_6) {
                                default: {
                                    if (var4_3 >= 32) {
                                        var7_5 = null;
                                        if (var4_3 != 127) break;
                                    }
                                    if (!var1) {
                                        var11_4 = new StringBuilder("(");
                                        var11_4.append(var4_3);
                                        var11_4.append(")");
                                        var7_5 = var11_4.toString();
                                        ** break;
                                    }
                                    break block10;
                                }
                                case '\n': {
                                    var7_5 = "\\n";
                                    ** break;
                                }
                                case '\t': {
                                    var7_5 = "\\t";
                                    ** break;
lbl30: // 3 sources:
                                    break;
                                }
                            }
                            break block13;
                        }
                        var7_5 = "<space>";
                        break block13;
                    }
                    var7_5 = "\\r";
                }
                var2_2.append(' ');
                if (var7_5 == null) {
                    var2_2.append(var6_6);
                } else {
                    var2_2.append(var7_5);
                }
            }
            ++var4_3;
        } while (true);
    }

    public final boolean a(String string2) {
        for (int i2 = 0; i2 < string2.length(); ++i2) {
            char c2 = string2.charAt(i2);
            if (!(c2 >= '' ? !this.b : !this.a.get((int)c2))) continue;
            return false;
        }
        return true;
    }

    public final String toString() {
        return this.a(false);
    }

    public static final class a {
        boolean a;
        private final BitSet b;

        public a() {
            this.b = new BitSet(128);
            this.a = false;
        }

        public a(a a2) {
            this.b = (BitSet)a2.a.clone();
            this.a = a2.b;
        }

        private void a(String string2, boolean bl) {
            for (int i2 = 0; i2 < string2.length(); ++i2) {
                char c2 = string2.charAt(i2);
                this.b.set((int)c2, bl);
            }
        }

        public final a a() {
            this.b.set(0, 128);
            this.a = true;
            return this;
        }

        public final a a(char c2) {
            this.b.set((int)c2);
            return this;
        }

        public final a a(int n2, int n3) {
            this.b.set(n2, n3 + 1);
            return this;
        }

        public final a a(String string2) {
            a.super.a(string2, true);
            return this;
        }

        public final a b() {
            return this.a(32, 126);
        }

        public final a b(char c2) {
            this.b.set((int)c2, false);
            return this;
        }

        public final a b(String string2) {
            a.super.a(string2, false);
            return this;
        }

        public final a c() {
            return new a(this.b, this.a);
        }
    }

}

