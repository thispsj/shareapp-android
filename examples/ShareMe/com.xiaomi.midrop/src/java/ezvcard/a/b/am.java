/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.property.VCardProperty
 *  java.lang.Class
 *  java.lang.String
 */
package ezvcard.a.b;

import ezvcard.a.b.ay;
import ezvcard.property.ProductId;
import ezvcard.property.VCardProperty;

public final class am
extends ay<ProductId> {
    public am() {
        super(ProductId.class, "PRODID");
    }

    protected final /* synthetic */ VCardProperty a(String string2) {
        return new ProductId(string2);
    }
}

