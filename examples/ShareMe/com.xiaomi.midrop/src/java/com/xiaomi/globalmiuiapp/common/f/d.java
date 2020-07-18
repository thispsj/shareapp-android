/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.ArrayMap
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package com.xiaomi.globalmiuiapp.common.f;

import android.util.ArrayMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class d {
    private static final ArrayMap<String, Method> a = new ArrayMap();

    public static String a(String string2) {
        Class class_;
        Method method;
        block3 : {
            class_ = Class.forName((String)"android.os.SystemProperties");
            method = d.a(class_, "get", new Class[]{String.class, String.class});
            if (method != null) break block3;
            return "";
        }
        try {
            String string3 = (String)method.invoke((Object)class_, new Object[]{string2, ""});
            return string3;
        }
        catch (ClassNotFoundException | Exception | IllegalAccessException | InvocationTargetException throwable) {
            return "";
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private static Method a(Class class_, String string2, Class[] arrclass) {
        void var10_12;
        Method method2;
        block8 : {
            Class<d> class_2 = d.class;
            // MONITORENTER : com.xiaomi.globalmiuiapp.common.f.d.class
            ArrayMap<String, Method> arrayMap = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(class_.getName());
            stringBuilder.append(".");
            stringBuilder.append(string2);
            Method method = (Method)arrayMap.get((Object)stringBuilder.toString());
            if (method != null) {
                // MONITOREXIT : class_2
                return method;
            }
            method2 = class_.getMethod(string2, arrclass);
            try {
                arrayMap = a;
                stringBuilder = new StringBuilder();
                stringBuilder.append(class_.getName());
                stringBuilder.append(".");
                stringBuilder.append(string2);
                arrayMap.put((Object)stringBuilder.toString(), (Object)method2);
                return method2;
            }
            catch (NoSuchMethodException noSuchMethodException) {}
            break block8;
            catch (NoSuchMethodException noSuchMethodException) {
                method2 = method;
            }
        }
        var10_12.printStackTrace();
        // MONITOREXIT : class_2
        return method2;
    }
}

