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
public class Deathdate
extends DateOrTimeProperty {
    public Deathdate(Deathdate deathdate) {
        super((DateOrTimeProperty)deathdate);
    }

    public Deathdate(PartialDate partialDate) {
        super(partialDate);
    }

    public Deathdate(String string2) {
        super(string2);
    }

    public Deathdate(Date date) {
        super(date);
    }

    public Deathdate(Date date, boolean bl) {
        super(date, bl);
    }

    public Deathdate copy() {
        return new Deathdate(this);
    }
}

