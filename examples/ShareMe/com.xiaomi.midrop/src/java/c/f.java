/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  c.c
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.ObjectInputStream
 *  java.io.ObjectOutputStream
 *  java.io.Serializable
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Comparable
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.NoSuchFieldException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.reflect.Field
 *  java.nio.charset.Charset
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.Arrays
 *  javax.annotation.Nullable
 */
package c;

import c.b;
import c.c;
import c.v;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;

public class f
implements Serializable,
Comparable<f> {
    static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final f b = f.a(new byte[0]);
    private static final long serialVersionUID = 1L;
    final byte[] c;
    transient int d;
    transient String e;

    f(byte[] arrby) {
        this.c = arrby;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int a(char n2) {
        if (n2 >= 48 && n2 <= 57) {
            return n2 - 48;
        }
        int n3 = 97;
        if (n2 >= n3 && n2 <= 102) {
            return 10 + (n2 - n3);
        }
        n3 = 65;
        if (n2 >= n3 && n2 <= 70) {
            return 10 + (n2 - n3);
        }
        StringBuilder stringBuilder = new StringBuilder("Unexpected hex digit: ");
        stringBuilder.append((char)n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static f a(String string2) {
        if (string2 == null) {
            throw new IllegalArgumentException("s == null");
        }
        f f2 = new f(string2.getBytes(v.a));
        f2.e = string2;
        return f2;
    }

    public static /* varargs */ f a(byte ... arrby) {
        if (arrby == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new f((byte[])arrby.clone());
    }

    @Nullable
    public static f b(String string2) {
        if (string2 == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] arrby = b.a(string2);
        if (arrby != null) {
            return new f(arrby);
        }
        return null;
    }

    public static f c(String string2) {
        if (string2.length() % 2 != 0) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected hex string: ");
            stringBuilder.append(string2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        byte[] arrby = new byte[string2.length() / 2];
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            int n2 = i2 * 2;
            arrby[i2] = (byte)((f.a(string2.charAt(n2)) << 4) + f.a(string2.charAt(n2 + 1)));
        }
        return f.a(arrby);
    }

    private f d(String string2) {
        try {
            f f2 = f.a(MessageDigest.getInstance((String)string2).digest(this.c));
            return f2;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new AssertionError((Object)noSuchAlgorithmException);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        int n2;
        int n3 = objectInputStream.readInt();
        if (objectInputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (n3 < 0) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(n3);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        byte[] arrby = new byte[n3];
        for (int i2 = 0; i2 < n3; i2 += n2) {
            n2 = objectInputStream.read(arrby, i2, n3 - i2);
            if (n2 != -1) continue;
            throw new EOFException();
        }
        f f2 = new f(arrby);
        try {
            Field field = f.class.getDeclaredField("c");
            field.setAccessible(true);
            field.set((Object)this, (Object)f2.c);
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError();
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.c.length);
        objectOutputStream.write(this.c);
    }

    public byte a(int n2) {
        return this.c[n2];
    }

    public f a(int n2, int n3) {
        if (n2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if (n3 > this.c.length) {
            StringBuilder stringBuilder = new StringBuilder("endIndex > length(");
            stringBuilder.append(this.c.length);
            stringBuilder.append(")");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int n4 = n3 - n2;
        if (n4 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (n2 == 0 && n3 == this.c.length) {
            return this;
        }
        byte[] arrby = new byte[n4];
        System.arraycopy((Object)this.c, (int)n2, (Object)arrby, (int)0, (int)n4);
        return new f(arrby);
    }

    public String a() {
        String string2;
        String string3 = this.e;
        if (string3 != null) {
            return string3;
        }
        this.e = string2 = new String(this.c, v.a);
        return string2;
    }

    void a(c c2) {
        c2.b(this.c, 0, this.c.length);
    }

    public boolean a(int n2, f f2, int n3, int n4) {
        return f2.a(0, this.c, 0, n4);
    }

    public boolean a(int n2, byte[] arrby, int n3, int n4) {
        return n2 >= 0 && n2 <= this.c.length - n4 && n3 >= 0 && n3 <= arrby.length - n4 && v.a(this.c, n2, arrby, n3, n4);
    }

    public String b() {
        return b.a(this.c);
    }

    public f c() {
        return this.d("MD5");
    }

    public /* synthetic */ int compareTo(Object object) {
        f f2 = (f)object;
        int n2 = this.h();
        int n3 = f2.h();
        int n4 = Math.min((int)n2, (int)n3);
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5;
            int n6 = 255 & this.a(i2);
            if (n6 == (n5 = 255 & f2.a(i2))) continue;
            if (n6 < n5) {
                return -1;
            }
            return 1;
        }
        if (n2 == n3) {
            return 0;
        }
        if (n2 < n3) {
            return -1;
        }
        return 1;
    }

    public f d() {
        return this.d("SHA-1");
    }

    public f e() {
        return this.d("SHA-256");
    }

    public boolean equals(Object object) {
        f f2;
        if (object == this) {
            return true;
        }
        return object instanceof f && (f2 = (f)object).h() == this.c.length && f2.a(0, this.c, 0, this.c.length);
    }

    public String f() {
        char[] arrc = new char[2 * this.c.length];
        byte[] arrby = this.c;
        int n2 = arrby.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by = arrby[i2];
            int n4 = n3 + 1;
            arrc[n3] = a[15 & by >> 4];
            n3 = n4 + 1;
            arrc[n4] = a[by & 15];
        }
        return new String(arrc);
    }

    public f g() {
        for (int i2 = 0; i2 < this.c.length; ++i2) {
            byte by = this.c[i2];
            if (by < 65 || by > 90) continue;
            byte[] arrby = (byte[])this.c.clone();
            arrby[i2] = (byte)(by + 32);
            for (int i3 = i2 + 1; i3 < arrby.length; ++i3) {
                byte by2 = arrby[i3];
                if (by2 < 65 || by2 > 90) continue;
                arrby[i3] = (byte)(by2 + 32);
            }
            return new f(arrby);
        }
        return this;
    }

    public int h() {
        return this.c.length;
    }

    public int hashCode() {
        int n2;
        int n3 = this.d;
        if (n3 != 0) {
            return n3;
        }
        this.d = n2 = Arrays.hashCode((byte[])this.c);
        return n2;
    }

    public byte[] i() {
        return (byte[])this.c.clone();
    }

    byte[] j() {
        return this.c;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public String toString() {
        block6 : {
            block7 : {
                block5 : {
                    if (this.c.length == 0) {
                        return "[size=0]";
                    }
                    var1_1 = this.a();
                    var2_2 = var1_1.length();
                    var4_4 = 0;
                    for (var3_3 = 0; var3_3 < var2_2; ++var4_4, var3_3 += Character.charCount((int)var15_5)) {
                        if (var4_4 != 64) {
                            var15_5 = var1_1.codePointAt(var3_3);
                            if ((!Character.isISOControl((int)var15_5) || var15_5 == 10 || var15_5 == 13) && var15_5 != 65533) continue;
                            var3_3 = -1;
                        }
                        break block5;
                    }
                    var3_3 = var1_1.length();
                }
                if (var3_3 != -1) break block6;
                if (this.c.length > 64) break block7;
                var6_6 = new StringBuilder("[hex=");
                var5_7 = this.f();
                ** GOTO lbl35
            }
            var6_6 = new StringBuilder("[size=");
            var6_6.append(this.c.length);
            var6_6.append(" hex=");
            var5_7 = this.a(0, 64).f();
            ** GOTO lbl31
        }
        var5_7 = var1_1.substring(0, var3_3).replace((CharSequence)"\\", (CharSequence)"\\\\").replace((CharSequence)"\n", (CharSequence)"\\n").replace((CharSequence)"\r", (CharSequence)"\\r");
        if (var3_3 < var1_1.length()) {
            var6_6 = new StringBuilder("[size=");
            var6_6.append(this.c.length);
            var6_6.append(" text=");
lbl31: // 2 sources:
            var6_6.append(var5_7);
            var10_8 = "\u2026]";
        } else {
            var6_6 = new StringBuilder("[text=");
lbl35: // 2 sources:
            var6_6.append(var5_7);
            var10_8 = "]";
        }
        var6_6.append(var10_8);
        return var6_6.toString();
    }
}

