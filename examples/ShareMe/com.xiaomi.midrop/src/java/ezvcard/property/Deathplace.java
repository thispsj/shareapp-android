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
public class Deathplace
extends PlaceProperty {
    public Deathplace() {
    }

    public Deathplace(double d2, double d3) {
        super(d2, d3);
    }

    public Deathplace(Deathplace deathplace) {
        super((PlaceProperty)deathplace);
    }

    public Deathplace(String string2) {
        super(string2);
    }

    public Deathplace copy() {
        return new Deathplace(this);
    }
}

