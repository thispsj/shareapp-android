/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.parameter.Pid
 *  ezvcard.parameter.VCardParameters
 *  ezvcard.property.HasAltId
 *  ezvcard.property.VCardProperty
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package ezvcard.property;

import ezvcard.parameter.Pid;
import ezvcard.parameter.VCardParameters;
import ezvcard.property.HasAltId;
import ezvcard.property.TextListProperty;
import ezvcard.property.VCardProperty;
import java.util.List;

public class Organization
extends TextListProperty
implements HasAltId {
    public Organization() {
    }

    public Organization(Organization organization) {
        super(organization);
    }

    public Organization copy() {
        return new Organization(this);
    }

    public String getAltId() {
        return this.parameters.a();
    }

    public String getLanguage() {
        return super.getLanguage();
    }

    public List<Pid> getPids() {
        return super.getPids();
    }

    public Integer getPref() {
        return super.getPref();
    }

    public List<String> getSortAs() {
        return this.parameters.b((Object)"SORT-AS");
    }

    public String getType() {
        return this.parameters.g();
    }

    public void setAltId(String string2) {
        this.parameters.a(string2);
    }

    public void setLanguage(String string2) {
        super.setLanguage(string2);
    }

    public void setPref(Integer n2) {
        super.setPref(n2);
    }

    public void setSortAs(String string2) {
        this.parameters.a(new String[]{string2});
    }

    public void setType(String string2) {
        this.parameters.d(string2);
    }
}

