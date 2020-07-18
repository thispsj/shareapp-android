/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package midrop.c.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.midrop.util.g;
import com.xiaomi.midrop.util.j;

public final class a
implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    };
    public a a;
    public String b;
    public long c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public boolean k;
    public boolean l;
    public String m;

    public a() {
    }

    public a(Parcel parcel) {
        this.a = a.a(parcel.readString());
        this.b = parcel.readString();
        this.e = parcel.readString();
        this.d = parcel.readString();
        this.c = parcel.readLong();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        boolean bl = parcel.readByte() != 0;
        this.k = bl;
        this.j = parcel.readString();
        int n2 = parcel.readInt();
        boolean bl2 = false;
        if (n2 != 0) {
            bl2 = true;
        }
        this.l = bl2;
        this.m = parcel.readString();
    }

    public final void a(String string2) {
        this.b = string2;
        a a2 = a.f;
        String string3 = j.d(string2);
        if (g.d(string3)) {
            a2 = a.e;
        } else if (g.a(string3)) {
            a2 = a.c;
        } else if (g.c(string3)) {
            a2 = a.b;
        } else if (g.b(string3)) {
            a2 = a.d;
        }
        this.a = a2;
    }

    public final void b(String string2) {
        this.h = string2;
        this.i = string2;
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return this.f;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.a.toString());
        parcel.writeString(this.b);
        parcel.writeString(this.e);
        parcel.writeString(this.d);
        parcel.writeLong(this.c);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeByte((byte)(this.k ? 1 : 0));
        parcel.writeString(this.j);
        parcel.writeInt((int)this.l);
        parcel.writeString(this.m);
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        public static final /* enum */ a d = new a();
        public static final /* enum */ a e = new a();
        public static final /* enum */ a f = new a();
        public static final /* enum */ a g = new a();
        public static final /* enum */ a h = new a();
        public static final /* enum */ a i = new a();
        private static final /* synthetic */ a[] j;

        static {
            a[] arra = new a[]{a, b, c, d, e, f, g, h, i};
            j = arra;
        }

        public static a a(String string2) {
            if (string2.equals((Object)"undefined")) {
                return a;
            }
            if (string2.equals((Object)"PhotoFile")) {
                return b;
            }
            if (string2.equals((Object)"MusicFile")) {
                return c;
            }
            if (string2.equals((Object)"VideoFile")) {
                return d;
            }
            if (string2.equals((Object)"ApkFile")) {
                return e;
            }
            if (string2.equals((Object)"File")) {
                return f;
            }
            if (string2.equals((Object)"WebPage")) {
                return g;
            }
            if (string2.equals((Object)"Message")) {
                return h;
            }
            if (string2.equals((Object)"NameCard")) {
                return i;
            }
            return a;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])j.clone();
        }

        public final String toString() {
            switch (2.a[this.ordinal()]) {
                default: {
                    return null;
                }
                case 8: {
                    return "NameCard";
                }
                case 7: {
                    return "Message";
                }
                case 6: {
                    return "WebPage";
                }
                case 5: {
                    return "File";
                }
                case 4: {
                    return "ApkFile";
                }
                case 3: {
                    return "VideoFile";
                }
                case 2: {
                    return "MusicFile";
                }
                case 1: 
            }
            return "PhotoFile";
        }
    }

}

