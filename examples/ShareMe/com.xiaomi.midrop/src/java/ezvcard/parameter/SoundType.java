/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.parameter.MediaTypeParameter
 *  ezvcard.parameter.b
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package ezvcard.parameter;

import ezvcard.parameter.MediaTypeParameter;
import ezvcard.parameter.b;

public class SoundType
extends MediaTypeParameter {
    public static final SoundType a;
    public static final SoundType b;
    public static final SoundType c;
    public static final SoundType f;
    public static final SoundType g;
    public static final SoundType h;
    private static final b<SoundType> i;

    static {
        i = new b(SoundType.class);
        a = new SoundType("AAC", "audio/aac", "aac");
        b = new SoundType("MIDI", "audio/midi", "mid");
        c = new SoundType("MP3", "audio/mp3", "mp3");
        f = new SoundType("MPEG", "audio/mpeg", "mpeg");
        g = new SoundType("OGG", "audio/ogg", "ogg");
        h = new SoundType("WAV", "audio/wav", "wav");
    }

    private SoundType(String string2, String string3, String string4) {
        super(string2, string3, string4);
    }

    public static SoundType a(String string2) {
        return (SoundType)((Object)i.b((Object)new String[]{null, null, string2}));
    }

    public static SoundType a(String string2, String string3) {
        return (SoundType)((Object)i.c((Object)new String[]{string2, string3, null}));
    }
}

