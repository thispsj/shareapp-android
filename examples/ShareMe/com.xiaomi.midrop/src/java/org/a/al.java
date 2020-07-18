/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.media.MediaScannerConnection
 *  android.media.MediaScannerConnection$MediaScannerConnectionClient
 *  android.net.Uri
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  java.io.UnsupportedEncodingException
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.net.InetAddress
 *  java.net.UnknownHostException
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package org.a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.Settings;
import com.xiaomi.miftp.c.c;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.a.ae;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class al {
    private static final String a = "al";

    static String a() {
        return Settings.Secure.getString((ContentResolver)ae.e().getContentResolver(), (String)"android_id");
    }

    public static InetAddress a(int n2) {
        byte[] arrby = new byte[4];
        for (int i2 = 0; i2 < 4; ++i2) {
            arrby[i2] = (byte)(n2 >> i2 * 8);
        }
        try {
            InetAddress inetAddress = InetAddress.getByAddress((byte[])arrby);
            return inetAddress;
        }
        catch (UnknownHostException unknownHostException) {
            return null;
        }
    }

    static JSONObject a(byte[] arrby) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(new String(arrby, "UTF-8"));
            return jSONObject;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return null;
        }
    }

    public static void a(String string2) {
        String string3 = a;
        StringBuilder stringBuilder = new StringBuilder("Notifying others about new file: ");
        stringBuilder.append(string2);
        c.a(string3, stringBuilder.toString());
        new a(ae.e(), string2);
    }

    static byte[] a(JSONObject jSONObject) throws JSONException {
        try {
            byte[] arrby = jSONObject.toString().getBytes("UTF-8");
            return arrby;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return null;
        }
    }

    public static String[] a(String[] arrstring, String[] arrstring2) {
        String[] arrstring3 = new String[1 + arrstring2.length];
        System.arraycopy((Object)arrstring, (int)0, (Object)arrstring3, (int)0, (int)1);
        System.arraycopy((Object)arrstring2, (int)0, (Object)arrstring3, (int)1, (int)arrstring2.length);
        return arrstring3;
    }

    public static String b() {
        String string2 = ae.e().getPackageName();
        try {
            String string3 = ae.e().getPackageManager().getPackageInfo((String)string2, (int)0).versionName;
            return string3;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            c.b(a, "NameNotFoundException looking up SwiFTP version");
            return null;
        }
    }

    public static void b(String string2) {
        String string3 = a;
        StringBuilder stringBuilder = new StringBuilder("Notifying others about deleted file: ");
        stringBuilder.append(string2);
        c.a(string3, stringBuilder.toString());
        new a(ae.e(), string2);
    }

    public static void c() {
        try {
            Thread.sleep((long)1000L);
        }
        catch (InterruptedException interruptedException) {}
    }

    private static final class a
    implements MediaScannerConnection.MediaScannerConnectionClient {
        private MediaScannerConnection a;
        private String b;

        public a(Context context, String string2) {
            this.b = string2;
            this.a = new MediaScannerConnection(context, (MediaScannerConnection.MediaScannerConnectionClient)this);
            this.a.connect();
        }

        public final void onMediaScannerConnected() {
            this.a.scanFile(this.b, null);
        }

        public final void onScanCompleted(String string2, Uri uri) {
            this.a.disconnect();
        }
    }

}

