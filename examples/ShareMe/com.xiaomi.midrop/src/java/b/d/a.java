/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.xiaomi.midrop.common.b
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  midrop.service.c.e
 */
package b.d;

import com.xiaomi.midrop.common.b;
import midrop.service.c.e;

public class a {
    public static String a(String string2) {
        if (string2.getBytes().length > 16) {
            StringBuilder stringBuilder = new StringBuilder();
            int n2 = 0;
            do {
                stringBuilder.append(string2.charAt(n2));
                ++n2;
            } while (stringBuilder.toString().getBytes().length <= 16);
            string2 = string2.substring(0, n2 - 1);
        }
        return string2;
    }

    public static boolean a() {
        return "running".equals((Object)b.a((String)"sys_midrop_running", (String)""));
    }

    public static void b() {
        e.a((String)"user_notice_agree_state", (boolean)true);
    }
}

