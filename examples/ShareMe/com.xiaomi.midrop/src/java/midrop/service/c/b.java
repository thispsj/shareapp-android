/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.provider.Settings
 *  android.provider.Settings$Global
 *  android.provider.Settings$System
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package midrop.service.c;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

public final class b {
    public static void a(Context context, boolean bl) {
        try {
            Settings.System.putInt((ContentResolver)context.getContentResolver(), (String)"key_midrop_enabled", (int)bl);
            Settings.Global.putInt((ContentResolver)context.getContentResolver(), (String)"key_midrop_enabled", (int)bl);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }
}

