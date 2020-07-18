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

@c(a={VCardVersion.V3_0})
public class Classification
extends TextProperty {
    public Classification(Classification classification) {
        super(classification);
    }

    public Classification(String string2) {
        super(string2);
    }

    public Classification copy() {
        return new Classification(this);
    }
}

