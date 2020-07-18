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
import ezvcard.property.CalendarRequestUri;
import ezvcard.property.VCardProperty;

public final class g
extends be<CalendarRequestUri> {
    public g() {
        super(CalendarRequestUri.class, "CALADRURI");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new CalendarRequestUri(string2);
    }
}

