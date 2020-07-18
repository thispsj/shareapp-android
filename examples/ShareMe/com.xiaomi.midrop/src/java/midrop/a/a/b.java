/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Parcelable
 *  java.lang.Object
 *  java.lang.String
 */
package midrop.a.a;

import android.content.Intent;
import android.os.Parcelable;
import com.xiaomi.midrop.MiDropApplication;
import com.xiaomi.midrop.b.d;

public final class b {
    public static void a(String string2) {
        Intent intent = new Intent("getting_conn_id_action");
        intent.putExtra("extra_conn_id", string2);
        intent.setPackage(MiDropApplication.a().getPackageName());
        MiDropApplication.a().sendBroadcast(intent);
    }

    public static void a(String string2, String string3, String string4, boolean bl) {
        d d2 = new d();
        d2.a = string2;
        d2.b = string3;
        Intent intent = new Intent("miui.intent.action.SHOW_CONNECT_DIALOG");
        intent.putExtra("device_id", string4);
        intent.putExtra("dialog_info", (Parcelable)d2);
        intent.putExtra("need_confirm", bl ^ true);
        intent.setPackage(MiDropApplication.a().getPackageName());
        MiDropApplication.a().sendBroadcast(intent);
        b.a(string2);
    }
}

