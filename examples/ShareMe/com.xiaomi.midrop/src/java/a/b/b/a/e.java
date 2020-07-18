/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  a.b.b.a.a
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Field
 */
package a.b.b.a;

import a.b.b.a.a;
import a.e.b.d;
import java.lang.reflect.Field;

public final class e {
    static final int a(a a2) {
        int n2;
        block6 : {
            block5 : {
                Object object;
                block4 : {
                    try {
                        Field field = a2.getClass().getDeclaredField("label");
                        d.a((Object)field, "field");
                        field.setAccessible(true);
                        object = field.get((Object)a2);
                        if (object instanceof Integer) break block4;
                        object = null;
                    }
                    catch (Exception exception) {
                        return -1;
                    }
                }
                Integer n3 = (Integer)object;
                if (n3 == null) break block5;
                n2 = n3;
                break block6;
            }
            n2 = 0;
        }
        return n2 - 1;
    }
}

