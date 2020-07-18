/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.property.VCardProperty
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.UUID
 */
package ezvcard.property;

import ezvcard.property.UriProperty;
import ezvcard.property.VCardProperty;
import java.util.UUID;

public class Uid
extends UriProperty {
    public Uid(Uid uid) {
        super(uid);
    }

    public Uid(String string2) {
        super(string2);
    }

    public static Uid random() {
        String string2 = UUID.randomUUID().toString();
        StringBuilder stringBuilder = new StringBuilder("urn:uuid:");
        stringBuilder.append(string2);
        return new Uid(stringBuilder.toString());
    }

    public Uid copy() {
        return new Uid(this);
    }
}

