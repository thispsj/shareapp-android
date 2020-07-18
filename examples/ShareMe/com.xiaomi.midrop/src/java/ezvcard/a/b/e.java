/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.a.b.l
 *  ezvcard.property.DateOrTimeProperty
 *  ezvcard.util.PartialDate
 *  java.lang.Class
 *  java.lang.String
 *  java.util.Date
 */
package ezvcard.a.b;

import ezvcard.a.b.l;
import ezvcard.property.Birthday;
import ezvcard.property.DateOrTimeProperty;
import ezvcard.util.PartialDate;
import java.util.Date;

public final class e
extends l<Birthday> {
    public e() {
        super(Birthday.class, "BDAY");
    }

    protected final /* synthetic */ DateOrTimeProperty a(PartialDate partialDate) {
        return new Birthday(partialDate);
    }

    protected final /* synthetic */ DateOrTimeProperty a(String string2) {
        return new Birthday(string2);
    }

    protected final /* synthetic */ DateOrTimeProperty a(Date date, boolean bl) {
        return new Birthday(date, bl);
    }
}

