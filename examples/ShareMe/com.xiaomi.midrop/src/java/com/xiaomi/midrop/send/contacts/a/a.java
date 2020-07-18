/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.VCard
 *  ezvcard.VCardVersion
 *  ezvcard.ValidationWarning
 *  ezvcard.property.VCardProperty
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.xiaomi.midrop.send.contacts.a;

import ezvcard.VCard;
import ezvcard.VCardVersion;
import ezvcard.ValidationWarning;
import ezvcard.property.VCardProperty;
import java.util.ArrayList;
import java.util.List;

public class a
extends VCardProperty {
    String a;
    List<String> b = new ArrayList();
    private boolean c;

    protected void _validate(List<ValidationWarning> list, VCardVersion vCardVersion, VCard vCard) {
        if (this.a == null) {
            list.add((Object)new ValidationWarning("No type specified."));
        }
        if (true ^ this.c && this.b.size() != 1) {
            list.add((Object)new ValidationWarning("Items must contain exactly one value."));
        }
    }
}

