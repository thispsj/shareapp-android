/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.VCard
 *  ezvcard.VCardVersion
 *  ezvcard.ValidationWarning
 *  ezvcard.parameter.EmailType
 *  ezvcard.parameter.Pid
 *  ezvcard.parameter.VCardParameters
 *  ezvcard.property.HasAltId
 *  ezvcard.property.VCardProperty
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package ezvcard.property;

import ezvcard.VCard;
import ezvcard.VCardVersion;
import ezvcard.ValidationWarning;
import ezvcard.parameter.EmailType;
import ezvcard.parameter.Pid;
import ezvcard.parameter.VCardParameters;
import ezvcard.property.HasAltId;
import ezvcard.property.TextProperty;
import ezvcard.property.VCardProperty;
import java.util.List;

public class Email
extends TextProperty
implements HasAltId {
    public Email(Email email) {
        super(email);
    }

    public Email(String string2) {
        super(string2);
    }

    protected void _validate(List<ValidationWarning> list, VCardVersion vCardVersion, VCard vCard) {
        super._validate(list, vCardVersion, vCard);
        for (EmailType emailType : this.getTypes()) {
            if (emailType == EmailType.c || emailType.a(vCardVersion)) continue;
            Object[] arrobject = new Object[]{emailType.c()};
            list.add((Object)new ValidationWarning(9, arrobject));
        }
    }

    public Email copy() {
        return new Email(this);
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

    public List<EmailType> getTypes() {
        VCardParameters vCardParameters = this.parameters;
        vCardParameters.getClass();
        return new VCardParameters.b<EmailType>(vCardParameters){
            {
                vCardParameters.getClass();
                super(vCardParameters);
            }

            protected EmailType _asObject(String string2) {
                return EmailType.a((String)string2);
            }
        };
    }

    public void setAltId(String string2) {
        this.parameters.a(string2);
    }

    public void setPref(Integer n2) {
        super.setPref(n2);
    }

}

