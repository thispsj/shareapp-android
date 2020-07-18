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
import ezvcard.property.OrgDirectory;
import ezvcard.property.VCardProperty;

public final class ai
extends ay<OrgDirectory> {
    public ai() {
        super(OrgDirectory.class, "ORG-DIRECTORY");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new OrgDirectory(string2);
    }
}

