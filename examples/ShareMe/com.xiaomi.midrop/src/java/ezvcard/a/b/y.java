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
import ezvcard.parameter.KeyType;
import ezvcard.parameter.MediaTypeParameter;
import ezvcard.property.BinaryProperty;
import ezvcard.property.Key;

public final class y
extends d<Key, KeyType> {
    public y() {
        super(Key.class, "KEY");
    }

    protected final /* synthetic */ BinaryProperty a(String string2, MediaTypeParameter mediaTypeParameter) {
        return new Key(string2, (KeyType)mediaTypeParameter);
    }

    protected final /* synthetic */ BinaryProperty a(byte[] arrby, MediaTypeParameter mediaTypeParameter) {
        return new Key(arrby, (KeyType)mediaTypeParameter);
    }

    protected final /* synthetic */ MediaTypeParameter b(String string2) {
        return KeyType.a(string2, null);
    }

    protected final /* synthetic */ MediaTypeParameter c(String string2) {
        return KeyType.a(string2);
    }
}

