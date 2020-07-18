/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.property.VCardProperty
 *  java.lang.Class
 *  java.lang.String
 */
package ezvcard.a.b;

import ezvcard.a.b.be;
import ezvcard.property.Source;
import ezvcard.property.VCardProperty;

public final class ax
extends be<Source> {
    public ax() {
        super(Source.class, "SOURCE");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new Source(string2);
    }
}

