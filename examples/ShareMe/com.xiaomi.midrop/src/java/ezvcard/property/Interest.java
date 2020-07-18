/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.VCardVersion
 *  ezvcard.c
 *  ezvcard.parameter.InterestLevel
 *  ezvcard.parameter.VCardParameters
 *  ezvcard.property.HasAltId
 *  ezvcard.property.VCardProperty
 *  java.lang.Integer
 *  java.lang.String
 */
package ezvcard.property;

import ezvcard.VCardVersion;
import ezvcard.c;
import ezvcard.parameter.InterestLevel;
import ezvcard.parameter.VCardParameters;
import ezvcard.property.HasAltId;
import ezvcard.property.TextProperty;
import ezvcard.property.VCardProperty;

@c(a={VCardVersion.V4_0})
public class Interest
extends TextProperty
implements HasAltId {
    public Interest(Interest interest) {
        super(interest);
    }

    public Interest(String string2) {
        super(string2);
    }

    public Interest copy() {
        return new Interest(this);
    }

    public String getAltId() {
        return this.parameters.a();
    }

    public Integer getIndex() {
        return super.getIndex();
    }

    public String getLanguage() {
        return super.getLanguage();
    }

    public InterestLevel getLevel() {
        String string2 = this.parameters.d();
        if (string2 == null) {
            return null;
        }
        return InterestLevel.a((String)string2);
    }

    public Integer getPref() {
        return super.getPref();
    }

    public String getType() {
        return this.parameters.g();
    }

    public void setAltId(String string2) {
        this.parameters.a(string2);
    }

    public void setIndex(Integer n2) {
        super.setIndex(n2);
    }

    public void setLanguage(String string2) {
        super.setLanguage(string2);
    }

    public void setLevel(InterestLevel interestLevel) {
        String string2 = interestLevel == null ? null : interestLevel.c();
        this.parameters.b(string2);
    }

    public void setPref(Integer n2) {
        super.setPref(n2);
    }

    public void setType(String string2) {
        this.parameters.d(string2);
    }
}

