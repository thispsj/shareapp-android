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
package midrop.c.d;

import android.os.Parcel;
import android.os.Parcelable;
import midrop.c.c.e;
import midrop.c.c.f;
import midrop.c.d.d;

public final class c
implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new c(parcel);
        }
    };
    public f a;

    public c() {
        this.a = new f();
        this.b();
    }

    public c(Parcel parcel) {
        this.a = new f();
        c.super.b();
        this.a = (f)parcel.readParcelable(f.class.getClassLoader());
    }

    private void b() {
        this.a.a(d.a, null);
        this.a.a(d.d, null);
        this.a.a(d.b, null);
        this.a.a(d.c, null);
        this.a.a(d.e, a.b.a());
    }

    public final String a() {
        return (String)this.a.b(d.b);
    }

    public final boolean a(int n2) {
        return this.a.b(d.d, n2);
    }

    public final boolean a(String string2) {
        return this.a.b(d.a, string2);
    }

    public final boolean b(String string2) {
        return this.a.b(d.b, string2);
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
        public static final /* enum */ a d = new a();
        private static final /* synthetic */ a[] e;

        static {
            a[] arra = new a[]{a, b, c, d};
            e = arra;
        }

        public static a a(byte by) {
            if (by == 1) {
                return b;
            }
            if (by == 2) {
                return c;
            }
            if (by == 3) {
                return d;
            }
            return a;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])e.clone();
        }

        public final byte a() {
            switch (2.a[this.ordinal()]) {
                default: {
                    return 0;
                }
                case 3: {
                    return 3;
                }
                case 2: {
                    return 2;
                }
                case 1: 
            }
            return 1;
        }

        public final String toString() {
            switch (2.a[this.ordinal()]) {
                default: {
                    return "type: undefined";
                }
                case 3: {
                    return "type: bt service";
                }
                case 2: {
                    return "type: migrate";
                }
                case 1: 
            }
            return "type: midrop";
        }
    }

}

