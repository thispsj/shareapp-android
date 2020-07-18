/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package b.g.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public int a;
    public String b;

    public c() {
        this.a = a.a;
        this.b = null;
        this.a = a.a;
    }

    public c(int n2, String string2) {
        this.a = a.a;
        this.b = null;
        this.a = n2;
        this.b = string2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean a(byte[] arrby) {
        if (arrby == null) return false;
        JSONObject jSONObject = new JSONObject(new String(arrby)).optJSONObject("ping");
        if (jSONObject == null) return false;
        try {
            String string2 = jSONObject.optString("type");
            if (TextUtils.isEmpty((CharSequence)string2)) return false;
            this.a = a.a(string2);
            this.b = jSONObject.optString("id");
            return true;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        return false;
    }

    public final String toString() {
        if (this.a == a.a) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", (Object)a.a(this.a));
            jSONObject.put("id", (Object)this.b);
            jSONObject2.put("ping", (Object)jSONObject);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        return jSONObject2.toString();
    }

    public static final class a
    extends Enum<a> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d;

        static {
            int[] arrn = new int[]{a, b, c};
            d = arrn;
        }

        public static int a(String string2) {
            int n2 = a;
            if (string2.equalsIgnoreCase("ping")) {
                return b;
            }
            if (string2.equalsIgnoreCase("pong")) {
                n2 = c;
            }
            return n2;
        }

        public static String a(int n2) {
            switch (1.a[n2 - 1]) {
                default: {
                    return "undefined";
                }
                case 2: {
                    return "ping";
                }
                case 1: 
            }
            return "pong";
        }

        public static int[] a() {
            return (int[])d.clone();
        }
    }

}

