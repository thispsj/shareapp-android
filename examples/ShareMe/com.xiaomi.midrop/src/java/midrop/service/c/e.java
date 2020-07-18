/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.ContentObserver
 *  android.net.Uri
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 */
package midrop.service.c;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.common.b;

public final class e {
    public static void a(String string2, int n2) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", 0);
        bundle.putString("key", string2);
        bundle.putInt("value", n2);
        b.a("SET", bundle);
    }

    public static void a(String string2, long l2) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", 4);
        bundle.putString("key", string2);
        bundle.putLong("value", l2);
        b.a("SET", bundle);
    }

    public static void a(String string2, String string3) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", 2);
        bundle.putString("key", string2);
        bundle.putString("value", string3);
        b.a("SET", bundle);
    }

    public static void a(String string2, boolean bl) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", 1);
        bundle.putString("key", string2);
        bundle.putBoolean("value", bl);
        b.a("SET", bundle);
        MiDropApplication.a().getContentResolver().notifyChange(Uri.withAppendedPath((Uri)Uri.parse((String)"content://com.xiaomi.midrop.remoteprovider"), (String)string2), null, false);
    }

    public static boolean b(String string2, boolean bl) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", 1);
        bundle.putString("key", string2);
        bundle.putBoolean("default", bl);
        Bundle bundle2 = b.a("GET", bundle);
        if (bundle2 == null) {
            return bl;
        }
        return bundle2.getBoolean(string2, bl);
    }
}

