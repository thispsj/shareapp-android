/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Random
 */
package midrop.b.a;

import android.text.TextUtils;
import java.util.Random;

public final class a {
    public static String a() {
        Random random = new Random(System.currentTimeMillis());
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i2 = 0; i2 < 6; ++i2) {
            stringBuilder.append("0123456789".charAt(random.nextInt(-1 + "0123456789".length())));
        }
        return stringBuilder.toString();
    }

    public static boolean a(String string2) {
        return !TextUtils.isEmpty((CharSequence)string2) && string2.length() == 6;
    }
}

