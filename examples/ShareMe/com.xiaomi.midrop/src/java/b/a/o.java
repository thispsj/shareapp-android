/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  com.xiaomi.midrop.MiDropApplication
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 *  java.security.InvalidParameterException
 *  midrop.service.c.d
 */
package b.a;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.midrop.MiDropApplication;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import midrop.service.c.d;

public final class o {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String a() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Field field = bluetoothAdapter.getClass().getDeclaredField("mService");
        if (field == null) return "";
        field.setAccessible(true);
        Object object = field.get((Object)bluetoothAdapter);
        if (object == null) return "";
        Method method = object.getClass().getDeclaredMethod("getAddress", new Class[0]);
        if (method == null) return "";
        method.setAccessible(true);
        Object object2 = method.invoke(object, new Object[0]);
        if (object2 == null) return "";
        try {
            if (!(object2 instanceof String)) return "";
            return (String)object2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return "";
    }

    public static boolean a(BluetoothAdapter bluetoothAdapter, String string2) {
        if (bluetoothAdapter != null && !TextUtils.isEmpty((CharSequence)string2)) {
            int n2;
            if (!bluetoothAdapter.isEnabled()) {
                return false;
            }
            int n3 = string2.getBytes().length;
            if (n3 > 248) {
                StringBuilder stringBuilder = new StringBuilder("too long ");
                stringBuilder.append(n3);
                throw new InvalidParameterException(stringBuilder.toString());
            }
            for (n2 = 0; n2 < 3 && !bluetoothAdapter.setName(string2); ++n2) {
                if (n2 >= 2) continue;
                try {
                    Thread.sleep((long)1000L);
                    continue;
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            if (n2 >= 3) {
                d.b((String)"BtUtils", (String)"set name failed", (Object[])new Object[0]);
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static void c() {
        Context context = MiDropApplication.a();
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.midrop.action.OPEN_BLUETOOTH_FAIL");
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT < 26;
    }
}

