/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.netty.d;

public final class f
extends IllegalStateException {
    private static final long serialVersionUID = -2507492394288153468L;

    public f() {
    }

    public f(int n2) {
        StringBuilder stringBuilder = new StringBuilder("refCnt: ");
        stringBuilder.append(n2);
        super(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     */
    public f(int n2, int n3) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder("refCnt: ");
        stringBuilder2.append(n2);
        stringBuilder2.append(", ");
        if (n3 > 0) {
            stringBuilder = new StringBuilder("increment: ");
        } else {
            stringBuilder = new StringBuilder("decrement: ");
            n3 = -n3;
        }
        stringBuilder.append(n3);
        String string2 = stringBuilder.toString();
        stringBuilder2.append(string2);
        super(stringBuilder2.toString());
    }

    private f(String string2) {
        super(string2);
    }
}

