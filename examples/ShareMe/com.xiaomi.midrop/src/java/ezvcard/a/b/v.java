/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.a.b.d
 *  ezvcard.parameter.MediaTypeParameter
 *  java.lang.Class
 *  java.lang.String
 */
package ezvcard.a.b;

import ezvcard.a.b.d;
import ezvcard.parameter.ImageType;
import ezvcard.parameter.MediaTypeParameter;
import ezvcard.property.ImageProperty;

public abstract class v<T extends ImageProperty>
extends d<T, ImageType> {
    public v(Class<T> class_, String string2) {
        super(class_, string2);
    }

    protected final /* synthetic */ MediaTypeParameter b(String string2) {
        return ImageType.a(string2, null);
    }

    protected final /* synthetic */ MediaTypeParameter c(String string2) {
        return ImageType.a(string2);
    }
}

