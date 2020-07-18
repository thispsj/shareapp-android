/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.parameter.MediaTypeParameter
 *  ezvcard.property.BinaryProperty
 *  ezvcard.property.VCardProperty
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.String
 */
package ezvcard.property;

import ezvcard.parameter.MediaTypeParameter;
import ezvcard.parameter.SoundType;
import ezvcard.property.BinaryProperty;
import ezvcard.property.VCardProperty;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Sound
extends BinaryProperty<SoundType> {
    public Sound(Sound sound) {
        super((BinaryProperty)sound);
    }

    public Sound(File file, SoundType soundType) throws IOException {
        super(file, (MediaTypeParameter)soundType);
    }

    public Sound(InputStream inputStream, SoundType soundType) throws IOException {
        super(inputStream, (MediaTypeParameter)soundType);
    }

    public Sound(String string2, SoundType soundType) {
        super(string2, (MediaTypeParameter)soundType);
    }

    public Sound(byte[] arrby, SoundType soundType) {
        super(arrby, (MediaTypeParameter)soundType);
    }

    public Sound copy() {
        return new Sound(this);
    }

    public String getLanguage() {
        return super.getLanguage();
    }

    public void setLanguage(String string2) {
        super.setLanguage(string2);
    }
}

