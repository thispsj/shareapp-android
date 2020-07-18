/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.parameter.MediaTypeParameter
 *  ezvcard.property.BinaryProperty
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.String
 */
package ezvcard.property;

import ezvcard.parameter.ImageType;
import ezvcard.parameter.MediaTypeParameter;
import ezvcard.property.BinaryProperty;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ImageProperty
extends BinaryProperty<ImageType> {
    public ImageProperty(ImageProperty imageProperty) {
        super((BinaryProperty)imageProperty);
    }

    public ImageProperty(File file, ImageType imageType) throws IOException {
        super(file, (MediaTypeParameter)imageType);
    }

    public ImageProperty(InputStream inputStream, ImageType imageType) throws IOException {
        super(inputStream, (MediaTypeParameter)imageType);
    }

    public ImageProperty(String string2, ImageType imageType) {
        super(string2, (MediaTypeParameter)imageType);
    }

    public ImageProperty(byte[] arrby, ImageType imageType) {
        super(arrby, (MediaTypeParameter)imageType);
    }
}

