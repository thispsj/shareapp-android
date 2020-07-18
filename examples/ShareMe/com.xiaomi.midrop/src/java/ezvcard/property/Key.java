/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.VCard
 *  ezvcard.VCardVersion
 *  ezvcard.ValidationWarning
 *  ezvcard.parameter.MediaTypeParameter
 *  ezvcard.property.BinaryProperty
 *  ezvcard.property.VCardProperty
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Map
 */
package ezvcard.property;

import ezvcard.VCard;
import ezvcard.VCardVersion;
import ezvcard.ValidationWarning;
import ezvcard.parameter.KeyType;
import ezvcard.parameter.MediaTypeParameter;
import ezvcard.property.BinaryProperty;
import ezvcard.property.VCardProperty;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Key
extends BinaryProperty<KeyType> {
    private String text;

    public Key() {
    }

    public Key(Key key) {
        super((BinaryProperty)key);
        this.text = key.text;
    }

    public Key(File file, KeyType keyType) throws IOException {
        super(file, (MediaTypeParameter)keyType);
    }

    public Key(InputStream inputStream, KeyType keyType) throws IOException {
        super(inputStream, (MediaTypeParameter)keyType);
    }

    public Key(String string2, KeyType keyType) {
        super(string2, (MediaTypeParameter)keyType);
    }

    public Key(byte[] arrby, KeyType keyType) {
        super(arrby, (MediaTypeParameter)keyType);
    }

    protected void _validate(List<ValidationWarning> list, VCardVersion vCardVersion, VCard vCard) {
        if (this.url == null && this.data == null && this.text == null) {
            list.add((Object)new ValidationWarning(8, new Object[0]));
        }
        if (this.url != null && (vCardVersion == VCardVersion.V2_1 || vCardVersion == VCardVersion.V3_0)) {
            list.add((Object)new ValidationWarning(15, new Object[0]));
        }
    }

    public Key copy() {
        return new Key(this);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        Key key = (Key)((Object)object);
        return !(this.text == null ? key.text != null : !this.text.equals((Object)key.text));
    }

    public String getText() {
        return this.text;
    }

    public int hashCode() {
        int n2 = 31 * super.hashCode();
        int n3 = this.text == null ? 0 : this.text.hashCode();
        return n2 + n3;
    }

    public void setData(byte[] arrby, KeyType keyType) {
        super.setData(arrby, (MediaTypeParameter)keyType);
        this.text = null;
    }

    public void setText(String string2, KeyType keyType) {
        this.text = string2;
        this.data = null;
        this.url = null;
        this.setContentType((MediaTypeParameter)keyType);
    }

    public void setUrl(String string2, KeyType keyType) {
        super.setUrl(string2, (MediaTypeParameter)keyType);
        this.text = null;
    }

    protected Map<String, Object> toStringValues() {
        Map map = super.toStringValues();
        map.put((Object)"text", (Object)this.text);
        return map;
    }
}

