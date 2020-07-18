/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.parameter.MediaTypeParameter
 *  ezvcard.property.BinaryProperty
 *  java.lang.Class
 *  java.lang.String
 */
package ezvcard.a.b;

import ezvcard.a.b.v;
import ezvcard.parameter.ImageType;
import ezvcard.parameter.MediaTypeParameter;
import ezvcard.property.BinaryProperty;
import ezvcard.property.Logo;

public final class ad
extends v<Logo> {
    public ad() {
        super(Logo.class, "LOGO");
    }

    protected final /* synthetic */ BinaryProperty a(String string2, MediaTypeParameter mediaTypeParameter) {
        return new Logo(string2, (ImageType)mediaTypeParameter);
    }

    protected final /* synthetic */ BinaryProperty a(byte[] arrby, MediaTypeParameter mediaTypeParameter) {
        return new Logo(arrby, (ImageType)mediaTypeParameter);
    }
}

