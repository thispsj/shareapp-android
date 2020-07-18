/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 *  org.json.JSONTokener
 */
package com.github.lzyzsd.jsbridge;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class f {
    public String a;
    String b;
    String c;
    public String d;
    public String e;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static List<f> a(String string2) {
        JSONArray jSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            jSONArray = new JSONArray(string2);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return arrayList;
        }
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            f f2 = new f();
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            String string3 = jSONObject.has("handlerName") ? jSONObject.getString("handlerName") : null;
            f2.e = string3;
            String string4 = jSONObject.has("callbackId") ? jSONObject.getString("callbackId") : null;
            f2.a = string4;
            String string5 = jSONObject.has("responseData") ? jSONObject.getString("responseData") : null;
            f2.c = string5;
            String string6 = jSONObject.has("responseId") ? jSONObject.getString("responseId") : null;
            f2.b = string6;
            boolean bl = jSONObject.has("data");
            String string7 = null;
            if (bl) {
                string7 = jSONObject.getString("data");
            }
            f2.d = string7;
            arrayList.add((Object)f2);
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            String string2;
            jSONObject.put("callbackId", (Object)this.a);
            jSONObject.put("data", (Object)this.d);
            jSONObject.put("handlerName", (Object)this.e);
            Object object = this.c;
            if (TextUtils.isEmpty((CharSequence)object)) {
                string2 = "responseData";
            } else {
                string2 = "responseData";
                object = new JSONTokener((String)object).nextValue();
            }
            jSONObject.put(string2, object);
            jSONObject.put("responseData", (Object)this.c);
            jSONObject.put("responseId", (Object)this.b);
            return jSONObject.toString();
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return null;
        }
    }
}

