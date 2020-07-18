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
import ezvcard.property.Email;
import ezvcard.property.VCardProperty;

public final class o
extends ay<Email> {
    public o() {
        super(Email.class, "EMAIL");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new Email(string2);
    }
}

