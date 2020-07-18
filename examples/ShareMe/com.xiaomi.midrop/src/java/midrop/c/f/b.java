/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package midrop.c.f;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import midrop.c.f.a;
import midrop.service.c.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private static final String a = "b";

    public static String a(List<a> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (a a2 : list) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("type", (Object)a2.a.toString());
                jSONObject2.put("name", (Object)a2.b);
                jSONObject2.put("sze", a2.c);
                jSONObject2.put("uri", (Object)a2.e);
                jSONObject2.put("preview", (Object)a2.d);
                jSONObject2.put("file_path", (Object)a2.f);
                jSONObject2.put("parent_path", (Object)a2.h);
                jSONObject2.put("is_dir", a2.k);
                jSONObject2.put("root_dir_name", (Object)a2.j);
                jSONObject2.put("silence", a2.l);
                jSONObject2.put("md5", (Object)a2.m);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
                break;
            }
            jSONArray.put((Object)jSONObject2);
        }
        try {
            jSONObject.put("list", (Object)jSONArray);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String a(List<String> list, String string2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                jSONArray.put((Object)((String)iterator.next()));
            }
            jSONObject.put("file_id", (Object)jSONArray);
            jSONObject.put("root_dir_name", (Object)string2);
        }
        catch (JSONException jSONException) {
            d.b("encodeFileIdList", jSONException.toString(), new Object[0]);
        }
        return jSONObject.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ArrayList<a> a(String string2) {
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
            jSONException.printStackTrace();
            return arrayList;
        }
        for (int i2 = 0; i2 < jSONArray.length() && (jSONObject = jSONArray.getJSONObject(i2)) != null; ++i2) {
            a a2 = new a();
            a2.a(jSONObject.getString("name"));
            a2.a = a.a.a(jSONObject.getString("type"));
            a2.c = jSONObject.getLong("sze");
            a2.d = jSONObject.getString("preview");
            a2.e = jSONObject.getString("uri");
            a2.f = jSONObject.getString("file_path");
            a2.b(jSONObject.optString("parent_path"));
            a2.k = jSONObject.optBoolean("is_dir");
            a2.j = jSONObject.optString("root_dir_name");
            a2.l = jSONObject.optBoolean("silence");
            a2.m = jSONObject.optString("md5");
            arrayList.add((Object)a2);
        }
        return arrayList;
    }

    public static ArrayList<a> a(String string2, String string3) {
        ArrayList<a> arrayList = b.a(string2);
        for (a a2 : arrayList) {
            String string4 = a2.e;
            if (string4 != null && string4.length() > 0) {
                a2.e = String.format((Locale)Locale.US, (String)"http://%s%s", (Object[])new Object[]{string3, string4});
                a2.g = string4.substring(1 + string4.indexOf("/"));
            }
            if (a2.d == null || a2.d.length() <= 0) continue;
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{string3, a2.d};
            a2.d = String.format((Locale)locale, (String)"http://%s%s", (Object[])arrobject);
        }
        return arrayList;
    }

    public static String b(String string2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("file_id", (Object)string2);
        }
        catch (JSONException jSONException) {
            d.b("encodeFileId", jSONException.toString(), new Object[0]);
        }
        return jSONObject.toString();
    }

    public static String c(String string2) {
        try {
            String string3 = new JSONObject(string2).optString("file_id", "");
            return string3;
        }
        catch (JSONException jSONException) {
            d.b("parseFileId", jSONException.toString(), new Object[0]);
            return "";
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Pair<List<String>, String> d(String string2) {
        String string3;
        int i2;
        JSONArray jSONArray;
        ArrayList arrayList;
        block5 : {
            JSONException jSONException;
            block6 : {
                arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject(string2);
                string3 = jSONObject.optString("root_dir_name");
                try {
                    jSONArray = jSONObject.optJSONArray("file_id");
                    i2 = 0;
                    break block5;
                }
                catch (JSONException jSONException2) {
                    break block6;
                }
                catch (JSONException jSONException3) {
                    jSONException = jSONException3;
                    string3 = "";
                }
            }
            d.b("parseFileId", jSONException.toString(), new Object[0]);
            return new Pair((Object)arrayList, (Object)string3);
        }
        while (i2 < jSONArray.length()) {
            arrayList.add((Object)jSONArray.getString(i2));
            ++i2;
        }
        return new Pair((Object)arrayList, (Object)string3);
    }
}

