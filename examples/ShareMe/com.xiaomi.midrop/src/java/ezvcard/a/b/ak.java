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
import ezvcard.property.Photo;

public final class ak
extends v<Photo> {
    public ak() {
        super(Photo.class, "PHOTO");
    }

    protected final /* synthetic */ BinaryProperty a(String string2, MediaTypeParameter mediaTypeParameter) {
        return new Photo(string2, (ImageType)mediaTypeParameter);
    }

    protected final /* synthetic */ BinaryProperty a(byte[] arrby, MediaTypeParameter mediaTypeParameter) {
        return new Photo(arrby, (ImageType)mediaTypeParameter);
    }
}

