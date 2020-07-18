/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Array
 *  java.lang.reflect.GenericArrayType
 *  java.lang.reflect.GenericDeclaration
 *  java.lang.reflect.Modifier
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.lang.reflect.TypeVariable
 *  java.lang.reflect.WildcardType
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Map
 *  java.util.NoSuchElementException
 *  java.util.Properties
 */
package com.google.a.b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class b {
    static final Type[] a = new Type[0];

    static int a(Object object) {
        if (object != null) {
            return object.hashCode();
        }
        return 0;
    }

    public static Type a(Type type) {
        if (type instanceof Class) {
            Object object = (Class)type;
            if (object.isArray()) {
                object = new a(b.a((Type)object.getComponentType()));
            }
            return (Type)object;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)type;
            return new b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType)type).getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType)type;
            return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
        return type;
    }

    public static Type a(Type type, Class<?> class_) {
        Type type2 = b.b(type, class_, Collection.class);
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

    public static Type a(Type type, Class<?> class_, Type type2) {
        return b.a(type, class_, type2, (Collection<TypeVariable>)new HashSet());
    }

    private static Type a(Type type, Class<?> class_, Type type2, Collection<TypeVariable> collection) {
        Class class_2;
        int n2;
        block18 : {
            TypeVariable typeVariable;
            block0 : do {
                Type type3;
                boolean bl = type2 instanceof TypeVariable;
                if (!bl) break block18;
                typeVariable = (TypeVariable)type2;
                if (collection.contains((Object)typeVariable)) {
                    return type2;
                }
                collection.add((Object)typeVariable);
                GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
                Class class_3 = genericDeclaration instanceof Class ? (Class)genericDeclaration : null;
                if (class_3 != null && (type3 = b.a(type, class_, class_3)) instanceof ParameterizedType) {
                    TypeVariable[] arrtypeVariable = class_3.getTypeParameters();
                    int n3 = arrtypeVariable.length;
                    for (n2 = 0; n2 < n3; ++n2) {
                        if (!typeVariable.equals((Object)arrtypeVariable[n2])) continue;
                        type2 = ((ParameterizedType)type3).getActualTypeArguments()[n2];
                        continue block0;
                    }
                    throw new NoSuchElementException();
                }
                type2 = typeVariable;
            } while (type2 != typeVariable);
            return type2;
        }
        if (type2 instanceof Class && (class_2 = (Class)type2).isArray()) {
            Type type4;
            Class class_4 = class_2.getComponentType();
            if (class_4 == (type4 = b.a(type, class_, (Type)class_4, collection))) {
                return class_2;
            }
            return b.f(type4);
        }
        if (type2 instanceof GenericArrayType) {
            Type type5;
            GenericArrayType genericArrayType = (GenericArrayType)type2;
            Type type6 = genericArrayType.getGenericComponentType();
            if (type6 == (type5 = b.a(type, class_, type6, collection))) {
                return genericArrayType;
            }
            return b.f(type5);
        }
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)type2;
            Type type7 = parameterizedType.getOwnerType();
            Type type8 = b.a(type, class_, type7, collection);
            boolean bl = type8 != type7;
            Type[] arrtype = parameterizedType.getActualTypeArguments();
            int n4 = arrtype.length;
            while (n2 < n4) {
                Type type9 = b.a(type, class_, arrtype[n2], collection);
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
                Type type11 = b.a(type, class_, arrtype[0], collection);
                if (type11 != arrtype[0]) {
                    Type[] arrtype3 = type11 instanceof WildcardType ? ((WildcardType)type11).getLowerBounds() : new Type[]{type11};
                    return new c(new Type[]{Object.class}, arrtype3);
                }
            } else if (arrtype2.length == 1 && (type10 = b.a(type, class_, arrtype2[0], collection)) != arrtype2[0]) {
                Type[] arrtype4 = type10 instanceof WildcardType ? ((WildcardType)type10).getUpperBounds() : new Type[]{type10};
                return new c(arrtype4, a);
            }
        }
        return type2;
    }

    public static boolean a(Type type, Type type2) {
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
                Type type4 = parameterizedType.getOwnerType();
                boolean bl = type4 == (type3 = parameterizedType2.getOwnerType()) || type4 != null && type4.equals((Object)type3);
                return bl && parameterizedType.getRawType().equals((Object)parameterizedType2.getRawType()) && Arrays.equals((Object[])parameterizedType.getActualTypeArguments(), (Object[])parameterizedType2.getActualTypeArguments());
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
                Type type2 = ((ParameterizedType)type).getRawType();
                com.google.a.b.a.a(type2 instanceof Class);
                return (Class)type2;
            }
            if (type instanceof GenericArrayType) {
                return Array.newInstance(b.b(((GenericArrayType)type).getGenericComponentType()), (int)0).getClass();
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
        if (type instanceof WildcardType) {
            type = ((WildcardType)type).getUpperBounds()[0];
        }
        com.google.a.b.a.a(class_2.isAssignableFrom(class_));
        return b.a(type, class_, b.a(type, class_, class_2));
    }

    public static Type[] b(Type type, Class<?> class_) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type type2 = b.b(type, class_, Map.class);
        if (type2 instanceof ParameterizedType) {
            return ((ParameterizedType)type2).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static String c(Type type) {
        if (type instanceof Class) {
            return ((Class)type).getName();
        }
        return type.toString();
    }

    public static Type d(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType)type).getGenericComponentType();
        }
        return ((Class)type).getComponentType();
    }

    static void e(Type type) {
        boolean bl = !(type instanceof Class) || !((Class)type).isPrimitive();
        com.google.a.b.a.a(bl);
    }

    private static GenericArrayType f(Type type) {
        return new a(type);
    }

    private static final class a
    implements Serializable,
    GenericArrayType {
        private static final long serialVersionUID;
        private final Type a;

        public a(Type type) {
            this.a = b.a(type);
        }

        public final boolean equals(Object object) {
            return object instanceof GenericArrayType && b.a((Type)this, (Type)((GenericArrayType)object));
        }

        public final Type getGenericComponentType() {
            return this.a;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b.c(this.a));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }
    }

    private static final class b
    implements Serializable,
    ParameterizedType {
        private static final long serialVersionUID;
        private final Type a;
        private final Type b;
        private final Type[] c;

        public /* varargs */ b(Type type, Type type2, Type ... arrtype) {
            boolean bl = type2 instanceof Class;
            int n2 = 0;
            if (bl) {
                Class class_ = (Class)type2;
                boolean bl2 = Modifier.isStatic((int)class_.getModifiers());
                boolean bl3 = true;
                boolean bl4 = bl2 || class_.getEnclosingClass() == null;
                if (type == null && !bl4) {
                    bl3 = false;
                }
                com.google.a.b.a.a(bl3);
            }
            Type type3 = type == null ? null : b.a(type);
            this.a = type3;
            this.b = b.a(type2);
            this.c = (Type[])arrtype.clone();
            int n3 = this.c.length;
            while (n2 < n3) {
                com.google.a.b.a.a(this.c[n2]);
                b.e(this.c[n2]);
                this.c[n2] = b.a(this.c[n2]);
                ++n2;
            }
        }

        public final boolean equals(Object object) {
            return object instanceof ParameterizedType && b.a((Type)this, (Type)((ParameterizedType)object));
        }

        public final Type[] getActualTypeArguments() {
            return (Type[])this.c.clone();
        }

        public final Type getOwnerType() {
            return this.a;
        }

        public final Type getRawType() {
            return this.b;
        }

        public final int hashCode() {
            return Arrays.hashCode((Object[])this.c) ^ this.b.hashCode() ^ b.a((Object)this.a);
        }

        public final String toString() {
            int n2 = this.c.length;
            if (n2 == 0) {
                return b.c(this.b);
            }
            StringBuilder stringBuilder = new StringBuilder(30 * (n2 + 1));
            stringBuilder.append(b.c(this.b));
            stringBuilder.append("<");
            stringBuilder.append(b.c(this.c[0]));
            for (int i2 = 1; i2 < n2; ++i2) {
                stringBuilder.append(", ");
                stringBuilder.append(b.c(this.c[i2]));
            }
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    private static final class c
    implements Serializable,
    WildcardType {
        private static final long serialVersionUID;
        private final Type a;
        private final Type b;

        /*
         * Enabled aggressive block sorting
         */
        public c(Type[] arrtype, Type[] arrtype2) {
            void var8_8;
            int n2 = arrtype2.length;
            int n3 = 1;
            boolean bl = n2 <= n3;
            com.google.a.b.a.a(bl);
            boolean bl2 = arrtype.length == n3;
            com.google.a.b.a.a(bl2);
            if (arrtype2.length == n3) {
                com.google.a.b.a.a(arrtype2[0]);
                b.e(arrtype2[0]);
                if (arrtype[0] != Object.class) {
                    n3 = 0;
                }
                com.google.a.b.a.a((boolean)n3);
                this.b = b.a(arrtype2[0]);
                Class<Object> class_ = Object.class;
            } else {
                com.google.a.b.a.a(arrtype[0]);
                b.e(arrtype[0]);
                this.b = null;
                Type type = b.a(arrtype[0]);
            }
            this.a = var8_8;
        }

        public final boolean equals(Object object) {
            return object instanceof WildcardType && b.a((Type)this, (Type)((WildcardType)object));
        }

        public final Type[] getLowerBounds() {
            if (this.b != null) {
                Type[] arrtype = new Type[]{this.b};
                return arrtype;
            }
            return b.a;
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
            stringBuilder.append(b.c(type));
            return stringBuilder.toString();
        }
    }

}

