/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.xiaomi.midrop.util.y
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package b.g.b;

import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.midrop.util.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public int a = a.a;
    public String b = null;
    public String c = null;
    public String d = null;
    public String e = null;
    public String f = null;
    public int g;
    public int h;

    public a() {
        this.a = a.a;
    }

    public a(int n2, String string2, String string3, String string4, String string5) {
        this.a = n2;
        this.b = string2;
        this.c = string3;
        this.d = string4;
        this.e = string5;
        this.g = y.C();
        this.h = 12826;
    }

    public static a a(byte[] arrby) {
        if (arrby == null) {
            return null;
        }
        a a2 = new a();
        if (!a2.b(arrby)) {
            return null;
        }
        return a2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean b(byte[] arrby) {
        if (arrby == null) return false;
        JSONObject jSONObject = new JSONObject(new String(arrby)).optJSONObject("iq");
        if (jSONObject == null) return false;
        try {
            String string2 = jSONObject.optString("type");
            if (TextUtils.isEmpty((CharSequence)string2)) return false;
            this.a = a.a(string2);
            this.b = jSONObject.optString("id");
            this.c = jSONObject.optString("xmlns");
            if (this.c == null) return false;
            this.d = jSONObject.optString("action");
            if (TextUtils.isEmpty((CharSequence)this.d)) return false;
            this.f = jSONObject.optString("from");
            this.g = jSONObject.optInt("profile");
            this.h = jSONObject.optInt("versionCode");
            String string3 = jSONObject.optString("param");
            if (TextUtils.isEmpty((CharSequence)string3)) return true;
            this.e = Uri.decode((String)string3);
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
            jSONObject.put("xmlns", (Object)this.c);
            jSONObject.put("action", (Object)this.d);
            if (!TextUtils.isEmpty((CharSequence)this.e)) {
                jSONObject.put("param", (Object)Uri.encode((String)this.e));
            }
            if (!TextUtils.isEmpty((CharSequence)this.f)) {
                jSONObject.put("from", (Object)this.f);
            }
            jSONObject.put("profile", this.g);
            jSONObject.put("versionCode", this.h);
            jSONObject2.put("iq", (Object)jSONObject);
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
        public static final int d = 4;
        public static final int e = 5;
        private static final /* synthetic */ int[] f;

        static {
            int[] arrn = new int[]{a, b, c, d, e};
            f = arrn;
        }

        public static int a(String string2) {
            int n2 = a;
            if (string2.equalsIgnoreCase("set")) {
                return b;
            }
            if (string2.equalsIgnoreCase("get")) {
                return c;
            }
            if (string2.equalsIgnoreCase("result")) {
                return d;
            }
            if (string2.equalsIgnoreCase("error")) {
                n2 = e;
            }
            return n2;
        }

        public static String a(int n2) {
            switch (1.a[n2 - 1]) {
                default: {
                    return "undefined";
                }
                case 4: {
                    return "set";
                }
                case 3: {
                    return "result";
                }
                case 2: {
                    return "get";
                }
                case 1: 
            }
            return "error";
        }

        public static int[] a() {
            return (int[])f.clone();
        }
    }

}

