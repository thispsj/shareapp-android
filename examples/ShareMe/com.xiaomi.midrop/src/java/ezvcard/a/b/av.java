/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.a.b.d
 *  ezvcard.parameter.MediaTypeParameter
 *  ezvcard.property.BinaryProperty
 *  java.lang.Class
 *  java.lang.String
 */
package ezvcard.a.b;

import ezvcard.a.b.d;
import ezvcard.parameter.MediaTypeParameter;
import ezvcard.parameter.SoundType;
import ezvcard.property.BinaryProperty;
import ezvcard.property.Sound;

public final class av
extends d<Sound, SoundType> {
    public av() {
        super(Sound.class, "SOUND");
    }

    protected final /* synthetic */ BinaryProperty a(String string2, MediaTypeParameter mediaTypeParameter) {
        return new Sound(string2, (SoundType)mediaTypeParameter);
    }

    protected final /* synthetic */ BinaryProperty a(byte[] arrby, MediaTypeParameter mediaTypeParameter) {
        return new Sound(arrby, (SoundType)mediaTypeParameter);
    }

    protected final /* synthetic */ MediaTypeParameter b(String string2) {
        return SoundType.a(string2, null);
    }

    protected final /* synthetic */ MediaTypeParameter c(String string2) {
        return SoundType.a(string2);
    }
}

