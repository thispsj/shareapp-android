/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.netty.d.b.g
 *  io.netty.d.b.x$1
 *  io.netty.d.b.x$a
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Array
 *  java.lang.reflect.GenericArrayType
 *  java.lang.reflect.GenericDeclaration
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.lang.reflect.TypeVariable
 *  java.util.HashMap
 *  java.util.IdentityHashMap
 *  java.util.Map
 */
package io.netty.d.b;

import io.netty.d.b.g;
import io.netty.d.b.x;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/*
 * Exception performing whole class analysis.
 */
public abstract class x {
    private static final x a;

    static {
        a = new 1();
    }

    x() {
    }

    public static x a(Object object, Class<?> class_, String string2) {
        x x2;
        Map map;
        Class class_2;
        g g2 = g.b();
        Map map2 = g2.k;
        if (map2 == null) {
            g2.k = map2 = new IdentityHashMap();
        }
        if ((map = (Map)map2.get((Object)(class_2 = object.getClass()))) == null) {
            map = new HashMap();
            map2.put((Object)class_2, (Object)map);
        }
        if ((x2 = (x)map.get((Object)string2)) == null) {
            x x3;
            Class<?> class_3 = x.b(object, class_, string2);
            g g3 = g.b();
            Map map3 = g3.j;
            if (map3 == null) {
                g3.j = map3 = new IdentityHashMap();
            }
            if ((x3 = (x)map3.get(class_3)) == null) {
                x3 = class_3 == Object.class ? a : new /* Unavailable Anonymous Inner Class!! */;
                map3.put(class_3, (Object)x3);
            }
            x2 = x3;
            map.put((Object)string2, (Object)x2);
        }
        return x2;
    }

    private static Class<?> a(Class<?> class_, String string2) {
        StringBuilder stringBuilder = new StringBuilder("cannot determine the type of the type parameter '");
        stringBuilder.append(string2);
        stringBuilder.append("': ");
        stringBuilder.append(class_);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private static Class<?> b(Object object, Class<?> class_, String string2) {
        Class class_2 = object.getClass();
        String string3 = string2;
        Class class_3 = class_;
        block0 : do {
            Class class_4 = class_2;
            do {
                if (class_4.getSuperclass() != class_3) continue;
                int n2 = -1;
                TypeVariable[] arrtypeVariable = class_4.getSuperclass().getTypeParameters();
                for (int i2 = 0; i2 < arrtypeVariable.length; ++i2) {
                    if (!string3.equals((Object)arrtypeVariable[i2].getName())) continue;
                    n2 = i2;
                    break;
                }
                if (n2 < 0) {
                    StringBuilder stringBuilder = new StringBuilder("unknown type parameter '");
                    stringBuilder.append(string3);
                    stringBuilder.append("': ");
                    stringBuilder.append(class_3);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                Type type = class_4.getGenericSuperclass();
                if (!(type instanceof ParameterizedType)) {
                    return Object.class;
                }
                Type type2 = ((ParameterizedType)type).getActualTypeArguments()[n2];
                if (type2 instanceof ParameterizedType) {
                    type2 = ((ParameterizedType)type2).getRawType();
                }
                if (type2 instanceof Class) {
                    return (Class)type2;
                }
                if (type2 instanceof GenericArrayType) {
                    Type type3 = ((GenericArrayType)type2).getGenericComponentType();
                    if (type3 instanceof ParameterizedType) {
                        type3 = ((ParameterizedType)type3).getRawType();
                    }
                    if (type3 instanceof Class) {
                        return Array.newInstance((Class)((Class)type3), (int)0).getClass();
                    }
                }
                if (type2 instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable)type2;
                    if (!(typeVariable.getGenericDeclaration() instanceof Class)) {
                        return Object.class;
                    }
                    class_3 = (Class)typeVariable.getGenericDeclaration();
                    string3 = typeVariable.getName();
                    if (class_3.isAssignableFrom(class_2)) continue block0;
                    return Object.class;
                }
                return x.a(class_2, string3);
            } while ((class_4 = class_4.getSuperclass()) != null);
            break;
        } while (true);
        return x.a(class_2, string3);
    }

    public abstract boolean a(Object var1);
}

