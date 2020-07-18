/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.wifi.WifiConfiguration
 *  android.net.wifi.WifiManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.Integer
 *  java.lang.NoSuchFieldException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.lang.reflect.Proxy
 *  java.util.ArrayList
 *  midrop.service.c.d
 */
package b.e.a.a.a.a;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Log;
import b.e.a.a.a.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

public final class d {
    private static ArrayList<String> a;

    static {
        ArrayList arrayList;
        a = arrayList = new ArrayList();
        arrayList.add((Object)"acer_t04");
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static int a(WifiManager wifiManager) {
        Method method;
        block5 : {
            method = WifiManager.class.getMethod("getWifiApState", new Class[0]);
            if (method != null) break block5;
            Log.d((String)"WifiManagerReflector", (String)"method not found: getWifiApState");
            return 0;
        }
        method.setAccessible(true);
        try {
            return (Integer)method.invoke((Object)wifiManager, new Object[0]);
        }
        catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
            return 0;
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
            return 0;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        }
        return 0;
    }

    private static Class a() {
        try {
            Class class_ = Class.forName((String)"android.net.wifi.WifiManager$ActionListener");
            return class_;
        }
        catch (ClassNotFoundException classNotFoundException) {
            midrop.service.c.d.a((String)"WifiManagerReflector", (String)"getActionListenerClass", (Throwable)classNotFoundException, (Object[])new Object[0]);
            return null;
        }
    }

    private static Field a(String string2) {
        try {
            Field field = WifiConfiguration.class.getDeclaredField(string2);
            return field;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            return null;
        }
    }

