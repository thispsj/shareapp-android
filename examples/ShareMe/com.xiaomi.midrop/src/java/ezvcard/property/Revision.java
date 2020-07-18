/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.property.SimpleProperty
 *  ezvcard.property.VCardProperty
 *  java.lang.Object
 *  java.util.Date
 */
package ezvcard.property;

import ezvcard.property.SimpleProperty;
import ezvcard.property.VCardProperty;
import java.util.Date;

public class Revision
extends SimpleProperty<Date> {
    public Revision(Revision revision) {
        super((SimpleProperty)revision);
        Date date = revision.value == null ? null : new Date(((Date)revision.value).getTime());
        this.value = date;
    }

    public Revision(Date date) {
        super((Object)date);
    }

    public static Revision now() {
        return new Revision(new Date());
    }

    public Revision copy() {
        return new Revision(this);
    }
}

