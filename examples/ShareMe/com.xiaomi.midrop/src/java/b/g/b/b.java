/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayInputStream
 *  java.lang.Object
 *  java.lang.String
 *  javax.xml.parsers.DocumentBuilderFactory
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package b.g.b;

import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public String a;
    private String b;

    public b() {
        this.b = null;
        this.a = null;
    }

    public b(String string2, String string3) {
        this.b = null;
        this.a = null;
        this.b = string2;
        this.a = string3;
    }

    public static b a(byte[] arrby) {
        b b2 = null;
        if (arrby != null) {
            b b3 = new b();
            if (!b3.b(arrby)) {
                return null;
            }
            b2 = b3;
        }
        return b2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean b(byte[] arrby) {
        if (arrby == null) return false;
        new ByteArrayInputStream(arrby);
        DocumentBuilderFactory.newInstance();
        JSONObject jSONObject = new JSONObject(new String(arrby)).optJSONObject("message");
        if (jSONObject == null) return false;
        try {
            this.b = jSONObject.optString("id");
            this.a = jSONObject.optString("body");
            return true;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        return false;
    }

    public final String toString() {
        if (this.b != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("id", (Object)this.b);
                jSONObject2.put("body", (Object)this.a);
                jSONObject.put("message", (Object)jSONObject2);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
            return jSONObject.toString();
        }
        return "";
    }
}

