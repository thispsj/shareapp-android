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
import ezvcard.property.FormattedName;
import ezvcard.property.VCardProperty;

public final class q
extends ay<FormattedName> {
    public q() {
        super(FormattedName.class, "FN");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new FormattedName(string2);
    }
}

