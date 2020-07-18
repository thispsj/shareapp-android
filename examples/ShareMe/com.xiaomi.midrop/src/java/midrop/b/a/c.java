/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package midrop.b.a;

import android.text.TextUtils;
import android.util.Base64;
import midrop.service.c.d;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static String a(byte[] arrby) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pk", (Object)new String(Base64.encode((byte[])arrby, (int)2)));
        }
        catch (JSONException jSONException) {
            d.a("PublicKeyEncoder", "encodeFileId", jSONException, new Object[0]);
        }
        return jSONObject.toString();
    }

    public static byte[] a(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return null;
        }
        try {
            byte[] arrby = Base64.decode((String)new JSONObject(string2).optString("pk"), (int)2);
            return arrby;
        }
        catch (JSONException jSONException) {
            d.a("PublicKeyEncoder", "parsePkString", jSONException, new Object[0]);
            return null;
        }
    }
}

