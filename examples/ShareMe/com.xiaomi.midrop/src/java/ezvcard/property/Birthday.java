/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.property.DateOrTimeProperty
 *  ezvcard.property.VCardProperty
 *  ezvcard.util.PartialDate
 *  java.lang.String
 *  java.util.Date
 */
package ezvcard.property;

import ezvcard.property.DateOrTimeProperty;
import ezvcard.property.VCardProperty;
import ezvcard.util.PartialDate;
import java.util.Date;

public class Birthday
extends DateOrTimeProperty {
    public Birthday(Birthday birthday) {
        super((DateOrTimeProperty)birthday);
    }

    public Birthday(PartialDate partialDate) {
        super(partialDate);
    }

    public Birthday(String string2) {
        super(string2);
    }

    public Birthday(Date date) {
        super(date);
    }

    public Birthday(Date date, boolean bl) {
        super(date, bl);
    }

    public Birthday copy() {
        return new Birthday(this);
    }
}

