/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package b.a;

import org.json.JSONException;
import org.json.JSONObject;

public final class l {
    public String a;
    public int b = 0;

    public l(String string2) {
        this.a = string2;
    }

    public static l a(String string2) {
        try {
            JSONObject jSONObject = new JSONObject(string2);
            int n2 = jSONObject.optInt("code");
            l l2 = new l(jSONObject.optString("type"));
            l2.b = n2;
            return l2;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return null;
        }
    }

    public final String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", this.b);
            jSONObject.put("type", (Object)this.a);
            String string2 = jSONObject.toString();
            return string2;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return "";
        }
    }
}

