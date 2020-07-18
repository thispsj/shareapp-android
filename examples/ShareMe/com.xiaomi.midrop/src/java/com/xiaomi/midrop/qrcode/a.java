/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  android.util.Base64
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  midrop.c.d.c
 *  midrop.c.d.c$a
 *  org.json.JSONObject
 */
package com.xiaomi.midrop.qrcode;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import midrop.c.d.c;
import org.json.JSONObject;

public final class a
implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new a(parcel, 0);
        }
    };
    public String a;
    public String b;
    public boolean c;
    public a d;
    public b e;
    public boolean f;

    public a() {
        this.c = true;
        this.d = new a();
        this.e = new b();
    }

    private a(Parcel parcel) {
        byte by;
        this.c = by = 1;
        this.d = new a();
        this.e = new b();
        this.a = parcel.readString();
        this.b = parcel.readString();
        boolean bl = parcel.readByte() == by;
        this.c = bl;
        this.d = a.a(parcel.readString());
        this.e = b.a(parcel.readString());
        if (parcel.readByte() != by) {
            by = 0;
        }
        this.f = by;
    }

    /* synthetic */ a(Parcel parcel, byte by) {
        super(parcel);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a(String string2) {
        try {
            JSONObject jSONObject = new JSONObject(new String(Base64.decode((String)string2, (int)2)));
            a a2 = new a();
            a2.a = jSONObject.optString("nm");
            a2.b = jSONObject.optString("id");
            boolean bl = jSONObject.optInt("ic") != 0;
            a2.c = bl;
            a2.d = a.a(jSONObject.optString("ap"));
            a2.e = b.a(jSONObject.optString("bt"));
            int n2 = jSONObject.optInt("sa");
            boolean bl2 = false;
            if (n2 != 0) {
                bl2 = true;
            }
            a2.f = bl2;
            return a2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public final c.a a() {
        if (this.e != null && this.e.a()) {
            return c.a.d;
        }
        return c.a.b;
    }

    public final boolean b() {
        if (TextUtils.isEmpty((CharSequence)this.a)) {
            return false;
        }
        if (TextUtils.isEmpty((CharSequence)this.b)) {
            return false;
        }
        if (this.d != null && this.d.a()) {
            return true;
        }
        return this.e != null && this.e.a();
    }

    public final String c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("nm", (Object)this.a);
            jSONObject.put("id", (Object)this.b);
            jSONObject.put("ic", (int)this.c);
            jSONObject.put("ap", (Object)this.d.b());
            jSONObject.put("bt", (Object)this.e.b());
            jSONObject.put("sa", (int)this.f);
            String string2 = new String(Base64.encode((byte[])jSONObject.toString().getBytes(), (int)2));
            return string2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeByte((byte)(this.c ? 1 : 0));
        parcel.writeString(this.d.b());
        parcel.writeString(this.e.b());
        parcel.writeByte((byte)(this.f ? 1 : 0));
    }

    public static final class a {
        public String a;
        public String b;
        public String c;
        public int d;

        public static a a(String string2) {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode((String)string2, (int)2)));
                a a2 = new a();
                a2.a = jSONObject.optString("ss");
                a2.b = jSONObject.optString("pd");
                a2.c = jSONObject.optString("ip");
                if (TextUtils.isEmpty((CharSequence)a2.c)) {
                    a2.c = "192.168.43.1";
                }
                a2.d = jSONObject.optInt("pt");
                if (a2.d == 0) {
                    a2.d = 8181;
                }
                return a2;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }
        }

        public final boolean a() {
            return !TextUtils.isEmpty((CharSequence)this.a) && !TextUtils.isEmpty((CharSequence)this.b);
        }

        public final String b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ss", (Object)this.a);
                jSONObject.put("pd", (Object)this.b);
                jSONObject.put("ip", (Object)this.c);
                jSONObject.put("pt", this.d);
                String string2 = new String(Base64.encode((byte[])jSONObject.toString().getBytes(), (int)2));
                return string2;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return "";
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(" ");
            stringBuilder.append(this.b);
            return stringBuilder.toString();
        }
    }

    public static final class b {
        public String a;
        public boolean b;
        public boolean c;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static b a(String string2) {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode((String)string2, (int)2)));
                b b2 = new b();
                b2.a = jSONObject.optString("ad");
                boolean bl = jSONObject.optInt("5g") != 0;
                b2.b = bl;
                int n2 = jSONObject.optInt("p2");
                boolean bl2 = false;
                if (n2 != 0) {
                    bl2 = true;
                }
                b2.c = bl2;
                return b2;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }
        }

        public final boolean a() {
            return !TextUtils.isEmpty((CharSequence)this.a);
        }

        public final String b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad", (Object)this.a);
                jSONObject.put("5g", (int)this.b);
                jSONObject.put("p2", (int)this.c);
                String string2 = new String(Base64.encode((byte[])jSONObject.toString().getBytes(), (int)2));
                return string2;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return "";
            }
        }

        public final String toString() {
            return this.a;
        }
    }

}

