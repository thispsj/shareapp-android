/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.VCard
 *  ezvcard.VCardDataType
 *  ezvcard.VCardVersion
 *  ezvcard.ValidationWarning
 *  ezvcard.property.VCardProperty
 *  java.lang.Object
 *  java.lang.String
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 */
package ezvcard.property;

import com.github.a.a.a;
import com.github.a.a.c.b;
import ezvcard.VCard;
import ezvcard.VCardDataType;
import ezvcard.VCardVersion;
import ezvcard.ValidationWarning;
import ezvcard.property.TextProperty;
import ezvcard.property.VCardProperty;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RawProperty
extends TextProperty {
    private VCardDataType dataType;
    private String propertyName;

    public RawProperty(RawProperty rawProperty) {
        super(rawProperty);
        this.propertyName = rawProperty.propertyName;
        this.dataType = rawProperty.dataType;
    }

    public RawProperty(String string2, String string3) {
        super(string2, string3, null);
    }

    public RawProperty(String string2, String string3, VCardDataType vCardDataType) {
        super(string3);
        this.propertyName = string2;
        this.dataType = vCardDataType;
    }

    protected void _validate(List<ValidationWarning> list, VCardVersion vCardVersion, VCard vCard) {
        a a2 = vCardVersion.getSyntaxStyle();
        com.github.a.a.c.a a3 = b.b(a2);
        if (!a3.a(this.propertyName)) {
            if (a2 == a.a) {
                com.github.a.a.c.a a4 = a3.a();
                Object[] arrobject = new Object[]{this.propertyName, a4.a(true)};
                list.add((Object)new ValidationWarning(33, arrobject));
                return;
            }
            Object[] arrobject = new Object[]{this.propertyName};
            list.add((Object)new ValidationWarning(24, arrobject));
        }
    }

    public RawProperty copy() {
        return new RawProperty(this);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        RawProperty rawProperty = (RawProperty)((Object)object);
        if (this.dataType == null ? rawProperty.dataType != null : !this.dataType.equals((Object)rawProperty.dataType)) {
            return false;
        }
        return !(this.propertyName == null ? rawProperty.propertyName != null : !this.propertyName.equalsIgnoreCase(rawProperty.propertyName));
    }

    public VCardDataType getDataType() {
        return this.dataType;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public int hashCode() {
        int n2 = 31 * super.hashCode();
        int n3 = this.dataType == null ? 0 : this.dataType.hashCode();
        int n4 = 31 * (n2 + n3);
        int n5 = this.propertyName == null ? 0 : this.propertyName.toLowerCase().hashCode();
        return n4 + n5;
    }

    public void setDataType(VCardDataType vCardDataType) {
        this.dataType = vCardDataType;
    }

    public void setPropertyName(String string2) {
        this.propertyName = string2;
    }

    protected Map<String, Object> toStringValues() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put((Object)"propertyName", (Object)this.propertyName);
        linkedHashMap.put((Object)"dataType", (Object)this.dataType);
        linkedHashMap.put((Object)"value", this.value);
        return linkedHashMap;
    }
}

