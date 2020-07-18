/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.a.d.a$1
 *  java.io.Closeable
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.Reader
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package com.google.a.d;

import com.google.a.b.f;
import com.google.a.d.a;
import com.google.a.d.b;
import com.google.a.d.d;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class a
implements Closeable {
    private static final char[] c = ")]}'\n".toCharArray();
    public boolean a = false;
    int b = 0;
    private final Reader d;
    private final char[] e = new char[1024];
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private long j;
    private int k;
    private String l;
    private int[] m = new int[32];
    private int n = 0;
    private String[] o;
    private int[] p;

    static {
        f.a = new 1();
    }

    public a(Reader reader) {
        int[] arrn = this.m;
        int n2 = this.n;
        this.n = n2 + 1;
        arrn[n2] = 6;
        this.o = new String[32];
        this.p = new int[32];
        this.d = reader;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int a(boolean var1) throws IOException {
        var2_2 = this.e;
        block0 : do {
            var3_7 = this.f;
            block1 : do {
                var4_8 = this.g;
                do {
                    block18 : {
                        block23 : {
                            block21 : {
                                block19 : {
                                    block20 : {
                                        block17 : {
                                            var5_6 = 1;
                                            if (var3_7 == var4_8) {
                                                this.f = var3_7;
                                                if (a.super.b(var5_6)) {
                                                    var3_7 = this.f;
                                                    var4_8 = this.g;
                                                } else {
                                                    if (!var1) return -1;
                                                    var13_13 = new StringBuilder("End of input");
                                                    var13_13.append(this.r());
                                                    throw new EOFException(var13_13.toString());
                                                }
                                            }
                                            var6_12 = var3_7 + 1;
                                            var7_11 = var2_2[var3_7];
                                            if (var7_11 != '\n') break block17;
                                            this.h = var5_6 + this.h;
                                            this.i = var6_12;
                                            break block18;
                                        }
                                        if (var7_11 == ' ' || var7_11 == '\r' || var7_11 == '\t') break block18;
                                        if (var7_11 != '/') break block19;
                                        this.f = var6_12;
                                        if (var6_12 == var4_8) {
                                            this.f -= var5_6;
                                            var12_9 = a.super.b(2);
                                            this.f = var5_6 + this.f;
                                            if (!var12_9) {
                                                return var7_11;
                                            }
                                        }
                                        a.super.u();
                                        var8_3 = var2_2[this.f];
                                        if (var8_3 == '*') break block20;
                                        if (var8_3 != '/') {
                                            return var7_11;
                                        }
                                        this.f = var5_6 + this.f;
                                        break block21;
                                    }
                                    this.f = var5_6 + this.f;
                                    var9_5 = "*/".length();
                                    block3 : do {
                                        block22 : {
                                            if (var9_5 + this.f > this.g && !a.super.b(var9_5)) {
                                                var5_6 = 0;
                                                break;
                                            }
                                            var10_10 = this.e[this.f];
                                            if (var10_10 != '\n') break block22;
                                            this.h = var5_6 + this.h;
                                            this.i = var5_6 + this.f;
                                            ** GOTO lbl57
                                        }
                                        for (var11_4 = 0; var11_4 < var9_5; ++var11_4) {
                                            if (this.e[var11_4 + this.f] == "*/".charAt(var11_4)) {
                                                continue;
                                            }
lbl57: // 3 sources:
                                            this.f = var5_6 + this.f;
                                            continue block3;
                                        }
                                        break;
                                    } while (true);
                                    if (var5_6 == 0) {
                                        throw a.super.a("Unterminated comment");
                                    }
                                    var3_7 = 2 + this.f;
                                    continue block1;
                                }
                                if (var7_11 != '#') break block23;
                                this.f = var6_12;
                                a.super.u();
                            }
                            a.super.v();
                            continue block0;
                        }
                        this.f = var6_12;
                        return var7_11;
                    }
                    var3_7 = var6_12;
                } while (true);
                break;
            } while (true);
            break;
        } while (true);
    }

    private IOException a(String string2) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(this.r());
        throw new d(stringBuilder.toString());
    }

    private void a(int n2) {
        if (this.n == this.m.length) {
            int[] arrn = new int[2 * this.n];
            int[] arrn2 = new int[2 * this.n];
            String[] arrstring = new String[2 * this.n];
            System.arraycopy((Object)this.m, (int)0, (Object)arrn, (int)0, (int)this.n);
            System.arraycopy((Object)this.p, (int)0, (Object)arrn2, (int)0, (int)this.n);
            System.arraycopy((Object)this.o, (int)0, (Object)arrstring, (int)0, (int)this.n);
            this.m = arrn;
            this.p = arrn2;
            this.o = arrstring;
        }
        int[] arrn = this.m;
        int n3 = this.n;
        this.n = n3 + 1;
        arrn[n3] = n2;
    }

    private boolean a(char c2) throws IOException {
        switch (c2) {
            default: {
                return true;
            }
            case '#': 
            case '/': 
            case ';': 
            case '=': 
            case '\\': {
                a.super.u();
            }
            case '\t': 
            case '\n': 
            case '\f': 
            case '\r': 
            case ' ': 
            case ',': 
            case ':': 
            case '[': 
            case ']': 
            case '{': 
            case '}': 
        }
        return false;
    }

    private String b(char c2) throws IOException {
        char[] arrc = this.e;
        StringBuilder stringBuilder = null;
        block0 : do {
            int n2 = this.f;
            int n3 = this.g;
            int n4 = n2;
            while (n4 < n3) {
                int n5 = n4 + 1;
                char c3 = arrc[n4];
                if (c3 == c2) {
                    this.f = n5;
                    int n6 = n5 - n2 - 1;
                    if (stringBuilder == null) {
                        return new String(arrc, n2, n6);
                    }
                    stringBuilder.append(arrc, n2, n6);
                    return stringBuilder.toString();
                }
                if (c3 == '\\') {
                    this.f = n5;
                    int n7 = n5 - n2 - 1;
                    if (stringBuilder == null) {
                        stringBuilder = new StringBuilder(Math.max((int)(2 * (n7 + 1)), (int)16));
                    }
                    stringBuilder.append(arrc, n2, n7);
                    stringBuilder.append(a.super.w());
                    continue block0;
                }
                if (c3 == '\n') {
                    this.h = 1 + this.h;
                    this.i = n5;
                }
                n4 = n5;
            }
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder(Math.max((int)(2 * (n4 - n2)), (int)16));
            }
            stringBuilder.append(arrc, n2, n4 - n2);
            this.f = n4;
            if (!a.super.b(1)) break;
        } while (true);
        throw a.super.a("Unterminated string");
    }

    private boolean b(int n2) throws IOException {
        int n3;
        char[] arrc = this.e;
        this.i -= this.f;
        if (this.g != this.f) {
            this.g -= this.f;
            System.arraycopy((Object)arrc, (int)this.f, (Object)arrc, (int)0, (int)this.g);
        } else {
            this.g = 0;
        }
        this.f = 0;
        while ((n3 = this.d.read(arrc, this.g, arrc.length - this.g)) != -1) {
            this.g = n3 + this.g;
            if (this.h == 0 && this.i == 0 && this.g > 0 && arrc[0] == '\ufeff') {
                this.f = 1 + this.f;
                this.i = 1 + this.i;
                ++n2;
            }
            if (this.g < n2) continue;
            return true;
        }
        return false;
    }

    private void c(char c2) throws IOException {
        char[] arrc = this.e;
        block0 : do {
            int n2 = this.f;
            int n3 = this.g;
            while (n2 < n3) {
                int n4 = n2 + 1;
                char c3 = arrc[n2];
                if (c3 == c2) {
                    this.f = n4;
                    return;
                }
                if (c3 == '\\') {
                    this.f = n4;
                    a.super.w();
                    continue block0;
                }
                if (c3 == '\n') {
                    this.h = 1 + this.h;
                    this.i = n4;
                }
                n2 = n4;
            }
            this.f = n2;
            if (!a.super.b(1)) break;
        } while (true);
        throw a.super.a("Unterminated string");
    }

    private int g() throws IOException {
        String string2;
        String string3;
        int n2;
        char c2 = this.e[this.f];
        if (c2 != 't' && c2 != 'T') {
            if (c2 != 'f' && c2 != 'F') {
                if (c2 != 'n' && c2 != 'N') {
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
        for (int i2 = 1; i2 < n3; ++i2) {
            if (i2 + this.f >= this.g && !this.b(i2 + 1)) {
                return 0;
            }
            char c3 = this.e[i2 + this.f];
            if (c3 == string2.charAt(i2) || c3 == string3.charAt(i2)) continue;
            return 0;
        }
        if ((n3 + this.f < this.g || this.b(n3 + 1)) && this.a(this.e[n3 + this.f])) {
            return 0;
        }
        this.f = n3 + this.f;
        this.b = n2;
        return n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private int s() throws IOException {
        var1_1 = this.e;
        var2_2 = this.f;
        var3_3 = this.g;
        var4_4 = 0;
        var5_5 = 0;
        var6_6 = true;
        var7_7 = 0L;
        var9_8 = false;
        do {
            block23 : {
                block24 : {
                    block21 : {
                        block22 : {
                            block20 : {
                                if (var2_2 + var4_4 != var3_3) break block20;
                                if (var4_4 == var1_1.length) {
                                    return 0;
                                }
                                if (!this.b(var4_4 + 1)) ** GOTO lbl42
                                var2_2 = this.f;
                                var3_3 = this.g;
                            }
                            if ((var10_10 = var1_1[var2_2 + var4_4]) == '+') break block21;
                            if (var10_10 == 'E' || var10_10 == 'e') break block22;
                            switch (var10_10) {
                                default: {
                                    if (var10_10 < '0' || var10_10 > '9') ** GOTO lbl40
                                    if (var5_5 != 1 && var5_5 != 0) {
                                        if (var5_5 == 2) {
                                            if (var7_7 == 0L) {
                                                return 0;
                                            }
                                            var12_9 = 10L * var7_7 - (long)(var10_10 - 48);
                                            var14_11 = var7_7 > -922337203685477580L || var7_7 == -922337203685477580L && var12_9 < var7_7;
                                            var6_6 = var14_11 & var6_6;
                                            var7_7 = var12_9;
                                        } else if (var5_5 == 3) {
                                            var5_5 = 4;
                                        } else if (var5_5 == 5 || var5_5 == 6) {
                                            var5_5 = 7;
                                        }
                                    } else {
                                        var7_7 = -(var10_10 - 48);
                                        var5_5 = 2;
                                    }
                                    break block23;
lbl40: // 1 sources:
                                    if (this.a(var10_10)) {
                                        return 0;
                                    }
lbl42: // 3 sources:
                                    if (!(var5_5 != 2 || !var6_6 || var7_7 == Long.MIN_VALUE && !var9_8 || var7_7 == 0L && var9_8)) {
                                        if (!var9_8) {
                                            var7_7 = -var7_7;
                                        }
                                        this.j = var7_7;
                                        this.f = var4_4 + this.f;
                                        var11_12 = 15;
                                    } else {
                                        if (var5_5 != 2 && var5_5 != 4) {
                                            if (var5_5 != 7) return 0;
                                        }
                                        this.k = var4_4;
                                        var11_12 = 16;
                                    }
                                    this.b = var11_12;
                                    return var11_12;
                                }
                                case '.': {
                                    if (var5_5 != 2) return 0;
                                    var5_5 = 3;
                                    break block23;
                                }
                                case '-': {
                                    if (var5_5 != 0) ** GOTO lbl64
                                    var5_5 = 1;
                                    var9_8 = true;
                                    break block23;
lbl64: // 1 sources:
                                    if (var5_5 != 5) return 0;
                                    break;
                                }
                            }
                            break block24;
                        }
                        if (var5_5 != 2) {
                            if (var5_5 != 4) return 0;
                        }
                        var5_5 = 5;
                        break block23;
                    }
                    if (var5_5 != 5) return 0;
                }
                var5_5 = 6;
            }
            ++var4_4;
        } while (true);
    }

    /*
     * Exception decompiling
     */
    private String t() throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:478)
        // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:61)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:372)
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

    private void u() throws IOException {
        if (!this.a) {
            throw this.a("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void v() throws IOException {
        while (this.f < this.g || this.b(1)) {
            char[] arrc = this.e;
            int n2 = this.f;
            this.f = n2 + 1;
            char c2 = arrc[n2];
            if (c2 == '\n') {
                this.h = 1 + this.h;
                this.i = this.f;
                return;
            }
            if (c2 != '\r') continue;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private char w() throws IOException {
        if (this.f == this.g && !this.b(1)) {
            throw this.a("Unterminated escape sequence");
        }
        char[] arrc = this.e;
        int n2 = this.f;
        this.f = n2 + 1;
        char c2 = arrc[n2];
        if (c2 != '\n') {
            if (c2 == '\"' || c2 == '\'' || c2 == '/' || c2 == '\\') return c2;
            {
                if (c2 == 'b') {
                    return '\b';
                }
                if (c2 == 'f') {
                    return '\f';
                }
                if (c2 == 'n') {
                    return '\n';
                }
                if (c2 == 'r') {
                    return '\r';
                }
                switch (c2) {
                    default: {
                        throw this.a("Invalid escape sequence");
                    }
                    case 'u': {
                        if (4 + this.f > this.g && !this.b(4)) {
                            throw this.a("Unterminated escape sequence");
                        }
                        char c3 = '\u0000';
                        int n3 = this.f;
                        int n4 = n3 + 4;
                        do {
                            int n5;
                            if (n3 >= n4) {
                                this.f = 4 + this.f;
                                return c3;
                            }
                            char c4 = this.e[n3];
                            char c5 = (char)(c3 << 4);
                            if (c4 >= '0' && c4 <= '9') {
                                n5 = c4 - 48;
                            } else {
                                int n6;
                                if (c4 >= 'a' && c4 <= 'f') {
                                    n6 = c4 - 97;
                                } else {
                                    if (c4 < 'A' || c4 > 'F') break;
                                    n6 = c4 - 65;
                                }
                                n5 = n6 + 10;
                            }
                            c3 = (char)(c5 + n5);
                            ++n3;
                        } while (true);
                        StringBuilder stringBuilder = new StringBuilder("\\u");
                        stringBuilder.append(new String(this.e, this.f, 4));
                        throw new NumberFormatException(stringBuilder.toString());
                    }
                    case 't': 
                }
                return '\t';
            }
        } else {
            this.h = 1 + this.h;
            this.i = this.f;
        }
        return c2;
    }

    public void a() throws IOException {
        int n2 = this.b;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 3) {
            this.a(1);
            this.p[this.n - 1] = 0;
            this.b = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected BEGIN_ARRAY but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(this.r());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void b() throws IOException {
        int n2 = this.b;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 4) {
            this.n = -1 + this.n;
            int[] arrn = this.p;
            int n3 = -1 + this.n;
            arrn[n3] = 1 + arrn[n3];
            this.b = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected END_ARRAY but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(this.r());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void c() throws IOException {
        int n2 = this.b;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 1) {
            this.a(3);
            this.b = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected BEGIN_OBJECT but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(this.r());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void close() throws IOException {
        this.b = 0;
        this.m[0] = 8;
        this.n = 1;
        this.d.close();
    }

    public void d() throws IOException {
        int n2 = this.b;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 2) {
            this.n = -1 + this.n;
            this.o[this.n] = null;
            int[] arrn = this.p;
            int n3 = -1 + this.n;
            arrn[n3] = 1 + arrn[n3];
            this.b = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected END_OBJECT but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(this.r());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public boolean e() throws IOException {
        int n2 = this.b;
        if (n2 == 0) {
            n2 = this.q();
        }
        return n2 != 2 && n2 != 4;
    }

    public b f() throws IOException {
        int n2 = this.b;
        if (n2 == 0) {
            n2 = this.q();
        }
        switch (n2) {
            default: {
                throw new AssertionError();
            }
            case 17: {
                return b.j;
            }
            case 15: 
            case 16: {
                return b.g;
            }
            case 12: 
            case 13: 
            case 14: {
                return b.e;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                return b.f;
            }
            case 7: {
                return b.i;
            }
            case 5: 
            case 6: {
                return b.h;
            }
            case 4: {
                return b.b;
            }
            case 3: {
                return b.a;
            }
            case 2: {
                return b.d;
            }
            case 1: 
        }
        return b.c;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String h() throws IOException {
        String string2;
        int n2 = this.b;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 14) {
            string2 = this.t();
        } else {
            int n3;
            if (n2 == 12) {
                n3 = 39;
            } else {
                if (n2 != 13) {
                    StringBuilder stringBuilder = new StringBuilder("Expected a name but was ");
                    stringBuilder.append((Object)this.f());
                    stringBuilder.append(this.r());
                    throw new IllegalStateException(stringBuilder.toString());
                }
                n3 = 34;
            }
            string2 = this.b((char)n3);
        }
        this.b = 0;
        this.o[-1 + this.n] = string2;
        return string2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public String i() throws IOException {
        block9 : {
            block10 : {
                block8 : {
                    var1_1 = this.b;
                    if (var1_1 == 0) {
                        var1_1 = this.q();
                    }
                    if (var1_1 != 10) break block8;
                    var2_2 = this.t();
                    break block9;
                }
                if (var1_1 != 8) break block10;
                var8_3 = 39;
                ** GOTO lbl14
            }
            if (var1_1 == 9) {
                var8_3 = 34;
lbl14: // 2 sources:
                var2_2 = this.b((char)var8_3);
            } else if (var1_1 == 11) {
                var2_2 = this.l;
                this.l = null;
            } else if (var1_1 == 15) {
                var2_2 = Long.toString((long)this.j);
            } else {
                if (var1_1 != 16) {
                    var5_6 = new StringBuilder("Expected a string but was ");
                    var5_6.append((Object)this.f());
                    var5_6.append(this.r());
                    throw new IllegalStateException(var5_6.toString());
                }
                var2_2 = new String(this.e, this.f, this.k);
                this.f += this.k;
            }
        }
        this.b = 0;
        var3_4 = this.p;
        var4_5 = -1 + this.n;
        var3_4[var4_5] = 1 + var3_4[var4_5];
        return var2_2;
    }

    public boolean j() throws IOException {
        int n2 = this.b;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 5) {
            this.b = 0;
            int[] arrn = this.p;
            int n3 = this.n - 1;
            arrn[n3] = 1 + arrn[n3];
            return true;
        }
        if (n2 == 6) {
            this.b = 0;
            int[] arrn = this.p;
            int n4 = this.n - 1;
            arrn[n4] = 1 + arrn[n4];
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected a boolean but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(this.r());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void k() throws IOException {
        int n2 = this.b;
        if (n2 == 0) {
            n2 = this.q();
        }
        if (n2 == 7) {
            this.b = 0;
            int[] arrn = this.p;
            int n3 = -1 + this.n;
            arrn[n3] = 1 + arrn[n3];
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected null but was ");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(this.r());
        throw new IllegalStateException(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     */
    public double l() throws IOException {
        block5 : {
            String string2;
            block8 : {
                int n2;
                block6 : {
                    block7 : {
                        block4 : {
                            n2 = this.b;
                            if (n2 == 0) {
                                n2 = this.q();
                            }
                            if (n2 == 15) {
                                this.b = 0;
                                int[] arrn = this.p;
                                int n3 = -1 + this.n;
                                arrn[n3] = 1 + arrn[n3];
                                return this.j;
                            }
                            if (n2 != 16) break block4;
                            this.l = new String(this.e, this.f, this.k);
                            this.f += this.k;
                            break block5;
                        }
                        if (n2 == 8 || n2 == 9) break block6;
                        if (n2 != 10) break block7;
                        string2 = this.t();
                        break block8;
                    }
                    if (n2 != 11) {
                        StringBuilder stringBuilder = new StringBuilder("Expected a double but was ");
                        stringBuilder.append((Object)this.f());
                        stringBuilder.append(this.r());
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                    break block5;
                }
                char c2 = n2 == 8 ? (char)'\'' : '\"';
                string2 = this.b(c2);
            }
            this.l = string2;
        }
        this.b = 11;
        double d2 = Double.parseDouble((String)this.l);
        if (!this.a && (Double.isNaN((double)d2) || Double.isInfinite((double)d2))) {
            StringBuilder stringBuilder = new StringBuilder("JSON forbids NaN and infinities: ");
            stringBuilder.append(d2);
            stringBuilder.append(this.r());
            throw new d(stringBuilder.toString());
        }
        this.l = null;
        this.b = 0;
        int[] arrn = this.p;
        int n4 = -1 + this.n;
        arrn[n4] = 1 + arrn[n4];
        return d2;
    }

    /*
     * Exception decompiling
     */
    public long m() throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl135.1 : ALOAD_0 : trying to set 1 previously set to 0
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
    public int n() throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl165.1 : ALOAD_0 : trying to set 1 previously set to 0
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
    public void o() throws IOException {
        int n2 = 0;
        do {
            block12 : {
                block14 : {
                    int n3;
                    block17 : {
                        block15 : {
                            block16 : {
                                int n4;
                                block13 : {
                                    block11 : {
                                        block10 : {
                                            block9 : {
                                                if ((n4 = this.b) == 0) {
                                                    n4 = this.q();
                                                }
                                                if (n4 != 3) break block9;
                                                this.a(1);
                                                break block10;
                                            }
                                            if (n4 != 1) break block11;
                                            this.a(3);
                                        }
                                        ++n2;
                                        break block12;
                                    }
                                    if (n4 != 4 && n4 != 2) break block13;
                                    --this.n;
                                    --n2;
                                    break block12;
                                }
                                if (n4 == 14 || n4 == 10) break block14;
                                if (n4 == 8 || n4 == 12) break block15;
                                if (n4 == 9 || n4 == 13) break block16;
                                if (n4 == 16) {
                                    this.f += this.k;
                                }
                                break block12;
                            }
                            n3 = 34;
                            break block17;
                        }
                        n3 = 39;
                    }
                    this.c((char)n3);
                    break block12;
                }
                block5 : do {
                    int n5 = 0;
                    block6 : while (n5 + this.f < this.g) {
                        switch (this.e[n5 + this.f]) {
                            default: {
                                ++n5;
                                continue block6;
                            }
                            case '#': 
                            case '/': 
                            case ';': 
                            case '=': 
                            case '\\': {
                                this.u();
                            }
                            case '\t': 
                            case '\n': 
                            case '\f': 
                            case '\r': 
                            case ' ': 
                            case ',': 
                            case ':': 
                            case '[': 
                            case ']': 
                            case '{': 
                            case '}': 
                        }
                        this.f = n5 + this.f;
                        break block5;
                    }
                    this.f = n5 + this.f;
                } while (this.b(1));
            }
            this.b = 0;
        } while (n2 != 0);
        int[] arrn = this.p;
        int n6 = this.n - 1;
        arrn[n6] = 1 + arrn[n6];
        this.o[this.n - 1] = "null";
    }

    public String p() {
        StringBuilder stringBuilder = new StringBuilder("$");
        int n2 = this.n;
        block4 : for (int i2 = 0; i2 < n2; ++i2) {
            switch (this.m[i2]) {
                default: {
                    continue block4;
                }
                case 3: 
                case 4: 
                case 5: {
                    stringBuilder.append('.');
                    if (this.o[i2] == null) continue block4;
                    stringBuilder.append(this.o[i2]);
                    continue block4;
                }
                case 1: 
                case 2: {
                    stringBuilder.append('[');
                    stringBuilder.append(this.p[i2]);
                    stringBuilder.append(']');
                }
            }
        }
        return stringBuilder.toString();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    final int q() throws IOException {
        block39 : {
            block32 : {
                block30 : {
                    block37 : {
                        block34 : {
                            block38 : {
                                block35 : {
                                    block28 : {
                                        block36 : {
                                            block33 : {
                                                block31 : {
                                                    block29 : {
                                                        var1_1 = this.m[this.n - 1];
                                                        if (var1_1 != 1) break block29;
                                                        this.m[this.n - 1] = 2;
                                                        break block30;
                                                    }
                                                    if (var1_1 != 2) break block31;
                                                    var15_2 = this.a(true);
                                                    if (var15_2 != 44) {
                                                        if (var15_2 != 59) {
                                                            if (var15_2 != 93) {
                                                                throw this.a("Unterminated array");
                                                            }
                                                            this.b = 4;
                                                            return 4;
                                                        }
                                                        this.u();
                                                    }
                                                    break block30;
                                                }
                                                if (var1_1 == 3 || var1_1 == 5) break block32;
                                                if (var1_1 != 4) break block33;
                                                this.m[this.n - 1] = 5;
                                                var14_3 = this.a(true);
                                                if (var14_3 == 58) break block30;
                                                if (var14_3 != 61) {
                                                    throw this.a("Expected ':'");
                                                }
                                                this.u();
                                                if (this.f >= this.g && !this.b(1) || this.e[this.f] != '>') break block30;
                                                var8_4 = 1 + this.f;
                                                break block34;
                                            }
                                            if (var1_1 != 6) break block35;
                                            if (!this.a) break block28;
                                            this.a(true);
                                            --this.f;
                                            var10_5 = this.f + a.c.length;
                                            var11_6 = this.g;
                                            var12_7 = 0;
                                            if (var10_5 <= var11_6) break block36;
                                            var13_8 = this.b(a.c.length);
                                            var12_7 = 0;
                                            if (!var13_8) break block28;
                                        }
                                        while (var12_7 < a.c.length) {
                                            if (this.e[var12_7 + this.f] == a.c[var12_7]) {
                                                ++var12_7;
                                                continue;
                                            }
                                            break block28;
                                        }
                                        this.f += a.c.length;
                                    }
                                    this.m[this.n - 1] = 7;
                                    break block30;
                                }
                                if (var1_1 != 7) break block37;
                                if (this.a(false) != -1) break block38;
                                var3_9 = 17;
                                break block39;
                            }
                            this.u();
                            var8_4 = this.f - 1;
                        }
                        this.f = var8_4;
                        break block30;
                    }
                    if (var1_1 == 8) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                }
                var5_10 = this.a(true);
                if (var5_10 == 34) ** GOTO lbl100
                if (var5_10 == 39) {
                    this.u();
                    this.b = 8;
                    return 8;
                }
                if (var5_10 == 44 || var5_10 == 59) ** GOTO lbl94
                if (var5_10 == 91) {
                    this.b = 3;
                    return 3;
                }
                if (var5_10 != 93) {
                    if (var5_10 == 123) {
                        this.b = 1;
                        return 1;
                    }
                    --this.f;
                    var6_11 = this.g();
                    if (var6_11 != 0) {
                        return var6_11;
                    }
                    var7_12 = this.s();
                    if (var7_12 != 0) {
                        return var7_12;
                    }
                    if (!this.a(this.e[this.f])) {
                        throw this.a("Expected value");
                    }
                    this.u();
                    var3_9 = 10;
                } else {
                    if (var1_1 == 1) {
                        this.b = 4;
                        return 4;
                    }
lbl94: // 3 sources:
                    if (var1_1 != 1) {
                        if (var1_1 != 2) throw this.a("Unexpected value");
                    }
                    this.u();
                    --this.f;
                    this.b = 7;
                    return 7;
lbl100: // 1 sources:
                    var3_9 = 9;
                }
                break block39;
            }
            this.m[this.n - 1] = 4;
            if (var1_1 == 5 && (var4_13 = this.a(true)) != 44) {
                if (var4_13 != 59) {
                    if (var4_13 != 125) {
                        throw this.a("Unterminated object");
                    }
                    this.b = 2;
                    return 2;
                }
                this.u();
            }
            if ((var2_14 = this.a(true)) != 34) {
                if (var2_14 != 39) {
                    if (var2_14 == 125) {
                        if (var1_1 == 5) throw this.a("Expected name");
                        this.b = 2;
                        return 2;
                    }
                    this.u();
                    --this.f;
                    if (this.a((char)var2_14) == false) throw this.a("Expected name");
                    var3_9 = 14;
                } else {
                    this.u();
                    var3_9 = 12;
                }
            } else {
                var3_9 = 13;
            }
        }
        this.b = var3_9;
        return var3_9;
    }

    final String r() {
        int n2 = 1 + this.h;
        int n3 = 1 + (this.f - this.i);
        StringBuilder stringBuilder = new StringBuilder(" at line ");
        stringBuilder.append(n2);
        stringBuilder.append(" column ");
        stringBuilder.append(n3);
        stringBuilder.append(" path ");
        stringBuilder.append(this.p());
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(this.r());
        return stringBuilder.toString();
    }
}

