/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  midrop.service.c.d
 */
package com.xiaomi.midrop.transmission.upgrade.a;

import android.text.TextUtils;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import midrop.service.c.d;

public final class a {
    public String a;
    public String b;
    public String c;
    public boolean d;
    public int e;
    public String f;
    public String g;
    public String h;
    public boolean i;
    public boolean j;

    public static String b(String string2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA-256");
            messageDigest.update(string2.getBytes());
            String string3 = Base64.encodeToString((byte[])messageDigest.digest(), (int)0);
            return string3;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            d.b((String)"UpgradeApkEntity", (String)"sha256 not exist", (Object[])new Object[0]);
            return "";
        }
    }

    public final boolean a(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return false;
        }
        String string3 = this.d ? a.b(string2) : string2;
        boolean bl = TextUtils.equals((CharSequence)this.b, (CharSequence)string3);
        if (bl) {
            this.c = string2;
        }
        return bl;
    }

    public final boolean equals(Object object) {
        if (object != null && object instanceof a) {
            if (this == object) {
                return true;
            }
            if (TextUtils.equals((CharSequence)this.b, (CharSequence)((a)object).b)) {
                return true;
            }
            return super.equals(object);
        }
        return false;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("UpgradeApkEntity{name='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", packageName='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", versionCode=");
        stringBuilder.append(this.e);
        stringBuilder.append(", path='");
        stringBuilder.append(this.g);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

