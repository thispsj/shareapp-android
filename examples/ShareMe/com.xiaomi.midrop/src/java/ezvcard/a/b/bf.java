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
import ezvcard.property.Url;
import ezvcard.property.VCardProperty;

public final class bf
extends be<Url> {
    public bf() {
        super(Url.class, "URL");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new Url(string2);
    }
}

