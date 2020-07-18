/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.a.b.c$1
 *  com.a.b.c$2
 *  com.a.b.c$3
 *  com.a.b.c$4
 *  java.io.ObjectInputStream
 *  java.io.ObjectStreamClass
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.InstantiationException
 *  java.lang.Integer
 *  java.lang.NoSuchFieldException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Field
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package com.a.b;

import com.a.b.c;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class c<T> {
    c() {
    }

    public static <T> c<T> a(Class<?> class_) {
        try {
            Constructor constructor = class_.getDeclaredConstructor(new Class[0]);
            constructor.setAccessible(true);
            1 var16_2 = new 1(constructor, class_);
            return var16_2;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            try {
                Class class_2 = Class.forName((String)"sun.misc.Unsafe");
                Field field = class_2.getDeclaredField("theUnsafe");
                field.setAccessible(true);
                Object object = field.get(null);
                2 var14_6 = new 2(class_2.getMethod("allocateInstance", new Class[]{Class.class}), object, class_);
                return var14_6;
            }
            catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException throwable) {
                try {
                    Method method = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                    method.setAccessible(true);
                    int n2 = (Integer)method.invoke(null, new Object[]{Object.class});
                    Class[] arrclass = new Class[]{Class.class, Integer.TYPE};
                    Method method2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", arrclass);
                    method2.setAccessible(true);
                    3 var10_11 = new 3(method2, class_, n2);
                    return var10_11;
                }
                catch (NoSuchMethodException noSuchMethodException2) {
                    try {
                        Method method = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                        method.setAccessible(true);
                        4 var5_13 = new 4(method, class_);
                        return var5_13;
                    }
                    catch (Exception exception) {
                        StringBuilder stringBuilder = new StringBuilder("cannot construct instances of ");
                        stringBuilder.append(class_.getName());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                catch (InvocationTargetException invocationTargetException) {
                    throw new RuntimeException((Throwable)invocationTargetException);
                }
                catch (IllegalAccessException illegalAccessException) {
                    throw new AssertionError();
                }
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new AssertionError();
            }
        }
    }

    abstract T a() throws InvocationTargetException, IllegalAccessException, InstantiationException;
}

