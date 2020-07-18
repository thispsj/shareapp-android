/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.property.SimpleProperty
 *  java.lang.Object
 *  java.lang.String
 */
package ezvcard.property;

import ezvcard.property.SimpleProperty;

public class TextProperty
extends SimpleProperty<String> {
    public TextProperty(TextProperty textProperty) {
        super((SimpleProperty)textProperty);
        this.value = textProperty.value;
    }

    public TextProperty(String string2) {
        super((Object)string2);
    }
}

