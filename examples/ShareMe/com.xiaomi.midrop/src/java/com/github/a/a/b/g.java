/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.github.a.a.b;

public final class g
extends Enum<g> {
    public static final /* enum */ g a = new g("Skipping malformed line (no colon character found).");
    public static final /* enum */ g b = new g("Ignoring BEGIN property that does not have a component name.");
    public static final /* enum */ g c = new g("Ignoring END property that does not have a component name.");
    public static final /* enum */ g d = new g("Ignoring END property that does not match up with any BEGIN properties.");
    public static final /* enum */ g e = new g("Unknown version number found. Treating it as a regular property.");
    public static final /* enum */ g f = new g("The property's character encoding is not supported by this system.  The value will be decoded into the default quoted-printable character encoding.");
    public static final /* enum */ g g = new g("Unable to decode the property's quoted-printable value.  Value will be treated as plain-text.");
    private static final /* synthetic */ g[] i;
    public String h;

    static {
        g[] arrg = new g[]{a, b, c, d, e, f, g};
        i = arrg;
    }

    private g(String string3) {
        this.h = string3;
    }

    public static g valueOf(String string2) {
        return (g)Enum.valueOf(g.class, (String)string2);
    }

    public static g[] values() {
        return (g[])i.clone();
    }

    public final String toString() {
        return this.h;
    }
}

