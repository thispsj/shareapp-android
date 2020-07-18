/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.VCardVersion
 *  ezvcard.c
 *  ezvcard.property.DateOrTimeProperty
 *  ezvcard.property.VCardProperty
 *  ezvcard.util.PartialDate
 *  java.lang.String
 *  java.util.Date
 */
package ezvcard.property;

import ezvcard.VCardVersion;
import ezvcard.c;
import ezvcard.property.DateOrTimeProperty;
import ezvcard.property.VCardProperty;
import ezvcard.util.PartialDate;
import java.util.Date;

@c(a={VCardVersion.V4_0})
public class Anniversary
extends DateOrTimeProperty {
    public Anniversary(Anniversary anniversary) {
        super((DateOrTimeProperty)anniversary);
    }

    public Anniversary(PartialDate partialDate) {
        super(partialDate);
    }

    public Anniversary(String string2) {
        super(string2);
    }

    public Anniversary(Date date) {
        super(date);
    }

    public Anniversary(Date date, boolean bl) {
        super(date, bl);
    }

    public Anniversary copy() {
        return new Anniversary(this);
    }
}

