/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.VCardDataType
 *  ezvcard.a.b.at
 *  java.lang.Class
 *  java.lang.String
 */
package ezvcard.a.b;

import ezvcard.VCardDataType;
import ezvcard.a.b.at;
import ezvcard.property.TextProperty;

public abstract class ay<T extends TextProperty>
extends at<T> {
    public ay(Class<T> class_, String string2) {
        super(class_, string2, VCardDataType.e);
    }

    public ay(Class<T> class_, String string2, VCardDataType vCardDataType) {
        super(class_, string2, vCardDataType);
    }
}

