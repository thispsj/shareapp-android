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
import ezvcard.property.Uid;
import ezvcard.property.VCardProperty;

public final class bd
extends be<Uid> {
    public bd() {
        super(Uid.class, "UID");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new Uid(string2);
    }
}

