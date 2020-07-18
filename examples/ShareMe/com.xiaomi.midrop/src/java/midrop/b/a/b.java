/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package midrop.b.a;

import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public int a;
    public int b;
    public String c;
    public String d;
    public int e;
    public String f;

    public static b a(String string2) {
        try {
            JSONObject jSONObject = new JSONObject(string2);
            b b2 = new b();
            b2.a = jSONObject.optInt("action");
            b2.d = jSONObject.optString("connId");
            b2.c = jSONObject.optString("name");
            b2.b = jSONObject.optInt("versionCode");
            b2.e = jSONObject.optInt("profileIndex");
            b2.f = jSONObject.optString("deviceId");
            return b2;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return null;
        }
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", this.a);
            jSONObject.put("connId", (Object)this.d);
            jSONObject.put("name", (Object)this.c);
            jSONObject.put("versionCode", this.b);
            jSONObject.put("profileIndex", this.e);
            jSONObject.put("deviceId", (Object)this.f);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        return jSONObject.toString();
    }
}

