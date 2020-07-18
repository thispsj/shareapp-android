/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.property.VCardProperty
 *  java.lang.Class
 *  java.lang.String
 */
package ezvcard.a.b;

import ezvcard.a.b.ay;
import ezvcard.property.Note;
import ezvcard.property.VCardProperty;

public final class ah
extends ay<Note> {
    public ah() {
        super(Note.class, "NOTE");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new Note(string2);
    }
}

