/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.ClassLoader
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package midrop.c.a;

import android.os.Parcel;
import android.os.Parcelable;
import midrop.c.a.d;
import midrop.c.c.e;
import midrop.c.c.f;

public final class c
implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new c(parcel);
        }
    };
    private f a;

    public c() {
        this.a = new f();
        this.d();
    }

    public c(Parcel parcel) {
        this.a = new f();
        c.super.d();
        this.a = (f)parcel.readParcelable(f.class.getClassLoader());
    }

    public c(String string2, String string3, String string4) {
        this.a = new f();
        c.super.d();
        this.a(string2);
        this.b(string3);
        this.c(string4);
    }

    private void d() {
        this.a.a(d.a, null);
        this.a.a(d.b, null);
        this.a.a(d.c, null);
    }

    public final String a() {
        return (String)this.a.b(d.a);
    }

    public final boolean a(String string2) {
        return this.a.b(d.a, string2);
    }

    public final a b() {
        return a.a((String)this.a.b(d.b));
    }

    public final boolean b(String string2) {
        return this.a.b(d.b, string2);
    }

    public final String c() {
        return (String)this.a.b(d.c);
    }

    public final boolean c(String string2) {
        return this.a.b(d.c, string2);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.a, n2);
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        private static final /* synthetic */ a[] d;

        static {
            a[] arra = new a[]{a, b, c};
            d = arra;
        }

        public static a a(String string2) {
            if (string2.equals((Object)"undefined")) {
                return a;
            }
            if (string2.equals((Object)"in")) {
                return b;
            }
            if (string2.equals((Object)"out")) {
                return c;
            }
            return a;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])d.clone();
        }

        public final String toString() {
            switch (2.a[this.ordinal()]) {
                default: {
                    return "undefined";
                }
                case 2: {
                    return "out";
                }
                case 1: 
            }
            return "in";
        }
    }

}

