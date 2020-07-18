/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.property.VCardProperty
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.String
 */
package ezvcard.property;

import ezvcard.parameter.ImageType;
import ezvcard.property.ImageProperty;
import ezvcard.property.VCardProperty;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Photo
extends ImageProperty {
    public Photo(Photo photo) {
        super(photo);
    }

    public Photo(File file, ImageType imageType) throws IOException {
        super(file, imageType);
    }

    public Photo(InputStream inputStream, ImageType imageType) throws IOException {
        super(inputStream, imageType);
    }

    public Photo(String string2, ImageType imageType) {
        super(string2, imageType);
    }

    public Photo(byte[] arrby, ImageType imageType) {
        super(arrby, imageType);
    }

    public Photo copy() {
        return new Photo(this);
    }
}

