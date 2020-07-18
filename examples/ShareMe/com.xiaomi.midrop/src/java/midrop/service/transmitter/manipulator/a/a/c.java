/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 */
package midrop.service.transmitter.manipulator.a.a;

public final class c
extends Enum<c> {
    public static final int a = 1;
    public static final int b = 2;
    private static final /* synthetic */ int[] c;

    static {
        int[] arrn = new int[]{a, b};
        c = arrn;
    }

    public static int[] a() {
        return (int[])c.clone();
    }
}

