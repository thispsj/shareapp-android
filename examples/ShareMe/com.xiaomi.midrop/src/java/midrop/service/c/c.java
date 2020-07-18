/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.os.Build
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  android.text.TextUtils
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.Locale
 *  java.util.Random
 *  java.util.UUID
 */
package midrop.service.c;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import b.a.o;
import com.xiaomi.midrop.MiDropApplication;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import midrop.service.c.d;

public final class c {
    private static int a = -1;
    private static String b = "";

    public static int a() {
        if (a != -1 && a != 0) {
            return a;
        }
        String string2 = Settings.Secure.getString((ContentResolver)MiDropApplication.a().getContentResolver(), (String)"android_id");
        String string3 = o.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        stringBuilder.append(Build.SERIAL);
        int n2 = c.a(stringBuilder.toString());
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{n2};
        String.format((Locale)locale, (String)"generateDeviceId: %d", (Object[])arrobject);
        if (n2 == 0) {
            d.b("IdUtil", "device null, generate random", new Object[0]);
            n2 = c.a(UUID.randomUUID().toString());
        }
        a = n2;
        return n2;
    }

    public static int a(String string2) {
        int n2;
        block3 : {
            block2 : {
                byte by;
                int n3;
                if (TextUtils.isEmpty((CharSequence)string2)) break block2;
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance((String)"MD5");
                    messageDigest.update(string2.toLowerCase().getBytes());
                    byte[] arrby = messageDigest.digest();
                    n3 = 255 & arrby[0] | 65280 & arrby[1] << 8 | 16711680 & arrby[2] << 16;
                    by = arrby[3];
                }
                catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    noSuchAlgorithmException.printStackTrace();
                }
                n2 = n3 | -16777216 & by << 24;
                break block3;
            }
            n2 = 0;
        }
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{n2};
        String.format((Locale)locale, (String)"generateDeviceId: %d", (Object[])arrobject);
        return n2;
    }

    public static String a(byte[] arrby) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            int n2 = 15 & arrby[i2] >> 4;
            int n3 = 15 & arrby[i2];
            stringBuilder.append(Integer.toHexString((int)n2));
            stringBuilder.append(Integer.toHexString((int)n3));
        }
        return stringBuilder.toString();
    }

    public static String b() {
        Random random = new Random(System.currentTimeMillis());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < 8; ++i2) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    public static String b(String string2) {
        File file = new File(string2);
        if (!file.exists()) {
            return "";
        }
        int n2 = file.hashCode();
        long l2 = file.length();
        int n3 = c.a();
        Object[] arrobject = new Object[]{Integer.toHexString((int)n2), Long.toHexString((long)l2), Integer.toHexString((int)n3)};
        return String.format((String)"%s-%s-%s", (Object[])arrobject);
    }
}

