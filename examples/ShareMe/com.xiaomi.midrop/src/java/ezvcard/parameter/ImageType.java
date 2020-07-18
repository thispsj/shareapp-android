/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  ezvcard.parameter.MediaTypeParameter
 *  ezvcard.parameter.b
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package ezvcard.parameter;

import ezvcard.parameter.MediaTypeParameter;
import ezvcard.parameter.b;

public class ImageType
extends MediaTypeParameter {
    public static final ImageType a;
    public static final ImageType b;
    public static final ImageType c;
    private static final b<ImageType> f;

    static {
        f = new b(ImageType.class);
        a = new ImageType("GIF", "image/gif", "gif");
        b = new ImageType("JPEG", "image/jpeg", "jpg");
        c = new ImageType("PNG", "image/png", "png");
    }

    private ImageType(String string2, String string3, String string4) {
        super(string2, string3, string4);
    }

    public static ImageType a(String string2) {
        return (ImageType)((Object)f.b((Object)new String[]{null, null, string2}));
    }

    public static ImageType a(String string2, String string3) {
        return (ImageType)((Object)f.c((Object)new String[]{string2, string3, null}));
    }
}

