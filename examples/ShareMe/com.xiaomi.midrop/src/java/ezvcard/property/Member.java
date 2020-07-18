/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.VCard
 *  ezvcard.VCardVersion
 *  ezvcard.ValidationWarning
 *  ezvcard.c
 *  ezvcard.parameter.Pid
 *  ezvcard.parameter.VCardParameters
 *  ezvcard.property.HasAltId
 *  ezvcard.property.VCardProperty
 *  ezvcard.util.TelUri
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package ezvcard.property;

import ezvcard.VCard;
import ezvcard.VCardVersion;
import ezvcard.ValidationWarning;
import ezvcard.c;
import ezvcard.parameter.Pid;
import ezvcard.parameter.VCardParameters;
import ezvcard.property.HasAltId;
import ezvcard.property.Kind;
import ezvcard.property.UriProperty;
import ezvcard.property.VCardProperty;
import ezvcard.util.TelUri;
import java.util.List;

@c(a={VCardVersion.V4_0})
public class Member
extends UriProperty
implements HasAltId {
    public Member(Member member) {
        super(member);
    }

    public Member(String string2) {
        super(string2);
    }

    public static Member email(String string2) {
        StringBuilder stringBuilder = new StringBuilder("mailto:");
        stringBuilder.append(string2);
        return new Member(stringBuilder.toString());
    }

    public static Member im(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(":");
        stringBuilder.append(string3);
        return new Member(stringBuilder.toString());
    }

    public static Member telephone(TelUri telUri) {
        return new Member(telUri.toString());
    }

    protected void _validate(List<ValidationWarning> list, VCardVersion vCardVersion, VCard vCard) {
        super._validate(list, vCardVersion, vCard);
        if (vCard.a() == null || !vCard.a().isGroup()) {
            list.add((Object)new ValidationWarning(17, new Object[0]));
        }
    }

    public Member copy() {
        return new Member(this);
    }

    public String getAltId() {
        return this.parameters.a();
    }

    public String getMediaType() {
        return this.parameters.e();
    }

    public List<Pid> getPids() {
        return super.getPids();
    }

    public Integer getPref() {
        return super.getPref();
    }

    public String getUri() {
        return (String)this.getValue();
    }

    public void setAltId(String string2) {
        this.parameters.a(string2);
    }

    public void setMediaType(String string2) {
        this.parameters.c(string2);
    }

    public void setPref(Integer n2) {
        super.setPref(n2);
    }

    public void setUri(String string2) {
        this.setValue((Object)string2);
    }
}

