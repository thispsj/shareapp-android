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
import ezvcard.property.SortString;
import ezvcard.property.VCardProperty;

public final class au
extends ay<SortString> {
    public au() {
        super(SortString.class, "SORT-STRING");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new SortString(string2);
    }
}

