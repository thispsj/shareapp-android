/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Array
 *  java.lang.reflect.GenericArrayType
 *  java.lang.reflect.GenericDeclaration
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.lang.reflect.TypeVariable
 *  java.lang.reflect.WildcardType
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Map
 *  java.util.NoSuchElementException
 *  java.util.Properties
 */
package com.a.b;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class v {
    static final Type[] a = new Type[0];

    static int a(Object object) {
        if (object != null) {
            return object.hashCode();
        }
        return 0;
    }

    static Type a(Type type) {
        if (type instanceof Class) {
            Class class_ = (Class)type;
            if (class_.isArray()) {
                return new a(v.a((Type)class_.getComponentType()));
            }
            return class_;
        }
        if (type instanceof ParameterizedType) {
            if (type instanceof b) {
                return type;
            }
            ParameterizedType parameterizedType = (ParameterizedType)type;
            return new b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type instanceof a) {
                return type;
            }
            return new a(((GenericArrayType)type).getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            if (type instanceof c) {
                return type;
            }
            WildcardType wildcardType = (WildcardType)type;
            return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
        return type;
    }

    public static Type a(Type type, Class<?> class_) {
        Type type2 = v.b(type, class_, Collection.class);
        if (type2 instanceof WildcardType) {
            type2 = ((WildcardType)type2).getUpperBounds()[0];
        }
        if (type2 instanceof ParameterizedType) {
            return ((ParameterizedType)type2).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static Type a(Type var0_1, Class<?> var1, Class<?> var2_2) {
        block0 : do {
            block8 : {
                if (var2_2 == var1) {
                    return var0_1;
                }
                if (!var2_2.isInterface()) break;
                var6_8 = var1.getInterfaces();
                var8_3 = var6_8.length;
                for (var7_7 = 0; var7_7 < var8_3; ++var7_7) {
                    if (var6_8[var7_7] == var2_2) {
                        return var1.getGenericInterfaces()[var7_7];
                    }
                    if (!var2_2.isAssignableFrom(var6_8[var7_7])) continue;
                    var4_6 = var1.getGenericInterfaces()[var7_7];
                    var3_5 = var6_8[var7_7];
                    break block8;
                }
                break;
            }
lbl16: // 2 sources:
            do {
                var5_4 = var4_6;
                var1 = var3_5;
                var0_1 = var5_4;
                continue block0;
                break;
            } while (true);
            break;
        } while (true);
        if (var1.isInterface() != false) return var2_2;
        while (var1 != Object.class) {
            var3_5 = var1.getSuperclass();
            if (var3_5 == var2_2) {
                return var1.getGenericSuperclass();
            }
            if (var2_2.isAssignableFrom(var3_5)) {
                var4_6 = var1.getGenericSuperclass();
                ** continue;
            }
            var1 = var3_5;
        }
        return var2_2;
    }

    static Type a(Type type, Class<?> class_, Type type2) {
        int n2;
        Class class_2;
        do {
            TypeVariable typeVariable;
            TypeVariable typeVariable2;
            block18 : {
                Type type3;
                boolean bl = type2 instanceof TypeVariable;
                if (!bl) break;
                typeVariable2 = (TypeVariable)type2;
                GenericDeclaration genericDeclaration = typeVariable2.getGenericDeclaration();
                Class class_3 = genericDeclaration instanceof Class ? (Class)genericDeclaration : null;
                if (class_3 != null && (type3 = v.a(type, class_, class_3)) instanceof ParameterizedType) {
                    TypeVariable[] arrtypeVariable = class_3.getTypeParameters();
                    for (n2 = 0; n2 < arrtypeVariable.length; ++n2) {
                        if (!typeVariable2.equals((Object)arrtypeVariable[n2])) continue;
                        typeVariable = ((ParameterizedType)type3).getActualTypeArguments()[n2];
                        break block18;
                    }
                    throw new NoSuchElementException();
                }
                typeVariable = typeVariable2;
            }
            if (typeVariable == typeVariable2) {
                return typeVariable;
            }
            type2 = typeVariable;
        } while (true);
        if (type2 instanceof Class && (class_2 = (Class)type2).isArray()) {
            Type type4;
            Class class_4 = class_2.getComponentType();
            if (class_4 == (type4 = v.a(type, class_, (Type)class_4))) {
                return class_2;
            }
            return v.h(type4);
        }
        if (type2 instanceof GenericArrayType) {
            Type type5;
            GenericArrayType genericArrayType = (GenericArrayType)type2;
            Type type6 = genericArrayType.getGenericComponentType();
            if (type6 == (type5 = v.a(type, class_, type6))) {
                return genericArrayType;
            }
            return v.h(type5);
        }
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)type2;
            Type type7 = parameterizedType.getOwnerType();
            Type type8 = v.a(type, class_, type7);
            boolean bl = type8 != type7;
            Type[] arrtype = parameterizedType.getActualTypeArguments();
            int n3 = arrtype.length;
            while (n2 < n3) {
                Type type9 = v.a(type, class_, arrtype[n2]);
                if (type9 != arrtype[n2]) {
                    if (!bl) {
                        arrtype = (Type[])arrtype.clone();
                        bl = true;
                    }
                    arrtype[n2] = type9;
                }
                ++n2;
            }
            if (bl) {
                return new b(type8, parameterizedType.getRawType(), arrtype);
            }
            return parameterizedType;
        }
        if (type2 instanceof WildcardType) {
            Type type10;
            type2 = (WildcardType)type2;
            Type[] arrtype = type2.getLowerBounds();
            Type[] arrtype2 = type2.getUpperBounds();
            if (arrtype.length == 1) {
                Type type11 = v.a(type, class_, arrtype[0]);
                if (type11 != arrtype[0]) {
                    return new c(new Type[]{Object.class}, new Type[]{type11});
                }
            } else if (arrtype2.length == 1 && (type10 = v.a(type, class_, arrtype2[0])) != arrtype2[0]) {
                return new c(new Type[]{type10}, a);
            }
        }
        return type2;
    }

    static boolean a(Type type, Type type2) {
        do {
            if (type == type2) {
                return true;
            }
            if (type instanceof Class) {
                return type.equals((Object)type2);
            }
            if (type instanceof ParameterizedType) {
                Type type3;
                if (!(type2 instanceof ParameterizedType)) {
                    return false;
                }
                ParameterizedType parameterizedType = (ParameterizedType)type;
                ParameterizedType parameterizedType2 = (ParameterizedType)type2;
                Object[] arrobject = parameterizedType instanceof b ? ((b)parameterizedType).a : parameterizedType.getActualTypeArguments();
                Object[] arrobject2 = parameterizedType2 instanceof b ? ((b)parameterizedType2).a : parameterizedType2.getActualTypeArguments();
                Type type4 = parameterizedType.getOwnerType();
                boolean bl = type4 == (type3 = parameterizedType2.getOwnerType()) || type4 != null && type4.equals((Object)type3);
                return bl && parameterizedType.getRawType().equals((Object)parameterizedType2.getRawType()) && Arrays.equals((Object[])arrobject, (Object[])arrobject2);
            }
            if (!(type instanceof GenericArrayType)) break;
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            GenericArrayType genericArrayType = (GenericArrayType)type;
            GenericArrayType genericArrayType2 = (GenericArrayType)type2;
            type = genericArrayType.getGenericComponentType();
            type2 = genericArrayType2.getGenericComponentType();
        } while (true);
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType)type;
            WildcardType wildcardType2 = (WildcardType)type2;
            return Arrays.equals((Object[])wildcardType.getUpperBounds(), (Object[])wildcardType2.getUpperBounds()) && Arrays.equals((Object[])wildcardType.getLowerBounds(), (Object[])wildcardType2.getLowerBounds());
        }
        if (type instanceof TypeVariable) {
            if (!(type2 instanceof TypeVariable)) {
                return false;
            }
            TypeVariable typeVariable = (TypeVariable)type;
            TypeVariable typeVariable2 = (TypeVariable)type2;
            if (typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals((Object)typeVariable2.getName())) {
                return true;
            }
        }
        return false;
    }

    public static Class<?> b(Type type) {
        do {
            if (type instanceof Class) {
                return (Class)type;
            }
            if (type instanceof ParameterizedType) {
                return (Class)((ParameterizedType)type).getRawType();
            }
            if (type instanceof GenericArrayType) {
                return Array.newInstance(v.b(((GenericArrayType)type).getGenericComponentType()), (int)0).getClass();
            }
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (!(type instanceof WildcardType)) break;
            type = ((WildcardType)type).getUpperBounds()[0];
        } while (true);
        String string2 = type == null ? "null" : type.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder("Expected a Class, ParameterizedType, or GenericArrayType, but <");
        stringBuilder.append((Object)type);
        stringBuilder.append("> is of type ");
        stringBuilder.append(string2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static Type b(Type type, Class<?> class_, Class<?> class_2) {
        if (!class_2.isAssignableFrom(class_)) {
            throw new IllegalArgumentException();
        }
        return v.a(type, class_, v.a(type, class_, class_2));
    }

    static Type[] b(Type type, Class<?> class_) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type type2 = v.b(type, class_, Map.class);
        if (type2 instanceof ParameterizedType) {
            return ((ParameterizedType)type2).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    static String c(Type type) {
        if (type instanceof Class) {
            return ((Class)type).getName();
        }
        return type.toString();
    }

    static Type d(Type type) {
        Class<?> class_ = v.b(type);
        return v.a(type, class_, class_.getGenericSuperclass());
    }

    static Type e(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType)type).getGenericComponentType();
        }
        if (type instanceof Class) {
            return ((Class)type).getComponentType();
        }
        return null;
    }

    static boolean f(Type type) {
        return type == Boolean.class || type == Byte.class || type == Character.class || type == Double.class || type == Float.class || type == Integer.class || type == Long.class || type == Short.class || type == String.class || type == Object.class;
        {
        }
    }

    static void g(Type type) {
        if (type instanceof Class && ((Class)type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    private static GenericArrayType h(Type type) {
        return new a(type);
    }

    private static final class a
    implements GenericArrayType {
        private final Type a;

        public a(Type type) {
            this.a = v.a(type);
        }

        public final boolean equals(Object object) {
            return object instanceof GenericArrayType && v.a((Type)this, (Type)((GenericArrayType)object));
        }

        public final Type getGenericComponentType() {
            return this.a;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(v.c(this.a));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }
    }

    private static final class b
    implements ParameterizedType {
        final Type[] a;
        private final Type b;
        private final Type c;

        /* varargs */ b(Type type, Type type2, Type ... arrtype) {
            boolean bl = type2 instanceof Class;
            int n2 = 0;
            if (bl) {
                boolean bl2 = true;
                boolean bl3 = type == null;
                if (((Class)type2).getEnclosingClass() != null) {
                    bl2 = false;
                }
                if (bl3 != bl2) {
                    StringBuilder stringBuilder = new StringBuilder("unexpected owner type for ");
                    stringBuilder.append((Object)type2);
                    stringBuilder.append(": ");
                    stringBuilder.append((Object)type);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            Type type3 = type == null ? null : v.a(type);
            this.b = type3;
            this.c = v.a(type2);
            this.a = (Type[])arrtype.clone();
            while (n2 < this.a.length) {
                if (this.a[n2] == null) {
                    throw new NullPointerException();
                }
                v.g(this.a[n2]);
                this.a[n2] = v.a(this.a[n2]);
                ++n2;
            }
        }

        public final boolean equals(Object object) {
            return object instanceof ParameterizedType && v.a((Type)this, (Type)((ParameterizedType)object));
        }

        public final Type[] getActualTypeArguments() {
            return (Type[])this.a.clone();
        }

        public final Type getOwnerType() {
            return this.b;
        }

        public final Type getRawType() {
            return this.c;
        }

        public final int hashCode() {
            return Arrays.hashCode((Object[])this.a) ^ this.c.hashCode() ^ v.a((Object)this.b);
        }

        public final String toString() {
            int n2;
            int n3 = this.a.length;
            StringBuilder stringBuilder = new StringBuilder(30 * (n3 + n2));
            stringBuilder.append(v.c(this.c));
            if (this.a.length == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append("<");
            stringBuilder.append(v.c(this.a[0]));
            for (n2 = 1; n2 < this.a.length; ++n2) {
                stringBuilder.append(", ");
                stringBuilder.append(v.c(this.a[n2]));
            }
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    private static final class c
    implements WildcardType {
        private final Type a;
        private final Type b;

        /*
         * Enabled aggressive block sorting
         */
        public c(Type[] arrtype, Type[] arrtype2) {
            void var3_4;
            if (arrtype2.length > 1) {
                throw new IllegalArgumentException();
            }
            if (arrtype.length != 1) {
                throw new IllegalArgumentException();
            }
            if (arrtype2.length == 1) {
                if (arrtype2[0] == null) {
                    throw new NullPointerException();
                }
                v.g(arrtype2[0]);
                if (arrtype[0] != Object.class) {
                    throw new IllegalArgumentException();
                }
                this.b = v.a(arrtype2[0]);
                Class<Object> class_ = Object.class;
            } else {
                if (arrtype[0] == null) {
                    throw new NullPointerException();
                }
                v.g(arrtype[0]);
                this.b = null;
                Type type = v.a(arrtype[0]);
            }
            this.a = var3_4;
        }

        public final boolean equals(Object object) {
            return object instanceof WildcardType && v.a((Type)this, (Type)((WildcardType)object));
        }

        public final Type[] getLowerBounds() {
            if (this.b != null) {
                Type[] arrtype = new Type[]{this.b};
                return arrtype;
            }
            return v.a;
        }

        public final Type[] getUpperBounds() {
            Type[] arrtype = new Type[]{this.a};
            return arrtype;
        }

        public final int hashCode() {
            int n2 = this.b != null ? 31 + this.b.hashCode() : 1;
            return n2 ^ 31 + this.a.hashCode();
        }

        /*
         * Enabled aggressive block sorting
         */
        public final String toString() {
            StringBuilder stringBuilder;
            Type type;
            if (this.b != null) {
                stringBuilder = new StringBuilder("? super ");
                type = this.b;
            } else {
                if (this.a == Object.class) {
                    return "?";
                }
                stringBuilder = new StringBuilder("? extends ");
                type = this.a;
            }
            stringBuilder.append(v.c(type));
            return stringBuilder.toString();
        }
    }

}

