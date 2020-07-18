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
import ezvcard.property.DateOrTimeProperty;
import ezvcard.property.Deathdate;
import ezvcard.util.PartialDate;
import java.util.Date;

public final class m
extends l<Deathdate> {
    public m() {
        super(Deathdate.class, "DEATHDATE");
    }

    protected final /* synthetic */ DateOrTimeProperty a(PartialDate partialDate) {
        return new Deathdate(partialDate);
    }

    protected final /* synthetic */ DateOrTimeProperty a(String string2) {
        return new Deathdate(string2);
    }

    protected final /* synthetic */ DateOrTimeProperty a(Date date, boolean bl) {
        return new Deathdate(date, bl);
    }
}

