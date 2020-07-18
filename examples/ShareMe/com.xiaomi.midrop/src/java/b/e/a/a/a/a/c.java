/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.telephony.TelephonyManager
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 */
package b.e.a.a.a.a;

import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

public final class c {
    public static boolean a(TelephonyManager telephonyManager) {
        boolean bl = false;
        try {
            Class class_ = Class.forName((String)"miui.telephony.TelephonyManager");
            Object object = class_.getMethod("getDefault", new Class[0]).invoke((Object)class_, new Object[0]);
            int n2 = (Integer)class_.getMethod("getIccCardCount", new Class[0]).invoke(object, new Object[0]);
            bl = false;
            if (n2 > 0) {
                bl = true;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (!bl) {
            bl = telephonyManager.hasIccCard();
        }
        return bl;
    }
}