    public static void a(WifiConfiguration wifiConfiguration, int n2) {
        Field field = d.a("channel");
        if (field == null) {
            field = d.a("apChannel");
        }
        if (field == null) {
            Log.e((String)"WifiManagerReflector", (String)"channel not found");
            return;
        }
        field.setAccessible(true);
        try {
            field.setInt((Object)wifiConfiguration, n2);
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean a(WifiManager wifiManager, int n2) {
        String string2;
        String string3;
        Class[] arrclass;
        Class class_;
        block6 : {
            class_ = wifiManager.getClass();
            arrclass = new Class[]{Integer.TYPE, d.a()};
            if (arrclass[1] != null) break block6;
            return false;
        }
        Method method = class_.getDeclaredMethod("forget", arrclass);
        if (method == null) return false;
        try {
            method.setAccessible(true);
            ClassLoader classLoader = arrclass[1].getClassLoader();
            Class[] arrclass2 = new Class[]{arrclass[1]};
            Object object = Proxy.newProxyInstance((ClassLoader)classLoader, (Class[])arrclass2, (InvocationHandler)new a(null));
            Object[] arrobject = new Object[]{n2, object};
            method.invoke((Object)wifiManager, arrobject);
            return true;
        }
        catch (IllegalAccessException illegalAccessException) {
            string2 = "WifiManagerReflector";
            string3 = illegalAccessException.toString();
        }
        catch (InvocationTargetException invocationTargetException) {
            string2 = "WifiManagerReflector";
            string3 = invocationTargetException.toString();
        }
        catch (NoSuchMethodException noSuchMethodException) {
            string2 = "WifiManagerReflector";
            string3 = noSuchMethodException.toString();
        }
        midrop.service.c.d.b((String)string2, (String)string3, (Object[])new Object[0]);
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean a(WifiManager wifiManager, int n2, a.a a2) {
        String string2;
        String string3;
        Class[] arrclass;
        Class class_;
        block6 : {
            class_ = wifiManager.getClass();
            arrclass = new Class[]{Integer.TYPE, d.a()};
            if (arrclass[1] != null) break block6;
            return false;
        }
        Method method = class_.getDeclaredMethod("connect", arrclass);
        if (method == null) return false;
        try {
            method.setAccessible(true);
            ClassLoader classLoader = arrclass[1].getClassLoader();
            Class[] arrclass2 = new Class[]{arrclass[1]};
            Object object = Proxy.newProxyInstance((ClassLoader)classLoader, (Class[])arrclass2, (InvocationHandler)new a(a2));
            Object[] arrobject = new Object[]{n2, object};
            method.invoke((Object)wifiManager, arrobject);
            return true;
        }
        catch (IllegalAccessException illegalAccessException) {
            string3 = "WifiManagerReflector";
            string2 = illegalAccessException.toString();
        }
        catch (InvocationTargetException invocationTargetException) {
            string3 = "WifiManagerReflector";
            string2 = invocationTargetException.toString();
        }
        catch (NoSuchMethodException noSuchMethodException) {
            string3 = "WifiManagerReflector";
            string2 = noSuchMethodException.toString();
        }
        midrop.service.c.d.b((String)string3, (String)string2, (Object[])new Object[0]);
        return false;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean a(WifiManager wifiManager, WifiConfiguration wifiConfiguration) {
        Method method;
        block5 : {
            method = WifiManager.class.getMethod("setWifiApConfiguration", new Class[]{WifiConfiguration.class});
            if (method != null) break block5;
            Log.d((String)"WifiManagerReflector", (String)"method not found: setWifiApConfiguration");
            return false;
        }
        method.setAccessible(true);
        try {
            return (Boolean)method.invoke((Object)wifiManager, new Object[]{wifiConfiguration});
        }
        catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
            return false;
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
            return false;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        }
        return false;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean a(WifiManager wifiManager, WifiConfiguration wifiConfiguration, boolean bl) {
        Method method;
        block4 : {
            Class[] arrclass = new Class[]{WifiConfiguration.class, Boolean.TYPE};
            method = WifiManager.class.getMethod("setWifiApEnabled", arrclass);
            if (method != null) break block4;
            Log.d((String)"WifiManagerReflector", (String)"method not found: setWifiApEnabled");
            return false;
        }
        method.setAccessible(true);
        try {
            Object[] arrobject = new Object[]{wifiConfiguration, bl};
            return (Boolean)method.invoke((Object)wifiManager, arrobject);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static WifiConfiguration b(WifiManager wifiManager) {
        String string2;
        String string3;
        StringBuilder stringBuilder;
        Class class_ = wifiManager.getClass();
        Method method = class_.getMethod("getWifiApConfiguration", new Class[0]);
        if (method == null) return null;
        try {
            method.setAccessible(true);
            return (WifiConfiguration)method.invoke((Object)wifiManager, new Object[0]);
        }
        catch (InvocationTargetException invocationTargetException) {
            string2 = "WifiManagerReflector";
            stringBuilder = new StringBuilder("getWifiApConfiguration:");
            string3 = invocationTargetException.toString();
        }
        catch (IllegalAccessException illegalAccessException) {
            string2 = "WifiManagerReflector";
            stringBuilder = new StringBuilder("getWifiApConfiguration:");
            string3 = illegalAccessException.toString();
        }
        catch (NoSuchMethodException noSuchMethodException) {
            string2 = "WifiManagerReflector";
            stringBuilder = new StringBuilder("getWifiApConfiguration:");
            string3 = noSuchMethodException.toString();
        }
        stringBuilder.append(string3);
        midrop.service.c.d.b((String)string2, (String)stringBuilder.toString(), (Object[])new Object[0]);
        return null;
    }

    public static void b(WifiConfiguration wifiConfiguration, int n2) {
        Field field = d.a("apBand");
        if (field == null) {
            Log.d((String)"WifiManagerReflector", (String)"apBand not found");
            return;
        }
        field.setAccessible(true);
        try {
            field.setInt((Object)wifiConfiguration, n2);
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean c(WifiManager wifiManager) {
        String string2;
        String string3;
        StringBuilder stringBuilder;
        Class class_ = wifiManager.getClass();
        Method method = class_.getMethod("isDualBandSupported", new Class[0]);
        if (method == null) return false;
        try {
            method.setAccessible(true);
            return (Boolean)method.invoke((Object)wifiManager, new Object[0]);
        }
        catch (IllegalAccessException illegalAccessException) {
            string2 = "WifiManagerReflector";
            stringBuilder = new StringBuilder("isDualBandSupported");
            string3 = illegalAccessException.toString();
        }
        catch (InvocationTargetException invocationTargetException) {
            string2 = "WifiManagerReflector";
            stringBuilder = new StringBuilder("isDualBandSupported:");
            string3 = invocationTargetException.toString();
        }
        catch (NoSuchMethodException noSuchMethodException) {
            string2 = "WifiManagerReflector";
            stringBuilder = new StringBuilder("isDualBandSupported:");
            string3 = noSuchMethodException.toString();
        }
        stringBuilder.append(string3);
        midrop.service.c.d.b((String)string2, (String)stringBuilder.toString(), (Object[])new Object[0]);
        return false;
    }

    public static boolean d(WifiManager wifiManager) {
        if (a.contains((Object)Build.DEVICE)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return wifiManager.is5GHzBandSupported();
        }
        return d.c(wifiManager);
    }

    public static boolean e(WifiManager wifiManager) {
        if (Build.VERSION.SDK_INT >= 21) {
            return wifiManager.isP2pSupported();
        }
        return d.c(wifiManager);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String f(WifiManager wifiManager) {
        if (Build.VERSION.SDK_INT < 23) return null;
        Class class_ = wifiManager.getClass();
        Method method = class_.getDeclaredMethod("getCountryCode", new Class[0]);
        if (method == null) return null;
        try {
            method.setAccessible(true);
            return (String)method.invoke((Object)wifiManager, new Object[0]);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}

