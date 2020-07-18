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
import ezvcard.property.Member;
import ezvcard.property.VCardProperty;

public final class af
extends ay<Member> {
    public af() {
        super(Member.class, "MEMBER");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new Member(string2);
    }
}

