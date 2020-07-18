/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.VCardVersion
 *  ezvcard.c
 *  ezvcard.property.VCardProperty
 *  java.lang.String
 */
package ezvcard.property;

import ezvcard.VCardVersion;
import ezvcard.c;
import ezvcard.property.TextProperty;
import ezvcard.property.VCardProperty;

@c(a={VCardVersion.V3_0, VCardVersion.V4_0})
public class ProductId
extends TextProperty {
    public ProductId(ProductId productId) {
        super(productId);
    }

    public ProductId(String string2) {
        super(string2);
    }

    public ProductId copy() {
        return new ProductId(this);
    }
}

