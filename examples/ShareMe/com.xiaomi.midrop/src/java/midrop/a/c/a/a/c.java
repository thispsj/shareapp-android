/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.List
 */
package midrop.a.c.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class c
implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new c(parcel, 0);
        }
    };
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public String h;
    public String i;
    public List<a> j;
    private long k;
    private long l;

    public c() {
        this.h = "";
        this.i = "";
        this.j = new ArrayList();
    }

    private c(Parcel parcel) {
        this.h = "";
        this.i = "";
        this.j = new ArrayList();
        this.h = parcel.readString();
        this.a = parcel.readLong();
        this.b = parcel.readLong();
        this.g = parcel.readLong();
        this.e = parcel.readLong();
        this.f = parcel.readLong();
        this.c = parcel.readLong();
        this.d = parcel.readLong();
        parcel.readTypedList(this.j, a.CREATOR);
    }

    /* synthetic */ c(Parcel parcel, byte by) {
        super(parcel);
    }

    public final void a() {
        this.h = "";
        this.a = 0L;
        this.b = 0L;
        this.g = 0L;
        this.k = 0L;
        this.l = 0L;
        this.c = 0L;
        this.j.clear();
    }

    public final void b() {
        long l2 = System.currentTimeMillis() - this.l;
        if (this.l == 0L) {
            this.e = 0L;
            this.f = 0L;
        }
        if (this.l > 0L && l2 > 0L) {
            long l3 = 1000L * ((this.b - this.k) / l2);
            if (l3 > 0L) {
                this.g = l3;
                this.f = 1000L * ((this.a - this.b) / this.g);
            }
            this.e = l2 + this.e;
        }
        this.k = this.b;
        this.l = System.currentTimeMillis();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.h);
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
        parcel.writeLong(this.g);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
        parcel.writeLong(this.c);
        parcel.writeLong(this.d);
        parcel.writeTypedList(this.j);
    }

    public static final class a
    implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>(){

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new a(parcel);
            }
        };
        public String a;
        public String b;

        public a() {
        }

        public a(Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.readString();
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            if (object instanceof a) {
                return TextUtils.equals((CharSequence)((a)object).a, (CharSequence)this.a);
            }
            return super.equals(object);
        }

        public final void writeToParcel(Parcel parcel, int n2) {
            parcel.writeString(this.a);
            parcel.writeString(this.b);
        }

    }

}

