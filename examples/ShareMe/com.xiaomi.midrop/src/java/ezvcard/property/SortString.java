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
public class SortString
extends TextProperty {
    public SortString(SortString sortString) {
        super(sortString);
    }

    public SortString(String string2) {
        super(string2);
    }

    public SortString copy() {
        return new SortString(this);
    }
}

