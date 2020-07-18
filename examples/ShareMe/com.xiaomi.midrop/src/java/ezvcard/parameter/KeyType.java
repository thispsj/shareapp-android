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

public class KeyType
extends MediaTypeParameter {
    public static final KeyType a;
    public static final KeyType b;
    public static final KeyType c;
    private static final b<KeyType> f;

    static {
        f = new b(KeyType.class);
        a = new KeyType("PGP", "application/pgp-keys", "pgp");
        b = new KeyType("GPG", "application/gpg", "gpg");
        c = new KeyType("X509", "application/x509", null);
    }

    private KeyType(String string2, String string3, String string4) {
        super(string2, string3, string4);
    }

    public static KeyType a(String string2) {
        return (KeyType)((Object)f.b((Object)new String[]{null, null, string2}));
    }

    public static KeyType a(String string2, String string3) {
        return (KeyType)((Object)f.c((Object)new String[]{string2, string3, null}));
    }
}

