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
import ezvcard.property.FreeBusyUrl;
import ezvcard.property.VCardProperty;

public final class r
extends be<FreeBusyUrl> {
    public r() {
        super(FreeBusyUrl.class, "FBURL");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new FreeBusyUrl(string2);
    }
}

