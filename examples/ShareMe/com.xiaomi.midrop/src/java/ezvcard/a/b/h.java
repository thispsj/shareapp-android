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
import ezvcard.property.CalendarUri;
import ezvcard.property.VCardProperty;

public final class h
extends be<CalendarUri> {
    public h() {
        super(CalendarUri.class, "CALURI");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new CalendarUri(string2);
    }
}

