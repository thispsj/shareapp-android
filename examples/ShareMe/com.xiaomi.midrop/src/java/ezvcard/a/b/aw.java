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
import ezvcard.property.SourceDisplayText;
import ezvcard.property.VCardProperty;

public final class aw
extends ay<SourceDisplayText> {
    public aw() {
        super(SourceDisplayText.class, "NAME");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new SourceDisplayText(string2);
    }
}

