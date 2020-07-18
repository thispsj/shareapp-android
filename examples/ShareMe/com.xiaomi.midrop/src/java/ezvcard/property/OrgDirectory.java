/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.VCardVersion
 *  ezvcard.c
 *  ezvcard.parameter.VCardParameters
 *  ezvcard.property.HasAltId
 *  ezvcard.property.VCardProperty
 *  java.lang.Integer
 *  java.lang.String
 */
package ezvcard.property;

import ezvcard.VCardVersion;
import ezvcard.c;
import ezvcard.parameter.VCardParameters;
import ezvcard.property.HasAltId;
import ezvcard.property.UriProperty;
import ezvcard.property.VCardProperty;

@c(a={VCardVersion.V4_0})
public class OrgDirectory
extends UriProperty
implements HasAltId {
    public OrgDirectory(OrgDirectory orgDirectory) {
        super(orgDirectory);
    }

    public OrgDirectory(String string2) {
        super(string2);
    }

    public OrgDirectory copy() {
        return new OrgDirectory(this);
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

    public void setPref(Integer n2) {
        super.setPref(n2);
    }

    public void setType(String string2) {
        this.parameters.d(string2);
    }
}

