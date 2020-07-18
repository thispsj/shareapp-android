/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.VCardVersion
 *  ezvcard.c
 *  ezvcard.parameter.Pid
 *  ezvcard.parameter.VCardParameters
 *  ezvcard.property.HasAltId
 *  ezvcard.property.VCardProperty
 *  java.lang.Integer
 *  java.lang.String
 *  java.util.List
 */
package ezvcard.property;

import ezvcard.VCardVersion;
import ezvcard.c;
import ezvcard.parameter.Pid;
import ezvcard.parameter.VCardParameters;
import ezvcard.property.HasAltId;
import ezvcard.property.TextListProperty;
import ezvcard.property.VCardProperty;
import java.util.List;

@c(a={VCardVersion.V3_0, VCardVersion.V4_0})
public class Nickname
extends TextListProperty
implements HasAltId {
    public Nickname() {
    }

    public Nickname(Nickname nickname) {
        super(nickname);
    }

    public Nickname copy() {
        return new Nickname(this);
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

    public void setType(String string2) {
        this.parameters.d(string2);
    }
}

