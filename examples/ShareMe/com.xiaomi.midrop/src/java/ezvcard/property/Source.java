/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.parameter.Pid
 *  ezvcard.parameter.VCardParameters
 *  ezvcard.property.HasAltId
 *  ezvcard.property.VCardProperty
 *  java.lang.Integer
 *  java.lang.String
 *  java.util.List
 */
package ezvcard.property;

import ezvcard.parameter.Pid;
import ezvcard.parameter.VCardParameters;
import ezvcard.property.HasAltId;
import ezvcard.property.UriProperty;
import ezvcard.property.VCardProperty;
import java.util.List;

public class Source
extends UriProperty
implements HasAltId {
    public Source(Source source) {
        super(source);
    }

    public Source(String string2) {
        super(string2);
    }

    public Source copy() {
        return new Source(this);
    }

    public String getAltId() {
        return this.parameters.a();
    }

    public List<Pid> getPids() {
        return super.getPids();
    }

    public Integer getPref() {
        return super.getPref();
    }

    public void setAltId(String string2) {
        this.parameters.a(string2);
    }

    public void setPref(Integer n2) {
        super.setPref(n2);
    }
}

