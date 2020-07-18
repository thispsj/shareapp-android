/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.io.File
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.xiaomi.midrop.b;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

public class g
implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>(){

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new g(parcel);
        }
    };
    public long A;
    public boolean B;
    public String C;
    public String[] D;
    public int E;
    public boolean F;
    public int g;
    public String h;
    public String i;
    public String j;
    public String k;
    public long l;
    public int m;
    public int n;
    public long o;
    public long p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public long v;
    public long w;
    public String x;
    public String y;
    public int z;

    public g() {
        this.i = "";
        this.j = "";
        this.k = "";
        this.z = a.a;
        this.D = null;
        this.E = -1;
    }

    public g(int n) {
        this.i = "";
        this.j = "";
        this.k = "";
        this.z = a.a;
        this.D = null;
        this.E = -1;
        this.g = n;
    }

    public g(Parcel parcel) {
        this.i = "";
        this.j = "";
        this.k = "";
        this.z = a.a;
        this.D = null;
        this.E = -1;
        this.g = parcel.readInt();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readLong();
        this.m = parcel.readInt();
        this.n = parcel.readInt();
        this.o = parcel.readLong();
        this.p = parcel.readLong();
        this.u = parcel.readString();
        this.v = parcel.readLong();
        this.w = parcel.readLong();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.t = parcel.readString();
        this.z = a.a(parcel.readInt());
        this.A = parcel.readLong();
        boolean bl = parcel.readByte() == 0;
        this.B = bl;
        this.C = parcel.readString();
    }

    public static boolean a(g g2) {
        if (g2 == null) {
            return false;
        }
        return new File(g2.i).isDirectory();
    }

    public void a(int n) {
        if (n == 1 && this.m != 2) {
            this.m = 1;
            return;
        }
        this.m = n;
    }

    public boolean c() {
        return this.m == 3 || this.m == 4 || this.m == 5;
        {
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        return object instanceof g && this.i.equals((Object)((g)object).i);
    }

    public int hashCode() {
        return this.i.hashCode();
    }

    public String toString() {
        return this.i;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeLong(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        parcel.writeLong(this.o);
        parcel.writeLong(this.p);
        parcel.writeString(this.u);
        parcel.writeLong(this.v);
        parcel.writeLong(this.w);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.t);
        parcel.writeInt(-1 + this.z);
        parcel.writeLong(this.A);
        parcel.writeByte((byte)(true ^ this.B ? 1 : 0));
        parcel.writeString(this.C);
    }

    public static final class a
    extends Enum<a> {
        public static final int a = 1;
        public static final int b = 2;
        private static final /* synthetic */ int[] c;

        static {
            int[] arrn = new int[]{a, b};
            c = arrn;
        }

        public static int a(int n) {
            if (-1 + a == n) {
                return a;
            }
            if (-1 + b == n) {
                return b;
            }
            return a;
        }
    }

}

