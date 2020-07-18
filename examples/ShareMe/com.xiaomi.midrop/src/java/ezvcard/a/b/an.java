/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.property.VCardProperty
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package ezvcard.a.b;

import ezvcard.a.b.ay;
import ezvcard.property.Profile;
import ezvcard.property.VCardProperty;

public final class an
extends ay<Profile> {
    public an() {
        super(Profile.class, "PROFILE");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        Profile profile = new Profile();
        profile.setValue((Object)string2);
        return profile;
    }
}

