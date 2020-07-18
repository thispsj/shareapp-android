/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.property.VCardProperty
 *  java.lang.Class
 *  java.lang.String
 */
package ezvcard.a.b;

import ezvcard.a.b.ay;
import ezvcard.property.Interest;
import ezvcard.property.VCardProperty;

public final class x
extends ay<Interest> {
    public x() {
        super(Interest.class, "INTEREST");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new Interest(string2);
    }
}

