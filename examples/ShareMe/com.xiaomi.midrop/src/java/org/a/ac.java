/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Environment
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package org.a;

import android.os.Environment;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ac {
    static int a = 65536;
    public static int b = 2121;
    public static final String c = Environment.getExternalStorageDirectory().getPath();
    public static final String d;
    private static int e = 256;

    static {
        String string2 = ac.c() ? "big5" : "UTF-8";
        d = string2;
    }

    public static int a() {
        return e;
    }

    public static int b() {
        return a;
    }

    private static boolean c() {
        String string2 = "";
        try {
            String string3;
            Class class_ = Class.forName((String)"android.os.SystemProperties");
            string2 = string3 = (String)class_.getMethod("get", new Class[]{String.class, String.class}).invoke((Object)class_, new Object[]{"ro.product.mod_device", ""});
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        }
        catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        }
        catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        return "aries_tw".equals((Object)string2);
    }
}

