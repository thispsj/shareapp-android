/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.VCard
 *  ezvcard.VCardVersion
 *  ezvcard.ValidationWarning
 *  ezvcard.c
 *  ezvcard.property.VCardProperty
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package ezvcard.property;

import ezvcard.VCard;
import ezvcard.VCardVersion;
import ezvcard.ValidationWarning;
import ezvcard.c;
import ezvcard.property.TextProperty;
import ezvcard.property.VCardProperty;
import java.util.List;

@c(a={VCardVersion.V3_0})
public class Profile
extends TextProperty {
    public Profile() {
        super("VCARD");
    }

    public Profile(Profile profile) {
        super(profile);
    }

    protected void _validate(List<ValidationWarning> list, VCardVersion vCardVersion, VCard vCard) {
        if (!"VCARD".equalsIgnoreCase((String)this.value)) {
            Object[] arrobject = new Object[]{this.value};
            list.add((Object)new ValidationWarning(18, arrobject));
        }
    }

    public Profile copy() {
        return new Profile(this);
    }
}

