/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.VCardVersion
 *  ezvcard.c
 *  ezvcard.property.VCardProperty
 *  java.lang.String
 */
package ezvcard.property;

import ezvcard.VCardVersion;
import ezvcard.c;
import ezvcard.property.TextProperty;
import ezvcard.property.VCardProperty;

@c(a={VCardVersion.V2_1, VCardVersion.V3_0})
public class Mailer
extends TextProperty {
    public Mailer(Mailer mailer) {
        super(mailer);
    }

    public Mailer(String string2) {
        super(string2);
    }

    public Mailer copy() {
        return new Mailer(this);
    }
}

