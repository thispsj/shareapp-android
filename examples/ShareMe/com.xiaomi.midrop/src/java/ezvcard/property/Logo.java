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

public class Logo
extends ImageProperty {
    public Logo(Logo logo) {
        super(logo);
    }

    public Logo(File file, ImageType imageType) throws IOException {
        super(file, imageType);
    }

    public Logo(InputStream inputStream, ImageType imageType) throws IOException {
        super(inputStream, imageType);
    }

    public Logo(String string2, ImageType imageType) {
        super(string2, imageType);
    }

    public Logo(byte[] arrby, ImageType imageType) {
        super(arrby, imageType);
    }

    public Logo copy() {
        return new Logo(this);
    }

    public String getLanguage() {
        return super.getLanguage();
    }

    public void setLanguage(String string2) {
        super.setLanguage(string2);
    }
}

