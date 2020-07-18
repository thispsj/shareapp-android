/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.VCardDataType
 *  ezvcard.property.VCardProperty
 *  java.lang.Class
 *  java.lang.String
 */
package ezvcard.a.b;

import ezvcard.VCardDataType;
import ezvcard.a.b.ay;
import ezvcard.property.Language;
import ezvcard.property.VCardProperty;

public final class ab
extends ay<Language> {
    public ab() {
        super(Language.class, "LANG", VCardDataType.o);
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new Language(string2);
    }
}

