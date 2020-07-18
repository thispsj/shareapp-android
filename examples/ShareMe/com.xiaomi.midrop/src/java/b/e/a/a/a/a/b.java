/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.ConnectivityManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.ResultReceiver
 *  android.util.Log
 *  com.xiaomi.midrop.MiDropApplication
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.Integer
 *  java.lang.NoSuchFieldException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  midrop.service.c.d
 */
package b.e.a.a.a.a;

import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;
import com.xiaomi.midrop.MiDropApplication;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import midrop.service.c.d;

public final class b {
    public static boolean a(ConnectivityManager connectivityManager) {
        String string2;
        String string3;
        void var1_7;
        if (Build.VERSION.SDK_INT > 26) {
            return b.c(connectivityManager);
        }
        try {
            Class[] arrclass = new Class[]{Integer.TYPE};
            Method method = ConnectivityManager.class.getMethod("stopTethering", arrclass);
            method.setAccessible(true);
            Object[] arrobject = new Object[]{0};
            method.invoke((Object)connectivityManager, arrobject);
            return true;
        }
        catch (InvocationTargetException invocationTargetException) {
            string2 = "WifiManagerReflector";
            string3 = "InvocationTargetException";
        }
        catch (IllegalAccessException illegalAccessException) {
            string2 = "WifiManagerReflector";
            string3 = "IllegalAccessException";
        }
        catch (NoSuchMethodException noSuchMethodException) {
            string2 = "WifiManagerReflector";
            string3 = "NoSuchMethodException";
        }
        Log.e((String)string2, (String)string3, (Throwable)var1_7);
        return false;
    }

    public static boolean b(ConnectivityManager connectivityManager) {
        void var1_8;
        String string2;
        String string3;
        if (Build.VERSION.SDK_INT > 26) {
            return b.e(connectivityManager);
        }
        if (Build.VERSION.SDK_INT > 25) {
            return b.d(connectivityManager);
        }
        try {
            Class[] arrclass = new Class[]{Integer.TYPE, Boolean.TYPE, Class.forName((String)"android.net.ConnectivityManager$OnStartTetheringCallback")};
            Method method = ConnectivityManager.class.getMethod("startTethering", arrclass);
            method.setAccessible(true);
            Object[] arrobject = new Object[]{0, true, null};
            method.invoke((Object)connectivityManager, arrobject);
            return true;
        }
        catch (InvocationTargetException invocationTargetException) {
            string3 = "WifiManagerReflector";
            string2 = "InvocationTargetException";
        }
        catch (IllegalAccessException illegalAccessException) {
            string3 = "WifiManagerReflector";
            string2 = "IllegalAccessException";
        }
        catch (NoSuchMethodException noSuchMethodException) {
            string3 = "WifiManagerReflector";
            string2 = "NoSuchMethodException";
        }
        catch (ClassNotFoundException classNotFoundException) {
            string3 = "WifiManagerReflector";
            string2 = "ClassNotFoundException";
        }
        Log.e((String)string3, (String)string2, (Throwable)var1_8);
        return false;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static boolean c(ConnectivityManager connectivityManager) {
        void var2_10;
        String string3;
        String string2;
        try {
            Field field = connectivityManager.getClass().getDeclaredField("mService");
            field.setAccessible(true);
            Object object = field.get((Object)connectivityManager);
            Class class_ = object.getClass();
            Class[] arrclass = new Class[]{Integer.TYPE, String.class};
            Method method = class_.getMethod("stopTethering", arrclass);
            method.setAccessible(true);
            Object[] arrobject = new Object[]{0, MiDropApplication.a().getPackageName()};
            method.invoke(object, arrobject);
            return true;
        }
        catch (InvocationTargetException invocationTargetException) {
            string3 = "WifiManagerReflector";
            string2 = "InvocationTargetException";
        }
        catch (IllegalAccessException illegalAccessException) {
            string3 = "WifiManagerReflector";
            string2 = "IllegalAccessException";
        }
        catch (NoSuchMethodException noSuchMethodException) {
            string3 = "WifiManagerReflector";
            string2 = "NoSuchMethodException";
        }
        Log.e((String)string3, (String)string2, (Throwable)var2_10);
        return false;
        catch (NoSuchFieldException noSuchFieldException) {}
        return false;
    }

    private static boolean d(ConnectivityManager connectivityManager) {
        void var1_11;
        String string2;
        String string3;
        try {
            Field field = connectivityManager.getClass().getDeclaredField("mService");
            field.setAccessible(true);
            Object object = field.get((Object)connectivityManager);
            Class[] arrclass = new Class[]{Integer.TYPE, ResultReceiver.class, Boolean.TYPE};
            Method method = object.getClass().getMethod("startTethering", arrclass);
            method.setAccessible(true);
            ResultReceiver resultReceiver = new ResultReceiver(){

                protected final void onReceiveResult(int n2, Bundle bundle) {
                }
            };
            Object[] arrobject = new Object[]{0, resultReceiver, true};
            method.invoke(object, arrobject);
            return true;
        }
        catch (InvocationTargetException invocationTargetException) {
            string3 = "WifiManagerReflector";
            string2 = "InvocationTargetException";
        }
        catch (NoSuchMethodException noSuchMethodException) {
            string3 = "WifiManagerReflector";
            string2 = "NoSuchMethodException";
        }
        catch (IllegalAccessException illegalAccessException) {
            string3 = "WifiManagerReflector";
            string2 = "IllegalAccessException";
        }
        catch (NoSuchFieldException noSuchFieldException) {
            string3 = "WifiManagerReflector";
            string2 = "NoSuchFieldException";
        }
        d.a((String)string3, (String)string2, (Throwable)var1_11, (Object[])new Object[0]);
        return false;
    }

    private static boolean e(ConnectivityManager connectivityManager) {
        void var1_11;
        String string2;
        String string3;
        try {
            Field field = connectivityManager.getClass().getDeclaredField("mService");
            field.setAccessible(true);
            Object object = field.get((Object)connectivityManager);
            Class[] arrclass = new Class[]{Integer.TYPE, ResultReceiver.class, Boolean.TYPE, String.class};
            Method method = object.getClass().getMethod("startTethering", arrclass);
            method.setAccessible(true);
            ResultReceiver resultReceiver = new ResultReceiver(){

                protected final void onReceiveResult(int n2, Bundle bundle) {
                }
            };
            Object[] arrobject = new Object[]{0, resultReceiver, true, MiDropApplication.a().getPackageName()};
            method.invoke(object, arrobject);
            return true;
        }
        catch (InvocationTargetException invocationTargetException) {
            string3 = "WifiManagerReflector";
            string2 = "InvocationTargetException";
        }
        catch (NoSuchMethodException noSuchMethodException) {
            string3 = "WifiManagerReflector";
            string2 = "NoSuchMethodException";
        }
        catch (IllegalAccessException illegalAccessException) {
            string3 = "WifiManagerReflector";
            string2 = "IllegalAccessException";
        }
        catch (NoSuchFieldException noSuchFieldException) {
            string3 = "WifiManagerReflector";
            string2 = "NoSuchFieldException";
        }
        d.a((String)string3, (String)string2, (Throwable)var1_11, (Object[])new Object[0]);
        return false;
    }

}

