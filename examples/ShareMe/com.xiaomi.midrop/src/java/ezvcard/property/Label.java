/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.VCardVersion
 *  ezvcard.c
 *  ezvcard.parameter.AddressType
 *  ezvcard.parameter.VCardParameters
 *  ezvcard.property.VCardProperty
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package ezvcard.property;

import ezvcard.VCardVersion;
import ezvcard.c;
import ezvcard.parameter.AddressType;
import ezvcard.parameter.VCardParameters;
import ezvcard.property.TextProperty;
import ezvcard.property.VCardProperty;
import java.util.List;

@c(a={VCardVersion.V2_1, VCardVersion.V3_0})
public class Label
extends TextProperty {
    public Label(Label label) {
        super(label);
    }

    public Label(String string2) {
        super(string2);
    }

    public Label copy() {
        return new Label(this);
    }

    public String getLanguage() {
        return super.getLanguage();
    }

    public List<AddressType> getTypes() {
        VCardParameters vCardParameters = this.parameters;
        vCardParameters.getClass();
        return new VCardParameters.b<AddressType>(vCardParameters){
            {
                vCardParameters.getClass();
                super(vCardParameters);
            }

            protected AddressType _asObject(String string2) {
                return AddressType.a((String)string2);
            }
        };
    }

    public void setLanguage(String string2) {
        super.setLanguage(string2);
    }

}

