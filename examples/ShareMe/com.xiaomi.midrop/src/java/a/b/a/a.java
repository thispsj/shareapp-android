/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package a.b.a;

public final class a
extends Enum<a> {
    public static final /* enum */ a a;
    public static final /* enum */ a b;
    public static final /* enum */ a c;
    private static final /* synthetic */ a[] d;

    static {
        a a2;
        a a3;
        a a4;
        a[] arra = new a[3];
        a = a3 = new a();
        arra[0] = a3;
        b = a4 = new a();
        arra[1] = a4;
        c = a2 = new a();
        arra[2] = a2;
        d = arra;
    }

    public static a valueOf(String string2) {
        return (a)Enum.valueOf(a.class, (String)string2);
    }

    public static a[] values() {
        return (a[])d.clone();
    }
}

