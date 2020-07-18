/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package midrop.c.f;

import com.xiaomi.midrop.b.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    private static final String a = "d";

    public static String a(List<f> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (f f2 : list) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("uri", (Object)f2.a);
                jSONObject2.put("base64_icon", (Object)f2.b);
            }
            catch (JSONException jSONException) {
                midrop.service.c.d.a(a, "e: ", jSONException, new Object[0]);
                break;
            }
            jSONArray.put((Object)jSONObject2);
        }
        try {
            jSONObject.put("list", (Object)jSONArray);
        }
        catch (JSONException jSONException) {
            midrop.service.c.d.a(a, "e: ", jSONException, new Object[0]);
        }
        return jSONObject.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ArrayList<f> a(String string2) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        ArrayList arrayList = new ArrayList();
        try {
            jSONArray = new JSONObject(string2).getJSONArray("list");
            if (jSONArray == null) {
                return arrayList;
            }
        }
        catch (JSONException jSONException) {
            midrop.service.c.d.a(a, "e: ", jSONException, new Object[0]);
            return arrayList;
        }
        for (int i2 = 0; i2 < jSONArray.length() && (jSONObject = jSONArray.getJSONObject(i2)) != null; ++i2) {
            f f2 = new f();
            f2.a = jSONObject.getString("uri");
            f2.b = jSONObject.getString("base64_icon");
            arrayList.add((Object)f2);
        }
        return arrayList;
    }
}

