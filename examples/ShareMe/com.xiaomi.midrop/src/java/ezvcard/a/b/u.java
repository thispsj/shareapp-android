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
import ezvcard.property.Hobby;
import ezvcard.property.VCardProperty;

public final class u
extends ay<Hobby> {
    public u() {
        super(Hobby.class, "HOBBY");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new Hobby(string2);
    }
}

