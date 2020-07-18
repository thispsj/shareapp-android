/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Double
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.a.b;

import c.c;
import c.e;
import c.f;
import c.m;
import com.a.b.i;
import com.a.b.j;
import com.a.b.l;
import java.io.EOFException;
import java.io.IOException;

final class n
extends l {
    private static final f g = f.a("'\\");
    private static final f h = f.a("\"\\");
    private static final f i = f.a("{}[]:, \n\t\r\f/\\;#=");
    private static final f j = f.a("\n\r");
    private final e k;
    private final c l;
    private int m = 0;
    private long n;
    private int o;
    private String p;

    n(e e2) {
        if (e2 == null) {
            throw new NullPointerException("source == null");
        }
        this.k = e2;
        this.l = e2.b();
        this.a(6);
    }

    private int a(String string2, l.a a2) {
        int n2 = a2.a.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string2.equals((Object)a2.a[i2])) continue;
            this.m = 0;
            this.c[-1 + this.a] = string2;
            return i2;
        }
        return -1;
    }

    private int a(boolean bl) throws IOException {
        block0 : do {
            int n2 = 0;
            int n3;
            e e2;
            while ((e2 = this.k).b(n3 = n2 + 1)) {
                block12 : {
                    byte by;
                    block16 : {
                        block15 : {
                            block13 : {
                                boolean bl2;
                                block11 : {
                                    block14 : {
                                        by = this.l.c((long)n2);
                                        if (by == 10 || by == 32 || by == 13 || by == 9) break block12;
                                        this.l.i((long)(n3 - 1));
                                        if (by != 47) break block13;
                                        if (!this.k.b(2L)) {
                                            return by;
                                        }
                                        n.super.w();
                                        byte by2 = this.l.c(1L);
                                        if (by2 == 42) break block14;
                                        if (by2 != 47) {
                                            return by;
                                        }
                                        this.l.e();
                                        this.l.e();
                                        break block15;
                                    }
                                    this.l.e();
                                    this.l.e();
                                    block2 : while (this.k.b("*/".length())) {
                                        for (int i2 = 0; i2 < "*/".length(); ++i2) {
                                            if (this.l.c((long)i2) == "*/".charAt(i2)) continue;
                                            this.l.e();
                                            continue block2;
                                        }
                                        bl2 = true;
                                        break block11;
                                    }
                                    bl2 = false;
                                }
                                if (!bl2) {
                                    throw this.a("Unterminated comment");
                                }
                                this.l.e();
                                this.l.e();
                                continue block0;
                            }
                            if (by != 35) break block16;
                            n.super.w();
                        }
                        n.super.x();
                        continue block0;
                    }
                    return by;
                }
                n2 = n3;
            }
            break;
        } while (true);
        if (bl) {
            throw new EOFException("End of input");
        }
        return -1;
    }

    private String a(f f2) throws IOException {
        long l2;
        StringBuilder stringBuilder = null;
        do {
            if ((l2 = this.k.b(f2)) == -1L) {
                throw this.a("Unterminated string");
            }
            if (this.l.c(l2) != 92) break;
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder();
            }
            stringBuilder.append(this.l.e(l2));
            this.l.e();
            stringBuilder.append(n.super.y());
        } while (true);
        if (stringBuilder == null) {
            String string2 = this.l.e(l2);
            this.l.e();
            return string2;
        }
        stringBuilder.append(this.l.e(l2));
        this.l.e();
        return stringBuilder.toString();
    }

    private int b(String string2, l.a a2) {
        int n2 = a2.a.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string2.equals((Object)a2.a[i2])) continue;
            this.m = 0;
            int[] arrn = this.d;
            int n3 = -1 + this.a;
            arrn[n3] = 1 + arrn[n3];
            return i2;
        }
        return -1;
    }

    private void b(f f2) throws IOException {
        long l2;
        do {
            if ((l2 = this.k.b(f2)) == -1L) {
                throw this.a("Unterminated string");
            }
            if (this.l.c(l2) != 92) break;
            this.l.i(l2 + 1L);
            n.super.y();
        } while (true);
        this.l.i(l2 + 1L);
    }

    private boolean b(int n2) throws IOException {
        switch (n2) {
            default: {
                return true;
            }
            case 35: 
            case 47: 
            case 59: 
            case 61: 
            case 92: {
                n.super.w();
            }
            case 9: 
            case 10: 
            case 12: 
            case 13: 
            case 32: 
            case 44: 
            case 58: 
            case 91: 
            case 93: 
            case 123: 
            case 125: 
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int r() throws IOException {
        block31 : {
            block32 : {
                block33 : {
                    block27 : {
                        block24 : {
                            block30 : {
                                block26 : {
                                    block29 : {
                                        block28 : {
                                            block25 : {
                                                block23 : {
                                                    var1_1 = this.b[this.a - 1];
                                                    if (var1_1 != 1) break block23;
                                                    this.b[this.a - 1] = 2;
                                                    break block24;
                                                }
                                                if (var1_1 != 2) break block25;
                                                var20_2 = this.a(true);
                                                this.l.e();
                                                if (var20_2 == 44) break block24;
                                                if (var20_2 != 59) {
                                                    if (var20_2 != 93) {
                                                        throw this.a("Unterminated array");
                                                    }
                                                    this.m = 4;
                                                    return 4;
                                                }
                                                break block26;
                                            }
                                            if (var1_1 == 3 || var1_1 == 5) break block27;
                                            if (var1_1 != 4) break block28;
                                            this.b[this.a - 1] = 5;
                                            var17_3 = this.a(true);
                                            this.l.e();
                                            if (var17_3 != 58) {
                                                if (var17_3 != 61) {
                                                    throw this.a("Expected ':'");
                                                }
                                                this.w();
                                                if (this.k.b(1L) && this.l.c(0L) == 62) {
                                                    this.l.e();
                                                }
                                            }
                                            break block24;
                                        }
                                        if (var1_1 != 6) break block29;
                                        this.b[this.a - 1] = 7;
                                        break block24;
                                    }
                                    if (var1_1 != 7) break block30;
                                    if (this.a(false) != -1) break block26;
                                    var4_4 = 18;
                                    break block31;
                                }
                                this.w();
                                break block24;
                            }
                            if (var1_1 == 8) {
                                throw new IllegalStateException("JsonReader is closed");
                            }
                        }
                        var9_5 = this.a(true);
                        if (var9_5 == 34) ** GOTO lbl82
                        if (var9_5 == 39) {
                            this.w();
                            this.l.e();
                            this.m = 8;
                            return 8;
                        }
                        if (var9_5 == 44 || var9_5 == 59) ** GOTO lbl77
                        if (var9_5 == 91) {
                            this.l.e();
                            this.m = 3;
                            return 3;
                        }
                        if (var9_5 != 93) {
                            if (var9_5 == 123) {
                                this.l.e();
                                this.m = 1;
                                return 1;
                            }
                            var15_6 = this.s();
                            if (var15_6 != 0) {
                                return var15_6;
                            }
                            var16_7 = this.t();
                            if (var16_7 != 0) {
                                return var16_7;
                            }
                            if (!this.b(this.l.c(0L))) {
                                throw this.a("Expected value");
                            }
                            this.w();
                            var4_4 = 10;
                        } else {
                            if (var1_1 == 1) {
                                this.l.e();
                                this.m = 4;
                                return 4;
                            }
lbl77: // 3 sources:
                            if (var1_1 != 1) {
                                if (var1_1 != 2) throw this.a("Unexpected value");
                            }
                            this.w();
                            this.m = 7;
                            return 7;
lbl82: // 1 sources:
                            this.l.e();
                            var4_4 = 9;
                        }
                        break block31;
                    }
                    this.b[this.a - 1] = 4;
                    if (var1_1 != 5) break block32;
                    var7_8 = this.a(true);
                    this.l.e();
                    if (var7_8 == 44) break block32;
                    if (var7_8 == 59) break block33;
                    if (var7_8 != 125) {
                        throw this.a("Unterminated object");
                    }
                    ** GOTO lbl107
                }
                this.w();
            }
            if ((var2_9 = this.a(true)) != 34) {
                if (var2_9 != 39) {
                    if (var2_9 != 125) {
                        this.w();
                        if (this.b((char)var2_9) == false) throw this.a("Expected name");
                        var4_4 = 14;
                    } else {
                        if (var1_1 == 5) throw this.a("Expected name");
                        this.l.e();
lbl107: // 2 sources:
                        var4_4 = 2;
                    }
                } else {
                    this.l.e();
                    this.w();
                    var4_4 = 12;
                }
            } else {
                this.l.e();
                var4_4 = 13;
            }
        }
        this.m = var4_4;
        return var4_4;
    }

    private int s() throws IOException {
        String string2;
        int n2;
        String string3;
        byte by = this.l.c(0L);
        if (by != 116 && by != 84) {
            if (by != 102 && by != 70) {
                if (by != 110 && by != 78) {
                    return 0;
                }
                string2 = "null";
                string3 = "NULL";
                n2 = 7;
            } else {
                string2 = "false";
                string3 = "FALSE";
                n2 = 6;
            }
        } else {
            string2 = "true";
            string3 = "TRUE";
            n2 = 5;
        }
        int n3 = string2.length();
        int n4 = 1;
        while (n4 < n3) {
            e e2 = this.k;
            int n5 = n4 + 1;
            if (!e2.b(n5)) {
                return 0;
            }
            byte by2 = this.l.c((long)n4);
            if (by2 != string2.charAt(n4) && by2 != string3.charAt(n4)) {
                return 0;
            }
            n4 = n5;
        }
        if (this.k.b(n3 + 1) && this.b(this.l.c((long)n3))) {
            return 0;
        }
        this.l.i((long)n3);
        this.m = n2;
        return n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int t() throws IOException {
        var3_2 = var1_1 = 0L;
        var5_3 = 0;
        var6_4 = 0;
        var7_5 = true;
        var8_6 = false;
        block4 : while ((var9_8 = this.k).b(var10_10 = var5_3 + 1)) {
            block20 : {
                block21 : {
                    block18 : {
                        block19 : {
                            var12_9 = this.l.c((long)var5_3);
                            if (var12_9 == 43) break block18;
                            if (var12_9 == 69 || var12_9 == 101) break block19;
                            switch (var12_9) {
                                default: {
                                    if (var12_9 < 48 || var12_9 > 57) ** GOTO lbl31
                                    if (var6_4 != 1 && var6_4 != 0) {
                                        if (var6_4 == 2) {
                                            if (var3_2 == var1_1) {
                                                return 0;
                                            }
                                            var13_7 = 10L * var3_2 - (long)(var12_9 - 48);
                                            var15_11 = var3_2 > -922337203685477580L || var3_2 == -922337203685477580L && var13_7 < var3_2;
                                            var7_5 = var15_11 & var7_5;
                                            var3_2 = var13_7;
                                        } else if (var6_4 == 3) {
                                            var6_4 = 4;
                                        } else if (var6_4 == 5 || var6_4 == 6) {
                                            var6_4 = 7;
                                        }
                                    } else {
                                        var3_2 = -(var12_9 - 48);
                                        var6_4 = 2;
                                    }
                                    break block20;
lbl31: // 1 sources:
                                    if (!this.b(var12_9)) break block4;
                                    return 0;
                                }
                                case 46: {
                                    if (var6_4 != 2) return 0;
                                    var6_4 = 3;
                                    break block20;
                                }
                                case 45: {
                                    if (var6_4 != 0) ** GOTO lbl42
                                    var6_4 = 1;
                                    var8_6 = true;
                                    break block20;
lbl42: // 1 sources:
                                    if (var6_4 != 5) return 0;
                                    break;
                                }
                            }
                            break block21;
                        }
                        if (var6_4 != 2) {
                            if (var6_4 != 4) return 0;
                        }
                        var6_4 = 5;
                        break block20;
                    }
                    if (var6_4 != 5) return 0;
                }
                var6_4 = 6;
            }
            var5_3 = var10_10;
            var1_1 = 0L;
        }
        if (var6_4 == 2 && var7_5 && (var3_2 != Long.MIN_VALUE || var8_6)) {
            if (!var8_6) {
                var3_2 = -var3_2;
            }
            this.n = var3_2;
            this.l.i((long)var5_3);
            var11_12 = 16;
        } else {
            if (var6_4 != 2 && var6_4 != 4) {
                if (var6_4 != 7) return 0;
            }
            this.o = var5_3;
            var11_12 = 17;
        }
        this.m = var11_12;
        return var11_12;
    }

    private String u() throws IOException {
        long l2 = this.k.b(i);
        if (l2 != -1L) {
            return this.l.e(l2);
        }
        return this.l.m();
    }

    private void v() throws IOException {
        long l2 = this.k.b(i);
        c c2 = this.l;
        if (l2 == -1L) {
            l2 = this.l.b;
        }
        c2.i(l2);
    }

    private void w() throws IOException {
        if (!this.e) {
            throw this.a("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void x() throws IOException {
        long l2 = this.k.b(j);
        c c2 = this.l;
        long l3 = l2 != -1L ? l2 + 1L : this.l.b;
        c2.i(l3);
    }

    /*
     * Enabled aggressive block sorting
     */
    private char y() throws IOException {
        if (!this.k.b(1L)) {
            throw this.a("Unterminated escape sequence");
        }
        byte by = this.l.e();
        if (by != 10 && by != 34 && by != 39 && by != 47 && by != 92) {
            if (by == 98) {
                return '\b';
            }
            if (by == 102) {
                return '\f';
            }
            if (by == 110) {
                return '\n';
            }
            if (by == 114) {
                return '\r';
            }
            switch (by) {
                default: {
                    if (!this.e) {
                        StringBuilder stringBuilder = new StringBuilder("Invalid escape sequence: \\");
                        stringBuilder.append((char)by);
                        throw this.a(stringBuilder.toString());
                    }
                    return (char)by;
                }
                case 117: {
                    if (!this.k.b(4L)) {
                        StringBuilder stringBuilder = new StringBuilder("Unterminated escape sequence at path ");
                        stringBuilder.append(this.p());
                        throw new EOFException(stringBuilder.toString());
                    }
                    int n2 = 0;
                    char c2 = '\u0000';
                    do {
                        int n3;
                        if (n2 >= 4) {
                            this.l.i(4L);
                            return c2;
                        }
                        byte by2 = this.l.c((long)n2);
                        char c3 = (char)(c2 << 4);
                        if (by2 >= 48 && by2 <= 57) {
                            n3 = by2 - 48;
                        } else {
                            int n4;
                            if (by2 >= 97 && by2 <= 102) {
                                n4 = by2 - 97;
                            } else {
                                if (by2 < 65 || by2 > 70) break;
                                n4 = by2 - 65;
                            }
                            n3 = n4 + 10;
                        }
                        c2 = (char)(c3 + n3);
                        ++n2;
                    } while (true);
                    StringBuilder stringBuilder = new StringBuilder("\\u");
                    stringBuilder.append(this.l.e(4L));
                    throw this.a(stringBuilder.toString());
                }
                case 116: 
            }
            return '\t';
        }
        return (char)by;
    }

    @Override
    public final int a(l.a a2) throws IOException {
        int n2 = this.m;
        if (n2 == 0) {
            n2 = n.super.r();
        }
        if (n2 >= 12) {
            if (n2 > 15) {
                return -1;
            }
            if (n2 == 15) {
                return n.super.a(this.p, a2);
            }
            int n3 = this.k.a(a2.b);
            if (n3 != -1) {
                this.m = 0;
                this.c[-1 + this.a] = a2.a[n3];
                return n3;
            }
            String string2 = this.c[-1 + this.a];
            String string3 = this.g();
            int n4 = n.super.a(string3, a2);
            if (n4 == -1) {
                this.m = 15;
                this.p = string3;
                this.c[-1 + this.a] = string2;
            }
            return n4;
        }
        return -1;
    }

    @Override
    public final void a() throws IOException {
        int n2 = this.m;
        if (n2 == 0) {
            n2 = this.r();
        }
        if (n2 == 3) {
            this.a(1);
            this.d[this.a - 1] = 0;
            this.m = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected BEGIN_ARRAY but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.p());
        throw new i(stringBuilder.toString());
    }

    @Override
    public final int b(l.a a2) throws IOException {
        int n2 = this.m;
        if (n2 == 0) {
            n2 = n.super.r();
        }
        if (n2 >= 8) {
            if (n2 > 11) {
                return -1;
            }
            if (n2 == 11) {
                return n.super.b(this.p, a2);
            }
            int n3 = this.k.a(a2.b);
            if (n3 != -1) {
                this.m = 0;
                int[] arrn = this.d;
                int n4 = -1 + this.a;
                arrn[n4] = 1 + arrn[n4];
                return n3;
            }
            String string2 = this.h();
            int n5 = n.super.b(string2, a2);
            if (n5 == -1) {
                this.m = 11;
                this.p = string2;
                int[] arrn = this.d;
                int n6 = -1 + this.a;
                arrn[n6] = -1 + arrn[n6];
            }
            return n5;
        }
        return -1;
    }

    @Override
    public final void b() throws IOException {
        int n2 = this.m;
        if (n2 == 0) {
            n2 = this.r();
        }
        if (n2 == 4) {
            this.a = -1 + this.a;
            int[] arrn = this.d;
            int n3 = -1 + this.a;
            arrn[n3] = 1 + arrn[n3];
            this.m = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected END_ARRAY but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.p());
        throw new i(stringBuilder.toString());
    }

    @Override
    public final void c() throws IOException {
        int n2 = this.m;
        if (n2 == 0) {
            n2 = this.r();
        }
        if (n2 == 1) {
            this.a(3);
            this.m = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected BEGIN_OBJECT but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.p());
        throw new i(stringBuilder.toString());
    }

    public final void close() throws IOException {
        this.m = 0;
        this.b[0] = 8;
        this.a = 1;
        this.l.p();
        this.k.close();
    }

    @Override
    public final void d() throws IOException {
        int n2 = this.m;
        if (n2 == 0) {
            n2 = this.r();
        }
        if (n2 == 2) {
            this.a = -1 + this.a;
            this.c[this.a] = null;
            int[] arrn = this.d;
            int n3 = -1 + this.a;
            arrn[n3] = 1 + arrn[n3];
            this.m = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected END_OBJECT but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.p());
        throw new i(stringBuilder.toString());
    }

    @Override
    public final boolean e() throws IOException {
        int n2 = this.m;
        if (n2 == 0) {
            n2 = this.r();
        }
        return n2 != 2 && n2 != 4;
    }

    @Override
    public final l.b f() throws IOException {
        int n2 = this.m;
        if (n2 == 0) {
            n2 = this.r();
        }
        switch (n2) {
            default: {
                throw new AssertionError();
            }
            case 18: {
                return l.b.j;
            }
            case 16: 
            case 17: {
                return l.b.g;
            }
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                return l.b.e;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                return l.b.f;
            }
            case 7: {
                return l.b.i;
            }
            case 5: 
            case 6: {
                return l.b.h;
            }
            case 4: {
                return l.b.b;
            }
            case 3: {
                return l.b.a;
            }
            case 2: {
                return l.b.d;
            }
            case 1: 
        }
        return l.b.c;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public final String g() throws IOException {
        block5 : {
            block6 : {
                block4 : {
                    var1_1 = this.m;
                    if (var1_1 == 0) {
                        var1_1 = this.r();
                    }
                    if (var1_1 != 14) break block4;
                    var6_2 = this.u();
                    break block5;
                }
                if (var1_1 != 13) break block6;
                var7_3 = n.h;
                ** GOTO lbl14
            }
            if (var1_1 == 12) {
                var7_3 = n.g;
lbl14: // 2 sources:
                var6_2 = this.a(var7_3);
            } else {
                if (var1_1 != 15) {
                    var2_4 = new StringBuilder("Expected a name but was ");
                    var2_4.append((Object)this.f());
                    var2_4.append(" at path ");
                    var2_4.append(this.p());
                    throw new i(var2_4.toString());
                }
                var6_2 = this.p;
            }
        }
        this.m = 0;
        this.c[-1 + this.a] = var6_2;
        return var6_2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public final String h() throws IOException {
        block9 : {
            block10 : {
                block8 : {
                    var1_1 = this.m;
                    if (var1_1 == 0) {
                        var1_1 = this.r();
                    }
                    if (var1_1 != 10) break block8;
                    var6_2 = this.u();
                    break block9;
                }
                if (var1_1 != 9) break block10;
                var9_3 = n.h;
                ** GOTO lbl14
            }
            if (var1_1 == 8) {
                var9_3 = n.g;
lbl14: // 2 sources:
                var6_2 = this.a(var9_3);
            } else if (var1_1 == 11) {
                var6_2 = this.p;
                this.p = null;
            } else if (var1_1 == 16) {
                var6_2 = Long.toString((long)this.n);
            } else {
                if (var1_1 != 17) {
                    var2_6 = new StringBuilder("Expected a string but was ");
                    var2_6.append((Object)this.f());
                    var2_6.append(" at path ");
                    var2_6.append(this.p());
                    throw new i(var2_6.toString());
                }
                var6_2 = this.l.e((long)this.o);
            }
        }
        this.m = 0;
        var7_4 = this.d;
        var8_5 = -1 + this.a;
        var7_4[var8_5] = 1 + var7_4[var8_5];
        return var6_2;
    }

    @Override
    public final boolean i() throws IOException {
        int n2 = this.m;
        if (n2 == 0) {
            n2 = this.r();
        }
        if (n2 == 5) {
            this.m = 0;
            int[] arrn = this.d;
            int n3 = this.a - 1;
            arrn[n3] = 1 + arrn[n3];
            return true;
        }
        if (n2 == 6) {
            this.m = 0;
            int[] arrn = this.d;
            int n4 = this.a - 1;
            arrn[n4] = 1 + arrn[n4];
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected a boolean but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.p());
        throw new i(stringBuilder.toString());
    }

    @Override
    public final <T> T j() throws IOException {
        int n2 = this.m;
        if (n2 == 0) {
            n2 = this.r();
        }
        if (n2 == 7) {
            this.m = 0;
            int[] arrn = this.d;
            int n3 = -1 + this.a;
            arrn[n3] = 1 + arrn[n3];
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected null but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(" at path ");
        stringBuilder.append(this.p());
        throw new i(stringBuilder.toString());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public final double k() throws IOException {
        block11 : {
            block10 : {
                block9 : {
                    block8 : {
                        var1_1 = this.m;
                        if (var1_1 == 0) {
                            var1_1 = this.r();
                        }
                        if (var1_1 == 16) {
                            this.m = 0;
                            var20_2 = this.d;
                            var21_3 = -1 + this.a;
                            var20_2[var21_3] = 1 + var20_2[var21_3];
                            return this.n;
                        }
                        if (var1_1 != 17) break block8;
                        var18_4 = this.l.e((long)this.o);
                        ** GOTO lbl26
                    }
                    if (var1_1 != 9) break block9;
                    var19_5 = n.h;
                    break block10;
                }
                if (var1_1 != 8) break block11;
                var19_5 = n.g;
            }
            var18_4 = this.a(var19_5);
            ** GOTO lbl26
        }
        if (var1_1 == 10) {
            var18_4 = this.u();
lbl26: // 3 sources:
            this.p = var18_4;
        } else if (var1_1 != 11) {
            var2_6 = new StringBuilder("Expected a double but was ");
            var2_6.append((Object)this.f());
            var2_6.append(" at path ");
            var2_6.append(this.p());
            throw new i(var2_6.toString());
        }
        this.m = 11;
        try {
            var10_7 = Double.parseDouble((String)this.p);
        }
        catch (NumberFormatException v0) {
            var6_11 = new StringBuilder("Expected a double but was ");
            var6_11.append(this.p);
            var6_11.append(" at path ");
            var6_11.append(this.p());
            throw new i(var6_11.toString());
        }
        if (!this.e && (Double.isNaN((double)var10_7) || Double.isInfinite((double)var10_7))) {
            var14_8 = new StringBuilder("JSON forbids NaN and infinities: ");
            var14_8.append(var10_7);
            var14_8.append(" at path ");
            var14_8.append(this.p());
            throw new j(var14_8.toString());
        }
        this.p = null;
        this.m = 0;
        var12_9 = this.d;
        var13_10 = -1 + this.a;
        var12_9[var13_10] = 1 + var12_9[var13_10];
        return var10_7;
    }

    /*
     * Exception decompiling
     */
    @Override
    public final long l() throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl122.1 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    @Override
    public final int m() throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl156.1 : ALOAD_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1113)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:588)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final void n() throws IOException {
        if (this.f) {
            StringBuilder stringBuilder = new StringBuilder("Cannot skip unexpected ");
            stringBuilder.append((Object)this.f());
            stringBuilder.append(" at ");
            stringBuilder.append(this.p());
            throw new i(stringBuilder.toString());
        }
        int n2 = 0;
        do {
            block7 : {
                block9 : {
                    f f2;
                    block12 : {
                        block10 : {
                            block11 : {
                                int n3;
                                block8 : {
                                    block6 : {
                                        block5 : {
                                            block4 : {
                                                if ((n3 = this.m) == 0) {
                                                    n3 = this.r();
                                                }
                                                if (n3 != 3) break block4;
                                                this.a(1);
                                                break block5;
                                            }
                                            if (n3 != 1) break block6;
                                            this.a(3);
                                        }
                                        ++n2;
                                        break block7;
                                    }
                                    if (n3 != 4 && n3 != 2) break block8;
                                    --this.a;
                                    --n2;
                                    break block7;
                                }
                                if (n3 == 14 || n3 == 10) break block9;
                                if (n3 == 9 || n3 == 13) break block10;
                                if (n3 == 8 || n3 == 12) break block11;
                                if (n3 == 17) {
                                    this.l.i((long)this.o);
                                }
                                break block7;
                            }
                            f2 = g;
                            break block12;
                        }
                        f2 = h;
                    }
                    this.b(f2);
                    break block7;
                }
                this.v();
            }
            this.m = 0;
        } while (n2 != 0);
        int[] arrn = this.d;
        int n4 = this.a - 1;
        arrn[n4] = 1 + arrn[n4];
        this.c[this.a - 1] = "null";
    }

    @Override
    final void q() throws IOException {
        if (this.e()) {
            this.p = this.g();
            this.m = 11;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("JsonReader(");
        stringBuilder.append((Object)this.k);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

