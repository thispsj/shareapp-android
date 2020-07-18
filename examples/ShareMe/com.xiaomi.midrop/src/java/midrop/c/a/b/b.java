/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package midrop.c.a.b;

public final class b
extends Enum<b> {
    public static final /* enum */ b a = new b();
    public static final /* enum */ b b = new b();
    public static final /* enum */ b c = new b();
    public static final /* enum */ b d = new b();
    private static final /* synthetic */ b[] e;

    static {
        b[] arrb = new b[]{a, b, c, d};
        e = arrb;
    }

    public static b valueOf(String string2) {
        return (b)Enum.valueOf(b.class, (String)string2);
    }

    public static b[] values() {
        return (b[])e.clone();
    }

    public final String toString() {
        switch (1.a[this.ordinal()]) {
            default: {
                return "undefined";
            }
            case 3: {
                return "bt_service";
            }
            case 2: {
                return "general";
            }
            case 1: 
        }
        return "ap";
    }

}

