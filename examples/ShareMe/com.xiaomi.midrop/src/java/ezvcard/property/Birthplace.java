/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.VCardVersion
 *  ezvcard.c
 *  ezvcard.property.PlaceProperty
 *  ezvcard.property.VCardProperty
 *  java.lang.String
 */
package ezvcard.property;

import ezvcard.VCardVersion;
import ezvcard.c;
import ezvcard.property.PlaceProperty;
import ezvcard.property.VCardProperty;

@c(a={VCardVersion.V4_0})
public class Birthplace
extends PlaceProperty {
    public Birthplace() {
    }

    public Birthplace(double d2, double d3) {
        super(d2, d3);
    }

    public Birthplace(Birthplace birthplace) {
        super((PlaceProperty)birthplace);
    }

    public Birthplace(String string2) {
        super(string2);
    }

    public Birthplace copy() {
        return new Birthplace(this);
    }
}

